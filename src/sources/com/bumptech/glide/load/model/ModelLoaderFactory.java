package com.bumptech.glide.load.model;

import androidx.annotation.NonNull;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public interface ModelLoaderFactory<T, Y> {
    @NonNull
    ModelLoader<T, Y> build(@NonNull MultiModelLoaderFactory multiModelLoaderFactory);

    void teardown();
}
