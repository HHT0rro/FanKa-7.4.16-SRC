package com.nirvana.tools.requestqueue;

import java.util.concurrent.Callable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface TimeoutCallable<T> extends Callable<T> {
    T onTimeout();
}
