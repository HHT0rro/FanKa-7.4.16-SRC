package sun.nio.ch;

import java.io.FileDescriptor;
import java.io.IOException;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class FileKey {
    private long st_dev;
    private long st_ino;

    private native void init(FileDescriptor fileDescriptor) throws IOException;

    private FileKey() {
    }

    public static FileKey create(FileDescriptor fd2) throws IOException {
        FileKey fk = new FileKey();
        fk.init(fd2);
        return fk;
    }

    public int hashCode() {
        long j10 = this.st_dev;
        int i10 = (int) (j10 ^ (j10 >>> 32));
        long j11 = this.st_ino;
        return i10 + ((int) ((j11 >>> 32) ^ j11));
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FileKey)) {
            return false;
        }
        FileKey other = (FileKey) obj;
        return this.st_dev == other.st_dev && this.st_ino == other.st_ino;
    }
}
