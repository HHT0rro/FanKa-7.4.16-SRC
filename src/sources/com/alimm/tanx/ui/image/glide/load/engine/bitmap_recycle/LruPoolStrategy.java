package com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface LruPoolStrategy {
    Bitmap get(int i10, int i11, Bitmap.Config config);

    int getSize(Bitmap bitmap);

    String logBitmap(int i10, int i11, Bitmap.Config config);

    String logBitmap(Bitmap bitmap);

    void put(Bitmap bitmap);

    Bitmap removeLast();
}
