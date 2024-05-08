package com.qq.e.comm.managers.setting;

import android.text.TextUtils;
import com.qq.e.comm.util.GDTLogger;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class GlobalSetting {
    public static final String ADMOB_SDK_WRAPPER = "ADMOB";
    public static final String AGREE_PRIVACY_KEY = "agree_privacy";
    public static final String AGREE_READ_AAID = "allow_read_aaid";
    public static final String APPLOVIN_SDK_WRAPPER = "APPLOVIN";
    public static final String BD_SDK_WRAPPER = "BD";
    public static final String CCPA = "ccpa";
    public static final String CONV_OPTIMIZE_KEY = "conv_opt_info";
    public static final String COPPA = "coppa";
    public static final String FACEBOOK_SDK_WRAPPER = "FACEBOOK";
    public static final String GDPR = "gdpr";
    public static final String KS_SDK_WRAPPER = "KS";
    public static final String OVERSEA_PRIVACY_INFO = "oversea_privacy_info";
    public static final String PAG_SDK_WRAPPER = "PAG";
    public static final String TT_SDK_WRAPPER = "TT";

    /* renamed from: a, reason: collision with root package name */
    private static volatile Integer f38309a = null;

    /* renamed from: b, reason: collision with root package name */
    private static volatile boolean f38310b = false;

    /* renamed from: c, reason: collision with root package name */
    private static volatile boolean f38311c = true;

    /* renamed from: d, reason: collision with root package name */
    private static volatile Integer f38312d;

    /* renamed from: e, reason: collision with root package name */
    private static volatile Boolean f38313e;

    /* renamed from: f, reason: collision with root package name */
    private static volatile Boolean f38314f;

    /* renamed from: g, reason: collision with root package name */
    private static volatile Boolean f38315g;

    /* renamed from: h, reason: collision with root package name */
    private static volatile Map<String, String> f38316h = new HashMap();

    /* renamed from: i, reason: collision with root package name */
    private static volatile Map<String, String> f38317i = new HashMap();

    /* renamed from: j, reason: collision with root package name */
    private static final Map<String, String> f38318j = new HashMap();

    /* renamed from: k, reason: collision with root package name */
    private static final JSONObject f38319k = new JSONObject();

    /* renamed from: l, reason: collision with root package name */
    private static volatile String f38320l = null;

    /* renamed from: m, reason: collision with root package name */
    private static volatile String f38321m = null;

    /* renamed from: n, reason: collision with root package name */
    private static volatile String f38322n = null;

    /* renamed from: o, reason: collision with root package name */
    private static volatile String f38323o = null;

    /* renamed from: p, reason: collision with root package name */
    private static volatile String f38324p = null;

    public static Boolean getAgreeReadAndroidId() {
        return f38315g;
    }

    public static Boolean getAgreeReadDeviceId() {
        return f38314f;
    }

    public static Integer getChannel() {
        return f38309a;
    }

    public static String getCustomADActivityClassName() {
        return f38320l;
    }

    public static String getCustomLandscapeActivityClassName() {
        return f38323o;
    }

    public static String getCustomPortraitActivityClassName() {
        return f38321m;
    }

    public static String getCustomRewardvideoLandscapeActivityClassName() {
        return f38324p;
    }

    public static String getCustomRewardvideoPortraitActivityClassName() {
        return f38322n;
    }

    public static Map<String, String> getExtraUserData() {
        return Collections.unmodifiableMap(f38316h);
    }

    public static Integer getPersonalizedState() {
        return f38312d;
    }

    public static Map<String, String> getPreloadAdapterMaps() {
        return f38318j;
    }

    public static JSONObject getSettings() {
        return f38319k;
    }

    public static boolean isAgreePrivacyStrategy() {
        return f38313e == null || f38313e.booleanValue();
    }

    public static boolean isAgreeReadAndroidId() {
        if (f38315g == null) {
            return true;
        }
        return f38315g.booleanValue();
    }

    public static boolean isAgreeReadDeviceId() {
        if (f38314f == null) {
            return true;
        }
        return f38314f.booleanValue();
    }

    public static boolean isEnableMediationTool() {
        return f38310b;
    }

    public static boolean isEnableVideoDownloadingCache() {
        return f38311c;
    }

    public static void setAgreePrivacyStrategy(boolean z10) {
        if (f38313e == null) {
            f38313e = Boolean.valueOf(z10);
        }
    }

    @Deprecated
    public static void setAgreeReadAndroidId(boolean z10) {
        f38315g = Boolean.valueOf(z10);
    }

    @Deprecated
    public static void setAgreeReadDeviceId(boolean z10) {
        f38314f = Boolean.valueOf(z10);
    }

    public static void setAgreeReadPrivacyInfo(Map<String, Boolean> map) {
        if (map == null || map.size() == 0) {
            return;
        }
        try {
            f38319k.putOpt(AGREE_PRIVACY_KEY, new JSONObject(map));
        } catch (Exception e2) {
            GDTLogger.e("setAgreeReadPrivacyInfo错误：" + e2.toString());
        }
    }

    public static void setChannel(int i10) {
        if (f38309a == null) {
            f38309a = Integer.valueOf(i10);
        }
    }

    public static void setConvOptimizeInfo(Map<String, Boolean> map) {
        if (map == null || map.size() == 0) {
            return;
        }
        try {
            f38319k.putOpt(CONV_OPTIMIZE_KEY, new JSONObject(map));
        } catch (Exception e2) {
            GDTLogger.e("setConvOptimizeInfo错误：" + e2.toString());
        }
    }

    public static void setCustomADActivityClassName(String str) {
        f38320l = str;
    }

    public static void setCustomLandscapeActivityClassName(String str) {
        f38323o = str;
    }

    public static void setCustomPortraitActivityClassName(String str) {
        f38321m = str;
    }

    public static void setCustomRewardvideoLandscapeActivityClassName(String str) {
        f38324p = str;
    }

    public static void setCustomRewardvideoPortraitActivityClassName(String str) {
        f38322n = str;
    }

    public static void setEnableCollectAppInstallStatus(boolean z10) {
        try {
            f38319k.putOpt("ecais", Boolean.valueOf(z10));
        } catch (JSONException unused) {
        }
    }

    public static void setEnableMediationTool(boolean z10) {
        f38310b = z10;
    }

    public static void setEnableVideoDownloadingCache(boolean z10) {
        f38311c = z10;
    }

    public static void setExtraUserData(Map<String, String> map) {
        if (map == null) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (TextUtils.isEmpty(entry.getKey()) || TextUtils.isEmpty(entry.getValue())) {
                GDTLogger.e("参数key和value不能为空！");
                return;
            }
        }
        f38316h = map;
    }

    public static void setMediaExtData(Map<String, String> map, boolean z10) {
        if (map == null) {
            return;
        }
        if (z10) {
            f38317i = new HashMap();
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (!TextUtils.isEmpty(entry.getKey()) && !TextUtils.isEmpty(entry.getValue())) {
                f38317i.put(entry.getKey(), entry.getValue());
            }
        }
        try {
            f38319k.putOpt("media_ext", new JSONObject(f38317i));
        } catch (JSONException unused) {
            GDTLogger.e("setMediaExtData失败，请检查");
        }
    }

    public static void setPersonalizedState(int i10) {
        f38312d = Integer.valueOf(i10);
    }

    public static void setPreloadAdapters(Map<String, String> map) {
        if (map == null) {
            return;
        }
        f38318j.putAll(map);
    }
}
