package com.kwad.sdk.core.b.a;

import com.alibaba.security.biometrics.service.model.params.ALBiometricsKeys;
import com.huawei.hms.ads.jsb.constant.Constant;
import com.huawei.hms.push.AttributionReporter;
import com.huawei.quickcard.framework.bean.ConfigBean;
import com.inno.innosdk.pb.InnoMain;
import com.kwad.sdk.core.webview.d.a;
import org.json.JSONObject;
import wseemann.media.FFmpegMediaMetadataRetriever;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class er implements com.kwad.sdk.core.d<a.C0532a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(a.C0532a c0532a, JSONObject jSONObject) {
        a2(c0532a, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(a.C0532a c0532a, JSONObject jSONObject) {
        return b2(c0532a, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(a.C0532a c0532a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0532a.WO = jSONObject.optString("SDKVersion");
        if (JSONObject.NULL.toString().equals(c0532a.WO)) {
            c0532a.WO = "";
        }
        c0532a.WP = jSONObject.optInt("SDKVersionCode");
        c0532a.ayD = jSONObject.optString("tkVersion");
        if (JSONObject.NULL.toString().equals(c0532a.ayD)) {
            c0532a.ayD = "";
        }
        c0532a.WQ = jSONObject.optString("sdkApiVersion");
        if (JSONObject.NULL.toString().equals(c0532a.WQ)) {
            c0532a.WQ = "";
        }
        c0532a.WR = jSONObject.optInt("sdkApiVersionCode");
        c0532a.sdkType = jSONObject.optInt(ALBiometricsKeys.KEY_SDK_TYPE);
        c0532a.appVersion = jSONObject.optString(AttributionReporter.APP_VERSION);
        if (JSONObject.NULL.toString().equals(c0532a.appVersion)) {
            c0532a.appVersion = "";
        }
        c0532a.appName = jSONObject.optString("appName");
        if (JSONObject.NULL.toString().equals(c0532a.appName)) {
            c0532a.appName = "";
        }
        c0532a.appId = jSONObject.optString("appId");
        if (JSONObject.NULL.toString().equals(c0532a.appId)) {
            c0532a.appId = "";
        }
        c0532a.aEF = jSONObject.optString("globalId");
        if (JSONObject.NULL.toString().equals(c0532a.aEF)) {
            c0532a.aEF = "";
        }
        c0532a.azu = jSONObject.optString("eGid");
        if (JSONObject.NULL.toString().equals(c0532a.azu)) {
            c0532a.azu = "";
        }
        c0532a.azt = jSONObject.optString("deviceSig");
        if (JSONObject.NULL.toString().equals(c0532a.azt)) {
            c0532a.azt = "";
        }
        c0532a.WS = jSONObject.optString(ConfigBean.Field.NETWORK_TYPE);
        if (JSONObject.NULL.toString().equals(c0532a.WS)) {
            c0532a.WS = "";
        }
        c0532a.WT = jSONObject.optString("manufacturer");
        if (JSONObject.NULL.toString().equals(c0532a.WT)) {
            c0532a.WT = "";
        }
        c0532a.model = jSONObject.optString(com.baidu.mobads.sdk.internal.bk.f9900i);
        if (JSONObject.NULL.toString().equals(c0532a.model)) {
            c0532a.model = "";
        }
        c0532a.WU = jSONObject.optString("deviceBrand");
        if (JSONObject.NULL.toString().equals(c0532a.WU)) {
            c0532a.WU = "";
        }
        c0532a.WV = jSONObject.optInt("osType");
        c0532a.WW = jSONObject.optString("systemVersion");
        if (JSONObject.NULL.toString().equals(c0532a.WW)) {
            c0532a.WW = "";
        }
        c0532a.WX = jSONObject.optInt("osApi");
        c0532a.WY = jSONObject.optString(FFmpegMediaMetadataRetriever.METADATA_KEY_LANGUAGE);
        if (JSONObject.NULL.toString().equals(c0532a.WY)) {
            c0532a.WY = "";
        }
        c0532a.WZ = jSONObject.optString("locale");
        if (JSONObject.NULL.toString().equals(c0532a.WZ)) {
            c0532a.WZ = "";
        }
        c0532a.aEG = jSONObject.optString(Constant.MAP_KEY_UUID);
        if (JSONObject.NULL.toString().equals(c0532a.aEG)) {
            c0532a.aEG = "";
        }
        c0532a.aEH = jSONObject.optBoolean("isDynamic");
        c0532a.Xa = jSONObject.optInt("screenWidth");
        c0532a.Xb = jSONObject.optInt("screenHeight");
        c0532a.atm = jSONObject.optString("imei");
        if (JSONObject.NULL.toString().equals(c0532a.atm)) {
            c0532a.atm = "";
        }
        c0532a.atn = jSONObject.optString(InnoMain.INNO_KEY_OAID);
        if (JSONObject.NULL.toString().equals(c0532a.atn)) {
            c0532a.atn = "";
        }
        c0532a.azo = jSONObject.optString("androidId");
        if (JSONObject.NULL.toString().equals(c0532a.azo)) {
            c0532a.azo = "";
        }
        c0532a.azF = jSONObject.optString("mac");
        if (JSONObject.NULL.toString().equals(c0532a.azF)) {
            c0532a.azF = "";
        }
        c0532a.Xc = jSONObject.optInt("statusBarHeight");
        c0532a.Xd = jSONObject.optInt("titleBarHeight");
        c0532a.aEI = jSONObject.optString("bridgeVersion");
        if (JSONObject.NULL.toString().equals(c0532a.aEI)) {
            c0532a.aEI = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(a.C0532a c0532a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c0532a.WO;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "SDKVersion", c0532a.WO);
        }
        int i10 = c0532a.WP;
        if (i10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "SDKVersionCode", i10);
        }
        String str2 = c0532a.ayD;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "tkVersion", c0532a.ayD);
        }
        String str3 = c0532a.WQ;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "sdkApiVersion", c0532a.WQ);
        }
        int i11 = c0532a.WR;
        if (i11 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "sdkApiVersionCode", i11);
        }
        int i12 = c0532a.sdkType;
        if (i12 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, ALBiometricsKeys.KEY_SDK_TYPE, i12);
        }
        String str4 = c0532a.appVersion;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, AttributionReporter.APP_VERSION, c0532a.appVersion);
        }
        String str5 = c0532a.appName;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "appName", c0532a.appName);
        }
        String str6 = c0532a.appId;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "appId", c0532a.appId);
        }
        String str7 = c0532a.aEF;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "globalId", c0532a.aEF);
        }
        String str8 = c0532a.azu;
        if (str8 != null && !str8.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "eGid", c0532a.azu);
        }
        String str9 = c0532a.azt;
        if (str9 != null && !str9.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "deviceSig", c0532a.azt);
        }
        String str10 = c0532a.WS;
        if (str10 != null && !str10.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, ConfigBean.Field.NETWORK_TYPE, c0532a.WS);
        }
        String str11 = c0532a.WT;
        if (str11 != null && !str11.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "manufacturer", c0532a.WT);
        }
        String str12 = c0532a.model;
        if (str12 != null && !str12.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, com.baidu.mobads.sdk.internal.bk.f9900i, c0532a.model);
        }
        String str13 = c0532a.WU;
        if (str13 != null && !str13.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "deviceBrand", c0532a.WU);
        }
        int i13 = c0532a.WV;
        if (i13 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "osType", i13);
        }
        String str14 = c0532a.WW;
        if (str14 != null && !str14.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "systemVersion", c0532a.WW);
        }
        int i14 = c0532a.WX;
        if (i14 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "osApi", i14);
        }
        String str15 = c0532a.WY;
        if (str15 != null && !str15.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, FFmpegMediaMetadataRetriever.METADATA_KEY_LANGUAGE, c0532a.WY);
        }
        String str16 = c0532a.WZ;
        if (str16 != null && !str16.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "locale", c0532a.WZ);
        }
        String str17 = c0532a.aEG;
        if (str17 != null && !str17.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, Constant.MAP_KEY_UUID, c0532a.aEG);
        }
        boolean z10 = c0532a.aEH;
        if (z10) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "isDynamic", z10);
        }
        int i15 = c0532a.Xa;
        if (i15 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "screenWidth", i15);
        }
        int i16 = c0532a.Xb;
        if (i16 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "screenHeight", i16);
        }
        String str18 = c0532a.atm;
        if (str18 != null && !str18.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "imei", c0532a.atm);
        }
        String str19 = c0532a.atn;
        if (str19 != null && !str19.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, InnoMain.INNO_KEY_OAID, c0532a.atn);
        }
        String str20 = c0532a.azo;
        if (str20 != null && !str20.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "androidId", c0532a.azo);
        }
        String str21 = c0532a.azF;
        if (str21 != null && !str21.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "mac", c0532a.azF);
        }
        int i17 = c0532a.Xc;
        if (i17 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "statusBarHeight", i17);
        }
        int i18 = c0532a.Xd;
        if (i18 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "titleBarHeight", i18);
        }
        String str22 = c0532a.aEI;
        if (str22 != null && !str22.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "bridgeVersion", c0532a.aEI);
        }
        return jSONObject;
    }
}
