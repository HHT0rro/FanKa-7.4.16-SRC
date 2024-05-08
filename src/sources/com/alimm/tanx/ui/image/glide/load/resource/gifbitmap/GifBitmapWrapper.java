package com.alimm.tanx.ui.image.glide.load.resource.gifbitmap;

import android.graphics.Bitmap;
import com.alimm.tanx.ui.image.glide.load.engine.Resource;
import com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class GifBitmapWrapper {
    public final Resource<Bitmap> bitmapResource;
    public final Resource<GifDrawable> gifResource;

    public GifBitmapWrapper(Resource<Bitmap> resource, Resource<GifDrawable> resource2) {
        if (resource != null && resource2 != null) {
            throw new IllegalArgumentException("Can only contain either a bitmap resource or a gif resource, not both");
        }
        if (resource == null && resource2 == null) {
            throw new IllegalArgumentException("Must contain either a bitmap resource or a gif resource");
        }
        this.bitmapResource = resource;
        this.gifResource = resource2;
    }

    public Resource<Bitmap> getBitmapResource() {
        return this.bitmapResource;
    }

    public Resource<GifDrawable> getGifResource() {
        return this.gifResource;
    }

    public int getSize() {
        Resource<Bitmap> resource = this.bitmapResource;
        if (resource != null) {
            return resource.getSize();
        }
        return this.gifResource.getSize();
    }
}
