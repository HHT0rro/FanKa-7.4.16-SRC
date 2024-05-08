package sun.nio.fs;

import com.cupidapp.live.liveshow.beauty.databeauty.UserData;
import java.io.IOException;
import java.nio.file.attribute.DosFileAttributeView;
import java.nio.file.attribute.FileAttributeView;
import java.nio.file.attribute.PosixFileAttributeView;
import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.Arrays;
import sun.nio.fs.UnixFileStore;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
class LinuxFileStore extends UnixFileStore {
    private volatile boolean xattrChecked;
    private volatile boolean xattrEnabled;

    LinuxFileStore(UnixPath file) throws IOException {
        super(file);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LinuxFileStore(UnixFileSystem fs, UnixMountEntry entry) throws IOException {
        super(fs, entry);
    }

    @Override // sun.nio.fs.UnixFileStore
    UnixMountEntry findMountEntry() throws IOException {
        LinuxFileSystem fs = (LinuxFileSystem) file().getFileSystem();
        UnixPath path = null;
        try {
            byte[] rp = UnixNativeDispatcher.realpath(file());
            path = new UnixPath(fs, rp);
        } catch (UnixException x10) {
            x10.rethrowAsIOException(file());
        }
        for (UnixPath parent = path.getParent(); parent != null; parent = parent.getParent()) {
            UnixFileAttributes attrs = null;
            try {
                attrs = UnixFileAttributes.get(parent, true);
            } catch (UnixException x11) {
                x11.rethrowAsIOException(parent);
            }
            if (attrs.dev() != dev()) {
                break;
            }
            path = parent;
        }
        byte[] dir = path.asByteArray();
        for (UnixMountEntry entry : fs.getMountEntries("/proc/mounts")) {
            if (Arrays.equals(dir, entry.dir())) {
                return entry;
            }
        }
        throw new IOException("Mount point not found");
    }

    private boolean isExtendedAttributesEnabled(UnixPath path) {
        try {
            int fd2 = path.openForAttributeAccess(false);
            try {
                byte[] name = Util.toBytes("user.java");
                LinuxNativeDispatcher.fgetxattr(fd2, name, 0L, 0);
                return true;
            } catch (UnixException e2) {
                if (e2.errno() == UnixConstants.ENODATA) {
                    return true;
                }
                UnixNativeDispatcher.close(fd2);
                return false;
            } finally {
                UnixNativeDispatcher.close(fd2);
            }
        } catch (IOException e10) {
            return false;
        }
    }

    @Override // sun.nio.fs.UnixFileStore, java.nio.file.FileStore
    public boolean supportsFileAttributeView(Class<? extends FileAttributeView> type) {
        if (type == DosFileAttributeView.class || type == UserDefinedFileAttributeView.class) {
            UnixFileStore.FeatureStatus status = checkIfFeaturePresent("user_xattr");
            if (status == UnixFileStore.FeatureStatus.PRESENT) {
                return true;
            }
            if (status == UnixFileStore.FeatureStatus.NOT_PRESENT) {
                return false;
            }
            if (entry().hasOption("user_xattr")) {
                return true;
            }
            if (entry().fstype().equals("ext3") || entry().fstype().equals("ext4")) {
                return false;
            }
            if (!this.xattrChecked) {
                UnixPath dir = new UnixPath(file().getFileSystem(), entry().dir());
                this.xattrEnabled = isExtendedAttributesEnabled(dir);
                this.xattrChecked = true;
            }
            return this.xattrEnabled;
        }
        if (type == PosixFileAttributeView.class && entry().fstype().equals("vfat")) {
            return false;
        }
        return super.supportsFileAttributeView(type);
    }

    @Override // sun.nio.fs.UnixFileStore, java.nio.file.FileStore
    public boolean supportsFileAttributeView(String name) {
        if (name.equals("dos")) {
            return supportsFileAttributeView(DosFileAttributeView.class);
        }
        if (name.equals(UserData.NAME)) {
            return supportsFileAttributeView(UserDefinedFileAttributeView.class);
        }
        return super.supportsFileAttributeView(name);
    }
}
