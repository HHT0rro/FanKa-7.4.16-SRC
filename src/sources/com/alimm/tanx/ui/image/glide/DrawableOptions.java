package com.alimm.tanx.ui.image.glide;

import android.view.animation.Animation;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface DrawableOptions {
    GenericRequestBuilder<?, ?, ?, ?> crossFade();

    GenericRequestBuilder<?, ?, ?, ?> crossFade(int i10);

    GenericRequestBuilder<?, ?, ?, ?> crossFade(int i10, int i11);

    @Deprecated
    GenericRequestBuilder<?, ?, ?, ?> crossFade(Animation animation, int i10);
}
