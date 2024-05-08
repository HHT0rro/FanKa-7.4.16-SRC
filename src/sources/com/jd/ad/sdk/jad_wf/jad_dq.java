package com.jd.ad.sdk.jad_wf;

import sun.util.locale.LanguageTag;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class jad_dq {
    public float jad_an;
    public float jad_bo;

    public jad_dq() {
        this(1.0f, 1.0f);
    }

    public jad_dq(float f10, float f11) {
        this.jad_an = f10;
        this.jad_bo = f11;
    }

    public String toString() {
        return this.jad_an + LanguageTag.PRIVATEUSE + this.jad_bo;
    }
}
