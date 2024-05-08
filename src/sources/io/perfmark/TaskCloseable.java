package io.perfmark;

import java.io.Closeable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class TaskCloseable implements Closeable {
    public static final TaskCloseable INSTANCE = new TaskCloseable();

    private TaskCloseable() {
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        PerfMark.stopTask();
    }
}
