package com.alimm.tanx.ui.image.glide.load.resource.gifbitmap;

import android.graphics.Bitmap;
import com.alimm.tanx.ui.image.glide.load.ResourceEncoder;
import com.alimm.tanx.ui.image.glide.load.engine.Resource;
import com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawable;
import java.io.OutputStream;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class GifBitmapWrapperResourceEncoder implements ResourceEncoder<GifBitmapWrapper> {
    public final ResourceEncoder<Bitmap> bitmapEncoder;
    public final ResourceEncoder<GifDrawable> gifEncoder;

    /* renamed from: id, reason: collision with root package name */
    public String f4198id;

    public GifBitmapWrapperResourceEncoder(ResourceEncoder<Bitmap> resourceEncoder, ResourceEncoder<GifDrawable> resourceEncoder2) {
        this.bitmapEncoder = resourceEncoder;
        this.gifEncoder = resourceEncoder2;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.Encoder
    public String getId() {
        if (this.f4198id == null) {
            this.f4198id = this.bitmapEncoder.getId() + this.gifEncoder.getId();
        }
        return this.f4198id;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.Encoder
    public boolean encode(Resource<GifBitmapWrapper> resource, OutputStream outputStream) {
        GifBitmapWrapper gifBitmapWrapper = resource.get();
        Resource<Bitmap> bitmapResource = gifBitmapWrapper.getBitmapResource();
        if (bitmapResource != null) {
            return this.bitmapEncoder.encode(bitmapResource, outputStream);
        }
        return this.gifEncoder.encode(gifBitmapWrapper.getGifResource(), outputStream);
    }
}
