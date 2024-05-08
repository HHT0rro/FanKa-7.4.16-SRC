package com.tencent.liteav.sdk.common;

import android.util.Base64;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.Log;
import com.tencent.liteav.base.annotations.CalledByNative;
import com.tencent.liteav.base.annotations.JNINamespace;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

@JNINamespace("liteav::license")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class LicenseCheckerPlatformAndroid {
    private static final String ALGORITHM_AES = "AES";
    private static final String ALGORITHM_AES_CBC_PKCS5PADDING = "AES/CBC/PKCS5Padding";
    private static final String ALGORITHM_RSA = "RSA";
    private static final String ALGORITHM_SHA256WITH_RSA = "SHA256WithRSA";
    private static final String TAG = "LicenseCheckerPlatformAndroid";

    @CalledByNative
    public static String decryptLicense(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr != null && bArr.length != 0 && bArr2 != null && bArr2.length != 0 && bArr3 != null && bArr3.length != 0) {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
            IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr3);
            try {
                Cipher cipher = Cipher.getInstance(ALGORITHM_AES_CBC_PKCS5PADDING);
                cipher.init(2, secretKeySpec, ivParameterSpec);
                return new String(cipher.doFinal(Base64.decode(bArr, 0)));
            } catch (Exception e2) {
                e2.printStackTrace();
                return "";
            }
        }
        Log.w(TAG, "decryptLicense: invalid parameter.", new Object[0]);
        return "";
    }

    @CalledByNative
    public static String getPackageFile(String str) {
        InputStream inputStream = null;
        try {
            try {
                inputStream = ContextUtils.getApplicationContext().getAssets().open(str);
                byte[] bArr = new byte[inputStream.available()];
                if (inputStream.read(bArr) <= 0) {
                    try {
                        inputStream.close();
                    } catch (IOException unused) {
                    }
                    return "";
                }
                inputStream.close();
                String str2 = new String(bArr);
                try {
                    inputStream.close();
                } catch (IOException unused2) {
                }
                return str2;
            } catch (IOException e2) {
                Log.w(TAG, "read asset file failed.", e2);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused3) {
                    }
                }
                return "";
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused4) {
                }
            }
            throw th;
        }
    }

    @CalledByNative
    public static boolean verifyLicense(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr != null && bArr.length != 0 && bArr2 != null && bArr2.length != 0 && bArr3 != null && bArr3.length != 0) {
            try {
                PublicKey generatePublic = KeyFactory.getInstance(ALGORITHM_RSA).generatePublic(new X509EncodedKeySpec(Base64.decode(bArr3, 0)));
                Signature signature = Signature.getInstance(ALGORITHM_SHA256WITH_RSA);
                signature.initVerify(generatePublic);
                signature.update(Base64.decode(bArr, 0));
                return signature.verify(Base64.decode(bArr2, 0));
            } catch (InvalidKeyException | NoSuchAlgorithmException | SignatureException | InvalidKeySpecException e2) {
                e2.printStackTrace();
                return false;
            }
        }
        Log.w(TAG, "verifyLicense: invalid parameter.", new Object[0]);
        return false;
    }
}
