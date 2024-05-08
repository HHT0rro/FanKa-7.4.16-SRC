package androidx.lifecycle;

import androidx.annotation.MainThread;
import androidx.lifecycle.Lifecycle;
import kotlin.jvm.internal.s;
import kotlinx.coroutines.n1;
import org.jetbrains.annotations.NotNull;

/* compiled from: LifecycleController.kt */
@MainThread
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class LifecycleController {

    @NotNull
    private final DispatchQueue dispatchQueue;

    @NotNull
    private final Lifecycle lifecycle;

    @NotNull
    private final Lifecycle.State minState;

    @NotNull
    private final LifecycleEventObserver observer;

    public LifecycleController(@NotNull Lifecycle lifecycle, @NotNull Lifecycle.State minState, @NotNull DispatchQueue dispatchQueue, @NotNull final n1 parentJob) {
        s.i(lifecycle, "lifecycle");
        s.i(minState, "minState");
        s.i(dispatchQueue, "dispatchQueue");
        s.i(parentJob, "parentJob");
        this.lifecycle = lifecycle;
        this.minState = minState;
        this.dispatchQueue = dispatchQueue;
        LifecycleEventObserver lifecycleEventObserver = new LifecycleEventObserver() { // from class: androidx.lifecycle.g
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                LifecycleController.observer$lambda$0(LifecycleController.this, parentJob, lifecycleOwner, event);
            }
        };
        this.observer = lifecycleEventObserver;
        if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
            n1.a.a(parentJob, null, 1, null);
            finish();
        } else {
            lifecycle.addObserver(lifecycleEventObserver);
        }
    }

    private final void handleDestroy(n1 n1Var) {
        n1.a.a(n1Var, null, 1, null);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void observer$lambda$0(LifecycleController this$0, n1 parentJob, LifecycleOwner source, Lifecycle.Event event) {
        s.i(this$0, "this$0");
        s.i(parentJob, "$parentJob");
        s.i(source, "source");
        s.i(event, "<anonymous parameter 1>");
        if (source.getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) {
            n1.a.a(parentJob, null, 1, null);
            this$0.finish();
        } else if (source.getLifecycle().getCurrentState().compareTo(this$0.minState) < 0) {
            this$0.dispatchQueue.pause();
        } else {
            this$0.dispatchQueue.resume();
        }
    }

    @MainThread
    public final void finish() {
        this.lifecycle.removeObserver(this.observer);
        this.dispatchQueue.finish();
    }
}
