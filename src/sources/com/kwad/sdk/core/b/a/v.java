package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdStyleInfo;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class v implements com.kwad.sdk.core.d<AdInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo adInfo, JSONObject jSONObject) {
        a2(adInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo adInfo, JSONObject jSONObject) {
        return b2(adInfo, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(AdInfo adInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        AdInfo.AdBaseInfo adBaseInfo = new AdInfo.AdBaseInfo();
        adInfo.adBaseInfo = adBaseInfo;
        adBaseInfo.parseJson(jSONObject.optJSONObject("adBaseInfo"));
        AdInfo.AdvertiserInfo advertiserInfo = new AdInfo.AdvertiserInfo();
        adInfo.advertiserInfo = advertiserInfo;
        advertiserInfo.parseJson(jSONObject.optJSONObject("advertiserInfo"));
        AdInfo.AdConversionInfo adConversionInfo = new AdInfo.AdConversionInfo();
        adInfo.adConversionInfo = adConversionInfo;
        adConversionInfo.parseJson(jSONObject.optJSONObject("adConversionInfo"));
        AdInfo.AdMaterialInfo adMaterialInfo = new AdInfo.AdMaterialInfo();
        adInfo.adMaterialInfo = adMaterialInfo;
        adMaterialInfo.parseJson(jSONObject.optJSONObject("adMaterialInfo"));
        adInfo.adTrackInfoList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("adTrackInfo");
        if (optJSONArray != null) {
            for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
                AdInfo.AdTrackInfo adTrackInfo = new AdInfo.AdTrackInfo();
                adTrackInfo.parseJson(optJSONArray.optJSONObject(i10));
                adInfo.adTrackInfoList.add(adTrackInfo);
            }
        }
        AdInfo.DownloadSafeInfo downloadSafeInfo = new AdInfo.DownloadSafeInfo();
        adInfo.downloadSafeInfo = downloadSafeInfo;
        downloadSafeInfo.parseJson(jSONObject.optJSONObject("downloadSafeInfo"));
        AdInfo.UnDownloadConf unDownloadConf = new AdInfo.UnDownloadConf();
        adInfo.unDownloadConf = unDownloadConf;
        unDownloadConf.parseJson(jSONObject.optJSONObject("unDownloadConf"));
        adInfo.status = jSONObject.optInt("status");
        adInfo.progress = jSONObject.optInt("progress");
        adInfo.soFarBytes = jSONObject.optLong("soFarBytes");
        adInfo.totalBytes = jSONObject.optLong(DBDefinition.TOTAL_BYTES);
        adInfo.downloadFilePath = jSONObject.optString("downloadFilePath");
        if (JSONObject.NULL.toString().equals(adInfo.downloadFilePath)) {
            adInfo.downloadFilePath = "";
        }
        adInfo.downloadId = jSONObject.optString("downloadId");
        if (JSONObject.NULL.toString().equals(adInfo.downloadId)) {
            adInfo.downloadId = "";
        }
        adInfo.mStartDownloadTime = jSONObject.optLong("mStartDownloadTime");
        AdInfo.AdPreloadInfo adPreloadInfo = new AdInfo.AdPreloadInfo();
        adInfo.adPreloadInfo = adPreloadInfo;
        adPreloadInfo.parseJson(jSONObject.optJSONObject("adPreloadInfo"));
        AdInfo.AdSplashInfo adSplashInfo = new AdInfo.AdSplashInfo();
        adInfo.adSplashInfo = adSplashInfo;
        adSplashInfo.parseJson(jSONObject.optJSONObject("adSplashInfo"));
        AdStyleInfo adStyleInfo = new AdStyleInfo();
        adInfo.adStyleInfo = adStyleInfo;
        adStyleInfo.parseJson(jSONObject.optJSONObject("adStyleInfo"));
        AdStyleInfo adStyleInfo2 = new AdStyleInfo();
        adInfo.adStyleInfo2 = adStyleInfo2;
        adStyleInfo2.parseJson(jSONObject.optJSONObject("adStyleInfo2"));
        AdInfo.AdAggregateInfo adAggregateInfo = new AdInfo.AdAggregateInfo();
        adInfo.adAggregateInfo = adAggregateInfo;
        adAggregateInfo.parseJson(jSONObject.optJSONObject("adAggregateInfo"));
        AdInfo.AdRewardInfo adRewardInfo = new AdInfo.AdRewardInfo();
        adInfo.adRewardInfo = adRewardInfo;
        adRewardInfo.parseJson(jSONObject.optJSONObject("adRewardInfo"));
        adInfo.serverExt = jSONObject.optString("serverExt");
        if (JSONObject.NULL.toString().equals(adInfo.serverExt)) {
            adInfo.serverExt = "";
        }
        AdInfo.AdStyleConfInfo adStyleConfInfo = new AdInfo.AdStyleConfInfo();
        adInfo.adStyleConfInfo = adStyleConfInfo;
        adStyleConfInfo.parseJson(jSONObject.optJSONObject("adStyleConfInfo"));
        AdInfo.FullScreenVideoInfo fullScreenVideoInfo = new AdInfo.FullScreenVideoInfo();
        adInfo.fullScreenVideoInfo = fullScreenVideoInfo;
        fullScreenVideoInfo.parseJson(jSONObject.optJSONObject("fullScreenVideoInfo"));
        AdInfo.AdFeedInfo adFeedInfo = new AdInfo.AdFeedInfo();
        adInfo.adFeedInfo = adFeedInfo;
        adFeedInfo.parseJson(jSONObject.optJSONObject("adFeedInfo"));
        AdInfo.AdInsertScreenInfo adInsertScreenInfo = new AdInfo.AdInsertScreenInfo();
        adInfo.adInsertScreenInfo = adInsertScreenInfo;
        adInsertScreenInfo.parseJson(jSONObject.optJSONObject("adInsertScreenInfo"));
        AdProductInfo adProductInfo = new AdProductInfo();
        adInfo.adProductInfo = adProductInfo;
        adProductInfo.parseJson(jSONObject.optJSONObject("adProductInfo"));
        adInfo.ocpcActionType = jSONObject.optInt("ocpcActionType");
        AdMatrixInfo adMatrixInfo = new AdMatrixInfo();
        adInfo.adMatrixInfo = adMatrixInfo;
        adMatrixInfo.parseJson(jSONObject.optJSONObject("adMatrixInfo"));
        adInfo.trace = jSONObject.optString("trace");
        if (JSONObject.NULL.toString().equals(adInfo.trace)) {
            adInfo.trace = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdInfo adInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "adBaseInfo", adInfo.adBaseInfo);
        com.kwad.sdk.utils.t.a(jSONObject, "advertiserInfo", adInfo.advertiserInfo);
        com.kwad.sdk.utils.t.a(jSONObject, "adConversionInfo", adInfo.adConversionInfo);
        com.kwad.sdk.utils.t.a(jSONObject, "adMaterialInfo", adInfo.adMaterialInfo);
        com.kwad.sdk.utils.t.putValue(jSONObject, "adTrackInfo", adInfo.adTrackInfoList);
        com.kwad.sdk.utils.t.a(jSONObject, "downloadSafeInfo", adInfo.downloadSafeInfo);
        com.kwad.sdk.utils.t.a(jSONObject, "unDownloadConf", adInfo.unDownloadConf);
        int i10 = adInfo.status;
        if (i10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "status", i10);
        }
        int i11 = adInfo.progress;
        if (i11 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "progress", i11);
        }
        long j10 = adInfo.soFarBytes;
        if (j10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "soFarBytes", j10);
        }
        long j11 = adInfo.totalBytes;
        if (j11 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, DBDefinition.TOTAL_BYTES, j11);
        }
        String str = adInfo.downloadFilePath;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "downloadFilePath", adInfo.downloadFilePath);
        }
        String str2 = adInfo.downloadId;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "downloadId", adInfo.downloadId);
        }
        long j12 = adInfo.mStartDownloadTime;
        if (j12 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "mStartDownloadTime", j12);
        }
        com.kwad.sdk.utils.t.a(jSONObject, "adPreloadInfo", adInfo.adPreloadInfo);
        com.kwad.sdk.utils.t.a(jSONObject, "adSplashInfo", adInfo.adSplashInfo);
        com.kwad.sdk.utils.t.a(jSONObject, "adStyleInfo", adInfo.adStyleInfo);
        com.kwad.sdk.utils.t.a(jSONObject, "adStyleInfo2", adInfo.adStyleInfo2);
        com.kwad.sdk.utils.t.a(jSONObject, "adAggregateInfo", adInfo.adAggregateInfo);
        com.kwad.sdk.utils.t.a(jSONObject, "adRewardInfo", adInfo.adRewardInfo);
        String str3 = adInfo.serverExt;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "serverExt", adInfo.serverExt);
        }
        com.kwad.sdk.utils.t.a(jSONObject, "adStyleConfInfo", adInfo.adStyleConfInfo);
        com.kwad.sdk.utils.t.a(jSONObject, "fullScreenVideoInfo", adInfo.fullScreenVideoInfo);
        com.kwad.sdk.utils.t.a(jSONObject, "adFeedInfo", adInfo.adFeedInfo);
        com.kwad.sdk.utils.t.a(jSONObject, "adInsertScreenInfo", adInfo.adInsertScreenInfo);
        com.kwad.sdk.utils.t.a(jSONObject, "adProductInfo", adInfo.adProductInfo);
        int i12 = adInfo.ocpcActionType;
        if (i12 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "ocpcActionType", i12);
        }
        com.kwad.sdk.utils.t.a(jSONObject, "adMatrixInfo", adInfo.adMatrixInfo);
        String str4 = adInfo.trace;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "trace", adInfo.trace);
        }
        return jSONObject;
    }
}
