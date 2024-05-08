package org.apache.commons.lang3.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class BackgroundInitializer<T> implements ConcurrentInitializer<T> {
    private ExecutorService executor;
    private ExecutorService externalExecutor;
    private Future<T> future;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class InitializationTask implements Callable<T> {
        private final ExecutorService execFinally;

        public InitializationTask(ExecutorService executorService) {
            this.execFinally = executorService;
        }

        @Override // java.util.concurrent.Callable
        public T call() throws Exception {
            try {
                return (T) BackgroundInitializer.this.initialize();
            } finally {
                ExecutorService executorService = this.execFinally;
                if (executorService != null) {
                    executorService.shutdown();
                }
            }
        }
    }

    public BackgroundInitializer() {
        this(null);
    }

    private ExecutorService createExecutor() {
        return Executors.newFixedThreadPool(getTaskCount());
    }

    private Callable<T> createTask(ExecutorService executorService) {
        return new InitializationTask(executorService);
    }

    @Override // org.apache.commons.lang3.concurrent.ConcurrentInitializer
    public T get() throws ConcurrentException {
        try {
            return getFuture().get();
        } catch (InterruptedException e2) {
            Thread.currentThread().interrupt();
            throw new ConcurrentException(e2);
        } catch (ExecutionException e10) {
            ConcurrentUtils.handleCause(e10);
            return null;
        }
    }

    public final synchronized ExecutorService getActiveExecutor() {
        return this.executor;
    }

    public final synchronized ExecutorService getExternalExecutor() {
        return this.externalExecutor;
    }

    public synchronized Future<T> getFuture() {
        Future<T> future;
        future = this.future;
        if (future == null) {
            throw new IllegalStateException("start() must be called first!");
        }
        return future;
    }

    public int getTaskCount() {
        return 1;
    }

    public abstract T initialize() throws Exception;

    public synchronized boolean isStarted() {
        return this.future != null;
    }

    public final synchronized void setExternalExecutor(ExecutorService executorService) {
        if (!isStarted()) {
            this.externalExecutor = executorService;
        } else {
            throw new IllegalStateException("Cannot set ExecutorService after start()!");
        }
    }

    public synchronized boolean start() {
        ExecutorService executorService;
        if (isStarted()) {
            return false;
        }
        ExecutorService externalExecutor = getExternalExecutor();
        this.executor = externalExecutor;
        if (externalExecutor == null) {
            executorService = createExecutor();
            this.executor = executorService;
        } else {
            executorService = null;
        }
        this.future = this.executor.submit(createTask(executorService));
        return true;
    }

    public BackgroundInitializer(ExecutorService executorService) {
        setExternalExecutor(executorService);
    }
}
