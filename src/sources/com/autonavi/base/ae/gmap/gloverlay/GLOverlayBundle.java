package com.autonavi.base.ae.gmap.gloverlay;

import android.util.SparseArray;
import com.autonavi.base.ae.gmap.gloverlay.BaseMapOverlay;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class GLOverlayBundle<E extends BaseMapOverlay<?, ?>> {
    private int mEngineID;
    private long mNativeInstance;
    private final List<E> mOverlayList = new ArrayList();
    private SparseArray<GLOverlayTexture> mTextureCaches = new SparseArray<>();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class GLAmapFocusHits {
        public long mOverlayHashCode = 0;
        public long mHitedIndex = 0;
        public long mHitedTimes = 1000;
    }

    public GLOverlayBundle(int i10, IAMapDelegate iAMapDelegate) {
        this.mNativeInstance = 0L;
        this.mEngineID = i10;
        if (iAMapDelegate != null) {
            try {
                this.mNativeInstance = iAMapDelegate.getGLMapEngine().getGlOverlayMgrPtr(this.mEngineID);
            } catch (Throwable unused) {
            }
        }
    }

    private int getOverlyExType(E e2) {
        return 0;
    }

    public static void intClr2PVRClr(float[] fArr, int i10) {
        fArr[2] = (i10 & 255) / 255.0f;
        fArr[1] = ((i10 >> 8) & 255) / 255.0f;
        fArr[0] = ((i10 >> 16) & 255) / 255.0f;
        fArr[3] = ((i10 >> 24) & 255) / 255.0f;
    }

    private static native void nativeAddGLOverlay(long j10, long j11, long j12);

    private static native void nativeAddGLOverlayEx(long j10, long j11, long j12, int i10);

    private static native void nativeClearAllGLOverlay(long j10, boolean z10);

    private static native boolean nativeOnSingleTapLineOverlay(long j10, int i10, int i11, long[] jArr);

    private static native boolean nativeOnSingleTapPointOverlay(long j10, int i10, int i11, long[] jArr);

    private static native void nativeRemoveGLOverlay(long j10, long j11);

    private static native void nativeRemoveGLOverlayEx(long j10, long j11, int i10);

    private static native void nativeSortAllGLOverlay(long j10);

    public void addOverlay(E e2) {
        if (e2 == null) {
            return;
        }
        nativeAddGLOverlay(this.mNativeInstance, e2.getGLOverlay().getNativeInstatnce(), e2.getGLOverlay().getCode());
        e2.getGLOverlay().mIsInBundle = true;
        synchronized (this.mOverlayList) {
            this.mOverlayList.add(e2);
        }
    }

    public boolean addOverlayTextureItem(int i10, int i11, int i12, int i13) {
        GLOverlayTexture gLOverlayTexture = new GLOverlayTexture(i10, i11, i12, i13);
        synchronized (this.mTextureCaches) {
            this.mTextureCaches.put(i10, gLOverlayTexture);
        }
        return true;
    }

    public long checkSingleTapOnLine(int i10, int i11) {
        long[] jArr = new long[3];
        if (nativeOnSingleTapLineOverlay(this.mNativeInstance, i10, i11, jArr)) {
            return jArr[0];
        }
        return -1L;
    }

    public long checkSingleTapOnPoint(int i10, int i11) {
        long[] jArr = new long[3];
        if (nativeOnSingleTapPointOverlay(this.mNativeInstance, i10, i11, jArr)) {
            return jArr[0];
        }
        return -1L;
    }

    public void clearFocus() {
        List<E> list = this.mOverlayList;
        if (list != null) {
            synchronized (list) {
                for (int i10 = 0; i10 < this.mOverlayList.size(); i10++) {
                    E e2 = this.mOverlayList.get(i10);
                    if (e2 != null) {
                        e2.clearFocus();
                    }
                }
            }
        }
    }

    public void clearOverlayTexture() {
        synchronized (this.mTextureCaches) {
            this.mTextureCaches.clear();
        }
    }

    public boolean cotainsOverlay(E e2) {
        boolean contains;
        if (e2 == null) {
            return false;
        }
        synchronized (this.mOverlayList) {
            contains = this.mOverlayList.contains(e2);
        }
        return contains;
    }

    public E getOverlay(int i10) {
        synchronized (this.mOverlayList) {
            if (i10 >= 0) {
                if (i10 <= this.mOverlayList.size() - 1) {
                    return this.mOverlayList.get(i10);
                }
            }
            return null;
        }
    }

    public int getOverlayCount() {
        int size;
        synchronized (this.mOverlayList) {
            size = this.mOverlayList.size();
        }
        return size;
    }

    public GLOverlayTexture getOverlayTextureItem(int i10) {
        GLOverlayTexture gLOverlayTexture;
        synchronized (this.mTextureCaches) {
            gLOverlayTexture = this.mTextureCaches.get(i10);
        }
        return gLOverlayTexture;
    }

    public boolean onSingleTap(int i10, int i11, int i12, int i13) {
        boolean onSingleTapPoints = (i13 & 1) == 1 ? onSingleTapPoints(i10, i11, i12) : false;
        if (onSingleTapPoints) {
            return true;
        }
        if ((i13 & 2) == 2) {
            onSingleTapPoints = onSingleTapLines(i10, i11, i12);
        }
        return onSingleTapPoints;
    }

    public boolean onSingleTapLines(int i10, int i11, int i12) {
        return false;
    }

    public boolean onSingleTapPoints(int i10, int i11, int i12) {
        return false;
    }

    public void reculateRouteBoard(IAMapDelegate iAMapDelegate) {
    }

    public void removeAll(boolean z10) {
        nativeClearAllGLOverlay(this.mNativeInstance, z10);
        synchronized (this.mOverlayList) {
            for (int i10 = 0; i10 < this.mOverlayList.size(); i10++) {
                E e2 = this.mOverlayList.get(i10);
                if (e2 != null) {
                    e2.getGLOverlay().mIsInBundle = false;
                    e2.getGLOverlay().releaseInstance();
                }
            }
            this.mOverlayList.clear();
        }
    }

    public void removeOverlay(E e2) {
        if (e2 == null) {
            return;
        }
        nativeRemoveGLOverlay(this.mNativeInstance, e2.getGLOverlay().getNativeInstatnce());
        e2.getGLOverlay().mIsInBundle = false;
        synchronized (this.mOverlayList) {
            this.mOverlayList.remove(e2);
        }
    }

    public void sortOverlay() {
        nativeSortAllGLOverlay(this.mNativeInstance);
    }

    public boolean addOverlayTextureItem(int i10, int i11, float f10, float f11, int i12, int i13) {
        GLOverlayTexture gLOverlayTexture = new GLOverlayTexture(i10, i11, f10, f11, i12, i13);
        synchronized (this.mTextureCaches) {
            this.mTextureCaches.put(i10, gLOverlayTexture);
        }
        return true;
    }
}
