package com.crashlytics.android.answers;

import io.fabric.sdk.android.Fabric;
import java.util.Map;

public abstract class AnswersEvent<T extends AnswersEvent> {
    final AnswersAttributes customAttributes = new AnswersAttributes(this.validator);
    final AnswersEventValidator validator = new AnswersEventValidator(20, 100, Fabric.isDebuggable());

    Map<String, Object> getCustomAttributes() {
        return this.customAttributes.attributes;
    }

    public T putCustomAttribute(String key, String value) {
        this.customAttributes.put(key, value);
        return this;
    }

    public T putCustomAttribute(String key, Number value) {
        this.customAttributes.put(key, value);
        return this;
    }
}
