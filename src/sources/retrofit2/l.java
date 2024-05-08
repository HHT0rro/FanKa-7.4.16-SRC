package retrofit2;

import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;
import okhttp3.Headers;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/* compiled from: ParameterHandler.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class l<T> {

    /* compiled from: ParameterHandler.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class a extends l<Iterable<T>> {
        public a() {
        }

        @Override // retrofit2.l
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(retrofit2.n nVar, Iterable<T> iterable) throws IOException {
            if (iterable == null) {
                return;
            }
            Iterator<T> iterator2 = iterable.iterator2();
            while (iterator2.hasNext()) {
                l.this.a(nVar, iterator2.next());
            }
        }
    }

    /* compiled from: ParameterHandler.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class b extends l<Object> {
        public b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // retrofit2.l
        public void a(retrofit2.n nVar, Object obj) throws IOException {
            if (obj == null) {
                return;
            }
            int length = Array.getLength(obj);
            for (int i10 = 0; i10 < length; i10++) {
                l.this.a(nVar, Array.get(obj, i10));
            }
        }
    }

    /* compiled from: ParameterHandler.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class c<T> extends l<T> {

        /* renamed from: a, reason: collision with root package name */
        public final Method f53452a;

        /* renamed from: b, reason: collision with root package name */
        public final int f53453b;

        /* renamed from: c, reason: collision with root package name */
        public final retrofit2.f<T, RequestBody> f53454c;

        public c(Method method, int i10, retrofit2.f<T, RequestBody> fVar) {
            this.f53452a = method;
            this.f53453b = i10;
            this.f53454c = fVar;
        }

        @Override // retrofit2.l
        public void a(retrofit2.n nVar, T t2) {
            if (t2 != null) {
                try {
                    nVar.l(this.f53454c.convert(t2));
                    return;
                } catch (IOException e2) {
                    throw t.q(this.f53452a, e2, this.f53453b, "Unable to convert " + ((Object) t2) + " to RequestBody", new Object[0]);
                }
            }
            throw t.p(this.f53452a, this.f53453b, "Body parameter value must not be null.", new Object[0]);
        }
    }

    /* compiled from: ParameterHandler.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class d<T> extends l<T> {

        /* renamed from: a, reason: collision with root package name */
        public final String f53455a;

        /* renamed from: b, reason: collision with root package name */
        public final retrofit2.f<T, String> f53456b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f53457c;

        public d(String str, retrofit2.f<T, String> fVar, boolean z10) {
            this.f53455a = (String) t.b(str, "name == null");
            this.f53456b = fVar;
            this.f53457c = z10;
        }

        @Override // retrofit2.l
        public void a(retrofit2.n nVar, T t2) throws IOException {
            String convert;
            if (t2 == null || (convert = this.f53456b.convert(t2)) == null) {
                return;
            }
            nVar.a(this.f53455a, convert, this.f53457c);
        }
    }

    /* compiled from: ParameterHandler.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class e<T> extends l<Map<String, T>> {

        /* renamed from: a, reason: collision with root package name */
        public final Method f53458a;

        /* renamed from: b, reason: collision with root package name */
        public final int f53459b;

        /* renamed from: c, reason: collision with root package name */
        public final retrofit2.f<T, String> f53460c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f53461d;

        public e(Method method, int i10, retrofit2.f<T, String> fVar, boolean z10) {
            this.f53458a = method;
            this.f53459b = i10;
            this.f53460c = fVar;
            this.f53461d = z10;
        }

        @Override // retrofit2.l
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(retrofit2.n nVar, Map<String, T> map) throws IOException {
            if (map != null) {
                for (Map.Entry<String, T> entry : map.entrySet()) {
                    String key = entry.getKey();
                    if (key != null) {
                        T value = entry.getValue();
                        if (value == null) {
                            throw t.p(this.f53458a, this.f53459b, "Field map contained null value for key '" + key + "'.", new Object[0]);
                        }
                        String convert = this.f53460c.convert(value);
                        if (convert != null) {
                            nVar.a(key, convert, this.f53461d);
                        } else {
                            throw t.p(this.f53458a, this.f53459b, "Field map value '" + ((Object) value) + "' converted to null by " + this.f53460c.getClass().getName() + " for key '" + key + "'.", new Object[0]);
                        }
                    } else {
                        throw t.p(this.f53458a, this.f53459b, "Field map contained null key.", new Object[0]);
                    }
                }
                return;
            }
            throw t.p(this.f53458a, this.f53459b, "Field map was null.", new Object[0]);
        }
    }

    /* compiled from: ParameterHandler.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class f<T> extends l<T> {

        /* renamed from: a, reason: collision with root package name */
        public final String f53462a;

        /* renamed from: b, reason: collision with root package name */
        public final retrofit2.f<T, String> f53463b;

        public f(String str, retrofit2.f<T, String> fVar) {
            this.f53462a = (String) t.b(str, "name == null");
            this.f53463b = fVar;
        }

        @Override // retrofit2.l
        public void a(retrofit2.n nVar, T t2) throws IOException {
            String convert;
            if (t2 == null || (convert = this.f53463b.convert(t2)) == null) {
                return;
            }
            nVar.b(this.f53462a, convert);
        }
    }

    /* compiled from: ParameterHandler.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class g<T> extends l<Map<String, T>> {

        /* renamed from: a, reason: collision with root package name */
        public final Method f53464a;

        /* renamed from: b, reason: collision with root package name */
        public final int f53465b;

        /* renamed from: c, reason: collision with root package name */
        public final retrofit2.f<T, String> f53466c;

        public g(Method method, int i10, retrofit2.f<T, String> fVar) {
            this.f53464a = method;
            this.f53465b = i10;
            this.f53466c = fVar;
        }

        @Override // retrofit2.l
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(retrofit2.n nVar, Map<String, T> map) throws IOException {
            if (map != null) {
                for (Map.Entry<String, T> entry : map.entrySet()) {
                    String key = entry.getKey();
                    if (key != null) {
                        T value = entry.getValue();
                        if (value == null) {
                            throw t.p(this.f53464a, this.f53465b, "Header map contained null value for key '" + key + "'.", new Object[0]);
                        }
                        nVar.b(key, this.f53466c.convert(value));
                    } else {
                        throw t.p(this.f53464a, this.f53465b, "Header map contained null key.", new Object[0]);
                    }
                }
                return;
            }
            throw t.p(this.f53464a, this.f53465b, "Header map was null.", new Object[0]);
        }
    }

    /* compiled from: ParameterHandler.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class h extends l<Headers> {

        /* renamed from: a, reason: collision with root package name */
        public final Method f53467a;

        /* renamed from: b, reason: collision with root package name */
        public final int f53468b;

        public h(Method method, int i10) {
            this.f53467a = method;
            this.f53468b = i10;
        }

        @Override // retrofit2.l
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(retrofit2.n nVar, Headers headers) {
            if (headers != null) {
                nVar.c(headers);
                return;
            }
            throw t.p(this.f53467a, this.f53468b, "Headers parameter must not be null.", new Object[0]);
        }
    }

    /* compiled from: ParameterHandler.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class i<T> extends l<T> {

        /* renamed from: a, reason: collision with root package name */
        public final Method f53469a;

        /* renamed from: b, reason: collision with root package name */
        public final int f53470b;

        /* renamed from: c, reason: collision with root package name */
        public final Headers f53471c;

        /* renamed from: d, reason: collision with root package name */
        public final retrofit2.f<T, RequestBody> f53472d;

        public i(Method method, int i10, Headers headers, retrofit2.f<T, RequestBody> fVar) {
            this.f53469a = method;
            this.f53470b = i10;
            this.f53471c = headers;
            this.f53472d = fVar;
        }

        @Override // retrofit2.l
        public void a(retrofit2.n nVar, T t2) {
            if (t2 == null) {
                return;
            }
            try {
                nVar.d(this.f53471c, this.f53472d.convert(t2));
            } catch (IOException e2) {
                throw t.p(this.f53469a, this.f53470b, "Unable to convert " + ((Object) t2) + " to RequestBody", e2);
            }
        }
    }

    /* compiled from: ParameterHandler.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class j<T> extends l<Map<String, T>> {

        /* renamed from: a, reason: collision with root package name */
        public final Method f53473a;

        /* renamed from: b, reason: collision with root package name */
        public final int f53474b;

        /* renamed from: c, reason: collision with root package name */
        public final retrofit2.f<T, RequestBody> f53475c;

        /* renamed from: d, reason: collision with root package name */
        public final String f53476d;

        public j(Method method, int i10, retrofit2.f<T, RequestBody> fVar, String str) {
            this.f53473a = method;
            this.f53474b = i10;
            this.f53475c = fVar;
            this.f53476d = str;
        }

        @Override // retrofit2.l
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(retrofit2.n nVar, Map<String, T> map) throws IOException {
            if (map != null) {
                for (Map.Entry<String, T> entry : map.entrySet()) {
                    String key = entry.getKey();
                    if (key != null) {
                        T value = entry.getValue();
                        if (value == null) {
                            throw t.p(this.f53473a, this.f53474b, "Part map contained null value for key '" + key + "'.", new Object[0]);
                        }
                        nVar.d(Headers.of("Content-Disposition", "form-data; name=\"" + key + "\"", "Content-Transfer-Encoding", this.f53476d), this.f53475c.convert(value));
                    } else {
                        throw t.p(this.f53473a, this.f53474b, "Part map contained null key.", new Object[0]);
                    }
                }
                return;
            }
            throw t.p(this.f53473a, this.f53474b, "Part map was null.", new Object[0]);
        }
    }

    /* compiled from: ParameterHandler.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class k<T> extends l<T> {

        /* renamed from: a, reason: collision with root package name */
        public final Method f53477a;

        /* renamed from: b, reason: collision with root package name */
        public final int f53478b;

        /* renamed from: c, reason: collision with root package name */
        public final String f53479c;

        /* renamed from: d, reason: collision with root package name */
        public final retrofit2.f<T, String> f53480d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f53481e;

        public k(Method method, int i10, String str, retrofit2.f<T, String> fVar, boolean z10) {
            this.f53477a = method;
            this.f53478b = i10;
            this.f53479c = (String) t.b(str, "name == null");
            this.f53480d = fVar;
            this.f53481e = z10;
        }

        @Override // retrofit2.l
        public void a(retrofit2.n nVar, T t2) throws IOException {
            if (t2 != null) {
                nVar.f(this.f53479c, this.f53480d.convert(t2), this.f53481e);
                return;
            }
            throw t.p(this.f53477a, this.f53478b, "Path parameter \"" + this.f53479c + "\" value must not be null.", new Object[0]);
        }
    }

    /* compiled from: ParameterHandler.java */
    /* renamed from: retrofit2.l$l, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class C0821l<T> extends l<T> {

        /* renamed from: a, reason: collision with root package name */
        public final String f53482a;

        /* renamed from: b, reason: collision with root package name */
        public final retrofit2.f<T, String> f53483b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f53484c;

        public C0821l(String str, retrofit2.f<T, String> fVar, boolean z10) {
            this.f53482a = (String) t.b(str, "name == null");
            this.f53483b = fVar;
            this.f53484c = z10;
        }

        @Override // retrofit2.l
        public void a(retrofit2.n nVar, T t2) throws IOException {
            String convert;
            if (t2 == null || (convert = this.f53483b.convert(t2)) == null) {
                return;
            }
            nVar.g(this.f53482a, convert, this.f53484c);
        }
    }

    /* compiled from: ParameterHandler.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class m<T> extends l<Map<String, T>> {

        /* renamed from: a, reason: collision with root package name */
        public final Method f53485a;

        /* renamed from: b, reason: collision with root package name */
        public final int f53486b;

        /* renamed from: c, reason: collision with root package name */
        public final retrofit2.f<T, String> f53487c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f53488d;

        public m(Method method, int i10, retrofit2.f<T, String> fVar, boolean z10) {
            this.f53485a = method;
            this.f53486b = i10;
            this.f53487c = fVar;
            this.f53488d = z10;
        }

        @Override // retrofit2.l
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(retrofit2.n nVar, Map<String, T> map) throws IOException {
            if (map != null) {
                for (Map.Entry<String, T> entry : map.entrySet()) {
                    String key = entry.getKey();
                    if (key != null) {
                        T value = entry.getValue();
                        if (value == null) {
                            throw t.p(this.f53485a, this.f53486b, "Query map contained null value for key '" + key + "'.", new Object[0]);
                        }
                        String convert = this.f53487c.convert(value);
                        if (convert != null) {
                            nVar.g(key, convert, this.f53488d);
                        } else {
                            throw t.p(this.f53485a, this.f53486b, "Query map value '" + ((Object) value) + "' converted to null by " + this.f53487c.getClass().getName() + " for key '" + key + "'.", new Object[0]);
                        }
                    } else {
                        throw t.p(this.f53485a, this.f53486b, "Query map contained null key.", new Object[0]);
                    }
                }
                return;
            }
            throw t.p(this.f53485a, this.f53486b, "Query map was null", new Object[0]);
        }
    }

    /* compiled from: ParameterHandler.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class n<T> extends l<T> {

        /* renamed from: a, reason: collision with root package name */
        public final retrofit2.f<T, String> f53489a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f53490b;

        public n(retrofit2.f<T, String> fVar, boolean z10) {
            this.f53489a = fVar;
            this.f53490b = z10;
        }

        @Override // retrofit2.l
        public void a(retrofit2.n nVar, T t2) throws IOException {
            if (t2 == null) {
                return;
            }
            nVar.g(this.f53489a.convert(t2), null, this.f53490b);
        }
    }

    /* compiled from: ParameterHandler.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class o extends l<MultipartBody.Part> {

        /* renamed from: a, reason: collision with root package name */
        public static final o f53491a = new o();

        @Override // retrofit2.l
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(retrofit2.n nVar, MultipartBody.Part part) {
            if (part != null) {
                nVar.e(part);
            }
        }
    }

    /* compiled from: ParameterHandler.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class p extends l<Object> {

        /* renamed from: a, reason: collision with root package name */
        public final Method f53492a;

        /* renamed from: b, reason: collision with root package name */
        public final int f53493b;

        public p(Method method, int i10) {
            this.f53492a = method;
            this.f53493b = i10;
        }

        @Override // retrofit2.l
        public void a(retrofit2.n nVar, Object obj) {
            if (obj != null) {
                nVar.m(obj);
                return;
            }
            throw t.p(this.f53492a, this.f53493b, "@Url parameter is null.", new Object[0]);
        }
    }

    /* compiled from: ParameterHandler.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class q<T> extends l<T> {

        /* renamed from: a, reason: collision with root package name */
        public final Class<T> f53494a;

        public q(Class<T> cls) {
            this.f53494a = cls;
        }

        @Override // retrofit2.l
        public void a(retrofit2.n nVar, T t2) {
            nVar.h(this.f53494a, t2);
        }
    }

    public abstract void a(retrofit2.n nVar, T t2) throws IOException;

    public final l<Object> b() {
        return new b();
    }

    public final l<Iterable<T>> c() {
        return new a();
    }
}
