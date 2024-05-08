package com.alimm.tanx.ui.image.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class FitCenter extends BitmapTransformation {
    public FitCenter(Context context) {
        super(context);
    }

    @Override // com.alimm.tanx.ui.image.glide.load.Transformation
    public String getId() {
        return "FitCenter.com.alimm.tanx.ui.image.glide.load.resource.bitmap";
    }

    @Override // com.alimm.tanx.ui.image.glide.load.resource.bitmap.BitmapTransformation
    public Bitmap transform(BitmapPool bitmapPool, Bitmap bitmap, int i10, int i11) {
        return TransformationUtils.fitCenter(bitmap, bitmapPool, i10, i11);
    }

    public FitCenter(BitmapPool bitmapPool) {
        super(bitmapPool);
    }
}
