package com.alicom.tools.networking;

import com.mobile.auth.e.a;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class RSA {
    public static final String AES_ALGORITHM = "AES/ECB/PKCS5Padding";
    public static final String CHAR_ENCODING = "UTF-8";
    public static final String RSA_ALGORITHM = "RSA/ECB/PKCS1Padding";

    public static String decryptByPrivateKey(byte[] bArr, String str) throws Exception {
        PrivateKey privateKey = getPrivateKey(str);
        Cipher cipher = Cipher.getInstance(RSA_ALGORITHM);
        cipher.init(2, privateKey);
        return a.a(cipher.doFinal(bArr));
    }

    public static String encrypt(String str, String str2) throws Exception {
        PublicKey publicKey = getPublicKey(str2);
        Cipher cipher = Cipher.getInstance(RSA_ALGORITHM);
        cipher.init(1, publicKey);
        return a.a(cipher.doFinal(str.getBytes()));
    }

    public static PrivateKey getPrivateKey(String str) throws Exception {
        return KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(a.a(str)));
    }

    public static PublicKey getPublicKey(String str) throws Exception {
        return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(a.a(str)));
    }
}
