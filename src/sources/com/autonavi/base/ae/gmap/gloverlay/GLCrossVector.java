package com.autonavi.base.ae.gmap.gloverlay;

import android.graphics.Rect;
import com.autonavi.ae.gmap.gloverlay.AVectorCrossAttr;
import com.autonavi.base.ae.gmap.gloverlay.GLOverlay;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class GLCrossVector extends GLOverlay {
    private long mDiceNativeInstance;

    public GLCrossVector(final int i10, final IAMapDelegate iAMapDelegate, int i11) {
        super(i10, iAMapDelegate, i11);
        this.mDiceNativeInstance = 0L;
        if (iAMapDelegate == null || iAMapDelegate.getGLMapEngine() == null) {
            return;
        }
        iAMapDelegate.queueEvent(new Runnable() { // from class: com.autonavi.base.ae.gmap.gloverlay.GLCrossVector.1
            @Override // java.lang.Runnable
            public void run() {
                GLCrossVector.this.mNativeInstance = iAMapDelegate.getGLMapEngine().createOverlay(i10, GLOverlay.EAMapOverlayTpye.AMAPOVERLAY_VECTOR.ordinal());
            }
        });
    }

    private static native void nativeAddVectorCar(long j10, int i10, int i11, int i12);

    /* JADX INFO: Access modifiers changed from: private */
    public static native int nativeAddVectorData(long j10, int[] iArr, byte[] bArr);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeInitTextureCallback(long j10, Object obj, boolean z10);

    private static native void nativeSetArrowResId(long j10, boolean z10, int i10);

    private static native void nativeSetBackgroundResId(long j10, int i10);

    private static native void nativeSetCarResId(long j10, int i10);

    public int addVectorItem(AVectorCrossAttr aVectorCrossAttr, final byte[] bArr, int i10) {
        if (aVectorCrossAttr == null || bArr == null || i10 == 0) {
            return -1;
        }
        Rect rect = aVectorCrossAttr.stAreaRect;
        final int[] iArr = {rect.left, rect.top, rect.right, rect.bottom, aVectorCrossAttr.stAreaColor, aVectorCrossAttr.fArrowBorderWidth, aVectorCrossAttr.stArrowBorderColor, aVectorCrossAttr.fArrowLineWidth, aVectorCrossAttr.stArrowLineColor, aVectorCrossAttr.dayMode ? 1 : 0};
        IAMapDelegate iAMapDelegate = this.mGLMapView;
        if (iAMapDelegate != null) {
            iAMapDelegate.queueEvent(new Runnable() { // from class: com.autonavi.base.ae.gmap.gloverlay.GLCrossVector.2
                @Override // java.lang.Runnable
                public void run() {
                    GLCrossVector.nativeAddVectorData(GLCrossVector.this.mNativeInstance, iArr, bArr);
                }
            });
        }
        return 0;
    }

    public void initTextureCallback(final CrossVectorOverlay crossVectorOverlay, final boolean z10) {
        IAMapDelegate iAMapDelegate = this.mGLMapView;
        if (iAMapDelegate != null) {
            iAMapDelegate.queueEvent(new Runnable() { // from class: com.autonavi.base.ae.gmap.gloverlay.GLCrossVector.3
                @Override // java.lang.Runnable
                public void run() {
                    GLCrossVector.nativeInitTextureCallback(GLCrossVector.this.mNativeInstance, crossVectorOverlay, z10);
                }
            });
        }
    }

    @Override // com.autonavi.base.ae.gmap.gloverlay.GLOverlay
    public void releaseInstance() {
        long j10 = this.mNativeInstance;
        this.mNativeInstance = 0L;
        this.mGLMapView.getGLMapEngine().destroyOverlay(this.mEngineID, j10);
        super.releaseInstance();
    }

    public void setArrowResId(boolean z10, int i10) {
        nativeSetArrowResId(this.mNativeInstance, z10, i10);
    }

    public void setBackgroundResId(int i10) {
        nativeSetBackgroundResId(this.mNativeInstance, i10);
    }

    public void setCarResId(int i10) {
        nativeSetCarResId(this.mNativeInstance, i10);
    }
}
