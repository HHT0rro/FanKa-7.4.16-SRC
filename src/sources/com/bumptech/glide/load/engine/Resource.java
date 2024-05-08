package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public interface Resource<Z> {
    @NonNull
    Z get();

    @NonNull
    Class<Z> getResourceClass();

    int getSize();

    void recycle();
}
