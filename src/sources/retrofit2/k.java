package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Optional;
import okhttp3.ResponseBody;
import retrofit2.f;

/* compiled from: OptionalConverterFactory.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class k extends f.a {

    /* renamed from: a, reason: collision with root package name */
    public static final f.a f53448a = new k();

    /* compiled from: OptionalConverterFactory.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class a<T> implements f<ResponseBody, Optional<T>> {

        /* renamed from: a, reason: collision with root package name */
        public final f<ResponseBody, T> f53449a;

        public a(f<ResponseBody, T> fVar) {
            this.f53449a = fVar;
        }

        @Override // retrofit2.f
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Optional<T> convert(ResponseBody responseBody) throws IOException {
            return Optional.ofNullable(this.f53449a.convert(responseBody));
        }
    }

    @Override // retrofit2.f.a
    public f<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotationArr, p pVar) {
        if (f.a.getRawType(type) != Optional.class) {
            return null;
        }
        return new a(pVar.i(f.a.getParameterUpperBound(0, (ParameterizedType) type), annotationArr));
    }
}
