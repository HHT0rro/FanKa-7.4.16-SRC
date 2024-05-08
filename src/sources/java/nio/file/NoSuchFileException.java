package java.nio.file;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class NoSuchFileException extends FileSystemException {
    static final long serialVersionUID = -1390291775875351931L;

    public NoSuchFileException(String file) {
        super(file);
    }

    public NoSuchFileException(String file, String other, String reason) {
        super(file, other, reason);
    }
}
