package com.jd.ad.sdk.jad_mv;

import android.graphics.PointF;
import androidx.annotation.Nullable;
import java.util.Collections;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class jad_na extends jad_an<PointF, PointF> {
    public final PointF jad_iv;
    public final PointF jad_jw;
    public final jad_an<Float, Float> jad_kx;
    public final jad_an<Float, Float> jad_ly;

    @Nullable
    public com.jd.ad.sdk.jad_wf.jad_cp<Float> jad_mz;

    @Nullable
    public com.jd.ad.sdk.jad_wf.jad_cp<Float> jad_na;

    public jad_na(jad_an<Float, Float> jad_anVar, jad_an<Float, Float> jad_anVar2) {
        super(Collections.emptyList());
        this.jad_iv = new PointF();
        this.jad_jw = new PointF();
        this.jad_kx = jad_anVar;
        this.jad_ly = jad_anVar2;
        jad_an(jad_er());
    }

    @Override // com.jd.ad.sdk.jad_mv.jad_an
    public void jad_an(float f10) {
        this.jad_kx.jad_an(f10);
        this.jad_ly.jad_an(f10);
        this.jad_iv.set(this.jad_kx.jad_fs().floatValue(), this.jad_ly.jad_fs().floatValue());
        for (int i10 = 0; i10 < this.jad_an.size(); i10++) {
            this.jad_an.get(i10).jad_an();
        }
    }

    @Override // com.jd.ad.sdk.jad_mv.jad_an
    /* renamed from: jad_bo, reason: merged with bridge method [inline-methods] */
    public PointF jad_an(com.jd.ad.sdk.jad_wf.jad_an<PointF> jad_anVar, float f10) {
        Float f11;
        com.jd.ad.sdk.jad_wf.jad_an<Float> jad_an;
        com.jd.ad.sdk.jad_wf.jad_an<Float> jad_an2;
        Float f12 = null;
        if (this.jad_mz == null || (jad_an2 = this.jad_kx.jad_an()) == null) {
            f11 = null;
        } else {
            float jad_cp = this.jad_kx.jad_cp();
            Float f13 = jad_an2.jad_hu;
            com.jd.ad.sdk.jad_wf.jad_cp<Float> jad_cpVar = this.jad_mz;
            float f14 = jad_an2.jad_jt;
            f11 = jad_cpVar.jad_an(f14, f13 == null ? f14 : f13.floatValue(), jad_an2.jad_bo, jad_an2.jad_cp, f10, f10, jad_cp);
        }
        if (this.jad_na != null && (jad_an = this.jad_ly.jad_an()) != null) {
            float jad_cp2 = this.jad_ly.jad_cp();
            Float f15 = jad_an.jad_hu;
            com.jd.ad.sdk.jad_wf.jad_cp<Float> jad_cpVar2 = this.jad_na;
            float f16 = jad_an.jad_jt;
            f12 = jad_cpVar2.jad_an(f16, f15 == null ? f16 : f15.floatValue(), jad_an.jad_bo, jad_an.jad_cp, f10, f10, jad_cp2);
        }
        if (f11 == null) {
            this.jad_jw.set(this.jad_iv.x, 0.0f);
        } else {
            this.jad_jw.set(f11.floatValue(), 0.0f);
        }
        PointF pointF = this.jad_jw;
        pointF.set(pointF.x, f12 == null ? this.jad_iv.y : f12.floatValue());
        return this.jad_jw;
    }

    @Override // com.jd.ad.sdk.jad_mv.jad_an
    public PointF jad_fs() {
        return jad_an(null, 0.0f);
    }
}
