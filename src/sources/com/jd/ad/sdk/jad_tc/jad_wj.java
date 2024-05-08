package com.jd.ad.sdk.jad_tc;

import android.graphics.Rect;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.huawei.quickcard.framework.QuickCardField;
import com.jd.ad.sdk.jad_ud.jad_cp;
import com.kuaishou.weapon.p0.t;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class jad_wj {
    public static final jad_cp.jad_an jad_an = jad_cp.jad_an.jad_an(IAdInterListener.AdReqParam.WIDTH, "h", "ip", "op", "fr", t.f36218c, "layers", QuickCardField.ASSETS, "fonts", "chars", "markers");
    public static jad_cp.jad_an jad_bo = jad_cp.jad_an.jad_an("id", "layers", IAdInterListener.AdReqParam.WIDTH, "h", t.f36217b, t.f36224i);
    public static final jad_cp.jad_an jad_cp = jad_cp.jad_an.jad_an("list");
    public static final jad_cp.jad_an jad_dq = jad_cp.jad_an.jad_an("cm", "tm", "dr");

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0046. Please report as an issue. */
    public static com.jd.ad.sdk.jad_js.jad_jt jad_an(com.jd.ad.sdk.jad_ud.jad_cp jad_cpVar) {
        ArrayList arrayList;
        SparseArrayCompat<com.jd.ad.sdk.jad_ox.jad_dq> sparseArrayCompat;
        ArrayList arrayList2;
        float f10;
        float f11;
        ArrayList arrayList3;
        float jad_an2 = com.jd.ad.sdk.jad_ve.jad_hu.jad_an();
        LongSparseArray<com.jd.ad.sdk.jad_ra.jad_er> longSparseArray = new LongSparseArray<>();
        ArrayList arrayList4 = new ArrayList();
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        ArrayList arrayList5 = new ArrayList();
        SparseArrayCompat<com.jd.ad.sdk.jad_ox.jad_dq> sparseArrayCompat2 = new SparseArrayCompat<>();
        com.jd.ad.sdk.jad_js.jad_jt jad_jtVar = new com.jd.ad.sdk.jad_js.jad_jt();
        jad_cpVar.jad_cp();
        int i10 = 0;
        float f12 = 0.0f;
        float f13 = 0.0f;
        float f14 = 0.0f;
        int i11 = 0;
        while (jad_cpVar.jad_jt()) {
            float f15 = f12;
            switch (jad_cpVar.jad_an(jad_an)) {
                case 0:
                    i10 = jad_cpVar.jad_jw();
                    f12 = f15;
                    break;
                case 1:
                    i11 = jad_cpVar.jad_jw();
                    f12 = f15;
                    break;
                case 2:
                    arrayList = arrayList5;
                    sparseArrayCompat = sparseArrayCompat2;
                    f14 = (float) jad_cpVar.jad_iv();
                    f12 = f15;
                    arrayList5 = arrayList;
                    sparseArrayCompat2 = sparseArrayCompat;
                    break;
                case 3:
                    arrayList = arrayList5;
                    sparseArrayCompat = sparseArrayCompat2;
                    f13 = ((float) jad_cpVar.jad_iv()) - 0.01f;
                    f12 = f15;
                    arrayList5 = arrayList;
                    sparseArrayCompat2 = sparseArrayCompat;
                    break;
                case 4:
                    arrayList = arrayList5;
                    sparseArrayCompat = sparseArrayCompat2;
                    f12 = (float) jad_cpVar.jad_iv();
                    arrayList5 = arrayList;
                    sparseArrayCompat2 = sparseArrayCompat;
                    break;
                case 5:
                    arrayList2 = arrayList5;
                    sparseArrayCompat = sparseArrayCompat2;
                    f10 = f13;
                    f11 = f14;
                    String[] split = jad_cpVar.jad_ly().split("\\.");
                    int parseInt = Integer.parseInt(split[0]);
                    int parseInt2 = Integer.parseInt(split[1]);
                    if (!(parseInt >= 4 && (parseInt > 4 || (parseInt2 >= 4 && (parseInt2 > 4 || Integer.parseInt(split[2]) >= 0))))) {
                        jad_jtVar.jad_an("Lottie only supports bodymovin >= 4.4.0");
                    }
                    f12 = f15;
                    f14 = f11;
                    arrayList5 = arrayList2;
                    f13 = f10;
                    sparseArrayCompat2 = sparseArrayCompat;
                    break;
                case 6:
                    arrayList2 = arrayList5;
                    sparseArrayCompat = sparseArrayCompat2;
                    f10 = f13;
                    f11 = f14;
                    jad_cpVar.jad_bo();
                    int i12 = 0;
                    while (jad_cpVar.jad_jt()) {
                        com.jd.ad.sdk.jad_ra.jad_er jad_an3 = jad_vi.jad_an(jad_cpVar, jad_jtVar);
                        if (jad_an3.jad_er == 3) {
                            i12++;
                        }
                        arrayList4.add(jad_an3);
                        longSparseArray.put(jad_an3.jad_dq, jad_an3);
                        if (i12 > 4) {
                            com.jd.ad.sdk.jad_ve.jad_dq.jad_an("You have " + i12 + " images. Lottie should primarily be used with shapes. If you are using Adobe Illustrator, convert the Illustrator layers to shape layers.");
                        }
                    }
                    jad_cpVar.jad_dq();
                    f12 = f15;
                    f14 = f11;
                    arrayList5 = arrayList2;
                    f13 = f10;
                    sparseArrayCompat2 = sparseArrayCompat;
                    break;
                case 7:
                    arrayList2 = arrayList5;
                    sparseArrayCompat = sparseArrayCompat2;
                    f10 = f13;
                    f11 = f14;
                    jad_cpVar.jad_bo();
                    while (jad_cpVar.jad_jt()) {
                        ArrayList arrayList6 = new ArrayList();
                        LongSparseArray longSparseArray2 = new LongSparseArray();
                        jad_cpVar.jad_cp();
                        String str = null;
                        String str2 = null;
                        String str3 = null;
                        int i13 = 0;
                        int i14 = 0;
                        while (jad_cpVar.jad_jt()) {
                            int jad_an4 = jad_cpVar.jad_an(jad_bo);
                            if (jad_an4 == 0) {
                                str = jad_cpVar.jad_ly();
                            } else if (jad_an4 == 1) {
                                jad_cpVar.jad_bo();
                                while (jad_cpVar.jad_jt()) {
                                    com.jd.ad.sdk.jad_ra.jad_er jad_an5 = jad_vi.jad_an(jad_cpVar, jad_jtVar);
                                    longSparseArray2.put(jad_an5.jad_dq, jad_an5);
                                    arrayList6.add(jad_an5);
                                }
                                jad_cpVar.jad_dq();
                            } else if (jad_an4 == 2) {
                                i13 = jad_cpVar.jad_jw();
                            } else if (jad_an4 == 3) {
                                i14 = jad_cpVar.jad_jw();
                            } else if (jad_an4 == 4) {
                                str2 = jad_cpVar.jad_ly();
                            } else if (jad_an4 != 5) {
                                jad_cpVar.jad_na();
                                jad_cpVar.jad_ob();
                            } else {
                                str3 = jad_cpVar.jad_ly();
                            }
                        }
                        jad_cpVar.jad_er();
                        if (str2 != null) {
                            hashMap2.put(str, new com.jd.ad.sdk.jad_js.jad_na(i13, i14, str, str2, str3));
                        } else {
                            hashMap.put(str, arrayList6);
                        }
                    }
                    jad_cpVar.jad_dq();
                    f12 = f15;
                    f14 = f11;
                    arrayList5 = arrayList2;
                    f13 = f10;
                    sparseArrayCompat2 = sparseArrayCompat;
                    break;
                case 8:
                    f10 = f13;
                    f11 = f14;
                    jad_cpVar.jad_cp();
                    while (jad_cpVar.jad_jt()) {
                        if (jad_cpVar.jad_an(jad_cp) != 0) {
                            jad_cpVar.jad_na();
                            jad_cpVar.jad_ob();
                        } else {
                            jad_cpVar.jad_bo();
                            while (jad_cpVar.jad_jt()) {
                                jad_cp.jad_an jad_anVar = jad_na.jad_an;
                                jad_cpVar.jad_cp();
                                String str4 = null;
                                String str5 = null;
                                String str6 = null;
                                float f16 = 0.0f;
                                while (true) {
                                    arrayList3 = arrayList5;
                                    if (jad_cpVar.jad_jt()) {
                                        int jad_an6 = jad_cpVar.jad_an(jad_na.jad_an);
                                        SparseArrayCompat<com.jd.ad.sdk.jad_ox.jad_dq> sparseArrayCompat3 = sparseArrayCompat2;
                                        if (jad_an6 != 0) {
                                            if (jad_an6 == 1) {
                                                str5 = jad_cpVar.jad_ly();
                                            } else if (jad_an6 == 2) {
                                                str6 = jad_cpVar.jad_ly();
                                            } else if (jad_an6 != 3) {
                                                jad_cpVar.jad_na();
                                                jad_cpVar.jad_ob();
                                            } else {
                                                f16 = (float) jad_cpVar.jad_iv();
                                            }
                                            arrayList5 = arrayList3;
                                            sparseArrayCompat2 = sparseArrayCompat3;
                                        } else {
                                            str4 = jad_cpVar.jad_ly();
                                            arrayList5 = arrayList3;
                                        }
                                    }
                                }
                                jad_cpVar.jad_er();
                                hashMap3.put(str5, new com.jd.ad.sdk.jad_ox.jad_cp(str4, str5, str6, f16));
                                arrayList5 = arrayList3;
                            }
                            jad_cpVar.jad_dq();
                        }
                    }
                    arrayList2 = arrayList5;
                    sparseArrayCompat = sparseArrayCompat2;
                    jad_cpVar.jad_er();
                    f12 = f15;
                    f14 = f11;
                    arrayList5 = arrayList2;
                    f13 = f10;
                    sparseArrayCompat2 = sparseArrayCompat;
                    break;
                case 9:
                    f10 = f13;
                    f11 = f14;
                    jad_cpVar.jad_bo();
                    while (jad_cpVar.jad_jt()) {
                        jad_cp.jad_an jad_anVar2 = jad_mz.jad_an;
                        ArrayList arrayList7 = new ArrayList();
                        jad_cpVar.jad_cp();
                        double d10 = 0.0d;
                        double d11 = 0.0d;
                        String str7 = null;
                        String str8 = null;
                        char c4 = 0;
                        while (jad_cpVar.jad_jt()) {
                            int jad_an7 = jad_cpVar.jad_an(jad_mz.jad_an);
                            if (jad_an7 == 0) {
                                c4 = jad_cpVar.jad_ly().charAt(0);
                            } else if (jad_an7 == 1) {
                                d10 = jad_cpVar.jad_iv();
                            } else if (jad_an7 == 2) {
                                d11 = jad_cpVar.jad_iv();
                            } else if (jad_an7 == 3) {
                                str7 = jad_cpVar.jad_ly();
                            } else if (jad_an7 == 4) {
                                str8 = jad_cpVar.jad_ly();
                            } else if (jad_an7 != 5) {
                                jad_cpVar.jad_na();
                                jad_cpVar.jad_ob();
                            } else {
                                jad_cpVar.jad_cp();
                                while (jad_cpVar.jad_jt()) {
                                    if (jad_cpVar.jad_an(jad_mz.jad_bo) != 0) {
                                        jad_cpVar.jad_na();
                                        jad_cpVar.jad_ob();
                                    } else {
                                        jad_cpVar.jad_bo();
                                        while (jad_cpVar.jad_jt()) {
                                            arrayList7.add((com.jd.ad.sdk.jad_qz.jad_pc) jad_hu.jad_an(jad_cpVar, jad_jtVar));
                                        }
                                        jad_cpVar.jad_dq();
                                    }
                                }
                                jad_cpVar.jad_er();
                            }
                        }
                        jad_cpVar.jad_er();
                        com.jd.ad.sdk.jad_ox.jad_dq jad_dqVar = new com.jd.ad.sdk.jad_ox.jad_dq(arrayList7, c4, d10, d11, str7, str8);
                        sparseArrayCompat2.put(jad_dqVar.hashCode(), jad_dqVar);
                    }
                    jad_cpVar.jad_dq();
                    arrayList2 = arrayList5;
                    sparseArrayCompat = sparseArrayCompat2;
                    f12 = f15;
                    f14 = f11;
                    arrayList5 = arrayList2;
                    f13 = f10;
                    sparseArrayCompat2 = sparseArrayCompat;
                    break;
                case 10:
                    jad_cpVar.jad_bo();
                    while (jad_cpVar.jad_jt()) {
                        jad_cpVar.jad_cp();
                        String str9 = null;
                        float f17 = 0.0f;
                        float f18 = 0.0f;
                        while (jad_cpVar.jad_jt()) {
                            int jad_an8 = jad_cpVar.jad_an(jad_dq);
                            float f19 = f13;
                            if (jad_an8 != 0) {
                                if (jad_an8 == 1) {
                                    f17 = (float) jad_cpVar.jad_iv();
                                } else if (jad_an8 != 2) {
                                    jad_cpVar.jad_na();
                                    jad_cpVar.jad_ob();
                                } else {
                                    f18 = (float) jad_cpVar.jad_iv();
                                }
                                f13 = f19;
                            } else {
                                str9 = jad_cpVar.jad_ly();
                            }
                        }
                        jad_cpVar.jad_er();
                        arrayList5.add(new com.jd.ad.sdk.jad_ox.jad_hu(str9, f17, f18));
                        f14 = f14;
                        f13 = f13;
                    }
                    f10 = f13;
                    f11 = f14;
                    jad_cpVar.jad_dq();
                    arrayList2 = arrayList5;
                    sparseArrayCompat = sparseArrayCompat2;
                    f12 = f15;
                    f14 = f11;
                    arrayList5 = arrayList2;
                    f13 = f10;
                    sparseArrayCompat2 = sparseArrayCompat;
                    break;
                default:
                    arrayList2 = arrayList5;
                    sparseArrayCompat = sparseArrayCompat2;
                    f10 = f13;
                    f11 = f14;
                    jad_cpVar.jad_na();
                    jad_cpVar.jad_ob();
                    f12 = f15;
                    f14 = f11;
                    arrayList5 = arrayList2;
                    f13 = f10;
                    sparseArrayCompat2 = sparseArrayCompat;
                    break;
            }
        }
        jad_jtVar.jad_jw = new Rect(0, 0, (int) (i10 * jad_an2), (int) (i11 * jad_an2));
        jad_jtVar.jad_kx = f14;
        jad_jtVar.jad_ly = f13;
        jad_jtVar.jad_mz = f12;
        jad_jtVar.jad_iv = arrayList4;
        jad_jtVar.jad_hu = longSparseArray;
        jad_jtVar.jad_cp = hashMap;
        jad_jtVar.jad_dq = hashMap2;
        jad_jtVar.jad_jt = sparseArrayCompat2;
        jad_jtVar.jad_er = hashMap3;
        jad_jtVar.jad_fs = arrayList5;
        return jad_jtVar;
    }
}
