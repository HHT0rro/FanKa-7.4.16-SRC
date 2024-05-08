package com.nirvana.tools.logger.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.nirvana.tools.jsoner.JSONUtils;
import com.nirvana.tools.logger.model.ACMLimitConfig;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class UTSharedPreferencesHelper {
    private static final String ALITX_LOGGER_DATA = "ALITX_LOGGER_DATA";
    private static final String AUTH_LIMIT_CONFIG_KEY = "AUTH_LIMIT_CONFIG_KEY";
    public static final String AUTH_LIMIT_SLS_KEY = "AUTH_LIMIT_SLS_KEY";

    public static synchronized void clearLimitCount(Context context) {
        synchronized (UTSharedPreferencesHelper.class) {
            put(context, ALITX_LOGGER_DATA, "AUTH_LIMIT_SLS_KEY", "");
            put(context, ALITX_LOGGER_DATA, AUTH_LIMIT_CONFIG_KEY, "");
        }
    }

    public static void clearUTData(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences(ALITX_LOGGER_DATA, 0).edit();
        edit.clear();
        edit.apply();
    }

    public static boolean contains(Context context, String str, String str2) {
        return context.getSharedPreferences(str, 0).contains(str2);
    }

    public static <T> T get(Context context, String str, String str2, T t2) {
        try {
            if (contains(context, str, str2)) {
                String decode = EncodeUtil.decode(context.getSharedPreferences(str, 0).getString(str2, ""));
                if (t2 instanceof Integer) {
                    return (T) Integer.valueOf(decode);
                }
                if (t2 instanceof Boolean) {
                    return (T) Boolean.valueOf(decode);
                }
                if (t2 instanceof Long) {
                    return (T) Long.valueOf(decode);
                }
                if (t2 instanceof String) {
                    return (T) String.valueOf(decode);
                }
                throw new Exception("unsupported type");
            }
        } catch (Exception unused) {
        }
        return t2;
    }

    public static <T> void put(Context context, String str, String str2, T t2) {
        try {
            context.getSharedPreferences(str, 0).edit().putString(str2, EncodeUtil.encode(t2.toString())).commit();
        } catch (Exception unused) {
        }
    }

    public static synchronized ACMLimitConfig readLimitConfig(Context context) {
        ACMLimitConfig aCMLimitConfig;
        synchronized (UTSharedPreferencesHelper.class) {
            String str = (String) get(context, ALITX_LOGGER_DATA, AUTH_LIMIT_CONFIG_KEY, "");
            aCMLimitConfig = null;
            if (!TextUtils.isEmpty(str)) {
                try {
                    aCMLimitConfig = ACMLimitConfig.fromJson(str);
                } catch (Exception unused) {
                    return null;
                }
            }
        }
        return aCMLimitConfig;
    }

    public static synchronized int readLimitCount(Context context, String str, String str2) {
        synchronized (UTSharedPreferencesHelper.class) {
            String str3 = (String) get(context, ALITX_LOGGER_DATA, str, "");
            Map<String, Integer> json2MapForStringInteger = TextUtils.isEmpty(str3) ? null : JSONUtils.json2MapForStringInteger(str3);
            if (json2MapForStringInteger == null || json2MapForStringInteger.isEmpty() || !json2MapForStringInteger.containsKey(str2)) {
                return 0;
            }
            return json2MapForStringInteger.get(str2).intValue();
        }
    }

    public static synchronized int readSLSLimitCount(Context context, String str) {
        int readLimitCount;
        synchronized (UTSharedPreferencesHelper.class) {
            readLimitCount = readLimitCount(context, "AUTH_LIMIT_SLS_KEY", str);
        }
        return readLimitCount;
    }

    public static synchronized void saveLimitCount(Context context, String str, String str2) {
        int i10;
        synchronized (UTSharedPreferencesHelper.class) {
            String str3 = (String) get(context, ALITX_LOGGER_DATA, str, "");
            Map<String, Integer> json2MapForStringInteger = TextUtils.isEmpty(str3) ? null : JSONUtils.json2MapForStringInteger(str3);
            if (json2MapForStringInteger == null || json2MapForStringInteger.isEmpty() || !json2MapForStringInteger.containsKey(str2)) {
                json2MapForStringInteger = new HashMap<>();
                i10 = 1;
            } else {
                i10 = Integer.valueOf(json2MapForStringInteger.get(str2).intValue() + 1);
            }
            json2MapForStringInteger.put(str2, i10);
            put(context, ALITX_LOGGER_DATA, str, new JSONObject(json2MapForStringInteger).toString());
        }
    }

    public static synchronized void saveSLSLimitCount(Context context, String str) {
        synchronized (UTSharedPreferencesHelper.class) {
            saveLimitCount(context, "AUTH_LIMIT_SLS_KEY", str);
        }
    }

    public static synchronized void writeLimitConfig(Context context, ACMLimitConfig aCMLimitConfig) {
        synchronized (UTSharedPreferencesHelper.class) {
            put(context, ALITX_LOGGER_DATA, AUTH_LIMIT_CONFIG_KEY, aCMLimitConfig.toJsonString());
        }
    }
}
