package com.jd.ad.sdk.jad_mv;

import android.graphics.PointF;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class jad_kx extends jad_jt<PointF> {
    public final PointF jad_iv;

    public jad_kx(List<com.jd.ad.sdk.jad_wf.jad_an<PointF>> list) {
        super(list);
        this.jad_iv = new PointF();
    }

    @Override // com.jd.ad.sdk.jad_mv.jad_an
    public Object jad_an(com.jd.ad.sdk.jad_wf.jad_an jad_anVar, float f10) {
        return jad_an(jad_anVar, f10, f10, f10);
    }

    @Override // com.jd.ad.sdk.jad_mv.jad_an
    /* renamed from: jad_bo, reason: merged with bridge method [inline-methods] */
    public PointF jad_an(com.jd.ad.sdk.jad_wf.jad_an<PointF> jad_anVar, float f10, float f11, float f12) {
        PointF pointF;
        PointF pointF2;
        PointF pointF3 = jad_anVar.jad_bo;
        if (pointF3 == null || (pointF = jad_anVar.jad_cp) == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        PointF pointF4 = pointF3;
        PointF pointF5 = pointF;
        com.jd.ad.sdk.jad_wf.jad_cp<A> jad_cpVar = this.jad_er;
        if (jad_cpVar != 0 && (pointF2 = (PointF) jad_cpVar.jad_an(jad_anVar.jad_jt, jad_anVar.jad_hu.floatValue(), pointF4, pointF5, f10, jad_dq(), this.jad_dq)) != null) {
            return pointF2;
        }
        PointF pointF6 = this.jad_iv;
        float f13 = pointF4.x;
        float f14 = ((pointF5.x - f13) * f11) + f13;
        float f15 = pointF4.y;
        pointF6.set(f14, ((pointF5.y - f15) * f12) + f15);
        return this.jad_iv;
    }
}
