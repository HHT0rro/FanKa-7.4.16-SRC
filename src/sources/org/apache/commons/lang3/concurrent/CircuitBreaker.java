package org.apache.commons.lang3.concurrent;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface CircuitBreaker<T> {
    boolean checkState();

    void close();

    boolean incrementAndCheckState(T t2);

    boolean isClosed();

    boolean isOpen();

    void open();
}
