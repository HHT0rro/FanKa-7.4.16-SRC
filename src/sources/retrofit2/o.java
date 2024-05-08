package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.URI;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.coroutines.Continuation;
import ne.u;
import ne.v;
import ne.x;
import ne.y;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import retrofit2.l;

/* compiled from: RequestFactory.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public final Method f53512a;

    /* renamed from: b, reason: collision with root package name */
    public final HttpUrl f53513b;

    /* renamed from: c, reason: collision with root package name */
    public final String f53514c;

    /* renamed from: d, reason: collision with root package name */
    public final String f53515d;

    /* renamed from: e, reason: collision with root package name */
    public final Headers f53516e;

    /* renamed from: f, reason: collision with root package name */
    public final MediaType f53517f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f53518g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f53519h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f53520i;

    /* renamed from: j, reason: collision with root package name */
    public final l<?>[] f53521j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f53522k;

    /* compiled from: RequestFactory.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class a {

        /* renamed from: x, reason: collision with root package name */
        public static final Pattern f53523x = Pattern.compile("\\{([a-zA-Z][a-zA-Z0-9_-]*)\\}");

        /* renamed from: y, reason: collision with root package name */
        public static final Pattern f53524y = Pattern.compile("[a-zA-Z][a-zA-Z0-9_-]*");

        /* renamed from: a, reason: collision with root package name */
        public final p f53525a;

        /* renamed from: b, reason: collision with root package name */
        public final Method f53526b;

        /* renamed from: c, reason: collision with root package name */
        public final Annotation[] f53527c;

        /* renamed from: d, reason: collision with root package name */
        public final Annotation[][] f53528d;

        /* renamed from: e, reason: collision with root package name */
        public final Type[] f53529e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f53530f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f53531g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f53532h;

        /* renamed from: i, reason: collision with root package name */
        public boolean f53533i;

        /* renamed from: j, reason: collision with root package name */
        public boolean f53534j;

        /* renamed from: k, reason: collision with root package name */
        public boolean f53535k;

        /* renamed from: l, reason: collision with root package name */
        public boolean f53536l;

        /* renamed from: m, reason: collision with root package name */
        public boolean f53537m;

        /* renamed from: n, reason: collision with root package name */
        public String f53538n;

        /* renamed from: o, reason: collision with root package name */
        public boolean f53539o;

        /* renamed from: p, reason: collision with root package name */
        public boolean f53540p;

        /* renamed from: q, reason: collision with root package name */
        public boolean f53541q;

        /* renamed from: r, reason: collision with root package name */
        public String f53542r;

        /* renamed from: s, reason: collision with root package name */
        public Headers f53543s;

        /* renamed from: t, reason: collision with root package name */
        public MediaType f53544t;

        /* renamed from: u, reason: collision with root package name */
        public Set<String> f53545u;

        /* renamed from: v, reason: collision with root package name */
        public l<?>[] f53546v;

        /* renamed from: w, reason: collision with root package name */
        public boolean f53547w;

        public a(p pVar, Method method) {
            this.f53525a = pVar;
            this.f53526b = method;
            this.f53527c = method.getAnnotations();
            this.f53529e = method.getGenericParameterTypes();
            this.f53528d = method.getParameterAnnotations();
        }

        public static Class<?> a(Class<?> cls) {
            return Boolean.TYPE == cls ? Boolean.class : Byte.TYPE == cls ? Byte.class : Character.TYPE == cls ? Character.class : Double.TYPE == cls ? Double.class : Float.TYPE == cls ? Float.class : Integer.TYPE == cls ? Integer.class : Long.TYPE == cls ? Long.class : Short.TYPE == cls ? Short.class : cls;
        }

        public static Set<String> h(String str) {
            Matcher matcher = f53523x.matcher(str);
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            while (matcher.find()) {
                linkedHashSet.add(matcher.group(1));
            }
            return linkedHashSet;
        }

        public o b() {
            for (Annotation annotation : this.f53527c) {
                e(annotation);
            }
            if (this.f53538n != null) {
                if (!this.f53539o) {
                    if (!this.f53541q) {
                        if (this.f53540p) {
                            throw t.n(this.f53526b, "FormUrlEncoded can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
                        }
                    } else {
                        throw t.n(this.f53526b, "Multipart can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
                    }
                }
                int length = this.f53528d.length;
                this.f53546v = new l[length];
                int i10 = length - 1;
                int i11 = 0;
                while (true) {
                    boolean z10 = true;
                    if (i11 >= length) {
                        break;
                    }
                    l<?>[] lVarArr = this.f53546v;
                    Type type = this.f53529e[i11];
                    Annotation[] annotationArr = this.f53528d[i11];
                    if (i11 != i10) {
                        z10 = false;
                    }
                    lVarArr[i11] = f(i11, type, annotationArr, z10);
                    i11++;
                }
                if (this.f53542r == null && !this.f53537m) {
                    throw t.n(this.f53526b, "Missing either @%s URL or @Url parameter.", this.f53538n);
                }
                boolean z11 = this.f53540p;
                if (!z11 && !this.f53541q && !this.f53539o && this.f53532h) {
                    throw t.n(this.f53526b, "Non-body HTTP method cannot contain @Body.", new Object[0]);
                }
                if (z11 && !this.f53530f) {
                    throw t.n(this.f53526b, "Form-encoded method must contain at least one @Field.", new Object[0]);
                }
                if (this.f53541q && !this.f53531g) {
                    throw t.n(this.f53526b, "Multipart method must contain at least one @Part.", new Object[0]);
                }
                return new o(this);
            }
            throw t.n(this.f53526b, "HTTP method annotation is required (e.g., @GET, @POST, etc.).", new Object[0]);
        }

        public final Headers c(String[] strArr) {
            Headers.Builder builder = new Headers.Builder();
            for (String str : strArr) {
                int indexOf = str.indexOf(58);
                if (indexOf == -1 || indexOf == 0 || indexOf == str.length() - 1) {
                    throw t.n(this.f53526b, "@Headers value must be in the form \"Name: Value\". Found: \"%s\"", str);
                }
                String substring = str.substring(0, indexOf);
                String trim = str.substring(indexOf + 1).trim();
                if ("Content-Type".equalsIgnoreCase(substring)) {
                    try {
                        this.f53544t = MediaType.get(trim);
                    } catch (IllegalArgumentException e2) {
                        throw t.o(this.f53526b, e2, "Malformed content type: %s", trim);
                    }
                } else {
                    builder.add(substring, trim);
                }
            }
            return builder.build();
        }

        public final void d(String str, String str2, boolean z10) {
            String str3 = this.f53538n;
            if (str3 != null) {
                throw t.n(this.f53526b, "Only one HTTP method is allowed. Found: %s and %s.", str3, str);
            }
            this.f53538n = str;
            this.f53539o = z10;
            if (str2.isEmpty()) {
                return;
            }
            int indexOf = str2.indexOf(63);
            if (indexOf != -1 && indexOf < str2.length() - 1) {
                String substring = str2.substring(indexOf + 1);
                if (f53523x.matcher(substring).find()) {
                    throw t.n(this.f53526b, "URL query string \"%s\" must not have replace block. For dynamic query parameters use @Query.", substring);
                }
            }
            this.f53542r = str2;
            this.f53545u = h(str2);
        }

        public final void e(Annotation annotation) {
            if (annotation instanceof ne.b) {
                d("DELETE", ((ne.b) annotation).value(), false);
                return;
            }
            if (annotation instanceof ne.f) {
                d("GET", ((ne.f) annotation).value(), false);
                return;
            }
            if (annotation instanceof ne.g) {
                d("HEAD", ((ne.g) annotation).value(), false);
                return;
            }
            if (annotation instanceof ne.n) {
                d("PATCH", ((ne.n) annotation).value(), true);
                return;
            }
            if (annotation instanceof ne.o) {
                d("POST", ((ne.o) annotation).value(), true);
                return;
            }
            if (annotation instanceof ne.p) {
                d("PUT", ((ne.p) annotation).value(), true);
                return;
            }
            if (annotation instanceof ne.m) {
                d("OPTIONS", ((ne.m) annotation).value(), false);
                return;
            }
            if (annotation instanceof ne.h) {
                ne.h hVar = (ne.h) annotation;
                d(hVar.method(), hVar.path(), hVar.hasBody());
                return;
            }
            if (annotation instanceof ne.k) {
                String[] value = ((ne.k) annotation).value();
                if (value.length != 0) {
                    this.f53543s = c(value);
                    return;
                }
                throw t.n(this.f53526b, "@Headers annotation is empty.", new Object[0]);
            }
            if (annotation instanceof ne.l) {
                if (!this.f53540p) {
                    this.f53541q = true;
                    return;
                }
                throw t.n(this.f53526b, "Only one encoding annotation is allowed.", new Object[0]);
            }
            if (annotation instanceof ne.e) {
                if (!this.f53541q) {
                    this.f53540p = true;
                    return;
                }
                throw t.n(this.f53526b, "Only one encoding annotation is allowed.", new Object[0]);
            }
        }

        public final l<?> f(int i10, Type type, Annotation[] annotationArr, boolean z10) {
            l<?> lVar;
            if (annotationArr != null) {
                lVar = null;
                for (Annotation annotation : annotationArr) {
                    l<?> g3 = g(i10, type, annotationArr, annotation);
                    if (g3 != null) {
                        if (lVar != null) {
                            throw t.p(this.f53526b, i10, "Multiple Retrofit annotations found, only one allowed.", new Object[0]);
                        }
                        lVar = g3;
                    }
                }
            } else {
                lVar = null;
            }
            if (lVar != null) {
                return lVar;
            }
            if (z10) {
                try {
                    if (t.i(type) == Continuation.class) {
                        this.f53547w = true;
                        return null;
                    }
                } catch (NoClassDefFoundError unused) {
                }
            }
            throw t.p(this.f53526b, i10, "No Retrofit annotation found.", new Object[0]);
        }

        public final l<?> g(int i10, Type type, Annotation[] annotationArr, Annotation annotation) {
            if (annotation instanceof y) {
                j(i10, type);
                if (!this.f53537m) {
                    if (!this.f53533i) {
                        if (!this.f53534j) {
                            if (!this.f53535k) {
                                if (!this.f53536l) {
                                    if (this.f53542r != null) {
                                        throw t.p(this.f53526b, i10, "@Url cannot be used with @%s URL", this.f53538n);
                                    }
                                    this.f53537m = true;
                                    if (type != HttpUrl.class && type != String.class && type != URI.class && (!(type instanceof Class) || !"android.net.Uri".equals(((Class) type).getName()))) {
                                        throw t.p(this.f53526b, i10, "@Url must be okhttp3.HttpUrl, String, java.net.URI, or android.net.Uri type.", new Object[0]);
                                    }
                                    return new l.p(this.f53526b, i10);
                                }
                                throw t.p(this.f53526b, i10, "A @Url parameter must not come after a @QueryMap.", new Object[0]);
                            }
                            throw t.p(this.f53526b, i10, "A @Url parameter must not come after a @QueryName.", new Object[0]);
                        }
                        throw t.p(this.f53526b, i10, "A @Url parameter must not come after a @Query.", new Object[0]);
                    }
                    throw t.p(this.f53526b, i10, "@Path parameters may not be used with @Url.", new Object[0]);
                }
                throw t.p(this.f53526b, i10, "Multiple @Url method annotations found.", new Object[0]);
            }
            if (annotation instanceof ne.s) {
                j(i10, type);
                if (!this.f53534j) {
                    if (!this.f53535k) {
                        if (!this.f53536l) {
                            if (!this.f53537m) {
                                if (this.f53542r == null) {
                                    throw t.p(this.f53526b, i10, "@Path can only be used with relative url on @%s", this.f53538n);
                                }
                                this.f53533i = true;
                                ne.s sVar = (ne.s) annotation;
                                String value = sVar.value();
                                i(i10, value);
                                return new l.k(this.f53526b, i10, value, this.f53525a.j(type, annotationArr), sVar.encoded());
                            }
                            throw t.p(this.f53526b, i10, "@Path parameters may not be used with @Url.", new Object[0]);
                        }
                        throw t.p(this.f53526b, i10, "A @Path parameter must not come after a @QueryMap.", new Object[0]);
                    }
                    throw t.p(this.f53526b, i10, "A @Path parameter must not come after a @QueryName.", new Object[0]);
                }
                throw t.p(this.f53526b, i10, "A @Path parameter must not come after a @Query.", new Object[0]);
            }
            if (annotation instanceof ne.t) {
                j(i10, type);
                ne.t tVar = (ne.t) annotation;
                String value2 = tVar.value();
                boolean encoded = tVar.encoded();
                Class<?> i11 = t.i(type);
                this.f53534j = true;
                if (Iterable.class.isAssignableFrom(i11)) {
                    if (type instanceof ParameterizedType) {
                        return new l.C0821l(value2, this.f53525a.j(t.h(0, (ParameterizedType) type), annotationArr), encoded).c();
                    }
                    throw t.p(this.f53526b, i10, i11.getSimpleName() + " must include generic type (e.g., " + i11.getSimpleName() + "<String>)", new Object[0]);
                }
                if (i11.isArray()) {
                    return new l.C0821l(value2, this.f53525a.j(a(i11.getComponentType()), annotationArr), encoded).b();
                }
                return new l.C0821l(value2, this.f53525a.j(type, annotationArr), encoded);
            }
            if (annotation instanceof v) {
                j(i10, type);
                boolean encoded2 = ((v) annotation).encoded();
                Class<?> i12 = t.i(type);
                this.f53535k = true;
                if (Iterable.class.isAssignableFrom(i12)) {
                    if (type instanceof ParameterizedType) {
                        return new l.n(this.f53525a.j(t.h(0, (ParameterizedType) type), annotationArr), encoded2).c();
                    }
                    throw t.p(this.f53526b, i10, i12.getSimpleName() + " must include generic type (e.g., " + i12.getSimpleName() + "<String>)", new Object[0]);
                }
                if (i12.isArray()) {
                    return new l.n(this.f53525a.j(a(i12.getComponentType()), annotationArr), encoded2).b();
                }
                return new l.n(this.f53525a.j(type, annotationArr), encoded2);
            }
            if (annotation instanceof u) {
                j(i10, type);
                Class<?> i13 = t.i(type);
                this.f53536l = true;
                if (Map.class.isAssignableFrom(i13)) {
                    Type j10 = t.j(type, i13, Map.class);
                    if (j10 instanceof ParameterizedType) {
                        ParameterizedType parameterizedType = (ParameterizedType) j10;
                        Type h10 = t.h(0, parameterizedType);
                        if (String.class == h10) {
                            return new l.m(this.f53526b, i10, this.f53525a.j(t.h(1, parameterizedType), annotationArr), ((u) annotation).encoded());
                        }
                        throw t.p(this.f53526b, i10, "@QueryMap keys must be of type String: " + ((Object) h10), new Object[0]);
                    }
                    throw t.p(this.f53526b, i10, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                throw t.p(this.f53526b, i10, "@QueryMap parameter type must be Map.", new Object[0]);
            }
            if (annotation instanceof ne.i) {
                j(i10, type);
                String value3 = ((ne.i) annotation).value();
                Class<?> i14 = t.i(type);
                if (Iterable.class.isAssignableFrom(i14)) {
                    if (type instanceof ParameterizedType) {
                        return new l.f(value3, this.f53525a.j(t.h(0, (ParameterizedType) type), annotationArr)).c();
                    }
                    throw t.p(this.f53526b, i10, i14.getSimpleName() + " must include generic type (e.g., " + i14.getSimpleName() + "<String>)", new Object[0]);
                }
                if (i14.isArray()) {
                    return new l.f(value3, this.f53525a.j(a(i14.getComponentType()), annotationArr)).b();
                }
                return new l.f(value3, this.f53525a.j(type, annotationArr));
            }
            if (annotation instanceof ne.j) {
                if (type == Headers.class) {
                    return new l.h(this.f53526b, i10);
                }
                j(i10, type);
                Class<?> i15 = t.i(type);
                if (Map.class.isAssignableFrom(i15)) {
                    Type j11 = t.j(type, i15, Map.class);
                    if (j11 instanceof ParameterizedType) {
                        ParameterizedType parameterizedType2 = (ParameterizedType) j11;
                        Type h11 = t.h(0, parameterizedType2);
                        if (String.class == h11) {
                            return new l.g(this.f53526b, i10, this.f53525a.j(t.h(1, parameterizedType2), annotationArr));
                        }
                        throw t.p(this.f53526b, i10, "@HeaderMap keys must be of type String: " + ((Object) h11), new Object[0]);
                    }
                    throw t.p(this.f53526b, i10, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                throw t.p(this.f53526b, i10, "@HeaderMap parameter type must be Map.", new Object[0]);
            }
            if (annotation instanceof ne.c) {
                j(i10, type);
                if (this.f53540p) {
                    ne.c cVar = (ne.c) annotation;
                    String value4 = cVar.value();
                    boolean encoded3 = cVar.encoded();
                    this.f53530f = true;
                    Class<?> i16 = t.i(type);
                    if (Iterable.class.isAssignableFrom(i16)) {
                        if (type instanceof ParameterizedType) {
                            return new l.d(value4, this.f53525a.j(t.h(0, (ParameterizedType) type), annotationArr), encoded3).c();
                        }
                        throw t.p(this.f53526b, i10, i16.getSimpleName() + " must include generic type (e.g., " + i16.getSimpleName() + "<String>)", new Object[0]);
                    }
                    if (i16.isArray()) {
                        return new l.d(value4, this.f53525a.j(a(i16.getComponentType()), annotationArr), encoded3).b();
                    }
                    return new l.d(value4, this.f53525a.j(type, annotationArr), encoded3);
                }
                throw t.p(this.f53526b, i10, "@Field parameters can only be used with form encoding.", new Object[0]);
            }
            if (annotation instanceof ne.d) {
                j(i10, type);
                if (this.f53540p) {
                    Class<?> i17 = t.i(type);
                    if (Map.class.isAssignableFrom(i17)) {
                        Type j12 = t.j(type, i17, Map.class);
                        if (j12 instanceof ParameterizedType) {
                            ParameterizedType parameterizedType3 = (ParameterizedType) j12;
                            Type h12 = t.h(0, parameterizedType3);
                            if (String.class == h12) {
                                f j13 = this.f53525a.j(t.h(1, parameterizedType3), annotationArr);
                                this.f53530f = true;
                                return new l.e(this.f53526b, i10, j13, ((ne.d) annotation).encoded());
                            }
                            throw t.p(this.f53526b, i10, "@FieldMap keys must be of type String: " + ((Object) h12), new Object[0]);
                        }
                        throw t.p(this.f53526b, i10, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                    }
                    throw t.p(this.f53526b, i10, "@FieldMap parameter type must be Map.", new Object[0]);
                }
                throw t.p(this.f53526b, i10, "@FieldMap parameters can only be used with form encoding.", new Object[0]);
            }
            if (annotation instanceof ne.q) {
                j(i10, type);
                if (this.f53541q) {
                    ne.q qVar = (ne.q) annotation;
                    this.f53531g = true;
                    String value5 = qVar.value();
                    Class<?> i18 = t.i(type);
                    if (value5.isEmpty()) {
                        if (Iterable.class.isAssignableFrom(i18)) {
                            if (type instanceof ParameterizedType) {
                                if (MultipartBody.Part.class.isAssignableFrom(t.i(t.h(0, (ParameterizedType) type)))) {
                                    return l.o.f53491a.c();
                                }
                                throw t.p(this.f53526b, i10, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                            }
                            throw t.p(this.f53526b, i10, i18.getSimpleName() + " must include generic type (e.g., " + i18.getSimpleName() + "<String>)", new Object[0]);
                        }
                        if (i18.isArray()) {
                            if (MultipartBody.Part.class.isAssignableFrom(i18.getComponentType())) {
                                return l.o.f53491a.b();
                            }
                            throw t.p(this.f53526b, i10, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                        }
                        if (MultipartBody.Part.class.isAssignableFrom(i18)) {
                            return l.o.f53491a;
                        }
                        throw t.p(this.f53526b, i10, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                    }
                    Headers of = Headers.of("Content-Disposition", "form-data; name=\"" + value5 + "\"", "Content-Transfer-Encoding", qVar.encoding());
                    if (Iterable.class.isAssignableFrom(i18)) {
                        if (type instanceof ParameterizedType) {
                            Type h13 = t.h(0, (ParameterizedType) type);
                            if (!MultipartBody.Part.class.isAssignableFrom(t.i(h13))) {
                                return new l.i(this.f53526b, i10, of, this.f53525a.h(h13, annotationArr, this.f53527c)).c();
                            }
                            throw t.p(this.f53526b, i10, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                        }
                        throw t.p(this.f53526b, i10, i18.getSimpleName() + " must include generic type (e.g., " + i18.getSimpleName() + "<String>)", new Object[0]);
                    }
                    if (i18.isArray()) {
                        Class<?> a10 = a(i18.getComponentType());
                        if (!MultipartBody.Part.class.isAssignableFrom(a10)) {
                            return new l.i(this.f53526b, i10, of, this.f53525a.h(a10, annotationArr, this.f53527c)).b();
                        }
                        throw t.p(this.f53526b, i10, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                    }
                    if (!MultipartBody.Part.class.isAssignableFrom(i18)) {
                        return new l.i(this.f53526b, i10, of, this.f53525a.h(type, annotationArr, this.f53527c));
                    }
                    throw t.p(this.f53526b, i10, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                }
                throw t.p(this.f53526b, i10, "@Part parameters can only be used with multipart encoding.", new Object[0]);
            }
            if (annotation instanceof ne.r) {
                j(i10, type);
                if (this.f53541q) {
                    this.f53531g = true;
                    Class<?> i19 = t.i(type);
                    if (Map.class.isAssignableFrom(i19)) {
                        Type j14 = t.j(type, i19, Map.class);
                        if (j14 instanceof ParameterizedType) {
                            ParameterizedType parameterizedType4 = (ParameterizedType) j14;
                            Type h14 = t.h(0, parameterizedType4);
                            if (String.class == h14) {
                                Type h15 = t.h(1, parameterizedType4);
                                if (!MultipartBody.Part.class.isAssignableFrom(t.i(h15))) {
                                    return new l.j(this.f53526b, i10, this.f53525a.h(h15, annotationArr, this.f53527c), ((ne.r) annotation).encoding());
                                }
                                throw t.p(this.f53526b, i10, "@PartMap values cannot be MultipartBody.Part. Use @Part List<Part> or a different value type instead.", new Object[0]);
                            }
                            throw t.p(this.f53526b, i10, "@PartMap keys must be of type String: " + ((Object) h14), new Object[0]);
                        }
                        throw t.p(this.f53526b, i10, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                    }
                    throw t.p(this.f53526b, i10, "@PartMap parameter type must be Map.", new Object[0]);
                }
                throw t.p(this.f53526b, i10, "@PartMap parameters can only be used with multipart encoding.", new Object[0]);
            }
            if (annotation instanceof ne.a) {
                j(i10, type);
                if (!this.f53540p && !this.f53541q) {
                    if (!this.f53532h) {
                        try {
                            f h16 = this.f53525a.h(type, annotationArr, this.f53527c);
                            this.f53532h = true;
                            return new l.c(this.f53526b, i10, h16);
                        } catch (RuntimeException e2) {
                            throw t.q(this.f53526b, e2, i10, "Unable to create @Body converter for %s", type);
                        }
                    }
                    throw t.p(this.f53526b, i10, "Multiple @Body method annotations found.", new Object[0]);
                }
                throw t.p(this.f53526b, i10, "@Body parameters cannot be used with form or multi-part encoding.", new Object[0]);
            }
            if (!(annotation instanceof x)) {
                return null;
            }
            j(i10, type);
            Class<?> i20 = t.i(type);
            for (int i21 = i10 - 1; i21 >= 0; i21--) {
                l<?> lVar = this.f53546v[i21];
                if ((lVar instanceof l.q) && ((l.q) lVar).f53494a.equals(i20)) {
                    throw t.p(this.f53526b, i10, "@Tag type " + i20.getName() + " is duplicate of parameter #" + (i21 + 1) + " and would always overwrite its value.", new Object[0]);
                }
            }
            return new l.q(i20);
        }

        public final void i(int i10, String str) {
            if (f53524y.matcher(str).matches()) {
                if (!this.f53545u.contains(str)) {
                    throw t.p(this.f53526b, i10, "URL \"%s\" does not contain \"{%s}\".", this.f53542r, str);
                }
                return;
            }
            throw t.p(this.f53526b, i10, "@Path parameter name must match %s. Found: %s", f53523x.pattern(), str);
        }

        public final void j(int i10, Type type) {
            if (t.k(type)) {
                throw t.p(this.f53526b, i10, "Parameter type must not include a type variable or wildcard: %s", type);
            }
        }
    }

    public o(a aVar) {
        this.f53512a = aVar.f53526b;
        this.f53513b = aVar.f53525a.f53550c;
        this.f53514c = aVar.f53538n;
        this.f53515d = aVar.f53542r;
        this.f53516e = aVar.f53543s;
        this.f53517f = aVar.f53544t;
        this.f53518g = aVar.f53539o;
        this.f53519h = aVar.f53540p;
        this.f53520i = aVar.f53541q;
        this.f53521j = aVar.f53546v;
        this.f53522k = aVar.f53547w;
    }

    public static o b(p pVar, Method method) {
        return new a(pVar, method).b();
    }

    public Request a(Object[] objArr) throws IOException {
        l<?>[] lVarArr = this.f53521j;
        int length = objArr.length;
        if (length == lVarArr.length) {
            n nVar = new n(this.f53514c, this.f53513b, this.f53515d, this.f53516e, this.f53517f, this.f53518g, this.f53519h, this.f53520i);
            if (this.f53522k) {
                length--;
            }
            ArrayList arrayList = new ArrayList(length);
            for (int i10 = 0; i10 < length; i10++) {
                arrayList.add(objArr[i10]);
                lVarArr[i10].a(nVar, objArr[i10]);
            }
            return nVar.k().tag(i.class, new i(this.f53512a, arrayList)).build();
        }
        throw new IllegalArgumentException("Argument count (" + length + ") doesn't match expected count (" + lVarArr.length + ")");
    }
}
