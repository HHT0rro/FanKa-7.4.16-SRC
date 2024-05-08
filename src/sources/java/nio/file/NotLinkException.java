package java.nio.file;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class NotLinkException extends FileSystemException {
    static final long serialVersionUID = -388655596416518021L;

    public NotLinkException(String file) {
        super(file);
    }

    public NotLinkException(String file, String other, String reason) {
        super(file, other, reason);
    }
}
