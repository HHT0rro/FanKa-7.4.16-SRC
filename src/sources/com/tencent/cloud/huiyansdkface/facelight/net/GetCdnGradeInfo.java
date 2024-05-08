package com.tencent.cloud.huiyansdkface.facelight.net;

import com.tencent.cloud.huiyansdkface.facelight.net.tools.HttpEventListener;
import com.tencent.cloud.huiyansdkface.facelight.process.d;
import com.tencent.cloud.huiyansdkface.facelight.provider.WbUiTips;
import com.tencent.cloud.huiyansdkface.normal.tools.WLogger;
import com.tencent.cloud.huiyansdkface.wehttp2.WeLog;
import com.tencent.cloud.huiyansdkface.wehttp2.WeOkHttp;
import com.tencent.cloud.huiyansdkface.wehttp2.WeReq;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class GetCdnGradeInfo {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class GetGradeInfoResponse implements Serializable {
        public String actCheckNextTime;
        public List<String> androidBanTuringList;
        public List<String> androidBanTuringVersion;
        public String androidEyeOpenRate;
        public String androidFaceAreaMax;
        public String androidFaceAreaMin;
        public String androidFacePitchMax;
        public String androidFacePitchMin;
        public String androidFacePointsPercent;
        public String androidFacePointsVis;
        public String androidFaceRollMax;
        public String androidFaceRollMin;
        public String androidFaceYawMax;
        public String androidFaceYawMin;
        public int androidHighPixelThreshold;
        public String androidLightScore;
        public String androidLuxDefault;
        public boolean androidUseHighPixelNew;
        public String authBackVisibleTime;
        public String camTokenWaitTime;
        public String dialogType;
        public String encodeOutOfTime;
        public String enterDetectWaitTime;
        public String gradeQueryInterval;
        public String gradeRetryCount;
        public String gradeTimeoutInterval;
        public String isCamCanRetry;
        public String isDetectCloseEye;
        public String isGm;
        public String isWillCheckShielding;
        public String kyc_auth_popup_tip;
        public String kyc_auth_tip_know_and_agree;
        public String kyc_auth_tip_line1;
        public String kyc_auth_tip_line2;
        public String kyc_auth_tip_line3;
        public String kyc_auth_tip_read_and_agree;
        public String kyc_auth_tip_refuse_no_use;
        public String kyc_auth_tip_use_cam_mic_reason;
        public String kyc_auth_tip_use_cam_reason;
        public String kyc_auth_tip_user_auth;
        public String kyc_dialog_no;
        public String kyc_dialog_text;
        public String kyc_dialog_title;
        public String kyc_dialog_yes;
        public Map<String, WbUiTips> languageSet;
        public List<String> notPlayVoiceList;
        public String outOfTime;
        public String previewVoiceTime;
        public List<String> recordList;
        public String recordTime;
        public String recordYTVideo;
        public String returnUserImage;
        public String skipGuideTipVoice;
        public specialSet[] specialAppIdSet;
        public String turingTime;
        public String uploadYTVideo;
        public String useTuringSDK_and;
        public String verifyBackVisibleTime;
        public String version;
        public String willAsrAnswerRetryCount;
        public String willAsrErrorTip;
        public String willAsrNetworkTip;
        public String willAsrShowErrorTipTime;
        public String willAsrShowNetworkTipTime;
        public String willAsrTimeoutInterval;
        public String willAsrTimeoutRetryCount;
        public String willFaceOutCount;
        public String willPoseCount;
        public String willUploadTimeoutInterval;
        public String willVideoBitRateFactor;
        public String willVideoTimeoutInterval;
        public String will_pass_play_volume_check;
        public String will_screenshot;
        public String will_service_answer_no_volume_tip;
        public String will_service_mute_timeout;
        public String will_service_play_audio_lowest_volume;
        public String will_service_play_mode_wait_time_and;
        public String will_service_play_no_volume_tip;
        public String will_service_screenshot_time;
        public String will_service_volume_detect_minlevel_and;
        public String will_service_volume_detect_waittime;
        public String will_service_volume_turnup_level;
        public String ytVideoValidFrames;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class specialSet {
        public String actCheckNextTime;
        public String androidFaceAreaMax;
        public String androidFaceAreaMin;
        public String androidFacePitchMax;
        public String androidFacePitchMin;
        public String androidFacePointsPercent;
        public String androidFacePointsVis;
        public String androidFaceRollMax;
        public String androidFaceRollMin;
        public String androidFaceYawMax;
        public String androidFaceYawMin;
        public int androidHighPixelThreshold;
        public List<String> appIdSet;
        public String authBackVisibleTime;
        public String camTokenWaitTime;
        public String dialogType;
        public String enterDetectWaitTime;
        public String gradeQueryInterval;
        public String gradeTimeoutInterval;
        public String isCamCanRetry;
        public String isDetectCloseEye;
        public String isGm;
        public String isWillCheckShielding;
        public String kyc_auth_popup_tip;
        public String kyc_auth_tip_know_and_agree;
        public String kyc_auth_tip_line1;
        public String kyc_auth_tip_line2;
        public String kyc_auth_tip_line3;
        public String kyc_auth_tip_read_and_agree;
        public String kyc_auth_tip_refuse_no_use;
        public String kyc_auth_tip_use_cam_mic_reason;
        public String kyc_auth_tip_use_cam_reason;
        public String kyc_auth_tip_user_auth;
        public String kyc_dialog_no;
        public String kyc_dialog_text;
        public String kyc_dialog_title;
        public String kyc_dialog_yes;
        public String outOfTime;
        public String recordTime;
        public String recordYTVideo;
        public String returnUserImage;
        public String skipGuideTipVoice;
        public String turingTime;
        public String uploadYTVideo;
        public String useTuringSDK_and;
        public String verifyBackVisibleTime;
        public String willAsrAnswerRetryCount;
        public String willAsrErrorTip;
        public String willAsrNetworkTip;
        public String willAsrShowErrorTipTime;
        public String willAsrShowNetworkTipTime;
        public String willAsrTimeoutInterval;
        public String willAsrTimeoutRetryCount;
        public String willFaceOutCount;
        public String willPoseCount;
        public String willUploadTimeoutInterval;
        public String willVideoBitRateFactor;
        public String willVideoTimeoutInterval;
        public String will_pass_play_volume_check;
        public String will_screenshot;
        public String will_service_answer_no_volume_tip;
        public String will_service_mute_timeout;
        public String will_service_play_audio_lowest_volume;
        public String will_service_play_mode_wait_time_and;
        public String will_service_play_no_volume_tip;
        public String will_service_screenshot_time;
        public String will_service_volume_detect_minlevel_and;
        public String will_service_volume_detect_waittime;
        public String will_service_volume_turnup_level;
        public String ytVideoValidFrames;
    }

    public static void requestExec(String str, WeReq.Callback<GetGradeInfoResponse> callback) {
        WeOkHttp weOkHttp = new WeOkHttp();
        weOkHttp.config().log(d.z().x().O() ? WeLog.Level.BODY : WeLog.Level.NONE, true, false, null, new WeLog.Logger() { // from class: com.tencent.cloud.huiyansdkface.facelight.net.GetCdnGradeInfo.1
            @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeLog.Logger
            public void log(String str2) {
                WLogger.d("GetCdnInfo", str2);
            }
        }).clientConfig().callTimeout(2L, TimeUnit.SECONDS).eventListenerFactory(HttpEventListener.FACTORY);
        weOkHttp.get(str).execute(callback);
    }
}
