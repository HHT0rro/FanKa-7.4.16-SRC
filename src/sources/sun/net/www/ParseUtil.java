package sun.net.www;

import com.android.internal.accessibility.common.ShortcutConstants;
import com.huawei.openalliance.ad.constant.u;
import com.kuaishou.weapon.p0.bi;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;
import java.util.BitSet;
import org.apache.commons.io.IOUtils;
import sun.nio.cs.ThreadLocalCoders;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class ParseUtil {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long H_ALPHA;
    private static final long H_ALPHANUM;
    private static final long H_DASH;
    private static final long H_DIGIT = 0;
    private static final long H_ESCAPED = 0;
    private static final long H_HEX;
    private static final long H_LOWALPHA;
    private static final long H_MARK;
    private static final long H_PATH;
    private static final long H_PCHAR;
    private static final long H_REG_NAME;
    private static final long H_RESERVED;
    private static final long H_SERVER;
    private static final long H_UNRESERVED;
    private static final long H_UPALPHA;
    private static final long H_URIC;
    private static final long H_USERINFO;
    private static final long L_ALPHA = 0;
    private static final long L_ALPHANUM;
    private static final long L_DASH;
    private static final long L_DIGIT;
    private static final long L_ESCAPED = 1;
    private static final long L_HEX;
    private static final long L_LOWALPHA = 0;
    private static final long L_MARK;
    private static final long L_PATH;
    private static final long L_PCHAR;
    private static final long L_REG_NAME;
    private static final long L_RESERVED;
    private static final long L_SERVER;
    private static final long L_UNRESERVED;
    private static final long L_UPALPHA = 0;
    private static final long L_URIC;
    private static final long L_USERINFO;
    static BitSet encodedInPath;
    private static final char[] hexDigits;

    static {
        BitSet bitSet = new BitSet(256);
        encodedInPath = bitSet;
        bitSet.set(61);
        encodedInPath.set(59);
        encodedInPath.set(63);
        encodedInPath.set(47);
        encodedInPath.set(35);
        encodedInPath.set(32);
        encodedInPath.set(60);
        encodedInPath.set(62);
        encodedInPath.set(37);
        encodedInPath.set(34);
        encodedInPath.set(123);
        encodedInPath.set(125);
        encodedInPath.set(124);
        encodedInPath.set(92);
        encodedInPath.set(94);
        encodedInPath.set(91);
        encodedInPath.set(93);
        encodedInPath.set(96);
        for (int i10 = 0; i10 < 32; i10++) {
            encodedInPath.set(i10);
        }
        encodedInPath.set(127);
        hexDigits = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        long lowMask = lowMask('0', '9');
        L_DIGIT = lowMask;
        L_HEX = lowMask;
        H_HEX = highMask('A', 'F') | highMask('a', 'f');
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
        long lowMask3 = lowMask(";/?:@&=+$,[]");
        L_RESERVED = lowMask3;
        long highMask4 = highMask(";/?:@&=+$,[]");
        H_RESERVED = highMask4;
        long lowMask4 = lowMask("-");
        L_DASH = lowMask4;
        long highMask5 = highMask("-");
        H_DASH = highMask5;
        L_URIC = lowMask3 | j13 | 1;
        H_URIC = highMask4 | j14 | 0;
        long lowMask5 = j13 | 1 | lowMask(":@&=+$,");
        L_PCHAR = lowMask5;
        long highMask6 = j14 | 0 | highMask(":@&=+$,");
        H_PCHAR = highMask6;
        L_PATH = lowMask5 | lowMask(";/");
        H_PATH = highMask(";/") | highMask6;
        long lowMask6 = j13 | 1 | lowMask(";:&=+$,");
        L_USERINFO = lowMask6;
        long highMask7 = j14 | 0 | highMask(";:&=+$,");
        H_USERINFO = highMask7;
        L_REG_NAME = j13 | 1 | lowMask("$,;:@&=+");
        H_REG_NAME = 0 | j14 | highMask("$,;:@&=+");
        L_SERVER = j11 | lowMask6 | lowMask4 | lowMask(".:@[]");
        H_SERVER = highMask7 | j12 | highMask5 | highMask(".:@[]");
    }

    public static String encodePath(String path) {
        return encodePath(path, true);
    }

    public static String encodePath(String path, boolean flag) {
        char[] retCC = new char[(path.length() * 2) + 16];
        int retLen = 0;
        char[] pathCC = path.toCharArray();
        int n10 = path.length();
        for (int i10 = 0; i10 < n10; i10++) {
            char c4 = pathCC[i10];
            if ((!flag && c4 == '/') || (flag && c4 == File.separatorChar)) {
                retCC[retLen] = IOUtils.DIR_SEPARATOR_UNIX;
                retLen++;
            } else if (c4 <= 127) {
                if ((c4 >= 'a' && c4 <= 'z') || ((c4 >= 'A' && c4 <= 'Z') || (c4 >= '0' && c4 <= '9'))) {
                    retCC[retLen] = c4;
                    retLen++;
                } else if (encodedInPath.get(c4)) {
                    retLen = escape(retCC, c4, retLen);
                } else {
                    retCC[retLen] = c4;
                    retLen++;
                }
            } else if (c4 > 2047) {
                retLen = escape(retCC, (char) (((c4 >> 0) & 63) | 128), escape(retCC, (char) (((c4 >> 6) & 63) | 128), escape(retCC, (char) (((c4 >> '\f') & 15) | 224), retLen)));
            } else {
                retLen = escape(retCC, (char) (((c4 >> 0) & 63) | 128), escape(retCC, (char) (((c4 >> 6) & 31) | 192), retLen));
            }
            if (retLen + 9 > retCC.length) {
                int newLen = (retCC.length * 2) + 16;
                if (newLen < 0) {
                    newLen = Integer.MAX_VALUE;
                }
                char[] buf = new char[newLen];
                System.arraycopy((Object) retCC, 0, (Object) buf, 0, retLen);
                retCC = buf;
            }
        }
        return new String(retCC, 0, retLen);
    }

    private static int escape(char[] cc2, char c4, int index) {
        int index2 = index + 1;
        cc2[index] = '%';
        int index3 = index2 + 1;
        cc2[index2] = Character.forDigit((c4 >> 4) & 15, 16);
        int index4 = index3 + 1;
        cc2[index3] = Character.forDigit(c4 & 15, 16);
        return index4;
    }

    private static byte unescape(String s2, int i10) {
        return (byte) Integer.parseInt(s2.substring(i10 + 1, i10 + 3), 16);
    }

    public static String decode(String s2) {
        int n10 = s2.length();
        if (n10 == 0 || s2.indexOf(37) < 0) {
            return s2;
        }
        StringBuilder sb2 = new StringBuilder(n10);
        ByteBuffer bb2 = ByteBuffer.allocate(n10);
        CharBuffer cb2 = CharBuffer.allocate(n10);
        CharsetDecoder dec = ThreadLocalCoders.decoderFor("UTF-8").onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT);
        char c4 = s2.charAt(0);
        int i10 = 0;
        while (i10 < n10) {
            if (c4 != '%') {
                sb2.append(c4);
                i10++;
                if (i10 >= n10) {
                    break;
                }
                c4 = s2.charAt(i10);
            } else {
                bb2.clear();
                do {
                    try {
                        bb2.put(unescape(s2, i10));
                        i10 += 3;
                        if (i10 >= n10) {
                            break;
                        }
                        c4 = s2.charAt(i10);
                    } catch (NumberFormatException e2) {
                        throw new IllegalArgumentException();
                    }
                } while (c4 == '%');
                bb2.flip();
                cb2.clear();
                dec.reset();
                CoderResult cr = dec.decode(bb2, cb2, true);
                if (cr.isError()) {
                    throw new IllegalArgumentException("Error decoding percent encoded characters");
                }
                CoderResult cr2 = dec.flush(cb2);
                if (cr2.isError()) {
                    throw new IllegalArgumentException("Error decoding percent encoded characters");
                }
                sb2.append(cb2.flip().toString());
            }
        }
        return sb2.toString();
    }

    public String canonizeString(String file) {
        file.length();
        while (true) {
            int i10 = file.indexOf("/../");
            if (i10 < 0) {
                break;
            }
            int lim = file.lastIndexOf(47, i10 - 1);
            if (lim >= 0) {
                file = file.substring(0, lim) + file.substring(i10 + 3);
            } else {
                file = file.substring(i10 + 3);
            }
        }
        while (true) {
            int i11 = file.indexOf("/./");
            if (i11 < 0) {
                break;
            }
            file = file.substring(0, i11) + file.substring(i11 + 2);
        }
        while (file.endsWith("/..")) {
            int i12 = file.indexOf("/..");
            int lim2 = file.lastIndexOf(47, i12 - 1);
            if (lim2 >= 0) {
                file = file.substring(0, lim2 + 1);
            } else {
                file = file.substring(0, i12);
            }
        }
        if (file.endsWith(bi.f35840j)) {
            return file.substring(0, file.length() - 1);
        }
        return file;
    }

    public static URL fileToEncodedURL(File file) throws MalformedURLException {
        String path = encodePath(file.getAbsolutePath());
        if (!path.startsWith("/")) {
            path = "/" + path;
        }
        if (!path.endsWith("/") && file.isDirectory()) {
            path = path + "/";
        }
        return new URL("file", "", path);
    }

    public static URI toURI(URL url) {
        String protocol = url.getProtocol();
        String auth = url.getAuthority();
        String path = url.getPath();
        String query = url.getQuery();
        String ref = url.getRef();
        if (path != null && !path.startsWith("/")) {
            path = "/" + path;
        }
        if (auth != null && auth.endsWith(":-1")) {
            auth = auth.substring(0, auth.length() - 3);
        }
        try {
            URI uri = createURI(protocol, auth, path, query, ref);
            return uri;
        } catch (URISyntaxException e2) {
            return null;
        }
    }

    private static URI createURI(String scheme, String authority, String path, String query, String fragment) throws URISyntaxException {
        String s2 = toString(scheme, null, authority, null, null, -1, path, query, fragment);
        checkPath(s2, scheme, path);
        return new URI(s2);
    }

    private static String toString(String scheme, String opaquePart, String authority, String userInfo, String host, int port, String path, String query, String fragment) {
        StringBuffer sb2 = new StringBuffer();
        if (scheme != null) {
            sb2.append(scheme);
            sb2.append(ShortcutConstants.SERVICES_SEPARATOR);
        }
        appendSchemeSpecificPart(sb2, opaquePart, authority, userInfo, host, port, path, query);
        appendFragment(sb2, fragment);
        return sb2.toString();
    }

    private static void appendSchemeSpecificPart(StringBuffer sb2, String opaquePart, String authority, String userInfo, String host, int port, String path, String query) {
        String dontquote;
        String doquote;
        if (opaquePart != null) {
            if (opaquePart.startsWith("//[")) {
                int end = opaquePart.indexOf("]");
                if (end != -1 && opaquePart.indexOf(u.bD) != -1) {
                    if (end == opaquePart.length()) {
                        dontquote = opaquePart;
                        doquote = "";
                    } else {
                        dontquote = opaquePart.substring(0, end + 1);
                        doquote = opaquePart.substring(end + 1);
                    }
                    sb2.append(dontquote);
                    sb2.append(quote(doquote, L_URIC, H_URIC));
                    return;
                }
                return;
            }
            sb2.append(quote(opaquePart, L_URIC, H_URIC));
            return;
        }
        appendAuthority(sb2, authority, userInfo, host, port);
        if (path != null) {
            sb2.append(quote(path, L_PATH, H_PATH));
        }
        if (query != null) {
            sb2.append('?');
            sb2.append(quote(query, L_URIC, H_URIC));
        }
    }

    private static void appendAuthority(StringBuffer sb2, String authority, String userInfo, String host, int port) {
        String dontquote;
        String doquote;
        boolean needBrackets = false;
        if (host != null) {
            sb2.append("//");
            if (userInfo != null) {
                sb2.append(quote(userInfo, L_USERINFO, H_USERINFO));
                sb2.append('@');
            }
            if (host.indexOf(58) >= 0 && !host.startsWith("[") && !host.endsWith("]")) {
                needBrackets = true;
            }
            if (needBrackets) {
                sb2.append('[');
            }
            sb2.append(host);
            if (needBrackets) {
                sb2.append(']');
            }
            if (port != -1) {
                sb2.append(ShortcutConstants.SERVICES_SEPARATOR);
                sb2.append(port);
                return;
            }
            return;
        }
        if (authority != null) {
            sb2.append("//");
            if (authority.startsWith("[")) {
                int end = authority.indexOf("]");
                if (end != -1 && authority.indexOf(u.bD) != -1) {
                    if (end != authority.length()) {
                        dontquote = authority.substring(0, end + 1);
                        doquote = authority.substring(end + 1);
                    } else {
                        dontquote = authority;
                        doquote = "";
                    }
                    sb2.append(dontquote);
                    sb2.append(quote(doquote, L_REG_NAME | L_SERVER, H_REG_NAME | H_SERVER));
                    return;
                }
                return;
            }
            sb2.append(quote(authority, L_REG_NAME | L_SERVER, H_REG_NAME | H_SERVER));
        }
    }

    private static void appendFragment(StringBuffer sb2, String fragment) {
        if (fragment != null) {
            sb2.append('#');
            sb2.append(quote(fragment, L_URIC, H_URIC));
        }
    }

    private static String quote(String s2, long lowMask, long highMask) {
        s2.length();
        StringBuffer sb2 = null;
        boolean allowNonASCII = (1 & lowMask) != 0;
        for (int i10 = 0; i10 < s2.length(); i10++) {
            char c4 = s2.charAt(i10);
            if (c4 < 128) {
                if (!match(c4, lowMask, highMask) && !isEscaped(s2, i10)) {
                    if (sb2 == null) {
                        sb2 = new StringBuffer();
                        sb2.append(s2.substring(0, i10));
                    }
                    appendEscape(sb2, (byte) c4);
                } else if (sb2 != null) {
                    sb2.append(c4);
                }
            } else if (allowNonASCII && (Character.isSpaceChar(c4) || Character.isISOControl(c4))) {
                if (sb2 == null) {
                    sb2 = new StringBuffer();
                    sb2.append(s2.substring(0, i10));
                }
                appendEncoded(sb2, c4);
            } else if (sb2 != null) {
                sb2.append(c4);
            }
        }
        return sb2 == null ? s2 : sb2.toString();
    }

    private static boolean isEscaped(String s2, int pos) {
        if (s2 == null || s2.length() <= pos + 2 || s2.charAt(pos) != '%') {
            return false;
        }
        char charAt = s2.charAt(pos + 1);
        long j10 = L_HEX;
        long j11 = H_HEX;
        return match(charAt, j10, j11) && match(s2.charAt(pos + 2), j10, j11);
    }

    private static void appendEncoded(StringBuffer sb2, char c4) {
        ByteBuffer bb2 = null;
        try {
            bb2 = ThreadLocalCoders.encoderFor("UTF-8").encode(CharBuffer.wrap("" + c4));
        } catch (CharacterCodingException e2) {
        }
        while (bb2.hasRemaining()) {
            int b4 = bb2.get() & 255;
            if (b4 >= 128) {
                appendEscape(sb2, (byte) b4);
            } else {
                sb2.append((char) b4);
            }
        }
    }

    private static void appendEscape(StringBuffer sb2, byte b4) {
        sb2.append('%');
        char[] cArr = hexDigits;
        sb2.append(cArr[(b4 >> 4) & 15]);
        sb2.append(cArr[(b4 >> 0) & 15]);
    }

    private static boolean match(char c4, long lowMask, long highMask) {
        return c4 < '@' ? ((1 << c4) & lowMask) != 0 : c4 < 128 && ((1 << (c4 + (-64))) & highMask) != 0;
    }

    private static void checkPath(String s2, String scheme, String path) throws URISyntaxException {
        if (scheme != null && path != null && path.length() > 0 && path.charAt(0) != '/') {
            throw new URISyntaxException(s2, "Relative path in absolute URI");
        }
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

    private static long highMask(char first, char last) {
        long m10 = 0;
        int f10 = Math.max(Math.min((int) first, 127), 64) - 64;
        int l10 = Math.max(Math.min((int) last, 127), 64) - 64;
        for (int i10 = f10; i10 <= l10; i10++) {
            m10 |= 1 << i10;
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
}
