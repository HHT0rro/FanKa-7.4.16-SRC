package com.tencent.liteav.device;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface TXDeviceManager {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public enum TXAudioRoute {
        TXAudioRouteSpeakerphone,
        TXAudioRouteEarpiece
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public enum TXCameraCaptureMode {
        TXCameraResolutionStrategyAuto,
        TXCameraResolutionStrategyPerformance,
        TXCameraResolutionStrategyHighQuality,
        TXCameraCaptureManual
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class TXCameraCaptureParam {
        public int height;
        public TXCameraCaptureMode mode;
        public int width;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public enum TXSystemVolumeType {
        TXSystemVolumeTypeAuto,
        TXSystemVolumeTypeMedia,
        TXSystemVolumeTypeVOIP
    }

    int enableCameraAutoFocus(boolean z10);

    boolean enableCameraTorch(boolean z10);

    float getCameraZoomMaxRatio();

    boolean isAutoFocusEnabled();

    boolean isFrontCamera();

    int setAudioRoute(TXAudioRoute tXAudioRoute);

    void setCameraCapturerParam(TXCameraCaptureParam tXCameraCaptureParam);

    int setCameraFocusPosition(int i10, int i11);

    int setCameraZoomRatio(float f10);

    int setExposureCompensation(float f10);

    int setSystemVolumeType(TXSystemVolumeType tXSystemVolumeType);

    int switchCamera(boolean z10);
}
