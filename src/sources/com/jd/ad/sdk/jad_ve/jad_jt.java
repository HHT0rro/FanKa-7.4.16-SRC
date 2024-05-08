package com.jd.ad.sdk.jad_ve;

import android.graphics.PointF;
import androidx.annotation.FloatRange;
import com.jd.ad.sdk.jad_lu.jad_kx;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class jad_jt {
    public static final PointF jad_an = new PointF();

    public static float jad_an(float f10, float f11, @FloatRange(from = 0.0d, to = 1.0d) float f12) {
        return ((f11 - f10) * f12) + f10;
    }

    public static int jad_an(float f10, float f11) {
        int i10 = (int) f10;
        int i11 = (int) f11;
        int i12 = i10 / i11;
        int i13 = i10 % i11;
        if (!((i10 ^ i11) >= 0) && i13 != 0) {
            i12--;
        }
        return i10 - (i11 * i12);
    }

    public static PointF jad_an(PointF pointF, PointF pointF2) {
        return new PointF(pointF.x + pointF2.x, pointF.y + pointF2.y);
    }

    public static void jad_an(com.jd.ad.sdk.jad_ox.jad_er jad_erVar, int i10, List<com.jd.ad.sdk.jad_ox.jad_er> list, com.jd.ad.sdk.jad_ox.jad_er jad_erVar2, jad_kx jad_kxVar) {
        if (jad_erVar.jad_an(jad_kxVar.jad_cp(), i10)) {
            list.add(jad_erVar2.jad_an(jad_kxVar.jad_cp()).jad_an(jad_kxVar));
        }
    }
}
