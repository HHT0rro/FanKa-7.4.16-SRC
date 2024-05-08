package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class id implements jb<id, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with root package name */
    private static final a7 f47586a = new a7("PushMetaInfo");

    /* renamed from: a, reason: collision with other field name */
    private static final u6 f359a = new u6("", (byte) 11, 1);

    /* renamed from: b, reason: collision with root package name */
    private static final u6 f47587b = new u6("", (byte) 10, 2);

    /* renamed from: c, reason: collision with root package name */
    private static final u6 f47588c = new u6("", (byte) 11, 3);

    /* renamed from: d, reason: collision with root package name */
    private static final u6 f47589d = new u6("", (byte) 11, 4);

    /* renamed from: e, reason: collision with root package name */
    private static final u6 f47590e = new u6("", (byte) 11, 5);

    /* renamed from: f, reason: collision with root package name */
    private static final u6 f47591f = new u6("", (byte) 8, 6);

    /* renamed from: g, reason: collision with root package name */
    private static final u6 f47592g = new u6("", (byte) 11, 7);

    /* renamed from: h, reason: collision with root package name */
    private static final u6 f47593h = new u6("", (byte) 8, 8);

    /* renamed from: i, reason: collision with root package name */
    private static final u6 f47594i = new u6("", (byte) 8, 9);

    /* renamed from: j, reason: collision with root package name */
    private static final u6 f47595j = new u6("", (byte) 13, 10);

    /* renamed from: k, reason: collision with root package name */
    private static final u6 f47596k = new u6("", (byte) 13, 11);

    /* renamed from: l, reason: collision with root package name */
    private static final u6 f47597l = new u6("", (byte) 2, 12);

    /* renamed from: m, reason: collision with root package name */
    private static final u6 f47598m = new u6("", (byte) 13, 13);

    /* renamed from: a, reason: collision with other field name */
    public int f360a;

    /* renamed from: a, reason: collision with other field name */
    public long f361a;

    /* renamed from: a, reason: collision with other field name */
    public String f362a;

    /* renamed from: a, reason: collision with other field name */
    private BitSet f363a;

    /* renamed from: a, reason: collision with other field name */
    public Map<String, String> f364a;

    /* renamed from: a, reason: collision with other field name */
    public boolean f365a;

    /* renamed from: b, reason: collision with other field name */
    public int f366b;

    /* renamed from: b, reason: collision with other field name */
    public String f367b;

    /* renamed from: b, reason: collision with other field name */
    public Map<String, String> f368b;

    /* renamed from: c, reason: collision with other field name */
    public int f369c;

    /* renamed from: c, reason: collision with other field name */
    public String f370c;

    /* renamed from: c, reason: collision with other field name */
    public Map<String, String> f371c;

    /* renamed from: d, reason: collision with other field name */
    public String f372d;

    /* renamed from: e, reason: collision with other field name */
    public String f373e;

    public id() {
        this.f363a = new BitSet(5);
        this.f365a = false;
    }

    public id(id idVar) {
        BitSet bitSet = new BitSet(5);
        this.f363a = bitSet;
        bitSet.clear();
        this.f363a.or(idVar.f363a);
        if (idVar.m2973a()) {
            this.f362a = idVar.f362a;
        }
        this.f361a = idVar.f361a;
        if (idVar.m2979c()) {
            this.f367b = idVar.f367b;
        }
        if (idVar.m2980d()) {
            this.f370c = idVar.f370c;
        }
        if (idVar.e()) {
            this.f372d = idVar.f372d;
        }
        this.f360a = idVar.f360a;
        if (idVar.g()) {
            this.f373e = idVar.f373e;
        }
        this.f366b = idVar.f366b;
        this.f369c = idVar.f369c;
        if (idVar.j()) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, String> entry : idVar.f364a.entrySet()) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
            this.f364a = hashMap;
        }
        if (idVar.k()) {
            HashMap hashMap2 = new HashMap();
            for (Map.Entry<String, String> entry2 : idVar.f368b.entrySet()) {
                hashMap2.put(entry2.getKey(), entry2.getValue());
            }
            this.f368b = hashMap2;
        }
        this.f365a = idVar.f365a;
        if (idVar.n()) {
            HashMap hashMap3 = new HashMap();
            for (Map.Entry<String, String> entry3 : idVar.f371c.entrySet()) {
                hashMap3.put(entry3.getKey(), entry3.getValue());
            }
            this.f371c = hashMap3;
        }
    }

    public int a() {
        return this.f360a;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(id idVar) {
        int h10;
        int k10;
        int h11;
        int h12;
        int b4;
        int b10;
        int e2;
        int b11;
        int e10;
        int e11;
        int e12;
        int c4;
        int e13;
        if (!getClass().equals(idVar.getClass())) {
            return getClass().getName().compareTo(idVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m2973a()).compareTo(Boolean.valueOf(idVar.m2973a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m2973a() && (e13 = p6.e(this.f362a, idVar.f362a)) != 0) {
            return e13;
        }
        int compareTo2 = Boolean.valueOf(m2977b()).compareTo(Boolean.valueOf(idVar.m2977b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m2977b() && (c4 = p6.c(this.f361a, idVar.f361a)) != 0) {
            return c4;
        }
        int compareTo3 = Boolean.valueOf(m2979c()).compareTo(Boolean.valueOf(idVar.m2979c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m2979c() && (e12 = p6.e(this.f367b, idVar.f367b)) != 0) {
            return e12;
        }
        int compareTo4 = Boolean.valueOf(m2980d()).compareTo(Boolean.valueOf(idVar.m2980d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (m2980d() && (e11 = p6.e(this.f370c, idVar.f370c)) != 0) {
            return e11;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(idVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (e10 = p6.e(this.f372d, idVar.f372d)) != 0) {
            return e10;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(idVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (b11 = p6.b(this.f360a, idVar.f360a)) != 0) {
            return b11;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(idVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (e2 = p6.e(this.f373e, idVar.f373e)) != 0) {
            return e2;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(idVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (b10 = p6.b(this.f366b, idVar.f366b)) != 0) {
            return b10;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(idVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i() && (b4 = p6.b(this.f369c, idVar.f369c)) != 0) {
            return b4;
        }
        int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(idVar.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (j() && (h12 = p6.h(this.f364a, idVar.f364a)) != 0) {
            return h12;
        }
        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(idVar.k()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (k() && (h11 = p6.h(this.f368b, idVar.f368b)) != 0) {
            return h11;
        }
        int compareTo12 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(idVar.m()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (m() && (k10 = p6.k(this.f365a, idVar.f365a)) != 0) {
            return k10;
        }
        int compareTo13 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(idVar.n()));
        if (compareTo13 != 0) {
            return compareTo13;
        }
        if (!n() || (h10 = p6.h(this.f371c, idVar.f371c)) == 0) {
            return 0;
        }
        return h10;
    }

    /* renamed from: a, reason: collision with other method in class */
    public long m2968a() {
        return this.f361a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public id m2969a() {
        return new id(this);
    }

    public id a(int i10) {
        this.f360a = i10;
        b(true);
        return this;
    }

    public id a(String str) {
        this.f362a = str;
        return this;
    }

    public id a(Map<String, String> map) {
        this.f364a = map;
        return this;
    }

    /* renamed from: a, reason: collision with other method in class */
    public String m2970a() {
        return this.f362a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public Map<String, String> m2971a() {
        return this.f364a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m2972a() {
        if (this.f362a != null) {
            return;
        }
        throw new jn("Required field 'id' was not present! Struct: " + toString());
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x003e. Please report as an issue. */
    @Override // com.xiaomi.push.jb
    public void a(x6 x6Var) {
        x6Var.i();
        while (true) {
            u6 e2 = x6Var.e();
            byte b4 = e2.f48410b;
            if (b4 == 0) {
                x6Var.D();
                if (m2977b()) {
                    m2972a();
                    return;
                }
                throw new jn("Required field 'messageTs' was not found in serialized data! Struct: " + toString());
            }
            int i10 = 0;
            switch (e2.f48411c) {
                case 1:
                    if (b4 == 11) {
                        this.f362a = x6Var.j();
                        break;
                    }
                    y6.a(x6Var, b4);
                    break;
                case 2:
                    if (b4 == 10) {
                        this.f361a = x6Var.d();
                        a(true);
                        break;
                    }
                    y6.a(x6Var, b4);
                    break;
                case 3:
                    if (b4 == 11) {
                        this.f367b = x6Var.j();
                        break;
                    }
                    y6.a(x6Var, b4);
                    break;
                case 4:
                    if (b4 == 11) {
                        this.f370c = x6Var.j();
                        break;
                    }
                    y6.a(x6Var, b4);
                    break;
                case 5:
                    if (b4 == 11) {
                        this.f372d = x6Var.j();
                        break;
                    }
                    y6.a(x6Var, b4);
                    break;
                case 6:
                    if (b4 == 8) {
                        this.f360a = x6Var.c();
                        b(true);
                        break;
                    }
                    y6.a(x6Var, b4);
                    break;
                case 7:
                    if (b4 == 11) {
                        this.f373e = x6Var.j();
                        break;
                    }
                    y6.a(x6Var, b4);
                    break;
                case 8:
                    if (b4 == 8) {
                        this.f366b = x6Var.c();
                        c(true);
                        break;
                    }
                    y6.a(x6Var, b4);
                    break;
                case 9:
                    if (b4 == 8) {
                        this.f369c = x6Var.c();
                        d(true);
                        break;
                    }
                    y6.a(x6Var, b4);
                    break;
                case 10:
                    if (b4 == 13) {
                        w6 g3 = x6Var.g();
                        this.f364a = new HashMap(g3.f48461c * 2);
                        while (i10 < g3.f48461c) {
                            this.f364a.put(x6Var.j(), x6Var.j());
                            i10++;
                        }
                        x6Var.F();
                        break;
                    }
                    y6.a(x6Var, b4);
                    break;
                case 11:
                    if (b4 == 13) {
                        w6 g10 = x6Var.g();
                        this.f368b = new HashMap(g10.f48461c * 2);
                        while (i10 < g10.f48461c) {
                            this.f368b.put(x6Var.j(), x6Var.j());
                            i10++;
                        }
                        x6Var.F();
                        break;
                    }
                    y6.a(x6Var, b4);
                    break;
                case 12:
                    if (b4 == 2) {
                        this.f365a = x6Var.y();
                        e(true);
                        break;
                    }
                    y6.a(x6Var, b4);
                    break;
                case 13:
                    if (b4 == 13) {
                        w6 g11 = x6Var.g();
                        this.f371c = new HashMap(g11.f48461c * 2);
                        while (i10 < g11.f48461c) {
                            this.f371c.put(x6Var.j(), x6Var.j());
                            i10++;
                        }
                        x6Var.F();
                        break;
                    }
                    y6.a(x6Var, b4);
                    break;
                default:
                    y6.a(x6Var, b4);
                    break;
            }
            x6Var.E();
        }
    }

    public void a(String str, String str2) {
        if (this.f364a == null) {
            this.f364a = new HashMap();
        }
        this.f364a.put(str, str2);
    }

    public void a(boolean z10) {
        this.f363a.set(0, z10);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m2973a() {
        return this.f362a != null;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m2974a(id idVar) {
        if (idVar == null) {
            return false;
        }
        boolean m2973a = m2973a();
        boolean m2973a2 = idVar.m2973a();
        if (((m2973a || m2973a2) && !(m2973a && m2973a2 && this.f362a.equals(idVar.f362a))) || this.f361a != idVar.f361a) {
            return false;
        }
        boolean m2979c = m2979c();
        boolean m2979c2 = idVar.m2979c();
        if ((m2979c || m2979c2) && !(m2979c && m2979c2 && this.f367b.equals(idVar.f367b))) {
            return false;
        }
        boolean m2980d = m2980d();
        boolean m2980d2 = idVar.m2980d();
        if ((m2980d || m2980d2) && !(m2980d && m2980d2 && this.f370c.equals(idVar.f370c))) {
            return false;
        }
        boolean e2 = e();
        boolean e10 = idVar.e();
        if ((e2 || e10) && !(e2 && e10 && this.f372d.equals(idVar.f372d))) {
            return false;
        }
        boolean f10 = f();
        boolean f11 = idVar.f();
        if ((f10 || f11) && !(f10 && f11 && this.f360a == idVar.f360a)) {
            return false;
        }
        boolean g3 = g();
        boolean g10 = idVar.g();
        if ((g3 || g10) && !(g3 && g10 && this.f373e.equals(idVar.f373e))) {
            return false;
        }
        boolean h10 = h();
        boolean h11 = idVar.h();
        if ((h10 || h11) && !(h10 && h11 && this.f366b == idVar.f366b)) {
            return false;
        }
        boolean i10 = i();
        boolean i11 = idVar.i();
        if ((i10 || i11) && !(i10 && i11 && this.f369c == idVar.f369c)) {
            return false;
        }
        boolean j10 = j();
        boolean j11 = idVar.j();
        if ((j10 || j11) && !(j10 && j11 && this.f364a.equals(idVar.f364a))) {
            return false;
        }
        boolean k10 = k();
        boolean k11 = idVar.k();
        if ((k10 || k11) && !(k10 && k11 && this.f368b.equals(idVar.f368b))) {
            return false;
        }
        boolean m10 = m();
        boolean m11 = idVar.m();
        if ((m10 || m11) && !(m10 && m11 && this.f365a == idVar.f365a)) {
            return false;
        }
        boolean n10 = n();
        boolean n11 = idVar.n();
        if (n10 || n11) {
            return n10 && n11 && this.f371c.equals(idVar.f371c);
        }
        return true;
    }

    public int b() {
        return this.f366b;
    }

    public id b(int i10) {
        this.f366b = i10;
        c(true);
        return this;
    }

    public id b(String str) {
        this.f367b = str;
        return this;
    }

    /* renamed from: b, reason: collision with other method in class */
    public String m2975b() {
        return this.f367b;
    }

    /* renamed from: b, reason: collision with other method in class */
    public Map<String, String> m2976b() {
        return this.f368b;
    }

    @Override // com.xiaomi.push.jb
    public void b(x6 x6Var) {
        m2972a();
        x6Var.t(f47586a);
        if (this.f362a != null) {
            x6Var.q(f359a);
            x6Var.u(this.f362a);
            x6Var.z();
        }
        x6Var.q(f47587b);
        x6Var.p(this.f361a);
        x6Var.z();
        if (this.f367b != null && m2979c()) {
            x6Var.q(f47588c);
            x6Var.u(this.f367b);
            x6Var.z();
        }
        if (this.f370c != null && m2980d()) {
            x6Var.q(f47589d);
            x6Var.u(this.f370c);
            x6Var.z();
        }
        if (this.f372d != null && e()) {
            x6Var.q(f47590e);
            x6Var.u(this.f372d);
            x6Var.z();
        }
        if (f()) {
            x6Var.q(f47591f);
            x6Var.o(this.f360a);
            x6Var.z();
        }
        if (this.f373e != null && g()) {
            x6Var.q(f47592g);
            x6Var.u(this.f373e);
            x6Var.z();
        }
        if (h()) {
            x6Var.q(f47593h);
            x6Var.o(this.f366b);
            x6Var.z();
        }
        if (i()) {
            x6Var.q(f47594i);
            x6Var.o(this.f369c);
            x6Var.z();
        }
        if (this.f364a != null && j()) {
            x6Var.q(f47595j);
            x6Var.s(new w6((byte) 11, (byte) 11, this.f364a.size()));
            for (Map.Entry<String, String> entry : this.f364a.entrySet()) {
                x6Var.u(entry.getKey());
                x6Var.u(entry.getValue());
            }
            x6Var.B();
            x6Var.z();
        }
        if (this.f368b != null && k()) {
            x6Var.q(f47596k);
            x6Var.s(new w6((byte) 11, (byte) 11, this.f368b.size()));
            for (Map.Entry<String, String> entry2 : this.f368b.entrySet()) {
                x6Var.u(entry2.getKey());
                x6Var.u(entry2.getValue());
            }
            x6Var.B();
            x6Var.z();
        }
        if (m()) {
            x6Var.q(f47597l);
            x6Var.x(this.f365a);
            x6Var.z();
        }
        if (this.f371c != null && n()) {
            x6Var.q(f47598m);
            x6Var.s(new w6((byte) 11, (byte) 11, this.f371c.size()));
            for (Map.Entry<String, String> entry3 : this.f371c.entrySet()) {
                x6Var.u(entry3.getKey());
                x6Var.u(entry3.getValue());
            }
            x6Var.B();
            x6Var.z();
        }
        x6Var.A();
        x6Var.m();
    }

    public void b(String str, String str2) {
        if (this.f368b == null) {
            this.f368b = new HashMap();
        }
        this.f368b.put(str, str2);
    }

    public void b(boolean z10) {
        this.f363a.set(1, z10);
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m2977b() {
        return this.f363a.get(0);
    }

    public int c() {
        return this.f369c;
    }

    public id c(int i10) {
        this.f369c = i10;
        d(true);
        return this;
    }

    public id c(String str) {
        this.f370c = str;
        return this;
    }

    /* renamed from: c, reason: collision with other method in class */
    public String m2978c() {
        return this.f370c;
    }

    public void c(boolean z10) {
        this.f363a.set(2, z10);
    }

    /* renamed from: c, reason: collision with other method in class */
    public boolean m2979c() {
        return this.f367b != null;
    }

    public id d(String str) {
        this.f372d = str;
        return this;
    }

    public String d() {
        return this.f372d;
    }

    public void d(boolean z10) {
        this.f363a.set(3, z10);
    }

    /* renamed from: d, reason: collision with other method in class */
    public boolean m2980d() {
        return this.f370c != null;
    }

    public void e(boolean z10) {
        this.f363a.set(4, z10);
    }

    public boolean e() {
        return this.f372d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof id)) {
            return m2974a((id) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f363a.get(1);
    }

    public boolean g() {
        return this.f373e != null;
    }

    public boolean h() {
        return this.f363a.get(2);
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f363a.get(3);
    }

    public boolean j() {
        return this.f364a != null;
    }

    public boolean k() {
        return this.f368b != null;
    }

    public boolean l() {
        return this.f365a;
    }

    public boolean m() {
        return this.f363a.get(4);
    }

    public boolean n() {
        return this.f371c != null;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("PushMetaInfo(");
        sb2.append("id:");
        String str = this.f362a;
        if (str == null) {
            sb2.append("null");
        } else {
            sb2.append(str);
        }
        sb2.append(", ");
        sb2.append("messageTs:");
        sb2.append(this.f361a);
        if (m2979c()) {
            sb2.append(", ");
            sb2.append("topic:");
            String str2 = this.f367b;
            if (str2 == null) {
                sb2.append("null");
            } else {
                sb2.append(str2);
            }
        }
        if (m2980d()) {
            sb2.append(", ");
            sb2.append("title:");
            String str3 = this.f370c;
            if (str3 == null) {
                sb2.append("null");
            } else {
                sb2.append(str3);
            }
        }
        if (e()) {
            sb2.append(", ");
            sb2.append("description:");
            String str4 = this.f372d;
            if (str4 == null) {
                sb2.append("null");
            } else {
                sb2.append(str4);
            }
        }
        if (f()) {
            sb2.append(", ");
            sb2.append("notifyType:");
            sb2.append(this.f360a);
        }
        if (g()) {
            sb2.append(", ");
            sb2.append("url:");
            String str5 = this.f373e;
            if (str5 == null) {
                sb2.append("null");
            } else {
                sb2.append(str5);
            }
        }
        if (h()) {
            sb2.append(", ");
            sb2.append("passThrough:");
            sb2.append(this.f366b);
        }
        if (i()) {
            sb2.append(", ");
            sb2.append("notifyId:");
            sb2.append(this.f369c);
        }
        if (j()) {
            sb2.append(", ");
            sb2.append("extra:");
            Map<String, String> map = this.f364a;
            if (map == null) {
                sb2.append("null");
            } else {
                sb2.append((Object) map);
            }
        }
        if (k()) {
            sb2.append(", ");
            sb2.append("internal:");
            Map<String, String> map2 = this.f368b;
            if (map2 == null) {
                sb2.append("null");
            } else {
                sb2.append((Object) map2);
            }
        }
        if (m()) {
            sb2.append(", ");
            sb2.append("ignoreRegInfo:");
            sb2.append(this.f365a);
        }
        if (n()) {
            sb2.append(", ");
            sb2.append("apsProperFields:");
            Map<String, String> map3 = this.f371c;
            if (map3 == null) {
                sb2.append("null");
            } else {
                sb2.append((Object) map3);
            }
        }
        sb2.append(")");
        return sb2.toString();
    }
}
