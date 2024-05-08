package com.nirvana.tools.logger;

import android.content.Context;
import android.text.TextUtils;
import com.nirvana.tools.cache.CacheHandler;
import com.nirvana.tools.cache.CacheManager;
import com.nirvana.tools.cache.SharedPreferenceTemplate;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class UaidTracker {
    private static final String CMCC = "CMCC";
    private static final long CMCC_EXPIRED_TIME = 120000;
    private static final String CMCC_URL = "https://verify.cmpassport.com/h5/getMobile";
    private static final String CUCC = "CUCC";
    private static final long CUCC_EXPIRED_TIME = 60000;
    private static final String CUCC_GET_AUTH_ADDR_URL = "https://nisportal.10010.com:9001/api";
    private static final String KEY_CACHE_UAID_TRACKER = "KEY_CACHE_UAID_TRACKER";
    private static final String TAG = "UaidTracker";
    private static final String UAID_EXPIRED_TIME_KEY = "expiredTime";
    private static final String UAID_ISUSABLE_KEY = "isUsable";
    private static final String UAID_TOKENS_KEY = "tokens";
    private static final String UAID_TRACKER_DATA = "UAID_TRACKER_DATA";
    private static final int UAID_TRACKER_DATA_VERSION = 1;
    private static boolean isTackerEnable;
    private static volatile UaidTracker sInstance;
    private boolean isLoggerEnable = false;
    private String cmccAppID = "";
    private String cmccAppKey = "";
    private String cuccAppID = "";

    private CacheHandler getCacheHandler(Context context, String str, String str2) {
        CacheManager cacheManager = CacheManager.getInstance(context.getApplicationContext());
        CacheHandler cacheHandler = cacheManager.getCacheHandler(KEY_CACHE_UAID_TRACKER);
        if (cacheHandler != null) {
            return cacheHandler;
        }
        return cacheManager.registerCacheHandler(KEY_CACHE_UAID_TRACKER, (String) new SharedPreferenceTemplate(1, false, UAID_TRACKER_DATA, str2 + str));
    }

    public static UaidTracker getInstance() {
        if (sInstance == null) {
            synchronized (UaidTracker.class) {
                if (sInstance == null) {
                    sInstance = new UaidTracker();
                }
            }
        }
        return sInstance;
    }

    public static boolean isEnable() {
        return isTackerEnable;
    }

    public String getIdToken(Context context, String str, String str2) {
        String load = getCacheHandler(context, str, str2).load();
        if (TextUtils.isEmpty(load)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(load);
            long j10 = jSONObject.getLong(UAID_EXPIRED_TIME_KEY);
            boolean z10 = jSONObject.getBoolean(UAID_ISUSABLE_KEY);
            if (j10 > System.currentTimeMillis() && !z10) {
                return jSONObject.getJSONObject(UAID_TOKENS_KEY).toString();
            }
        } catch (JSONException unused) {
        }
        return null;
    }

    public boolean isUsable(Context context, String str, String str2) {
        try {
            return new JSONObject(getCacheHandler(context, str, str2).load()).getBoolean(UAID_ISUSABLE_KEY);
        } catch (JSONException unused) {
            return false;
        }
    }

    public void setEnable(boolean z10) {
        isTackerEnable = z10;
    }

    public void setKey(String str, String str2, String str3) {
        this.cmccAppID = str;
        this.cmccAppKey = str2;
        this.cuccAppID = str3;
    }

    public void setLoggerEnable(boolean z10) {
        this.isLoggerEnable = z10;
    }

    public void setUsable(Context context, String str, String str2) {
        CacheHandler cacheHandler = getCacheHandler(context, str, str2);
        try {
            JSONObject jSONObject = new JSONObject(cacheHandler.load());
            jSONObject.put(UAID_ISUSABLE_KEY, true);
            cacheHandler.save(jSONObject.toString());
        } catch (JSONException unused) {
        }
    }
}
