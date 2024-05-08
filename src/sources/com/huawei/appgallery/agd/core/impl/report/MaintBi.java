package com.huawei.appgallery.agd.core.impl.report;

import android.text.TextUtils;
import com.huawei.appgallery.agd.common.gcd.DispatchBlock;
import com.huawei.appgallery.agd.common.gcd.DispatchQoS;
import com.huawei.appgallery.agd.common.gcd.DispatchQueue;
import com.huawei.appgallery.agd.core.impl.report.MaintData;
import java.util.LinkedHashMap;
import n9.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class MaintBi {
    public static final int CHECK_WHITELIST_ERROR_PPS = 2;
    public static final int CHECK_WHITELIST_ERROR_WEBJS = 1;
    public static final int CODE_FAIL_JUMP_WAP_NO_NETWORK = 3;
    public static final int CODE_FAIL_OTHER = 2;
    public static final int CODE_FAIL_PARAM_INVALID = 1;
    public static final int CODE_SUCCESS = 0;
    public static final int DIALOG_FROM_BUTTON = 1;
    public static final int DIALOG_FROM_CLOSE = 0;
    public static final String DOWNLOAD_SOURCE_WEB = "web";
    public static final int NATIVE_AD_LOAD_SUCCESS = 100;
    public static final int PPS_HAD_REWARDED = 1;
    public static final int PPS_NOT_REWARDED = 0;
    public static final String REASON_CLICK_BACK_CLOSE = "back_close";
    public static final String REASON_CLICK_VIDEO_TOP_CARD_CLOSE = "head_close";
    public static final String REASON_OTHERS = "others";
    public static final int REASON_STOP_CLICK_BOTTOM_CARD = 1;
    public static final int REASON_STOP_OTHERS = 0;
    public static final int STATUS_START = 1;
    public static final int STATUS_STOP = 0;
    public static final int WEB_AD_CONTEXT_ERROR = 5;
    public static final int WEB_AD_IAGDAD_NULL_ERROR = 7;
    public static final int WEB_AD_JSON_PARSE_ERROR = 4;
    public static final int WEB_AD_JS_OBJECT_NULL_ERROR = 6;
    public static final int WEB_AD_PACKAGE_NAMES_INCONSISTENT = 1;
    public static final int WEB_AD_PARAM_JSON_ERROR = 2;
    public static final int WEB_AD_PARAM_JSON_VALUE_NULL = 3;

    public static void report(MaintData maintData) {
        if (maintData != null && !TextUtils.isEmpty(maintData.getEventId())) {
            HiAnalysisUtil.onEvent(1, maintData.getEventId(), maintData.getLinkedHashMap());
        } else {
            a.f52175d.e("MaintBi", "report data is null or eventId is null");
        }
    }

    public static void reportAdClose(String str, String str2, String str3) {
        report(new MaintData.Builder(MaintKey.EVENT_AGD_AD_CLOSE).setSlotId(str).setUniqueId(str2).setAdId(str3).build());
    }

    public static void reportAdExpired(String str) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("slotId", str);
        HiAnalysisUtil.onEvent(1, MaintKey.EVENT_AD_EXPIRED, linkedHashMap);
    }

    public static void reportAdShow(int i10, long j10, String str) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("errorCode", String.valueOf(i10));
        linkedHashMap.put(MaintKey.TOTAL_TIME, String.valueOf(j10));
        linkedHashMap.put("slotId", str);
        HiAnalysisUtil.onEvent(1, MaintKey.EVENT_AD_SHOW, linkedHashMap);
    }

    public static void reportAdShowError(int i10, String str, String str2, String str3) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("errorCode", String.valueOf(i10));
        linkedHashMap.put("uri", str);
        linkedHashMap.put("msg", str2);
        linkedHashMap.put("slotId", str3);
        HiAnalysisUtil.onEvent(1, MaintKey.EVENT_AD_LOAD_FAIL, linkedHashMap);
    }

    public static void reportAgdAppInstallFail(String str, String str2, String str3) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("reason", String.valueOf(str));
        linkedHashMap.put(MaintKey.TASK_PACKAGE_NAME, str2);
        linkedHashMap.put("slotId", str3);
        HiAnalysisUtil.onEvent(1, MaintKey.EVENT_AGD_APP_INSTALL_FAIL, linkedHashMap);
    }

    public static void reportAgdDownloadFail(String str, String str2, String str3) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("reason", String.valueOf(str));
        linkedHashMap.put(MaintKey.TASK_PACKAGE_NAME, str2);
        linkedHashMap.put("slotId", str3);
        HiAnalysisUtil.onEvent(1, MaintKey.EVENT_AGD_DOWNLOAD_FAIL, linkedHashMap);
    }

    public static void reportCheckWapWhiteListError(int i10, String str) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(MaintKey.PAGE_TYPE, String.valueOf(i10));
        linkedHashMap.put("uri", str);
        HiAnalysisUtil.onEvent(1, MaintKey.EVENT_WAP_WHITELIST_ERROR, linkedHashMap);
    }

    public static void reportDistributionReward(int i10, String str, String str2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("errorCode", String.valueOf(i10));
        linkedHashMap.put("msg", str);
        linkedHashMap.put("slotId", str2);
        HiAnalysisUtil.onEvent(1, MaintKey.EVENT_DIST_REWARD, linkedHashMap);
    }

    public static void reportErrorLog(String str, String str2, Throwable th) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("TAG : ");
        sb2.append(str);
        sb2.append(", msg : ");
        sb2.append(str2);
        sb2.append(", error: ");
        sb2.append(th != null ? th.getMessage() : "");
        linkedHashMap.put("msg", sb2.toString());
        HiAnalysisUtil.onEvent(1, MaintKey.EVENT_AGD_GLOBAL_ERROR, linkedHashMap);
    }

    public static void reportLoadAgNativeAd(String str, int i10, String str2, long j10, int i11) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("slotId", str);
        linkedHashMap.put("errorCode", String.valueOf(i10));
        linkedHashMap.put("msg", str2);
        linkedHashMap.put(MaintKey.TOTAL_TIME, String.valueOf(j10));
        linkedHashMap.put("type", String.valueOf(i11));
        HiAnalysisUtil.onEvent(1, MaintKey.EVENT_LOAD_AG_NATIVE_AD, linkedHashMap);
    }

    public static void reportLoadMediaParams(int i10, String str, long j10) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("errorCode", String.valueOf(i10));
        linkedHashMap.put("msg", str);
        linkedHashMap.put(MaintKey.TOTAL_TIME, String.valueOf(j10));
        HiAnalysisUtil.onEvent(1, MaintKey.EVENT_QUERY_MEDIA_PARAMS, linkedHashMap);
    }

    public static void reportLoadNativeAd(String str, int i10, String str2, long j10, int i11) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("slotId", str);
        linkedHashMap.put("errorCode", String.valueOf(i10));
        linkedHashMap.put("msg", str2);
        linkedHashMap.put(MaintKey.TOTAL_TIME, String.valueOf(j10));
        linkedHashMap.put("type", String.valueOf(i11));
        HiAnalysisUtil.onEvent(1, MaintKey.EVENT_LOAD_NATIVE_AD, linkedHashMap);
    }

    public static void reportLoadPpsNativeAd(String str, int i10, String str2, long j10, int i11) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("slotId", str);
        linkedHashMap.put("errorCode", String.valueOf(i10));
        linkedHashMap.put("msg", str2);
        linkedHashMap.put(MaintKey.TOTAL_TIME, String.valueOf(j10));
        linkedHashMap.put("type", String.valueOf(i11));
        HiAnalysisUtil.onEvent(1, MaintKey.EVENT_LOAD_PPS_NATIVE_AD, linkedHashMap);
    }

    public static void reportMediaInit(final int i10) {
        DispatchQueue.GLOBAL.async(DispatchQoS.SERIAL, new DispatchBlock() { // from class: com.huawei.appgallery.agd.core.impl.report.MaintBi.1
            @Override // java.lang.Runnable
            public void run() {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("errorCode", String.valueOf(i10));
                HiAnalysisUtil.onEvent(1, MaintKey.EVENT_MEDIA_INIT, linkedHashMap);
            }
        });
    }

    public static void reportMediaRequestAd(int i10, String str, long j10, String str2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(MaintKey.TOTAL_TIME, String.valueOf(j10));
        linkedHashMap.put("msg", String.valueOf(str));
        linkedHashMap.put("errorCode", String.valueOf(i10));
        linkedHashMap.put("slotId", str2);
        HiAnalysisUtil.onEvent(1, MaintKey.EVENT_MEDIA_REQUEST_AD, linkedHashMap);
    }

    public static void reportNativeAdWapError(String str, String str2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("reason", str);
        linkedHashMap.put("uri", str2);
        HiAnalysisUtil.onEvent(1, MaintKey.EVENT_LOAD_WEB_AD, linkedHashMap);
    }

    public static void reportNoRewardExit(String str, String str2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("reason", str);
        linkedHashMap.put("slotId", str2);
        HiAnalysisUtil.onEvent(1, MaintKey.EVENT_NO_REWARD_EXIT, linkedHashMap);
    }

    public static void reportOpenEventUploadResult(String str, int i10, String str2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("reason", str);
        linkedHashMap.put("type", String.valueOf(i10));
        linkedHashMap.put("slotId", str2);
        HiAnalysisUtil.onEvent(1, MaintKey.EVENT_OPEN_EVENT_UPLOAD_FAIL, linkedHashMap);
    }

    public static void reportPPSAdShow(String str, long j10) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(MaintKey.TOTAL_TIME, String.valueOf(j10));
        linkedHashMap.put("slotId", str);
        HiAnalysisUtil.onEvent(1, MaintKey.EVENT_PPS_AD_SHOW, linkedHashMap);
    }

    public static void reportPPSAdShowError(String str, int i10) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("errorCode", String.valueOf(i10));
        linkedHashMap.put("slotId", str);
        HiAnalysisUtil.onEvent(1, MaintKey.EVENT_PPS_VIDEO_LOAD_FAIL, linkedHashMap);
    }

    public static void reportPPSDownloadFail(int i10, String str, String str2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("reason", String.valueOf(i10));
        linkedHashMap.put("adId", str);
        linkedHashMap.put("slotId", str2);
        HiAnalysisUtil.onEvent(1, MaintKey.EVENT_PPS_DOWNLOAD_FAIL, linkedHashMap);
    }

    public static void reportPPSNoRewardExit(String str, int i10) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("slotId", str);
        linkedHashMap.put("errorCode", String.valueOf(i10));
        HiAnalysisUtil.onEvent(1, MaintKey.EVENT_PPS_NO_REWARD_EXIT, linkedHashMap);
    }

    public static void reportPPSReward(String str, int i10, String str2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("errorCode", String.valueOf(i10));
        linkedHashMap.put("msg", str2);
        linkedHashMap.put("slotId", str);
        HiAnalysisUtil.onEvent(1, MaintKey.EVENT_PPS_DIST_REWARD, linkedHashMap);
    }

    public static void reportPPSStartDownloadError(int i10, String str, String str2) {
        if (i10 == 0) {
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("errorCode", String.valueOf(i10));
        linkedHashMap.put("slotId", str2);
        linkedHashMap.put("uniqueId", str);
        HiAnalysisUtil.onEvent(1, MaintKey.EVENT_PPS_START_DOWNLOAD_ERROR, linkedHashMap);
    }

    public static void reportRewardPauseOrResume(int i10, int i11, String str, int i12) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("reason", String.valueOf(i10));
        linkedHashMap.put("status", String.valueOf(i11));
        linkedHashMap.put("slotId", str);
        linkedHashMap.put(MaintKey.TOTAL_TIME, String.valueOf(i12));
        HiAnalysisUtil.onEvent(1, MaintKey.EVENT_AD_NO_REWARD_PAUSE_OR_RESUME, linkedHashMap);
    }

    public static void reportVideoStart(long j10, String str, String str2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(MaintKey.TOTAL_TIME, String.valueOf(j10));
        linkedHashMap.put("uri", str);
        linkedHashMap.put("slotId", str2);
        HiAnalysisUtil.onEvent(1, MaintKey.EVENT_VIDEO_START_PALY, linkedHashMap);
    }
}
