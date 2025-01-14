package com.amap.api.services.core;

import android.content.Context;
import com.amap.api.col.s.n;
import com.huawei.openalliance.ad.constant.u;
import java.security.MessageDigest;
import java.util.Locale;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class SearchUtils {
    public static String getPkgName(Context context) {
        try {
            return context.getApplicationContext().getPackageName();
        } catch (Throwable th) {
            n.a(th, "SearchUtils", "getPkgName");
            return null;
        }
    }

    public static String getSHA1(Context context) {
        try {
            byte[] digest = MessageDigest.getInstance("SHA1").digest(context.getApplicationContext().getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0].toByteArray());
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b4 : digest) {
                String upperCase = Integer.toHexString(b4 & 255).toUpperCase(Locale.US);
                if (upperCase.length() == 1) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(upperCase);
                stringBuffer.append(u.bD);
            }
            return stringBuffer.toString();
        } catch (Throwable th) {
            n.a(th, "SearchUtils", "getSHA1");
            return null;
        }
    }

    public static String getVersion() {
        return "9.7.0";
    }
}
