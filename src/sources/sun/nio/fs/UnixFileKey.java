package sun.nio.fs;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class UnixFileKey {
    private final long st_dev;
    private final long st_ino;

    /* JADX INFO: Access modifiers changed from: package-private */
    public UnixFileKey(long st_dev, long st_ino) {
        this.st_dev = st_dev;
        this.st_ino = st_ino;
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
        if (!(obj instanceof UnixFileKey)) {
            return false;
        }
        UnixFileKey other = (UnixFileKey) obj;
        return this.st_dev == other.st_dev && this.st_ino == other.st_ino;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("(dev=").append(Long.toHexString(this.st_dev)).append(",ino=").append(this.st_ino).append(')');
        return sb2.toString();
    }
}
