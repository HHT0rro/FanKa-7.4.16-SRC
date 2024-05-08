package java.sql;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface Clob {
    void free() throws SQLException;

    InputStream getAsciiStream() throws SQLException;

    Reader getCharacterStream() throws SQLException;

    Reader getCharacterStream(long j10, long j11) throws SQLException;

    String getSubString(long j10, int i10) throws SQLException;

    long length() throws SQLException;

    long position(String str, long j10) throws SQLException;

    long position(Clob clob, long j10) throws SQLException;

    OutputStream setAsciiStream(long j10) throws SQLException;

    Writer setCharacterStream(long j10) throws SQLException;

    int setString(long j10, String str) throws SQLException;

    int setString(long j10, String str, int i10, int i11) throws SQLException;

    void truncate(long j10) throws SQLException;
}
