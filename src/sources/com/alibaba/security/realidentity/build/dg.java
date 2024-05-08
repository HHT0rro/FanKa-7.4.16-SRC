package com.alibaba.security.realidentity.build;

import com.alibaba.security.realidentity.build.ft;
import com.alibaba.security.realidentity.oss.ClientException;
import com.alibaba.security.realidentity.oss.ServiceException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* compiled from: OSSAsyncTask.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class dg<T extends ft> {

    /* renamed from: a, reason: collision with root package name */
    private Future<T> f3456a;

    /* renamed from: b, reason: collision with root package name */
    private gr f3457b;

    /* renamed from: c, reason: collision with root package name */
    private volatile boolean f3458c;

    public static dg a(Future future, gr grVar) {
        dg dgVar = new dg();
        dgVar.f3456a = future;
        dgVar.f3457b = grVar;
        return dgVar;
    }

    private boolean d() {
        return this.f3456a.isDone();
    }

    private boolean e() {
        return this.f3458c;
    }

    public final T b() throws ClientException, ServiceException {
        try {
            return this.f3456a.get();
        } catch (InterruptedException e2) {
            throw new ClientException(" InterruptedException and message : " + e2.getMessage(), e2);
        } catch (ExecutionException e10) {
            Throwable cause = e10.getCause();
            if (!(cause instanceof ClientException)) {
                if (cause instanceof ServiceException) {
                    throw ((ServiceException) cause);
                }
                cause.printStackTrace();
                throw new ClientException("Unexpected exception!" + cause.getMessage());
            }
            throw ((ClientException) cause);
        }
    }

    public final void c() {
        try {
            this.f3456a.get();
        } catch (Exception unused) {
        }
    }

    public final void a() {
        this.f3458c = true;
        gr grVar = this.f3457b;
        if (grVar != null) {
            grVar.f3758c.a();
        }
    }
}
