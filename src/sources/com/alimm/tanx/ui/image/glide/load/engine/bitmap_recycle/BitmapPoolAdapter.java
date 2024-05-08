package com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class BitmapPoolAdapter implements BitmapPool {
    @Override // com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool
    public void clearMemory() {
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool
    public Bitmap get(int i10, int i11, Bitmap.Config config) {
        return null;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool
    public Bitmap getDirty(int i10, int i11, Bitmap.Config config) {
        return null;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool
    public int getMaxSize() {
        return 0;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool
    public boolean put(Bitmap bitmap) {
        return false;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool
    public void setSizeMultiplier(float f10) {
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool
    public void trimMemory(int i10) {
    }
}
