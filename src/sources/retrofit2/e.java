package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.CompletableFuture;
import retrofit2.c;

/* compiled from: CompletableFutureCallAdapterFactory.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class e extends c.a {

    /* renamed from: a, reason: collision with root package name */
    public static final c.a f53400a = new e();

    /* compiled from: CompletableFutureCallAdapterFactory.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class a<R> implements c<R, CompletableFuture<R>> {

        /* renamed from: a, reason: collision with root package name */
        public final Type f53401a;

        /* compiled from: CompletableFutureCallAdapterFactory.java */
        /* renamed from: retrofit2.e$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
        public class C0817a extends CompletableFuture<R> {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ retrofit2.b f53402b;

            public C0817a(retrofit2.b bVar) {
                this.f53402b = bVar;
            }

            @Override // java.util.concurrent.CompletableFuture, java.util.concurrent.Future
            public boolean cancel(boolean z10) {
                if (z10) {
                    this.f53402b.cancel();
                }
                return super.cancel(z10);
            }
        }

        /* compiled from: CompletableFutureCallAdapterFactory.java */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
        public class b implements d<R> {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ CompletableFuture f53404b;

            public b(CompletableFuture completableFuture) {
                this.f53404b = completableFuture;
            }

            @Override // retrofit2.d
            public void a(retrofit2.b<R> bVar, Throwable th) {
                this.f53404b.completeExceptionally(th);
            }

            @Override // retrofit2.d
            public void b(retrofit2.b<R> bVar, Response<R> response) {
                if (response.d()) {
                    this.f53404b.complete(response.a());
                } else {
                    this.f53404b.completeExceptionally(new HttpException(response));
                }
            }
        }

        public a(Type type) {
            this.f53401a = type;
        }

        @Override // retrofit2.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public CompletableFuture<R> a(retrofit2.b<R> bVar) {
            C0817a c0817a = new C0817a(bVar);
            bVar.b(new b(c0817a));
            return c0817a;
        }

        @Override // retrofit2.c
        public Type responseType() {
            return this.f53401a;
        }
    }

    /* compiled from: CompletableFutureCallAdapterFactory.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class b<R> implements c<R, CompletableFuture<Response<R>>> {

        /* renamed from: a, reason: collision with root package name */
        public final Type f53406a;

        /* compiled from: CompletableFutureCallAdapterFactory.java */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
        public class a extends CompletableFuture<Response<R>> {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ retrofit2.b f53407b;

            public a(retrofit2.b bVar) {
                this.f53407b = bVar;
            }

            @Override // java.util.concurrent.CompletableFuture, java.util.concurrent.Future
            public boolean cancel(boolean z10) {
                if (z10) {
                    this.f53407b.cancel();
                }
                return super.cancel(z10);
            }
        }

        /* compiled from: CompletableFutureCallAdapterFactory.java */
        /* renamed from: retrofit2.e$b$b, reason: collision with other inner class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
        public class C0818b implements d<R> {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ CompletableFuture f53409b;

            public C0818b(CompletableFuture completableFuture) {
                this.f53409b = completableFuture;
            }

            @Override // retrofit2.d
            public void a(retrofit2.b<R> bVar, Throwable th) {
                this.f53409b.completeExceptionally(th);
            }

            @Override // retrofit2.d
            public void b(retrofit2.b<R> bVar, Response<R> response) {
                this.f53409b.complete(response);
            }
        }

        public b(Type type) {
            this.f53406a = type;
        }

        @Override // retrofit2.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public CompletableFuture<Response<R>> a(retrofit2.b<R> bVar) {
            a aVar = new a(bVar);
            bVar.b(new C0818b(aVar));
            return aVar;
        }

        @Override // retrofit2.c
        public Type responseType() {
            return this.f53406a;
        }
    }

    @Override // retrofit2.c.a
    public c<?, ?> a(Type type, Annotation[] annotationArr, p pVar) {
        if (c.a.c(type) != CompletableFuture.class) {
            return null;
        }
        if (type instanceof ParameterizedType) {
            Type b4 = c.a.b(0, (ParameterizedType) type);
            if (c.a.c(b4) != Response.class) {
                return new a(b4);
            }
            if (b4 instanceof ParameterizedType) {
                return new b(c.a.b(0, (ParameterizedType) b4));
            }
            throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
        }
        throw new IllegalStateException("CompletableFuture return type must be parameterized as CompletableFuture<Foo> or CompletableFuture<? extends Foo>");
    }
}
