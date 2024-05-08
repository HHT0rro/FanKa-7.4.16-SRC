package java.sql;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class SQLSyntaxErrorException extends SQLNonTransientException {
    private static final long serialVersionUID = -1843832610477496053L;

    public SQLSyntaxErrorException() {
    }

    public SQLSyntaxErrorException(String reason) {
        super(reason);
    }

    public SQLSyntaxErrorException(String reason, String SQLState) {
        super(reason, SQLState);
    }

    public SQLSyntaxErrorException(String reason, String SQLState, int vendorCode) {
        super(reason, SQLState, vendorCode);
    }

    public SQLSyntaxErrorException(Throwable cause) {
        super(cause);
    }

    public SQLSyntaxErrorException(String reason, Throwable cause) {
        super(reason, cause);
    }

    public SQLSyntaxErrorException(String reason, String SQLState, Throwable cause) {
        super(reason, SQLState, cause);
    }

    public SQLSyntaxErrorException(String reason, String SQLState, int vendorCode, Throwable cause) {
        super(reason, SQLState, vendorCode, cause);
    }
}
