package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import kotlin.coroutines.Continuation;
import okhttp3.Call;
import okhttp3.ResponseBody;
import retrofit2.t;

/* compiled from: HttpServiceMethod.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class h<ResponseT, ReturnT> extends q<ReturnT> {

    /* renamed from: a, reason: collision with root package name */
    public final o f53423a;

    /* renamed from: b, reason: collision with root package name */
    public final Call.Factory f53424b;

    /* renamed from: c, reason: collision with root package name */
    public final f<ResponseBody, ResponseT> f53425c;

    /* compiled from: HttpServiceMethod.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class a<ResponseT, ReturnT> extends h<ResponseT, ReturnT> {

        /* renamed from: d, reason: collision with root package name */
        public final retrofit2.c<ResponseT, ReturnT> f53426d;

        public a(o oVar, Call.Factory factory, f<ResponseBody, ResponseT> fVar, retrofit2.c<ResponseT, ReturnT> cVar) {
            super(oVar, factory, fVar);
            this.f53426d = cVar;
        }

        @Override // retrofit2.h
        public ReturnT c(retrofit2.b<ResponseT> bVar, Object[] objArr) {
            return this.f53426d.a(bVar);
        }
    }

    /* compiled from: HttpServiceMethod.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class b<ResponseT> extends h<ResponseT, Object> {

        /* renamed from: d, reason: collision with root package name */
        public final retrofit2.c<ResponseT, retrofit2.b<ResponseT>> f53427d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f53428e;

        public b(o oVar, Call.Factory factory, f<ResponseBody, ResponseT> fVar, retrofit2.c<ResponseT, retrofit2.b<ResponseT>> cVar, boolean z10) {
            super(oVar, factory, fVar);
            this.f53427d = cVar;
            this.f53428e = z10;
        }

        @Override // retrofit2.h
        public Object c(retrofit2.b<ResponseT> bVar, Object[] objArr) {
            retrofit2.b<ResponseT> a10 = this.f53427d.a(bVar);
            Continuation continuation = (Continuation) objArr[objArr.length - 1];
            try {
                if (this.f53428e) {
                    return KotlinExtensions.b(a10, continuation);
                }
                return KotlinExtensions.a(a10, continuation);
            } catch (Exception e2) {
                return KotlinExtensions.d(e2, continuation);
            }
        }
    }

    /* compiled from: HttpServiceMethod.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class c<ResponseT> extends h<ResponseT, Object> {

        /* renamed from: d, reason: collision with root package name */
        public final retrofit2.c<ResponseT, retrofit2.b<ResponseT>> f53429d;

        public c(o oVar, Call.Factory factory, f<ResponseBody, ResponseT> fVar, retrofit2.c<ResponseT, retrofit2.b<ResponseT>> cVar) {
            super(oVar, factory, fVar);
            this.f53429d = cVar;
        }

        @Override // retrofit2.h
        public Object c(retrofit2.b<ResponseT> bVar, Object[] objArr) {
            return KotlinExtensions.c(this.f53429d.a(bVar), (Continuation) objArr[objArr.length - 1]);
        }
    }

    public h(o oVar, Call.Factory factory, f<ResponseBody, ResponseT> fVar) {
        this.f53423a = oVar;
        this.f53424b = factory;
        this.f53425c = fVar;
    }

    public static <ResponseT, ReturnT> retrofit2.c<ResponseT, ReturnT> d(p pVar, Method method, Type type, Annotation[] annotationArr) {
        try {
            return (retrofit2.c<ResponseT, ReturnT>) pVar.a(type, annotationArr);
        } catch (RuntimeException e2) {
            throw t.o(method, e2, "Unable to create call adapter for %s", type);
        }
    }

    public static <ResponseT> f<ResponseBody, ResponseT> e(p pVar, Method method, Type type) {
        try {
            return pVar.i(type, method.getAnnotations());
        } catch (RuntimeException e2) {
            throw t.o(method, e2, "Unable to create converter for %s", type);
        }
    }

    public static <ResponseT, ReturnT> h<ResponseT, ReturnT> f(p pVar, Method method, o oVar) {
        Type genericReturnType;
        boolean z10;
        boolean z11 = oVar.f53522k;
        Annotation[] annotations = method.getAnnotations();
        if (z11) {
            Type[] genericParameterTypes = method.getGenericParameterTypes();
            Type g3 = t.g(0, (ParameterizedType) genericParameterTypes[genericParameterTypes.length - 1]);
            if (t.i(g3) == Response.class && (g3 instanceof ParameterizedType)) {
                g3 = t.h(0, (ParameterizedType) g3);
                z10 = true;
            } else {
                z10 = false;
            }
            genericReturnType = new t.b(null, retrofit2.b.class, g3);
            annotations = s.a(annotations);
        } else {
            genericReturnType = method.getGenericReturnType();
            z10 = false;
        }
        retrofit2.c d10 = d(pVar, method, genericReturnType, annotations);
        Type responseType = d10.responseType();
        if (responseType != okhttp3.Response.class) {
            if (responseType != Response.class) {
                if (oVar.f53514c.equals("HEAD") && !Void.class.equals(responseType)) {
                    throw t.n(method, "HEAD method must use Void as response type.", new Object[0]);
                }
                f e2 = e(pVar, method, responseType);
                Call.Factory factory = pVar.f53549b;
                if (!z11) {
                    return new a(oVar, factory, e2, d10);
                }
                if (z10) {
                    return new c(oVar, factory, e2, d10);
                }
                return new b(oVar, factory, e2, d10, false);
            }
            throw t.n(method, "Response must include generic type (e.g., Response<String>)", new Object[0]);
        }
        throw t.n(method, "'" + t.i(responseType).getName() + "' is not a valid response body type. Did you mean ResponseBody?", new Object[0]);
    }

    @Override // retrofit2.q
    public final ReturnT a(Object[] objArr) {
        return c(new j(this.f53423a, objArr, this.f53424b, this.f53425c), objArr);
    }

    public abstract ReturnT c(retrofit2.b<ResponseT> bVar, Object[] objArr);
}
