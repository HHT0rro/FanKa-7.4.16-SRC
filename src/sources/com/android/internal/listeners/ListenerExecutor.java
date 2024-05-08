package com.android.internal.listeners;

import java.util.concurrent.Executor;
import java.util.function.Supplier;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface ListenerExecutor {

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public interface FailureCallback<TListenerOperation extends ListenerOperation<?>> {
        void onFailure(TListenerOperation tlisteneroperation, Exception exc);
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public interface ListenerOperation<TListener> {
        void operate(TListener tlistener) throws Exception;

        default void onPreExecute() {
        }

        default void onFailure(Exception e2) {
        }

        default void onPostExecute(boolean success) {
        }

        default void onComplete(boolean success) {
        }
    }

    default <TListener> void executeSafely(Executor executor, Supplier<TListener> listenerSupplier, ListenerOperation<TListener> operation) {
        executeSafely(executor, listenerSupplier, operation, null);
    }

    default <TListener, TListenerOperation extends ListenerOperation<TListener>> void executeSafely(Executor executor, final Supplier<TListener> listenerSupplier, final TListenerOperation operation, final FailureCallback<TListenerOperation> failureCallback) {
        final TListener listener;
        if (operation == null || (listener = listenerSupplier.get()) == null) {
            return;
        }
        boolean executing = false;
        boolean preexecute = false;
        try {
            operation.onPreExecute();
            preexecute = true;
            executor.execute(new Runnable() { // from class: com.android.internal.listeners.ListenerExecutor$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    ListenerExecutor.lambda$executeSafely$0(Object.this, listenerSupplier, operation, failureCallback);
                }
            });
            executing = true;
        } finally {
            if (!executing) {
                if (preexecute) {
                    operation.onPostExecute(false);
                }
                operation.onComplete(false);
            }
        }
    }

    static /* synthetic */ void lambda$executeSafely$0(Object listener, Supplier listenerSupplier, ListenerOperation operation, FailureCallback failureCallback) {
        boolean success = false;
        try {
            try {
                if (listener == listenerSupplier.get()) {
                    operation.operate(listener);
                    success = true;
                }
            } catch (Exception e2) {
                if (e2 instanceof RuntimeException) {
                    throw ((RuntimeException) e2);
                }
                operation.onFailure(e2);
                if (failureCallback != null) {
                    failureCallback.onFailure(operation, e2);
                }
            }
        } finally {
            operation.onPostExecute(false);
            operation.onComplete(false);
        }
    }
}
