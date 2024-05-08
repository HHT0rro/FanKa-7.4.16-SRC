package com.tencent.cloud.huiyansdkface.okhttp3;

import com.tencent.cloud.huiyansdkface.okhttp3.internal.NamedRunnable;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.cache.CacheInterceptor;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.connection.ConnectInterceptor;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.connection.StreamAllocation;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.http.BridgeInterceptor;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.http.CallServerInterceptor;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.http.RealInterceptorChain;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.http.RetryAndFollowUpInterceptor;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.platform.Platform;
import com.tencent.cloud.huiyansdkface.okio.AsyncTimeout;
import com.tencent.cloud.huiyansdkface.okio.Timeout;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class RealCall implements Call {

    /* renamed from: a, reason: collision with root package name */
    public final OkHttpClient f41525a;

    /* renamed from: b, reason: collision with root package name */
    public final RetryAndFollowUpInterceptor f41526b;

    /* renamed from: c, reason: collision with root package name */
    public final AsyncTimeout f41527c;

    /* renamed from: d, reason: collision with root package name */
    public final Request f41528d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f41529e;

    /* renamed from: f, reason: collision with root package name */
    private EventListener f41530f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f41531g;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public final class AsyncCall extends NamedRunnable {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ boolean f41533a = true;

        /* renamed from: d, reason: collision with root package name */
        private final Callback f41535d;

        public AsyncCall(Callback callback) {
            super("OkHttp %s", RealCall.this.c());
            this.f41535d = callback;
        }

        public String a() {
            return RealCall.this.f41528d.url().host();
        }

        public void a(ExecutorService executorService) {
            if (!f41533a && Thread.holdsLock(RealCall.this.f41525a.dispatcher())) {
                throw new AssertionError();
            }
            try {
                try {
                    executorService.execute(this);
                } catch (RejectedExecutionException e2) {
                    InterruptedIOException interruptedIOException = new InterruptedIOException("executor rejected");
                    interruptedIOException.initCause(e2);
                    RealCall.this.f41530f.callFailed(RealCall.this, interruptedIOException);
                    this.f41535d.onFailure(RealCall.this, interruptedIOException);
                    RealCall.this.f41525a.dispatcher().b(this);
                }
            } catch (Throwable th) {
                RealCall.this.f41525a.dispatcher().b(this);
                throw th;
            }
        }

        public RealCall b() {
            return RealCall.this;
        }

        @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.NamedRunnable
        public void execute() {
            IOException e2;
            RealCall.this.f41527c.enter();
            boolean z10 = true;
            try {
                try {
                    Response d10 = RealCall.this.d();
                    try {
                        if (RealCall.this.f41526b.isCanceled()) {
                            this.f41535d.onFailure(RealCall.this, new IOException("Canceled"));
                        } else {
                            this.f41535d.onResponse(RealCall.this, d10);
                        }
                    } catch (IOException e10) {
                        e2 = e10;
                        IOException a10 = RealCall.this.a(e2);
                        if (z10) {
                            Platform.get().log(4, "Callback failure for " + RealCall.this.b(), a10);
                        } else {
                            RealCall.this.f41530f.callFailed(RealCall.this, a10);
                            this.f41535d.onFailure(RealCall.this, a10);
                        }
                    }
                } finally {
                    RealCall.this.f41525a.dispatcher().b(this);
                }
            } catch (IOException e11) {
                e2 = e11;
                z10 = false;
            }
        }
    }

    private RealCall(OkHttpClient okHttpClient, Request request, boolean z10) {
        this.f41525a = okHttpClient;
        this.f41528d = request;
        this.f41529e = z10;
        this.f41526b = new RetryAndFollowUpInterceptor(okHttpClient, z10);
        AsyncTimeout asyncTimeout = new AsyncTimeout() { // from class: com.tencent.cloud.huiyansdkface.okhttp3.RealCall.1
            @Override // com.tencent.cloud.huiyansdkface.okio.AsyncTimeout
            public void timedOut() {
                RealCall.this.cancel();
            }
        };
        this.f41527c = asyncTimeout;
        asyncTimeout.timeout(okHttpClient.callTimeoutMillis(), TimeUnit.MILLISECONDS);
    }

    public static RealCall a(OkHttpClient okHttpClient, Request request, boolean z10) {
        RealCall realCall = new RealCall(okHttpClient, request, z10);
        realCall.f41530f = okHttpClient.eventListenerFactory().create(realCall);
        return realCall;
    }

    private void e() {
        this.f41526b.setCallStackTrace(Platform.get().getStackTraceForCloseable("response.body().close()"));
    }

    public StreamAllocation a() {
        return this.f41526b.streamAllocation();
    }

    public IOException a(IOException iOException) {
        if (!this.f41527c.exit()) {
            return iOException;
        }
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public String b() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(isCanceled() ? "canceled " : "");
        sb2.append(this.f41529e ? "web socket" : "call");
        sb2.append(" to ");
        sb2.append(c());
        return sb2.toString();
    }

    public String c() {
        return this.f41528d.url().redact();
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.Call
    public void cancel() {
        this.f41526b.cancel();
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.Call
    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public RealCall m2928clone() {
        return a(this.f41525a, this.f41528d, this.f41529e);
    }

    public Response d() throws IOException {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f41525a.interceptors());
        arrayList.add(this.f41526b);
        arrayList.add(new BridgeInterceptor(this.f41525a.cookieJar()));
        arrayList.add(new CacheInterceptor(this.f41525a.a()));
        arrayList.add(new ConnectInterceptor(this.f41525a));
        if (!this.f41529e) {
            arrayList.addAll(this.f41525a.networkInterceptors());
        }
        arrayList.add(new CallServerInterceptor(this.f41529e));
        return new RealInterceptorChain(arrayList, null, null, null, 0, this.f41528d, this, this.f41530f, this.f41525a.connectTimeoutMillis(), this.f41525a.readTimeoutMillis(), this.f41525a.writeTimeoutMillis()).proceed(this.f41528d);
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.Call
    public void enqueue(Callback callback) {
        synchronized (this) {
            if (this.f41531g) {
                throw new IllegalStateException("Already Executed");
            }
            this.f41531g = true;
        }
        e();
        this.f41530f.callStart(this);
        this.f41525a.dispatcher().a(new AsyncCall(callback));
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.Call
    public Response execute() throws IOException {
        synchronized (this) {
            if (this.f41531g) {
                throw new IllegalStateException("Already Executed");
            }
            this.f41531g = true;
        }
        e();
        this.f41527c.enter();
        this.f41530f.callStart(this);
        try {
            try {
                this.f41525a.dispatcher().a(this);
                Response d10 = d();
                if (d10 != null) {
                    return d10;
                }
                throw new IOException("Canceled");
            } catch (IOException e2) {
                IOException a10 = a(e2);
                this.f41530f.callFailed(this, a10);
                throw a10;
            }
        } finally {
            this.f41525a.dispatcher().b(this);
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.Call
    public boolean isCanceled() {
        return this.f41526b.isCanceled();
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.Call
    public synchronized boolean isExecuted() {
        return this.f41531g;
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.Call
    public Request request() {
        return this.f41528d;
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.Call
    public Timeout timeout() {
        return this.f41527c;
    }
}
