package okhttp3.internal.cache2;

import java.io.IOException;
import java.nio.channels.FileChannel;
import kotlin.d;
import kotlin.jvm.internal.s;
import okio.Buffer;
import org.jetbrains.annotations.NotNull;

/* compiled from: FileOperator.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class FileOperator {
    private final FileChannel fileChannel;

    public FileOperator(@NotNull FileChannel fileChannel) {
        s.i(fileChannel, "fileChannel");
        this.fileChannel = fileChannel;
    }

    public final void read(long j10, @NotNull Buffer sink, long j11) {
        s.i(sink, "sink");
        if (j11 < 0) {
            throw new IndexOutOfBoundsException();
        }
        while (j11 > 0) {
            long transferTo = this.fileChannel.transferTo(j10, j11, sink);
            j10 += transferTo;
            j11 -= transferTo;
        }
    }

    public final void write(long j10, @NotNull Buffer source, long j11) throws IOException {
        s.i(source, "source");
        if (j11 < 0 || j11 > source.size()) {
            throw new IndexOutOfBoundsException();
        }
        long j12 = j10;
        long j13 = j11;
        while (j13 > 0) {
            long transferFrom = this.fileChannel.transferFrom(source, j12, j13);
            j12 += transferFrom;
            j13 -= transferFrom;
        }
    }
}
