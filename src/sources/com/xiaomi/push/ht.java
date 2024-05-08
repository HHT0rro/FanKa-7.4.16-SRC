package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class ht implements jb<ht, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with root package name */
    private static final a7 f47441a = new a7("ClientUploadData");

    /* renamed from: a, reason: collision with other field name */
    private static final u6 f297a = new u6("", (byte) 15, 1);

    /* renamed from: a, reason: collision with other field name */
    public List<hu> f298a;

    public int a() {
        List<hu> list = this.f298a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(ht htVar) {
        int g3;
        if (!getClass().equals(htVar.getClass())) {
            return getClass().getName().compareTo(htVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m2937a()).compareTo(Boolean.valueOf(htVar.m2937a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (!m2937a() || (g3 = p6.g(this.f298a, htVar.f298a)) == 0) {
            return 0;
        }
        return g3;
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m2936a() {
        if (this.f298a != null) {
            return;
        }
        throw new jn("Required field 'uploadDataItems' was not present! Struct: " + toString());
    }

    public void a(hu huVar) {
        if (this.f298a == null) {
            this.f298a = new ArrayList();
        }
        this.f298a.add(huVar);
    }

    @Override // com.xiaomi.push.jb
    public void a(x6 x6Var) {
        x6Var.i();
        while (true) {
            u6 e2 = x6Var.e();
            byte b4 = e2.f48410b;
            if (b4 == 0) {
                x6Var.D();
                m2936a();
                return;
            }
            if (e2.f48411c == 1 && b4 == 15) {
                v6 f10 = x6Var.f();
                this.f298a = new ArrayList(f10.f48448b);
                for (int i10 = 0; i10 < f10.f48448b; i10++) {
                    hu huVar = new hu();
                    huVar.a(x6Var);
                    this.f298a.add(huVar);
                }
                x6Var.G();
            } else {
                y6.a(x6Var, b4);
            }
            x6Var.E();
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m2937a() {
        return this.f298a != null;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m2938a(ht htVar) {
        if (htVar == null) {
            return false;
        }
        boolean m2937a = m2937a();
        boolean m2937a2 = htVar.m2937a();
        if (m2937a || m2937a2) {
            return m2937a && m2937a2 && this.f298a.equals(htVar.f298a);
        }
        return true;
    }

    @Override // com.xiaomi.push.jb
    public void b(x6 x6Var) {
        m2936a();
        x6Var.t(f47441a);
        if (this.f298a != null) {
            x6Var.q(f297a);
            x6Var.r(new v6((byte) 12, this.f298a.size()));
            Iterator<hu> iterator2 = this.f298a.iterator2();
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
        if (obj != null && (obj instanceof ht)) {
            return m2938a((ht) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("ClientUploadData(");
        sb2.append("uploadDataItems:");
        List<hu> list = this.f298a;
        if (list == null) {
            sb2.append("null");
        } else {
            sb2.append((Object) list);
        }
        sb2.append(")");
        return sb2.toString();
    }
}
