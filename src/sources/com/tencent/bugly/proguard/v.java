package com.tencent.bugly.proguard;

import android.content.Context;
import java.util.Map;
import java.util.UUID;

/* compiled from: BUGLY */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class v implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private int f40213a;

    /* renamed from: b, reason: collision with root package name */
    private int f40214b;

    /* renamed from: c, reason: collision with root package name */
    private final Context f40215c;

    /* renamed from: d, reason: collision with root package name */
    private final int f40216d;

    /* renamed from: e, reason: collision with root package name */
    private final byte[] f40217e;

    /* renamed from: f, reason: collision with root package name */
    private final com.tencent.bugly.crashreport.common.info.a f40218f;

    /* renamed from: g, reason: collision with root package name */
    private final com.tencent.bugly.crashreport.common.strategy.a f40219g;

    /* renamed from: h, reason: collision with root package name */
    private final s f40220h;

    /* renamed from: i, reason: collision with root package name */
    private final u f40221i;

    /* renamed from: j, reason: collision with root package name */
    private final int f40222j;

    /* renamed from: k, reason: collision with root package name */
    private final t f40223k;

    /* renamed from: l, reason: collision with root package name */
    private final t f40224l;

    /* renamed from: m, reason: collision with root package name */
    private String f40225m;

    /* renamed from: n, reason: collision with root package name */
    private final String f40226n;

    /* renamed from: o, reason: collision with root package name */
    private final Map<String, String> f40227o;

    /* renamed from: p, reason: collision with root package name */
    private int f40228p;

    /* renamed from: q, reason: collision with root package name */
    private long f40229q;

    /* renamed from: r, reason: collision with root package name */
    private long f40230r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f40231s;

    public v(Context context, int i10, int i11, byte[] bArr, String str, String str2, t tVar, boolean z10, boolean z11) {
        this(context, i10, i11, bArr, str, str2, tVar, 2, 30000, z11, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(com.tencent.bugly.proguard.an r4, boolean r5, int r6, java.lang.String r7) {
        /*
            r3 = this;
            int r4 = r3.f40216d
            r0 = 630(0x276, float:8.83E-43)
            if (r4 == r0) goto L1a
            r0 = 640(0x280, float:8.97E-43)
            if (r4 == r0) goto L17
            r0 = 830(0x33e, float:1.163E-42)
            if (r4 == r0) goto L1a
            r0 = 840(0x348, float:1.177E-42)
            if (r4 == r0) goto L17
            java.lang.String r4 = java.lang.String.valueOf(r4)
            goto L1c
        L17:
            java.lang.String r4 = "userinfo"
            goto L1c
        L1a:
            java.lang.String r4 = "crash"
        L1c:
            r0 = 1
            r1 = 0
            if (r5 == 0) goto L2a
            java.lang.Object[] r6 = new java.lang.Object[r0]
            r6[r1] = r4
            java.lang.String r4 = "[Upload] Success: %s"
            com.tencent.bugly.proguard.x.a(r4, r6)
            goto L3d
        L2a:
            r2 = 3
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r2[r1] = r6
            r2[r0] = r4
            r4 = 2
            r2[r4] = r7
            java.lang.String r4 = "[Upload] Failed to upload(%d) %s: %s"
            com.tencent.bugly.proguard.x.e(r4, r2)
        L3d:
            long r6 = r3.f40229q
            long r0 = r3.f40230r
            long r6 = r6 + r0
            r0 = 0
            int r4 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r4 <= 0) goto L5d
            com.tencent.bugly.proguard.u r4 = r3.f40221i
            boolean r6 = r3.f40231s
            long r6 = r4.a(r6)
            long r0 = r3.f40229q
            long r6 = r6 + r0
            long r0 = r3.f40230r
            long r6 = r6 + r0
            com.tencent.bugly.proguard.u r4 = r3.f40221i
            boolean r0 = r3.f40231s
            r4.a(r6, r0)
        L5d:
            com.tencent.bugly.proguard.t r4 = r3.f40223k
            if (r4 == 0) goto L64
            r4.a(r5)
        L64:
            com.tencent.bugly.proguard.t r4 = r3.f40224l
            if (r4 == 0) goto L6b
            r4.a(r5)
        L6b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.v.a(com.tencent.bugly.proguard.an, boolean, int, java.lang.String):void");
    }

    public final void b(long j10) {
        this.f40230r += j10;
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x01b2 A[Catch: all -> 0x0321, TryCatch #0 {all -> 0x0321, blocks: (B:3:0x0007, B:5:0x001a, B:9:0x0022, B:12:0x0027, B:14:0x003b, B:16:0x003f, B:18:0x0043, B:21:0x0049, B:23:0x004f, B:25:0x0055, B:27:0x0082, B:28:0x0085, B:30:0x00b4, B:32:0x00ba, B:33:0x00ce, B:36:0x00d6, B:38:0x00ed, B:39:0x00fa, B:42:0x013d, B:45:0x0150, B:48:0x0158, B:51:0x015f, B:54:0x0167, B:58:0x01b2, B:60:0x01de, B:61:0x01e6, B:63:0x01ec, B:65:0x020d, B:76:0x0247, B:78:0x025a, B:80:0x026b, B:81:0x0273, B:83:0x0279, B:85:0x0294, B:87:0x029b, B:90:0x02a3, B:92:0x02a9, B:94:0x02b0, B:97:0x02c4, B:99:0x02d7, B:101:0x02de, B:103:0x02c3, B:105:0x02e6, B:108:0x0171, B:110:0x0177, B:111:0x017f, B:113:0x018d, B:114:0x0199, B:115:0x01a6, B:117:0x030c, B:119:0x0313, B:121:0x031a), top: B:2:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0218 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() {
        /*
            Method dump skipped, instructions count: 812
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.v.run():void");
    }

    public v(Context context, int i10, int i11, byte[] bArr, String str, String str2, t tVar, int i12, int i13, boolean z10, Map<String, String> map) {
        this.f40213a = 2;
        this.f40214b = 30000;
        this.f40225m = null;
        this.f40228p = 0;
        this.f40229q = 0L;
        this.f40230r = 0L;
        this.f40231s = false;
        this.f40215c = context;
        this.f40218f = com.tencent.bugly.crashreport.common.info.a.a(context);
        this.f40217e = bArr;
        this.f40219g = com.tencent.bugly.crashreport.common.strategy.a.a();
        this.f40220h = s.a(context);
        this.f40221i = u.a();
        this.f40222j = i10;
        this.f40225m = str;
        this.f40226n = str2;
        this.f40223k = tVar;
        this.f40224l = null;
        this.f40216d = i11;
        if (i12 > 0) {
            this.f40213a = i12;
        }
        if (i13 > 0) {
            this.f40214b = i13;
        }
        this.f40231s = z10;
        this.f40227o = map;
    }

    private static boolean a(an anVar, com.tencent.bugly.crashreport.common.info.a aVar, com.tencent.bugly.crashreport.common.strategy.a aVar2) {
        if (anVar == null) {
            x.d("resp == null!", new Object[0]);
            return false;
        }
        byte b4 = anVar.f40077a;
        if (b4 != 0) {
            x.e("resp result error %d", Byte.valueOf(b4));
            return false;
        }
        try {
            if (!z.a(anVar.f40081e) && !com.tencent.bugly.crashreport.common.info.a.b().j().equals(anVar.f40081e)) {
                p.a().a(com.tencent.bugly.crashreport.common.strategy.a.f39144a, com.alipay.sdk.packet.e.f4642n, anVar.f40081e.getBytes("UTF-8"), (o) null, true);
                aVar.f(anVar.f40081e);
            }
        } catch (Throwable th) {
            x.a(th);
        }
        aVar.f39101i = anVar.f40080d;
        int i10 = anVar.f40078b;
        if (i10 == 510) {
            byte[] bArr = anVar.f40079c;
            if (bArr == null) {
                x.e("[Upload] Strategy data is null. Response cmd: %d", Integer.valueOf(i10));
                return false;
            }
            ap apVar = (ap) a.a(bArr, ap.class);
            if (apVar == null) {
                x.e("[Upload] Failed to decode strategy from server. Response cmd: %d", Integer.valueOf(anVar.f40078b));
                return false;
            }
            aVar2.a(apVar);
        }
        return true;
    }

    public final void a(long j10) {
        this.f40228p++;
        this.f40229q += j10;
    }

    private static String a(String str) {
        if (z.a(str)) {
            return str;
        }
        try {
            return String.format("%s?aid=%s", str, UUID.randomUUID().toString());
        } catch (Throwable th) {
            x.a(th);
            return str;
        }
    }
}
