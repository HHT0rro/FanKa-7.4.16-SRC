package java.sql;

import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface Array {
    void free() throws SQLException;

    Object getArray() throws SQLException;

    Object getArray(long j10, int i10) throws SQLException;

    Object getArray(long j10, int i10, Map<String, Class<?>> map) throws SQLException;

    Object getArray(Map<String, Class<?>> map) throws SQLException;

    int getBaseType() throws SQLException;

    String getBaseTypeName() throws SQLException;

    ResultSet getResultSet() throws SQLException;

    ResultSet getResultSet(long j10, int i10) throws SQLException;

    ResultSet getResultSet(long j10, int i10, Map<String, Class<?>> map) throws SQLException;

    ResultSet getResultSet(Map<String, Class<?>> map) throws SQLException;
}
