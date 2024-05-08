package com.autonavi.amap.mapcore;

import com.autonavi.ae.gmap.maploader.Pools;
import com.google.android.material.shadow.ShadowDrawableWrapper;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class DPoint {
    private static final Pools.SynchronizedPool<DPoint> M_POOL = new Pools.SynchronizedPool<>(32);

    /* renamed from: x, reason: collision with root package name */
    public double f9303x;

    /* renamed from: y, reason: collision with root package name */
    public double f9304y;

    public DPoint() {
    }

    public static DPoint obtain() {
        DPoint acquire = M_POOL.acquire();
        if (acquire == null) {
            return new DPoint();
        }
        acquire.set(ShadowDrawableWrapper.COS_45, ShadowDrawableWrapper.COS_45);
        return acquire;
    }

    private void set(double d10, double d11) {
        this.f9303x = d10;
        this.f9304y = d11;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DPoint)) {
            return false;
        }
        DPoint dPoint = (DPoint) obj;
        return Double.doubleToLongBits(this.f9303x) == Double.doubleToLongBits(dPoint.f9303x) && Double.doubleToLongBits(this.f9304y) == Double.doubleToLongBits(dPoint.f9304y);
    }

    public void recycle() {
        M_POOL.release(this);
    }

    public DPoint(double d10, double d11) {
        this.f9303x = d10;
        this.f9304y = d11;
    }

    public static DPoint obtain(double d10, double d11) {
        DPoint acquire = M_POOL.acquire();
        if (acquire == null) {
            return new DPoint(d10, d11);
        }
        acquire.set(d10, d11);
        return acquire;
    }
}
