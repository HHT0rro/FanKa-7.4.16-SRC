package sun.nio.fs;

import java.io.FileDescriptor;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.FileChannel;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.StandardOpenOption;
import java.util.Set;
import jdk.internal.misc.JavaIOFileDescriptorAccess;
import jdk.internal.misc.SharedSecrets;
import sun.nio.ch.FileChannelImpl;
import sun.nio.ch.SimpleAsynchronousFileChannelImpl;
import sun.nio.ch.ThreadPool;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
class UnixChannelFactory {
    private static final JavaIOFileDescriptorAccess fdAccess = SharedSecrets.getJavaIOFileDescriptorAccess();

    protected UnixChannelFactory() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class Flags {
        boolean append;
        boolean create;
        boolean createNew;
        boolean deleteOnClose;
        boolean dsync;
        boolean noFollowLinks;
        boolean read;
        boolean sync;
        boolean truncateExisting;
        boolean write;

        protected Flags() {
        }

        static Flags toFlags(Set<? extends OpenOption> options) {
            Flags flags = new Flags();
            for (OpenOption option : options) {
                if (option instanceof StandardOpenOption) {
                    switch (AnonymousClass1.$SwitchMap$java$nio$file$StandardOpenOption[((StandardOpenOption) option).ordinal()]) {
                        case 1:
                            flags.read = true;
                            break;
                        case 2:
                            flags.write = true;
                            break;
                        case 3:
                            flags.append = true;
                            break;
                        case 4:
                            flags.truncateExisting = true;
                            break;
                        case 5:
                            flags.create = true;
                            break;
                        case 6:
                            flags.createNew = true;
                            break;
                        case 7:
                            flags.deleteOnClose = true;
                            break;
                        case 8:
                            break;
                        case 9:
                            flags.sync = true;
                            break;
                        case 10:
                            flags.dsync = true;
                            break;
                        default:
                            throw new UnsupportedOperationException();
                    }
                } else if (option == LinkOption.NOFOLLOW_LINKS && UnixConstants.O_NOFOLLOW != 0) {
                    flags.noFollowLinks = true;
                } else {
                    if (option == null) {
                        throw new NullPointerException();
                    }
                    throw new UnsupportedOperationException(((Object) option) + " not supported");
                }
            }
            return flags;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* renamed from: sun.nio.fs.UnixChannelFactory$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$java$nio$file$StandardOpenOption;

        static {
            int[] iArr = new int[StandardOpenOption.values().length];
            $SwitchMap$java$nio$file$StandardOpenOption = iArr;
            try {
                iArr[StandardOpenOption.READ.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$java$nio$file$StandardOpenOption[StandardOpenOption.WRITE.ordinal()] = 2;
            } catch (NoSuchFieldError e10) {
            }
            try {
                $SwitchMap$java$nio$file$StandardOpenOption[StandardOpenOption.APPEND.ordinal()] = 3;
            } catch (NoSuchFieldError e11) {
            }
            try {
                $SwitchMap$java$nio$file$StandardOpenOption[StandardOpenOption.TRUNCATE_EXISTING.ordinal()] = 4;
            } catch (NoSuchFieldError e12) {
            }
            try {
                $SwitchMap$java$nio$file$StandardOpenOption[StandardOpenOption.CREATE.ordinal()] = 5;
            } catch (NoSuchFieldError e13) {
            }
            try {
                $SwitchMap$java$nio$file$StandardOpenOption[StandardOpenOption.CREATE_NEW.ordinal()] = 6;
            } catch (NoSuchFieldError e14) {
            }
            try {
                $SwitchMap$java$nio$file$StandardOpenOption[StandardOpenOption.DELETE_ON_CLOSE.ordinal()] = 7;
            } catch (NoSuchFieldError e15) {
            }
            try {
                $SwitchMap$java$nio$file$StandardOpenOption[StandardOpenOption.SPARSE.ordinal()] = 8;
            } catch (NoSuchFieldError e16) {
            }
            try {
                $SwitchMap$java$nio$file$StandardOpenOption[StandardOpenOption.SYNC.ordinal()] = 9;
            } catch (NoSuchFieldError e17) {
            }
            try {
                $SwitchMap$java$nio$file$StandardOpenOption[StandardOpenOption.DSYNC.ordinal()] = 10;
            } catch (NoSuchFieldError e18) {
            }
        }
    }

    static FileChannel newFileChannel(int fd2, String path, boolean reading, boolean writing) {
        FileDescriptor fdObj = new FileDescriptor();
        fdAccess.set(fdObj, fd2);
        return FileChannelImpl.open(fdObj, path, reading, writing, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static FileChannel newFileChannel(int dfd, UnixPath path, String pathForPermissionCheck, Set<? extends OpenOption> options, int mode) throws UnixException {
        Flags flags = Flags.toFlags(options);
        if (!flags.read && !flags.write) {
            if (flags.append) {
                flags.write = true;
            } else {
                flags.read = true;
            }
        }
        if (flags.read && flags.append) {
            throw new IllegalArgumentException("READ + APPEND not allowed");
        }
        if (flags.append && flags.truncateExisting) {
            throw new IllegalArgumentException("APPEND + TRUNCATE_EXISTING not allowed");
        }
        FileDescriptor fdObj = open(dfd, path, pathForPermissionCheck, flags, mode);
        return FileChannelImpl.open(fdObj, path.toString(), flags.read, flags.write, flags.append, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static FileChannel newFileChannel(UnixPath path, Set<? extends OpenOption> options, int mode) throws UnixException {
        return newFileChannel(-1, path, null, options, mode);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static AsynchronousFileChannel newAsynchronousFileChannel(UnixPath path, Set<? extends OpenOption> options, int mode, ThreadPool pool) throws UnixException {
        Flags flags = Flags.toFlags(options);
        if (!flags.read && !flags.write) {
            flags.read = true;
        }
        if (flags.append) {
            throw new UnsupportedOperationException("APPEND not allowed");
        }
        FileDescriptor fdObj = open(-1, path, null, flags, mode);
        return SimpleAsynchronousFileChannelImpl.open(fdObj, flags.read, flags.write, pool);
    }

    protected static FileDescriptor open(int dfd, UnixPath path, String pathForPermissionCheck, Flags flags, int mode) throws UnixException {
        int oflags;
        int fd2;
        if (flags.read && flags.write) {
            oflags = UnixConstants.O_RDWR;
        } else {
            oflags = flags.write ? UnixConstants.O_WRONLY : UnixConstants.O_RDONLY;
        }
        if (flags.write) {
            if (flags.truncateExisting) {
                oflags |= UnixConstants.O_TRUNC;
            }
            if (flags.append) {
                oflags |= UnixConstants.O_APPEND;
            }
            if (flags.createNew) {
                byte[] pathForSysCall = path.asByteArray();
                if (pathForSysCall[pathForSysCall.length - 1] == 46 && (pathForSysCall.length == 1 || pathForSysCall[pathForSysCall.length - 2] == 47)) {
                    throw new UnixException(UnixConstants.EEXIST);
                }
                oflags |= UnixConstants.O_CREAT | UnixConstants.O_EXCL;
            } else if (flags.create) {
                oflags |= UnixConstants.O_CREAT;
            }
        }
        boolean followLinks = true;
        if (!flags.createNew && (flags.noFollowLinks || flags.deleteOnClose)) {
            if (flags.deleteOnClose && UnixConstants.O_NOFOLLOW == 0) {
                try {
                    if (UnixFileAttributes.get(path, false).isSymbolicLink()) {
                        throw new UnixException("DELETE_ON_CLOSE specified and file is a symbolic link");
                    }
                } catch (UnixException x10) {
                    if (!flags.create || x10.errno() != UnixConstants.ENOENT) {
                        throw x10;
                    }
                }
            }
            followLinks = false;
            oflags |= UnixConstants.O_NOFOLLOW;
        }
        if (flags.dsync) {
            oflags |= UnixConstants.O_DSYNC;
        }
        if (flags.sync) {
            oflags |= UnixConstants.O_SYNC;
        }
        SecurityManager sm = System.getSecurityManager();
        if (sm != null) {
            if (pathForPermissionCheck == null) {
                pathForPermissionCheck = path.getPathForPermissionCheck();
            }
            if (flags.read) {
                sm.checkRead(pathForPermissionCheck);
            }
            if (flags.write) {
                sm.checkWrite(pathForPermissionCheck);
            }
            if (flags.deleteOnClose) {
                sm.checkDelete(pathForPermissionCheck);
            }
        }
        try {
            if (dfd >= 0) {
                fd2 = UnixNativeDispatcher.openat(dfd, path.asByteArray(), oflags, mode);
            } else {
                fd2 = UnixNativeDispatcher.open(path, oflags, mode);
            }
            if (flags.deleteOnClose) {
                try {
                    if (dfd >= 0) {
                        UnixNativeDispatcher.unlinkat(dfd, path.asByteArray(), 0);
                    } else {
                        UnixNativeDispatcher.unlink(path);
                    }
                } catch (UnixException e2) {
                }
            }
            FileDescriptor fdObj = new FileDescriptor();
            fdAccess.set(fdObj, fd2);
            return fdObj;
        } catch (UnixException x11) {
            if (flags.createNew && x11.errno() == UnixConstants.EISDIR) {
                x11.setError(UnixConstants.EEXIST);
            }
            if (followLinks || x11.errno() != UnixConstants.ELOOP) {
                throw x11;
            }
            throw new UnixException(x11.getMessage() + " (NOFOLLOW_LINKS specified)");
        }
    }
}
