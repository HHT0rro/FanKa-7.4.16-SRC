package com.alimm.tanx.ui.image.glide.load.model;

import android.content.Context;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface ModelLoaderFactory<T, Y> {
    ModelLoader<T, Y> build(Context context, GenericLoaderFactory genericLoaderFactory);

    void teardown();
}
