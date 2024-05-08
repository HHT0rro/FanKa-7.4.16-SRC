package com.huawei.hmf.taskstream.impl;

import com.huawei.hmf.tasks.TaskExecutors;
import com.huawei.hmf.taskstream.Consumer;
import com.huawei.hmf.taskstream.Disposable;
import com.huawei.hmf.taskstream.ExecuteResult;
import com.huawei.hmf.taskstream.Observer;
import com.huawei.hmf.taskstream.TaskStream;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Executor;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class TaskStreamImpl<TResult> implements TaskStream<TResult> {
    private boolean complete;
    private boolean mDispose;
    private Executor mExecutor;
    private TaskStreamImpl<TResult>.LambdaDisposable mLambdaDisposable;
    private Observer mObserver;
    private final Object lock = new Object();
    private Deque<ExecuteResult> continuations = new ArrayDeque();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class LambdaDisposable implements Disposable {
        private Disposable mDisposable;

        public LambdaDisposable() {
        }

        @Override // com.huawei.hmf.taskstream.Disposable
        public void dispose() {
            TaskStreamImpl.this.dispose();
            synchronized (TaskStreamImpl.this.lock) {
                Disposable disposable = this.mDisposable;
                if (disposable != null) {
                    disposable.dispose();
                }
            }
        }

        public void setDisposable(Disposable disposable) {
            synchronized (TaskStreamImpl.this.lock) {
                this.mDisposable = disposable;
            }
        }
    }

    private void continueWithTask(Observer observer, Executor executor) {
        synchronized (this.lock) {
            Observer observer2 = this.mObserver;
            if (observer2 != null) {
                if (observer != observer2) {
                    throw new IllegalStateException("An observer has already been subscribed on this TaskStream");
                }
            } else {
                this.mObserver = observer;
                this.mExecutor = executor;
                this.lock.notifyAll();
                runContinuations();
            }
        }
    }

    private void deliverTask(final TaskStreamImpl taskStreamImpl, final ExecuteResult executeResult, Executor executor) {
        executor.execute(new Runnable() { // from class: com.huawei.hmf.taskstream.impl.TaskStreamImpl.1
            @Override // java.lang.Runnable
            public void run() {
                executeResult.onComplete(taskStreamImpl.getObserver());
            }
        });
    }

    private void runContinuations() {
        synchronized (this.lock) {
            if (this.mObserver == null) {
                return;
            }
            while (true) {
                ExecuteResult poll = this.continuations.poll();
                if (poll == null) {
                    return;
                }
                try {
                    try {
                        deliverTask(this, poll, this.mExecutor);
                    } catch (RuntimeException e2) {
                        throw e2;
                    }
                } catch (Exception e10) {
                    throw new RuntimeException(e10);
                }
            }
        }
    }

    public void dispose() {
        synchronized (this.lock) {
            if (!this.mDispose) {
                this.complete = true;
                this.mDispose = true;
                this.continuations.clear();
                this.mObserver = null;
                this.mExecutor = null;
                this.lock.notifyAll();
            }
        }
    }

    public Observer getObserver() {
        Observer observer;
        synchronized (this.lock) {
            observer = this.mObserver;
        }
        return observer;
    }

    public final void onComplete() {
        synchronized (this.lock) {
            if (this.complete) {
                return;
            }
            this.complete = true;
            this.continuations.add(new CompleteExecuteResult());
            this.lock.notifyAll();
            runContinuations();
        }
    }

    public final void onException(Exception exc) {
        synchronized (this.lock) {
            if (this.complete) {
                return;
            }
            this.complete = true;
            this.continuations.add(new ExceptionExecuteResult(exc));
            this.lock.notifyAll();
            runContinuations();
        }
    }

    public final void onNext(TResult tresult) {
        synchronized (this.lock) {
            if (this.complete) {
                return;
            }
            this.continuations.add(new NextExecuteResult(tresult));
            this.lock.notifyAll();
            runContinuations();
        }
    }

    public final void onSubscribe(Disposable disposable) {
        synchronized (this.lock) {
            if (this.mDispose) {
                disposable.dispose();
                return;
            }
            TaskStreamImpl<TResult>.LambdaDisposable lambdaDisposable = this.mLambdaDisposable;
            if (lambdaDisposable != null) {
                lambdaDisposable.setDisposable(disposable);
            }
            this.continuations.add(new SubscribeExecuteResult(disposable));
            this.lock.notifyAll();
            runContinuations();
        }
    }

    @Override // com.huawei.hmf.taskstream.TaskStream
    public void subscribe(Observer<TResult> observer) {
        continueWithTask(observer, TaskExecutors.immediate());
    }

    @Override // com.huawei.hmf.taskstream.TaskStream
    public void subscribe(Executor executor, Observer<TResult> observer) {
        continueWithTask(observer, executor);
    }

    @Override // com.huawei.hmf.taskstream.TaskStream
    public Disposable subscribe(final Consumer<TResult> consumer) {
        this.mLambdaDisposable = new LambdaDisposable();
        subscribe(new Observer<TResult>() { // from class: com.huawei.hmf.taskstream.impl.TaskStreamImpl.2
            @Override // com.huawei.hmf.taskstream.Observer
            public void onComplete() {
            }

            @Override // com.huawei.hmf.taskstream.Observer
            public void onFailure(Exception exc) {
            }

            @Override // com.huawei.hmf.taskstream.Observer
            public void onNext(TResult tresult) {
                try {
                    consumer.accept(tresult);
                } catch (Exception unused) {
                }
            }

            @Override // com.huawei.hmf.taskstream.Observer
            public void onSubscribe(Disposable disposable) {
                TaskStreamImpl.this.mLambdaDisposable.setDisposable(disposable);
            }
        });
        return this.mLambdaDisposable;
    }

    @Override // com.huawei.hmf.taskstream.TaskStream
    public Disposable subscribe(final Consumer<TResult> consumer, final Consumer<? super Exception> consumer2) {
        this.mLambdaDisposable = new LambdaDisposable();
        subscribe(new Observer<TResult>() { // from class: com.huawei.hmf.taskstream.impl.TaskStreamImpl.3
            @Override // com.huawei.hmf.taskstream.Observer
            public void onComplete() {
            }

            @Override // com.huawei.hmf.taskstream.Observer
            public void onFailure(Exception exc) {
                try {
                    consumer2.accept(exc);
                } catch (Exception unused) {
                }
            }

            @Override // com.huawei.hmf.taskstream.Observer
            public void onNext(TResult tresult) {
                try {
                    consumer.accept(tresult);
                } catch (Exception unused) {
                }
            }

            @Override // com.huawei.hmf.taskstream.Observer
            public void onSubscribe(Disposable disposable) {
                TaskStreamImpl.this.mLambdaDisposable.setDisposable(disposable);
            }
        });
        return this.mLambdaDisposable;
    }
}
