package com.kwad.sdk.core.b.a;

import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.sdk.core.scene.URLPackage;
import org.json.JSONObject;
import wseemann.media.FFmpegMediaMetadataRetriever;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class fb implements com.kwad.sdk.core.d<ImpInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(ImpInfo impInfo, JSONObject jSONObject) {
        a2(impInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(ImpInfo impInfo, JSONObject jSONObject) {
        return b2(impInfo, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(ImpInfo impInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        impInfo.pageScene = jSONObject.optLong("pageScene");
        impInfo.subPageScene = jSONObject.optLong("subPageScene");
        impInfo.sdkExtraData = jSONObject.optString("sdkExtraData");
        if (JSONObject.NULL.toString().equals(impInfo.sdkExtraData)) {
            impInfo.sdkExtraData = "";
        }
        impInfo.posId = jSONObject.optLong("posId");
        impInfo.entryScene = jSONObject.optLong("entryScene");
        impInfo.adNum = jSONObject.optInt("adNum");
        impInfo.action = jSONObject.optInt("action");
        impInfo.width = jSONObject.optInt("width");
        impInfo.height = jSONObject.optInt("height");
        impInfo.cpmBidFloor = jSONObject.optLong("cpmBidFloor");
        impInfo.adStyle = jSONObject.optInt("adStyle");
        URLPackage uRLPackage = new URLPackage();
        impInfo.urlPackage = uRLPackage;
        uRLPackage.parseJson(jSONObject.optJSONObject("urlPackage"));
        impInfo.promoteId = jSONObject.optString("promoteId");
        if (JSONObject.NULL.toString().equals(impInfo.promoteId)) {
            impInfo.promoteId = "";
        }
        impInfo.comment = jSONObject.optString(FFmpegMediaMetadataRetriever.METADATA_KEY_COMMENT);
        if (JSONObject.NULL.toString().equals(impInfo.comment)) {
            impInfo.comment = "";
        }
        impInfo.backUrl = jSONObject.optString("backUrl");
        if (JSONObject.NULL.toString().equals(impInfo.backUrl)) {
            impInfo.backUrl = "";
        }
        impInfo.userCommRateBuying = jSONObject.optLong("userCommRateBuying");
        impInfo.userCommRateSharing = jSONObject.optLong("userCommRateSharing");
        impInfo.screenOrientation = jSONObject.optInt("screenOrientation");
        impInfo.extraData = jSONObject.optString("extraData");
        if (JSONObject.NULL.toString().equals(impInfo.extraData)) {
            impInfo.extraData = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(ImpInfo impInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j10 = impInfo.pageScene;
        if (j10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "pageScene", j10);
        }
        long j11 = impInfo.subPageScene;
        if (j11 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "subPageScene", j11);
        }
        String str = impInfo.sdkExtraData;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "sdkExtraData", impInfo.sdkExtraData);
        }
        long j12 = impInfo.posId;
        if (j12 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "posId", j12);
        }
        long j13 = impInfo.entryScene;
        if (j13 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "entryScene", j13);
        }
        int i10 = impInfo.adNum;
        if (i10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adNum", i10);
        }
        int i11 = impInfo.action;
        if (i11 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "action", i11);
        }
        int i12 = impInfo.width;
        if (i12 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "width", i12);
        }
        int i13 = impInfo.height;
        if (i13 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "height", i13);
        }
        long j14 = impInfo.cpmBidFloor;
        if (j14 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "cpmBidFloor", j14);
        }
        int i14 = impInfo.adStyle;
        if (i14 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adStyle", i14);
        }
        com.kwad.sdk.utils.t.a(jSONObject, "urlPackage", impInfo.urlPackage);
        String str2 = impInfo.promoteId;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "promoteId", impInfo.promoteId);
        }
        String str3 = impInfo.comment;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, FFmpegMediaMetadataRetriever.METADATA_KEY_COMMENT, impInfo.comment);
        }
        String str4 = impInfo.backUrl;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "backUrl", impInfo.backUrl);
        }
        long j15 = impInfo.userCommRateBuying;
        if (j15 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "userCommRateBuying", j15);
        }
        long j16 = impInfo.userCommRateSharing;
        if (j16 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "userCommRateSharing", j16);
        }
        int i15 = impInfo.screenOrientation;
        if (i15 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "screenOrientation", i15);
        }
        String str5 = impInfo.extraData;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "extraData", impInfo.extraData);
        }
        return jSONObject;
    }
}
