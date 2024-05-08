package com.autonavi.base.ae.gmap.gloverlay;

import android.content.Context;
import android.graphics.Bitmap;
import com.autonavi.amap.mapcore.interfaces.IAMap;
import com.autonavi.base.ae.gmap.gloverlay.GLOverlay;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import java.io.Serializable;
import java.util.List;
import java.util.Vector;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public abstract class BaseMapOverlay<T extends GLOverlay, E> implements Serializable {
    private static final long serialVersionUID = 1;
    public Context mContext;
    public int mEngineID;
    public T mGLOverlay;
    public Vector<E> mItemList;
    public int mLastFocusedIndex;
    public IAMapDelegate mMapView;

    public BaseMapOverlay(int i10, Context context, IAMap iAMap) {
        this.mItemList = null;
        this.mEngineID = i10;
        this.mContext = context;
        try {
            this.mMapView = (IAMapDelegate) iAMap;
        } catch (Throwable unused) {
        }
        this.mItemList = new Vector<>();
        iniGLOverlay();
    }

    public abstract void addItem(E e2);

    public boolean clear() {
        try {
            this.mItemList.clear();
            clearFocus();
            T t2 = this.mGLOverlay;
            if (t2 == null) {
                return true;
            }
            t2.removeAll();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public void clearFocus() {
        this.mLastFocusedIndex = -1;
        this.mGLOverlay.clearFocus();
    }

    public T getGLOverlay() {
        return this.mGLOverlay;
    }

    public final E getItem(int i10) {
        try {
            synchronized (this.mItemList) {
                if (i10 >= 0) {
                    if (i10 <= this.mItemList.size() - 1) {
                        return this.mItemList.get(i10);
                    }
                }
                return null;
            }
        } catch (IndexOutOfBoundsException unused) {
            return null;
        }
    }

    public List<E> getItems() {
        return this.mItemList;
    }

    public int getSize() {
        return this.mItemList.size();
    }

    public abstract void iniGLOverlay();

    public boolean isClickable() {
        T t2 = this.mGLOverlay;
        if (t2 != null) {
            return t2.isClickable();
        }
        return false;
    }

    public boolean isVisible() {
        T t2 = this.mGLOverlay;
        if (t2 != null) {
            return t2.isVisible();
        }
        return false;
    }

    public void releaseInstance() {
        if (getGLOverlay() != null) {
            IAMapDelegate iAMapDelegate = this.mMapView;
            if (iAMapDelegate != null && iAMapDelegate.isMaploaded()) {
                this.mMapView.removeEngineGLOverlay(this);
            }
            getGLOverlay().releaseInstance();
            this.mGLOverlay = null;
        }
    }

    public boolean removeAll() {
        return clear();
    }

    public void removeItem(int i10) {
        if (i10 >= 0) {
            try {
                if (i10 > this.mItemList.size() - 1) {
                    return;
                }
                if (i10 == this.mLastFocusedIndex) {
                    this.mLastFocusedIndex = -1;
                    clearFocus();
                }
                this.mItemList.remove(i10);
                T t2 = this.mGLOverlay;
                if (t2 != null) {
                    t2.removeItem(i10);
                }
            } catch (IndexOutOfBoundsException unused) {
            }
        }
    }

    public abstract void resumeMarker(Bitmap bitmap);

    public void setClickable(boolean z10) {
        T t2 = this.mGLOverlay;
        if (t2 != null) {
            t2.setClickable(z10);
        }
    }

    public abstract void setVisible(boolean z10);

    public void removeItem(E e2) {
        if (e2 == null) {
            return;
        }
        try {
            synchronized (this.mItemList) {
                removeItem(this.mItemList.indexOf(e2));
            }
        } catch (IndexOutOfBoundsException unused) {
        }
    }
}
