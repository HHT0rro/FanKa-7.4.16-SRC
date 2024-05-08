package java.security;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class InvalidKeyException extends KeyException {
    private static final long serialVersionUID = 5698479920593359816L;

    public InvalidKeyException() {
    }

    public InvalidKeyException(String msg) {
        super(msg);
    }

    public InvalidKeyException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidKeyException(Throwable cause) {
        super(cause);
    }
}
