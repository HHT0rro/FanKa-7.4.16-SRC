package com.kwad.components.offline.api.core.api;

import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface IAsync {
    void execute(Runnable runnable);

    void runOnDefaultExecutor(Runnable runnable);

    void runOnUiThread(Runnable runnable);

    void runOnUiThreadDelay(Runnable runnable, long j10);

    void schedule(Runnable runnable, long j10, TimeUnit timeUnit);
}
