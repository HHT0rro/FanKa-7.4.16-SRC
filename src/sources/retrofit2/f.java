package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

/* compiled from: Converter.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface f<F, T> {

    /* compiled from: Converter.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static abstract class a {
        public static Type getParameterUpperBound(int i10, ParameterizedType parameterizedType) {
            return t.h(i10, parameterizedType);
        }

        public static Class<?> getRawType(Type type) {
            return t.i(type);
        }

        public f<?, RequestBody> requestBodyConverter(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, p pVar) {
            return null;
        }

        public f<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotationArr, p pVar) {
            return null;
        }

        public f<?, String> stringConverter(Type type, Annotation[] annotationArr, p pVar) {
            return null;
        }
    }

    T convert(F f10) throws IOException;
}
