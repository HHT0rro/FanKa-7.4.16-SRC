package com.inno.innosdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.openalliance.ad.constant.u;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.UUID;

/* compiled from: Tools.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class q {

    /* renamed from: a, reason: collision with root package name */
    public static SharedPreferences f35656a;

    /* renamed from: b, reason: collision with root package name */
    public static Random f35657b;

    public static String a(Date date, String str) {
        try {
            return new SimpleDateFormat(str, Locale.US).format(date);
        } catch (Throwable th) {
            com.inno.innosdk.utils.u.a.a(th);
            return "";
        }
    }

    public static String b(Context context, String str, String str2) {
        return a(context, str, str2);
    }

    public static boolean c(Context context, String str, String str2) {
        try {
            if (f35656a == null) {
                f35656a = context.getSharedPreferences(context.getPackageName(), 0);
            }
            f35656a.edit().putString(str, str2).apply();
            return true;
        } catch (Throwable th) {
            com.inno.innosdk.utils.u.a.a(th);
            return false;
        }
    }

    public static boolean d(Context context, String str, String str2) {
        return c(context, str, str2);
    }

    public static String b(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            byte[] digest = messageDigest.digest();
            StringBuilder sb2 = new StringBuilder();
            for (byte b4 : digest) {
                int i10 = b4 & 255;
                if (i10 < 16) {
                    sb2.append(0);
                }
                sb2.append(Integer.toHexString(i10));
            }
            return sb2.toString();
        } catch (Throwable th) {
            com.inno.innosdk.utils.u.a.a(th);
            return null;
        }
    }

    public static String a() {
        return UUID.randomUUID().toString();
    }

    public static String a(Context context, String str, String str2) {
        try {
            if (f35656a == null) {
                f35656a = context.getSharedPreferences(context.getPackageName(), 0);
            }
            return f35656a.getString(str, str2);
        } catch (Throwable th) {
            com.inno.innosdk.utils.u.a.a(th);
            return str2;
        }
    }

    public static String c(String str) {
        return com.inno.innosdk.utils.t.b.a(str);
    }

    public static boolean a(Context context, String str) {
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        try {
            return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
        } catch (Throwable th) {
            com.inno.innosdk.utils.u.a.a(th);
            return false;
        }
    }

    public static String a(int i10) {
        if (f35657b == null) {
            if (Build.VERSION.SDK_INT >= 26) {
                try {
                    f35657b = SecureRandom.getInstanceStrong();
                } catch (NoSuchAlgorithmException e2) {
                    e2.printStackTrace();
                }
            }
            if (f35657b == null) {
                f35657b = new Random();
            }
        }
        StringBuilder sb2 = new StringBuilder();
        for (int i11 = 0; i11 < i10; i11++) {
            sb2.append("ABCDEFGHIJKLNMOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".charAt(f35657b.nextInt(62)));
        }
        return sb2.toString();
    }

    public static String a(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        try {
            if (bArr.length == 0) {
                return "";
            }
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            byte[] digest = messageDigest.digest();
            StringBuilder sb2 = new StringBuilder();
            for (byte b4 : digest) {
                int i10 = b4 & 255;
                if (i10 < 16) {
                    sb2.append(0);
                }
                sb2.append(Integer.toHexString(i10));
            }
            return sb2.toString();
        } catch (Throwable th) {
            com.inno.innosdk.utils.u.a.a(th);
            return null;
        }
    }

    public static String a(String str) {
        return (str == null || str.isEmpty()) ? "" : str.replaceAll(u.bD, "").toLowerCase();
    }
}
