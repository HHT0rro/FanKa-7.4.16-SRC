package androidx.lifecycle;

import androidx.annotation.MainThread;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;

/* compiled from: LiveData.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class LiveDataKt {
    @MainThread
    @NotNull
    public static final <T> Observer<T> observe(@NotNull LiveData<T> liveData, @NotNull LifecycleOwner owner, @NotNull final Function1<? super T, p> onChanged) {
        s.i(liveData, "<this>");
        s.i(owner, "owner");
        s.i(onChanged, "onChanged");
        Observer<T> observer = new Observer() { // from class: androidx.lifecycle.LiveDataKt$observe$wrappedObserver$1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t2) {
                onChanged.invoke(t2);
            }
        };
        liveData.observe(owner, observer);
        return observer;
    }
}
