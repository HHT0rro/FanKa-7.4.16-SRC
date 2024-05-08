package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class w implements com.kwad.sdk.core.d<AdInfo.AdInsertScreenInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.AdInsertScreenInfo adInsertScreenInfo, JSONObject jSONObject) {
        a2(adInsertScreenInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.AdInsertScreenInfo adInsertScreenInfo, JSONObject jSONObject) {
        return b2(adInsertScreenInfo, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(AdInfo.AdInsertScreenInfo adInsertScreenInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adInsertScreenInfo.cycleAggregateSwitch = jSONObject.optBoolean("cycleAggregateSwitch");
        adInsertScreenInfo.cycleAggregateDailyShowCount = jSONObject.optInt("cycleAggregateDailyShowCount", new Integer("10").intValue());
        adInsertScreenInfo.cycleAggregateStyle = jSONObject.optInt("cycleAggregateStyle");
        adInsertScreenInfo.cycleAggregateInterval = jSONObject.optInt("cycleAggregateInterval", new Integer("10").intValue());
        adInsertScreenInfo.autoCloseTime = jSONObject.optInt("autoCloseTime");
        adInsertScreenInfo.retainWindowStyle = jSONObject.optInt("retainWindowStyle");
        adInsertScreenInfo.retainWindowText = jSONObject.optString("retainWindowText");
        if (JSONObject.NULL.toString().equals(adInsertScreenInfo.retainWindowText)) {
            adInsertScreenInfo.retainWindowText = "";
        }
        adInsertScreenInfo.retainWindowBasedAdShowCount = jSONObject.optInt("retainWindowBasedAdShowCount");
        adInsertScreenInfo.retainWindowDailyShowCount = jSONObject.optInt("retainWindowDailyShowCount");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdInfo.AdInsertScreenInfo adInsertScreenInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z10 = adInsertScreenInfo.cycleAggregateSwitch;
        if (z10) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "cycleAggregateSwitch", z10);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "cycleAggregateDailyShowCount", adInsertScreenInfo.cycleAggregateDailyShowCount);
        int i10 = adInsertScreenInfo.cycleAggregateStyle;
        if (i10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "cycleAggregateStyle", i10);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "cycleAggregateInterval", adInsertScreenInfo.cycleAggregateInterval);
        int i11 = adInsertScreenInfo.autoCloseTime;
        if (i11 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "autoCloseTime", i11);
        }
        int i12 = adInsertScreenInfo.retainWindowStyle;
        if (i12 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "retainWindowStyle", i12);
        }
        String str = adInsertScreenInfo.retainWindowText;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "retainWindowText", adInsertScreenInfo.retainWindowText);
        }
        int i13 = adInsertScreenInfo.retainWindowBasedAdShowCount;
        if (i13 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "retainWindowBasedAdShowCount", i13);
        }
        int i14 = adInsertScreenInfo.retainWindowDailyShowCount;
        if (i14 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "retainWindowDailyShowCount", i14);
        }
        return jSONObject;
    }
}
