package com.qq.e.ads.cfg;

import com.qq.e.comm.util.GDTLogger;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class VideoOption {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f38122a;

    /* renamed from: b, reason: collision with root package name */
    private final int f38123b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f38124c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f38125d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f38126e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f38127f;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f38128g;

    /* renamed from: h, reason: collision with root package name */
    private final int f38129h;

    /* renamed from: i, reason: collision with root package name */
    private final int f38130i;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class AutoPlayPolicy {
        public static final int ALWAYS = 1;
        public static final int NEVER = 2;
        public static final int WIFI = 0;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        private boolean f38131a = true;

        /* renamed from: b, reason: collision with root package name */
        private int f38132b = 1;

        /* renamed from: c, reason: collision with root package name */
        private boolean f38133c = true;

        /* renamed from: d, reason: collision with root package name */
        private boolean f38134d = true;

        /* renamed from: e, reason: collision with root package name */
        private boolean f38135e = true;

        /* renamed from: f, reason: collision with root package name */
        private boolean f38136f = false;

        /* renamed from: g, reason: collision with root package name */
        private boolean f38137g = false;

        /* renamed from: h, reason: collision with root package name */
        private int f38138h;

        /* renamed from: i, reason: collision with root package name */
        private int f38139i;

        public VideoOption build() {
            return new VideoOption(this);
        }

        public Builder setAutoPlayMuted(boolean z10) {
            this.f38131a = z10;
            return this;
        }

        public Builder setAutoPlayPolicy(int i10) {
            if (i10 < 0 || i10 > 2) {
                i10 = 1;
                GDTLogger.e("setAutoPlayPolicy 设置失败，值只能为0到2之间的数值, 重置为 : 1");
            }
            this.f38132b = i10;
            return this;
        }

        public Builder setDetailPageMuted(boolean z10) {
            this.f38137g = z10;
            return this;
        }

        public Builder setEnableDetailPage(boolean z10) {
            this.f38135e = z10;
            return this;
        }

        public Builder setEnableUserControl(boolean z10) {
            this.f38136f = z10;
            return this;
        }

        public Builder setMaxVideoDuration(int i10) {
            this.f38138h = i10;
            return this;
        }

        public Builder setMinVideoDuration(int i10) {
            this.f38139i = i10;
            return this;
        }

        public Builder setNeedCoverImage(boolean z10) {
            this.f38134d = z10;
            return this;
        }

        public Builder setNeedProgressBar(boolean z10) {
            this.f38133c = z10;
            return this;
        }
    }

    private VideoOption(Builder builder) {
        this.f38122a = builder.f38131a;
        this.f38123b = builder.f38132b;
        this.f38124c = builder.f38133c;
        this.f38125d = builder.f38134d;
        this.f38126e = builder.f38135e;
        this.f38127f = builder.f38136f;
        this.f38128g = builder.f38137g;
        this.f38129h = builder.f38138h;
        this.f38130i = builder.f38139i;
    }

    public boolean getAutoPlayMuted() {
        return this.f38122a;
    }

    public int getAutoPlayPolicy() {
        return this.f38123b;
    }

    public int getMaxVideoDuration() {
        return this.f38129h;
    }

    public int getMinVideoDuration() {
        return this.f38130i;
    }

    public JSONObject getOptions() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("autoPlayMuted", Boolean.valueOf(this.f38122a));
            jSONObject.putOpt("autoPlayPolicy", Integer.valueOf(this.f38123b));
            jSONObject.putOpt("detailPageMuted", Boolean.valueOf(this.f38128g));
        } catch (Exception e2) {
            GDTLogger.d("Get video options error: " + e2.getMessage());
        }
        return jSONObject;
    }

    public boolean isDetailPageMuted() {
        return this.f38128g;
    }

    public boolean isEnableDetailPage() {
        return this.f38126e;
    }

    public boolean isEnableUserControl() {
        return this.f38127f;
    }

    public boolean isNeedCoverImage() {
        return this.f38125d;
    }

    public boolean isNeedProgressBar() {
        return this.f38124c;
    }
}
