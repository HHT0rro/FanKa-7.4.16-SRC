package com.huawei.appgallery.agd.core.impl.store.carddata;

import androidx.annotation.NonNull;
import com.huawei.appgallery.agd.core.api.Image;
import com.huawei.appgallery.agd.core.api.Video;
import com.huawei.appgallery.agd.pageframe.api.CardConstants;
import com.huawei.appgallery.agd.serverreq.json.JsonBean;
import com.huawei.appgallery.agd.serverreq.json.annotation.NetworkTransmission;
import com.huawei.openalliance.ad.constant.ax;
import java.util.ArrayList;
import java.util.List;
import n9.a;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class CreativeInfo extends JsonBean {
    private static final String TAG = "CreativeInfo";

    @NetworkTransmission
    private String adDeepLink;

    @NetworkTransmission
    private String adWapUrl;

    @NetworkTransmission
    private String buttonText;

    @NetworkTransmission
    private String creativeType;

    @NetworkTransmission
    private int creativeTypeCode;

    @NetworkTransmission
    private String detailId;

    @NetworkTransmission
    private Integer fastAppAdCardShowFlag;

    @NetworkTransmission
    private String icon;

    @NetworkTransmission
    private List<Image> images;
    private boolean isApp;
    public RewardData rewardData;

    @NetworkTransmission
    private String slogan;

    @NetworkTransmission
    private String title;

    @NetworkTransmission
    private Video video;
    private int videoLength;
    private String videoUri;

    @NonNull
    public static CreativeInfo parse(@NonNull JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        CreativeInfo creativeInfo = new CreativeInfo();
        creativeInfo.adDeepLink = jSONObject.optString("adDeepLink");
        creativeInfo.detailId = jSONObject.optString("detailId");
        creativeInfo.adWapUrl = jSONObject.optString(CardConstants.KEY_WEB_URL);
        creativeInfo.slogan = jSONObject.optString(CardConstants.KEY_SLOGAN);
        creativeInfo.buttonText = jSONObject.optString("buttonText");
        creativeInfo.icon = jSONObject.optString("icon");
        creativeInfo.isApp = jSONObject.has(CardConstants.KEY_REFS_APP);
        try {
            creativeInfo.videoUri = jSONObject.getJSONObject("video").getString("url");
            creativeInfo.videoLength = jSONObject.getJSONObject("video").getInt("duration");
        } catch (JSONException unused) {
            a.f52175d.e(TAG, "CreativeInfo parse with JSONException");
        }
        creativeInfo.rewardData = RewardData.parse(jSONObject.optJSONObject("rewardInfo"));
        creativeInfo.title = jSONObject.optString("title");
        creativeInfo.creativeType = jSONObject.optString("creativeType");
        creativeInfo.creativeTypeCode = jSONObject.optInt("creativeTypeCode");
        if (jSONObject.has(CardConstants.KEY_IMAGES)) {
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray(CardConstants.KEY_IMAGES);
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i10 = 0; i10 < length; i10++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i10);
                    Image image = new Image();
                    image.setImgUrl(optJSONObject.optString("imgUrl"));
                    image.setWidth(optJSONObject.optInt("width"));
                    image.setHeight(optJSONObject.optInt("height"));
                    arrayList.add(image);
                }
                creativeInfo.images = arrayList;
            }
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("video");
        if (optJSONObject2 != null) {
            Video video = new Video();
            video.setUrl(optJSONObject2.optString("url"));
            video.setDuration(optJSONObject2.optLong("duration"));
            video.setSize(optJSONObject2.optLong("size"));
            video.setSha256(optJSONObject2.optString(ax.aq));
            video.setRation((float) optJSONObject2.optDouble("ration"));
            video.setCoverUrl(optJSONObject2.optString("coverUrl"));
            video.setCoverWidth(optJSONObject2.optInt("coverWidth"));
            video.setCoverHeight(optJSONObject2.optInt("coverHeight"));
            creativeInfo.video = video;
        }
        return creativeInfo;
    }

    public String getAdDeepLink() {
        return this.adDeepLink;
    }

    public String getAdWapUri() {
        return this.adWapUrl;
    }

    public String getButtonText() {
        return this.buttonText;
    }

    public String getCreativeType() {
        return this.creativeType;
    }

    public int getCreativeTypeCode() {
        return this.creativeTypeCode;
    }

    public String getDetailId() {
        return this.detailId;
    }

    public Integer getFastAppAdCardShowFlag() {
        return this.fastAppAdCardShowFlag;
    }

    public String getIcon() {
        return this.icon;
    }

    public List<Image> getImages() {
        return this.images;
    }

    public RewardData getRewardData() {
        return this.rewardData;
    }

    public String getSlogan() {
        return this.slogan;
    }

    public String getTitle() {
        return this.title;
    }

    public Video getVideo() {
        return this.video;
    }

    public int getVideoLength() {
        return this.videoLength;
    }

    public String getVideoUri() {
        return this.videoUri;
    }

    public boolean isApp() {
        return this.isApp;
    }

    public boolean isValid() {
        return (this.rewardData == null || this.videoUri == null) ? false : true;
    }

    public boolean isValidForAgdPro() {
        return true;
    }

    public void setAdDeepLink(String str) {
        this.adDeepLink = str;
    }

    public void setButtonText(String str) {
        this.buttonText = str;
    }

    public void setDetailId(String str) {
        this.detailId = str;
    }

    public void setFastAppAdCardShowFlag(Integer num) {
        this.fastAppAdCardShowFlag = num;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public void setImages(List<Image> list) {
        this.images = list;
    }

    public void setSlogan(String str) {
        this.slogan = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("CreativeInfo{rewardData=");
        sb2.append((Object) this.rewardData);
        sb2.append(", adWapUri='");
        sb2.append(this.adWapUrl);
        sb2.append('\'');
        sb2.append(", videoUri='");
        sb2.append(this.videoUri);
        sb2.append('\'');
        sb2.append(", isApp=");
        sb2.append(this.isApp);
        sb2.append(", title='");
        sb2.append(this.title);
        sb2.append('\'');
        sb2.append(", creativeType='");
        sb2.append(this.creativeType);
        sb2.append('\'');
        sb2.append(", creativeTypeCode=");
        sb2.append(this.creativeTypeCode);
        sb2.append(", image=");
        sb2.append((Object) this.images);
        sb2.append(", slogan='");
        sb2.append(this.slogan);
        sb2.append('\'');
        sb2.append(", buttonText='");
        sb2.append(this.buttonText);
        sb2.append('\'');
        sb2.append(", icon='");
        sb2.append(this.icon);
        sb2.append('\'');
        sb2.append(", detailId='");
        sb2.append(this.detailId != null ? "not null" : "null");
        sb2.append('\'');
        sb2.append(", adDeepLink='");
        sb2.append(this.adDeepLink);
        sb2.append('\'');
        sb2.append('}');
        return sb2.toString();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class RewardData extends JsonBean {

        /* renamed from: id, reason: collision with root package name */
        @NetworkTransmission
        public String f27456id;

        @NetworkTransmission
        public int needServerCheck;

        @NetworkTransmission
        public String rewardName;

        @NetworkTransmission
        public int rewardNumber;

        @NetworkTransmission
        public String rewardSign;

        @NetworkTransmission
        public int rewardTime;

        @NetworkTransmission
        public long ts;

        private RewardData() {
        }

        public static RewardData parse(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            RewardData rewardData = new RewardData();
            rewardData.rewardName = jSONObject.optString("rewardName");
            rewardData.rewardNumber = jSONObject.optInt("rewardNumber");
            rewardData.rewardTime = jSONObject.optInt("rewardTime");
            rewardData.rewardSign = jSONObject.optString("rewardSign");
            rewardData.needServerCheck = jSONObject.optInt("needServerCheck");
            rewardData.f27456id = jSONObject.optString("id");
            rewardData.ts = jSONObject.optLong("ts");
            return rewardData;
        }

        public static RewardData parse(String str, int i10) {
            RewardData rewardData = new RewardData();
            rewardData.rewardName = str;
            rewardData.rewardNumber = i10;
            return rewardData;
        }
    }
}
