package retrofit2;

import java.lang.reflect.Method;
import java.lang.reflect.Type;

/* compiled from: ServiceMethod.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class q<T> {
    public static <T> q<T> b(p pVar, Method method) {
        o b4 = o.b(pVar, method);
        Type genericReturnType = method.getGenericReturnType();
        if (!t.k(genericReturnType)) {
            if (genericReturnType != Void.TYPE) {
                return h.f(pVar, method, b4);
            }
            throw t.n(method, "Service methods cannot return void.", new Object[0]);
        }
        throw t.n(method, "Method return type must not include a type variable or wildcard: %s", genericReturnType);
    }

    public abstract T a(Object[] objArr);
}
