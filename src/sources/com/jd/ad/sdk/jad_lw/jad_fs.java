package com.jd.ad.sdk.jad_lw;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class jad_fs implements jad_er {
    @Override // com.jd.ad.sdk.jad_lw.jad_er
    @NonNull
    public Bitmap jad_an(int i10, int i11, Bitmap.Config config) {
        return Bitmap.createBitmap(i10, i11, config);
    }

    @Override // com.jd.ad.sdk.jad_lw.jad_er
    public void jad_an() {
    }

    @Override // com.jd.ad.sdk.jad_lw.jad_er
    public void jad_an(int i10) {
    }

    @Override // com.jd.ad.sdk.jad_lw.jad_er
    public void jad_an(Bitmap bitmap) {
        bitmap.recycle();
    }

    @Override // com.jd.ad.sdk.jad_lw.jad_er
    @NonNull
    public Bitmap jad_bo(int i10, int i11, Bitmap.Config config) {
        return Bitmap.createBitmap(i10, i11, config);
    }
}
