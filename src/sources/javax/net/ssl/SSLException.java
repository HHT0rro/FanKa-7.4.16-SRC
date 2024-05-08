package javax.net.ssl;

import java.io.IOException;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class SSLException extends IOException {
    private static final long serialVersionUID = 4511006460650708967L;

    public SSLException(String reason) {
        super(reason);
    }

    public SSLException(String message, Throwable cause) {
        super(message);
        initCause(cause);
    }

    public SSLException(Throwable cause) {
        super(cause == null ? null : cause.toString());
        initCause(cause);
    }
}
