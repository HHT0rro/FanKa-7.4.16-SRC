package com.huawei.hianalytics.core.crypto;

import com.huawei.hianalytics.core.log.HiLog;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import va.b;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class HexUtil {

    /* renamed from: a, reason: collision with root package name */
    public static final char[] f28736a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static byte a(char c4) {
        return (byte) "0123456789ABCDEF".indexOf(c4);
    }

    public static String byteArray2HexString(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            StringBuilder sb2 = new StringBuilder(bArr.length * 2);
            for (byte b4 : bArr) {
                char[] cArr = f28736a;
                sb2.append(cArr[(b4 & 240) >> 4]);
                sb2.append(cArr[b4 & 15]);
            }
            return sb2.toString();
        }
        HiLog.sw("HexUtil", "byteArray is empty");
        return "";
    }

    public static byte[] hexString2ByteArray(String str) {
        if (str == null || str.length() == 0) {
            return new byte[0];
        }
        String upperCase = str.toUpperCase(Locale.ENGLISH);
        int length = upperCase.length() / 2;
        char[] charArray = upperCase.toCharArray();
        byte[] bArr = new byte[length];
        for (int i10 = 0; i10 < length; i10++) {
            int i11 = i10 * 2;
            if (i11 > -1 && i11 < charArray.length - 1) {
                bArr[i10] = (byte) (a(charArray[i11 + 1]) | (a(charArray[i11]) << 4));
            } else {
                HiLog.e("HexUtil", "char error");
            }
        }
        return bArr;
    }

    public static String initRandomKey(int i10) {
        byte[] bArr;
        try {
            bArr = b.c(i10);
        } catch (Exception e2) {
            StringBuilder b4 = e9.a.b("generate secure random error: ");
            b4.append(e2.getMessage());
            HiLog.e("HexUtil", b4.toString());
            bArr = null;
        }
        return byteArray2HexString(bArr);
    }

    public static byte[] sha256Hmac(String str, String str2) {
        byte[] bytes = str.getBytes(Charset.forName("UTF-8"));
        SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(Charset.forName("UTF-8")), "HmacSHA_256");
        try {
            Mac mac = Mac.getInstance(secretKeySpec.getAlgorithm());
            mac.init(secretKeySpec);
            return mac.doFinal(bytes);
        } catch (InvalidKeyException unused) {
            HiLog.e("HexUtil", "Exception has happened when digest2byte,From Invalid key!");
            return new byte[0];
        } catch (NoSuchAlgorithmException unused2) {
            HiLog.e("HexUtil", "When digest2byte executed Exception has happened!From Algorithm error !");
            return new byte[0];
        }
    }
}
