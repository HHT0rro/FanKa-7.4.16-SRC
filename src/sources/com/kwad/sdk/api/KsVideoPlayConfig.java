package com.kwad.sdk.api;

import androidx.annotation.Keep;
import com.kwad.sdk.api.core.KsAdSdkApi;
import com.kwad.sdk.api.loader.Loader;
import java.io.Serializable;

@KsAdSdkApi
@Keep
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface KsVideoPlayConfig extends Serializable {

    @KsAdSdkApi
    @Keep
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class Builder {
        private boolean showLandscape;
        private String showScene;
        private boolean skipLongTime;
        private boolean videoSoundEnable = true;

        @KsAdSdkApi
        @Keep
        public KsVideoPlayConfig build() {
            KsVideoPlayConfig ksVideoPlayConfig = (KsVideoPlayConfig) Loader.get().newInstance(KsVideoPlayConfig.class);
            ksVideoPlayConfig.setShowScene(this.showScene);
            ksVideoPlayConfig.setShowLandscape(this.showLandscape);
            ksVideoPlayConfig.setSkipThirtySecond(this.skipLongTime);
            ksVideoPlayConfig.setVideoSoundEnable(this.videoSoundEnable);
            return ksVideoPlayConfig;
        }

        @KsAdSdkApi
        @Keep
        public Builder showLandscape(boolean z10) {
            this.showLandscape = z10;
            return this;
        }

        @KsAdSdkApi
        @Keep
        public Builder showScene(String str) {
            this.showScene = str;
            return this;
        }

        @KsAdSdkApi
        @Keep
        public Builder skipThirtySecond(boolean z10) {
            this.skipLongTime = z10;
            return this;
        }

        @KsAdSdkApi
        @Keep
        public Builder videoSoundEnable(boolean z10) {
            this.videoSoundEnable = z10;
            return this;
        }
    }

    @KsAdSdkApi
    @Keep
    String getShowScene();

    @KsAdSdkApi
    @Keep
    boolean isShowLandscape();

    @KsAdSdkApi
    @Keep
    boolean isSkipThirtySecond();

    @KsAdSdkApi
    @Keep
    boolean isVideoSoundEnable();

    @KsAdSdkApi
    @Keep
    void setShowLandscape(boolean z10);

    @KsAdSdkApi
    @Keep
    void setShowScene(String str);

    @KsAdSdkApi
    @Keep
    void setSkipThirtySecond(boolean z10);

    @KsAdSdkApi
    @Keep
    void setVideoSoundEnable(boolean z10);
}
