package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Currency;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Pattern;

public abstract class FromStringDeserializer<T> extends StdScalarDeserializer<T> {

    public static class Std extends FromStringDeserializer<Object> {
        protected final int _kind;

        protected Std(Class<?> valueType, int kind) {
            super(valueType);
            this._kind = kind;
        }

        protected Object _deserialize(String value, DeserializationContext ctxt) throws IOException {
            int ix;
            switch (this._kind) {
                case 1:
                    return new File(value);
                case 2:
                    return new URL(value);
                case 3:
                    return URI.create(value);
                case 4:
                    try {
                        return ctxt.findClass(value);
                    } catch (Exception e) {
                        throw ctxt.instantiationException(this._valueClass, ClassUtil.getRootCause(e));
                    }
                case 5:
                    return ctxt.getTypeFactory().constructFromCanonical(value);
                case 6:
                    return Currency.getInstance(value);
                case 7:
                    return Pattern.compile(value);
                case 8:
                    ix = value.indexOf(95);
                    if (ix < 0) {
                        return new Locale(value);
                    }
                    String first = value.substring(0, ix);
                    value = value.substring(ix + 1);
                    ix = value.indexOf(95);
                    if (ix < 0) {
                        return new Locale(first, value);
                    }
                    return new Locale(first, value.substring(0, ix), value.substring(ix + 1));
                case 9:
                    return Charset.forName(value);
                case 10:
                    return TimeZone.getTimeZone(value);
                case 11:
                    return InetAddress.getByName(value);
                case 12:
                    if (value.startsWith("[")) {
                        int i = value.lastIndexOf(93);
                        if (i == -1) {
                            throw new InvalidFormatException("Bracketed IPv6 address must contain closing bracket", value, InetSocketAddress.class);
                        }
                        int port;
                        int j = value.indexOf(58, i);
                        if (j > -1) {
                            port = Integer.parseInt(value.substring(j + 1));
                        } else {
                            port = 0;
                        }
                        return new InetSocketAddress(value.substring(0, i + 1), port);
                    }
                    ix = value.indexOf(58);
                    if (ix < 0 || value.indexOf(58, ix + 1) >= 0) {
                        return new InetSocketAddress(value, 0);
                    }
                    return new InetSocketAddress(value.substring(0, ix), Integer.parseInt(value.substring(ix + 1)));
                default:
                    throw new IllegalArgumentException();
            }
        }

        protected Object _deserializeFromEmptyString() throws IOException {
            if (this._kind == 3) {
                return URI.create("");
            }
            return super._deserializeFromEmptyString();
        }
    }

    protected abstract T _deserialize(String str, DeserializationContext deserializationContext) throws IOException;

    public static Class<?>[] types() {
        return new Class[]{File.class, URL.class, URI.class, Class.class, JavaType.class, Currency.class, Pattern.class, Locale.class, Charset.class, TimeZone.class, InetAddress.class, InetSocketAddress.class};
    }

    protected FromStringDeserializer(Class<?> vc) {
        super(vc);
    }

    public static Std findDeserializer(Class<?> rawType) {
        int kind;
        if (rawType == File.class) {
            kind = 1;
        } else if (rawType == URL.class) {
            kind = 2;
        } else if (rawType == URI.class) {
            kind = 3;
        } else if (rawType == Class.class) {
            kind = 4;
        } else if (rawType == JavaType.class) {
            kind = 5;
        } else if (rawType == Currency.class) {
            kind = 6;
        } else if (rawType == Pattern.class) {
            kind = 7;
        } else if (rawType == Locale.class) {
            kind = 8;
        } else if (rawType == Charset.class) {
            kind = 9;
        } else if (rawType == TimeZone.class) {
            kind = 10;
        } else if (rawType == InetAddress.class) {
            kind = 11;
        } else if (rawType != InetSocketAddress.class) {
            return null;
        } else {
            kind = 12;
        }
        return new Std(rawType, kind);
    }

    public T deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        if (jp.getCurrentToken() == JsonToken.START_ARRAY && ctxt.isEnabled(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS)) {
            jp.nextToken();
            T deserialize = deserialize(jp, ctxt);
            if (jp.nextToken() == JsonToken.END_ARRAY) {
                return deserialize;
            }
            throw ctxt.wrongTokenException(jp, JsonToken.END_ARRAY, "Attempted to unwrap single value array for single '" + this._valueClass.getName() + "' value but there was more than a single value in the array");
        }
        String text = jp.getValueAsString();
        if (text != null) {
            if (text.length() != 0) {
                text = text.trim();
                if (text.length() != 0) {
                    Exception cause = null;
                    try {
                        T result = _deserialize(text, ctxt);
                        if (result != null) {
                            return result;
                        }
                    } catch (Exception iae) {
                        cause = iae;
                    }
                    String msg = "not a valid textual representation";
                    if (cause != null) {
                        msg = msg + "problem: " + cause.getMessage();
                    }
                    JsonMappingException e = ctxt.weirdStringException(text, this._valueClass, msg);
                    if (cause != null) {
                        e.initCause(cause);
                    }
                    throw e;
                }
            }
            return _deserializeFromEmptyString();
        } else if (jp.getCurrentToken() == JsonToken.VALUE_EMBEDDED_OBJECT) {
            T ob = jp.getEmbeddedObject();
            if (ob == null) {
                return null;
            }
            if (this._valueClass.isAssignableFrom(ob.getClass())) {
                return ob;
            }
            return _deserializeEmbedded(ob, ctxt);
        } else {
            throw ctxt.mappingException(this._valueClass);
        }
    }

    protected T _deserializeEmbedded(Object ob, DeserializationContext ctxt) throws IOException {
        throw ctxt.mappingException("Don't know how to convert embedded Object of type " + ob.getClass().getName() + " into " + this._valueClass.getName());
    }

    protected T _deserializeFromEmptyString() throws IOException {
        return null;
    }
}
