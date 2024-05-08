package com.alibaba.security.common.http.ok;

import com.alibaba.security.common.http.ok.internal.NamedRunnable;
import com.alibaba.security.common.http.ok.internal.cache.CacheInterceptor;
import com.alibaba.security.common.http.ok.internal.connection.ConnectInterceptor;
import com.alibaba.security.common.http.ok.internal.connection.StreamAllocation;
import com.alibaba.security.common.http.ok.internal.http.BridgeInterceptor;
import com.alibaba.security.common.http.ok.internal.http.CallServerInterceptor;
import com.alibaba.security.common.http.ok.internal.http.RealInterceptorChain;
import com.alibaba.security.common.http.ok.internal.http.RetryAndFollowUpInterceptor;
import com.alibaba.security.common.http.ok.internal.platform.Platform;
import com.alibaba.security.common.http.okio.AsyncTimeout;
import com.alibaba.security.common.http.okio.Timeout;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class RealCall implements RPCall {
    public final RPHttpClient client;
    private EventListener eventListener;
    private boolean executed;
    public final boolean forWebSocket;
    public final RPRequest originalRequest;
    public final RetryAndFollowUpInterceptor retryAndFollowUpInterceptor;
    public final AsyncTimeout timeout;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public final class AsyncCall extends NamedRunnable {
        public static final /* synthetic */ boolean $assertionsDisabled = false;
        private final Callback responseCallback;

        public AsyncCall(Callback callback) {
            super("OkHttp %s", RealCall.this.redactedUrl());
            this.responseCallback = callback;
        }

        @Override // com.alibaba.security.common.http.ok.internal.NamedRunnable
        public void execute() {
            IOException e2;
            RealCall.this.timeout.enter();
            boolean z10 = true;
            try {
                try {
                    Response responseWithInterceptorChain = RealCall.this.getResponseWithInterceptorChain();
                    try {
                        if (RealCall.this.retryAndFollowUpInterceptor.isCanceled()) {
                            this.responseCallback.onFailure(RealCall.this, new IOException("Canceled"));
                        } else {
                            this.responseCallback.onResponse(RealCall.this, responseWithInterceptorChain);
                        }
                    } catch (IOException e10) {
                        e2 = e10;
                        IOException timeoutExit = RealCall.this.timeoutExit(e2);
                        if (z10) {
                            Platform.get().log(4, "Callback failure for " + RealCall.this.toLoggableString(), timeoutExit);
                        } else {
                            RealCall.this.eventListener.callFailed(RealCall.this, timeoutExit);
                            this.responseCallback.onFailure(RealCall.this, timeoutExit);
                        }
                    }
                } finally {
                    RealCall.this.client.dispatcher().finished(this);
                }
            } catch (IOException e11) {
                e2 = e11;
                z10 = false;
            }
        }

        public void executeOn(ExecutorService executorService) {
            try {
                try {
                    executorService.execute(this);
                } catch (RejectedExecutionException e2) {
                    InterruptedIOException interruptedIOException = new InterruptedIOException("executor rejected");
                    interruptedIOException.initCause(e2);
                    RealCall.this.eventListener.callFailed(RealCall.this, interruptedIOException);
                    this.responseCallback.onFailure(RealCall.this, interruptedIOException);
                    RealCall.this.client.dispatcher().finished(this);
                }
            } catch (Throwable th) {
                RealCall.this.client.dispatcher().finished(this);
                throw th;
            }
        }

        public RealCall get() {
            return RealCall.this;
        }

        public String host() {
            return RealCall.this.originalRequest.url().host();
        }

        public RPRequest request() {
            return RealCall.this.originalRequest;
        }
    }

    private RealCall(RPHttpClient rPHttpClient, RPRequest rPRequest, boolean z10) {
        this.client = rPHttpClient;
        this.originalRequest = rPRequest;
        this.forWebSocket = z10;
        this.retryAndFollowUpInterceptor = new RetryAndFollowUpInterceptor(rPHttpClient, z10);
        AsyncTimeout asyncTimeout = new AsyncTimeout() { // from class: com.alibaba.security.common.http.ok.RealCall.1
            @Override // com.alibaba.security.common.http.okio.AsyncTimeout
            public void timedOut() {
                RealCall.this.cancel();
            }
        };
        this.timeout = asyncTimeout;
        asyncTimeout.timeout(rPHttpClient.callTimeoutMillis(), TimeUnit.MILLISECONDS);
    }

    private void captureCallStackTrace() {
        this.retryAndFollowUpInterceptor.setCallStackTrace(Platform.get().getStackTraceForCloseable("response.body().close()"));
    }

    public static RealCall newRealCall(RPHttpClient rPHttpClient, RPRequest rPRequest, boolean z10) {
        RealCall realCall = new RealCall(rPHttpClient, rPRequest, z10);
        realCall.eventListener = rPHttpClient.eventListenerFactory().create(realCall);
        return realCall;
    }

    @Override // com.alibaba.security.common.http.ok.RPCall
    public void cancel() {
        this.retryAndFollowUpInterceptor.cancel();
    }

    @Override // com.alibaba.security.common.http.ok.RPCall
    public void enqueue(Callback callback) {
        synchronized (this) {
            if (!this.executed) {
                this.executed = true;
            } else {
                throw new IllegalStateException("Already Executed");
            }
        }
        captureCallStackTrace();
        this.eventListener.callStart(this);
        this.client.dispatcher().enqueue(new AsyncCall(callback));
    }

    @Override // com.alibaba.security.common.http.ok.RPCall
    public Response execute() throws IOException {
        synchronized (this) {
            if (!this.executed) {
                this.executed = true;
            } else {
                throw new IllegalStateException("Already Executed");
            }
        }
        captureCallStackTrace();
        this.timeout.enter();
        this.eventListener.callStart(this);
        try {
            try {
                this.client.dispatcher().executed(this);
                Response responseWithInterceptorChain = getResponseWithInterceptorChain();
                if (responseWithInterceptorChain != null) {
                    return responseWithInterceptorChain;
                }
                throw new IOException("Canceled");
            } catch (IOException e2) {
                IOException timeoutExit = timeoutExit(e2);
                this.eventListener.callFailed(this, timeoutExit);
                throw timeoutExit;
            }
        } finally {
            this.client.dispatcher().finished(this);
        }
    }

    public Response getResponseWithInterceptorChain() throws IOException {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.client.interceptors());
        arrayList.add(this.retryAndFollowUpInterceptor);
        arrayList.add(new BridgeInterceptor(this.client.cookieJar()));
        arrayList.add(new CacheInterceptor(this.client.internalCache()));
        arrayList.add(new ConnectInterceptor(this.client));
        if (!this.forWebSocket) {
            arrayList.addAll(this.client.networkInterceptors());
        }
        arrayList.add(new CallServerInterceptor(this.forWebSocket));
        return new RealInterceptorChain(arrayList, null, null, null, 0, this.originalRequest, this, this.eventListener, this.client.connectTimeoutMillis(), this.client.readTimeoutMillis(), this.client.writeTimeoutMillis()).proceed(this.originalRequest);
    }

    @Override // com.alibaba.security.common.http.ok.RPCall
    public boolean isCanceled() {
        return this.retryAndFollowUpInterceptor.isCanceled();
    }

    @Override // com.alibaba.security.common.http.ok.RPCall
    public synchronized boolean isExecuted() {
        return this.executed;
    }

    public String redactedUrl() {
        return this.originalRequest.url().redact();
    }

    @Override // com.alibaba.security.common.http.ok.RPCall
    public RPRequest request() {
        return this.originalRequest;
    }

    public StreamAllocation streamAllocation() {
        return this.retryAndFollowUpInterceptor.streamAllocation();
    }

    @Override // com.alibaba.security.common.http.ok.RPCall
    public Timeout timeout() {
        return this.timeout;
    }

    public IOException timeoutExit(IOException iOException) {
        if (!this.timeout.exit()) {
            return iOException;
        }
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public String toLoggableString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(isCanceled() ? "canceled " : "");
        sb2.append(this.forWebSocket ? "web socket" : "call");
        sb2.append(" to ");
        sb2.append(redactedUrl());
        return sb2.toString();
    }

    @Override // com.alibaba.security.common.http.ok.RPCall
    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public RealCall m1764clone() {
        return newRealCall(this.client, this.originalRequest, this.forWebSocket);
    }
}
