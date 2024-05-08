package com.zego.zegoavkit2.videocapture;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class TrafficControlQuality {
    private int videoBitrate;
    private int videoFrameRate;
    private int videoHeight;
    private int videoWidth;

    public TrafficControlQuality(int i10, int i11, int i12, int i13) {
        this.videoBitrate = i10;
        this.videoFrameRate = i11;
        this.videoWidth = i12;
        this.videoHeight = i13;
    }

    public int getVideoBitrate() {
        return this.videoBitrate;
    }

    public int getVideoFrameRate() {
        return this.videoFrameRate;
    }

    public int getVideoHeight() {
        return this.videoHeight;
    }

    public int getVideoWidth() {
        return this.videoWidth;
    }
}
