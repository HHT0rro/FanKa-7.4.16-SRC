package java.io;

import android.system.ErrnoException;
import android.system.OsConstants;
import dalvik.system.BlockGuard;
import java.util.Properties;
import java.util.zip.ZipUtils;
import jdk.internal.util.StaticProperty;
import libcore.io.Libcore;
import org.apache.commons.io.IOUtils;
import sun.security.action.GetPropertyAction;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class UnixFileSystem extends FileSystem {
    private final char colon;
    private final String javaHome;
    private final char slash;
    private final String userDir;
    private ExpiringCache cache = new ExpiringCache();
    private ExpiringCache javaHomePrefixCache = new ExpiringCache();

    private native String canonicalize0(String str) throws IOException;

    private native boolean createDirectory0(File file);

    private native boolean createFileExclusively0(String str) throws IOException;

    private native int getBooleanAttributes0(String str);

    private native long getLastModifiedTime0(File file);

    private native long getNameMax0(String str);

    private native long getSpace0(File file, int i10);

    private static native void initIDs();

    private native String[] list0(File file);

    private native boolean setLastModifiedTime0(File file, long j10);

    private native boolean setPermission0(File file, int i10, boolean z10, boolean z11);

    private native boolean setReadOnly0(File file);

    public UnixFileSystem() {
        Properties props = GetPropertyAction.privilegedGetProperties();
        this.slash = props.getProperty("file.separator").charAt(0);
        this.colon = props.getProperty("path.separator").charAt(0);
        this.javaHome = StaticProperty.javaHome();
        this.userDir = StaticProperty.userDir();
    }

    @Override // java.io.FileSystem
    public char getSeparator() {
        return this.slash;
    }

    @Override // java.io.FileSystem
    public char getPathSeparator() {
        return this.colon;
    }

    @Override // java.io.FileSystem
    public String normalize(String pathname) {
        int n10 = pathname.length();
        char[] normalized = pathname.toCharArray();
        int index = 0;
        char prevChar = 0;
        for (int i10 = 0; i10 < n10; i10++) {
            char current = normalized[i10];
            if (current != '/' || prevChar != '/') {
                normalized[index] = current;
                index++;
            }
            prevChar = current;
        }
        if (prevChar == '/' && n10 > 1) {
            index--;
        }
        return index != n10 ? new String(normalized, 0, index) : pathname;
    }

    @Override // java.io.FileSystem
    public int prefixLength(String pathname) {
        return (!pathname.isEmpty() && pathname.charAt(0) == '/') ? 1 : 0;
    }

    @Override // java.io.FileSystem
    public String resolve(String parent, String child) {
        if (child.isEmpty() || child.equals("/")) {
            return parent;
        }
        return child.charAt(0) == '/' ? parent.equals("/") ? child : parent + child : parent.equals("/") ? parent + child : parent + IOUtils.DIR_SEPARATOR_UNIX + child;
    }

    @Override // java.io.FileSystem
    public String getDefaultParent() {
        return "/";
    }

    @Override // java.io.FileSystem
    public String fromURIPath(String path) {
        if (!path.endsWith("/") || path.length() <= 1) {
            return path;
        }
        String p10 = path.substring(0, path.length() - 1);
        return p10;
    }

    @Override // java.io.FileSystem
    public boolean isAbsolute(File f10) {
        return f10.getPrefixLength() != 0;
    }

    @Override // java.io.FileSystem
    public String resolve(File f10) {
        if (isAbsolute(f10)) {
            return f10.getPath();
        }
        SecurityManager sm = System.getSecurityManager();
        if (sm != null) {
            sm.checkPropertyAccess("user.dir");
        }
        return resolve(this.userDir, f10.getPath());
    }

    @Override // java.io.FileSystem
    public String canonicalize(String path) throws IOException {
        String resDir;
        String resDir2;
        if (!useCanonCaches) {
            return canonicalize0(path);
        }
        String res = this.cache.get(path);
        if (res == null) {
            String dir = null;
            if (useCanonPrefixCache && (dir = parentOrNull(path)) != null && (resDir2 = this.javaHomePrefixCache.get(dir)) != null) {
                String filename = path.substring(dir.length() + 1);
                res = resDir2 + this.slash + filename;
                this.cache.put(dir + this.slash + filename, res);
            }
            if (res == null) {
                BlockGuard.getThreadPolicy().onReadFromDisk();
                BlockGuard.getVmPolicy().onPathAccess(path);
                res = canonicalize0(path);
                this.cache.put(path, res);
                if (useCanonPrefixCache && dir != null && dir.startsWith(this.javaHome) && (resDir = parentOrNull(res)) != null && resDir.equals(dir)) {
                    File f10 = new File(res);
                    if (f10.exists() && !f10.isDirectory()) {
                        this.javaHomePrefixCache.put(dir, resDir);
                    }
                }
            }
        }
        return res;
    }

    static String parentOrNull(String path) {
        if (path == null) {
            return null;
        }
        char sep = File.separatorChar;
        int last = path.length() - 1;
        int adjacentDots = 0;
        int nonDotCount = 0;
        for (int idx = last; idx > 0; idx--) {
            char c4 = path.charAt(idx);
            if (c4 == '.') {
                adjacentDots++;
                if (adjacentDots >= 2) {
                    return null;
                }
            } else {
                if (c4 == sep) {
                    if ((adjacentDots == 1 && nonDotCount == 0) || idx == 0 || idx >= last - 1 || path.charAt(idx - 1) == sep) {
                        return null;
                    }
                    return path.substring(0, idx);
                }
                nonDotCount++;
                adjacentDots = 0;
            }
        }
        return null;
    }

    @Override // java.io.FileSystem
    public int getBooleanAttributes(File f10) {
        BlockGuard.getThreadPolicy().onReadFromDisk();
        BlockGuard.getVmPolicy().onPathAccess(f10.getPath());
        int rv = getBooleanAttributes0(f10.getPath());
        String name = f10.getName();
        boolean hidden = !name.isEmpty() && name.charAt(0) == '.';
        return (hidden ? 8 : 0) | rv;
    }

    @Override // java.io.FileSystem
    public boolean checkAccess(File f10, int access) {
        int mode;
        switch (access) {
            case 1:
                mode = OsConstants.X_OK;
                break;
            case 2:
                mode = OsConstants.W_OK;
                break;
            case 4:
                mode = OsConstants.R_OK;
                break;
            case 8:
                mode = OsConstants.F_OK;
                break;
            default:
                throw new IllegalArgumentException("Bad access mode: " + access);
        }
        try {
            return Libcore.os.access(f10.getPath(), mode);
        } catch (ErrnoException e2) {
            return false;
        }
    }

    @Override // java.io.FileSystem
    public long getLastModifiedTime(File f10) {
        BlockGuard.getThreadPolicy().onReadFromDisk();
        BlockGuard.getVmPolicy().onPathAccess(f10.getPath());
        return getLastModifiedTime0(f10);
    }

    @Override // java.io.FileSystem
    public long getLength(File f10) {
        try {
            return Libcore.os.stat(f10.getPath()).st_size;
        } catch (ErrnoException e2) {
            return 0L;
        }
    }

    @Override // java.io.FileSystem
    public boolean setPermission(File f10, int access, boolean enable, boolean owneronly) {
        BlockGuard.getThreadPolicy().onWriteToDisk();
        BlockGuard.getVmPolicy().onPathAccess(f10.getPath());
        return setPermission0(f10, access, enable, owneronly);
    }

    @Override // java.io.FileSystem
    public boolean createFileExclusively(String path) throws IOException {
        BlockGuard.getThreadPolicy().onWriteToDisk();
        BlockGuard.getVmPolicy().onPathAccess(path);
        return createFileExclusively0(path);
    }

    @Override // java.io.FileSystem
    public boolean delete(File f10) {
        this.cache.clear();
        this.javaHomePrefixCache.clear();
        try {
            Libcore.os.remove(f10.getPath());
            return true;
        } catch (ErrnoException e2) {
            return false;
        }
    }

    @Override // java.io.FileSystem
    public String[] list(File f10) {
        BlockGuard.getThreadPolicy().onReadFromDisk();
        BlockGuard.getVmPolicy().onPathAccess(f10.getPath());
        return list0(f10);
    }

    @Override // java.io.FileSystem
    public boolean createDirectory(File f10) {
        BlockGuard.getThreadPolicy().onWriteToDisk();
        BlockGuard.getVmPolicy().onPathAccess(f10.getPath());
        return createDirectory0(f10);
    }

    @Override // java.io.FileSystem
    public boolean rename(File f12, File f22) {
        this.cache.clear();
        this.javaHomePrefixCache.clear();
        try {
            Libcore.os.rename(f12.getPath(), f22.getPath());
            return true;
        } catch (ErrnoException e2) {
            return false;
        }
    }

    @Override // java.io.FileSystem
    public boolean setLastModifiedTime(File f10, long time) {
        BlockGuard.getThreadPolicy().onWriteToDisk();
        BlockGuard.getVmPolicy().onPathAccess(f10.getPath());
        return setLastModifiedTime0(f10, time);
    }

    @Override // java.io.FileSystem
    public boolean setReadOnly(File f10) {
        BlockGuard.getThreadPolicy().onWriteToDisk();
        BlockGuard.getVmPolicy().onPathAccess(f10.getPath());
        return setReadOnly0(f10);
    }

    @Override // java.io.FileSystem
    public File[] listRoots() {
        try {
            SecurityManager security = System.getSecurityManager();
            if (security != null) {
                security.checkRead("/");
            }
            return new File[]{new File("/")};
        } catch (SecurityException e2) {
            return new File[0];
        }
    }

    @Override // java.io.FileSystem
    public long getSpace(File f10, int t2) {
        BlockGuard.getThreadPolicy().onReadFromDisk();
        BlockGuard.getVmPolicy().onPathAccess(f10.getPath());
        return getSpace0(f10, t2);
    }

    @Override // java.io.FileSystem
    public int getNameMax(String path) {
        long nameMax = getNameMax0(path);
        if (nameMax > ZipUtils.UPPER_UNIXTIME_BOUND) {
            nameMax = ZipUtils.UPPER_UNIXTIME_BOUND;
        }
        return (int) nameMax;
    }

    @Override // java.io.FileSystem
    public int compare(File f12, File f22) {
        return f12.getPath().compareTo(f22.getPath());
    }

    @Override // java.io.FileSystem
    public int hashCode(File f10) {
        return f10.getPath().hashCode() ^ 1234321;
    }

    static {
        initIDs();
    }
}
