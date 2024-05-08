package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* renamed from: com.xiaomi.push.if, reason: invalid class name */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class Cif implements jb<Cif, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with root package name */
    private static final a7 f47602a = new a7("Target");

    /* renamed from: a, reason: collision with other field name */
    private static final u6 f376a = new u6("", (byte) 10, 1);

    /* renamed from: b, reason: collision with root package name */
    private static final u6 f47603b = new u6("", (byte) 11, 2);

    /* renamed from: c, reason: collision with root package name */
    private static final u6 f47604c = new u6("", (byte) 11, 3);

    /* renamed from: d, reason: collision with root package name */
    private static final u6 f47605d = new u6("", (byte) 11, 4);

    /* renamed from: e, reason: collision with root package name */
    private static final u6 f47606e = new u6("", (byte) 2, 5);

    /* renamed from: f, reason: collision with root package name */
    private static final u6 f47607f = new u6("", (byte) 11, 7);

    /* renamed from: a, reason: collision with other field name */
    public String f378a;

    /* renamed from: d, reason: collision with other field name */
    public String f383d;

    /* renamed from: a, reason: collision with other field name */
    private BitSet f379a = new BitSet(2);

    /* renamed from: a, reason: collision with other field name */
    public long f377a = 5;

    /* renamed from: b, reason: collision with other field name */
    public String f381b = "xiaomi.com";

    /* renamed from: c, reason: collision with other field name */
    public String f382c = "";

    /* renamed from: a, reason: collision with other field name */
    public boolean f380a = false;

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(Cif cif) {
        int e2;
        int k10;
        int e10;
        int e11;
        int e12;
        int c4;
        if (!getClass().equals(cif.getClass())) {
            return getClass().getName().compareTo(cif.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m2981a()).compareTo(Boolean.valueOf(cif.m2981a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m2981a() && (c4 = p6.c(this.f377a, cif.f377a)) != 0) {
            return c4;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(cif.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (e12 = p6.e(this.f378a, cif.f378a)) != 0) {
            return e12;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(cif.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (e11 = p6.e(this.f381b, cif.f381b)) != 0) {
            return e11;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(cif.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (e10 = p6.e(this.f382c, cif.f382c)) != 0) {
            return e10;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(cif.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (k10 = p6.k(this.f380a, cif.f380a)) != 0) {
            return k10;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(cif.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (!f() || (e2 = p6.e(this.f383d, cif.f383d)) == 0) {
            return 0;
        }
        return e2;
    }

    public void a() {
        if (this.f378a != null) {
            return;
        }
        throw new jn("Required field 'userId' was not present! Struct: " + toString());
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
                    this.f377a = x6Var.d();
                    a(true);
                    x6Var.E();
                }
                y6.a(x6Var, b4);
                x6Var.E();
            } else if (s2 == 2) {
                if (b4 == 11) {
                    this.f378a = x6Var.j();
                    x6Var.E();
                }
                y6.a(x6Var, b4);
                x6Var.E();
            } else if (s2 == 3) {
                if (b4 == 11) {
                    this.f381b = x6Var.j();
                    x6Var.E();
                }
                y6.a(x6Var, b4);
                x6Var.E();
            } else if (s2 == 4) {
                if (b4 == 11) {
                    this.f382c = x6Var.j();
                    x6Var.E();
                }
                y6.a(x6Var, b4);
                x6Var.E();
            } else if (s2 != 5) {
                if (s2 == 7 && b4 == 11) {
                    this.f383d = x6Var.j();
                    x6Var.E();
                }
                y6.a(x6Var, b4);
                x6Var.E();
            } else {
                if (b4 == 2) {
                    this.f380a = x6Var.y();
                    b(true);
                    x6Var.E();
                }
                y6.a(x6Var, b4);
                x6Var.E();
            }
        }
        x6Var.D();
        if (m2981a()) {
            a();
            return;
        }
        throw new jn("Required field 'channelId' was not found in serialized data! Struct: " + toString());
    }

    public void a(boolean z10) {
        this.f379a.set(0, z10);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m2981a() {
        return this.f379a.get(0);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m2982a(Cif cif) {
        if (cif == null || this.f377a != cif.f377a) {
            return false;
        }
        boolean b4 = b();
        boolean b10 = cif.b();
        if ((b4 || b10) && !(b4 && b10 && this.f378a.equals(cif.f378a))) {
            return false;
        }
        boolean c4 = c();
        boolean c10 = cif.c();
        if ((c4 || c10) && !(c4 && c10 && this.f381b.equals(cif.f381b))) {
            return false;
        }
        boolean d10 = d();
        boolean d11 = cif.d();
        if ((d10 || d11) && !(d10 && d11 && this.f382c.equals(cif.f382c))) {
            return false;
        }
        boolean e2 = e();
        boolean e10 = cif.e();
        if ((e2 || e10) && !(e2 && e10 && this.f380a == cif.f380a)) {
            return false;
        }
        boolean f10 = f();
        boolean f11 = cif.f();
        if (f10 || f11) {
            return f10 && f11 && this.f383d.equals(cif.f383d);
        }
        return true;
    }

    @Override // com.xiaomi.push.jb
    public void b(x6 x6Var) {
        a();
        x6Var.t(f47602a);
        x6Var.q(f376a);
        x6Var.p(this.f377a);
        x6Var.z();
        if (this.f378a != null) {
            x6Var.q(f47603b);
            x6Var.u(this.f378a);
            x6Var.z();
        }
        if (this.f381b != null && c()) {
            x6Var.q(f47604c);
            x6Var.u(this.f381b);
            x6Var.z();
        }
        if (this.f382c != null && d()) {
            x6Var.q(f47605d);
            x6Var.u(this.f382c);
            x6Var.z();
        }
        if (e()) {
            x6Var.q(f47606e);
            x6Var.x(this.f380a);
            x6Var.z();
        }
        if (this.f383d != null && f()) {
            x6Var.q(f47607f);
            x6Var.u(this.f383d);
            x6Var.z();
        }
        x6Var.A();
        x6Var.m();
    }

    public void b(boolean z10) {
        this.f379a.set(1, z10);
    }

    public boolean b() {
        return this.f378a != null;
    }

    public boolean c() {
        return this.f381b != null;
    }

    public boolean d() {
        return this.f382c != null;
    }

    public boolean e() {
        return this.f379a.get(1);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof Cif)) {
            return m2982a((Cif) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f383d != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("Target(");
        sb2.append("channelId:");
        sb2.append(this.f377a);
        sb2.append(", ");
        sb2.append("userId:");
        String str = this.f378a;
        if (str == null) {
            sb2.append("null");
        } else {
            sb2.append(str);
        }
        if (c()) {
            sb2.append(", ");
            sb2.append("server:");
            String str2 = this.f381b;
            if (str2 == null) {
                sb2.append("null");
            } else {
                sb2.append(str2);
            }
        }
        if (d()) {
            sb2.append(", ");
            sb2.append("resource:");
            String str3 = this.f382c;
            if (str3 == null) {
                sb2.append("null");
            } else {
                sb2.append(str3);
            }
        }
        if (e()) {
            sb2.append(", ");
            sb2.append("isPreview:");
            sb2.append(this.f380a);
        }
        if (f()) {
            sb2.append(", ");
            sb2.append("token:");
            String str4 = this.f383d;
            if (str4 == null) {
                sb2.append("null");
            } else {
                sb2.append(str4);
            }
        }
        sb2.append(")");
        return sb2.toString();
    }
}
