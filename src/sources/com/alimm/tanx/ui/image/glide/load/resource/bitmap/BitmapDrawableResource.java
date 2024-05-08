package com.alimm.tanx.ui.image.glide.load.resource.bitmap;

import android.graphics.drawable.BitmapDrawable;
import com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool;
import com.alimm.tanx.ui.image.glide.load.resource.drawable.DrawableResource;
import com.alimm.tanx.ui.image.glide.util.Util;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class BitmapDrawableResource extends DrawableResource<BitmapDrawable> {
    public final BitmapPool bitmapPool;

    public BitmapDrawableResource(BitmapDrawable bitmapDrawable, BitmapPool bitmapPool) {
        super(bitmapDrawable);
        this.bitmapPool = bitmapPool;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.Resource
    public int getSize() {
        return Util.getBitmapByteSize(((BitmapDrawable) this.drawable).getBitmap());
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.Resource
    public void recycle() {
        this.bitmapPool.put(((BitmapDrawable) this.drawable).getBitmap());
    }
}
