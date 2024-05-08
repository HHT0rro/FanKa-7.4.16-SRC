package com.alimm.tanx.ui.image.glide.request.animation;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import com.alimm.tanx.ui.image.glide.request.animation.GlideAnimation;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class BitmapContainerCrossFadeFactory<T> implements GlideAnimationFactory<T> {
    public final GlideAnimationFactory<Drawable> realFactory;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class BitmapGlideAnimation implements GlideAnimation<T> {
        public final GlideAnimation<Drawable> transition;

        public BitmapGlideAnimation(GlideAnimation<Drawable> glideAnimation) {
            this.transition = glideAnimation;
        }

        @Override // com.alimm.tanx.ui.image.glide.request.animation.GlideAnimation
        public boolean animate(T t2, GlideAnimation.ViewAdapter viewAdapter) {
            return this.transition.animate(new BitmapDrawable(viewAdapter.getView().getResources(), BitmapContainerCrossFadeFactory.this.getBitmap(t2)), viewAdapter);
        }
    }

    public BitmapContainerCrossFadeFactory() {
        this.realFactory = new DrawableCrossFadeFactory();
    }

    @Override // com.alimm.tanx.ui.image.glide.request.animation.GlideAnimationFactory
    public GlideAnimation<T> build(boolean z10, boolean z11) {
        return new BitmapGlideAnimation(this.realFactory.build(z10, z11));
    }

    public abstract Bitmap getBitmap(T t2);

    public BitmapContainerCrossFadeFactory(int i10) {
        this.realFactory = new DrawableCrossFadeFactory(i10);
    }

    public BitmapContainerCrossFadeFactory(Context context, int i10, int i11) {
        this.realFactory = new DrawableCrossFadeFactory(context, i10, i11);
    }

    public BitmapContainerCrossFadeFactory(Animation animation, int i10) {
        this.realFactory = new DrawableCrossFadeFactory(animation, i10);
    }

    public BitmapContainerCrossFadeFactory(GlideAnimationFactory<Drawable> glideAnimationFactory) {
        this.realFactory = glideAnimationFactory;
    }
}
