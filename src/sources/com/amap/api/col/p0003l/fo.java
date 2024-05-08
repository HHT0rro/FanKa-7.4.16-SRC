package com.amap.api.col.p0003l;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;

/* compiled from: HttpsDecisionUtil.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class fo {

    /* renamed from: a, reason: collision with root package name */
    private volatile b f5896a = new b(0);

    /* renamed from: b, reason: collision with root package name */
    private hl f5897b = new hl("HttpsDecisionUtil");

    /* compiled from: HttpsDecisionUtil.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static fo f5898a = new fo();
    }

    public static fo a() {
        return a.f5898a;
    }

    private static boolean c() {
        return false;
    }

    public final boolean b() {
        if (this.f5896a == null) {
            this.f5896a = new b((byte) 0);
        }
        return this.f5896a.a();
    }

    /* compiled from: HttpsDecisionUtil.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public boolean f5899a;

        /* renamed from: b, reason: collision with root package name */
        private int f5900b;

        /* renamed from: c, reason: collision with root package name */
        private final boolean f5901c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f5902d;

        private b() {
            this.f5900b = 0;
            this.f5899a = true;
            this.f5901c = true;
            this.f5902d = false;
        }

        public final void a(Context context) {
            if (context != null && this.f5900b <= 0) {
                this.f5900b = context.getApplicationContext().getApplicationInfo().targetSdkVersion;
            }
        }

        public final void a(boolean z10) {
            this.f5899a = z10;
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x002e A[RETURN] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final boolean a() {
            /*
                r5 = this;
                boolean r0 = r5.f5902d
                r1 = 1
                if (r0 != 0) goto L2f
                int r0 = android.os.Build.VERSION.SDK_INT
                r2 = 28
                r3 = 0
                if (r0 < r2) goto Le
                r0 = 1
                goto Lf
            Le:
                r0 = 0
            Lf:
                boolean r4 = r5.f5899a
                if (r4 == 0) goto L23
                int r4 = r5.f5900b
                if (r4 > 0) goto L19
                r4 = 28
            L19:
                if (r4 < r2) goto L1d
                r2 = 1
                goto L1e
            L1d:
                r2 = 0
            L1e:
                if (r2 == 0) goto L21
                goto L23
            L21:
                r2 = 0
                goto L24
            L23:
                r2 = 1
            L24:
                if (r0 == 0) goto L2a
                if (r2 == 0) goto L2a
                r0 = 1
                goto L2b
            L2a:
                r0 = 0
            L2b:
                if (r0 == 0) goto L2e
                goto L2f
            L2e:
                return r3
            L2f:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.3l.fo.b.a():boolean");
        }

        public /* synthetic */ b(byte b4) {
            this();
        }
    }

    public final void a(Context context) {
        if (this.f5896a == null) {
            this.f5896a = new b((byte) 0);
        }
        this.f5896a.a(hl.a(context, "open_common", "a3", true));
        this.f5896a.a(context);
        gk.a(context).a();
    }

    private static void b(Context context, boolean z10) {
        SharedPreferences.Editor a10 = hl.a(context, "open_common");
        hl.a(a10, "a3", z10);
        hl.a(a10);
    }

    public static void b(Context context) {
        b(context, true);
    }

    public final void a(Context context, boolean z10) {
        if (this.f5896a == null) {
            this.f5896a = new b((byte) 0);
        }
        b(context, z10);
        this.f5896a.a(z10);
    }

    public static String a(String str) {
        Uri.Builder buildUpon;
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (!str.startsWith("https")) {
            try {
                buildUpon = Uri.parse(str).buildUpon();
                buildUpon.scheme("https");
            } catch (Throwable unused) {
                return str;
            }
        }
        return buildUpon.build().toString();
    }

    public final boolean a(boolean z10) {
        if (c()) {
            return false;
        }
        return z10 || b();
    }
}
