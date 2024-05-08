package java.net;

import java.io.IOException;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class SocketException extends IOException {
    private static final long serialVersionUID = -5935874303556886934L;

    public SocketException(String msg) {
        super(msg);
    }

    public SocketException() {
    }

    public SocketException(Throwable cause) {
        super(cause);
    }

    public SocketException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
