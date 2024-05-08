package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class in implements jb<in, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with root package name */
    private static final a7 f47669a = new a7("XmPushActionCustomConfig");

    /* renamed from: a, reason: collision with other field name */
    private static final u6 f458a = new u6("", (byte) 15, 1);

    /* renamed from: a, reason: collision with other field name */
    public List<ib> f459a;

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(in inVar) {
        int g3;
        if (!getClass().equals(inVar.getClass())) {
            return getClass().getName().compareTo(inVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m3012a()).compareTo(Boolean.valueOf(inVar.m3012a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (!m3012a() || (g3 = p6.g(this.f459a, inVar.f459a)) == 0) {
            return 0;
        }
        return g3;
    }

    public List<ib> a() {
        return this.f459a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m3011a() {
        if (this.f459a != null) {
            return;
        }
        throw new jn("Required field 'customConfigs' was not present! Struct: " + toString());
    }

    @Override // com.xiaomi.push.jb
    public void a(x6 x6Var) {
        x6Var.i();
        while (true) {
            u6 e2 = x6Var.e();
            byte b4 = e2.f48410b;
            if (b4 == 0) {
                x6Var.D();
                m3011a();
                return;
            }
            if (e2.f48411c == 1 && b4 == 15) {
                v6 f10 = x6Var.f();
                this.f459a = new ArrayList(f10.f48448b);
                for (int i10 = 0; i10 < f10.f48448b; i10++) {
                    ib ibVar = new ib();
                    ibVar.a(x6Var);
                    this.f459a.add(ibVar);
                }
                x6Var.G();
            } else {
                y6.a(x6Var, b4);
            }
            x6Var.E();
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m3012a() {
        return this.f459a != null;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m3013a(in inVar) {
        if (inVar == null) {
            return false;
        }
        boolean m3012a = m3012a();
        boolean m3012a2 = inVar.m3012a();
        if (m3012a || m3012a2) {
            return m3012a && m3012a2 && this.f459a.equals(inVar.f459a);
        }
        return true;
    }

    @Override // com.xiaomi.push.jb
    public void b(x6 x6Var) {
        m3011a();
        x6Var.t(f47669a);
        if (this.f459a != null) {
            x6Var.q(f458a);
            x6Var.r(new v6((byte) 12, this.f459a.size()));
            Iterator<ib> iterator2 = this.f459a.iterator2();
            while (iterator2.hasNext()) {
                iterator2.next().b(x6Var);
            }
            x6Var.C();
            x6Var.z();
        }
        x6Var.A();
        x6Var.m();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof in)) {
            return m3013a((in) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("XmPushActionCustomConfig(");
        sb2.append("customConfigs:");
        List<ib> list = this.f459a;
        if (list == null) {
            sb2.append("null");
        } else {
            sb2.append((Object) list);
        }
        sb2.append(")");
        return sb2.toString();
    }
}
