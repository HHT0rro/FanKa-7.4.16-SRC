package com.bytedance.pangle.res.a;

import com.android.internal.logging.nano.MetricsProto;
import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.logging.Logger;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class a {

    /* renamed from: f, reason: collision with root package name */
    private static final Logger f10895f = Logger.getLogger(a.class.getName());

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f10896a;

    /* renamed from: b, reason: collision with root package name */
    private final h f10897b;

    /* renamed from: c, reason: collision with root package name */
    private final g f10898c;

    /* renamed from: d, reason: collision with root package name */
    private final e f10899d;

    /* renamed from: e, reason: collision with root package name */
    private C0124a f10900e;

    /* renamed from: com.bytedance.pangle.res.a.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class C0124a {

        /* renamed from: a, reason: collision with root package name */
        public final short f10901a;

        /* renamed from: b, reason: collision with root package name */
        public final int f10902b;

        /* renamed from: c, reason: collision with root package name */
        public final int f10903c;

        /* renamed from: d, reason: collision with root package name */
        public final int f10904d;

        /* renamed from: e, reason: collision with root package name */
        public final int f10905e;

        private C0124a(short s2, int i10, int i11, int i12) {
            this.f10901a = s2;
            this.f10902b = i10;
            this.f10903c = i11;
            this.f10904d = i12;
            this.f10905e = i12 + i11;
        }

        public static C0124a a(g gVar, e eVar) {
            int a10 = eVar.a();
            try {
                return new C0124a(gVar.readShort(), gVar.readShort(), gVar.readInt(), a10);
            } catch (EOFException unused) {
                return new C0124a((short) -1, 0, 0, eVar.a());
            }
        }
    }

    public a(byte[] bArr, h hVar) {
        e eVar = new e(new ByteArrayInputStream(bArr));
        this.f10899d = eVar;
        this.f10898c = new g(new i(eVar));
        this.f10896a = bArr;
        this.f10897b = hVar;
    }

    private String a(int i10) {
        int i11;
        short s2;
        StringBuilder sb2 = new StringBuilder(16);
        while (true) {
            i11 = i10 - 1;
            if (i10 == 0 || this.f10898c.readByte() == 0) {
                break;
            }
            sb2.append((char) s2);
            i10 = i11;
        }
        this.f10898c.skipBytes(i11);
        return sb2.toString();
    }

    private void b() {
        b(MetricsProto.MetricsEvent.ZONE_PICKER);
        int readInt = this.f10898c.readInt();
        for (int i10 = 0; i10 < readInt; i10++) {
            this.f10898c.readInt();
            this.f10898c.skipBytes(256);
        }
        while (j().f10901a == 513) {
            c();
        }
    }

    private void c() {
        d();
        short s2 = j().f10901a;
        while (s2 == 514) {
            d();
            s2 = j().f10901a;
        }
        while (s2 == 513) {
            e();
            if (this.f10899d.a() < this.f10900e.f10905e) {
                f10895f.warning("Unknown data detected. Skipping: " + (this.f10900e.f10905e - this.f10899d.a()) + " byte(s)");
                e eVar = this.f10899d;
                eVar.skip((long) (this.f10900e.f10905e - eVar.a()));
            }
            s2 = j().f10901a;
        }
    }

    private void d() {
        b(MetricsProto.MetricsEvent.USER_DICTIONARY_SETTINGS);
        this.f10898c.readUnsignedByte();
        this.f10898c.skipBytes(3);
        this.f10898c.skipBytes(this.f10898c.readInt() * 4);
    }

    private void e() {
        b(513);
        this.f10898c.readUnsignedByte();
        this.f10898c.readByte();
        this.f10898c.skipBytes(2);
        int readInt = this.f10898c.readInt();
        int readInt2 = this.f10898c.readInt();
        i();
        int i10 = (this.f10900e.f10904d + readInt2) - (readInt * 4);
        if (i10 != this.f10899d.a()) {
            f10895f.warning("Invalid data detected. Skipping: " + (i10 - this.f10899d.a()) + " byte(s)");
            this.f10898c.skipBytes(i10 - this.f10899d.a());
        }
        int[] a10 = this.f10898c.a(readInt);
        HashSet hashSet = new HashSet();
        for (int i11 : a10) {
            if (i11 != -1 && !hashSet.contains(Integer.valueOf(i11))) {
                f();
                hashSet.add(Integer.valueOf(i11));
            }
        }
    }

    private void f() {
        if (this.f10898c.readShort() >= 0) {
            short readShort = this.f10898c.readShort();
            this.f10898c.readInt();
            if ((readShort & 1) == 0) {
                h();
                return;
            } else {
                g();
                return;
            }
        }
        throw new RuntimeException("Entry size is under 0 bytes.");
    }

    private void g() {
        int a10 = k.a(this.f10898c);
        k.a(this.f10896a, this.f10898c.readInt(), a10, this.f10897b);
        int readInt = this.f10898c.readInt();
        for (int i10 = 0; i10 < readInt; i10++) {
            int a11 = k.a(this.f10898c);
            k.a(this.f10896a, this.f10898c.readInt(), a11, this.f10897b);
            h();
        }
    }

    private void h() {
        this.f10898c.a();
        this.f10898c.b();
        byte readByte = this.f10898c.readByte();
        int a10 = k.a(this.f10898c);
        int readInt = this.f10898c.readInt();
        if (readByte == 1) {
            k.a(this.f10896a, readInt, a10, this.f10897b);
        }
        if (readByte == 2) {
            k.a(this.f10896a, readInt, a10, this.f10897b);
        }
    }

    private void i() {
        int readInt = this.f10898c.readInt();
        int i10 = 28;
        if (readInt >= 28) {
            this.f10898c.readShort();
            this.f10898c.readShort();
            this.f10898c.readByte();
            this.f10898c.readByte();
            this.f10898c.readByte();
            this.f10898c.readByte();
            this.f10898c.readByte();
            this.f10898c.readByte();
            this.f10898c.readUnsignedShort();
            this.f10898c.readByte();
            this.f10898c.readByte();
            this.f10898c.readByte();
            this.f10898c.skipBytes(1);
            this.f10898c.readShort();
            this.f10898c.readShort();
            this.f10898c.readShort();
            this.f10898c.skipBytes(2);
            if (readInt >= 32) {
                this.f10898c.readByte();
                this.f10898c.readByte();
                this.f10898c.readShort();
                i10 = 32;
            }
            if (readInt >= 36) {
                this.f10898c.readShort();
                this.f10898c.readShort();
                i10 = 36;
            }
            if (readInt >= 48) {
                a(4).toCharArray();
                a(8).toCharArray();
                i10 = 48;
            }
            if (readInt >= 52) {
                this.f10898c.readByte();
                this.f10898c.readByte();
                this.f10898c.skipBytes(2);
                i10 = 52;
            }
            if (readInt >= 56) {
                this.f10898c.skipBytes(4);
                i10 = 56;
            }
            int i11 = readInt - 56;
            if (i11 > 0) {
                byte[] bArr = new byte[i11];
                i10 += i11;
                this.f10898c.readFully(bArr);
                BigInteger bigInteger = new BigInteger(1, bArr);
                if (bigInteger.equals(BigInteger.ZERO)) {
                    f10895f.fine(String.format("Config flags size > %d, but exceeding bytes are all zero, so it should be ok.", 56));
                } else {
                    f10895f.warning(String.format("Config flags size > %d. Size = %d. Exceeding bytes: 0x%X.", 56, Integer.valueOf(readInt), bigInteger));
                }
            }
            int i12 = readInt - i10;
            if (i12 > 0) {
                this.f10898c.skipBytes(i12);
                return;
            }
            return;
        }
        throw new RuntimeException("Config size < 28");
    }

    private C0124a j() {
        C0124a a10 = C0124a.a(this.f10898c, this.f10899d);
        this.f10900e = a10;
        return a10;
    }

    public final void a() {
        j();
        b(2);
        int readInt = this.f10898c.readInt();
        l.a(this.f10898c);
        j();
        for (int i10 = 0; i10 < readInt; i10++) {
            b(512);
            this.f10898c.readInt();
            this.f10898c.skipBytes(256);
            this.f10898c.skipBytes(4);
            this.f10898c.skipBytes(4);
            this.f10898c.skipBytes(4);
            this.f10898c.skipBytes(4);
            if (this.f10900e.f10902b == 288 && this.f10898c.readInt() > 0) {
                throw new RuntimeException("don't support");
            }
            l.a(this.f10898c);
            l.a(this.f10898c);
            j();
            boolean z10 = true;
            while (z10) {
                short s2 = this.f10900e.f10901a;
                if (s2 == 514) {
                    c();
                } else if (s2 != 515) {
                    z10 = false;
                } else {
                    b();
                }
            }
        }
    }

    private void b(int i10) {
        if (this.f10900e.f10901a != i10) {
            throw new RuntimeException(String.format("Invalid chunk type: expected=0x%08x, got=0x%08x", Integer.valueOf(i10), Short.valueOf(this.f10900e.f10901a)));
        }
    }
}
