package java.io;

import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import jdk.internal.misc.JavaIOFileDescriptorAccess;
import jdk.internal.misc.SharedSecrets;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class FileDescriptor {
    public static final long NO_OWNER = 0;
    private int descriptor;
    private long ownerId;
    private final Object releaseLock;
    public static final FileDescriptor in = new FileDescriptor(0);
    public static final FileDescriptor out = new FileDescriptor(1);
    public static final FileDescriptor err = new FileDescriptor(2);

    private static native boolean isSocket(int i10);

    public native void sync() throws SyncFailedException;

    public FileDescriptor() {
        this.ownerId = 0L;
        this.releaseLock = new Object();
        this.descriptor = -1;
    }

    private FileDescriptor(int descriptor) {
        this.ownerId = 0L;
        this.releaseLock = new Object();
        this.descriptor = descriptor;
    }

    static {
        SharedSecrets.setJavaIOFileDescriptorAccess(new JavaIOFileDescriptorAccess() { // from class: java.io.FileDescriptor.1
            @Override // jdk.internal.misc.JavaIOFileDescriptorAccess
            public void set(FileDescriptor obj, int fd2) {
                obj.descriptor = fd2;
            }

            @Override // jdk.internal.misc.JavaIOFileDescriptorAccess
            public int get(FileDescriptor obj) {
                return obj.descriptor;
            }

            @Override // jdk.internal.misc.JavaIOFileDescriptorAccess
            public void setHandle(FileDescriptor obj, long handle) {
                throw new UnsupportedOperationException();
            }

            @Override // jdk.internal.misc.JavaIOFileDescriptorAccess
            public long getHandle(FileDescriptor obj) {
                throw new UnsupportedOperationException();
            }
        });
    }

    public boolean valid() {
        return this.descriptor != -1;
    }

    public final int getInt$() {
        return this.descriptor;
    }

    public final void setInt$(int fd2) {
        this.descriptor = fd2;
    }

    public void cloneForFork() {
        try {
            int newDescriptor = Os.fcntlInt(this, OsConstants.F_DUPFD_CLOEXEC, 0);
            this.descriptor = newDescriptor;
        } catch (ErrnoException e2) {
            throw new RuntimeException(e2);
        }
    }

    public long getOwnerId$() {
        return this.ownerId;
    }

    public void setOwnerId$(long newOwnerId) {
        this.ownerId = newOwnerId;
    }

    public FileDescriptor release$() {
        FileDescriptor result = new FileDescriptor();
        synchronized (this.releaseLock) {
            result.descriptor = this.descriptor;
            result.ownerId = this.ownerId;
            this.descriptor = -1;
            this.ownerId = 0L;
        }
        return result;
    }

    public boolean isSocket$() {
        return isSocket(this.descriptor);
    }
}
