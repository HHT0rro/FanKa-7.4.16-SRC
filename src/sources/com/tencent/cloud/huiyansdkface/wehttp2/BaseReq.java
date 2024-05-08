package com.tencent.cloud.huiyansdkface.wehttp2;

import com.tencent.cloud.huiyansdkface.okhttp3.Call;
import com.tencent.cloud.huiyansdkface.okhttp3.Callback;
import com.tencent.cloud.huiyansdkface.okhttp3.HttpUrl;
import com.tencent.cloud.huiyansdkface.okhttp3.Request;
import com.tencent.cloud.huiyansdkface.okhttp3.Response;
import com.tencent.cloud.huiyansdkface.wehttp2.BaseReq;
import com.tencent.cloud.huiyansdkface.wehttp2.WeReq;
import com.tencent.cloud.huiyansdkface.wejson.WeJsonException;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class BaseReq<R extends BaseReq> implements WeReq {

    /* renamed from: a, reason: collision with root package name */
    public String f42174a;

    /* renamed from: b, reason: collision with root package name */
    public String f42175b;

    /* renamed from: c, reason: collision with root package name */
    public Map<String, String> f42176c;

    /* renamed from: d, reason: collision with root package name */
    public WeOkHttp f42177d;

    /* renamed from: e, reason: collision with root package name */
    public Request.Builder f42178e;

    /* renamed from: f, reason: collision with root package name */
    private Call f42179f;

    /* renamed from: g, reason: collision with root package name */
    private long f42180g = 0;

    /* renamed from: h, reason: collision with root package name */
    private long f42181h = 0;

    /* renamed from: i, reason: collision with root package name */
    private long f42182i = 0;

    /* renamed from: j, reason: collision with root package name */
    private long f42183j = 0;

    public BaseReq(WeOkHttp weOkHttp, String str, String str2) {
        this.f42177d = weOkHttp;
        this.f42174a = str;
        this.f42175b = str2;
        Request.Builder builder = new Request.Builder();
        this.f42178e = builder;
        a(builder, weOkHttp.config().getHeaders());
    }

    private HttpUrl.Builder a(HttpUrl.Builder builder, Map<String, String> map) {
        if (map != null && map.size() != 0) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                builder.addQueryParameter(entry.getKey(), entry.getValue());
            }
        }
        return builder;
    }

    private <T> WeReq a(final Type type, final WeReq.InnerCallback<T> innerCallback) {
        Call d10 = d();
        innerCallback.onStart(this);
        d10.enqueue(new Callback() { // from class: com.tencent.cloud.huiyansdkface.wehttp2.BaseReq.3
            @Override // com.tencent.cloud.huiyansdkface.okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                BaseReq.this.a(innerCallback, WeReq.ErrType.NETWORK, BaseReq.this.b(iOException), BaseReq.this.a(iOException), iOException);
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r13v13, types: [java.lang.Object] */
            /* JADX WARN: Type inference failed for: r13v14 */
            /* JADX WARN: Type inference failed for: r13v16, types: [java.lang.Object] */
            @Override // com.tencent.cloud.huiyansdkface.okhttp3.Callback
            public void onResponse(Call call, Response response) {
                ?? from;
                Type type2 = type;
                String str = response;
                if (type2 != Response.class) {
                    str = response;
                    if (type2 != Object.class) {
                        if (response.code() < 200 || response.code() >= 300) {
                            BaseReq.this.a(innerCallback, WeReq.ErrType.HTTP, response.code(), response.message(), null);
                            return;
                        }
                        try {
                            String string = response.body().string();
                            str = string;
                            if (type != String.class) {
                                try {
                                    TypeAdapter adapter = BaseReq.this.f42177d.config().adapter();
                                    if (adapter instanceof TypeAdaptor2) {
                                        from = ((TypeAdaptor2) adapter).a(string, type);
                                    } else {
                                        Type type3 = type;
                                        if (!(type3 instanceof Class)) {
                                            BaseReq.this.a(innerCallback, WeReq.ErrType.LOCAL, 3, "you need use TypeAdaptor2", null);
                                            return;
                                        }
                                        from = adapter.from(string, (Class) type3);
                                    }
                                    str = from;
                                } catch (WeJsonException e2) {
                                    BaseReq.this.a(innerCallback, WeReq.ErrType.LOCAL, -1, e2.getMessage(), e2);
                                    return;
                                }
                            }
                        } catch (IOException e10) {
                            BaseReq.this.a(innerCallback, WeReq.ErrType.LOCAL, -2, e10.getMessage(), e10);
                            return;
                        }
                    }
                }
                BaseReq.this.a((BaseReq) str, (WeReq.InnerCallback<BaseReq>) innerCallback);
            }
        });
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(IOException iOException) {
        return iOException.getMessage();
    }

    private void a(Request.Builder builder, Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            builder.header(entry.getKey(), entry.getValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T> void a(WeReq.InnerCallback<T> innerCallback, WeReq.ErrType errType, int i10, String str, IOException iOException) {
        innerCallback.onFailed(this, errType, i10, str, iOException);
        innerCallback.onFinish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T> void a(T t2, WeReq.InnerCallback<T> innerCallback) {
        innerCallback.onSuccess(this, t2);
        innerCallback.onFinish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b(IOException iOException) {
        return 0;
    }

    private Call d() {
        if (this.f42179f == null) {
            long j10 = this.f42183j;
            if (j10 > 0) {
                header("__wehttp__read_timeout__", String.valueOf(j10));
            }
            long j11 = this.f42182i;
            if (j11 > 0) {
                header("__wehttp__write_timeout__", String.valueOf(j11));
            }
            long j12 = this.f42181h;
            if (j12 > 0) {
                header("__wehttp__connect_timeout__", String.valueOf(j12));
            }
            Call c4 = c();
            this.f42179f = c4;
            if (this.f42180g > 0) {
                c4.timeout().timeout(this.f42180g, TimeUnit.MILLISECONDS);
            }
        }
        return this.f42179f;
    }

    public final Request.Builder a() {
        return this.f42178e;
    }

    public final HttpUrl.Builder b() {
        HttpUrl.Builder newBuilder = HttpUrl.parse(this.f42177d.config().getUrl(this.f42175b)).newBuilder();
        a(newBuilder, this.f42177d.config().getParams());
        return a(newBuilder, this.f42176c);
    }

    public abstract Call c();

    public final R callTimeoutInMillis(int i10) {
        this.f42180g = i10;
        return this;
    }

    @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeReq
    public void cancel() {
        d().cancel();
    }

    public final R connectTimeoutInMillis(long j10) {
        this.f42181h = j10;
        return this;
    }

    @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeReq
    public WeConfig context() {
        return this.f42177d.config();
    }

    @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeReq
    public <T> WeReq execute(final WeReq.Callback<T> callback) {
        final boolean a10 = WeUtils.a(callback);
        final boolean b4 = WeUtils.b(callback);
        final boolean c4 = WeUtils.c(callback);
        return a(WeUtils.getTypeOfReturn(callback), (WeReq.InnerCallback) new WeReq.InnerCallback<T>() { // from class: com.tencent.cloud.huiyansdkface.wehttp2.BaseReq.2

            /* renamed from: f, reason: collision with root package name */
            private boolean f42190f = false;

            @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeReq.InnerCallback
            public void onFailed(final WeReq weReq, final WeReq.ErrType errType, final int i10, final String str, final IOException iOException) {
                this.f42190f = false;
                if (b4) {
                    WeOkHttp.runUi(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.wehttp2.BaseReq.2.3
                        @Override // java.lang.Runnable
                        public void run() {
                            callback.onFailed(weReq, errType, i10, str, iOException);
                        }
                    });
                } else {
                    callback.onFailed(weReq, errType, i10, str, iOException);
                }
            }

            @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeReq.InnerCallback
            public void onFinish() {
                if (c4) {
                    WeOkHttp.runUi(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.wehttp2.BaseReq.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            callback.onFinish();
                        }
                    });
                    return;
                }
                boolean z10 = this.f42190f;
                if ((z10 && a10) || (!z10 && b4)) {
                    throw new IllegalStateException("不支持onFinish()在非主线程执行,但onSuccess或onFailed在主线程执行");
                }
                callback.onFinish();
            }

            @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeReq.InnerCallback
            public void onStart(WeReq weReq) {
                callback.onStart(weReq);
            }

            @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeReq.InnerCallback
            public void onSuccess(final WeReq weReq, final T t2) {
                this.f42190f = true;
                if (a10) {
                    WeOkHttp.runUi(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.wehttp2.BaseReq.2.2
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.lang.Runnable
                        public void run() {
                            callback.onSuccess(weReq, t2);
                        }
                    });
                } else {
                    callback.onSuccess(weReq, t2);
                }
            }
        });
    }

    @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeReq
    public <T> T execute(Class<T> cls) throws ReqFailException {
        return (T) execute((Type) cls);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [com.tencent.cloud.huiyansdkface.okhttp3.Call, T] */
    /* JADX WARN: Type inference failed for: r0v3, types: [T, com.tencent.cloud.huiyansdkface.okhttp3.Response] */
    /* JADX WARN: Type inference failed for: r0v6, types: [T, java.lang.String] */
    @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeReq
    public <T> T execute(Type type) throws ReqFailException {
        if (type == null) {
            throw new IllegalArgumentException("classOfReturn must not be null");
        }
        ?? r02 = (T) d();
        if (type == Call.class) {
            return r02;
        }
        try {
            ?? r03 = (T) r02.execute();
            if (type != Response.class && type != Object.class) {
                if (!r03.isSuccessful()) {
                    throw new ReqFailException(WeReq.ErrType.HTTP, r03.code(), r03.message(), null);
                }
                try {
                    ?? r04 = (T) r03.body().string();
                    if (type == String.class) {
                        return r04;
                    }
                    try {
                        TypeAdapter adapter = this.f42177d.config().adapter();
                        if (adapter instanceof TypeAdaptor2) {
                            return (T) ((TypeAdaptor2) adapter).a(r04, type);
                        }
                        if (type instanceof Class) {
                            return (T) adapter.from(r04, (Class) type);
                        }
                        throw new ReqFailException(WeReq.ErrType.LOCAL, 3, "you need use TypeAdaptor2", null);
                    } catch (Exception e2) {
                        throw new ReqFailException(WeReq.ErrType.LOCAL, -1, "JSON", e2);
                    }
                } catch (IOException e10) {
                    throw new ReqFailException(WeReq.ErrType.LOCAL, -2, e10.getMessage(), e10);
                }
            }
            return r03;
        } catch (IOException e11) {
            throw new ReqFailException(WeReq.ErrType.NETWORK, 0, e11.getMessage(), e11);
        }
    }

    public final R header(String str, String str2) {
        this.f42178e.header(str, str2);
        return this;
    }

    public final R param(String str, String str2) {
        if (this.f42176c == null) {
            this.f42176c = new HashMap();
        }
        if (str != null && !str.trim().equals("")) {
            this.f42176c.put(str, str2);
        }
        return this;
    }

    public final R param(Map<String, String> map) {
        if (this.f42176c == null) {
            this.f42176c = new HashMap();
        }
        if (map != null && map.size() != 0) {
            this.f42176c.putAll(map);
        }
        return this;
    }

    public final R readTimeoutInMillis(long j10) {
        this.f42183j = j10;
        return this;
    }

    @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeReq
    public Observable subscribe() {
        return new Observable(this) { // from class: com.tencent.cloud.huiyansdkface.wehttp2.BaseReq.1
            @Override // com.tencent.cloud.huiyansdkface.wehttp2.Observable
            public void subscribe(WeReq.Callback callback) {
                BaseReq.this.execute(callback);
            }
        };
    }

    public final R tag(Object obj) {
        this.f42178e.tag(obj);
        return this;
    }

    public final R writeTimeoutInMillis(long j10) {
        this.f42182i = j10;
        return this;
    }
}
