package com.huawei.hianalytics.core.crypto;

import com.huawei.hianalytics.core.log.HiLog;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class RsaCipher {

    /* renamed from: a, reason: collision with root package name */
    public static final Charset f28737a = Charset.forName("UTF-8");

    public static PublicKey a(byte[] bArr) {
        return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(bArr));
    }

    public static String encrypt(String str, String str2) {
        if (str != null && str2 != null && str2.length() != 0) {
            try {
                PublicKey a10 = a(HexUtil.hexString2ByteArray(str));
                Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-1AndMGF1Padding");
                cipher.init(1, a10);
                return HexUtil.byteArray2HexString(cipher.doFinal(str2.getBytes(f28737a)));
            } catch (InvalidKeyException unused) {
                HiLog.e("RsaCipher", "rsaEncrypt(): init - Invalid key!");
                return "";
            } catch (NoSuchAlgorithmException unused2) {
                HiLog.e("RsaCipher", "rsaEncrypt(): getInstance - No such algorithm,transformation");
                return "";
            } catch (InvalidKeySpecException unused3) {
                HiLog.e("RsaCipher", "rsaEncrypt(): InvalidKeySpecException");
                return "";
            } catch (BadPaddingException unused4) {
                HiLog.e("RsaCipher", "rsaEncrypt():False filling parameters!");
                return "";
            } catch (IllegalBlockSizeException unused5) {
                HiLog.e("RsaCipher", "rsaEncrypt(): doFinal - The provided block is not filled with");
                return "";
            } catch (NoSuchPaddingException unused6) {
                HiLog.e("RsaCipher", "rsaEncrypt():  No such filling parameters ");
                return "";
            }
        }
        HiLog.e("RsaCipher", "content or public key is null");
        return "";
    }

    public static String encryptNew(String str, String str2) {
        if (str != null && str2 != null && str2.length() != 0) {
            try {
                PublicKey a10 = a(a.a(str));
                Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
                cipher.init(1, a10);
                return HexUtil.byteArray2HexString(cipher.doFinal(str2.getBytes(f28737a)));
            } catch (RuntimeException e2) {
                e = e2;
                StringBuilder b4 = e9.a.b("rsaEncrypt(): doFinal - The provided block is not filled with, e : ");
                b4.append(e.getMessage());
                HiLog.e("RsaCipher", b4.toString());
                return "";
            } catch (InvalidKeyException unused) {
                HiLog.e("RsaCipher", "rsaEncrypt(): init - Invalid key!");
                return "";
            } catch (NoSuchAlgorithmException unused2) {
                HiLog.e("RsaCipher", "rsaEncrypt(): getInstance - No such algorithm,transformation");
                return "";
            } catch (InvalidKeySpecException unused3) {
                HiLog.e("RsaCipher", "rsaEncrypt(): InvalidKeySpecException");
                return "";
            } catch (BadPaddingException unused4) {
                HiLog.e("RsaCipher", "rsaEncrypt():False filling parameters!");
                return "";
            } catch (IllegalBlockSizeException e10) {
                e = e10;
                StringBuilder b42 = e9.a.b("rsaEncrypt(): doFinal - The provided block is not filled with, e : ");
                b42.append(e.getMessage());
                HiLog.e("RsaCipher", b42.toString());
                return "";
            } catch (NoSuchPaddingException unused5) {
                HiLog.e("RsaCipher", "rsaEncrypt():  No such filling parameters ");
                return "";
            } catch (Exception e11) {
                StringBuilder b10 = e9.a.b("decode failed, e : ");
                b10.append(e11.getMessage());
                HiLog.e("RsaCipher", b10.toString());
                return "";
            }
        }
        HiLog.e("RsaCipher", "content or public key is null");
        return "";
    }
}
