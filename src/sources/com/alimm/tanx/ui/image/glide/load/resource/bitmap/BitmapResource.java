package com.alimm.tanx.ui.image.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.alimm.tanx.ui.image.glide.load.engine.Resource;
import com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool;
import com.alimm.tanx.ui.image.glide.util.Util;
import java.util.Objects;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class BitmapResource implements Resource<Bitmap> {
    public final Bitmap bitmap;
    public final BitmapPool bitmapPool;

    public BitmapResource(Bitmap bitmap, BitmapPool bitmapPool) {
        Objects.requireNonNull(bitmap, "Bitmap must not be null");
        Objects.requireNonNull(bitmapPool, "BitmapPool must not be null");
        this.bitmap = bitmap;
        this.bitmapPool = bitmapPool;
    }

    public static BitmapResource obtain(Bitmap bitmap, BitmapPool bitmapPool) {
        if (bitmap == null) {
            return null;
        }
        return new BitmapResource(bitmap, bitmapPool);
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.Resource
    public int getSize() {
        return Util.getBitmapByteSize(this.bitmap);
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.Resource
    public void recycle() {
        if (this.bitmapPool.put(this.bitmap)) {
            return;
        }
        this.bitmap.recycle();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.alimm.tanx.ui.image.glide.load.engine.Resource
    public Bitmap get() {
        return this.bitmap;
    }
}
