package com.xiaomi.push;

import android.text.TextUtils;
import com.huawei.appgallery.agd.common.utils.StringUtils;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Random;
import java.util.regex.Pattern;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class p0 {
    public static String a(int i10) {
        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i11 = 0; i11 < i10; i11++) {
            stringBuffer.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".charAt(random.nextInt(62)));
        }
        return stringBuffer.toString();
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(j(str));
            return String.format("%1$032X", new BigInteger(1, messageDigest.digest()));
        } catch (NoSuchAlgorithmException unused) {
            return str;
        }
    }

    public static String c(String str, int i10) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        int length = str.length();
        if (i10 <= 0 || length < i10) {
            i10 = length / 3;
            if (i10 <= 1) {
                i10 = 1;
            }
            if (i10 > 3) {
                i10 = 3;
            }
        }
        int i11 = 0;
        while (i11 < length) {
            int i12 = i11 + 1;
            if (i12 % i10 == 0) {
                sb2.append(StringUtils.NO_PRINT_CODE);
            } else {
                sb2.append(str.charAt(i11));
            }
            i11 = i12;
        }
        return sb2.toString();
    }

    public static String d(Collection<?> collection, String str) {
        if (collection == null) {
            return null;
        }
        return e(collection.iterator2(), str);
    }

    public static String e(Iterator<?> it, String str) {
        if (it == null) {
            return null;
        }
        if (!it.hasNext()) {
            return "";
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return next.toString();
        }
        StringBuffer stringBuffer = new StringBuffer(256);
        if (next != null) {
            stringBuffer.append(next);
        }
        while (it.hasNext()) {
            if (str != null) {
                stringBuffer.append(str);
            }
            Object next2 = it.next();
            if (next2 != null) {
                stringBuffer.append(next2);
            }
        }
        return stringBuffer.toString();
    }

    public static String f(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        try {
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return new String(bArr);
        }
    }

    public static String g(Object[] objArr, String str) {
        if (objArr == null) {
            return null;
        }
        return h(objArr, str, 0, objArr.length);
    }

    public static String h(Object[] objArr, String str, int i10, int i11) {
        if (objArr == null) {
            return null;
        }
        if (str == null) {
            str = "";
        }
        int i12 = i11 - i10;
        if (i12 <= 0) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(i12 * ((objArr[i10] == null ? 16 : objArr[i10].toString().length()) + str.length()));
        for (int i13 = i10; i13 < i11; i13++) {
            if (i13 > i10) {
                stringBuffer.append(str);
            }
            if (objArr[i13] != null) {
                stringBuffer.append(objArr[i13]);
            }
        }
        return stringBuffer.toString();
    }

    public static boolean i(String str) {
        if (str == null) {
            return true;
        }
        for (int i10 = 0; i10 < str.length(); i10++) {
            char charAt = str.charAt(i10);
            if (charAt < 0 || charAt > 127) {
                return false;
            }
        }
        return true;
    }

    public static byte[] j(String str) {
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return str.getBytes();
        }
    }

    public static String k(String str) {
        if (str == null) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
            messageDigest.update(j(str));
            return String.format("%1$032X", new BigInteger(1, messageDigest.digest()));
        } catch (NoSuchAlgorithmException unused) {
            return str;
        }
    }

    public static boolean l(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.compile("^[A-Za-z0-9]+$").matcher(str).matches();
    }

    public static boolean m(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        char charAt = str.charAt(0);
        for (int i10 = 1; i10 < str.length(); i10++) {
            if (str.charAt(i10) != charAt) {
                return false;
            }
        }
        return true;
    }
}
