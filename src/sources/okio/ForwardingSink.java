package okio;

import java.io.IOException;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: ForwardingSink.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class ForwardingSink implements Sink {

    @NotNull
    private final Sink delegate;

    public ForwardingSink(@NotNull Sink delegate) {
        s.i(delegate, "delegate");
        this.delegate = delegate;
    }

    @NotNull
    /* renamed from: -deprecated_delegate, reason: not valid java name */
    public final Sink m3741deprecated_delegate() {
        return this.delegate;
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.delegate.close();
    }

    @NotNull
    public final Sink delegate() {
        return this.delegate;
    }

    @Override // okio.Sink, java.io.Flushable
    public void flush() throws IOException {
        this.delegate.flush();
    }

    @Override // okio.Sink
    @NotNull
    public Timeout timeout() {
        return this.delegate.timeout();
    }

    @NotNull
    public String toString() {
        return getClass().getSimpleName() + '(' + ((Object) this.delegate) + ')';
    }

    @Override // okio.Sink
    public void write(@NotNull Buffer source, long j10) throws IOException {
        s.i(source, "source");
        this.delegate.write(source, j10);
    }
}
