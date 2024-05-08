package com.kwad.sdk.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class e {
    private static HashMap<String, ArrayList<String>> aOg = new HashMap<>();
    private static String aOh;

    @Nullable
    private static ArrayList<String> K(Context context, String str) {
        String packageName;
        if (context == null || (packageName = context.getPackageName()) == null) {
            return null;
        }
        if (aOg.get(str) != null) {
            return aOg.get(str);
        }
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            for (Signature signature : L(context, packageName)) {
                String str2 = "error!";
                if ("MD5".equals(str)) {
                    str2 = a(signature, "MD5");
                } else if ("SHA1".equals(str)) {
                    str2 = a(signature, "SHA1");
                } else if ("SHA256".equals(str)) {
                    str2 = a(signature, "SHA256");
                }
                arrayList.add(str2);
            }
        } catch (Exception e2) {
            com.kwad.sdk.core.e.c.e("AppSigningUtil", "签名信息列表获取失败 " + e2.getMessage());
        }
        aOg.put(str, arrayList);
        return arrayList;
    }

    private static Signature[] L(Context context, String str) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            if (packageInfo == null) {
                return null;
            }
            return packageInfo.signatures;
        } catch (Exception e2) {
            com.kwad.sdk.core.e.c.e("AppSigningUtil", e2.getMessage());
            return null;
        }
    }

    private static String a(Signature signature, String str) {
        byte[] byteArray = signature.toByteArray();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            if (messageDigest == null) {
                return "error!";
            }
            byte[] digest = messageDigest.digest(byteArray);
            StringBuilder sb2 = new StringBuilder();
            for (byte b4 : digest) {
                sb2.append(Integer.toHexString((b4 & 255) | 256).substring(1, 3).toUpperCase());
                sb2.append(com.huawei.openalliance.ad.constant.u.bD);
            }
            return sb2.substring(0, sb2.length() - 1);
        } catch (Exception e2) {
            com.kwad.sdk.core.e.c.e("AppSigningUtil", e2.getMessage());
            return "error!";
        }
    }

    @Nullable
    public static String bG(Context context) {
        if (!TextUtils.isEmpty(aOh)) {
            return aOh;
        }
        ArrayList<String> K = K(context, "SHA1");
        if (K != null && K.size() != 0) {
            aOh = K.get(0);
        }
        return aOh;
    }
}
