package java.sql;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class SQLTransientConnectionException extends SQLTransientException {
    private static final long serialVersionUID = -2520155553543391200L;

    public SQLTransientConnectionException() {
    }

    public SQLTransientConnectionException(String reason) {
        super(reason);
    }

    public SQLTransientConnectionException(String reason, String SQLState) {
        super(reason, SQLState);
    }

    public SQLTransientConnectionException(String reason, String SQLState, int vendorCode) {
        super(reason, SQLState, vendorCode);
    }

    public SQLTransientConnectionException(Throwable cause) {
        super(cause);
    }

    public SQLTransientConnectionException(String reason, Throwable cause) {
        super(reason, cause);
    }

    public SQLTransientConnectionException(String reason, String SQLState, Throwable cause) {
        super(reason, SQLState, cause);
    }

    public SQLTransientConnectionException(String reason, String SQLState, int vendorCode, Throwable cause) {
        super(reason, SQLState, vendorCode, cause);
    }
}
