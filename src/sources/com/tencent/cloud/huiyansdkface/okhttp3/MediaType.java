package com.tencent.cloud.huiyansdkface.okhttp3;

import com.baidu.mobads.sdk.internal.an;
import com.huawei.openalliance.ad.constant.bb;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class MediaType {

    /* renamed from: m, reason: collision with root package name */
    private final String f41442m;

    /* renamed from: n, reason: collision with root package name */
    private final String f41443n;

    /* renamed from: o, reason: collision with root package name */
    private final String f41444o;

    /* renamed from: p, reason: collision with root package name */
    private final String f41445p;

    /* renamed from: k, reason: collision with root package name */
    private static final Pattern f41440k = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");

    /* renamed from: l, reason: collision with root package name */
    private static final Pattern f41441l = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    /* renamed from: a, reason: collision with root package name */
    public static final MediaType f41430a = parse(bb.Z);

    /* renamed from: b, reason: collision with root package name */
    public static final MediaType f41431b = parse(bb.I);

    /* renamed from: c, reason: collision with root package name */
    public static final MediaType f41432c = parse(bb.B);

    /* renamed from: d, reason: collision with root package name */
    public static final MediaType f41433d = parse(an.f9799e);

    /* renamed from: e, reason: collision with root package name */
    public static final MediaType f41434e = parse("text/html");

    /* renamed from: f, reason: collision with root package name */
    public static final MediaType f41435f = parse("text/xml");

    /* renamed from: g, reason: collision with root package name */
    public static final MediaType f41436g = parse("application/json");

    /* renamed from: h, reason: collision with root package name */
    public static final MediaType f41437h = parse("application/x-www-form-urlencoded");

    /* renamed from: i, reason: collision with root package name */
    public static final MediaType f41438i = parse("multipart/form-data");

    /* renamed from: j, reason: collision with root package name */
    public static final MediaType f41439j = parse("application/octet-stream");

    private MediaType(String str, String str2, String str3, String str4) {
        this.f41442m = str;
        this.f41443n = str2;
        this.f41444o = str3;
        this.f41445p = str4;
    }

    public static MediaType get(String str) {
        Matcher matcher = f41440k.matcher(str);
        if (!matcher.lookingAt()) {
            throw new IllegalArgumentException("No subtype found for: \"" + str + '\"');
        }
        String group = matcher.group(1);
        Locale locale = Locale.US;
        String lowerCase = group.toLowerCase(locale);
        String lowerCase2 = matcher.group(2).toLowerCase(locale);
        String str2 = null;
        Matcher matcher2 = f41441l.matcher(str);
        for (int end = matcher.end(); end < str.length(); end = matcher2.end()) {
            matcher2.region(end, str.length());
            if (!matcher2.lookingAt()) {
                throw new IllegalArgumentException("Parameter is not formatted correctly: \"" + str.substring(end) + "\" for: \"" + str + '\"');
            }
            String group2 = matcher2.group(1);
            if (group2 != null && group2.equalsIgnoreCase("charset")) {
                String group3 = matcher2.group(2);
                if (group3 == null) {
                    group3 = matcher2.group(3);
                } else if (group3.startsWith("'") && group3.endsWith("'") && group3.length() > 2) {
                    group3 = group3.substring(1, group3.length() - 1);
                }
                if (str2 != null && !group3.equalsIgnoreCase(str2)) {
                    throw new IllegalArgumentException("Multiple charsets defined: \"" + str2 + "\" and: \"" + group3 + "\" for: \"" + str + '\"');
                }
                str2 = group3;
            }
        }
        return new MediaType(str, lowerCase, lowerCase2, str2);
    }

    public static MediaType parse(String str) {
        try {
            return get(str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public Charset charset() {
        return charset(null);
    }

    public Charset charset(Charset charset) {
        try {
            String str = this.f41445p;
            return str != null ? Charset.forName(str) : charset;
        } catch (IllegalArgumentException unused) {
            return charset;
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof MediaType) && ((MediaType) obj).f41442m.equals(this.f41442m);
    }

    public int hashCode() {
        return this.f41442m.hashCode();
    }

    public String subtype() {
        return this.f41444o;
    }

    public String toString() {
        return this.f41442m;
    }

    public String type() {
        return this.f41443n;
    }
}
