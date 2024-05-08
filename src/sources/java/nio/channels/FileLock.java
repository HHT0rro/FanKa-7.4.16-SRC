package java.nio.channels;

import com.huawei.openalliance.ad.constant.u;
import dalvik.system.VMRuntime;
import java.io.IOException;
import java.util.Objects;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class FileLock implements AutoCloseable {
    private final Channel channel;
    private final long position;
    private final boolean shared;
    private final long size;

    public abstract boolean isValid();

    public abstract void release() throws IOException;

    /* JADX INFO: Access modifiers changed from: protected */
    public FileLock(FileChannel channel, long position, long size, boolean shared) {
        if (VMRuntime.getSdkVersion() >= 34) {
            Objects.requireNonNull(channel, "Null channel");
        }
        if (position < 0) {
            throw new IllegalArgumentException("Negative position");
        }
        if (size < 0) {
            throw new IllegalArgumentException("Negative size");
        }
        if (position + size < 0) {
            throw new IllegalArgumentException("Negative position + size");
        }
        this.channel = channel;
        this.position = position;
        this.size = size;
        this.shared = shared;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public FileLock(AsynchronousFileChannel channel, long position, long size, boolean shared) {
        if (VMRuntime.getSdkVersion() >= 34) {
            Objects.requireNonNull(channel, "Null channel");
        }
        if (position < 0) {
            throw new IllegalArgumentException("Negative position");
        }
        if (size < 0) {
            throw new IllegalArgumentException("Negative size");
        }
        if (position + size < 0) {
            throw new IllegalArgumentException("Negative position + size");
        }
        this.channel = channel;
        this.position = position;
        this.size = size;
        this.shared = shared;
    }

    public final FileChannel channel() {
        Channel channel = this.channel;
        if (channel instanceof FileChannel) {
            return (FileChannel) channel;
        }
        return null;
    }

    public Channel acquiredBy() {
        return this.channel;
    }

    public final long position() {
        return this.position;
    }

    public final long size() {
        return this.size;
    }

    public final boolean isShared() {
        return this.shared;
    }

    public final boolean overlaps(long position, long size) {
        long j10 = position + size;
        long j11 = this.position;
        return j10 > j11 && j11 + this.size > position;
    }

    @Override // java.lang.AutoCloseable
    public final void close() throws IOException {
        release();
    }

    public final String toString() {
        return getClass().getName() + "[" + this.position + u.bD + this.size + " " + (this.shared ? "shared" : "exclusive") + " " + (isValid() ? "valid" : "invalid") + "]";
    }
}
