package com.kwad.sdk.core.b.a;

import com.alibaba.security.biometrics.service.model.params.ALBiometricsKeys;
import com.android.internal.org.bouncycastle.cms.CMSAttributeTableGenerator;
import com.huawei.appgallery.agd.core.impl.report.MaintKey;
import com.huawei.openalliance.ad.constant.bg;
import com.kwad.sdk.core.report.n;
import com.kwad.sdk.core.scene.URLPackage;
import com.tencent.cloud.huiyansdkface.facelight.api.WbCloudFaceContant;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class hz implements com.kwad.sdk.core.d<com.kwad.sdk.core.report.n> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.report.n nVar, JSONObject jSONObject) {
        a2(nVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.report.n nVar, JSONObject jSONObject) {
        return b2(nVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.core.report.n nVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        nVar.timestamp = jSONObject.optLong("timestamp");
        nVar.sessionId = jSONObject.optString("sessionId");
        if (JSONObject.NULL.toString().equals(nVar.sessionId)) {
            nVar.sessionId = "";
        }
        nVar.IE = jSONObject.optLong("seq");
        nVar.axI = jSONObject.optLong("listId");
        nVar.actionType = jSONObject.optLong("actionType");
        nVar.KG = jSONObject.optString("payload");
        if (JSONObject.NULL.toString().equals(nVar.KG)) {
            nVar.KG = "";
        }
        nVar.llsid = jSONObject.optLong("llsid");
        nVar.axJ = jSONObject.optJSONObject("extra");
        nVar.axK = jSONObject.optJSONObject("impAdExtra");
        nVar.posId = jSONObject.optLong("posId");
        nVar.contentType = jSONObject.optInt(CMSAttributeTableGenerator.CONTENT_TYPE);
        nVar.realShowType = jSONObject.optInt("realShowType");
        nVar.photoId = jSONObject.optLong(com.alibaba.security.realidentity.build.aq.f3119o);
        nVar.position = jSONObject.optLong("position");
        nVar.axL = jSONObject.optLong("serverPosition");
        nVar.axM = jSONObject.optLong("photoDuration");
        nVar.axN = jSONObject.optLong("effectivePlayDuration");
        nVar.VU = jSONObject.optLong("playDuration");
        nVar.blockDuration = jSONObject.optLong("blockDuration");
        nVar.axO = jSONObject.optLong("intervalDuration");
        nVar.axP = jSONObject.optLong("allIntervalDuration");
        nVar.axQ = jSONObject.optLong("flowSdk");
        nVar.axR = jSONObject.optLong("blockTimes");
        nVar.contentSourceType = jSONObject.optInt("contentSourceType", new Integer("0").intValue());
        nVar.apY = jSONObject.optInt("adAggPageSource");
        nVar.entryPageSource = jSONObject.optString("entryPageSource");
        if (JSONObject.NULL.toString().equals(nVar.entryPageSource)) {
            nVar.entryPageSource = "";
        }
        URLPackage uRLPackage = new URLPackage();
        nVar.urlPackage = uRLPackage;
        uRLPackage.parseJson(jSONObject.optJSONObject("urlPackage"));
        URLPackage uRLPackage2 = new URLPackage();
        nVar.axS = uRLPackage2;
        uRLPackage2.parseJson(jSONObject.optJSONObject("referURLPackage"));
        nVar.Sd = jSONObject.optLong(URLPackage.KEY_AUTHOR_ID);
        nVar.axT = jSONObject.optString("photoSize");
        if (JSONObject.NULL.toString().equals(nVar.axT)) {
            nVar.axT = "";
        }
        nVar.axU = jSONObject.optJSONArray("appInstalled");
        nVar.axV = jSONObject.optJSONArray("appUninstalled");
        n.a aVar = new n.a();
        nVar.axW = aVar;
        aVar.parseJson(jSONObject.optJSONObject("clientExt"));
        nVar.axX = jSONObject.optInt("playerType");
        nVar.axY = jSONObject.optInt(WbCloudFaceContant.CUSTOMER_TIPS_LOC);
        nVar.axZ = jSONObject.optInt("isLeftSlipStatus", new Integer("0").intValue());
        nVar.Xt = jSONObject.optInt("refreshType");
        nVar.aya = jSONObject.optInt("photoResponseType", new Integer("0").intValue());
        nVar.ayb = jSONObject.optString("failUrl");
        if (JSONObject.NULL.toString().equals(nVar.ayb)) {
            nVar.ayb = "";
        }
        nVar.errorMsg = jSONObject.optString("errorMsg");
        if (JSONObject.NULL.toString().equals(nVar.errorMsg)) {
            nVar.errorMsg = "";
        }
        nVar.errorCode = jSONObject.optInt("errorCode", new Integer("0").intValue());
        nVar.creativeId = jSONObject.optLong("creativeId");
        nVar.aye = jSONObject.optString("cacheFailedReason");
        if (JSONObject.NULL.toString().equals(nVar.aye)) {
            nVar.aye = "";
        }
        nVar.ayf = jSONObject.optJSONObject("appExt");
        nVar.ayg = jSONObject.optJSONArray("appRunningInfoList");
        nVar.downloadDuration = jSONObject.optLong("downloadDuration");
        nVar.pageType = jSONObject.optInt(MaintKey.PAGE_TYPE, new Integer("0").intValue());
        nVar.ayh = jSONObject.optInt("speedLimitStatus");
        nVar.ayi = jSONObject.optInt("speedLimitThreshold");
        nVar.ayj = jSONObject.optInt("currentRealDownloadSpeed");
        nVar.ayl = jSONObject.optJSONArray("sdkPlatform");
        nVar.aym = jSONObject.optBoolean("isKsUnion");
        nVar.ayn = jSONObject.optString("trackMethodName");
        if (JSONObject.NULL.toString().equals(nVar.ayn)) {
            nVar.ayn = "";
        }
        nVar.ayo = jSONObject.optInt("viewModeType", new Integer("0").intValue());
        nVar.clickTime = jSONObject.optLong("clickTime");
        nVar.ayq = jSONObject.optLong("frameRenderTime");
        nVar.ayr = jSONObject.optInt("playerEnterAction");
        nVar.ays = jSONObject.optString("requestUrl");
        if (JSONObject.NULL.toString().equals(nVar.ays)) {
            nVar.ays = "";
        }
        nVar.ayt = jSONObject.optLong("requestTotalTime");
        nVar.ayu = jSONObject.optLong("requestResponseTime");
        nVar.ayv = jSONObject.optLong("requestParseDataTime");
        nVar.ayw = jSONObject.optLong("requestCallbackTime");
        nVar.ayx = jSONObject.optString("requestFailReason");
        if (JSONObject.NULL.toString().equals(nVar.ayx)) {
            nVar.ayx = "";
        }
        nVar.Ra = jSONObject.optString(com.alibaba.security.realidentity.build.aq.I);
        if (JSONObject.NULL.toString().equals(nVar.Ra)) {
            nVar.Ra = "";
        }
        nVar.Ri = jSONObject.optLong("pageCreateTime");
        nVar.Rj = jSONObject.optLong("pageResumeTime");
        nVar.ayy = jSONObject.optInt("trackUrlType");
        nVar.ayz = jSONObject.optJSONArray("trackUrlList");
        nVar.Rh = jSONObject.optLong("pageLaunchTime");
        nVar.ayC = jSONObject.optJSONArray("appAuthorityInfoList");
        nVar.ayD = jSONObject.optString("tkVersion");
        if (JSONObject.NULL.toString().equals(nVar.ayD)) {
            nVar.ayD = "";
        }
        nVar.ayE = jSONObject.optString("jsVersion");
        if (JSONObject.NULL.toString().equals(nVar.ayE)) {
            nVar.ayE = "";
        }
        nVar.ayF = jSONObject.optString("jsFileName");
        if (JSONObject.NULL.toString().equals(nVar.ayF)) {
            nVar.ayF = "";
        }
        nVar.ayG = jSONObject.optString("jsErrorMsg");
        if (JSONObject.NULL.toString().equals(nVar.ayG)) {
            nVar.ayG = "";
        }
        nVar.ayH = jSONObject.optString("jsConfig");
        if (JSONObject.NULL.toString().equals(nVar.ayH)) {
            nVar.ayH = "";
        }
        nVar.ayI = jSONObject.optInt("adBizType");
        nVar.ayJ = jSONObject.optString("customKey");
        if (JSONObject.NULL.toString().equals(nVar.ayJ)) {
            nVar.ayJ = "";
        }
        nVar.ayK = jSONObject.optString("customValue");
        if (JSONObject.NULL.toString().equals(nVar.ayK)) {
            nVar.ayK = "";
        }
        nVar.trace = jSONObject.optString("trace");
        if (JSONObject.NULL.toString().equals(nVar.trace)) {
            nVar.trace = "";
        }
        nVar.ayL = jSONObject.optInt("filterCode");
        nVar.ayM = jSONObject.optInt("sdkVersionCode");
        nVar.sdkVersion = jSONObject.optString(bg.e.Code);
        if (JSONObject.NULL.toString().equals(nVar.sdkVersion)) {
            nVar.sdkVersion = "";
        }
        nVar.ayN = jSONObject.optString("adSdkVersion");
        if (JSONObject.NULL.toString().equals(nVar.ayN)) {
            nVar.ayN = "";
        }
        nVar.WQ = jSONObject.optString("sdkApiVersion");
        if (JSONObject.NULL.toString().equals(nVar.WQ)) {
            nVar.WQ = "";
        }
        nVar.sdkType = jSONObject.optInt(ALBiometricsKeys.KEY_SDK_TYPE);
        nVar.ayO = jSONObject.optLong("appUseDuration");
        nVar.ayP = jSONObject.optLong("appStartType");
        nVar.auc = jSONObject.optLong("sequenceNumber");
        nVar.IB = jSONObject.optString("appColdStart");
        if (JSONObject.NULL.toString().equals(nVar.IB)) {
            nVar.IB = "";
        }
        nVar.IC = jSONObject.optString("appStart");
        if (JSONObject.NULL.toString().equals(nVar.IC)) {
            nVar.IC = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.core.report.n nVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j10 = nVar.timestamp;
        if (j10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "timestamp", j10);
        }
        String str = nVar.sessionId;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "sessionId", nVar.sessionId);
        }
        long j11 = nVar.IE;
        if (j11 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "seq", j11);
        }
        long j12 = nVar.axI;
        if (j12 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "listId", j12);
        }
        long j13 = nVar.actionType;
        if (j13 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "actionType", j13);
        }
        String str2 = nVar.KG;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "payload", nVar.KG);
        }
        long j14 = nVar.llsid;
        if (j14 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "llsid", j14);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "extra", nVar.axJ);
        com.kwad.sdk.utils.t.putValue(jSONObject, "impAdExtra", nVar.axK);
        long j15 = nVar.posId;
        if (j15 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "posId", j15);
        }
        int i10 = nVar.contentType;
        if (i10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, CMSAttributeTableGenerator.CONTENT_TYPE, i10);
        }
        int i11 = nVar.realShowType;
        if (i11 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "realShowType", i11);
        }
        long j16 = nVar.photoId;
        if (j16 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, com.alibaba.security.realidentity.build.aq.f3119o, j16);
        }
        long j17 = nVar.position;
        if (j17 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "position", j17);
        }
        long j18 = nVar.axL;
        if (j18 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "serverPosition", j18);
        }
        long j19 = nVar.axM;
        if (j19 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "photoDuration", j19);
        }
        long j20 = nVar.axN;
        if (j20 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "effectivePlayDuration", j20);
        }
        long j21 = nVar.VU;
        if (j21 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "playDuration", j21);
        }
        long j22 = nVar.blockDuration;
        if (j22 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "blockDuration", j22);
        }
        long j23 = nVar.axO;
        if (j23 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "intervalDuration", j23);
        }
        long j24 = nVar.axP;
        if (j24 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "allIntervalDuration", j24);
        }
        long j25 = nVar.axQ;
        if (j25 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "flowSdk", j25);
        }
        long j26 = nVar.axR;
        if (j26 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "blockTimes", j26);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "contentSourceType", nVar.contentSourceType);
        int i12 = nVar.apY;
        if (i12 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adAggPageSource", i12);
        }
        String str3 = nVar.entryPageSource;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "entryPageSource", nVar.entryPageSource);
        }
        com.kwad.sdk.utils.t.a(jSONObject, "urlPackage", nVar.urlPackage);
        com.kwad.sdk.utils.t.a(jSONObject, "referURLPackage", nVar.axS);
        long j27 = nVar.Sd;
        if (j27 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, URLPackage.KEY_AUTHOR_ID, j27);
        }
        String str4 = nVar.axT;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "photoSize", nVar.axT);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "appInstalled", nVar.axU);
        com.kwad.sdk.utils.t.putValue(jSONObject, "appUninstalled", nVar.axV);
        com.kwad.sdk.utils.t.a(jSONObject, "clientExt", nVar.axW);
        int i13 = nVar.axX;
        if (i13 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "playerType", i13);
        }
        int i14 = nVar.axY;
        if (i14 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, WbCloudFaceContant.CUSTOMER_TIPS_LOC, i14);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "isLeftSlipStatus", nVar.axZ);
        int i15 = nVar.Xt;
        if (i15 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "refreshType", i15);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "photoResponseType", nVar.aya);
        String str5 = nVar.ayb;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "failUrl", nVar.ayb);
        }
        String str6 = nVar.errorMsg;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "errorMsg", nVar.errorMsg);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "errorCode", nVar.errorCode);
        long j28 = nVar.creativeId;
        if (j28 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "creativeId", j28);
        }
        String str7 = nVar.aye;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "cacheFailedReason", nVar.aye);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "appExt", nVar.ayf);
        com.kwad.sdk.utils.t.putValue(jSONObject, "appRunningInfoList", nVar.ayg);
        long j29 = nVar.downloadDuration;
        if (j29 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "downloadDuration", j29);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, MaintKey.PAGE_TYPE, nVar.pageType);
        int i16 = nVar.ayh;
        if (i16 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "speedLimitStatus", i16);
        }
        int i17 = nVar.ayi;
        if (i17 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "speedLimitThreshold", i17);
        }
        int i18 = nVar.ayj;
        if (i18 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "currentRealDownloadSpeed", i18);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "sdkPlatform", nVar.ayl);
        boolean z10 = nVar.aym;
        if (z10) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "isKsUnion", z10);
        }
        String str8 = nVar.ayn;
        if (str8 != null && !str8.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "trackMethodName", nVar.ayn);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "viewModeType", nVar.ayo);
        long j30 = nVar.clickTime;
        if (j30 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "clickTime", j30);
        }
        long j31 = nVar.ayq;
        if (j31 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "frameRenderTime", j31);
        }
        int i19 = nVar.ayr;
        if (i19 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "playerEnterAction", i19);
        }
        String str9 = nVar.ays;
        if (str9 != null && !str9.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "requestUrl", nVar.ays);
        }
        long j32 = nVar.ayt;
        if (j32 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "requestTotalTime", j32);
        }
        long j33 = nVar.ayu;
        if (j33 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "requestResponseTime", j33);
        }
        long j34 = nVar.ayv;
        if (j34 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "requestParseDataTime", j34);
        }
        long j35 = nVar.ayw;
        if (j35 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "requestCallbackTime", j35);
        }
        String str10 = nVar.ayx;
        if (str10 != null && !str10.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "requestFailReason", nVar.ayx);
        }
        String str11 = nVar.Ra;
        if (str11 != null && !str11.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, com.alibaba.security.realidentity.build.aq.I, nVar.Ra);
        }
        long j36 = nVar.Ri;
        if (j36 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "pageCreateTime", j36);
        }
        long j37 = nVar.Rj;
        if (j37 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "pageResumeTime", j37);
        }
        int i20 = nVar.ayy;
        if (i20 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "trackUrlType", i20);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "trackUrlList", nVar.ayz);
        long j38 = nVar.Rh;
        if (j38 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "pageLaunchTime", j38);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "appAuthorityInfoList", nVar.ayC);
        String str12 = nVar.ayD;
        if (str12 != null && !str12.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "tkVersion", nVar.ayD);
        }
        String str13 = nVar.ayE;
        if (str13 != null && !str13.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "jsVersion", nVar.ayE);
        }
        String str14 = nVar.ayF;
        if (str14 != null && !str14.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "jsFileName", nVar.ayF);
        }
        String str15 = nVar.ayG;
        if (str15 != null && !str15.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "jsErrorMsg", nVar.ayG);
        }
        String str16 = nVar.ayH;
        if (str16 != null && !str16.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "jsConfig", nVar.ayH);
        }
        int i21 = nVar.ayI;
        if (i21 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adBizType", i21);
        }
        String str17 = nVar.ayJ;
        if (str17 != null && !str17.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "customKey", nVar.ayJ);
        }
        String str18 = nVar.ayK;
        if (str18 != null && !str18.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "customValue", nVar.ayK);
        }
        String str19 = nVar.trace;
        if (str19 != null && !str19.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "trace", nVar.trace);
        }
        int i22 = nVar.ayL;
        if (i22 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "filterCode", i22);
        }
        int i23 = nVar.ayM;
        if (i23 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "sdkVersionCode", i23);
        }
        String str20 = nVar.sdkVersion;
        if (str20 != null && !str20.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, bg.e.Code, nVar.sdkVersion);
        }
        String str21 = nVar.ayN;
        if (str21 != null && !str21.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adSdkVersion", nVar.ayN);
        }
        String str22 = nVar.WQ;
        if (str22 != null && !str22.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "sdkApiVersion", nVar.WQ);
        }
        int i24 = nVar.sdkType;
        if (i24 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, ALBiometricsKeys.KEY_SDK_TYPE, i24);
        }
        long j39 = nVar.ayO;
        if (j39 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "appUseDuration", j39);
        }
        long j40 = nVar.ayP;
        if (j40 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "appStartType", j40);
        }
        long j41 = nVar.auc;
        if (j41 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "sequenceNumber", j41);
        }
        String str23 = nVar.IB;
        if (str23 != null && !str23.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "appColdStart", nVar.IB);
        }
        String str24 = nVar.IC;
        if (str24 != null && !str24.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "appStart", nVar.IC);
        }
        return jSONObject;
    }
}
