package com.google.common.io;

import com.google.common.base.l;
import com.google.common.base.o;
import java.io.IOException;
import java.math.RoundingMode;
import java.util.Arrays;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class BaseEncoding {

    /* renamed from: a, reason: collision with root package name */
    public static final BaseEncoding f26658a = new c("base64()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", '=');

    /* renamed from: b, reason: collision with root package name */
    public static final BaseEncoding f26659b = new c("base64Url()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_", '=');

    /* renamed from: c, reason: collision with root package name */
    public static final BaseEncoding f26660c = new d("base32()", "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567", '=');

    /* renamed from: d, reason: collision with root package name */
    public static final BaseEncoding f26661d = new d("base32Hex()", "0123456789ABCDEFGHIJKLMNOPQRSTUV", '=');

    /* renamed from: e, reason: collision with root package name */
    public static final BaseEncoding f26662e = new b("base16()", "0123456789ABCDEF");

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class DecodingException extends IOException {
        public DecodingException(String str) {
            super(str);
        }

        public DecodingException(Throwable th) {
            super(th);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final String f26663a;

        /* renamed from: b, reason: collision with root package name */
        public final char[] f26664b;

        /* renamed from: c, reason: collision with root package name */
        public final int f26665c;

        /* renamed from: d, reason: collision with root package name */
        public final int f26666d;

        /* renamed from: e, reason: collision with root package name */
        public final int f26667e;

        /* renamed from: f, reason: collision with root package name */
        public final int f26668f;

        /* renamed from: g, reason: collision with root package name */
        public final byte[] f26669g;

        /* renamed from: h, reason: collision with root package name */
        public final boolean[] f26670h;

        public a(String str, char[] cArr) {
            this.f26663a = (String) o.r(str);
            this.f26664b = (char[]) o.r(cArr);
            try {
                int f10 = com.google.common.math.d.f(cArr.length, RoundingMode.UNNECESSARY);
                this.f26666d = f10;
                int min = Math.min(8, Integer.lowestOneBit(f10));
                try {
                    this.f26667e = 8 / min;
                    this.f26668f = f10 / min;
                    this.f26665c = cArr.length - 1;
                    byte[] bArr = new byte[128];
                    Arrays.fill(bArr, (byte) -1);
                    for (int i10 = 0; i10 < cArr.length; i10++) {
                        char c4 = cArr[i10];
                        o.f(c4 < 128, "Non-ASCII character: %s", c4);
                        o.f(bArr[c4] == -1, "Duplicate character: %s", c4);
                        bArr[c4] = (byte) i10;
                    }
                    this.f26669g = bArr;
                    boolean[] zArr = new boolean[this.f26667e];
                    for (int i11 = 0; i11 < this.f26668f; i11++) {
                        zArr[com.google.common.math.d.c(i11 * 8, this.f26666d, RoundingMode.CEILING)] = true;
                    }
                    this.f26670h = zArr;
                } catch (ArithmeticException e2) {
                    String str2 = new String(cArr);
                    throw new IllegalArgumentException(str2.length() != 0 ? "Illegal alphabet ".concat(str2) : new String("Illegal alphabet "), e2);
                }
            } catch (ArithmeticException e10) {
                int length = cArr.length;
                StringBuilder sb2 = new StringBuilder(35);
                sb2.append("Illegal alphabet length ");
                sb2.append(length);
                throw new IllegalArgumentException(sb2.toString(), e10);
            }
        }

        public int b(char c4) throws DecodingException {
            if (c4 > 127) {
                String valueOf = String.valueOf(Integer.toHexString(c4));
                throw new DecodingException(valueOf.length() != 0 ? "Unrecognized character: 0x".concat(valueOf) : new String("Unrecognized character: 0x"));
            }
            byte b4 = this.f26669g[c4];
            if (b4 != -1) {
                return b4;
            }
            if (c4 > ' ' && c4 != 127) {
                StringBuilder sb2 = new StringBuilder(25);
                sb2.append("Unrecognized character: ");
                sb2.append(c4);
                throw new DecodingException(sb2.toString());
            }
            String valueOf2 = String.valueOf(Integer.toHexString(c4));
            throw new DecodingException(valueOf2.length() != 0 ? "Unrecognized character: 0x".concat(valueOf2) : new String("Unrecognized character: 0x"));
        }

        public char c(int i10) {
            return this.f26664b[i10];
        }

        public boolean d(int i10) {
            return this.f26670h[i10 % this.f26667e];
        }

        public boolean e(char c4) {
            byte[] bArr = this.f26669g;
            return c4 < bArr.length && bArr[c4] != -1;
        }

        public boolean equals(Object obj) {
            if (obj instanceof a) {
                return Arrays.equals(this.f26664b, ((a) obj).f26664b);
            }
            return false;
        }

        public int hashCode() {
            return Arrays.hashCode(this.f26664b);
        }

        public String toString() {
            return this.f26663a;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class b extends d {

        /* renamed from: h, reason: collision with root package name */
        public final char[] f26671h;

        public b(String str, String str2) {
            this(new a(str, str2.toCharArray()));
        }

        @Override // com.google.common.io.BaseEncoding.d, com.google.common.io.BaseEncoding
        public int d(byte[] bArr, CharSequence charSequence) throws DecodingException {
            o.r(bArr);
            if (charSequence.length() % 2 != 1) {
                int i10 = 0;
                int i11 = 0;
                while (i10 < charSequence.length()) {
                    bArr[i11] = (byte) ((this.f26672f.b(charSequence.charAt(i10)) << 4) | this.f26672f.b(charSequence.charAt(i10 + 1)));
                    i10 += 2;
                    i11++;
                }
                return i11;
            }
            int length = charSequence.length();
            StringBuilder sb2 = new StringBuilder(32);
            sb2.append("Invalid input length ");
            sb2.append(length);
            throw new DecodingException(sb2.toString());
        }

        @Override // com.google.common.io.BaseEncoding.d, com.google.common.io.BaseEncoding
        public void g(Appendable appendable, byte[] bArr, int i10, int i11) throws IOException {
            o.r(appendable);
            o.w(i10, i10 + i11, bArr.length);
            for (int i12 = 0; i12 < i11; i12++) {
                int i13 = bArr[i10 + i12] & 255;
                appendable.append(this.f26671h[i13]);
                appendable.append(this.f26671h[i13 | 256]);
            }
        }

        @Override // com.google.common.io.BaseEncoding.d
        public BaseEncoding n(a aVar, Character ch) {
            return new b(aVar);
        }

        public b(a aVar) {
            super(aVar, null);
            this.f26671h = new char[512];
            o.d(aVar.f26664b.length == 16);
            for (int i10 = 0; i10 < 256; i10++) {
                this.f26671h[i10] = aVar.c(i10 >>> 4);
                this.f26671h[i10 | 256] = aVar.c(i10 & 15);
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class c extends d {
        public c(String str, String str2, Character ch) {
            this(new a(str, str2.toCharArray()), ch);
        }

        @Override // com.google.common.io.BaseEncoding.d, com.google.common.io.BaseEncoding
        public int d(byte[] bArr, CharSequence charSequence) throws DecodingException {
            o.r(bArr);
            CharSequence l10 = l(charSequence);
            if (this.f26672f.d(l10.length())) {
                int i10 = 0;
                int i11 = 0;
                while (i10 < l10.length()) {
                    int i12 = i10 + 1;
                    int i13 = i12 + 1;
                    int b4 = (this.f26672f.b(l10.charAt(i10)) << 18) | (this.f26672f.b(l10.charAt(i12)) << 12);
                    int i14 = i11 + 1;
                    bArr[i11] = (byte) (b4 >>> 16);
                    if (i13 < l10.length()) {
                        int i15 = i13 + 1;
                        int b10 = b4 | (this.f26672f.b(l10.charAt(i13)) << 6);
                        i11 = i14 + 1;
                        bArr[i14] = (byte) ((b10 >>> 8) & 255);
                        if (i15 < l10.length()) {
                            i13 = i15 + 1;
                            i14 = i11 + 1;
                            bArr[i11] = (byte) ((b10 | this.f26672f.b(l10.charAt(i15))) & 255);
                        } else {
                            i10 = i15;
                        }
                    }
                    i11 = i14;
                    i10 = i13;
                }
                return i11;
            }
            int length = l10.length();
            StringBuilder sb2 = new StringBuilder(32);
            sb2.append("Invalid input length ");
            sb2.append(length);
            throw new DecodingException(sb2.toString());
        }

        @Override // com.google.common.io.BaseEncoding.d, com.google.common.io.BaseEncoding
        public void g(Appendable appendable, byte[] bArr, int i10, int i11) throws IOException {
            o.r(appendable);
            int i12 = i10 + i11;
            o.w(i10, i12, bArr.length);
            while (i11 >= 3) {
                int i13 = i10 + 1;
                int i14 = i13 + 1;
                int i15 = ((bArr[i10] & 255) << 16) | ((bArr[i13] & 255) << 8) | (bArr[i14] & 255);
                appendable.append(this.f26672f.c(i15 >>> 18));
                appendable.append(this.f26672f.c((i15 >>> 12) & 63));
                appendable.append(this.f26672f.c((i15 >>> 6) & 63));
                appendable.append(this.f26672f.c(i15 & 63));
                i11 -= 3;
                i10 = i14 + 1;
            }
            if (i10 < i12) {
                m(appendable, bArr, i10, i12 - i10);
            }
        }

        @Override // com.google.common.io.BaseEncoding.d
        public BaseEncoding n(a aVar, Character ch) {
            return new c(aVar, ch);
        }

        public c(a aVar, Character ch) {
            super(aVar, ch);
            o.d(aVar.f26664b.length == 64);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class d extends BaseEncoding {

        /* renamed from: f, reason: collision with root package name */
        public final a f26672f;

        /* renamed from: g, reason: collision with root package name */
        public final Character f26673g;

        public d(String str, String str2, Character ch) {
            this(new a(str, str2.toCharArray()), ch);
        }

        @Override // com.google.common.io.BaseEncoding
        public int d(byte[] bArr, CharSequence charSequence) throws DecodingException {
            a aVar;
            o.r(bArr);
            CharSequence l10 = l(charSequence);
            if (this.f26672f.d(l10.length())) {
                int i10 = 0;
                int i11 = 0;
                while (i10 < l10.length()) {
                    long j10 = 0;
                    int i12 = 0;
                    int i13 = 0;
                    while (true) {
                        aVar = this.f26672f;
                        if (i12 >= aVar.f26667e) {
                            break;
                        }
                        j10 <<= aVar.f26666d;
                        if (i10 + i12 < l10.length()) {
                            j10 |= this.f26672f.b(l10.charAt(i13 + i10));
                            i13++;
                        }
                        i12++;
                    }
                    int i14 = aVar.f26668f;
                    int i15 = (i14 * 8) - (i13 * aVar.f26666d);
                    int i16 = (i14 - 1) * 8;
                    while (i16 >= i15) {
                        bArr[i11] = (byte) ((j10 >>> i16) & 255);
                        i16 -= 8;
                        i11++;
                    }
                    i10 += this.f26672f.f26667e;
                }
                return i11;
            }
            int length = l10.length();
            StringBuilder sb2 = new StringBuilder(32);
            sb2.append("Invalid input length ");
            sb2.append(length);
            throw new DecodingException(sb2.toString());
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return this.f26672f.equals(dVar.f26672f) && l.a(this.f26673g, dVar.f26673g);
        }

        @Override // com.google.common.io.BaseEncoding
        public void g(Appendable appendable, byte[] bArr, int i10, int i11) throws IOException {
            o.r(appendable);
            o.w(i10, i10 + i11, bArr.length);
            int i12 = 0;
            while (i12 < i11) {
                m(appendable, bArr, i10 + i12, Math.min(this.f26672f.f26668f, i11 - i12));
                i12 += this.f26672f.f26668f;
            }
        }

        public int hashCode() {
            return this.f26672f.hashCode() ^ l.b(this.f26673g);
        }

        @Override // com.google.common.io.BaseEncoding
        public int i(int i10) {
            return (int) (((this.f26672f.f26666d * i10) + 7) / 8);
        }

        @Override // com.google.common.io.BaseEncoding
        public int j(int i10) {
            a aVar = this.f26672f;
            return aVar.f26667e * com.google.common.math.d.c(i10, aVar.f26668f, RoundingMode.CEILING);
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding k() {
            return this.f26673g == null ? this : n(this.f26672f, null);
        }

        @Override // com.google.common.io.BaseEncoding
        public CharSequence l(CharSequence charSequence) {
            o.r(charSequence);
            Character ch = this.f26673g;
            if (ch == null) {
                return charSequence;
            }
            char charValue = ch.charValue();
            int length = charSequence.length() - 1;
            while (length >= 0 && charSequence.charAt(length) == charValue) {
                length--;
            }
            return charSequence.subSequence(0, length + 1);
        }

        public void m(Appendable appendable, byte[] bArr, int i10, int i11) throws IOException {
            o.r(appendable);
            o.w(i10, i10 + i11, bArr.length);
            int i12 = 0;
            o.d(i11 <= this.f26672f.f26668f);
            long j10 = 0;
            for (int i13 = 0; i13 < i11; i13++) {
                j10 = (j10 | (bArr[i10 + i13] & 255)) << 8;
            }
            int i14 = ((i11 + 1) * 8) - this.f26672f.f26666d;
            while (i12 < i11 * 8) {
                a aVar = this.f26672f;
                appendable.append(aVar.c(((int) (j10 >>> (i14 - i12))) & aVar.f26665c));
                i12 += this.f26672f.f26666d;
            }
            if (this.f26673g != null) {
                while (i12 < this.f26672f.f26668f * 8) {
                    appendable.append(this.f26673g.charValue());
                    i12 += this.f26672f.f26666d;
                }
            }
        }

        public BaseEncoding n(a aVar, Character ch) {
            return new d(aVar, ch);
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder("BaseEncoding.");
            sb2.append(this.f26672f.toString());
            if (8 % this.f26672f.f26666d != 0) {
                if (this.f26673g == null) {
                    sb2.append(".omitPadding()");
                } else {
                    sb2.append(".withPadChar('");
                    sb2.append((Object) this.f26673g);
                    sb2.append("')");
                }
            }
            return sb2.toString();
        }

        public d(a aVar, Character ch) {
            this.f26672f = (a) o.r(aVar);
            o.m(ch == null || !aVar.e(ch.charValue()), "Padding character %s was already in alphabet", ch);
            this.f26673g = ch;
        }
    }

    public static BaseEncoding a() {
        return f26658a;
    }

    public static byte[] h(byte[] bArr, int i10) {
        if (i10 == bArr.length) {
            return bArr;
        }
        byte[] bArr2 = new byte[i10];
        System.arraycopy((Object) bArr, 0, (Object) bArr2, 0, i10);
        return bArr2;
    }

    public final byte[] b(CharSequence charSequence) {
        try {
            return c(charSequence);
        } catch (DecodingException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public final byte[] c(CharSequence charSequence) throws DecodingException {
        CharSequence l10 = l(charSequence);
        byte[] bArr = new byte[i(l10.length())];
        return h(bArr, d(bArr, l10));
    }

    public abstract int d(byte[] bArr, CharSequence charSequence) throws DecodingException;

    public String e(byte[] bArr) {
        return f(bArr, 0, bArr.length);
    }

    public final String f(byte[] bArr, int i10, int i11) {
        o.w(i10, i10 + i11, bArr.length);
        StringBuilder sb2 = new StringBuilder(j(i11));
        try {
            g(sb2, bArr, i10, i11);
            return sb2.toString();
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }

    public abstract void g(Appendable appendable, byte[] bArr, int i10, int i11) throws IOException;

    public abstract int i(int i10);

    public abstract int j(int i10);

    public abstract BaseEncoding k();

    public abstract CharSequence l(CharSequence charSequence);
}
