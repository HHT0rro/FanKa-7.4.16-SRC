package com.alimm.tanx.ui.image.glide.request.animation;

import com.alimm.tanx.ui.image.glide.request.animation.GlideAnimation;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class NoAnimation<R> implements GlideAnimation<R> {
    public static final NoAnimation<?> NO_ANIMATION = new NoAnimation<>();
    public static final GlideAnimationFactory<?> NO_ANIMATION_FACTORY = new NoAnimationFactory();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class NoAnimationFactory<R> implements GlideAnimationFactory<R> {
        @Override // com.alimm.tanx.ui.image.glide.request.animation.GlideAnimationFactory
        public GlideAnimation<R> build(boolean z10, boolean z11) {
            return NoAnimation.NO_ANIMATION;
        }
    }

    public static <R> GlideAnimation<R> get() {
        return NO_ANIMATION;
    }

    public static <R> GlideAnimationFactory<R> getFactory() {
        return (GlideAnimationFactory<R>) NO_ANIMATION_FACTORY;
    }

    @Override // com.alimm.tanx.ui.image.glide.request.animation.GlideAnimation
    public boolean animate(Object obj, GlideAnimation.ViewAdapter viewAdapter) {
        return false;
    }
}
