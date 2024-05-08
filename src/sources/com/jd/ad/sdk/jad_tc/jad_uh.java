package com.jd.ad.sdk.jad_tc;

import com.jd.ad.sdk.jad_ud.jad_cp;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class jad_uh {
    public static jad_cp.jad_an jad_an = jad_cp.jad_an.jad_an("k");

    public static <T> List<com.jd.ad.sdk.jad_wf.jad_an<T>> jad_an(com.jd.ad.sdk.jad_ud.jad_cp jad_cpVar, com.jd.ad.sdk.jad_js.jad_jt jad_jtVar, float f10, jad_mx<T> jad_mxVar, boolean z10) {
        ArrayList arrayList = new ArrayList();
        if (jad_cpVar.jad_mz() == 6) {
            jad_jtVar.jad_an("Lottie doesn't support expressions.");
            return arrayList;
        }
        jad_cpVar.jad_cp();
        while (jad_cpVar.jad_jt()) {
            if (jad_cpVar.jad_an(jad_an) != 0) {
                jad_cpVar.jad_ob();
            } else if (jad_cpVar.jad_mz() == 1) {
                jad_cpVar.jad_bo();
                if (jad_cpVar.jad_mz() == 7) {
                    arrayList.add(jad_tg.jad_an(jad_cpVar, jad_jtVar, f10, jad_mxVar, false, z10));
                } else {
                    while (jad_cpVar.jad_jt()) {
                        arrayList.add(jad_tg.jad_an(jad_cpVar, jad_jtVar, f10, jad_mxVar, true, z10));
                    }
                }
                jad_cpVar.jad_dq();
            } else {
                arrayList.add(jad_tg.jad_an(jad_cpVar, jad_jtVar, f10, jad_mxVar, false, z10));
            }
        }
        jad_cpVar.jad_er();
        jad_an(arrayList);
        return arrayList;
    }

    public static <T> void jad_an(List<? extends com.jd.ad.sdk.jad_wf.jad_an<T>> list) {
        int i10;
        T t2;
        int size = list.size();
        int i11 = 0;
        while (true) {
            i10 = size - 1;
            if (i11 >= i10) {
                break;
            }
            com.jd.ad.sdk.jad_wf.jad_an<T> jad_anVar = list.get(i11);
            i11++;
            com.jd.ad.sdk.jad_wf.jad_an<T> jad_anVar2 = list.get(i11);
            jad_anVar.jad_hu = Float.valueOf(jad_anVar2.jad_jt);
            if (jad_anVar.jad_cp == null && (t2 = jad_anVar2.jad_bo) != null) {
                jad_anVar.jad_cp = t2;
                if (jad_anVar instanceof com.jd.ad.sdk.jad_mv.jad_iv) {
                    ((com.jd.ad.sdk.jad_mv.jad_iv) jad_anVar).jad_dq();
                }
            }
        }
        com.jd.ad.sdk.jad_wf.jad_an<T> jad_anVar3 = list.get(i10);
        if ((jad_anVar3.jad_bo == null || jad_anVar3.jad_cp == null) && list.size() > 1) {
            list.remove(jad_anVar3);
        }
    }
}
