package com.wangmai.common.utils;

import com.wangmai.common.bean.SdkTrackEventBean;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class ConstantInfo {
    public static String APP_KEY = null;
    public static String APP_TOKEN = null;
    public static final String BID_FAILED = "bid_failed";
    public static final String BID_FAILED_DEMANDER_SIDE_PRICE_FILTER = "demander_side_price_filter";
    public static final String BID_FAILED_MEDIA_SIDE_PRICE_FILTER = "media_side_price_filter";
    public static final String BID_FAILED_MISSING_MEDIA_PRICE = "missing_media_price";
    public static final String BID_FAILED_MISSING_PRICE = "missing_price";
    public static int CHECKINSTALLEDFLAG = 1;
    public static boolean DEBUG = false;
    public static final int HORIZONTAL = 1;
    public static int MOCK_JD_TYPE = 0;
    public static String SP_KEY_APP_CONFIG = "app_config";
    public static String SP_KEY_SDK_MC = "sdk_mc";
    public static String SP_KEY_SDK_TRACK = "sdk_track";
    public static String SP_KEY_VIRTUAL_CLICK = "click_info";
    public static String SP_KEY_WM_ID = "wm_id";
    public static final String THIRD_PARTY_API = "api";
    public static final String THIRD_PARTY_BD = "baidu";
    public static final String THIRD_PARTY_CSJ = "chuanshanjia";
    public static final String THIRD_PARTY_GDT = "guangdiantong";
    public static final String THIRD_PARTY_JD = "jd";
    public static final String THIRD_PARTY_KS = "kuaishou";
    public static final String THIRD_PARTY_OPPO = "oppo";
    public static final String THIRD_PARTY_QM = "qumeng";
    public static final String THIRD_PARTY_SIGMOB = "sigmob";
    public static final String THIRD_PARTY_TANX = "tanx";
    public static final String THIRD_PARTY_ZHONG_JIAN = "zhongjian";
    public static final String TIME_OUT = "time_out";
    public static final int VERTICAL = 2;
    public static String WX_APP_ID = null;
    public static String bootMark = "";
    public static boolean canUseAppList = true;
    public static boolean canUseLocation = true;
    public static boolean canUseNetworkState = true;
    public static boolean canUseOaid = true;
    public static boolean canUsePermissionRecordAudio = true;
    public static boolean canUsePhoneState = true;
    public static boolean canUseWifiState = true;
    public static boolean canUseWriteExternal = true;
    public static String devImei = "";
    public static String devMacAddress = "";
    public static String devOaid = "";
    public static WMLocation devWMLocation = null;
    public static String deviceFingerprint = "";
    public static double downX = 0.0d;
    public static double downY = 0.0d;
    public static boolean enablePersonalized = true;
    public static int responseSuccessRoundByYLH = 0;
    public static long sdkInitCostTime = -1;
    public static long sdkInitTime = -1;
    public static boolean sdkInitTrackCompleted = false;
    public static ConcurrentHashMap<String, SdkTrackEventBean> sdkTrackEventMap = null;
    public static String updateMark = "";
    public static String wmId = "";

    public static String getAppKey() {
        return APP_KEY;
    }

    public static String getAppToken() {
        return APP_TOKEN;
    }

    public static String getDevImei() {
        return devImei;
    }

    public static String getDevMacAddress() {
        return devMacAddress;
    }

    public static String getDevOaid() {
        return devOaid;
    }

    public static WMLocation getDevWMLocation() {
        return devWMLocation;
    }

    public static String getWxAppId() {
        return WX_APP_ID;
    }

    public static boolean isCanUseAppList() {
        return canUseAppList;
    }

    public static boolean isCanUseLocation() {
        return canUseLocation;
    }

    public static boolean isCanUseNetworkState() {
        return canUseNetworkState;
    }

    public static boolean isCanUseOaid() {
        return canUseOaid;
    }

    public static boolean isCanUsePermissionRecordAudio() {
        return canUsePermissionRecordAudio;
    }

    public static boolean isCanUsePhoneState() {
        return canUsePhoneState;
    }

    public static boolean isCanUseWifiState() {
        return canUseWifiState;
    }

    public static boolean isCanUseWriteExternal() {
        return canUseWriteExternal;
    }

    public static boolean isDebug() {
        return DEBUG;
    }

    public static boolean isEnablePersonalized() {
        return enablePersonalized;
    }

    public static void setAppKey(String str) {
        APP_KEY = str;
    }

    public static void setAppToken(String str) {
        APP_TOKEN = str;
    }

    public static void setCanUseAppList(boolean z10) {
        canUseAppList = z10;
    }

    public static void setCanUseLocation(boolean z10) {
        canUseLocation = z10;
    }

    public static void setCanUseNetworkState(boolean z10) {
        canUseNetworkState = z10;
    }

    public static void setCanUseOaid(boolean z10) {
        canUseOaid = z10;
    }

    public static void setCanUsePermissionRecordAudio(boolean z10) {
        canUsePermissionRecordAudio = z10;
    }

    public static void setCanUsePhoneState(boolean z10) {
        canUsePhoneState = z10;
    }

    public static void setCanUseWifiState(boolean z10) {
        canUseWifiState = z10;
    }

    public static void setCanUseWriteExternal(boolean z10) {
        canUseWriteExternal = z10;
    }

    public static void setDebug(boolean z10) {
        DEBUG = z10;
    }

    public static void setDevImei(String str) {
        devImei = str;
    }

    public static void setDevMacAddress(String str) {
        devMacAddress = str;
    }

    public static void setDevOaid(String str) {
        devOaid = str;
    }

    public static void setDevWMLocation(WMLocation wMLocation) {
        devWMLocation = wMLocation;
    }

    public static void setEnablePersonalized(boolean z10) {
        enablePersonalized = z10;
    }

    public static void setWxAppId(String str) {
        WX_APP_ID = str;
    }
}
