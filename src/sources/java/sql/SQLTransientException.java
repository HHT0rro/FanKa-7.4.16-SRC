package java.sql;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class SQLTransientException extends SQLException {
    private static final long serialVersionUID = -9042733978262274539L;

    public SQLTransientException() {
    }

    public SQLTransientException(String reason) {
        super(reason);
    }

    public SQLTransientException(String reason, String SQLState) {
        super(reason, SQLState);
    }

    public SQLTransientException(String reason, String SQLState, int vendorCode) {
        super(reason, SQLState, vendorCode);
    }

    public SQLTransientException(Throwable cause) {
        super(cause);
    }

    public SQLTransientException(String reason, Throwable cause) {
        super(reason, cause);
    }

    public SQLTransientException(String reason, String SQLState, Throwable cause) {
        super(reason, SQLState, cause);
    }

    public SQLTransientException(String reason, String SQLState, int vendorCode, Throwable cause) {
        super(reason, SQLState, vendorCode, cause);
    }
}
