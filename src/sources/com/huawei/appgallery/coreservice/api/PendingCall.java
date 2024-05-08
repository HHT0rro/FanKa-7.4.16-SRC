package com.huawei.appgallery.coreservice.api;

import android.os.RemoteException;
import com.huawei.appgallery.coreservice.f;
import com.huawei.appgallery.coreservice.internal.framework.ipc.transport.data.BaseIPCRequest;
import com.huawei.appgallery.coreservice.internal.framework.ipc.transport.data.BaseIPCResponse;
import com.huawei.appmarket.framework.coreservice.Status;
import com.huawei.appmarket.framework.coreservice.a;
import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import w9.m;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class PendingCall<C extends BaseIPCRequest, R extends BaseIPCResponse> {
    public WeakReference<ApiClient> api;

    /* renamed from: c, reason: collision with root package name */
    private final f f27572c;
    public final Object lock = new Object();

    /* renamed from: a, reason: collision with root package name */
    private final CountDownLatch f27570a = new CountDownLatch(1);
    public Status<R> mResult = new Status<>(10);

    /* renamed from: b, reason: collision with root package name */
    private boolean f27571b = false;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface Callback<R extends BaseIPCResponse> {
        void onReceiveStatus(Status<R> status);
    }

    public PendingCall(ApiClient apiClient, C c4) {
        this.f27572c = new w9.f(apiClient.getContext(), c4);
        this.api = new WeakReference<>(apiClient);
    }

    public Status<R> await() {
        awaitOnAnyThread();
        synchronized (this.lock) {
            if (!this.f27571b) {
                try {
                    this.f27570a.await();
                } catch (InterruptedException unused) {
                    m.e("PendingCall", "InterruptedException");
                }
            }
        }
        return getResult();
    }

    public Status<R> await(long j10, TimeUnit timeUnit) {
        awaitOnAnyThread();
        synchronized (this.lock) {
            if (!this.f27571b) {
                try {
                    m.a("PendingCall", "await:" + this.f27570a.await(j10, timeUnit));
                } catch (InterruptedException unused) {
                    m.e("PendingCall", "InterruptedException");
                }
            }
        }
        return getResult();
    }

    public void awaitOnAnyThread() {
        m.d("PendingCall", "awaitOnAnyThread");
        ApiClient apiClient = this.api.get();
        if (apiClient != null) {
            this.f27572c.a(apiClient, new a.AbstractBinderC0260a() { // from class: com.huawei.appgallery.coreservice.api.PendingCall.2
                @Override // com.huawei.appmarket.framework.coreservice.a
                public void call(Status status) throws RemoteException {
                    synchronized (PendingCall.this.lock) {
                        PendingCall.this.setResult(status);
                    }
                }
            });
            return;
        }
        m.c("PendingCall", "api is null");
        synchronized (this.lock) {
            this.mResult.setStatusCode(12);
        }
    }

    public Status<R> getResult() {
        Status<R> status;
        synchronized (this.lock) {
            status = this.mResult;
        }
        return status;
    }

    public void setCallback(final Callback<R> callback) {
        m.d("PendingCall", "setResultCallback");
        ApiClient apiClient = this.api.get();
        if (apiClient != null) {
            this.f27572c.a(apiClient, new a.AbstractBinderC0260a(this) { // from class: com.huawei.appgallery.coreservice.api.PendingCall.1
                @Override // com.huawei.appmarket.framework.coreservice.a
                public void call(Status status) throws RemoteException {
                    callback.onReceiveStatus(status);
                }
            });
            return;
        }
        m.c("PendingCall", "api is null");
        synchronized (this.lock) {
            this.mResult.setStatusCode(12);
        }
        callback.onReceiveStatus(getResult());
    }

    public void setResult(Status<R> status) {
        synchronized (this.lock) {
            this.mResult = status;
            this.f27571b = true;
        }
    }
}
