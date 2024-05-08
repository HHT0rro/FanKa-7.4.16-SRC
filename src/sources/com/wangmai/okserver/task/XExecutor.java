package com.wangmai.okserver.task;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class XExecutor extends ThreadPoolExecutor {
    public List<OnAllTaskEndListener> allTaskEndListenerList;
    public Handler innerHandler;
    public List<OnTaskEndListener> taskEndListenerList;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface OnAllTaskEndListener {
        void onAllTaskEnd();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface OnTaskEndListener {
        void onTaskEnd(Runnable runnable);
    }

    public XExecutor(int i10, int i11, long j10, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, RejectedExecutionHandler rejectedExecutionHandler) {
        super(i10, i11, j10, timeUnit, blockingQueue, rejectedExecutionHandler);
        this.innerHandler = new Handler(Looper.getMainLooper());
    }

    public void addOnAllTaskEndListener(OnAllTaskEndListener onAllTaskEndListener) {
        if (this.allTaskEndListenerList == null) {
            this.allTaskEndListenerList = new ArrayList();
        }
        this.allTaskEndListenerList.add(onAllTaskEndListener);
    }

    public void addOnTaskEndListener(OnTaskEndListener onTaskEndListener) {
        if (this.taskEndListenerList == null) {
            this.taskEndListenerList = new ArrayList();
        }
        this.taskEndListenerList.add(onTaskEndListener);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void afterExecute(final Runnable runnable, Throwable th) {
        List<OnAllTaskEndListener> list;
        super.afterExecute(runnable, th);
        List<OnTaskEndListener> list2 = this.taskEndListenerList;
        if (list2 != null && list2.size() > 0) {
            for (final OnTaskEndListener onTaskEndListener : this.taskEndListenerList) {
                this.innerHandler.post(new Runnable() { // from class: com.wangmai.okserver.task.XExecutor.1
                    @Override // java.lang.Runnable
                    public void run() {
                        onTaskEndListener.onTaskEnd(runnable);
                    }
                });
            }
        }
        if (getActiveCount() != 1 || getQueue().size() != 0 || (list = this.allTaskEndListenerList) == null || list.size() <= 0) {
            return;
        }
        for (final OnAllTaskEndListener onAllTaskEndListener : this.allTaskEndListenerList) {
            this.innerHandler.post(new Runnable() { // from class: com.wangmai.okserver.task.XExecutor.2
                @Override // java.lang.Runnable
                public void run() {
                    onAllTaskEndListener.onAllTaskEnd();
                }
            });
        }
    }

    public void removeOnAllTaskEndListener(OnAllTaskEndListener onAllTaskEndListener) {
        this.allTaskEndListenerList.remove(onAllTaskEndListener);
    }

    public void removeOnTaskEndListener(OnTaskEndListener onTaskEndListener) {
        this.taskEndListenerList.remove(onTaskEndListener);
    }

    public XExecutor(int i10, int i11, long j10, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
        super(i10, i11, j10, timeUnit, blockingQueue, threadFactory, rejectedExecutionHandler);
        this.innerHandler = new Handler(Looper.getMainLooper());
    }

    public XExecutor(int i10, int i11, long j10, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
        super(i10, i11, j10, timeUnit, blockingQueue, threadFactory);
        this.innerHandler = new Handler(Looper.getMainLooper());
    }

    public XExecutor(int i10, int i11, long j10, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue) {
        super(i10, i11, j10, timeUnit, blockingQueue);
        this.innerHandler = new Handler(Looper.getMainLooper());
    }
}
