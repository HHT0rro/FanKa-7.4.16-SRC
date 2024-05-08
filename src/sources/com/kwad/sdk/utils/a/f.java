package com.kwad.sdk.utils.a;

import java.util.concurrent.Executor;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class f implements Executor {
    private Runnable aSc;
    private Runnable aSd;

    private Runnable d(final Runnable runnable) {
        return new Runnable() { // from class: com.kwad.sdk.utils.a.f.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    runnable.run();
                } finally {
                    f.this.scheduleNext();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void scheduleNext() {
        Runnable runnable = this.aSd;
        this.aSc = runnable;
        this.aSd = null;
        if (runnable != null) {
            d.getExecutor().execute(this.aSc);
        }
    }

    @Override // java.util.concurrent.Executor
    public final synchronized void execute(Runnable runnable) {
        if (this.aSc == null) {
            this.aSc = d(runnable);
            d.getExecutor().execute(this.aSc);
        } else {
            if (this.aSd == null) {
                this.aSd = d(runnable);
            }
        }
    }
}
