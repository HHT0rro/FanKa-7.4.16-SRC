package java.nio.file;

import java.io.IOException;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.security.AccessController;
import java.security.SecureRandom;
import java.util.EnumSet;
import java.util.Set;
import sun.security.action.GetPropertyAction;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class TempFileHelper {
    private static final Path tmpdir = Paths.get((String) AccessController.doPrivileged(new GetPropertyAction("java.io.tmpdir")), new String[0]);
    private static final boolean isPosix = FileSystems.getDefault().supportedFileAttributeViews().contains("posix");
    private static final SecureRandom random = new SecureRandom();

    private TempFileHelper() {
    }

    private static Path generatePath(String prefix, String suffix, Path dir) {
        long n10 = random.nextLong();
        Path name = dir.getFileSystem().getPath(prefix + Long.toString(n10 == Long.MIN_VALUE ? 0L : Math.abs(n10)) + suffix, new String[0]);
        if (name.getParent() != null) {
            throw new IllegalArgumentException("Invalid prefix or suffix");
        }
        return dir.resolve(name);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class PosixPermissions {
        static final FileAttribute<Set<PosixFilePermission>> filePermissions = PosixFilePermissions.asFileAttribute(EnumSet.of(PosixFilePermission.OWNER_READ, PosixFilePermission.OWNER_WRITE));
        static final FileAttribute<Set<PosixFilePermission>> dirPermissions = PosixFilePermissions.asFileAttribute(EnumSet.of(PosixFilePermission.OWNER_READ, PosixFilePermission.OWNER_WRITE, PosixFilePermission.OWNER_EXECUTE));

        private PosixPermissions() {
        }
    }

    private static Path create(Path dir, String prefix, String suffix, boolean createDirectory, FileAttribute<?>[] attrs) throws IOException {
        FileAttribute<Set<PosixFilePermission>> fileAttribute;
        if (prefix == null) {
            prefix = "";
        }
        if (suffix == null) {
            suffix = createDirectory ? "" : ".tmp";
        }
        if (dir == null) {
            dir = tmpdir;
        }
        if (isPosix && dir.getFileSystem() == FileSystems.getDefault()) {
            if (attrs.length == 0) {
                attrs = new FileAttribute[1];
                attrs[0] = createDirectory ? PosixPermissions.dirPermissions : PosixPermissions.filePermissions;
            } else {
                boolean hasPermissions = false;
                int i10 = 0;
                while (true) {
                    if (i10 >= attrs.length) {
                        break;
                    }
                    if (!attrs[i10].name().equals("posix:permissions")) {
                        i10++;
                    } else {
                        hasPermissions = true;
                        break;
                    }
                }
                if (!hasPermissions) {
                    FileAttribute<?>[] copy = new FileAttribute[attrs.length + 1];
                    System.arraycopy(attrs, 0, copy, 0, attrs.length);
                    attrs = copy;
                    int length = attrs.length - 1;
                    if (createDirectory) {
                        fileAttribute = PosixPermissions.dirPermissions;
                    } else {
                        fileAttribute = PosixPermissions.filePermissions;
                    }
                    attrs[length] = fileAttribute;
                }
            }
        }
        SecurityManager sm = System.getSecurityManager();
        while (true) {
            try {
                Path f10 = generatePath(prefix, suffix, dir);
                try {
                    if (createDirectory) {
                        return Files.createDirectory(f10, attrs);
                    }
                    return Files.createFile(f10, attrs);
                } catch (SecurityException e2) {
                    if (dir == tmpdir && sm != null) {
                        throw new SecurityException("Unable to create temporary file or directory");
                    }
                    throw e2;
                } catch (FileAlreadyExistsException e10) {
                }
            } catch (InvalidPathException e11) {
                if (sm != null) {
                    throw new IllegalArgumentException("Invalid prefix or suffix");
                }
                throw e11;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Path createTempFile(Path dir, String prefix, String suffix, FileAttribute<?>[] attrs) throws IOException {
        return create(dir, prefix, suffix, false, attrs);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Path createTempDirectory(Path dir, String prefix, FileAttribute<?>[] attrs) throws IOException {
        return create(dir, prefix, null, true, attrs);
    }
}
