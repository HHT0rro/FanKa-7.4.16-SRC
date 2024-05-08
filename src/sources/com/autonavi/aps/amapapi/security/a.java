package com.autonavi.aps.amapapi.security;

import com.amap.api.col.p0003l.fq;
import com.amap.api.col.p0003l.fv;
import com.amap.api.col.p0003l.kz;
import com.autonavi.aps.amapapi.utils.b;
import com.tencent.cloud.huiyansdkface.normal.tools.secure.AESEncrypt;
import java.io.ObjectStreamConstants;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: Encrypt.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static final char[] f9518a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: b, reason: collision with root package name */
    private static final byte[] f9519b = {61, 61, 81, 65, 65, 69, ObjectStreamConstants.TC_BLOCKDATA, 65, 67, 48, 74, 80, ObjectStreamConstants.TC_OBJECT, ObjectStreamConstants.TC_STRING, 54, 75, 104, 76, ObjectStreamConstants.TC_BLOCKDATALONG, 97, 88, 99, 53, 71, 49, ObjectStreamConstants.TC_BLOCKDATALONG, 68, 70, 79, 104, ObjectStreamConstants.TC_REFERENCE, ObjectStreamConstants.TC_REFERENCE, 65, 97, 76, 54, 65, 66, 87, 53, 103, 85, 84, ObjectStreamConstants.TC_REFERENCE, 71, 68, 69, 76, 80, 82, 106, 51, 66, 75, 75, 69, 98, 55, 84, 108, ObjectStreamConstants.TC_OBJECT, ObjectStreamConstants.TC_BLOCKDATALONG, 51, 106, 76, 55, 88, ObjectStreamConstants.TC_BLOCKDATALONG, 70, ObjectStreamConstants.TC_RESET, 73, 75, 52, 50, 43, 101, 70, ObjectStreamConstants.TC_RESET, 56, 105, ObjectStreamConstants.TC_OBJECT, 105, 89, ObjectStreamConstants.TC_ENDBLOCKDATA, ObjectStreamConstants.TC_ARRAY, 112, 53, 48, 76, 81, 70, 86, 108, 110, 73, 65, 66, 74, 65, 83, ObjectStreamConstants.TC_BLOCKDATA, 65, ObjectStreamConstants.TC_BLOCKDATA, 83, 68, 65, 81, 66, 66, 69, 81, 65, 78, 99, ObjectStreamConstants.TC_CLASS, 104, 73, 90, 111, 75, 74, 89, 81, 68, ObjectStreamConstants.TC_BLOCKDATA, ObjectStreamConstants.TC_BLOCKDATA, 70, 77};

    /* renamed from: c, reason: collision with root package name */
    private static final byte[] f9520c;

    /* renamed from: d, reason: collision with root package name */
    private static final IvParameterSpec f9521d;

    static {
        byte[] bArr = {0, 1, 1, 2, 3, 5, 8, 13, 8, 7, 6, 5, 4, 3, 2, 1};
        f9520c = bArr;
        f9521d = new IvParameterSpec(bArr);
    }

    public static byte[] a(byte[] bArr) throws Exception {
        PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(kz.a(new StringBuilder(new String(f9519b)).reverse().toString().getBytes())));
        Cipher cipher = Cipher.getInstance(fv.c("WUlNBL0VDQi9PQUVQV0lUSFNIQS0xQU5ETUdGMVBBRERJTkc"));
        cipher.init(1, generatePublic);
        return cipher.doFinal(bArr);
    }

    public static byte[] b(byte[] bArr, String str) {
        try {
            SecretKeySpec b4 = b(str);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(a());
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, b4, ivParameterSpec);
            return cipher.doFinal(bArr);
        } catch (Throwable th) {
            b.a(th, "Encrypt", "aesDecrypt");
            return null;
        }
    }

    private static String c(byte[] bArr) {
        int length = bArr.length;
        StringBuilder sb2 = new StringBuilder(length * 2);
        for (int i10 = 0; i10 < length; i10++) {
            char[] cArr = f9518a;
            sb2.append(cArr[(bArr[i10] >> 4) & 15]);
            sb2.append(cArr[bArr[i10] & 15]);
        }
        return sb2.toString();
    }

    private static SecretKeySpec b(String str) {
        byte[] bArr;
        if (str == null) {
            str = "";
        }
        StringBuffer stringBuffer = new StringBuffer(16);
        stringBuffer.append(str);
        while (stringBuffer.length() < 16) {
            stringBuffer.append("0");
        }
        if (stringBuffer.length() > 16) {
            stringBuffer.setLength(16);
        }
        try {
            bArr = stringBuffer.toString().getBytes("UTF-8");
        } catch (Throwable th) {
            b.a(th, "Encrypt", "createKey");
            bArr = null;
        }
        return new SecretKeySpec(bArr, AESEncrypt.ALGORITHM);
    }

    public static byte[] a(byte[] bArr, String str) {
        try {
            SecretKeySpec b4 = b(str);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(a());
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(1, b4, ivParameterSpec);
            return cipher.doFinal(bArr);
        } catch (Throwable th) {
            b.a(th, "Encrypt", "aesEncrypt");
            return null;
        }
    }

    public static String a(String str) {
        if (str != null) {
            try {
                if (str.length() != 0) {
                    return a("MD5", a("SHA1", str) + str);
                }
            } catch (Throwable th) {
                b.a(th, "Encrypt", "generatorKey");
            }
        }
        return null;
    }

    public static byte[] b(byte[] bArr) {
        try {
            byte[] bArr2 = new byte[16];
            byte[] bArr3 = new byte[bArr.length - 16];
            System.arraycopy((Object) bArr, 0, (Object) bArr2, 0, 16);
            System.arraycopy((Object) bArr, 16, (Object) bArr3, 0, bArr.length - 16);
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, AESEncrypt.ALGORITHM);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, secretKeySpec, new IvParameterSpec(fv.c()));
            return cipher.doFinal(bArr3);
        } catch (Throwable th) {
            b.a(th, "Encrypt", "decryptRsponse length = ".concat(String.valueOf(bArr != null ? bArr.length : 0)));
            return null;
        }
    }

    public static String a(String str, String str2) {
        if (str2 == null) {
            return null;
        }
        try {
            return c(fq.a(str2.getBytes("UTF-8"), str));
        } catch (Throwable th) {
            b.a(th, "Encrypt", "encode");
            return null;
        }
    }

    private static byte[] a() {
        return fv.c();
    }
}
