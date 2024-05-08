package com.huawei.hms.ads;

import com.huawei.hms.ads.annotation.GlobalApi;

@GlobalApi
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public interface VideoOperator {

    @GlobalApi
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static abstract class VideoLifecycleListener {
        @GlobalApi
        public VideoLifecycleListener() {
        }

        @GlobalApi
        public void onVideoEnd() {
        }

        @GlobalApi
        public void onVideoMute(boolean z10) {
        }

        @GlobalApi
        public void onVideoPause() {
        }

        @GlobalApi
        public void onVideoPlay() {
        }

        @GlobalApi
        public void onVideoStart() {
        }
    }

    float getAspectRatio();

    VideoLifecycleListener getVideoLifecycleListener();

    boolean hasVideo();

    boolean isClickToFullScreenEnabled();

    boolean isCustomizeOperateEnabled();

    boolean isMuted();

    void mute(boolean z10);

    void pause();

    void play();

    void setVideoLifecycleListener(VideoLifecycleListener videoLifecycleListener);

    void stop();
}
