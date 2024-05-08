package com.kwad.sdk;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class a {
    public int mTaskId;

    public abstract void a(DownloadTask downloadTask);

    public abstract void a(DownloadTask downloadTask, int i10, int i11);

    public abstract void a(DownloadTask downloadTask, Throwable th);

    public abstract void b(DownloadTask downloadTask);

    public abstract void c(DownloadTask downloadTask);

    public abstract void d(DownloadTask downloadTask);

    public abstract void e(DownloadTask downloadTask);

    public abstract void f(DownloadTask downloadTask);

    public final void setId(int i10) {
        this.mTaskId = i10;
    }
}
