package com.huawei.flexiblelayout.css.adapter.value.integrate.dimensions;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class FixedDimens extends Dimens {
    private static final float INVALID_VAL = -10.0f;
    private static final float MATCH_PARENT = -1.0f;
    private static final float WRAP_CONTENT = -2.0f;

    public FixedDimens() {
        this.mDimens = INVALID_VAL;
    }

    @Override // com.huawei.flexiblelayout.css.adapter.value.integrate.dimensions.Dimens
    public boolean isValid() {
        float f10 = this.mDimens;
        return f10 != INVALID_VAL && (f10 >= 0.0f || f10 == -1.0f || f10 == WRAP_CONTENT);
    }
}
