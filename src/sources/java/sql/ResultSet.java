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
public interface ResultSet extends Wrapper, AutoCloseable {
    public static final int CLOSE_CURSORS_AT_COMMIT = 2;
    public static final int CONCUR_READ_ONLY = 1007;
    public static final int CONCUR_UPDATABLE = 1008;
    public static final int FETCH_FORWARD = 1000;
    public static final int FETCH_REVERSE = 1001;
    public static final int FETCH_UNKNOWN = 1002;
    public static final int HOLD_CURSORS_OVER_COMMIT = 1;
    public static final int TYPE_FORWARD_ONLY = 1003;
    public static final int TYPE_SCROLL_INSENSITIVE = 1004;
    public static final int TYPE_SCROLL_SENSITIVE = 1005;

    boolean absolute(int i10) throws SQLException;

    void afterLast() throws SQLException;

    void beforeFirst() throws SQLException;

    void cancelRowUpdates() throws SQLException;

    void clearWarnings() throws SQLException;

    @Override // java.lang.AutoCloseable
    void close() throws SQLException;

    void deleteRow() throws SQLException;

    int findColumn(String str) throws SQLException;

    boolean first() throws SQLException;

    Array getArray(int i10) throws SQLException;

    Array getArray(String str) throws SQLException;

    InputStream getAsciiStream(int i10) throws SQLException;

    InputStream getAsciiStream(String str) throws SQLException;

    BigDecimal getBigDecimal(int i10) throws SQLException;

    @Deprecated
    BigDecimal getBigDecimal(int i10, int i11) throws SQLException;

    BigDecimal getBigDecimal(String str) throws SQLException;

    @Deprecated
    BigDecimal getBigDecimal(String str, int i10) throws SQLException;

    InputStream getBinaryStream(int i10) throws SQLException;

    InputStream getBinaryStream(String str) throws SQLException;

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

    int getConcurrency() throws SQLException;

    String getCursorName() throws SQLException;

    Date getDate(int i10) throws SQLException;

    Date getDate(int i10, Calendar calendar) throws SQLException;

    Date getDate(String str) throws SQLException;

    Date getDate(String str, Calendar calendar) throws SQLException;

    double getDouble(int i10) throws SQLException;

    double getDouble(String str) throws SQLException;

    int getFetchDirection() throws SQLException;

    int getFetchSize() throws SQLException;

    float getFloat(int i10) throws SQLException;

    float getFloat(String str) throws SQLException;

    int getHoldability() throws SQLException;

    int getInt(int i10) throws SQLException;

    int getInt(String str) throws SQLException;

    long getLong(int i10) throws SQLException;

    long getLong(String str) throws SQLException;

    ResultSetMetaData getMetaData() throws SQLException;

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

    int getRow() throws SQLException;

    RowId getRowId(int i10) throws SQLException;

    RowId getRowId(String str) throws SQLException;

    SQLXML getSQLXML(int i10) throws SQLException;

    SQLXML getSQLXML(String str) throws SQLException;

    short getShort(int i10) throws SQLException;

    short getShort(String str) throws SQLException;

    Statement getStatement() throws SQLException;

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

    int getType() throws SQLException;

    URL getURL(int i10) throws SQLException;

    URL getURL(String str) throws SQLException;

    @Deprecated
    InputStream getUnicodeStream(int i10) throws SQLException;

    @Deprecated
    InputStream getUnicodeStream(String str) throws SQLException;

    SQLWarning getWarnings() throws SQLException;

    void insertRow() throws SQLException;

    boolean isAfterLast() throws SQLException;

    boolean isBeforeFirst() throws SQLException;

    boolean isClosed() throws SQLException;

    boolean isFirst() throws SQLException;

    boolean isLast() throws SQLException;

    boolean last() throws SQLException;

    void moveToCurrentRow() throws SQLException;

    void moveToInsertRow() throws SQLException;

    boolean next() throws SQLException;

    boolean previous() throws SQLException;

    void refreshRow() throws SQLException;

    boolean relative(int i10) throws SQLException;

    boolean rowDeleted() throws SQLException;

    boolean rowInserted() throws SQLException;

    boolean rowUpdated() throws SQLException;

    void setFetchDirection(int i10) throws SQLException;

    void setFetchSize(int i10) throws SQLException;

    void updateArray(int i10, Array array) throws SQLException;

    void updateArray(String str, Array array) throws SQLException;

    void updateAsciiStream(int i10, InputStream inputStream) throws SQLException;

    void updateAsciiStream(int i10, InputStream inputStream, int i11) throws SQLException;

    void updateAsciiStream(int i10, InputStream inputStream, long j10) throws SQLException;

    void updateAsciiStream(String str, InputStream inputStream) throws SQLException;

    void updateAsciiStream(String str, InputStream inputStream, int i10) throws SQLException;

    void updateAsciiStream(String str, InputStream inputStream, long j10) throws SQLException;

    void updateBigDecimal(int i10, BigDecimal bigDecimal) throws SQLException;

