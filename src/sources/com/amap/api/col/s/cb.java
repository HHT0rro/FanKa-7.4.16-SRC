package com.amap.api.col.s;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import java.util.Locale;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import okio.Utf8;
import org.apache.commons.io.IOUtils;

/* compiled from: Encrypt.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class cb {

    /* renamed from: a, reason: collision with root package name */
    private static final char[] f7449a = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', Locale.PRIVATE_USE_EXTENSION, 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', IOUtils.DIR_SEPARATOR_UNIX};

    /* renamed from: b, reason: collision with root package name */
    private static final byte[] f7450b = new byte[128];

    static {
        for (int i10 = 0; i10 < 128; i10++) {
            f7450b[i10] = -1;
        }
        for (int i11 = 65; i11 <= 90; i11++) {
            f7450b[i11] = (byte) (i11 - 65);
        }
        for (int i12 = 97; i12 <= 122; i12++) {
            f7450b[i12] = (byte) ((i12 - 97) + 26);
        }
        for (int i13 = 48; i13 <= 57; i13++) {
            f7450b[i13] = (byte) ((i13 - 48) + 52);
        }
        byte[] bArr = f7450b;
        bArr[43] = 62;
        bArr[47] = Utf8.REPLACEMENT_BYTE;
    }

    public static byte[] a(byte[] bArr) throws CertificateException, InvalidKeySpecException, NoSuchAlgorithmException, NullPointerException, IOException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(ci.c("EQUVT"));
        if (keyGenerator == null) {
            return null;
        }
        keyGenerator.init(256);
        byte[] encoded = keyGenerator.generateKey().getEncoded();
        PublicKey d10 = ci.d();
        if (d10 == null) {
            return null;
        }
        byte[] a10 = a(encoded, d10);
        byte[] a11 = a(encoded, bArr);
        byte[] bArr2 = new byte[a10.length + a11.length];
        System.arraycopy((Object) a10, 0, (Object) bArr2, 0, a10.length);
        System.arraycopy((Object) a11, 0, (Object) bArr2, a10.length, a11.length);
        return bArr2;
    }

    public static String b(byte[] bArr) {
        try {
            return d(bArr);
        } catch (Throwable th) {
            dc.a(th, "er", "e64");
            return null;
        }
    }

    public static String c(byte[] bArr) {
        try {
            return d(bArr);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private static String d(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        int length = bArr.length;
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                break;
            }
            int i11 = i10 + 1;
            int i12 = bArr[i10] & 255;
            if (i11 == length) {
                char[] cArr = f7449a;
                stringBuffer.append(cArr[i12 >>> 2]);
                stringBuffer.append(cArr[(i12 & 3) << 4]);
                stringBuffer.append("==");
                break;
            }
            int i13 = i11 + 1;
            int i14 = bArr[i11] & 255;
            if (i13 == length) {
                char[] cArr2 = f7449a;
                stringBuffer.append(cArr2[i12 >>> 2]);
                stringBuffer.append(cArr2[((i12 & 3) << 4) | ((i14 & 240) >>> 4)]);
                stringBuffer.append(cArr2[(i14 & 15) << 2]);
                stringBuffer.append("=");
                break;
            }
            int i15 = i13 + 1;
            int i16 = bArr[i13] & 255;
            char[] cArr3 = f7449a;
            stringBuffer.append(cArr3[i12 >>> 2]);
            stringBuffer.append(cArr3[((i12 & 3) << 4) | ((i14 & 240) >>> 4)]);
            stringBuffer.append(cArr3[((i14 & 15) << 2) | ((i16 & 192) >>> 6)]);
            stringBuffer.append(cArr3[i16 & 63]);
            i10 = i15;
        }
        return stringBuffer.toString();
    }

    public static byte[] b(byte[] bArr, byte[] bArr2, byte[] bArr3) throws IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {
        return c(bArr, bArr2, bArr3);
    }

    private static byte[] c(byte[] bArr, byte[] bArr2, byte[] bArr3) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr3);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, ci.c("EQUVT"));
        Cipher cipher = Cipher.getInstance(ci.c("CQUVTL0NCQy9QS0NTNVBhZGRpbmc"));
        try {
            cipher.init(1, secretKeySpec, ivParameterSpec);
        } catch (InvalidAlgorithmParameterException e2) {
            e2.printStackTrace();
        }
        return cipher.doFinal(bArr2);
    }

    public static byte[] b(String str) {
        int i10;
        byte b4;
        int i11;
        byte b10;
        int i12 = 0;
        if (str == null) {
            return new byte[0];
        }
        byte[] a10 = ci.a(str);
        int length = a10.length;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(length);
        while (i12 < length) {
            while (true) {
                i10 = i12 + 1;
                b4 = f7450b[a10[i12]];
                if (i10 >= length || b4 != -1) {
                    break;
                }
                i12 = i10;
            }
            if (b4 == -1) {
                break;
            }
            while (true) {
                i11 = i10 + 1;
                b10 = f7450b[a10[i10]];
                if (i11 >= length || b10 != -1) {
                    break;
                }
                i10 = i11;
            }
            if (b10 == -1) {
                break;
            }
            byteArrayOutputStream.write((b4 << 2) | ((b10 & 48) >>> 4));
            while (i11 != length) {
                int i13 = i11 + 1;
                byte b11 = a10[i11];
                if (b11 == 61) {
                    return byteArrayOutputStream.toByteArray();
                }
                byte b12 = f7450b[b11];
                if (i13 >= length || b12 != -1) {
                    if (b12 == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(((b10 & 15) << 4) | ((b12 & 60) >>> 2));
                    while (i13 != length) {
                        int i14 = i13 + 1;
                        byte b13 = a10[i13];
                        if (b13 == 61) {
                            return byteArrayOutputStream.toByteArray();
                        }
                        byte b14 = f7450b[b13];
                        if (i14 < length && b14 == -1) {
                            i13 = i14;
                        } else {
                            if (b14 == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(b14 | ((b12 & 3) << 6));
                            i12 = i14;
                        }
                    }
                    return byteArrayOutputStream.toByteArray();
                }
                i11 = i13;
            }
            return byteArrayOutputStream.toByteArray();
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static String a(String str) {
        return ci.a(b(str));
    }

    public static byte[] a(byte[] bArr, Key key) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Cipher cipher = Cipher.getInstance(ci.c("CUlNBL0VDQi9QS0NTMVBhZGRpbmc"));
        cipher.init(1, key);
        return cipher.doFinal(bArr);
    }

    private static byte[] a(byte[] bArr, byte[] bArr2) {
        try {
            return c(bArr, bArr2, ci.c());
        } catch (Throwable th) {
            dc.a(th, "er", "asEn");
            return null;
        }
    }

    public static byte[] a(byte[] bArr, byte[] bArr2, byte[] bArr3) throws Exception {
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr3);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, ci.c("EQUVT"));
        Cipher cipher = Cipher.getInstance(ci.c("CQUVTL0NCQy9QS0NTNVBhZGRpbmc"));
        cipher.init(2, secretKeySpec, ivParameterSpec);
        return cipher.doFinal(bArr2);
    }
}
