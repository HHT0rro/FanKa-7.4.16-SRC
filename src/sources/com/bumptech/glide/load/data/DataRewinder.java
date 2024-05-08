package com.bumptech.glide.load.data;

import androidx.annotation.NonNull;
import java.io.IOException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public interface DataRewinder<T> {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface Factory<T> {
        @NonNull
        DataRewinder<T> build(@NonNull T t2);

        @NonNull
        Class<T> getDataClass();
    }

    void cleanup();

    @NonNull
    T rewindAndGet() throws IOException;
}
