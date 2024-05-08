package com.alimm.tanx.ui.image.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import com.alimm.tanx.ui.image.glide.Glide;
import com.alimm.tanx.ui.image.glide.load.Transformation;
import com.alimm.tanx.ui.image.glide.load.engine.Resource;
import com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool;
import com.alimm.tanx.ui.image.glide.util.Util;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class BitmapTransformation implements Transformation<Bitmap> {
    public BitmapPool bitmapPool;

    public BitmapTransformation(Context context) {
        this(Glide.get(context).getBitmapPool());
    }

    public abstract Bitmap transform(BitmapPool bitmapPool, Bitmap bitmap, int i10, int i11);

    @Override // com.alimm.tanx.ui.image.glide.load.Transformation
    public final Resource<Bitmap> transform(Resource<Bitmap> resource, int i10, int i11) {
        if (Util.isValidDimensions(i10, i11)) {
            Bitmap bitmap = resource.get();
            if (i10 == Integer.MIN_VALUE) {
                i10 = bitmap.getWidth();
            }
            if (i11 == Integer.MIN_VALUE) {
                i11 = bitmap.getHeight();
            }
            Bitmap transform = transform(this.bitmapPool, bitmap, i10, i11);
            return bitmap.equals(transform) ? resource : BitmapResource.obtain(transform, this.bitmapPool);
        }
        throw new IllegalArgumentException("Cannot apply transformation on width: " + i10 + " or height: " + i11 + " less than or equal to zero and not Target.SIZE_ORIGINAL");
    }

    public BitmapTransformation(BitmapPool bitmapPool) {
        this.bitmapPool = bitmapPool;
    }
}
