package com.tencent.cloud.huiyansdkface.okio;

import java.io.Closeable;
import java.io.IOException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface Source extends Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close() throws IOException;

    long read(Buffer buffer, long j10) throws IOException;

    Timeout timeout();
}
