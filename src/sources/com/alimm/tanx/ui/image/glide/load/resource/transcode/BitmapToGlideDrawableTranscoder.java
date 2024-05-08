package com.alimm.tanx.ui.image.glide.load.resource.transcode;

import android.content.Context;
import android.graphics.Bitmap;
import com.alimm.tanx.ui.image.glide.load.engine.Resource;
import com.alimm.tanx.ui.image.glide.load.resource.drawable.GlideDrawable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class BitmapToGlideDrawableTranscoder implements ResourceTranscoder<Bitmap, GlideDrawable> {
    public final GlideBitmapDrawableTranscoder glideBitmapDrawableTranscoder;

    public BitmapToGlideDrawableTranscoder(Context context) {
        this.glideBitmapDrawableTranscoder = new GlideBitmapDrawableTranscoder(context);
    }

    @Override // com.alimm.tanx.ui.image.glide.load.resource.transcode.ResourceTranscoder
    public String getId() {
        return this.glideBitmapDrawableTranscoder.getId();
    }

    @Override // com.alimm.tanx.ui.image.glide.load.resource.transcode.ResourceTranscoder
    public Resource<GlideDrawable> transcode(Resource<Bitmap> resource) {
        return this.glideBitmapDrawableTranscoder.transcode(resource);
    }

    public BitmapToGlideDrawableTranscoder(GlideBitmapDrawableTranscoder glideBitmapDrawableTranscoder) {
        this.glideBitmapDrawableTranscoder = glideBitmapDrawableTranscoder;
    }
}
