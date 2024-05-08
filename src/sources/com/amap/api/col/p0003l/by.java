package com.amap.api.col.p0003l;

/* compiled from: IDownloadListener.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface by {

    /* compiled from: IDownloadListener.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public enum a {
        amap_exception(-1),
        network_exception(-1),
        file_io_exception(0),
        success_no_exception(1),
        cancel_no_exception(2);


        /* renamed from: f, reason: collision with root package name */
        private int f5187f;

        a(int i10) {
            this.f5187f = i10;
        }
    }

    void a(long j10, long j11);

    void a(a aVar);

    void m();

    void n();

    void o();
}
