package com.kwad.sdk.core.b.a;

import com.kwad.components.ad.feed.monitor.FeedPageInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class dv implements com.kwad.sdk.core.d<FeedPageInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(FeedPageInfo feedPageInfo, JSONObject jSONObject) {
        a2(feedPageInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(FeedPageInfo feedPageInfo, JSONObject jSONObject) {
        return b2(feedPageInfo, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(FeedPageInfo feedPageInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        feedPageInfo.status = jSONObject.optInt("status");
        feedPageInfo.loadStatus = jSONObject.optInt("load_status");
        feedPageInfo.adNum = jSONObject.optInt("ad_num");
        feedPageInfo.type = jSONObject.optInt("type");
        feedPageInfo.loadType = jSONObject.optLong("load_type");
        feedPageInfo.loadDataDuration = jSONObject.optLong("load_data_duration_ms");
        feedPageInfo.resourceLoadDuration = jSONObject.optLong("resource_load_duration_ms");
        feedPageInfo.materialType = jSONObject.optInt("material_type");
        feedPageInfo.materialUrl = jSONObject.optString("material_url");
        if (JSONObject.NULL.toString().equals(feedPageInfo.materialUrl)) {
            feedPageInfo.materialUrl = "";
        }
        feedPageInfo.renderDuration = jSONObject.optLong("render_duration_ms");
        feedPageInfo.renderType = jSONObject.optInt("render_type");
        feedPageInfo.expectedRenderType = jSONObject.optInt("expected_render_type");
        feedPageInfo.convertDuration = jSONObject.optLong("convert_duartion_ms");
        feedPageInfo.extMsg = jSONObject.optString("ext_msg");
        if (JSONObject.NULL.toString().equals(feedPageInfo.extMsg)) {
            feedPageInfo.extMsg = "";
        }
        feedPageInfo.abParams = jSONObject.optString("ab_params");
        if (JSONObject.NULL.toString().equals(feedPageInfo.abParams)) {
            feedPageInfo.abParams = "";
        }
        feedPageInfo.callbackType = jSONObject.optInt("callback_type");
        feedPageInfo.materialInfoList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("material_info");
        if (optJSONArray != null) {
            for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
                FeedPageInfo.a aVar = new FeedPageInfo.a();
                aVar.parseJson(optJSONArray.optJSONObject(i10));
                feedPageInfo.materialInfoList.add(aVar);
            }
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(FeedPageInfo feedPageInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i10 = feedPageInfo.status;
        if (i10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "status", i10);
        }
        int i11 = feedPageInfo.loadStatus;
        if (i11 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "load_status", i11);
        }
        int i12 = feedPageInfo.adNum;
        if (i12 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "ad_num", i12);
        }
        int i13 = feedPageInfo.type;
        if (i13 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "type", i13);
        }
        long j10 = feedPageInfo.loadType;
        if (j10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "load_type", j10);
        }
        long j11 = feedPageInfo.loadDataDuration;
        if (j11 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "load_data_duration_ms", j11);
        }
        long j12 = feedPageInfo.resourceLoadDuration;
        if (j12 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "resource_load_duration_ms", j12);
        }
        int i14 = feedPageInfo.materialType;
        if (i14 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "material_type", i14);
        }
        String str = feedPageInfo.materialUrl;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "material_url", feedPageInfo.materialUrl);
        }
        long j13 = feedPageInfo.renderDuration;
        if (j13 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "render_duration_ms", j13);
        }
        int i15 = feedPageInfo.renderType;
        if (i15 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "render_type", i15);
        }
        int i16 = feedPageInfo.expectedRenderType;
        if (i16 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "expected_render_type", i16);
        }
        long j14 = feedPageInfo.convertDuration;
        if (j14 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "convert_duartion_ms", j14);
        }
        String str2 = feedPageInfo.extMsg;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "ext_msg", feedPageInfo.extMsg);
        }
        String str3 = feedPageInfo.abParams;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "ab_params", feedPageInfo.abParams);
        }
        int i17 = feedPageInfo.callbackType;
        if (i17 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "callback_type", i17);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "material_info", feedPageInfo.materialInfoList);
        return jSONObject;
    }
}
