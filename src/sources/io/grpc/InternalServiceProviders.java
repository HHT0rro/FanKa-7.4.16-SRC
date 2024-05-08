package io.grpc;

import io.grpc.ServiceProviders;
import java.util.List;

@Internal
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class InternalServiceProviders {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface PriorityAccessor<T> extends ServiceProviders.PriorityAccessor<T> {
    }

    private InternalServiceProviders() {
    }

    public static <T> Iterable<T> getCandidatesViaHardCoded(Class<T> cls, Iterable<Class<?>> iterable) {
        return ServiceProviders.getCandidatesViaHardCoded(cls, iterable);
    }

    public static <T> Iterable<T> getCandidatesViaServiceLoader(Class<T> cls, ClassLoader classLoader) {
        return ServiceProviders.getCandidatesViaServiceLoader(cls, classLoader);
    }

    public static boolean isAndroid(ClassLoader classLoader) {
        return ServiceProviders.isAndroid(classLoader);
    }

    public static <T> T load(Class<T> cls, Iterable<Class<?>> iterable, ClassLoader classLoader, PriorityAccessor<T> priorityAccessor) {
        return (T) ServiceProviders.load(cls, iterable, classLoader, priorityAccessor);
    }

    public static <T> List<T> loadAll(Class<T> cls, Iterable<Class<?>> iterable, ClassLoader classLoader, PriorityAccessor<T> priorityAccessor) {
        return ServiceProviders.loadAll(cls, iterable, classLoader, priorityAccessor);
    }
}
