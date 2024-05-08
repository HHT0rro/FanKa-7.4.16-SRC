package javax.sql;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Date;
import java.sql.NClob;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLXML;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface RowSet extends ResultSet {
    void addRowSetListener(RowSetListener rowSetListener);

    void clearParameters() throws SQLException;

    void execute() throws SQLException;

    String getCommand();

    String getDataSourceName();

    boolean getEscapeProcessing() throws SQLException;

    int getMaxFieldSize() throws SQLException;

    int getMaxRows() throws SQLException;

    String getPassword();

    int getQueryTimeout() throws SQLException;

    int getTransactionIsolation();

    Map<String, Class<?>> getTypeMap() throws SQLException;

    String getUrl() throws SQLException;

    String getUsername();

    boolean isReadOnly();

    void removeRowSetListener(RowSetListener rowSetListener);

    void setArray(int i10, Array array) throws SQLException;

    void setAsciiStream(int i10, InputStream inputStream) throws SQLException;

    void setAsciiStream(int i10, InputStream inputStream, int i11) throws SQLException;

    void setAsciiStream(String str, InputStream inputStream) throws SQLException;

    void setAsciiStream(String str, InputStream inputStream, int i10) throws SQLException;

    void setBigDecimal(int i10, BigDecimal bigDecimal) throws SQLException;

    void setBigDecimal(String str, BigDecimal bigDecimal) throws SQLException;

    void setBinaryStream(int i10, InputStream inputStream) throws SQLException;

    void setBinaryStream(int i10, InputStream inputStream, int i11) throws SQLException;

    void setBinaryStream(String str, InputStream inputStream) throws SQLException;

    void setBinaryStream(String str, InputStream inputStream, int i10) throws SQLException;

    void setBlob(int i10, InputStream inputStream) throws SQLException;

    void setBlob(int i10, InputStream inputStream, long j10) throws SQLException;

    void setBlob(int i10, Blob blob) throws SQLException;

    void setBlob(String str, InputStream inputStream) throws SQLException;

    void setBlob(String str, InputStream inputStream, long j10) throws SQLException;

    void setBlob(String str, Blob blob) throws SQLException;

    void setBoolean(int i10, boolean z10) throws SQLException;

    void setBoolean(String str, boolean z10) throws SQLException;

    void setByte(int i10, byte b4) throws SQLException;

    void setByte(String str, byte b4) throws SQLException;

    void setBytes(int i10, byte[] bArr) throws SQLException;

    void setBytes(String str, byte[] bArr) throws SQLException;

    void setCharacterStream(int i10, Reader reader) throws SQLException;

    void setCharacterStream(int i10, Reader reader, int i11) throws SQLException;

    void setCharacterStream(String str, Reader reader) throws SQLException;

    void setCharacterStream(String str, Reader reader, int i10) throws SQLException;

    void setClob(int i10, Reader reader) throws SQLException;

    void setClob(int i10, Reader reader, long j10) throws SQLException;

    void setClob(int i10, Clob clob) throws SQLException;

    void setClob(String str, Reader reader) throws SQLException;

    void setClob(String str, Reader reader, long j10) throws SQLException;

    void setClob(String str, Clob clob) throws SQLException;

    void setCommand(String str) throws SQLException;

    void setConcurrency(int i10) throws SQLException;

    void setDataSourceName(String str) throws SQLException;

    void setDate(int i10, Date date) throws SQLException;

    void setDate(int i10, Date date, Calendar calendar) throws SQLException;

    void setDate(String str, Date date) throws SQLException;

    void setDate(String str, Date date, Calendar calendar) throws SQLException;

    void setDouble(int i10, double d10) throws SQLException;

    void setDouble(String str, double d10) throws SQLException;

    void setEscapeProcessing(boolean z10) throws SQLException;

    void setFloat(int i10, float f10) throws SQLException;

    void setFloat(String str, float f10) throws SQLException;

    void setInt(int i10, int i11) throws SQLException;

    void setInt(String str, int i10) throws SQLException;

    void setLong(int i10, long j10) throws SQLException;

    void setLong(String str, long j10) throws SQLException;

    void setMaxFieldSize(int i10) throws SQLException;

    void setMaxRows(int i10) throws SQLException;

    void setNCharacterStream(int i10, Reader reader) throws SQLException;

    void setNCharacterStream(int i10, Reader reader, long j10) throws SQLException;

    void setNCharacterStream(String str, Reader reader) throws SQLException;

    void setNCharacterStream(String str, Reader reader, long j10) throws SQLException;

    void setNClob(int i10, Reader reader) throws SQLException;

    void setNClob(int i10, Reader reader, long j10) throws SQLException;

    void setNClob(int i10, NClob nClob) throws SQLException;

    void setNClob(String str, Reader reader) throws SQLException;

    void setNClob(String str, Reader reader, long j10) throws SQLException;

    void setNClob(String str, NClob nClob) throws SQLException;

    void setNString(int i10, String str) throws SQLException;

    void setNString(String str, String str2) throws SQLException;

    void setNull(int i10, int i11) throws SQLException;

    void setNull(int i10, int i11, String str) throws SQLException;

    void setNull(String str, int i10) throws SQLException;

    void setNull(String str, int i10, String str2) throws SQLException;

    void setObject(int i10, Object obj) throws SQLException;

    void setObject(int i10, Object obj, int i11) throws SQLException;

    void setObject(int i10, Object obj, int i11, int i12) throws SQLException;

    void setObject(String str, Object obj) throws SQLException;

    void setObject(String str, Object obj, int i10) throws SQLException;

    void setObject(String str, Object obj, int i10, int i11) throws SQLException;

    void setPassword(String str) throws SQLException;

    void setQueryTimeout(int i10) throws SQLException;

    void setReadOnly(boolean z10) throws SQLException;

    void setRef(int i10, Ref ref) throws SQLException;

    void setRowId(int i10, RowId rowId) throws SQLException;

    void setRowId(String str, RowId rowId) throws SQLException;

    void setSQLXML(int i10, SQLXML sqlxml) throws SQLException;

    void setSQLXML(String str, SQLXML sqlxml) throws SQLException;

    void setShort(int i10, short s2) throws SQLException;

    void setShort(String str, short s2) throws SQLException;

    void setString(int i10, String str) throws SQLException;

    void setString(String str, String str2) throws SQLException;

    void setTime(int i10, Time time) throws SQLException;

    void setTime(int i10, Time time, Calendar calendar) throws SQLException;

    void setTime(String str, Time time) throws SQLException;

    void setTime(String str, Time time, Calendar calendar) throws SQLException;

    void setTimestamp(int i10, Timestamp timestamp) throws SQLException;

    void setTimestamp(int i10, Timestamp timestamp, Calendar calendar) throws SQLException;

    void setTimestamp(String str, Timestamp timestamp) throws SQLException;

    void setTimestamp(String str, Timestamp timestamp, Calendar calendar) throws SQLException;

    void setTransactionIsolation(int i10) throws SQLException;

    void setType(int i10) throws SQLException;

    void setTypeMap(Map<String, Class<?>> map) throws SQLException;

    void setURL(int i10, URL url) throws SQLException;

    void setUrl(String str) throws SQLException;

    void setUsername(String str) throws SQLException;
}
