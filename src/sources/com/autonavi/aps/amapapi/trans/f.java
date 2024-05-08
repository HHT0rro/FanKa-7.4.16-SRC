package com.autonavi.aps.amapapi.trans;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.amap.api.col.p0003l.fj;
import com.amap.api.col.p0003l.fm;
import com.amap.api.col.p0003l.ks;
import com.autonavi.aps.amapapi.restruct.g;
import com.autonavi.aps.amapapi.restruct.k;
import com.autonavi.aps.amapapi.utils.j;
import com.huawei.appgallery.agd.common.utils.StringUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: Req.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class f {
    public static String I;
    public static String K;

    /* renamed from: a, reason: collision with root package name */
    public String f9579a = "1";

    /* renamed from: b, reason: collision with root package name */
    public short f9580b = 0;

    /* renamed from: c, reason: collision with root package name */
    public String f9581c = null;

    /* renamed from: d, reason: collision with root package name */
    public String f9582d = null;

    /* renamed from: e, reason: collision with root package name */
    public String f9583e = null;

    /* renamed from: f, reason: collision with root package name */
    public String f9584f = null;

    /* renamed from: g, reason: collision with root package name */
    public String f9585g = null;

    /* renamed from: h, reason: collision with root package name */
    public String f9586h = null;

    /* renamed from: i, reason: collision with root package name */
    public String f9587i = null;

    /* renamed from: j, reason: collision with root package name */
    public String f9588j = null;

    /* renamed from: k, reason: collision with root package name */
    public String f9589k = null;

    /* renamed from: l, reason: collision with root package name */
    public String f9590l = null;

    /* renamed from: m, reason: collision with root package name */
    public String f9591m = null;

    /* renamed from: n, reason: collision with root package name */
    public String f9592n = null;

    /* renamed from: o, reason: collision with root package name */
    public String f9593o = null;

    /* renamed from: p, reason: collision with root package name */
    public String f9594p = null;

    /* renamed from: q, reason: collision with root package name */
    public String f9595q = null;

    /* renamed from: r, reason: collision with root package name */
    public String f9596r = null;

    /* renamed from: s, reason: collision with root package name */
    public String f9597s = null;

    /* renamed from: t, reason: collision with root package name */
    public String f9598t = null;

    /* renamed from: u, reason: collision with root package name */
    public String f9599u = null;

    /* renamed from: v, reason: collision with root package name */
    public String f9600v = null;

    /* renamed from: w, reason: collision with root package name */
    public String f9601w = null;

    /* renamed from: x, reason: collision with root package name */
    public String f9602x = null;

    /* renamed from: y, reason: collision with root package name */
    public String f9603y = null;

    /* renamed from: z, reason: collision with root package name */
    public int f9604z = 0;
    public ArrayList<com.autonavi.aps.amapapi.restruct.d> A = new ArrayList<>();
    public ArrayList<com.autonavi.aps.amapapi.restruct.d> B = new ArrayList<>();
    public String C = null;
    public String D = null;
    public ArrayList<ks> E = new ArrayList<>();
    public String F = null;
    public String G = null;
    public byte[] H = null;
    private byte[] Q = null;
    private int R = 0;
    public String J = null;
    public String L = null;
    public String M = null;
    public String N = null;
    public int O = 0;
    private List<com.autonavi.aps.amapapi.restruct.f> S = null;
    private List<com.autonavi.aps.amapapi.restruct.d> T = Collections.synchronizedList(new ArrayList());
    public final int P = 3;

    private void b() {
        String[] strArr = new String[27];
        strArr[0] = this.f9579a;
        strArr[1] = this.f9581c;
        strArr[2] = this.f9582d;
        strArr[3] = this.f9583e;
        strArr[4] = this.f9584f;
        strArr[5] = this.f9585g;
        strArr[6] = this.f9586h;
        strArr[7] = this.f9587i;
        strArr[8] = this.f9590l;
        strArr[9] = this.f9591m;
        strArr[10] = this.f9592n;
        strArr[11] = this.f9593o;
        strArr[12] = this.f9594p;
        strArr[13] = this.f9595q;
        strArr[14] = this.f9596r;
        strArr[15] = this.f9597s;
        strArr[16] = this.f9598t;
        strArr[17] = this.f9599u;
        strArr[18] = this.f9600v;
        strArr[19] = this.f9601w;
        strArr[20] = this.f9602x;
        strArr[21] = this.D;
        strArr[22] = this.F;
        strArr[23] = this.G;
        strArr[24] = I;
        strArr[25] = this.M;
        strArr[26] = this.N;
        for (int i10 = 0; i10 < 27; i10++) {
            if (TextUtils.isEmpty(strArr[i10])) {
                strArr[i10] = "";
            }
        }
        if (TextUtils.isEmpty(this.f9588j)) {
            this.f9588j = "0";
        } else if (!"0".equals(this.f9588j) && !"2".equals(this.f9588j)) {
            this.f9588j = "0";
        }
        if (TextUtils.isEmpty(this.f9589k)) {
            this.f9589k = "0";
        } else if (!"0".equals(this.f9589k) && !"1".equals(this.f9589k)) {
            this.f9589k = "0";
        }
        if (TextUtils.isEmpty(this.f9603y)) {
            this.f9603y = "0";
        } else if (!"1".equals(this.f9603y) && !"2".equals(this.f9603y)) {
            this.f9603y = "0";
        }
        if (!com.autonavi.aps.amapapi.restruct.e.a(this.f9604z)) {
            this.f9604z = 0;
        }
        if (this.H == null) {
            this.H = new byte[0];
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(19:12|13|14|(17:280|(1:282)(1:384)|283|(7:285|(1:287)(1:361)|288|(1:290)(1:360)|291|(1:293)(1:359)|294)(12:(11:363|(1:365)(1:383)|366|(1:368)(1:382)|369|(1:371)(1:381)|372|(1:374)(1:380)|375|(1:377)(1:379)|378)|296|(1:298)(1:358)|(1:300)|301|(1:303)(1:356)|304|(1:306)|307|(1:309)|310|(2:312|(2:314|315)(3:316|(11:318|(1:320)(1:351)|321|(1:323)(1:350)|324|(1:326)(1:349)|327|(1:329)|330|(2:345|346)(8:332|(1:334)(1:344)|335|(1:337)|338|(1:340)|341|342)|343)|352))(2:353|(2:355|315)))|295|296|(0)(0)|(0)|300|301|(0)(0)|304|(0)|307|(0)|310|(0)(0))(1:17)|18|(13:22|23|24|25|(1:276)(4:28|(6:30|(3:85|(1:87)|88)(1:(3:36|(1:38)|39)(2:78|(3:80|(1:82)|83)(1:84)))|40|(1:42)|43|(3:64|(1:75)(5:66|(1:68)|(1:70)|71|(3:73|59|60)(1:74))|61)(3:49|(6:53|(1:55)|(1:57)|58|59|60)|61))|89|90)|91|(1:275)(15:95|96|97|98|99|100|(1:102)|103|104|105|(5:267|(1:269)|108|(2:110|111)|113)|107|108|(0)|113)|114|(1:116)(7:235|(1:237)(1:266)|(1:239)|240|(10:242|243|244|245|246|(1:248)(2:259|(1:261))|249|(1:258)|(2:254|255)(1:257)|256)|264|265)|117|118|119|(28:121|122|123|124|125|(1:127)|128|129|(3:219|220|221)|131|132|133|134|135|136|137|138|(1:140)(1:214)|141|(1:143)|144|(5:146|(1:148)(1:186)|149|(5:152|153|(9:156|(2:163|(6:165|(1:167)|168|169|170|171)(4:172|(3:174|(1:176)|177)|170|171))|178|(1:180)|181|169|170|171|154)|182|183)|151)|187|(4:189|(1:191)(1:207)|192|(3:194|(6:197|(1:199)|200|(2:202|203)(1:205)|204|195)|206))|208|(1:210)|211|212)(3:226|(1:228)|(29:230|231|122|123|124|125|(0)|128|129|(0)|131|132|133|134|135|136|137|138|(0)(0)|141|(0)|144|(0)|187|(0)|208|(0)|211|212)(28:232|233|123|124|125|(0)|128|129|(0)|131|132|133|134|135|136|137|138|(0)(0)|141|(0)|144|(0)|187|(0)|208|(0)|211|212)))|279|25|(0)|276|91|(1:93)|275|114|(0)(0)|117|118|119|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:234:0x06d5, code lost:
    
        r7[r9] = 0;
     */
    /* JADX WARN: Removed duplicated region for block: B:110:0x05b9 A[Catch: all -> 0x05c9, TRY_LEAVE, TryCatch #7 {all -> 0x05c9, blocks: (B:97:0x054f, B:105:0x0588, B:108:0x059a, B:110:0x05b9, B:272:0x057e, B:100:0x0565, B:103:0x0572), top: B:96:0x054f, inners: #10 }] */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0601  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x06b4 A[Catch: all -> 0x06d5, TryCatch #3 {all -> 0x06d5, blocks: (B:119:0x06b0, B:121:0x06b4, B:226:0x06b7, B:230:0x06c3, B:232:0x06c7), top: B:118:0x06b0 }] */
    /* JADX WARN: Removed duplicated region for block: B:127:0x06e8 A[Catch: all -> 0x0709, TryCatch #6 {all -> 0x0709, blocks: (B:125:0x06e0, B:127:0x06e8, B:128:0x06f2), top: B:124:0x06e0 }] */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0721  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0732  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x074c  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0842  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x08ec  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x0723  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x06fa A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:226:0x06b7 A[Catch: all -> 0x06d5, TryCatch #3 {all -> 0x06d5, blocks: (B:119:0x06b0, B:121:0x06b4, B:226:0x06b7, B:230:0x06c3, B:232:0x06c7), top: B:118:0x06b0 }] */
    /* JADX WARN: Removed duplicated region for block: B:235:0x0607  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x035e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:282:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:298:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:303:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:306:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:309:0x0247  */
    /* JADX WARN: Removed duplicated region for block: B:312:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:353:0x031c  */
    /* JADX WARN: Removed duplicated region for block: B:356:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:357:0x0215 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:358:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:362:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:384:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0541  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final byte[] a() {
        /*
            Method dump skipped, instructions count: 2335
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.trans.f.a():byte[]");
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x000d, code lost:
    
        if (r0.length != 6) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private byte[] a(java.lang.String r7) {
        /*
            r6 = this;
            java.lang.String r0 = ":"
            java.lang.String[] r0 = r7.split(r0)
            r1 = 6
            byte[] r2 = new byte[r1]
            r3 = 0
            if (r0 == 0) goto Lf
            int r4 = r0.length     // Catch: java.lang.Throwable -> L3e
            if (r4 == r1) goto L1b
        Lf:
            java.lang.String[] r0 = new java.lang.String[r1]     // Catch: java.lang.Throwable -> L3e
            r4 = 0
        L12:
            if (r4 >= r1) goto L1b
            java.lang.String r5 = "0"
            r0[r4] = r5     // Catch: java.lang.Throwable -> L3e
            int r4 = r4 + 1
            goto L12
        L1b:
            r1 = 0
        L1c:
            int r4 = r0.length     // Catch: java.lang.Throwable -> L3e
            if (r1 >= r4) goto L50
            r4 = r0[r1]     // Catch: java.lang.Throwable -> L3e
            int r4 = r4.length()     // Catch: java.lang.Throwable -> L3e
            r5 = 2
            if (r4 <= r5) goto L30
            r4 = r0[r1]     // Catch: java.lang.Throwable -> L3e
            java.lang.String r4 = r4.substring(r3, r5)     // Catch: java.lang.Throwable -> L3e
            r0[r1] = r4     // Catch: java.lang.Throwable -> L3e
        L30:
            r4 = r0[r1]     // Catch: java.lang.Throwable -> L3e
            r5 = 16
            int r4 = java.lang.Integer.parseInt(r4, r5)     // Catch: java.lang.Throwable -> L3e
            byte r4 = (byte) r4     // Catch: java.lang.Throwable -> L3e
            r2[r1] = r4     // Catch: java.lang.Throwable -> L3e
            int r1 = r1 + 1
            goto L1c
        L3e:
            r0 = move-exception
            java.lang.String r1 = "getMacBa "
            java.lang.String r7 = r1.concat(r7)
            java.lang.String r1 = "Req"
            com.autonavi.aps.amapapi.utils.b.a(r0, r1, r7)
            java.lang.String r7 = "00:00:00:00:00:00"
            byte[] r2 = r6.a(r7)
        L50:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.trans.f.a(java.lang.String):byte[]");
    }

    public final void a(Context context, boolean z10, boolean z11, com.autonavi.aps.amapapi.restruct.e eVar, k kVar, ConnectivityManager connectivityManager, String str, g gVar) {
        String str2;
        String str3;
        String str4;
        NetworkInfo networkInfo;
        String str5;
        String str6;
        ArrayList<ks> arrayList;
        int i10;
        String f10 = fj.f(context);
        int d10 = j.d();
        this.J = str;
        this.S = null;
        if (z11) {
            str2 = "api_serverSDK_130905";
            str3 = "S128DF1572465B890OE3F7A13167KLEI";
        } else {
            str2 = "UC_nlp_20131029";
            str3 = "BKZCHMBBSSUK7U8GLUKHBB56CCFF78U";
        }
        String str7 = str3;
        String str8 = str2;
        StringBuilder sb2 = new StringBuilder();
        int g3 = eVar.g();
        int h10 = eVar.h();
        TelephonyManager i11 = eVar.i();
        ArrayList<com.autonavi.aps.amapapi.restruct.d> c4 = eVar.c();
        ArrayList<com.autonavi.aps.amapapi.restruct.d> d11 = eVar.d();
        ArrayList<ks> e2 = kVar.e();
        String str9 = h10 == 2 ? "1" : "0";
        if (i11 != null) {
            if (TextUtils.isEmpty(com.autonavi.aps.amapapi.utils.b.f9638g)) {
                try {
                    com.autonavi.aps.amapapi.utils.b.f9638g = fm.k();
                } catch (Throwable th) {
                    com.autonavi.aps.amapapi.utils.b.a(th, "Aps", "getApsReq part4");
                }
            }
            str4 = "1";
            if (TextUtils.isEmpty(com.autonavi.aps.amapapi.utils.b.f9638g) && Build.VERSION.SDK_INT < 29) {
                com.autonavi.aps.amapapi.utils.b.f9638g = "888888888888888";
            }
            if (TextUtils.isEmpty(com.autonavi.aps.amapapi.utils.b.f9639h)) {
                try {
                    com.autonavi.aps.amapapi.utils.b.f9639h = fm.n();
                } catch (SecurityException unused) {
                } catch (Throwable th2) {
                    com.autonavi.aps.amapapi.utils.b.a(th2, "Aps", "getApsReq part2");
                }
            }
            if (TextUtils.isEmpty(com.autonavi.aps.amapapi.utils.b.f9639h) && Build.VERSION.SDK_INT < 29) {
                com.autonavi.aps.amapapi.utils.b.f9639h = "888888888888888";
            }
        } else {
            str4 = "1";
        }
        try {
            networkInfo = connectivityManager.getActiveNetworkInfo();
        } catch (Throwable th3) {
            com.autonavi.aps.amapapi.utils.b.a(th3, "Aps", "getApsReq part");
            networkInfo = null;
        }
        boolean a10 = kVar.a(connectivityManager);
        if (j.a(networkInfo) != -1) {
            str5 = j.a(connectivityManager);
            str6 = a10 ? "2" : str4;
        } else {
            str5 = "";
            str6 = str5;
        }
        if ((g3 & 4) == 4 && !d11.isEmpty()) {
            this.B.clear();
            this.B.addAll(d11);
        } else {
            this.B.clear();
        }
        this.A.clear();
        this.A.addAll(c4);
        StringBuilder sb3 = new StringBuilder();
        if (kVar.k()) {
            if (a10) {
                com.autonavi.aps.amapapi.restruct.j m10 = kVar.m();
                if (kVar.a(m10)) {
                    sb3.append(m10.a());
                    sb3.append(",");
                    int c10 = m10.c();
                    if (c10 < -128 || c10 > 127) {
                        c10 = 0;
                    }
                    sb3.append(c10);
                    sb3.append(",");
                    String b4 = m10.b();
                    try {
                        i10 = b4.getBytes("UTF-8").length;
                    } catch (Exception unused2) {
                        i10 = 32;
                    }
                    if (i10 >= 32) {
                        b4 = "unkwn";
                    }
                    sb3.append(b4.replace(StringUtils.NO_PRINT_CODE, "."));
                }
            }
            if (e2 != null && (arrayList = this.E) != null) {
                arrayList.clear();
                this.E.addAll(e2);
            }
        } else {
            kVar.g();
            ArrayList<ks> arrayList2 = this.E;
            if (arrayList2 != null) {
                arrayList2.clear();
            }
        }
        this.f9580b = (short) 0;
        if (!z10) {
            this.f9580b = (short) (2 | 0);
        }
        this.f9581c = str8;
        this.f9582d = str7;
        this.f9584f = Build.MODEL;
        this.f9585g = "android" + Build.VERSION.RELEASE;
        this.f9586h = j.b(context);
        this.f9587i = str9;
        this.f9588j = "0";
        this.f9589k = "0";
        this.f9590l = "0";
        this.f9591m = "0";
        this.f9592n = "0";
        this.f9593o = f10;
        this.f9594p = com.autonavi.aps.amapapi.utils.b.f9638g;
        this.f9595q = com.autonavi.aps.amapapi.utils.b.f9639h;
        this.f9597s = String.valueOf(d10);
        this.f9598t = j.i(context);
        this.f9600v = "6.4.1";
        this.f9601w = null;
        this.f9599u = "";
        this.f9602x = str5;
        this.f9603y = str6;
        this.f9604z = g3;
        this.C = eVar.l();
        this.F = k.p();
        this.D = sb3.toString();
        this.O = (int) ((j.b() - kVar.q()) / 1000);
        try {
            if (TextUtils.isEmpty(I)) {
                I = fm.f(context);
            }
        } catch (Throwable unused3) {
        }
        try {
            if (TextUtils.isEmpty(K)) {
                K = fm.a(context);
            }
        } catch (Throwable unused4) {
        }
        try {
            if (TextUtils.isEmpty(this.M)) {
                this.M = fm.f();
            }
        } catch (Throwable unused5) {
        }
        try {
            if (TextUtils.isEmpty(this.N)) {
                this.N = fm.e(context);
            }
        } catch (Throwable unused6) {
        }
        try {
            this.S = gVar.a(this.B, this.E);
            a(this.A, this.B);
        } catch (Throwable th4) {
            th4.printStackTrace();
        }
        sb2.delete(0, sb2.length());
        sb3.delete(0, sb3.length());
    }

    private void a(ArrayList<com.autonavi.aps.amapapi.restruct.d> arrayList, ArrayList<com.autonavi.aps.amapapi.restruct.d> arrayList2) {
        if (arrayList2 != null && arrayList2.size() > 0) {
            Iterator<com.autonavi.aps.amapapi.restruct.d> iterator2 = arrayList2.iterator2();
            while (iterator2.hasNext()) {
                com.autonavi.aps.amapapi.restruct.d next = iterator2.next();
                if (next.f9446r && next.f9442n) {
                    a(next, this.T);
                    return;
                }
            }
        }
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        a(arrayList.get(0), this.T);
    }

    private static void a(com.autonavi.aps.amapapi.restruct.d dVar, List<com.autonavi.aps.amapapi.restruct.d> list) {
        if (dVar == null || list == null) {
            return;
        }
        int size = list.size();
        if (size == 0) {
            list.add(dVar);
            return;
        }
        long j10 = Long.MAX_VALUE;
        int i10 = 0;
        int i11 = -1;
        int i12 = -1;
        while (true) {
            if (i10 >= size) {
                i11 = i12;
                break;
            }
            com.autonavi.aps.amapapi.restruct.d dVar2 = list.get(i10);
            if (dVar.c() != null && dVar.c().equals(dVar2.c())) {
                int i13 = dVar.f9447s;
                if (i13 != dVar2.f9447s) {
                    dVar2.f9448t = dVar.f9448t;
                    dVar2.f9447s = i13;
                }
            } else {
                j10 = Math.min(j10, dVar2.f9448t);
                if (j10 == dVar2.f9448t) {
                    i12 = i10;
                }
                i10++;
            }
        }
        if (i11 >= 0) {
            if (size < 3) {
                list.add(dVar);
            } else {
                if (dVar.f9448t <= j10 || i11 >= size) {
                    return;
                }
                list.remove(i11);
                list.add(dVar);
            }
        }
    }

    private static int a(String str, byte[] bArr, int i10) {
        try {
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "Req", "copyContentWithByteLen");
            bArr[i10] = 0;
        }
        if (TextUtils.isEmpty(str)) {
            bArr[i10] = 0;
            return i10 + 1;
        }
        byte[] bytes = str.getBytes("GBK");
        int length = bytes.length;
        if (length > 127) {
            length = 127;
        }
        bArr[i10] = (byte) length;
        int i11 = i10 + 1;
        System.arraycopy((Object) bytes, 0, (Object) bArr, i11, length);
        return i11 + length;
    }
}
