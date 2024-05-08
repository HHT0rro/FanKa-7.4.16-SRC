package sun.nio.fs;

import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.attribute.GroupPrincipal;
import java.nio.file.attribute.UserPrincipal;
import java.nio.file.attribute.UserPrincipalLookupService;
import java.nio.file.spi.FileSystemProvider;
import java.security.AccessController;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.regex.Pattern;
import org.apache.commons.io.IOUtils;
import sun.security.action.GetPropertyAction;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class UnixFileSystem extends FileSystem {
    private static final String GLOB_SYNTAX = "glob";
    private static final String REGEX_SYNTAX = "regex";
    private final byte[] defaultDirectory;
    private final boolean needToResolveAgainstDefaultDirectory;
    private final UnixFileSystemProvider provider;
    private final UnixPath rootDirectory;

    abstract FileStore getFileStore(UnixMountEntry unixMountEntry) throws IOException;

    abstract Iterable<UnixMountEntry> getMountEntries();

    /* JADX INFO: Access modifiers changed from: package-private */
    public UnixFileSystem(UnixFileSystemProvider provider, String dir) {
        this.provider = provider;
        byte[] bytes = Util.toBytes(UnixPath.normalizeAndCheck(dir));
        this.defaultDirectory = bytes;
        if (bytes[0] != 47) {
            throw new RuntimeException("default directory must be absolute");
        }
        String propValue = (String) AccessController.doPrivileged(new GetPropertyAction("sun.nio.fs.chdirAllowed", "false"));
        boolean chdirAllowed = propValue.length() == 0 ? true : Boolean.valueOf(propValue).booleanValue();
        if (chdirAllowed) {
            this.needToResolveAgainstDefaultDirectory = true;
        } else {
            byte[] cwd = UnixNativeDispatcher.getcwd();
            boolean defaultIsCwd = cwd.length == bytes.length;
            if (defaultIsCwd) {
                int i10 = 0;
                while (true) {
                    if (i10 >= cwd.length) {
                        break;
                    }
                    if (cwd[i10] == this.defaultDirectory[i10]) {
                        i10++;
                    } else {
                        defaultIsCwd = false;
                        break;
                    }
                }
            }
            this.needToResolveAgainstDefaultDirectory = defaultIsCwd ? false : true;
        }
        this.rootDirectory = new UnixPath(this, "/");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] defaultDirectory() {
        return this.defaultDirectory;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean needToResolveAgainstDefaultDirectory() {
        return this.needToResolveAgainstDefaultDirectory;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public UnixPath rootDirectory() {
        return this.rootDirectory;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isSolaris() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<String> standardFileAttributeViews() {
        return Arrays.asList("basic", "posix", "unix", "owner");
    }

    @Override // java.nio.file.FileSystem
    public final FileSystemProvider provider() {
        return this.provider;
    }

    @Override // java.nio.file.FileSystem
    public final String getSeparator() {
        return "/";
    }

    @Override // java.nio.file.FileSystem
    public final boolean isOpen() {
        return true;
    }

    @Override // java.nio.file.FileSystem
    public final boolean isReadOnly() {
        return false;
    }

    @Override // java.nio.file.FileSystem, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void copyNonPosixAttributes(int sfd, int tfd) {
    }

    @Override // java.nio.file.FileSystem
    public final Iterable<Path> getRootDirectories() {
        final List<Path> allowedList = Collections.unmodifiableList(Arrays.asList(this.rootDirectory));
        return new Iterable<Path>() { // from class: sun.nio.fs.UnixFileSystem.1
            @Override // java.lang.Iterable
            /* renamed from: iterator */
            public Iterator<Path> iterator2() {
                try {
                    SecurityManager sm = System.getSecurityManager();
                    if (sm != null) {
                        sm.checkRead(UnixFileSystem.this.rootDirectory.toString());
                    }
                    return allowedList.iterator2();
                } catch (SecurityException e2) {
                    List<Path> disallowed = Collections.emptyList();
                    return disallowed.iterator2();
                }
            }
        };
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private class FileStoreIterator implements Iterator<FileStore> {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final Iterator<UnixMountEntry> entries;
        private FileStore next;

        FileStoreIterator() {
            this.entries = UnixFileSystem.this.getMountEntries().iterator2();
        }

        private FileStore readNext() {
            while (this.entries.hasNext()) {
                UnixMountEntry entry = this.entries.next();
                if (!entry.isIgnored()) {
                    SecurityManager sm = System.getSecurityManager();
                    if (sm != null) {
                        try {
                            sm.checkRead(Util.toString(entry.dir()));
                        } catch (SecurityException e2) {
                        }
                    }
                    try {
                        return UnixFileSystem.this.getFileStore(entry);
                    } catch (IOException e10) {
                    }
                }
            }
            return null;
        }

        @Override // java.util.Iterator
        public synchronized boolean hasNext() {
            if (this.next != null) {
                return true;
            }
            FileStore readNext = readNext();
            this.next = readNext;
            return readNext != null;
        }

        @Override // java.util.Iterator
        public synchronized FileStore next() {
            FileStore result;
            if (this.next == null) {
                this.next = readNext();
            }
            result = this.next;
            if (result == null) {
                throw new NoSuchElementException();
            }
            this.next = null;
            return result;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.nio.file.FileSystem
    public final Iterable<FileStore> getFileStores() {
        SecurityManager sm = System.getSecurityManager();
        if (sm != null) {
            try {
                sm.checkPermission(new RuntimePermission("getFileStoreAttributes"));
            } catch (SecurityException e2) {
                return Collections.emptyList();
            }
        }
        return new Iterable<FileStore>() { // from class: sun.nio.fs.UnixFileSystem.2
            @Override // java.lang.Iterable
            /* renamed from: iterator */
            public Iterator<FileStore> iterator2() {
                return new FileStoreIterator();
            }
        };
    }

    @Override // java.nio.file.FileSystem
    public final Path getPath(String first, String... more) {
        String path;
        if (more.length == 0) {
            path = first;
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(first);
            for (String segment : more) {
                if (segment.length() > 0) {
                    if (sb2.length() > 0) {
                        sb2.append(IOUtils.DIR_SEPARATOR_UNIX);
                    }
                    sb2.append(segment);
                }
            }
            path = sb2.toString();
        }
        return new UnixPath(this, path);
    }

    @Override // java.nio.file.FileSystem
    public PathMatcher getPathMatcher(String syntaxAndInput) {
        String expr;
        int pos = syntaxAndInput.indexOf(58);
        if (pos <= 0 || pos == syntaxAndInput.length()) {
            throw new IllegalArgumentException();
        }
        String syntax = syntaxAndInput.substring(0, pos);
        String input = syntaxAndInput.substring(pos + 1);
        if (syntax.equals(GLOB_SYNTAX)) {
            expr = Globs.toUnixRegexPattern(input);
        } else if (syntax.equals(REGEX_SYNTAX)) {
            expr = input;
        } else {
            throw new UnsupportedOperationException("Syntax '" + syntax + "' not recognized");
        }
        final Pattern pattern = compilePathMatchPattern(expr);
        return new PathMatcher() { // from class: sun.nio.fs.UnixFileSystem.3
            @Override // java.nio.file.PathMatcher
            public boolean matches(Path path) {
                return pattern.matcher(path.toString()).matches();
            }
        };
    }

    @Override // java.nio.file.FileSystem
    public final UserPrincipalLookupService getUserPrincipalLookupService() {
        return LookupService.instance;
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private static class LookupService {
        static final UserPrincipalLookupService instance = new UserPrincipalLookupService() { // from class: sun.nio.fs.UnixFileSystem.LookupService.1
            @Override // java.nio.file.attribute.UserPrincipalLookupService
            public UserPrincipal lookupPrincipalByName(String name) throws IOException {
                return UnixUserPrincipals.lookupUser(name);
            }

            @Override // java.nio.file.attribute.UserPrincipalLookupService
            public GroupPrincipal lookupPrincipalByGroupName(String group) throws IOException {
                return UnixUserPrincipals.lookupGroup(group);
            }
        };

        private LookupService() {
        }
    }

    Pattern compilePathMatchPattern(String expr) {
        return Pattern.compile(expr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public char[] normalizeNativePath(char[] path) {
        return path;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String normalizeJavaPath(String path) {
        return path;
    }
}
