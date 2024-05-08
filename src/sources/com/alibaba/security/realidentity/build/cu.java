package com.alibaba.security.realidentity.build;

import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: HttpdnsMini.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class cu {

    /* renamed from: a, reason: collision with root package name */
    private static final String f3362a = "HttpDnsMini";

    /* renamed from: b, reason: collision with root package name */
    private static final String f3363b = "203.107.1.1";

    /* renamed from: c, reason: collision with root package name */
    private static final String f3364c = "181345";

    /* renamed from: d, reason: collision with root package name */
    private static final int f3365d = 5;

    /* renamed from: e, reason: collision with root package name */
    private static final int f3366e = 10;

    /* renamed from: f, reason: collision with root package name */
    private static final int f3367f = 100;

    /* renamed from: g, reason: collision with root package name */
    private static final int f3368g = 30;

    /* renamed from: h, reason: collision with root package name */
    private static cu f3369h;

    /* renamed from: i, reason: collision with root package name */
    private ConcurrentMap<String, a> f3370i = new ConcurrentHashMap();

    /* renamed from: j, reason: collision with root package name */
    private ExecutorService f3371j = Executors.newFixedThreadPool(5);

    /* compiled from: HttpdnsMini.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        public String f3372a;

        /* renamed from: b, reason: collision with root package name */
        public String f3373b;

        /* renamed from: c, reason: collision with root package name */
        public long f3374c;

        /* renamed from: d, reason: collision with root package name */
        public long f3375d;

        public a() {
        }

        private void a(String str) {
            this.f3373b = str;
        }

        private void b(String str) {
            this.f3372a = str;
        }

        private String c() {
            return this.f3373b;
        }

        private String d() {
            return this.f3372a;
        }

        private long e() {
            return this.f3374c;
        }

        private long f() {
            return this.f3375d;
        }

        public final String toString() {
            return "[hostName=" + this.f3372a + ", ip=" + this.f3373b + ", ttl=" + this.f3374c + ", queryTime=" + this.f3375d + "]";
        }

        private void a(long j10) {
            this.f3374c = j10;
        }

        private void b(long j10) {
            this.f3375d = j10;
        }

        private boolean a() {
            return this.f3375d + this.f3374c < System.currentTimeMillis() / 1000;
        }

        private boolean b() {
            return (this.f3375d + this.f3374c) + 600 > System.currentTimeMillis() / 1000;
        }
    }

    /* compiled from: HttpdnsMini.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class b implements Callable<String> {

        /* renamed from: b, reason: collision with root package name */
        private String f3378b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f3379c = false;

        public b(String str) {
            this.f3378b = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x0103, code lost:
        
            if (r0 == null) goto L26;
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x0105, code lost:
        
            r0.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x0109, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x010a, code lost:
        
            r0.printStackTrace();
         */
        /* JADX WARN: Removed duplicated region for block: B:10:0x0141 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:58:0x0146 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:9:0x013c A[LOOP:0: B:1:0x0000->B:9:0x013c, LOOP_END] */
        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.String call() {
            /*
                Method dump skipped, instructions count: 335
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.security.realidentity.build.cu.b.call():java.lang.String");
        }
    }

    private cu() {
    }

    public static cu a() {
        if (f3369h == null) {
            synchronized (cu.class) {
                if (f3369h == null) {
                    f3369h = new cu();
                }
            }
        }
        return f3369h;
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x001f, code lost:
    
        if ((r0.f3375d + r0.f3374c < java.lang.System.currentTimeMillis() / 1000) != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String a(java.lang.String r11) {
        /*
            r10 = this;
            java.util.concurrent.ConcurrentMap<java.lang.String, com.alibaba.security.realidentity.build.cu$a> r0 = r10.f3370i
            java.lang.Object r0 = r0.get(r11)
            com.alibaba.security.realidentity.build.cu$a r0 = (com.alibaba.security.realidentity.build.cu.a) r0
            r1 = 1
            r2 = 0
            r3 = 1000(0x3e8, double:4.94E-321)
            if (r0 == 0) goto L21
            long r5 = r0.f3375d
            long r7 = r0.f3374c
            long r5 = r5 + r7
            long r7 = java.lang.System.currentTimeMillis()
            long r7 = r7 / r3
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 >= 0) goto L1e
            r5 = 1
            goto L1f
        L1e:
            r5 = 0
        L1f:
            if (r5 == 0) goto L38
        L21:
            java.lang.String r5 = java.lang.String.valueOf(r11)
            java.lang.String r6 = "[httpdnsmini] - refresh host: "
            java.lang.String r5 = r6.concat(r5)
            com.alibaba.security.realidentity.build.cd.b(r5)
            java.util.concurrent.ExecutorService r5 = r10.f3371j
            com.alibaba.security.realidentity.build.cu$b r6 = new com.alibaba.security.realidentity.build.cu$b
            r6.<init>(r11)
            r5.submit(r6)
        L38:
            r11 = 0
            if (r0 == 0) goto L52
            long r5 = r0.f3375d
            long r7 = r0.f3374c
            long r5 = r5 + r7
            r7 = 600(0x258, double:2.964E-321)
            long r5 = r5 + r7
            long r7 = java.lang.System.currentTimeMillis()
            long r7 = r7 / r3
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r3 <= 0) goto L4d
            goto L4e
        L4d:
            r1 = 0
        L4e:
            if (r1 == 0) goto L52
            java.lang.String r11 = r0.f3373b
        L52:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.security.realidentity.build.cu.a(java.lang.String):java.lang.String");
    }
}
