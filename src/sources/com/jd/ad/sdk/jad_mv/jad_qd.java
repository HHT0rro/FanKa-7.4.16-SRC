package com.jd.ad.sdk.jad_mv;

import androidx.annotation.Nullable;
import java.util.Collections;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class jad_qd<K, A> extends jad_an<K, A> {
    public final A jad_iv;

    public jad_qd(com.jd.ad.sdk.jad_wf.jad_cp<A> jad_cpVar, @Nullable A a10) {
        super(Collections.emptyList());
        jad_an(jad_cpVar);
        this.jad_iv = a10;
    }

    @Override // com.jd.ad.sdk.jad_mv.jad_an
    public A jad_an(com.jd.ad.sdk.jad_wf.jad_an<K> jad_anVar, float f10) {
        return jad_fs();
    }

    @Override // com.jd.ad.sdk.jad_mv.jad_an
    public void jad_an(float f10) {
        this.jad_dq = f10;
    }

    @Override // com.jd.ad.sdk.jad_mv.jad_an
    public float jad_bo() {
        return 1.0f;
    }

    @Override // com.jd.ad.sdk.jad_mv.jad_an
    public A jad_fs() {
        com.jd.ad.sdk.jad_wf.jad_cp<A> jad_cpVar = this.jad_er;
        A a10 = this.jad_iv;
        float f10 = this.jad_dq;
        return jad_cpVar.jad_an(0.0f, 0.0f, a10, a10, f10, f10, f10);
    }

    @Override // com.jd.ad.sdk.jad_mv.jad_an
    public void jad_jt() {
        if (this.jad_er != null) {
            super.jad_jt();
        }
    }
}
