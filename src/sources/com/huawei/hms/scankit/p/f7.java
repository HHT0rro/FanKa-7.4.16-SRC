package com.huawei.hms.scankit.p;

import android.text.TextUtils;
import com.huawei.hms.ml.scan.HmsScan;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: TelPhoneNumberResultParser.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class f7 extends t6 {

    /* renamed from: b, reason: collision with root package name */
    private static final Pattern f30981b = Pattern.compile("tel:([\\s\\S]+)", 2);

    @Override // com.huawei.hms.scankit.p.t6
    public HmsScan b(s6 s6Var) {
        String a10 = t6.a(s6Var);
        if (TextUtils.isEmpty(a10)) {
            return null;
        }
        Matcher matcher = f30981b.matcher(a10);
        if (!matcher.matches()) {
            return null;
        }
        String group = matcher.group(1);
        return new HmsScan(s6Var.k(), t6.a(s6Var.c()), group, HmsScan.TEL_PHONE_NUMBER_FORM, s6Var.i(), t6.a(s6Var.j()), null, new z6(new HmsScan.TelPhoneNumber(HmsScan.TelPhoneNumber.OTHER_USE_TYPE, group)));
    }
}
