package com.alimm.tanx.core.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.os.Build;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import com.alibaba.fastjson.JSON;
import com.alimm.tanx.core.SdkConstant;
import com.alimm.tanx.core.TanxCoreSdk;
import com.alimm.tanx.core.config.TanxConfig;
import com.alimm.tanx.core.request.AdRequestBean;
import com.alimm.tanx.core.ut.UtErrorCode;
import com.alimm.tanx.core.ut.impl.TanxBaseUt;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class AndroidUtils implements NotConfused {
    public static final String TAG = "PackageUtils";
    public static AdRequestBean.AdDeviceBean deviceBean;

    public static String getAndroidId() {
        return "";
    }

    public static String getAppName(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            return String.valueOf(packageManager.getApplicationLabel(packageManager.getPackageInfo(context.getPackageName(), 0).applicationInfo));
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String getAppVersion(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0).versionName;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return str;
        }
    }

    public static String getBrand() {
        return Build.BRAND;
    }

    public static AdRequestBean.AdDeviceBean getDeviceBean() {
        getDeviceInfo(true);
        return deviceBean;
    }

    public static String getDeviceInfo(boolean z10) {
        try {
            if (deviceBean == null) {
                AdRequestBean.AdDeviceBean adDeviceBean = new AdRequestBean.AdDeviceBean();
                deviceBean = adDeviceBean;
                adDeviceBean.user_agent = getUserAgent();
                deviceBean.android_id = getAndroidId();
                AdRequestBean.AdDeviceBean adDeviceBean2 = deviceBean;
                adDeviceBean2.device_type = 0;
                adDeviceBean2.brand = getBrand();
                deviceBean.model = getModel();
                AdRequestBean.AdDeviceBean adDeviceBean3 = deviceBean;
                adDeviceBean3.os = "Android";
                adDeviceBean3.osv = getSystemVersion();
                Point screenSize = getScreenSize(TanxCoreSdk.getApplication());
                AdRequestBean.AdDeviceBean adDeviceBean4 = deviceBean;
                adDeviceBean4.width = screenSize.x;
                adDeviceBean4.height = screenSize.y;
                adDeviceBean4.pixel_ratio = getDisplayDpi(TanxCoreSdk.getApplication());
            }
            deviceBean.network = NetWorkUtil.getNetworkType(TanxCoreSdk.getApplication()).getKey();
            return JSON.toJSONString(deviceBean);
        } catch (Exception e2) {
            LogUtils.e(e2);
            e2.printStackTrace();
            if (z10) {
                TanxBaseUt.utError(UtErrorCode.CRASH_ERROR.getIntCode(), "PackageUtils", LogUtils.getStackTraceMessage(e2), "");
            }
            return "";
        }
    }

    public static int getDisplayDpi(Context context) {
        return context.getResources().getDisplayMetrics().densityDpi;
    }

    public static String getModel() {
        return Build.MODEL;
    }

    public static String getPackageName(Context context) {
        return context != null ? context.getPackageName() : "";
    }

    public static int getScreenOrientation(Context context) {
        int i10 = context.getResources().getConfiguration().orientation;
        if (i10 == 1) {
            return 1;
        }
        return i10 == 2 ? 2 : 0;
    }

    public static Point getScreenSize(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        return point;
    }

    public static String getSystemVersion() {
        return Build.VERSION.RELEASE;
    }

    public static String getUserAgent() {
        return System.getProperty("http.agent");
    }

    public static String getUserAgentSuffix() {
        return " AliApp(TANXSDK/" + SdkConstant.getSdkVersion() + ")";
    }

    public static AdRequestBean.AdDeviceBean getUtDeviceBean() {
        getDeviceInfo(false);
        return deviceBean;
    }

    public static String mediaNameStr() {
        try {
            TanxConfig config = TanxCoreSdk.getConfig();
            String packageName = getPackageName(TanxCoreSdk.getApplication());
            String appVersion = !TextUtils.isEmpty(packageName) ? getAppVersion(TanxCoreSdk.getApplication(), packageName) : "";
            return "AppName/" + (config != null ? config.getAppName() : "") + "/" + packageName + "/" + appVersion;
        } catch (Exception e2) {
            LogUtils.e(e2);
            return "";
        }
    }
}
