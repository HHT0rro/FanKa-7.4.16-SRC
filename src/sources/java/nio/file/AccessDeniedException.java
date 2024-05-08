package java.nio.file;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class AccessDeniedException extends FileSystemException {
    private static final long serialVersionUID = 4943049599949219617L;

    public AccessDeniedException(String file) {
        super(file);
    }

    public AccessDeniedException(String file, String other, String reason) {
        super(file, other, reason);
    }
}
