package okio;

import java.io.IOException;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: ForwardingSource.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class ForwardingSource implements Source {

    @NotNull
    private final Source delegate;

    public ForwardingSource(@NotNull Source delegate) {
        s.i(delegate, "delegate");
        this.delegate = delegate;
    }

    @NotNull
    /* renamed from: -deprecated_delegate, reason: not valid java name */
    public final Source m3742deprecated_delegate() {
        return this.delegate;
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.delegate.close();
    }

    @NotNull
    public final Source delegate() {
        return this.delegate;
    }

    @Override // okio.Source
    public long read(@NotNull Buffer sink, long j10) throws IOException {
        s.i(sink, "sink");
        return this.delegate.read(sink, j10);
    }

    @Override // okio.Source
    @NotNull
    public Timeout timeout() {
        return this.delegate.timeout();
    }

    @NotNull
    public String toString() {
        return getClass().getSimpleName() + '(' + ((Object) this.delegate) + ')';
    }
}
