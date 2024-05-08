package java.util.concurrent;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class ExecutorCompletionService<V> implements CompletionService<V> {
    private final AbstractExecutorService aes;
    private final BlockingQueue<Future<V>> completionQueue;
    private final Executor executor;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class QueueingFuture<V> extends FutureTask<Void> {
        private final BlockingQueue<Future<V>> completionQueue;
        private final Future<V> task;

        QueueingFuture(RunnableFuture<V> task, BlockingQueue<Future<V>> completionQueue) {
            super(task, null);
            this.task = task;
            this.completionQueue = completionQueue;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.util.concurrent.FutureTask
        public void done() {
            this.completionQueue.add(this.task);
        }
    }

    private RunnableFuture<V> newTaskFor(Callable<V> task) {
        AbstractExecutorService abstractExecutorService = this.aes;
        if (abstractExecutorService == null) {
            return new FutureTask(task);
        }
        return abstractExecutorService.newTaskFor(task);
    }

    private RunnableFuture<V> newTaskFor(Runnable task, V result) {
        AbstractExecutorService abstractExecutorService = this.aes;
        if (abstractExecutorService == null) {
            return new FutureTask(task, result);
        }
        return abstractExecutorService.newTaskFor(task, result);
    }

    public ExecutorCompletionService(Executor executor) {
        if (executor == null) {
            throw new NullPointerException();
        }
        this.executor = executor;
        this.aes = executor instanceof AbstractExecutorService ? (AbstractExecutorService) executor : null;
        this.completionQueue = new LinkedBlockingQueue();
    }

    public ExecutorCompletionService(Executor executor, BlockingQueue<Future<V>> completionQueue) {
        if (executor == null || completionQueue == null) {
            throw new NullPointerException();
        }
        this.executor = executor;
        this.aes = executor instanceof AbstractExecutorService ? (AbstractExecutorService) executor : null;
        this.completionQueue = completionQueue;
    }

    @Override // java.util.concurrent.CompletionService
    public Future<V> submit(Callable<V> task) {
        if (task == null) {
            throw new NullPointerException();
        }
        RunnableFuture<V> f10 = newTaskFor(task);
        this.executor.execute(new QueueingFuture(f10, this.completionQueue));
        return f10;
    }

    @Override // java.util.concurrent.CompletionService
    public Future<V> submit(Runnable task, V result) {
        if (task == null) {
            throw new NullPointerException();
        }
        RunnableFuture<V> f10 = newTaskFor(task, result);
        this.executor.execute(new QueueingFuture(f10, this.completionQueue));
        return f10;
    }

    @Override // java.util.concurrent.CompletionService
    public Future<V> take() throws InterruptedException {
        return this.completionQueue.take();
    }

    @Override // java.util.concurrent.CompletionService
    public Future<V> poll() {
        return this.completionQueue.poll();
    }

    @Override // java.util.concurrent.CompletionService
    public Future<V> poll(long timeout, TimeUnit unit) throws InterruptedException {
        return this.completionQueue.poll(timeout, unit);
    }
}
