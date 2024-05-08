package javax.sql;

import java.sql.SQLException;
import java.util.EventObject;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class ConnectionEvent extends EventObject {
    static final long serialVersionUID = -4843217645290030002L;
    private SQLException ex;

    public ConnectionEvent(PooledConnection con) {
        super(con);
        this.ex = null;
    }

    public ConnectionEvent(PooledConnection con, SQLException ex) {
        super(con);
        this.ex = null;
        this.ex = ex;
    }

    public SQLException getSQLException() {
        return this.ex;
    }
}
