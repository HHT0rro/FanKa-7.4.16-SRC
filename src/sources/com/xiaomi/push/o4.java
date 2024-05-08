package com.xiaomi.push;

import android.text.TextUtils;
import com.xiaomi.push.service.aq;
import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.zip.Adler32;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class o4 {

    /* renamed from: a, reason: collision with root package name */
    public ByteBuffer f48050a = ByteBuffer.allocate(2048);

    /* renamed from: b, reason: collision with root package name */
    public ByteBuffer f48051b = ByteBuffer.allocate(4);

    /* renamed from: c, reason: collision with root package name */
    public Adler32 f48052c = new Adler32();

    /* renamed from: d, reason: collision with root package name */
    public q4 f48053d = new q4();

    /* renamed from: e, reason: collision with root package name */
    public InputStream f48054e;

    /* renamed from: f, reason: collision with root package name */
    public s4 f48055f;

    /* renamed from: g, reason: collision with root package name */
    public volatile boolean f48056g;

    /* renamed from: h, reason: collision with root package name */
    public byte[] f48057h;

    public o4(InputStream inputStream, s4 s4Var) {
        this.f48054e = new BufferedInputStream(inputStream);
        this.f48055f = s4Var;
    }

    public n4 a() {
        int i10;
        try {
            ByteBuffer b4 = b();
            i10 = b4.position();
            try {
                b4.flip();
                b4.position(8);
                n4 r4Var = i10 == 8 ? new r4() : n4.c(b4.slice());
                fc.c.m("[Slim] Read {cmd=" + r4Var.d() + ";chid=" + r4Var.a() + ";len=" + i10 + com.alipay.sdk.util.i.f4738d);
                return r4Var;
            } catch (IOException e2) {
                e = e2;
                if (i10 == 0) {
                    i10 = this.f48050a.position();
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("[Slim] read Blob [");
                byte[] array = this.f48050a.array();
                if (i10 > 128) {
                    i10 = 128;
                }
                sb2.append(k.a(array, 0, i10));
                sb2.append("] Err:");
                sb2.append(e.getMessage());
                fc.c.i(sb2.toString());
                throw e;
            }
        } catch (IOException e10) {
            e = e10;
            i10 = 0;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00cf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.nio.ByteBuffer b() {
        /*
            Method dump skipped, instructions count: 266
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.o4.b():java.nio.ByteBuffer");
    }

    public void c() {
        try {
            f();
        } catch (IOException e2) {
            if (!this.f48056g) {
                throw e2;
            }
        }
    }

    public final void d(ByteBuffer byteBuffer, int i10) {
        int position = byteBuffer.position();
        do {
            int read = this.f48054e.read(byteBuffer.array(), position, i10);
            if (read == -1) {
                throw new EOFException();
            }
            i10 -= read;
            position += read;
        } while (i10 > 0);
        byteBuffer.position(position);
    }

    public void e() {
        this.f48056g = true;
    }

    public final void f() {
        String str;
        StringBuilder sb2;
        boolean z10 = false;
        this.f48056g = false;
        n4 a10 = a();
        if ("CONN".equals(a10.d())) {
            m3 n10 = m3.n(a10.n());
            if (n10.p()) {
                this.f48055f.l(n10.o());
                z10 = true;
            }
            if (n10.t()) {
                i3 j10 = n10.j();
                n4 n4Var = new n4();
                n4Var.j("SYNC", "CONF");
                n4Var.l(j10.h(), null);
                this.f48055f.U(n4Var);
            }
            fc.c.i("[Slim] CONN: host = " + n10.r());
        }
        if (!z10) {
            fc.c.i("[Slim] Invalid CONN");
            throw new IOException("Invalid Connection");
        }
        this.f48057h = this.f48055f.V();
        while (!this.f48056g) {
            n4 a11 = a();
            this.f48055f.z();
            short f10 = a11.f();
            if (f10 != 1) {
                if (f10 != 2) {
                    if (f10 != 3) {
                        str = "[Slim] unknow blob type " + ((int) a11.f());
                        fc.c.i(str);
                    } else {
                        try {
                            this.f48055f.W(this.f48053d.a(a11.n(), this.f48055f));
                        } catch (Exception e2) {
                            e = e2;
                            sb2 = new StringBuilder();
                            sb2.append("[Slim] Parse packet from Blob chid=");
                            sb2.append(a11.a());
                            sb2.append("; Id=");
                            sb2.append(a11.w());
                            sb2.append(" failure:");
                            sb2.append(e.getMessage());
                            str = sb2.toString();
                            fc.c.i(str);
                        }
                    }
                } else if ("SECMSG".equals(a11.d()) && ((a11.a() == 2 || a11.a() == 3) && TextUtils.isEmpty(a11.q()))) {
                    try {
                        this.f48055f.W(this.f48053d.a(a11.o(aq.c().b(Integer.valueOf(a11.a()).toString(), a11.y()).f48230i), this.f48055f));
                    } catch (Exception e10) {
                        e = e10;
                        sb2 = new StringBuilder();
                        sb2.append("[Slim] Parse packet from Blob chid=");
                        sb2.append(a11.a());
                        sb2.append("; Id=");
                        sb2.append(a11.w());
                        sb2.append(" failure:");
                        sb2.append(e.getMessage());
                        str = sb2.toString();
                        fc.c.i(str);
                    }
                }
            }
            this.f48055f.U(a11);
        }
    }
}
