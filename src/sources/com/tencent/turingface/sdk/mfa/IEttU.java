package com.tencent.turingface.sdk.mfa;

import android.text.TextUtils;
import com.huawei.openalliance.ad.constant.u;
import java.util.Iterator;
import java.util.Locale;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class IEttU {

    /* renamed from: a, reason: collision with root package name */
    public String f45604a;

    /* renamed from: b, reason: collision with root package name */
    public int f45605b;

    /* renamed from: c, reason: collision with root package name */
    public OCkqn f45606c;

    public IEttU(String str, int i10, OCkqn oCkqn) {
        this.f45604a = str;
        this.f45605b = i10;
        this.f45606c = oCkqn;
    }

    public static String a(String str, String str2, String str3) {
        return !TextUtils.isEmpty(str3) ? str3.replace(str, str2) : str3;
    }

    public final String a() {
        StringBuilder sb2 = new StringBuilder();
        String str = this.f45604a;
        if (str == null) {
            str = "";
        }
        sb2.append(a("&", "%0A", a(",", "%54", a("_", "%5F", a(";", "%3B", a(u.bD, "%3A", str))))));
        sb2.append("_");
        sb2.append(this.f45605b);
        sb2.append("_");
        OCkqn oCkqn = this.f45606c;
        if (oCkqn == null) {
            return sb2.toString();
        }
        sb2.append(oCkqn.f45643b);
        sb2.append(u.bD);
        sb2.append(this.f45606c.f45644c);
        sb2.append(u.bD);
        Iterator<XnM3A> iterator2 = this.f45606c.f45645d.iterator2();
        while (iterator2.hasNext()) {
            XnM3A next = iterator2.next();
            sb2.append(next.f45722a);
            sb2.append(",");
            sb2.append(",");
            sb2.append(",");
            String format = String.format(Locale.SIMPLIFIED_CHINESE, "%.5f", Float.valueOf(next.f45725d));
            if (format.indexOf(".") > 0) {
                format = format.replaceAll("0+?$", "").replaceAll("[.]$", "");
            }
            sb2.append(format);
            sb2.append(",");
            String format2 = String.format(Locale.SIMPLIFIED_CHINESE, "%.5f", Float.valueOf(next.f45726e));
            if (format2.indexOf(".") > 0) {
                format2 = format2.replaceAll("0+?$", "").replaceAll("[.]$", "");
            }
            sb2.append(format2);
            if (iterator2.hasNext()) {
                sb2.append(";");
            }
        }
        sb2.append(u.bD);
        sb2.append(this.f45606c.f45646e);
        return sb2.toString();
    }
}