    void updateBigDecimal(String str, BigDecimal bigDecimal) throws SQLException;

    void updateBinaryStream(int i10, InputStream inputStream) throws SQLException;

    void updateBinaryStream(int i10, InputStream inputStream, int i11) throws SQLException;

    void updateBinaryStream(int i10, InputStream inputStream, long j10) throws SQLException;

    void updateBinaryStream(String str, InputStream inputStream) throws SQLException;

    void updateBinaryStream(String str, InputStream inputStream, int i10) throws SQLException;

    void updateBinaryStream(String str, InputStream inputStream, long j10) throws SQLException;

    void updateBlob(int i10, InputStream inputStream) throws SQLException;

    void updateBlob(int i10, InputStream inputStream, long j10) throws SQLException;

    void updateBlob(int i10, Blob blob) throws SQLException;

    void updateBlob(String str, InputStream inputStream) throws SQLException;

    void updateBlob(String str, InputStream inputStream, long j10) throws SQLException;

    void updateBlob(String str, Blob blob) throws SQLException;

    void updateBoolean(int i10, boolean z10) throws SQLException;

    void updateBoolean(String str, boolean z10) throws SQLException;

    void updateByte(int i10, byte b4) throws SQLException;

    void updateByte(String str, byte b4) throws SQLException;

    void updateBytes(int i10, byte[] bArr) throws SQLException;

    void updateBytes(String str, byte[] bArr) throws SQLException;

    void updateCharacterStream(int i10, Reader reader) throws SQLException;

    void updateCharacterStream(int i10, Reader reader, int i11) throws SQLException;

    void updateCharacterStream(int i10, Reader reader, long j10) throws SQLException;

    void updateCharacterStream(String str, Reader reader) throws SQLException;

    void updateCharacterStream(String str, Reader reader, int i10) throws SQLException;

    void updateCharacterStream(String str, Reader reader, long j10) throws SQLException;

    void updateClob(int i10, Reader reader) throws SQLException;

    void updateClob(int i10, Reader reader, long j10) throws SQLException;

    void updateClob(int i10, Clob clob) throws SQLException;

    void updateClob(String str, Reader reader) throws SQLException;

    void updateClob(String str, Reader reader, long j10) throws SQLException;

    void updateClob(String str, Clob clob) throws SQLException;

    void updateDate(int i10, Date date) throws SQLException;

    void updateDate(String str, Date date) throws SQLException;

    void updateDouble(int i10, double d10) throws SQLException;

    void updateDouble(String str, double d10) throws SQLException;

    void updateFloat(int i10, float f10) throws SQLException;

    void updateFloat(String str, float f10) throws SQLException;

    void updateInt(int i10, int i11) throws SQLException;

    void updateInt(String str, int i10) throws SQLException;

    void updateLong(int i10, long j10) throws SQLException;

    void updateLong(String str, long j10) throws SQLException;

    void updateNCharacterStream(int i10, Reader reader) throws SQLException;

    void updateNCharacterStream(int i10, Reader reader, long j10) throws SQLException;

    void updateNCharacterStream(String str, Reader reader) throws SQLException;

    void updateNCharacterStream(String str, Reader reader, long j10) throws SQLException;

    void updateNClob(int i10, Reader reader) throws SQLException;

    void updateNClob(int i10, Reader reader, long j10) throws SQLException;

    void updateNClob(int i10, NClob nClob) throws SQLException;

    void updateNClob(String str, Reader reader) throws SQLException;

    void updateNClob(String str, Reader reader, long j10) throws SQLException;

    void updateNClob(String str, NClob nClob) throws SQLException;

    void updateNString(int i10, String str) throws SQLException;

    void updateNString(String str, String str2) throws SQLException;

    void updateNull(int i10) throws SQLException;

    void updateNull(String str) throws SQLException;

    void updateObject(int i10, Object obj) throws SQLException;

    void updateObject(int i10, Object obj, int i11) throws SQLException;

    void updateObject(String str, Object obj) throws SQLException;

    void updateObject(String str, Object obj, int i10) throws SQLException;

    void updateRef(int i10, Ref ref) throws SQLException;

    void updateRef(String str, Ref ref) throws SQLException;

    void updateRow() throws SQLException;

    void updateRowId(int i10, RowId rowId) throws SQLException;

    void updateRowId(String str, RowId rowId) throws SQLException;

    void updateSQLXML(int i10, SQLXML sqlxml) throws SQLException;

    void updateSQLXML(String str, SQLXML sqlxml) throws SQLException;

    void updateShort(int i10, short s2) throws SQLException;

    void updateShort(String str, short s2) throws SQLException;

    void updateString(int i10, String str) throws SQLException;

    void updateString(String str, String str2) throws SQLException;

    void updateTime(int i10, Time time) throws SQLException;

    void updateTime(String str, Time time) throws SQLException;

    void updateTimestamp(int i10, Timestamp timestamp) throws SQLException;

    void updateTimestamp(String str, Timestamp timestamp) throws SQLException;

    boolean wasNull() throws SQLException;
}
