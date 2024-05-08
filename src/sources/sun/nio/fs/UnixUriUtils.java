package sun.nio.fs;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.util.Arrays;
import org.apache.commons.io.IOUtils;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
class UnixUriUtils {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long H_ALPHA;
    private static final long H_ALPHANUM;
    private static final long H_DIGIT = 0;
    private static final long H_LOWALPHA;
    private static final long H_MARK;
    private static final long H_PATH;
    private static final long H_PCHAR;
    private static final long H_UNRESERVED;
    private static final long H_UPALPHA;
    private static final long L_ALPHA = 0;
    private static final long L_ALPHANUM;
    private static final long L_DIGIT;
    private static final long L_LOWALPHA = 0;
    private static final long L_MARK;
    private static final long L_PATH;
    private static final long L_PCHAR;
    private static final long L_UNRESERVED;
    private static final long L_UPALPHA = 0;
    private static final char[] hexDigits;

    static {
        long lowMask = lowMask('0', '9');
        L_DIGIT = lowMask;
        long highMask = highMask('A', 'Z');
        H_UPALPHA = highMask;
        long highMask2 = highMask('a', 'z');
        H_LOWALPHA = highMask2;
        long j10 = highMask | highMask2;
        H_ALPHA = j10;
        long j11 = lowMask | 0;
        L_ALPHANUM = j11;
        long j12 = j10 | 0;
        H_ALPHANUM = j12;
        long lowMask2 = lowMask("-_.!~*'()");
        L_MARK = lowMask2;
        long highMask3 = highMask("-_.!~*'()");
        H_MARK = highMask3;
        long j13 = j11 | lowMask2;
        L_UNRESERVED = j13;
        long j14 = j12 | highMask3;
        H_UNRESERVED = j14;
        long lowMask3 = j13 | lowMask(":@&=+$,");
        L_PCHAR = lowMask3;
        long highMask4 = j14 | highMask(":@&=+$,");
        H_PCHAR = highMask4;
        L_PATH = lowMask3 | lowMask(";/");
        H_PATH = highMask(";/") | highMask4;
        hexDigits = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    private UnixUriUtils() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Path fromUri(UnixFileSystem fs, URI uri) {
        byte b4;
        if (!uri.isAbsolute()) {
            throw new IllegalArgumentException("URI is not absolute");
        }
        if (uri.isOpaque()) {
            throw new IllegalArgumentException("URI is not hierarchical");
        }
        String scheme = uri.getScheme();
        if (scheme == null || !scheme.equalsIgnoreCase("file")) {
            throw new IllegalArgumentException("URI scheme is not \"file\"");
        }
        if (uri.getAuthority() != null) {
            throw new IllegalArgumentException("URI has an authority component");
        }
        if (uri.getFragment() != null) {
            throw new IllegalArgumentException("URI has a fragment component");
        }
        if (uri.getQuery() != null) {
            throw new IllegalArgumentException("URI has a query component");
        }
        if (!uri.toString().startsWith("file:///")) {
            return new File(uri).toPath();
        }
        String p10 = uri.getRawPath();
        int len = p10.length();
        if (len == 0) {
            throw new IllegalArgumentException("URI path component is empty");
        }
        if (p10.endsWith("/") && len > 1) {
            len--;
        }
        byte[] result = new byte[len];
        int rlen = 0;
        int pos = 0;
        while (pos < len) {
            int pos2 = pos + 1;
            char c4 = p10.charAt(pos);
            if (c4 == '%') {
                int pos3 = pos2 + 1;
                char c12 = p10.charAt(pos2);
                int pos4 = pos3 + 1;
                char c22 = p10.charAt(pos3);
                b4 = (byte) ((decode(c12) << 4) | decode(c22));
                if (b4 == 0) {
                    throw new IllegalArgumentException("Nul character not allowed");
                }
                pos2 = pos4;
            } else {
                b4 = (byte) c4;
            }
            result[rlen] = b4;
            pos = pos2;
            rlen++;
        }
        int pos5 = result.length;
        if (rlen != pos5) {
            result = Arrays.copyOf(result, rlen);
        }
        return new UnixPath(fs, result);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static URI toUri(UnixPath up) {
        byte[] path = up.toAbsolutePath().asByteArray();
        StringBuilder sb2 = new StringBuilder("file:///");
        for (int i10 = 1; i10 < path.length; i10++) {
            char c4 = (char) (path[i10] & 255);
            if (match(c4, L_PATH, H_PATH)) {
                sb2.append(c4);
            } else {
                sb2.append('%');
                char[] cArr = hexDigits;
                sb2.append(cArr[(c4 >> 4) & 15]);
                sb2.append(cArr[c4 & 15]);
            }
        }
        int i11 = sb2.length();
        if (sb2.charAt(i11 - 1) != '/') {
            try {
                if (UnixFileAttributes.get(up, true).isDirectory()) {
                    sb2.append(IOUtils.DIR_SEPARATOR_UNIX);
                }
            } catch (UnixException e2) {
            }
        }
        try {
            return new URI(sb2.toString());
        } catch (URISyntaxException x10) {
            throw new AssertionError(x10);
        }
    }

    private static long lowMask(String chars) {
        int n10 = chars.length();
        long m10 = 0;
        for (int i10 = 0; i10 < n10; i10++) {
            char c4 = chars.charAt(i10);
            if (c4 < '@') {
                m10 |= 1 << c4;
            }
        }
        return m10;
    }

    private static long highMask(String chars) {
        int n10 = chars.length();
        long m10 = 0;
        for (int i10 = 0; i10 < n10; i10++) {
            char c4 = chars.charAt(i10);
            if (c4 >= '@' && c4 < 128) {
                m10 |= 1 << (c4 - '@');
            }
        }
        return m10;
    }

    private static long lowMask(char first, char last) {
        long m10 = 0;
        int f10 = Math.max(Math.min((int) first, 63), 0);
        int l10 = Math.max(Math.min((int) last, 63), 0);
        for (int i10 = f10; i10 <= l10; i10++) {
            m10 |= 1 << i10;
        }
        return m10;
    }

    private static long highMask(char first, char last) {
        long m10 = 0;
        int f10 = Math.max(Math.min((int) first, 127), 64) - 64;
        int l10 = Math.max(Math.min((int) last, 127), 64) - 64;
        for (int i10 = f10; i10 <= l10; i10++) {
            m10 |= 1 << i10;
        }
        return m10;
    }

    private static boolean match(char c4, long lowMask, long highMask) {
        return c4 < '@' ? ((1 << c4) & lowMask) != 0 : c4 < 128 && ((1 << (c4 + (-64))) & highMask) != 0;
    }

    private static int decode(char c4) {
        if (c4 >= '0' && c4 <= '9') {
            return c4 - '0';
        }
        if (c4 >= 'a' && c4 <= 'f') {
            return (c4 - 'a') + 10;
        }
        if (c4 >= 'A' && c4 <= 'F') {
            return (c4 - 'A') + 10;
        }
        throw new AssertionError();
    }
}
