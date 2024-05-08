package java.io;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class InterruptedIOException extends IOException {
    private static final long serialVersionUID = 4020568460727500567L;
    public int bytesTransferred;

    public InterruptedIOException() {
        this.bytesTransferred = 0;
    }

    public InterruptedIOException(String s2) {
        super(s2);
        this.bytesTransferred = 0;
    }

    public InterruptedIOException(Throwable cause) {
        super(cause);
        this.bytesTransferred = 0;
    }

    public InterruptedIOException(String detailMessage, Throwable cause) {
        super(detailMessage, cause);
        this.bytesTransferred = 0;
    }
}
