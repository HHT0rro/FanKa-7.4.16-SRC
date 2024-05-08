package com.alibaba.security.common.http.ok.internal.http;

import com.alibaba.security.common.http.ok.Connection;
import com.alibaba.security.common.http.ok.EventListener;
import com.alibaba.security.common.http.ok.Interceptor;
import com.alibaba.security.common.http.ok.RPCall;
import com.alibaba.security.common.http.ok.RPRequest;
import com.alibaba.security.common.http.ok.Response;
import com.alibaba.security.common.http.ok.internal.Util;
import com.alibaba.security.common.http.ok.internal.connection.RealConnection;
import com.alibaba.security.common.http.ok.internal.connection.StreamAllocation;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class RealInterceptorChain implements Interceptor.Chain {
    private final RPCall call;
    private int calls;
    private final int connectTimeout;
    private final RealConnection connection;
    private final EventListener eventListener;
    private final HttpCodec httpCodec;
    private final int index;
    private final List<Interceptor> interceptors;
    private final int readTimeout;
    private final RPRequest request;
    private final StreamAllocation streamAllocation;
    private final int writeTimeout;

    public RealInterceptorChain(List<Interceptor> list, StreamAllocation streamAllocation, HttpCodec httpCodec, RealConnection realConnection, int i10, RPRequest rPRequest, RPCall rPCall, EventListener eventListener, int i11, int i12, int i13) {
        this.interceptors = list;
        this.connection = realConnection;
        this.streamAllocation = streamAllocation;
        this.httpCodec = httpCodec;
        this.index = i10;
        this.request = rPRequest;
        this.call = rPCall;
        this.eventListener = eventListener;
        this.connectTimeout = i11;
        this.readTimeout = i12;
        this.writeTimeout = i13;
    }

    @Override // com.alibaba.security.common.http.ok.Interceptor.Chain
    public RPCall call() {
        return this.call;
    }

    @Override // com.alibaba.security.common.http.ok.Interceptor.Chain
    public int connectTimeoutMillis() {
        return this.connectTimeout;
    }

    @Override // com.alibaba.security.common.http.ok.Interceptor.Chain
    public Connection connection() {
        return this.connection;
    }

    public EventListener eventListener() {
        return this.eventListener;
    }

    public HttpCodec httpStream() {
        return this.httpCodec;
    }

    @Override // com.alibaba.security.common.http.ok.Interceptor.Chain
    public Response proceed(RPRequest rPRequest) throws IOException {
        return proceed(rPRequest, this.streamAllocation, this.httpCodec, this.connection);
    }

    @Override // com.alibaba.security.common.http.ok.Interceptor.Chain
    public int readTimeoutMillis() {
        return this.readTimeout;
    }

    @Override // com.alibaba.security.common.http.ok.Interceptor.Chain
    public RPRequest request() {
        return this.request;
    }

    public StreamAllocation streamAllocation() {
        return this.streamAllocation;
    }

    @Override // com.alibaba.security.common.http.ok.Interceptor.Chain
    public Interceptor.Chain withConnectTimeout(int i10, TimeUnit timeUnit) {
        return new RealInterceptorChain(this.interceptors, this.streamAllocation, this.httpCodec, this.connection, this.index, this.request, this.call, this.eventListener, Util.checkDuration("timeout", i10, timeUnit), this.readTimeout, this.writeTimeout);
    }

    @Override // com.alibaba.security.common.http.ok.Interceptor.Chain
    public Interceptor.Chain withReadTimeout(int i10, TimeUnit timeUnit) {
        return new RealInterceptorChain(this.interceptors, this.streamAllocation, this.httpCodec, this.connection, this.index, this.request, this.call, this.eventListener, this.connectTimeout, Util.checkDuration("timeout", i10, timeUnit), this.writeTimeout);
    }

    @Override // com.alibaba.security.common.http.ok.Interceptor.Chain
    public Interceptor.Chain withWriteTimeout(int i10, TimeUnit timeUnit) {
        return new RealInterceptorChain(this.interceptors, this.streamAllocation, this.httpCodec, this.connection, this.index, this.request, this.call, this.eventListener, this.connectTimeout, this.readTimeout, Util.checkDuration("timeout", i10, timeUnit));
    }

    @Override // com.alibaba.security.common.http.ok.Interceptor.Chain
    public int writeTimeoutMillis() {
        return this.writeTimeout;
    }

    public Response proceed(RPRequest rPRequest, StreamAllocation streamAllocation, HttpCodec httpCodec, RealConnection realConnection) throws IOException {
        if (this.index < this.interceptors.size()) {
            this.calls++;
            if (this.httpCodec != null && !this.connection.supportsUrl(rPRequest.url())) {
                throw new IllegalStateException("network interceptor " + ((Object) this.interceptors.get(this.index - 1)) + " must retain the same host and port");
            }
            if (this.httpCodec != null && this.calls > 1) {
                throw new IllegalStateException("network interceptor " + ((Object) this.interceptors.get(this.index - 1)) + " must call proceed() exactly once");
            }
            RealInterceptorChain realInterceptorChain = new RealInterceptorChain(this.interceptors, streamAllocation, httpCodec, realConnection, this.index + 1, rPRequest, this.call, this.eventListener, this.connectTimeout, this.readTimeout, this.writeTimeout);
            Interceptor interceptor = this.interceptors.get(this.index);
            Response intercept = interceptor.intercept(realInterceptorChain);
            if (httpCodec != null && this.index + 1 < this.interceptors.size() && realInterceptorChain.calls != 1) {
                throw new IllegalStateException("network interceptor " + ((Object) interceptor) + " must call proceed() exactly once");
            }
            if (intercept != null) {
                if (intercept.body() != null) {
                    return intercept;
                }
                throw new IllegalStateException("interceptor " + ((Object) interceptor) + " returned a response with no body");
            }
            throw new NullPointerException("interceptor " + ((Object) interceptor) + " returned null");
        }
        throw new AssertionError();
    }
}
