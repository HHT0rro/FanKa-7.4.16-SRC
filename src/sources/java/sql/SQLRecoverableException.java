package java.sql;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class SQLRecoverableException extends SQLException {
    private static final long serialVersionUID = -4144386502923131579L;

    public SQLRecoverableException() {
    }

    public SQLRecoverableException(String reason) {
        super(reason);
    }

    public SQLRecoverableException(String reason, String SQLState) {
        super(reason, SQLState);
    }

    public SQLRecoverableException(String reason, String SQLState, int vendorCode) {
        super(reason, SQLState, vendorCode);
    }

    public SQLRecoverableException(Throwable cause) {
        super(cause);
    }

    public SQLRecoverableException(String reason, Throwable cause) {
        super(reason, cause);
    }

    public SQLRecoverableException(String reason, String SQLState, Throwable cause) {
        super(reason, SQLState, cause);
    }

    public SQLRecoverableException(String reason, String SQLState, int vendorCode, Throwable cause) {
        super(reason, SQLState, vendorCode, cause);
    }
}
