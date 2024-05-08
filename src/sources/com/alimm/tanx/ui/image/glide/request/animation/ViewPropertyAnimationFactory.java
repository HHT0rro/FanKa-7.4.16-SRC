package com.alimm.tanx.ui.image.glide.request.animation;

import com.alimm.tanx.ui.image.glide.request.animation.ViewPropertyAnimation;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class ViewPropertyAnimationFactory<R> implements GlideAnimationFactory<R> {
    public ViewPropertyAnimation<R> animation;
    public final ViewPropertyAnimation.Animator animator;

    public ViewPropertyAnimationFactory(ViewPropertyAnimation.Animator animator) {
        this.animator = animator;
    }

    @Override // com.alimm.tanx.ui.image.glide.request.animation.GlideAnimationFactory
    public GlideAnimation<R> build(boolean z10, boolean z11) {
        if (!z10 && z11) {
            if (this.animation == null) {
                this.animation = new ViewPropertyAnimation<>(this.animator);
            }
            return this.animation;
        }
        return NoAnimation.get();
    }
}
