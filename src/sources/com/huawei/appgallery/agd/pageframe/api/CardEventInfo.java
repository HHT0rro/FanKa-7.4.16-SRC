package com.huawei.appgallery.agd.pageframe.api;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.huawei.appgallery.agd.pageframe.PageFrameLog;
import com.huawei.flexiblelayout.FLContext;
import com.huawei.flexiblelayout.card.FLCell;
import com.huawei.flexiblelayout.data.FLCardData;
import com.huawei.flexiblelayout.data.primitive.FLMap;
import com.huawei.flexiblelayout.services.action.CardActionService;
import com.koushikdutta.quack.JavaScriptObject;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class CardEventInfo {
    public String adDeeplink;
    public String adFastLink;
    public String adId;
    public String adVideoUrl;
    public String adWapUrl;
    public String appName;
    public int cType;
    public String clickSource;
    public String detailId;
    public int downloadFlag;
    public String downloadParams;
    public FLCell<? extends FLCardData> flCell;
    public FLContext flContext;
    public String iconUri;
    public String installType;
    public int interactType;
    public boolean isAllowAgdResolution;
    public int jumpType;
    public String layoutId;
    public String packageName;
    public String slogan;
    public String slotId;
    public String type;
    public String uniqueId;
    public String version;
    public long videoDuration;
    public long videoProgress;
    public String visibility;

    public CardEventInfo() {
    }

    public final int a(JavaScriptObject javaScriptObject, String str, int i10) {
        Object obj = javaScriptObject.get(str);
        return obj instanceof Number ? ((Number) obj).intValue() : i10;
    }

    public final long b(JavaScriptObject javaScriptObject, String str) {
        Object obj = javaScriptObject.get(str);
        if (obj instanceof Number) {
            return ((Number) obj).longValue();
        }
        return 0L;
    }

    public final String c(FLMap fLMap, JavaScriptObject javaScriptObject, String str) {
        Object obj = javaScriptObject.get(str);
        if (obj instanceof String) {
            return (String) obj;
        }
        return fLMap != null ? fLMap.optString(str) : "";
    }

    public final void d(FLMap fLMap) {
        if (fLMap == null) {
            return;
        }
        FLMap optMap = fLMap.optMap(CardConstants.KEY_REFS_APP);
        if (optMap != null) {
            fLMap = optMap;
        }
        String optString = fLMap.optString("name", "");
        if (TextUtils.isEmpty(optString)) {
            optString = fLMap.optString("title", "");
        }
        this.appName = optString;
        this.iconUri = fLMap.optString("icon", "");
        this.isAllowAgdResolution = fLMap.optBoolean(CardConstants.KEY_IS_ALLOW_AGD_RESOLUTION, true);
        this.version = fLMap.optString("version", "");
        PageFrameLog.LOG.i("CardEventInfo", "appName: " + this.appName + " icon is empty: " + TextUtils.isEmpty(this.iconUri));
    }

    public final String e(FLMap fLMap, @NonNull JavaScriptObject javaScriptObject) {
        JSONObject jSONObject = new JSONObject();
        String c4 = c(fLMap, javaScriptObject, "downloadParams");
        if (!TextUtils.isEmpty(c4)) {
            PageFrameLog.LOG.i("CardEventInfo", "get downloadParams directly");
            return c4;
        }
        try {
            PageFrameLog.LOG.i("CardEventInfo", "Put detailId Success");
            jSONObject.put("detailId", c(fLMap, javaScriptObject, "detailId"));
        } catch (JSONException unused) {
            PageFrameLog.LOG.e("CardEventInfo", "Put detailId Exception");
        }
        return jSONObject.toString();
    }

    public String toString() {
        return "ClickInfo{, type='" + this.type + "', uniqueId='" + this.uniqueId + "', slotId='" + this.slotId + "', adId='" + this.adId + "', packageName='" + this.packageName + "', installType='" + this.installType + "', downloadParams='" + this.downloadParams + "', adVideoUrl='" + TextUtils.isEmpty(this.adVideoUrl) + "', videoProgress='" + this.videoProgress + "', videoDuration='" + this.videoDuration + "', clickSource='" + this.clickSource + "', version='" + this.version + "', interactType='" + this.interactType + "'}";
    }

    public CardEventInfo(@NonNull FLContext fLContext, @NonNull FLCell<? extends FLCardData> fLCell, @NonNull CardActionService.Action action) {
        this.flContext = fLContext;
        this.flCell = fLCell;
        this.type = action.getType();
        this.uniqueId = "";
        this.slotId = "";
        this.layoutId = "";
        this.adDeeplink = "";
        this.adFastLink = "";
        this.adId = "";
        this.packageName = "";
        this.detailId = "";
        this.adWapUrl = "";
        this.adVideoUrl = "";
        this.videoProgress = 0L;
        this.videoDuration = 0L;
        this.downloadParams = "";
        this.installType = "";
        this.downloadFlag = 0;
        this.appName = "";
        this.iconUri = "";
        this.jumpType = 0;
        this.clickSource = "";
        this.version = "";
        this.slogan = "";
        this.interactType = 0;
        this.cType = 0;
        if (action.getParam() == null || !(action.getParam() instanceof JavaScriptObject)) {
            return;
        }
        JavaScriptObject javaScriptObject = (JavaScriptObject) action.getParam();
        FLMap data = fLCell.getData().getData();
        this.uniqueId = c(data, javaScriptObject, "uniqueId");
        this.slotId = c(data, javaScriptObject, "slotId");
        this.layoutId = c(data, javaScriptObject, CardConstants.KEY_LAYOUT_ID);
        this.adDeeplink = c(data, javaScriptObject, CardConstants.KEY_DEEP_LINK);
        this.adFastLink = c(data, javaScriptObject, CardConstants.KEY_FAST_LINK);
        this.adId = c(data, javaScriptObject, "adId");
        this.packageName = c(data, javaScriptObject, "packageName");
        this.detailId = c(data, javaScriptObject, "detailId");
        this.adWapUrl = c(data, javaScriptObject, CardConstants.KEY_WEB_URL);
        this.adVideoUrl = c(data, javaScriptObject, CardConstants.KEY_VIDEO_URL);
        this.videoProgress = b(javaScriptObject, "videoProgress");
        this.videoDuration = b(javaScriptObject, "videoDuration");
        this.slogan = c(data, javaScriptObject, "title");
        this.interactType = a(javaScriptObject, "interactType", 0);
        this.cType = a(javaScriptObject, "ctype", 0);
        this.installType = c(data, javaScriptObject, "installType");
        this.downloadFlag = a(javaScriptObject, CardConstants.KEY_DOWNLOAD_FLAG, 1);
        this.downloadParams = e(data, javaScriptObject);
        this.visibility = c(data, javaScriptObject, "visibility");
        this.clickSource = c(data, javaScriptObject, "clickSource");
        d(data);
    }
}
