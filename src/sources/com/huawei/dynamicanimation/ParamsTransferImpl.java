package com.huawei.dynamicanimation;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class ParamsTransferImpl implements ParamTransfer<Float> {
    public float mVal;

    public ParamsTransferImpl(float f10) {
        this.mVal = f10;
    }

    public float getK() {
        return this.mVal;
    }

    public ParamsTransferImpl setK(float f10) {
        this.mVal = f10;
        return this;
    }

    @Override // com.huawei.dynamicanimation.ParamTransfer
    public Float transfer(Float f10, int i10) {
        if (i10 == 0) {
            return f10;
        }
        return Float.valueOf(f10.floatValue() * ((float) Math.pow(i10 + 1, (-this.mVal) * 1.0f)));
    }
}
