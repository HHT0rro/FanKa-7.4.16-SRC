package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: SavedStateHandleSupport.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class SavedStateHandleAttacher implements LifecycleEventObserver {

    @NotNull
    private final SavedStateHandlesProvider provider;

    public SavedStateHandleAttacher(@NotNull SavedStateHandlesProvider provider) {
        s.i(provider, "provider");
        this.provider = provider;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(@NotNull LifecycleOwner source, @NotNull Lifecycle.Event event) {
        s.i(source, "source");
        s.i(event, "event");
        if (event == Lifecycle.Event.ON_CREATE) {
            source.getLifecycle().removeObserver(this);
            this.provider.performRestore();
        } else {
            throw new IllegalStateException(("Next event must be ON_CREATE, it was " + ((Object) event)).toString());
        }
    }
}
