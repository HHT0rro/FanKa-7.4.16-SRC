package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.Executor;
import okhttp3.Request;
import retrofit2.c;

/* compiled from: DefaultCallAdapterFactory.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class g extends c.a {

    /* renamed from: a, reason: collision with root package name */
    public final Executor f53411a;

    /* compiled from: DefaultCallAdapterFactory.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class a implements c<Object, retrofit2.b<?>> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Type f53412a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Executor f53413b;

        public a(Type type, Executor executor) {
            this.f53412a = type;
            this.f53413b = executor;
        }

        @Override // retrofit2.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public retrofit2.b<Object> a(retrofit2.b<Object> bVar) {
            Executor executor = this.f53413b;
            return executor == null ? bVar : new b(executor, bVar);
        }

        @Override // retrofit2.c
        public Type responseType() {
            return this.f53412a;
        }
    }

    /* compiled from: DefaultCallAdapterFactory.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class b<T> implements retrofit2.b<T> {

        /* renamed from: b, reason: collision with root package name */
        public final Executor f53415b;

        /* renamed from: c, reason: collision with root package name */
        public final retrofit2.b<T> f53416c;

        /* compiled from: DefaultCallAdapterFactory.java */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
        public class a implements d<T> {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ d f53417b;

            /* compiled from: DefaultCallAdapterFactory.java */
            /* renamed from: retrofit2.g$b$a$a, reason: collision with other inner class name */
            /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
            public class RunnableC0819a implements Runnable {

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ Response f53419b;

                public RunnableC0819a(Response response) {
                    this.f53419b = response;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.f53416c.isCanceled()) {
                        a aVar = a.this;
                        aVar.f53417b.a(b.this, new IOException("Canceled"));
                    } else {
                        a aVar2 = a.this;
                        aVar2.f53417b.b(b.this, this.f53419b);
                    }
                }
            }

            /* compiled from: DefaultCallAdapterFactory.java */
            /* renamed from: retrofit2.g$b$a$b, reason: collision with other inner class name */
            /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
            public class RunnableC0820b implements Runnable {

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ Throwable f53421b;

                public RunnableC0820b(Throwable th) {
                    this.f53421b = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    a aVar = a.this;
                    aVar.f53417b.a(b.this, this.f53421b);
                }
            }

            public a(d dVar) {
                this.f53417b = dVar;
            }

            @Override // retrofit2.d
            public void a(retrofit2.b<T> bVar, Throwable th) {
                b.this.f53415b.execute(new RunnableC0820b(th));
            }

            @Override // retrofit2.d
            public void b(retrofit2.b<T> bVar, Response<T> response) {
                b.this.f53415b.execute(new RunnableC0819a(response));
            }
        }

        public b(Executor executor, retrofit2.b<T> bVar) {
            this.f53415b = executor;
            this.f53416c = bVar;
        }

        @Override // retrofit2.b
        public void b(d<T> dVar) {
            t.b(dVar, "callback == null");
            this.f53416c.b(new a(dVar));
        }

        @Override // retrofit2.b
        public void cancel() {
            this.f53416c.cancel();
        }

        @Override // retrofit2.b
        public Response<T> execute() throws IOException {
            return this.f53416c.execute();
        }

        @Override // retrofit2.b
        public boolean isCanceled() {
            return this.f53416c.isCanceled();
        }

        @Override // retrofit2.b
        public Request request() {
            return this.f53416c.request();
        }

        @Override // retrofit2.b
        public retrofit2.b<T> clone() {
            return new b(this.f53415b, this.f53416c.clone());
        }
    }

    public g(Executor executor) {
        this.f53411a = executor;
    }

    @Override // retrofit2.c.a
    public c<?, ?> a(Type type, Annotation[] annotationArr, p pVar) {
        if (c.a.c(type) != retrofit2.b.class) {
            return null;
        }
        if (type instanceof ParameterizedType) {
            return new a(t.h(0, (ParameterizedType) type), t.m(annotationArr, r.class) ? null : this.f53411a);
        }
        throw new IllegalArgumentException("Call return type must be parameterized as Call<Foo> or Call<? extends Foo>");
    }
}
