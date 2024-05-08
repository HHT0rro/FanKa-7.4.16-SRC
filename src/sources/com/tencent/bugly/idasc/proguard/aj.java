package com.tencent.bugly.idasc.proguard;

import android.content.Context;
import android.util.Pair;
import java.util.Map;
import java.util.UUID;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class aj implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public int f39545a;

    /* renamed from: b, reason: collision with root package name */
    public long f39546b;

    /* renamed from: c, reason: collision with root package name */
    public long f39547c;

    /* renamed from: d, reason: collision with root package name */
    private int f39548d;

    /* renamed from: e, reason: collision with root package name */
    private int f39549e;

    /* renamed from: f, reason: collision with root package name */
    private final Context f39550f;

    /* renamed from: g, reason: collision with root package name */
    private final int f39551g;

    /* renamed from: h, reason: collision with root package name */
    private final byte[] f39552h;

    /* renamed from: i, reason: collision with root package name */
    private final aa f39553i;

    /* renamed from: j, reason: collision with root package name */
    private final ac f39554j;

    /* renamed from: k, reason: collision with root package name */
    private final af f39555k;

    /* renamed from: l, reason: collision with root package name */
    private final ai f39556l;

    /* renamed from: m, reason: collision with root package name */
    private final int f39557m;

    /* renamed from: n, reason: collision with root package name */
    private final ah f39558n;

    /* renamed from: o, reason: collision with root package name */
    private final ah f39559o;

    /* renamed from: p, reason: collision with root package name */
    private String f39560p;

    /* renamed from: q, reason: collision with root package name */
    private final String f39561q;

    /* renamed from: r, reason: collision with root package name */
    private final Map<String, String> f39562r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f39563s;

    public aj(Context context, int i10, int i11, byte[] bArr, String str, String str2, ah ahVar, int i12, int i13, boolean z10) {
        this.f39548d = 2;
        this.f39549e = 30000;
        this.f39560p = null;
        this.f39545a = 0;
        this.f39546b = 0L;
        this.f39547c = 0L;
        this.f39563s = false;
        this.f39550f = context;
        this.f39553i = aa.a(context);
        this.f39552h = bArr;
        this.f39554j = ac.a();
        if (af.f39510a == null) {
            af.f39510a = new af(context);
        }
        this.f39555k = af.f39510a;
        ai a10 = ai.a();
        this.f39556l = a10;
        this.f39557m = i10;
        this.f39560p = str;
        this.f39561q = str2;
        this.f39558n = ahVar;
        this.f39559o = a10.f39529a;
        this.f39551g = i11;
        if (i12 > 0) {
            this.f39548d = i12;
        }
        if (i13 > 0) {
            this.f39549e = i13;
        }
        this.f39563s = z10;
        this.f39562r = null;
    }

    public aj(Context context, int i10, int i11, byte[] bArr, String str, String str2, ah ahVar, boolean z10) {
        this(context, i10, i11, bArr, str, str2, ahVar, 2, 30000, z10);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00ba  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.util.Pair<java.lang.Boolean, java.lang.Boolean> a(java.util.Map<java.lang.String, java.lang.String> r8) {
        /*
            Method dump skipped, instructions count: 293
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.idasc.proguard.aj.a(java.util.Map):android.util.Pair");
    }

    private Pair<Boolean, Boolean> a(byte[] bArr, Map<String, String> map) {
        if (bArr == null) {
            a("Failed to upload for no response!");
            return new Pair<>(Boolean.FALSE, Boolean.TRUE);
        }
        al.c("[Upload] Received %d bytes", Integer.valueOf(bArr.length));
        if (bArr.length != 0) {
            Boolean bool = Boolean.TRUE;
            return new Pair<>(bool, bool);
        }
        a(false, 1, "response data from server is empty");
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                al.c("[Upload] HTTP headers from server: key = %s, value = %s", entry.getKey(), entry.getValue());
            }
        }
        Boolean bool2 = Boolean.FALSE;
        return new Pair<>(bool2, bool2);
    }

    private static void a(String str) {
        al.e("[Upload] Failed to upload(%d): %s", 1, str);
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
    private void a(boolean r5, int r6, java.lang.String r7) {
        /*
            r4 = this;
            int r0 = r4.f39551g
            r1 = 630(0x276, float:8.83E-43)
            if (r0 == r1) goto L1a
            r1 = 640(0x280, float:8.97E-43)
            if (r0 == r1) goto L17
            r1 = 830(0x33e, float:1.163E-42)
            if (r0 == r1) goto L1a
            r1 = 840(0x348, float:1.177E-42)
            if (r0 == r1) goto L17
            java.lang.String r0 = java.lang.String.valueOf(r0)
            goto L1c
        L17:
            java.lang.String r0 = "userinfo"
            goto L1c
        L1a:
            java.lang.String r0 = "crash"
        L1c:
            r1 = 1
            r2 = 0
            if (r5 == 0) goto L2a
            java.lang.Object[] r6 = new java.lang.Object[r1]
            r6[r2] = r0
            java.lang.String r0 = "[Upload] Success: %s"
            com.tencent.bugly.idasc.proguard.al.a(r0, r6)
            goto L3d
        L2a:
            r3 = 3
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r3[r2] = r6
            r3[r1] = r0
            r6 = 2
            r3[r6] = r7
            java.lang.String r6 = "[Upload] Failed to upload(%d) %s: %s"
            com.tencent.bugly.idasc.proguard.al.e(r6, r3)
        L3d:
            long r0 = r4.f39546b
            long r2 = r4.f39547c
            long r0 = r0 + r2
            r2 = 0
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 <= 0) goto L5d
            com.tencent.bugly.idasc.proguard.ai r6 = r4.f39556l
            boolean r0 = r4.f39563s
            long r0 = r6.a(r0)
            long r2 = r4.f39546b
            long r0 = r0 + r2
            long r2 = r4.f39547c
            long r0 = r0 + r2
            com.tencent.bugly.idasc.proguard.ai r6 = r4.f39556l
            boolean r2 = r4.f39563s
            r6.a(r0, r2)
        L5d:
            com.tencent.bugly.idasc.proguard.ah r6 = r4.f39558n
            if (r6 == 0) goto L64
            r6.a(r5, r7)
        L64:
            com.tencent.bugly.idasc.proguard.ah r6 = r4.f39559o
            if (r6 == 0) goto L6b
            r6.a(r5, r7)
        L6b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.idasc.proguard.aj.a(boolean, int, java.lang.String):void");
    }

    private static boolean a(br brVar, aa aaVar, ac acVar) {
        if (brVar == null) {
            al.d("resp == null!", new Object[0]);
            return false;
        }
        byte b4 = brVar.f39827a;
        if (b4 != 0) {
            al.e("resp result error %d", Byte.valueOf(b4));
            return false;
        }
        try {
            if (!ap.b(brVar.f39833g) && !aa.b().i().equals(brVar.f39833g)) {
                w.a().a(ac.f39500a, com.alipay.sdk.packet.e.f4642n, brVar.f39833g.getBytes("UTF-8"), true);
                aaVar.d(brVar.f39833g);
            }
        } catch (Throwable th) {
            al.a(th);
        }
        aaVar.f39483m = brVar.f39831e;
        int i10 = brVar.f39828b;
        if (i10 == 510) {
            byte[] bArr = brVar.f39829c;
            if (bArr == null) {
                al.e("[Upload] Strategy data is null. Response cmd: %d", Integer.valueOf(i10));
                return false;
            }
            bt btVar = (bt) ae.a(bArr, bt.class);
            if (btVar == null) {
                al.e("[Upload] Failed to decode strategy from server. Response cmd: %d", Integer.valueOf(brVar.f39828b));
                return false;
            }
            acVar.a(btVar);
        }
        return true;
    }

    private static String b(String str) {
        if (ap.b(str)) {
            return str;
        }
        try {
            return String.format("%s?aid=%s", str, UUID.randomUUID().toString());
        } catch (Throwable th) {
            al.a(th);
            return str;
        }
    }

    public final void a(long j10) {
        this.f39545a++;
        this.f39546b += j10;
    }

    public final void b(long j10) {
        this.f39547c += j10;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x01cd A[LOOP:0: B:18:0x00c6->B:29:0x01cd, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x01d1 A[SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() {
        /*
            Method dump skipped, instructions count: 483
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.idasc.proguard.aj.run():void");
    }
}
