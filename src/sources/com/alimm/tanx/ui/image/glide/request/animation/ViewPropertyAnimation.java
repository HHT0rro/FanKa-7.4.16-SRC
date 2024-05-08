package com.alimm.tanx.ui.image.glide.request.animation;

import android.view.View;
import com.alimm.tanx.ui.image.glide.request.animation.GlideAnimation;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class ViewPropertyAnimation<R> implements GlideAnimation<R> {
    public final Animator animator;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface Animator {
        void animate(View view);
    }

    public ViewPropertyAnimation(Animator animator) {
        this.animator = animator;
    }

    @Override // com.alimm.tanx.ui.image.glide.request.animation.GlideAnimation
    public boolean animate(R r10, GlideAnimation.ViewAdapter viewAdapter) {
        if (viewAdapter.getView() == null) {
            return false;
        }
        this.animator.animate(viewAdapter.getView());
        return false;
    }
}
