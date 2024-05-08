package com.baidu.mobads.sdk.api;

import android.os.Bundle;
import com.baidu.mobads.sdk.internal.aa;
import com.baidu.mobads.sdk.internal.av;
import com.baidu.mobads.sdk.internal.aw;
import com.baidu.mobads.sdk.internal.ba;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class MobadsPermissionSettings {
    private static final String PERMISSION_APP_LIST = "permission_app_list";
    private static final String PERMISSION_APP_UPDATE = "permission_app_update";
    private static final String PERMISSION_DEVICE_INFO = "permission_device_info";
    private static final String PERMISSION_LIMIT_STATE = "permission_limitpersonalads";
    private static final String PERMISSION_LOCATION = "permission_location";
    private static final String PERMISSION_OAID = "permission_oaid";
    private static final String PERMISSION_PHONE_STATE = "permission_read_phone_state";
    private static final String PERMISSION_RUNNING_APP = "permission_running_app";
    private static final String PERMISSION_STORAGE = "permission_storage";
    private static boolean mAccessAppListGranted = false;
    private static boolean mAccessLocationGranted = false;
    private static boolean mAppUpdateGranted = true;
    private static boolean mCheckSPLimit = false;
    private static boolean mDeviceInfoGranted = true;
    private static boolean mExternalStorageGranted = false;
    private static boolean mLimitPrivacyAds = false;
    private static boolean mOAIDGranted = true;
    private static boolean mReadPhoneStateGranted = false;
    private static boolean mRunningAppGranted = true;

    public static JSONObject getLimitInfo() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(PERMISSION_LIMIT_STATE, mLimitPrivacyAds);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public static boolean getLimitPersonalAdsStatus() {
        updateSPLimitTag();
        return mLimitPrivacyAds;
    }

    public static JSONObject getPermissionInfo() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(PERMISSION_LOCATION, "" + mAccessLocationGranted);
            jSONObject.put(PERMISSION_STORAGE, "" + mExternalStorageGranted);
            jSONObject.put(PERMISSION_APP_LIST, "" + mAccessAppListGranted);
            jSONObject.put(PERMISSION_PHONE_STATE, "" + mReadPhoneStateGranted);
            jSONObject.put(PERMISSION_OAID, "" + mOAIDGranted);
            jSONObject.put(PERMISSION_APP_UPDATE, "" + mAppUpdateGranted);
            jSONObject.put(PERMISSION_RUNNING_APP, "" + mRunningAppGranted);
            jSONObject.put(PERMISSION_DEVICE_INFO, "" + mDeviceInfoGranted);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    private static boolean handleIntegrationInfo(Bundle bundle) {
        try {
            switchDebugLog(bundle);
            IXAdContainerFactory c4 = aa.a().c();
            if (c4 != null) {
                c4.getRemoteParam("integrationInfo", bundle);
                return true;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return false;
    }

    private static void postLimitInfoRemote() {
        IXAdContainerFactory c4 = aa.a().c();
        if (c4 != null) {
            c4.onTaskDistribute(ba.f9856b, getLimitInfo());
        }
    }

    private static void postPermissionInfoRemote() {
        IXAdContainerFactory c4 = aa.a().c();
        if (c4 != null) {
            c4.onTaskDistribute(ba.f9855a, getPermissionInfo());
        }
    }

    public static void setLimitPersonalAds(boolean z10) {
        mLimitPrivacyAds = z10;
        postLimitInfoRemote();
    }

    public static void setPermissionAppList(boolean z10) {
        mAccessAppListGranted = z10;
        postPermissionInfoRemote();
    }

    public static void setPermissionAppUpdate(boolean z10) {
        mAppUpdateGranted = z10;
        postPermissionInfoRemote();
    }

    public static void setPermissionDeviceInfo(boolean z10) {
        mDeviceInfoGranted = z10;
        postPermissionInfoRemote();
    }

    public static void setPermissionLocation(boolean z10) {
        mAccessLocationGranted = z10;
        postPermissionInfoRemote();
    }

    public static void setPermissionOAID(boolean z10) {
        mOAIDGranted = z10;
        postPermissionInfoRemote();
    }

    public static void setPermissionReadDeviceID(boolean z10) {
        mReadPhoneStateGranted = z10;
        postPermissionInfoRemote();
    }

    public static void setPermissionRunningApp(boolean z10) {
        mRunningAppGranted = z10;
        postPermissionInfoRemote();
    }

    public static void setPermissionStorage(boolean z10) {
        mExternalStorageGranted = z10;
        postPermissionInfoRemote();
    }

    private static void switchDebugLog(Bundle bundle) {
        if (bundle != null && bundle.containsKey("debug_mode")) {
            if (bundle.getBoolean("debug_mode")) {
                aw.a(true);
                return;
            } else {
                aw.a();
                return;
            }
        }
        if (bundle == null || !bundle.containsKey(av.f9843b)) {
            return;
        }
        if (bundle.getBoolean(av.f9843b)) {
            aw.a((aw.a) new av());
        } else {
            aw.i(av.f9843b);
        }
    }

    private static void updateSPLimitTag() {
        aa a10;
        IXAdContainerFactory c4;
        try {
            if (mCheckSPLimit || (a10 = aa.a()) == null || (c4 = a10.c()) == null) {
                return;
            }
            Object remoteParam = c4.getRemoteParam("limitPersonalAds", new Object[0]);
            if (remoteParam instanceof Boolean) {
                mLimitPrivacyAds = ((Boolean) remoteParam).booleanValue();
                mCheckSPLimit = true;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
