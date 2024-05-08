package com.alimm.tanx.ui.image.glide.request.target;

import android.graphics.Bitmap;
import android.widget.ImageView;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class BitmapImageViewTarget extends ImageViewTarget<Bitmap> {
    public BitmapImageViewTarget(ImageView imageView) {
        super(imageView);
    }

    @Override // com.alimm.tanx.ui.image.glide.request.target.ImageViewTarget
    public void setResource(Bitmap bitmap) {
        ((ImageView) this.view).setImageBitmap(bitmap);
    }
}
