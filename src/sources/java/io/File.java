package java.io;

import java.io.ObjectInputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.IOUtils;
import sun.misc.Unsafe;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class File implements Serializable, Comparable<File> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long PATH_OFFSET;
    private static final long PREFIX_LENGTH_OFFSET;
    private static final Unsafe UNSAFE;
    private static final FileSystem fs;
    public static final String pathSeparator;
    public static final char pathSeparatorChar;
    public static final String separator;
    public static final char separatorChar;
    private static final long serialVersionUID = 301077366599181567L;
    private volatile transient Path filePath;
    private final String path;
    private final transient int prefixLength;
    private transient PathStatus status = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public enum PathStatus {
        INVALID,
        CHECKED
    }

    static {
        FileSystem fileSystem = DefaultFileSystem.getFileSystem();
        fs = fileSystem;
        char separator2 = fileSystem.getSeparator();
        separatorChar = separator2;
        separator = "" + separator2;
        char pathSeparator2 = fileSystem.getPathSeparator();
        pathSeparatorChar = pathSeparator2;
        pathSeparator = "" + pathSeparator2;
        try {
            Unsafe unsafe = Unsafe.getUnsafe();
            PATH_OFFSET = unsafe.objectFieldOffset(File.class.getDeclaredField("path"));
            PREFIX_LENGTH_OFFSET = unsafe.objectFieldOffset(File.class.getDeclaredField("prefixLength"));
            UNSAFE = unsafe;
        } catch (ReflectiveOperationException e2) {
            throw new Error(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean isInvalid() {
        if (this.status == null) {
            this.status = this.path.indexOf(0) < 0 ? PathStatus.CHECKED : PathStatus.INVALID;
        }
        return this.status == PathStatus.INVALID;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getPrefixLength() {
        return this.prefixLength;
    }

    private File(String pathname, int prefixLength) {
        this.path = pathname;
        this.prefixLength = prefixLength;
    }

    private File(String child, File parent) {
        this.path = fs.resolve(parent.path, child);
        this.prefixLength = parent.prefixLength;
    }

    public File(String pathname) {
        if (pathname == null) {
            throw new NullPointerException();
        }
        FileSystem fileSystem = fs;
        String normalize = fileSystem.normalize(pathname);
        this.path = normalize;
        this.prefixLength = fileSystem.prefixLength(normalize);
    }

    public File(String parent, String child) {
        if (child == null) {
            throw new NullPointerException();
        }
        if (parent != null && !parent.isEmpty()) {
            FileSystem fileSystem = fs;
            this.path = fileSystem.resolve(fileSystem.normalize(parent), fileSystem.normalize(child));
        } else {
            this.path = fs.normalize(child);
        }
        this.prefixLength = fs.prefixLength(this.path);
    }

    public File(File parent, String child) {
        if (child == null) {
            throw new NullPointerException();
        }
        if (parent != null) {
            if (parent.path.equals("")) {
                FileSystem fileSystem = fs;
                this.path = fileSystem.resolve(fileSystem.getDefaultParent(), fileSystem.normalize(child));
            } else {
                FileSystem fileSystem2 = fs;
                this.path = fileSystem2.resolve(parent.path, fileSystem2.normalize(child));
            }
        } else {
            this.path = fs.normalize(child);
        }
        this.prefixLength = fs.prefixLength(this.path);
    }

    public File(URI uri) {
        if (!uri.isAbsolute()) {
            throw new IllegalArgumentException("URI is not absolute");
        }
        if (uri.isOpaque()) {
            throw new IllegalArgumentException("URI is not hierarchical");
        }
        String scheme = uri.getScheme();
        if (scheme == null || !scheme.equalsIgnoreCase("file")) {
            throw new IllegalArgumentException("URI scheme is not \"file\"");
        }
        if (uri.getAuthority() != null) {
            throw new IllegalArgumentException("URI has an authority component");
        }
        if (uri.getFragment() != null) {
            throw new IllegalArgumentException("URI has a fragment component");
        }
        if (uri.getQuery() != null) {
            throw new IllegalArgumentException("URI has a query component");
        }
        String p10 = uri.getPath();
        if (p10.equals("")) {
            throw new IllegalArgumentException("URI path component is empty");
        }
        FileSystem fileSystem = fs;
        String p11 = fileSystem.fromURIPath(p10);
        char c4 = separatorChar;
        String normalize = fileSystem.normalize(c4 != '/' ? p11.replace(IOUtils.DIR_SEPARATOR_UNIX, c4) : p11);
        this.path = normalize;
        this.prefixLength = fileSystem.prefixLength(normalize);
    }

    public String getName() {
        int index = this.path.lastIndexOf(separatorChar);
        int i10 = this.prefixLength;
        return index < i10 ? this.path.substring(i10) : this.path.substring(index + 1);
    }

    public String getParent() {
        int index = this.path.lastIndexOf(separatorChar);
        int i10 = this.prefixLength;
        if (index < i10) {
            if (i10 <= 0) {
                return null;
            }
            int length = this.path.length();
            int i11 = this.prefixLength;
            if (length > i11) {
                return this.path.substring(0, i11);
            }
            return null;
        }
        return this.path.substring(0, index);
    }

    public File getParentFile() {
        String p10 = getParent();
        if (p10 == null) {
            return null;
        }
        return new File(p10, this.prefixLength);
    }

    public String getPath() {
        return this.path;
    }

    public boolean isAbsolute() {
        return fs.isAbsolute(this);
    }

    public String getAbsolutePath() {
        return fs.resolve(this);
    }

    public File getAbsoluteFile() {
        String absPath = getAbsolutePath();
        return new File(absPath, fs.prefixLength(absPath));
    }

    public String getCanonicalPath() throws IOException {
        if (isInvalid()) {
            throw new IOException("Invalid file path");
        }
        FileSystem fileSystem = fs;
        return fileSystem.canonicalize(fileSystem.resolve(this));
    }

    public File getCanonicalFile() throws IOException {
        String canonPath = getCanonicalPath();
        return new File(canonPath, fs.prefixLength(canonPath));
    }

    private static String slashify(String path, boolean isDirectory) {
        String p10 = path;
        char c4 = separatorChar;
        if (c4 != '/') {
            p10 = p10.replace(c4, IOUtils.DIR_SEPARATOR_UNIX);
        }
        if (!p10.startsWith("/")) {
            p10 = "/" + p10;
        }
        if (!p10.endsWith("/") && isDirectory) {
            return p10 + "/";
        }
        return p10;
    }

    @Deprecated
    public URL toURL() throws MalformedURLException {
        if (isInvalid()) {
            throw new MalformedURLException("Invalid file path");
        }
        return new URL("file", "", slashify(getAbsolutePath(), getAbsoluteFile().isDirectory()));
    }

    public URI toURI() {
        try {
            File f10 = getAbsoluteFile();
            String sp = slashify(f10.getPath(), f10.isDirectory());
            if (sp.startsWith("//")) {
                sp = "//" + sp;
            }
            return new URI("file", null, sp, null);
        } catch (URISyntaxException x10) {
            throw new Error(x10);
        }
    }

    public boolean canRead() {
        SecurityManager security = System.getSecurityManager();
        if (security != null) {
            security.checkRead(this.path);
        }
        if (isInvalid()) {
            return false;
        }
        return fs.checkAccess(this, 4);
    }

    public boolean canWrite() {
        SecurityManager security = System.getSecurityManager();
        if (security != null) {
            security.checkWrite(this.path);
        }
        if (isInvalid()) {
            return false;
        }
        return fs.checkAccess(this, 2);
    }

    public boolean exists() {
        SecurityManager security = System.getSecurityManager();
        if (security != null) {
            security.checkRead(this.path);
        }
        if (isInvalid()) {
            return false;
        }
        return fs.checkAccess(this, 8);
    }

    public boolean isDirectory() {
        SecurityManager security = System.getSecurityManager();
        if (security != null) {
            security.checkRead(this.path);
        }
        return (isInvalid() || (fs.getBooleanAttributes(this) & 4) == 0) ? false : true;
    }

    public boolean isFile() {
        SecurityManager security = System.getSecurityManager();
        if (security != null) {
            security.checkRead(this.path);
        }
        return (isInvalid() || (fs.getBooleanAttributes(this) & 2) == 0) ? false : true;
    }

    public boolean isHidden() {
        SecurityManager security = System.getSecurityManager();
        if (security != null) {
            security.checkRead(this.path);
        }
        return (isInvalid() || (fs.getBooleanAttributes(this) & 8) == 0) ? false : true;
    }

    public long lastModified() {
        SecurityManager security = System.getSecurityManager();
        if (security != null) {
            security.checkRead(this.path);
        }
        if (isInvalid()) {
            return 0L;
        }
        return fs.getLastModifiedTime(this);
    }

    public long length() {
        SecurityManager security = System.getSecurityManager();
        if (security != null) {
            security.checkRead(this.path);
        }
        if (isInvalid()) {
            return 0L;
        }
        return fs.getLength(this);
    }

    public boolean createNewFile() throws IOException {
        SecurityManager security = System.getSecurityManager();
        if (security != null) {
            security.checkWrite(this.path);
        }
        if (isInvalid()) {
            throw new IOException("Invalid file path");
        }
        return fs.createFileExclusively(this.path);
    }

    public boolean delete() {
        SecurityManager security = System.getSecurityManager();
        if (security != null) {
            security.checkDelete(this.path);
        }
        if (isInvalid()) {
            return false;
        }
        return fs.delete(this);
    }

    public void deleteOnExit() {
        SecurityManager security = System.getSecurityManager();
        if (security != null) {
            security.checkDelete(this.path);
        }
        if (isInvalid()) {
            return;
        }
        DeleteOnExitHook.add(this.path);
    }

    public String[] list() {
        SecurityManager security = System.getSecurityManager();
        if (security != null) {
            security.checkRead(this.path);
        }
        if (isInvalid()) {
            return null;
        }
        return fs.list(this);
    }

    public String[] list(FilenameFilter filter) {
        String[] names = list();
        if (names == null || filter == null) {
            return names;
        }
        List<String> v2 = new ArrayList<>();
        for (int i10 = 0; i10 < names.length; i10++) {
            if (filter.accept(this, names[i10])) {
                v2.add(names[i10]);
            }
        }
        int i11 = v2.size();
        return (String[]) v2.toArray(new String[i11]);
    }

    public File[] listFiles() {
        String[] ss = list();
        if (ss == null) {
            return null;
        }
        int n10 = ss.length;
        File[] fs2 = new File[n10];
        for (int i10 = 0; i10 < n10; i10++) {
            fs2[i10] = new File(ss[i10], this);
        }
        return fs2;
    }

    public File[] listFiles(FilenameFilter filter) {
        String[] ss = list();
        if (ss == null) {
            return null;
        }
        ArrayList<File> files = new ArrayList<>();
        for (String s2 : ss) {
            if (filter == null || filter.accept(this, s2)) {
                files.add(new File(s2, this));
            }
        }
        return (File[]) files.toArray(new File[files.size()]);
    }

    public File[] listFiles(FileFilter filter) {
        String[] ss = list();
        if (ss == null) {
            return null;
        }
        ArrayList<File> files = new ArrayList<>();
        for (String s2 : ss) {
            File f10 = new File(s2, this);
            if (filter == null || filter.accept(f10)) {
                files.add(f10);
            }
        }
        return (File[]) files.toArray(new File[files.size()]);
    }

    public boolean mkdir() {
        SecurityManager security = System.getSecurityManager();
        if (security != null) {
            security.checkWrite(this.path);
        }
        if (isInvalid()) {
            return false;
        }
        return fs.createDirectory(this);
    }

    public boolean mkdirs() {
        if (exists()) {
            return false;
        }
        if (mkdir()) {
            return true;
        }
        try {
            File canonFile = getCanonicalFile();
            File parent = canonFile.getParentFile();
            if (parent != null) {
                return (parent.mkdirs() || parent.exists()) && canonFile.mkdir();
            }
            return false;
        } catch (IOException e2) {
            return false;
        }
    }

    public boolean renameTo(File dest) {
        SecurityManager security = System.getSecurityManager();
        if (security != null) {
            security.checkWrite(this.path);
            security.checkWrite(dest.path);
        }
        if (dest == null) {
            throw new NullPointerException();
        }
        if (isInvalid() || dest.isInvalid()) {
            return false;
        }
        return fs.rename(this, dest);
    }

    public boolean setLastModified(long time) {
        if (time < 0) {
            throw new IllegalArgumentException("Negative time");
        }
        SecurityManager security = System.getSecurityManager();
        if (security != null) {
            security.checkWrite(this.path);
        }
        if (isInvalid()) {
            return false;
        }
        return fs.setLastModifiedTime(this, time);
    }

    public boolean setReadOnly() {
        SecurityManager security = System.getSecurityManager();
        if (security != null) {
            security.checkWrite(this.path);
        }
        if (isInvalid()) {
            return false;
        }
        return fs.setReadOnly(this);
    }

    public boolean setWritable(boolean writable, boolean ownerOnly) {
        SecurityManager security = System.getSecurityManager();
        if (security != null) {
            security.checkWrite(this.path);
        }
        if (isInvalid()) {
            return false;
        }
        return fs.setPermission(this, 2, writable, ownerOnly);
    }

    public boolean setWritable(boolean writable) {
        return setWritable(writable, true);
    }

    public boolean setReadable(boolean readable, boolean ownerOnly) {
        SecurityManager security = System.getSecurityManager();
        if (security != null) {
            security.checkWrite(this.path);
        }
        if (isInvalid()) {
            return false;
        }
        return fs.setPermission(this, 4, readable, ownerOnly);
    }

    public boolean setReadable(boolean readable) {
        return setReadable(readable, true);
    }

    public boolean setExecutable(boolean executable, boolean ownerOnly) {
        SecurityManager security = System.getSecurityManager();
        if (security != null) {
            security.checkWrite(this.path);
        }
        if (isInvalid()) {
            return false;
        }
        return fs.setPermission(this, 1, executable, ownerOnly);
    }

    public boolean setExecutable(boolean executable) {
        return setExecutable(executable, true);
    }

    public boolean canExecute() {
        SecurityManager security = System.getSecurityManager();
        if (security != null) {
            security.checkExec(this.path);
        }
        if (isInvalid()) {
            return false;
        }
        return fs.checkAccess(this, 1);
    }

    public static File[] listRoots() {
        return fs.listRoots();
    }

    public long getTotalSpace() {
        SecurityManager sm = System.getSecurityManager();
        if (sm != null) {
            sm.checkPermission(new RuntimePermission("getFileSystemAttributes"));
            sm.checkRead(this.path);
        }
        if (isInvalid()) {
            return 0L;
        }
        return fs.getSpace(this, 0);
    }

    public long getFreeSpace() {
        SecurityManager sm = System.getSecurityManager();
        if (sm != null) {
            sm.checkPermission(new RuntimePermission("getFileSystemAttributes"));
            sm.checkRead(this.path);
        }
        if (isInvalid()) {
            return 0L;
        }
        return fs.getSpace(this, 1);
    }

    public long getUsableSpace() {
        SecurityManager sm = System.getSecurityManager();
        if (sm != null) {
            sm.checkPermission(new RuntimePermission("getFileSystemAttributes"));
            sm.checkRead(this.path);
        }
        if (isInvalid()) {
            return 0L;
        }
        return fs.getSpace(this, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class TempDirectory {
        private TempDirectory() {
        }

        static File generateFile(String prefix, String suffix, File dir) throws IOException {
            long n10;
            long n11 = Math.randomLongInternal();
            if (n11 == Long.MIN_VALUE) {
                n10 = 0;
            } else {
                n10 = Math.abs(n11);
            }
            String name = prefix + Long.toString(n10) + suffix;
            File f10 = new File(dir, name);
            if (!name.equals(f10.getName()) || f10.isInvalid()) {
                if (System.getSecurityManager() != null) {
                    throw new IOException("Unable to create temporary file");
                }
                throw new IOException("Unable to create temporary file, " + ((Object) f10));
            }
            return f10;
        }
    }

    public static File createTempFile(String prefix, String suffix, File directory) throws IOException {
        String suffix2;
        File f10;
        FileSystem fileSystem;
        if (prefix.length() < 3) {
            throw new IllegalArgumentException("Prefix string too short");
        }
        if (suffix != null) {
            suffix2 = suffix;
        } else {
            suffix2 = ".tmp";
        }
        File tmpdir = directory != null ? directory : new File(System.getProperty("java.io.tmpdir", "."));
        do {
            f10 = TempDirectory.generateFile(prefix, suffix2, tmpdir);
            fileSystem = fs;
        } while ((fileSystem.getBooleanAttributes(f10) & 1) != 0);
        if (!fileSystem.createFileExclusively(f10.getPath())) {
            throw new IOException("Unable to create temporary file");
        }
        return f10;
    }

    public static File createTempFile(String prefix, String suffix) throws IOException {
        return createTempFile(prefix, suffix, null);
    }

    @Override // java.lang.Comparable
    public int compareTo(File pathname) {
        return fs.compare(this, pathname);
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof File) && compareTo((File) obj) == 0;
    }

    public int hashCode() {
        return fs.hashCode(this);
    }

    public String toString() {
        return getPath();
    }

    private synchronized void writeObject(ObjectOutputStream s2) throws IOException {
        s2.defaultWriteObject();
        s2.writeChar(separatorChar);
    }

    private synchronized void readObject(ObjectInputStream s2) throws IOException, ClassNotFoundException {
        ObjectInputStream.GetField fields = s2.readFields();
        String pathField = (String) fields.get("path", (Object) null);
        char sep = s2.readChar();
        char c4 = separatorChar;
        if (sep != c4) {
            pathField = pathField.replace(sep, c4);
        }
        FileSystem fileSystem = fs;
        String path = fileSystem.normalize(pathField);
        Unsafe unsafe = UNSAFE;
        unsafe.putObject(this, PATH_OFFSET, path);
        unsafe.putIntVolatile(this, PREFIX_LENGTH_OFFSET, fileSystem.prefixLength(path));
    }

    public Path toPath() {
        Path result = this.filePath;
        if (result == null) {
            synchronized (this) {
                result = this.filePath;
                if (result == null) {
                    result = FileSystems.getDefault().getPath(this.path, new String[0]);
                    this.filePath = result;
                }
            }
        }
        return result;
    }
}
