package com.huawei.appgallery.agd.common.utils;

import androidx.annotation.NonNull;
import com.huawei.appgallery.agd.common.CommonLog;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.IllegalFormatException;
import java.util.Locale;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class AESUtil {
    public static final String CHARSET = "UTF-8";

    public static String sha256EncryptStr(String str) {
        if (StringUtils.isBlank(str)) {
            return null;
        }
        try {
            return sha256EncryptStr(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException unused) {
            CommonLog.LOG.e("AESUtil", "can not getBytes");
            return null;
        }
    }

    public static String sha256EncryptStr(@NonNull byte[] bArr) {
        CommonLog commonLog;
        String str;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(bArr);
            StringBuilder sb2 = new StringBuilder(256);
            for (byte b4 : messageDigest.digest()) {
                sb2.append(String.format(Locale.ENGLISH, "%02X", Byte.valueOf(b4)));
            }
            return sb2.toString();
        } catch (NoSuchAlgorithmException unused) {
            commonLog = CommonLog.LOG;
            str = "sha256EncryptStr error:NoSuchAlgorithmException";
            commonLog.e("AESUtil", str);
            return null;
        } catch (IllegalFormatException unused2) {
            commonLog = CommonLog.LOG;
            str = "sha256EncryptStr error:IllegalFormatException";
            commonLog.e("AESUtil", str);
            return null;
        } catch (Exception unused3) {
            commonLog = CommonLog.LOG;
            str = "sha256EncryptStr error:Exception";
            commonLog.e("AESUtil", str);
            return null;
        }
    }
}
