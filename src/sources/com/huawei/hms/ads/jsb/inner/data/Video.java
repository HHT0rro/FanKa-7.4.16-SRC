package com.huawei.hms.ads.jsb.inner.data;

import android.text.TextUtils;
import com.huawei.openalliance.ad.annotations.DataKeep;
import com.huawei.openalliance.ad.beans.metadata.VideoInfo;

@DataKeep
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class Video {
    private String autoPlay;
    private Integer autoPlayAreaRatio;
    private String autoPlayWithSound;
    private Integer autoStopPlayAreaRatio;
    private int duration;
    private int fileSize;
    private float ratio;
    private String soundSwitch;
    private Integer timeBeforeAutoPlay;
    private String url;

    public Video(VideoInfo videoInfo) {
        this.autoPlay = "y";
        this.soundSwitch = "n";
        this.url = videoInfo.Code();
        this.autoStopPlayAreaRatio = videoInfo.b();
        if (TextUtils.equals(videoInfo.B(), "y") || TextUtils.equals(videoInfo.B(), "a")) {
            this.autoPlay = "y";
        } else {
            this.autoPlay = "n";
        }
        this.autoPlayAreaRatio = videoInfo.a();
        this.timeBeforeAutoPlay = Integer.valueOf(videoInfo.S());
        this.autoPlayWithSound = videoInfo.C();
        this.soundSwitch = videoInfo.C();
        this.duration = videoInfo.I();
        this.fileSize = videoInfo.Z();
        this.ratio = videoInfo.d() == null ? 1.7777778f : videoInfo.d().floatValue();
    }
}
