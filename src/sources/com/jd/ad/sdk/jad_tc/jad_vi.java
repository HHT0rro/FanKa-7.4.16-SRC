package com.jd.ad.sdk.jad_tc;

import android.graphics.Color;
import com.alipay.sdk.sys.a;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.jd.ad.sdk.jad_ud.jad_cp;
import com.kuaishou.weapon.p0.t;
import com.ss.android.socialbase.downloader.segment.Segment;
import java.util.ArrayList;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class jad_vi {
    public static final jad_cp.jad_an jad_an = jad_cp.jad_an.jad_an("nm", "ind", "refId", a.f4666g, "parent", "sw", "sh", "sc", MediationConstant.ADN_KS, "tt", "masksProperties", "shapes", "t", "ef", "sr", Segment.JsonKey.START, IAdInterListener.AdReqParam.WIDTH, "h", "ip", "op", "tm", "cl", "hd");
    public static final jad_cp.jad_an jad_bo = jad_cp.jad_an.jad_an("d", "a");
    public static final jad_cp.jad_an jad_cp = jad_cp.jad_an.jad_an(a.f4666g, "nm");

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static /* synthetic */ class jad_an {
        public static final /* synthetic */ int[] jad_an;

        static {
            int[] iArr = new int[com.jd.ad.sdk.jad_jt.jad_fs.jad_bo(6).length];
            jad_an = iArr;
            try {
                iArr[3] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                jad_an[4] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x005f. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v9 */
    public static com.jd.ad.sdk.jad_ra.jad_er jad_an(com.jd.ad.sdk.jad_ud.jad_cp jad_cpVar, com.jd.ad.sdk.jad_js.jad_jt jad_jtVar) {
        ArrayList arrayList;
        long j10;
        String str;
        String str2;
        String str3;
        char c4;
        String str4;
        char c10;
        com.jd.ad.sdk.jad_py.jad_bo jad_boVar;
        com.jd.ad.sdk.jad_py.jad_bo jad_boVar2;
        com.jd.ad.sdk.jad_py.jad_bo jad_boVar3;
        com.jd.ad.sdk.jad_py.jad_bo jad_boVar4;
        char c11;
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        jad_cpVar.jad_cp();
        Float valueOf = Float.valueOf(1.0f);
        Float valueOf2 = Float.valueOf(0.0f);
        boolean z10 = false;
        boolean z11 = true;
        long j11 = -1;
        float f10 = 0.0f;
        int i10 = 0;
        String str5 = null;
        com.jd.ad.sdk.jad_py.jad_ly jad_lyVar = null;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        float f11 = 1.0f;
        float f12 = 0.0f;
        int i14 = 0;
        int i15 = 0;
        com.jd.ad.sdk.jad_py.jad_jw jad_jwVar = null;
        com.jd.ad.sdk.jad_py.jad_kx jad_kxVar = null;
        int i16 = 1;
        com.jd.ad.sdk.jad_py.jad_bo jad_boVar5 = null;
        boolean z12 = false;
        com.jd.ad.sdk.jad_qz.jad_an jad_anVar = null;
        jad_jw jad_jwVar2 = null;
        float f13 = 0.0f;
        long j12 = 0;
        String str6 = "UNSET";
        String str7 = null;
        while (jad_cpVar.jad_jt()) {
            switch (jad_cpVar.jad_an(jad_an)) {
                case 0:
                    str2 = str7;
                    str6 = jad_cpVar.jad_ly();
                    str7 = str2;
                    z10 = false;
                    z11 = true;
                    break;
                case 1:
                    str2 = str7;
                    j12 = jad_cpVar.jad_jw();
                    str7 = str2;
                    z10 = false;
                    z11 = true;
                    break;
                case 2:
                    str2 = str7;
                    str5 = jad_cpVar.jad_ly();
                    str7 = str2;
                    z10 = false;
                    z11 = true;
                    break;
                case 3:
                    str2 = str7;
                    int jad_jw = jad_cpVar.jad_jw();
                    if (jad_jw >= 6) {
                        str7 = str2;
                        z10 = false;
                        z11 = true;
                        i10 = 7;
                        break;
                    } else {
                        i10 = com.jd.ad.sdk.jad_jt.jad_fs.jad_bo(7)[jad_jw];
                        str7 = str2;
                        z10 = false;
                        z11 = true;
                        break;
                    }
                case 4:
                    str2 = str7;
                    j11 = jad_cpVar.jad_jw();
                    str7 = str2;
                    z10 = false;
                    z11 = true;
                    break;
                case 5:
                    str2 = str7;
                    i11 = (int) (com.jd.ad.sdk.jad_ve.jad_hu.jad_an() * jad_cpVar.jad_jw());
                    str7 = str2;
                    z10 = false;
                    z11 = true;
                    break;
                case 6:
                    str2 = str7;
                    i12 = (int) (com.jd.ad.sdk.jad_ve.jad_hu.jad_an() * jad_cpVar.jad_jw());
                    str7 = str2;
                    z10 = false;
                    z11 = true;
                    break;
                case 7:
                    str2 = str7;
                    i13 = Color.parseColor(jad_cpVar.jad_ly());
                    str7 = str2;
                    z10 = false;
                    z11 = true;
                    break;
                case 8:
                    str2 = str7;
                    jad_lyVar = jad_cp.jad_an(jad_cpVar, jad_jtVar);
                    str7 = str2;
                    z10 = false;
                    z11 = true;
                    break;
                case 9:
                    str2 = str7;
                    int jad_jw2 = jad_cpVar.jad_jw();
                    if (jad_jw2 >= com.jd.ad.sdk.jad_jt.jad_fs.jad_bo(6).length) {
                        jad_jtVar.jad_an("Unsupported matte type: " + jad_jw2);
                        str7 = str2;
                        z10 = false;
                        z11 = true;
                        break;
                    } else {
                        i16 = com.jd.ad.sdk.jad_jt.jad_fs.jad_bo(6)[jad_jw2];
                        int i17 = jad_an.jad_an[com.jd.ad.sdk.jad_jt.jad_fs.jad_an(i16)];
                        if (i17 != 1) {
                            str3 = i17 == 2 ? "Unsupported matte type: Luma Inverted" : "Unsupported matte type: Luma";
                            jad_jtVar.jad_ob++;
                            str7 = str2;
                            z10 = false;
                            z11 = true;
                        }
                        jad_jtVar.jad_an(str3);
                        jad_jtVar.jad_ob++;
                        str7 = str2;
                        z10 = false;
                        z11 = true;
                    }
                case 10:
                    com.jd.ad.sdk.jad_py.jad_hu jad_huVar = null;
                    jad_cpVar.jad_bo();
                    while (jad_cpVar.jad_jt()) {
                        jad_cpVar.jad_cp();
                        com.jd.ad.sdk.jad_py.jad_hu jad_huVar2 = jad_huVar;
                        com.jd.ad.sdk.jad_py.jad_dq jad_dqVar = jad_huVar2;
                        int i18 = 0;
                        boolean z13 = false;
                        while (jad_cpVar.jad_jt()) {
                            String jad_kx = jad_cpVar.jad_kx();
                            jad_kx.getClass();
                            switch (jad_kx.hashCode()) {
                                case 111:
                                    if (jad_kx.equals("o")) {
                                        c4 = 0;
                                        break;
                                    }
                                    break;
                                case 3588:
                                    if (jad_kx.equals("pt")) {
                                        c4 = 1;
                                        break;
                                    }
                                    break;
                                case 104433:
                                    if (jad_kx.equals("inv")) {
                                        c4 = 2;
                                        break;
                                    }
                                    break;
                                case 3357091:
                                    if (jad_kx.equals("mode")) {
                                        c4 = 3;
                                        break;
                                    }
                                    break;
                            }
                            c4 = 65535;
                            switch (c4) {
                                case 0:
                                    str4 = str7;
                                    jad_dqVar = jad_dq.jad_bo(jad_cpVar, jad_jtVar);
                                    break;
                                case 1:
                                    str4 = str7;
                                    jad_huVar2 = new com.jd.ad.sdk.jad_py.jad_hu(jad_uh.jad_an(jad_cpVar, jad_jtVar, com.jd.ad.sdk.jad_ve.jad_hu.jad_an(), jad_gr.jad_an, false));
                                    jad_dqVar = jad_dqVar;
                                    break;
                                case 2:
                                    z13 = jad_cpVar.jad_hu();
                                    break;
                                case 3:
                                    String jad_ly = jad_cpVar.jad_ly();
                                    jad_ly.getClass();
                                    switch (jad_ly.hashCode()) {
                                        case 97:
                                            if (jad_ly.equals("a")) {
                                                c10 = 0;
                                                break;
                                            }
                                            break;
                                        case 105:
                                            if (jad_ly.equals(t.f36220e)) {
                                                c10 = 1;
                                                break;
                                            }
                                            break;
                                        case 110:
                                            if (jad_ly.equals("n")) {
                                                c10 = 2;
                                                break;
                                            }
                                            break;
                                        case 115:
                                            if (jad_ly.equals(t.f36222g)) {
                                                c10 = 3;
                                                break;
                                            }
                                            break;
                                    }
                                    c10 = 65535;
                                    switch (c10) {
                                        case 0:
                                            break;
                                        case 1:
                                            jad_jtVar.jad_an("Animation contains intersect masks. They are not supported but will be treated like add masks.");
                                            i18 = 3;
                                            break;
                                        case 2:
                                            i18 = 4;
                                            break;
                                        case 3:
                                            i18 = 2;
                                            break;
                                        default:
                                            com.jd.ad.sdk.jad_ve.jad_dq.jad_an("Unknown mask mode " + jad_kx + ". Defaulting to Add.");
                                            break;
                                    }
                                    i18 = 1;
                                    break;
                                default:
                                    jad_cpVar.jad_ob();
                                    break;
                            }
                            str7 = str4;
                            jad_dqVar = jad_dqVar;
                        }
                        jad_cpVar.jad_er();
                        arrayList2.add(new com.jd.ad.sdk.jad_qz.jad_jt(i18, jad_huVar2, jad_dqVar, z13));
                        str7 = str7;
                        jad_huVar = null;
                    }
                    str2 = str7;
                    jad_jtVar.jad_ob += arrayList2.size();
                    jad_cpVar.jad_dq();
                    str7 = str2;
                    z10 = false;
                    z11 = true;
                    break;
                case 11:
                    jad_cpVar.jad_bo();
                    while (jad_cpVar.jad_jt()) {
                        com.jd.ad.sdk.jad_qz.jad_cp jad_an2 = jad_hu.jad_an(jad_cpVar, jad_jtVar);
                        if (jad_an2 != null) {
                            arrayList3.add(jad_an2);
                        }
                    }
                    jad_cpVar.jad_dq();
                    str2 = str7;
                    str7 = str2;
                    z10 = false;
                    z11 = true;
                    break;
                case 12:
                    jad_cpVar.jad_cp();
                    while (jad_cpVar.jad_jt()) {
                        int jad_an3 = jad_cpVar.jad_an(jad_bo);
                        if (jad_an3 == 0) {
                            jad_jwVar = new com.jd.ad.sdk.jad_py.jad_jw(jad_dq.jad_an(jad_cpVar, jad_jtVar, jad_iv.jad_an));
                        } else if (jad_an3 != 1) {
                            jad_cpVar.jad_na();
                            jad_cpVar.jad_ob();
                        } else {
                            jad_cpVar.jad_bo();
                            if (jad_cpVar.jad_jt()) {
                                jad_cp.jad_an jad_anVar2 = jad_bo.jad_an;
                                jad_cpVar.jad_cp();
                                com.jd.ad.sdk.jad_py.jad_kx jad_kxVar2 = null;
                                while (jad_cpVar.jad_jt()) {
                                    if (jad_cpVar.jad_an(jad_bo.jad_an) != 0) {
                                        jad_cpVar.jad_na();
                                        jad_cpVar.jad_ob();
                                    } else {
                                        jad_cpVar.jad_cp();
                                        com.jd.ad.sdk.jad_py.jad_an jad_anVar3 = null;
                                        com.jd.ad.sdk.jad_py.jad_an jad_anVar4 = null;
                                        com.jd.ad.sdk.jad_py.jad_bo jad_boVar6 = null;
                                        com.jd.ad.sdk.jad_py.jad_bo jad_boVar7 = null;
                                        while (jad_cpVar.jad_jt()) {
                                            int jad_an4 = jad_cpVar.jad_an(jad_bo.jad_bo);
                                            if (jad_an4 == 0) {
                                                jad_anVar3 = jad_dq.jad_an(jad_cpVar, jad_jtVar);
                                            } else if (jad_an4 == 1) {
                                                jad_anVar4 = jad_dq.jad_an(jad_cpVar, jad_jtVar);
                                            } else if (jad_an4 == 2) {
                                                jad_boVar6 = jad_dq.jad_an(jad_cpVar, jad_jtVar, true);
                                            } else if (jad_an4 != 3) {
                                                jad_cpVar.jad_na();
                                                jad_cpVar.jad_ob();
                                            } else {
                                                jad_boVar7 = jad_dq.jad_an(jad_cpVar, jad_jtVar, true);
                                            }
                                        }
                                        jad_cpVar.jad_er();
                                        jad_kxVar2 = new com.jd.ad.sdk.jad_py.jad_kx(jad_anVar3, jad_anVar4, jad_boVar6, jad_boVar7);
                                    }
                                }
                                jad_cpVar.jad_er();
                                if (jad_kxVar2 == null) {
                                    jad_kxVar2 = new com.jd.ad.sdk.jad_py.jad_kx(null, null, null, null);
                                }
                                jad_kxVar = jad_kxVar2;
                            }
                            while (jad_cpVar.jad_jt()) {
                                jad_cpVar.jad_ob();
                            }
                            jad_cpVar.jad_dq();
                        }
                    }
                    jad_cpVar.jad_er();
                    z10 = false;
                    z11 = true;
                    break;
                case 13:
                    jad_cpVar.jad_bo();
                    ArrayList arrayList4 = new ArrayList();
                    while (jad_cpVar.jad_jt()) {
                        jad_cpVar.jad_cp();
                        while (jad_cpVar.jad_jt()) {
                            int jad_an5 = jad_cpVar.jad_an(jad_cp);
                            if (jad_an5 == 0) {
                                int jad_jw3 = jad_cpVar.jad_jw();
                                if (jad_jw3 == 29) {
                                    jad_cp.jad_an jad_anVar5 = jad_er.jad_an;
                                    jad_anVar = null;
                                    while (jad_cpVar.jad_jt()) {
                                        if (jad_cpVar.jad_an(jad_er.jad_an) != 0) {
                                            jad_cpVar.jad_na();
                                            jad_cpVar.jad_ob();
                                        } else {
                                            jad_cpVar.jad_bo();
                                            while (jad_cpVar.jad_jt()) {
                                                jad_cpVar.jad_cp();
                                                com.jd.ad.sdk.jad_qz.jad_an jad_anVar6 = null;
                                                while (true) {
                                                    boolean z14 = false;
                                                    while (jad_cpVar.jad_jt()) {
                                                        int jad_an6 = jad_cpVar.jad_an(jad_er.jad_bo);
                                                        if (jad_an6 != 0) {
                                                            if (jad_an6 != z11) {
                                                                jad_cpVar.jad_na();
                                                                jad_cpVar.jad_ob();
                                                            } else if (z14) {
                                                                jad_anVar6 = new com.jd.ad.sdk.jad_qz.jad_an(jad_dq.jad_an(jad_cpVar, jad_jtVar, z11));
                                                            } else {
                                                                jad_cpVar.jad_ob();
                                                            }
                                                        } else if (jad_cpVar.jad_jw() == 0) {
                                                            z14 = true;
                                                        }
                                                    }
                                                    jad_cpVar.jad_er();
                                                    if (jad_anVar6 != null) {
                                                        jad_anVar = jad_anVar6;
                                                    }
                                                }
                                            }
                                            jad_cpVar.jad_dq();
                                        }
                                    }
                                } else if (jad_jw3 == 25) {
                                    jad_kx jad_kxVar3 = new jad_kx();
                                    while (jad_cpVar.jad_jt()) {
                                        if (jad_cpVar.jad_an(jad_kx.jad_fs) != 0) {
                                            jad_cpVar.jad_na();
                                            jad_cpVar.jad_ob();
                                        } else {
                                            jad_cpVar.jad_bo();
                                            while (jad_cpVar.jad_jt()) {
                                                jad_cpVar.jad_cp();
                                                String str8 = "";
                                                while (jad_cpVar.jad_jt()) {
                                                    int jad_an7 = jad_cpVar.jad_an(jad_kx.jad_jt);
                                                    if (jad_an7 != 0) {
                                                        if (jad_an7 == z11) {
                                                            str8.getClass();
                                                            switch (str8.hashCode()) {
                                                                case 353103893:
                                                                    if (str8.equals("Distance")) {
                                                                        c11 = 0;
                                                                        break;
                                                                    }
                                                                    break;
                                                                case 397447147:
                                                                    if (str8.equals("Opacity")) {
                                                                        c11 = 1;
                                                                        break;
                                                                    }
                                                                    break;
                                                                case 1041377119:
                                                                    if (str8.equals("Direction")) {
                                                                        c11 = 2;
                                                                        break;
                                                                    }
                                                                    break;
                                                                case 1379387491:
                                                                    if (str8.equals("Shadow Color")) {
                                                                        c11 = 3;
                                                                        break;
                                                                    }
                                                                    break;
                                                                case 1383710113:
                                                                    if (str8.equals("Softness")) {
                                                                        c11 = 4;
                                                                        break;
                                                                    }
                                                                    break;
                                                            }
                                                            c11 = 65535;
                                                            switch (c11) {
                                                                case 0:
                                                                    jad_kxVar3.jad_dq = jad_dq.jad_an(jad_cpVar, jad_jtVar, z11);
                                                                    break;
                                                                case 1:
                                                                    jad_kxVar3.jad_bo = jad_dq.jad_an(jad_cpVar, jad_jtVar, z10);
                                                                    break;
                                                                case 2:
                                                                    jad_kxVar3.jad_cp = jad_dq.jad_an(jad_cpVar, jad_jtVar, z10);
                                                                    break;
                                                                case 3:
                                                                    jad_kxVar3.jad_an = jad_dq.jad_an(jad_cpVar, jad_jtVar);
                                                                    break;
                                                                case 4:
                                                                    jad_kxVar3.jad_er = jad_dq.jad_an(jad_cpVar, jad_jtVar, z11);
                                                                    break;
                                                            }
                                                        } else {
                                                            jad_cpVar.jad_na();
                                                        }
                                                        jad_cpVar.jad_ob();
                                                    } else {
                                                        str8 = jad_cpVar.jad_ly();
                                                    }
                                                }
                                                jad_cpVar.jad_er();
                                            }
                                            jad_cpVar.jad_dq();
                                        }
                                    }
                                    com.jd.ad.sdk.jad_py.jad_an jad_anVar7 = jad_kxVar3.jad_an;
                                    if (jad_anVar7 == null || (jad_boVar = jad_kxVar3.jad_bo) == null || (jad_boVar2 = jad_kxVar3.jad_cp) == null || (jad_boVar3 = jad_kxVar3.jad_dq) == null || (jad_boVar4 = jad_kxVar3.jad_er) == null) {
                                        z10 = false;
                                        z11 = true;
                                        jad_jwVar2 = null;
                                    } else {
                                        jad_jwVar2 = new jad_jw(jad_anVar7, jad_boVar, jad_boVar2, jad_boVar3, jad_boVar4);
                                    }
                                }
                            } else if (jad_an5 != z11) {
                                jad_cpVar.jad_na();
                                jad_cpVar.jad_ob();
                            } else {
                                arrayList4.add(jad_cpVar.jad_ly());
                            }
                            z10 = false;
                            z11 = true;
                        }
                        jad_cpVar.jad_er();
                        z10 = false;
                        z11 = true;
                    }
                    jad_cpVar.jad_dq();
                    jad_jtVar.jad_an("Lottie doesn't support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as contents  in your shape. Found: " + ((Object) arrayList4));
                    z10 = false;
                    z11 = true;
                    break;
                case 14:
                    f11 = (float) jad_cpVar.jad_iv();
                    break;
                case 15:
                    f12 = (float) jad_cpVar.jad_iv();
                    break;
                case 16:
                    i14 = (int) (com.jd.ad.sdk.jad_ve.jad_hu.jad_an() * jad_cpVar.jad_jw());
                    break;
                case 17:
                    i15 = (int) (com.jd.ad.sdk.jad_ve.jad_hu.jad_an() * jad_cpVar.jad_jw());
                    break;
                case 18:
                    f10 = (float) jad_cpVar.jad_iv();
                    break;
                case 19:
                    f13 = (float) jad_cpVar.jad_iv();
                    break;
                case 20:
                    jad_boVar5 = jad_dq.jad_an(jad_cpVar, jad_jtVar, z10);
                    break;
                case 21:
                    str7 = jad_cpVar.jad_ly();
                    break;
                case 22:
                    z12 = jad_cpVar.jad_hu();
                    break;
                default:
                    str2 = str7;
                    jad_cpVar.jad_na();
                    jad_cpVar.jad_ob();
                    str7 = str2;
                    z10 = false;
                    z11 = true;
                    break;
            }
        }
        String str9 = str7;
        jad_cpVar.jad_er();
        ArrayList arrayList5 = new ArrayList();
        if (f10 > 0.0f) {
            arrayList = arrayList2;
            j10 = j12;
            str = str9;
            arrayList5.add(new com.jd.ad.sdk.jad_wf.jad_an(jad_jtVar, valueOf2, valueOf2, null, 0.0f, Float.valueOf(f10)));
        } else {
            arrayList = arrayList2;
            j10 = j12;
            str = str9;
        }
        if (f13 <= 0.0f) {
            f13 = jad_jtVar.jad_ly;
        }
        arrayList5.add(new com.jd.ad.sdk.jad_wf.jad_an(jad_jtVar, valueOf, valueOf, null, f10, Float.valueOf(f13)));
        arrayList5.add(new com.jd.ad.sdk.jad_wf.jad_an(jad_jtVar, valueOf2, valueOf2, null, f13, Float.valueOf(Float.MAX_VALUE)));
        if (str6.endsWith(".ai") || "ai".equals(str)) {
            jad_jtVar.jad_an("Convert your Illustrator layers to shape layers.");
        }
        return new com.jd.ad.sdk.jad_ra.jad_er(arrayList3, jad_jtVar, str6, j10, i10, j11, str5, arrayList, jad_lyVar, i11, i12, i13, f11, f12, i14, i15, jad_jwVar, jad_kxVar, arrayList5, i16, jad_boVar5, z12, jad_anVar, jad_jwVar2);
    }
}
