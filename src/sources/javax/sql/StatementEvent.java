package javax.sql;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.EventObject;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class StatementEvent extends EventObject {
    private SQLException exception;
    private PreparedStatement statement;

    public StatementEvent(PooledConnection con, PreparedStatement statement) {
        super(con);
        this.statement = statement;
        this.exception = null;
    }

    public StatementEvent(PooledConnection con, PreparedStatement statement, SQLException exception) {
        super(con);
        this.statement = statement;
        this.exception = exception;
    }

    public PreparedStatement getStatement() {
        return this.statement;
    }

    public SQLException getSQLException() {
        return this.exception;
    }
}
