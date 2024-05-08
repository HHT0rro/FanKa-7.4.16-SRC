package com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface BitmapPool {
    void clearMemory();

    Bitmap get(int i10, int i11, Bitmap.Config config);

    Bitmap getDirty(int i10, int i11, Bitmap.Config config);

    int getMaxSize();

    boolean put(Bitmap bitmap);

    void setSizeMultiplier(float f10);

    void trimMemory(int i10);
}
