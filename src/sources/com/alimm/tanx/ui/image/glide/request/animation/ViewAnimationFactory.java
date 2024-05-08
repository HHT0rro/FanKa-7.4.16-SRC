package com.alimm.tanx.ui.image.glide.request.animation;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.alimm.tanx.ui.image.glide.request.animation.ViewAnimation;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class ViewAnimationFactory<R> implements GlideAnimationFactory<R> {
    public final ViewAnimation.AnimationFactory animationFactory;
    public GlideAnimation<R> glideAnimation;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class ConcreteAnimationFactory implements ViewAnimation.AnimationFactory {
        public final Animation animation;

        public ConcreteAnimationFactory(Animation animation) {
            this.animation = animation;
        }

        @Override // com.alimm.tanx.ui.image.glide.request.animation.ViewAnimation.AnimationFactory
        public Animation build() {
            return this.animation;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class ResourceAnimationFactory implements ViewAnimation.AnimationFactory {
        public final int animationId;
        public final Context context;

        public ResourceAnimationFactory(Context context, int i10) {
            this.context = context.getApplicationContext();
            this.animationId = i10;
        }

        @Override // com.alimm.tanx.ui.image.glide.request.animation.ViewAnimation.AnimationFactory
        public Animation build() {
            return AnimationUtils.loadAnimation(this.context, this.animationId);
        }
    }

    public ViewAnimationFactory(Animation animation) {
        this.animationFactory = new ConcreteAnimationFactory(animation);
    }

    @Override // com.alimm.tanx.ui.image.glide.request.animation.GlideAnimationFactory
    public GlideAnimation<R> build(boolean z10, boolean z11) {
        if (!z10 && z11) {
            if (this.glideAnimation == null) {
                this.glideAnimation = new ViewAnimation(this.animationFactory);
            }
            return this.glideAnimation;
        }
        return NoAnimation.get();
    }

    public ViewAnimationFactory(Context context, int i10) {
        this.animationFactory = new ResourceAnimationFactory(context, i10);
    }

    public ViewAnimationFactory(ViewAnimation.AnimationFactory animationFactory) {
        this.animationFactory = animationFactory;
    }
}
