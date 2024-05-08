package com.danlan.android.cognition;

import android.content.Context;
import android.os.Build;
import android.security.KeyPairGeneratorSpec;
import android.security.keystore.KeyGenParameterSpec;
import android.text.TextUtils;
import android.util.Base64;
import com.danlan.android.cognition.common.SharedPrefStoreUtil;
import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Calendar;
import javax.crypto.Cipher;
import javax.security.auth.x500.X500Principal;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class KeyStoreEncrypt {
    private static final String TAG = StringFog.decrypt("ZE1HUVhTUHRVSkg=");
    private static KeyStoreEncrypt encryptUtilInstance;
    private Context context;
    private KeyStore keyStore;
    private final int maxExpiredTime = 1000;
    private String x500PrincipalName = StringFog.decrypt("Ym0ZblhoQVgNA2seYE1AU05KQANgVlBJTlFNV1g=");
    private int rsaEncryptBlock = 244;
    private int rsaDecryptBlock = 256;

    private KeyStoreEncrypt() {
    }

    private void createNewKeys(String str) {
        KeyPairGenerator keyPairGenerator;
        AlgorithmParameterSpec build;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if (this.keyStore.containsAlias(str)) {
                return;
            }
            if (Build.VERSION.SDK_INT < 23) {
                Calendar calendar = Calendar.getInstance();
                Calendar calendar2 = Calendar.getInstance();
                calendar2.add(1, 1000);
                build = new KeyPairGeneratorSpec.Builder(this.context).setAlias(str).setSubject(new X500Principal(this.x500PrincipalName)).setSerialNumber(BigInteger.ONE).setStartDate(calendar.getTime()).setEndDate(calendar2.getTime()).build();
                keyPairGenerator = KeyPairGenerator.getInstance(StringFog.decrypt("c3Bl"), StringFog.decrypt("YE1AUU5KQGpEWndXTlFB"));
            } else {
                keyPairGenerator = KeyPairGenerator.getInstance(StringFog.decrypt("c3Bl"), StringFog.decrypt("YE1AUU5KQGpEWndXTlFB"));
                build = new KeyGenParameterSpec.Builder(str, 2).setDigests(StringFog.decrypt("cmtlDhMWEg=="), StringFog.decrypt("cmtlDhQSFg==")).setEncryptionPaddings(StringFog.decrypt("cWhncBBzRUVFSkpE")).setUserAuthenticationRequired(false).build();
            }
            keyPairGenerator.initialize(build);
            keyPairGenerator.generateKeyPair();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static KeyStoreEncrypt getInstance() {
        if (encryptUtilInstance == null) {
            synchronized (KeyStoreEncrypt.class) {
                if (encryptUtilInstance == null) {
                    encryptUtilInstance = new KeyStoreEncrypt();
                }
            }
        }
        return encryptUtilInstance;
    }

    private void initKeyStore(String str) {
        synchronized (KeyStoreEncrypt.class) {
            try {
                if (this.keyStore == null) {
                    KeyStore keyStore = KeyStore.getInstance(StringFog.decrypt("YE1AUU5KQGpEWndXTlFB"));
                    this.keyStore = keyStore;
                    keyStore.load(null);
                }
                createNewKeys(str);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void clearKeystore(String str) {
        try {
            KeyStore keyStore = KeyStore.getInstance(StringFog.decrypt("YE1AUU5KQGpEWndXTlFB"));
            this.keyStore = keyStore;
            keyStore.load(null);
            this.keyStore.deleteEntry(str);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public String decryptString(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return "";
        }
        String str3 = "";
        synchronized (KeyStoreEncrypt.class) {
            initKeyStore(str2);
            try {
                PrivateKey privateKey = (PrivateKey) this.keyStore.getKey(str2, null);
                Cipher cipher = Cipher.getInstance(StringFog.decrypt("c3BlDGRgZg5xaGdwEHNFRUVKSkQ="));
                cipher.init(2, privateKey);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] decode = Base64.decode(str, 8);
                int length = decode.length;
                int i10 = 0;
                int i11 = 0;
                while (true) {
                    int i12 = length - i10;
                    if (i12 <= 0) {
                        break;
                    }
                    int i13 = this.rsaDecryptBlock;
                    byte[] doFinal = i12 > i13 ? cipher.doFinal(decode, i10, i13) : cipher.doFinal(decode, i10, i12);
                    byteArrayOutputStream.write(doFinal, 0, doFinal.length);
                    i11++;
                    i10 = this.rsaDecryptBlock * i11;
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                str3 = new String(byteArray, 0, byteArray.length, StringFog.decrypt("dHdiDhk="));
            } catch (Exception e2) {
                if (str2.equals(CacheDataManager.KEY_STORE_ALIAS)) {
                    SharedPrefStoreUtil.setDataToSharePref(context, StringFog.decrypt("RU1FfEJCR0lE"), StringFog.decrypt("QBI="), StringFog.decrypt("RUZCQlRPUA=="));
                }
                e2.printStackTrace();
            }
        }
        return str3;
    }

    public String encryptString(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return "";
        }
        String str3 = "";
        synchronized (KeyStoreEncrypt.class) {
            initKeyStore(str2);
            try {
                PublicKey publicKey = this.keyStore.getCertificate(str2).getPublicKey();
                Cipher cipher = Cipher.getInstance(StringFog.decrypt("c3BlDGRgZg5xaGdwEHNFRUVKSkQ="));
                cipher.init(1, publicKey);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                int length = str.length();
                byte[] bytes = str.getBytes();
                int i10 = 0;
                int i11 = 0;
                while (true) {
                    int i12 = length - i10;
                    if (i12 <= 0) {
                        break;
                    }
                    int i13 = this.rsaEncryptBlock;
                    byte[] doFinal = i12 > i13 ? cipher.doFinal(bytes, i10, i13) : cipher.doFinal(bytes, i10, i12);
                    byteArrayOutputStream.write(doFinal, 0, doFinal.length);
                    i11++;
                    i10 = this.rsaEncryptBlock * i11;
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                str3 = Base64.encodeToString(byteArray, 8);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return str3;
    }

    public void init(Context context, String str) {
        this.context = context;
        this.x500PrincipalName = str;
    }
}
