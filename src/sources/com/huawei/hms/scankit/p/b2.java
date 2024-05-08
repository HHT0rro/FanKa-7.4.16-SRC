package com.huawei.hms.scankit.p;

/* compiled from: DetectionResultRowIndicatorColumn.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
final class b2 extends a2 {

    /* renamed from: c, reason: collision with root package name */
    private final boolean f30729c;

    public b2(a0 a0Var, boolean z10) {
        super(a0Var);
        this.f30729c = z10;
    }

    private void b(k kVar) {
        a0 a10 = a();
        u6 g3 = this.f30729c ? a10.g() : a10.h();
        u6 a11 = this.f30729c ? a10.a() : a10.b();
        int c4 = c((int) a11.c());
        x0[] b4 = b();
        int i10 = -1;
        int i11 = 0;
        int i12 = 1;
        for (int c10 = c((int) g3.c()); c10 < c4; c10++) {
            if (b4[c10] != null) {
                x0 x0Var = b4[c10];
                x0Var.h();
                int c11 = x0Var.c() - i10;
                if (c11 == 0) {
                    i11++;
                } else {
                    if (c11 == 1) {
                        i12 = Math.max(i12, i11);
                        i10 = x0Var.c();
                    } else if (x0Var.c() >= kVar.c()) {
                        b4[c10] = null;
                    } else {
                        i10 = x0Var.c();
                    }
                    i11 = 1;
                }
            }
        }
    }

    private void f() {
        for (x0 x0Var : b()) {
            if (x0Var != null) {
                x0Var.h();
            }
        }
    }

    public void a(k kVar) throws a {
        x0[] b4 = b();
        f();
        a(b4, kVar);
        a0 a10 = a();
        u6 g3 = this.f30729c ? a10.g() : a10.h();
        u6 a11 = this.f30729c ? a10.a() : a10.b();
        int c4 = c((int) g3.c());
        int c10 = c((int) a11.c());
        int i10 = -1;
        int i11 = 0;
        int i12 = 1;
        while (c4 < c10) {
            if (b4[c4] != null) {
                x0 x0Var = b4[c4];
                int c11 = x0Var.c() - i10;
                if (c11 == 0) {
                    i11++;
                } else {
                    if (c11 == 1) {
                        i12 = Math.max(i12, i11);
                        i10 = x0Var.c();
                    } else if (c11 < 0 || x0Var.c() >= kVar.c() || c11 > c4) {
                        b4[c4] = null;
                    } else {
                        if (i12 > 2) {
                            c11 *= i12 - 2;
                        }
                        boolean z10 = c11 >= c4;
                        for (int i13 = 1; i13 <= c11 && !z10; i13++) {
                            z10 = b4[c4 - i13] != null;
                        }
                        if (z10) {
                            b4[c4] = null;
                        } else {
                            i10 = x0Var.c();
                        }
                    }
                    i11 = 1;
                }
            }
            c4++;
        }
    }

    public k c() throws a {
        x0[] b4 = b();
        m mVar = new m();
        m mVar2 = new m();
        m mVar3 = new m();
        m mVar4 = new m();
        for (x0 x0Var : b4) {
            if (x0Var != null) {
                x0Var.h();
                int e2 = x0Var.e() % 30;
                int c4 = x0Var.c();
                if (!this.f30729c) {
                    c4 += 2;
                }
                int i10 = c4 % 3;
                if (i10 == 0) {
                    mVar2.a((e2 * 3) + 1);
                } else if (i10 == 1) {
                    mVar4.a(e2 / 3);
                    mVar3.a(e2 % 3);
                } else if (i10 == 2) {
                    mVar.a(e2 + 1);
                } else {
                    throw a.a();
                }
            }
        }
        if (mVar.a().length == 0 || mVar2.a().length == 0 || mVar3.a().length == 0 || mVar4.a().length == 0 || mVar.a()[0] < 1 || mVar2.a()[0] + mVar3.a()[0] < 3 || mVar2.a()[0] + mVar3.a()[0] > 90) {
            return null;
        }
        k kVar = new k(mVar.a()[0], mVar2.a()[0], mVar3.a()[0], mVar4.a()[0]);
        a(b4, kVar);
        return kVar;
    }

    public int[] d() throws a {
        int c4;
        k c10 = c();
        if (c10 == null) {
            return null;
        }
        b(c10);
        int c11 = c10.c();
        int[] iArr = new int[c11];
        for (x0 x0Var : b()) {
            if (x0Var != null && (c4 = x0Var.c()) < c11) {
                iArr[c4] = iArr[c4] + 1;
            }
        }
        return iArr;
    }

    public boolean e() {
        return this.f30729c;
    }

    @Override // com.huawei.hms.scankit.p.a2
    public String toString() {
        return "IsLeft: " + this.f30729c + '\n' + super.toString();
    }

    private void a(x0[] x0VarArr, k kVar) throws a {
        for (int i10 = 0; i10 < x0VarArr.length; i10++) {
            x0 x0Var = x0VarArr[i10];
            if (x0VarArr[i10] != null) {
                int e2 = x0Var.e() % 30;
                int c4 = x0Var.c();
                if (c4 > kVar.c()) {
                    x0VarArr[i10] = null;
                } else {
                    if (!this.f30729c) {
                        c4 += 2;
                    }
                    int i11 = c4 % 3;
                    if (i11 != 0) {
                        if (i11 != 1) {
                            if (i11 == 2) {
                                if (e2 + 1 != kVar.a()) {
                                    x0VarArr[i10] = null;
                                }
                            } else {
                                throw a.a();
                            }
                        } else if (e2 / 3 != kVar.b() || e2 % 3 != kVar.d()) {
                            x0VarArr[i10] = null;
                        }
                    } else if ((e2 * 3) + 1 != kVar.e()) {
                        x0VarArr[i10] = null;
                    }
                }
            }
        }
    }
}
