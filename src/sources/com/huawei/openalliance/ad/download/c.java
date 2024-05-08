package com.huawei.openalliance.ad.download;

import android.text.TextUtils;
import com.huawei.hms.ads.gl;
import com.huawei.openalliance.ad.download.DownloadTask;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class c<T extends DownloadTask> {
    private static final String Code = "DownloadQueue";
    private Queue<T> V = new ConcurrentLinkedQueue();

    private T Code(Queue<T> queue, String str) {
        if (gl.Code()) {
            gl.Code(Code, "findTaskFromQueue, taskId:%s", str);
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (T t2 : queue) {
            if (str.equals(t2.F())) {
                return t2;
            }
        }
        return null;
    }

    public T Code(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (gl.Code()) {
            gl.Code(Code, "findTask, workingQueue.size:%s", Integer.valueOf(this.V.size()));
        }
        return Code(this.V, str);
    }

    public Queue<T> Code() {
        return this.V;
    }

    public void Code(T t2) {
        if (t2 == null || this.V.contains(t2)) {
            return;
        }
        this.V.offer(t2);
    }

    public void V() {
        this.V.clear();
    }

    public boolean V(T t2) {
        if (t2 == null || !this.V.contains(t2)) {
            return false;
        }
        this.V.remove(t2);
        return true;
    }
}
