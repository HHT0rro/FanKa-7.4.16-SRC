package com.jd.ad.sdk.jad_tc;

import android.graphics.Color;
import android.graphics.PointF;
import androidx.annotation.ColorInt;
import com.jd.ad.sdk.jad_ud.jad_cp;
import java.util.ArrayList;
import java.util.List;
import sun.util.locale.LanguageTag;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class jad_sf {
    public static final jad_cp.jad_an jad_an = jad_cp.jad_an.jad_an(LanguageTag.PRIVATEUSE, "y");

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static /* synthetic */ class jad_an {
        public static final /* synthetic */ int[] jad_an;

        static {
            int[] iArr = new int[com.jd.ad.sdk.jad_jt.jad_fs.jad_bo(10).length];
            jad_an = iArr;
            try {
                iArr[6] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                jad_an[0] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                jad_an[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    @ColorInt
    public static int jad_an(com.jd.ad.sdk.jad_ud.jad_cp jad_cpVar) {
        jad_cpVar.jad_bo();
        int jad_iv = (int) (jad_cpVar.jad_iv() * 255.0d);
        int jad_iv2 = (int) (jad_cpVar.jad_iv() * 255.0d);
        int jad_iv3 = (int) (jad_cpVar.jad_iv() * 255.0d);
        while (jad_cpVar.jad_jt()) {
            jad_cpVar.jad_ob();
        }
        jad_cpVar.jad_dq();
        return Color.argb(255, jad_iv, jad_iv2, jad_iv3);
    }

    public static PointF jad_an(com.jd.ad.sdk.jad_ud.jad_cp jad_cpVar, float f10) {
        int i10 = jad_an.jad_an[com.jd.ad.sdk.jad_jt.jad_fs.jad_an(jad_cpVar.jad_mz())];
        if (i10 == 1) {
            float jad_iv = (float) jad_cpVar.jad_iv();
            float jad_iv2 = (float) jad_cpVar.jad_iv();
            while (jad_cpVar.jad_jt()) {
                jad_cpVar.jad_ob();
            }
            return new PointF(jad_iv * f10, jad_iv2 * f10);
        }
        if (i10 == 2) {
            jad_cpVar.jad_bo();
            float jad_iv3 = (float) jad_cpVar.jad_iv();
            float jad_iv4 = (float) jad_cpVar.jad_iv();
            while (jad_cpVar.jad_mz() != 2) {
                jad_cpVar.jad_ob();
            }
            jad_cpVar.jad_dq();
            return new PointF(jad_iv3 * f10, jad_iv4 * f10);
        }
        if (i10 == 3) {
            jad_cpVar.jad_cp();
            float f11 = 0.0f;
            float f12 = 0.0f;
            while (jad_cpVar.jad_jt()) {
                int jad_an2 = jad_cpVar.jad_an(jad_an);
                if (jad_an2 == 0) {
                    f12 = jad_bo(jad_cpVar);
                } else if (jad_an2 != 1) {
                    jad_cpVar.jad_na();
                    jad_cpVar.jad_ob();
                } else {
                    f11 = jad_bo(jad_cpVar);
                }
            }
            jad_cpVar.jad_er();
            return new PointF(f12 * f10, f11 * f10);
        }
        StringBuilder jad_an3 = com.jd.ad.sdk.jad_js.jad_zm.jad_an("Unknown point starts with ");
        jad_an3.append(com.jd.ad.sdk.jad_ud.jad_dq.jad_an(jad_cpVar.jad_mz()));
        throw new IllegalArgumentException(jad_an3.toString());
    }

    public static float jad_bo(com.jd.ad.sdk.jad_ud.jad_cp jad_cpVar) {
        int jad_mz = jad_cpVar.jad_mz();
        int i10 = jad_an.jad_an[com.jd.ad.sdk.jad_jt.jad_fs.jad_an(jad_mz)];
        if (i10 == 1) {
            return (float) jad_cpVar.jad_iv();
        }
        if (i10 != 2) {
            throw new IllegalArgumentException("Unknown value for token of type " + com.jd.ad.sdk.jad_ud.jad_dq.jad_an(jad_mz));
        }
        jad_cpVar.jad_bo();
        float jad_iv = (float) jad_cpVar.jad_iv();
        while (jad_cpVar.jad_jt()) {
            jad_cpVar.jad_ob();
        }
        jad_cpVar.jad_dq();
        return jad_iv;
    }

    public static List<PointF> jad_bo(com.jd.ad.sdk.jad_ud.jad_cp jad_cpVar, float f10) {
        ArrayList arrayList = new ArrayList();
        jad_cpVar.jad_bo();
        while (jad_cpVar.jad_mz() == 1) {
            jad_cpVar.jad_bo();
            arrayList.add(jad_an(jad_cpVar, f10));
            jad_cpVar.jad_dq();
        }
        jad_cpVar.jad_dq();
        return arrayList;
    }
}
