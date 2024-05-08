package com.huawei.hms.scankit.p;

/* compiled from: BoundingBox.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
final class a0 {

    /* renamed from: a, reason: collision with root package name */
    private final s f30677a;

    /* renamed from: b, reason: collision with root package name */
    private final u6 f30678b;

    /* renamed from: c, reason: collision with root package name */
    private final u6 f30679c;

    /* renamed from: d, reason: collision with root package name */
    private final u6 f30680d;

    /* renamed from: e, reason: collision with root package name */
    private final u6 f30681e;

    /* renamed from: f, reason: collision with root package name */
    private final int f30682f;

    /* renamed from: g, reason: collision with root package name */
    private final int f30683g;

    /* renamed from: h, reason: collision with root package name */
    private final int f30684h;

    /* renamed from: i, reason: collision with root package name */
    private final int f30685i;

    public a0(s sVar, u6 u6Var, u6 u6Var2, u6 u6Var3, u6 u6Var4) throws a {
        boolean z10 = u6Var == null || u6Var2 == null;
        boolean z11 = u6Var3 == null || u6Var4 == null;
        if (z10 && z11) {
            throw a.a();
        }
        if (z10) {
            u6Var = new u6(0.0f, u6Var3.c());
            u6Var2 = new u6(0.0f, u6Var4.c());
        } else if (z11) {
            u6Var3 = new u6(sVar.e() - 1, u6Var.c());
            u6Var4 = new u6(sVar.e() - 1, u6Var2.c());
        }
        this.f30677a = sVar;
        this.f30678b = u6Var;
        this.f30679c = u6Var2;
        this.f30680d = u6Var3;
        this.f30681e = u6Var4;
        this.f30682f = (int) Math.min(u6Var.b(), u6Var2.b());
        this.f30683g = (int) Math.max(u6Var3.b(), u6Var4.b());
        this.f30684h = (int) Math.min(u6Var.c(), u6Var3.c());
        this.f30685i = (int) Math.max(u6Var2.c(), u6Var4.c());
    }

    public static a0 a(a0 a0Var, a0 a0Var2) throws a {
        return a0Var == null ? a0Var2 : a0Var2 == null ? a0Var : new a0(a0Var.f30677a, a0Var.f30678b, a0Var.f30679c, a0Var2.f30680d, a0Var2.f30681e);
    }

    public u6 b() {
        return this.f30681e;
    }

    public int c() {
        return this.f30683g;
    }

    public int d() {
        return this.f30685i;
    }

    public int e() {
        return this.f30682f;
    }

    public int f() {
        return this.f30684h;
    }

    public u6 g() {
        return this.f30678b;
    }

    public u6 h() {
        return this.f30680d;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.huawei.hms.scankit.p.a0 a(int r13, int r14, boolean r15) throws com.huawei.hms.scankit.p.a {
        /*
            r12 = this;
            com.huawei.hms.scankit.p.u6 r0 = r12.f30678b
            com.huawei.hms.scankit.p.u6 r1 = r12.f30679c
            com.huawei.hms.scankit.p.u6 r2 = r12.f30680d
            com.huawei.hms.scankit.p.u6 r3 = r12.f30681e
            if (r13 <= 0) goto L29
            if (r15 == 0) goto Le
            r4 = r0
            goto Lf
        Le:
            r4 = r2
        Lf:
            float r5 = r4.c()
            int r5 = (int) r5
            int r5 = r5 - r13
            if (r5 >= 0) goto L18
            r5 = 0
        L18:
            com.huawei.hms.scankit.p.u6 r13 = new com.huawei.hms.scankit.p.u6
            float r4 = r4.b()
            float r5 = (float) r5
            r13.<init>(r4, r5)
            if (r15 == 0) goto L26
            r8 = r13
            goto L2a
        L26:
            r10 = r13
            r8 = r0
            goto L2b
        L29:
            r8 = r0
        L2a:
            r10 = r2
        L2b:
            if (r14 <= 0) goto L5b
            if (r15 == 0) goto L32
            com.huawei.hms.scankit.p.u6 r13 = r12.f30679c
            goto L34
        L32:
            com.huawei.hms.scankit.p.u6 r13 = r12.f30681e
        L34:
            float r0 = r13.c()
            int r0 = (int) r0
            int r0 = r0 + r14
            com.huawei.hms.scankit.p.s r14 = r12.f30677a
            int r14 = r14.c()
            if (r0 < r14) goto L4a
            com.huawei.hms.scankit.p.s r14 = r12.f30677a
            int r14 = r14.c()
            int r0 = r14 + (-1)
        L4a:
            com.huawei.hms.scankit.p.u6 r14 = new com.huawei.hms.scankit.p.u6
            float r13 = r13.b()
            float r0 = (float) r0
            r14.<init>(r13, r0)
            if (r15 == 0) goto L58
            r9 = r14
            goto L5c
        L58:
            r11 = r14
            r9 = r1
            goto L5d
        L5b:
            r9 = r1
        L5c:
            r11 = r3
        L5d:
            com.huawei.hms.scankit.p.a0 r13 = new com.huawei.hms.scankit.p.a0
            com.huawei.hms.scankit.p.s r7 = r12.f30677a
            r6 = r13
            r6.<init>(r7, r8, r9, r10, r11)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.a0.a(int, int, boolean):com.huawei.hms.scankit.p.a0");
    }

    public u6 a() {
        return this.f30679c;
    }

    public a0(a0 a0Var) {
        this.f30677a = a0Var.f30677a;
        this.f30678b = a0Var.g();
        this.f30679c = a0Var.a();
        this.f30680d = a0Var.h();
        this.f30681e = a0Var.b();
        this.f30682f = a0Var.e();
        this.f30683g = a0Var.c();
        this.f30684h = a0Var.f();
        this.f30685i = a0Var.d();
    }
}
