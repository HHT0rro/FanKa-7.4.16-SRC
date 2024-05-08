package sun.nio.fs;

import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermission;
import java.util.Set;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
class UnixFileModeAttribute {
    static final int ALL_PERMISSIONS = (((((((UnixConstants.S_IRUSR | UnixConstants.S_IWUSR) | UnixConstants.S_IXUSR) | UnixConstants.S_IRGRP) | UnixConstants.S_IWGRP) | UnixConstants.S_IXGRP) | UnixConstants.S_IROTH) | UnixConstants.S_IWOTH) | UnixConstants.S_IXOTH;
    static final int ALL_READWRITE = ((((UnixConstants.S_IRUSR | UnixConstants.S_IWUSR) | UnixConstants.S_IRGRP) | UnixConstants.S_IWGRP) | UnixConstants.S_IROTH) | UnixConstants.S_IWOTH;
    static final int TEMPFILE_PERMISSIONS = (UnixConstants.S_IRUSR | UnixConstants.S_IWUSR) | UnixConstants.S_IXUSR;

    private UnixFileModeAttribute() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int toUnixMode(Set<PosixFilePermission> perms) {
        int mode = 0;
        for (PosixFilePermission perm : perms) {
            if (perm == null) {
                throw new NullPointerException();
            }
            switch (AnonymousClass1.$SwitchMap$java$nio$file$attribute$PosixFilePermission[perm.ordinal()]) {
                case 1:
                    mode |= UnixConstants.S_IRUSR;
                    break;
                case 2:
                    mode |= UnixConstants.S_IWUSR;
                    break;
                case 3:
                    mode |= UnixConstants.S_IXUSR;
                    break;
                case 4:
                    mode |= UnixConstants.S_IRGRP;
                    break;
                case 5:
                    mode |= UnixConstants.S_IWGRP;
                    break;
                case 6:
                    mode |= UnixConstants.S_IXGRP;
                    break;
                case 7:
                    mode |= UnixConstants.S_IROTH;
                    break;
                case 8:
                    mode |= UnixConstants.S_IWOTH;
                    break;
                case 9:
                    mode |= UnixConstants.S_IXOTH;
                    break;
            }
        }
        return mode;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* renamed from: sun.nio.fs.UnixFileModeAttribute$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$java$nio$file$attribute$PosixFilePermission;

        static {
            int[] iArr = new int[PosixFilePermission.values().length];
            $SwitchMap$java$nio$file$attribute$PosixFilePermission = iArr;
            try {
                iArr[PosixFilePermission.OWNER_READ.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$java$nio$file$attribute$PosixFilePermission[PosixFilePermission.OWNER_WRITE.ordinal()] = 2;
            } catch (NoSuchFieldError e10) {
            }
            try {
                $SwitchMap$java$nio$file$attribute$PosixFilePermission[PosixFilePermission.OWNER_EXECUTE.ordinal()] = 3;
            } catch (NoSuchFieldError e11) {
            }
            try {
                $SwitchMap$java$nio$file$attribute$PosixFilePermission[PosixFilePermission.GROUP_READ.ordinal()] = 4;
            } catch (NoSuchFieldError e12) {
            }
            try {
                $SwitchMap$java$nio$file$attribute$PosixFilePermission[PosixFilePermission.GROUP_WRITE.ordinal()] = 5;
            } catch (NoSuchFieldError e13) {
            }
            try {
                $SwitchMap$java$nio$file$attribute$PosixFilePermission[PosixFilePermission.GROUP_EXECUTE.ordinal()] = 6;
            } catch (NoSuchFieldError e14) {
            }
            try {
                $SwitchMap$java$nio$file$attribute$PosixFilePermission[PosixFilePermission.OTHERS_READ.ordinal()] = 7;
            } catch (NoSuchFieldError e15) {
            }
            try {
                $SwitchMap$java$nio$file$attribute$PosixFilePermission[PosixFilePermission.OTHERS_WRITE.ordinal()] = 8;
            } catch (NoSuchFieldError e16) {
            }
            try {
                $SwitchMap$java$nio$file$attribute$PosixFilePermission[PosixFilePermission.OTHERS_EXECUTE.ordinal()] = 9;
            } catch (NoSuchFieldError e17) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int toUnixMode(int defaultMode, FileAttribute<?>... attrs) {
        int mode = defaultMode;
        for (FileAttribute<?> attr : attrs) {
            String name = attr.name();
            if (!name.equals("posix:permissions") && !name.equals("unix:permissions")) {
                throw new UnsupportedOperationException("'" + attr.name() + "' not supported as initial attribute");
            }
            mode = toUnixMode((Set) attr.value());
        }
        return mode;
    }
}
