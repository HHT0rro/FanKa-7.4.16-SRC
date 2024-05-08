package sun.nio.fs;

import com.sun.nio.file.ExtendedCopyOption;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.LinkOption;
import java.nio.file.LinkPermission;
import java.nio.file.StandardCopyOption;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
class UnixCopyFile {
    static native void transfer(int i10, int i11, long j10) throws UnixException;

    private UnixCopyFile() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class Flags {
        boolean atomicMove;
        boolean copyBasicAttributes;
        boolean copyNonPosixAttributes;
        boolean copyPosixAttributes;
        boolean failIfUnableToCopyBasic;
        boolean failIfUnableToCopyNonPosix;
        boolean failIfUnableToCopyPosix;
        boolean followLinks;
        boolean interruptible;
        boolean replaceExisting;

        private Flags() {
        }

        static Flags fromCopyOptions(CopyOption... options) {
            Flags flags = new Flags();
            flags.followLinks = true;
            for (CopyOption option : options) {
                if (option == StandardCopyOption.REPLACE_EXISTING) {
                    flags.replaceExisting = true;
                } else if (option == LinkOption.NOFOLLOW_LINKS) {
                    flags.followLinks = false;
                } else if (option == StandardCopyOption.COPY_ATTRIBUTES) {
                    flags.copyBasicAttributes = true;
                    flags.copyPosixAttributes = true;
                    flags.copyNonPosixAttributes = true;
                    flags.failIfUnableToCopyBasic = true;
                } else if (option == ExtendedCopyOption.INTERRUPTIBLE) {
                    flags.interruptible = true;
                } else {
                    if (option == null) {
                        throw new NullPointerException();
                    }
                    throw new UnsupportedOperationException("Unsupported copy option");
                }
            }
            return flags;
        }

        static Flags fromMoveOptions(CopyOption... options) {
            Flags flags = new Flags();
            for (CopyOption option : options) {
                if (option == StandardCopyOption.ATOMIC_MOVE) {
                    flags.atomicMove = true;
                } else if (option == StandardCopyOption.REPLACE_EXISTING) {
                    flags.replaceExisting = true;
                } else if (option != LinkOption.NOFOLLOW_LINKS) {
                    if (option == null) {
                        throw new NullPointerException();
                    }
                    throw new UnsupportedOperationException("Unsupported copy option");
                }
            }
            flags.copyBasicAttributes = true;
            flags.copyPosixAttributes = true;
            flags.copyNonPosixAttributes = true;
            flags.failIfUnableToCopyBasic = true;
            return flags;
        }
    }

