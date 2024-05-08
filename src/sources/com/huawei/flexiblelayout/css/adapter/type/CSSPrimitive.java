package com.huawei.flexiblelayout.css.adapter.type;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class CSSPrimitive extends CSSValue {
    private String value;

    public CSSPrimitive(String str) {
        this.value = str;
    }

    public Boolean asBool() {
        try {
            return Boolean.valueOf(Boolean.parseBoolean(this.value));
        } catch (Exception unused) {
            return null;
        }
    }

    public Float asFloat() {
        try {
            return Float.valueOf(Float.parseFloat(this.value));
        } catch (Exception unused) {
            return null;
        }
    }

    public Integer asInt() {
        try {
            return Integer.valueOf(Integer.parseInt(this.value));
        } catch (Exception unused) {
            return null;
        }
    }

    public String asString() {
        return this.value;
    }
}
