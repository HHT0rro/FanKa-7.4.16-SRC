package com.alimm.tanx.ui.image.glide.request.target;

import com.alimm.tanx.ui.image.glide.Glide;
import com.alimm.tanx.ui.image.glide.request.animation.GlideAnimation;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class PreloadTarget<Z> extends SimpleTarget<Z> {
    public PreloadTarget(int i10, int i11) {
        super(i10, i11);
    }

    public static <Z> PreloadTarget<Z> obtain(int i10, int i11) {
        return new PreloadTarget<>(i10, i11);
    }

    @Override // com.alimm.tanx.ui.image.glide.request.target.Target
    public void onResourceReady(Z z10, GlideAnimation<? super Z> glideAnimation) {
        Glide.clear(this);
    }
}
