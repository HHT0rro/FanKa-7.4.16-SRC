package com.xiaomi.push;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class ip implements jb<ip, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with root package name */
    private static final a7 f47671a = new a7("XmPushActionNotification");

    /* renamed from: a, reason: collision with other field name */
    private static final u6 f462a = new u6("", (byte) 11, 1);

    /* renamed from: b, reason: collision with root package name */
    private static final u6 f47672b = new u6("", (byte) 12, 2);

    /* renamed from: c, reason: collision with root package name */
    private static final u6 f47673c = new u6("", (byte) 11, 3);

    /* renamed from: d, reason: collision with root package name */
    private static final u6 f47674d = new u6("", (byte) 11, 4);

    /* renamed from: e, reason: collision with root package name */
    private static final u6 f47675e = new u6("", (byte) 11, 5);

    /* renamed from: f, reason: collision with root package name */
    private static final u6 f47676f = new u6("", (byte) 2, 6);

    /* renamed from: g, reason: collision with root package name */
    private static final u6 f47677g = new u6("", (byte) 11, 7);

    /* renamed from: h, reason: collision with root package name */
    private static final u6 f47678h = new u6("", (byte) 13, 8);

    /* renamed from: i, reason: collision with root package name */
    private static final u6 f47679i = new u6("", (byte) 11, 9);

    /* renamed from: j, reason: collision with root package name */
    private static final u6 f47680j = new u6("", (byte) 11, 10);

    /* renamed from: k, reason: collision with root package name */
    private static final u6 f47681k = new u6("", (byte) 11, 12);

    /* renamed from: l, reason: collision with root package name */
    private static final u6 f47682l = new u6("", (byte) 11, 13);

    /* renamed from: m, reason: collision with root package name */
    private static final u6 f47683m = new u6("", (byte) 11, 14);

    /* renamed from: n, reason: collision with root package name */
    private static final u6 f47684n = new u6("", (byte) 10, 15);

    /* renamed from: o, reason: collision with root package name */
    private static final u6 f47685o = new u6("", (byte) 2, 20);

    /* renamed from: a, reason: collision with other field name */
    public long f463a;

    /* renamed from: a, reason: collision with other field name */
    public Cif f464a;

    /* renamed from: a, reason: collision with other field name */
    public String f465a;

    /* renamed from: a, reason: collision with other field name */
    public ByteBuffer f466a;

    /* renamed from: a, reason: collision with other field name */
    private BitSet f467a;

    /* renamed from: a, reason: collision with other field name */
    public Map<String, String> f468a;

    /* renamed from: a, reason: collision with other field name */
    public boolean f469a;

    /* renamed from: b, reason: collision with other field name */
    public String f470b;

    /* renamed from: b, reason: collision with other field name */
    public boolean f471b;

    /* renamed from: c, reason: collision with other field name */
    public String f472c;

    /* renamed from: d, reason: collision with other field name */
    public String f473d;

    /* renamed from: e, reason: collision with other field name */
    public String f474e;

    /* renamed from: f, reason: collision with other field name */
    public String f475f;

    /* renamed from: g, reason: collision with other field name */
    public String f476g;

    /* renamed from: h, reason: collision with other field name */
    public String f477h;

    /* renamed from: i, reason: collision with other field name */
    public String f478i;

    public ip() {
        this.f467a = new BitSet(3);
        this.f469a = true;
        this.f471b = false;
    }

    public ip(String str, boolean z10) {
        this();
        this.f470b = str;
        this.f469a = z10;
        m3019a(true);
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(ip ipVar) {
        int k10;
        int c4;
        int d10;
        int e2;
        int e10;
        int e11;
        int e12;
        int h10;
        int e13;
        int k11;
        int e14;
        int e15;
        int e16;
        int d11;
        int e17;
        if (!getClass().equals(ipVar.getClass())) {
            return getClass().getName().compareTo(ipVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m3020a()).compareTo(Boolean.valueOf(ipVar.m3020a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m3020a() && (e17 = p6.e(this.f465a, ipVar.f465a)) != 0) {
            return e17;
        }
        int compareTo2 = Boolean.valueOf(m3023b()).compareTo(Boolean.valueOf(ipVar.m3023b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m3023b() && (d11 = p6.d(this.f464a, ipVar.f464a)) != 0) {
            return d11;
        }
        int compareTo3 = Boolean.valueOf(m3024c()).compareTo(Boolean.valueOf(ipVar.m3024c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m3024c() && (e16 = p6.e(this.f470b, ipVar.f470b)) != 0) {
            return e16;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ipVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (e15 = p6.e(this.f472c, ipVar.f472c)) != 0) {
            return e15;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ipVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (e14 = p6.e(this.f473d, ipVar.f473d)) != 0) {
            return e14;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ipVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (k11 = p6.k(this.f469a, ipVar.f469a)) != 0) {
            return k11;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ipVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (e13 = p6.e(this.f474e, ipVar.f474e)) != 0) {
            return e13;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ipVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (h10 = p6.h(this.f468a, ipVar.f468a)) != 0) {
            return h10;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ipVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i() && (e12 = p6.e(this.f475f, ipVar.f475f)) != 0) {
            return e12;
        }
        int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(ipVar.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (j() && (e11 = p6.e(this.f476g, ipVar.f476g)) != 0) {
            return e11;
        }
        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(ipVar.k()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (k() && (e10 = p6.e(this.f477h, ipVar.f477h)) != 0) {
            return e10;
        }
        int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(ipVar.l()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (l() && (e2 = p6.e(this.f478i, ipVar.f478i)) != 0) {
            return e2;
        }
        int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(ipVar.m()));
        if (compareTo13 != 0) {
            return compareTo13;
        }
        if (m() && (d10 = p6.d(this.f466a, ipVar.f466a)) != 0) {
            return d10;
        }
        int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(ipVar.n()));
        if (compareTo14 != 0) {
            return compareTo14;
        }
        if (n() && (c4 = p6.c(this.f463a, ipVar.f463a)) != 0) {
            return c4;
        }
        int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(ipVar.o()));
        if (compareTo15 != 0) {
            return compareTo15;
        }
        if (!o() || (k10 = p6.k(this.f471b, ipVar.f471b)) == 0) {
            return 0;
        }
        return k10;
    }

    public ip a(String str) {
        this.f470b = str;
        return this;
    }

    public ip a(ByteBuffer byteBuffer) {
        this.f466a = byteBuffer;
        return this;
    }

    public ip a(Map<String, String> map) {
        this.f468a = map;
        return this;
    }

    public ip a(boolean z10) {
        this.f469a = z10;
        m3019a(true);
        return this;
    }

    public ip a(byte[] bArr) {
        a(ByteBuffer.wrap(bArr));
        return this;
    }

    public String a() {
        return this.f470b;
    }

    /* renamed from: a, reason: collision with other method in class */
    public Map<String, String> m3017a() {
        return this.f468a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m3018a() {
        if (this.f470b != null) {
            return;
        }
        throw new jn("Required field 'id' was not present! Struct: " + toString());
    }

    @Override // com.xiaomi.push.jb
    public void a(x6 x6Var) {
        x6Var.i();
        while (true) {
            u6 e2 = x6Var.e();
            byte b4 = e2.f48410b;
            if (b4 == 0) {
                x6Var.D();
                if (f()) {
                    m3018a();
                    return;
                }
                throw new jn("Required field 'requireAck' was not found in serialized data! Struct: " + toString());
            }
            switch (e2.f48411c) {
                case 1:
                    if (b4 == 11) {
                        this.f465a = x6Var.j();
                        continue;
                    }
                    break;
                case 2:
                    if (b4 == 12) {
                        Cif cif = new Cif();
                        this.f464a = cif;
                        cif.a(x6Var);
                        break;
                    }
                    break;
                case 3:
                    if (b4 == 11) {
                        this.f470b = x6Var.j();
                        continue;
                    }
                    break;
                case 4:
                    if (b4 == 11) {
                        this.f472c = x6Var.j();
                        continue;
                    }
                    break;
                case 5:
                    if (b4 == 11) {
                        this.f473d = x6Var.j();
                        continue;
                    }
                    break;
                case 6:
                    if (b4 == 2) {
                        this.f469a = x6Var.y();
                        m3019a(true);
                        continue;
                    }
                    break;
                case 7:
                    if (b4 == 11) {
                        this.f474e = x6Var.j();
                        continue;
                    }
                    break;
                case 8:
                    if (b4 == 13) {
                        w6 g3 = x6Var.g();
                        this.f468a = new HashMap(g3.f48461c * 2);
                        for (int i10 = 0; i10 < g3.f48461c; i10++) {
                            this.f468a.put(x6Var.j(), x6Var.j());
                        }
                        x6Var.F();
                        break;
                    }
                    break;
                case 9:
                    if (b4 == 11) {
                        this.f475f = x6Var.j();
                        continue;
                    }
                    break;
                case 10:
                    if (b4 == 11) {
                        this.f476g = x6Var.j();
                        continue;
                    }
                    break;
                case 12:
                    if (b4 == 11) {
                        this.f477h = x6Var.j();
                        continue;
                    }
                    break;
                case 13:
                    if (b4 == 11) {
                        this.f478i = x6Var.j();
                        continue;
                    }
                    break;
                case 14:
                    if (b4 == 11) {
                        this.f466a = x6Var.k();
                        continue;
                    }
                    break;
                case 15:
                    if (b4 == 10) {
                        this.f463a = x6Var.d();
                        b(true);
                        break;
                    }
                    break;
                case 20:
                    if (b4 == 2) {
                        this.f471b = x6Var.y();
                        c(true);
                        continue;
                    }
                    break;
            }
            y6.a(x6Var, b4);
            x6Var.E();
        }
    }

    public void a(String str, String str2) {
        if (this.f468a == null) {
            this.f468a = new HashMap();
        }
        this.f468a.put(str, str2);
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m3019a(boolean z10) {
        this.f467a.set(0, z10);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m3020a() {
        return this.f465a != null;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m3021a(ip ipVar) {
        if (ipVar == null) {
            return false;
        }
        boolean m3020a = m3020a();
        boolean m3020a2 = ipVar.m3020a();
        if ((m3020a || m3020a2) && !(m3020a && m3020a2 && this.f465a.equals(ipVar.f465a))) {
            return false;
        }
        boolean m3023b = m3023b();
        boolean m3023b2 = ipVar.m3023b();
        if ((m3023b || m3023b2) && !(m3023b && m3023b2 && this.f464a.m2982a(ipVar.f464a))) {
            return false;
        }
        boolean m3024c = m3024c();
        boolean m3024c2 = ipVar.m3024c();
        if ((m3024c || m3024c2) && !(m3024c && m3024c2 && this.f470b.equals(ipVar.f470b))) {
            return false;
        }
        boolean d10 = d();
        boolean d11 = ipVar.d();
        if ((d10 || d11) && !(d10 && d11 && this.f472c.equals(ipVar.f472c))) {
            return false;
        }
        boolean e2 = e();
        boolean e10 = ipVar.e();
        if (((e2 || e10) && !(e2 && e10 && this.f473d.equals(ipVar.f473d))) || this.f469a != ipVar.f469a) {
            return false;
        }
        boolean g3 = g();
        boolean g10 = ipVar.g();
        if ((g3 || g10) && !(g3 && g10 && this.f474e.equals(ipVar.f474e))) {
            return false;
        }
        boolean h10 = h();
        boolean h11 = ipVar.h();
        if ((h10 || h11) && !(h10 && h11 && this.f468a.equals(ipVar.f468a))) {
            return false;
        }
        boolean i10 = i();
        boolean i11 = ipVar.i();
        if ((i10 || i11) && !(i10 && i11 && this.f475f.equals(ipVar.f475f))) {
            return false;
        }
        boolean j10 = j();
        boolean j11 = ipVar.j();
        if ((j10 || j11) && !(j10 && j11 && this.f476g.equals(ipVar.f476g))) {
            return false;
        }
        boolean k10 = k();
        boolean k11 = ipVar.k();
        if ((k10 || k11) && !(k10 && k11 && this.f477h.equals(ipVar.f477h))) {
            return false;
        }
        boolean l10 = l();
        boolean l11 = ipVar.l();
        if ((l10 || l11) && !(l10 && l11 && this.f478i.equals(ipVar.f478i))) {
            return false;
        }
        boolean m10 = m();
        boolean m11 = ipVar.m();
        if ((m10 || m11) && !(m10 && m11 && this.f466a.equals(ipVar.f466a))) {
            return false;
        }
        boolean n10 = n();
        boolean n11 = ipVar.n();
        if ((n10 || n11) && !(n10 && n11 && this.f463a == ipVar.f463a)) {
            return false;
        }
        boolean o10 = o();
        boolean o11 = ipVar.o();
        if (o10 || o11) {
            return o10 && o11 && this.f471b == ipVar.f471b;
        }
        return true;
    }

    /* renamed from: a, reason: collision with other method in class */
    public byte[] m3022a() {
        a(p6.n(this.f466a));
        return this.f466a.array();
    }

    public ip b(String str) {
        this.f472c = str;
        return this;
    }

    public String b() {
        return this.f472c;
    }

    @Override // com.xiaomi.push.jb
    public void b(x6 x6Var) {
        m3018a();
        x6Var.t(f47671a);
        if (this.f465a != null && m3020a()) {
            x6Var.q(f462a);
            x6Var.u(this.f465a);
            x6Var.z();
        }
        if (this.f464a != null && m3023b()) {
            x6Var.q(f47672b);
            this.f464a.b(x6Var);
            x6Var.z();
        }
        if (this.f470b != null) {
            x6Var.q(f47673c);
            x6Var.u(this.f470b);
            x6Var.z();
        }
        if (this.f472c != null && d()) {
            x6Var.q(f47674d);
            x6Var.u(this.f472c);
            x6Var.z();
        }
        if (this.f473d != null && e()) {
            x6Var.q(f47675e);
            x6Var.u(this.f473d);
            x6Var.z();
        }
        x6Var.q(f47676f);
        x6Var.x(this.f469a);
        x6Var.z();
        if (this.f474e != null && g()) {
            x6Var.q(f47677g);
            x6Var.u(this.f474e);
            x6Var.z();
        }
        if (this.f468a != null && h()) {
            x6Var.q(f47678h);
            x6Var.s(new w6((byte) 11, (byte) 11, this.f468a.size()));
            for (Map.Entry<String, String> entry : this.f468a.entrySet()) {
                x6Var.u(entry.getKey());
                x6Var.u(entry.getValue());
            }
            x6Var.B();
            x6Var.z();
        }
        if (this.f475f != null && i()) {
            x6Var.q(f47679i);
            x6Var.u(this.f475f);
            x6Var.z();
        }
        if (this.f476g != null && j()) {
            x6Var.q(f47680j);
            x6Var.u(this.f476g);
            x6Var.z();
        }
        if (this.f477h != null && k()) {
            x6Var.q(f47681k);
            x6Var.u(this.f477h);
            x6Var.z();
        }
        if (this.f478i != null && l()) {
            x6Var.q(f47682l);
            x6Var.u(this.f478i);
            x6Var.z();
        }
        if (this.f466a != null && m()) {
            x6Var.q(f47683m);
            x6Var.v(this.f466a);
            x6Var.z();
        }
        if (n()) {
            x6Var.q(f47684n);
            x6Var.p(this.f463a);
            x6Var.z();
        }
        if (o()) {
            x6Var.q(f47685o);
            x6Var.x(this.f471b);
            x6Var.z();
        }
        x6Var.A();
        x6Var.m();
    }

    public void b(boolean z10) {
        this.f467a.set(1, z10);
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m3023b() {
        return this.f464a != null;
    }

    public ip c(String str) {
        this.f473d = str;
        return this;
    }

    public String c() {
        return this.f475f;
    }

    public void c(boolean z10) {
        this.f467a.set(2, z10);
    }

    /* renamed from: c, reason: collision with other method in class */
    public boolean m3024c() {
        return this.f470b != null;
    }

    public ip d(String str) {
        this.f475f = str;
        return this;
    }

    public boolean d() {
        return this.f472c != null;
    }

    public boolean e() {
        return this.f473d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ip)) {
            return m3021a((ip) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f467a.get(0);
    }

    public boolean g() {
        return this.f474e != null;
    }

    public boolean h() {
        return this.f468a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f475f != null;
    }

    public boolean j() {
        return this.f476g != null;
    }

    public boolean k() {
        return this.f477h != null;
    }

    public boolean l() {
        return this.f478i != null;
    }

    public boolean m() {
        return this.f466a != null;
    }

    public boolean n() {
        return this.f467a.get(1);
    }

    public boolean o() {
        return this.f467a.get(2);
    }

    public String toString() {
        boolean z10;
        StringBuilder sb2 = new StringBuilder("XmPushActionNotification(");
        boolean z11 = false;
        if (m3020a()) {
            sb2.append("debug:");
            String str = this.f465a;
            if (str == null) {
                sb2.append("null");
            } else {
                sb2.append(str);
            }
            z10 = false;
        } else {
            z10 = true;
        }
        if (m3023b()) {
            if (!z10) {
                sb2.append(", ");
            }
            sb2.append("target:");
            Cif cif = this.f464a;
            if (cif == null) {
                sb2.append("null");
            } else {
                sb2.append((Object) cif);
            }
        } else {
            z11 = z10;
        }
        if (!z11) {
            sb2.append(", ");
        }
        sb2.append("id:");
        String str2 = this.f470b;
        if (str2 == null) {
            sb2.append("null");
        } else {
            sb2.append(str2);
        }
        if (d()) {
            sb2.append(", ");
            sb2.append("appId:");
            String str3 = this.f472c;
            if (str3 == null) {
                sb2.append("null");
            } else {
                sb2.append(str3);
            }
        }
        if (e()) {
            sb2.append(", ");
            sb2.append("type:");
            String str4 = this.f473d;
            if (str4 == null) {
                sb2.append("null");
            } else {
                sb2.append(str4);
            }
        }
        sb2.append(", ");
        sb2.append("requireAck:");
        sb2.append(this.f469a);
        if (g()) {
            sb2.append(", ");
            sb2.append("payload:");
            String str5 = this.f474e;
            if (str5 == null) {
                sb2.append("null");
            } else {
                sb2.append(str5);
            }
        }
        if (h()) {
            sb2.append(", ");
            sb2.append("extra:");
            Map<String, String> map = this.f468a;
            if (map == null) {
                sb2.append("null");
            } else {
                sb2.append((Object) map);
            }
        }
        if (i()) {
            sb2.append(", ");
            sb2.append("packageName:");
            String str6 = this.f475f;
            if (str6 == null) {
                sb2.append("null");
            } else {
                sb2.append(str6);
            }
        }
        if (j()) {
            sb2.append(", ");
            sb2.append("category:");
            String str7 = this.f476g;
            if (str7 == null) {
                sb2.append("null");
            } else {
                sb2.append(str7);
            }
        }
        if (k()) {
            sb2.append(", ");
            sb2.append("regId:");
            String str8 = this.f477h;
            if (str8 == null) {
                sb2.append("null");
            } else {
                sb2.append(str8);
            }
        }
        if (l()) {
            sb2.append(", ");
            sb2.append("aliasName:");
            String str9 = this.f478i;
            if (str9 == null) {
                sb2.append("null");
            } else {
                sb2.append(str9);
            }
        }
        if (m()) {
            sb2.append(", ");
            sb2.append("binaryExtra:");
            ByteBuffer byteBuffer = this.f466a;
            if (byteBuffer == null) {
                sb2.append("null");
            } else {
                p6.o(byteBuffer, sb2);
            }
        }
        if (n()) {
            sb2.append(", ");
            sb2.append("createdTs:");
            sb2.append(this.f463a);
        }
        if (o()) {
            sb2.append(", ");
            sb2.append("alreadyLogClickInXmq:");
            sb2.append(this.f471b);
        }
        sb2.append(")");
        return sb2.toString();
    }
}
