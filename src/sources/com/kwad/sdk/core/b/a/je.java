package com.kwad.sdk.core.b.a;

import com.alimm.tanx.core.ad.event.track.expose.ExposeManager;
import com.kwad.components.ad.splashscreen.monitor.SplashMonitorInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class je implements com.kwad.sdk.core.d<SplashMonitorInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(SplashMonitorInfo splashMonitorInfo, JSONObject jSONObject) {
        a2(splashMonitorInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(SplashMonitorInfo splashMonitorInfo, JSONObject jSONObject) {
        return b2(splashMonitorInfo, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(SplashMonitorInfo splashMonitorInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        splashMonitorInfo.status = jSONObject.optInt("status");
        splashMonitorInfo.type = jSONObject.optInt("type");
        splashMonitorInfo.preloadId = jSONObject.optString("preload_id");
        if (JSONObject.NULL.toString().equals(splashMonitorInfo.preloadId)) {
            splashMonitorInfo.preloadId = "";
        }
        splashMonitorInfo.checkStatus = jSONObject.optInt("check_status");
        splashMonitorInfo.loadDataTime = jSONObject.optLong("load_data_duration_ms");
        splashMonitorInfo.beforeLoadDataTime = jSONObject.optLong("before_load_data_duration_ms");
        splashMonitorInfo.checkDataTime = jSONObject.optLong("check_data_duration_ms");
        splashMonitorInfo.loadAndCheckDataTime = jSONObject.optLong("load_and_check_data_duration_ms");
        splashMonitorInfo.costTime = jSONObject.optLong("duration_ms");
        splashMonitorInfo.ids = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("ids");
        if (optJSONArray != null) {
            for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
                splashMonitorInfo.ids.add((String) optJSONArray.opt(i10));
            }
        }
        splashMonitorInfo.count = jSONObject.optInt("count");
        splashMonitorInfo.cacheValidTime = jSONObject.optLong("validity_period_ms");
        splashMonitorInfo.size = jSONObject.optLong("size");
        splashMonitorInfo.url = jSONObject.optString("url");
        if (JSONObject.NULL.toString().equals(splashMonitorInfo.url)) {
            splashMonitorInfo.url = "";
        }
        splashMonitorInfo.creativeId = jSONObject.optLong(ExposeManager.UtArgsNames.creativeId);
        splashMonitorInfo.materialType = jSONObject.optInt("material_type");
        splashMonitorInfo.totalCount = jSONObject.optInt("total_count");
        splashMonitorInfo.creativeIds = new ArrayList();
        JSONArray optJSONArray2 = jSONObject.optJSONArray("creative_ids");
        if (optJSONArray2 != null) {
            for (int i11 = 0; i11 < optJSONArray2.length(); i11++) {
                splashMonitorInfo.creativeIds.add((String) optJSONArray2.opt(i11));
            }
        }
        splashMonitorInfo.preloadIds = new ArrayList();
        JSONArray optJSONArray3 = jSONObject.optJSONArray("preload_ids");
        if (optJSONArray3 != null) {
            for (int i12 = 0; i12 < optJSONArray3.length(); i12++) {
                splashMonitorInfo.preloadIds.add((String) optJSONArray3.opt(i12));
            }
        }
        splashMonitorInfo.posId = jSONObject.optLong("pos_Id");
        splashMonitorInfo.viewSource = jSONObject.optInt("view_source");
        splashMonitorInfo.elementTypes = new ArrayList();
        JSONArray optJSONArray4 = jSONObject.optJSONArray("element_types");
        if (optJSONArray4 != null) {
            for (int i13 = 0; i13 < optJSONArray4.length(); i13++) {
                splashMonitorInfo.elementTypes.add((Integer) optJSONArray4.opt(i13));
            }
        }
        splashMonitorInfo.interactiveStyle = jSONObject.optString("interactive_style");
        if (JSONObject.NULL.toString().equals(splashMonitorInfo.interactiveStyle)) {
            splashMonitorInfo.interactiveStyle = "";
        }
        splashMonitorInfo.interactivityDefaultStyle = jSONObject.optString("interactivity_default_style");
        if (JSONObject.NULL.toString().equals(splashMonitorInfo.interactivityDefaultStyle)) {
            splashMonitorInfo.interactivityDefaultStyle = "";
        }
        splashMonitorInfo.showEndTime = jSONObject.optLong("show_end_time");
        splashMonitorInfo.isRotateComposeTimeout = jSONObject.optBoolean("is_rotate_compose_timeout");
        splashMonitorInfo.tkDefaultTimeout = jSONObject.optLong("tk_default_timeout");
        splashMonitorInfo.soSource = jSONObject.optInt("so_source");
        splashMonitorInfo.soLoadTime = jSONObject.optLong("so_load_time");
        splashMonitorInfo.offlineSource = jSONObject.optInt("offline_source");
        splashMonitorInfo.offlineLoadTime = jSONObject.optLong("offline_load_time");
        splashMonitorInfo.tkFileLoadTime = jSONObject.optLong("tk_file_load_time");
        splashMonitorInfo.tkInitTime = jSONObject.optLong("tk_init_time");
        splashMonitorInfo.tkRenderTime = jSONObject.optLong("tk_render_time");
        splashMonitorInfo.nativeLoadTime = jSONObject.optLong("native_load_time");
        splashMonitorInfo.isWebTimeout = jSONObject.optBoolean("is_web_timeout");
        splashMonitorInfo.webLoadTime = jSONObject.optLong("web_load_time");
        splashMonitorInfo.templateId = jSONObject.optString(ExposeManager.UtArgsNames.templateId);
        if (JSONObject.NULL.toString().equals(splashMonitorInfo.templateId)) {
            splashMonitorInfo.templateId = "";
        }
        splashMonitorInfo.templateVersionCode = jSONObject.optInt("template_version_code");
        splashMonitorInfo.tkTotalTime = jSONObject.optLong("tk_total_time");
        splashMonitorInfo.actionType = jSONObject.optInt("action_type");
        splashMonitorInfo.callbackType = jSONObject.optInt("callback_type");
        splashMonitorInfo.tkRenderType = jSONObject.optLong("tk_render_type");
        splashMonitorInfo.loadProcessType = jSONObject.optLong("load_process_type");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(SplashMonitorInfo splashMonitorInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i10 = splashMonitorInfo.status;
        if (i10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "status", i10);
        }
        int i11 = splashMonitorInfo.type;
        if (i11 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "type", i11);
        }
        String str = splashMonitorInfo.preloadId;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "preload_id", splashMonitorInfo.preloadId);
        }
        int i12 = splashMonitorInfo.checkStatus;
        if (i12 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "check_status", i12);
        }
        long j10 = splashMonitorInfo.loadDataTime;
        if (j10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "load_data_duration_ms", j10);
        }
        long j11 = splashMonitorInfo.beforeLoadDataTime;
        if (j11 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "before_load_data_duration_ms", j11);
        }
        long j12 = splashMonitorInfo.checkDataTime;
        if (j12 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "check_data_duration_ms", j12);
        }
        long j13 = splashMonitorInfo.loadAndCheckDataTime;
        if (j13 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "load_and_check_data_duration_ms", j13);
        }
        long j14 = splashMonitorInfo.costTime;
        if (j14 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "duration_ms", j14);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "ids", splashMonitorInfo.ids);
        int i13 = splashMonitorInfo.count;
        if (i13 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "count", i13);
        }
        long j15 = splashMonitorInfo.cacheValidTime;
        if (j15 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "validity_period_ms", j15);
        }
        long j16 = splashMonitorInfo.size;
        if (j16 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "size", j16);
        }
        String str2 = splashMonitorInfo.url;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "url", splashMonitorInfo.url);
        }
        long j17 = splashMonitorInfo.creativeId;
        if (j17 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, ExposeManager.UtArgsNames.creativeId, j17);
        }
        int i14 = splashMonitorInfo.materialType;
        if (i14 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "material_type", i14);
        }
        int i15 = splashMonitorInfo.totalCount;
        if (i15 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "total_count", i15);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "creative_ids", splashMonitorInfo.creativeIds);
        com.kwad.sdk.utils.t.putValue(jSONObject, "preload_ids", splashMonitorInfo.preloadIds);
        long j18 = splashMonitorInfo.posId;
        if (j18 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "pos_Id", j18);
        }
        int i16 = splashMonitorInfo.viewSource;
        if (i16 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "view_source", i16);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "element_types", splashMonitorInfo.elementTypes);
        String str3 = splashMonitorInfo.interactiveStyle;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "interactive_style", splashMonitorInfo.interactiveStyle);
        }
        String str4 = splashMonitorInfo.interactivityDefaultStyle;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "interactivity_default_style", splashMonitorInfo.interactivityDefaultStyle);
        }
        long j19 = splashMonitorInfo.showEndTime;
        if (j19 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "show_end_time", j19);
        }
        boolean z10 = splashMonitorInfo.isRotateComposeTimeout;
        if (z10) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "is_rotate_compose_timeout", z10);
        }
        long j20 = splashMonitorInfo.tkDefaultTimeout;
        if (j20 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "tk_default_timeout", j20);
        }
        int i17 = splashMonitorInfo.soSource;
        if (i17 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "so_source", i17);
        }
        long j21 = splashMonitorInfo.soLoadTime;
        if (j21 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "so_load_time", j21);
        }
        int i18 = splashMonitorInfo.offlineSource;
        if (i18 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "offline_source", i18);
        }
        long j22 = splashMonitorInfo.offlineLoadTime;
        if (j22 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "offline_load_time", j22);
        }
        long j23 = splashMonitorInfo.tkFileLoadTime;
        if (j23 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "tk_file_load_time", j23);
        }
        long j24 = splashMonitorInfo.tkInitTime;
        if (j24 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "tk_init_time", j24);
        }
        long j25 = splashMonitorInfo.tkRenderTime;
        if (j25 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "tk_render_time", j25);
        }
        long j26 = splashMonitorInfo.nativeLoadTime;
        if (j26 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "native_load_time", j26);
        }
        boolean z11 = splashMonitorInfo.isWebTimeout;
        if (z11) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "is_web_timeout", z11);
        }
        long j27 = splashMonitorInfo.webLoadTime;
        if (j27 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "web_load_time", j27);
        }
        String str5 = splashMonitorInfo.templateId;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, ExposeManager.UtArgsNames.templateId, splashMonitorInfo.templateId);
        }
        int i19 = splashMonitorInfo.templateVersionCode;
        if (i19 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "template_version_code", i19);
        }
        long j28 = splashMonitorInfo.tkTotalTime;
        if (j28 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "tk_total_time", j28);
        }
        int i20 = splashMonitorInfo.actionType;
        if (i20 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "action_type", i20);
        }
        int i21 = splashMonitorInfo.callbackType;
        if (i21 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "callback_type", i21);
        }
        long j29 = splashMonitorInfo.tkRenderType;
        if (j29 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "tk_render_type", j29);
        }
        long j30 = splashMonitorInfo.loadProcessType;
        if (j30 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "load_process_type", j30);
        }
        return jSONObject;
    }
}
