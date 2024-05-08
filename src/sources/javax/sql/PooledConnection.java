package javax.sql;

import java.sql.Connection;
import java.sql.SQLException;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface PooledConnection {
    void addConnectionEventListener(ConnectionEventListener connectionEventListener);

    void addStatementEventListener(StatementEventListener statementEventListener);

    void close() throws SQLException;

    Connection getConnection() throws SQLException;

    void removeConnectionEventListener(ConnectionEventListener connectionEventListener);

    void removeStatementEventListener(StatementEventListener statementEventListener);
}
