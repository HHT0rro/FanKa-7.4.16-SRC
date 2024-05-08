package com.huawei.appgallery.agd.core.impl.report;

import java.util.LinkedHashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class OperationBi {
    public static final String ACTION = "action";
    public static final String ACTION_AD_CLOSED = "close";
    public static final String ACTION_AD_LOAD_FAILURE = "loadFailure";
    public static final String ACTION_AD_LOAD_SUCCESS = "loadSuccess";
    public static final String ACTION_AD_REWARD_SENT = "rewardSent";
    public static final String ACTION_AD_SHOW_FAILURE = "showFailure";
    public static final String ACTION_AD_SHOW_SUCCESS = "showSuccess";
    public static final String ACTION_BUTTON_AREA = "buttonClick";
    public static final String ACTION_ICON_AREA = "iconClick";
    public static final String ACTION_SHAKE_AREA = "shake";
    public static final String ACTION_VIDEO_CLOSE = "videoClose";
    public static final String ACTION_VIDEO_COMPLETE = "videoComplete";
    public static final String ACTION_VIDEO_MUTE = "videoMute";
    public static final String ACTION_VIDEO_PAUSE = "videoPause";
    public static final String ACTION_VIDEO_REPLAY = "videoReplay";
    public static final String ACTION_VIDEO_RESUME = "videoResume";
    public static final String ACTION_VIDEO_SOUND_ON = "videoSoundOn";
    public static final String ACTION_VIDEO_START = "videoStart";
    public static final String ACTION_VIDEO_SURE_LEAVE = "videoSureLeave";
    public static final String AD_ID = "adId";
    public static final String AD_TYPE = "type";
    public static final String CLICK_TYPE = "clickType";
    public static final String CLICK_TYPE_APP_DETAIL = "openAppDetail";
    public static final String CLICK_TYPE_DEEP_LINK = "openDeeplink";
    public static final String CLICK_TYPE_FAST_APP = "openFastApp";
    public static final String CLICK_TYPE_INSTALL = "installApp";
    public static final String CLICK_TYPE_NATIVE = "openNative";
    public static final String CLICK_TYPE_SKIP = "skip";
    public static final String CLICK_TYPE_WAP_URL = "openWeb";
    public static final String INTERACT_TYPE = "interactType";
    public static final String PPS_SLOT_ID = "ppsslotId";
    public static final String SLOTID = "slotId";
    public static final String SWITCH = "switch";
    public static final String TIME = "time";

    public static void reportAdAreaOperate(String str, String str2, String str3) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("action", str);
        linkedHashMap.put(CLICK_TYPE, str2);
        linkedHashMap.put("slotId", str3);
        HiAnalysisUtil.onEvent(0, "1190501103", linkedHashMap);
    }

    public static void reportAdCallBackOperate(String str, String str2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("action", str);
        linkedHashMap.put("slotId", str2);
        HiAnalysisUtil.onEvent(0, "1190501102", linkedHashMap);
    }

    public static void reportAdsFilterOperate(String str, Integer num, String str2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("interactType", String.valueOf(num));
        linkedHashMap.put("adId", str);
        linkedHashMap.put("slotId", str2);
        HiAnalysisUtil.onEvent(0, "1190501104", linkedHashMap);
    }

    public static void reportVideoViewAction(String str, long j10, String str2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("time", String.valueOf(j10));
        linkedHashMap.put("action", str);
        linkedHashMap.put("slotId", str2);
        HiAnalysisUtil.onEvent(0, "1190501101", linkedHashMap);
    }
}
