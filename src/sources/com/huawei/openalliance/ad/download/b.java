package com.huawei.openalliance.ad.download;

import android.content.Context;
import com.huawei.hms.ads.gl;
import com.huawei.openalliance.ad.download.DownloadTask;
import java.util.Iterator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class b<T extends DownloadTask> {
    private static final String Z = "DownloadManager";
    public Context Code;
    public c<T> I;
    public DownloadListener<T> V;

    public b(Context context) {
        this.Code = context.getApplicationContext();
    }

    public T Code(String str) {
        return this.I.Code(str);
    }

    public void Code() {
        if (this.I == null) {
            this.I = new c<>();
        }
    }

    public void Code(DownloadListener<T> downloadListener) {
        this.V = downloadListener;
    }

    public void Code(T t2) {
        this.I.Code((c<T>) t2);
        if (gl.Code()) {
            gl.Code(Z, "addTask, task:%s, priority:%s", t2.F(), Integer.valueOf(t2.C()));
        }
    }

    public boolean I(T t2) {
        if (t2 == null) {
            return false;
        }
        boolean V = this.I.V(t2);
        gl.V(Z, "removeTask, succ:" + V);
        if (!V) {
            return true;
        }
        Z(t2);
        return true;
    }

    public void V() {
        gl.V(Z, "cancelAllDownload");
        Iterator<T> it = this.I.Code().iterator2();
        while (it.hasNext()) {
            Z(it.next());
        }
        this.I.V();
    }

    public void V(T t2) {
        if (t2 == null) {
            return;
        }
        gl.V(Z, "deleteTask, succ:%s, taskId:%s", Boolean.valueOf(this.I.V(t2)), t2.F());
    }

    public void Z(T t2) {
        if (t2 == null) {
            return;
        }
        if (gl.Code()) {
            gl.Code(Z, "onDownloadDeleted, taskId:%s", t2.F());
        }
        DownloadListener<T> downloadListener = this.V;
        if (downloadListener != null) {
            downloadListener.onDownloadDeleted(t2);
        }
    }
}
