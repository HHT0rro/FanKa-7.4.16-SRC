package com.alimm.tanx.ui.image.glide.load.resource.gif;

import android.graphics.Bitmap;
import com.alimm.tanx.ui.image.glide.gifdecoder.GifDecoder;
import com.alimm.tanx.ui.image.glide.load.ResourceDecoder;
import com.alimm.tanx.ui.image.glide.load.engine.Resource;
import com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool;
import com.alimm.tanx.ui.image.glide.load.resource.bitmap.BitmapResource;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class GifFrameResourceDecoder implements ResourceDecoder<GifDecoder, Bitmap> {
    public final BitmapPool bitmapPool;

    public GifFrameResourceDecoder(BitmapPool bitmapPool) {
        this.bitmapPool = bitmapPool;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.ResourceDecoder
    public String getId() {
        return "GifFrameResourceDecoder.com.alimm.tanx.ui.image.glide.load.resource.gif";
    }

    @Override // com.alimm.tanx.ui.image.glide.load.ResourceDecoder
    public Resource<Bitmap> decode(GifDecoder gifDecoder, int i10, int i11) {
        return BitmapResource.obtain(gifDecoder.getNextFrame(), this.bitmapPool);
    }
}
