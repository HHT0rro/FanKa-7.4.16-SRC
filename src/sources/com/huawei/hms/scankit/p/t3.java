package com.huawei.hms.scankit.p;

import com.huawei.hms.ml.scan.HmsScan;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: HTTPResultParser.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class t3 extends t6 {

    /* renamed from: b, reason: collision with root package name */
    private static final Pattern f31545b = Pattern.compile("(?:http:|http//|https://)([\\s\\S]+)", 2);

    /* renamed from: c, reason: collision with root package name */
    private static final Pattern f31546c = Pattern.compile("(?:http:/?(?!/)|http//)([\\s\\S]+)", 2);

    @Override // com.huawei.hms.scankit.p.t6
    public HmsScan b(s6 s6Var) {
        String a10 = t6.a(s6Var);
        if (!f31545b.matcher(a10).matches()) {
            return null;
        }
        Matcher matcher = f31546c.matcher(a10);
        if (matcher.matches()) {
            a10 = a10.substring(0, 4) + "://" + matcher.group(1);
        }
        String a11 = t6.a(a10);
        if (a11.length() == 7) {
            return null;
        }
        return new HmsScan(s6Var.k(), t6.a(s6Var.c()), a11, HmsScan.URL_FORM, s6Var.i(), t6.a(s6Var.j()), null, new z6(new HmsScan.LinkUrl("", a11)));
    }
}
