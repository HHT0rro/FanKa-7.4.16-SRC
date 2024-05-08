package java.nio.file.attribute;

import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class PosixFilePermissions {
    private PosixFilePermissions() {
    }

    private static void writeBits(StringBuilder sb2, boolean r10, boolean w3, boolean x10) {
        if (r10) {
            sb2.append('r');
        } else {
            sb2.append('-');
        }
        if (w3) {
            sb2.append('w');
        } else {
            sb2.append('-');
        }
        if (x10) {
            sb2.append(Locale.PRIVATE_USE_EXTENSION);
        } else {
            sb2.append('-');
        }
    }

    public static String toString(Set<PosixFilePermission> perms) {
        StringBuilder sb2 = new StringBuilder(9);
        writeBits(sb2, perms.contains(PosixFilePermission.OWNER_READ), perms.contains(PosixFilePermission.OWNER_WRITE), perms.contains(PosixFilePermission.OWNER_EXECUTE));
        writeBits(sb2, perms.contains(PosixFilePermission.GROUP_READ), perms.contains(PosixFilePermission.GROUP_WRITE), perms.contains(PosixFilePermission.GROUP_EXECUTE));
        writeBits(sb2, perms.contains(PosixFilePermission.OTHERS_READ), perms.contains(PosixFilePermission.OTHERS_WRITE), perms.contains(PosixFilePermission.OTHERS_EXECUTE));
        return sb2.toString();
    }

    private static boolean isSet(char c4, char setValue) {
        if (c4 == setValue) {
            return true;
        }
        if (c4 == '-') {
            return false;
        }
        throw new IllegalArgumentException("Invalid mode");
    }

    private static boolean isR(char c4) {
        return isSet(c4, 'r');
    }

    private static boolean isW(char c4) {
        return isSet(c4, 'w');
    }

    private static boolean isX(char c4) {
        return isSet(c4, Locale.PRIVATE_USE_EXTENSION);
    }

    public static Set<PosixFilePermission> fromString(String perms) {
        if (perms.length() != 9) {
            throw new IllegalArgumentException("Invalid mode");
        }
        Set<PosixFilePermission> result = EnumSet.noneOf(PosixFilePermission.class);
        if (isR(perms.charAt(0))) {
            result.add(PosixFilePermission.OWNER_READ);
        }
        if (isW(perms.charAt(1))) {
            result.add(PosixFilePermission.OWNER_WRITE);
        }
        if (isX(perms.charAt(2))) {
            result.add(PosixFilePermission.OWNER_EXECUTE);
        }
        if (isR(perms.charAt(3))) {
            result.add(PosixFilePermission.GROUP_READ);
        }
        if (isW(perms.charAt(4))) {
            result.add(PosixFilePermission.GROUP_WRITE);
        }
        if (isX(perms.charAt(5))) {
            result.add(PosixFilePermission.GROUP_EXECUTE);
        }
        if (isR(perms.charAt(6))) {
            result.add(PosixFilePermission.OTHERS_READ);
        }
        if (isW(perms.charAt(7))) {
            result.add(PosixFilePermission.OTHERS_WRITE);
        }
        if (isX(perms.charAt(8))) {
            result.add(PosixFilePermission.OTHERS_EXECUTE);
        }
        return result;
    }

    public static FileAttribute<Set<PosixFilePermission>> asFileAttribute(Set<PosixFilePermission> perms) {
        final Set<PosixFilePermission> perms2 = new HashSet<>(perms);
        for (PosixFilePermission p10 : perms2) {
            if (p10 == null) {
                throw new NullPointerException();
            }
        }
        return new FileAttribute<Set<PosixFilePermission>>() { // from class: java.nio.file.attribute.PosixFilePermissions.1
            @Override // java.nio.file.attribute.FileAttribute
            public String name() {
                return "posix:permissions";
            }

            @Override // java.nio.file.attribute.FileAttribute
            public Set<PosixFilePermission> value() {
                return Collections.unmodifiableSet(Set.this);
            }
        };
    }
}
