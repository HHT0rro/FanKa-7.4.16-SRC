package java.nio.channels;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.spi.FileSystemProvider;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class AsynchronousFileChannel implements AsynchronousChannel {
    private static final FileAttribute<?>[] NO_ATTRIBUTES = new FileAttribute[0];

    public abstract void force(boolean z10) throws IOException;

    public abstract Future<FileLock> lock(long j10, long j11, boolean z10);

    public abstract <A> void lock(long j10, long j11, boolean z10, A a10, CompletionHandler<FileLock, ? super A> completionHandler);

    public abstract Future<Integer> read(ByteBuffer byteBuffer, long j10);

    public abstract <A> void read(ByteBuffer byteBuffer, long j10, A a10, CompletionHandler<Integer, ? super A> completionHandler);

    public abstract long size() throws IOException;

    public abstract AsynchronousFileChannel truncate(long j10) throws IOException;

    public abstract FileLock tryLock(long j10, long j11, boolean z10) throws IOException;

    public abstract Future<Integer> write(ByteBuffer byteBuffer, long j10);

    public abstract <A> void write(ByteBuffer byteBuffer, long j10, A a10, CompletionHandler<Integer, ? super A> completionHandler);

    public static AsynchronousFileChannel open(Path file, Set<? extends OpenOption> options, ExecutorService executor, FileAttribute<?>... attrs) throws IOException {
        FileSystemProvider provider = file.getFileSystem().provider();
        return provider.newAsynchronousFileChannel(file, options, executor, attrs);
    }

    public static AsynchronousFileChannel open(Path file, OpenOption... options) throws IOException {
        Set<OpenOption> set;
        if (options.length == 0) {
            set = Collections.emptySet();
        } else {
            set = new HashSet<>();
            Collections.addAll(set, options);
        }
        return open(file, set, null, NO_ATTRIBUTES);
    }

    public final <A> void lock(A attachment, CompletionHandler<FileLock, ? super A> handler) {
        lock(0L, Long.MAX_VALUE, false, attachment, handler);
    }

    public final Future<FileLock> lock() {
        return lock(0L, Long.MAX_VALUE, false);
    }

    public final FileLock tryLock() throws IOException {
        return tryLock(0L, Long.MAX_VALUE, false);
    }
}
