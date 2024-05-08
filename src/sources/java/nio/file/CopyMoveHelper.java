package java.nio.file;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class CopyMoveHelper {
    private CopyMoveHelper() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class CopyOptions {
        boolean replaceExisting = false;
        boolean copyAttributes = false;
        boolean followLinks = true;

        private CopyOptions() {
        }

        static CopyOptions parse(CopyOption... options) {
            CopyOptions result = new CopyOptions();
            for (CopyOption option : options) {
                if (option == StandardCopyOption.REPLACE_EXISTING) {
                    result.replaceExisting = true;
                } else if (option == LinkOption.NOFOLLOW_LINKS) {
                    result.followLinks = false;
                } else if (option == StandardCopyOption.COPY_ATTRIBUTES) {
                    result.copyAttributes = true;
                } else {
                    if (option == null) {
                        throw new NullPointerException();
                    }
                    throw new UnsupportedOperationException("'" + ((Object) option) + "' is not a recognized copy option");
                }
            }
            return result;
        }
    }

    private static CopyOption[] convertMoveToCopyOptions(CopyOption... options) throws AtomicMoveNotSupportedException {
        int len = options.length;
        CopyOption[] newOptions = new CopyOption[len + 2];
        for (int i10 = 0; i10 < len; i10++) {
            CopyOption option = options[i10];
            if (option == StandardCopyOption.ATOMIC_MOVE) {
                throw new AtomicMoveNotSupportedException(null, null, "Atomic move between providers is not supported");
            }
            newOptions[i10] = option;
        }
        newOptions[len] = LinkOption.NOFOLLOW_LINKS;
        newOptions[len + 1] = StandardCopyOption.COPY_ATTRIBUTES;
        return newOptions;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void copyToForeignTarget(Path source, Path target, CopyOption... options) throws IOException {
        CopyOptions opts = CopyOptions.parse(options);
        LinkOption[] linkOptions = opts.followLinks ? new LinkOption[0] : new LinkOption[]{LinkOption.NOFOLLOW_LINKS};
        BasicFileAttributes attrs = Files.readAttributes(source, (Class<BasicFileAttributes>) BasicFileAttributes.class, linkOptions);
        if (attrs.isSymbolicLink()) {
            throw new IOException("Copying of symbolic links not supported");
        }
        if (opts.replaceExisting) {
            Files.deleteIfExists(target);
        } else if (Files.exists(target, new LinkOption[0])) {
            throw new FileAlreadyExistsException(target.toString());
        }
        if (attrs.isDirectory()) {
            Files.createDirectory(target, new FileAttribute[0]);
        } else {
            InputStream in = Files.newInputStream(source, new OpenOption[0]);
            try {
                Files.copy(in, target, new CopyOption[0]);
                if (in != null) {
                    in.close();
                }
            } catch (Throwable th) {
                if (in != null) {
                    try {
                        in.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
        if (opts.copyAttributes) {
            BasicFileAttributeView view = (BasicFileAttributeView) Files.getFileAttributeView(target, BasicFileAttributeView.class, new LinkOption[0]);
            try {
                view.setTimes(attrs.lastModifiedTime(), attrs.lastAccessTime(), attrs.creationTime());
            } catch (Throwable x10) {
                try {
                    Files.delete(target);
                } catch (Throwable suppressed) {
                    x10.addSuppressed(suppressed);
                }
                throw x10;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void moveToForeignTarget(Path source, Path target, CopyOption... options) throws IOException {
        copyToForeignTarget(source, target, convertMoveToCopyOptions(options));
        Files.delete(source);
    }
}
