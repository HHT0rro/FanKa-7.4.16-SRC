package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import ne.w;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.f;

/* compiled from: BuiltInConverters.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class a extends f.a {

    /* renamed from: a, reason: collision with root package name */
    public boolean f53393a = true;

    /* compiled from: BuiltInConverters.java */
    /* renamed from: retrofit2.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class C0816a implements retrofit2.f<ResponseBody, ResponseBody> {

        /* renamed from: a, reason: collision with root package name */
        public static final C0816a f53394a = new C0816a();

        @Override // retrofit2.f
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ResponseBody convert(ResponseBody responseBody) throws IOException {
            try {
                return t.a(responseBody);
            } finally {
                responseBody.close();
            }
        }
    }

    /* compiled from: BuiltInConverters.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class b implements retrofit2.f<RequestBody, RequestBody> {

        /* renamed from: a, reason: collision with root package name */
        public static final b f53395a = new b();

        @Override // retrofit2.f
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RequestBody convert(RequestBody requestBody) {
            return requestBody;
        }
    }

    /* compiled from: BuiltInConverters.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class c implements retrofit2.f<ResponseBody, ResponseBody> {

        /* renamed from: a, reason: collision with root package name */
        public static final c f53396a = new c();

        @Override // retrofit2.f
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ResponseBody convert(ResponseBody responseBody) {
            return responseBody;
        }
    }

    /* compiled from: BuiltInConverters.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class d implements retrofit2.f<Object, String> {

        /* renamed from: a, reason: collision with root package name */
        public static final d f53397a = new d();

        @Override // retrofit2.f
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String convert(Object obj) {
            return obj.toString();
        }
    }

    /* compiled from: BuiltInConverters.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class e implements retrofit2.f<ResponseBody, kotlin.p> {

        /* renamed from: a, reason: collision with root package name */
        public static final e f53398a = new e();

        @Override // retrofit2.f
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public kotlin.p convert(ResponseBody responseBody) {
            responseBody.close();
            return kotlin.p.f51048a;
        }
    }

    /* compiled from: BuiltInConverters.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class f implements retrofit2.f<ResponseBody, Void> {

        /* renamed from: a, reason: collision with root package name */
        public static final f f53399a = new f();

        @Override // retrofit2.f
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void convert(ResponseBody responseBody) {
            responseBody.close();
            return null;
        }
    }

    @Override // retrofit2.f.a
    public retrofit2.f<?, RequestBody> requestBodyConverter(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, p pVar) {
        if (RequestBody.class.isAssignableFrom(t.i(type))) {
            return b.f53395a;
        }
        return null;
    }

    @Override // retrofit2.f.a
    public retrofit2.f<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotationArr, p pVar) {
        if (type == ResponseBody.class) {
            if (t.m(annotationArr, w.class)) {
                return c.f53396a;
            }
            return C0816a.f53394a;
        }
        if (type == Void.class) {
            return f.f53399a;
        }
        if (!this.f53393a || type != kotlin.p.class) {
            return null;
        }
        try {
            return e.f53398a;
        } catch (NoClassDefFoundError unused) {
            this.f53393a = false;
            return null;
        }
    }
}
