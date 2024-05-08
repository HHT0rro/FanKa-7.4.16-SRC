package java.io;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface DataOutput {
    void write(int i10) throws IOException;

    void write(byte[] bArr) throws IOException;

    void write(byte[] bArr, int i10, int i11) throws IOException;

    void writeBoolean(boolean z10) throws IOException;

    void writeByte(int i10) throws IOException;

    void writeBytes(String str) throws IOException;

    void writeChar(int i10) throws IOException;

    void writeChars(String str) throws IOException;

    void writeDouble(double d10) throws IOException;

    void writeFloat(float f10) throws IOException;

    void writeInt(int i10) throws IOException;

    void writeLong(long j10) throws IOException;

    void writeShort(int i10) throws IOException;

    void writeUTF(String str) throws IOException;
}
