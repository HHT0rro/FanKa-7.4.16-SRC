package sun.nio.fs;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class UnixFileStoreAttributes {
    private long f_bavail;
    private long f_bfree;
    private long f_blocks;
    private long f_frsize;

    private UnixFileStoreAttributes() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static UnixFileStoreAttributes get(UnixPath path) throws UnixException {
        UnixFileStoreAttributes attrs = new UnixFileStoreAttributes();
        UnixNativeDispatcher.statvfs(path, attrs);
        return attrs;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long blockSize() {
        return this.f_frsize;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long totalBlocks() {
        return this.f_blocks;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long freeBlocks() {
        return this.f_bfree;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long availableBlocks() {
        return this.f_bavail;
    }
}
