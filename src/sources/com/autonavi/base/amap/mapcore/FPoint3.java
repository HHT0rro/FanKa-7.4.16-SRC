package com.autonavi.base.amap.mapcore;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class FPoint3 extends FPoint {
    public int colorIndex;

    public FPoint3() {
        this.colorIndex = -1;
    }

    public void setColorIndex(int i10) {
        this.colorIndex = i10;
    }

    public FPoint3(float f10, float f11, int i10) {
        super(f10, f11);
        this.colorIndex = i10;
    }
}
