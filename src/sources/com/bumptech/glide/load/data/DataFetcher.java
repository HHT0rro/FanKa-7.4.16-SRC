package com.bumptech.glide.load.data;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public interface DataFetcher<T> {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface DataCallback<T> {
        void onDataReady(@Nullable T t2);

        void onLoadFailed(@NonNull Exception exc);
    }

    void cancel();

    void cleanup();

    @NonNull
    Class<T> getDataClass();

    @NonNull
    DataSource getDataSource();

    void loadData(@NonNull Priority priority, @NonNull DataCallback<? super T> dataCallback);
}
