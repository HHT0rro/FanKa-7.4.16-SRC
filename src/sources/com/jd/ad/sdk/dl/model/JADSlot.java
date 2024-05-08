package com.jd.ad.sdk.dl.model;

import androidx.annotation.NonNull;
import com.jd.ad.sdk.bl.dynamicrender.DynamicRenderTemplateHelper;
import java.io.Serializable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class JADSlot implements Serializable {
    private int adDataRequestSourceType;
    private float adImageHeight;
    private float adImageWidth;
    private int adType;
    private int clickAreaType;
    private long clickTime;
    private long delayShowTime;
    private int displayScene;
    private DynamicRenderTemplateHelper dynamicRenderTemplateHelper = null;
    private long dynamicRenderViewInitSuccessTime;
    private int eventInteractionType;
    private float height;
    private boolean hideClose;
    private boolean hideSkip;
    private int interactionType;
    private boolean isFromNativeAd;
    private long loadSucTime;
    private long loadTime;
    private int mediaSpecSetType;
    private int modelClickAreaType;
    private int rem;
    private long renderSucTime;
    private String requestId;
    private int sen;
    private long showTime;
    private int skipTime;
    private final String slotID;
    private int templateId;
    private float tolerateTime;
    private float width;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface AdDataRequestSourceType {
        public static final int DATA_FROM_PRELOAD = 1;
        public static final int DATA_FROM_PRELOAD_CACHE = 2;
        public static final int DATA_FROM_REALTIME = 0;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface AdType {
        public static final int BANNER = 5;
        public static final int FEED = 2;
        public static final int FEED_VIDEO = 3;
        public static final int INTERSTITIAL = 4;
        public static final int REWARDED_VIDEO = 6;
        public static final int SPLASH = 1;
        public static final int UNKNOWN = 0;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class Builder {
        private float adImageHeight;
        private float adImageWidth;
        private int adType;
        private int eventInteractionType;
        private float height;
        private boolean hideClose;
        private boolean hideSkip;
        private String slotID;
        private int templateId;
        private float width;
        private int skipTime = 5;
        private float tolerateTime = 5.0f;
        private int clickAreaType = 0;
        private int interactionType = 0;

        public JADSlot build() {
            return new JADSlot(this);
        }

        public Builder setAdType(int i10) {
            this.adType = i10;
            return this;
        }

        public Builder setCloseButtonHidden(boolean z10) {
            this.hideClose = z10;
            return this;
        }

        public Builder setEventInteractionType(int i10) {
            this.eventInteractionType = i10;
            return this;
        }

        public Builder setImageSize(float f10, float f11) {
            this.adImageWidth = f10;
            this.adImageHeight = f11;
            return this;
        }

        @Deprecated
        public Builder setInteractionType(int i10) {
            this.interactionType = i10;
            return this;
        }

        public Builder setSize(float f10, float f11) {
            this.width = f10;
            this.height = f11;
            return this;
        }

        public Builder setSkipButtonHidden(boolean z10) {
            this.hideSkip = z10;
            return this;
        }

        public Builder setSkipTime(int i10) {
            if (i10 < 1) {
                this.skipTime = 5;
            } else {
                this.skipTime = i10;
            }
            return this;
        }

        public Builder setSlotID(@NonNull String str) {
            this.slotID = str;
            return this;
        }

        public Builder setSplashClickAreaType(int i10) {
            this.clickAreaType = i10;
            return this;
        }

        public Builder setTemplateId(int i10) {
            this.templateId = i10;
            return this;
        }

        public Builder setTolerateTime(float f10) {
            this.tolerateTime = Math.max(f10, 3.0f);
            return this;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface ClickStyle {
        public static final int NORMAL = 3;
        public static final int ONLY_TEXT = 1;
        public static final int ONLY_TEXT_CLICK = 2;
        public static final int SERVER = 0;
        public static final int SHOW_TEXT_MASK = 4;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface EventInteractionType {
        public static final int EVENT_INTERACTION_TYPE_NORMAL = 0;
        public static final int EVENT_INTERACTION_TYPE_SHAKE = 1;
        public static final int EVENT_INTERACTION_TYPE_SWIPE_UP = 2;
    }

    @Deprecated
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface InteractionType {
        public static final int NORMAL = 0;
        public static final int SHAKE = 1;
        public static final int SWIPE = 2;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface MediaSpecSetType {
        public static final int MEDIA_SPEC_SET_TYPE_FEED16_9_SINGLE = 10003;
        public static final int MEDIA_SPEC_SET_TYPE_FEED2_1_SINGLE = 10006;
        public static final int MEDIA_SPEC_SET_TYPE_FEED3_2_GROUP = 10005;
        public static final int MEDIA_SPEC_SET_TYPE_FEED3_2_SINGLE = 10004;
        public static final int MEDIA_SPEC_SET_TYPE_NORMAL = 0;
        public static final int MEDIA_SPEC_SET_TYPE_SPLASH2_3_SINGLE = 10001;
        public static final int MEDIA_SPEC_SET_TYPE_SPLASH9_16_SINGLE = 10002;
    }

    public JADSlot(Builder builder) {
        this.skipTime = 5;
        this.slotID = builder.slotID;
        this.width = builder.width;
        this.height = builder.height;
        this.skipTime = builder.skipTime;
        this.hideClose = builder.hideClose;
        this.tolerateTime = builder.tolerateTime;
        this.clickAreaType = builder.clickAreaType;
        this.adImageWidth = builder.adImageWidth;
        this.adImageHeight = builder.adImageHeight;
        this.adType = builder.adType;
        this.interactionType = builder.interactionType;
        this.hideSkip = builder.hideSkip;
        this.eventInteractionType = builder.eventInteractionType;
        this.templateId = builder.templateId;
    }

    public int getAdDataRequestSourceType() {
        return this.adDataRequestSourceType;
    }

    public float getAdImageHeight() {
        return this.adImageHeight;
    }

    public float getAdImageWidth() {
        return this.adImageWidth;
    }

    public int getAdType() {
        return this.adType;
    }

    public int getClickAreaType() {
        return this.clickAreaType;
    }

    public long getClickTime() {
        return this.clickTime;
    }

    public long getDelayShowTime() {
        return this.delayShowTime;
    }

    public int getDisplayScene() {
        return this.displayScene;
    }

    public int getDynamicInteractionType() {
        return this.interactionType;
    }

    public DynamicRenderTemplateHelper getDynamicRenderTemplateHelper() {
        return this.dynamicRenderTemplateHelper;
    }

    public long getDynamicRenderViewInitSuccessTime() {
        return this.dynamicRenderViewInitSuccessTime;
    }

    public int getEventInteractionType() {
        return this.eventInteractionType;
    }

    public float getHeight() {
        return this.height;
    }

    public long getLoadSucTime() {
        return this.loadSucTime;
    }

    public long getLoadTime() {
        return this.loadTime;
    }

    public int getMediaSpecSetType() {
        return this.mediaSpecSetType;
    }

    public int getModelClickAreaType() {
        return this.modelClickAreaType;
    }

    public int getRem() {
        return this.rem;
    }

    public long getRenderSucTime() {
        return this.renderSucTime;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public int getSen() {
        return this.sen;
    }

    public long getShowTime() {
        return this.showTime;
    }

    public int getSkipTime() {
        return this.skipTime;
    }

    public String getSlotID() {
        return this.slotID;
    }

    public int getTemplateId() {
        return this.templateId;
    }

    public float getTolerateTime() {
        return this.tolerateTime;
    }

    public float getWidth() {
        return this.width;
    }

    public boolean isFromNativeAd() {
        return this.isFromNativeAd;
    }

    public boolean isHideClose() {
        return this.hideClose;
    }

    public boolean isHideSkip() {
        return this.hideSkip;
    }

    public void setAdDataRequestSourceType(int i10) {
        this.adDataRequestSourceType = i10;
    }

    public void setAdImageHeight(float f10) {
        this.adImageHeight = f10;
    }

    public void setAdImageWidth(float f10) {
        this.adImageWidth = f10;
    }

    public void setAdType(int i10) {
        this.adType = i10;
    }

    public void setClickAreaType(int i10) {
        this.clickAreaType = i10;
    }

    public void setClickTime(long j10) {
        this.clickTime = j10;
    }

    public void setDelayShowTime(long j10) {
        this.delayShowTime = j10;
    }

    public void setDisplayScene(int i10) {
        this.displayScene = i10;
    }

    public void setDynamicRenderTemplateHelper(DynamicRenderTemplateHelper dynamicRenderTemplateHelper) {
        this.dynamicRenderTemplateHelper = dynamicRenderTemplateHelper;
    }

    public void setDynamicRenderViewInitSuccessTime(long j10) {
        this.dynamicRenderViewInitSuccessTime = j10;
    }

    public void setEventInteractionType(int i10) {
        this.eventInteractionType = i10;
    }

    public void setFromNativeAd(boolean z10) {
        this.isFromNativeAd = z10;
    }

    public void setHeight(float f10) {
        this.height = f10;
    }

    public void setHideClose(boolean z10) {
        this.hideClose = z10;
    }

    public void setInteractionType(int i10) {
        this.interactionType = i10;
    }

    public void setLoadSucTime(long j10) {
        this.loadSucTime = j10;
    }

    public void setLoadTime(long j10) {
        this.loadTime = j10;
    }

    public void setMediaSpecSetType(int i10) {
        this.mediaSpecSetType = i10;
    }

    public void setModelClickAreaType(int i10) {
        this.modelClickAreaType = i10;
    }

    public void setRem(int i10) {
        this.rem = i10;
    }

    public void setRenderSucTime(long j10) {
        this.renderSucTime = j10;
    }

    public void setRequestId(String str) {
        this.requestId = str;
    }

    public void setSen(int i10) {
        this.sen = i10;
    }

    public void setShowTime(long j10) {
        this.showTime = j10;
    }

    public void setSkipTime(int i10) {
        if (i10 < 1) {
            this.skipTime = 5;
        } else {
            this.skipTime = i10;
        }
    }

    public void setTemplateId(int i10) {
        this.templateId = i10;
    }

    public void setTolerateTime(float f10) {
        this.tolerateTime = f10;
    }

    public void setWidth(float f10) {
        this.width = f10;
    }
}
