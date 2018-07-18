package com.fasterxml.jackson.databind.jsontype.impl;

import com.fasterxml.jackson.databind.DatabindContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.jsontype.TypeIdResolver;
import com.fasterxml.jackson.databind.type.TypeFactory;

public abstract class TypeIdResolverBase implements TypeIdResolver {
    protected final JavaType _baseType;
    protected final TypeFactory _typeFactory;

    @Deprecated
    public abstract JavaType typeFromId(String str);

    protected TypeIdResolverBase() {
        this(null, null);
    }

    protected TypeIdResolverBase(JavaType baseType, TypeFactory typeFactory) {
        this._baseType = baseType;
        this._typeFactory = typeFactory;
    }

    public void init(JavaType bt) {
    }

    public String idFromBaseType() {
        return idFromValueAndType(null, this._baseType.getRawClass());
    }

    public JavaType typeFromId(DatabindContext context, String id) {
        return typeFromId(id);
    }
}
