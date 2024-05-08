package java.io;

import android.system.OsConstants;
import dalvik.annotation.optimization.ReachabilitySensitive;
import dalvik.system.BlockGuard;
import dalvik.system.CloseGuard;
import java.nio.channels.FileChannel;
import libcore.io.IoBridge;
import libcore.io.IoTracker;
import libcore.io.IoUtils;
import sun.nio.ch.FileChannelImpl;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class FileInputStream extends InputStream {
    private FileChannel channel;
    private final Object closeLock;
    private volatile boolean closed;

    /* renamed from: fd, reason: collision with root package name */
    @ReachabilitySensitive
    private final FileDescriptor f50352fd;

    @ReachabilitySensitive
    private final CloseGuard guard;
    private final boolean isFdOwner;
    private final String path;
    private final IoTracker tracker;

    private native int available0() throws IOException;

    private native long skip0(long j10) throws IOException, UseManualSkipException;

    public FileInputStream(String name) throws FileNotFoundException {
        this(name != null ? new File(name) : null);
    }

    public FileInputStream(File file) throws FileNotFoundException {
        this.channel = null;
        this.closeLock = new Object();
        this.closed = false;
        CloseGuard closeGuard = CloseGuard.get();
        this.guard = closeGuard;
        this.tracker = new IoTracker();
        String name = file != null ? file.getPath() : null;
        SecurityManager security = System.getSecurityManager();
        if (security != null) {
            security.checkRead(name);
        }
        if (name == null) {
            throw new NullPointerException();
        }
        if (file.isInvalid()) {
            throw new FileNotFoundException("Invalid file path");
        }
        FileDescriptor open = IoBridge.open(name, OsConstants.O_RDONLY);
        this.f50352fd = open;
        this.isFdOwner = true;
        this.path = name;
        IoUtils.setFdOwner(open, this);
        closeGuard.open("close");
    }

    public FileInputStream(FileDescriptor fdObj) {
        this(fdObj, false);
    }

    public FileInputStream(FileDescriptor fdObj, boolean isFdOwner) {
        this.channel = null;
        this.closeLock = new Object();
        this.closed = false;
        this.guard = CloseGuard.get();
        this.tracker = new IoTracker();
        if (fdObj == null) {
            throw new NullPointerException("fdObj == null");
        }
        this.f50352fd = fdObj;
        this.path = null;
        this.isFdOwner = isFdOwner;
        if (isFdOwner) {
            IoUtils.setFdOwner(fdObj, this);
        }
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        byte[] b4 = new byte[1];
        if (read(b4, 0, 1) != -1) {
            return b4[0] & 255;
        }
        return -1;
    }

    @Override // java.io.InputStream
    public int read(byte[] b4) throws IOException {
        return read(b4, 0, b4.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] b4, int off, int len) throws IOException {
        if (this.closed && len > 0) {
            throw new IOException("Stream Closed");
        }
        this.tracker.trackIo(len, IoTracker.Mode.READ);
        return IoBridge.read(this.f50352fd, b4, off, len);
    }

    @Override // java.io.InputStream
    public long skip(long n10) throws IOException {
        if (this.closed) {
            throw new IOException("Stream Closed");
        }
        try {
            BlockGuard.getThreadPolicy().onReadFromDisk();
            return skip0(n10);
        } catch (UseManualSkipException e2) {
            return super.skip(n10);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private static class UseManualSkipException extends Exception {
        private UseManualSkipException() {
        }
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        if (this.closed) {
            throw new IOException("Stream Closed");
        }
        return available0();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this.closeLock) {
            if (this.closed) {
                return;
            }
            this.closed = true;
            this.guard.close();
            FileChannel fileChannel = this.channel;
            if (fileChannel != null) {
                fileChannel.close();
            }
            if (this.isFdOwner) {
                IoBridge.closeAndSignalBlockedThreads(this.f50352fd);
            }
        }
    }

    public final FileDescriptor getFD() throws IOException {
        FileDescriptor fileDescriptor = this.f50352fd;
        if (fileDescriptor != null) {
            return fileDescriptor;
        }
        throw new IOException();
    }

    public FileChannel getChannel() {
        FileChannel fileChannel;
        synchronized (this) {
            if (this.channel == null) {
                this.channel = FileChannelImpl.open(this.f50352fd, this.path, true, false, this);
            }
            fileChannel = this.channel;
        }
        return fileChannel;
    }

    protected void finalize() throws IOException {
        CloseGuard closeGuard = this.guard;
        if (closeGuard != null) {
            closeGuard.warnIfOpen();
        }
        FileDescriptor fileDescriptor = this.f50352fd;
        if (fileDescriptor != null && fileDescriptor != FileDescriptor.in) {
            close();
        }
    }
}
