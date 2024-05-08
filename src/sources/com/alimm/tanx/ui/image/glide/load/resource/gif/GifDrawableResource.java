package com.alimm.tanx.ui.image.glide.load.resource.gif;

import com.alimm.tanx.ui.image.glide.load.resource.drawable.DrawableResource;
import com.alimm.tanx.ui.image.glide.util.Util;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class GifDrawableResource extends DrawableResource<GifDrawable> {
    public GifDrawableResource(GifDrawable gifDrawable) {
        super(gifDrawable);
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.Resource
    public int getSize() {
        return Util.getBitmapByteSize(((GifDrawable) this.drawable).getFirstFrame()) + ((GifDrawable) this.drawable).getData().length;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.Resource
    public void recycle() {
        ((GifDrawable) this.drawable).stop();
        ((GifDrawable) this.drawable).recycle();
    }
}
