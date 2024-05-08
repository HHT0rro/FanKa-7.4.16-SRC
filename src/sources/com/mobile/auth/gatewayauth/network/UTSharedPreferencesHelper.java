package com.mobile.auth.gatewayauth.network;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.mobile.auth.gatewayauth.ExceptionProcessor;
import com.mobile.auth.gatewayauth.model.ConfigRule;
import com.mobile.auth.gatewayauth.model.MonitorStruct;
import com.mobile.auth.gatewayauth.utils.security.PackageUtils;
import com.nirvana.tools.core.EncodeUtil;
import com.nirvana.tools.jsoner.JSONUtils;
import com.nirvana.tools.jsoner.JsonType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class UTSharedPreferencesHelper {
    public static final String AUTH_APP_INFO = "AUTH_APP_INFO";
    private static final String AUTH_CUCC_PL_KEY = "AUTH_CUCC_PL_KEY";
    public static final String AUTH_FLAG_CLOSE_GET_CONFIG_KEY = "AUTH_FLAG_CLOSE_GET_CONFIG_KEY";
    public static final String AUTH_FLAG_LIMIT_GET_CONFIG_KEY = "AUTH_FLAG_LIMIT_GET_CONFIG_KEY";
    public static final String AUTH_LIMIT_AUTH_TOKEN_KEY = "AUTH_LIMIT_AUTH_TOKEN_KEY";
    public static final String AUTH_LIMIT_GET_CONFIG_KEY = "AUTH_LIMIT_GET_CONFIG_KEY";
    public static final String AUTH_LIMIT_LOGIN_PAGE_KEY = "AUTH_LIMIT_LOGIN_PAGE_KEY";
    public static final String AUTH_LIMIT_LOGIN_PHONE_KEY = "AUTH_LIMIT_LOGIN_PHONE_KEY";
    public static final String AUTH_LIMIT_LOGIN_TOKEN_KEY = "AUTH_LIMIT_LOGIN_TOKEN_KEY";
    public static final String AUTH_LIMIT_SLS_KEY = "AUTH_LIMIT_SLS_KEY";
    public static final String AUTH_LIMIT_VENDOR_LIST_KEY = "AUTH_LIMIT_VENDOR_LIST_KEY";
    private static final String AUTH_PL_DATA_KEY = "AUTH_PL_DATA_KEY";
    public static final String AUTH_PRIVATE_KEY = "AUTH_PRIVATE_KEY";
    private static final String AUTH_SDK_CONFIG_KEY = "AUTH_SDK_CONFIG_KEY";
    private static final String AUTH_UT_DATA = "AUTH_UT_DATA";
    private static final String AUTH_UT_DATA_KEY = "AUTH_UT_DATA_KEY";
    public static final String FILE_VENDOR_CONFIG_KEY = "FILE_VENDOR_CONFIG_KEY";
    public static final String LIFE_BODY_VERIFY_CID_KEY = "LIFE_BODY_VERIFY_CID_KEY";
    public static final String LOGIN_TOKEN_KEY = "LOGIN_TOKEN_KEY";
    public static final String MASK_IMSI_KEY = "MASK_IMSI_KEY";
    public static final String MASK_LOCAL_IP_KEY = "MASK_LOCAL_IP_KEY";
    public static final String VERIFY_TOKEN_KEY = "VERIFY_TOKEN_KEY";
    public static final String WIFI_SETUP_FLAG = "wifi_setup_flag";

    public static synchronized void clearAppInfo(Context context, String str) {
        synchronized (UTSharedPreferencesHelper.class) {
            try {
                clearInfo(context, "AUTH_APP_INFO", str);
            } catch (Throwable th) {
                try {
                    ExceptionProcessor.processException(th);
                } catch (Throwable th2) {
                    ExceptionProcessor.processException(th2);
                }
            }
        }
    }

    public static synchronized void clearCUCCPreLoginCount(Context context) {
        synchronized (UTSharedPreferencesHelper.class) {
            try {
                put(context, AUTH_UT_DATA, AUTH_CUCC_PL_KEY, "");
            } catch (Throwable th) {
                try {
                    ExceptionProcessor.processException(th);
                } catch (Throwable th2) {
                    ExceptionProcessor.processException(th2);
                }
            }
        }
    }

    public static synchronized void clearInfo(Context context, String str, String str2) {
        synchronized (UTSharedPreferencesHelper.class) {
            try {
                context.getSharedPreferences(str, 0).edit().remove(str2).commit();
            } catch (Exception unused) {
            } catch (Throwable th) {
                try {
                    ExceptionProcessor.processException(th);
                } catch (Throwable th2) {
                    ExceptionProcessor.processException(th2);
                }
            }
        }
    }

    public static synchronized void clearLimitCount(Context context) {
        synchronized (UTSharedPreferencesHelper.class) {
            try {
                put(context, AUTH_UT_DATA, "AUTH_LIMIT_SLS_KEY", "");
                put(context, AUTH_UT_DATA, AUTH_LIMIT_VENDOR_LIST_KEY, "");
                put(context, AUTH_UT_DATA, AUTH_LIMIT_GET_CONFIG_KEY, "");
                put(context, AUTH_UT_DATA, AUTH_LIMIT_AUTH_TOKEN_KEY, "");
                put(context, AUTH_UT_DATA, AUTH_LIMIT_LOGIN_TOKEN_KEY, "");
                put(context, AUTH_UT_DATA, AUTH_LIMIT_LOGIN_PHONE_KEY, "");
                put(context, AUTH_UT_DATA, AUTH_LIMIT_LOGIN_PAGE_KEY, "");
            } catch (Throwable th) {
                try {
                    ExceptionProcessor.processException(th);
                } catch (Throwable th2) {
                    ExceptionProcessor.processException(th2);
                }
            }
        }
    }

    public static void clearUTData(Context context) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences(AUTH_UT_DATA, 0).edit();
            edit.clear();
            edit.apply();
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public static boolean contains(Context context, String str, String str2) {
        try {
            return context.getSharedPreferences(str, 0).contains(str2);
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return false;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return false;
            }
        }
    }

    public static <T> T get(Context context, String str, String str2, T t2) {
        try {
            if (!contains(context, str, str2)) {
                return t2;
            }
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
        } catch (Exception unused) {
            return t2;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
    }

    public static synchronized <T> T getAppInfo(Context context, String str, T t2) {
        T t10;
        synchronized (UTSharedPreferencesHelper.class) {
            try {
                t10 = (T) get(context, "AUTH_APP_INFO", str, t2);
            } catch (Throwable th) {
                try {
                    ExceptionProcessor.processException(th);
                    return null;
                } catch (Throwable th2) {
                    ExceptionProcessor.processException(th2);
                    return null;
                }
            }
        }
        return t10;
    }

    public static <T> void put(Context context, String str, String str2, T t2) {
        try {
            try {
                context.getSharedPreferences(str, 0).edit().putString(str2, EncodeUtil.encode(t2.toString())).commit();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public static synchronized <T> void putAppInfo(Context context, String str, T t2) {
        synchronized (UTSharedPreferencesHelper.class) {
            try {
                put(context, "AUTH_APP_INFO", str, t2);
            } catch (Throwable th) {
                try {
                    ExceptionProcessor.processException(th);
                } catch (Throwable th2) {
                    ExceptionProcessor.processException(th2);
                }
            }
        }
    }

    public static synchronized String readAuthSDKPrivateKey(Context context) {
        String str;
        synchronized (UTSharedPreferencesHelper.class) {
            try {
                str = (String) get(context, "AUTH_APP_INFO", "AUTH" + PackageUtils.getPackageName(context) + PackageUtils.getSign(context), "");
            } catch (Throwable th) {
                try {
                    ExceptionProcessor.processException(th);
                    return null;
                } catch (Throwable th2) {
                    ExceptionProcessor.processException(th2);
                    return null;
                }
            }
        }
        return str;
    }

    public static synchronized int readAuthTokenLimitCount(Context context, String str) {
        int readLimitCount;
        synchronized (UTSharedPreferencesHelper.class) {
            try {
                readLimitCount = readLimitCount(context, AUTH_LIMIT_AUTH_TOKEN_KEY, str);
            } catch (Throwable th) {
                try {
                    ExceptionProcessor.processException(th);
                    return -1;
                } catch (Throwable th2) {
                    ExceptionProcessor.processException(th2);
                    return -1;
                }
            }
        }
        return readLimitCount;
    }

    public static synchronized int readConfigLimitCount(Context context, String str) {
        int readLimitCount;
        synchronized (UTSharedPreferencesHelper.class) {
            try {
                readLimitCount = readLimitCount(context, AUTH_LIMIT_GET_CONFIG_KEY, str);
            } catch (Throwable th) {
                try {
                    ExceptionProcessor.processException(th);
                    return -1;
                } catch (Throwable th2) {
                    ExceptionProcessor.processException(th2);
                    return -1;
                }
            }
        }
        return readLimitCount;
    }

    public static synchronized int readLimitCount(Context context, String str, String str2) {
        synchronized (UTSharedPreferencesHelper.class) {
            try {
                String str3 = (String) get(context, AUTH_UT_DATA, str, "");
                Map<String, Integer> json2MapForStringInteger = TextUtils.isEmpty(str3) ? null : JSONUtils.json2MapForStringInteger(str3);
                if (json2MapForStringInteger == null || json2MapForStringInteger.isEmpty() || !json2MapForStringInteger.containsKey(str2)) {
                    return 0;
                }
                return json2MapForStringInteger.get(str2).intValue();
            } catch (Throwable th) {
                try {
                    ExceptionProcessor.processException(th);
                    return -1;
                } catch (Throwable th2) {
                    ExceptionProcessor.processException(th2);
                    return -1;
                }
            }
        }
    }

    public static synchronized int readLoginPageLimitCount(Context context, String str) {
        int readLimitCount;
        synchronized (UTSharedPreferencesHelper.class) {
            try {
                readLimitCount = readLimitCount(context, AUTH_LIMIT_LOGIN_PAGE_KEY, str);
            } catch (Throwable th) {
                try {
                    ExceptionProcessor.processException(th);
                    return -1;
                } catch (Throwable th2) {
                    ExceptionProcessor.processException(th2);
                    return -1;
                }
            }
        }
        return readLimitCount;
    }

    public static synchronized int readLoginPhoneLimitCount(Context context, String str) {
        int readLimitCount;
        synchronized (UTSharedPreferencesHelper.class) {
            try {
                readLimitCount = readLimitCount(context, AUTH_LIMIT_LOGIN_PHONE_KEY, str);
            } catch (Throwable th) {
                try {
                    ExceptionProcessor.processException(th);
                    return -1;
                } catch (Throwable th2) {
                    ExceptionProcessor.processException(th2);
                    return -1;
                }
            }
        }
        return readLimitCount;
    }

    public static synchronized int readLoginTokenLimitCount(Context context, String str) {
        int readLimitCount;
        synchronized (UTSharedPreferencesHelper.class) {
            try {
                readLimitCount = readLimitCount(context, AUTH_LIMIT_LOGIN_TOKEN_KEY, str);
            } catch (Throwable th) {
                try {
                    ExceptionProcessor.processException(th);
                    return -1;
                } catch (Throwable th2) {
                    ExceptionProcessor.processException(th2);
                    return -1;
                }
            }
        }
        return readLimitCount;
    }

    public static synchronized ConfigRule readSDKConfig(Context context) {
        ConfigRule configRule;
        synchronized (UTSharedPreferencesHelper.class) {
            configRule = null;
            try {
                String str = (String) get(context, AUTH_UT_DATA, AUTH_SDK_CONFIG_KEY, "");
                if (!TextUtils.isEmpty(str)) {
                    try {
                        configRule = ConfigRule.fromJson(str);
                    } catch (Exception unused) {
                        return null;
                    }
                }
            } catch (Throwable th) {
                try {
                    ExceptionProcessor.processException(th);
                    return null;
                } catch (Throwable th2) {
                    ExceptionProcessor.processException(th2);
                    return null;
                }
            }
        }
        return configRule;
    }

    public static synchronized boolean readSDKConfigCloseFlag(Context context) {
        boolean booleanValue;
        synchronized (UTSharedPreferencesHelper.class) {
            try {
                booleanValue = ((Boolean) get(context, AUTH_UT_DATA, AUTH_FLAG_CLOSE_GET_CONFIG_KEY, Boolean.FALSE)).booleanValue();
            } catch (Throwable th) {
                try {
                    ExceptionProcessor.processException(th);
                    return false;
                } catch (Throwable th2) {
                    ExceptionProcessor.processException(th2);
                    return false;
                }
            }
        }
        return booleanValue;
    }

    public static synchronized String readSDKConfigLimitFlag(Context context) {
        String str;
        synchronized (UTSharedPreferencesHelper.class) {
            try {
                str = (String) get(context, AUTH_UT_DATA, AUTH_FLAG_LIMIT_GET_CONFIG_KEY, "");
            } catch (Throwable th) {
                try {
                    ExceptionProcessor.processException(th);
                    return null;
                } catch (Throwable th2) {
                    ExceptionProcessor.processException(th2);
                    return null;
                }
            }
        }
        return str;
    }

    public static synchronized int readSLSLimitCount(Context context, String str) {
        int readLimitCount;
        synchronized (UTSharedPreferencesHelper.class) {
            try {
                readLimitCount = readLimitCount(context, "AUTH_LIMIT_SLS_KEY", str);
            } catch (Throwable th) {
                try {
                    ExceptionProcessor.processException(th);
                    return -1;
                } catch (Throwable th2) {
                    ExceptionProcessor.processException(th2);
                    return -1;
                }
            }
        }
        return readLimitCount;
    }

    public static List<MonitorStruct> readUTInfo(Context context) {
        try {
            String str = (String) get(context, AUTH_UT_DATA, AUTH_UT_DATA_KEY, "");
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return JSONUtils.parseJsonArray2JsonerList(str, new JsonType<MonitorStruct>() { // from class: com.mobile.auth.gatewayauth.network.UTSharedPreferencesHelper.1
            });
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
    }

    public static synchronized int readVendorLimitCount(Context context, String str) {
        int readLimitCount;
        synchronized (UTSharedPreferencesHelper.class) {
            try {
                readLimitCount = readLimitCount(context, AUTH_LIMIT_VENDOR_LIST_KEY, str);
            } catch (Throwable th) {
                try {
                    ExceptionProcessor.processException(th);
                    return -1;
                } catch (Throwable th2) {
                    ExceptionProcessor.processException(th2);
                    return -1;
                }
            }
        }
        return readLimitCount;
    }

    public static synchronized void saveAuthSDKPrivateKey(Context context, String str) {
        synchronized (UTSharedPreferencesHelper.class) {
            try {
                put(context, "AUTH_APP_INFO", "AUTH" + PackageUtils.getPackageName(context) + PackageUtils.getSign(context), str);
            } catch (Throwable th) {
                try {
                    ExceptionProcessor.processException(th);
                } catch (Throwable th2) {
                    ExceptionProcessor.processException(th2);
                }
            }
        }
    }

    public static synchronized void saveAuthTokenLimitCount(Context context, String str) {
        synchronized (UTSharedPreferencesHelper.class) {
            try {
                saveLimitCount(context, AUTH_LIMIT_AUTH_TOKEN_KEY, str);
            } catch (Throwable th) {
                try {
                    ExceptionProcessor.processException(th);
                } catch (Throwable th2) {
                    ExceptionProcessor.processException(th2);
                }
            }
        }
    }

    public static synchronized void saveConfigLimitCount(Context context, String str) {
        synchronized (UTSharedPreferencesHelper.class) {
            try {
                saveLimitCount(context, AUTH_LIMIT_GET_CONFIG_KEY, str);
            } catch (Throwable th) {
                try {
                    ExceptionProcessor.processException(th);
                } catch (Throwable th2) {
                    ExceptionProcessor.processException(th2);
                }
            }
        }
    }

    public static synchronized void saveLimitCount(Context context, String str, String str2) {
        int i10;
        synchronized (UTSharedPreferencesHelper.class) {
            try {
                String str3 = (String) get(context, AUTH_UT_DATA, str, "");
                Map<String, Integer> json2MapForStringInteger = TextUtils.isEmpty(str3) ? null : JSONUtils.json2MapForStringInteger(str3);
                if (json2MapForStringInteger == null || json2MapForStringInteger.isEmpty() || !json2MapForStringInteger.containsKey(str2)) {
                    json2MapForStringInteger = new HashMap<>();
                    i10 = 1;
                } else {
                    i10 = Integer.valueOf(json2MapForStringInteger.get(str2).intValue() + 1);
                }
                json2MapForStringInteger.put(str2, i10);
                put(context, AUTH_UT_DATA, str, new JSONObject(json2MapForStringInteger).toString());
            } catch (Throwable th) {
                try {
                    ExceptionProcessor.processException(th);
                } catch (Throwable th2) {
                    ExceptionProcessor.processException(th2);
                }
            }
        }
    }

    public static synchronized void saveLoginPageLimitCount(Context context, String str) {
        synchronized (UTSharedPreferencesHelper.class) {
            try {
                saveLimitCount(context, AUTH_LIMIT_LOGIN_PAGE_KEY, str);
            } catch (Throwable th) {
                try {
                    ExceptionProcessor.processException(th);
                } catch (Throwable th2) {
                    ExceptionProcessor.processException(th2);
                }
            }
        }
    }

    public static synchronized void saveLoginPhoneLimitCount(Context context, String str) {
        synchronized (UTSharedPreferencesHelper.class) {
            try {
                saveLimitCount(context, AUTH_LIMIT_LOGIN_PHONE_KEY, str);
            } catch (Throwable th) {
                try {
                    ExceptionProcessor.processException(th);
                } catch (Throwable th2) {
                    ExceptionProcessor.processException(th2);
                }
            }
        }
    }

    public static synchronized void saveLoginTokenLimitCount(Context context, String str) {
        synchronized (UTSharedPreferencesHelper.class) {
            try {
                saveLimitCount(context, AUTH_LIMIT_LOGIN_TOKEN_KEY, str);
            } catch (Throwable th) {
                try {
                    ExceptionProcessor.processException(th);
                } catch (Throwable th2) {
                    ExceptionProcessor.processException(th2);
                }
            }
        }
    }

    public static synchronized void saveSDKConfig(Context context, String str) {
        synchronized (UTSharedPreferencesHelper.class) {
            try {
                put(context, AUTH_UT_DATA, AUTH_SDK_CONFIG_KEY, str);
            } catch (Throwable th) {
                try {
                    ExceptionProcessor.processException(th);
                } catch (Throwable th2) {
                    ExceptionProcessor.processException(th2);
                }
            }
        }
    }

    public static synchronized void saveSDKConfigCloseFlag(Context context, boolean z10) {
        synchronized (UTSharedPreferencesHelper.class) {
            try {
                put(context, AUTH_UT_DATA, AUTH_FLAG_CLOSE_GET_CONFIG_KEY, Boolean.valueOf(z10));
            } catch (Throwable th) {
                try {
                    ExceptionProcessor.processException(th);
                } catch (Throwable th2) {
                    ExceptionProcessor.processException(th2);
                }
            }
        }
    }

    public static synchronized void saveSDKConfigLimitFlag(Context context, String str) {
        synchronized (UTSharedPreferencesHelper.class) {
            try {
                put(context, AUTH_UT_DATA, AUTH_FLAG_LIMIT_GET_CONFIG_KEY, str);
            } catch (Throwable th) {
                try {
                    ExceptionProcessor.processException(th);
                } catch (Throwable th2) {
                    ExceptionProcessor.processException(th2);
                }
            }
        }
    }

    public static synchronized void saveSLSLimitCount(Context context, String str) {
        synchronized (UTSharedPreferencesHelper.class) {
            try {
                saveLimitCount(context, "AUTH_LIMIT_SLS_KEY", str);
            } catch (Throwable th) {
                try {
                    ExceptionProcessor.processException(th);
                } catch (Throwable th2) {
                    ExceptionProcessor.processException(th2);
                }
            }
        }
    }

    public static synchronized void saveUTInfo(Context context, MonitorStruct monitorStruct) {
        synchronized (UTSharedPreferencesHelper.class) {
            try {
                List readUTInfo = readUTInfo(context);
                if (readUTInfo == null) {
                    readUTInfo = new ArrayList();
                }
                readUTInfo.add(monitorStruct);
                put(context, AUTH_UT_DATA, AUTH_UT_DATA_KEY, JSONUtils.jsonerList2JsonArray(readUTInfo));
            } catch (Throwable th) {
                try {
                    ExceptionProcessor.processException(th);
                } catch (Throwable th2) {
                    ExceptionProcessor.processException(th2);
                }
            }
        }
    }

    public static void saveUTInfos(Context context, String str) {
        try {
            put(context, AUTH_UT_DATA, AUTH_UT_DATA_KEY, str);
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public static synchronized void saveVendorLimitCount(Context context, String str) {
        synchronized (UTSharedPreferencesHelper.class) {
            try {
                saveLimitCount(context, AUTH_LIMIT_VENDOR_LIST_KEY, str);
            } catch (Throwable th) {
                try {
                    ExceptionProcessor.processException(th);
                } catch (Throwable th2) {
                    ExceptionProcessor.processException(th2);
                }
            }
        }
    }
}
