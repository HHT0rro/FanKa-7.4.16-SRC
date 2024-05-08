package com.tencent.live2.impl;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class V2TXLiveDefInner {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class SurfaceSize {
        public int height;
        public int width;

        public SurfaceSize(int i10, int i11) {
            this.width = i10;
            this.height = i11;
        }

        public String toString() {
            return "[width:" + this.width + "][height:" + this.height + "]";
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class TXLivePropertyKey {
        public static final String kV2EnableAGC = "enableAGC";
        public static final String kV2EnableANS = "enableANS";
        public static final String kV2EnableCameraZoom = "enableCameraZoom";
        public static final String kV2EnableRTMPAcc = "enableRTMPAcc";
        public static final String kV2EnableRealtimeMode = "enableRealtimeMode";
        public static final String kV2SetAudioCodecType = "setAudioCodecType";
        public static final String kV2SetAudioRoute = "setAudioRoute";
        public static final String kV2SetFramework = "setFramework";
        public static final String kV2SetLEBEnvironment = "setLEBEnvironment";
        public static final String kV2SetLebCacheParams = "setLebCacheParams";
        public static final String kV2SetOpenGLContext = "setOpenGLContext";
        public static final String kV2SetPreferLocalIPStack = "setPreferLocalIPStack";
        public static final String kV2SetSurface = "setSurface";
        public static final String kV2SetSurfaceSize = "setSurfaceSize";
    }
}
