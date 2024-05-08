package com.autonavi.base.ae.gmap.glyph;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class FontMetrics {
    public boolean bSuccess;
    public float fAscent;
    public float fDescent;
    public float fHeight;
    public float fLeading;

    public FontMetrics() {
        this.bSuccess = false;
        this.fAscent = 0.0f;
        this.fDescent = 0.0f;
        this.fLeading = 0.0f;
        this.fHeight = 0.0f;
    }

    public FontMetrics(float f10, float f11, float f12, float f13) {
        this.bSuccess = false;
        this.fAscent = f10;
        this.fDescent = f11;
        this.fLeading = f12;
        this.fHeight = f13;
    }
}
