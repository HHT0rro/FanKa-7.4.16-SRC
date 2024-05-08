package com.huawei.hms.scankit.p;

import android.text.TextUtils;
import com.huawei.hms.ml.scan.HmsScan;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: BookmarkDoCoMoResultParser.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class z extends t6 {

    /* renamed from: b, reason: collision with root package name */
    private static final Pattern f31772b = Pattern.compile("(?:MEBKM:)([\\s\\S]+)", 2);

    /* renamed from: c, reason: collision with root package name */
    private static final Pattern f31773c = Pattern.compile("(?:http:/?(?!/)|http//)([\\s\\S]+)", 2);

    private static String a(String[] strArr, String str) {
        for (String str2 : strArr) {
            if (str2.startsWith(str)) {
                return t6.b(str2.substring(str.length()));
            }
        }
        return "";
    }

    @Override // com.huawei.hms.scankit.p.t6
    public HmsScan b(s6 s6Var) {
        String a10 = t6.a(s6Var);
        if (TextUtils.isEmpty(a10)) {
            return null;
        }
        Matcher matcher = f31772b.matcher(a10);
        if (!matcher.matches()) {
            return null;
        }
        String[] split = matcher.group(1).split("(?<=(?<!\\\\)(?:\\\\\\\\){0,100});");
        String a11 = a(split, "TITLE:");
        String a12 = t6.a(a(split, "URL:"));
        if (a12.length() == 0) {
            return null;
        }
        Matcher matcher2 = f31773c.matcher(a12);
        if (matcher2.matches()) {
            a12 = a12.substring(0, 4) + "://" + matcher2.group(1);
        }
        String str = a12;
        return new HmsScan(s6Var.k(), t6.a(s6Var.c()), str, HmsScan.URL_FORM, s6Var.i(), t6.a(s6Var.j()), null, new z6(new HmsScan.LinkUrl(a11, str)));
    }
}
