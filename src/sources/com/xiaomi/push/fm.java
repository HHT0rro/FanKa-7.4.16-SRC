package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class fm implements jb<fm, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with root package name */
    private static final a7 f47287a = new a7("StatsEvent");

    /* renamed from: a, reason: collision with other field name */
    private static final u6 f269a = new u6("", (byte) 3, 1);

    /* renamed from: b, reason: collision with root package name */
    private static final u6 f47288b = new u6("", (byte) 8, 2);

    /* renamed from: c, reason: collision with root package name */
    private static final u6 f47289c = new u6("", (byte) 8, 3);

    /* renamed from: d, reason: collision with root package name */
    private static final u6 f47290d = new u6("", (byte) 11, 4);

    /* renamed from: e, reason: collision with root package name */
    private static final u6 f47291e = new u6("", (byte) 11, 5);

    /* renamed from: f, reason: collision with root package name */
    private static final u6 f47292f = new u6("", (byte) 8, 6);

    /* renamed from: g, reason: collision with root package name */
    private static final u6 f47293g = new u6("", (byte) 11, 7);

    /* renamed from: h, reason: collision with root package name */
    private static final u6 f47294h = new u6("", (byte) 11, 8);

    /* renamed from: i, reason: collision with root package name */
    private static final u6 f47295i = new u6("", (byte) 8, 9);

    /* renamed from: j, reason: collision with root package name */
    private static final u6 f47296j = new u6("", (byte) 8, 10);

    /* renamed from: a, reason: collision with other field name */
    public byte f270a;

    /* renamed from: a, reason: collision with other field name */
    public int f271a;

    /* renamed from: a, reason: collision with other field name */
    public String f272a;

    /* renamed from: a, reason: collision with other field name */
    private BitSet f273a = new BitSet(6);

    /* renamed from: b, reason: collision with other field name */
    public int f274b;

    /* renamed from: b, reason: collision with other field name */
    public String f275b;

    /* renamed from: c, reason: collision with other field name */
    public int f276c;

    /* renamed from: c, reason: collision with other field name */
    public String f277c;

    /* renamed from: d, reason: collision with other field name */
    public int f278d;

    /* renamed from: d, reason: collision with other field name */
    public String f279d;

    /* renamed from: e, reason: collision with other field name */
    public int f280e;

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(fm fmVar) {
        int b4;
        int b10;
        int e2;
        int e10;
        int b11;
        int e11;
        int e12;
        int b12;
        int b13;
        int a10;
        if (!getClass().equals(fmVar.getClass())) {
            return getClass().getName().compareTo(fmVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m2932a()).compareTo(Boolean.valueOf(fmVar.m2932a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m2932a() && (a10 = p6.a(this.f270a, fmVar.f270a)) != 0) {
            return a10;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(fmVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (b13 = p6.b(this.f271a, fmVar.f271a)) != 0) {
            return b13;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(fmVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (b12 = p6.b(this.f274b, fmVar.f274b)) != 0) {
            return b12;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(fmVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (e12 = p6.e(this.f272a, fmVar.f272a)) != 0) {
            return e12;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(fmVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (e11 = p6.e(this.f275b, fmVar.f275b)) != 0) {
            return e11;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(fmVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (b11 = p6.b(this.f276c, fmVar.f276c)) != 0) {
            return b11;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(fmVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (e10 = p6.e(this.f277c, fmVar.f277c)) != 0) {
            return e10;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(fmVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (e2 = p6.e(this.f279d, fmVar.f279d)) != 0) {
            return e2;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(fmVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i() && (b10 = p6.b(this.f278d, fmVar.f278d)) != 0) {
            return b10;
        }
        int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(fmVar.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (!j() || (b4 = p6.b(this.f280e, fmVar.f280e)) == 0) {
            return 0;
        }
        return b4;
    }

    public fm a(byte b4) {
        this.f270a = b4;
        a(true);
        return this;
    }

    public fm a(int i10) {
        this.f271a = i10;
        b(true);
        return this;
    }

    public fm a(String str) {
        this.f272a = str;
        return this;
    }

    public void a() {
        if (this.f272a != null) {
            return;
        }
        throw new jn("Required field 'connpt' was not present! Struct: " + toString());
    }

    @Override // com.xiaomi.push.jb
    public void a(x6 x6Var) {
        x6Var.i();
        while (true) {
            u6 e2 = x6Var.e();
            byte b4 = e2.f48410b;
            if (b4 == 0) {
                x6Var.D();
                if (!m2932a()) {
                    throw new jn("Required field 'chid' was not found in serialized data! Struct: " + toString());
                }
                if (!b()) {
                    throw new jn("Required field 'type' was not found in serialized data! Struct: " + toString());
                }
                if (c()) {
                    a();
                    return;
                }
                throw new jn("Required field 'value' was not found in serialized data! Struct: " + toString());
            }
            switch (e2.f48411c) {
                case 1:
                    if (b4 == 3) {
                        this.f270a = x6Var.a();
                        a(true);
                        break;
                    }
                    break;
                case 2:
                    if (b4 == 8) {
                        this.f271a = x6Var.c();
                        b(true);
                        continue;
                    }
                    break;
                case 3:
                    if (b4 == 8) {
                        this.f274b = x6Var.c();
                        c(true);
                        continue;
                    }
                    break;
                case 4:
                    if (b4 == 11) {
                        this.f272a = x6Var.j();
                        continue;
                    }
                    break;
                case 5:
                    if (b4 == 11) {
                        this.f275b = x6Var.j();
                        continue;
                    }
                    break;
                case 6:
                    if (b4 == 8) {
                        this.f276c = x6Var.c();
                        d(true);
                        continue;
                    }
                    break;
                case 7:
                    if (b4 == 11) {
                        this.f277c = x6Var.j();
                        continue;
                    }
                    break;
                case 8:
                    if (b4 == 11) {
                        this.f279d = x6Var.j();
                        continue;
                    }
                    break;
                case 9:
                    if (b4 == 8) {
                        this.f278d = x6Var.c();
                        e(true);
                        continue;
                    }
                    break;
                case 10:
                    if (b4 == 8) {
                        this.f280e = x6Var.c();
                        f(true);
                        continue;
                    }
                    break;
            }
            y6.a(x6Var, b4);
            x6Var.E();
        }
    }

    public void a(boolean z10) {
        this.f273a.set(0, z10);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m2932a() {
        return this.f273a.get(0);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m2933a(fm fmVar) {
        if (fmVar == null || this.f270a != fmVar.f270a || this.f271a != fmVar.f271a || this.f274b != fmVar.f274b) {
            return false;
        }
        boolean d10 = d();
        boolean d11 = fmVar.d();
        if ((d10 || d11) && !(d10 && d11 && this.f272a.equals(fmVar.f272a))) {
            return false;
        }
        boolean e2 = e();
        boolean e10 = fmVar.e();
        if ((e2 || e10) && !(e2 && e10 && this.f275b.equals(fmVar.f275b))) {
            return false;
        }
        boolean f10 = f();
        boolean f11 = fmVar.f();
        if ((f10 || f11) && !(f10 && f11 && this.f276c == fmVar.f276c)) {
            return false;
        }
        boolean g3 = g();
        boolean g10 = fmVar.g();
        if ((g3 || g10) && !(g3 && g10 && this.f277c.equals(fmVar.f277c))) {
            return false;
        }
        boolean h10 = h();
        boolean h11 = fmVar.h();
        if ((h10 || h11) && !(h10 && h11 && this.f279d.equals(fmVar.f279d))) {
            return false;
        }
        boolean i10 = i();
        boolean i11 = fmVar.i();
        if ((i10 || i11) && !(i10 && i11 && this.f278d == fmVar.f278d)) {
            return false;
        }
        boolean j10 = j();
        boolean j11 = fmVar.j();
        if (j10 || j11) {
            return j10 && j11 && this.f280e == fmVar.f280e;
        }
        return true;
    }

    public fm b(int i10) {
        this.f274b = i10;
        c(true);
        return this;
    }

    public fm b(String str) {
        this.f275b = str;
        return this;
    }

    @Override // com.xiaomi.push.jb
    public void b(x6 x6Var) {
        a();
        x6Var.t(f47287a);
        x6Var.q(f269a);
        x6Var.n(this.f270a);
        x6Var.z();
        x6Var.q(f47288b);
        x6Var.o(this.f271a);
        x6Var.z();
        x6Var.q(f47289c);
        x6Var.o(this.f274b);
        x6Var.z();
        if (this.f272a != null) {
            x6Var.q(f47290d);
            x6Var.u(this.f272a);
            x6Var.z();
        }
        if (this.f275b != null && e()) {
            x6Var.q(f47291e);
            x6Var.u(this.f275b);
            x6Var.z();
        }
        if (f()) {
            x6Var.q(f47292f);
            x6Var.o(this.f276c);
            x6Var.z();
        }
        if (this.f277c != null && g()) {
            x6Var.q(f47293g);
            x6Var.u(this.f277c);
            x6Var.z();
        }
        if (this.f279d != null && h()) {
            x6Var.q(f47294h);
            x6Var.u(this.f279d);
            x6Var.z();
        }
        if (i()) {
            x6Var.q(f47295i);
            x6Var.o(this.f278d);
            x6Var.z();
        }
        if (j()) {
            x6Var.q(f47296j);
            x6Var.o(this.f280e);
            x6Var.z();
        }
        x6Var.A();
        x6Var.m();
    }

    public void b(boolean z10) {
        this.f273a.set(1, z10);
    }

    public boolean b() {
        return this.f273a.get(1);
    }

    public fm c(int i10) {
        this.f276c = i10;
        d(true);
        return this;
    }

    public fm c(String str) {
        this.f277c = str;
        return this;
    }

    public void c(boolean z10) {
        this.f273a.set(2, z10);
    }

    public boolean c() {
        return this.f273a.get(2);
    }

    public fm d(int i10) {
        this.f278d = i10;
        e(true);
        return this;
    }

    public fm d(String str) {
        this.f279d = str;
        return this;
    }

    public void d(boolean z10) {
        this.f273a.set(3, z10);
    }

    public boolean d() {
        return this.f272a != null;
    }

    public void e(boolean z10) {
        this.f273a.set(4, z10);
    }

    public boolean e() {
        return this.f275b != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof fm)) {
            return m2933a((fm) obj);
        }
        return false;
    }

    public void f(boolean z10) {
        this.f273a.set(5, z10);
    }

    public boolean f() {
        return this.f273a.get(3);
    }

    public boolean g() {
        return this.f277c != null;
    }

    public boolean h() {
        return this.f279d != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f273a.get(4);
    }

    public boolean j() {
        return this.f273a.get(5);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("StatsEvent(");
        sb2.append("chid:");
        sb2.append((int) this.f270a);
        sb2.append(", ");
        sb2.append("type:");
        sb2.append(this.f271a);
        sb2.append(", ");
        sb2.append("value:");
        sb2.append(this.f274b);
        sb2.append(", ");
        sb2.append("connpt:");
        String str = this.f272a;
        if (str == null) {
            sb2.append("null");
        } else {
            sb2.append(str);
        }
        if (e()) {
            sb2.append(", ");
            sb2.append("host:");
            String str2 = this.f275b;
            if (str2 == null) {
                sb2.append("null");
            } else {
                sb2.append(str2);
            }
        }
        if (f()) {
            sb2.append(", ");
            sb2.append("subvalue:");
            sb2.append(this.f276c);
        }
        if (g()) {
            sb2.append(", ");
            sb2.append("annotation:");
            String str3 = this.f277c;
            if (str3 == null) {
                sb2.append("null");
            } else {
                sb2.append(str3);
            }
        }
        if (h()) {
            sb2.append(", ");
            sb2.append("user:");
            String str4 = this.f279d;
            if (str4 == null) {
                sb2.append("null");
            } else {
                sb2.append(str4);
            }
        }
        if (i()) {
            sb2.append(", ");
            sb2.append("time:");
            sb2.append(this.f278d);
        }
        if (j()) {
            sb2.append(", ");
            sb2.append("clientIp:");
            sb2.append(this.f280e);
        }
        sb2.append(")");
        return sb2.toString();
    }
}
