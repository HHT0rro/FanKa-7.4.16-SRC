package com.kwad.sdk.core.b.a;

import com.alimm.tanx.core.ad.event.track.expose.ExposeManager;
import com.kwad.sdk.core.track.AdTrackLog;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class at implements com.kwad.sdk.core.d<AdTrackLog> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdTrackLog adTrackLog, JSONObject jSONObject) {
        a2(adTrackLog, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdTrackLog adTrackLog, JSONObject jSONObject) {
        return b2(adTrackLog, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(AdTrackLog adTrackLog, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adTrackLog.templateId = jSONObject.optString(ExposeManager.UtArgsNames.templateId);
        if (JSONObject.NULL.toString().equals(adTrackLog.templateId)) {
            adTrackLog.templateId = "";
        }
        adTrackLog.sceneId = jSONObject.optString("scene_id");
        if (JSONObject.NULL.toString().equals(adTrackLog.sceneId)) {
            adTrackLog.sceneId = "";
        }
        adTrackLog.preLandingPageSwitch = jSONObject.optInt("pre_landing_page_switch");
        adTrackLog.preLandingPageShowType = jSONObject.optInt("pre_landing_page_show_type");
        adTrackLog.adLiveSwitch = jSONObject.optInt("ad_live_switch");
        adTrackLog.adTkLiveSwitch = jSONObject.optInt("ad_tk_live_switch");
        adTrackLog.adLiveComponentReady = jSONObject.optInt("ad_live_component_ready");
        adTrackLog.serverCheckSwitch = jSONObject.optInt("server_check_switch");
        adTrackLog.rewardAdvanceSwitch = jSONObject.optInt("reward_advance_switch");
        adTrackLog.rewardSkipShowTime = jSONObject.optInt("reward_skip_show_time");
        adTrackLog.isPlugin = jSONObject.optInt("is_plugin");
        adTrackLog.apiSdkVersion = jSONObject.optString("api_sdk_version");
        if (JSONObject.NULL.toString().equals(adTrackLog.apiSdkVersion)) {
            adTrackLog.apiSdkVersion = "";
        }
        adTrackLog.rewardDetailStatusBarHeight = jSONObject.optInt("reward_detail_status_bar_height");
        adTrackLog.rewardDetailCallPositionY = jSONObject.optInt("reward_detail_call_position_y");
        adTrackLog.screenOrientation = jSONObject.optInt("screen_orientation");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdTrackLog adTrackLog, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = adTrackLog.templateId;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, ExposeManager.UtArgsNames.templateId, adTrackLog.templateId);
        }
        String str2 = adTrackLog.sceneId;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "scene_id", adTrackLog.sceneId);
        }
        int i10 = adTrackLog.preLandingPageSwitch;
        if (i10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "pre_landing_page_switch", i10);
        }
        int i11 = adTrackLog.preLandingPageShowType;
        if (i11 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "pre_landing_page_show_type", i11);
        }
        int i12 = adTrackLog.adLiveSwitch;
        if (i12 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "ad_live_switch", i12);
        }
        int i13 = adTrackLog.adTkLiveSwitch;
        if (i13 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "ad_tk_live_switch", i13);
        }
        int i14 = adTrackLog.adLiveComponentReady;
        if (i14 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "ad_live_component_ready", i14);
        }
        int i15 = adTrackLog.serverCheckSwitch;
        if (i15 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "server_check_switch", i15);
        }
        int i16 = adTrackLog.rewardAdvanceSwitch;
        if (i16 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "reward_advance_switch", i16);
        }
        int i17 = adTrackLog.rewardSkipShowTime;
        if (i17 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "reward_skip_show_time", i17);
        }
        int i18 = adTrackLog.isPlugin;
        if (i18 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "is_plugin", i18);
        }
        String str3 = adTrackLog.apiSdkVersion;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "api_sdk_version", adTrackLog.apiSdkVersion);
        }
        int i19 = adTrackLog.rewardDetailStatusBarHeight;
        if (i19 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "reward_detail_status_bar_height", i19);
        }
        int i20 = adTrackLog.rewardDetailCallPositionY;
        if (i20 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "reward_detail_call_position_y", i20);
        }
        int i21 = adTrackLog.screenOrientation;
        if (i21 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "screen_orientation", i21);
        }
        return jSONObject;
    }
}
