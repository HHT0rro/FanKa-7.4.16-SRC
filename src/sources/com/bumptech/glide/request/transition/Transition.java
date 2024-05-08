package com.bumptech.glide.request.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.Nullable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public interface Transition<R> {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface ViewAdapter {
        @Nullable
        Drawable getCurrentDrawable();

        View getView();

        void setDrawable(Drawable drawable);
    }

    boolean transition(R r10, ViewAdapter viewAdapter);
}
