package com.bytedance.sdk.openadsdk.mediation.bridge.valueset;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.MediationApiLog;
import com.bytedance.sdk.openadsdk.mediation.bridge.IMediationLocation;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationCustomController;
import com.bytedance.sdk.openadsdk.mediation.custom.MediationCustomInitConfig;
import com.huawei.hms.support.api.entity.core.JosStatusCodes;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class MediationInitConfig {
    private ValueSet dk;
    private ValueSet ej;

    /* renamed from: m, reason: collision with root package name */
    private ValueSet f11320m;

    private MediationInitConfig(ValueSet valueSet) {
        this.f11320m = valueSet;
        if (valueSet != null) {
            this.ej = (ValueSet) valueSet.objectValue(8457, ValueSet.class);
            this.dk = (ValueSet) this.f11320m.objectValue(8475, ValueSet.class);
        }
        m();
    }

    public static MediationInitConfig create(ValueSet valueSet) {
        return new MediationInitConfig(valueSet);
    }

    private void ej() {
        MediationApiLog.i("---------  sdk 初始化信息 start ----");
        MediationApiLog.i("isDebug：" + isDebug());
        MediationApiLog.i("getClassName：" + getClassName());
        MediationApiLog.i("getAppId：" + getAppId());
        MediationApiLog.i("getAppName：" + getAppName());
        MediationApiLog.i("getADNName：" + getADNName());
        MediationApiLog.i("getAppKey：" + getAppKey());
        MediationApiLog.i("getInitCallback：" + ((Object) getInitCallback()));
        MediationApiLog.i("getAgeGroup：" + getAgeGroup());
        MediationApiLog.i("isCustom：" + isCustom());
        MediationApiLog.i("getCustomInitConfig：" + ((Object) getCustomInitConfig()));
        MediationApiLog.i("getCustomInitMap：" + ((Object) getCustomInitMap()));
        MediationApiLog.i("getCustomGMConfiguration：" + ((Object) getCustomGMConfiguration()));
        MediationApiLog.i("getKsAdapterVersion：" + getKsAdapterVersion());
        MediationApiLog.i("getGromoreVersion：" + getGromoreVersion());
        MediationApiLog.i("getAdmobAdapterVersion：" + getAdmobAdapterVersion());
        MediationApiLog.i("getBaiduAdapterVersion：" + getBaiduAdapterVersion());
        MediationApiLog.i("getGdtAdapterVersion：" + getGdtAdapterVersion());
        MediationApiLog.i("getKlevinAdapterVersion：" + getKlevinAdapterVersion());
        MediationApiLog.i("getMintegralAdapterVersion：" + getMintegralAdapterVersion());
        MediationApiLog.i("getSigmobAdapterVersion：" + getSigmobAdapterVersion());
        MediationApiLog.i("getUnityAdapterVersion：" + getUnityAdapterVersion());
        MediationApiLog.i("getMap：" + ((Object) getInitAdnMap()));
        MediationApiLog.i("---------  sdk 初始化信息 end ----");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public double hc() {
        Bridge bridge;
        ValueSet values;
        ValueSet valueSet = this.dk;
        if (valueSet == null || (bridge = (Bridge) valueSet.objectValue(8312, Bridge.class)) == null || (values = bridge.values()) == null) {
            return -1.0d;
        }
        return values.doubleValue(8482);
    }

    private void l() {
        MediationApiLog.i("---------  sdk 隐私设置 start ----");
        MediationApiLog.i("isCanUseLocation：" + isCanUseLocation());
        IMediationLocation location = getLocation();
        MediationApiLog.i("getLocation：" + ((Object) location));
        if (location != null) {
            MediationApiLog.i("getLocation getLatitude：" + location.getLatitude());
            MediationApiLog.i("getLocation getLongitude：" + location.getLongitude());
        }
        MediationApiLog.i("appList：" + appList());
        MediationApiLog.i("isCanUsePhoneState：" + isCanUsePhoneState());
        MediationApiLog.i("isLimitPersonalAds：" + isLimitPersonalAds());
        MediationApiLog.i("getDevImei：" + getDevImei());
        MediationApiLog.i("isCanUseWifiState：" + isCanUseWifiState());
        MediationApiLog.i("getMacAddress：" + getMacAddress());
        MediationApiLog.i("isCanUseWriteExternal：" + isCanUseWriteExternal());
        MediationApiLog.i("isCanUseAndroidId：" + isCanUseAndroidId());
        MediationApiLog.i("getAndroidId：" + getAndroidId());
        List<String> appList = getAppList();
        MediationApiLog.i("getAppList：" + ((Object) appList));
        if (appList != null) {
            Iterator<String> iterator2 = appList.iterator2();
            while (iterator2.hasNext()) {
                MediationApiLog.i("getAppList item: " + iterator2.next());
            }
        }
        List<String> devImeis = getDevImeis();
        MediationApiLog.i("getDevImeis：" + ((Object) devImeis));
        if (devImeis != null) {
            Iterator<String> iterator22 = devImeis.iterator2();
            while (iterator22.hasNext()) {
                MediationApiLog.i("getDevImeis item: " + iterator22.next());
            }
        }
        MediationApiLog.i("getDevOaid：" + getDevOaid());
        MediationApiLog.i("isCanUseOaid：" + isCanUseOaid());
        MediationApiLog.i("isCanUseMacAddress：" + isCanUseMacAddress());
        MediationApiLog.i("isProgrammaticRecommend：" + isProgrammaticRecommend());
        MediationApiLog.i("isCanUsePermissionRecordAudio：" + isCanUsePermissionRecordAudio());
        MediationApiLog.i("---------  sdk 隐私设置 end ----");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public double n() {
        Bridge bridge;
        ValueSet values;
        ValueSet valueSet = this.dk;
        if (valueSet == null || (bridge = (Bridge) valueSet.objectValue(8312, Bridge.class)) == null || (values = bridge.values()) == null) {
            return -1.0d;
        }
        return values.doubleValue(8481);
    }

    private boolean np() {
        ValueSet valueSet = this.f11320m;
        return (valueSet == null || valueSet.isEmpty()) ? false : true;
    }

    public boolean appList() {
        ValueSet valueSet = this.dk;
        if (valueSet != null) {
            return valueSet.booleanValue(8026);
        }
        return true;
    }

    public String getADNName() {
        return np() ? this.f11320m.stringValue(8003) : "";
    }

    public String getAdmobAdapterVersion() {
        ValueSet valueSet = this.f11320m;
        return valueSet != null ? valueSet.stringValue(8412) : "";
    }

    public int getAgeGroup() {
        if (np()) {
            return this.f11320m.intValue(7);
        }
        return 0;
    }

    public String getAndroidId() {
        ValueSet valueSet = this.dk;
        return valueSet != null ? valueSet.stringValue(8485) : "";
    }

    public String getAppId() {
        if (np()) {
            return this.f11320m.stringValue(3);
        }
        return null;
    }

    public String getAppKey() {
        return np() ? this.f11320m.stringValue(8005) : "";
    }

    public List<String> getAppList() {
        Bridge bridge;
        ValueSet values;
        ValueSet valueSet = this.dk;
        if (valueSet != null && (bridge = (Bridge) valueSet.objectValue(8311, Bridge.class)) != null && (values = bridge.values()) != null) {
            return (List) values.objectValue(8476, List.class);
        }
        return new LinkedList();
    }

    public String getAppName() {
        return np() ? this.f11320m.stringValue(8) : "";
    }

    public String getBaiduAdapterVersion() {
        ValueSet valueSet = this.f11320m;
        return valueSet != null ? valueSet.stringValue(8413) : "";
    }

    public String getClassName() {
        return np() ? this.f11320m.stringValue(8010) : "";
    }

    public Bridge getCustomGMConfiguration() {
        if (np()) {
            return (Bridge) this.f11320m.objectValue(8401, Bridge.class);
        }
        return null;
    }

    public MediationCustomInitConfig getCustomInitConfig() {
        if (np()) {
            return (MediationCustomInitConfig) this.f11320m.objectValue(8099, MediationCustomInitConfig.class);
        }
        return null;
    }

    public ValueSet getCustomInitConfigValueSet() {
        if (np()) {
            return (ValueSet) this.f11320m.objectValue(8545, ValueSet.class);
        }
        return null;
    }

    public Map getCustomInitMap() {
        if (np()) {
            return (Map) this.f11320m.objectValue(8400, Map.class);
        }
        return null;
    }

    public JSONObject getCustomLocalConfig() {
        ValueSet valueSet = this.ej;
        if (valueSet != null) {
            return (JSONObject) valueSet.objectValue(8463, JSONObject.class);
        }
        return null;
    }

    public String getDevImei() {
        ValueSet valueSet = this.dk;
        return valueSet != null ? valueSet.stringValue(8484) : "";
    }

    public List<String> getDevImeis() {
        Bridge bridge;
        ValueSet values;
        ValueSet valueSet = this.dk;
        if (valueSet != null && (bridge = (Bridge) valueSet.objectValue(8311, Bridge.class)) != null && (values = bridge.values()) != null) {
            return (List) values.objectValue(8477, List.class);
        }
        return new LinkedList();
    }

    public String getDevOaid() {
        ValueSet valueSet = this.dk;
        return valueSet != null ? valueSet.stringValue(8486) : "";
    }

    public String getGdtAdapterVersion() {
        ValueSet valueSet = this.f11320m;
        return valueSet != null ? valueSet.stringValue(8414) : "";
    }

    public String getGromoreVersion() {
        ValueSet valueSet = this.f11320m;
        return valueSet != null ? valueSet.stringValue(8411) : "";
    }

    public boolean getHttps() {
        ValueSet valueSet = this.ej;
        if (valueSet != null) {
            return valueSet.booleanValue(8458);
        }
        return false;
    }

    public Map getInitAdnMap() {
        ValueSet valueSet = this.f11320m;
        if (valueSet != null) {
            return (Map) valueSet.objectValue(8425, Map.class);
        }
        return new HashMap();
    }

    public Bridge getInitCallback() {
        if (np()) {
            return (Bridge) this.f11320m.objectValue(JosStatusCodes.RNT_CODE_NETWORK_ERROR, Bridge.class);
        }
        return null;
    }

    public String getKlevinAdapterVersion() {
        ValueSet valueSet = this.f11320m;
        return valueSet != null ? valueSet.stringValue(8415) : "";
    }

    public String getKsAdapterVersion() {
        ValueSet valueSet = this.f11320m;
        return valueSet != null ? valueSet.stringValue(8410) : "";
    }

    public Map getLocalExtra() {
        ValueSet valueSet = this.ej;
        if (valueSet != null) {
            return (Map) valueSet.objectValue(8462, Map.class);
        }
        return new HashMap();
    }

    public IMediationLocation getLocation() {
        if (n() == -1.0d || n() == -1.0d) {
            return null;
        }
        return new IMediationLocation() { // from class: com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationInitConfig.1
            @Override // com.bytedance.sdk.openadsdk.mediation.bridge.IMediationLocation
            public double getLatitude() {
                return MediationInitConfig.this.n();
            }

            @Override // com.bytedance.sdk.openadsdk.mediation.bridge.IMediationLocation
            public double getLongitude() {
                return MediationInitConfig.this.hc();
            }
        };
    }

    public String getMacAddress() {
        ValueSet valueSet = this.dk;
        return valueSet != null ? valueSet.stringValue(8487) : "";
    }

    public Bridge getMediationConfigUserInfoForSegment() {
        ValueSet valueSet = this.ej;
        if (valueSet != null) {
            return (Bridge) valueSet.objectValue(8310, Bridge.class);
        }
        return null;
    }

    public String getMintegralAdapterVersion() {
        ValueSet valueSet = this.f11320m;
        return valueSet != null ? valueSet.stringValue(8416) : "";
    }

    public String getOpensdkVer() {
        ValueSet valueSet = this.ej;
        return valueSet != null ? valueSet.stringValue(8464) : "";
    }

    public String getPublisherDid() {
        ValueSet valueSet = this.ej;
        return valueSet != null ? valueSet.stringValue(8460) : "";
    }

    public String getSigmobAdapterVersion() {
        ValueSet valueSet = this.f11320m;
        return valueSet != null ? valueSet.stringValue(8417) : "";
    }

    public String getUnityAdapterVersion() {
        ValueSet valueSet = this.f11320m;
        return valueSet != null ? valueSet.stringValue(8418) : "";
    }

    public ValueSet getValueSet() {
        return this.f11320m;
    }

    public String getWxAppId() {
        ValueSet valueSet = this.ej;
        return valueSet != null ? valueSet.stringValue(8459) : "";
    }

    public boolean isCanUseAndroidId() {
        ValueSet valueSet = this.dk;
        if (valueSet != null) {
            return valueSet.booleanValue(8479);
        }
        return true;
    }

    public boolean isCanUseLocation() {
        ValueSet valueSet = this.dk;
        if (valueSet != null) {
            return valueSet.booleanValue(8024);
        }
        return true;
    }

    public boolean isCanUseMacAddress() {
        return isCanUseWifiState();
    }

    public boolean isCanUseOaid() {
        Bridge bridge;
        ValueSet values;
        ValueSet valueSet = this.dk;
        if (valueSet == null || (bridge = (Bridge) valueSet.objectValue(8311, Bridge.class)) == null || (values = bridge.values()) == null) {
            return true;
        }
        return values.booleanValue(8478);
    }

    public boolean isCanUsePermissionRecordAudio() {
        ValueSet valueSet = this.dk;
        if (valueSet != null) {
            return valueSet.booleanValue(8549);
        }
        return true;
    }

    public boolean isCanUsePhoneState() {
        ValueSet valueSet = this.dk;
        if (valueSet != null) {
            return valueSet.booleanValue(8023);
        }
        return true;
    }

    public boolean isCanUseWifiState() {
        ValueSet valueSet = this.dk;
        if (valueSet != null) {
            return valueSet.booleanValue(8480);
        }
        return true;
    }

    public boolean isCanUseWriteExternal() {
        ValueSet valueSet = this.dk;
        if (valueSet != null) {
            return valueSet.booleanValue(8025);
        }
        return true;
    }

    public boolean isCustom() {
        if (np()) {
            return this.f11320m.booleanValue(8098);
        }
        return false;
    }

    public boolean isDebug() {
        ValueSet valueSet = this.f11320m;
        if (valueSet != null) {
            return valueSet.booleanValue(1);
        }
        return false;
    }

    public boolean isLimitPersonalAds() {
        Bridge bridge;
        ValueSet values;
        ValueSet valueSet = this.dk;
        if (valueSet == null || (bridge = (Bridge) valueSet.objectValue(8311, Bridge.class)) == null || (values = bridge.values()) == null) {
            return false;
        }
        return values.booleanValue(8027);
    }

    public boolean isOpenAdnTest() {
        ValueSet valueSet = this.ej;
        if (valueSet != null) {
            return valueSet.booleanValue(8461);
        }
        return false;
    }

    public boolean isProgrammaticRecommend() {
        Bridge bridge;
        ValueSet values;
        ValueSet valueSet = this.dk;
        if (valueSet == null || (bridge = (Bridge) valueSet.objectValue(8311, Bridge.class)) == null || (values = bridge.values()) == null) {
            return false;
        }
        return values.booleanValue(8028);
    }

    public boolean isSupportH265() {
        ValueSet valueSet = this.ej;
        if (valueSet != null) {
            return valueSet.booleanValue(8466);
        }
        return false;
    }

    public boolean isSupportSplashZoomout() {
        ValueSet valueSet = this.ej;
        if (valueSet != null) {
            return valueSet.booleanValue(8467);
        }
        return false;
    }

    public boolean isWxInstalled() {
        ValueSet valueSet = this.ej;
        if (valueSet != null) {
            return valueSet.booleanValue(8465);
        }
        return false;
    }

    public void setMediationCustomController(MediationCustomController mediationCustomController) {
        this.dk = MediationInitUtil.getMediationCustomController(mediationCustomController);
        l();
    }

    public void setMediationCustomControllerValueSet(ValueSet valueSet) {
        this.dk = valueSet;
        l();
    }

    private void dk() {
        MediationApiLog.i("---------  sdk 聚合信息 start ----");
        MediationApiLog.i("getHttps：" + getHttps());
        MediationApiLog.i("getWxAppId：" + getWxAppId());
        MediationApiLog.i("getPublisherDid：" + getPublisherDid());
        MediationApiLog.i("isOpenAdnTest：" + isOpenAdnTest());
        MediationApiLog.i("getMediationConfigUserInfoForSegment：" + ((Object) getMediationConfigUserInfoForSegment()));
        MediationApiLog.i("getLocalExtra：" + ((Object) getLocalExtra()));
        MediationApiLog.i("getCustomLocalConfig：" + ((Object) getCustomLocalConfig()));
        MediationApiLog.i("getOpensdkVer：" + getOpensdkVer());
        MediationApiLog.i("isWxInstalled：" + isWxInstalled());
        MediationApiLog.i("isSupportH265：" + isSupportH265());
        MediationApiLog.i("isSupportSplashZoomout：" + isSupportSplashZoomout());
        MediationApiLog.i("---------  sdk 聚合信息 end ----");
    }

    private void m() {
        MediationApiLog.setDebug(Boolean.valueOf(isDebug()));
        ej();
        l();
        dk();
    }
}
