package io.grpc.internal;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
final class LongCounterFactory {
    public static LongCounter create() {
        if (ReflectionLongAdderCounter.isAvailable()) {
            return new ReflectionLongAdderCounter();
        }
        return new AtomicLongCounter();
    }
}
