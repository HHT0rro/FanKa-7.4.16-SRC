package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class ax implements com.kwad.sdk.core.d<AdInfo.AdvertiserInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.AdvertiserInfo advertiserInfo, JSONObject jSONObject) {
        a2(advertiserInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.AdvertiserInfo advertiserInfo, JSONObject jSONObject) {
        return b2(advertiserInfo, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(AdInfo.AdvertiserInfo advertiserInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        advertiserInfo.userId = jSONObject.optLong(com.huawei.openalliance.ad.constant.as.f32242q);
        advertiserInfo.userName = jSONObject.optString("userName");
        if (JSONObject.NULL.toString().equals(advertiserInfo.userName)) {
            advertiserInfo.userName = "";
        }
        advertiserInfo.rawUserName = jSONObject.optString("rawUserName");
        if (JSONObject.NULL.toString().equals(advertiserInfo.rawUserName)) {
            advertiserInfo.rawUserName = "";
        }
        advertiserInfo.userGender = jSONObject.optString("userGender");
        if (JSONObject.NULL.toString().equals(advertiserInfo.userGender)) {
            advertiserInfo.userGender = "";
        }
        advertiserInfo.portraitUrl = jSONObject.optString("portraitUrl");
        if (JSONObject.NULL.toString().equals(advertiserInfo.portraitUrl)) {
            advertiserInfo.portraitUrl = "";
        }
        advertiserInfo.adAuthorText = jSONObject.optString("adAuthorText");
        if (JSONObject.NULL.toString().equals(advertiserInfo.adAuthorText)) {
            advertiserInfo.adAuthorText = "";
        }
        advertiserInfo.authorIconGuide = jSONObject.optString("authorIconGuide");
        if (JSONObject.NULL.toString().equals(advertiserInfo.authorIconGuide)) {
            advertiserInfo.authorIconGuide = "";
        }
        advertiserInfo.followed = jSONObject.optBoolean("followed");
        advertiserInfo.fansCount = jSONObject.optInt("fansCount");
        advertiserInfo.brief = jSONObject.optString("brief");
        if (JSONObject.NULL.toString().equals(advertiserInfo.brief)) {
            advertiserInfo.brief = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdInfo.AdvertiserInfo advertiserInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j10 = advertiserInfo.userId;
        if (j10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, com.huawei.openalliance.ad.constant.as.f32242q, j10);
        }
        String str = advertiserInfo.userName;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "userName", advertiserInfo.userName);
        }
        String str2 = advertiserInfo.rawUserName;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "rawUserName", advertiserInfo.rawUserName);
        }
        String str3 = advertiserInfo.userGender;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "userGender", advertiserInfo.userGender);
        }
        String str4 = advertiserInfo.portraitUrl;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "portraitUrl", advertiserInfo.portraitUrl);
        }
        String str5 = advertiserInfo.adAuthorText;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adAuthorText", advertiserInfo.adAuthorText);
        }
        String str6 = advertiserInfo.authorIconGuide;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "authorIconGuide", advertiserInfo.authorIconGuide);
        }
        boolean z10 = advertiserInfo.followed;
        if (z10) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "followed", z10);
        }
        int i10 = advertiserInfo.fansCount;
        if (i10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "fansCount", i10);
        }
        String str7 = advertiserInfo.brief;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "brief", advertiserInfo.brief);
        }
        return jSONObject;
    }
}
