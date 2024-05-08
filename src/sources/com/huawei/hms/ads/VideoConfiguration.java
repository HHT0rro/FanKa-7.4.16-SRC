package com.huawei.hms.ads;

import com.huawei.hms.ads.annotation.GlobalApi;

@GlobalApi
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class VideoConfiguration {
    private boolean Code;
    private boolean I;
    private boolean V;
    private int Z;

    @GlobalApi
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static final class Builder {
        private boolean Code = true;
        private boolean V = false;
        private boolean I = false;
        private int Z = 1;

        @GlobalApi
        public Builder() {
        }

        @GlobalApi
        public final VideoConfiguration build() {
            return new VideoConfiguration(this);
        }

        @GlobalApi
        public Builder setAudioFocusType(int i10) {
            this.Z = i10;
            return this;
        }

        @GlobalApi
        public Builder setClickToFullScreenRequested(boolean z10) {
            this.I = z10;
            return this;
        }

        @GlobalApi
        public Builder setCustomizeOperateRequested(boolean z10) {
            this.V = z10;
            return this;
        }

        @GlobalApi
        public Builder setStartMuted(boolean z10) {
            this.Code = z10;
            return this;
        }
    }

    private VideoConfiguration(Builder builder) {
        this.Code = true;
        this.V = false;
        this.I = false;
        this.Z = 1;
        if (builder != null) {
            this.Code = builder.Code;
            this.I = builder.I;
            this.V = builder.V;
            this.Z = builder.Z;
        }
    }

    @GlobalApi
    public int getAudioFocusType() {
        return this.Z;
    }

    @GlobalApi
    public final boolean isClickToFullScreenRequested() {
        return this.I;
    }

    @GlobalApi
    public final boolean isCustomizeOperateRequested() {
        return this.V;
    }

    @GlobalApi
    public final boolean isStartMuted() {
        return this.Code;
    }
}
