package com.xiaomi.push;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.BitSet;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class im implements jb<im, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with root package name */
    private static final a7 f47661a = new a7("XmPushActionContainer");

    /* renamed from: a, reason: collision with other field name */
    private static final u6 f448a = new u6("", (byte) 8, 1);

    /* renamed from: b, reason: collision with root package name */
    private static final u6 f47662b = new u6("", (byte) 2, 2);

    /* renamed from: c, reason: collision with root package name */
    private static final u6 f47663c = new u6("", (byte) 2, 3);

    /* renamed from: d, reason: collision with root package name */
    private static final u6 f47664d = new u6("", (byte) 11, 4);

    /* renamed from: e, reason: collision with root package name */
    private static final u6 f47665e = new u6("", (byte) 11, 5);

    /* renamed from: f, reason: collision with root package name */
    private static final u6 f47666f = new u6("", (byte) 11, 6);

    /* renamed from: g, reason: collision with root package name */
    private static final u6 f47667g = new u6("", (byte) 12, 7);

    /* renamed from: h, reason: collision with root package name */
    private static final u6 f47668h = new u6("", (byte) 12, 8);

    /* renamed from: a, reason: collision with other field name */
    public hq f449a;

    /* renamed from: a, reason: collision with other field name */
    public id f450a;

    /* renamed from: a, reason: collision with other field name */
    public Cif f451a;

    /* renamed from: a, reason: collision with other field name */
    public String f452a;

    /* renamed from: a, reason: collision with other field name */
    public ByteBuffer f453a;

    /* renamed from: b, reason: collision with other field name */
    public String f456b;

    /* renamed from: a, reason: collision with other field name */
    private BitSet f454a = new BitSet(2);

    /* renamed from: a, reason: collision with other field name */
    public boolean f455a = true;

    /* renamed from: b, reason: collision with other field name */
    public boolean f457b = true;

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(im imVar) {
        int d10;
        int d11;
        int e2;
        int e10;
        int d12;
        int k10;
        int k11;
        int d13;
        if (!getClass().equals(imVar.getClass())) {
            return getClass().getName().compareTo(imVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m3006a()).compareTo(Boolean.valueOf(imVar.m3006a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m3006a() && (d13 = p6.d(this.f449a, imVar.f449a)) != 0) {
            return d13;
        }
        int compareTo2 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(imVar.c()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (c() && (k11 = p6.k(this.f455a, imVar.f455a)) != 0) {
            return k11;
        }
        int compareTo3 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(imVar.d()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (d() && (k10 = p6.k(this.f457b, imVar.f457b)) != 0) {
            return k10;
        }
        int compareTo4 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(imVar.e()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (e() && (d12 = p6.d(this.f453a, imVar.f453a)) != 0) {
            return d12;
        }
        int compareTo5 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(imVar.f()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (f() && (e10 = p6.e(this.f452a, imVar.f452a)) != 0) {
            return e10;
        }
        int compareTo6 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(imVar.g()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (g() && (e2 = p6.e(this.f456b, imVar.f456b)) != 0) {
            return e2;
        }
        int compareTo7 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(imVar.h()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (h() && (d11 = p6.d(this.f451a, imVar.f451a)) != 0) {
            return d11;
        }
        int compareTo8 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(imVar.i()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (!i() || (d10 = p6.d(this.f450a, imVar.f450a)) == 0) {
            return 0;
        }
        return d10;
    }

    public hq a() {
        return this.f449a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public id m3002a() {
        return this.f450a;
    }

    public im a(hq hqVar) {
        this.f449a = hqVar;
        return this;
    }

    public im a(id idVar) {
        this.f450a = idVar;
        return this;
    }

    public im a(Cif cif) {
        this.f451a = cif;
        return this;
    }

    public im a(String str) {
        this.f452a = str;
        return this;
    }

    public im a(ByteBuffer byteBuffer) {
        this.f453a = byteBuffer;
        return this;
    }

    public im a(boolean z10) {
        this.f455a = z10;
        m3005a(true);
        return this;
    }

    /* renamed from: a, reason: collision with other method in class */
    public String m3003a() {
        return this.f452a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m3004a() {
        if (this.f449a == null) {
            throw new jn("Required field 'action' was not present! Struct: " + toString());
        }
        if (this.f453a == null) {
            throw new jn("Required field 'pushAction' was not present! Struct: " + toString());
        }
        if (this.f451a != null) {
            return;
        }
        throw new jn("Required field 'target' was not present! Struct: " + toString());
    }

    @Override // com.xiaomi.push.jb
    public void a(x6 x6Var) {
        x6Var.i();
        while (true) {
            u6 e2 = x6Var.e();
            byte b4 = e2.f48410b;
            if (b4 == 0) {
                x6Var.D();
                if (!c()) {
                    throw new jn("Required field 'encryptAction' was not found in serialized data! Struct: " + toString());
                }
                if (d()) {
                    m3004a();
                    return;
                }
                throw new jn("Required field 'isRequest' was not found in serialized data! Struct: " + toString());
            }
            switch (e2.f48411c) {
                case 1:
                    if (b4 == 8) {
                        this.f449a = hq.a(x6Var.c());
                        break;
                    }
                    break;
                case 2:
                    if (b4 == 2) {
                        this.f455a = x6Var.y();
                        m3005a(true);
                        continue;
                    }
                    break;
                case 3:
                    if (b4 == 2) {
                        this.f457b = x6Var.y();
                        m3009b(true);
                        continue;
                    }
                    break;
                case 4:
                    if (b4 == 11) {
                        this.f453a = x6Var.k();
                        continue;
                    }
                    break;
                case 5:
                    if (b4 == 11) {
                        this.f452a = x6Var.j();
                        continue;
                    }
                    break;
                case 6:
                    if (b4 == 11) {
                        this.f456b = x6Var.j();
                        continue;
                    }
                    break;
                case 7:
                    if (b4 == 12) {
                        Cif cif = new Cif();
                        this.f451a = cif;
                        cif.a(x6Var);
                        continue;
                    }
                    break;
                case 8:
                    if (b4 == 12) {
                        id idVar = new id();
                        this.f450a = idVar;
                        idVar.a(x6Var);
                        continue;
                    }
                    break;
            }
            y6.a(x6Var, b4);
            x6Var.E();
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m3005a(boolean z10) {
        this.f454a.set(0, z10);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m3006a() {
        return this.f449a != null;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m3007a(im imVar) {
        if (imVar == null) {
            return false;
        }
        boolean m3006a = m3006a();
        boolean m3006a2 = imVar.m3006a();
        if (((m3006a || m3006a2) && (!m3006a || !m3006a2 || !this.f449a.equals(imVar.f449a))) || this.f455a != imVar.f455a || this.f457b != imVar.f457b) {
            return false;
        }
        boolean e2 = e();
        boolean e10 = imVar.e();
        if ((e2 || e10) && !(e2 && e10 && this.f453a.equals(imVar.f453a))) {
            return false;
        }
        boolean f10 = f();
        boolean f11 = imVar.f();
        if ((f10 || f11) && !(f10 && f11 && this.f452a.equals(imVar.f452a))) {
            return false;
        }
        boolean g3 = g();
        boolean g10 = imVar.g();
        if ((g3 || g10) && !(g3 && g10 && this.f456b.equals(imVar.f456b))) {
            return false;
        }
        boolean h10 = h();
        boolean h11 = imVar.h();
        if ((h10 || h11) && !(h10 && h11 && this.f451a.m2982a(imVar.f451a))) {
            return false;
        }
        boolean i10 = i();
        boolean i11 = imVar.i();
        if (i10 || i11) {
            return i10 && i11 && this.f450a.m2974a(imVar.f450a);
        }
        return true;
    }

    /* renamed from: a, reason: collision with other method in class */
    public byte[] m3008a() {
        a(p6.n(this.f453a));
        return this.f453a.array();
    }

    public im b(String str) {
        this.f456b = str;
        return this;
    }

    public im b(boolean z10) {
        this.f457b = z10;
        m3009b(true);
        return this;
    }

    public String b() {
        return this.f456b;
    }

    @Override // com.xiaomi.push.jb
    public void b(x6 x6Var) {
        m3004a();
        x6Var.t(f47661a);
        if (this.f449a != null) {
            x6Var.q(f448a);
            x6Var.o(this.f449a.a());
            x6Var.z();
        }
        x6Var.q(f47662b);
        x6Var.x(this.f455a);
        x6Var.z();
        x6Var.q(f47663c);
        x6Var.x(this.f457b);
        x6Var.z();
        if (this.f453a != null) {
            x6Var.q(f47664d);
            x6Var.v(this.f453a);
            x6Var.z();
        }
        if (this.f452a != null && f()) {
            x6Var.q(f47665e);
            x6Var.u(this.f452a);
            x6Var.z();
        }
        if (this.f456b != null && g()) {
            x6Var.q(f47666f);
            x6Var.u(this.f456b);
            x6Var.z();
        }
        if (this.f451a != null) {
            x6Var.q(f47667g);
            this.f451a.b(x6Var);
            x6Var.z();
        }
        if (this.f450a != null && i()) {
            x6Var.q(f47668h);
            this.f450a.b(x6Var);
            x6Var.z();
        }
        x6Var.A();
        x6Var.m();
    }

    /* renamed from: b, reason: collision with other method in class */
    public void m3009b(boolean z10) {
        this.f454a.set(1, z10);
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m3010b() {
        return this.f455a;
    }

    public boolean c() {
        return this.f454a.get(0);
    }

    public boolean d() {
        return this.f454a.get(1);
    }

    public boolean e() {
        return this.f453a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof im)) {
            return m3007a((im) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f452a != null;
    }

    public boolean g() {
        return this.f456b != null;
    }

    public boolean h() {
        return this.f451a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f450a != null;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("XmPushActionContainer(");
        sb2.append("action:");
        hq hqVar = this.f449a;
        if (hqVar == null) {
            sb2.append("null");
        } else {
            sb2.append((Object) hqVar);
        }
        sb2.append(", ");
        sb2.append("encryptAction:");
        sb2.append(this.f455a);
        sb2.append(", ");
        sb2.append("isRequest:");
        sb2.append(this.f457b);
        sb2.append(", ");
        sb2.append("pushAction:");
        ByteBuffer byteBuffer = this.f453a;
        if (byteBuffer == null) {
            sb2.append("null");
        } else {
            p6.o(byteBuffer, sb2);
        }
        if (f()) {
            sb2.append(", ");
            sb2.append("appid:");
            String str = this.f452a;
            if (str == null) {
                sb2.append("null");
            } else {
                sb2.append(str);
            }
        }
        if (g()) {
            sb2.append(", ");
            sb2.append("packageName:");
            String str2 = this.f456b;
            if (str2 == null) {
                sb2.append("null");
            } else {
                sb2.append(str2);
            }
        }
        sb2.append(", ");
        sb2.append("target:");
        Cif cif = this.f451a;
        if (cif == null) {
            sb2.append("null");
        } else {
            sb2.append((Object) cif);
        }
        if (i()) {
            sb2.append(", ");
            sb2.append("metaInfo:");
            id idVar = this.f450a;
            if (idVar == null) {
                sb2.append("null");
            } else {
                sb2.append((Object) idVar);
            }
        }
        sb2.append(")");
        return sb2.toString();
    }
}
