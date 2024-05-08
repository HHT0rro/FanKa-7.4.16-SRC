package com.bytedance.sdk.openadsdk.mediation.bridge.valueset;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.MediationApiLog;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class MediationAdSlotValueSet {
    public static final String TAG = "TTMediationSDK";
    private ValueSet dk;
    private ValueSet ej;

    /* renamed from: l, reason: collision with root package name */
    private int f11318l;

    /* renamed from: m, reason: collision with root package name */
    private ValueSet f11319m;
    private String np;

    private MediationAdSlotValueSet(ValueSet valueSet) {
        this.f11319m = valueSet;
        ValueSet valueSet2 = (ValueSet) valueSet.objectValue(8090, ValueSet.class);
        if (valueSet2 == null) {
            ValueSet valueSet3 = (ValueSet) this.f11319m.objectValue(8089, ValueSet.class);
            this.dk = valueSet3;
            if (valueSet3 != null) {
                this.ej = (ValueSet) valueSet3.objectValue(8443, ValueSet.class);
            }
        } else {
            ValueSet valueSet4 = (ValueSet) valueSet2.objectValue(8089, ValueSet.class);
            this.dk = valueSet4;
            if (valueSet4 != null) {
                this.ej = (ValueSet) valueSet4.objectValue(8443, ValueSet.class);
            }
        }
        m();
    }

    public static MediationAdSlotValueSet create(ValueSet valueSet) {
        return new MediationAdSlotValueSet(valueSet);
    }

    private boolean dk() {
        ValueSet valueSet = this.f11319m;
        return (valueSet == null || valueSet.isEmpty()) ? false : true;
    }

    private void m() {
        MediationApiLog.i("---------  sdk MediationAdSlotValueSet start ----");
        MediationApiLog.i("getAdLoaderCallback：" + ((Object) getAdLoaderCallback()));
        MediationApiLog.i("getADNId：" + getADNId());
        MediationApiLog.i("getRitId：" + getRitId());
        MediationApiLog.i("getUserId：" + getUserId());
        MediationApiLog.i("getAdCount：" + getAdCount());
        MediationApiLog.i("getWidth：" + getWidth());
        MediationApiLog.i("getHeight：" + getHeight());
        MediationApiLog.i("getExpressWidth：" + getExpressWidth());
        MediationApiLog.i("getExpressHeight：" + getExpressHeight());
        MediationApiLog.i("isMuted：" + isMuted());
        MediationApiLog.i("isSplashShakeButton：" + isSplashShakeButton());
        MediationApiLog.i("isSplashPreLoad：" + isSplashPreLoad());
        MediationApiLog.i("getVolume：" + getVolume());
        MediationApiLog.i("isUseSurfaceView：" + isUseSurfaceView());
        MediationApiLog.i("getExtraObject：" + ((Object) getExtraObject()));
        MediationApiLog.i("isBidNotify：" + isBidNotify());
        MediationApiLog.i("getScenarioId：" + getScenarioId());
        MediationApiLog.i("getRewardName：" + getRewardName());
        MediationApiLog.i("getRewardAmount：" + getRewardAmount());
        MediationApiLog.i("isAllowShowCloseBtn：" + isAllowShowCloseBtn());
        MediationApiLog.i("isExpress：" + isExpress());
        MediationApiLog.i("getOrientation：" + getOrientation());
        MediationApiLog.i("getContentUrl：" + getContentUrl());
        MediationApiLog.i("getDevices：" + getDevices());
        MediationApiLog.i("getOriginType：" + getOriginType());
        MediationApiLog.i("getAdSubType：" + getAdSubType());
        MediationApiLog.i("getAdmobNativeAdOptions：" + getAdmobNativeAdOptions());
        MediationApiLog.i("getBaiduAppSid：" + getBaiduAppSid());
        MediationApiLog.i("getBaiduDownloadAppConfirmPolicy：" + getBaiduDownloadAppConfirmPolicy());
        MediationApiLog.i("getBaiduUseRewardCountdown：" + getBaiduUseRewardCountdown());
        MediationApiLog.i("getBaiduShowDialogOnSkip：" + getBaiduShowDialogOnSkip());
        MediationApiLog.i("getBaiduCacheVideoOnlyWifi：" + getBaiduCacheVideoOnlyWifi());
        MediationApiLog.i("getBaiduRequestParameters：" + getBaiduRequestParameters());
        MediationApiLog.i("getBaiduNativeSmartOptStyleParams：" + getBaiduNativeSmartOptStyleParams());
        MediationApiLog.i("getGdtMinVideoDuration：" + getGdtMinVideoDuration());
        MediationApiLog.i("getGdtMaxVideoDuration：" + getGdtMaxVideoDuration());
        MediationApiLog.i("getGdtVideoOption：" + getGdtVideoOption());
        MediationApiLog.i("getGdtDownAPPConfirmPolicy：" + getGdtDownAPPConfirmPolicy());
        MediationApiLog.i("getGdtNativeLogoParams：" + getGdtNativeLogoParams());
        MediationApiLog.i("getAdLoadTimeOut：" + getAdLoadTimeOut());
        MediationApiLog.i("getShakeViewWidth：" + getShakeViewWidth());
        MediationApiLog.i("getShakeViewHeight：" + getShakeViewHeight());
        MediationApiLog.i("getAdloadSeq：" + getAdloadSeq());
        MediationApiLog.i("getAdUnitId：" + getAdUnitId());
        MediationApiLog.i("isSupportDeepLink：" + isSupportDeepLink());
        MediationApiLog.i("getParams：" + ((Object) getParams()));
        MediationApiLog.i("---------  初始化adn sdk MediationAdSlotValueSet end ----");
    }

    public String getADNId() {
        if (dk()) {
            return this.f11319m.stringValue(8007);
        }
        return null;
    }

    public int getAdCount() {
        ValueSet valueSet = this.dk;
        if (valueSet != null) {
            return valueSet.intValue(13);
        }
        return 1;
    }

    public int getAdLoadTimeOut() {
        ValueSet valueSet = this.dk;
        if (valueSet != null) {
            return valueSet.intValue(17, 3000);
        }
        return 3000;
    }

    public Bridge getAdLoaderCallback() {
        if (dk()) {
            return (Bridge) this.f11319m.objectValue(8011, Bridge.class);
        }
        return null;
    }

    public int getAdSubType() {
        if (dk()) {
            return this.f11319m.intValue(8094);
        }
        return 0;
    }

    public String getAdUnitId() {
        return this.np;
    }

    public int getAdloadSeq() {
        int i10 = this.f11318l;
        if (i10 != 0) {
            return i10;
        }
        if (dk()) {
            return this.f11319m.intValue(20);
        }
        return 0;
    }

    public Object getAdmobNativeAdOptions() {
        Map<String, Object> extraObject = getExtraObject();
        if (extraObject != null) {
            return extraObject.get(MediationConstant.KEY_ADMOB_NATIVE_OPTIONS);
        }
        return null;
    }

    public String getBaiduAppSid() {
        Map<String, Object> extraObject = getExtraObject();
        if (extraObject == null) {
            return "";
        }
        Object obj = extraObject.get(MediationConstant.KEY_BAIDU_APPSID);
        return obj instanceof String ? (String) obj : "";
    }

    public boolean getBaiduCacheVideoOnlyWifi() {
        Map<String, Object> extraObject = getExtraObject();
        if (extraObject == null) {
            return false;
        }
        Object obj = extraObject.get(MediationConstant.KEY_BAIDU_CACHE_VIDEO_ONLY_WIFI);
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        return false;
    }

    public int getBaiduDownloadAppConfirmPolicy() {
        Map<String, Object> extraObject = getExtraObject();
        if (extraObject == null) {
            return 0;
        }
        Object obj = extraObject.get(MediationConstant.KEY_BAIDU_DOWN_APP_CONFIG_POLICY);
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        return 0;
    }

    public Object getBaiduNativeSmartOptStyleParams() {
        Map<String, Object> extraObject = getExtraObject();
        if (extraObject != null) {
            return extraObject.get(MediationConstant.KEY_BAIDU_NATIVE_SMART_OPT_STYLE_PARAMS);
        }
        return null;
    }

    public Object getBaiduRequestParameters() {
        Map<String, Object> extraObject = getExtraObject();
        if (extraObject != null) {
            return extraObject.get(MediationConstant.KEY_BAIDU_REQUEST_PARAMETERS);
        }
        return null;
    }

    public boolean getBaiduShowDialogOnSkip() {
        Map<String, Object> extraObject = getExtraObject();
        if (extraObject == null) {
            return false;
        }
        Object obj = extraObject.get(MediationConstant.KEY_BAIDU_SHOW_DIALOG_ON_SKIP);
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        return false;
    }

    public boolean getBaiduUseRewardCountdown() {
        Map<String, Object> extraObject = getExtraObject();
        if (extraObject == null) {
            return false;
        }
        Object obj = extraObject.get(MediationConstant.KEY_BAIDU_USE_REWARD_COUNTDOWN);
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        return false;
    }

    public String getClientReqId() {
        return dk() ? this.f11319m.stringValue(8430) : "";
    }

    public String getContentUrl() {
        return dk() ? this.f11319m.stringValue(8083) : "";
    }

    public String getDevices() {
        return dk() ? this.f11319m.stringValue(8084) : "";
    }

    public float getExpressHeight() {
        ValueSet valueSet = this.dk;
        if (valueSet != null) {
            return valueSet.floatValue(9);
        }
        return 0.0f;
    }

    public float getExpressWidth() {
        ValueSet valueSet = this.dk;
        if (valueSet != null) {
            return valueSet.floatValue(10);
        }
        return 0.0f;
    }

    public Map<String, Object> getExtraObject() {
        ValueSet valueSet = this.ej;
        if (valueSet != null) {
            return (Map) valueSet.objectValue(8449, Map.class);
        }
        return null;
    }

    public Object getGdtDownAPPConfirmPolicy() {
        Map<String, Object> extraObject = getExtraObject();
        if (extraObject != null) {
            return extraObject.get(MediationConstant.KEY_GDT_DOWN_APP_CONFIG_POLICY);
        }
        return null;
    }

    public int getGdtMaxVideoDuration() {
        Map<String, Object> extraObject = getExtraObject();
        if (extraObject == null) {
            return 0;
        }
        Object obj = extraObject.get(MediationConstant.KEY_GDT_MAX_VIDEO_DURATION);
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        return 0;
    }

    public int getGdtMinVideoDuration() {
        Map<String, Object> extraObject = getExtraObject();
        if (extraObject == null) {
            return 0;
        }
        Object obj = extraObject.get(MediationConstant.KEY_GDT_MIN_VIDEO_DURATION);
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        return 0;
    }

    public Object getGdtNativeLogoParams() {
        Map<String, Object> extraObject = getExtraObject();
        if (extraObject != null) {
            return extraObject.get(MediationConstant.KEY_GDT_NATIVE_LOGO_PARAMS);
        }
        return null;
    }

    public Object getGdtVideoOption() {
        Map<String, Object> extraObject = getExtraObject();
        if (extraObject != null) {
            return extraObject.get(MediationConstant.KEY_GDT_VIDEO_OPTION);
        }
        return null;
    }

    public int getHeight() {
        ValueSet valueSet = this.dk;
        if (valueSet != null) {
            return valueSet.intValue(8);
        }
        return 0;
    }

    public int getOrientation() {
        ValueSet valueSet = this.dk;
        if (valueSet != null) {
            return valueSet.intValue(16);
        }
        return 2;
    }

    public int getOriginType() {
        if (dk()) {
            return this.f11319m.intValue(8085);
        }
        return 0;
    }

    public Map<String, Object> getParams() {
        return dk() ? (Map) this.f11319m.objectValue(8044, Map.class) : new HashMap();
    }

    public int getRewardAmount() {
        ValueSet valueSet = this.ej;
        if (valueSet != null) {
            return valueSet.intValue(8453);
        }
        return 0;
    }

    public String getRewardName() {
        ValueSet valueSet = this.ej;
        return valueSet != null ? valueSet.stringValue(8452) : "";
    }

    public String getRitId() {
        if (dk()) {
            return this.f11319m.stringValue(4);
        }
        return null;
    }

    public String getScenarioId() {
        ValueSet valueSet = this.ej;
        return valueSet != null ? valueSet.stringValue(8451) : "";
    }

    public float getShakeViewHeight() {
        ValueSet valueSet = this.ej;
        if (valueSet != null) {
            return valueSet.floatValue(8456);
        }
        return 0.0f;
    }

    public float getShakeViewWidth() {
        ValueSet valueSet = this.ej;
        if (valueSet != null) {
            return valueSet.floatValue(8455);
        }
        return 0.0f;
    }

    public String getUserId() {
        ValueSet valueSet = this.dk;
        return valueSet != null ? valueSet.stringValue(15) : "";
    }

    public float getVolume() {
        ValueSet valueSet = this.ej;
        if (valueSet != null) {
            return valueSet.floatValue(8447);
        }
        return 1.0f;
    }

    public String getWaterfallABTest() {
        return dk() ? this.f11319m.stringValue(8429) : "";
    }

    public int getWidth() {
        ValueSet valueSet = this.dk;
        if (valueSet != null) {
            return valueSet.intValue(7);
        }
        return 0;
    }

    public boolean isAllowShowCloseBtn() {
        ValueSet valueSet = this.ej;
        if (valueSet != null) {
            return valueSet.booleanValue(8454);
        }
        return false;
    }

    public boolean isBidNotify() {
        ValueSet valueSet = this.ej;
        if (valueSet != null) {
            return valueSet.booleanValue(8450);
        }
        return false;
    }

    public boolean isExpress() {
        return dk() && this.f11319m.booleanValue(8033);
    }

    public boolean isMuted() {
        ValueSet valueSet = this.ej;
        if (valueSet != null) {
            return valueSet.booleanValue(8444);
        }
        return false;
    }

    public boolean isSplashPreLoad() {
        ValueSet valueSet = this.ej;
        if (valueSet != null) {
            return valueSet.booleanValue(8446);
        }
        return false;
    }

    public boolean isSplashShakeButton() {
        ValueSet valueSet = this.ej;
        if (valueSet != null) {
            return valueSet.booleanValue(8445);
        }
        return false;
    }

    public boolean isSupportDeepLink() {
        if (dk()) {
            return this.f11319m.booleanValue(11);
        }
        return false;
    }

    public boolean isUseSurfaceView() {
        ValueSet valueSet = this.ej;
        if (valueSet != null) {
            return valueSet.booleanValue(8448);
        }
        return false;
    }

    public void setAdUnitId(String str) {
        this.np = str;
    }

    public void setAdloadSeq(int i10) {
        this.f11318l = i10;
    }
}
