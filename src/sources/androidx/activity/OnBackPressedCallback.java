package androidx.activity;

import androidx.annotation.MainThread;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: OnBackPressedCallback.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class OnBackPressedCallback {

    @NotNull
    private final CopyOnWriteArrayList<Cancellable> cancellables = new CopyOnWriteArrayList<>();

    @Nullable
    private Function0<p> enabledChangedCallback;
    private boolean isEnabled;

    public OnBackPressedCallback(boolean z10) {
        this.isEnabled = z10;
    }

    public final void addCancellable(@NotNull Cancellable cancellable) {
        s.i(cancellable, "cancellable");
        this.cancellables.add(cancellable);
    }

    @Nullable
    public final Function0<p> getEnabledChangedCallback$activity_release() {
        return this.enabledChangedCallback;
    }

    @MainThread
    public abstract void handleOnBackPressed();

    @MainThread
    public final boolean isEnabled() {
        return this.isEnabled;
    }

    @MainThread
    public final void remove() {
        Iterator<Cancellable> iterator2 = this.cancellables.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().cancel();
        }
    }

    public final void removeCancellable(@NotNull Cancellable cancellable) {
        s.i(cancellable, "cancellable");
        this.cancellables.remove(cancellable);
    }

    @MainThread
    public final void setEnabled(boolean z10) {
        this.isEnabled = z10;
        Function0<p> function0 = this.enabledChangedCallback;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public final void setEnabledChangedCallback$activity_release(@Nullable Function0<p> function0) {
        this.enabledChangedCallback = function0;
    }
}
