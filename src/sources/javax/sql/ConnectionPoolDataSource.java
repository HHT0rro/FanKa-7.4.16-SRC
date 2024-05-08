package javax.sql;

import java.sql.SQLException;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface ConnectionPoolDataSource extends CommonDataSource {
    PooledConnection getPooledConnection() throws SQLException;

    PooledConnection getPooledConnection(String str, String str2) throws SQLException;
}
