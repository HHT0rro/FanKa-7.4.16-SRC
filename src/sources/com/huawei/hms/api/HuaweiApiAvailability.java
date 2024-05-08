package com.huawei.hms.api;

import android.app.Activity;
import android.app.Dialog;
import android.app.Fragment;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.api.HuaweiApiCallable;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class HuaweiApiAvailability {
    public static final String ACTIVITY_NAME = "com.huawei.hms.core.activity.JumpActivity";
    private static final Map<String, Integer> API_MAP;
    public static final String APPID_HMS = "C10132067";
    public static final String APPID_HMS_TV = "C100636709";
    public static final String HMS_API_NAME_GAME = "HuaweiGame.API";
    public static final String HMS_API_NAME_IAP = "HuaweiIap.API";
    public static final String HMS_API_NAME_ID = "HuaweiID.API";
    public static final String HMS_API_NAME_OD = "HuaweiOpenDevice.API";
    public static final String HMS_API_NAME_PAY = "HuaweiPay.API";
    public static final String HMS_API_NAME_PPS = "HuaweiPPSkit.API";
    public static final String HMS_API_NAME_PUSH = "HuaweiPush.API";
    public static final String HMS_API_NAME_SNS = "HuaweiSns.API";
    public static final int HMS_JSON_VERSION_MIN = 30000000;
    public static final int HMS_SDK_VERSION_CODE = 61100302;
    public static final String HMS_SDK_VERSION_NAME = "6.11.0.302";
    public static final int HMS_VERSION_CODE_GAME = 20503000;
    public static final int HMS_VERSION_CODE_IAP = 20700300;
    public static final int HMS_VERSION_CODE_ID = 30000000;
    public static final int HMS_VERSION_CODE_KIT_UPDATE = 40000000;
    public static final int HMS_VERSION_CODE_MIN = 20503000;
    public static final int HMS_VERSION_CODE_OD = 20601000;
    public static final int HMS_VERSION_CODE_PAY = 20503000;
    public static final int HMS_VERSION_CODE_PPS = 20700300;
    public static final int HMS_VERSION_CODE_PUSH = 20503000;
    public static final int HMS_VERSION_CODE_SNS = 20503000;
    public static final int HMS_VERSION_MAX = 20600000;
    public static final int HMS_VERSION_MIN = 20503000;
    public static final int NOTICE_VERSION_CODE = 20600000;
    public static final String SERVICES_ACTION = "com.huawei.hms.core.aidlservice";

    @Deprecated
    public static final String SERVICES_PACKAGE = "com.huawei.hwid";

    @Deprecated
    public static final String SERVICES_PACKAGE_TV = "com.huawei.hwid.tv";

    @Deprecated
    public static final String SERVICES_SIGNATURE = "B92825C2BD5D6D6D1E7F39EECD17843B7D9016F611136B75441BC6F4D3F00F05";

    @Deprecated
    public static final String SERVICES_SIGNATURE_CAR = "3517262215D8D3008CBF888750B6418EDC4D562AC33ED6874E0D73ABA667BC3C";

    @Deprecated
    public static final String SERVICES_SIGNATURE_TV = "3517262215D8D3008CBF888750B6418EDC4D562AC33ED6874E0D73ABA667BC3C";
    public static int servicesVersionCode = 30000100;

    static {
        HashMap hashMap = new HashMap();
        API_MAP = hashMap;
        hashMap.put(HMS_API_NAME_ID, 30000000);
        hashMap.put(HMS_API_NAME_SNS, 20503000);
        hashMap.put(HMS_API_NAME_PAY, 20503000);
        hashMap.put(HMS_API_NAME_PUSH, 20503000);
        hashMap.put(HMS_API_NAME_GAME, 20503000);
        hashMap.put(HMS_API_NAME_OD, Integer.valueOf(HMS_VERSION_CODE_OD));
        hashMap.put(HMS_API_NAME_IAP, 20700300);
        hashMap.put(HMS_API_NAME_PPS, 20700300);
    }

    public static Map<String, Integer> getApiMap() {
        return API_MAP;
    }

    public static HuaweiApiAvailability getInstance() {
        return HuaweiApiAvailabilityImpl.getInstance();
    }

    public static int getServicesVersionCode() {
        return servicesVersionCode;
    }

    public static void setServicesVersionCode(int i10) {
        servicesVersionCode = i10;
    }

    public abstract Task<Void> checkApiAccessible(HuaweiApi<?> huaweiApi, HuaweiApi<?>... huaweiApiArr);

    public abstract Task<Void> checkApiAccessible(HuaweiApiCallable huaweiApiCallable, HuaweiApiCallable... huaweiApiCallableArr);

    public abstract PendingIntent getErrPendingIntent(Context context, int i10, int i11);

    public abstract PendingIntent getErrPendingIntent(Context context, ConnectionResult connectionResult);

    public abstract Dialog getErrorDialog(Activity activity, int i10, int i11);

    public abstract Dialog getErrorDialog(Activity activity, int i10, int i11, DialogInterface.OnCancelListener onCancelListener);

    public abstract String getErrorString(int i10);

    public abstract Task<Void> getHuaweiServicesReady(Activity activity);

    public abstract Intent getResolveErrorIntent(Activity activity, int i10);

    public abstract PendingIntent getResolveErrorPendingIntent(Activity activity, int i10);

    public abstract int isHuaweiMobileNoticeAvailable(Context context);

    public abstract int isHuaweiMobileServicesAvailable(Context context);

    public abstract int isHuaweiMobileServicesAvailable(Context context, int i10);

    public abstract boolean isUserResolvableError(int i10);

    public abstract boolean isUserResolvableError(int i10, PendingIntent pendingIntent);

    public abstract void popupErrNotification(Context context, ConnectionResult connectionResult);

    public abstract void resolveError(Activity activity, int i10, int i11);

    public abstract void resolveError(Activity activity, int i10, int i11, PendingIntent pendingIntent);

    public abstract boolean showErrorDialogFragment(Activity activity, int i10, int i11);

    public abstract boolean showErrorDialogFragment(Activity activity, int i10, int i11, DialogInterface.OnCancelListener onCancelListener);

    public abstract boolean showErrorDialogFragment(Activity activity, int i10, Fragment fragment, int i11, DialogInterface.OnCancelListener onCancelListener);

    public abstract void showErrorNotification(Context context, int i10);
}
