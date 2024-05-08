package com.irisdt.grpc.connect;

import com.irisdt.db.DBManager;
import com.irisdt.db.Entity;
import com.irisdt.grpc.ConnectManager;
import com.irisdt.util.LoopQueue;
import com.irisdt.util.ThreadManager;
import com.irisdt.util.UploadTaskHandler;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class BaseManager<Request> {
    private LoopQueue dataQueue = new LoopQueue(300);
    private long nextMinUploadTime = 0;
    private long lastUploadTime = 0;
    private long currentTime = 0;
    private Runnable timingRunnable = new Runnable() { // from class: com.irisdt.grpc.connect.BaseManager.1
        @Override // java.lang.Runnable
        public void run() {
            if (BaseManager.this.isEnable() && ConnectManager.isInit()) {
                synchronized (BaseManager.this.dataQueue) {
                    while (BaseManager.this.dataQueue.size() > 0) {
                        if (BaseManager.this.isLogEnable()) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("+++ report start: ");
                            sb2.append(BaseManager.this.dataQueue.size());
                            sb2.append(", ");
                            sb2.append(Thread.currentThread().getName());
                        }
                        Object[] pop = BaseManager.this.dataQueue.pop(BaseManager.this.getBatchSize());
                        if (pop != null && pop.length > 0) {
                            BaseManager.this.upload(pop);
                        }
                        if (BaseManager.this.isLogEnable()) {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("--- report end: ");
                            sb3.append(BaseManager.this.dataQueue.size());
                            sb3.append(", ");
                            sb3.append(Thread.currentThread().getName());
                        }
                    }
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$recordByDB$0(Object obj) {
        DBManager.getInstance().insert(getTable(), new Entity(serialize(obj)));
    }

    private void recordByDB(final Request request) {
        ThreadManager.startThread(new Runnable() { // from class: com.irisdt.grpc.connect.a
            @Override // java.lang.Runnable
            public final void run() {
                BaseManager.this.lambda$recordByDB$0(request);
            }
        });
    }

    private void recordByMem(Request request) {
        synchronized (this.dataQueue) {
            UploadTaskHandler.getInstance().removeRunnable(this.timingRunnable);
            this.dataQueue.push(request);
            long currentTimeMillis = System.currentTimeMillis();
            this.currentTime = currentTimeMillis;
            if (0 == this.lastUploadTime) {
                this.lastUploadTime = currentTimeMillis;
                this.nextMinUploadTime = currentTimeMillis + getMinUploadIntervals();
            }
            if (this.dataQueue.size() >= getBatchSize()) {
                uploadNow();
            } else {
                long j10 = this.currentTime;
                if (j10 < this.nextMinUploadTime) {
                    uploadDelayed();
                } else if (j10 >= this.lastUploadTime + getMinUploadIntervals()) {
                    uploadNow();
                } else {
                    this.nextMinUploadTime += getMinUploadIntervals();
                    uploadDelayed();
                }
            }
        }
    }

    private void uploadDelayed() {
        UploadTaskHandler.getInstance().uploadDelay(this.timingRunnable, this.nextMinUploadTime - this.currentTime);
        this.lastUploadTime = this.nextMinUploadTime;
    }

    private void uploadNow() {
        UploadTaskHandler.getInstance().uploadNow(this.timingRunnable);
        this.nextMinUploadTime = this.currentTime + getMinUploadIntervals();
        this.lastUploadTime = this.currentTime;
    }

    public int getBatchSize() {
        return 30;
    }

    public abstract long getMinUploadIntervals();

    public String getTable() {
        return null;
    }

    public boolean isEnable() {
        return true;
    }

    public boolean isLocalCacheEnable() {
        return false;
    }

    public boolean isLogEnable() {
        return false;
    }

    public void record(Request request) {
        if (isEnable()) {
            if (isLocalCacheEnable()) {
                recordByDB(request);
            } else {
                recordByMem(request);
            }
        }
    }

    public byte[] serialize(Request request) {
        return null;
    }

    public abstract void upload(Object[] objArr);
}
