package com.danlan.android.cognition;

import android.content.Context;
import android.text.TextUtils;
import com.danlan.android.cognition.collector.util.SafeJSONObject;
import com.danlan.android.cognition.common.FileStoreUtil;
import com.danlan.android.cognition.common.HashUtil;
import com.danlan.android.cognition.common.SharedPrefStoreUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class CacheDataManager {
    public static final String SP_CACHE_FILENAME = StringFog.decrypt("RU1FfEJCR0lE");
    public static final String SP_CACHE_FLAG = StringFog.decrypt("QkJHS0R8Qk1ARA==");
    private static final String SP_ID_KEY = StringFog.decrypt("RU1F");
    public static final String DEFAULT_VALUE = StringFog.decrypt("RUZCQlRPUA==");
    private static String cache_deviceID = "";
    public static String KEY_STORE_ALIAS = StringFog.decrypt("Q0dvRlg=");

    public static int checkCacheAndroidID(Context context, SafeJSONObject safeJSONObject) {
        try {
            String dataFromSharePref = FileStoreUtil.getDataFromSharePref(context, SP_CACHE_FILENAME, StringFog.decrypt("QE1N"));
            if (!TextUtils.isEmpty(dataFromSharePref)) {
                String string = safeJSONObject.getJSONObject(StringFog.decrypt("UlpXV0RO")).getString(StringFog.decrypt("QE1AUU5KQH5IRw=="));
                if (!TextUtils.isEmpty(string)) {
                    return HashUtil.md5(string.getBytes()).equals(dataFromSharePref) ? 1 : 0;
                }
            }
        } catch (Exception unused) {
        }
        return -1;
    }

    public static int checkCacheAndroidTime(Context context, SafeJSONObject safeJSONObject) {
        try {
            String dataFromSharePref = FileStoreUtil.getDataFromSharePref(context, SP_CACHE_FILENAME, StringFog.decrypt("QE1H"));
            if (!TextUtils.isEmpty(dataFromSharePref)) {
                String string = safeJSONObject.getJSONObject(StringFog.decrypt("TEZJTFNa")).getString(StringFog.decrypt("QE1AUU5KQH5CV01ORA=="));
                if (!TextUtils.isEmpty(string)) {
                    return HashUtil.md5(string.getBytes()).equals(dataFromSharePref) ? 1 : 0;
                }
            }
        } catch (Exception unused) {
        }
        return -1;
    }

    public static boolean checkCacheData(Context context, SafeJSONObject safeJSONObject) {
        return checkCacheFirstInstallTime(context, safeJSONObject) == 1 || checkCacheAndroidID(context, safeJSONObject) == 1 || checkCacheAndroidTime(context, safeJSONObject) == 1 || checkCacheSdcardTime(context, safeJSONObject) == 1 || checkCacheDicmTime(context, safeJSONObject) != 0;
    }

    public static int checkCacheDicmTime(Context context, SafeJSONObject safeJSONObject) {
        try {
            String dataFromSharePref = FileStoreUtil.getDataFromSharePref(context, SP_CACHE_FILENAME, StringFog.decrypt("RUpH"));
            if (!TextUtils.isEmpty(dataFromSharePref)) {
                String string = safeJSONObject.getJSONObject(StringFog.decrypt("TEZJTFNa")).getString(StringFog.decrypt("RUpHTn5AUEhMRg=="));
                if (!TextUtils.isEmpty(string)) {
                    return HashUtil.md5(string.getBytes()).equals(dataFromSharePref) ? 1 : 0;
                }
            }
        } catch (Exception unused) {
        }
        return -1;
    }

    public static int checkCacheFirstInstallTime(Context context, SafeJSONObject safeJSONObject) {
        try {
            return HashUtil.md5(String.valueOf(safeJSONObject.getJSONObject(StringFog.decrypt("QFNUT0hARVVITEo=")).getInt(StringFog.decrypt("R0pWUFVqSlJVQkhPdUpJRA=="))).getBytes()).equals(FileStoreUtil.getDataFromSharePref(context, SP_CACHE_FILENAME, StringFog.decrypt("R0pW"))) ? 1 : 0;
        } catch (Exception unused) {
            return -1;
        }
    }

    public static int checkCacheSdcardTime(Context context, SafeJSONObject safeJSONObject) {
        try {
            String dataFromSharePref = FileStoreUtil.getDataFromSharePref(context, SP_CACHE_FILENAME, StringFog.decrypt("UkdH"));
            if (!TextUtils.isEmpty(dataFromSharePref)) {
                String string = safeJSONObject.getJSONObject(StringFog.decrypt("TEZJTFNa")).getString(StringFog.decrypt("UkdHQlNHe0JVSklG"));
                if (!TextUtils.isEmpty(string)) {
                    return HashUtil.md5(string.getBytes()).equals(dataFromSharePref) ? 1 : 0;
                }
            }
        } catch (Exception unused) {
        }
        return -1;
    }

    public static String getCacheDeviceId() {
        return cache_deviceID;
    }

    public static String getCacheId(Context context, String str) {
        try {
            return FileStoreUtil.getDataFromSharePref(context, SP_CACHE_FILENAME, str);
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String getDeviceId(Context context) {
        String str = "";
        if (!TextUtils.isEmpty(cache_deviceID)) {
            Logger.d(StringFog.decrypt("xZiqYnFzwaekxom7xZuJxJaRbWcBQEVCSUZ7R0RVTUJEamDMnbk=") + cache_deviceID);
            return cache_deviceID;
        }
        try {
            str = FileStoreUtil.getDataFromSharePref(context, SP_CACHE_FILENAME, SP_ID_KEY);
            Logger.d(StringFog.decrypt("xZiqYnFzwaekyqeLxI68xKOLw4qbyrOVxZuJy6+Uwa63amADRUZSSEJGe0pFzJi7") + str);
            cache_deviceID = str;
            return str;
        } catch (Exception e2) {
            e2.printStackTrace();
            return str;
        }
    }

    public static boolean hasCacheData(Context context) {
        return context.getSharedPreferences(SP_CACHE_FILENAME, 0).getBoolean(SP_CACHE_FLAG, false);
    }

    public static void putCacheData(Context context, SafeJSONObject safeJSONObject) {
        try {
            JSONObject jSONObject = safeJSONObject.getJSONObject(StringFog.decrypt("TEZJTFNa"));
            String string = jSONObject.getString(StringFog.decrypt("RUpHTn5AUEhMRg=="));
            String string2 = jSONObject.getString(StringFog.decrypt("UkdHQlNHe0JVSklG"));
            String string3 = jSONObject.getString(StringFog.decrypt("QE1AUU5KQH5CV01ORA=="));
            int i10 = safeJSONObject.getJSONObject(StringFog.decrypt("QFNUT0hARVVITEo=")).getInt(StringFog.decrypt("R0pWUFVqSlJVQkhPdUpJRA=="));
            String string4 = safeJSONObject.getJSONObject(StringFog.decrypt("UlpXV0RO")).getString(StringFog.decrypt("QE1AUU5KQH5IRw=="));
            if (TextUtils.isEmpty(string4)) {
                FileStoreUtil.setDataToSharePref(context, SP_CACHE_FILENAME, StringFog.decrypt("QE1N"), "");
            } else {
                FileStoreUtil.setDataToSharePref(context, SP_CACHE_FILENAME, StringFog.decrypt("QE1N"), HashUtil.md5(string4.getBytes()));
            }
            if (TextUtils.isEmpty(string2)) {
                FileStoreUtil.setDataToSharePref(context, SP_CACHE_FILENAME, StringFog.decrypt("UkdH"), "");
            } else {
                FileStoreUtil.setDataToSharePref(context, SP_CACHE_FILENAME, StringFog.decrypt("UkdH"), HashUtil.md5(string2.getBytes()));
            }
            if (TextUtils.isEmpty(string3)) {
                FileStoreUtil.setDataToSharePref(context, SP_CACHE_FILENAME, StringFog.decrypt("QE1H"), "");
            } else {
                FileStoreUtil.setDataToSharePref(context, SP_CACHE_FILENAME, StringFog.decrypt("QE1H"), HashUtil.md5(string3.getBytes()));
            }
            if (TextUtils.isEmpty(string)) {
                FileStoreUtil.setDataToSharePref(context, SP_CACHE_FILENAME, StringFog.decrypt("RUpH"), "");
            } else {
                FileStoreUtil.setDataToSharePref(context, SP_CACHE_FILENAME, StringFog.decrypt("RUpH"), HashUtil.md5(string.getBytes()));
            }
            String md5 = HashUtil.md5(String.valueOf(i10).getBytes());
            String str = SP_CACHE_FILENAME;
            FileStoreUtil.setDataToSharePref(context, str, StringFog.decrypt("R0pW"), md5);
            context.getSharedPreferences(str, 0).edit().putBoolean(SP_CACHE_FLAG, true).apply();
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static void putCacheMac(Context context, String str, String str2) {
        try {
            if (TextUtils.isEmpty(str2)) {
                SharedPrefStoreUtil.setDataToSharePref(context, SP_CACHE_FILENAME, str, str2);
            } else {
                String encryptString = KeyStoreEncrypt.getInstance().encryptString(context, str2, KEY_STORE_ALIAS);
                SharedPrefStoreUtil.setDataToSharePref(context, SP_CACHE_FILENAME, str, encryptString);
                Logger.d(StringFog.decrypt("emBFQElGYEBVQmlCT0JDRFN+BFNUV2dAQktBbkBABEpEWsGjncyYuw==") + str + StringFog.decrypt("DA4JxquDwY6nxbGTx66Kzp25") + encryptString);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static String readCacheMac(Context context, String str) {
        String str2 = SP_CACHE_FILENAME;
        String str3 = DEFAULT_VALUE;
        String dataFromSharePref = SharedPrefStoreUtil.getDataFromSharePref(context, str2, str, str3);
        if (dataFromSharePref.equals(str3)) {
            return dataFromSharePref;
        }
        try {
            String decryptString = KeyStoreEncrypt.getInstance().decryptString(context, dataFromSharePref, KEY_STORE_ALIAS);
            Logger.d(StringFog.decrypt("emBFQElGYEBVQmlCT0JDRFN+BFFEQkBiQEBMRmxCRwFKRl3GoZ/Lnbs=") + str + StringFog.decrypt("DA4Jy4aAwY6nxbGTx66Kzp25") + decryptString);
            return decryptString;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static void saveCacheId(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        FileStoreUtil.setDataToSharePref(context, SP_CACHE_FILENAME, str, str2);
    }

    public static void syncDeviceId(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Logger.d(StringFog.decrypt("UlpKQGVGUkhCRm1HAca0rceOgcW9j8G9kcSYsMSOvMWZjsO5pWpgxZqGwayrxqKkxI68x5mOw7ulamA="));
        cache_deviceID = str;
        FileStoreUtil.setDataToSharePref(context, SP_CACHE_FILENAME, SP_ID_KEY, str);
    }
}
