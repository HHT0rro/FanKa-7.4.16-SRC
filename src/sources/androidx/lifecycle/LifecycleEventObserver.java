package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import org.jetbrains.annotations.NotNull;

/* compiled from: LifecycleEventObserver.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface LifecycleEventObserver extends LifecycleObserver {
    void onStateChanged(@NotNull LifecycleOwner lifecycleOwner, @NotNull Lifecycle.Event event);
}
