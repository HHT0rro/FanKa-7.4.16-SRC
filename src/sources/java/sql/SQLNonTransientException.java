package java.sql;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class SQLNonTransientException extends SQLException {
    private static final long serialVersionUID = -9104382843534716547L;

    public SQLNonTransientException() {
    }

    public SQLNonTransientException(String reason) {
        super(reason);
    }

    public SQLNonTransientException(String reason, String SQLState) {
        super(reason, SQLState);
    }

    public SQLNonTransientException(String reason, String SQLState, int vendorCode) {
        super(reason, SQLState, vendorCode);
    }

    public SQLNonTransientException(Throwable cause) {
        super(cause);
    }

    public SQLNonTransientException(String reason, Throwable cause) {
        super(reason, cause);
    }

    public SQLNonTransientException(String reason, String SQLState, Throwable cause) {
        super(reason, SQLState, cause);
    }

    public SQLNonTransientException(String reason, String SQLState, int vendorCode, Throwable cause) {
        super(reason, SQLState, vendorCode, cause);
    }
}
