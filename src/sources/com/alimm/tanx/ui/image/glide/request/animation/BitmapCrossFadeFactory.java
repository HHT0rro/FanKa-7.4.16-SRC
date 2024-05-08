package com.alimm.tanx.ui.image.glide.request.animation;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.animation.Animation;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class BitmapCrossFadeFactory extends BitmapContainerCrossFadeFactory<Bitmap> {
    public BitmapCrossFadeFactory() {
    }

    @Override // com.alimm.tanx.ui.image.glide.request.animation.BitmapContainerCrossFadeFactory
    public Bitmap getBitmap(Bitmap bitmap) {
        return bitmap;
    }

    public BitmapCrossFadeFactory(int i10) {
        super(i10);
    }

    public BitmapCrossFadeFactory(Context context, int i10, int i11) {
        super(context, i10, i11);
    }

    public BitmapCrossFadeFactory(Animation animation, int i10) {
        super(animation, i10);
    }

    public BitmapCrossFadeFactory(GlideAnimationFactory<Drawable> glideAnimationFactory) {
        super(glideAnimationFactory);
    }
}
