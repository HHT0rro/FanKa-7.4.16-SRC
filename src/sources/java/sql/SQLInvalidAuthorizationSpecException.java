package java.sql;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class SQLInvalidAuthorizationSpecException extends SQLNonTransientException {
    private static final long serialVersionUID = -64105250450891498L;

    public SQLInvalidAuthorizationSpecException() {
    }

    public SQLInvalidAuthorizationSpecException(String reason) {
        super(reason);
    }

    public SQLInvalidAuthorizationSpecException(String reason, String SQLState) {
        super(reason, SQLState);
    }

    public SQLInvalidAuthorizationSpecException(String reason, String SQLState, int vendorCode) {
        super(reason, SQLState, vendorCode);
    }

    public SQLInvalidAuthorizationSpecException(Throwable cause) {
        super(cause);
    }

    public SQLInvalidAuthorizationSpecException(String reason, Throwable cause) {
        super(reason, cause);
    }

    public SQLInvalidAuthorizationSpecException(String reason, String SQLState, Throwable cause) {
        super(reason, SQLState, cause);
    }

    public SQLInvalidAuthorizationSpecException(String reason, String SQLState, int vendorCode, Throwable cause) {
        super(reason, SQLState, vendorCode, cause);
    }
}
