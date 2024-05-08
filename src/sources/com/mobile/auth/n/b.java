package com.mobile.auth.n;

import android.content.Context;
import android.os.Build;
import android.security.KeyPairGeneratorSpec;
import android.security.keystore.KeyGenParameterSpec;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.cloud.huiyansdkface.normal.tools.secure.AESEncrypt;
import java.math.BigInteger;
import java.security.Key;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Calendar;
import java.util.HashMap;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.security.auth.x500.X500Principal;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static byte[] f37505a;

    public static String a(Context context, String str) {
        a();
        byte[] b4 = b(context);
        if (b4 != null) {
            return a.a(b4, str, f37505a);
        }
        a();
        return null;
    }

    public static void a() {
        k.a("AES_KEY");
    }

    private static boolean a(Context context) {
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                KeyGenerator keyGenerator = KeyGenerator.getInstance(AESEncrypt.ALGORITHM, "AndroidKeyStore");
                keyGenerator.init(new KeyGenParameterSpec.Builder("CMCC_SDK_V1", 3).setDigests("SHA-256", "SHA-512").setBlockModes("CBC").setEncryptionPaddings("PKCS7Padding").setRandomizedEncryptionRequired(false).setKeySize(256).build());
                Thread.sleep(1000L);
                keyGenerator.generateKey();
                return true;
            }
            Calendar calendar = Calendar.getInstance();
            Calendar calendar2 = Calendar.getInstance();
            calendar2.add(1, 30);
            KeyPairGeneratorSpec build = new KeyPairGeneratorSpec.Builder(context).setAlias("CMCC_SDK_V1").setSubject(new X500Principal("CN=CMCC_SDK_V1")).setSerialNumber(BigInteger.TEN).setStartDate(calendar.getTime()).setEndDate(calendar2.getTime()).build();
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA", "AndroidKeyStore");
            keyPairGenerator.initialize(build);
            Thread.sleep(1000L);
            keyPairGenerator.generateKeyPair();
            return true;
        } catch (Exception e2) {
            c.a("KeystoreUtil", e2.getMessage());
            return false;
        }
    }

    public static boolean a(Context context, boolean z10) {
        try {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            keyStore.load(null);
            if (keyStore.getKey("CMCC_SDK_V1", null) != null) {
                return true;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (z10) {
            return a(context);
        }
        return false;
    }

    private static String b() {
        return k.b("AES_KEY", "");
    }

    public static String b(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        byte[] b4 = b(context);
        if (b4 != null) {
            return a.b(b4, str, f37505a);
        }
        a();
        return null;
    }

    private static synchronized byte[] b(Context context) {
        Cipher cipher;
        String str;
        String str2;
        byte[] doFinal;
        Cipher cipher2;
        synchronized (b.class) {
            try {
                KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
                keyStore.load(null);
                if (!a(context, false)) {
                    return null;
                }
                String b4 = b();
                if (TextUtils.isEmpty(b4)) {
                    doFinal = q.a();
                    f37505a = q.a();
                    Key key = keyStore.getKey("CMCC_SDK_V1", null);
                    if (key instanceof SecretKey) {
                        c.b("KeystoreUtil", "随机生成aes秘钥");
                        cipher2 = Cipher.getInstance("AES/CBC/PKCS7Padding");
                        cipher2.init(1, key, new IvParameterSpec(f37505a));
                    } else {
                        if (!(key instanceof PrivateKey)) {
                            return null;
                        }
                        PublicKey publicKey = keyStore.getCertificate("CMCC_SDK_V1").getPublicKey();
                        Cipher cipher3 = Cipher.getInstance("RSA/ECB/OAEPWithSHA256AndMGF1Padding");
                        c.b("KeystoreUtil", "生成rsa密");
                        cipher3.init(1, publicKey);
                        cipher2 = cipher3;
                    }
                    String encodeToString = Base64.encodeToString(cipher2.doFinal(doFinal), 0);
                    String encodeToString2 = Base64.encodeToString(f37505a, 0);
                    HashMap hashMap = new HashMap();
                    hashMap.put("AES_IV", encodeToString2);
                    hashMap.put("AES_KEY", encodeToString);
                    k.a(hashMap);
                } else {
                    f37505a = Base64.decode(c(), 0);
                    byte[] decode = Base64.decode(b4, 0);
                    Key key2 = keyStore.getKey("CMCC_SDK_V1", null);
                    if (key2 == null) {
                        return null;
                    }
                    if (key2 instanceof SecretKey) {
                        cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
                        cipher.init(2, key2, new IvParameterSpec(f37505a));
                        str = "KeystoreUtil";
                        str2 = "使用aes";
                    } else {
                        if (!(key2 instanceof PrivateKey)) {
                            return null;
                        }
                        cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA256AndMGF1Padding");
                        cipher.init(2, key2);
                        str = "KeystoreUtil";
                        str2 = "使用rsa";
                    }
                    c.b(str, str2);
                    doFinal = cipher.doFinal(decode);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("是否解密出秘钥：");
                    sb2.append(TextUtils.isEmpty(Base64.encodeToString(doFinal, 0)) ? false : true);
                    c.b("KeystoreUtil", sb2.toString());
                }
                return doFinal;
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
    }

    private static String c() {
        return k.b("AES_IV", "");
    }
}
