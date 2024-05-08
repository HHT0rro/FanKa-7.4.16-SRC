package com.alimm.tanx.ui.image.glide.load.resource.transcode;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import com.alimm.tanx.ui.image.glide.Glide;
import com.alimm.tanx.ui.image.glide.load.engine.Resource;
import com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool;
import com.alimm.tanx.ui.image.glide.load.resource.bitmap.GlideBitmapDrawable;
import com.alimm.tanx.ui.image.glide.load.resource.bitmap.GlideBitmapDrawableResource;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class GlideBitmapDrawableTranscoder implements ResourceTranscoder<Bitmap, GlideBitmapDrawable> {
    public final BitmapPool bitmapPool;
    public final Resources resources;

    public GlideBitmapDrawableTranscoder(Context context) {
        this(context.getResources(), Glide.get(context).getBitmapPool());
    }

    @Override // com.alimm.tanx.ui.image.glide.load.resource.transcode.ResourceTranscoder
    public String getId() {
        return "GlideBitmapDrawableTranscoder.com.alimm.tanx.ui.image.glide.load.resource.transcode";
    }

    @Override // com.alimm.tanx.ui.image.glide.load.resource.transcode.ResourceTranscoder
    public Resource<GlideBitmapDrawable> transcode(Resource<Bitmap> resource) {
        return new GlideBitmapDrawableResource(new GlideBitmapDrawable(this.resources, resource.get()), this.bitmapPool);
    }

    public GlideBitmapDrawableTranscoder(Resources resources, BitmapPool bitmapPool) {
        this.resources = resources;
        this.bitmapPool = bitmapPool;
    }
}
