package java.net;

import com.wangmai.okhttp.cookie.SerializableCookie;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TimeZone;
import libcore.net.http.HttpDate;
import org.apache.commons.lang3.time.TimeZones;
import wseemann.media.FFmpegMediaMetadataRetriever;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class HttpCookie implements Cloneable {
    static final TimeZone GMT;
    private static final long MAX_AGE_UNSPECIFIED = -1;
    private static final Set<String> RESERVED_NAMES;
    private static final String SET_COOKIE = "set-cookie:";
    private static final String SET_COOKIE2 = "set-cookie2:";
    static final Map<String, CookieAttributeAssignor> assignors;
    private static final String tspecials = ",;= \t";
    private String comment;
    private String commentURL;
    private String domain;
    private final String header;
    private boolean httpOnly;
    private long maxAge;
    private final String name;
    private String path;
    private String portlist;
    private boolean secure;
    private boolean toDiscard;
    private String value;
    private int version;
    private final long whenCreated;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public interface CookieAttributeAssignor {
        void assign(HttpCookie httpCookie, String str, String str2);
    }

    static {
        HashSet hashSet = new HashSet();
        RESERVED_NAMES = hashSet;
        hashSet.add(FFmpegMediaMetadataRetriever.METADATA_KEY_COMMENT);
        hashSet.add("commenturl");
        hashSet.add("discard");
        hashSet.add(SerializableCookie.DOMAIN);
        hashSet.add("expires");
        hashSet.add("httponly");
        hashSet.add("max-age");
        hashSet.add("path");
        hashSet.add("port");
        hashSet.add("secure");
        hashSet.add("version");
        HashMap hashMap = new HashMap();
        assignors = hashMap;
        hashMap.put(FFmpegMediaMetadataRetriever.METADATA_KEY_COMMENT, new CookieAttributeAssignor() { // from class: java.net.HttpCookie.1
            @Override // java.net.HttpCookie.CookieAttributeAssignor
            public void assign(HttpCookie cookie, String attrName, String attrValue) {
                if (cookie.getComment() == null) {
                    cookie.setComment(attrValue);
                }
            }
        });
        hashMap.put("commenturl", new CookieAttributeAssignor() { // from class: java.net.HttpCookie.2
            @Override // java.net.HttpCookie.CookieAttributeAssignor
            public void assign(HttpCookie cookie, String attrName, String attrValue) {
                if (cookie.getCommentURL() == null) {
                    cookie.setCommentURL(attrValue);
                }
            }
        });
        hashMap.put("discard", new CookieAttributeAssignor() { // from class: java.net.HttpCookie.3
            @Override // java.net.HttpCookie.CookieAttributeAssignor
            public void assign(HttpCookie cookie, String attrName, String attrValue) {
                cookie.setDiscard(true);
            }
        });
        hashMap.put(SerializableCookie.DOMAIN, new CookieAttributeAssignor() { // from class: java.net.HttpCookie.4
            @Override // java.net.HttpCookie.CookieAttributeAssignor
            public void assign(HttpCookie cookie, String attrName, String attrValue) {
                if (cookie.getDomain() == null) {
                    cookie.setDomain(attrValue);
                }
            }
        });
        hashMap.put("max-age", new CookieAttributeAssignor() { // from class: java.net.HttpCookie.5
            @Override // java.net.HttpCookie.CookieAttributeAssignor
            public void assign(HttpCookie cookie, String attrName, String attrValue) {
                try {
                    long maxage = Long.parseLong(attrValue);
                    if (cookie.getMaxAge() == -1) {
                        cookie.setMaxAge(maxage);
                    }
                } catch (NumberFormatException e2) {
                    throw new IllegalArgumentException("Illegal cookie max-age attribute");
                }
            }
        });
        hashMap.put("path", new CookieAttributeAssignor() { // from class: java.net.HttpCookie.6
            @Override // java.net.HttpCookie.CookieAttributeAssignor
            public void assign(HttpCookie cookie, String attrName, String attrValue) {
                if (cookie.getPath() == null) {
                    cookie.setPath(attrValue);
                }
            }
        });
        hashMap.put("port", new CookieAttributeAssignor() { // from class: java.net.HttpCookie.7
            @Override // java.net.HttpCookie.CookieAttributeAssignor
            public void assign(HttpCookie cookie, String attrName, String attrValue) {
                if (cookie.getPortlist() == null) {
                    cookie.setPortlist(attrValue == null ? "" : attrValue);
                }
            }
        });
        hashMap.put("secure", new CookieAttributeAssignor() { // from class: java.net.HttpCookie.8
            @Override // java.net.HttpCookie.CookieAttributeAssignor
            public void assign(HttpCookie cookie, String attrName, String attrValue) {
                cookie.setSecure(true);
            }
        });
        hashMap.put("httponly", new CookieAttributeAssignor() { // from class: java.net.HttpCookie.9
            @Override // java.net.HttpCookie.CookieAttributeAssignor
            public void assign(HttpCookie cookie, String attrName, String attrValue) {
                cookie.setHttpOnly(true);
            }
        });
        hashMap.put("version", new CookieAttributeAssignor() { // from class: java.net.HttpCookie.10
            @Override // java.net.HttpCookie.CookieAttributeAssignor
            public void assign(HttpCookie cookie, String attrName, String attrValue) {
                try {
                    int version = Integer.parseInt(attrValue);
                    cookie.setVersion(version);
                } catch (NumberFormatException e2) {
                }
            }
        });
        hashMap.put("expires", new CookieAttributeAssignor() { // from class: java.net.HttpCookie.11
            @Override // java.net.HttpCookie.CookieAttributeAssignor
            public void assign(HttpCookie cookie, String attrName, String attrValue) {
                if (cookie.getMaxAge() == -1) {
                    Date date = HttpDate.parse(attrValue);
                    long maxAgeInSeconds = 0;
                    if (date != null) {
                        maxAgeInSeconds = (date.getTime() - cookie.whenCreated) / 1000;
                        if (maxAgeInSeconds == -1) {
                            maxAgeInSeconds = 0;
                        }
                    }
                    cookie.setMaxAge(maxAgeInSeconds);
                }
            }
        });
        GMT = TimeZone.getTimeZone(TimeZones.GMT_ID);
    }

    public HttpCookie(String name, String value) {
        this(name, value, null);
    }

    private HttpCookie(String name, String value, String header) {
        this.maxAge = -1L;
        this.version = 1;
        String name2 = name.trim();
        if (name2.length() == 0 || !isToken(name2) || name2.charAt(0) == '$') {
            throw new IllegalArgumentException("Illegal cookie name");
        }
        this.name = name2;
        this.value = value;
        this.toDiscard = false;
        this.secure = false;
        this.whenCreated = System.currentTimeMillis();
        this.portlist = null;
        this.header = header;
    }

    public static List<HttpCookie> parse(String header) {
        return parse(header, false);
    }

    private static List<HttpCookie> parse(String header, boolean retainHeader) {
        int version = guessCookieVersion(header);
        if (startsWithIgnoreCase(header, SET_COOKIE2)) {
            header = header.substring(SET_COOKIE2.length());
        } else if (startsWithIgnoreCase(header, SET_COOKIE)) {
            header = header.substring(SET_COOKIE.length());
        }
        List<HttpCookie> cookies = new ArrayList<>();
        if (version == 0) {
            HttpCookie cookie = parseInternal(header, retainHeader);
            cookie.setVersion(0);
            cookies.add(cookie);
        } else {
            List<String> cookieStrings = splitMultiCookies(header);
            for (String cookieStr : cookieStrings) {
                HttpCookie cookie2 = parseInternal(cookieStr, retainHeader);
                cookie2.setVersion(1);
                cookies.add(cookie2);
            }
        }
        return cookies;
    }

    public boolean hasExpired() {
        long j10 = this.maxAge;
        if (j10 == 0) {
            return true;
        }
        if (j10 == -1) {
            return false;
        }
        long deltaSecond = (System.currentTimeMillis() - this.whenCreated) / 1000;
        return deltaSecond > this.maxAge;
    }

    public void setComment(String purpose) {
        this.comment = purpose;
    }

    public String getComment() {
        return this.comment;
    }

    public void setCommentURL(String purpose) {
        this.commentURL = purpose;
    }

    public String getCommentURL() {
        return this.commentURL;
    }

    public void setDiscard(boolean discard) {
        this.toDiscard = discard;
    }

    public boolean getDiscard() {
        return this.toDiscard;
    }

    public void setPortlist(String ports) {
        this.portlist = ports;
    }

    public String getPortlist() {
        return this.portlist;
    }

    public void setDomain(String pattern) {
        if (pattern != null) {
            this.domain = pattern.toLowerCase();
        } else {
            this.domain = pattern;
        }
    }

    public String getDomain() {
        return this.domain;
    }

    public void setMaxAge(long expiry) {
        this.maxAge = expiry;
    }

    public long getMaxAge() {
        return this.maxAge;
    }

    public void setPath(String uri) {
        this.path = uri;
    }

    public String getPath() {
        return this.path;
    }

    public void setSecure(boolean flag) {
        this.secure = flag;
    }

    public boolean getSecure() {
        return this.secure;
    }

    public String getName() {
        return this.name;
    }

    public void setValue(String newValue) {
        this.value = newValue;
    }

    public String getValue() {
        return this.value;
    }

    public int getVersion() {
        return this.version;
    }

    public void setVersion(int v2) {
        if (v2 != 0 && v2 != 1) {
            throw new IllegalArgumentException("cookie version should be 0 or 1");
        }
        this.version = v2;
    }

    public boolean isHttpOnly() {
        return this.httpOnly;
    }

    public void setHttpOnly(boolean httpOnly) {
        this.httpOnly = httpOnly;
    }

    public static boolean domainMatches(String domain, String host) {
        if (domain == null || host == null) {
            return false;
        }
        boolean isLocalDomain = ".local".equalsIgnoreCase(domain);
        int embeddedDotInDomain = domain.indexOf(46);
        if (embeddedDotInDomain == 0) {
            embeddedDotInDomain = domain.indexOf(46, 1);
        }
        if (!isLocalDomain && (embeddedDotInDomain == -1 || embeddedDotInDomain == domain.length() - 1)) {
            return false;
        }
        int firstDotInHost = host.indexOf(46);
        if (firstDotInHost == -1 && (isLocalDomain || domain.equalsIgnoreCase(host + ".local"))) {
            return true;
        }
        int domainLength = domain.length();
        int lengthDiff = host.length() - domainLength;
        if (lengthDiff == 0) {
            return host.equalsIgnoreCase(domain);
        }
        if (lengthDiff > 0) {
            host.substring(0, lengthDiff);
            String D = host.substring(lengthDiff);
            if (!D.equalsIgnoreCase(domain)) {
                return false;
            }
            if ((!domain.startsWith(".") || !isFullyQualifiedDomainName(domain, 1)) && !isLocalDomain) {
                return false;
            }
            return true;
        }
        if (lengthDiff != -1 || domain.charAt(0) != '.' || !host.equalsIgnoreCase(domain.substring(1))) {
            return false;
        }
        return true;
    }

    private static boolean isFullyQualifiedDomainName(String s2, int firstCharacter) {
        int dotPosition = s2.indexOf(46, firstCharacter + 1);
        return dotPosition != -1 && dotPosition < s2.length() - 1;
    }

    public String toString() {
        if (getVersion() > 0) {
            return toRFC2965HeaderString();
        }
        return toNetscapeHeaderString();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof HttpCookie)) {
            return false;
        }
        HttpCookie other = (HttpCookie) obj;
        return equalsIgnoreCase(getName(), other.getName()) && equalsIgnoreCase(getDomain(), other.getDomain()) && Objects.equals(getPath(), other.getPath());
    }

    public int hashCode() {
        int h12 = this.name.toLowerCase().hashCode();
        String str = this.domain;
        int h22 = str != null ? str.toLowerCase().hashCode() : 0;
        String str2 = this.path;
        int h32 = str2 != null ? str2.hashCode() : 0;
        return h12 + h22 + h32;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2.getMessage());
        }
    }

    private static boolean isToken(String value) {
        if (RESERVED_NAMES.contains(value.toLowerCase(Locale.US))) {
            return false;
        }
        int len = value.length();
        for (int i10 = 0; i10 < len; i10++) {
            char c4 = value.charAt(i10);
            if (c4 < ' ' || c4 >= 127 || tspecials.indexOf(c4) != -1) {
                return false;
            }
        }
        return true;
    }

    private static HttpCookie parseInternal(String header, boolean retainHeader) {
        HttpCookie cookie;
        String name;
        String value;
        StringTokenizer tokenizer = new StringTokenizer(header, ";");
        try {
            String namevaluePair = tokenizer.nextToken();
            int index = namevaluePair.indexOf(61);
            if (index != -1) {
                String name2 = namevaluePair.substring(0, index).trim();
                String value2 = namevaluePair.substring(index + 1).trim();
                if (retainHeader) {
                    cookie = new HttpCookie(name2, stripOffSurroundingQuote(value2), header);
                } else {
                    cookie = new HttpCookie(name2, stripOffSurroundingQuote(value2));
                }
                while (tokenizer.hasMoreTokens()) {
                    String namevaluePair2 = tokenizer.nextToken();
                    int index2 = namevaluePair2.indexOf(61);
                    if (index2 != -1) {
                        name = namevaluePair2.substring(0, index2).trim();
                        value = namevaluePair2.substring(index2 + 1).trim();
                    } else {
                        name = namevaluePair2.trim();
                        value = null;
                    }
                    assignAttribute(cookie, name, value);
                }
                return cookie;
            }
            throw new IllegalArgumentException("Invalid cookie name-value pair");
        } catch (NoSuchElementException e2) {
            throw new IllegalArgumentException("Empty cookie header string");
        }
    }

    private static void assignAttribute(HttpCookie cookie, String attrName, String attrValue) {
        String attrValue2 = stripOffSurroundingQuote(attrValue);
        CookieAttributeAssignor assignor = assignors.get(attrName.toLowerCase());
        if (assignor != null) {
            assignor.assign(cookie, attrName, attrValue2);
        }
    }

    private String header() {
        return this.header;
    }

    private String toNetscapeHeaderString() {
        return getName() + "=" + getValue();
    }

    private String toRFC2965HeaderString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getName()).append("=\"").append(getValue()).append('\"');
        if (getPath() != null) {
            sb2.append(";$Path=\"").append(getPath()).append('\"');
        }
        if (getDomain() != null) {
            sb2.append(";$Domain=\"").append(getDomain()).append('\"');
        }
        if (getPortlist() != null) {
            sb2.append(";$Port=\"").append(getPortlist()).append('\"');
        }
        return sb2.toString();
    }

    private static int guessCookieVersion(String header) {
        String header2 = header.toLowerCase();
        if (header2.indexOf("expires=") != -1) {
            return 0;
        }
        if (header2.indexOf("version=") == -1 && header2.indexOf("max-age") == -1 && !startsWithIgnoreCase(header2, SET_COOKIE2)) {
            return 0;
        }
        return 1;
    }

    private static String stripOffSurroundingQuote(String str) {
        if (str != null && str.length() > 2 && str.charAt(0) == '\"' && str.charAt(str.length() - 1) == '\"') {
            return str.substring(1, str.length() - 1);
        }
        if (str != null && str.length() > 2 && str.charAt(0) == '\'' && str.charAt(str.length() - 1) == '\'') {
            return str.substring(1, str.length() - 1);
        }
        return str;
    }

    private static boolean equalsIgnoreCase(String s2, String t2) {
        if (s2 == t2) {
            return true;
        }
        if (s2 != null && t2 != null) {
            return s2.equalsIgnoreCase(t2);
        }
        return false;
    }

    private static boolean startsWithIgnoreCase(String s2, String start) {
        if (s2 == null || start == null || s2.length() < start.length() || !start.equalsIgnoreCase(s2.substring(0, start.length()))) {
            return false;
        }
        return true;
    }

    private static List<String> splitMultiCookies(String header) {
        List<String> cookies = new ArrayList<>();
        int quoteCount = 0;
        int q10 = 0;
        for (int p10 = 0; p10 < header.length(); p10++) {
            char c4 = header.charAt(p10);
            if (c4 == '\"') {
                quoteCount++;
            }
            if (c4 == ',' && quoteCount % 2 == 0) {
                cookies.add(header.substring(q10, p10));
                q10 = p10 + 1;
            }
        }
        cookies.add(header.substring(q10));
        return cookies;
    }
}
