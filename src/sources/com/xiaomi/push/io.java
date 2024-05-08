package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class io implements jb<io, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with root package name */
    private static final a7 f47670a = new a7("XmPushActionNormalConfig");

    /* renamed from: a, reason: collision with other field name */
    private static final u6 f460a = new u6("", (byte) 15, 1);

    /* renamed from: a, reason: collision with other field name */
    public List<hz> f461a;

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(io ioVar) {
        int g3;
        if (!getClass().equals(ioVar.getClass())) {
            return getClass().getName().compareTo(ioVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m3015a()).compareTo(Boolean.valueOf(ioVar.m3015a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (!m3015a() || (g3 = p6.g(this.f461a, ioVar.f461a)) == 0) {
            return 0;
        }
        return g3;
    }

    public List<hz> a() {
        return this.f461a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m3014a() {
        if (this.f461a != null) {
            return;
        }
        throw new jn("Required field 'normalConfigs' was not present! Struct: " + toString());
    }

    @Override // com.xiaomi.push.jb
    public void a(x6 x6Var) {
        x6Var.i();
        while (true) {
            u6 e2 = x6Var.e();
            byte b4 = e2.f48410b;
            if (b4 == 0) {
                x6Var.D();
                m3014a();
                return;
            }
            if (e2.f48411c == 1 && b4 == 15) {
                v6 f10 = x6Var.f();
                this.f461a = new ArrayList(f10.f48448b);
                for (int i10 = 0; i10 < f10.f48448b; i10++) {
                    hz hzVar = new hz();
                    hzVar.a(x6Var);
                    this.f461a.add(hzVar);
                }
                x6Var.G();
            } else {
                y6.a(x6Var, b4);
            }
            x6Var.E();
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m3015a() {
        return this.f461a != null;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m3016a(io ioVar) {
        if (ioVar == null) {
            return false;
        }
        boolean m3015a = m3015a();
        boolean m3015a2 = ioVar.m3015a();
        if (m3015a || m3015a2) {
            return m3015a && m3015a2 && this.f461a.equals(ioVar.f461a);
        }
        return true;
    }

    @Override // com.xiaomi.push.jb
    public void b(x6 x6Var) {
        m3014a();
        x6Var.t(f47670a);
        if (this.f461a != null) {
            x6Var.q(f460a);
            x6Var.r(new v6((byte) 12, this.f461a.size()));
            Iterator<hz> iterator2 = this.f461a.iterator2();
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
        if (obj != null && (obj instanceof io)) {
            return m3016a((io) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("XmPushActionNormalConfig(");
        sb2.append("normalConfigs:");
        List<hz> list = this.f461a;
        if (list == null) {
            sb2.append("null");
        } else {
            sb2.append((Object) list);
        }
        sb2.append(")");
        return sb2.toString();
    }
}
