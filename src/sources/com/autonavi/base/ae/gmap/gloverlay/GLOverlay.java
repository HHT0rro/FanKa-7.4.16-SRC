package com.autonavi.base.ae.gmap.gloverlay;

import com.autonavi.base.amap.api.mapcore.IAMapDelegate;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public abstract class GLOverlay {
    public int mCode;
    public int mEngineID;
    public IAMapDelegate mGLMapView;
    public boolean isNightStyle = false;
    public boolean mIsInBundle = false;
    public long mNativeInstance = 0;
    public int mItemPriority = 0;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public enum EAMapOverlayTpye {
        AMAPOVERLAY_ARROW,
        AMAPOVERLAY_VECTOR
    }

    public GLOverlay(int i10, IAMapDelegate iAMapDelegate, int i11) {
        this.mEngineID = i10;
        this.mGLMapView = iAMapDelegate;
        this.mCode = i11;
    }

    private static native int nativeGetCount(long j10);

    private static native int nativeGetOverlayPriority(long j10);

    private static native int nativeGetSubType(long j10);

    private static native int nativeGetType(long j10);

    private static native boolean nativeIsClickable(long j10);

    private static native boolean nativeIsVisible(long j10);

    private static native void nativeRemoveAll(long j10);

    private static native void nativeRemoveItem(long j10, int i10);

    private static native void nativeSetClickable(long j10, boolean z10);

    private static native void nativeSetMaxDisplayLevel(long j10, float f10);

    private static native void nativeSetMinDisplayLevel(long j10, float f10);

    private static native void nativeSetOverlayOnTop(long j10, boolean z10);

    private static native void nativeSetOverlayPriority(long j10, int i10);

    public static native void nativeSetVisible(long j10, boolean z10);

    public void clearFocus() {
    }

    public int getCode() {
        return this.mCode;
    }

    public boolean getIsInBundle() {
        return this.mIsInBundle;
    }

    public long getNativeInstatnce() {
        return this.mNativeInstance;
    }

    public int getOverlayPriority() {
        return nativeGetOverlayPriority(this.mNativeInstance);
    }

    public int getSize() {
        long j10 = this.mNativeInstance;
        if (j10 == 0) {
            return 0;
        }
        return nativeGetCount(j10);
    }

    public int getSubType() {
        long j10 = this.mNativeInstance;
        if (j10 == 0) {
            return -1;
        }
        return nativeGetSubType(j10);
    }

    public int getType() {
        long j10 = this.mNativeInstance;
        if (j10 == 0) {
            return -1;
        }
        return nativeGetType(j10);
    }

    public boolean isClickable() {
        long j10 = this.mNativeInstance;
        if (j10 == 0) {
            return false;
        }
        return nativeIsClickable(j10);
    }

    public boolean isVisible() {
        long j10 = this.mNativeInstance;
        if (j10 == 0) {
            return false;
        }
        return nativeIsVisible(j10);
    }

    public void releaseInstance() {
        if (this.mNativeInstance != 0) {
            this.mNativeInstance = 0L;
        }
    }

    public void removeAll() {
        long j10 = this.mNativeInstance;
        if (j10 == 0) {
            return;
        }
        nativeRemoveAll(j10);
    }

    public void removeItem(int i10) {
        long j10 = this.mNativeInstance;
        if (j10 == 0) {
            return;
        }
        nativeRemoveItem(j10, i10);
    }

    public void setClickable(boolean z10) {
        long j10 = this.mNativeInstance;
        if (j10 == 0) {
            return;
        }
        nativeSetClickable(j10, z10);
    }

    public void setMaxDisplayLevel(float f10) {
        nativeSetMaxDisplayLevel(this.mNativeInstance, f10);
    }

    public void setMinDisplayLevel(float f10) {
        nativeSetMinDisplayLevel(this.mNativeInstance, f10);
    }

    public void setOverlayItemPriority(int i10) {
        this.mItemPriority = i10;
    }

    public void setOverlayOnTop(boolean z10) {
        nativeSetOverlayOnTop(this.mNativeInstance, z10);
    }

    public void setOverlayPriority(int i10) {
        GLOverlayBundle overlayBundle;
        nativeSetOverlayPriority(this.mNativeInstance, i10);
        IAMapDelegate iAMapDelegate = this.mGLMapView;
        if (iAMapDelegate == null || iAMapDelegate.getGLMapEngine() == null || (overlayBundle = this.mGLMapView.getGLMapEngine().getOverlayBundle(this.mEngineID)) == null) {
            return;
        }
        overlayBundle.sortOverlay();
    }

    public void setVisible(boolean z10) {
        long j10 = this.mNativeInstance;
        if (j10 == 0) {
            return;
        }
        nativeSetVisible(j10, z10);
    }

    public void useNightStyle(boolean z10) {
        this.isNightStyle = z10;
    }
}
