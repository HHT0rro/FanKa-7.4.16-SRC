package sun.nio.fs;

import com.cupidapp.live.liveshow.beauty.databeauty.UserData;
import com.kuaishou.weapon.p0.t;
import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.WatchService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
class LinuxFileSystem extends UnixFileSystem {
    /* JADX INFO: Access modifiers changed from: package-private */
    public LinuxFileSystem(UnixFileSystemProvider provider, String dir) {
        super(provider, dir);
    }

    @Override // java.nio.file.FileSystem
    public WatchService newWatchService() throws IOException {
        return new LinuxWatchService(this);
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private static class SupportedFileFileAttributeViewsHolder {
        static final Set<String> supportedFileAttributeViews = supportedFileAttributeViews();

        private SupportedFileFileAttributeViewsHolder() {
        }

        private static Set<String> supportedFileAttributeViews() {
            Set<String> result = new HashSet<>();
            result.addAll(UnixFileSystem.standardFileAttributeViews());
            result.add("dos");
            result.add(UserData.NAME);
            return Collections.unmodifiableSet(result);
        }
    }

    @Override // java.nio.file.FileSystem
    public Set<String> supportedFileAttributeViews() {
        return SupportedFileFileAttributeViewsHolder.supportedFileAttributeViews;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // sun.nio.fs.UnixFileSystem
    public void copyNonPosixAttributes(int ofd, int nfd) {
        LinuxUserDefinedFileAttributeView.copyExtendedAttributes(ofd, nfd);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Iterable<UnixMountEntry> getMountEntries(String fstab) {
        ArrayList<UnixMountEntry> entries = new ArrayList<>();
        try {
            long fp = LinuxNativeDispatcher.setmntent(Util.toBytes(fstab), Util.toBytes(t.f36226k));
            while (true) {
                try {
                    UnixMountEntry entry = new UnixMountEntry();
                    int res = LinuxNativeDispatcher.getmntent(fp, entry);
                    if (res < 0) {
                        break;
                    }
                    entries.add(entry);
                } finally {
                    LinuxNativeDispatcher.endmntent(fp);
                }
            }
        } catch (UnixException e2) {
        }
        return entries;
    }

    @Override // sun.nio.fs.UnixFileSystem
    Iterable<UnixMountEntry> getMountEntries() {
        return getMountEntries("/proc/mounts");
    }

    @Override // sun.nio.fs.UnixFileSystem
    FileStore getFileStore(UnixMountEntry entry) throws IOException {
        return new LinuxFileStore(this, entry);
    }
}
