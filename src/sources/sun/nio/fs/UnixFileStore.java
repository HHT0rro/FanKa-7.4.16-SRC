package sun.nio.fs;

import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.FileAttributeView;
import java.nio.file.attribute.FileOwnerAttributeView;
import java.nio.file.attribute.FileStoreAttributeView;
import java.nio.file.attribute.PosixFileAttributeView;
import java.util.Arrays;
import java.util.Properties;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class UnixFileStore extends FileStore {
    private static final Object loadLock = new Object();
    private static volatile Properties props;
    private final long dev;
    private final UnixMountEntry entry;
    private final UnixPath file;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public enum FeatureStatus {
        PRESENT,
        NOT_PRESENT,
        UNKNOWN
    }

    abstract UnixMountEntry findMountEntry() throws IOException;

    private static long devFor(UnixPath file) throws IOException {
        try {
            return UnixFileAttributes.get(file, true).dev();
        } catch (UnixException x10) {
            x10.rethrowAsIOException(file);
            return 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public UnixFileStore(UnixPath file) throws IOException {
        this.file = file;
        this.dev = devFor(file);
        this.entry = findMountEntry();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public UnixFileStore(UnixFileSystem fs, UnixMountEntry entry) throws IOException {
        UnixPath unixPath = new UnixPath(fs, entry.dir());
        this.file = unixPath;
        this.dev = entry.dev() == 0 ? devFor(unixPath) : entry.dev();
        this.entry = entry;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public UnixPath file() {
        return this.file;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long dev() {
        return this.dev;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public UnixMountEntry entry() {
        return this.entry;
    }

    @Override // java.nio.file.FileStore
    public String name() {
        return this.entry.name();
    }

    @Override // java.nio.file.FileStore
    public String type() {
        return this.entry.fstype();
    }

    @Override // java.nio.file.FileStore
    public boolean isReadOnly() {
        return this.entry.isReadOnly();
    }

    private UnixFileStoreAttributes readAttributes() throws IOException {
        try {
            return UnixFileStoreAttributes.get(this.file);
        } catch (UnixException x10) {
            x10.rethrowAsIOException(this.file);
            return null;
        }
    }

    @Override // java.nio.file.FileStore
    public long getTotalSpace() throws IOException {
        UnixFileStoreAttributes attrs = readAttributes();
        return attrs.blockSize() * attrs.totalBlocks();
    }

    @Override // java.nio.file.FileStore
    public long getUsableSpace() throws IOException {
        UnixFileStoreAttributes attrs = readAttributes();
        return attrs.blockSize() * attrs.availableBlocks();
    }

    @Override // java.nio.file.FileStore
    public long getBlockSize() throws IOException {
        UnixFileStoreAttributes attrs = readAttributes();
        return attrs.blockSize();
    }

    @Override // java.nio.file.FileStore
    public long getUnallocatedSpace() throws IOException {
        UnixFileStoreAttributes attrs = readAttributes();
        return attrs.blockSize() * attrs.freeBlocks();
    }

    @Override // java.nio.file.FileStore
    public <V extends FileStoreAttributeView> V getFileStoreAttributeView(Class<V> view) {
        if (view == null) {
            throw new NullPointerException();
        }
        return null;
    }

    @Override // java.nio.file.FileStore
    public Object getAttribute(String attribute) throws IOException {
        if (attribute.equals("totalSpace")) {
            return Long.valueOf(getTotalSpace());
        }
        if (attribute.equals("usableSpace")) {
            return Long.valueOf(getUsableSpace());
        }
        if (attribute.equals("unallocatedSpace")) {
            return Long.valueOf(getUnallocatedSpace());
        }
        throw new UnsupportedOperationException("'" + attribute + "' not recognized");
    }

    @Override // java.nio.file.FileStore
    public boolean supportsFileAttributeView(Class<? extends FileAttributeView> type) {
        if (type == null) {
            throw new NullPointerException();
        }
        if (type == BasicFileAttributeView.class) {
            return true;
        }
        if (type != PosixFileAttributeView.class && type != FileOwnerAttributeView.class) {
            return false;
        }
        FeatureStatus status = checkIfFeaturePresent("posix");
        return status != FeatureStatus.NOT_PRESENT;
    }

    @Override // java.nio.file.FileStore
    public boolean supportsFileAttributeView(String name) {
        if (name.equals("basic") || name.equals("unix")) {
            return true;
        }
        if (name.equals("posix")) {
            return supportsFileAttributeView(PosixFileAttributeView.class);
        }
        if (name.equals("owner")) {
            return supportsFileAttributeView(FileOwnerAttributeView.class);
        }
        return false;
    }

    public boolean equals(Object ob2) {
        if (ob2 == this) {
            return true;
        }
        if (!(ob2 instanceof UnixFileStore)) {
            return false;
        }
        UnixFileStore other = (UnixFileStore) ob2;
        return this.dev == other.dev && Arrays.equals(this.entry.dir(), other.entry.dir()) && this.entry.name().equals(other.entry.name());
    }

    public int hashCode() {
        long j10 = this.dev;
        return ((int) (j10 ^ (j10 >>> 32))) ^ Arrays.hashCode(this.entry.dir());
    }

    public String toString() {
        return Util.toString(this.entry.dir()) + " (" + this.entry.name() + ")";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FeatureStatus checkIfFeaturePresent(String feature) {
        return FeatureStatus.UNKNOWN;
    }
}
