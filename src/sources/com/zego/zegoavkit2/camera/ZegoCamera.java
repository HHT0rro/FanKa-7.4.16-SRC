package com.zego.zegoavkit2.camera;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class ZegoCamera {
    public static void enableCamAdaptiveFPS(boolean z10, int i10, int i11, int i12) {
        ZegoCameraJNI.enableCamAdaptiveFPS(z10, i10, i11, i12);
    }

    public static float getCamMaxZoomFactor(int i10) {
        return ZegoCameraJNI.getCamMaxZoomFactor(i10);
    }

    public static boolean setCamExposureCompensation(float f10, int i10) {
        return ZegoCameraJNI.setCamExposureCompensation(f10, i10);
    }

    public static boolean setCamExposureMode(ZegoCameraExposureMode zegoCameraExposureMode, int i10) {
        return ZegoCameraJNI.setCamExposureMode(zegoCameraExposureMode.getCode(), i10);
    }

    @Deprecated
    public static boolean setCamExposurePoint(float f10, float f11, int i10) {
        return ZegoCameraJNI.setCamExposurePoint(f10, f11, i10);
    }

    public static boolean setCamExposurePointInPreview(float f10, float f11, int i10) {
        return ZegoCameraJNI.setCamExposurePointInPreview(f10, f11, i10);
    }

    public static boolean setCamFocusMode(ZegoCameraFocusMode zegoCameraFocusMode, int i10) {
        return ZegoCameraJNI.setCamFocusMode(zegoCameraFocusMode.getCode(), i10);
    }

    @Deprecated
    public static boolean setCamFocusPoint(float f10, float f11, int i10) {
        return ZegoCameraJNI.setCamFocusPoint(f10, f11, i10);
    }

    public static boolean setCamFocusPointInPreview(float f10, float f11, int i10) {
        return ZegoCameraJNI.setCamFocusPointInPreview(f10, f11, i10);
    }

    public static boolean setCamZoomFactor(float f10, int i10) {
        return ZegoCameraJNI.setCamZoomFactor(f10, i10);
    }
}