    private static void copyDirectory(UnixPath source, UnixFileAttributes attrs, UnixPath target, Flags flags) throws IOException {
        try {
            UnixNativeDispatcher.mkdir(target, attrs.mode());
        } catch (UnixException x10) {
            x10.rethrowAsIOException(target);
        }
        if (!flags.copyBasicAttributes && !flags.copyPosixAttributes && !flags.copyNonPosixAttributes) {
            return;
        }
        int dfd = -1;
        try {
            dfd = UnixNativeDispatcher.open(target, UnixConstants.O_RDONLY, 0);
        } catch (UnixException x11) {
            if (flags.copyNonPosixAttributes && flags.failIfUnableToCopyNonPosix) {
                try {
                    UnixNativeDispatcher.rmdir(target);
                } catch (UnixException e2) {
                }
                x11.rethrowAsIOException(target);
            }
        }
        try {
            if (flags.copyPosixAttributes) {
                try {
                    if (dfd >= 0) {
                        UnixNativeDispatcher.fchown(dfd, attrs.uid(), attrs.gid());
                        UnixNativeDispatcher.fchmod(dfd, attrs.mode());
                    } else {
                        UnixNativeDispatcher.chown(target, attrs.uid(), attrs.gid());
                        UnixNativeDispatcher.chmod(target, attrs.mode());
                    }
                } catch (UnixException x12) {
                    if (flags.failIfUnableToCopyPosix) {
                        x12.rethrowAsIOException(target);
                    }
                }
            }
            if (flags.copyNonPosixAttributes && dfd >= 0) {
                int sfd = -1;
                try {
                    sfd = UnixNativeDispatcher.open(source, UnixConstants.O_RDONLY, 0);
                } catch (UnixException x13) {
                    if (flags.failIfUnableToCopyNonPosix) {
                        x13.rethrowAsIOException(source);
                    }
                }
                if (sfd >= 0) {
                    source.getFileSystem().copyNonPosixAttributes(sfd, dfd);
                    UnixNativeDispatcher.close(sfd);
                }
            }
            if (flags.copyBasicAttributes) {
                if (dfd >= 0) {
                    try {
                        if (UnixNativeDispatcher.futimesSupported()) {
                            UnixNativeDispatcher.futimes(dfd, attrs.lastAccessTime().to(TimeUnit.MICROSECONDS), attrs.lastModifiedTime().to(TimeUnit.MICROSECONDS));
                        }
                    } catch (UnixException x14) {
                        if (flags.failIfUnableToCopyBasic) {
                            x14.rethrowAsIOException(target);
                        }
                    }
                }
                UnixNativeDispatcher.utimes(target, attrs.lastAccessTime().to(TimeUnit.MICROSECONDS), attrs.lastModifiedTime().to(TimeUnit.MICROSECONDS));
            }
            if (dfd >= 0) {
                UnixNativeDispatcher.close(dfd);
            }
            if (1 == 0) {
                try {
                    UnixNativeDispatcher.rmdir(target);
                } catch (UnixException e10) {
                }
            }
        } catch (Throwable th) {
            if (dfd >= 0) {
                UnixNativeDispatcher.close(dfd);
            }
            if (0 == 0) {
                try {
                    UnixNativeDispatcher.rmdir(target);
                } catch (UnixException e11) {
                }
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void copyFile(UnixPath source, UnixFileAttributes attrs, UnixPath target, Flags flags, long addressToPollForCancel) throws IOException {
        int fi = -1;
        try {
            fi = UnixNativeDispatcher.open(source, UnixConstants.O_RDONLY, 0);
        } catch (UnixException x10) {
            x10.rethrowAsIOException(source);
        }
        int fo = -1;
        try {
            try {
                fo = UnixNativeDispatcher.open(target, UnixConstants.O_WRONLY | UnixConstants.O_CREAT | UnixConstants.O_EXCL, attrs.mode());
            } catch (UnixException x11) {
                x11.rethrowAsIOException(target);
            }
            boolean complete = null;
            try {
                try {
                    transfer(fo, fi, addressToPollForCancel);
                } finally {
                    UnixNativeDispatcher.close(fo);
                    if (complete == null) {
                        try {
                            UnixNativeDispatcher.unlink(target);
                        } catch (UnixException e2) {
                        }
                    }
                }
            } catch (UnixException x12) {
                x12.rethrowAsIOException(source, target);
            }
            if (flags.copyPosixAttributes) {
                try {
                    UnixNativeDispatcher.fchown(fo, attrs.uid(), attrs.gid());
                    UnixNativeDispatcher.fchmod(fo, attrs.mode());
                } catch (UnixException x13) {
                    if (flags.failIfUnableToCopyPosix) {
                        x13.rethrowAsIOException(target);
                    }
                }
            }
            if (flags.copyNonPosixAttributes) {
                source.getFileSystem().copyNonPosixAttributes(fi, fo);
            }
            if (flags.copyBasicAttributes) {
                try {
                    if (UnixNativeDispatcher.futimesSupported()) {
                        UnixNativeDispatcher.futimes(fo, attrs.lastAccessTime().to(TimeUnit.MICROSECONDS), attrs.lastModifiedTime().to(TimeUnit.MICROSECONDS));
                    } else {
                        UnixNativeDispatcher.utimes(target, attrs.lastAccessTime().to(TimeUnit.MICROSECONDS), attrs.lastModifiedTime().to(TimeUnit.MICROSECONDS));
                    }
                } catch (UnixException x14) {
                    if (flags.failIfUnableToCopyBasic) {
                        x14.rethrowAsIOException(target);
                    }
                }
            }
            complete = true;
            UnixNativeDispatcher.close(fi);
        } catch (Throwable th) {
            UnixNativeDispatcher.close(fi);
            throw th;
        }
    }

    private static void copyLink(UnixPath source, UnixFileAttributes attrs, UnixPath target, Flags flags) throws IOException {
        byte[] linktarget = null;
        try {
            linktarget = UnixNativeDispatcher.readlink(source);
        } catch (UnixException x10) {
            x10.rethrowAsIOException(source);
        }
        try {
            UnixNativeDispatcher.symlink(linktarget, target);
            if (flags.copyPosixAttributes) {
                try {
                    UnixNativeDispatcher.lchown(target, attrs.uid(), attrs.gid());
                } catch (UnixException e2) {
                }
            }
        } catch (UnixException x11) {
            x11.rethrowAsIOException(target);
        }
    }

    private static void copySpecial(UnixPath source, UnixFileAttributes attrs, UnixPath target, Flags flags) throws IOException {
        try {
            UnixNativeDispatcher.mknod(target, attrs.mode(), attrs.rdev());
        } catch (UnixException x10) {
            x10.rethrowAsIOException(target);
        }
        try {
            if (flags.copyPosixAttributes) {
                try {
                    UnixNativeDispatcher.chown(target, attrs.uid(), attrs.gid());
                    UnixNativeDispatcher.chmod(target, attrs.mode());
                } catch (UnixException x11) {
                    if (flags.failIfUnableToCopyPosix) {
                        x11.rethrowAsIOException(target);
                    }
                }
            }
            if (flags.copyBasicAttributes) {
                try {
                    UnixNativeDispatcher.utimes(target, attrs.lastAccessTime().to(TimeUnit.MICROSECONDS), attrs.lastModifiedTime().to(TimeUnit.MICROSECONDS));
                } catch (UnixException x12) {
                    if (flags.failIfUnableToCopyBasic) {
                        x12.rethrowAsIOException(target);
                    }
                }
            }
            if (1 == 0) {
                try {
                    UnixNativeDispatcher.unlink(target);
                } catch (UnixException e2) {
                }
            }
        } catch (Throwable th) {
            if (0 == 0) {
                try {
                    UnixNativeDispatcher.unlink(target);
                } catch (UnixException e10) {
                }
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x009e, code lost:
    
        r1.rethrowAsIOException(r12);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void move(sun.nio.fs.UnixPath r11, sun.nio.fs.UnixPath r12, java.nio.file.CopyOption... r13) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 289
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.nio.fs.UnixCopyFile.move(sun.nio.fs.UnixPath, sun.nio.fs.UnixPath, java.nio.file.CopyOption[]):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void copy(final UnixPath source, final UnixPath target, CopyOption... options) throws IOException {
        UnixFileAttributes sourceAttrs;
        UnixFileAttributes targetAttrs;
        SecurityManager sm = System.getSecurityManager();
        if (sm != null) {
            source.checkRead();
            target.checkWrite();
        }
        final Flags flags = Flags.fromCopyOptions(options);
        try {
            UnixFileAttributes sourceAttrs2 = UnixFileAttributes.get(source, flags.followLinks);
            sourceAttrs = sourceAttrs2;
        } catch (UnixException x10) {
            x10.rethrowAsIOException(source);
            sourceAttrs = null;
        }
        if (sm != null && sourceAttrs.isSymbolicLink()) {
            sm.checkPermission(new LinkPermission("symbolic"));
        }
        try {
            UnixFileAttributes targetAttrs2 = UnixFileAttributes.get(target, false);
            targetAttrs = targetAttrs2;
        } catch (UnixException e2) {
            targetAttrs = null;
        }
        boolean targetExists = targetAttrs != null;
        if (targetExists) {
            if (sourceAttrs.isSameFile(targetAttrs)) {
                return;
            }
            if (!flags.replaceExisting) {
                throw new FileAlreadyExistsException(target.getPathForExceptionMessage());
            }
            try {
                if (targetAttrs.isDirectory()) {
                    UnixNativeDispatcher.rmdir(target);
                } else {
                    UnixNativeDispatcher.unlink(target);
                }
            } catch (UnixException x11) {
                if (targetAttrs.isDirectory() && (x11.errno() == UnixConstants.EEXIST || x11.errno() == UnixConstants.ENOTEMPTY)) {
                    throw new DirectoryNotEmptyException(target.getPathForExceptionMessage());
                }
                x11.rethrowAsIOException(target);
            }
        }
        if (sourceAttrs.isDirectory()) {
            copyDirectory(source, sourceAttrs, target, flags);
            return;
        }
        if (sourceAttrs.isSymbolicLink()) {
            copyLink(source, sourceAttrs, target, flags);
            return;
        }
        if (!flags.interruptible) {
            copyFile(source, sourceAttrs, target, flags, 0L);
            return;
        }
        final UnixFileAttributes attrsToCopy = sourceAttrs;
        Cancellable copyTask = new Cancellable() { // from class: sun.nio.fs.UnixCopyFile.1
            @Override // sun.nio.fs.Cancellable
            public void implRun() throws IOException {
                UnixCopyFile.copyFile(UnixPath.this, attrsToCopy, target, flags, addressToPollForCancel());
            }
        };
        try {
            Cancellable.runInterruptibly(copyTask);
        } catch (ExecutionException e10) {
            Throwable t2 = e10.getCause();
            if (t2 instanceof IOException) {
                throw ((IOException) t2);
            }
            throw new IOException(t2);
        }
    }
}
