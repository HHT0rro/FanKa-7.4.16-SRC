package io.grpc.okhttp.internal.proxy;

import com.android.internal.accessibility.common.ShortcutConstants;
import com.google.android.material.badge.BadgeDrawable;
import io.grpc.internal.GrpcUtil;
import java.io.EOFException;
import java.net.IDN;
import java.net.InetAddress;
import java.util.Locale;
import okio.Buffer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class HttpUrl {
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private final String host;
    private final int port;
    private final String scheme;
    private final String url;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class Builder {
        public String host;
        public int port = -1;
        public String scheme;

        private static String canonicalizeHost(String str, int i10, int i11) {
            String percentDecode = HttpUrl.percentDecode(str, i10, i11, false);
            if (percentDecode.startsWith("[") && percentDecode.endsWith("]")) {
                InetAddress decodeIpv6 = decodeIpv6(percentDecode, 1, percentDecode.length() - 1);
                if (decodeIpv6 == null) {
                    return null;
                }
                byte[] address = decodeIpv6.getAddress();
                if (address.length == 16) {
                    return inet6AddressToAscii(address);
                }
                throw new AssertionError();
            }
            return domainToAscii(percentDecode);
        }

        private static boolean containsInvalidHostnameAsciiCodes(String str) {
            for (int i10 = 0; i10 < str.length(); i10++) {
                char charAt = str.charAt(i10);
                if (charAt <= 31 || charAt >= 127 || " #%/:?@[\\]".indexOf(charAt) != -1) {
                    return true;
                }
            }
            return false;
        }

        private static boolean decodeIpv4Suffix(String str, int i10, int i11, byte[] bArr, int i12) {
            int i13 = i12;
            while (i10 < i11) {
                if (i13 == bArr.length) {
                    return false;
                }
                if (i13 != i12) {
                    if (str.charAt(i10) != '.') {
                        return false;
                    }
                    i10++;
                }
                int i14 = i10;
                int i15 = 0;
                while (i14 < i11) {
                    char charAt = str.charAt(i14);
                    if (charAt < '0' || charAt > '9') {
                        break;
                    }
                    if ((i15 == 0 && i10 != i14) || (i15 = ((i15 * 10) + charAt) - 48) > 255) {
                        return false;
                    }
                    i14++;
                }
                if (i14 - i10 == 0) {
                    return false;
                }
                bArr[i13] = (byte) i15;
                i13++;
                i10 = i14;
            }
            return i13 == i12 + 4;
        }

        /* JADX WARN: Code restructure failed: missing block: B:25:0x0079, code lost:
        
            return null;
         */
        /* JADX WARN: Removed duplicated region for block: B:15:0x004f  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static java.net.InetAddress decodeIpv6(java.lang.String r11, int r12, int r13) {
            /*
                r0 = 16
                byte[] r1 = new byte[r0]
                r2 = -1
                r3 = 0
                r4 = 0
                r5 = -1
                r6 = -1
            L9:
                r7 = 0
                if (r12 >= r13) goto L7a
                if (r4 != r0) goto Lf
                return r7
            Lf:
                int r8 = r12 + 2
                if (r8 > r13) goto L27
                java.lang.String r9 = "::"
                r10 = 2
                boolean r9 = r11.regionMatches(r12, r9, r3, r10)
                if (r9 == 0) goto L27
                if (r5 == r2) goto L1f
                return r7
            L1f:
                int r4 = r4 + 2
                r5 = r4
                if (r8 != r13) goto L25
                goto L7a
            L25:
                r6 = r8
                goto L4b
            L27:
                if (r4 == 0) goto L4a
                java.lang.String r8 = ":"
                r9 = 1
                boolean r8 = r11.regionMatches(r12, r8, r3, r9)
                if (r8 == 0) goto L35
                int r12 = r12 + 1
                goto L4a
            L35:
                java.lang.String r8 = "."
                boolean r12 = r11.regionMatches(r12, r8, r3, r9)
                if (r12 == 0) goto L49
                int r12 = r4 + (-2)
                boolean r11 = decodeIpv4Suffix(r11, r6, r13, r1, r12)
                if (r11 != 0) goto L46
                return r7
            L46:
                int r4 = r4 + 2
                goto L7a
            L49:
                return r7
            L4a:
                r6 = r12
            L4b:
                r12 = r6
                r8 = 0
            L4d:
                if (r12 >= r13) goto L60
                char r9 = r11.charAt(r12)
                int r9 = io.grpc.okhttp.internal.proxy.HttpUrl.decodeHexDigit(r9)
                if (r9 != r2) goto L5a
                goto L60
            L5a:
                int r8 = r8 << 4
                int r8 = r8 + r9
                int r12 = r12 + 1
                goto L4d
            L60:
                int r9 = r12 - r6
                if (r9 == 0) goto L79
                r10 = 4
                if (r9 <= r10) goto L68
                goto L79
            L68:
                int r7 = r4 + 1
                int r9 = r8 >>> 8
                r9 = r9 & 255(0xff, float:3.57E-43)
                byte r9 = (byte) r9
                r1[r4] = r9
                int r4 = r7 + 1
                r8 = r8 & 255(0xff, float:3.57E-43)
                byte r8 = (byte) r8
                r1[r7] = r8
                goto L9
            L79:
                return r7
            L7a:
                if (r4 == r0) goto L8b
                if (r5 != r2) goto L7f
                return r7
            L7f:
                int r11 = r4 - r5
                int r12 = 16 - r11
                java.lang.System.arraycopy(r1, r5, r1, r12, r11)
                int r0 = r0 - r4
                int r0 = r0 + r5
                java.util.Arrays.fill(r1, r5, r0, r3)
            L8b:
                java.net.InetAddress r11 = java.net.InetAddress.getByAddress(r1)     // Catch: java.net.UnknownHostException -> L90
                return r11
            L90:
                java.lang.AssertionError r11 = new java.lang.AssertionError
                r11.<init>()
                throw r11
            */
            throw new UnsupportedOperationException("Method not decompiled: io.grpc.okhttp.internal.proxy.HttpUrl.Builder.decodeIpv6(java.lang.String, int, int):java.net.InetAddress");
        }

        private static String domainToAscii(String str) {
            try {
                String lowerCase = IDN.toASCII(str).toLowerCase(Locale.US);
                if (lowerCase.isEmpty()) {
                    return null;
                }
                if (containsInvalidHostnameAsciiCodes(lowerCase)) {
                    return null;
                }
                return lowerCase;
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        private static String inet6AddressToAscii(byte[] bArr) {
            int i10 = 0;
            int i11 = -1;
            int i12 = 0;
            int i13 = 0;
            while (i12 < bArr.length) {
                int i14 = i12;
                while (i14 < 16 && bArr[i14] == 0 && bArr[i14 + 1] == 0) {
                    i14 += 2;
                }
                int i15 = i14 - i12;
                if (i15 > i13) {
                    i11 = i12;
                    i13 = i15;
                }
                i12 = i14 + 2;
            }
            Buffer buffer = new Buffer();
            while (i10 < bArr.length) {
                if (i10 == i11) {
                    buffer.writeByte(58);
                    i10 += i13;
                    if (i10 == 16) {
                        buffer.writeByte(58);
                    }
                } else {
                    if (i10 > 0) {
                        buffer.writeByte(58);
                    }
                    buffer.writeHexadecimalUnsignedLong(((bArr[i10] & 255) << 8) | (bArr[i10 + 1] & 255));
                    i10 += 2;
                }
            }
            return buffer.readUtf8();
        }

        public HttpUrl build() {
            if (this.scheme != null) {
                if (this.host != null) {
                    return new HttpUrl(this);
                }
                throw new IllegalStateException("host == null");
            }
            throw new IllegalStateException("scheme == null");
        }

        public int effectivePort() {
            int i10 = this.port;
            return i10 != -1 ? i10 : HttpUrl.defaultPort(this.scheme);
        }

        public Builder host(String str) {
            if (str != null) {
                String canonicalizeHost = canonicalizeHost(str, 0, str.length());
                if (canonicalizeHost != null) {
                    this.host = canonicalizeHost;
                    return this;
                }
                throw new IllegalArgumentException("unexpected host: " + str);
            }
            throw new IllegalArgumentException("host == null");
        }

        public Builder port(int i10) {
            if (i10 > 0 && i10 <= 65535) {
                this.port = i10;
                return this;
            }
            throw new IllegalArgumentException("unexpected port: " + i10);
        }

        public Builder scheme(String str) {
            if (str != null) {
                if (str.equalsIgnoreCase("http")) {
                    this.scheme = "http";
                } else if (str.equalsIgnoreCase("https")) {
                    this.scheme = "https";
                } else {
                    throw new IllegalArgumentException("unexpected scheme: " + str);
                }
                return this;
            }
            throw new IllegalArgumentException("scheme == null");
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.scheme);
            sb2.append("://");
            if (this.host.indexOf(58) != -1) {
                sb2.append('[');
                sb2.append(this.host);
                sb2.append(']');
            } else {
                sb2.append(this.host);
            }
            int effectivePort = effectivePort();
            if (effectivePort != HttpUrl.defaultPort(this.scheme)) {
                sb2.append(ShortcutConstants.SERVICES_SEPARATOR);
                sb2.append(effectivePort);
            }
            return sb2.toString();
        }
    }

    public static void canonicalize(Buffer buffer, String str, int i10, int i11, String str2, boolean z10, boolean z11, boolean z12) {
        Buffer buffer2 = null;
        while (i10 < i11) {
            int codePointAt = str.codePointAt(i10);
            if (!z10 || (codePointAt != 9 && codePointAt != 10 && codePointAt != 12 && codePointAt != 13)) {
                if (codePointAt == 43 && z11) {
                    buffer.writeUtf8(z10 ? BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX : "%2B");
                } else if (codePointAt >= 32 && codePointAt != 127 && ((codePointAt < 128 || !z12) && str2.indexOf(codePointAt) == -1 && (codePointAt != 37 || z10))) {
                    buffer.writeUtf8CodePoint(codePointAt);
                } else {
                    if (buffer2 == null) {
                        buffer2 = new Buffer();
                    }
                    buffer2.writeUtf8CodePoint(codePointAt);
                    while (!buffer2.exhausted()) {
                        try {
                            fakeEofExceptionMethod();
                            int readByte = buffer2.readByte() & 255;
                            buffer.writeByte(37);
                            char[] cArr = HEX_DIGITS;
                            buffer.writeByte((int) cArr[(readByte >> 4) & 15]);
                            buffer.writeByte((int) cArr[readByte & 15]);
                        } catch (EOFException e2) {
                            throw new IndexOutOfBoundsException(e2.getMessage());
                        }
                    }
                }
            }
            i10 += Character.charCount(codePointAt);
        }
    }

    public static int decodeHexDigit(char c4) {
        if (c4 >= '0' && c4 <= '9') {
            return c4 - '0';
        }
        char c10 = 'a';
        if (c4 < 'a' || c4 > 'f') {
            c10 = 'A';
            if (c4 < 'A' || c4 > 'F') {
                return -1;
            }
        }
        return (c4 - c10) + 10;
    }

    public static int defaultPort(String str) {
        if (str.equals("http")) {
            return 80;
        }
        if (str.equals("https")) {
            return GrpcUtil.DEFAULT_PORT_SSL;
        }
        return -1;
    }

    private static void fakeEofExceptionMethod() throws EOFException {
    }

    public static String percentDecode(String str, int i10, int i11, boolean z10) {
        for (int i12 = i10; i12 < i11; i12++) {
            char charAt = str.charAt(i12);
            if (charAt == '%' || (charAt == '+' && z10)) {
                Buffer buffer = new Buffer();
                buffer.writeUtf8(str, i10, i12);
                percentDecode(buffer, str, i12, i11, z10);
                return buffer.readUtf8();
            }
        }
        return str.substring(i10, i11);
    }

    public boolean equals(Object obj) {
        return (obj instanceof HttpUrl) && ((HttpUrl) obj).url.equals(this.url);
    }

    public int hashCode() {
        return this.url.hashCode();
    }

    public String host() {
        return this.host;
    }

    public boolean isHttps() {
        return this.scheme.equals("https");
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        String str = this.scheme;
        builder.scheme = str;
        builder.host = this.host;
        builder.port = this.port != defaultPort(str) ? this.port : -1;
        return builder;
    }

    public int port() {
        return this.port;
    }

    public String scheme() {
        return this.scheme;
    }

    public String toString() {
        return this.url;
    }

    private HttpUrl(Builder builder) {
        this.scheme = builder.scheme;
        this.host = builder.host;
        this.port = builder.effectivePort();
        this.url = builder.toString();
    }

    public static void percentDecode(Buffer buffer, String str, int i10, int i11, boolean z10) {
        int i12;
        while (i10 < i11) {
            int codePointAt = str.codePointAt(i10);
            if (codePointAt == 37 && (i12 = i10 + 2) < i11) {
                int decodeHexDigit = decodeHexDigit(str.charAt(i10 + 1));
                int decodeHexDigit2 = decodeHexDigit(str.charAt(i12));
                if (decodeHexDigit != -1 && decodeHexDigit2 != -1) {
                    buffer.writeByte((decodeHexDigit << 4) + decodeHexDigit2);
                    i10 = i12;
                }
                buffer.writeUtf8CodePoint(codePointAt);
            } else {
                if (codePointAt == 43 && z10) {
                    buffer.writeByte(32);
                }
                buffer.writeUtf8CodePoint(codePointAt);
            }
            i10 += Character.charCount(codePointAt);
        }
    }
}
