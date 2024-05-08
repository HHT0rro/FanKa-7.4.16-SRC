package io.grpc.internal;

import io.grpc.Context;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
abstract class ContextRunnable implements Runnable {
    private final Context context;

    public ContextRunnable(Context context) {
        this.context = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context attach = this.context.attach();
        try {
            runInContext();
        } finally {
            this.context.detach(attach);
        }
    }

    public abstract void runInContext();
}
