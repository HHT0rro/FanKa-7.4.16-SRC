package okio;

import java.io.Closeable;
import java.io.IOException;
import kotlin.d;
import org.jetbrains.annotations.NotNull;

/* compiled from: Source.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface Source extends Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close() throws IOException;

    long read(@NotNull Buffer buffer, long j10) throws IOException;

    @NotNull
    Timeout timeout();
}
