package com.alimm.tanx.ui.image.glide.load.resource.gifbitmap;

import android.graphics.Bitmap;
import com.alimm.tanx.ui.image.glide.load.Transformation;
import com.alimm.tanx.ui.image.glide.load.engine.Resource;
import com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool;
import com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawable;
import com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawableTransformation;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class GifBitmapWrapperTransformation implements Transformation<GifBitmapWrapper> {
    public final Transformation<Bitmap> bitmapTransformation;
    public final Transformation<GifDrawable> gifDataTransformation;

    public GifBitmapWrapperTransformation(BitmapPool bitmapPool, Transformation<Bitmap> transformation) {
        GifDrawableTransformation gifDrawableTransformation = new GifDrawableTransformation(transformation, bitmapPool);
        this.bitmapTransformation = transformation;
        this.gifDataTransformation = gifDrawableTransformation;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.Transformation
    public String getId() {
        return this.bitmapTransformation.getId();
    }

    @Override // com.alimm.tanx.ui.image.glide.load.Transformation
    public Resource<GifBitmapWrapper> transform(Resource<GifBitmapWrapper> resource, int i10, int i11) {
        Transformation<GifDrawable> transformation;
        Transformation<Bitmap> transformation2;
        Resource<Bitmap> bitmapResource = resource.get().getBitmapResource();
        Resource<GifDrawable> gifResource = resource.get().getGifResource();
        if (bitmapResource != null && (transformation2 = this.bitmapTransformation) != null) {
            Resource<Bitmap> transform = transformation2.transform(bitmapResource, i10, i11);
            return !bitmapResource.equals(transform) ? new GifBitmapWrapperResource(new GifBitmapWrapper(transform, resource.get().getGifResource())) : resource;
        }
        if (gifResource == null || (transformation = this.gifDataTransformation) == null) {
            return resource;
        }
        Resource<GifDrawable> transform2 = transformation.transform(gifResource, i10, i11);
        return !gifResource.equals(transform2) ? new GifBitmapWrapperResource(new GifBitmapWrapper(resource.get().getBitmapResource(), transform2)) : resource;
    }

    public GifBitmapWrapperTransformation(Transformation<Bitmap> transformation, Transformation<GifDrawable> transformation2) {
        this.bitmapTransformation = transformation;
        this.gifDataTransformation = transformation2;
    }
}
