package com.google.android.gms.internal.clearcut;

import com.android.internal.os.PowerProfile;
import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class x3 {

    /* renamed from: a, reason: collision with root package name */
    public final ByteBuffer f24098a;

    /* renamed from: b, reason: collision with root package name */
    public zzbn f24099b;

    /* renamed from: c, reason: collision with root package name */
    public int f24100c;

    public x3(ByteBuffer byteBuffer) {
        this.f24098a = byteBuffer;
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    }

    public x3(byte[] bArr, int i10, int i11) {
        this(ByteBuffer.wrap(bArr, i10, i11));
    }

    public static int A(int i10) {
        if ((i10 & (-128)) == 0) {
            return 1;
        }
        if ((i10 & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i10) == 0) {
            return 3;
        }
        return (i10 & (-268435456)) == 0 ? 4 : 5;
    }

    public static int a(CharSequence charSequence) {
        int length = charSequence.length();
        int i10 = 0;
        int i11 = 0;
        while (i11 < length && charSequence.charAt(i11) < 128) {
            i11++;
        }
        int i12 = length;
        while (true) {
            if (i11 >= length) {
                break;
            }
            char charAt = charSequence.charAt(i11);
            if (charAt < 2048) {
                i12 += (127 - charAt) >>> 31;
                i11++;
            } else {
                int length2 = charSequence.length();
                while (i11 < length2) {
                    char charAt2 = charSequence.charAt(i11);
                    if (charAt2 < 2048) {
                        i10 += (127 - charAt2) >>> 31;
                    } else {
                        i10 += 2;
                        if (55296 <= charAt2 && charAt2 <= 57343) {
                            if (Character.codePointAt(charSequence, i11) < 65536) {
                                StringBuilder sb2 = new StringBuilder(39);
                                sb2.append("Unpaired surrogate at index ");
                                sb2.append(i11);
                                throw new IllegalArgumentException(sb2.toString());
                            }
                            i11++;
                        }
                    }
                    i11++;
                }
                i12 += i10;
            }
        }
        if (i12 >= length) {
            return i12;
        }
        long j10 = i12 + PowerProfile.SUBSYSTEM_MODEM;
        StringBuilder sb3 = new StringBuilder(54);
        sb3.append("UTF-8 length does not fit in int: ");
        sb3.append(j10);
        throw new IllegalArgumentException(sb3.toString());
    }

    public static int g(int i10, c4 c4Var) {
        int y10 = y(i10);
        int d10 = c4Var.d();
        return y10 + A(d10) + d10;
    }

    public static int h(int i10, String str) {
        return y(i10) + r(str);
    }

    public static int i(int i10, byte[] bArr) {
        return y(i10) + s(bArr);
    }

    public static int m(int i10, long j10) {
        return y(i10) + x(j10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v26 */
    public static void n(CharSequence charSequence, ByteBuffer byteBuffer) {
        int i10;
        int i11;
        char charAt;
        int i12;
        if (byteBuffer.isReadOnly()) {
            throw new ReadOnlyBufferException();
        }
        int i13 = 0;
        if (!byteBuffer.hasArray()) {
            int length = charSequence.length();
            while (i13 < length) {
                char charAt2 = charSequence.charAt(i13);
                char c4 = charAt2;
                if (charAt2 >= 128) {
                    if (charAt2 < 2048) {
                        i12 = (charAt2 >>> 6) | 960;
                    } else {
                        if (charAt2 >= 55296 && 57343 >= charAt2) {
                            int i14 = i13 + 1;
                            if (i14 != charSequence.length()) {
                                char charAt3 = charSequence.charAt(i14);
                                if (Character.isSurrogatePair(charAt2, charAt3)) {
                                    int codePoint = Character.toCodePoint(charAt2, charAt3);
                                    byteBuffer.put((byte) ((codePoint >>> 18) | 240));
                                    byteBuffer.put((byte) (((codePoint >>> 12) & 63) | 128));
                                    byteBuffer.put((byte) (((codePoint >>> 6) & 63) | 128));
                                    byteBuffer.put((byte) ((codePoint & 63) | 128));
                                    i13 = i14;
                                    i13++;
                                } else {
                                    i13 = i14;
                                }
                            }
                            StringBuilder sb2 = new StringBuilder(39);
                            sb2.append("Unpaired surrogate at index ");
                            sb2.append(i13 - 1);
                            throw new IllegalArgumentException(sb2.toString());
                        }
                        byteBuffer.put((byte) ((charAt2 >>> '\f') | 480));
                        i12 = ((charAt2 >>> 6) & 63) | 128;
                    }
                    byteBuffer.put((byte) i12);
                    c4 = (charAt2 & '?') | 128;
                }
                byteBuffer.put((byte) c4);
                i13++;
            }
            return;
        }
        try {
            byte[] array = byteBuffer.array();
            int arrayOffset = byteBuffer.arrayOffset() + byteBuffer.position();
            int remaining = byteBuffer.remaining();
            int length2 = charSequence.length();
            int i15 = remaining + arrayOffset;
            while (i13 < length2) {
                int i16 = i13 + arrayOffset;
                if (i16 >= i15 || (charAt = charSequence.charAt(i13)) >= 128) {
                    break;
                }
                array[i16] = (byte) charAt;
                i13++;
            }
            if (i13 == length2) {
                i10 = arrayOffset + length2;
            } else {
                i10 = arrayOffset + i13;
                while (i13 < length2) {
                    char charAt4 = charSequence.charAt(i13);
                    if (charAt4 >= 128 || i10 >= i15) {
                        if (charAt4 < 2048 && i10 <= i15 - 2) {
                            int i17 = i10 + 1;
                            array[i10] = (byte) ((charAt4 >>> 6) | 960);
                            i10 = i17 + 1;
                            array[i17] = (byte) ((charAt4 & '?') | 128);
                        } else {
                            if ((charAt4 >= 55296 && 57343 >= charAt4) || i10 > i15 - 3) {
                                if (i10 > i15 - 4) {
                                    StringBuilder sb3 = new StringBuilder(37);
                                    sb3.append("Failed writing ");
                                    sb3.append(charAt4);
                                    sb3.append(" at index ");
                                    sb3.append(i10);
                                    throw new ArrayIndexOutOfBoundsException(sb3.toString());
                                }
                                int i18 = i13 + 1;
                                if (i18 != charSequence.length()) {
                                    char charAt5 = charSequence.charAt(i18);
                                    if (Character.isSurrogatePair(charAt4, charAt5)) {
                                        int codePoint2 = Character.toCodePoint(charAt4, charAt5);
                                        int i19 = i10 + 1;
                                        array[i10] = (byte) ((codePoint2 >>> 18) | 240);
                                        int i20 = i19 + 1;
                                        array[i19] = (byte) (((codePoint2 >>> 12) & 63) | 128);
                                        int i21 = i20 + 1;
                                        array[i20] = (byte) (((codePoint2 >>> 6) & 63) | 128);
                                        i10 = i21 + 1;
                                        array[i21] = (byte) ((codePoint2 & 63) | 128);
                                        i13 = i18;
                                    } else {
                                        i13 = i18;
                                    }
                                }
                                StringBuilder sb4 = new StringBuilder(39);
                                sb4.append("Unpaired surrogate at index ");
                                sb4.append(i13 - 1);
                                throw new IllegalArgumentException(sb4.toString());
                            }
                            int i22 = i10 + 1;
                            array[i10] = (byte) ((charAt4 >>> '\f') | 480);
                            int i23 = i22 + 1;
                            array[i22] = (byte) (((charAt4 >>> 6) & 63) | 128);
                            i11 = i23 + 1;
                            array[i23] = (byte) ((charAt4 & '?') | 128);
                        }
                        i13++;
                    } else {
                        i11 = i10 + 1;
                        array[i10] = (byte) charAt4;
                    }
                    i10 = i11;
                    i13++;
                }
            }
            byteBuffer.position(i10 - byteBuffer.arrayOffset());
        } catch (ArrayIndexOutOfBoundsException e2) {
            BufferOverflowException bufferOverflowException = new BufferOverflowException();
            bufferOverflowException.initCause(e2);
            throw bufferOverflowException;
        }
    }

    public static x3 q(byte[] bArr) {
        return t(bArr, 0, bArr.length);
    }

    public static int r(String str) {
        int a10 = a(str);
        return A(a10) + a10;
    }

    public static int s(byte[] bArr) {
        return A(bArr.length) + bArr.length;
    }

    public static x3 t(byte[] bArr, int i10, int i11) {
        return new x3(bArr, 0, i11);
    }

    public static long v(long j10) {
        return (j10 >> 63) ^ (j10 << 1);
    }

    public static int x(long j10) {
        if (((-128) & j10) == 0) {
            return 1;
        }
        if (((-16384) & j10) == 0) {
            return 2;
        }
        if (((-2097152) & j10) == 0) {
            return 3;
        }
        if (((-268435456) & j10) == 0) {
            return 4;
        }
        if (((-34359738368L) & j10) == 0) {
            return 5;
        }
        if (((-4398046511104L) & j10) == 0) {
            return 6;
        }
        if (((-562949953421312L) & j10) == 0) {
            return 7;
        }
        if (((-72057594037927936L) & j10) == 0) {
            return 8;
        }
        return (j10 & Long.MIN_VALUE) == 0 ? 9 : 10;
    }

    public static int y(int i10) {
        return A(i10 << 3);
    }

    public static int z(int i10) {
        if (i10 >= 0) {
            return A(i10);
        }
        return 10;
    }

    public final void b(int i10, c4 c4Var) throws IOException {
        j(i10, 2);
        if (c4Var.f23837b < 0) {
            c4Var.d();
        }
        f(c4Var.f23837b);
        c4Var.a(this);
    }

    public final void c(int i10, String str) throws IOException {
        j(i10, 2);
        try {
            int A = A(str.length());
            if (A != A(str.length() * 3)) {
                f(a(str));
                n(str, this.f24098a);
                return;
            }
            int position = this.f24098a.position();
            if (this.f24098a.remaining() < A) {
                throw new zzft(position + A, this.f24098a.limit());
            }
            this.f24098a.position(position + A);
            n(str, this.f24098a);
            int position2 = this.f24098a.position();
            this.f24098a.position(position);
            f((position2 - position) - A);
            this.f24098a.position(position2);
        } catch (BufferOverflowException e2) {
            zzft zzftVar = new zzft(this.f24098a.position(), this.f24098a.limit());
            zzftVar.initCause(e2);
            throw zzftVar;
        }
    }

    public final void d(int i10, byte[] bArr) throws IOException {
        j(i10, 2);
        f(bArr.length);
        int length = bArr.length;
        if (this.f24098a.remaining() < length) {
            throw new zzft(this.f24098a.position(), this.f24098a.limit());
        }
        this.f24098a.put(bArr, 0, length);
    }

    public final void e(int i10) throws IOException {
        byte b4 = (byte) i10;
        if (!this.f24098a.hasRemaining()) {
            throw new zzft(this.f24098a.position(), this.f24098a.limit());
        }
        this.f24098a.put(b4);
    }

    public final void f(int i10) throws IOException {
        while ((i10 & (-128)) != 0) {
            e((i10 & 127) | 128);
            i10 >>>= 7;
        }
        e(i10);
    }

    public final void j(int i10, int i11) throws IOException {
        f((i10 << 3) | i11);
    }

    public final void k(int i10, boolean z10) throws IOException {
        j(25, 0);
        byte b4 = z10 ? (byte) 1 : (byte) 0;
        if (!this.f24098a.hasRemaining()) {
            throw new zzft(this.f24098a.position(), this.f24098a.limit());
        }
        this.f24098a.put(b4);
    }

    public final void l(int i10, int i11) throws IOException {
        j(i10, 0);
        if (i11 >= 0) {
            f(i11);
        } else {
            w(i11);
        }
    }

    public final void o(int i10, a2 a2Var) throws IOException {
        if (this.f24099b != null) {
            if (this.f24100c != this.f24098a.position()) {
                this.f24099b.c(this.f24098a.array(), this.f24100c, this.f24098a.position() - this.f24100c);
            }
            zzbn zzbnVar = this.f24099b;
            zzbnVar.n(i10, a2Var);
            zzbnVar.b();
            this.f24100c = this.f24098a.position();
        }
        this.f24099b = zzbn.f(this.f24098a);
        this.f24100c = this.f24098a.position();
        zzbn zzbnVar2 = this.f24099b;
        zzbnVar2.n(i10, a2Var);
        zzbnVar2.b();
        this.f24100c = this.f24098a.position();
    }

    public final void p() {
        if (this.f24098a.remaining() != 0) {
            throw new IllegalStateException(String.format("Did not write as much data as expected, %s bytes remaining.", Integer.valueOf(this.f24098a.remaining())));
        }
    }

    public final void u(int i10, long j10) throws IOException {
        j(i10, 0);
        w(j10);
    }

    public final void w(long j10) throws IOException {
        while (((-128) & j10) != 0) {
            e((((int) j10) & 127) | 128);
            j10 >>>= 7;
        }
        e((int) j10);
    }
}
