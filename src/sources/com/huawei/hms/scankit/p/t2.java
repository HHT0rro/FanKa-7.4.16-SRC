package com.huawei.hms.scankit.p;

import android.text.TextUtils;
import com.huawei.hms.ml.scan.HmsScan;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: EmailContentAddressResultParser.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class t2 extends t6 {

    /* renamed from: b, reason: collision with root package name */
    private static final Pattern f31541b = Pattern.compile("(?:MATMSG:TO:|mailto:|SMTP:)([\\s\\S]+)", 2);

    /* renamed from: c, reason: collision with root package name */
    private static final Pattern f31542c = Pattern.compile("mailto:([\\s\\S]+)\\?subject=([\\s\\S]+)&body=([\\s\\S]+)", 2);

    /* renamed from: d, reason: collision with root package name */
    private static final Pattern f31543d = Pattern.compile("MATMSG:TO:([\\s\\S]+);SUB:([\\s\\S]+);BODY:([\\s\\S]+)", 2);

    /* renamed from: e, reason: collision with root package name */
    private static final Pattern f31544e = Pattern.compile("SMTP:([\\s\\S]+):([\\s\\S]+):([\\s\\S]+)", 2);

    public static String c(String str) {
        try {
            return URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return str;
        }
    }

    @Override // com.huawei.hms.scankit.p.t6
    public HmsScan b(s6 s6Var) {
        Matcher matcher;
        Matcher matcher2;
        Matcher matcher3;
        String group;
        String str;
        String group2;
        String a10 = t6.a(s6Var);
        if (TextUtils.isEmpty(a10) || !f31541b.matcher(a10).matches()) {
            return null;
        }
        try {
            matcher = f31542c.matcher(a10);
            matcher2 = f31543d.matcher(a10);
            matcher3 = f31544e.matcher(a10);
        } catch (RuntimeException | Exception unused) {
        }
        if (matcher.matches()) {
            String group3 = matcher.group(1);
            group = matcher.group(2);
            group2 = matcher.group(3);
            str = group3;
        } else if (matcher2.matches()) {
            String group4 = matcher2.group(1);
            String group5 = matcher2.group(2);
            String group6 = matcher2.group(3);
            str = group4;
            group = group5;
            group2 = group6;
        } else {
            if (matcher3.matches()) {
                String group7 = matcher3.group(1);
                group = matcher3.group(2);
                str = group7;
                group2 = matcher3.group(3);
            }
            return null;
        }
        return new HmsScan(s6Var.k(), t6.a(s6Var.c()), str, HmsScan.EMAIL_CONTENT_FORM, s6Var.i(), t6.a(s6Var.j()), null, new z6(new HmsScan.EmailContent(str, c(group), c(group2), HmsScan.EmailContent.OTHER_USE_TYPE)));
    }
}
