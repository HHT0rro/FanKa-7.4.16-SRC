package java.io;

import android.system.OsConstants;
import dalvik.annotation.optimization.ReachabilitySensitive;
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
public class FileOutputStream extends OutputStream {
    private final boolean append;
    private FileChannel channel;
    private final Object closeLock;
    private volatile boolean closed;

    /* renamed from: fd, reason: collision with root package name */
    @ReachabilitySensitive
    private final FileDescriptor f50353fd;

    @ReachabilitySensitive
    private final CloseGuard guard;
    private final boolean isFdOwner;
    private final String path;
    private final IoTracker tracker;

    public FileOutputStream(String name) throws FileNotFoundException {
        this(name != null ? new File(name) : null, false);
    }

    public FileOutputStream(String name, boolean append) throws FileNotFoundException {
        this(name != null ? new File(name) : null, append);
    }

    public FileOutputStream(File file) throws FileNotFoundException {
        this(file, false);
    }

    public FileOutputStream(File file, boolean append) throws FileNotFoundException {
        this.closeLock = new Object();
        this.closed = false;
        CloseGuard closeGuard = CloseGuard.get();
        this.guard = closeGuard;
        this.tracker = new IoTracker();
        String name = file != null ? file.getPath() : null;
        SecurityManager security = System.getSecurityManager();
        if (security != null) {
            security.checkWrite(name);
        }
        if (name == null) {
            throw new NullPointerException();
        }
        if (file.isInvalid()) {
            throw new FileNotFoundException("Invalid file path");
        }
        int flags = OsConstants.O_WRONLY | OsConstants.O_CREAT | (append ? OsConstants.O_APPEND : OsConstants.O_TRUNC);
        FileDescriptor open = IoBridge.open(name, flags);
        this.f50353fd = open;
        this.isFdOwner = true;
        this.append = append;
        this.path = name;
        IoUtils.setFdOwner(open, this);
        closeGuard.open("close");
    }

    public FileOutputStream(FileDescriptor fdObj) {
        this(fdObj, false);
    }

    public FileOutputStream(FileDescriptor fdObj, boolean isFdOwner) {
        this.closeLock = new Object();
        this.closed = false;
        this.guard = CloseGuard.get();
        this.tracker = new IoTracker();
        if (fdObj == null) {
            throw new NullPointerException("fdObj == null");
        }
        this.f50353fd = fdObj;
        this.append = false;
        this.path = null;
        this.isFdOwner = isFdOwner;
        if (isFdOwner) {
            IoUtils.setFdOwner(fdObj, this);
        }
    }

    @Override // java.io.OutputStream
    public void write(int b4) throws IOException {
        write(new byte[]{(byte) b4}, 0, 1);
    }

    @Override // java.io.OutputStream
    public void write(byte[] b4) throws IOException {
        write(b4, 0, b4.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] b4, int off, int len) throws IOException {
        if (this.closed && len > 0) {
            throw new IOException("Stream Closed");
        }
        this.tracker.trackIo(len, IoTracker.Mode.WRITE);
        IoBridge.write(this.f50353fd, b4, off, len);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
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
                IoBridge.closeAndSignalBlockedThreads(this.f50353fd);
            }
        }
    }

    @ReachabilitySensitive
    public final FileDescriptor getFD() throws IOException {
        FileDescriptor fileDescriptor = this.f50353fd;
        if (fileDescriptor != null) {
            return fileDescriptor;
        }
        throw new IOException();
    }

    public FileChannel getChannel() {
        FileChannel fileChannel;
        synchronized (this) {
            if (this.channel == null) {
                this.channel = FileChannelImpl.open(this.f50353fd, this.path, false, true, this.append, this);
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
        FileDescriptor fileDescriptor = this.f50353fd;
        if (fileDescriptor != null) {
            if (fileDescriptor == FileDescriptor.out || this.f50353fd == FileDescriptor.err) {
                flush();
            } else {
                close();
            }
        }
    }
}
