package com.google.android.datatransport.runtime.scheduling.persistence;

import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;
import java.io.Closeable;

/* compiled from: EventStore.java */
@WorkerThread
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public interface b extends Closeable {
    void c(TransportContext transportContext, long j10);

    int cleanUp();

    void h(Iterable<PersistedEvent> iterable);

    Iterable<TransportContext> o();

    long p(TransportContext transportContext);

    boolean q(TransportContext transportContext);

    void s(Iterable<PersistedEvent> iterable);

    Iterable<PersistedEvent> t(TransportContext transportContext);

    @Nullable
    PersistedEvent v(TransportContext transportContext, EventInternal eventInternal);
}
