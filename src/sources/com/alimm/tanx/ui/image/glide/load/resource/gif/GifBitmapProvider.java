package com.alimm.tanx.ui.image.glide.load.resource.gif;

import android.graphics.Bitmap;
import com.alimm.tanx.ui.image.glide.gifdecoder.GifDecoder;
import com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class GifBitmapProvider implements GifDecoder.BitmapProvider {
    public final BitmapPool bitmapPool;

    public GifBitmapProvider(BitmapPool bitmapPool) {
        this.bitmapPool = bitmapPool;
    }

    @Override // com.alimm.tanx.ui.image.glide.gifdecoder.GifDecoder.BitmapProvider
    public Bitmap obtain(int i10, int i11, Bitmap.Config config) {
        return this.bitmapPool.getDirty(i10, i11, config);
    }

    @Override // com.alimm.tanx.ui.image.glide.gifdecoder.GifDecoder.BitmapProvider
    public void release(Bitmap bitmap) {
        if (this.bitmapPool.put(bitmap)) {
            return;
        }
        bitmap.recycle();
    }
}
