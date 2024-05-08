package com.alimm.tanx.ui.image.glide.request.target;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.alimm.tanx.ui.image.glide.load.resource.drawable.GlideDrawable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class ImageViewTargetFactory {
    public <Z> Target<Z> buildTarget(ImageView imageView, Class<Z> cls) {
        if (GlideDrawable.class.isAssignableFrom(cls)) {
            return new GlideDrawableImageViewTarget(imageView);
        }
        if (Bitmap.class.equals(cls)) {
            return new BitmapImageViewTarget(imageView);
        }
        if (Drawable.class.isAssignableFrom(cls)) {
            return new DrawableImageViewTarget(imageView);
        }
        throw new IllegalArgumentException("Unhandled class: " + ((Object) cls) + ", try .as*(Class).transcode(ResourceTranscoder)");
    }
}