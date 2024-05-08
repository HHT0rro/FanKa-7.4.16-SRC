package com.alipay.android.phone.mrpc.core;

import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
final class m extends FutureTask<u> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q f4250a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ l f4251b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(l lVar, Callable callable, q qVar) {
        super(callable);
        this.f4251b = lVar;
        this.f4250a = qVar;
    }

    @Override // java.util.concurrent.FutureTask
    public final void done() {
        o a10 = this.f4250a.a();
        if (a10.f() == null) {
            super.done();
            return;
        }
        try {
            get();
            if (isCancelled() || a10.h()) {
                a10.g();
                if (isCancelled() && isDone()) {
                    return;
                }
                cancel(false);
            }
        } catch (InterruptedException e2) {
            e2.toString();
        } catch (CancellationException unused) {
            a10.g();
        } catch (ExecutionException e10) {
            if (e10.getCause() == null || !(e10.getCause() instanceof HttpException)) {
                e10.toString();
                return;
            }
            HttpException httpException = (HttpException) e10.getCause();
            httpException.getCode();
            httpException.getMsg();
        } catch (Throwable th) {
            throw new RuntimeException("An error occured while executing http request", th);
        }
    }
}
