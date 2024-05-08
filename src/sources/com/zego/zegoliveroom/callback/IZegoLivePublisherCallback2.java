package com.zego.zegoliveroom.callback;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface IZegoLivePublisherCallback2 {
    void onCaptureVideoFirstFrame(int i10);

    void onCaptureVideoSizeChangedTo(int i10, int i11, int i12);

    void onPreviewVideoFirstFrame(int i10);

    void onSendLocalAudioFirstFrame(int i10);

    void onSendLocalVideoFirstFrame(int i10);

    void onVideoEncoderChanged(int i10, int i11, int i12);

    void onVideoEncoderError(int i10, int i11, int i12);

    void onVideoObjectSegmentationStateChanged(int i10, int i11, int i12);
}
