package javax.sql;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface RowSetMetaData extends ResultSetMetaData {
    void setAutoIncrement(int i10, boolean z10) throws SQLException;

    void setCaseSensitive(int i10, boolean z10) throws SQLException;

    void setCatalogName(int i10, String str) throws SQLException;

    void setColumnCount(int i10) throws SQLException;

    void setColumnDisplaySize(int i10, int i11) throws SQLException;

    void setColumnLabel(int i10, String str) throws SQLException;

    void setColumnName(int i10, String str) throws SQLException;

    void setColumnType(int i10, int i11) throws SQLException;

    void setColumnTypeName(int i10, String str) throws SQLException;

    void setCurrency(int i10, boolean z10) throws SQLException;

    void setNullable(int i10, int i11) throws SQLException;

    void setPrecision(int i10, int i11) throws SQLException;

    void setScale(int i10, int i11) throws SQLException;

    void setSchemaName(int i10, String str) throws SQLException;

    void setSearchable(int i10, boolean z10) throws SQLException;

    void setSigned(int i10, boolean z10) throws SQLException;

    void setTableName(int i10, String str) throws SQLException;
}
