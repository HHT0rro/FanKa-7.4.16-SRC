package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class fn implements jb<fn, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with root package name */
    private static final a7 f47297a = new a7("StatsEvents");

    /* renamed from: a, reason: collision with other field name */
    private static final u6 f281a = new u6("", (byte) 11, 1);

    /* renamed from: b, reason: collision with root package name */
    private static final u6 f47298b = new u6("", (byte) 11, 2);

    /* renamed from: c, reason: collision with root package name */
    private static final u6 f47299c = new u6("", (byte) 15, 3);

    /* renamed from: a, reason: collision with other field name */
    public String f282a;

    /* renamed from: a, reason: collision with other field name */
    public List<fm> f283a;

    /* renamed from: b, reason: collision with other field name */
    public String f284b;

    public fn() {
    }

    public fn(String str, List<fm> list) {
        this();
        this.f282a = str;
        this.f283a = list;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(fn fnVar) {
        int g3;
        int e2;
        int e10;
        if (!getClass().equals(fnVar.getClass())) {
            return getClass().getName().compareTo(fnVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m2934a()).compareTo(Boolean.valueOf(fnVar.m2934a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m2934a() && (e10 = p6.e(this.f282a, fnVar.f282a)) != 0) {
            return e10;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(fnVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (e2 = p6.e(this.f284b, fnVar.f284b)) != 0) {
            return e2;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(fnVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (!c() || (g3 = p6.g(this.f283a, fnVar.f283a)) == 0) {
            return 0;
        }
        return g3;
    }

    public fn a(String str) {
        this.f284b = str;
        return this;
    }

    public void a() {
        if (this.f282a == null) {
            throw new jn("Required field 'uuid' was not present! Struct: " + toString());
        }
        if (this.f283a != null) {
            return;
        }
        throw new jn("Required field 'events' was not present! Struct: " + toString());
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
            short s2 = e2.f48411c;
            if (s2 == 1) {
                if (b4 == 11) {
                    this.f282a = x6Var.j();
                    x6Var.E();
                }
                y6.a(x6Var, b4);
                x6Var.E();
            } else if (s2 != 2) {
                if (s2 == 3 && b4 == 15) {
                    v6 f10 = x6Var.f();
                    this.f283a = new ArrayList(f10.f48448b);
                    for (int i10 = 0; i10 < f10.f48448b; i10++) {
                        fm fmVar = new fm();
                        fmVar.a(x6Var);
                        this.f283a.add(fmVar);
                    }
                    x6Var.G();
                    x6Var.E();
                }
                y6.a(x6Var, b4);
                x6Var.E();
            } else {
                if (b4 == 11) {
                    this.f284b = x6Var.j();
                    x6Var.E();
                }
                y6.a(x6Var, b4);
                x6Var.E();
            }
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m2934a() {
        return this.f282a != null;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m2935a(fn fnVar) {
        if (fnVar == null) {
            return false;
        }
        boolean m2934a = m2934a();
        boolean m2934a2 = fnVar.m2934a();
        if ((m2934a || m2934a2) && !(m2934a && m2934a2 && this.f282a.equals(fnVar.f282a))) {
            return false;
        }
        boolean b4 = b();
        boolean b10 = fnVar.b();
        if ((b4 || b10) && !(b4 && b10 && this.f284b.equals(fnVar.f284b))) {
            return false;
        }
        boolean c4 = c();
        boolean c10 = fnVar.c();
        if (c4 || c10) {
            return c4 && c10 && this.f283a.equals(fnVar.f283a);
        }
        return true;
    }

    @Override // com.xiaomi.push.jb
    public void b(x6 x6Var) {
        a();
        x6Var.t(f47297a);
        if (this.f282a != null) {
            x6Var.q(f281a);
            x6Var.u(this.f282a);
            x6Var.z();
        }
        if (this.f284b != null && b()) {
            x6Var.q(f47298b);
            x6Var.u(this.f284b);
            x6Var.z();
        }
        if (this.f283a != null) {
            x6Var.q(f47299c);
            x6Var.r(new v6((byte) 12, this.f283a.size()));
            Iterator<fm> iterator2 = this.f283a.iterator2();
            while (iterator2.hasNext()) {
                iterator2.next().b(x6Var);
            }
            x6Var.C();
            x6Var.z();
        }
        x6Var.A();
        x6Var.m();
    }

    public boolean b() {
        return this.f284b != null;
    }

    public boolean c() {
        return this.f283a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof fn)) {
            return m2935a((fn) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("StatsEvents(");
        sb2.append("uuid:");
        String str = this.f282a;
        if (str == null) {
            sb2.append("null");
        } else {
            sb2.append(str);
        }
        if (b()) {
            sb2.append(", ");
            sb2.append("operator:");
            String str2 = this.f284b;
            if (str2 == null) {
                sb2.append("null");
            } else {
                sb2.append(str2);
            }
        }
        sb2.append(", ");
        sb2.append("events:");
        List<fm> list = this.f283a;
        if (list == null) {
            sb2.append("null");
        } else {
            sb2.append((Object) list);
        }
        sb2.append(")");
        return sb2.toString();
    }
}
