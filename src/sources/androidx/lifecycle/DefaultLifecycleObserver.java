package androidx.lifecycle;

import org.jetbrains.annotations.NotNull;

/* compiled from: DefaultLifecycleObserver.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface DefaultLifecycleObserver extends LifecycleObserver {
    void onCreate(@NotNull LifecycleOwner lifecycleOwner);

    void onDestroy(@NotNull LifecycleOwner lifecycleOwner);

    void onPause(@NotNull LifecycleOwner lifecycleOwner);

    void onResume(@NotNull LifecycleOwner lifecycleOwner);

    void onStart(@NotNull LifecycleOwner lifecycleOwner);

    void onStop(@NotNull LifecycleOwner lifecycleOwner);
}
