package com.huawei.hms.scankit.p;

import android.text.TextUtils;
import com.huawei.hms.ml.scan.HmsScan;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: URIResultParser.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class u7 extends t6 {

    /* renamed from: b, reason: collision with root package name */
    private static final Pattern f31596b = Pattern.compile("(?:uri|url):([\\s\\S]*)", 2);

    /* renamed from: c, reason: collision with root package name */
    private static final Pattern f31597c = Pattern.compile("(?:http:/?(?!/)|http//)([\\s\\S]+)", 2);

    @Override // com.huawei.hms.scankit.p.t6
    public HmsScan b(s6 s6Var) {
        String a10 = t6.a(s6Var);
        if (TextUtils.isEmpty(a10) || !f31596b.matcher(a10).matches()) {
            return null;
        }
        String substring = a10.substring(4);
        Matcher matcher = f31597c.matcher(substring);
        if (matcher.matches()) {
            substring = substring.substring(0, 4) + "://" + matcher.group(1);
        }
        return new HmsScan(s6Var.k(), t6.a(s6Var.c()), t6.a(substring), HmsScan.URL_FORM, s6Var.i(), t6.a(s6Var.j()), null, new z6(new HmsScan.LinkUrl("", "")));
    }
}
