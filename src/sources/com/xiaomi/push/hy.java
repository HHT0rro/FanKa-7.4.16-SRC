package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class hy implements jb<hy, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with root package name */
    private static final a7 f47496a = new a7("DataCollectionItem");

    /* renamed from: a, reason: collision with other field name */
    private static final u6 f318a = new u6("", (byte) 10, 1);

    /* renamed from: b, reason: collision with root package name */
    private static final u6 f47497b = new u6("", (byte) 8, 2);

    /* renamed from: c, reason: collision with root package name */
    private static final u6 f47498c = new u6("", (byte) 11, 3);

    /* renamed from: a, reason: collision with other field name */
    public long f319a;

    /* renamed from: a, reason: collision with other field name */
    public hs f320a;

    /* renamed from: a, reason: collision with other field name */
    public String f321a;

    /* renamed from: a, reason: collision with other field name */
    private BitSet f322a = new BitSet(1);

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(hy hyVar) {
        int e2;
        int d10;
        int c4;
        if (!getClass().equals(hyVar.getClass())) {
            return getClass().getName().compareTo(hyVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m2949a()).compareTo(Boolean.valueOf(hyVar.m2949a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m2949a() && (c4 = p6.c(this.f319a, hyVar.f319a)) != 0) {
            return c4;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hyVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (d10 = p6.d(this.f320a, hyVar.f320a)) != 0) {
            return d10;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hyVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (!c() || (e2 = p6.e(this.f321a, hyVar.f321a)) == 0) {
            return 0;
        }
        return e2;
    }

    public hy a(long j10) {
        this.f319a = j10;
        a(true);
        return this;
    }

    public hy a(hs hsVar) {
        this.f320a = hsVar;
        return this;
    }

    public hy a(String str) {
        this.f321a = str;
        return this;
    }

    public String a() {
        return this.f321a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m2948a() {
        if (this.f320a == null) {
            throw new jn("Required field 'collectionType' was not present! Struct: " + toString());
        }
        if (this.f321a != null) {
            return;
        }
        throw new jn("Required field 'content' was not present! Struct: " + toString());
    }

    @Override // com.xiaomi.push.jb
    public void a(x6 x6Var) {
        x6Var.i();
        while (true) {
            u6 e2 = x6Var.e();
            byte b4 = e2.f48410b;
            if (b4 == 0) {
                break;
            }
            short s2 = e2.f48411c;
            if (s2 == 1) {
                if (b4 == 10) {
                    this.f319a = x6Var.d();
                    a(true);
                    x6Var.E();
                }
                y6.a(x6Var, b4);
                x6Var.E();
            } else if (s2 != 2) {
                if (s2 == 3 && b4 == 11) {
                    this.f321a = x6Var.j();
                    x6Var.E();
                }
                y6.a(x6Var, b4);
                x6Var.E();
            } else {
                if (b4 == 8) {
                    this.f320a = hs.a(x6Var.c());
                    x6Var.E();
                }
                y6.a(x6Var, b4);
                x6Var.E();
            }
        }
        x6Var.D();
        if (m2949a()) {
            m2948a();
            return;
        }
        throw new jn("Required field 'collectedAt' was not found in serialized data! Struct: " + toString());
    }

    public void a(boolean z10) {
        this.f322a.set(0, z10);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m2949a() {
        return this.f322a.get(0);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m2950a(hy hyVar) {
        if (hyVar == null || this.f319a != hyVar.f319a) {
            return false;
        }
        boolean b4 = b();
        boolean b10 = hyVar.b();
        if ((b4 || b10) && !(b4 && b10 && this.f320a.equals(hyVar.f320a))) {
            return false;
        }
        boolean c4 = c();
        boolean c10 = hyVar.c();
        if (c4 || c10) {
            return c4 && c10 && this.f321a.equals(hyVar.f321a);
        }
        return true;
    }

    @Override // com.xiaomi.push.jb
    public void b(x6 x6Var) {
        m2948a();
        x6Var.t(f47496a);
        x6Var.q(f318a);
        x6Var.p(this.f319a);
        x6Var.z();
        if (this.f320a != null) {
            x6Var.q(f47497b);
            x6Var.o(this.f320a.a());
            x6Var.z();
        }
        if (this.f321a != null) {
            x6Var.q(f47498c);
            x6Var.u(this.f321a);
            x6Var.z();
        }
        x6Var.A();
        x6Var.m();
    }

    public boolean b() {
        return this.f320a != null;
    }

    public boolean c() {
        return this.f321a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hy)) {
            return m2950a((hy) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("DataCollectionItem(");
        sb2.append("collectedAt:");
        sb2.append(this.f319a);
        sb2.append(", ");
        sb2.append("collectionType:");
        hs hsVar = this.f320a;
        if (hsVar == null) {
            sb2.append("null");
        } else {
            sb2.append((Object) hsVar);
        }
        sb2.append(", ");
        sb2.append("content:");
        String str = this.f321a;
        if (str == null) {
            sb2.append("null");
        } else {
            sb2.append(str);
        }
        sb2.append(")");
        return sb2.toString();
    }
}
