package com.alimm.tanx.ui.image.glide.request.animation;

import android.view.View;
import android.view.animation.Animation;
import com.alimm.tanx.ui.image.glide.request.animation.GlideAnimation;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class ViewAnimation<R> implements GlideAnimation<R> {
    public final AnimationFactory animationFactory;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface AnimationFactory {
        Animation build();
    }

    public ViewAnimation(AnimationFactory animationFactory) {
        this.animationFactory = animationFactory;
    }

    @Override // com.alimm.tanx.ui.image.glide.request.animation.GlideAnimation
    public boolean animate(R r10, GlideAnimation.ViewAdapter viewAdapter) {
        View view = viewAdapter.getView();
        if (view == null) {
            return false;
        }
        view.clearAnimation();
        view.startAnimation(this.animationFactory.build());
        return false;
    }
}
