package com.alicom.tools.serialization;

import android.text.TextUtils;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
class JSONField {
    private boolean isExcluded;
    private String keyName;
    private Class valueType;

    public JSONField(Field field) {
        Annotation annotation = field.getAnnotation(JSONerTag.class);
        if (annotation != null) {
            JSONerTag jSONerTag = (JSONerTag) annotation;
            this.keyName = jSONerTag.keyName();
            this.isExcluded = jSONerTag.isExcluded();
        }
        if (TextUtils.isEmpty(this.keyName)) {
            this.keyName = field.getName();
        }
        this.valueType = field.getType();
    }

    public String getKeyName() {
        return this.keyName;
    }

    public Class getValueType() {
        return this.valueType;
    }

    public boolean isExcluded() {
        return this.isExcluded;
    }

    public boolean isOriginalBoolean(Class cls) {
        return Boolean.TYPE.equals(cls) || Boolean.class.equals(cls) || boolean[].class.equals(cls) || Boolean[].class.equals(cls);
    }

    public boolean isOriginalChar(Class cls) {
        return Byte.TYPE.equals(cls) || Byte.class.equals(cls) || byte[].class.equals(cls) || Byte[].class.equals(cls) || Character.TYPE.equals(cls) || Character.class.equals(cls) || char[].class.equals(cls) || Character[].class.equals(cls);
    }

    public boolean isOriginalNumber(Class cls) {
        return Integer.TYPE.equals(cls) || Integer.class.equals(cls) || int[].class.equals(cls) || Integer[].class.equals(cls) || Short.TYPE.equals(cls) || Short.class.equals(cls) || short[].class.equals(cls) || Short[].class.equals(cls) || Long.TYPE.equals(cls) || Long.class.equals(cls) || long[].class.equals(cls) || Long[].class.equals(cls) || Float.TYPE.equals(cls) || Float.class.equals(cls) || float[].class.equals(cls) || Float[].class.equals(cls) || Double.TYPE.equals(cls) || Double.class.equals(cls) || double[].class.equals(cls) || Double[].class.equals(cls);
    }

    public boolean isOriginalString(Class cls) {
        return String.class.equals(cls) || StringBuilder.class.equals(cls) || String[].class.equals(cls) || StringBuilder[].class.equals(cls) || StringBuffer.class.equals(cls) || CharSequence.class.equals(cls) || StringBuffer[].class.equals(cls) || CharSequence[].class.equals(cls);
    }

    public boolean isOriginalType() {
        return isOriginalBoolean(this.valueType) || isOriginalChar(this.valueType) || isOriginalNumber(this.valueType) || isOriginalString(this.valueType);
    }
}
