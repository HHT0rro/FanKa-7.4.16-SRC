package com.ss.android.socialbase.downloader.thread;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class ThreadWithHandler {
    private InnerThread handlerThread;
    private Object lock = new Object();
    private Queue<MessageEntity> mCacheQueue = new ConcurrentLinkedQueue();
    private Handler mHandler;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class InnerThread extends HandlerThread {
        public InnerThread(String str) {
            super(str);
        }

        @Override // android.os.HandlerThread
        public void onLooperPrepared() {
            super.onLooperPrepared();
            Looper looper = getLooper();
            synchronized (ThreadWithHandler.this.lock) {
                ThreadWithHandler.this.mHandler = new Handler(looper);
            }
            while (!ThreadWithHandler.this.mCacheQueue.isEmpty()) {
                MessageEntity messageEntity = (MessageEntity) ThreadWithHandler.this.mCacheQueue.poll();
                if (messageEntity != null) {
                    ThreadWithHandler.this.mHandler.postDelayed(messageEntity.target, messageEntity.delayMillis);
                }
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class MessageEntity {
        public long delayMillis;
        public Runnable target;

        public MessageEntity(Runnable runnable, long j10) {
            this.target = runnable;
            this.delayMillis = j10;
        }
    }

    public ThreadWithHandler(String str) {
        this.handlerThread = new InnerThread(str);
    }

    public void post(Runnable runnable) {
        postDelayed(runnable, 0L);
    }

    public void postDelayed(Runnable runnable, long j10) {
        if (this.mHandler == null) {
            synchronized (this.lock) {
                if (this.mHandler == null) {
                    this.mCacheQueue.add(new MessageEntity(runnable, j10));
                    return;
                }
            }
        }
        this.mHandler.postDelayed(runnable, j10);
    }

    public void quit() {
        this.handlerThread.quit();
    }

    public void start() {
        this.handlerThread.start();
    }
}
