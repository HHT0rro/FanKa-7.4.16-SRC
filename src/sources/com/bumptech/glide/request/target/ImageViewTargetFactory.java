package com.bumptech.glide.request.target;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.annotation.NonNull;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class ImageViewTargetFactory {
    @NonNull
    public <Z> ViewTarget<ImageView, Z> buildTarget(@NonNull ImageView imageView, @NonNull Class<Z> cls) {
        if (Bitmap.class.equals(cls)) {
            return new BitmapImageViewTarget(imageView);
        }
        if (Drawable.class.isAssignableFrom(cls)) {
            return new DrawableImageViewTarget(imageView);
        }
        throw new IllegalArgumentException("Unhandled class: " + ((Object) cls) + ", try .as*(Class).transcode(ResourceTranscoder)");
    }
}