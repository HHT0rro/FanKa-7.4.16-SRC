package com.google.android.exoplayer2.upstream.cache;

import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import java.io.File;
import java.io.IOException;
import p6.f;
import p6.j;
import p6.k;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public interface Cache {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class CacheException extends IOException {
        public CacheException(String str) {
            super(str);
        }

        public CacheException(Throwable th) {
            super(th);
        }

        public CacheException(String str, Throwable th) {
            super(str, th);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface a {
        void b(Cache cache, f fVar);

        void d(Cache cache, f fVar);

        void e(Cache cache, f fVar, f fVar2);
    }

    j a(String str);

    void b(f fVar);

    @WorkerThread
    f c(String str, long j10, long j11) throws InterruptedException, CacheException;

    @WorkerThread
    File d(String str, long j10, long j11) throws CacheException;

    @Nullable
    @WorkerThread
    f e(String str, long j10, long j11) throws CacheException;

    @WorkerThread
    void f(f fVar);

    long g();

    @WorkerThread
    void h(File file, long j10) throws CacheException;

    @WorkerThread
    void i(String str, k kVar) throws CacheException;
}
