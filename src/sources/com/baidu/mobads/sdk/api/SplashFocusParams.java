package com.baidu.mobads.sdk.api;

import com.baidu.mobads.sdk.internal.bs;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class SplashFocusParams {
    private final Builder mBuilder;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class Builder {
        private int iconRightMarginDp = 15;
        private int iconBottomMarginDp = 95;
        private int iconSizeDp = 44;
        private boolean autoAnimOffset = true;
        private int animOffsetPx = 0;
        private double darkAlpha = ShadowDrawableWrapper.COS_45;

        public SplashFocusParams build() {
            return new SplashFocusParams(this);
        }

        @Deprecated
        public Builder setAnimOffsetPx(int i10) {
            this.autoAnimOffset = false;
            this.animOffsetPx = i10;
            return this;
        }

        public Builder setDarkAlpha(double d10) {
            this.darkAlpha = d10;
            return this;
        }

        public Builder setIconBottomMarginDp(int i10) {
            this.iconBottomMarginDp = i10;
            return this;
        }

        public Builder setIconRightMarginDp(int i10) {
            this.iconRightMarginDp = i10;
            return this;
        }

        public Builder setIconSizeDp(int i10) {
            this.iconSizeDp = i10;
            return this;
        }
    }

    public SplashFocusParams(Builder builder) {
        this.mBuilder = builder;
    }

    public JSONObject getFocusParams() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("right_margin", this.mBuilder.iconRightMarginDp);
            jSONObject.put("bottom_margin", this.mBuilder.iconBottomMarginDp);
            jSONObject.put("icon_size", this.mBuilder.iconSizeDp);
            if (!this.mBuilder.autoAnimOffset) {
                jSONObject.put("anim_offset_y", this.mBuilder.animOffsetPx);
            }
            jSONObject.put("icon_dark_alpha", this.mBuilder.darkAlpha);
        } catch (JSONException e2) {
            bs.a().a(e2);
        }
        return jSONObject;
    }
}
