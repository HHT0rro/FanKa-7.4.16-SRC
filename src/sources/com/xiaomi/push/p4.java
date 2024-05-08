package com.xiaomi.push;

import android.os.Build;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Locale;
import java.util.TimeZone;
import java.util.zip.Adler32;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class p4 {

    /* renamed from: a, reason: collision with root package name */
    public ByteBuffer f48072a = ByteBuffer.allocate(2048);

    /* renamed from: b, reason: collision with root package name */
    public ByteBuffer f48073b = ByteBuffer.allocate(4);

    /* renamed from: c, reason: collision with root package name */
    public Adler32 f48074c = new Adler32();

    /* renamed from: d, reason: collision with root package name */
    public s4 f48075d;

    /* renamed from: e, reason: collision with root package name */
    public OutputStream f48076e;

    /* renamed from: f, reason: collision with root package name */
    public int f48077f;

    /* renamed from: g, reason: collision with root package name */
    public int f48078g;

    /* renamed from: h, reason: collision with root package name */
    public byte[] f48079h;

    public p4(OutputStream outputStream, s4 s4Var) {
        this.f48076e = new BufferedOutputStream(outputStream);
        this.f48075d = s4Var;
        TimeZone timeZone = TimeZone.getDefault();
        this.f48077f = timeZone.getRawOffset() / 3600000;
        this.f48078g = timeZone.useDaylightTime() ? 1 : 0;
    }

    public int a(n4 n4Var) {
        int s2 = n4Var.s();
        if (s2 > 32768) {
            fc.c.i("Blob size=" + s2 + " should be less than 32768 Drop blob chid=" + n4Var.a() + " id=" + n4Var.w());
            return 0;
        }
        this.f48072a.clear();
        int i10 = s2 + 8 + 4;
        if (i10 > this.f48072a.capacity() || this.f48072a.capacity() > 4096) {
            this.f48072a = ByteBuffer.allocate(i10);
        }
        this.f48072a.putShort((short) -15618);
        this.f48072a.putShort((short) 5);
        this.f48072a.putInt(s2);
        int position = this.f48072a.position();
        this.f48072a = n4Var.e(this.f48072a);
        if (!"CONN".equals(n4Var.d())) {
            if (this.f48079h == null) {
                this.f48079h = this.f48075d.V();
            }
            kc.s.j(this.f48079h, this.f48072a.array(), true, position, s2);
        }
        this.f48074c.reset();
        this.f48074c.update(this.f48072a.array(), 0, this.f48072a.position());
        this.f48073b.putInt(0, (int) this.f48074c.getValue());
        this.f48076e.write(this.f48072a.array(), 0, this.f48072a.position());
        this.f48076e.write(this.f48073b.array(), 0, 4);
        this.f48076e.flush();
        int position2 = this.f48072a.position() + 4;
        fc.c.m("[Slim] Wrote {cmd=" + n4Var.d() + ";chid=" + n4Var.a() + ";len=" + position2 + com.alipay.sdk.util.i.f4738d);
        return position2;
    }

    public void b() {
        l3 l3Var = new l3();
        l3Var.k(106);
        String str = Build.MODEL;
        l3Var.n(str);
        l3Var.r(n7.d());
        l3Var.w(kc.x.f());
        l3Var.q(39);
        l3Var.A(this.f48075d.r());
        l3Var.E(this.f48075d.d());
        l3Var.H(Locale.getDefault().toString());
        int i10 = Build.VERSION.SDK_INT;
        l3Var.v(i10);
        byte[] i11 = this.f48075d.c().i();
        if (i11 != null) {
            l3Var.m(i3.m(i11));
        }
        n4 n4Var = new n4();
        n4Var.g(0);
        n4Var.j("CONN", null);
        n4Var.h(0L, "xiaomi.com", null);
        n4Var.l(l3Var.h(), null);
        a(n4Var);
        fc.c.i("[slim] open conn: andver=" + i10 + " sdk=39 hash=" + kc.x.f() + " tz=" + this.f48077f + com.huawei.openalliance.ad.constant.u.bD + this.f48078g + " Model=" + str + " os=" + Build.VERSION.INCREMENTAL);
    }

    public void c() {
        n4 n4Var = new n4();
        n4Var.j("CLOSE", null);
        a(n4Var);
        this.f48076e.close();
    }
}
