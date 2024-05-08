package com.huawei.hms.ads;

import android.graphics.Bitmap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class fj {
    public int Code;
    public int I;
    public Bitmap V;

    public fj() {
    }

    public fj(int i10, Bitmap bitmap, int i11) {
        this.Code = i10;
        this.V = bitmap;
        this.I = i11;
    }

    public fj Code() {
        fj fjVar = new fj();
        fjVar.Code = this.Code;
        fjVar.I = this.I;
        return fjVar;
    }

    public String toString() {
        return "GifFrame{frameIndex=" + this.Code + ", delay=" + this.I + '}';
    }
}
