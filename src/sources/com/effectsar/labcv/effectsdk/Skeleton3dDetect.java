package com.effectsar.labcv.effectsdk;

import android.content.Context;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class Skeleton3dDetect {
    private volatile boolean mInited = false;
    private long mNativePtr;
    private BefSkeleton3DInfo mResult;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class InputParam {
        public ByteBuffer buffer;
        public int image_height;
        public int image_stride;
        public int image_width;
        public int keypoint_num;
        public int orientation;
        public int pixel_format;
        public int target_num;
        public float[] points2d = new float[180];
        public int[] point_valid = new int[90];

        public ByteBuffer getBuffer() {
            return this.buffer;
        }

        public int getImage_height() {
            return this.image_height;
        }

        public int getImage_stride() {
            return this.image_stride;
        }

        public int getImage_width() {
            return this.image_width;
        }

        public int getKeypoint_num() {
            return this.keypoint_num;
        }

        public int getOrientation() {
            return this.orientation;
        }

        public int getPixel_format() {
            return this.pixel_format;
        }

        public int[] getPoint_valid() {
            return this.point_valid;
        }

        public float[] getPoints2d() {
            return this.points2d;
        }

        public int getTarget_num() {
            return this.target_num;
        }

        public void setBuffer(ByteBuffer byteBuffer) {
            this.buffer = byteBuffer;
        }

        public void setImage_height(int i10) {
            this.image_height = i10;
        }

        public void setImage_stride(int i10) {
            this.image_stride = i10;
        }

        public void setImage_width(int i10) {
            this.image_width = i10;
        }

        public void setKeypoint_num(int i10) {
            this.keypoint_num = i10;
        }

        public void setOrientation(int i10) {
            this.orientation = i10;
        }

        public void setPixel_format(int i10) {
            this.pixel_format = i10;
        }

        public void setPoint_valid(int[] iArr) {
            this.point_valid = iArr;
        }

        public void setPoints2d(float[] fArr) {
            this.points2d = fArr;
        }

        public void setTarget_num(int i10) {
            this.target_num = i10;
        }

        public String toString() {
            return "InputParam{buffer=" + ((Object) this.buffer) + ", pixel_format=" + this.pixel_format + ", image_width=" + this.image_width + ", image_height=" + this.image_height + ", image_stride=" + this.image_stride + ", orientation=" + this.orientation + ", points2d=" + Arrays.toString(this.points2d) + ", point_valid=" + Arrays.toString(this.point_valid) + ", keypoint_num=" + this.keypoint_num + ", target_num=" + this.target_num + '}';
        }
    }

    static {
        try {
            System.loadLibrary("effect");
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        }
    }

    private native int nativeCreateHandle(Context context, String str, boolean z10);

    private native int nativeDetect(InputParam inputParam, BefSkeleton3DInfo befSkeleton3DInfo);

    private native void nativeRelease();

    private native int nativeSetModel(String str);

    private native int nativeSetParam(int i10, float f10);

    public int detectSkeleton3d(InputParam inputParam) {
        if (!this.mInited) {
            return -1;
        }
        int nativeDetect = nativeDetect(inputParam, this.mResult);
        if (nativeDetect == 0) {
            return 0;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("nativeDetect return ");
        sb2.append(nativeDetect);
        return -1;
    }

    public BefSkeleton3DInfo getSkeleton3DInfo() {
        return this.mResult;
    }

    public int init(Context context, String str, boolean z10, String str2) {
        int nativeCreateHandle = nativeCreateHandle(context, str, z10);
        if (nativeCreateHandle != 0) {
            return nativeCreateHandle;
        }
        int nativeSetModel = nativeSetModel(str2);
        if (nativeSetModel != 0) {
            return nativeSetModel;
        }
        this.mInited = true;
        this.mResult = new BefSkeleton3DInfo();
        return nativeSetModel;
    }

    public boolean isInited() {
        return this.mInited;
    }

    public void release() {
        if (this.mInited) {
            nativeRelease();
            this.mInited = false;
        }
    }

    public int setParam(int i10, float f10) {
        return nativeSetParam(i10, f10);
    }
}
