package org.apache.commons.lang3.concurrent;

import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.Validate;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class ConcurrentUtils {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class ConstantFuture<T> implements Future<T> {
        private final T value;

        public ConstantFuture(T t2) {
            this.value = t2;
        }

        @Override // java.util.concurrent.Future
        public boolean cancel(boolean z10) {
            return false;
        }

        @Override // java.util.concurrent.Future
        public T get() {
            return this.value;
        }

        @Override // java.util.concurrent.Future
        public boolean isCancelled() {
            return false;
        }

        @Override // java.util.concurrent.Future
        public boolean isDone() {
            return true;
        }

        @Override // java.util.concurrent.Future
        public T get(long j10, TimeUnit timeUnit) {
            return this.value;
        }
    }

    private ConcurrentUtils() {
    }

    public static Throwable checkedException(Throwable th) {
        Validate.isTrue((th == null || (th instanceof RuntimeException) || (th instanceof Error)) ? false : true, "Not a checked exception: " + ((Object) th), new Object[0]);
        return th;
    }

    public static <T> Future<T> constantFuture(T t2) {
        return new ConstantFuture(t2);
    }

    public static <K, V> V createIfAbsent(ConcurrentMap<K, V> concurrentMap, K k10, ConcurrentInitializer<V> concurrentInitializer) throws ConcurrentException {
        if (concurrentMap == null || concurrentInitializer == null) {
            return null;
        }
        V v2 = concurrentMap.get(k10);
        return v2 == null ? (V) putIfAbsent(concurrentMap, k10, concurrentInitializer.get()) : v2;
    }

    public static <K, V> V createIfAbsentUnchecked(ConcurrentMap<K, V> concurrentMap, K k10, ConcurrentInitializer<V> concurrentInitializer) {
        try {
            return (V) createIfAbsent(concurrentMap, k10, concurrentInitializer);
        } catch (ConcurrentException e2) {
            throw new ConcurrentRuntimeException(e2.getCause());
        }
    }

    public static ConcurrentException extractCause(ExecutionException executionException) {
        if (executionException == null || executionException.getCause() == null) {
            return null;
        }
        throwCause(executionException);
        return new ConcurrentException(executionException.getMessage(), executionException.getCause());
    }

    public static ConcurrentRuntimeException extractCauseUnchecked(ExecutionException executionException) {
        if (executionException == null || executionException.getCause() == null) {
            return null;
        }
        throwCause(executionException);
        return new ConcurrentRuntimeException(executionException.getMessage(), executionException.getCause());
    }

    public static void handleCause(ExecutionException executionException) throws ConcurrentException {
        ConcurrentException extractCause = extractCause(executionException);
        if (extractCause != null) {
            throw extractCause;
        }
    }

    public static void handleCauseUnchecked(ExecutionException executionException) {
        ConcurrentRuntimeException extractCauseUnchecked = extractCauseUnchecked(executionException);
        if (extractCauseUnchecked != null) {
            throw extractCauseUnchecked;
        }
    }

    public static <T> T initialize(ConcurrentInitializer<T> concurrentInitializer) throws ConcurrentException {
        if (concurrentInitializer != null) {
            return concurrentInitializer.get();
        }
        return null;
    }

    public static <T> T initializeUnchecked(ConcurrentInitializer<T> concurrentInitializer) {
        try {
            return (T) initialize(concurrentInitializer);
        } catch (ConcurrentException e2) {
            throw new ConcurrentRuntimeException(e2.getCause());
        }
    }

    public static <K, V> V putIfAbsent(ConcurrentMap<K, V> concurrentMap, K k10, V v2) {
        if (concurrentMap == null) {
            return null;
        }
        V putIfAbsent = concurrentMap.putIfAbsent(k10, v2);
        return putIfAbsent != null ? putIfAbsent : v2;
    }

    private static void throwCause(ExecutionException executionException) {
        if (!(executionException.getCause() instanceof RuntimeException)) {
            if (executionException.getCause() instanceof Error) {
                throw ((Error) executionException.getCause());
            }
            return;
        }
        throw ((RuntimeException) executionException.getCause());
    }
}
