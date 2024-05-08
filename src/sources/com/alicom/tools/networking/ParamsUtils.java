package com.alicom.tools.networking;

import android.util.Base64;
import com.google.android.material.badge.BadgeDrawable;
import com.huawei.appgallery.agd.common.utils.StringUtils;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class ParamsUtils {
    private static final String CHARSET_UTF8 = "utf-8";
    private static final String SIGN_METHOD_HMAC = "hmac";
    private static final String SIGN_METHOD_MD5 = "md5";

    private static String byte2hex(byte[] bArr) {
        StringBuilder sb2 = new StringBuilder();
        for (byte b4 : bArr) {
            String hexString = Integer.toHexString(b4 & 255);
            if (hexString.length() == 1) {
                sb2.append("0");
            }
            sb2.append(hexString.toUpperCase());
        }
        return sb2.toString();
    }

    private static byte[] encryptHMAC(String str, String str2) throws IOException {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes("utf-8"), "HmacMD5");
            Mac mac = Mac.getInstance(secretKeySpec.getAlgorithm());
            mac.init(secretKeySpec);
            return mac.doFinal(str.getBytes("utf-8"));
        } catch (GeneralSecurityException e2) {
            throw new IOException(e2.toString());
        }
    }

    private static byte[] encryptMD5(String str) throws IOException {
        return encryptMD5(str.getBytes("utf-8"));
    }

    private static byte[] encryptMD5(byte[] bArr) throws IOException {
        try {
            return MessageDigest.getInstance("MD5").digest(bArr);
        } catch (GeneralSecurityException e2) {
            throw new IOException(e2.toString());
        }
    }

    public static List<Field> getAllDeclaredFields(Class cls) {
        Class superclass;
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(Arrays.asList(cls.getDeclaredFields()));
        if (!cls.getName().equals(Request.class.getName()) && (superclass = cls.getSuperclass()) != null && !superclass.getName().equals(Object.class.getName())) {
            arrayList.addAll(getAllDeclaredFields(superclass));
        }
        return arrayList;
    }

    private static boolean isNotEmpty(String str) {
        int length;
        if (str != null && (length = str.length()) != 0) {
            for (int i10 = 0; i10 < length; i10++) {
                if (!Character.isWhitespace(str.charAt(i10))) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String sign(StringBuilder sb2, String str) {
        try {
            Mac mac = Mac.getInstance("HmacSHA1");
            mac.init(new SecretKeySpec(str.getBytes("utf-8"), "HmacSHA1"));
            return Base64.encodeToString(mac.doFinal(sb2.toString().getBytes("utf-8")), 2);
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return null;
        } catch (InvalidKeyException e10) {
            throw new IllegalArgumentException(e10.toString());
        } catch (NoSuchAlgorithmException e11) {
            throw new IllegalArgumentException(e11.toString());
        }
    }

    public static String signTopRequest(Map<String, String> map, String str, String str2) throws IOException {
        byte[] encryptMD5;
        String[] strArr = (String[]) map.h().toArray(new String[0]);
        Arrays.sort(strArr);
        StringBuilder sb2 = new StringBuilder();
        if ("md5".equals(str2)) {
            sb2.append(str);
        }
        for (String str3 : strArr) {
            String str4 = map.get(str3);
            if (isNotEmpty(str3) && isNotEmpty(str4)) {
                sb2.append(str3);
                sb2.append(str4);
            }
        }
        if (SIGN_METHOD_HMAC.equals(str2)) {
            encryptMD5 = encryptHMAC(sb2.toString(), str);
        } else {
            sb2.append(str);
            encryptMD5 = encryptMD5(sb2.toString());
        }
        return byte2hex(encryptMD5);
    }

    public static String specialUrlEncode(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8").replace(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX, "%20").replace(StringUtils.NO_PRINT_CODE, "%2A").replace("%7E", "~");
        } catch (Exception unused) {
            return "";
        }
    }
}
