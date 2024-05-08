package com.huawei.flexiblelayout.css.adapter.value.integrate.dimensions;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class Dimens {
    public float mDimens;
    private String mUnit;

    public float getDimens() {
        if (isValid()) {
            return this.mDimens;
        }
        throw new IllegalArgumentException(((Object) this) + ", getDimens dimens is not valid");
    }

    public String getUnit() {
        return this.mUnit;
    }

    public abstract boolean isValid();

    public void setDimens(float f10) {
        this.mDimens = f10;
    }

    public void setUnit(String str) {
        this.mUnit = str;
    }
}
