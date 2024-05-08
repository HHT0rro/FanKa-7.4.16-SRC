package com.alibaba.security.common.videorecorder;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface ICameraVideoRecorder {
    void init(int i10, int i11, int i12, int i13);

    void record(byte[] bArr);

    void release(OnCameraVideoReorderListener onCameraVideoReorderListener, boolean z10);

    void setOnH264EncoderListener(OnH264EncoderListener onH264EncoderListener);
}
