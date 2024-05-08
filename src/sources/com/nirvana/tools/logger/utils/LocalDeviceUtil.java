package com.nirvana.tools.logger.utils;

import android.content.Context;
import android.text.TextUtils;
import com.nirvana.tools.core.EncryptUtils;
import java.security.MessageDigest;
import java.util.UUID;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class LocalDeviceUtil {
    public static final String AUTH_DEVICEID_FILE = "AUTH_DEVICEINFO";
    public static final String AUTH_DEVICEID_UUID = "AUTH_DEVICEID_UUID";
    public static final String AUTH_UMAAID_UUID = "AUTH_UMAAID_UUID";
    private static final String IV_PASS = "0000000000000000";
    private static String mDeviceId = "";

    private static String MD5(String str) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            byte[] bytes = str.getBytes();
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bytes);
            byte[] digest = messageDigest.digest();
            char[] cArr2 = new char[digest.length << 1];
            int i10 = 0;
            for (byte b4 : digest) {
                int i11 = i10 + 1;
                cArr2[i10] = cArr[(b4 >>> 4) & 15];
                i10 = i11 + 1;
                cArr2[i11] = cArr[b4 & 15];
            }
            return new String(cArr2);
        } catch (Exception unused) {
            return null;
        }
    }

    private static String createDeviceId(Context context) {
        try {
            String uuid = UUID.randomUUID().toString();
            return TextUtils.isEmpty(uuid) ? "default" : EncryptUtils.encrypt(uuid + "default", "0000000000000000");
        } catch (Throwable th) {
            th.printStackTrace();
            return "default";
        }
    }

    private static String createUmaaId(Context context) {
        try {
            String uuid = UUID.randomUUID().toString();
            return TextUtils.isEmpty(uuid) ? "default" : EncryptUtils.encrypt(uuid + "default", "0000000000000000");
        } catch (Throwable th) {
            th.printStackTrace();
            return "default";
        }
    }

    public static String getDeviceId(Context context) {
        if (TextUtils.isEmpty(mDeviceId)) {
            String saveDeviceId = getSaveDeviceId(context);
            mDeviceId = saveDeviceId;
            if (TextUtils.isEmpty(saveDeviceId)) {
                String createDeviceId = createDeviceId(context);
                mDeviceId = createDeviceId;
                saveDeviceId(context, createDeviceId);
            }
        }
        return mDeviceId;
    }

    private static String getSaveDeviceId(Context context) {
        return (String) UTSharedPreferencesHelper.get(context, AUTH_DEVICEID_FILE, AUTH_DEVICEID_UUID, "");
    }

    private static String getSaveUmaaId(Context context) {
        return (String) UTSharedPreferencesHelper.get(context, AUTH_DEVICEID_FILE, AUTH_UMAAID_UUID, "");
    }

    public static String getUmaaId(Context context) {
        if (TextUtils.isEmpty(mDeviceId)) {
            String saveUmaaId = getSaveUmaaId(context);
            mDeviceId = saveUmaaId;
            if (TextUtils.isEmpty(saveUmaaId)) {
                String createUmaaId = createUmaaId(context);
                mDeviceId = createUmaaId;
                saveUmaaId(context, createUmaaId);
            }
        }
        return mDeviceId;
    }

    private static void saveDeviceId(Context context, String str) {
        if (TextUtils.isEmpty(str) || context == null) {
            return;
        }
        UTSharedPreferencesHelper.put(context, AUTH_DEVICEID_FILE, AUTH_DEVICEID_UUID, str);
    }

    private static void saveUmaaId(Context context, String str) {
        if (TextUtils.isEmpty(str) || context == null) {
            return;
        }
        UTSharedPreferencesHelper.put(context, AUTH_DEVICEID_FILE, AUTH_UMAAID_UUID, str);
    }
}
