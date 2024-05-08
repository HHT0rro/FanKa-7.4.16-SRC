package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class hz implements jb<hz, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with root package name */
    private static final a7 f47499a = new a7("NormalConfig");

    /* renamed from: a, reason: collision with other field name */
    private static final u6 f323a = new u6("", (byte) 8, 1);

    /* renamed from: b, reason: collision with root package name */
    private static final u6 f47500b = new u6("", (byte) 15, 2);

    /* renamed from: c, reason: collision with root package name */
    private static final u6 f47501c = new u6("", (byte) 8, 3);

    /* renamed from: a, reason: collision with other field name */
    public int f324a;

    /* renamed from: a, reason: collision with other field name */
    public hw f325a;

    /* renamed from: a, reason: collision with other field name */
    private BitSet f326a = new BitSet(1);

    /* renamed from: a, reason: collision with other field name */
    public List<ib> f327a;

    public int a() {
        return this.f324a;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(hz hzVar) {
        int d10;
        int g3;
        int b4;
        if (!getClass().equals(hzVar.getClass())) {
            return getClass().getName().compareTo(hzVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m2953a()).compareTo(Boolean.valueOf(hzVar.m2953a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m2953a() && (b4 = p6.b(this.f324a, hzVar.f324a)) != 0) {
            return b4;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hzVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (g3 = p6.g(this.f327a, hzVar.f327a)) != 0) {
            return g3;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hzVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (!c() || (d10 = p6.d(this.f325a, hzVar.f325a)) == 0) {
            return 0;
        }
        return d10;
    }

    /* renamed from: a, reason: collision with other method in class */
    public hw m2951a() {
        return this.f325a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m2952a() {
        if (this.f327a != null) {
            return;
        }
        throw new jn("Required field 'configItems' was not present! Struct: " + toString());
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
                if (b4 == 8) {
                    this.f324a = x6Var.c();
                    a(true);
                    x6Var.E();
                }
                y6.a(x6Var, b4);
                x6Var.E();
            } else if (s2 != 2) {
                if (s2 == 3 && b4 == 8) {
                    this.f325a = hw.a(x6Var.c());
                    x6Var.E();
                }
                y6.a(x6Var, b4);
                x6Var.E();
            } else {
                if (b4 == 15) {
                    v6 f10 = x6Var.f();
                    this.f327a = new ArrayList(f10.f48448b);
                    for (int i10 = 0; i10 < f10.f48448b; i10++) {
                        ib ibVar = new ib();
                        ibVar.a(x6Var);
                        this.f327a.add(ibVar);
                    }
                    x6Var.G();
                    x6Var.E();
                }
                y6.a(x6Var, b4);
                x6Var.E();
            }
        }
        x6Var.D();
        if (m2953a()) {
            m2952a();
            return;
        }
        throw new jn("Required field 'version' was not found in serialized data! Struct: " + toString());
    }

    public void a(boolean z10) {
        this.f326a.set(0, z10);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m2953a() {
        return this.f326a.get(0);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m2954a(hz hzVar) {
        if (hzVar == null || this.f324a != hzVar.f324a) {
            return false;
        }
        boolean b4 = b();
        boolean b10 = hzVar.b();
        if ((b4 || b10) && !(b4 && b10 && this.f327a.equals(hzVar.f327a))) {
            return false;
        }
        boolean c4 = c();
        boolean c10 = hzVar.c();
        if (c4 || c10) {
            return c4 && c10 && this.f325a.equals(hzVar.f325a);
        }
        return true;
    }

    @Override // com.xiaomi.push.jb
    public void b(x6 x6Var) {
        m2952a();
        x6Var.t(f47499a);
        x6Var.q(f323a);
        x6Var.o(this.f324a);
        x6Var.z();
        if (this.f327a != null) {
            x6Var.q(f47500b);
            x6Var.r(new v6((byte) 12, this.f327a.size()));
            Iterator<ib> iterator2 = this.f327a.iterator2();
            while (iterator2.hasNext()) {
                iterator2.next().b(x6Var);
            }
            x6Var.C();
            x6Var.z();
        }
        if (this.f325a != null && c()) {
            x6Var.q(f47501c);
            x6Var.o(this.f325a.a());
            x6Var.z();
        }
        x6Var.A();
        x6Var.m();
    }

    public boolean b() {
        return this.f327a != null;
    }

    public boolean c() {
        return this.f325a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hz)) {
            return m2954a((hz) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("NormalConfig(");
        sb2.append("version:");
        sb2.append(this.f324a);
        sb2.append(", ");
        sb2.append("configItems:");
        List<ib> list = this.f327a;
        if (list == null) {
            sb2.append("null");
        } else {
            sb2.append((Object) list);
        }
        if (c()) {
            sb2.append(", ");
            sb2.append("type:");
            hw hwVar = this.f325a;
            if (hwVar == null) {
                sb2.append("null");
            } else {
                sb2.append((Object) hwVar);
            }
        }
        sb2.append(")");
        return sb2.toString();
    }
}
