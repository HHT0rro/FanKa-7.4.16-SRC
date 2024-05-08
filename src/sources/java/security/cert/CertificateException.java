package java.security.cert;

import java.security.GeneralSecurityException;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class CertificateException extends GeneralSecurityException {
    private static final long serialVersionUID = 3192535253797119798L;

    public CertificateException() {
    }

    public CertificateException(String msg) {
        super(msg);
    }

    public CertificateException(String message, Throwable cause) {
        super(message, cause);
    }

    public CertificateException(Throwable cause) {
        super(cause);
    }
}
