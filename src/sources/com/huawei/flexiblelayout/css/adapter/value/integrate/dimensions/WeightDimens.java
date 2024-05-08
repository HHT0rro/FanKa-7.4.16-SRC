package com.huawei.flexiblelayout.css.adapter.value.integrate.dimensions;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class WeightDimens extends Dimens {
    private static final float INVALID_VAL = -1.0f;
    private static final float WEIGHT_TAG = 1.0f;

    public WeightDimens() {
        this.mDimens = -1.0f;
    }

    @Override // com.huawei.flexiblelayout.css.adapter.value.integrate.dimensions.Dimens
    public boolean isValid() {
        float f10 = this.mDimens;
        return f10 != -1.0f && f10 <= 1.0f && f10 >= 0.0f;
    }
}
