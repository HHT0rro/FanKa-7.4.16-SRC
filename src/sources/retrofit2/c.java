package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* compiled from: CallAdapter.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface c<R, T> {

    /* compiled from: CallAdapter.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static abstract class a {
        public static Type b(int i10, ParameterizedType parameterizedType) {
            return t.h(i10, parameterizedType);
        }

        public static Class<?> c(Type type) {
            return t.i(type);
        }

        public abstract c<?, ?> a(Type type, Annotation[] annotationArr, p pVar);
    }

    T a(b<R> bVar);

    Type responseType();
}
