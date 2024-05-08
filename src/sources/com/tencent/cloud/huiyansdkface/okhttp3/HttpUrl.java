package com.tencent.cloud.huiyansdkface.okhttp3;

import com.android.internal.accessibility.common.ShortcutConstants;
import com.google.android.material.badge.BadgeDrawable;
import com.huawei.appgallery.agd.common.constant.SymbolValues;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.Util;
import com.tencent.cloud.huiyansdkface.okio.Buffer;
import io.grpc.internal.GrpcUtil;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import org.apache.commons.io.IOUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class HttpUrl {

    /* renamed from: d, reason: collision with root package name */
    private static final char[] f41412d = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: a, reason: collision with root package name */
    public final String f41413a;

    /* renamed from: b, reason: collision with root package name */
    public final String f41414b;

    /* renamed from: c, reason: collision with root package name */
    public final int f41415c;

    /* renamed from: e, reason: collision with root package name */
    private final String f41416e;

    /* renamed from: f, reason: collision with root package name */
    private final String f41417f;

    /* renamed from: g, reason: collision with root package name */
    private final List<String> f41418g;

    /* renamed from: h, reason: collision with root package name */
    private final List<String> f41419h;

    /* renamed from: i, reason: collision with root package name */
    private final String f41420i;

    /* renamed from: j, reason: collision with root package name */
    private final String f41421j;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        public String f41422a;

        /* renamed from: d, reason: collision with root package name */
        public String f41425d;

        /* renamed from: f, reason: collision with root package name */
        public final List<String> f41427f;

        /* renamed from: g, reason: collision with root package name */
        public List<String> f41428g;

        /* renamed from: h, reason: collision with root package name */
        public String f41429h;

        /* renamed from: b, reason: collision with root package name */
        public String f41423b = "";

        /* renamed from: c, reason: collision with root package name */
        public String f41424c = "";

        /* renamed from: e, reason: collision with root package name */
        public int f41426e = -1;

        public Builder() {
            ArrayList arrayList = new ArrayList();
            this.f41427f = arrayList;
            arrayList.add("");
        }

        private Builder a(String str, boolean z10) {
            int i10 = 0;
            do {
                int delimiterOffset = Util.delimiterOffset(str, i10, str.length(), "/\\");
                a(str, i10, delimiterOffset, delimiterOffset < str.length(), z10);
                i10 = delimiterOffset + 1;
            } while (i10 <= str.length());
            return this;
        }

        private void a(String str) {
            for (int size = this.f41428g.size() - 2; size >= 0; size -= 2) {
                if (str.equals(this.f41428g.get(size))) {
                    this.f41428g.remove(size + 1);
                    this.f41428g.remove(size);
                    if (this.f41428g.isEmpty()) {
                        this.f41428g = null;
                        return;
                    }
                }
            }
        }

        private void a(String str, int i10, int i11) {
            if (i10 == i11) {
                return;
            }
            char charAt = str.charAt(i10);
            if (charAt == '/' || charAt == '\\') {
                this.f41427f.clear();
                this.f41427f.add("");
                i10++;
            } else {
                List<String> list = this.f41427f;
                list.set(list.size() - 1, "");
            }
            while (true) {
                int i12 = i10;
                if (i12 >= i11) {
                    return;
                }
                i10 = Util.delimiterOffset(str, i12, i11, "/\\");
                boolean z10 = i10 < i11;
                a(str, i12, i10, z10, true);
                if (z10) {
                    i10++;
                }
            }
        }

        private void a(String str, int i10, int i11, boolean z10, boolean z11) {
            String a10 = HttpUrl.a(str, i10, i11, " \"<>^`{}|/\\?#", z11, false, false, true, null);
            if (b(a10)) {
                return;
            }
            if (c(a10)) {
                c();
                return;
            }
            if (this.f41427f.get(r11.size() - 1).isEmpty()) {
                this.f41427f.set(r11.size() - 1, a10);
            } else {
                this.f41427f.add(a10);
            }
            if (z10) {
                this.f41427f.add("");
            }
        }

        private static int b(String str, int i10, int i11) {
            if (i11 - i10 < 2) {
                return -1;
            }
            char charAt = str.charAt(i10);
            if ((charAt >= 'a' && charAt <= 'z') || (charAt >= 'A' && charAt <= 'Z')) {
                while (true) {
                    i10++;
                    if (i10 >= i11) {
                        break;
                    }
                    char charAt2 = str.charAt(i10);
                    if (charAt2 < 'a' || charAt2 > 'z') {
                        if (charAt2 < 'A' || charAt2 > 'Z') {
                            if (charAt2 < '0' || charAt2 > '9') {
                                if (charAt2 != '+' && charAt2 != '-' && charAt2 != '.') {
                                    if (charAt2 == ':') {
                                        return i10;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return -1;
        }

        private boolean b(String str) {
            return str.equals(".") || str.equalsIgnoreCase("%2e");
        }

        private static int c(String str, int i10, int i11) {
            int i12 = 0;
            while (i10 < i11) {
                char charAt = str.charAt(i10);
                if (charAt != '\\' && charAt != '/') {
                    break;
                }
                i12++;
                i10++;
            }
            return i12;
        }

        private void c() {
            if (!this.f41427f.remove(r0.size() - 1).isEmpty() || this.f41427f.isEmpty()) {
                this.f41427f.add("");
            } else {
                this.f41427f.set(r0.size() - 1, "");
            }
        }

        private boolean c(String str) {
            return str.equals("..") || str.equalsIgnoreCase("%2e.") || str.equalsIgnoreCase(".%2e") || str.equalsIgnoreCase("%2e%2e");
        }

        private static int d(String str, int i10, int i11) {
            while (i10 < i11) {
                char charAt = str.charAt(i10);
                if (charAt == ':') {
                    return i10;
                }
                if (charAt != '[') {
                    i10++;
                }
                do {
                    i10++;
                    if (i10 < i11) {
                    }
                    i10++;
                } while (str.charAt(i10) != ']');
                i10++;
            }
            return i11;
        }

        private static String e(String str, int i10, int i11) {
            return Util.canonicalizeHost(HttpUrl.a(str, i10, i11, false));
        }

        private static int f(String str, int i10, int i11) {
            int parseInt;
            try {
                parseInt = Integer.parseInt(HttpUrl.a(str, i10, i11, "", false, false, false, true, null));
            } catch (NumberFormatException unused) {
            }
            if (parseInt <= 0 || parseInt > 65535) {
                return -1;
            }
            return parseInt;
        }

        public int a() {
            int i10 = this.f41426e;
            return i10 != -1 ? i10 : HttpUrl.defaultPort(this.f41422a);
        }

        public Builder a(HttpUrl httpUrl, String str) {
            int delimiterOffset;
            int i10;
            int skipLeadingAsciiWhitespace = Util.skipLeadingAsciiWhitespace(str, 0, str.length());
            int skipTrailingAsciiWhitespace = Util.skipTrailingAsciiWhitespace(str, skipLeadingAsciiWhitespace, str.length());
            int b4 = b(str, skipLeadingAsciiWhitespace, skipTrailingAsciiWhitespace);
            if (b4 != -1) {
                if (str.regionMatches(true, skipLeadingAsciiWhitespace, "https:", 0, 6)) {
                    this.f41422a = "https";
                    skipLeadingAsciiWhitespace += 6;
                } else {
                    if (!str.regionMatches(true, skipLeadingAsciiWhitespace, "http:", 0, 5)) {
                        throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but was '" + str.substring(0, b4) + "'");
                    }
                    this.f41422a = "http";
                    skipLeadingAsciiWhitespace += 5;
                }
            } else {
                if (httpUrl == null) {
                    throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no colon was found");
                }
                this.f41422a = httpUrl.f41413a;
            }
            int c4 = c(str, skipLeadingAsciiWhitespace, skipTrailingAsciiWhitespace);
            char c10 = '?';
            char c11 = '#';
            if (c4 >= 2 || httpUrl == null || !httpUrl.f41413a.equals(this.f41422a)) {
                int i11 = skipLeadingAsciiWhitespace + c4;
                boolean z10 = false;
                boolean z11 = false;
                while (true) {
                    delimiterOffset = Util.delimiterOffset(str, i11, skipTrailingAsciiWhitespace, "@/\\?#");
                    char charAt = delimiterOffset != skipTrailingAsciiWhitespace ? str.charAt(delimiterOffset) : (char) 65535;
                    if (charAt == 65535 || charAt == c11 || charAt == '/' || charAt == '\\' || charAt == c10) {
                        break;
                    }
                    if (charAt == '@') {
                        if (z10) {
                            i10 = delimiterOffset;
                            this.f41424c += "%40" + HttpUrl.a(str, i11, i10, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                        } else {
                            int delimiterOffset2 = Util.delimiterOffset(str, i11, delimiterOffset, ShortcutConstants.SERVICES_SEPARATOR);
                            i10 = delimiterOffset;
                            String a10 = HttpUrl.a(str, i11, delimiterOffset2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                            if (z11) {
                                a10 = this.f41423b + "%40" + a10;
                            }
                            this.f41423b = a10;
                            if (delimiterOffset2 != i10) {
                                this.f41424c = HttpUrl.a(str, delimiterOffset2 + 1, i10, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                                z10 = true;
                            }
                            z11 = true;
                        }
                        i11 = i10 + 1;
                    }
                    c10 = '?';
                    c11 = '#';
                }
                int d10 = d(str, i11, delimiterOffset);
                int i12 = d10 + 1;
                if (i12 < delimiterOffset) {
                    this.f41425d = e(str, i11, d10);
                    int f10 = f(str, i12, delimiterOffset);
                    this.f41426e = f10;
                    if (f10 == -1) {
                        throw new IllegalArgumentException("Invalid URL port: \"" + str.substring(i12, delimiterOffset) + '\"');
                    }
                } else {
                    this.f41425d = e(str, i11, d10);
                    this.f41426e = HttpUrl.defaultPort(this.f41422a);
                }
                if (this.f41425d == null) {
                    throw new IllegalArgumentException("Invalid URL host: \"" + str.substring(i11, d10) + '\"');
                }
                skipLeadingAsciiWhitespace = delimiterOffset;
            } else {
                this.f41423b = httpUrl.encodedUsername();
                this.f41424c = httpUrl.encodedPassword();
                this.f41425d = httpUrl.f41414b;
                this.f41426e = httpUrl.f41415c;
                this.f41427f.clear();
                this.f41427f.addAll(httpUrl.encodedPathSegments());
                if (skipLeadingAsciiWhitespace == skipTrailingAsciiWhitespace || str.charAt(skipLeadingAsciiWhitespace) == '#') {
                    encodedQuery(httpUrl.encodedQuery());
                }
            }
            int delimiterOffset3 = Util.delimiterOffset(str, skipLeadingAsciiWhitespace, skipTrailingAsciiWhitespace, "?#");
            a(str, skipLeadingAsciiWhitespace, delimiterOffset3);
            if (delimiterOffset3 < skipTrailingAsciiWhitespace && str.charAt(delimiterOffset3) == '?') {
                int delimiterOffset4 = Util.delimiterOffset(str, delimiterOffset3, skipTrailingAsciiWhitespace, '#');
                this.f41428g = HttpUrl.a(HttpUrl.a(str, delimiterOffset3 + 1, delimiterOffset4, " \"'<>#", true, false, true, true, null));
                delimiterOffset3 = delimiterOffset4;
            }
            if (delimiterOffset3 < skipTrailingAsciiWhitespace && str.charAt(delimiterOffset3) == '#') {
                this.f41429h = HttpUrl.a(str, 1 + delimiterOffset3, skipTrailingAsciiWhitespace, "", true, false, false, false, null);
            }
            return this;
        }

        public Builder addEncodedPathSegment(String str) {
            Objects.requireNonNull(str, "encodedPathSegment == null");
            a(str, 0, str.length(), false, true);
            return this;
        }

        public Builder addEncodedPathSegments(String str) {
            Objects.requireNonNull(str, "encodedPathSegments == null");
            return a(str, true);
        }

        public Builder addEncodedQueryParameter(String str, String str2) {
            Objects.requireNonNull(str, "encodedName == null");
            if (this.f41428g == null) {
                this.f41428g = new ArrayList();
            }
            this.f41428g.add(HttpUrl.a(str, " \"'<>#&=", true, false, true, true));
            this.f41428g.add(str2 != null ? HttpUrl.a(str2, " \"'<>#&=", true, false, true, true) : null);
            return this;
        }

        public Builder addPathSegment(String str) {
            Objects.requireNonNull(str, "pathSegment == null");
            a(str, 0, str.length(), false, false);
            return this;
        }

        public Builder addPathSegments(String str) {
            Objects.requireNonNull(str, "pathSegments == null");
            return a(str, false);
        }

        public Builder addQueryParameter(String str, String str2) {
            Objects.requireNonNull(str, "name == null");
            if (this.f41428g == null) {
                this.f41428g = new ArrayList();
            }
            this.f41428g.add(HttpUrl.a(str, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, true));
            this.f41428g.add(str2 != null ? HttpUrl.a(str2, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, true) : null);
            return this;
        }

        public Builder b() {
            int size = this.f41427f.size();
            for (int i10 = 0; i10 < size; i10++) {
                this.f41427f.set(i10, HttpUrl.a(this.f41427f.get(i10), "[]", true, true, false, true));
            }
            List<String> list = this.f41428g;
            if (list != null) {
                int size2 = list.size();
                for (int i11 = 0; i11 < size2; i11++) {
                    String str = this.f41428g.get(i11);
                    if (str != null) {
                        this.f41428g.set(i11, HttpUrl.a(str, "\\^`{|}", true, true, true, true));
                    }
                }
            }
            String str2 = this.f41429h;
            if (str2 != null) {
                this.f41429h = HttpUrl.a(str2, " \"#<>\\^`{|}", true, true, false, false);
            }
            return this;
        }

        public HttpUrl build() {
            if (this.f41422a == null) {
                throw new IllegalStateException("scheme == null");
            }
            if (this.f41425d != null) {
                return new HttpUrl(this);
            }
            throw new IllegalStateException("host == null");
        }

        public Builder encodedFragment(String str) {
            this.f41429h = str != null ? HttpUrl.a(str, "", true, false, false, false) : null;
            return this;
        }

        public Builder encodedPassword(String str) {
            Objects.requireNonNull(str, "encodedPassword == null");
            this.f41424c = HttpUrl.a(str, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
            return this;
        }

        public Builder encodedPath(String str) {
            Objects.requireNonNull(str, "encodedPath == null");
            if (str.startsWith("/")) {
                a(str, 0, str.length());
                return this;
            }
            throw new IllegalArgumentException("unexpected encodedPath: " + str);
        }

        public Builder encodedQuery(String str) {
            this.f41428g = str != null ? HttpUrl.a(HttpUrl.a(str, " \"'<>#", true, false, true, true)) : null;
            return this;
        }

        public Builder encodedUsername(String str) {
            Objects.requireNonNull(str, "encodedUsername == null");
            this.f41423b = HttpUrl.a(str, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
            return this;
        }

        public Builder fragment(String str) {
            this.f41429h = str != null ? HttpUrl.a(str, "", false, false, false, false) : null;
            return this;
        }

        public Builder host(String str) {
            Objects.requireNonNull(str, "host == null");
            String e2 = e(str, 0, str.length());
            if (e2 != null) {
                this.f41425d = e2;
                return this;
            }
            throw new IllegalArgumentException("unexpected host: " + str);
        }

        public Builder password(String str) {
            Objects.requireNonNull(str, "password == null");
            this.f41424c = HttpUrl.a(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        }

        public Builder port(int i10) {
            if (i10 > 0 && i10 <= 65535) {
                this.f41426e = i10;
                return this;
            }
            throw new IllegalArgumentException("unexpected port: " + i10);
        }

        public Builder query(String str) {
            this.f41428g = str != null ? HttpUrl.a(HttpUrl.a(str, " \"'<>#", false, false, true, true)) : null;
            return this;
        }

        public Builder removeAllEncodedQueryParameters(String str) {
            Objects.requireNonNull(str, "encodedName == null");
            if (this.f41428g == null) {
                return this;
            }
            a(HttpUrl.a(str, " \"'<>#&=", true, false, true, true));
            return this;
        }

        public Builder removeAllQueryParameters(String str) {
            Objects.requireNonNull(str, "name == null");
            if (this.f41428g == null) {
                return this;
            }
            a(HttpUrl.a(str, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, true));
            return this;
        }

        public Builder removePathSegment(int i10) {
            this.f41427f.remove(i10);
            if (this.f41427f.isEmpty()) {
                this.f41427f.add("");
            }
            return this;
        }

        public Builder scheme(String str) {
            Objects.requireNonNull(str, "scheme == null");
            String str2 = "http";
            if (!str.equalsIgnoreCase("http")) {
                str2 = "https";
                if (!str.equalsIgnoreCase("https")) {
                    throw new IllegalArgumentException("unexpected scheme: " + str);
                }
            }
            this.f41422a = str2;
            return this;
        }

        public Builder setEncodedPathSegment(int i10, String str) {
            Objects.requireNonNull(str, "encodedPathSegment == null");
            String a10 = HttpUrl.a(str, 0, str.length(), " \"<>^`{}|/\\?#", true, false, false, true, null);
            this.f41427f.set(i10, a10);
            if (!b(a10) && !c(a10)) {
                return this;
            }
            throw new IllegalArgumentException("unexpected path segment: " + str);
        }

        public Builder setEncodedQueryParameter(String str, String str2) {
            removeAllEncodedQueryParameters(str);
            addEncodedQueryParameter(str, str2);
            return this;
        }

        public Builder setPathSegment(int i10, String str) {
            Objects.requireNonNull(str, "pathSegment == null");
            String a10 = HttpUrl.a(str, 0, str.length(), " \"<>^`{}|/\\?#", false, false, false, true, null);
            if (!b(a10) && !c(a10)) {
                this.f41427f.set(i10, a10);
                return this;
            }
            throw new IllegalArgumentException("unexpected path segment: " + str);
        }

        public Builder setQueryParameter(String str, String str2) {
            removeAllQueryParameters(str);
            addQueryParameter(str, str2);
            return this;
        }

        public String toString() {
            String str;
            StringBuilder sb2 = new StringBuilder();
            String str2 = this.f41422a;
            if (str2 != null) {
                sb2.append(str2);
                str = "://";
            } else {
                str = "//";
            }
            sb2.append(str);
            if (!this.f41423b.isEmpty() || !this.f41424c.isEmpty()) {
                sb2.append(this.f41423b);
                if (!this.f41424c.isEmpty()) {
                    sb2.append(ShortcutConstants.SERVICES_SEPARATOR);
                    sb2.append(this.f41424c);
                }
                sb2.append('@');
            }
            String str3 = this.f41425d;
            if (str3 != null) {
                if (str3.indexOf(58) != -1) {
                    sb2.append('[');
                    sb2.append(this.f41425d);
                    sb2.append(']');
                } else {
                    sb2.append(this.f41425d);
                }
            }
            if (this.f41426e != -1 || this.f41422a != null) {
                int a10 = a();
                String str4 = this.f41422a;
                if (str4 == null || a10 != HttpUrl.defaultPort(str4)) {
                    sb2.append(ShortcutConstants.SERVICES_SEPARATOR);
                    sb2.append(a10);
                }
            }
            HttpUrl.a(sb2, this.f41427f);
            if (this.f41428g != null) {
                sb2.append('?');
                HttpUrl.b(sb2, this.f41428g);
            }
            if (this.f41429h != null) {
                sb2.append('#');
                sb2.append(this.f41429h);
            }
            return sb2.toString();
        }

        public Builder username(String str) {
            Objects.requireNonNull(str, "username == null");
            this.f41423b = HttpUrl.a(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        }
    }

    public HttpUrl(Builder builder) {
        this.f41413a = builder.f41422a;
        this.f41416e = a(builder.f41423b, false);
        this.f41417f = a(builder.f41424c, false);
        this.f41414b = builder.f41425d;
        this.f41415c = builder.a();
        this.f41418g = a(builder.f41427f, false);
        List<String> list = builder.f41428g;
        this.f41419h = list != null ? a(list, true) : null;
        String str = builder.f41429h;
        this.f41420i = str != null ? a(str, false) : null;
        this.f41421j = builder.toString();
    }

    public static String a(String str, int i10, int i11, String str2, boolean z10, boolean z11, boolean z12, boolean z13, Charset charset) {
        int i12 = i10;
        while (i12 < i11) {
            int codePointAt = str.codePointAt(i12);
            if (codePointAt >= 32 && codePointAt != 127 && (codePointAt < 128 || !z13)) {
                if (str2.indexOf(codePointAt) == -1 && ((codePointAt != 37 || (z10 && (!z11 || a(str, i12, i11)))) && (codePointAt != 43 || !z12))) {
                    i12 += Character.charCount(codePointAt);
                }
            }
            Buffer buffer = new Buffer();
            buffer.writeUtf8(str, i10, i12);
            a(buffer, str, i12, i11, str2, z10, z11, z12, z13, charset);
            return buffer.readUtf8();
        }
        return str.substring(i10, i11);
    }

    public static String a(String str, int i10, int i11, boolean z10) {
        for (int i12 = i10; i12 < i11; i12++) {
            char charAt = str.charAt(i12);
            if (charAt == '%' || (charAt == '+' && z10)) {
                Buffer buffer = new Buffer();
                buffer.writeUtf8(str, i10, i12);
                a(buffer, str, i12, i11, z10);
                return buffer.readUtf8();
            }
        }
        return str.substring(i10, i11);
    }

    public static String a(String str, String str2, boolean z10, boolean z11, boolean z12, boolean z13) {
        return a(str, 0, str.length(), str2, z10, z11, z12, z13, null);
    }

    public static String a(String str, String str2, boolean z10, boolean z11, boolean z12, boolean z13, Charset charset) {
        return a(str, 0, str.length(), str2, z10, z11, z12, z13, charset);
    }

    public static String a(String str, boolean z10) {
        return a(str, 0, str.length(), z10);
    }

    public static List<String> a(String str) {
        String str2;
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        while (i10 <= str.length()) {
            int indexOf = str.indexOf(38, i10);
            if (indexOf == -1) {
                indexOf = str.length();
            }
            int indexOf2 = str.indexOf(61, i10);
            if (indexOf2 == -1 || indexOf2 > indexOf) {
                arrayList.add(str.substring(i10, indexOf));
                str2 = null;
            } else {
                arrayList.add(str.substring(i10, indexOf2));
                str2 = str.substring(indexOf2 + 1, indexOf);
            }
            arrayList.add(str2);
            i10 = indexOf + 1;
        }
        return arrayList;
    }

    private List<String> a(List<String> list, boolean z10) {
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i10 = 0; i10 < size; i10++) {
            String str = list.get(i10);
            arrayList.add(str != null ? a(str, z10) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    public static void a(Buffer buffer, String str, int i10, int i11, String str2, boolean z10, boolean z11, boolean z12, boolean z13, Charset charset) {
        Buffer buffer2 = null;
        while (i10 < i11) {
            int codePointAt = str.codePointAt(i10);
            if (!z10 || (codePointAt != 9 && codePointAt != 10 && codePointAt != 12 && codePointAt != 13)) {
                if (codePointAt == 43 && z12) {
                    buffer.writeUtf8(z10 ? BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX : "%2B");
                } else if (codePointAt < 32 || codePointAt == 127 || ((codePointAt >= 128 && z13) || str2.indexOf(codePointAt) != -1 || (codePointAt == 37 && (!z10 || (z11 && !a(str, i10, i11)))))) {
                    if (buffer2 == null) {
                        buffer2 = new Buffer();
                    }
                    if (charset == null || charset.equals(Util.f41604e)) {
                        buffer2.writeUtf8CodePoint(codePointAt);
                    } else {
                        buffer2.writeString(str, i10, Character.charCount(codePointAt) + i10, charset);
                    }
                    while (!buffer2.exhausted()) {
                        int readByte = buffer2.readByte() & 255;
                        buffer.writeByte(37);
                        char[] cArr = f41412d;
                        buffer.writeByte((int) cArr[(readByte >> 4) & 15]);
                        buffer.writeByte((int) cArr[readByte & 15]);
                    }
                } else {
                    buffer.writeUtf8CodePoint(codePointAt);
                }
            }
            i10 += Character.charCount(codePointAt);
        }
    }

    public static void a(Buffer buffer, String str, int i10, int i11, boolean z10) {
        int i12;
        while (i10 < i11) {
            int codePointAt = str.codePointAt(i10);
            if (codePointAt != 37 || (i12 = i10 + 2) >= i11) {
                if (codePointAt == 43 && z10) {
                    buffer.writeByte(32);
                }
                buffer.writeUtf8CodePoint(codePointAt);
            } else {
                int decodeHexDigit = Util.decodeHexDigit(str.charAt(i10 + 1));
                int decodeHexDigit2 = Util.decodeHexDigit(str.charAt(i12));
                if (decodeHexDigit != -1 && decodeHexDigit2 != -1) {
                    buffer.writeByte((decodeHexDigit << 4) + decodeHexDigit2);
                    i10 = i12;
                }
                buffer.writeUtf8CodePoint(codePointAt);
            }
            i10 += Character.charCount(codePointAt);
        }
    }

    public static void a(StringBuilder sb2, List<String> list) {
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            sb2.append(IOUtils.DIR_SEPARATOR_UNIX);
            sb2.append(list.get(i10));
        }
    }

    public static boolean a(String str, int i10, int i11) {
        int i12 = i10 + 2;
        return i12 < i11 && str.charAt(i10) == '%' && Util.decodeHexDigit(str.charAt(i10 + 1)) != -1 && Util.decodeHexDigit(str.charAt(i12)) != -1;
    }

    public static void b(StringBuilder sb2, List<String> list) {
        int size = list.size();
        for (int i10 = 0; i10 < size; i10 += 2) {
            String str = list.get(i10);
            String str2 = list.get(i10 + 1);
            if (i10 > 0) {
                sb2.append(SymbolValues.CHAR_AND_SYMBOL);
            }
            sb2.append(str);
            if (str2 != null) {
                sb2.append('=');
                sb2.append(str2);
            }
        }
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

    public static HttpUrl get(String str) {
        return new Builder().a((HttpUrl) null, str).build();
    }

    public static HttpUrl get(URI uri) {
        return parse(uri.toString());
    }

    public static HttpUrl get(URL url) {
        return parse(url.toString());
    }

    public static HttpUrl parse(String str) {
        try {
            return get(str);
        } catch (IllegalArgumentException e2) {
            OkHttpLogger.log("url parse err:" + str, e2);
            return null;
        }
    }

    public String encodedFragment() {
        if (this.f41420i == null) {
            return null;
        }
        return this.f41421j.substring(this.f41421j.indexOf(35) + 1);
    }

    public String encodedPassword() {
        if (this.f41417f.isEmpty()) {
            return "";
        }
        return this.f41421j.substring(this.f41421j.indexOf(58, this.f41413a.length() + 3) + 1, this.f41421j.indexOf(64));
    }

    public String encodedPath() {
        int indexOf = this.f41421j.indexOf(47, this.f41413a.length() + 3);
        String str = this.f41421j;
        return this.f41421j.substring(indexOf, Util.delimiterOffset(str, indexOf, str.length(), "?#"));
    }

    public List<String> encodedPathSegments() {
        int indexOf = this.f41421j.indexOf(47, this.f41413a.length() + 3);
        String str = this.f41421j;
        int delimiterOffset = Util.delimiterOffset(str, indexOf, str.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (indexOf < delimiterOffset) {
            int i10 = indexOf + 1;
            int delimiterOffset2 = Util.delimiterOffset(this.f41421j, i10, delimiterOffset, IOUtils.DIR_SEPARATOR_UNIX);
            arrayList.add(this.f41421j.substring(i10, delimiterOffset2));
            indexOf = delimiterOffset2;
        }
        return arrayList;
    }

    public String encodedQuery() {
        if (this.f41419h == null) {
            return null;
        }
        int indexOf = this.f41421j.indexOf(63) + 1;
        String str = this.f41421j;
        return this.f41421j.substring(indexOf, Util.delimiterOffset(str, indexOf, str.length(), '#'));
    }

    public String encodedUsername() {
        if (this.f41416e.isEmpty()) {
            return "";
        }
        int length = this.f41413a.length() + 3;
        String str = this.f41421j;
        return this.f41421j.substring(length, Util.delimiterOffset(str, length, str.length(), ":@"));
    }

    public boolean equals(Object obj) {
        return (obj instanceof HttpUrl) && ((HttpUrl) obj).f41421j.equals(this.f41421j);
    }

    public String fragment() {
        return this.f41420i;
    }

    public int hashCode() {
        return this.f41421j.hashCode();
    }

    public String host() {
        return this.f41414b;
    }

    public boolean isHttps() {
        return this.f41413a.equals("https");
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.f41422a = this.f41413a;
        builder.f41423b = encodedUsername();
        builder.f41424c = encodedPassword();
        builder.f41425d = this.f41414b;
        builder.f41426e = this.f41415c != defaultPort(this.f41413a) ? this.f41415c : -1;
        builder.f41427f.clear();
        builder.f41427f.addAll(encodedPathSegments());
        builder.encodedQuery(encodedQuery());
        builder.f41429h = encodedFragment();
        return builder;
    }

    public Builder newBuilder(String str) {
        try {
            return new Builder().a(this, str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public String password() {
        return this.f41417f;
    }

    public List<String> pathSegments() {
        return this.f41418g;
    }

    public int pathSize() {
        return this.f41418g.size();
    }

    public int port() {
        return this.f41415c;
    }

    public String query() {
        if (this.f41419h == null) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        b(sb2, this.f41419h);
        return sb2.toString();
    }

    public String queryParameter(String str) {
        List<String> list = this.f41419h;
        if (list == null) {
            return null;
        }
        int size = list.size();
        for (int i10 = 0; i10 < size; i10 += 2) {
            if (str.equals(this.f41419h.get(i10))) {
                return this.f41419h.get(i10 + 1);
            }
        }
        return null;
    }

    public String queryParameterName(int i10) {
        List<String> list = this.f41419h;
        if (list != null) {
            return list.get(i10 * 2);
        }
        throw new IndexOutOfBoundsException();
    }

    public Set<String> queryParameterNames() {
        if (this.f41419h == null) {
            return Collections.emptySet();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int size = this.f41419h.size();
        for (int i10 = 0; i10 < size; i10 += 2) {
            linkedHashSet.add(this.f41419h.get(i10));
        }
        return Collections.unmodifiableSet(linkedHashSet);
    }

    public String queryParameterValue(int i10) {
        List<String> list = this.f41419h;
        if (list != null) {
            return list.get((i10 * 2) + 1);
        }
        throw new IndexOutOfBoundsException();
    }

    public List<String> queryParameterValues(String str) {
        if (this.f41419h == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        int size = this.f41419h.size();
        for (int i10 = 0; i10 < size; i10 += 2) {
            if (str.equals(this.f41419h.get(i10))) {
                arrayList.add(this.f41419h.get(i10 + 1));
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public int querySize() {
        List<String> list = this.f41419h;
        if (list != null) {
            return list.size() / 2;
        }
        return 0;
    }

    public String redact() {
        return newBuilder("/...").username("").password("").build().toString();
    }

    public HttpUrl resolve(String str) {
        Builder newBuilder = newBuilder(str);
        if (newBuilder != null) {
            return newBuilder.build();
        }
        return null;
    }

    public String scheme() {
        return this.f41413a;
    }

    public String toString() {
        return this.f41421j;
    }

    public URI uri() {
        String builder = newBuilder().b().toString();
        try {
            return new URI(builder);
        } catch (URISyntaxException e2) {
            try {
                return URI.create(builder.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
            } catch (Exception unused) {
                throw new RuntimeException(e2);
            }
        }
    }

    public URL url() {
        try {
            return new URL(this.f41421j);
        } catch (MalformedURLException e2) {
            throw new RuntimeException(e2);
        }
    }

    public String username() {
        return this.f41416e;
    }
}
