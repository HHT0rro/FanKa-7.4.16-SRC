package com.effectsar.labcv.effectsdk;

import android.content.Context;
import com.effectsar.labcv.effectsdk.EffectsSDKEffectConstants;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class FaceFitting {
    public static final int FaceFittingMaxFaceCount = 6;
    private long mNativePtr;
    private long mNativeCResultPtr = 0;
    private volatile boolean mInited = false;
    public FaceFittingResult faceFittingResult = null;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class FaceFittingMeshConfig {
        public short[] flist;
        public int flist_count;
        public short[] landmark_triangle;
        public int landmark_triangle_count;
        public int mum_landmark;
        public int num_flist;
        public int num_landmark_triangle;
        public int num_param;
        public int num_vertex;
        public float[] uv;
        public int uv_count;
        public int version_code;

        public short[] getFlist() {
            return this.flist;
        }

        public int getFlist_count() {
            return this.flist_count;
        }

        public short[] getLandmark_triangle() {
            return this.landmark_triangle;
        }

        public int getLandmark_triangle_count() {
            return this.landmark_triangle_count;
        }

        public int getMum_landmark() {
            return this.mum_landmark;
        }

        public int getNum_flist() {
            return this.num_flist;
        }

        public int getNum_landmark_triangle() {
            return this.num_landmark_triangle;
        }

        public int getNum_param() {
            return this.num_param;
        }

        public int getNum_vertex() {
            return this.num_vertex;
        }

        public float[] getUv() {
            return this.uv;
        }

        public int getUv_count() {
            return this.uv_count;
        }

        public int getVersion_code() {
            return this.version_code;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class FaceFittingMeshInfo {
        public float[] bitangent;

        /* renamed from: id, reason: collision with root package name */
        public int f19188id;
        public float[] landmark;
        public int landmark_count;
        public float[] model;
        public float[] mvp;
        public float[] normal;
        public float[] param;
        public int param_count;
        public float[] rvec;
        public float[] tangent;
        public float[] tvec;
        public float[] vertex;
        public int vertex_count;

        public float[] getBitangent() {
            return this.bitangent;
        }

        public int getId() {
            return this.f19188id;
        }

        public float[] getLandmark() {
            return this.landmark;
        }

        public int getLandmark_count() {
            return this.landmark_count;
        }

        public float[] getModel() {
            return this.model;
        }

        public float[] getMvp() {
            return this.mvp;
        }

        public float[] getNormal() {
            return this.normal;
        }

        public float[] getParam() {
            return this.param;
        }

        public int getParam_count() {
            return this.param_count;
        }

        public float[] getRvec() {
            return this.rvec;
        }

        public float[] getTangent() {
            return this.tangent;
        }

        public float[] getTvec() {
            return this.tvec;
        }

        public float[] getVertex() {
            return this.vertex;
        }

        public int getVertex_count() {
            return this.vertex_count;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class FaceFittingResult {
        public int faceCount;
        public FaceFittingMeshConfig config = null;
        public FaceFittingMeshInfo[] faceFittingMeshInfo = new FaceFittingMeshInfo[6];

        public FaceFittingMeshConfig getConfig() {
            return this.config;
        }

        public int getFaceCount() {
            return this.faceCount;
        }

        public FaceFittingMeshInfo[] getFaceFittingMeshInfo() {
            return this.faceFittingMeshInfo;
        }
    }

    static {
        try {
            System.loadLibrary("effect");
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        }
    }

    private native void nativeAllocCResult();

    private native int nativeDestroy();

    private native int nativeDetect(BefFaceInfo befFaceInfo, int i10, int i11, float[] fArr, FaceFittingResult faceFittingResult);

    private native void nativeFreeCResult();

    private native int nativeInit(Context context, String str, String str2, boolean z10);

    private native int nativeSetParam(int i10, int i11);

    public int destroy() {
        if (!this.mInited) {
            return -1;
        }
        nativeFreeCResult();
        return nativeDestroy();
    }

    public int detect(BefFaceInfo befFaceInfo, int i10, int i11, float[] fArr) {
        if (this.mInited) {
            return nativeDetect(befFaceInfo, i10, i11, fArr, this.faceFittingResult);
        }
        return -1;
    }

    public FaceFittingResult getFaceFittingResult() {
        if (this.mInited) {
            return this.faceFittingResult;
        }
        return null;
    }

    public int init(Context context, String str, String str2, boolean z10) {
        int nativeInit = nativeInit(context, str, str2, z10);
        this.mInited = nativeInit == 0;
        if (this.mInited) {
            nativeAllocCResult();
            this.faceFittingResult = new FaceFittingResult();
        }
        return nativeInit;
    }

    public int setParam(EffectsSDKEffectConstants.FaceFittingParam faceFittingParam, int i10) {
        if (this.mInited) {
            return nativeSetParam(faceFittingParam.getValue(), i10);
        }
        return -1;
    }
}
