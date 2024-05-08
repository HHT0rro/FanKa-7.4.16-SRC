package okio;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import kotlin.d;
import org.jetbrains.annotations.NotNull;

/* compiled from: Sink.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface Sink extends Closeable, Flushable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close() throws IOException;

    void flush() throws IOException;

    @NotNull
    Timeout timeout();

    void write(@NotNull Buffer buffer, long j10) throws IOException;
}
