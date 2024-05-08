package java.io;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface ObjectOutput extends DataOutput, AutoCloseable {
    @Override // java.lang.AutoCloseable
    void close() throws IOException;

    void flush() throws IOException;

    @Override // java.io.DataOutput
    void write(int i10) throws IOException;

    @Override // java.io.DataOutput
    void write(byte[] bArr) throws IOException;

    @Override // java.io.DataOutput
    void write(byte[] bArr, int i10, int i11) throws IOException;

    void writeObject(Object obj) throws IOException;
}
