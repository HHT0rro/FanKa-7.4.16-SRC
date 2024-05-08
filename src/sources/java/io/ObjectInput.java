package java.io;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface ObjectInput extends DataInput, AutoCloseable {
    int available() throws IOException;

    @Override // java.lang.AutoCloseable
    void close() throws IOException;

    int read() throws IOException;

    int read(byte[] bArr) throws IOException;

    int read(byte[] bArr, int i10, int i11) throws IOException;

    Object readObject() throws ClassNotFoundException, IOException;

    long skip(long j10) throws IOException;
}
