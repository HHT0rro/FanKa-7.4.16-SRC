package java.sql;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface SQLOutput {
    void writeArray(Array array) throws SQLException;

    void writeAsciiStream(InputStream inputStream) throws SQLException;

    void writeBigDecimal(BigDecimal bigDecimal) throws SQLException;

    void writeBinaryStream(InputStream inputStream) throws SQLException;

    void writeBlob(Blob blob) throws SQLException;

    void writeBoolean(boolean z10) throws SQLException;

    void writeByte(byte b4) throws SQLException;

    void writeBytes(byte[] bArr) throws SQLException;

    void writeCharacterStream(Reader reader) throws SQLException;

    void writeClob(Clob clob) throws SQLException;

    void writeDate(Date date) throws SQLException;

    void writeDouble(double d10) throws SQLException;

    void writeFloat(float f10) throws SQLException;

    void writeInt(int i10) throws SQLException;

    void writeLong(long j10) throws SQLException;

    void writeNClob(NClob nClob) throws SQLException;

    void writeNString(String str) throws SQLException;

    void writeObject(SQLData sQLData) throws SQLException;

    void writeRef(Ref ref) throws SQLException;

    void writeRowId(RowId rowId) throws SQLException;

    void writeSQLXML(SQLXML sqlxml) throws SQLException;

    void writeShort(short s2) throws SQLException;

    void writeString(String str) throws SQLException;

    void writeStruct(Struct struct) throws SQLException;

    void writeTime(Time time) throws SQLException;

    void writeTimestamp(Timestamp timestamp) throws SQLException;

    void writeURL(URL url) throws SQLException;
}
