package java.net;

import com.android.internal.accessibility.common.ShortcutConstants;
import com.huawei.hms.actions.SearchIntents;
import com.huawei.openalliance.ad.constant.u;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;
import java.text.Normalizer;
import java.util.SeempLog;
import org.apache.commons.io.IOUtils;
import sun.nio.cs.ThreadLocalCoders;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class URI implements Comparable<URI>, Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long H_ALPHA;
    private static final long H_ALPHANUM;
    private static final long H_DASH;
    private static final long H_DIGIT = 0;
    private static final long H_DOT;
    private static final long H_ESCAPED = 0;
    private static final long H_HEX;
    private static final long H_LEFT_BRACKET;
    private static final long H_LOWALPHA;
    private static final long H_MARK;
    private static final long H_PATH;
    private static final long H_PCHAR;
    private static final long H_REG_NAME;
    private static final long H_RESERVED;
    private static final long H_SCHEME;
    private static final long H_SCOPE_ID;
    private static final long H_SERVER;
    private static final long H_SERVER_PERCENT;
    private static final long H_UNDERSCORE;
    private static final long H_UNRESERVED;
    private static final long H_UPALPHA;
    private static final long H_URIC;
    private static final long H_URIC_NO_SLASH;
    private static final long H_USERINFO;
    private static final long L_ALPHA = 0;
    private static final long L_ALPHANUM;
    private static final long L_DASH;
    private static final long L_DIGIT;
    private static final long L_DOT;
    private static final long L_ESCAPED = 1;
    private static final long L_HEX;
    private static final long L_LEFT_BRACKET;
    private static final long L_LOWALPHA = 0;
    private static final long L_MARK;
    private static final long L_PATH;
    private static final long L_PCHAR;
    private static final long L_REG_NAME;
    private static final long L_RESERVED;
    private static final long L_SCHEME;
    private static final long L_SCOPE_ID;
    private static final long L_SERVER;
    private static final long L_SERVER_PERCENT;
    private static final long L_UNDERSCORE;
    private static final long L_UNRESERVED;
    private static final long L_UPALPHA = 0;
    private static final long L_URIC;
    private static final long L_URIC_NO_SLASH;
    private static final long L_USERINFO;
    private static final char[] hexDigits;
    static final long serialVersionUID = -6052424284110960213L;
    private transient String authority;
    private volatile transient String decodedAuthority;
    private volatile transient String decodedFragment;
    private volatile transient String decodedPath;
    private volatile transient String decodedQuery;
    private volatile transient String decodedSchemeSpecificPart;
    private volatile transient String decodedUserInfo;
    private transient String fragment;
    private volatile transient int hash;
    private transient String host;
    private transient String path;
    private transient int port;
    private transient String query;
    private transient String scheme;
    private volatile transient String schemeSpecificPart;
    private volatile String string;
    private transient String userInfo;

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
        L_HEX = lowMask;
        H_HEX = highMask('A', 'F') | highMask('a', 'f');
        long lowMask2 = lowMask("-_.!~*'()");
        L_MARK = lowMask2;
        long highMask3 = highMask("-_.!~*'()");
        H_MARK = highMask3;
        long j13 = lowMask2 | j11;
        L_UNRESERVED = j13;
        long j14 = highMask3 | j12;
        H_UNRESERVED = j14;
        long lowMask3 = lowMask(";/?:@&=+$,[]");
        L_RESERVED = lowMask3;
        long highMask4 = highMask(";/?:@&=+$,[]");
        H_RESERVED = highMask4;
        L_URIC = lowMask3 | j13 | 1;
        H_URIC = highMask4 | j14 | 0;
        long lowMask4 = j13 | 1 | lowMask(":@&=+$,");
        L_PCHAR = lowMask4;
        long highMask5 = j14 | 0 | highMask(":@&=+$,");
        H_PCHAR = highMask5;
        L_PATH = lowMask4 | lowMask(";/");
        H_PATH = highMask5 | highMask(";/");
        long lowMask5 = lowMask("-");
        L_DASH = lowMask5;
        long highMask6 = highMask("-");
        H_DASH = highMask6;
        L_UNDERSCORE = lowMask("_");
        H_UNDERSCORE = highMask("_");
        L_DOT = lowMask(".");
        H_DOT = highMask(".");
        long lowMask6 = j13 | 1 | lowMask(";:&=+$,");
        L_USERINFO = lowMask6;
        long highMask7 = j14 | 0 | highMask(";:&=+$,");
        H_USERINFO = highMask7;
        L_REG_NAME = j13 | 1 | lowMask("$,;:@&=+");
        H_REG_NAME = j14 | 0 | highMask("$,;:@&=+");
        long lowMask7 = lowMask6 | j11 | lowMask5 | lowMask(".:@[]");
        L_SERVER = lowMask7;
        long highMask8 = highMask7 | j12 | highMask6 | highMask(".:@[]");
        H_SERVER = highMask8;
        L_SERVER_PERCENT = lowMask7 | lowMask("%");
        H_SERVER_PERCENT = highMask8 | highMask("%");
        L_LEFT_BRACKET = lowMask("[");
        H_LEFT_BRACKET = highMask("[");
        L_SCHEME = lowMask | 0 | lowMask("+-.");
        H_SCHEME = j10 | 0 | highMask("+-.");
        L_URIC_NO_SLASH = j13 | 1 | lowMask(";?:@&=+$,");
        H_URIC_NO_SLASH = j14 | 0 | highMask(";?:@&=+$,");
        L_SCOPE_ID = lowMask("_.") | j11;
        H_SCOPE_ID = highMask("_.") | j12;
        hexDigits = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    private URI() {
        this.port = -1;
        this.decodedUserInfo = null;
        this.decodedAuthority = null;
        this.decodedPath = null;
        this.decodedQuery = null;
        this.decodedFragment = null;
        this.decodedSchemeSpecificPart = null;
    }

    public URI(String str) throws URISyntaxException {
        this.port = -1;
        this.decodedUserInfo = null;
        this.decodedAuthority = null;
        this.decodedPath = null;
        this.decodedQuery = null;
        this.decodedFragment = null;
        this.decodedSchemeSpecificPart = null;
        SeempLog.record_str(92, "s:" + str);
        new Parser(str).parse(false);
    }

    public URI(String scheme, String userInfo, String host, int port, String path, String query, String fragment) throws URISyntaxException {
        this.port = -1;
        this.decodedUserInfo = null;
        this.decodedAuthority = null;
        this.decodedPath = null;
        this.decodedQuery = null;
        this.decodedFragment = null;
        this.decodedSchemeSpecificPart = null;
        String s2 = toString(scheme, null, null, userInfo, host, port, path, query, fragment);
        checkPath(s2, scheme, path);
        new Parser(s2).parse(true);
    }

    public URI(String scheme, String authority, String path, String query, String fragment) throws URISyntaxException {
        this.port = -1;
        this.decodedUserInfo = null;
        this.decodedAuthority = null;
        this.decodedPath = null;
        this.decodedQuery = null;
        this.decodedFragment = null;
        this.decodedSchemeSpecificPart = null;
        String s2 = toString(scheme, null, authority, null, null, -1, path, query, fragment);
        checkPath(s2, scheme, path);
        new Parser(s2).parse(false);
    }

    public URI(String scheme, String host, String path, String fragment) throws URISyntaxException {
        this(scheme, null, host, -1, path, null, fragment);
    }

    public URI(String scheme, String ssp, String fragment) throws URISyntaxException {
        this.port = -1;
        this.decodedUserInfo = null;
        this.decodedAuthority = null;
        this.decodedPath = null;
        this.decodedQuery = null;
        this.decodedFragment = null;
        this.decodedSchemeSpecificPart = null;
        new Parser(toString(scheme, ssp, null, null, null, -1, null, null, fragment)).parse(false);
    }

    public static URI create(String str) {
        try {
            return new URI(str);
        } catch (URISyntaxException x10) {
            throw new IllegalArgumentException(x10.getMessage(), x10);
        }
    }

    public URI parseServerAuthority() throws URISyntaxException {
        if (this.host != null || this.authority == null) {
            return this;
        }
        defineString();
        new Parser(this.string).parse(true);
        return this;
    }

    public URI normalize() {
        return normalize(this);
    }

    public URI resolve(URI uri) {
        return resolve(this, uri);
    }

    public URI resolve(String str) {
        return resolve(create(str));
    }

    public URI relativize(URI uri) {
        return relativize(this, uri);
    }

    public URL toURL() throws MalformedURLException {
        if (!isAbsolute()) {
            throw new IllegalArgumentException("URI is not absolute");
        }
        return new URL(toString());
    }

    public String getScheme() {
        return this.scheme;
    }

    public boolean isAbsolute() {
        return this.scheme != null;
    }

    public boolean isOpaque() {
        return this.path == null;
    }

    public String getRawSchemeSpecificPart() {
        defineSchemeSpecificPart();
        return this.schemeSpecificPart;
    }

    public String getSchemeSpecificPart() {
        if (this.decodedSchemeSpecificPart == null) {
            this.decodedSchemeSpecificPart = decode(getRawSchemeSpecificPart());
        }
        return this.decodedSchemeSpecificPart;
    }

    public String getRawAuthority() {
        return this.authority;
    }

    public String getAuthority() {
        if (this.decodedAuthority == null) {
            this.decodedAuthority = decode(this.authority);
        }
        return this.decodedAuthority;
    }

    public String getRawUserInfo() {
        return this.userInfo;
    }

    public String getUserInfo() {
        String str;
        if (this.decodedUserInfo == null && (str = this.userInfo) != null) {
            this.decodedUserInfo = decode(str);
        }
        return this.decodedUserInfo;
    }

    public String getHost() {
        return this.host;
    }

    public int getPort() {
        return this.port;
    }

    public String getRawPath() {
        return this.path;
    }

    public String getPath() {
        String str;
        if (this.decodedPath == null && (str = this.path) != null) {
            this.decodedPath = decode(str);
        }
        return this.decodedPath;
    }

    public String getRawQuery() {
        return this.query;
    }

    public String getQuery() {
        String str;
        if (this.decodedQuery == null && (str = this.query) != null) {
            this.decodedQuery = decode(str);
        }
        return this.decodedQuery;
    }

    public String getRawFragment() {
        return this.fragment;
    }

    public String getFragment() {
        String str;
        if (this.decodedFragment == null && (str = this.fragment) != null) {
            this.decodedFragment = decode(str);
        }
        return this.decodedFragment;
    }

    public boolean equals(Object ob2) {
        if (ob2 == this) {
            return true;
        }
        if (!(ob2 instanceof URI)) {
            return false;
        }
        URI that = (URI) ob2;
        if (isOpaque() != that.isOpaque() || !equalIgnoringCase(this.scheme, that.scheme) || !equal(this.fragment, that.fragment)) {
            return false;
        }
        if (isOpaque()) {
            return equal(this.schemeSpecificPart, that.schemeSpecificPart);
        }
        if (!equal(this.path, that.path) || !equal(this.query, that.query)) {
            return false;
        }
        String str = this.authority;
        String str2 = that.authority;
        if (str == str2) {
            return true;
        }
        if (this.host != null) {
            if (!equal(this.userInfo, that.userInfo) || !equalIgnoringCase(this.host, that.host) || this.port != that.port) {
                return false;
            }
        } else if (str != null) {
            if (!equal(str, str2)) {
                return false;
            }
        } else if (str != str2) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int h10;
        if (this.hash != 0) {
            return this.hash;
        }
        int h11 = hash(hashIgnoringCase(0, this.scheme), this.fragment);
        if (isOpaque()) {
            h10 = hash(h11, this.schemeSpecificPart);
        } else {
            int h12 = hash(hash(h11, this.path), this.query);
            if (this.host != null) {
                h10 = hashIgnoringCase(hash(h12, this.userInfo), this.host) + (this.port * 1949);
            } else {
                h10 = hash(h12, this.authority);
            }
        }
        this.hash = h10;
        return h10;
    }

    @Override // java.lang.Comparable
    public int compareTo(URI that) {
        int c4 = compareIgnoringCase(this.scheme, that.scheme);
        if (c4 != 0) {
            return c4;
        }
        if (isOpaque()) {
            if (that.isOpaque()) {
                int c10 = compare(this.schemeSpecificPart, that.schemeSpecificPart);
                return c10 != 0 ? c10 : compare(this.fragment, that.fragment);
            }
            return 1;
        }
        if (that.isOpaque()) {
            return -1;
        }
        if (this.host != null && that.host != null) {
            int c11 = compare(this.userInfo, that.userInfo);
            if (c11 != 0) {
                return c11;
            }
            int c12 = compareIgnoringCase(this.host, that.host);
            if (c12 != 0) {
                return c12;
            }
            int c13 = this.port - that.port;
            if (c13 != 0) {
                return c13;
            }
        } else {
            int c14 = compare(this.authority, that.authority);
            if (c14 != 0) {
                return c14;
            }
        }
        int c15 = compare(this.path, that.path);
        if (c15 != 0) {
            return c15;
        }
        int c16 = compare(this.query, that.query);
        return c16 != 0 ? c16 : compare(this.fragment, that.fragment);
    }

    public String toString() {
        defineString();
        return this.string;
    }

    public String toASCIIString() {
        defineString();
        return encode(this.string);
    }

    private void writeObject(ObjectOutputStream os) throws IOException {
        defineString();
        os.defaultWriteObject();
    }

    private void readObject(ObjectInputStream is) throws ClassNotFoundException, IOException {
        this.port = -1;
        is.defaultReadObject();
        try {
            new Parser(this.string).parse(false);
        } catch (URISyntaxException x10) {
            IOException y10 = new InvalidObjectException("Invalid URI");
            y10.initCause(x10);
            throw y10;
        }
    }

    private static int toLower(char c4) {
        if (c4 >= 'A' && c4 <= 'Z') {
            return c4 + ' ';
        }
        return c4;
    }

    private static int toUpper(char c4) {
        if (c4 >= 'a' && c4 <= 'z') {
            return c4 - ' ';
        }
        return c4;
    }

    private static boolean equal(String s2, String t2) {
        if (s2 == t2) {
            return true;
        }
        if (s2 == null || t2 == null || s2.length() != t2.length()) {
            return false;
        }
        if (s2.indexOf(37) < 0) {
            return s2.equals(t2);
        }
        int n10 = s2.length();
        int i10 = 0;
        while (i10 < n10) {
            char c4 = s2.charAt(i10);
            char d10 = t2.charAt(i10);
            if (c4 != '%') {
                if (c4 != d10) {
                    return false;
                }
                i10++;
            } else {
                if (d10 != '%') {
                    return false;
                }
                int i11 = i10 + 1;
                if (toLower(s2.charAt(i11)) != toLower(t2.charAt(i11))) {
                    return false;
                }
                int i12 = i11 + 1;
                if (toLower(s2.charAt(i12)) != toLower(t2.charAt(i12))) {
                    return false;
                }
                i10 = i12 + 1;
            }
        }
        return true;
    }

    private static boolean equalIgnoringCase(String s2, String t2) {
        int n10;
        if (s2 == t2) {
            return true;
        }
        if (s2 == null || t2 == null || t2.length() != (n10 = s2.length())) {
            return false;
        }
        for (int i10 = 0; i10 < n10; i10++) {
            if (toLower(s2.charAt(i10)) != toLower(t2.charAt(i10))) {
                return false;
            }
        }
        return true;
    }

    private static int hash(int hash, String s2) {
        return s2 == null ? hash : s2.indexOf(37) < 0 ? (hash * 127) + s2.hashCode() : normalizedHash(hash, s2);
    }

    private static int normalizedHash(int hash, String s2) {
        int h10 = 0;
        int index = 0;
        while (index < s2.length()) {
            char ch = s2.charAt(index);
            int h11 = (h10 * 31) + ch;
            if (ch == '%') {
                for (int i10 = index + 1; i10 < index + 3; i10++) {
                    h11 = (h11 * 31) + toUpper(s2.charAt(i10));
                }
                index += 2;
            }
            h10 = h11;
            index++;
        }
        int index2 = hash * 127;
        return index2 + h10;
    }

    private static int hashIgnoringCase(int hash, String s2) {
        if (s2 == null) {
            return hash;
        }
        int h10 = hash;
        int n10 = s2.length();
        for (int i10 = 0; i10 < n10; i10++) {
            h10 = (h10 * 31) + toLower(s2.charAt(i10));
        }
        return h10;
    }

    private static int compare(String s2, String t2) {
        if (s2 == t2) {
            return 0;
        }
        if (s2 != null) {
            if (t2 != null) {
                return s2.compareTo(t2);
            }
            return 1;
        }
        return -1;
    }

    private static int compareIgnoringCase(String s2, String t2) {
        if (s2 == t2) {
            return 0;
        }
        if (s2 != null) {
            if (t2 != null) {
                int sn = s2.length();
                int tn = t2.length();
                int n10 = sn < tn ? sn : tn;
                for (int i10 = 0; i10 < n10; i10++) {
                    int c4 = toLower(s2.charAt(i10)) - toLower(t2.charAt(i10));
                    if (c4 != 0) {
                        return c4;
                    }
                }
                int i11 = sn - tn;
                return i11;
            }
            return 1;
        }
        return -1;
    }

    private static void checkPath(String s2, String scheme, String path) throws URISyntaxException {
        if (scheme != null && path != null && path.length() > 0 && path.charAt(0) != '/') {
            throw new URISyntaxException(s2, "Relative path in absolute URI");
        }
    }

    private void appendAuthority(StringBuffer sb2, String authority, String userInfo, String host, int port) {
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
                String doquote = authority;
                String dontquote = "";
                if (end != -1 && authority.indexOf(u.bD) != -1) {
                    if (end != authority.length()) {
                        dontquote = authority.substring(0, end + 1);
                        doquote = authority.substring(end + 1);
                    } else {
                        dontquote = authority;
                        doquote = "";
                    }
                }
                sb2.append(dontquote);
                sb2.append(quote(doquote, L_REG_NAME | L_SERVER, H_REG_NAME | H_SERVER));
                return;
            }
            sb2.append(quote(authority, L_REG_NAME | L_SERVER, H_REG_NAME | H_SERVER));
        }
    }

    private void appendSchemeSpecificPart(StringBuffer sb2, String opaquePart, String authority, String userInfo, String host, int port, String path, String query) {
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

    private void appendFragment(StringBuffer sb2, String fragment) {
        if (fragment != null) {
            sb2.append('#');
            sb2.append(quote(fragment, L_URIC, H_URIC));
        }
    }

    private String toString(String scheme, String opaquePart, String authority, String userInfo, String host, int port, String path, String query, String fragment) {
        StringBuffer sb2 = new StringBuffer();
        if (scheme != null) {
            sb2.append(scheme);
            sb2.append(ShortcutConstants.SERVICES_SEPARATOR);
        }
        appendSchemeSpecificPart(sb2, opaquePart, authority, userInfo, host, port, path, query);
        appendFragment(sb2, fragment);
        return sb2.toString();
    }

    private void defineSchemeSpecificPart() {
        if (this.schemeSpecificPart != null) {
            return;
        }
        StringBuffer sb2 = new StringBuffer();
        appendSchemeSpecificPart(sb2, null, getAuthority(), getUserInfo(), this.host, this.port, getPath(), getQuery());
        if (sb2.length() == 0) {
            return;
        }
        this.schemeSpecificPart = sb2.toString();
    }

    private void defineString() {
        if (this.string != null) {
            return;
        }
        StringBuffer sb2 = new StringBuffer();
        String str = this.scheme;
        if (str != null) {
            sb2.append(str);
            sb2.append(ShortcutConstants.SERVICES_SEPARATOR);
        }
        if (isOpaque()) {
            sb2.append(this.schemeSpecificPart);
        } else {
            if (this.host != null) {
                sb2.append("//");
                String str2 = this.userInfo;
                if (str2 != null) {
                    sb2.append(str2);
                    sb2.append('@');
                }
                boolean needBrackets = (this.host.indexOf(58) < 0 || this.host.startsWith("[") || this.host.endsWith("]")) ? false : true;
                if (needBrackets) {
                    sb2.append('[');
                }
                sb2.append(this.host);
                if (needBrackets) {
                    sb2.append(']');
                }
                if (this.port != -1) {
                    sb2.append(ShortcutConstants.SERVICES_SEPARATOR);
                    sb2.append(this.port);
                }
            } else if (this.authority != null) {
                sb2.append("//");
                sb2.append(this.authority);
            }
            String str3 = this.path;
            if (str3 != null) {
                sb2.append(str3);
            }
            if (this.query != null) {
                sb2.append('?');
                sb2.append(this.query);
            }
        }
        if (this.fragment != null) {
            sb2.append('#');
            sb2.append(this.fragment);
        }
        this.string = sb2.toString();
    }

    private static String resolvePath(String base, String child, boolean absolute) {
        int i10 = base.lastIndexOf(47);
        int cn2 = child.length();
        String path = "";
        if (cn2 == 0) {
            if (i10 >= 0) {
                path = base.substring(0, i10 + 1);
            }
        } else {
            StringBuffer sb2 = new StringBuffer(base.length() + cn2);
            if (i10 >= 0) {
                sb2.append(base.substring(0, i10 + 1));
            }
            sb2.append(child);
            path = sb2.toString();
        }
        String np = normalize(path, true);
        return np;
    }

    private static URI resolve(URI base, URI child) {
        String str;
        if (child.isOpaque() || base.isOpaque()) {
            return child;
        }
        if (child.scheme == null && child.authority == null && child.path.equals("") && (str = child.fragment) != null && child.query == null) {
            String str2 = base.fragment;
            if (str2 != null && str.equals(str2)) {
                return base;
            }
            URI ru = new URI();
            ru.scheme = base.scheme;
            ru.authority = base.authority;
            ru.userInfo = base.userInfo;
            ru.host = base.host;
            ru.port = base.port;
            ru.path = base.path;
            ru.fragment = child.fragment;
            ru.query = base.query;
            return ru;
        }
        if (child.scheme != null) {
            return child;
        }
        URI ru2 = new URI();
        ru2.scheme = base.scheme;
        ru2.query = child.query;
        ru2.fragment = child.fragment;
        String str3 = child.authority;
        if (str3 == null) {
            ru2.authority = base.authority;
            ru2.host = base.host;
            ru2.userInfo = base.userInfo;
            ru2.port = base.port;
            String str4 = child.path;
            if (str4 == null || str4.isEmpty()) {
                ru2.path = base.path;
                String str5 = child.query;
                if (str5 == null) {
                    str5 = base.query;
                }
                ru2.query = str5;
            } else if (child.path.length() > 0 && child.path.charAt(0) == '/') {
                ru2.path = normalize(child.path, true);
            } else {
                ru2.path = resolvePath(base.path, child.path, base.isAbsolute());
            }
        } else {
            ru2.authority = str3;
            ru2.host = child.host;
            ru2.userInfo = child.userInfo;
            ru2.host = child.host;
            ru2.port = child.port;
            ru2.path = child.path;
        }
        return ru2;
    }

    private static URI normalize(URI u10) {
        String str;
        if (u10.isOpaque() || (str = u10.path) == null || str.length() == 0) {
            return u10;
        }
        String np = normalize(u10.path);
        if (np == u10.path) {
            return u10;
        }
        URI v2 = new URI();
        v2.scheme = u10.scheme;
        v2.fragment = u10.fragment;
        v2.authority = u10.authority;
        v2.userInfo = u10.userInfo;
        v2.host = u10.host;
        v2.port = u10.port;
        v2.path = np;
        v2.query = u10.query;
        return v2;
    }

    private static URI relativize(URI base, URI child) {
        if (child.isOpaque() || base.isOpaque()) {
            return child;
        }
        if (!equalIgnoringCase(base.scheme, child.scheme) || !equal(base.authority, child.authority)) {
            return child;
        }
        String bp = normalize(base.path);
        String cp = normalize(child.path);
        if (!bp.equals(cp)) {
            if (bp.indexOf(47) != -1) {
                bp = bp.substring(0, bp.lastIndexOf(47) + 1);
            }
            if (!cp.startsWith(bp)) {
                return child;
            }
        }
        URI v2 = new URI();
        v2.path = cp.substring(bp.length());
        v2.query = child.query;
        v2.fragment = child.fragment;
        return v2;
    }

    private static int needsNormalization(String path) {
        int ns = 0;
        int end = path.length() - 1;
        int p10 = 0;
        while (p10 <= end && path.charAt(p10) == '/') {
            p10++;
        }
        boolean normal = p10 <= 1;
        while (p10 <= end) {
            if (path.charAt(p10) == '.' && (p10 == end || path.charAt(p10 + 1) == '/' || (path.charAt(p10 + 1) == '.' && (p10 + 1 == end || path.charAt(p10 + 2) == '/')))) {
                normal = false;
            }
            ns++;
            while (true) {
                if (p10 <= end) {
                    int p11 = p10 + 1;
                    if (path.charAt(p10) == 47) {
                        p10 = p11;
                        while (p10 <= end && path.charAt(p10) == '/') {
                            normal = false;
                            p10++;
                        }
                    } else {
                        p10 = p11;
                    }
                }
            }
        }
        if (normal) {
            return -1;
        }
        return ns;
    }

    private static void split(char[] path, int[] segs) {
        int end = path.length - 1;
        int p10 = 0;
        int p11 = 0;
        while (p10 <= end && path[p10] == '/') {
            path[p10] = 0;
            p10++;
        }
        while (p10 <= end) {
            int i10 = p11 + 1;
            segs[p11] = p10;
            p10++;
            while (true) {
                if (p10 > end) {
                    p11 = i10;
                    break;
                }
                int p12 = p10 + 1;
                if (path[p10] == '/') {
                    path[p12 - 1] = 0;
                    p10 = p12;
                    while (p10 <= end && path[p10] == '/') {
                        path[p10] = 0;
                        p10++;
                    }
                    p11 = i10;
                } else {
                    p10 = p12;
                }
            }
        }
        if (p11 != segs.length) {
            throw new InternalError();
        }
    }

    private static int join(char[] path, int[] segs) {
        int end = path.length - 1;
        int p10 = 0;
        if (path[0] == 0) {
            int p11 = 0 + 1;
            path[0] = IOUtils.DIR_SEPARATOR_UNIX;
            p10 = p11;
        }
        for (int q10 : segs) {
            if (q10 != -1) {
                if (p10 == q10) {
                    while (p10 <= end && path[p10] != 0) {
                        p10++;
                    }
                    if (p10 <= end) {
                        path[p10] = IOUtils.DIR_SEPARATOR_UNIX;
                        p10++;
                    }
                } else if (p10 < q10) {
                    while (q10 <= end && path[q10] != 0) {
                        path[p10] = path[q10];
                        p10++;
                        q10++;
                    }
                    if (q10 <= end) {
                        path[p10] = IOUtils.DIR_SEPARATOR_UNIX;
                        p10++;
                    }
                } else {
                    throw new InternalError();
                }
            }
        }
        return p10;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x002c, code lost:
    
        r4 = 2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void removeDots(char[] r10, int[] r11, boolean r12) {
        /*
            int r0 = r11.length
            int r1 = r10.length
            r2 = 1
            int r1 = r1 - r2
            r3 = 0
        L5:
            if (r3 >= r0) goto L6c
            r4 = 0
        L8:
            r5 = r11[r3]
            char r6 = r10[r5]
            r7 = 46
            if (r6 != r7) goto L2e
            if (r5 != r1) goto L14
            r4 = 1
            goto L33
        L14:
            int r6 = r5 + 1
            char r6 = r10[r6]
            if (r6 != 0) goto L1c
            r4 = 1
            goto L33
        L1c:
            int r6 = r5 + 1
            char r6 = r10[r6]
            if (r6 != r7) goto L2e
            int r6 = r5 + 1
            if (r6 == r1) goto L2c
            int r6 = r5 + 2
            char r6 = r10[r6]
            if (r6 != 0) goto L2e
        L2c:
            r4 = 2
            goto L33
        L2e:
            int r3 = r3 + 1
            if (r3 < r0) goto L8
        L33:
            if (r3 > r0) goto L6c
            if (r4 != 0) goto L38
            goto L6c
        L38:
            r5 = -1
            if (r4 != r2) goto L3e
            r11[r3] = r5
            goto L69
        L3e:
            int r6 = r3 + (-1)
        L40:
            if (r6 < 0) goto L4a
            r8 = r11[r6]
            if (r8 == r5) goto L47
            goto L4a
        L47:
            int r6 = r6 + (-1)
            goto L40
        L4a:
            if (r6 < 0) goto L63
            r8 = r11[r6]
            char r9 = r10[r8]
            if (r9 != r7) goto L5e
            int r9 = r8 + 1
            char r9 = r10[r9]
            if (r9 != r7) goto L5e
            int r7 = r8 + 2
            char r7 = r10[r7]
            if (r7 == 0) goto L68
        L5e:
            r11[r3] = r5
            r11[r6] = r5
            goto L68
        L63:
            if (r12 == 0) goto L68
            r11[r3] = r5
            goto L69
        L68:
        L69:
            int r3 = r3 + 1
            goto L5
        L6c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: java.net.URI.removeDots(char[], int[], boolean):void");
    }

    private static void maybeAddLeadingDot(char[] path, int[] segs) {
        if (path[0] == 0) {
            return;
        }
        int ns = segs.length;
        int f10 = 0;
        while (f10 < ns && segs[f10] < 0) {
            f10++;
        }
        if (f10 >= ns || f10 == 0) {
            return;
        }
        int p10 = segs[f10];
        while (p10 < path.length && path[p10] != ':' && path[p10] != 0) {
            p10++;
        }
        if (p10 < path.length && path[p10] != 0) {
            path[0] = '.';
            path[1] = 0;
            segs[0] = 0;
        }
    }

    private static String normalize(String ps) {
        return normalize(ps, false);
    }

    private static String normalize(String ps, boolean removeLeading) {
        int ns = needsNormalization(ps);
        if (ns < 0) {
            return ps;
        }
        char[] path = ps.toCharArray();
        int[] segs = new int[ns];
        split(path, segs);
        removeDots(path, segs, removeLeading);
        maybeAddLeadingDot(path, segs);
        String s2 = new String(path, 0, join(path, segs));
        if (s2.equals(ps)) {
            return ps;
        }
        return s2;
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

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean match(char c4, long lowMask, long highMask) {
        if (c4 == 0) {
            return false;
        }
        if (c4 < '@') {
            if (((1 << c4) & lowMask) == 0) {
                return false;
            }
            return true;
        }
        if (c4 >= 128 || ((1 << (c4 - 64)) & highMask) == 0) {
            return false;
        }
        return true;
    }

    private static void appendEscape(StringBuffer sb2, byte b4) {
        sb2.append('%');
        char[] cArr = hexDigits;
        sb2.append(cArr[(b4 >> 4) & 15]);
        sb2.append(cArr[(b4 >> 0) & 15]);
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

    private static String quote(String s2, long lowMask, long highMask) {
        s2.length();
        StringBuffer sb2 = null;
        boolean allowNonASCII = (1 & lowMask) != 0;
        for (int i10 = 0; i10 < s2.length(); i10++) {
            char c4 = s2.charAt(i10);
            if (c4 < 128) {
                if (!match(c4, lowMask, highMask)) {
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

    private static String encode(String s2) {
        int n10 = s2.length();
        if (n10 == 0) {
            return s2;
        }
        int i10 = 0;
        while (s2.charAt(i10) < 128) {
            i10++;
            if (i10 >= n10) {
                return s2;
            }
        }
        String ns = Normalizer.normalize(s2, Normalizer.Form.NFC);
        ByteBuffer bb2 = null;
        try {
            bb2 = ThreadLocalCoders.encoderFor("UTF-8").encode(CharBuffer.wrap(ns));
        } catch (CharacterCodingException e2) {
        }
        StringBuffer sb2 = new StringBuffer();
        while (bb2.hasRemaining()) {
            int b4 = bb2.get() & 255;
            if (b4 >= 128) {
                appendEscape(sb2, (byte) b4);
            } else {
                sb2.append((char) b4);
            }
        }
        return sb2.toString();
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
        return -1;
    }

    private static byte decode(char c12, char c22) {
        return (byte) (((decode(c12) & 15) << 4) | ((decode(c22) & 15) << 0));
    }

    private static String decode(String s2) {
        if (s2 == null) {
            return s2;
        }
        int n10 = s2.length();
        if (n10 == 0) {
            return s2;
        }
        if (s2.indexOf(37) < 0) {
            return s2;
        }
        StringBuffer sb2 = new StringBuffer(n10);
        ByteBuffer bb2 = ByteBuffer.allocate(n10);
        CharBuffer cb2 = CharBuffer.allocate(n10);
        CharsetDecoder dec = ThreadLocalCoders.decoderFor("UTF-8").onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE);
        char c4 = s2.charAt(0);
        boolean betweenBrackets = false;
        int i10 = 0;
        while (i10 < n10) {
            if (c4 == '[') {
                betweenBrackets = true;
            } else if (betweenBrackets && c4 == ']') {
                betweenBrackets = false;
            }
            if (c4 != '%' || betweenBrackets) {
                sb2.append(c4);
                i10++;
                if (i10 >= n10) {
                    break;
                }
                c4 = s2.charAt(i10);
            } else {
                bb2.clear();
                do {
                    int i11 = i10 + 1;
                    char charAt = s2.charAt(i11);
                    int i12 = i11 + 1;
                    bb2.put(decode(charAt, s2.charAt(i12)));
                    i10 = i12 + 1;
                    if (i10 >= n10) {
                        break;
                    }
                    c4 = s2.charAt(i10);
                } while (c4 == '%');
                bb2.flip();
                cb2.clear();
                dec.reset();
                dec.decode(bb2, cb2, true);
                dec.flush(cb2);
                sb2.append(cb2.flip().toString());
            }
        }
        return sb2.toString();
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private class Parser {
        private String input;
        private boolean requireServerAuthority = false;
        private int ipv6byteCount = 0;

        Parser(String s2) {
            this.input = s2;
            URI.this.string = s2;
        }

        private void fail(String reason) throws URISyntaxException {
            throw new URISyntaxException(this.input, reason);
        }

        private void fail(String reason, int p10) throws URISyntaxException {
            throw new URISyntaxException(this.input, reason, p10);
        }

        private void failExpecting(String expected, int p10) throws URISyntaxException {
            fail("Expected " + expected, p10);
        }

        private void failExpecting(String expected, String prior, int p10) throws URISyntaxException {
            fail("Expected " + expected + " following " + prior, p10);
        }

        private String substring(int start, int end) {
            return this.input.substring(start, end);
        }

        private char charAt(int p10) {
            return this.input.charAt(p10);
        }

        private boolean at(int start, int end, char c4) {
            return start < end && charAt(start) == c4;
        }

        private boolean at(int start, int end, String s2) {
            int p10 = start;
            int sn = s2.length();
            if (sn > end - p10) {
                return false;
            }
            int i10 = 0;
            while (i10 < sn) {
                int p11 = p10 + 1;
                if (charAt(p10) != s2.charAt(i10)) {
                    break;
                }
                i10++;
                p10 = p11;
            }
            return i10 == sn;
        }

        private int scan(int start, int end, char c4) {
            if (start < end && charAt(start) == c4) {
                return start + 1;
            }
            return start;
        }

        private int scan(int start, int end, String err, String stop) {
            int p10 = start;
            while (p10 < end) {
                char c4 = charAt(p10);
                if (err.indexOf(c4) >= 0) {
                    return -1;
                }
                if (stop.indexOf(c4) >= 0) {
                    break;
                }
                p10++;
            }
            return p10;
        }

        private int scanEscape(int start, int n10, char first) throws URISyntaxException {
            if (first != '%') {
                if (first > 128 && !Character.isSpaceChar(first) && !Character.isISOControl(first)) {
                    return start + 1;
                }
            } else if (start + 3 > n10 || !URI.match(charAt(start + 1), URI.L_HEX, URI.H_HEX) || !URI.match(charAt(start + 2), URI.L_HEX, URI.H_HEX)) {
                fail("Malformed escape pair", start);
            } else {
                return start + 3;
            }
            return start;
        }

        private int scan(int start, int n10, long lowMask, long highMask) throws URISyntaxException {
            int q10;
            int p10 = start;
            while (p10 < n10) {
                char c4 = charAt(p10);
                if (URI.match(c4, lowMask, highMask)) {
                    p10++;
                } else {
                    if ((1 & lowMask) == 0 || (q10 = scanEscape(p10, n10, c4)) <= p10) {
                        break;
                    }
                    p10 = q10;
                }
            }
            return p10;
        }

        private void checkChars(int start, int end, long lowMask, long highMask, String what) throws URISyntaxException {
            int p10 = scan(start, end, lowMask, highMask);
            if (p10 < end) {
                fail("Illegal character in " + what, p10);
            }
        }

        private void checkChar(int p10, long lowMask, long highMask, String what) throws URISyntaxException {
            checkChars(p10, p10 + 1, lowMask, highMask, what);
        }

        void parse(boolean rsa) throws URISyntaxException {
            int p10;
            int ssp;
            this.requireServerAuthority = rsa;
            int n10 = this.input.length();
            int p11 = scan(0, n10, "/?#", u.bD);
            if (p11 >= 0 && at(p11, n10, ShortcutConstants.SERVICES_SEPARATOR)) {
                if (p11 == 0) {
                    failExpecting("scheme name", 0);
                }
                checkChar(0, 0L, URI.H_ALPHA, "scheme name");
                checkChars(1, p11, URI.L_SCHEME, URI.H_SCHEME, "scheme name");
                URI.this.scheme = substring(0, p11);
                int p12 = p11 + 1;
                if (at(p12, n10, IOUtils.DIR_SEPARATOR_UNIX)) {
                    p10 = parseHierarchical(p12, n10);
                    ssp = p12;
                } else {
                    int q10 = scan(p12, n10, "", "#");
                    if (q10 <= p12) {
                        failExpecting("scheme-specific part", p12);
                    }
                    checkChars(p12, q10, URI.L_URIC, URI.H_URIC, "opaque part");
                    p10 = q10;
                    ssp = p12;
                }
            } else {
                p10 = parseHierarchical(0, n10);
                ssp = 0;
            }
            URI.this.schemeSpecificPart = substring(ssp, p10);
            if (at(p10, n10, '#')) {
                checkChars(p10 + 1, n10, URI.L_URIC, URI.H_URIC, "fragment");
                URI.this.fragment = substring(p10 + 1, n10);
                p10 = n10;
            }
            if (p10 < n10) {
                fail("end of URI", p10);
            }
        }

        private int parseHierarchical(int start, int n10) throws URISyntaxException {
            int p10 = start;
            if (at(p10, n10, IOUtils.DIR_SEPARATOR_UNIX) && at(p10 + 1, n10, IOUtils.DIR_SEPARATOR_UNIX)) {
                p10 += 2;
                int q10 = scan(p10, n10, "", "/?#");
                if (q10 > p10) {
                    p10 = parseAuthority(p10, q10);
                } else if (q10 >= n10) {
                    failExpecting("authority", p10);
                }
            }
            int q11 = scan(p10, n10, "", "?#");
            checkChars(p10, q11, URI.L_PATH, URI.H_PATH, "path");
            URI.this.path = substring(p10, q11);
            if (!at(q11, n10, '?')) {
                return q11;
            }
            int p11 = q11 + 1;
            int q12 = scan(p11, n10, "", "#");
            checkChars(p11, q12, URI.L_URIC, URI.H_URIC, SearchIntents.EXTRA_QUERY);
            URI.this.query = substring(p11, q12);
            return q12;
        }

        private int parseAuthority(int start, int n10) throws URISyntaxException {
            boolean serverChars;
            int q10 = start;
            URISyntaxException ex = null;
            if (scan(start, n10, "", "]") > start) {
                serverChars = scan(start, n10, URI.L_SERVER_PERCENT, URI.H_SERVER_PERCENT) == n10;
            } else {
                serverChars = scan(start, n10, URI.L_SERVER, URI.H_SERVER) == n10;
            }
            boolean regChars = scan(start, n10, URI.L_REG_NAME, URI.H_REG_NAME) == n10;
            if (regChars && !serverChars) {
                URI.this.authority = substring(start, n10);
                return n10;
            }
            if (serverChars) {
                try {
                    q10 = parseServer(start, n10);
                    if (q10 < n10) {
                        failExpecting("end of authority", q10);
                    }
                    URI.this.authority = substring(start, n10);
                } catch (URISyntaxException x10) {
                    URI.this.userInfo = null;
                    URI.this.host = null;
                    URI.this.port = -1;
                    if (this.requireServerAuthority) {
                        throw x10;
                    }
                    ex = x10;
                    q10 = start;
                }
            }
            if (q10 < n10) {
                if (regChars) {
                    URI.this.authority = substring(start, n10);
                } else {
                    if (ex != null) {
                        throw ex;
                    }
                    fail("Illegal character in authority", q10);
                }
            }
            return n10;
        }

        private int parseServer(int start, int n10) throws URISyntaxException {
            int q10;
            int p10;
            int p11 = start;
            int q11 = scan(p11, n10, "/?#", "@");
            if (q11 >= p11 && at(q11, n10, '@')) {
                checkChars(p11, q11, URI.L_USERINFO, URI.H_USERINFO, "user info");
                URI.this.userInfo = substring(p11, q11);
                p11 = q11 + 1;
            }
            if (at(p11, n10, '[')) {
                p10 = p11 + 1;
                int q12 = scan(p10, n10, "/?#", "]");
                if (q12 > p10 && at(q12, n10, ']')) {
                    int r10 = scan(p10, q12, "", "%");
                    if (r10 > p10) {
                        parseIPv6Reference(p10, r10);
                        if (r10 + 1 == q12) {
                            fail("scope id expected");
                        }
                        checkChars(r10 + 1, q12, URI.L_SCOPE_ID, URI.H_SCOPE_ID, "scope id");
                    } else {
                        parseIPv6Reference(p10, q12);
                    }
                    URI.this.host = substring(p10 - 1, q12 + 1);
                    p10 = q12 + 1;
                } else {
                    failExpecting("closing bracket for IPv6 address", q12);
                }
            } else {
                int q13 = parseIPv4Address(p11, n10);
                if (q13 > p11) {
                    q10 = q13;
                } else {
                    q10 = parseHostname(p11, n10);
                }
                p10 = q10;
            }
            if (at(p10, n10, ShortcutConstants.SERVICES_SEPARATOR)) {
                int p12 = p10 + 1;
                int q14 = scan(p12, n10, "", "/");
                if (q14 <= p12) {
                    p10 = p12;
                } else {
                    checkChars(p12, q14, URI.L_DIGIT, 0L, "port number");
                    try {
                        URI.this.port = Integer.parseInt(substring(p12, q14));
                    } catch (NumberFormatException e2) {
                        fail("Malformed port number", p12);
                    }
                    p10 = q14;
                }
            }
            if (p10 < n10) {
                failExpecting("port number", p10);
            }
            return p10;
        }

        private int scanByte(int start, int n10) throws URISyntaxException {
            int q10 = scan(start, n10, URI.L_DIGIT, 0L);
            if (q10 <= start) {
                return q10;
            }
            if (Integer.parseInt(substring(start, q10)) > 255) {
                return start;
            }
            return q10;
        }

        private int scanIPv4Address(int start, int n10, boolean strict) throws URISyntaxException {
            int m10 = scan(start, n10, URI.L_DIGIT | URI.L_DOT, URI.H_DOT | 0);
            if (m10 <= start || (strict && m10 != n10)) {
                return -1;
            }
            int scanByte = scanByte(start, m10);
            int q10 = scanByte;
            if (scanByte > start) {
                int scan = scan(q10, m10, '.');
                q10 = scan;
                if (scan > q10) {
                    int scanByte2 = scanByte(q10, m10);
                    q10 = scanByte2;
                    if (scanByte2 > q10) {
                        int scan2 = scan(q10, m10, '.');
                        q10 = scan2;
                        if (scan2 > q10) {
                            int scanByte3 = scanByte(q10, m10);
                            q10 = scanByte3;
                            if (scanByte3 > q10) {
                                int scan3 = scan(q10, m10, '.');
                                q10 = scan3;
                                if (scan3 > q10) {
                                    int scanByte4 = scanByte(q10, m10);
                                    q10 = scanByte4;
                                    if (scanByte4 > q10 && q10 >= m10) {
                                        return q10;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            fail("Malformed IPv4 address", q10);
            return -1;
        }

        private int takeIPv4Address(int start, int n10, String expected) throws URISyntaxException {
            int p10 = scanIPv4Address(start, n10, true);
            if (p10 <= start) {
                failExpecting(expected, start);
            }
            return p10;
        }

        private int parseIPv4Address(int start, int n10) {
            try {
                int p10 = scanIPv4Address(start, n10, false);
                if (p10 > start && p10 < n10 && charAt(p10) != ':') {
                    p10 = -1;
                }
                if (p10 > start) {
                    URI.this.host = substring(start, p10);
                }
                return p10;
            } catch (NumberFormatException e2) {
                return -1;
            } catch (URISyntaxException e10) {
                return -1;
            }
        }

        private int parseHostname(int start, int n10) throws URISyntaxException {
            int p10 = start;
            int l10 = -1;
            do {
                int q10 = scan(p10, n10, URI.L_ALPHANUM, URI.H_ALPHANUM);
                if (q10 <= p10) {
                    break;
                }
                l10 = p10;
                if (q10 > p10) {
                    p10 = q10;
                    int q11 = scan(p10, n10, URI.L_ALPHANUM | URI.L_DASH | URI.L_UNDERSCORE, URI.H_UNDERSCORE | URI.H_ALPHANUM | URI.H_DASH);
                    if (q11 > p10) {
                        if (charAt(q11 - 1) == '-') {
                            fail("Illegal character in hostname", q11 - 1);
                        }
                        p10 = q11;
                    }
                }
                int q12 = scan(p10, n10, '.');
                if (q12 <= p10) {
                    break;
                }
                p10 = q12;
            } while (p10 < n10);
            if (p10 < n10 && !at(p10, n10, ShortcutConstants.SERVICES_SEPARATOR)) {
                fail("Illegal character in hostname", p10);
            }
            if (l10 < 0) {
                failExpecting("hostname", start);
            }
            if (l10 > start && !URI.match(charAt(l10), 0L, URI.H_ALPHA)) {
                fail("Illegal character in hostname", l10);
            }
            URI.this.host = substring(start, p10);
            return p10;
        }

        private int parseIPv6Reference(int start, int n10) throws URISyntaxException {
            int p10 = start;
            boolean compressedZeros = false;
            int q10 = scanHexSeq(p10, n10);
            if (q10 > p10) {
                p10 = q10;
                if (at(p10, n10, "::")) {
                    compressedZeros = true;
                    p10 = scanHexPost(p10 + 2, n10);
                } else if (at(p10, n10, ShortcutConstants.SERVICES_SEPARATOR)) {
                    p10 = takeIPv4Address(p10 + 1, n10, "IPv4 address");
                    this.ipv6byteCount += 4;
                }
            } else if (at(p10, n10, "::")) {
                compressedZeros = true;
                p10 = scanHexPost(p10 + 2, n10);
            }
            if (p10 < n10) {
                fail("Malformed IPv6 address", start);
            }
            if (this.ipv6byteCount > 16) {
                fail("IPv6 address too long", start);
            }
            if (!compressedZeros && this.ipv6byteCount < 16) {
                fail("IPv6 address too short", start);
            }
            if (compressedZeros && this.ipv6byteCount == 16) {
                fail("Malformed IPv6 address", start);
            }
            return p10;
        }

        private int scanHexPost(int start, int n10) throws URISyntaxException {
            if (start == n10) {
                return start;
            }
            int q10 = scanHexSeq(start, n10);
            if (q10 > start) {
                if (!at(q10, n10, ShortcutConstants.SERVICES_SEPARATOR)) {
                    return q10;
                }
                int p10 = q10 + 1;
                int p11 = takeIPv4Address(p10, n10, "hex digits or IPv4 address");
                this.ipv6byteCount += 4;
                return p11;
            }
            int p12 = takeIPv4Address(start, n10, "hex digits or IPv4 address");
            this.ipv6byteCount += 4;
            return p12;
        }

        private int scanHexSeq(int start, int n10) throws URISyntaxException {
            int q10 = scan(start, n10, URI.L_HEX, URI.H_HEX);
            if (q10 <= start || at(q10, n10, '.')) {
                return -1;
            }
            if (q10 > start + 4) {
                fail("IPv6 hexadecimal digit sequence too long", start);
            }
            this.ipv6byteCount += 2;
            int p10 = q10;
            while (p10 < n10 && at(p10, n10, ShortcutConstants.SERVICES_SEPARATOR) && !at(p10 + 1, n10, ShortcutConstants.SERVICES_SEPARATOR)) {
                int p11 = p10 + 1;
                int q11 = scan(p11, n10, URI.L_HEX, URI.H_HEX);
                if (q11 <= p11) {
                    failExpecting("digits for an IPv6 address", p11);
                }
                if (at(q11, n10, '.')) {
                    return p11 - 1;
                }
                if (q11 > p11 + 4) {
                    fail("IPv6 hexadecimal digit sequence too long", p11);
                }
                this.ipv6byteCount += 2;
                p10 = q11;
            }
            return p10;
        }
    }
}
