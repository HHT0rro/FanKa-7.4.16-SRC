package com.mobile.auth.b;

import com.mobile.auth.gatewayauth.ExceptionProcessor;
import com.tencent.cloud.huiyansdkface.normal.tools.secure.AESEncrypt;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final String f36672a = "a";

    /* renamed from: b, reason: collision with root package name */
    private static byte[] f36673b = "0000000000000000".getBytes();

    /* renamed from: c, reason: collision with root package name */
    private static byte[] f36674c = "vrf5g7h0tededwx3".getBytes();

    public static String a(String str, String str2) {
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(f36673b);
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), AESEncrypt.ALGORITHM);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            byte[] bytes = str.getBytes("utf-8");
            cipher.init(1, secretKeySpec, ivParameterSpec);
            return e.a(cipher.doFinal(bytes));
        } catch (Throwable th) {
            try {
                com.mobile.auth.a.a.a(f36672a, "encryptAesNew error", th);
                return null;
            } catch (Throwable th2) {
                try {
                    ExceptionProcessor.processException(th2);
                    return null;
                } catch (Throwable th3) {
                    ExceptionProcessor.processException(th3);
                    return null;
                }
            }
        }
    }

    public static byte[] b(String str, String str2) {
        try {
            byte[] bytes = str.getBytes("utf-8");
            int length = bytes.length;
            while (length % 16 != 0) {
                length++;
            }
            byte[] bArr = new byte[length];
            for (int i10 = 0; i10 < length; i10++) {
                if (i10 < bytes.length) {
                    bArr[i10] = bytes[i10];
                } else {
                    bArr[i10] = 0;
                }
            }
            IvParameterSpec ivParameterSpec = new IvParameterSpec(f36674c);
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), AESEncrypt.ALGORITHM);
            Cipher cipher = Cipher.getInstance(com.kuaishou.weapon.p0.b.f35814a);
            cipher.init(1, secretKeySpec, ivParameterSpec);
            return cipher.doFinal(bArr);
        } catch (Throwable th) {
            try {
                com.mobile.auth.a.a.a(f36672a, "encrypt4Ux error", th);
                return null;
            } catch (Throwable th2) {
                try {
                    ExceptionProcessor.processException(th2);
                    return null;
                } catch (Throwable th3) {
                    ExceptionProcessor.processException(th3);
                    return null;
                }
            }
        }
    }

    public static String c(String str, String str2) {
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(f36673b);
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), AESEncrypt.ALGORITHM);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, secretKeySpec, ivParameterSpec);
            byte[] doFinal = cipher.doFinal(e.a(str));
            if (doFinal != null) {
                return new String(doFinal);
            }
            com.mobile.auth.a.a.a(f36672a, "Aes decrypt result is empty");
            return "";
        } catch (Throwable th) {
            try {
                com.mobile.auth.a.a.a(f36672a, "decryptAesNew error", th);
                return "";
            } catch (Throwable th2) {
                try {
                    ExceptionProcessor.processException(th2);
                    return null;
                } catch (Throwable th3) {
                    ExceptionProcessor.processException(th3);
                    return null;
                }
            }
        }
    }
}
