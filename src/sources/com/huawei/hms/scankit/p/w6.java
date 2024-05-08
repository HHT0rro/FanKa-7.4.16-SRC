package com.huawei.hms.scankit.p;

import android.text.TextUtils;
import com.huawei.hms.ml.scan.HmsScan;
import java.util.regex.Pattern;

/* compiled from: SMSTOMMSTOResultParser.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class w6 extends t6 {

    /* renamed from: b, reason: collision with root package name */
    private static final Pattern f31707b = Pattern.compile("(?:mmsto|smsto):([\\s\\S]+)", 2);

    @Override // com.huawei.hms.scankit.p.t6
    public HmsScan b(s6 s6Var) {
        String str;
        String str2;
        String str3;
        String a10 = t6.a(s6Var);
        if (TextUtils.isEmpty(a10) || !f31707b.matcher(a10).matches()) {
            return null;
        }
        String substring = a10.substring(6);
        int indexOf = substring.indexOf(58);
        if (indexOf >= 0) {
            str = substring.substring(0, indexOf);
            str2 = substring.substring(indexOf + 1);
        } else {
            str = substring;
            str2 = "";
        }
        if (str2.isEmpty()) {
            str3 = str;
        } else {
            str3 = str + "\n" + str2;
        }
        return new HmsScan(s6Var.k(), t6.a(s6Var.c()), str3, HmsScan.SMS_FORM, s6Var.i(), t6.a(s6Var.j()), null, new z6(new HmsScan.SmsContent(str2, str)));
    }
}
