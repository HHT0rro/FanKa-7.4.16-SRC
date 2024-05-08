package com.alimm.tanx.core.ad.bean;

import android.text.TextUtils;
import com.alibaba.fastjson.annotation.JSONField;
import com.alimm.tanx.core.utils.LogUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class TemplateConfig extends BaseBean {

    @JSONField(name = "action_text")
    public String actionText;

    @JSONField(name = "all_slide_distance")
    public String allSlideDistance;

    @JSONField(name = "back_pop")
    public String backPop;

    @JSONField(name = "count_down")
    public String countDown;
    public MediaRenderingMode day;

    @JSONField(name = "interact_img")
    public String interactImg;
    public MediaRenderingMode night;

    @JSONField(name = "pid_style_id")
    public String pidStyleId;

    @JSONField(name = "render_url")
    public String renderUrl;

    @JSONField(name = "reward_mode")
    public int rewardMode;

    @JSONField(name = "shake_splash")
    public String shakeSplash;

    @JSONField(name = "slide_distance")
    public String slideDistance;

    @JSONField(name = "slide_type")
    public String slideType;

    @JSONField(name = "sliding_direction")
    public int slidingDirection;

    @JSONField(name = "web_end_time")
    public String webEndTime;

    @JSONField(name = "web_height")
    public String webHeight;

    @JSONField(name = "web_start_time")
    public String webStartTime;

    @JSONField(name = "web_type")
    public String webType;

    @JSONField(name = "web_url")
    public String webUrl;

    @JSONField(name = "web_width")
    public String webWidth;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class DefaultConfig extends BaseBean {
        public static final String adColor = "#ffffff";
        public static final String adSize = "5";
        public static final String advColor = "#ffffff";
        public static final String advSize = "5";
        public static final String bAdColor = "#999999";
        public static final String bAdSize = "5";
        public static final String bAdvColor = "#999999";
        public static final String bAdvSize = "5";
        public static final String bBgColor = "#ffffff";
        public static final String bPicRadius = "4";
        public static final String bTitleColor = "#333333";
        public static final String bTitleSize = "8";
        public static final String bgColor = "#333333";
        public static final String picRadius = "4";
        public static final String titleColor = "#ffffff";
        public static final String titleSize = "8";

        public DefaultConfig() {
        }
    }

    private void setDefaultDaytimeMode() {
        this.day = new MediaRenderingMode("8", "#333333", "5", "#999999", "5", "#999999", "#ffffff", "4");
    }

    private void setDefaultNightMode() {
        this.night = new MediaRenderingMode("8", "#ffffff", "5", "#ffffff", "5", "#ffffff", "#333333", "4");
    }

    public String getActionText() {
        return this.actionText;
    }

    public String getAllSlideDistance() {
        return this.allSlideDistance;
    }

    public int getAllSlideDistance2Int() {
        try {
            return Integer.parseInt(this.allSlideDistance);
        } catch (Exception e2) {
            LogUtils.d(LogUtils.getStackTraceMessage(e2), new String[0]);
            return 120;
        }
    }

    public String getBackPop() {
        return this.backPop;
    }

    public String getCountDown() {
        return this.countDown;
    }

    public int getCountDown2Int() {
        if (TextUtils.isEmpty(this.countDown)) {
            return 0;
        }
        try {
            return Integer.parseInt(this.countDown);
        } catch (Exception e2) {
            LogUtils.e("countDown转Int error", e2);
            return 0;
        }
    }

    public MediaRenderingMode getDay() {
        return this.day;
    }

    public String getInteractImg() {
        return this.interactImg;
    }

    public MediaRenderingMode getNight() {
        return this.night;
    }

    public MediaRenderingMode getNowConfig(boolean z10, boolean z11, int i10) {
        MediaRenderingMode mediaRenderingMode = this.day;
        if (mediaRenderingMode == null || TextUtils.isEmpty(mediaRenderingMode.getTitleColor())) {
            setDefaultDaytimeMode();
        }
        MediaRenderingMode mediaRenderingMode2 = this.night;
        if (mediaRenderingMode2 == null || TextUtils.isEmpty(mediaRenderingMode2.getTitleColor())) {
            setDefaultNightMode();
        }
        if (z10) {
            if (z11) {
                if (TextUtils.isEmpty(this.night.getServerTitleSize())) {
                    MediaRenderingMode mediaRenderingMode3 = this.night;
                    mediaRenderingMode3.setServerTitleSize(mediaRenderingMode3.getTitleSize());
                }
                this.night.setTitleSize(i10 + "");
            } else if (!TextUtils.isEmpty(this.night.getServerTitleSize())) {
                this.night.setTitleSize(this.night.getServerTitleSize() + "");
            }
            return this.night;
        }
        if (z11) {
            if (TextUtils.isEmpty(this.day.getServerTitleSize())) {
                MediaRenderingMode mediaRenderingMode4 = this.day;
                mediaRenderingMode4.setServerTitleSize(mediaRenderingMode4.getTitleSize());
            }
            this.day.setTitleSize(i10 + "");
        } else if (!TextUtils.isEmpty(this.day.getServerTitleSize())) {
            this.day.setTitleSize(this.day.getServerTitleSize() + "");
        }
        return this.day;
    }

    public String getPidStyleId() {
        return this.pidStyleId;
    }

    public String getRenderUrl() {
        return this.renderUrl;
    }

    public int getRewardMode() {
        return this.rewardMode;
    }

    public String getShakeSplash() {
        return this.shakeSplash;
    }

    public int getShakeSplash2Int() {
        try {
            return Integer.parseInt(this.shakeSplash);
        } catch (Exception e2) {
            LogUtils.d(LogUtils.getStackTraceMessage(e2), new String[0]);
            return 15;
        }
    }

    public String getSlideDistance() {
        return this.slideDistance;
    }

    public int getSlideDistance2Int() {
        try {
            return Integer.parseInt(this.slideDistance);
        } catch (Exception e2) {
            LogUtils.d(LogUtils.getStackTraceMessage(e2), new String[0]);
            return 55;
        }
    }

    public String getSlideType() {
        return this.slideType;
    }

    public int getSlideType2Int() {
        try {
            return Integer.parseInt(this.slideType);
        } catch (Exception e2) {
            LogUtils.d(LogUtils.getStackTraceMessage(e2), new String[0]);
            return 1;
        }
    }

    public int getSlidingDirection() {
        return this.slidingDirection;
    }

    public String getWebEndTime() {
        return this.webEndTime;
    }

    public Long getWebEndTime2Long() {
        try {
            return Long.valueOf(Long.parseLong(this.webEndTime));
        } catch (Exception unused) {
            return null;
        }
    }

    public String getWebHeight() {
        return this.webHeight;
    }

    public int getWebHeight2Int() {
        int i10;
        try {
            i10 = Integer.parseInt(this.webHeight);
        } catch (Exception unused) {
            i10 = 9;
        }
        if (i10 <= 0) {
            return 9;
        }
        return i10;
    }

    public String getWebStartTime() {
        return this.webStartTime;
    }

    public Long getWebStartTime2Long() {
        try {
            return Long.valueOf(Long.parseLong(this.webStartTime));
        } catch (Exception unused) {
            return null;
        }
    }

    public String getWebType() {
        return this.webType;
    }

    public int getWebType2Int() {
        try {
            return Integer.parseInt(this.webType);
        } catch (Exception unused) {
            return -1;
        }
    }

    public String getWebUrl() {
        return this.webUrl;
    }

    public String getWebWidth() {
        return this.webWidth;
    }

    public int getWebWidth2Int() {
        int i10;
        try {
            i10 = Integer.parseInt(this.webWidth);
        } catch (Exception unused) {
            i10 = 16;
        }
        if (i10 <= 0) {
            return 16;
        }
        return i10;
    }

    public void setActionText(String str) {
        this.actionText = str;
    }

    public void setAllSlideDistance(String str) {
        this.allSlideDistance = str;
    }

    public void setBackPop(String str) {
        this.backPop = str;
    }

    public void setCountDown(String str) {
        this.countDown = str;
    }

    public void setDay(MediaRenderingMode mediaRenderingMode) {
        this.day = mediaRenderingMode;
    }

    public void setInteractImg(String str) {
        this.interactImg = str;
    }

    public void setNight(MediaRenderingMode mediaRenderingMode) {
        this.night = mediaRenderingMode;
    }

    public void setPidStyleId(String str) {
        this.pidStyleId = str;
    }

    public void setRenderUrl(String str) {
        this.renderUrl = str;
    }

    public void setRewardMode(int i10) {
        this.rewardMode = i10;
    }

    public void setShakeSplash(String str) {
        this.shakeSplash = str;
    }

    public void setSlideDistance(String str) {
        this.slideDistance = str;
    }

    public void setSlideType(String str) {
        this.slideType = str;
    }

    public void setSlidingDirection(int i10) {
        this.slidingDirection = i10;
    }

    public void setWebEndTime(String str) {
        this.webEndTime = str;
    }

    public void setWebHeight(String str) {
        this.webHeight = str;
    }

    public void setWebStartTime(String str) {
        this.webStartTime = str;
    }

    public void setWebType(String str) {
        this.webType = str;
    }

    public void setWebUrl(String str) {
        this.webUrl = str;
    }

    public void setWebWidth(String str) {
        this.webWidth = str;
    }
}
