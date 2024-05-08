package com.jd.ad.sdk.jad_tc;

import com.jd.ad.sdk.jad_ud.jad_cp;
import com.kuaishou.weapon.p0.t;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class jad_iv implements jad_mx<com.jd.ad.sdk.jad_ox.jad_bo> {
    public static final jad_iv jad_an = new jad_iv();
    public static final jad_cp.jad_an jad_bo = jad_cp.jad_an.jad_an("t", "f", t.f36222g, "j", "tr", "lh", "ls", "fc", "sc", "sw", "of");

    @Override // com.jd.ad.sdk.jad_tc.jad_mx
    public com.jd.ad.sdk.jad_ox.jad_bo jad_an(com.jd.ad.sdk.jad_ud.jad_cp jad_cpVar, float f10) {
        jad_cpVar.jad_cp();
        String str = null;
        String str2 = null;
        float f11 = 0.0f;
        int i10 = 3;
        int i11 = 0;
        float f12 = 0.0f;
        float f13 = 0.0f;
        int i12 = 0;
        int i13 = 0;
        float f14 = 0.0f;
        boolean z10 = true;
        while (jad_cpVar.jad_jt()) {
            switch (jad_cpVar.jad_an(jad_bo)) {
                case 0:
                    str = jad_cpVar.jad_ly();
                    break;
                case 1:
                    str2 = jad_cpVar.jad_ly();
                    break;
                case 2:
                    f11 = (float) jad_cpVar.jad_iv();
                    break;
                case 3:
                    int jad_jw = jad_cpVar.jad_jw();
                    if (jad_jw <= 2 && jad_jw >= 0) {
                        i10 = com.jd.ad.sdk.jad_jt.jad_fs.jad_bo(3)[jad_jw];
                        break;
                    } else {
                        i10 = 3;
                        break;
                    }
                case 4:
                    i11 = jad_cpVar.jad_jw();
                    break;
                case 5:
                    f12 = (float) jad_cpVar.jad_iv();
                    break;
                case 6:
                    f13 = (float) jad_cpVar.jad_iv();
                    break;
                case 7:
                    i12 = jad_sf.jad_an(jad_cpVar);
                    break;
                case 8:
                    i13 = jad_sf.jad_an(jad_cpVar);
                    break;
                case 9:
                    f14 = (float) jad_cpVar.jad_iv();
                    break;
                case 10:
                    z10 = jad_cpVar.jad_hu();
                    break;
                default:
                    jad_cpVar.jad_na();
                    jad_cpVar.jad_ob();
                    break;
            }
        }
        jad_cpVar.jad_er();
        return new com.jd.ad.sdk.jad_ox.jad_bo(str, str2, f11, i10, i11, f12, f13, i12, i13, f14, z10);
    }
}
