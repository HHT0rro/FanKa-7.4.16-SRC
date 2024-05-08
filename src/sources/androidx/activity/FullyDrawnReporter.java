package androidx.activity;

import androidx.annotation.GuardedBy;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;

/* compiled from: FullyDrawnReporter.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class FullyDrawnReporter {

    @NotNull
    private final Executor executor;

    @NotNull
    private final Object lock;

    @GuardedBy("lock")
    @NotNull
    private final List<Function0<p>> onReportCallbacks;

    @NotNull
    private final Function0<p> reportFullyDrawn;

    @GuardedBy("lock")
    private boolean reportPosted;

    @NotNull
    private final Runnable reportRunnable;

    @GuardedBy("lock")
    private boolean reportedFullyDrawn;

    @GuardedBy("lock")
    private int reporterCount;

    public FullyDrawnReporter(@NotNull Executor executor, @NotNull Function0<p> reportFullyDrawn) {
        s.i(executor, "executor");
        s.i(reportFullyDrawn, "reportFullyDrawn");
        this.executor = executor;
        this.reportFullyDrawn = reportFullyDrawn;
        this.lock = new Object();
        this.onReportCallbacks = new ArrayList();
        this.reportRunnable = new Runnable() { // from class: androidx.activity.g
            @Override // java.lang.Runnable
            public final void run() {
                FullyDrawnReporter.reportRunnable$lambda$2(FullyDrawnReporter.this);
            }
        };
    }

    private final void postWhenReportersAreDone() {
        if (this.reportPosted || this.reporterCount != 0) {
            return;
        }
        this.reportPosted = true;
        this.executor.execute(this.reportRunnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void reportRunnable$lambda$2(FullyDrawnReporter this$0) {
        s.i(this$0, "this$0");
        synchronized (this$0.lock) {
            this$0.reportPosted = false;
            if (this$0.reporterCount == 0 && !this$0.reportedFullyDrawn) {
                this$0.reportFullyDrawn.invoke();
                this$0.fullyDrawnReported();
            }
            p pVar = p.f51048a;
        }
    }

    public final void addOnReportDrawnListener(@NotNull Function0<p> callback) {
        boolean z10;
        s.i(callback, "callback");
        synchronized (this.lock) {
            if (this.reportedFullyDrawn) {
                z10 = true;
            } else {
                this.onReportCallbacks.add(callback);
                z10 = false;
            }
        }
        if (z10) {
            callback.invoke();
        }
    }

    public final void addReporter() {
        synchronized (this.lock) {
            if (!this.reportedFullyDrawn) {
                this.reporterCount++;
            }
            p pVar = p.f51048a;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void fullyDrawnReported() {
        synchronized (this.lock) {
            this.reportedFullyDrawn = true;
            Iterator<Function0<p>> iterator2 = this.onReportCallbacks.iterator2();
            while (iterator2.hasNext()) {
                iterator2.next().invoke();
            }
            this.onReportCallbacks.clear();
            p pVar = p.f51048a;
        }
    }

    public final boolean isFullyDrawnReported() {
        boolean z10;
        synchronized (this.lock) {
            z10 = this.reportedFullyDrawn;
        }
        return z10;
    }

    public final void removeOnReportDrawnListener(@NotNull Function0<p> callback) {
        s.i(callback, "callback");
        synchronized (this.lock) {
            this.onReportCallbacks.remove(callback);
            p pVar = p.f51048a;
        }
    }

    public final void removeReporter() {
        int i10;
        synchronized (this.lock) {
            if (!this.reportedFullyDrawn && (i10 = this.reporterCount) > 0) {
                this.reporterCount = i10 - 1;
                postWhenReportersAreDone();
            }
            p pVar = p.f51048a;
        }
    }
}
