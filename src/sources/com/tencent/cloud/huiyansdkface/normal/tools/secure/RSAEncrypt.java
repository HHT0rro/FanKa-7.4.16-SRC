package com.tencent.cloud.huiyansdkface.normal.tools.secure;

import android.util.Base64;
import com.alicom.tools.networking.RSA;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import org.apache.commons.lang3.CharUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class RSAEncrypt {
    private static final char[] HEX_CHAR = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private RSAPrivateKey privateKey;
    private RSAPublicKey publicKey;

    public static String byteArray2HexString(byte[] bArr) {
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < bArr.length; i10++) {
            char[] cArr = HEX_CHAR;
            sb2.append(cArr[(bArr[i10] & 240) >>> 4]);
            sb2.append(cArr[bArr[i10] & 15]);
        }
        return sb2.toString().toUpperCase();
    }

    public byte[] decrypt(byte[] bArr) throws Exception {
        if (this.privateKey == null) {
            throw new Exception("解密私钥为空, 请设置");
        }
        try {
            Cipher cipher = Cipher.getInstance(RSA.RSA_ALGORITHM);
            cipher.init(2, this.privateKey);
            return cipher.doFinal(bArr);
        } catch (InvalidKeyException e2) {
            throw new RuntimeException(e2);
        } catch (NoSuchAlgorithmException e10) {
            throw new RuntimeException(e10);
        } catch (BadPaddingException e11) {
            throw new RuntimeException(e11);
        } catch (IllegalBlockSizeException e12) {
            throw new RuntimeException(e12);
        } catch (NoSuchPaddingException e13) {
            throw new RuntimeException(e13);
        }
    }

    public byte[] encrypt(byte[] bArr) throws Exception {
        if (this.publicKey == null) {
            throw new Exception("加密公钥为空, 请设置");
        }
        try {
            Cipher cipher = Cipher.getInstance(RSA.RSA_ALGORITHM);
            cipher.init(1, this.publicKey);
            return cipher.doFinal(bArr);
        } catch (InvalidKeyException e2) {
            throw new RuntimeException(e2);
        } catch (NoSuchAlgorithmException e10) {
            throw new RuntimeException(e10);
        } catch (BadPaddingException e11) {
            throw new RuntimeException(e11);
        } catch (IllegalBlockSizeException e12) {
            throw new RuntimeException(e12);
        } catch (NoSuchPaddingException e13) {
            throw new RuntimeException(e13);
        }
    }

    public void genKeyPair() {
        KeyPairGenerator keyPairGenerator;
        try {
            keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            keyPairGenerator = null;
        }
        keyPairGenerator.initialize(2048, new SecureRandom());
        KeyPair generateKeyPair = keyPairGenerator.generateKeyPair();
        this.privateKey = (RSAPrivateKey) generateKeyPair.getPrivate();
        this.publicKey = (RSAPublicKey) generateKeyPair.getPublic();
    }

    public RSAPrivateKey getPrivateKey() {
        return this.privateKey;
    }

    public RSAPublicKey getPublicKey() {
        return this.publicKey;
    }

    public void loadPrivateKey(InputStream inputStream) throws Exception {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder sb2 = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    loadPrivateKey(sb2.toString());
                    return;
                } else if (readLine.charAt(0) != '-') {
                    sb2.append(readLine);
                }
            }
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        } catch (NullPointerException e10) {
            throw new RuntimeException(e10);
        }
    }

    public void loadPrivateKey(String str) throws Exception {
        try {
            this.privateKey = (RSAPrivateKey) KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(Base64.decode(str, 0)));
        } catch (NullPointerException e2) {
            throw new RuntimeException(e2);
        } catch (NoSuchAlgorithmException e10) {
            throw new RuntimeException(e10);
        } catch (InvalidKeySpecException e11) {
            throw new RuntimeException(e11);
        }
    }

    public void loadPublicKey(InputStream inputStream) throws Exception {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder sb2 = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    loadPublicKey(sb2.toString());
                    return;
                } else if (readLine.charAt(0) != '-') {
                    sb2.append(readLine);
                    sb2.append(CharUtils.CR);
                }
            }
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        } catch (NullPointerException e10) {
            throw new RuntimeException(e10);
        }
    }

    public void loadPublicKey(String str) throws Exception {
        try {
            this.publicKey = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
        } catch (NullPointerException e2) {
            throw new RuntimeException(e2);
        } catch (NoSuchAlgorithmException e10) {
            throw new RuntimeException(e10);
        } catch (InvalidKeySpecException e11) {
            throw new RuntimeException(e11);
        }
    }

    public void loadPublicKey(byte[] bArr) throws Exception {
        try {
            this.publicKey = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(bArr));
        } catch (NullPointerException e2) {
            throw new RuntimeException(e2);
        } catch (NoSuchAlgorithmException e10) {
            throw new RuntimeException(e10);
        } catch (InvalidKeySpecException e11) {
            throw new RuntimeException(e11);
        }
    }
}
