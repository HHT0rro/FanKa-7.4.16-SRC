package sun.nio.fs;

import java.io.IOException;
import java.nio.file.ProviderMismatchException;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.GroupPrincipal;
import java.nio.file.attribute.PosixFileAttributeView;
import java.nio.file.attribute.PosixFileAttributes;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.UserPrincipal;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import sun.nio.fs.AbstractBasicFileAttributeView;
import sun.nio.fs.UnixUserPrincipals;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
class UnixFileAttributeViews {
    UnixFileAttributeViews() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class Basic extends AbstractBasicFileAttributeView {
        protected final UnixPath file;
        protected final boolean followLinks;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Basic(UnixPath file, boolean followLinks) {
            this.file = file;
            this.followLinks = followLinks;
        }

        @Override // java.nio.file.attribute.BasicFileAttributeView
        public BasicFileAttributes readAttributes() throws IOException {
            this.file.checkRead();
            try {
                UnixFileAttributes attrs = UnixFileAttributes.get(this.file, this.followLinks);
                return attrs.asBasicFileAttributes();
            } catch (UnixException x10) {
                x10.rethrowAsIOException(this.file);
                return null;
            }
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x0087 -> B:26:0x008c). Please report as a decompilation issue!!! */
        @Override // java.nio.file.attribute.BasicFileAttributeView
        public void setTimes(FileTime lastModifiedTime, FileTime lastAccessTime, FileTime createTime) throws IOException {
            if (lastModifiedTime == null && lastAccessTime == null) {
                return;
            }
            this.file.checkWrite();
            int fd2 = this.file.openForAttributeAccess(this.followLinks);
            if (lastModifiedTime == null || lastAccessTime == null) {
                try {
                    try {
                        UnixFileAttributes attrs = UnixFileAttributes.get(fd2);
                        if (lastModifiedTime == null) {
                            lastModifiedTime = attrs.lastModifiedTime();
                        }
                        if (lastAccessTime == null) {
                            lastAccessTime = attrs.lastAccessTime();
                        }
                    } catch (UnixException x10) {
                        x10.rethrowAsIOException(this.file);
                    }
                } finally {
                    UnixNativeDispatcher.close(fd2);
                }
            }
            long modValue = lastModifiedTime.to(TimeUnit.MICROSECONDS);
            long accessValue = lastAccessTime.to(TimeUnit.MICROSECONDS);
            boolean retry = false;
            try {
                if (UnixNativeDispatcher.futimesSupported()) {
                    UnixNativeDispatcher.futimes(fd2, accessValue, modValue);
                } else {
                    UnixNativeDispatcher.utimes(this.file, accessValue, modValue);
                }
            } catch (UnixException x11) {
                if (x11.errno() == UnixConstants.EINVAL && (modValue < 0 || accessValue < 0)) {
                    retry = true;
                } else {
                    x11.rethrowAsIOException(this.file);
                }
            }
            if (retry) {
                if (modValue < 0) {
                    modValue = 0;
                }
                if (accessValue < 0) {
                    accessValue = 0;
                }
                try {
                    if (UnixNativeDispatcher.futimesSupported()) {
                        UnixNativeDispatcher.futimes(fd2, accessValue, modValue);
                    } else {
                        UnixNativeDispatcher.utimes(this.file, accessValue, modValue);
                    }
                } catch (UnixException x12) {
                    x12.rethrowAsIOException(this.file);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class Posix extends Basic implements PosixFileAttributeView {
        private static final String PERMISSIONS_NAME = "permissions";
        private static final String OWNER_NAME = "owner";
        private static final String GROUP_NAME = "group";
        static final Set<String> posixAttributeNames = Util.newSet(basicAttributeNames, PERMISSIONS_NAME, OWNER_NAME, GROUP_NAME);

        Posix(UnixPath file, boolean followLinks) {
            super(file, followLinks);
        }

        final void checkReadExtended() {
            SecurityManager sm = System.getSecurityManager();
            if (sm != null) {
                this.file.checkRead();
                sm.checkPermission(new RuntimePermission("accessUserInformation"));
            }
        }

        final void checkWriteExtended() {
            SecurityManager sm = System.getSecurityManager();
            if (sm != null) {
                this.file.checkWrite();
                sm.checkPermission(new RuntimePermission("accessUserInformation"));
            }
        }

        @Override // sun.nio.fs.AbstractBasicFileAttributeView, java.nio.file.attribute.BasicFileAttributeView, java.nio.file.attribute.AttributeView
        public String name() {
            return "posix";
        }

        @Override // sun.nio.fs.AbstractBasicFileAttributeView, sun.nio.fs.DynamicFileAttributeView
        public void setAttribute(String attribute, Object value) throws IOException {
            if (attribute.equals(PERMISSIONS_NAME)) {
                setPermissions((Set) value);
                return;
            }
            if (attribute.equals(OWNER_NAME)) {
                setOwner((UserPrincipal) value);
            } else if (attribute.equals(GROUP_NAME)) {
                setGroup((GroupPrincipal) value);
            } else {
                super.setAttribute(attribute, value);
            }
        }

        final void addRequestedPosixAttributes(PosixFileAttributes attrs, AbstractBasicFileAttributeView.AttributesBuilder builder) {
            addRequestedBasicAttributes(attrs, builder);
            if (builder.match(PERMISSIONS_NAME)) {
                builder.add(PERMISSIONS_NAME, attrs.permissions());
            }
            if (builder.match(OWNER_NAME)) {
                builder.add(OWNER_NAME, attrs.owner());
            }
            if (builder.match(GROUP_NAME)) {
                builder.add(GROUP_NAME, attrs.group());
            }
        }

        @Override // sun.nio.fs.AbstractBasicFileAttributeView, sun.nio.fs.DynamicFileAttributeView
        public Map<String, Object> readAttributes(String[] requested) throws IOException {
            AbstractBasicFileAttributeView.AttributesBuilder builder = AbstractBasicFileAttributeView.AttributesBuilder.create(posixAttributeNames, requested);
            PosixFileAttributes attrs = readAttributes();
            addRequestedPosixAttributes(attrs, builder);
            return builder.unmodifiableMap();
        }

        @Override // sun.nio.fs.UnixFileAttributeViews.Basic, java.nio.file.attribute.BasicFileAttributeView
        public UnixFileAttributes readAttributes() throws IOException {
            checkReadExtended();
            try {
                return UnixFileAttributes.get(this.file, this.followLinks);
            } catch (UnixException x10) {
                x10.rethrowAsIOException(this.file);
                return null;
            }
        }

        final void setMode(int mode) throws IOException {
            checkWriteExtended();
            try {
                if (this.followLinks) {
                    UnixNativeDispatcher.chmod(this.file, mode);
                } else {
                    int fd2 = this.file.openForAttributeAccess(false);
                    try {
                        UnixNativeDispatcher.fchmod(fd2, mode);
                    } finally {
                        UnixNativeDispatcher.close(fd2);
                    }
                }
            } catch (UnixException x10) {
                x10.rethrowAsIOException(this.file);
            }
        }

        final void setOwners(int uid, int gid) throws IOException {
            checkWriteExtended();
            try {
                if (this.followLinks) {
                    UnixNativeDispatcher.chown(this.file, uid, gid);
                } else {
                    UnixNativeDispatcher.lchown(this.file, uid, gid);
                }
            } catch (UnixException x10) {
                x10.rethrowAsIOException(this.file);
            }
        }

        @Override // java.nio.file.attribute.PosixFileAttributeView
        public void setPermissions(Set<PosixFilePermission> perms) throws IOException {
            setMode(UnixFileModeAttribute.toUnixMode(perms));
        }

        @Override // java.nio.file.attribute.FileOwnerAttributeView
        public void setOwner(UserPrincipal owner) throws IOException {
            if (owner == null) {
                throw new NullPointerException("'owner' is null");
            }
            if (!(owner instanceof UnixUserPrincipals.User)) {
                throw new ProviderMismatchException();
            }
            if (owner instanceof UnixUserPrincipals.Group) {
                throw new IOException("'owner' parameter can't be a group");
            }
            int uid = ((UnixUserPrincipals.User) owner).uid();
            setOwners(uid, -1);
        }

        @Override // java.nio.file.attribute.FileOwnerAttributeView
        public UserPrincipal getOwner() throws IOException {
            return readAttributes().owner();
        }

        @Override // java.nio.file.attribute.PosixFileAttributeView
        public void setGroup(GroupPrincipal group) throws IOException {
            if (group == null) {
                throw new NullPointerException("'owner' is null");
            }
            if (!(group instanceof UnixUserPrincipals.Group)) {
                throw new ProviderMismatchException();
            }
            int gid = ((UnixUserPrincipals.Group) group).gid();
            setOwners(-1, gid);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class Unix extends Posix {
        private static final String MODE_NAME = "mode";
        private static final String UID_NAME = "uid";
        private static final String INO_NAME = "ino";
        private static final String DEV_NAME = "dev";
        private static final String RDEV_NAME = "rdev";
        private static final String NLINK_NAME = "nlink";
        private static final String GID_NAME = "gid";
        private static final String CTIME_NAME = "ctime";
        static final Set<String> unixAttributeNames = Util.newSet(posixAttributeNames, "mode", INO_NAME, DEV_NAME, RDEV_NAME, NLINK_NAME, "uid", GID_NAME, CTIME_NAME);

        Unix(UnixPath file, boolean followLinks) {
            super(file, followLinks);
        }

        @Override // sun.nio.fs.UnixFileAttributeViews.Posix, sun.nio.fs.AbstractBasicFileAttributeView, java.nio.file.attribute.BasicFileAttributeView, java.nio.file.attribute.AttributeView
        public String name() {
            return "unix";
        }

        @Override // sun.nio.fs.UnixFileAttributeViews.Posix, sun.nio.fs.AbstractBasicFileAttributeView, sun.nio.fs.DynamicFileAttributeView
        public void setAttribute(String attribute, Object value) throws IOException {
            if (attribute.equals("mode")) {
                setMode(((Integer) value).intValue());
                return;
            }
            if (attribute.equals("uid")) {
                setOwners(((Integer) value).intValue(), -1);
            } else if (attribute.equals(GID_NAME)) {
                setOwners(-1, ((Integer) value).intValue());
            } else {
                super.setAttribute(attribute, value);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // sun.nio.fs.UnixFileAttributeViews.Posix, sun.nio.fs.AbstractBasicFileAttributeView, sun.nio.fs.DynamicFileAttributeView
        public Map<String, Object> readAttributes(String[] requested) throws IOException {
            AbstractBasicFileAttributeView.AttributesBuilder builder = AbstractBasicFileAttributeView.AttributesBuilder.create(unixAttributeNames, requested);
            UnixFileAttributes attrs = readAttributes();
            addRequestedPosixAttributes(attrs, builder);
            if (builder.match("mode")) {
                builder.add("mode", Integer.valueOf(attrs.mode()));
            }
            if (builder.match(INO_NAME)) {
                builder.add(INO_NAME, Long.valueOf(attrs.ino()));
            }
            if (builder.match(DEV_NAME)) {
                builder.add(DEV_NAME, Long.valueOf(attrs.dev()));
            }
            if (builder.match(RDEV_NAME)) {
                builder.add(RDEV_NAME, Long.valueOf(attrs.rdev()));
            }
            if (builder.match(NLINK_NAME)) {
                builder.add(NLINK_NAME, Integer.valueOf(attrs.nlink()));
            }
            if (builder.match("uid")) {
                builder.add("uid", Integer.valueOf(attrs.uid()));
            }
            if (builder.match(GID_NAME)) {
                builder.add(GID_NAME, Integer.valueOf(attrs.gid()));
            }
            if (builder.match(CTIME_NAME)) {
                builder.add(CTIME_NAME, attrs.ctime());
            }
            return builder.unmodifiableMap();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Basic createBasicView(UnixPath file, boolean followLinks) {
        return new Basic(file, followLinks);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Posix createPosixView(UnixPath file, boolean followLinks) {
        return new Posix(file, followLinks);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Unix createUnixView(UnixPath file, boolean followLinks) {
        return new Unix(file, followLinks);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static FileOwnerAttributeViewImpl createOwnerView(UnixPath file, boolean followLinks) {
        return new FileOwnerAttributeViewImpl(createPosixView(file, followLinks));
    }
}
