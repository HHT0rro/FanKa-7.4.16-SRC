package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdStyleInfo;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class k implements com.kwad.sdk.core.d<AdStyleInfo.AdBrowseInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdStyleInfo.AdBrowseInfo adBrowseInfo, JSONObject jSONObject) {
        a2(adBrowseInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdStyleInfo.AdBrowseInfo adBrowseInfo, JSONObject jSONObject) {
        return b2(adBrowseInfo, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(AdStyleInfo.AdBrowseInfo adBrowseInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adBrowseInfo.enableAdBrowse = jSONObject.optInt("enableAdBrowse");
        adBrowseInfo.adBrowseDuration = jSONObject.optInt("adBrowseDuration");
        adBrowseInfo.rewardDescription = jSONObject.optString("rewardDescription");
        if (JSONObject.NULL.toString().equals(adBrowseInfo.rewardDescription)) {
            adBrowseInfo.rewardDescription = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdStyleInfo.AdBrowseInfo adBrowseInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i10 = adBrowseInfo.enableAdBrowse;
        if (i10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "enableAdBrowse", i10);
        }
        int i11 = adBrowseInfo.adBrowseDuration;
        if (i11 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adBrowseDuration", i11);
        }
        String str = adBrowseInfo.rewardDescription;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "rewardDescription", adBrowseInfo.rewardDescription);
        }
        return jSONObject;
    }
}