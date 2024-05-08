package java.util;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import org.apache.commons.io.IOUtils;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class Base64 {
    private Base64() {
    }

    public static Encoder getEncoder() {
        return Encoder.RFC4648;
    }

    public static Encoder getUrlEncoder() {
        return Encoder.RFC4648_URLSAFE;
    }

    public static Encoder getMimeEncoder() {
        return Encoder.RFC2045;
    }

    public static Encoder getMimeEncoder(int lineLength, byte[] lineSeparator) {
        Objects.requireNonNull(lineSeparator);
        int[] base64 = Decoder.fromBase64;
        for (byte b4 : lineSeparator) {
            if (base64[b4 & 255] != -1) {
                throw new IllegalArgumentException("Illegal base64 line separator character 0x" + Integer.toString(b4, 16));
            }
        }
        int lineLength2 = lineLength & (-4);
        if (lineLength2 <= 0) {
            return Encoder.RFC4648;
        }
        return new Encoder(false, lineSeparator, lineLength2, true);
    }

    public static Decoder getDecoder() {
        return Decoder.RFC4648;
    }

    public static Decoder getUrlDecoder() {
        return Decoder.RFC4648_URLSAFE;
    }

    public static Decoder getMimeDecoder() {
        return Decoder.RFC2045;
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class Encoder {
        private static final byte[] CRLF;
        private static final int MIMELINEMAX = 76;
        static final Encoder RFC2045;
        private final boolean doPadding;
        private final boolean isURL;
        private final int linemax;
        private final byte[] newline;
        private static final char[] toBase64 = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', Locale.PRIVATE_USE_EXTENSION, 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', IOUtils.DIR_SEPARATOR_UNIX};
        private static final char[] toBase64URL = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', Locale.PRIVATE_USE_EXTENSION, 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '-', '_'};
        static final Encoder RFC4648 = new Encoder(false, null, -1, true);
        static final Encoder RFC4648_URLSAFE = new Encoder(true, null, -1, true);

        private Encoder(boolean isURL, byte[] newline, int linemax, boolean doPadding) {
            this.isURL = isURL;
            this.newline = newline;
            this.linemax = linemax;
            this.doPadding = doPadding;
        }

        static {
            byte[] bArr = {13, 10};
            CRLF = bArr;
            RFC2045 = new Encoder(false, bArr, 76, true);
        }

        private final int encodedOutLength(int srclen, boolean throwOOME) {
            int len;
            try {
                if (this.doPadding) {
                    len = Math.multiplyExact(4, Math.addExact(srclen, 2) / 3);
                } else {
                    int n10 = srclen % 3;
                    len = Math.addExact(Math.multiplyExact(4, srclen / 3), n10 == 0 ? 0 : n10 + 1);
                }
                int n11 = this.linemax;
                if (n11 > 0) {
                    return Math.addExact(len, ((len - 1) / n11) * this.newline.length);
                }
                return len;
            } catch (ArithmeticException e2) {
                if (throwOOME) {
                    throw new OutOfMemoryError("Encoded size is too large");
                }
                return -1;
            }
        }

        public byte[] encode(byte[] src) {
            int len = encodedOutLength(src.length, true);
            byte[] dst = new byte[len];
            int ret = encode0(src, 0, src.length, dst);
            if (ret != dst.length) {
                return Arrays.copyOf(dst, ret);
            }
            return dst;
        }

        public int encode(byte[] src, byte[] dst) {
            int len = encodedOutLength(src.length, false);
            if (dst.length < len || len == -1) {
                throw new IllegalArgumentException("Output byte array is too small for encoding all input bytes");
            }
            return encode0(src, 0, src.length, dst);
        }

        public String encodeToString(byte[] src) {
            byte[] encoded = encode(src);
            return new String(encoded, 0, 0, encoded.length);
        }

        public ByteBuffer encode(ByteBuffer buffer) {
            int ret;
            int len = encodedOutLength(buffer.remaining(), true);
            byte[] dst = new byte[len];
            if (buffer.hasArray()) {
                ret = encode0(buffer.array(), buffer.arrayOffset() + buffer.position(), buffer.arrayOffset() + buffer.limit(), dst);
                buffer.position(buffer.limit());
            } else {
                byte[] src = new byte[buffer.remaining()];
                buffer.get(src);
                ret = encode0(src, 0, src.length, dst);
            }
            if (ret != dst.length) {
                dst = Arrays.copyOf(dst, ret);
            }
            return ByteBuffer.wrap(dst);
        }

        public OutputStream wrap(OutputStream os) {
            Objects.requireNonNull(os);
            return new EncOutputStream(os, this.isURL ? toBase64URL : toBase64, this.newline, this.linemax, this.doPadding);
        }

        public Encoder withoutPadding() {
            if (!this.doPadding) {
                return this;
            }
            return new Encoder(this.isURL, this.newline, this.linemax, false);
        }

        private void encodeBlock(byte[] src, int sp, int sl, byte[] dst, int dp, boolean isURL) {
            char[] base64 = isURL ? toBase64URL : toBase64;
            int bits = sp;
            int dp0 = dp;
            while (bits < sl) {
                int sp0 = bits + 1;
                int sp02 = sp0 + 1;
                int i10 = ((src[bits] & 255) << 16) | ((src[sp0] & 255) << 8);
                int sp03 = sp02 + 1;
                int bits2 = i10 | (src[sp02] & 255);
                int dp02 = dp0 + 1;
                dst[dp0] = (byte) base64[(bits2 >>> 18) & 63];
                int dp03 = dp02 + 1;
                dst[dp02] = (byte) base64[(bits2 >>> 12) & 63];
                int dp04 = dp03 + 1;
                dst[dp03] = (byte) base64[(bits2 >>> 6) & 63];
                dp0 = dp04 + 1;
                dst[dp04] = (byte) base64[bits2 & 63];
                bits = sp03;
            }
        }

        private int encode0(byte[] src, int off, int end, byte[] dst) {
            int slen;
            char[] base64 = this.isURL ? toBase64URL : toBase64;
            int slen2 = ((end - off) / 3) * 3;
            int sl = off + slen2;
            int i10 = this.linemax;
            if (i10 > 0 && slen2 > (i10 / 4) * 3) {
                slen = (i10 / 4) * 3;
            } else {
                slen = slen2;
            }
            int sp = off;
            int dp = 0;
            while (sp < sl) {
                int sl0 = Math.min(sp + slen, sl);
                encodeBlock(src, sp, sl0, dst, dp, this.isURL);
                int dlen = ((sl0 - sp) / 3) * 4;
                dp += dlen;
                sp = sl0;
                if (dlen == this.linemax && sp < end) {
                    byte[] bArr = this.newline;
                    int length = bArr.length;
                    int i11 = 0;
                    while (i11 < length) {
                        byte b4 = bArr[i11];
                        dst[dp] = b4;
                        i11++;
                        dp++;
                    }
                }
            }
            if (sp < end) {
                int sp2 = sp + 1;
                int b02 = src[sp] & 255;
                int dp2 = dp + 1;
                dst[dp] = (byte) base64[b02 >> 2];
                if (sp2 == end) {
                    int dp3 = dp2 + 1;
                    dst[dp2] = (byte) base64[(b02 << 4) & 63];
                    if (this.doPadding) {
                        int dp4 = dp3 + 1;
                        dst[dp3] = 61;
                        int dp5 = dp4 + 1;
                        dst[dp4] = 61;
                        return dp5;
                    }
                    return dp3;
                }
                int i12 = sp2 + 1;
                int b12 = src[sp2] & 255;
                int dp6 = dp2 + 1;
                dst[dp2] = (byte) base64[((b02 << 4) & 63) | (b12 >> 4)];
                int dp7 = dp6 + 1;
                dst[dp6] = (byte) base64[(b12 << 2) & 63];
                if (this.doPadding) {
                    int dp8 = dp7 + 1;
                    dst[dp7] = 61;
                    return dp8;
                }
                return dp7;
            }
            return dp;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class Decoder {
        static final Decoder RFC2045;
        static final Decoder RFC4648;
        static final Decoder RFC4648_URLSAFE;
        private static final int[] fromBase64;
        private static final int[] fromBase64URL;
        private final boolean isMIME;
        private final boolean isURL;

        private Decoder(boolean isURL, boolean isMIME) {
            this.isURL = isURL;
            this.isMIME = isMIME;
        }

        static {
            int[] iArr = new int[256];
            fromBase64 = iArr;
            Arrays.fill(iArr, -1);
            for (int i10 = 0; i10 < Encoder.toBase64.length; i10++) {
                fromBase64[Encoder.toBase64[i10]] = i10;
            }
            fromBase64[61] = -2;
            int[] iArr2 = new int[256];
            fromBase64URL = iArr2;
            Arrays.fill(iArr2, -1);
            for (int i11 = 0; i11 < Encoder.toBase64URL.length; i11++) {
                fromBase64URL[Encoder.toBase64URL[i11]] = i11;
            }
            fromBase64URL[61] = -2;
            RFC4648 = new Decoder(false, false);
            RFC4648_URLSAFE = new Decoder(true, false);
            RFC2045 = new Decoder(false, true);
        }

        public byte[] decode(byte[] src) {
            byte[] dst = new byte[decodedOutLength(src, 0, src.length)];
            int ret = decode0(src, 0, src.length, dst);
            if (ret != dst.length) {
                return Arrays.copyOf(dst, ret);
            }
            return dst;
        }

        public byte[] decode(String src) {
            return decode(src.getBytes(StandardCharsets.ISO_8859_1));
        }

        public int decode(byte[] src, byte[] dst) {
            int len = decodedOutLength(src, 0, src.length);
            if (dst.length < len || len == -1) {
                throw new IllegalArgumentException("Output byte array is too small for decoding all input bytes");
            }
            return decode0(src, 0, src.length, dst);
        }

        public ByteBuffer decode(ByteBuffer buffer) {
            byte[] src;
            int sp;
            int sl;
            int pos0 = buffer.position();
            try {
                if (buffer.hasArray()) {
                    src = buffer.array();
                    sp = buffer.arrayOffset() + buffer.position();
                    sl = buffer.arrayOffset() + buffer.limit();
                    buffer.position(buffer.limit());
                } else {
                    src = new byte[buffer.remaining()];
                    buffer.get(src);
                    sp = 0;
                    sl = src.length;
                }
                byte[] dst = new byte[decodedOutLength(src, sp, sl)];
                return ByteBuffer.wrap(dst, 0, decode0(src, sp, sl, dst));
            } catch (IllegalArgumentException iae) {
                buffer.position(pos0);
                throw iae;
            }
        }

        public InputStream wrap(InputStream is) {
            Objects.requireNonNull(is);
            return new DecInputStream(is, this.isURL ? fromBase64URL : fromBase64, this.isMIME);
        }

        private int decodedOutLength(byte[] src, int b4, int sl) {
            int[] base64 = this.isURL ? fromBase64URL : fromBase64;
            int paddings = 0;
            int len = sl - b4;
            if (len == 0) {
                return 0;
            }
            if (len < 2) {
                if (this.isMIME && base64[0] == -1) {
                    return 0;
                }
                throw new IllegalArgumentException("Input byte[] should at least have 2 bytes for base64 bytes");
            }
            if (this.isMIME) {
                int n10 = 0;
                while (true) {
                    if (b4 >= sl) {
                        break;
                    }
                    int sp = b4 + 1;
                    int b10 = src[b4] & 255;
                    if (b10 != 61) {
                        if (base64[b10] == -1) {
                            n10++;
                        }
                        b4 = sp;
                    } else {
                        len -= (sl - sp) + 1;
                        break;
                    }
                }
                len -= n10;
            } else if (src[sl - 1] == 61) {
                paddings = 0 + 1;
                if (src[sl - 2] == 61) {
                    paddings++;
                }
            }
            if (paddings == 0 && (len & 3) != 0) {
                paddings = 4 - (len & 3);
            }
            return (((int) ((len + 3) / 4)) * 3) - paddings;
        }

        private int decodeBlock(byte[] src, int sp, int sl, byte[] dst, int dp, boolean isURL, boolean isMIME) {
            int[] base64 = isURL ? fromBase64URL : fromBase64;
            int sl0 = ((sl - sp) & (-4)) + sp;
            int new_dp = dp;
            int b12 = sp;
            while (b12 < sl0) {
                int sp2 = b12 + 1;
                int b13 = base64[src[b12] & 255];
                int sp3 = sp2 + 1;
                int b22 = base64[src[sp2] & 255];
                int sp4 = sp3 + 1;
                int b32 = base64[src[sp3] & 255];
                int sp5 = sp4 + 1;
                int b4 = base64[src[sp4] & 255];
                if ((b13 | b22 | b32 | b4) < 0) {
                    return new_dp - dp;
                }
                int bits0 = (b13 << 18) | (b22 << 12) | (b32 << 6) | b4;
                int new_dp2 = new_dp + 1;
                dst[new_dp] = (byte) (bits0 >> 16);
                int new_dp3 = new_dp2 + 1;
                dst[new_dp2] = (byte) (bits0 >> 8);
                dst[new_dp3] = (byte) bits0;
                b12 = sp5;
                new_dp = new_dp3 + 1;
            }
            return new_dp - dp;
        }

        /* JADX WARN: Code restructure failed: missing block: B:43:0x00bf, code lost:
        
            if (r14 != 6) goto L45;
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x00c1, code lost:
        
            r21[r12] = (byte) (r13 >> 16);
            r12 = r12 + 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x00df, code lost:
        
            if (r11 >= r20) goto L72;
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x00e3, code lost:
        
            if (r17.isMIME == false) goto L70;
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x00e5, code lost:
        
            r0 = r11 + 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x00ed, code lost:
        
            if (r10[r18[r11] & 255] >= 0) goto L71;
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x00ef, code lost:
        
            r11 = r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:53:0x00f1, code lost:
        
            r11 = r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x010a, code lost:
        
            throw new java.lang.IllegalArgumentException("Input byte array has incorrect ending byte at " + r11);
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x010b, code lost:
        
            return r12;
         */
        /* JADX WARN: Code restructure failed: missing block: B:59:0x00ca, code lost:
        
            if (r14 != 0) goto L47;
         */
        /* JADX WARN: Code restructure failed: missing block: B:60:0x00cc, code lost:
        
            r0 = r12 + 1;
            r21[r12] = (byte) (r13 >> 16);
            r12 = r0 + 1;
            r21[r0] = (byte) (r13 >> 8);
         */
        /* JADX WARN: Code restructure failed: missing block: B:62:0x00dd, code lost:
        
            if (r14 == 12) goto L59;
         */
        /* JADX WARN: Code restructure failed: missing block: B:64:0x0113, code lost:
        
            throw new java.lang.IllegalArgumentException("Last unit does not have enough valid bits");
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private int decode0(byte[] r18, int r19, int r20, byte[] r21) {
            /*
                Method dump skipped, instructions count: 276
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.Base64.Decoder.decode0(byte[], int, int, byte[]):int");
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private static class EncOutputStream extends FilterOutputStream {

        /* renamed from: b0, reason: collision with root package name */
        private int f50431b0;

        /* renamed from: b1, reason: collision with root package name */
        private int f50432b1;

        /* renamed from: b2, reason: collision with root package name */
        private int f50433b2;
        private final char[] base64;
        private byte[] buf;
        private boolean closed;
        private final boolean doPadding;
        private int leftover;
        private final int linemax;
        private int linepos;
        private final byte[] newline;

        EncOutputStream(OutputStream os, char[] base64, byte[] newline, int linemax, boolean doPadding) {
            super(os);
            this.leftover = 0;
            this.closed = false;
            this.linepos = 0;
            this.base64 = base64;
            this.newline = newline;
            this.linemax = linemax;
            this.doPadding = doPadding;
            this.buf = new byte[linemax <= 0 ? 8124 : linemax];
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(int b4) throws IOException {
            byte[] buf = {(byte) (b4 & 255)};
            write(buf, 0, 1);
        }

        private void checkNewline() throws IOException {
            if (this.linepos == this.linemax) {
                this.out.write(this.newline);
                this.linepos = 0;
            }
        }

        private void writeb4(char b12, char b22, char b32, char b4) throws IOException {
            byte[] bArr = this.buf;
            bArr[0] = (byte) b12;
            bArr[1] = (byte) b22;
            bArr[2] = (byte) b32;
            bArr[3] = (byte) b4;
            this.out.write(this.buf, 0, 4);
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] b4, int off, int len) throws IOException {
            if (this.closed) {
                throw new IOException("Stream is closed");
            }
            if (off < 0 || len < 0 || len > b4.length - off) {
                throw new ArrayIndexOutOfBoundsException();
            }
            if (len == 0) {
                return;
            }
            int i10 = this.leftover;
            if (i10 != 0) {
                if (i10 == 1) {
                    int off2 = off + 1;
                    this.f50432b1 = b4[off] & 255;
                    len--;
                    if (len != 0) {
                        off = off2;
                    } else {
                        this.leftover = i10 + 1;
                        return;
                    }
                }
                int off3 = off + 1;
                this.f50433b2 = b4[off] & 255;
                len--;
                checkNewline();
                char[] cArr = this.base64;
                int i11 = this.f50431b0;
                char c4 = cArr[i11 >> 2];
                int i12 = this.f50432b1;
                char c10 = cArr[((i11 << 4) & 63) | (i12 >> 4)];
                int i13 = this.f50433b2;
                writeb4(c4, c10, cArr[((i12 << 2) & 63) | (i13 >> 6)], cArr[i13 & 63]);
                this.linepos += 4;
                off = off3;
            }
            int nBits24 = len / 3;
            this.leftover = len - (nBits24 * 3);
            while (nBits24 > 0) {
                checkNewline();
                int dl = this.linemax <= 0 ? this.buf.length : this.buf.length - this.linepos;
                int sl = (Math.min(nBits24, dl / 4) * 3) + off;
                int dp = 0;
                int bits = off;
                while (bits < sl) {
                    int sp = bits + 1;
                    int sp2 = sp + 1;
                    int i14 = ((b4[bits] & 255) << 16) | ((b4[sp] & 255) << 8);
                    int sp3 = sp2 + 1;
                    int bits2 = i14 | (b4[sp2] & 255);
                    byte[] bArr = this.buf;
                    int dp2 = dp + 1;
                    char[] cArr2 = this.base64;
                    bArr[dp] = (byte) cArr2[(bits2 >>> 18) & 63];
                    int dp3 = dp2 + 1;
                    bArr[dp2] = (byte) cArr2[(bits2 >>> 12) & 63];
                    int dp4 = dp3 + 1;
                    bArr[dp3] = (byte) cArr2[(bits2 >>> 6) & 63];
                    dp = dp4 + 1;
                    bArr[dp4] = (byte) cArr2[bits2 & 63];
                    bits = sp3;
                }
                this.out.write(this.buf, 0, dp);
                off = sl;
                this.linepos += dp;
                nBits24 -= dp / 4;
            }
            int i15 = this.leftover;
            if (i15 == 1) {
                int i16 = off + 1;
                this.f50431b0 = b4[off] & 255;
            } else if (i15 == 2) {
                int off4 = off + 1;
                this.f50431b0 = b4[off] & 255;
                int i17 = off4 + 1;
                this.f50432b1 = b4[off4] & 255;
            }
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (!this.closed) {
                this.closed = true;
                int i10 = this.leftover;
                if (i10 == 1) {
                    checkNewline();
                    this.out.write(this.base64[this.f50431b0 >> 2]);
                    this.out.write(this.base64[(this.f50431b0 << 4) & 63]);
                    if (this.doPadding) {
                        this.out.write(61);
                        this.out.write(61);
                    }
                } else if (i10 == 2) {
                    checkNewline();
                    this.out.write(this.base64[this.f50431b0 >> 2]);
                    this.out.write(this.base64[((this.f50431b0 << 4) & 63) | (this.f50432b1 >> 4)]);
                    this.out.write(this.base64[(this.f50432b1 << 2) & 63]);
                    if (this.doPadding) {
                        this.out.write(61);
                    }
                }
                this.leftover = 0;
                this.out.close();
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private static class DecInputStream extends InputStream {
        private final int[] base64;
        private final InputStream is;
        private final boolean isMIME;
        private int bits = 0;
        private int wpos = 0;
        private int rpos = 0;
        private boolean eof = false;
        private boolean closed = false;
        private byte[] sbBuf = new byte[1];

        DecInputStream(InputStream is, int[] base64, boolean isMIME) {
            this.is = is;
            this.base64 = base64;
            this.isMIME = isMIME;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            if (read(this.sbBuf, 0, 1) == -1) {
                return -1;
            }
            return this.sbBuf[0] & 255;
        }

        private int leftovers(byte[] b4, int off, int pos, int limit) {
            int i10;
            int i11;
            this.eof = true;
            while (true) {
                i10 = this.rpos;
                int i12 = i10 - 8;
                i11 = this.wpos;
                if (i12 < i11 || pos == limit) {
                    break;
                }
                int i13 = i10 - 8;
                this.rpos = i13;
                b4[pos] = (byte) (this.bits >> i13);
                pos++;
            }
            if (pos - off != 0 || i10 - 8 >= i11) {
                return pos - off;
            }
            return -1;
        }

        private int eof(byte[] b4, int off, int pos, int limit) throws IOException {
            if (this.wpos == 18) {
                throw new IOException("Base64 stream has one un-decoded dangling byte.");
            }
            this.rpos = 24;
            return leftovers(b4, off, pos, limit);
        }

        private int padding(byte[] b4, int off, int pos, int limit) throws IOException {
            int i10 = this.wpos;
            if (i10 >= 18 || (i10 == 12 && this.is.read() != 61)) {
                throw new IOException("Illegal base64 ending sequence:" + this.wpos);
            }
            this.rpos = 24;
            return leftovers(b4, off, pos, limit);
        }

        @Override // java.io.InputStream
        public int read(byte[] b4, int off, int len) throws IOException {
            if (this.closed) {
                throw new IOException("Stream is closed");
            }
            Objects.checkFromIndexSize(off, len, b4.length);
            if (len == 0) {
                return 0;
            }
            int pos = off;
            int limit = off + len;
            if (this.eof) {
                return leftovers(b4, off, pos, limit);
            }
            if (this.rpos == 16) {
                int pos2 = pos + 1;
                b4[pos] = (byte) (this.bits >> 8);
                this.rpos = 8;
                if (pos2 != limit) {
                    pos = pos2;
                } else {
                    return len;
                }
            }
            if (this.rpos == 8) {
                int pos3 = pos + 1;
                b4[pos] = (byte) this.bits;
                this.rpos = 0;
                if (pos3 != limit) {
                    pos = pos3;
                } else {
                    return len;
                }
            }
            this.bits = 0;
            this.wpos = 24;
            while (true) {
                int i10 = this.is.read();
                if (i10 < 0) {
                    return eof(b4, off, pos, limit);
                }
                int v2 = this.base64[i10];
                if (v2 < 0) {
                    if (v2 == -1) {
                        if (!this.isMIME) {
                            throw new IOException("Illegal base64 character 0x" + Integer.toHexString(i10));
                        }
                    } else {
                        return padding(b4, off, pos, limit);
                    }
                } else {
                    int i11 = this.wpos - 6;
                    this.wpos = i11;
                    int i12 = this.bits | (v2 << i11);
                    this.bits = i12;
                    if (i11 != 0) {
                        continue;
                    } else if (limit - pos >= 3) {
                        int pos4 = pos + 1;
                        b4[pos] = (byte) (i12 >> 16);
                        int pos5 = pos4 + 1;
                        b4[pos4] = (byte) (i12 >> 8);
                        int pos6 = pos5 + 1;
                        b4[pos5] = (byte) i12;
                        this.bits = 0;
                        this.wpos = 24;
                        if (pos6 != limit) {
                            pos = pos6;
                        } else {
                            return len;
                        }
                    } else {
                        int pos7 = pos + 1;
                        b4[pos] = (byte) (i12 >> 16);
                        if (pos7 == limit) {
                            this.rpos = 16;
                            return len;
                        }
                        int i13 = pos7 + 1;
                        b4[pos7] = (byte) (i12 >> 8);
                        this.rpos = 8;
                        return len;
                    }
                }
            }
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            if (this.closed) {
                throw new IOException("Stream is closed");
            }
            return this.is.available();
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (!this.closed) {
                this.closed = true;
                this.is.close();
            }
        }
    }
}
