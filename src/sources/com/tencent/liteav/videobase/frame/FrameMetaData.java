package com.tencent.liteav.videobase.frame;

import com.tencent.liteav.base.annotations.CalledByNative;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.Rotation;
import com.tencent.liteav.base.util.Size;
import com.tencent.liteav.videobase.base.GLConstants;

@JNINamespace("liteav::video")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class FrameMetaData {
    private final MirrorInfo mCaptureMirror = new MirrorInfo();
    private final Size mCaptureRealFrameSize;
    private Rotation mCaptureRotation;
    private final MirrorInfo mEncodeMirror;
    private Rotation mEncodeRotation;
    private final Size mEncodeSize;
    private boolean mIsBlackFrame;
    private boolean mIsFrontCamera;
    private final MirrorInfo mPreprocessorMirror;
    private Rotation mPreprocessorRotation;
    private GLConstants.GLScaleType mPreprocessorScaleType;
    private final MirrorInfo mRenderMirror;
    private Rotation mRenderRotation;
    private final Size mRenderSize;

    @CalledByNative
    public FrameMetaData() {
        Rotation rotation = Rotation.NORMAL;
        this.mCaptureRotation = rotation;
        this.mIsFrontCamera = false;
        this.mCaptureRealFrameSize = new Size();
        this.mIsBlackFrame = false;
        this.mPreprocessorMirror = new MirrorInfo();
        this.mPreprocessorRotation = rotation;
        this.mPreprocessorScaleType = GLConstants.GLScaleType.CENTER_CROP;
        this.mRenderMirror = new MirrorInfo();
        this.mRenderRotation = rotation;
        this.mRenderSize = new Size();
        this.mEncodeMirror = new MirrorInfo();
        this.mEncodeRotation = rotation;
        this.mEncodeSize = new Size();
    }

    public Size getCaptureRealSize() {
        return this.mCaptureRealFrameSize;
    }

    @CalledByNative
    public int getCaptureRotation() {
        return this.mCaptureRotation.mValue;
    }

    @CalledByNative
    public int getEncodeHeight() {
        return this.mEncodeSize.height;
    }

    public Rotation getEncodeRotation() {
        return this.mEncodeRotation;
    }

    @CalledByNative
    public int getEncodeRotationValue() {
        return this.mEncodeRotation.mValue;
    }

    public Size getEncodeSize() {
        return this.mEncodeSize;
    }

    @CalledByNative
    public int getEncodeWidth() {
        return this.mEncodeSize.width;
    }

    public Rotation getPreprocessorRotation() {
        return this.mPreprocessorRotation;
    }

    @CalledByNative
    public int getPreprocessorRotationValue() {
        return this.mPreprocessorRotation.mValue;
    }

    public GLConstants.GLScaleType getPreprocessorScaleType() {
        return this.mPreprocessorScaleType;
    }

    @CalledByNative
    public int getPreprocessorScaleTypeValue() {
        return this.mPreprocessorScaleType.mValue;
    }

    @CalledByNative
    public int getRenderHeight() {
        return this.mRenderSize.height;
    }

    public Rotation getRenderRotation() {
        return this.mRenderRotation;
    }

    @CalledByNative
    public int getRenderRotationValue() {
        return this.mRenderRotation.mValue;
    }

    public Size getRenderSize() {
        return this.mRenderSize;
    }

    @CalledByNative
    public int getRenderWidth() {
        return this.mRenderSize.width;
    }

    public boolean isBlackFrame() {
        return this.mIsBlackFrame;
    }

    @CalledByNative
    public boolean isCaptureMirrorHorizontal() {
        return this.mCaptureMirror.isHorizontal;
    }

    @CalledByNative
    public boolean isCaptureMirrorVertical() {
        return this.mCaptureMirror.isVertical;
    }

    @CalledByNative
    public boolean isEncodeMirrorHorizontal() {
        return this.mEncodeMirror.isHorizontal;
    }

    @CalledByNative
    public boolean isEncodeMirrorVertical() {
        return this.mEncodeMirror.isVertical;
    }

    @CalledByNative
    public boolean isFrontCamera() {
        return this.mIsFrontCamera;
    }

    @CalledByNative
    public boolean isPreprocessorMirrorHorizontal() {
        return this.mPreprocessorMirror.isHorizontal;
    }

    @CalledByNative
    public boolean isPreprocessorMirrorVertical() {
        return this.mPreprocessorMirror.isVertical;
    }

    @CalledByNative
    public boolean isRenderMirrorHorizontal() {
        return this.mRenderMirror.isHorizontal;
    }

    @CalledByNative
    public boolean isRenderMirrorVertical() {
        return this.mRenderMirror.isVertical;
    }

    @CalledByNative
    public void setCaptureMetaData(boolean z10, boolean z11, int i10, boolean z12, int i11, int i12) {
        MirrorInfo mirrorInfo = this.mCaptureMirror;
        mirrorInfo.isHorizontal = z10;
        mirrorInfo.isVertical = z11;
        this.mCaptureRotation = Rotation.a(i10);
        this.mIsFrontCamera = z12;
        Size size = this.mCaptureRealFrameSize;
        size.width = i11;
        size.height = i12;
    }

    @CalledByNative
    public void setEncodeMetaData(boolean z10, boolean z11, int i10, int i11, int i12) {
        MirrorInfo mirrorInfo = this.mEncodeMirror;
        mirrorInfo.isHorizontal = z10;
        mirrorInfo.isVertical = z11;
        this.mEncodeRotation = Rotation.a(i10);
        Size size = this.mEncodeSize;
        size.width = i11;
        size.height = i12;
    }

    public void setEncodeMirror(MirrorInfo mirrorInfo) {
        if (mirrorInfo == null) {
            return;
        }
        MirrorInfo mirrorInfo2 = this.mEncodeMirror;
        mirrorInfo2.isHorizontal = mirrorInfo.isHorizontal;
        mirrorInfo2.isVertical = mirrorInfo.isVertical;
    }

    public void setEncodeRotation(Rotation rotation) {
        if (rotation == null) {
            return;
        }
        this.mEncodeRotation = rotation;
    }

    public void setEncodeSize(Size size) {
        this.mEncodeSize.set(size);
    }

    public void setIsBlackFrame(boolean z10) {
        this.mIsBlackFrame = z10;
    }

    @CalledByNative
    public void setPreprocessorMetaData(boolean z10, boolean z11, int i10, int i11) {
        MirrorInfo mirrorInfo = this.mPreprocessorMirror;
        mirrorInfo.isHorizontal = z10;
        mirrorInfo.isVertical = z11;
        this.mPreprocessorRotation = Rotation.a(i10);
        this.mPreprocessorScaleType = GLConstants.GLScaleType.a(i11);
    }

    public void setPreprocessorMirror(MirrorInfo mirrorInfo) {
        if (mirrorInfo == null) {
            return;
        }
        MirrorInfo mirrorInfo2 = this.mPreprocessorMirror;
        mirrorInfo2.isHorizontal = mirrorInfo.isHorizontal;
        mirrorInfo2.isVertical = mirrorInfo.isVertical;
    }

    public void setPreprocessorRotation(Rotation rotation) {
        if (rotation == null) {
            return;
        }
        this.mPreprocessorRotation = rotation;
    }

    public void setPreprocessorScaleType(GLConstants.GLScaleType gLScaleType) {
        if (gLScaleType == null) {
            return;
        }
        this.mPreprocessorScaleType = gLScaleType;
    }

    @CalledByNative
    public void setRenderMetaData(boolean z10, boolean z11, int i10, int i11, int i12) {
        MirrorInfo mirrorInfo = this.mRenderMirror;
        mirrorInfo.isHorizontal = z10;
        mirrorInfo.isVertical = z11;
        this.mRenderRotation = Rotation.a(i10);
        Size size = this.mRenderSize;
        size.width = i11;
        size.height = i12;
    }

    public void setRenderMirror(MirrorInfo mirrorInfo) {
        if (mirrorInfo == null) {
            return;
        }
        MirrorInfo mirrorInfo2 = this.mRenderMirror;
        mirrorInfo2.isHorizontal = mirrorInfo.isHorizontal;
        mirrorInfo2.isVertical = mirrorInfo.isVertical;
    }

    public void setRenderRotation(Rotation rotation) {
        if (rotation == null) {
            return;
        }
        this.mRenderRotation = rotation;
    }

    public void setRenderSize(Size size) {
        this.mRenderSize.set(size);
    }
}
