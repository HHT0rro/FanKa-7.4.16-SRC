package com.bumptech.glide.request.transition;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class BitmapTransitionFactory extends BitmapContainerTransitionFactory<Bitmap> {
    public BitmapTransitionFactory(@NonNull TransitionFactory<Drawable> transitionFactory) {
        super(transitionFactory);
    }

    @Override // com.bumptech.glide.request.transition.BitmapContainerTransitionFactory
    @NonNull
    public Bitmap getBitmap(@NonNull Bitmap bitmap) {
        return bitmap;
    }
}
