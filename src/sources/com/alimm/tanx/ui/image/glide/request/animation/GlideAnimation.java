package com.alimm.tanx.ui.image.glide.request.animation;

import android.graphics.drawable.Drawable;
import android.view.View;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface GlideAnimation<R> {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface ViewAdapter {
        Drawable getCurrentDrawable();

        View getView();

        void setDrawable(Drawable drawable);
    }

    boolean animate(R r10, ViewAdapter viewAdapter);
}
