package java.nio.file.spi;

import java.io.IOException;
import java.nio.file.Path;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class FileTypeDetector {
    public abstract String probeContentType(Path path) throws IOException;

    private static Void checkPermission() {
        SecurityManager sm = System.getSecurityManager();
        if (sm != null) {
            sm.checkPermission(new RuntimePermission("fileTypeDetector"));
            return null;
        }
        return null;
    }

    private FileTypeDetector(Void ignore) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public FileTypeDetector() {
        this(checkPermission());
    }
}
