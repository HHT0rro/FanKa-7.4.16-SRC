package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class ii implements jb<ii, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with root package name */
    private static final a7 f47638a = new a7("XmPushActionCheckClientInfo");

    /* renamed from: a, reason: collision with other field name */
    private static final u6 f418a = new u6("", (byte) 8, 1);

    /* renamed from: b, reason: collision with root package name */
    private static final u6 f47639b = new u6("", (byte) 8, 2);

    /* renamed from: a, reason: collision with other field name */
    public int f419a;

    /* renamed from: a, reason: collision with other field name */
    private BitSet f420a = new BitSet(2);

    /* renamed from: b, reason: collision with other field name */
    public int f421b;

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(ii iiVar) {
        int b4;
        int b10;
        if (!getClass().equals(iiVar.getClass())) {
            return getClass().getName().compareTo(iiVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m2989a()).compareTo(Boolean.valueOf(iiVar.m2989a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m2989a() && (b10 = p6.b(this.f419a, iiVar.f419a)) != 0) {
            return b10;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(iiVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (!b() || (b4 = p6.b(this.f421b, iiVar.f421b)) == 0) {
            return 0;
        }
        return b4;
    }

    public ii a(int i10) {
        this.f419a = i10;
        a(true);
        return this;
    }

    public void a() {
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
            if (s2 != 1) {
                if (s2 == 2 && b4 == 8) {
                    this.f421b = x6Var.c();
                    b(true);
                    x6Var.E();
                }
                y6.a(x6Var, b4);
                x6Var.E();
            } else {
                if (b4 == 8) {
                    this.f419a = x6Var.c();
                    a(true);
                    x6Var.E();
                }
                y6.a(x6Var, b4);
                x6Var.E();
            }
        }
        x6Var.D();
        if (!m2989a()) {
            throw new jn("Required field 'miscConfigVersion' was not found in serialized data! Struct: " + toString());
        }
        if (b()) {
            a();
            return;
        }
        throw new jn("Required field 'pluginConfigVersion' was not found in serialized data! Struct: " + toString());
    }

    public void a(boolean z10) {
        this.f420a.set(0, z10);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m2989a() {
        return this.f420a.get(0);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m2990a(ii iiVar) {
        return iiVar != null && this.f419a == iiVar.f419a && this.f421b == iiVar.f421b;
    }

    public ii b(int i10) {
        this.f421b = i10;
        b(true);
        return this;
    }

    @Override // com.xiaomi.push.jb
    public void b(x6 x6Var) {
        a();
        x6Var.t(f47638a);
        x6Var.q(f418a);
        x6Var.o(this.f419a);
        x6Var.z();
        x6Var.q(f47639b);
        x6Var.o(this.f421b);
        x6Var.z();
        x6Var.A();
        x6Var.m();
    }

    public void b(boolean z10) {
        this.f420a.set(1, z10);
    }

    public boolean b() {
        return this.f420a.get(1);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ii)) {
            return m2990a((ii) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        return "XmPushActionCheckClientInfo(miscConfigVersion:" + this.f419a + ", pluginConfigVersion:" + this.f421b + ")";
    }
}
