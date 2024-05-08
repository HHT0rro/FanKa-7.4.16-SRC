package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.a;
import retrofit2.c;
import retrofit2.f;

/* compiled from: Retrofit.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    public final Map<Method, q<?>> f53548a = new ConcurrentHashMap();

    /* renamed from: b, reason: collision with root package name */
    public final Call.Factory f53549b;

    /* renamed from: c, reason: collision with root package name */
    public final HttpUrl f53550c;

    /* renamed from: d, reason: collision with root package name */
    public final List<f.a> f53551d;

    /* renamed from: e, reason: collision with root package name */
    public final List<c.a> f53552e;

    /* renamed from: f, reason: collision with root package name */
    public final Executor f53553f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f53554g;

    /* compiled from: Retrofit.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class a implements InvocationHandler {

        /* renamed from: b, reason: collision with root package name */
        public final m f53555b = m.f();

        /* renamed from: c, reason: collision with root package name */
        public final Object[] f53556c = new Object[0];

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Class f53557d;

        public a(Class cls) {
            this.f53557d = cls;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            if (method.getDeclaringClass() == Object.class) {
                return method.invoke(this, objArr);
            }
            if (this.f53555b.h(method)) {
                return this.f53555b.g(method, this.f53557d, obj, objArr);
            }
            q<?> d10 = p.this.d(method);
            if (objArr == null) {
                objArr = this.f53556c;
            }
            return d10.a(objArr);
        }
    }

    public p(Call.Factory factory, HttpUrl httpUrl, List<f.a> list, List<c.a> list2, Executor executor, boolean z10) {
        this.f53549b = factory;
        this.f53550c = httpUrl;
        this.f53551d = list;
        this.f53552e = list2;
        this.f53553f = executor;
        this.f53554g = z10;
    }

    public c<?, ?> a(Type type, Annotation[] annotationArr) {
        return e(null, type, annotationArr);
    }

    public <T> T b(Class<T> cls) {
        t.v(cls);
        if (this.f53554g) {
            c(cls);
        }
        return (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new a(cls));
    }

    public final void c(Class<?> cls) {
        m f10 = m.f();
        for (Method method : cls.getDeclaredMethods()) {
            if (!f10.h(method) && !Modifier.isStatic(method.getModifiers())) {
                d(method);
            }
        }
    }

    public q<?> d(Method method) {
        q<?> qVar;
        q<?> qVar2 = this.f53548a.get(method);
        if (qVar2 != null) {
            return qVar2;
        }
        synchronized (this.f53548a) {
            qVar = this.f53548a.get(method);
            if (qVar == null) {
                qVar = q.b(this, method);
                this.f53548a.put(method, qVar);
            }
        }
        return qVar;
    }

    public c<?, ?> e(c.a aVar, Type type, Annotation[] annotationArr) {
        t.b(type, "returnType == null");
        t.b(annotationArr, "annotations == null");
        int indexOf = this.f53552e.indexOf(aVar) + 1;
        int size = this.f53552e.size();
        for (int i10 = indexOf; i10 < size; i10++) {
            c<?, ?> a10 = this.f53552e.get(i10).a(type, annotationArr, this);
            if (a10 != null) {
                return a10;
            }
        }
        StringBuilder sb2 = new StringBuilder("Could not locate call adapter for ");
        sb2.append((Object) type);
        sb2.append(".\n");
        if (aVar != null) {
            sb2.append("  Skipped:");
            for (int i11 = 0; i11 < indexOf; i11++) {
                sb2.append("\n   * ");
                sb2.append(this.f53552e.get(i11).getClass().getName());
            }
            sb2.append('\n');
        }
        sb2.append("  Tried:");
        int size2 = this.f53552e.size();
        while (indexOf < size2) {
            sb2.append("\n   * ");
            sb2.append(this.f53552e.get(indexOf).getClass().getName());
            indexOf++;
        }
        throw new IllegalArgumentException(sb2.toString());
    }

    public <T> f<T, RequestBody> f(f.a aVar, Type type, Annotation[] annotationArr, Annotation[] annotationArr2) {
        t.b(type, "type == null");
        t.b(annotationArr, "parameterAnnotations == null");
        t.b(annotationArr2, "methodAnnotations == null");
        int indexOf = this.f53551d.indexOf(aVar) + 1;
        int size = this.f53551d.size();
        for (int i10 = indexOf; i10 < size; i10++) {
            f<T, RequestBody> fVar = (f<T, RequestBody>) this.f53551d.get(i10).requestBodyConverter(type, annotationArr, annotationArr2, this);
            if (fVar != null) {
                return fVar;
            }
        }
        StringBuilder sb2 = new StringBuilder("Could not locate RequestBody converter for ");
        sb2.append((Object) type);
        sb2.append(".\n");
        if (aVar != null) {
            sb2.append("  Skipped:");
            for (int i11 = 0; i11 < indexOf; i11++) {
                sb2.append("\n   * ");
                sb2.append(this.f53551d.get(i11).getClass().getName());
            }
            sb2.append('\n');
        }
        sb2.append("  Tried:");
        int size2 = this.f53551d.size();
        while (indexOf < size2) {
            sb2.append("\n   * ");
            sb2.append(this.f53551d.get(indexOf).getClass().getName());
            indexOf++;
        }
        throw new IllegalArgumentException(sb2.toString());
    }

    public <T> f<ResponseBody, T> g(f.a aVar, Type type, Annotation[] annotationArr) {
        t.b(type, "type == null");
        t.b(annotationArr, "annotations == null");
        int indexOf = this.f53551d.indexOf(aVar) + 1;
        int size = this.f53551d.size();
        for (int i10 = indexOf; i10 < size; i10++) {
            f<ResponseBody, T> fVar = (f<ResponseBody, T>) this.f53551d.get(i10).responseBodyConverter(type, annotationArr, this);
            if (fVar != null) {
                return fVar;
            }
        }
        StringBuilder sb2 = new StringBuilder("Could not locate ResponseBody converter for ");
        sb2.append((Object) type);
        sb2.append(".\n");
        if (aVar != null) {
            sb2.append("  Skipped:");
            for (int i11 = 0; i11 < indexOf; i11++) {
                sb2.append("\n   * ");
                sb2.append(this.f53551d.get(i11).getClass().getName());
            }
            sb2.append('\n');
        }
        sb2.append("  Tried:");
        int size2 = this.f53551d.size();
        while (indexOf < size2) {
            sb2.append("\n   * ");
            sb2.append(this.f53551d.get(indexOf).getClass().getName());
            indexOf++;
        }
        throw new IllegalArgumentException(sb2.toString());
    }

    public <T> f<T, RequestBody> h(Type type, Annotation[] annotationArr, Annotation[] annotationArr2) {
        return f(null, type, annotationArr, annotationArr2);
    }

    public <T> f<ResponseBody, T> i(Type type, Annotation[] annotationArr) {
        return g(null, type, annotationArr);
    }

    public <T> f<T, String> j(Type type, Annotation[] annotationArr) {
        t.b(type, "type == null");
        t.b(annotationArr, "annotations == null");
        int size = this.f53551d.size();
        for (int i10 = 0; i10 < size; i10++) {
            f<T, String> fVar = (f<T, String>) this.f53551d.get(i10).stringConverter(type, annotationArr, this);
            if (fVar != null) {
                return fVar;
            }
        }
        return a.d.f53397a;
    }

    /* compiled from: Retrofit.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final m f53559a;

        /* renamed from: b, reason: collision with root package name */
        public Call.Factory f53560b;

        /* renamed from: c, reason: collision with root package name */
        public HttpUrl f53561c;

        /* renamed from: d, reason: collision with root package name */
        public final List<f.a> f53562d;

        /* renamed from: e, reason: collision with root package name */
        public final List<c.a> f53563e;

        /* renamed from: f, reason: collision with root package name */
        public Executor f53564f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f53565g;

        public b(m mVar) {
            this.f53562d = new ArrayList();
            this.f53563e = new ArrayList();
            this.f53559a = mVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b a(c.a aVar) {
            this.f53563e.add(t.b(aVar, "factory == null"));
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b b(f.a aVar) {
            this.f53562d.add(t.b(aVar, "factory == null"));
            return this;
        }

        public b c(String str) {
            t.b(str, "baseUrl == null");
            return d(HttpUrl.get(str));
        }

        public b d(HttpUrl httpUrl) {
            t.b(httpUrl, "baseUrl == null");
            if ("".equals(httpUrl.pathSegments().get(r0.size() - 1))) {
                this.f53561c = httpUrl;
                return this;
            }
            throw new IllegalArgumentException("baseUrl must end in /: " + ((Object) httpUrl));
        }

        public p e() {
            if (this.f53561c != null) {
                Call.Factory factory = this.f53560b;
                if (factory == null) {
                    factory = new OkHttpClient();
                }
                Call.Factory factory2 = factory;
                Executor executor = this.f53564f;
                if (executor == null) {
                    executor = this.f53559a.b();
                }
                Executor executor2 = executor;
                ArrayList arrayList = new ArrayList(this.f53563e);
                arrayList.addAll(this.f53559a.a(executor2));
                ArrayList arrayList2 = new ArrayList(this.f53562d.size() + 1 + this.f53559a.d());
                arrayList2.add(new retrofit2.a());
                arrayList2.addAll(this.f53562d);
                arrayList2.addAll(this.f53559a.c());
                return new p(factory2, this.f53561c, Collections.unmodifiableList(arrayList2), Collections.unmodifiableList(arrayList), executor2, this.f53565g);
            }
            throw new IllegalStateException("Base URL required.");
        }

        public b f(Call.Factory factory) {
            this.f53560b = (Call.Factory) t.b(factory, "factory == null");
            return this;
        }

        public b g(OkHttpClient okHttpClient) {
            return f((Call.Factory) t.b(okHttpClient, "client == null"));
        }

        public b() {
            this(m.f());
        }
    }
}
