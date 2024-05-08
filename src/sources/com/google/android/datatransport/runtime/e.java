package com.google.android.datatransport.runtime;

import android.content.Context;
import java.io.Closeable;
import java.io.IOException;
import javax.inject.Singleton;

/* compiled from: TransportRuntimeComponent.java */
@Singleton
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class e implements Closeable {

    /* compiled from: TransportRuntimeComponent.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface a {
        a a(Context context);

        e build();
    }

    public abstract com.google.android.datatransport.runtime.scheduling.persistence.b a();

    public abstract d b();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        a().close();
    }
}
