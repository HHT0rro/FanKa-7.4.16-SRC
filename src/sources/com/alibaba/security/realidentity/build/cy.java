package com.alibaba.security.realidentity.build;

import android.os.Build;
import com.alibaba.security.realidentity.oss.common.utils.OSSUtils;
import com.huawei.appgallery.agd.common.constant.SymbolValues;

/* compiled from: VersionInfoUtils.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class cy {

    /* renamed from: a, reason: collision with root package name */
    private static String f3385a;

    private static String a() {
        return cb.f3255a;
    }

    public static String a(String str) {
        if (OSSUtils.a(f3385a)) {
            StringBuilder sb2 = new StringBuilder("aliyun-sdk-android/2.9.2");
            StringBuilder sb3 = new StringBuilder();
            sb3.append("(");
            sb3.append(System.getProperty("os.name"));
            sb3.append("/Android " + Build.VERSION.RELEASE);
            sb3.append("/");
            sb3.append(ct.a(Build.MODEL, "utf-8") + ";" + ct.a(Build.ID, "utf-8"));
            sb3.append(")");
            String sb4 = sb3.toString();
            cd.b("user agent : ".concat(String.valueOf(sb4)));
            if (OSSUtils.a(sb4)) {
                sb4 = System.getProperty("http.agent").replaceAll("[^\\p{ASCII}]", SymbolValues.QUESTION_EN_SYMBOL);
            }
            sb2.append(sb4);
            f3385a = sb2.toString();
        }
        if (OSSUtils.a(str)) {
            return f3385a;
        }
        return f3385a + "/" + str;
    }

    private static String b() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("(");
        sb2.append(System.getProperty("os.name"));
        sb2.append("/Android " + Build.VERSION.RELEASE);
        sb2.append("/");
        sb2.append(ct.a(Build.MODEL, "utf-8") + ";" + ct.a(Build.ID, "utf-8"));
        sb2.append(")");
        String sb3 = sb2.toString();
        cd.b("user agent : ".concat(String.valueOf(sb3)));
        return OSSUtils.a(sb3) ? System.getProperty("http.agent").replaceAll("[^\\p{ASCII}]", SymbolValues.QUESTION_EN_SYMBOL) : sb3;
    }
}
