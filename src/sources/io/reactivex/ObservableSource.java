package io.reactivex;

import io.reactivex.annotations.NonNull;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface ObservableSource<T> {
    void subscribe(@NonNull Observer<? super T> observer);
}
