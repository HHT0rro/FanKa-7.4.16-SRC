package com.kwad.sdk.core.b.a;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.qq.e.comm.pi.IBidding;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class ae implements com.kwad.sdk.core.d<com.kwad.sdk.core.adlog.c.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.adlog.c.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.adlog.c.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.core.adlog.c.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        AdTemplate adTemplate = new AdTemplate();
        aVar.adTemplate = adTemplate;
        adTemplate.parseJson(jSONObject.optJSONObject("adTemplate"));
        aVar.apH = jSONObject.optJSONObject("extData");
        aVar.aoM = jSONObject.optInt("adActionType");
        aVar.apI = jSONObject.optInt("photoPlaySecond");
        aVar.apJ = jSONObject.optInt("awardReceiveStage");
        aVar.kl = jSONObject.optInt("itemClickType");
        aVar.apK = jSONObject.optInt("itemCloseType");
        aVar.apL = jSONObject.optInt("elementType");
        aVar.apM = jSONObject.optString("adRenderArea");
        if (JSONObject.NULL.toString().equals(aVar.apM)) {
            aVar.apM = "";
        }
        aVar.apN = jSONObject.optLong(IBidding.HIGHEST_LOSS_PRICE);
        aVar.apO = jSONObject.optInt("impFailReason");
        aVar.apP = jSONObject.optLong("winEcpm");
        aVar.adnType = jSONObject.optInt("adnType");
        aVar.adnName = jSONObject.optString(MediationConstant.KEY_ADN_NAME);
        if (JSONObject.NULL.toString().equals(aVar.adnName)) {
            aVar.adnName = "";
        }
        aVar.apQ = jSONObject.optInt("retainCodeType");
        aVar.KI = jSONObject.optInt("photoSizeStyle");
        aVar.KG = jSONObject.optString("payload");
        if (JSONObject.NULL.toString().equals(aVar.KG)) {
            aVar.KG = "";
        }
        aVar.apR = jSONObject.optInt("deeplinkType");
        aVar.apS = jSONObject.optString("deeplinkAppName");
        if (JSONObject.NULL.toString().equals(aVar.apS)) {
            aVar.apS = "";
        }
        aVar.apT = jSONObject.optInt("deeplinkFailedReason");
        aVar.downloadSource = jSONObject.optInt(com.huawei.hms.ads.hs.I);
        aVar.apU = jSONObject.optInt("isPackageChanged");
        aVar.apV = jSONObject.optString("installedFrom");
        if (JSONObject.NULL.toString().equals(aVar.apV)) {
            aVar.apV = "";
        }
        aVar.apW = jSONObject.optString("downloadFailedReason");
        if (JSONObject.NULL.toString().equals(aVar.apW)) {
            aVar.apW = "";
        }
        aVar.apX = jSONObject.optInt("isChangedEndcard");
        aVar.apY = jSONObject.optInt("adAggPageSource");
        aVar.apZ = jSONObject.optString("serverPackageName");
        if (JSONObject.NULL.toString().equals(aVar.apZ)) {
            aVar.apZ = "";
        }
        aVar.aqa = jSONObject.optString("installedPackageName");
        if (JSONObject.NULL.toString().equals(aVar.aqa)) {
            aVar.aqa = "";
        }
        aVar.aqb = jSONObject.optInt("closeButtonImpressionTime");
        aVar.aqc = jSONObject.optInt("closeButtonClickTime");
        aVar.aqd = jSONObject.optLong("landingPageLoadedDuration");
        aVar.Li = jSONObject.optLong("leaveTime");
        aVar.aqe = jSONObject.optLong("adItemClickBackDuration");
        aVar.aqf = jSONObject.optInt("appStorePageType");
        aVar.aqg = jSONObject.optInt("installStatus");
        aVar.downloadStatus = jSONObject.optInt(com.huawei.openalliance.ad.download.app.d.C);
        aVar.aqh = jSONObject.optInt("downloadCardType");
        a.C0516a c0516a = new a.C0516a();
        aVar.KH = c0516a;
        c0516a.parseJson(jSONObject.optJSONObject("clientExtData"));
        aVar.Om = jSONObject.optInt("landingPageType");
        aVar.vz = jSONObject.optLong("playedDuration");
        aVar.aqi = jSONObject.optInt("playedRate");
        aVar.aqj = jSONObject.optInt("adOrder");
        aVar.KF = jSONObject.optInt("adInterstitialSource");
        aVar.ko = jSONObject.optDouble("splashShakeAcceleration");
        aVar.aqk = jSONObject.optString("splashInteractionRotateAngle");
        if (JSONObject.NULL.toString().equals(aVar.aqk)) {
            aVar.aqk = "";
        }
        aVar.aql = jSONObject.optInt("downloadInstallType");
        aVar.aqm = jSONObject.optInt("businessSceneType");
        aVar.adxResult = jSONObject.optInt("adxResult");
        aVar.aqn = jSONObject.optInt("fingerSwipeType");
        aVar.aqo = jSONObject.optInt("fingerSwipeDistance");
        aVar.KJ = jSONObject.optInt("triggerType");
        aVar.aqp = jSONObject.optInt("cardCloseType");
        aVar.aqq = jSONObject.optString("clientPkFailAdInfo");
        if (JSONObject.NULL.toString().equals(aVar.aqq)) {
            aVar.aqq = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.core.adlog.c.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "adTemplate", aVar.adTemplate);
        com.kwad.sdk.utils.t.putValue(jSONObject, "extData", aVar.apH);
        int i10 = aVar.aoM;
        if (i10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adActionType", i10);
        }
        int i11 = aVar.apI;
        if (i11 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "photoPlaySecond", i11);
        }
        int i12 = aVar.apJ;
        if (i12 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "awardReceiveStage", i12);
        }
        int i13 = aVar.kl;
        if (i13 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "itemClickType", i13);
        }
        int i14 = aVar.apK;
        if (i14 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "itemCloseType", i14);
        }
        int i15 = aVar.apL;
        if (i15 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "elementType", i15);
        }
        String str = aVar.apM;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adRenderArea", aVar.apM);
        }
        long j10 = aVar.apN;
        if (j10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, IBidding.HIGHEST_LOSS_PRICE, j10);
        }
        int i16 = aVar.apO;
        if (i16 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "impFailReason", i16);
        }
        long j11 = aVar.apP;
        if (j11 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "winEcpm", j11);
        }
        int i17 = aVar.adnType;
        if (i17 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adnType", i17);
        }
        String str2 = aVar.adnName;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, MediationConstant.KEY_ADN_NAME, aVar.adnName);
        }
        int i18 = aVar.apQ;
        if (i18 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "retainCodeType", i18);
        }
        int i19 = aVar.KI;
        if (i19 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "photoSizeStyle", i19);
        }
        String str3 = aVar.KG;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "payload", aVar.KG);
        }
        int i20 = aVar.apR;
        if (i20 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "deeplinkType", i20);
        }
        String str4 = aVar.apS;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "deeplinkAppName", aVar.apS);
        }
        int i21 = aVar.apT;
        if (i21 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "deeplinkFailedReason", i21);
        }
        int i22 = aVar.downloadSource;
        if (i22 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, com.huawei.hms.ads.hs.I, i22);
        }
        int i23 = aVar.apU;
        if (i23 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "isPackageChanged", i23);
        }
        String str5 = aVar.apV;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "installedFrom", aVar.apV);
        }
        String str6 = aVar.apW;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "downloadFailedReason", aVar.apW);
        }
        int i24 = aVar.apX;
        if (i24 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "isChangedEndcard", i24);
        }
        int i25 = aVar.apY;
        if (i25 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adAggPageSource", i25);
        }
        String str7 = aVar.apZ;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "serverPackageName", aVar.apZ);
        }
        String str8 = aVar.aqa;
        if (str8 != null && !str8.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "installedPackageName", aVar.aqa);
        }
        int i26 = aVar.aqb;
        if (i26 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "closeButtonImpressionTime", i26);
        }
        int i27 = aVar.aqc;
        if (i27 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "closeButtonClickTime", i27);
        }
        long j12 = aVar.aqd;
        if (j12 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "landingPageLoadedDuration", j12);
        }
        long j13 = aVar.Li;
        if (j13 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "leaveTime", j13);
        }
        long j14 = aVar.aqe;
        if (j14 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adItemClickBackDuration", j14);
        }
        int i28 = aVar.aqf;
        if (i28 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "appStorePageType", i28);
        }
        int i29 = aVar.aqg;
        if (i29 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "installStatus", i29);
        }
        int i30 = aVar.downloadStatus;
        if (i30 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, com.huawei.openalliance.ad.download.app.d.C, i30);
        }
        int i31 = aVar.aqh;
        if (i31 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "downloadCardType", i31);
        }
        com.kwad.sdk.utils.t.a(jSONObject, "clientExtData", aVar.KH);
        int i32 = aVar.Om;
        if (i32 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "landingPageType", i32);
        }
        long j15 = aVar.vz;
        if (j15 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "playedDuration", j15);
        }
        int i33 = aVar.aqi;
        if (i33 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "playedRate", i33);
        }
        int i34 = aVar.aqj;
        if (i34 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adOrder", i34);
        }
        int i35 = aVar.KF;
        if (i35 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adInterstitialSource", i35);
        }
        double d10 = aVar.ko;
        if (d10 != ShadowDrawableWrapper.COS_45) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "splashShakeAcceleration", d10);
        }
        String str9 = aVar.aqk;
        if (str9 != null && !str9.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "splashInteractionRotateAngle", aVar.aqk);
        }
        int i36 = aVar.aql;
        if (i36 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "downloadInstallType", i36);
        }
        int i37 = aVar.aqm;
        if (i37 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "businessSceneType", i37);
        }
        int i38 = aVar.adxResult;
        if (i38 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adxResult", i38);
        }
        int i39 = aVar.aqn;
        if (i39 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "fingerSwipeType", i39);
        }
        int i40 = aVar.aqo;
        if (i40 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "fingerSwipeDistance", i40);
        }
        int i41 = aVar.KJ;
        if (i41 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "triggerType", i41);
        }
        int i42 = aVar.aqp;
        if (i42 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "cardCloseType", i42);
        }
        String str10 = aVar.aqq;
        if (str10 != null && !str10.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "clientPkFailAdInfo", aVar.aqq);
        }
        return jSONObject;
    }
}
