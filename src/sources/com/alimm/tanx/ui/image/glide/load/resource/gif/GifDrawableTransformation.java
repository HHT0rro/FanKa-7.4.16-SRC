package com.alimm.tanx.ui.image.glide.load.resource.gif;

import android.graphics.Bitmap;
import com.alimm.tanx.ui.image.glide.load.Transformation;
import com.alimm.tanx.ui.image.glide.load.engine.Resource;
import com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool;
import com.alimm.tanx.ui.image.glide.load.resource.bitmap.BitmapResource;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class GifDrawableTransformation implements Transformation<GifDrawable> {
    public final BitmapPool bitmapPool;
    public final Transformation<Bitmap> wrapped;

    public GifDrawableTransformation(Transformation<Bitmap> transformation, BitmapPool bitmapPool) {
        this.wrapped = transformation;
        this.bitmapPool = bitmapPool;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.Transformation
    public String getId() {
        return this.wrapped.getId();
    }

    @Override // com.alimm.tanx.ui.image.glide.load.Transformation
    public Resource<GifDrawable> transform(Resource<GifDrawable> resource, int i10, int i11) {
        GifDrawable gifDrawable = resource.get();
        Bitmap firstFrame = resource.get().getFirstFrame();
        Bitmap bitmap = this.wrapped.transform(new BitmapResource(firstFrame, this.bitmapPool), i10, i11).get();
        return !bitmap.equals(firstFrame) ? new GifDrawableResource(new GifDrawable(gifDrawable, bitmap, this.wrapped)) : resource;
    }
}
