package com.kwad.sdk.core.b.a;

import com.android.internal.org.bouncycastle.cms.CMSAttributeTableGenerator;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdStatusInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.AdVideoPreCacheConfig;
import com.kwad.sdk.core.response.model.PageInfo;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class ar implements com.kwad.sdk.core.d<AdTemplate> {
    private static void k(AdTemplate adTemplate, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adTemplate.mOriginJString = jSONObject.optString("mOriginJString");
        if (JSONObject.NULL.toString().equals(adTemplate.mOriginJString)) {
            adTemplate.mOriginJString = "";
        }
        adTemplate.posId = jSONObject.optLong("posId");
        adTemplate.adStyle = jSONObject.optInt("adStyle");
        adTemplate.type = jSONObject.optInt("type");
        adTemplate.contentType = jSONObject.optInt(CMSAttributeTableGenerator.CONTENT_TYPE);
        adTemplate.adInfoList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("adInfo");
        if (optJSONArray != null) {
            for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
                AdInfo adInfo = new AdInfo();
                adInfo.parseJson(optJSONArray.optJSONObject(i10));
                adTemplate.adInfoList.add(adInfo);
            }
        }
        adTemplate.impAdExtra = jSONObject.optString("impAdExtra");
        if (JSONObject.NULL.toString().equals(adTemplate.impAdExtra)) {
            adTemplate.impAdExtra = "";
        }
        adTemplate.llsid = jSONObject.optLong("llsid");
        adTemplate.mIsFromContent = jSONObject.optBoolean("mIsFromContent");
        adTemplate.extra = jSONObject.optString("extra");
        if (JSONObject.NULL.toString().equals(adTemplate.extra)) {
            adTemplate.extra = "";
        }
        adTemplate.mUniqueId = jSONObject.optString("mUniqueId");
        if (JSONObject.NULL.toString().equals(adTemplate.mUniqueId)) {
            adTemplate.mUniqueId = "";
        }
        adTemplate.mBidEcpm = jSONObject.optLong("mBidEcpm");
        SceneImpl sceneImpl = new SceneImpl();
        adTemplate.mAdScene = sceneImpl;
        sceneImpl.parseJson(jSONObject.optJSONObject("mAdScene"));
        adTemplate.realShowType = jSONObject.optInt("realShowType");
        adTemplate.mInitVoiceStatus = jSONObject.optInt("mInitVoiceStatus");
        adTemplate.mMediaPlayerType = jSONObject.optInt("mMediaPlayerType");
        VideoPlayerStatus videoPlayerStatus = new VideoPlayerStatus();
        adTemplate.mVideoPlayerStatus = videoPlayerStatus;
        videoPlayerStatus.parseJson(jSONObject.optJSONObject("mVideoPlayerStatus"));
        adTemplate.mOutClickTimeParam = jSONObject.optLong("mOutClickTimeParam", new Long("-1").longValue());
        adTemplate.mVisibleTimeParam = jSONObject.optLong("mVisibleTimeParam", new Long("-1").longValue());
        adTemplate.mIsLeftSlipStatus = jSONObject.optInt("mIsLeftSlipStatus");
        adTemplate.mPhotoResponseType = jSONObject.optInt("mPhotoResponseType");
        PageInfo pageInfo = new PageInfo();
        adTemplate.mPageInfo = pageInfo;
        pageInfo.parseJson(jSONObject.optJSONObject("mPageInfo"));
        adTemplate.mIsForceJumpLandingPage = jSONObject.optBoolean("mIsForceJumpLandingPage", new Boolean("false").booleanValue());
        adTemplate.mIsAudioEnable = jSONObject.optBoolean("mIsAudioEnable");
        adTemplate.mRewardVerifyCalled = jSONObject.optBoolean("mRewardVerifyCalled");
        adTemplate.isWebViewDownload = jSONObject.optBoolean("isWebViewDownload");
        adTemplate.watched = jSONObject.optBoolean("watched");
        adTemplate.converted = jSONObject.optBoolean("converted");
        adTemplate.fromCache = jSONObject.optBoolean("fromCache", new Boolean("false").booleanValue());
        adTemplate.loadDataTime = jSONObject.optLong("loadDataTime");
        adTemplate.showStartTime = jSONObject.optLong("showStartTime");
        adTemplate.notNetworkRequest = jSONObject.optBoolean("notNetworkRequest");
        adTemplate.downloadDuration = jSONObject.optLong("downloadDuration");
        adTemplate.adLoadTotalTime = jSONObject.optLong("adLoadTotalTime");
        adTemplate.adShowStartTimeStamp = jSONObject.optLong("adShowStartTimeStamp");
        AdStatusInfo adStatusInfo = new AdStatusInfo();
        adTemplate.mAdStatusInfo = adStatusInfo;
        adStatusInfo.parseJson(jSONObject.optJSONObject("mAdStatusInfo"));
        AdVideoPreCacheConfig adVideoPreCacheConfig = new AdVideoPreCacheConfig();
        adTemplate.adVideoPreCacheConfig = adVideoPreCacheConfig;
        adVideoPreCacheConfig.parseJson(jSONObject.optJSONObject("adVideoPreCacheConfig"));
        adTemplate.isNativeRewardPreview = jSONObject.optBoolean("isNativeRewardPreview");
        adTemplate.mInstallApkFromSDK = jSONObject.optBoolean("mInstallApkFromSDK");
        adTemplate.mInstallApkFormUser = jSONObject.optBoolean("mInstallApkFormUser");
        adTemplate.mClickOpenAppStore = jSONObject.optBoolean("mClickOpenAppStore");
        adTemplate.mDataLoadTraceElement = jSONObject.optString("mDataLoadTraceElement");
        if (JSONObject.NULL.toString().equals(adTemplate.mDataLoadTraceElement)) {
            adTemplate.mDataLoadTraceElement = "";
        }
        adTemplate.mDataCacheTraceElement = jSONObject.optString("mDataCacheTraceElement");
        if (JSONObject.NULL.toString().equals(adTemplate.mDataCacheTraceElement)) {
            adTemplate.mDataCacheTraceElement = "";
        }
    }

    private static JSONObject l(AdTemplate adTemplate, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = adTemplate.mOriginJString;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "mOriginJString", adTemplate.mOriginJString);
        }
        long j10 = adTemplate.posId;
        if (j10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "posId", j10);
        }
        int i10 = adTemplate.adStyle;
        if (i10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adStyle", i10);
        }
        int i11 = adTemplate.type;
        if (i11 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "type", i11);
        }
        int i12 = adTemplate.contentType;
        if (i12 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, CMSAttributeTableGenerator.CONTENT_TYPE, i12);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "adInfo", adTemplate.adInfoList);
        String str2 = adTemplate.impAdExtra;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "impAdExtra", adTemplate.impAdExtra);
        }
        long j11 = adTemplate.llsid;
        if (j11 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "llsid", j11);
        }
        boolean z10 = adTemplate.mIsFromContent;
        if (z10) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "mIsFromContent", z10);
        }
        String str3 = adTemplate.extra;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "extra", adTemplate.extra);
        }
        String str4 = adTemplate.mUniqueId;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "mUniqueId", adTemplate.mUniqueId);
        }
        long j12 = adTemplate.mBidEcpm;
        if (j12 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "mBidEcpm", j12);
        }
        com.kwad.sdk.utils.t.a(jSONObject, "mAdScene", adTemplate.mAdScene);
        int i13 = adTemplate.realShowType;
        if (i13 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "realShowType", i13);
        }
        int i14 = adTemplate.mInitVoiceStatus;
        if (i14 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "mInitVoiceStatus", i14);
        }
        int i15 = adTemplate.mMediaPlayerType;
        if (i15 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "mMediaPlayerType", i15);
        }
        com.kwad.sdk.utils.t.a(jSONObject, "mVideoPlayerStatus", adTemplate.mVideoPlayerStatus);
        com.kwad.sdk.utils.t.putValue(jSONObject, "mOutClickTimeParam", adTemplate.mOutClickTimeParam);
        com.kwad.sdk.utils.t.putValue(jSONObject, "mVisibleTimeParam", adTemplate.mVisibleTimeParam);
        int i16 = adTemplate.mIsLeftSlipStatus;
        if (i16 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "mIsLeftSlipStatus", i16);
        }
        int i17 = adTemplate.mPhotoResponseType;
        if (i17 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "mPhotoResponseType", i17);
        }
        com.kwad.sdk.utils.t.a(jSONObject, "mPageInfo", adTemplate.mPageInfo);
        com.kwad.sdk.utils.t.putValue(jSONObject, "mIsForceJumpLandingPage", adTemplate.mIsForceJumpLandingPage);
        boolean z11 = adTemplate.mIsAudioEnable;
        if (z11) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "mIsAudioEnable", z11);
        }
        boolean z12 = adTemplate.mRewardVerifyCalled;
        if (z12) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "mRewardVerifyCalled", z12);
        }
        boolean z13 = adTemplate.isWebViewDownload;
        if (z13) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "isWebViewDownload", z13);
        }
        boolean z14 = adTemplate.watched;
        if (z14) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "watched", z14);
        }
        boolean z15 = adTemplate.converted;
        if (z15) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "converted", z15);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "fromCache", adTemplate.fromCache);
        long j13 = adTemplate.loadDataTime;
        if (j13 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "loadDataTime", j13);
        }
        long j14 = adTemplate.showStartTime;
        if (j14 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "showStartTime", j14);
        }
        boolean z16 = adTemplate.notNetworkRequest;
        if (z16) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "notNetworkRequest", z16);
        }
        long j15 = adTemplate.downloadDuration;
        if (j15 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "downloadDuration", j15);
        }
        long j16 = adTemplate.adLoadTotalTime;
        if (j16 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adLoadTotalTime", j16);
        }
        long j17 = adTemplate.adShowStartTimeStamp;
        if (j17 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adShowStartTimeStamp", j17);
        }
        com.kwad.sdk.utils.t.a(jSONObject, "mAdStatusInfo", adTemplate.mAdStatusInfo);
        com.kwad.sdk.utils.t.a(jSONObject, "adVideoPreCacheConfig", adTemplate.adVideoPreCacheConfig);
        boolean z17 = adTemplate.isNativeRewardPreview;
        if (z17) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "isNativeRewardPreview", z17);
        }
        boolean z18 = adTemplate.mInstallApkFromSDK;
        if (z18) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "mInstallApkFromSDK", z18);
        }
        boolean z19 = adTemplate.mInstallApkFormUser;
        if (z19) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "mInstallApkFormUser", z19);
        }
        boolean z20 = adTemplate.mClickOpenAppStore;
        if (z20) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "mClickOpenAppStore", z20);
        }
        String str5 = adTemplate.mDataLoadTraceElement;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "mDataLoadTraceElement", adTemplate.mDataLoadTraceElement);
        }
        String str6 = adTemplate.mDataCacheTraceElement;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "mDataCacheTraceElement", adTemplate.mDataCacheTraceElement);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* synthetic */ void a(AdTemplate adTemplate, JSONObject jSONObject) {
        k(adTemplate, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* synthetic */ JSONObject b(AdTemplate adTemplate, JSONObject jSONObject) {
        return l(adTemplate, jSONObject);
    }
}
