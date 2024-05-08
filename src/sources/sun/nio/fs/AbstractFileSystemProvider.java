package sun.nio.fs;

import java.io.IOException;
import java.nio.file.AccessMode;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.spi.FileSystemProvider;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class AbstractFileSystemProvider extends FileSystemProvider {
    abstract DynamicFileAttributeView getFileAttributeView(Path path, String str, LinkOption... linkOptionArr);

    public abstract byte[] getSunPathForSocketFile(Path path);

    abstract boolean implDelete(Path path, boolean z10) throws IOException;

    private static String[] split(String attribute) {
        String[] s2 = new String[2];
        int pos = attribute.indexOf(58);
        if (pos == -1) {
            s2[0] = "basic";
            s2[1] = attribute;
        } else {
            int pos2 = pos + 1;
            s2[0] = attribute.substring(0, pos);
            s2[1] = pos2 == attribute.length() ? "" : attribute.substring(pos2);
        }
        return s2;
    }

    @Override // java.nio.file.spi.FileSystemProvider
    public final void setAttribute(Path file, String attribute, Object value, LinkOption... options) throws IOException {
        String[] s2 = split(attribute);
        if (s2[0].isEmpty()) {
            throw new IllegalArgumentException(attribute);
        }
        DynamicFileAttributeView view = getFileAttributeView(file, s2[0], options);
        if (view == null) {
            throw new UnsupportedOperationException("View '" + s2[0] + "' not available");
        }
        view.setAttribute(s2[1], value);
    }

    @Override // java.nio.file.spi.FileSystemProvider
    public final Map<String, Object> readAttributes(Path file, String attributes, LinkOption... options) throws IOException {
        String[] s2 = split(attributes);
        if (s2[0].isEmpty()) {
            throw new IllegalArgumentException(attributes);
        }
        DynamicFileAttributeView view = getFileAttributeView(file, s2[0], options);
        if (view == null) {
            throw new UnsupportedOperationException("View '" + s2[0] + "' not available");
        }
        return view.readAttributes(s2[1].split(","));
    }

    @Override // java.nio.file.spi.FileSystemProvider
    public final void delete(Path file) throws IOException {
        implDelete(file, true);
    }

    @Override // java.nio.file.spi.FileSystemProvider
    public final boolean deleteIfExists(Path file) throws IOException {
        return implDelete(file, false);
    }

    public boolean isDirectory(Path file) {
        try {
            return readAttributes(file, BasicFileAttributes.class, new LinkOption[0]).isDirectory();
        } catch (IOException e2) {
            return false;
        }
    }

    public boolean isRegularFile(Path file) {
        try {
            return readAttributes(file, BasicFileAttributes.class, new LinkOption[0]).isRegularFile();
        } catch (IOException e2) {
            return false;
        }
    }

    public boolean exists(Path file) {
        try {
            checkAccess(file, new AccessMode[0]);
            return true;
        } catch (IOException e2) {
            return false;
        }
    }
}
