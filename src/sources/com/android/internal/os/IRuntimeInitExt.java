package com.android.internal.os;

import java.lang.Thread;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface IRuntimeInitExt {
    default void uncaughtExceptionExt(Thread t2, Throwable e2, Thread.UncaughtExceptionHandler eh) {
    }

    default void collectHeapdump(Throwable e2) {
    }
}
