package com.alimm.tanx.ui.image.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class CenterCrop extends BitmapTransformation {
    public CenterCrop(Context context) {
        super(context);
    }

    @Override // com.alimm.tanx.ui.image.glide.load.Transformation
    public String getId() {
        return "CenterCrop.com.alimm.tanx.ui.image.glide.load.resource.bitmap";
    }

    @Override // com.alimm.tanx.ui.image.glide.load.resource.bitmap.BitmapTransformation
    public Bitmap transform(BitmapPool bitmapPool, Bitmap bitmap, int i10, int i11) {
        Bitmap bitmap2 = bitmapPool.get(i10, i11, bitmap.getConfig() != null ? bitmap.getConfig() : Bitmap.Config.ARGB_8888);
        Bitmap centerCrop = TransformationUtils.centerCrop(bitmap2, bitmap, i10, i11);
        if (bitmap2 != null && bitmap2 != centerCrop && !bitmapPool.put(bitmap2)) {
            bitmap2.recycle();
        }
        return centerCrop;
    }

    public CenterCrop(BitmapPool bitmapPool) {
        super(bitmapPool);
    }
}
