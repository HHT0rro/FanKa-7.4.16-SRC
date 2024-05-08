package com.autonavi.base.amap.mapcore;

import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

@JBindingInclude
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class Rectangle {

    @JBindingInclude
    private int beyond180Mode;
    public float bottom;
    public FPoint[] clipMapRect;
    public IPoint[] clipRect;

    @JBindingInclude
    private int[] jniClipRect;
    public float left;
    public Rect rect;
    public float right;
    public float top;

    public Rectangle() {
        this.rect = new Rect();
        this.beyond180Mode = 0;
        this.clipRect = null;
        this.clipMapRect = null;
        this.jniClipRect = new int[8];
    }

    private void updateClipMapRect(int i10, int i11) {
        int i12 = 0;
        if (this.clipMapRect == null) {
            FPoint[] fPointArr = new FPoint[4];
            this.clipMapRect = fPointArr;
            fPointArr[0] = FPoint.obtain(0.0f, 0.0f);
            this.clipMapRect[1] = FPoint.obtain(0.0f, 0.0f);
            this.clipMapRect[2] = FPoint.obtain(0.0f, 0.0f);
            this.clipMapRect[3] = FPoint.obtain(0.0f, 0.0f);
        }
        Rect rect = this.rect;
        if (rect != null) {
            FPoint[] fPointArr2 = this.clipMapRect;
            FPoint fPoint = fPointArr2[0];
            int i13 = rect.left;
            ((PointF) fPoint).x = i13 - i10;
            FPoint fPoint2 = fPointArr2[0];
            int i14 = rect.top;
            ((PointF) fPoint2).y = i14 - i11;
            FPoint fPoint3 = fPointArr2[1];
            int i15 = rect.right;
            ((PointF) fPoint3).x = i15 - i10;
            ((PointF) fPointArr2[1]).y = i14 - i11;
            ((PointF) fPointArr2[2]).x = i15 - i10;
            FPoint fPoint4 = fPointArr2[2];
            int i16 = rect.bottom;
            ((PointF) fPoint4).y = i16 - i11;
            ((PointF) fPointArr2[3]).x = i13 - i10;
            ((PointF) fPointArr2[3]).y = i16 - i11;
        }
        if (this.jniClipRect == null) {
            this.jniClipRect = new int[this.clipMapRect.length * 2];
        }
        while (true) {
            FPoint[] fPointArr3 = this.clipMapRect;
            if (i12 >= fPointArr3.length) {
                return;
            }
            int[] iArr = this.jniClipRect;
            int i17 = i12 * 2;
            iArr[i17] = (int) ((PointF) fPointArr3[i12]).x;
            iArr[i17 + 1] = (int) ((PointF) fPointArr3[i12]).y;
            i12++;
        }
    }

    private void updateClipRect() {
        if (this.clipRect == null) {
            IPoint[] iPointArr = new IPoint[4];
            this.clipRect = iPointArr;
            iPointArr[0] = IPoint.obtain(0, 0);
            this.clipRect[1] = IPoint.obtain(0, 0);
            this.clipRect[2] = IPoint.obtain(0, 0);
            this.clipRect[3] = IPoint.obtain(0, 0);
        }
        Rect rect = this.rect;
        if (rect != null) {
            IPoint[] iPointArr2 = this.clipRect;
            IPoint iPoint = iPointArr2[0];
            int i10 = rect.left;
            ((Point) iPoint).x = i10;
            IPoint iPoint2 = iPointArr2[0];
            int i11 = rect.top;
            ((Point) iPoint2).y = i11;
            IPoint iPoint3 = iPointArr2[1];
            int i12 = rect.right;
            ((Point) iPoint3).x = i12;
            ((Point) iPointArr2[1]).y = i11;
            ((Point) iPointArr2[2]).x = i12;
            IPoint iPoint4 = iPointArr2[2];
            int i13 = rect.bottom;
            ((Point) iPoint4).y = i13;
            ((Point) iPointArr2[3]).x = i10;
            ((Point) iPointArr2[3]).y = i13;
        }
    }

    public boolean contains(int i10, int i11) {
        Rect rect = this.rect;
        if (rect == null) {
            return false;
        }
        if (rect.contains(i10, i11)) {
            return true;
        }
        if (this.beyond180Mode != 0) {
            return this.rect.contains(i10 - 268435456, i11) || this.rect.contains(i10 + 268435456, i11);
        }
        return false;
    }

    public int getBeyond180Mode() {
        return this.beyond180Mode;
    }

    public FPoint[] getClipMapRect() {
        return this.clipMapRect;
    }

    public IPoint[] getClipRect() {
        return this.clipRect;
    }

    public Rect getRect() {
        return this.rect;
    }

    public boolean isOverlap(Rect rect) {
        Rect rect2 = this.rect;
        if (rect2 != null && rect != null) {
            int width = rect2.left + rect2.width();
            int i10 = rect.left;
            if (width > i10) {
                int width2 = i10 + rect.width();
                Rect rect3 = this.rect;
                if (width2 > rect3.left) {
                    int height = rect3.top + rect3.height();
                    int i11 = rect.top;
                    if (height > i11 && i11 + rect.height() > this.rect.top) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void updateRect(Rect rect, int i10, int i11) {
        if (rect != null) {
            this.rect = rect;
            rect.inset((-rect.width()) / 8, (-rect.height()) / 8);
            float f10 = r4.left / 100000.0f;
            int i12 = this.rect.right;
            if (f10 * (i12 / 100000.0f) < 0.0f) {
                this.beyond180Mode = -1;
            } else if (i12 > 268435456) {
                this.beyond180Mode = 1;
            } else {
                this.beyond180Mode = 0;
            }
            updateClipRect();
            updateClipMapRect(i10, i11);
        }
    }

    public boolean contains(IPoint iPoint) {
        if (iPoint == null) {
            return false;
        }
        return contains(((Point) iPoint).x, ((Point) iPoint).y);
    }

    public boolean isOverlap(int i10, int i11, int i12, int i13) {
        Rect rect = this.rect;
        if (rect != null && rect.left + rect.width() > i10) {
            int i14 = i10 + i12;
            Rect rect2 = this.rect;
            if (i14 > rect2.left && rect2.top + rect2.height() > i11 && i11 + i13 > this.rect.top) {
                return true;
            }
        }
        return false;
    }

    public Rectangle(Rect rect, int i10, int i11) {
        new Rect();
        this.beyond180Mode = 0;
        this.clipRect = null;
        this.clipMapRect = null;
        this.jniClipRect = new int[8];
        this.rect = rect;
        if (rect != null) {
            updateRect(rect, i10, i11);
            updateClipRect();
            updateClipMapRect(rect.centerX(), rect.centerY());
        }
    }

    public boolean contains(Rect rect) {
        if (rect == null) {
            return false;
        }
        return this.rect.contains(rect);
    }

    public Rectangle(float f10, float f11, float f12, float f13) {
        this.rect = new Rect();
        this.beyond180Mode = 0;
        this.clipRect = null;
        this.clipMapRect = null;
        this.jniClipRect = new int[8];
        if (f10 >= f11 || f13 <= f12) {
            return;
        }
        this.left = f10;
        this.right = f11;
        this.top = f13;
        this.bottom = f12;
    }
}
