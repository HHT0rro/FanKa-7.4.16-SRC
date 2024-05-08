package com.alimm.tanx.ui.image.glide.load.resource.bitmap;

import com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool;
import com.alimm.tanx.ui.image.glide.load.resource.drawable.DrawableResource;
import com.alimm.tanx.ui.image.glide.util.Util;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class GlideBitmapDrawableResource extends DrawableResource<GlideBitmapDrawable> {
    public final BitmapPool bitmapPool;

    public GlideBitmapDrawableResource(GlideBitmapDrawable glideBitmapDrawable, BitmapPool bitmapPool) {
        super(glideBitmapDrawable);
        this.bitmapPool = bitmapPool;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.Resource
    public int getSize() {
        return Util.getBitmapByteSize(((GlideBitmapDrawable) this.drawable).getBitmap());
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.Resource
    public void recycle() {
        this.bitmapPool.put(((GlideBitmapDrawable) this.drawable).getBitmap());
    }
}