package androidx.window.java.layout;

import android.app.Activity;
import androidx.core.util.Consumer;
import androidx.window.layout.WindowInfoTracker;
import androidx.window.layout.WindowLayoutInfo;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.d;
import kotlin.jvm.internal.s;
import kotlin.p;
import kotlinx.coroutines.e1;
import kotlinx.coroutines.flow.c;
import kotlinx.coroutines.h;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.n1;
import org.jetbrains.annotations.NotNull;

/* compiled from: WindowInfoTrackerCallbackAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class WindowInfoTrackerCallbackAdapter implements WindowInfoTracker {

    @NotNull
    private final Map<Consumer<?>, n1> consumerToJobMap;

    @NotNull
    private final ReentrantLock lock;

    @NotNull
    private final WindowInfoTracker tracker;

    public WindowInfoTrackerCallbackAdapter(@NotNull WindowInfoTracker tracker) {
        s.i(tracker, "tracker");
        this.tracker = tracker;
        this.lock = new ReentrantLock();
        this.consumerToJobMap = new LinkedHashMap();
    }

    private final <T> void addListener(Executor executor, Consumer<T> consumer, c<? extends T> cVar) {
        n1 b4;
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (this.consumerToJobMap.get(consumer) == null) {
                h0 a10 = i0.a(e1.a(executor));
                Map<Consumer<?>, n1> map = this.consumerToJobMap;
                b4 = h.b(a10, null, null, new WindowInfoTrackerCallbackAdapter$addListener$1$1(cVar, consumer, null), 3, null);
                map.put(consumer, b4);
            }
            p pVar = p.f51048a;
        } finally {
            reentrantLock.unlock();
        }
    }

    private final void removeListener(Consumer<?> consumer) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            n1 n1Var = this.consumerToJobMap.get(consumer);
            if (n1Var != null) {
                n1.a.a(n1Var, null, 1, null);
            }
            this.consumerToJobMap.remove(consumer);
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void addWindowLayoutInfoListener(@NotNull Activity activity, @NotNull Executor executor, @NotNull Consumer<WindowLayoutInfo> consumer) {
        s.i(activity, "activity");
        s.i(executor, "executor");
        s.i(consumer, "consumer");
        addListener(executor, consumer, this.tracker.windowLayoutInfo(activity));
    }

    public final void removeWindowLayoutInfoListener(@NotNull Consumer<WindowLayoutInfo> consumer) {
        s.i(consumer, "consumer");
        removeListener(consumer);
    }

    @Override // androidx.window.layout.WindowInfoTracker
    @NotNull
    public c<WindowLayoutInfo> windowLayoutInfo(@NotNull Activity activity) {
        s.i(activity, "activity");
        return this.tracker.windowLayoutInfo(activity);
    }
}
