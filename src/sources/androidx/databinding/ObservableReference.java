package androidx.databinding;

import androidx.annotation.RestrictTo;
import androidx.lifecycle.LifecycleOwner;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
interface ObservableReference<T> {
    void addListener(T t2);

    WeakListener<T> getListener();

    void removeListener(T t2);

    void setLifecycleOwner(LifecycleOwner lifecycleOwner);
}
