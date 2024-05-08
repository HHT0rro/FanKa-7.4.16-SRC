package org.apache.commons.collections4;

import org.apache.commons.collections4.functors.ConstantFactory;
import org.apache.commons.collections4.functors.ExceptionFactory;
import org.apache.commons.collections4.functors.InstantiateFactory;
import org.apache.commons.collections4.functors.PrototypeFactory;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class FactoryUtils {
    private FactoryUtils() {
    }

    public static <T> Factory<T> constantFactory(T t2) {
        return ConstantFactory.constantFactory(t2);
    }

    public static <T> Factory<T> exceptionFactory() {
        return ExceptionFactory.exceptionFactory();
    }

    public static <T> Factory<T> instantiateFactory(Class<T> cls) {
        return InstantiateFactory.instantiateFactory(cls, null, null);
    }

    public static <T> Factory<T> nullFactory() {
        return ConstantFactory.constantFactory(null);
    }

    public static <T> Factory<T> prototypeFactory(T t2) {
        return PrototypeFactory.prototypeFactory(t2);
    }

    public static <T> Factory<T> instantiateFactory(Class<T> cls, Class<?>[] clsArr, Object[] objArr) {
        return InstantiateFactory.instantiateFactory(cls, clsArr, objArr);
    }
}
