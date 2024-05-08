package com.alibaba.security.biometrics.service.video;

import android.content.Context;
import com.alibaba.security.biometrics.jni.YuvEngineWrap;
import com.alibaba.security.biometrics.service.build.aj;
import com.alibaba.security.common.videorecorder.ICameraVideoRecorder;
import com.alibaba.security.common.videorecorder.OnCameraVideoReorderListener;
import com.alibaba.security.common.videorecorder.OnH264EncoderListener;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class VideoRecorderService implements ICameraVideoRecorder {
    private ICameraVideoRecorder mCameraVideoRecorder;

    public VideoRecorderService(Context context) {
        this.mCameraVideoRecorder = new aj(context);
    }

    @Override // com.alibaba.security.common.videorecorder.ICameraVideoRecorder
    public void init(int i10, int i11, int i12, int i13) {
        YuvEngineWrap.getInstance().startYuvEngine();
        this.mCameraVideoRecorder.init(i10, i11, i12, i13);
    }

    @Override // com.alibaba.security.common.videorecorder.ICameraVideoRecorder
    public void record(byte[] bArr) {
        this.mCameraVideoRecorder.record(bArr);
    }

    @Override // com.alibaba.security.common.videorecorder.ICameraVideoRecorder
    public void release(OnCameraVideoReorderListener onCameraVideoReorderListener, boolean z10) {
        YuvEngineWrap.getInstance().stopYuvEngine();
        this.mCameraVideoRecorder.release(onCameraVideoReorderListener, z10);
    }

    @Override // com.alibaba.security.common.videorecorder.ICameraVideoRecorder
    public void setOnH264EncoderListener(OnH264EncoderListener onH264EncoderListener) {
    }
}
