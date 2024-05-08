package java.io;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class FileSystem {
    public static final int ACCESS_EXECUTE = 1;
    public static final int ACCESS_OK = 8;
    public static final int ACCESS_READ = 4;
    public static final int ACCESS_WRITE = 2;
    public static final int BA_DIRECTORY = 4;
    public static final int BA_EXISTS = 1;
    public static final int BA_HIDDEN = 8;
    public static final int BA_REGULAR = 2;
    public static final int SPACE_FREE = 1;
    public static final int SPACE_TOTAL = 0;
    public static final int SPACE_USABLE = 2;
    static boolean useCanonCaches;
    static boolean useCanonPrefixCache;

    public abstract String canonicalize(String str) throws IOException;

    public abstract boolean checkAccess(File file, int i10);

    public abstract int compare(File file, File file2);

    public abstract boolean createDirectory(File file);

    public abstract boolean createFileExclusively(String str) throws IOException;

    public abstract boolean delete(File file);

    public abstract String fromURIPath(String str);

    public abstract int getBooleanAttributes(File file);

    public abstract String getDefaultParent();

    public abstract long getLastModifiedTime(File file);

    public abstract long getLength(File file);

    public abstract int getNameMax(String str);

    public abstract char getPathSeparator();

    public abstract char getSeparator();

    public abstract long getSpace(File file, int i10);

    public abstract int hashCode(File file);

    public abstract boolean isAbsolute(File file);

    public abstract String[] list(File file);

    public abstract File[] listRoots();

    public abstract String normalize(String str);

    public abstract int prefixLength(String str);

    public abstract boolean rename(File file, File file2);

    public abstract String resolve(File file);

    public abstract String resolve(String str, String str2);

    public abstract boolean setLastModifiedTime(File file, long j10);

    public abstract boolean setPermission(File file, int i10, boolean z10, boolean z11);

    public abstract boolean setReadOnly(File file);

    static {
        useCanonCaches = false;
        useCanonPrefixCache = false;
        useCanonCaches = getBooleanProperty("sun.io.useCanonCaches", false);
        useCanonPrefixCache = getBooleanProperty("sun.io.useCanonPrefixCache", useCanonPrefixCache);
    }

    private static boolean getBooleanProperty(String prop, boolean defaultVal) {
        return Boolean.parseBoolean(System.getProperty(prop, String.valueOf(defaultVal)));
    }
}
