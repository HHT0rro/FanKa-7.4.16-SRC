package com.effectsar.labcv.effectsdk;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class OnekeyEnhance {
    private boolean mInited = false;
    private long mNativePtr;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class AlgParamStream {
        public float amount_float;
        public int asf_scene_mode_int;
        public float contrast_factor_float;
        public float current_pixel_weight_float;
        public int hdr_version_int;
        public float luma_trigger_float;
        public int luminance_target_int0;
        public int luminance_target_int1;
        public float noise_factor_float;
        public float over_trigger_float;
        public float ratio_float;
        public float saturation_factor_float;
        public float under_trigger_float;

        public AlgParamStream(int i10, int i11, float f10, float f11, float f12, float f13, float f14, float f15, int i12, float f16, float f17, float f18, int i13) {
            this.luminance_target_int0 = i10;
            this.luminance_target_int1 = i11;
            this.contrast_factor_float = f10;
            this.saturation_factor_float = f11;
            this.amount_float = f12;
            this.ratio_float = f13;
            this.noise_factor_float = f14;
            this.current_pixel_weight_float = f15;
            this.hdr_version_int = i12;
            this.luma_trigger_float = f16;
            this.over_trigger_float = f17;
            this.under_trigger_float = f18;
            this.asf_scene_mode_int = i13;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class FaceRect {
        public int bottom;
        public int left;
        public int right;
        public int top;

        public FaceRect(int i10, int i11, int i12, int i13) {
            this.top = i10;
            this.left = i11;
            this.right = i12;
            this.bottom = i13;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class InitConfig {
        public boolean asnycProcess;
        public boolean disableAsf;
        public boolean disableDayScene;
        public boolean disableDenoise;
        public boolean disableHdr;
        public boolean disableNightScene;
        public int height;
        public String kernelBinPath;
        public boolean oneKeyRecordHdrV2;
        public int powerLevel;
        public int sceneMode;
        public int width;

        public InitConfig(int i10, int i11, String str, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, int i12, int i13) {
            this.width = i10;
            this.height = i11;
            this.kernelBinPath = str;
            this.disableDenoise = z10;
            this.disableHdr = z11;
            this.oneKeyRecordHdrV2 = z12;
            this.asnycProcess = z13;
            this.disableNightScene = z14;
            this.disableDayScene = z15;
            this.disableAsf = z16;
            this.powerLevel = i12;
            this.sceneMode = i13;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class ProcessConfig {
        public int cvDetectFrames;
        public FaceRect[] faceList;
        public int faceNum;
        public int height;
        public int initDecayFrames;
        public boolean isFirstFrame;
        public boolean isProtectFace;
        public int iso;
        public int iso_max;
        public int iso_min;
        public int width;

        public ProcessConfig(int i10, int i11, int i12, int i13, int i14, int i15, boolean z10, boolean z11, int i16, int i17, FaceRect[] faceRectArr) {
            this.iso = i10;
            this.iso_max = i11;
            this.iso_min = i12;
            this.cvDetectFrames = i13;
            this.width = i14;
            this.height = i15;
            this.isFirstFrame = z10;
            this.isProtectFace = z11;
            this.initDecayFrames = i16;
            this.faceNum = i17;
            this.faceList = faceRectArr;
        }

        public int getCvDetectFrames() {
            return this.cvDetectFrames;
        }

        public FaceRect[] getFaceList() {
            return this.faceList;
        }

        public int getFaceNum() {
            return this.faceNum;
        }

        public int getHeight() {
            return this.height;
        }

        public int getInitDecayFrames() {
            return this.initDecayFrames;
        }

        public int getIso() {
            return this.iso;
        }

        public int getIso_max() {
            return this.iso_max;
        }

        public int getIso_min() {
            return this.iso_min;
        }

        public int getWidth() {
            return this.width;
        }

        public boolean isFirstFrame() {
            return this.isFirstFrame;
        }

        public boolean isProtectFace() {
            return this.isProtectFace;
        }

        public void setCvDetectFrames(int i10) {
            this.cvDetectFrames = i10;
        }

        public void setFaceList(FaceRect[] faceRectArr) {
            this.faceList = faceRectArr;
        }

        public void setFaceNum(int i10) {
            this.faceNum = i10;
        }

        public void setFirstFrame(boolean z10) {
            this.isFirstFrame = z10;
        }

        public void setHeight(int i10) {
            this.height = i10;
        }

        public void setInitDecayFrames(int i10) {
            this.initDecayFrames = i10;
        }

        public void setIso(int i10) {
            this.iso = i10;
        }

        public void setIso_max(int i10) {
            this.iso_max = i10;
        }

        public void setIso_min(int i10) {
            this.iso_min = i10;
        }

        public void setProtectFace(boolean z10) {
            this.isProtectFace = z10;
        }

        public void setWidth(int i10) {
            this.width = i10;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class Result {
        public int textureId;
    }

    static {
        try {
            System.loadLibrary("effect");
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        }
    }

    private native int nativeCreate(String str, boolean z10, AlgParamStream algParamStream, InitConfig initConfig);

    private native int nativeProcess(int i10, AlgParamStream algParamStream, ProcessConfig processConfig, Result result);

    private native void nativeRelease();

    public int create(String str, boolean z10, AlgParamStream algParamStream, InitConfig initConfig) {
        int nativeCreate = nativeCreate(str, z10, algParamStream, initConfig);
        if (nativeCreate != 0) {
            this.mInited = false;
            return nativeCreate;
        }
        this.mInited = true;
        return nativeCreate;
    }

    public int process(int i10, AlgParamStream algParamStream, ProcessConfig processConfig) {
        if (!this.mInited) {
            return 0;
        }
        Result result = new Result();
        int nativeProcess = nativeProcess(i10, algParamStream, processConfig, result);
        return nativeProcess < 0 ? nativeProcess : result.textureId;
    }

    public void release() {
        if (this.mInited) {
            nativeRelease();
        }
        this.mInited = false;
    }
}
