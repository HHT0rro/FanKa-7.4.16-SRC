package okio;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.Arrays;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: -DeprecatedOkio.kt */
@d
/* renamed from: okio.-DeprecatedOkio, reason: invalid class name */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class DeprecatedOkio {
    public static final DeprecatedOkio INSTANCE = new DeprecatedOkio();

    private DeprecatedOkio() {
    }

    @NotNull
    public final Sink appendingSink(@NotNull File file) {
        s.i(file, "file");
        return Okio.appendingSink(file);
    }

    @NotNull
    public final Sink blackhole() {
        return Okio.blackhole();
    }

    @NotNull
    public final BufferedSink buffer(@NotNull Sink sink) {
        s.i(sink, "sink");
        return Okio.buffer(sink);
    }

    @NotNull
    public final Sink sink(@NotNull File file) {
        s.i(file, "file");
        return Okio__JvmOkioKt.sink$default(file, false, 1, null);
    }

    @NotNull
    public final Source source(@NotNull File file) {
        s.i(file, "file");
        return Okio.source(file);
    }

    @NotNull
    public final BufferedSource buffer(@NotNull Source source) {
        s.i(source, "source");
        return Okio.buffer(source);
    }

    @NotNull
    public final Sink sink(@NotNull OutputStream outputStream) {
        s.i(outputStream, "outputStream");
        return Okio.sink(outputStream);
    }

    @NotNull
    public final Source source(@NotNull InputStream inputStream) {
        s.i(inputStream, "inputStream");
        return Okio.source(inputStream);
    }

    @NotNull
    public final Sink sink(@NotNull Path path, @NotNull OpenOption... options) {
        s.i(path, "path");
        s.i(options, "options");
        return Okio.sink(path, (OpenOption[]) Arrays.copyOf(options, options.length));
    }

    @NotNull
    public final Source source(@NotNull Path path, @NotNull OpenOption... options) {
        s.i(path, "path");
        s.i(options, "options");
        return Okio.source(path, (OpenOption[]) Arrays.copyOf(options, options.length));
    }

    @NotNull
    public final Sink sink(@NotNull Socket socket) {
        s.i(socket, "socket");
        return Okio.sink(socket);
    }

    @NotNull
    public final Source source(@NotNull Socket socket) {
        s.i(socket, "socket");
        return Okio.source(socket);
    }
}
