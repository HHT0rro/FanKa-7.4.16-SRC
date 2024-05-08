package com.jd.ad.sdk.jad_tc;

import android.graphics.PointF;
import com.jd.ad.sdk.jad_ud.jad_cp;
import com.kuaishou.weapon.p0.t;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class jad_gr implements jad_mx<com.jd.ad.sdk.jad_qz.jad_na> {
    public static final jad_gr jad_an = new jad_gr();
    public static final jad_cp.jad_an jad_bo = jad_cp.jad_an.jad_an("c", t.f36218c, t.f36220e, "o");

    @Override // com.jd.ad.sdk.jad_tc.jad_mx
    public com.jd.ad.sdk.jad_qz.jad_na jad_an(com.jd.ad.sdk.jad_ud.jad_cp jad_cpVar, float f10) {
        if (jad_cpVar.jad_mz() == 1) {
            jad_cpVar.jad_bo();
        }
        jad_cpVar.jad_cp();
        List<PointF> list = null;
        List<PointF> list2 = null;
        List<PointF> list3 = null;
        boolean z10 = false;
        while (jad_cpVar.jad_jt()) {
            int jad_an2 = jad_cpVar.jad_an(jad_bo);
            if (jad_an2 == 0) {
                z10 = jad_cpVar.jad_hu();
            } else if (jad_an2 == 1) {
                list = jad_sf.jad_bo(jad_cpVar, f10);
            } else if (jad_an2 == 2) {
                list2 = jad_sf.jad_bo(jad_cpVar, f10);
            } else if (jad_an2 != 3) {
                jad_cpVar.jad_na();
                jad_cpVar.jad_ob();
            } else {
                list3 = jad_sf.jad_bo(jad_cpVar, f10);
            }
        }
        jad_cpVar.jad_er();
        if (jad_cpVar.jad_mz() == 2) {
            jad_cpVar.jad_dq();
        }
        if (list == null || list2 == null || list3 == null) {
            throw new IllegalArgumentException("Shape data was missing information.");
        }
        if (list.isEmpty()) {
            return new com.jd.ad.sdk.jad_qz.jad_na(new PointF(), false, Collections.emptyList());
        }
        int size = list.size();
        PointF pointF = list.get(0);
        ArrayList arrayList = new ArrayList(size);
        for (int i10 = 1; i10 < size; i10++) {
            PointF pointF2 = list.get(i10);
            int i11 = i10 - 1;
            arrayList.add(new com.jd.ad.sdk.jad_ox.jad_an(com.jd.ad.sdk.jad_ve.jad_jt.jad_an(list.get(i11), list3.get(i11)), com.jd.ad.sdk.jad_ve.jad_jt.jad_an(pointF2, list2.get(i10)), pointF2));
        }
        if (z10) {
            PointF pointF3 = list.get(0);
            int i12 = size - 1;
            arrayList.add(new com.jd.ad.sdk.jad_ox.jad_an(com.jd.ad.sdk.jad_ve.jad_jt.jad_an(list.get(i12), list3.get(i12)), com.jd.ad.sdk.jad_ve.jad_jt.jad_an(pointF3, list2.get(0)), pointF3));
        }
        return new com.jd.ad.sdk.jad_qz.jad_na(pointF, z10, arrayList);
    }
}
