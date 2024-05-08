package com.alimm.tanx.core.request;

import com.alimm.tanx.core.TanxCoreSdk;
import com.alimm.tanx.core.ad.bean.BaseBean;
import com.alimm.tanx.core.utils.MD5Utils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class C extends BaseBean {
    public static final String AD = "/japi";
    public static final String BASE_DEBUG_URL = "https://videoproxy.tanx.com";
    public static final String BASE_DEBUG_URL_HTTP = "http://videoproxy.tanx.com";
    public static volatile String BASE_ORANGE_URL = "https://et.tanx.com";
    public static final String BASE_RELEASE_URL = "https://opehs.tanx.com";
    public static final String BASE_RELEASE_URL_HTTP = "http://opehs.tanx.com";
    public static volatile String BASE_URL = "https://opehs.tanx.com";
    public static final String BASE_UT_RELEASE_URL = "https://et.tanx.com";
    public static final String BASE_UT_RELEASE_URL_HTTP = "http://et.tanx.com";
    public static volatile String BASE_UT_URL = "https://et.tanx.com";
    public static final String UT = "/tsbpm";

    public static String getAdUrl() {
        return BASE_URL + AD + "?id=" + MD5Utils.getMD5String(TanxCoreSdk.getConfig().getAppKey());
    }

    public static String getOrangeUrl() {
        return BASE_ORANGE_URL + "/tsc?os=android";
    }

    public static String getUtUrl() {
        return BASE_UT_URL + UT + "?id=" + MD5Utils.getMD5String(TanxCoreSdk.getConfig().getAppKey());
    }

    public static void setDebug() {
        BASE_URL = BASE_DEBUG_URL;
        BASE_UT_URL = BASE_DEBUG_URL;
        BASE_ORANGE_URL = BASE_DEBUG_URL;
    }

    public static void setDebugHttp() {
        BASE_URL = BASE_DEBUG_URL_HTTP;
        BASE_UT_URL = BASE_DEBUG_URL_HTTP;
        BASE_ORANGE_URL = BASE_DEBUG_URL_HTTP;
    }

    public static void setRelease() {
        BASE_URL = BASE_RELEASE_URL;
        BASE_UT_URL = BASE_UT_RELEASE_URL;
        BASE_ORANGE_URL = BASE_UT_RELEASE_URL;
    }

    public static void setReleaseHttp() {
        Boolean bool;
        try {
            bool = Boolean.valueOf(TanxCoreSdk.getConfig().isDebugMode());
        } catch (Exception unused) {
            bool = null;
        }
        if (bool == null) {
            BASE_URL = BASE_RELEASE_URL_HTTP;
            BASE_UT_URL = BASE_UT_RELEASE_URL_HTTP;
            BASE_ORANGE_URL = BASE_UT_RELEASE_URL_HTTP;
        } else if (bool.booleanValue()) {
            BASE_URL = BASE_RELEASE_URL_HTTP;
            BASE_UT_URL = BASE_UT_RELEASE_URL_HTTP;
            BASE_ORANGE_URL = BASE_UT_RELEASE_URL_HTTP;
        }
    }
}
