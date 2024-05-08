package com.tencent.cloud.huiyansdkface.okhttp3;

import com.android.internal.logging.nano.MetricsProto;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.Util;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.http.HttpDate;
import com.wangmai.okhttp.model.HttpHeaders;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class Cookie {

    /* renamed from: a, reason: collision with root package name */
    private static final Pattern f41366a = Pattern.compile("(\\d{2,4})[^\\d]*");

    /* renamed from: b, reason: collision with root package name */
    private static final Pattern f41367b = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");

    /* renamed from: c, reason: collision with root package name */
    private static final Pattern f41368c = Pattern.compile("(\\d{1,2})[^\\d]*");

    /* renamed from: d, reason: collision with root package name */
    private static final Pattern f41369d = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    /* renamed from: e, reason: collision with root package name */
    private final String f41370e;

    /* renamed from: f, reason: collision with root package name */
    private final String f41371f;

    /* renamed from: g, reason: collision with root package name */
    private final long f41372g;

    /* renamed from: h, reason: collision with root package name */
    private final String f41373h;

    /* renamed from: i, reason: collision with root package name */
    private final String f41374i;

    /* renamed from: j, reason: collision with root package name */
    private final boolean f41375j;

    /* renamed from: k, reason: collision with root package name */
    private final boolean f41376k;

    /* renamed from: l, reason: collision with root package name */
    private final boolean f41377l;

    /* renamed from: m, reason: collision with root package name */
    private final boolean f41378m;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        public String f41379a;

        /* renamed from: b, reason: collision with root package name */
        public String f41380b;

        /* renamed from: d, reason: collision with root package name */
        public String f41382d;

        /* renamed from: f, reason: collision with root package name */
        public boolean f41384f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f41385g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f41386h;

        /* renamed from: i, reason: collision with root package name */
        public boolean f41387i;

        /* renamed from: c, reason: collision with root package name */
        public long f41381c = 253402300799999L;

        /* renamed from: e, reason: collision with root package name */
        public String f41383e = "/";

        private Builder a(String str, boolean z10) {
            Objects.requireNonNull(str, "domain == null");
            String canonicalizeHost = Util.canonicalizeHost(str);
            if (canonicalizeHost != null) {
                this.f41382d = canonicalizeHost;
                this.f41387i = z10;
                return this;
            }
            throw new IllegalArgumentException("unexpected domain: " + str);
        }

        public Cookie build() {
            return new Cookie(this);
        }

        public Builder domain(String str) {
            return a(str, false);
        }

        public Builder expiresAt(long j10) {
            if (j10 <= 0) {
                j10 = Long.MIN_VALUE;
            }
            if (j10 > 253402300799999L) {
                j10 = 253402300799999L;
            }
            this.f41381c = j10;
            this.f41386h = true;
            return this;
        }

        public Builder hostOnlyDomain(String str) {
            return a(str, true);
        }

        public Builder httpOnly() {
            this.f41385g = true;
            return this;
        }

        public Builder name(String str) {
            Objects.requireNonNull(str, "name == null");
            if (!str.trim().equals(str)) {
                throw new IllegalArgumentException("name is not trimmed");
            }
            this.f41379a = str;
            return this;
        }

        public Builder path(String str) {
            if (!str.startsWith("/")) {
                throw new IllegalArgumentException("path must start with '/'");
            }
            this.f41383e = str;
            return this;
        }

        public Builder secure() {
            this.f41384f = true;
            return this;
        }

        public Builder value(String str) {
            Objects.requireNonNull(str, "value == null");
            if (!str.trim().equals(str)) {
                throw new IllegalArgumentException("value is not trimmed");
            }
            this.f41380b = str;
            return this;
        }
    }

    public Cookie(Builder builder) {
        String str = builder.f41379a;
        Objects.requireNonNull(str, "builder.name == null");
        String str2 = builder.f41380b;
        Objects.requireNonNull(str2, "builder.value == null");
        String str3 = builder.f41382d;
        Objects.requireNonNull(str3, "builder.domain == null");
        this.f41370e = str;
        this.f41371f = str2;
        this.f41372g = builder.f41381c;
        this.f41373h = str3;
        this.f41374i = builder.f41383e;
        this.f41375j = builder.f41384f;
        this.f41376k = builder.f41385g;
        this.f41377l = builder.f41386h;
        this.f41378m = builder.f41387i;
    }

    private Cookie(String str, String str2, long j10, String str3, String str4, boolean z10, boolean z11, boolean z12, boolean z13) {
        this.f41370e = str;
        this.f41371f = str2;
        this.f41372g = j10;
        this.f41373h = str3;
        this.f41374i = str4;
        this.f41375j = z10;
        this.f41376k = z11;
        this.f41378m = z12;
        this.f41377l = z13;
    }

    private static int a(String str, int i10, int i11, boolean z10) {
        while (i10 < i11) {
            char charAt = str.charAt(i10);
            if (((charAt < ' ' && charAt != '\t') || charAt >= 127 || (charAt >= '0' && charAt <= '9') || ((charAt >= 'a' && charAt <= 'z') || ((charAt >= 'A' && charAt <= 'Z') || charAt == ':'))) == (!z10)) {
                return i10;
            }
            i10++;
        }
        return i11;
    }

    private static long a(String str) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong <= 0) {
                return Long.MIN_VALUE;
            }
            return parseLong;
        } catch (NumberFormatException e2) {
            if (str.matches("-?\\d+")) {
                return str.startsWith("-") ? Long.MIN_VALUE : Long.MAX_VALUE;
            }
            throw e2;
        }
    }

    private static long a(String str, int i10, int i11) {
        int a10 = a(str, i10, i11, false);
        Matcher matcher = f41369d.matcher(str);
        int i12 = -1;
        int i13 = -1;
        int i14 = -1;
        int i15 = -1;
        int i16 = -1;
        int i17 = -1;
        while (a10 < i11) {
            int a11 = a(str, a10 + 1, i11, true);
            matcher.region(a10, a11);
            if (i13 == -1 && matcher.usePattern(f41369d).matches()) {
                i13 = Integer.parseInt(matcher.group(1));
                i16 = Integer.parseInt(matcher.group(2));
                i17 = Integer.parseInt(matcher.group(3));
            } else if (i14 == -1 && matcher.usePattern(f41368c).matches()) {
                i14 = Integer.parseInt(matcher.group(1));
            } else {
                if (i15 == -1) {
                    Pattern pattern = f41367b;
                    if (matcher.usePattern(pattern).matches()) {
                        i15 = pattern.pattern().indexOf(matcher.group(1).toLowerCase(Locale.US)) / 4;
                    }
                }
                if (i12 == -1 && matcher.usePattern(f41366a).matches()) {
                    i12 = Integer.parseInt(matcher.group(1));
                }
            }
            a10 = a(str, a11 + 1, i11, false);
        }
        if (i12 >= 70 && i12 <= 99) {
            i12 += 1900;
        }
        if (i12 >= 0 && i12 <= 69) {
            i12 += 2000;
        }
        if (i12 < 1601) {
            throw new IllegalArgumentException();
        }
        if (i15 == -1) {
            throw new IllegalArgumentException();
        }
        if (i14 < 1 || i14 > 31) {
            throw new IllegalArgumentException();
        }
        if (i13 < 0 || i13 > 23) {
            throw new IllegalArgumentException();
        }
        if (i16 < 0 || i16 > 59) {
            throw new IllegalArgumentException();
        }
        if (i17 < 0 || i17 > 59) {
            throw new IllegalArgumentException();
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar(Util.f41606g);
        gregorianCalendar.setLenient(false);
        gregorianCalendar.set(1, i12);
        gregorianCalendar.set(2, i15 - 1);
        gregorianCalendar.set(5, i14);
        gregorianCalendar.set(11, i13);
        gregorianCalendar.set(12, i16);
        gregorianCalendar.set(13, i17);
        gregorianCalendar.set(14, 0);
        return gregorianCalendar.getTimeInMillis();
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00ef  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.tencent.cloud.huiyansdkface.okhttp3.Cookie a(long r23, com.tencent.cloud.huiyansdkface.okhttp3.HttpUrl r25, java.lang.String r26) {
        /*
            Method dump skipped, instructions count: 288
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.cloud.huiyansdkface.okhttp3.Cookie.a(long, com.tencent.cloud.huiyansdkface.okhttp3.HttpUrl, java.lang.String):com.tencent.cloud.huiyansdkface.okhttp3.Cookie");
    }

    private static boolean a(HttpUrl httpUrl, String str) {
        String encodedPath = httpUrl.encodedPath();
        if (encodedPath.equals(str)) {
            return true;
        }
        if (encodedPath.startsWith(str)) {
            return str.endsWith("/") || encodedPath.charAt(str.length()) == '/';
        }
        return false;
    }

    private static boolean a(String str, String str2) {
        if (str.equals(str2)) {
            return true;
        }
        return str.endsWith(str2) && str.charAt((str.length() - str2.length()) - 1) == '.' && !Util.verifyAsIpAddress(str);
    }

    private static String b(String str) {
        if (str.endsWith(".")) {
            throw new IllegalArgumentException();
        }
        if (str.startsWith(".")) {
            str = str.substring(1);
        }
        String canonicalizeHost = Util.canonicalizeHost(str);
        if (canonicalizeHost != null) {
            return canonicalizeHost;
        }
        throw new IllegalArgumentException();
    }

    public static Cookie parse(HttpUrl httpUrl, String str) {
        return a(System.currentTimeMillis(), httpUrl, str);
    }

    public static List<Cookie> parseAll(HttpUrl httpUrl, Headers headers) {
        List<String> values = headers.values(HttpHeaders.HEAD_KEY_SET_COOKIE);
        int size = values.size();
        ArrayList arrayList = null;
        for (int i10 = 0; i10 < size; i10++) {
            Cookie parse = parse(httpUrl, values.get(i10));
            if (parse != null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(parse);
            }
        }
        return arrayList != null ? Collections.unmodifiableList(arrayList) : Collections.emptyList();
    }

    public String a(boolean z10) {
        String format;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f41370e);
        sb2.append('=');
        sb2.append(this.f41371f);
        if (this.f41377l) {
            if (this.f41372g == Long.MIN_VALUE) {
                format = "; max-age=0";
            } else {
                sb2.append("; expires=");
                format = HttpDate.format(new Date(this.f41372g));
            }
            sb2.append(format);
        }
        if (!this.f41378m) {
            sb2.append("; domain=");
            if (z10) {
                sb2.append(".");
            }
            sb2.append(this.f41373h);
        }
        sb2.append("; path=");
        sb2.append(this.f41374i);
        if (this.f41375j) {
            sb2.append("; secure");
        }
        if (this.f41376k) {
            sb2.append("; httponly");
        }
        return sb2.toString();
    }

    public String domain() {
        return this.f41373h;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Cookie)) {
            return false;
        }
        Cookie cookie = (Cookie) obj;
        return cookie.f41370e.equals(this.f41370e) && cookie.f41371f.equals(this.f41371f) && cookie.f41373h.equals(this.f41373h) && cookie.f41374i.equals(this.f41374i) && cookie.f41372g == this.f41372g && cookie.f41375j == this.f41375j && cookie.f41376k == this.f41376k && cookie.f41377l == this.f41377l && cookie.f41378m == this.f41378m;
    }

    public long expiresAt() {
        return this.f41372g;
    }

    public int hashCode() {
        int hashCode = (((((((MetricsProto.MetricsEvent.DIALOG_SUPPORT_PHONE + this.f41370e.hashCode()) * 31) + this.f41371f.hashCode()) * 31) + this.f41373h.hashCode()) * 31) + this.f41374i.hashCode()) * 31;
        long j10 = this.f41372g;
        return ((((((((hashCode + ((int) (j10 ^ (j10 >>> 32)))) * 31) + (!this.f41375j ? 1 : 0)) * 31) + (!this.f41376k ? 1 : 0)) * 31) + (!this.f41377l ? 1 : 0)) * 31) + (!this.f41378m ? 1 : 0);
    }

    public boolean hostOnly() {
        return this.f41378m;
    }

    public boolean httpOnly() {
        return this.f41376k;
    }

    public boolean matches(HttpUrl httpUrl) {
        if ((this.f41378m ? httpUrl.host().equals(this.f41373h) : a(httpUrl.host(), this.f41373h)) && a(httpUrl, this.f41374i)) {
            return !this.f41375j || httpUrl.isHttps();
        }
        return false;
    }

    public String name() {
        return this.f41370e;
    }

    public String path() {
        return this.f41374i;
    }

    public boolean persistent() {
        return this.f41377l;
    }

    public boolean secure() {
        return this.f41375j;
    }

    public String toString() {
        return a(false);
    }

    public String value() {
        return this.f41371f;
    }
}
