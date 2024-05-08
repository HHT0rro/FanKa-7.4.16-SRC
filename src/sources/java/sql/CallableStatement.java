package java.sql;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.util.Calendar;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface CallableStatement extends PreparedStatement {
    Array getArray(int i10) throws SQLException;

    Array getArray(String str) throws SQLException;

    BigDecimal getBigDecimal(int i10) throws SQLException;

    @Deprecated
    BigDecimal getBigDecimal(int i10, int i11) throws SQLException;

    BigDecimal getBigDecimal(String str) throws SQLException;

    Blob getBlob(int i10) throws SQLException;

    Blob getBlob(String str) throws SQLException;

    boolean getBoolean(int i10) throws SQLException;

    boolean getBoolean(String str) throws SQLException;

    byte getByte(int i10) throws SQLException;

    byte getByte(String str) throws SQLException;

    byte[] getBytes(int i10) throws SQLException;

    byte[] getBytes(String str) throws SQLException;

    Reader getCharacterStream(int i10) throws SQLException;

    Reader getCharacterStream(String str) throws SQLException;

    Clob getClob(int i10) throws SQLException;

    Clob getClob(String str) throws SQLException;

    Date getDate(int i10) throws SQLException;

    Date getDate(int i10, Calendar calendar) throws SQLException;

    Date getDate(String str) throws SQLException;

    Date getDate(String str, Calendar calendar) throws SQLException;

    double getDouble(int i10) throws SQLException;

    double getDouble(String str) throws SQLException;

    float getFloat(int i10) throws SQLException;

    float getFloat(String str) throws SQLException;

    int getInt(int i10) throws SQLException;

    int getInt(String str) throws SQLException;

    long getLong(int i10) throws SQLException;

    long getLong(String str) throws SQLException;

    Reader getNCharacterStream(int i10) throws SQLException;

    Reader getNCharacterStream(String str) throws SQLException;

    NClob getNClob(int i10) throws SQLException;

    NClob getNClob(String str) throws SQLException;

    String getNString(int i10) throws SQLException;

    String getNString(String str) throws SQLException;

    Object getObject(int i10) throws SQLException;

    Object getObject(int i10, Map<String, Class<?>> map) throws SQLException;

    Object getObject(String str) throws SQLException;

    Object getObject(String str, Map<String, Class<?>> map) throws SQLException;

    Ref getRef(int i10) throws SQLException;

    Ref getRef(String str) throws SQLException;

    RowId getRowId(int i10) throws SQLException;

    RowId getRowId(String str) throws SQLException;

    SQLXML getSQLXML(int i10) throws SQLException;

    SQLXML getSQLXML(String str) throws SQLException;

    short getShort(int i10) throws SQLException;

    short getShort(String str) throws SQLException;

    String getString(int i10) throws SQLException;

    String getString(String str) throws SQLException;

    Time getTime(int i10) throws SQLException;

    Time getTime(int i10, Calendar calendar) throws SQLException;

    Time getTime(String str) throws SQLException;

    Time getTime(String str, Calendar calendar) throws SQLException;

    Timestamp getTimestamp(int i10) throws SQLException;

    Timestamp getTimestamp(int i10, Calendar calendar) throws SQLException;

    Timestamp getTimestamp(String str) throws SQLException;

    Timestamp getTimestamp(String str, Calendar calendar) throws SQLException;

    URL getURL(int i10) throws SQLException;

    URL getURL(String str) throws SQLException;

    void registerOutParameter(int i10, int i11) throws SQLException;

    void registerOutParameter(int i10, int i11, int i12) throws SQLException;

    void registerOutParameter(int i10, int i11, String str) throws SQLException;

    void registerOutParameter(String str, int i10) throws SQLException;

    void registerOutParameter(String str, int i10, int i11) throws SQLException;

    void registerOutParameter(String str, int i10, String str2) throws SQLException;

    void setAsciiStream(String str, InputStream inputStream) throws SQLException;

    void setAsciiStream(String str, InputStream inputStream, int i10) throws SQLException;

    void setAsciiStream(String str, InputStream inputStream, long j10) throws SQLException;

    void setBigDecimal(String str, BigDecimal bigDecimal) throws SQLException;

    void setBinaryStream(String str, InputStream inputStream) throws SQLException;

    void setBinaryStream(String str, InputStream inputStream, int i10) throws SQLException;

    void setBinaryStream(String str, InputStream inputStream, long j10) throws SQLException;

    void setBlob(String str, InputStream inputStream) throws SQLException;

    void setBlob(String str, InputStream inputStream, long j10) throws SQLException;

    void setBlob(String str, Blob blob) throws SQLException;

    void setBoolean(String str, boolean z10) throws SQLException;

    void setByte(String str, byte b4) throws SQLException;

    void setBytes(String str, byte[] bArr) throws SQLException;

    void setCharacterStream(String str, Reader reader) throws SQLException;

    void setCharacterStream(String str, Reader reader, int i10) throws SQLException;

    void setCharacterStream(String str, Reader reader, long j10) throws SQLException;

    void setClob(String str, Reader reader) throws SQLException;

    void setClob(String str, Reader reader, long j10) throws SQLException;

    void setClob(String str, Clob clob) throws SQLException;

    void setDate(String str, Date date) throws SQLException;

    void setDate(String str, Date date, Calendar calendar) throws SQLException;

    void setDouble(String str, double d10) throws SQLException;

    void setFloat(String str, float f10) throws SQLException;

    void setInt(String str, int i10) throws SQLException;

    void setLong(String str, long j10) throws SQLException;

    void setNCharacterStream(String str, Reader reader) throws SQLException;

    void setNCharacterStream(String str, Reader reader, long j10) throws SQLException;

    void setNClob(String str, Reader reader) throws SQLException;

    void setNClob(String str, Reader reader, long j10) throws SQLException;

    void setNClob(String str, NClob nClob) throws SQLException;

    void setNString(String str, String str2) throws SQLException;

    void setNull(String str, int i10) throws SQLException;

    void setNull(String str, int i10, String str2) throws SQLException;

    void setObject(String str, Object obj) throws SQLException;

    void setObject(String str, Object obj, int i10) throws SQLException;

    void setObject(String str, Object obj, int i10, int i11) throws SQLException;

    void setRowId(String str, RowId rowId) throws SQLException;

    void setSQLXML(String str, SQLXML sqlxml) throws SQLException;

    void setShort(String str, short s2) throws SQLException;

    void setString(String str, String str2) throws SQLException;

    void setTime(String str, Time time) throws SQLException;

    void setTime(String str, Time time, Calendar calendar) throws SQLException;

    void setTimestamp(String str, Timestamp timestamp) throws SQLException;

    void setTimestamp(String str, Timestamp timestamp, Calendar calendar) throws SQLException;

    void setURL(String str, URL url) throws SQLException;

    boolean wasNull() throws SQLException;
}
