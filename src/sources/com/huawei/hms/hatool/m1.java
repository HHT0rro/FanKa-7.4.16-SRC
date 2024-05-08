package com.huawei.hms.hatool;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class m1 {

    /* renamed from: b, reason: collision with root package name */
    private static m1 f30178b = new m1();

    /* renamed from: a, reason: collision with root package name */
    private a f30179a = new a();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        public String f30180a;

        /* renamed from: b, reason: collision with root package name */
        public String f30181b;

        /* renamed from: c, reason: collision with root package name */
        public long f30182c = 0;

        public a() {
        }

        public void a(long j10) {
            m1.this.f30179a.f30182c = j10;
        }

        public void a(String str) {
            m1.this.f30179a.f30181b = str;
        }

        public void b(String str) {
            m1.this.f30179a.f30180a = str;
        }
    }

    public static m1 d() {
        return f30178b;
    }

    public String a() {
        return this.f30179a.f30181b;
    }

    public void a(String str, String str2) {
        long b4 = b();
        String c4 = w0.c(str, str2);
        if (c4 == null || c4.isEmpty()) {
            v.e("WorkKeyHandler", "get rsa pubkey config error");
            return;
        }
        if (b4 == 0) {
            b4 = System.currentTimeMillis();
        } else if (System.currentTimeMillis() - b4 <= 43200000) {
            return;
        }
        String d10 = va.b.d(16);
        String a10 = h0.a(c4, d10);
        this.f30179a.a(b4);
        this.f30179a.b(d10);
        this.f30179a.a(a10);
    }

    public long b() {
        return this.f30179a.f30182c;
    }

    public String c() {
        return this.f30179a.f30180a;
    }
}
