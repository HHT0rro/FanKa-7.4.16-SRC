package sun.net.ftp;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class FtpProtocolException extends Exception {
    private static final long serialVersionUID = 5978077070276545054L;
    private final FtpReplyCode code;

    public FtpProtocolException(String detail) {
        super(detail);
        this.code = FtpReplyCode.UNKNOWN_ERROR;
    }

    public FtpProtocolException(String detail, FtpReplyCode code) {
        super(detail);
        this.code = code;
    }

    public FtpReplyCode getReplyCode() {
        return this.code;
    }
}
