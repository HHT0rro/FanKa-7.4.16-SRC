package okhttp3.internal.cache;

import java.io.IOException;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import okio.Buffer;
import okio.ForwardingSink;
import okio.Sink;
import org.jetbrains.annotations.NotNull;

/* compiled from: FaultHidingSink.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class FaultHidingSink extends ForwardingSink {
    private boolean hasErrors;

    @NotNull
    private final Function1<IOException, p> onException;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FaultHidingSink(@NotNull Sink delegate, @NotNull Function1<? super IOException, p> onException) {
        super(delegate);
        s.i(delegate, "delegate");
        s.i(onException, "onException");
        this.onException = onException;
    }

    @Override // okio.ForwardingSink, okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.hasErrors) {
            return;
        }
        try {
            super.close();
        } catch (IOException e2) {
            this.hasErrors = true;
            this.onException.invoke(e2);
        }
    }

    @Override // okio.ForwardingSink, okio.Sink, java.io.Flushable
    public void flush() {
        if (this.hasErrors) {
            return;
        }
        try {
            super.flush();
        } catch (IOException e2) {
            this.hasErrors = true;
            this.onException.invoke(e2);
        }
    }

    @NotNull
    public final Function1<IOException, p> getOnException() {
        return this.onException;
    }

    @Override // okio.ForwardingSink, okio.Sink
    public void write(@NotNull Buffer source, long j10) {
        s.i(source, "source");
        if (this.hasErrors) {
            source.skip(j10);
            return;
        }
        try {
            super.write(source, j10);
        } catch (IOException e2) {
            this.hasErrors = true;
            this.onException.invoke(e2);
        }
    }
}
