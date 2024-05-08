package com.alimm.tanx.core.ad.bean;

import com.alibaba.fastjson.annotation.JSONField;
import com.alimm.tanx.core.ad.listener.bean.IMaterialBean;
import wseemann.media.FFmpegMediaMetadataRetriever;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class CreativeItem extends BaseBean implements IMaterialBean {

    @JSONField(name = "action_text")
    public String actionText;

    @JSONField(name = "adv_logo")
    public String advLogo;

    @JSONField(name = "adv_name")
    public String advName;
    public String description;

    @JSONField(name = "img_url_height")
    public String imageHeight;

    @JSONField(name = "img_url_md5")
    public String imageMd5;

    @JSONField(name = "img_size")
    public String imageSize;

    @JSONField(name = "img_url")
    public String imageUrl;

    @JSONField(name = "img_url_width")
    public String imageWidth;

    @JSONField(name = "img_height")
    public String imgHeight;

    @JSONField(name = "img_sm")
    public String imgSm;

    @JSONField(name = "img_sm_height")
    public String imgSmHeight;

    @JSONField(name = "img_sm_md5")
    public String imgSmMd5;

    @JSONField(name = "img_sm_width")
    public String imgSmWidth;

    @JSONField(name = "img_width")
    public String imgWidth;

    @JSONField(name = "title")
    public String title;

    @JSONField(name = "video")
    public String video;

    @JSONField(name = "video_duration")
    public String videoDuration;

    @JSONField(name = FFmpegMediaMetadataRetriever.METADATA_KEY_VIDEO_HEIGHT)
    public String videoHeight;

    @JSONField(name = "video_md5")
    public String videoMd5;

    @JSONField(name = FFmpegMediaMetadataRetriever.METADATA_KEY_VIDEO_WIDTH)
    public String videoWidth;

    @Override // com.alimm.tanx.core.ad.listener.bean.IMaterialBean
    public String getActionText() {
        return this.actionText;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IMaterialBean
    public String getAdvLogo() {
        return this.advLogo;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IMaterialBean
    public String getAdvName() {
        return this.advName;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IMaterialBean
    public String getDescription() {
        return this.description;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IMaterialBean
    public String getImageHeight() {
        return this.imageHeight;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IMaterialBean
    public String getImageMd5() {
        return this.imageMd5;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IMaterialBean
    public String getImageSize() {
        return this.imageSize;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IMaterialBean
    public String getImageUrl() {
        return this.imageUrl;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IMaterialBean
    public String getImageWidth() {
        return this.imageWidth;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IMaterialBean
    public String getImgHeight() {
        return this.imgHeight;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IMaterialBean
    public String getImgSm() {
        return this.imgSm;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IMaterialBean
    public String getImgSmHeight() {
        return this.imgSmHeight;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IMaterialBean
    public String getImgSmMd5() {
        return this.imgSmMd5;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IMaterialBean
    public String getImgSmWidth() {
        return this.imgSmWidth;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IMaterialBean
    public String getImgWidth() {
        return this.imgWidth;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IMaterialBean
    public String getTitle() {
        return this.title;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IMaterialBean
    public String getVideo() {
        return this.video;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IMaterialBean
    public String getVideoDuration() {
        return this.videoDuration;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IMaterialBean
    public String getVideoHeight() {
        return this.videoHeight;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IMaterialBean
    public String getVideoMd5() {
        return this.videoMd5;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IMaterialBean
    public String getVideoWidth() {
        return this.videoWidth;
    }

    public void setActionText(String str) {
        this.actionText = str;
    }

    public void setAdvLogo(String str) {
        this.advLogo = str;
    }

    public void setAdvName(String str) {
        this.advName = str;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setImageHeight(String str) {
        this.imageHeight = str;
    }

    public void setImageMd5(String str) {
        this.imageMd5 = str;
    }

    public void setImageSize(String str) {
        this.imageSize = str;
    }

    public void setImageUrl(String str) {
        this.imageUrl = str;
    }

    public void setImageWidth(String str) {
        this.imageWidth = str;
    }

    public void setImgHeight(String str) {
        this.imgHeight = str;
    }

    public void setImgSm(String str) {
        this.imgSm = str;
    }

    public void setImgSmHeight(String str) {
        this.imgSmHeight = str;
    }

    public void setImgSmMd5(String str) {
        this.imgSmMd5 = str;
    }

    public void setImgSmWidth(String str) {
        this.imgSmWidth = str;
    }

    public void setImgWidth(String str) {
        this.imgWidth = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setVideo(String str) {
        this.video = str;
    }

    public void setVideoDuration(String str) {
        this.videoDuration = str;
    }

    public void setVideoHeight(String str) {
        this.videoHeight = str;
    }

    public void setVideoMd5(String str) {
        this.videoMd5 = str;
    }

    public void setVideoWidth(String str) {
        this.videoWidth = str;
    }
}
