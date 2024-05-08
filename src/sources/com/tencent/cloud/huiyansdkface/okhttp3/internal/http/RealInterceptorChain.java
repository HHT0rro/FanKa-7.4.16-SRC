package com.tencent.cloud.huiyansdkface.okhttp3.internal.http;

import com.tencent.cloud.huiyansdkface.okhttp3.Call;
import com.tencent.cloud.huiyansdkface.okhttp3.Connection;
import com.tencent.cloud.huiyansdkface.okhttp3.EventListener;
import com.tencent.cloud.huiyansdkface.okhttp3.Interceptor;
import com.tencent.cloud.huiyansdkface.okhttp3.Request;
import com.tencent.cloud.huiyansdkface.okhttp3.Response;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.Util;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.connection.RealConnection;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.connection.StreamAllocation;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class RealInterceptorChain implements Interceptor.Chain {

    /* renamed from: a, reason: collision with root package name */
    private final List<Interceptor> f41764a;

    /* renamed from: b, reason: collision with root package name */
    private final StreamAllocation f41765b;

    /* renamed from: c, reason: collision with root package name */
    private final HttpCodec f41766c;

    /* renamed from: d, reason: collision with root package name */
    private final RealConnection f41767d;

    /* renamed from: e, reason: collision with root package name */
    private final int f41768e;

    /* renamed from: f, reason: collision with root package name */
    private final Request f41769f;

    /* renamed from: g, reason: collision with root package name */
    private final Call f41770g;

    /* renamed from: h, reason: collision with root package name */
    private final EventListener f41771h;

    /* renamed from: i, reason: collision with root package name */
    private final int f41772i;

    /* renamed from: j, reason: collision with root package name */
    private final int f41773j;

    /* renamed from: k, reason: collision with root package name */
    private final int f41774k;

    /* renamed from: l, reason: collision with root package name */
    private int f41775l;

    public RealInterceptorChain(List<Interceptor> list, StreamAllocation streamAllocation, HttpCodec httpCodec, RealConnection realConnection, int i10, Request request, Call call, EventListener eventListener, int i11, int i12, int i13) {
        this.f41764a = list;
        this.f41767d = realConnection;
        this.f41765b = streamAllocation;
        this.f41766c = httpCodec;
        this.f41768e = i10;
        this.f41769f = request;
        this.f41770g = call;
        this.f41771h = eventListener;
        this.f41772i = i11;
        this.f41773j = i12;
        this.f41774k = i13;
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.Interceptor.Chain
    public Call call() {
        return this.f41770g;
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.Interceptor.Chain
    public int connectTimeoutMillis() {
        return this.f41772i;
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.Interceptor.Chain
    public Connection connection() {
        return this.f41767d;
    }

    public EventListener eventListener() {
        return this.f41771h;
    }

    public HttpCodec httpStream() {
        return this.f41766c;
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.Interceptor.Chain
    public Response proceed(Request request) throws IOException {
        return proceed(request, this.f41765b, this.f41766c, this.f41767d);
    }

    public Response proceed(Request request, StreamAllocation streamAllocation, HttpCodec httpCodec, RealConnection realConnection) throws IOException {
        if (this.f41768e >= this.f41764a.size()) {
            throw new AssertionError();
        }
        this.f41775l++;
        if (this.f41766c != null && !this.f41767d.supportsUrl(request.url())) {
            throw new IllegalStateException("network interceptor " + ((Object) this.f41764a.get(this.f41768e - 1)) + " must retain the same host and port");
        }
        if (this.f41766c != null && this.f41775l > 1) {
            throw new IllegalStateException("network interceptor " + ((Object) this.f41764a.get(this.f41768e - 1)) + " must call proceed() exactly once");
        }
        RealInterceptorChain realInterceptorChain = new RealInterceptorChain(this.f41764a, streamAllocation, httpCodec, realConnection, this.f41768e + 1, request, this.f41770g, this.f41771h, this.f41772i, this.f41773j, this.f41774k);
        Interceptor interceptor = this.f41764a.get(this.f41768e);
        Response intercept = interceptor.intercept(realInterceptorChain);
        if (httpCodec != null && this.f41768e + 1 < this.f41764a.size() && realInterceptorChain.f41775l != 1) {
            throw new IllegalStateException("network interceptor " + ((Object) interceptor) + " must call proceed() exactly once");
        }
        if (intercept == null) {
            throw new NullPointerException("interceptor " + ((Object) interceptor) + " returned null");
        }
        if (intercept.body() != null) {
            return intercept;
        }
        throw new IllegalStateException("interceptor " + ((Object) interceptor) + " returned a response with no body");
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.Interceptor.Chain
    public int readTimeoutMillis() {
        return this.f41773j;
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.Interceptor.Chain
    public Request request() {
        return this.f41769f;
    }

    public StreamAllocation streamAllocation() {
        return this.f41765b;
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.Interceptor.Chain
    public Interceptor.Chain withConnectTimeout(int i10, TimeUnit timeUnit) {
        return new RealInterceptorChain(this.f41764a, this.f41765b, this.f41766c, this.f41767d, this.f41768e, this.f41769f, this.f41770g, this.f41771h, Util.checkDuration("timeout", i10, timeUnit), this.f41773j, this.f41774k);
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.Interceptor.Chain
    public Interceptor.Chain withReadTimeout(int i10, TimeUnit timeUnit) {
        return new RealInterceptorChain(this.f41764a, this.f41765b, this.f41766c, this.f41767d, this.f41768e, this.f41769f, this.f41770g, this.f41771h, this.f41772i, Util.checkDuration("timeout", i10, timeUnit), this.f41774k);
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.Interceptor.Chain
    public Interceptor.Chain withWriteTimeout(int i10, TimeUnit timeUnit) {
        return new RealInterceptorChain(this.f41764a, this.f41765b, this.f41766c, this.f41767d, this.f41768e, this.f41769f, this.f41770g, this.f41771h, this.f41772i, this.f41773j, Util.checkDuration("timeout", i10, timeUnit));
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.Interceptor.Chain
    public int writeTimeoutMillis() {
        return this.f41774k;
    }
}
