package androidx.lifecycle;

import java.io.Closeable;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.s;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.s1;
import org.jetbrains.annotations.NotNull;

/* compiled from: ViewModel.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class CloseableCoroutineScope implements Closeable, h0 {

    @NotNull
    private final CoroutineContext coroutineContext;

    public CloseableCoroutineScope(@NotNull CoroutineContext context) {
        s.i(context, "context");
        this.coroutineContext = context;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        s1.d(getCoroutineContext(), null, 1, null);
    }

    @Override // kotlinx.coroutines.h0
    @NotNull
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }
}
