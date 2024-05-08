package com.autonavi.base.amap.mapcore;

import android.graphics.PointF;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class FPointBounds {
    private final int mVersionCode;
    public final FPoint northeast;
    public final FPoint southwest;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class Builder {
        private float mSouth = Float.POSITIVE_INFINITY;
        private float mNorth = Float.NEGATIVE_INFINITY;
        private float mWest = Float.POSITIVE_INFINITY;
        private float mEast = Float.NEGATIVE_INFINITY;

        private boolean containsx(double d10) {
            float f10 = this.mWest;
            float f11 = this.mEast;
            return f10 <= f11 ? ((double) f10) <= d10 && d10 <= ((double) f11) : ((double) f10) <= d10 || d10 <= ((double) f11);
        }

        public final FPointBounds build() {
            return new FPointBounds(FPoint.obtain(this.mWest, this.mSouth), FPoint.obtain(this.mEast, this.mNorth));
        }

        public final Builder include(FPoint fPoint) {
            this.mSouth = Math.min(this.mSouth, ((PointF) fPoint).y);
            this.mNorth = Math.max(this.mNorth, ((PointF) fPoint).y);
            this.mWest = Math.min(this.mWest, ((PointF) fPoint).x);
            this.mEast = Math.max(this.mEast, ((PointF) fPoint).x);
            return this;
        }
    }

    public FPointBounds(int i10, FPoint fPoint, FPoint fPoint2) {
        this.mVersionCode = i10;
        this.southwest = fPoint;
        this.northeast = fPoint2;
    }

    public static Builder builder() {
        return new Builder();
    }

    private boolean containsx(double d10) {
        float f10 = ((PointF) this.southwest).x;
        float f11 = ((PointF) this.northeast).x;
        return f10 <= f11 ? ((double) f10) <= d10 && d10 <= ((double) f11) : ((double) f10) <= d10 || d10 <= ((double) f11);
    }

    private boolean containsy(double d10) {
        return ((double) ((PointF) this.southwest).y) <= d10 && d10 <= ((double) ((PointF) this.northeast).y);
    }

    private boolean intersect(FPointBounds fPointBounds) {
        FPoint fPoint;
        FPoint fPoint2;
        FPoint fPoint3;
        FPoint fPoint4;
        if (fPointBounds != null && (fPoint = fPointBounds.northeast) != null && (fPoint2 = fPointBounds.southwest) != null && (fPoint3 = this.northeast) != null && (fPoint4 = this.southwest) != null) {
            float f10 = ((PointF) fPoint).x;
            float f11 = ((PointF) fPoint2).x + f10;
            float f12 = ((PointF) fPoint3).x;
            float f13 = ((PointF) fPoint4).x;
            double d10 = (f11 - f12) - f13;
            double d11 = ((f12 - f13) + f10) - f13;
            float f14 = ((PointF) fPoint).y;
            float f15 = ((PointF) fPoint2).y;
            float f16 = ((PointF) fPoint3).y;
            float f17 = ((PointF) fPoint4).y;
            double d12 = ((f14 + f15) - f16) - f17;
            double d13 = ((f16 - f17) + f14) - f15;
            if (Math.abs(d10) < d11 && Math.abs(d12) < d13) {
                return true;
            }
        }
        return false;
    }

    public boolean contains(FPoint fPoint) {
        return containsy((double) ((PointF) fPoint).y) && containsx((double) ((PointF) fPoint).x);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FPointBounds)) {
            return false;
        }
        FPointBounds fPointBounds = (FPointBounds) obj;
        return this.southwest.equals(fPointBounds.southwest) && this.northeast.equals(fPointBounds.northeast);
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public boolean intersects(FPointBounds fPointBounds) {
        if (fPointBounds == null) {
            return false;
        }
        return intersect(fPointBounds) || fPointBounds.intersect(this);
    }

    public String toString() {
        return "southwest = (" + ((PointF) this.southwest).x + "," + ((PointF) this.southwest).y + ") northeast = (" + ((PointF) this.northeast).x + "," + ((PointF) this.northeast).y + ")";
    }

    public boolean contains(FPointBounds fPointBounds) {
        return fPointBounds != null && contains(fPointBounds.southwest) && contains(fPointBounds.northeast);
    }

    public FPointBounds(FPoint fPoint, FPoint fPoint2) {
        this(1, fPoint, fPoint2);
    }
}
