package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class ij implements jb<ij, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with root package name */
    private static final a7 f47640a = new a7("XmPushActionCollectData");

    /* renamed from: a, reason: collision with other field name */
    private static final u6 f422a = new u6("", (byte) 15, 1);

    /* renamed from: a, reason: collision with other field name */
    public List<hy> f423a;

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(ij ijVar) {
        int g3;
        if (!getClass().equals(ijVar.getClass())) {
            return getClass().getName().compareTo(ijVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m2991a()).compareTo(Boolean.valueOf(ijVar.m2991a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (!m2991a() || (g3 = p6.g(this.f423a, ijVar.f423a)) == 0) {
            return 0;
        }
        return g3;
    }

    public ij a(List<hy> list) {
        this.f423a = list;
        return this;
    }

    public void a() {
        if (this.f423a != null) {
            return;
        }
        throw new jn("Required field 'dataCollectionItems' was not present! Struct: " + toString());
    }

    @Override // com.xiaomi.push.jb
    public void a(x6 x6Var) {
        x6Var.i();
        while (true) {
            u6 e2 = x6Var.e();
            byte b4 = e2.f48410b;
            if (b4 == 0) {
                x6Var.D();
                a();
                return;
            }
            if (e2.f48411c == 1 && b4 == 15) {
                v6 f10 = x6Var.f();
                this.f423a = new ArrayList(f10.f48448b);
                for (int i10 = 0; i10 < f10.f48448b; i10++) {
                    hy hyVar = new hy();
                    hyVar.a(x6Var);
                    this.f423a.add(hyVar);
                }
                x6Var.G();
            } else {
                y6.a(x6Var, b4);
            }
            x6Var.E();
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m2991a() {
        return this.f423a != null;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m2992a(ij ijVar) {
        if (ijVar == null) {
            return false;
        }
        boolean m2991a = m2991a();
        boolean m2991a2 = ijVar.m2991a();
        if (m2991a || m2991a2) {
            return m2991a && m2991a2 && this.f423a.equals(ijVar.f423a);
        }
        return true;
    }

    @Override // com.xiaomi.push.jb
    public void b(x6 x6Var) {
        a();
        x6Var.t(f47640a);
        if (this.f423a != null) {
            x6Var.q(f422a);
            x6Var.r(new v6((byte) 12, this.f423a.size()));
            Iterator<hy> iterator2 = this.f423a.iterator2();
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
        if (obj != null && (obj instanceof ij)) {
            return m2992a((ij) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("XmPushActionCollectData(");
        sb2.append("dataCollectionItems:");
        List<hy> list = this.f423a;
        if (list == null) {
            sb2.append("null");
        } else {
            sb2.append((Object) list);
        }
        sb2.append(")");
        return sb2.toString();
    }
}
