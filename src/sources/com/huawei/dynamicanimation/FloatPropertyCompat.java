package com.huawei.dynamicanimation;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class FloatPropertyCompat<T> {
    public final String mPropertyName;

    public FloatPropertyCompat(String str) {
        this.mPropertyName = str;
    }

    public abstract float getValue(T t2);

    public abstract void setValue(T t2, float f10);
}
