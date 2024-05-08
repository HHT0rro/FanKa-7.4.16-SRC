package com.zego.zegoavkit2.camera;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
final class ZegoCameraJNI {
    public static native void enableCamAdaptiveFPS(boolean z10, int i10, int i11, int i12);

    public static native float getCamMaxZoomFactor(int i10);

    public static native boolean setCamExposureCompensation(float f10, int i10);

    public static native boolean setCamExposureMode(int i10, int i11);

    public static native boolean setCamExposurePoint(float f10, float f11, int i10);

    public static native boolean setCamExposurePointInPreview(float f10, float f11, int i10);

    public static native boolean setCamFocusMode(int i10, int i11);

    public static native boolean setCamFocusPoint(float f10, float f11, int i10);

    public static native boolean setCamFocusPointInPreview(float f10, float f11, int i10);

    public static native boolean setCamZoomFactor(float f10, int i10);
}
