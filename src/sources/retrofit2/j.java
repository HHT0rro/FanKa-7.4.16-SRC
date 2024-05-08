package retrofit2;

import java.io.IOException;
import java.util.Objects;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;

/* compiled from: OkHttpCall.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class j<T> implements retrofit2.b<T> {

    /* renamed from: b, reason: collision with root package name */
    public final o f53432b;

    /* renamed from: c, reason: collision with root package name */
    public final Object[] f53433c;

    /* renamed from: d, reason: collision with root package name */
    public final Call.Factory f53434d;

    /* renamed from: e, reason: collision with root package name */
    public final f<ResponseBody, T> f53435e;

    /* renamed from: f, reason: collision with root package name */
    public volatile boolean f53436f;

    /* renamed from: g, reason: collision with root package name */
    public Call f53437g;

    /* renamed from: h, reason: collision with root package name */
    public Throwable f53438h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f53439i;

    /* compiled from: OkHttpCall.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class a implements Callback {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f53440b;

        public a(d dVar) {
            this.f53440b = dVar;
        }

        public final void a(Throwable th) {
            try {
                this.f53440b.a(j.this, th);
            } catch (Throwable th2) {
                t.t(th2);
                th2.printStackTrace();
            }
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            a(iOException);
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, okhttp3.Response response) {
            try {
                try {
                    this.f53440b.b(j.this, j.this.d(response));
                } catch (Throwable th) {
                    t.t(th);
                    th.printStackTrace();
                }
            } catch (Throwable th2) {
                t.t(th2);
                a(th2);
            }
        }
    }

    /* compiled from: OkHttpCall.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class b extends ResponseBody {

        /* renamed from: b, reason: collision with root package name */
        public final ResponseBody f53442b;

        /* renamed from: c, reason: collision with root package name */
        public final BufferedSource f53443c;

        /* renamed from: d, reason: collision with root package name */
        public IOException f53444d;

        /* compiled from: OkHttpCall.java */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
        public class a extends ForwardingSource {
            public a(Source source) {
                super(source);
            }

            @Override // okio.ForwardingSource, okio.Source
            public long read(Buffer buffer, long j10) throws IOException {
                try {
                    return super.read(buffer, j10);
                } catch (IOException e2) {
                    b.this.f53444d = e2;
                    throw e2;
                }
            }
        }

        public b(ResponseBody responseBody) {
            this.f53442b = responseBody;
            this.f53443c = Okio.buffer(new a(responseBody.source()));
        }

        public void a() throws IOException {
            IOException iOException = this.f53444d;
            if (iOException != null) {
                throw iOException;
            }
        }

        @Override // okhttp3.ResponseBody, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f53442b.close();
        }

        @Override // okhttp3.ResponseBody
        public long contentLength() {
            return this.f53442b.contentLength();
        }

        @Override // okhttp3.ResponseBody
        public MediaType contentType() {
            return this.f53442b.contentType();
        }

        @Override // okhttp3.ResponseBody
        public BufferedSource source() {
            return this.f53443c;
        }
    }

    /* compiled from: OkHttpCall.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class c extends ResponseBody {

        /* renamed from: b, reason: collision with root package name */
        public final MediaType f53446b;

        /* renamed from: c, reason: collision with root package name */
        public final long f53447c;

        public c(MediaType mediaType, long j10) {
            this.f53446b = mediaType;
            this.f53447c = j10;
        }

        @Override // okhttp3.ResponseBody
        public long contentLength() {
            return this.f53447c;
        }

        @Override // okhttp3.ResponseBody
        public MediaType contentType() {
            return this.f53446b;
        }

        @Override // okhttp3.ResponseBody
        public BufferedSource source() {
            throw new IllegalStateException("Cannot read raw response body of a converted body.");
        }
    }

    public j(o oVar, Object[] objArr, Call.Factory factory, f<ResponseBody, T> fVar) {
        this.f53432b = oVar;
        this.f53433c = objArr;
        this.f53434d = factory;
        this.f53435e = fVar;
    }

    @Override // retrofit2.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public j<T> clone() {
        return new j<>(this.f53432b, this.f53433c, this.f53434d, this.f53435e);
    }

    @Override // retrofit2.b
    public void b(d<T> dVar) {
        Call call;
        Throwable th;
        t.b(dVar, "callback == null");
        synchronized (this) {
            if (!this.f53439i) {
                this.f53439i = true;
                call = this.f53437g;
                th = this.f53438h;
                if (call == null && th == null) {
                    try {
                        Call c4 = c();
                        this.f53437g = c4;
                        call = c4;
                    } catch (Throwable th2) {
                        th = th2;
                        t.t(th);
                        this.f53438h = th;
                    }
                }
            } else {
                throw new IllegalStateException("Already executed.");
            }
        }
        if (th != null) {
            dVar.a(this, th);
            return;
        }
        if (this.f53436f) {
            call.cancel();
        }
        call.enqueue(new a(dVar));
    }

    public final Call c() throws IOException {
        Call newCall = this.f53434d.newCall(this.f53432b.a(this.f53433c));
        Objects.requireNonNull(newCall, "Call.Factory returned null.");
        return newCall;
    }

    @Override // retrofit2.b
    public void cancel() {
        Call call;
        this.f53436f = true;
        synchronized (this) {
            call = this.f53437g;
        }
        if (call != null) {
            call.cancel();
        }
    }

    public Response<T> d(okhttp3.Response response) throws IOException {
        ResponseBody body = response.body();
        okhttp3.Response build = response.newBuilder().body(new c(body.contentType(), body.contentLength())).build();
        int code = build.code();
        if (code < 200 || code >= 300) {
            try {
                return Response.c(t.a(body), build);
            } finally {
                body.close();
            }
        }
        if (code != 204 && code != 205) {
            b bVar = new b(body);
            try {
                return Response.f(this.f53435e.convert(bVar), build);
            } catch (RuntimeException e2) {
                bVar.a();
                throw e2;
            }
        }
        body.close();
        return Response.f(null, build);
    }

    @Override // retrofit2.b
    public Response<T> execute() throws IOException {
        Call call;
        synchronized (this) {
            if (!this.f53439i) {
                this.f53439i = true;
                Throwable th = this.f53438h;
                if (th != null) {
                    if (!(th instanceof IOException)) {
                        if (th instanceof RuntimeException) {
                            throw ((RuntimeException) th);
                        }
                        throw ((Error) th);
                    }
                    throw ((IOException) th);
                }
                call = this.f53437g;
                if (call == null) {
                    try {
                        call = c();
                        this.f53437g = call;
                    } catch (IOException | Error | RuntimeException e2) {
                        t.t(e2);
                        this.f53438h = e2;
                        throw e2;
                    }
                }
            } else {
                throw new IllegalStateException("Already executed.");
            }
        }
        if (this.f53436f) {
            call.cancel();
        }
        return d(call.execute());
    }

    @Override // retrofit2.b
    public boolean isCanceled() {
        boolean z10 = true;
        if (this.f53436f) {
            return true;
        }
        synchronized (this) {
            Call call = this.f53437g;
            if (call == null || !call.isCanceled()) {
                z10 = false;
            }
        }
        return z10;
    }

    @Override // retrofit2.b
    public synchronized Request request() {
        Call call = this.f53437g;
        if (call != null) {
            return call.request();
        }
        Throwable th = this.f53438h;
        if (th != null) {
            if (!(th instanceof IOException)) {
                if (th instanceof RuntimeException) {
                    throw ((RuntimeException) th);
                }
                throw ((Error) th);
            }
            throw new RuntimeException("Unable to create request.", this.f53438h);
        }
        try {
            Call c4 = c();
            this.f53437g = c4;
            return c4.request();
        } catch (IOException e2) {
            this.f53438h = e2;
            throw new RuntimeException("Unable to create request.", e2);
        } catch (Error e10) {
            e = e10;
            t.t(e);
            this.f53438h = e;
            throw e;
        } catch (RuntimeException e11) {
            e = e11;
            t.t(e);
            this.f53438h = e;
            throw e;
        }
    }
}
