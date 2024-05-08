package com.autonavi.base.ae.gmap.gloverlay;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class GLOverlayTexture {
    public int mAnchor;
    public float mAnchorXRatio;
    public float mAnchorYRatio;
    public int mHeight;
    public int mResHeight;
    public int mResId;
    public int mResWidth;
    public int mWidth;

    public GLOverlayTexture(int i10, int i11, int i12, int i13) {
        this.mResId = i10;
        this.mWidth = i12;
        this.mHeight = i13;
        this.mResWidth = i12;
        this.mResHeight = i13;
        this.mAnchor = i11;
    }

    public GLOverlayTexture(int i10, int i11, float f10, float f11, int i12, int i13) {
        this.mResId = i10;
        this.mWidth = i12;
        this.mHeight = i13;
        this.mResWidth = i12;
        this.mResHeight = i13;
        this.mAnchor = i11;
        this.mAnchorXRatio = f10;
        this.mAnchorYRatio = f11;
    }
}
