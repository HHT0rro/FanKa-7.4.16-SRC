package java.io;

import java.nio.ByteOrder;
import libcore.io.Memory;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class DataInputStream extends FilterInputStream implements DataInput {
    private byte[] bytearr;
    private char[] chararr;
    private char[] lineBuffer;
    private byte[] readBuffer;

    public DataInputStream(InputStream in) {
        super(in);
        this.bytearr = new byte[80];
        this.chararr = new char[80];
        this.readBuffer = new byte[8];
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] b4) throws IOException {
        return this.in.read(b4, 0, b4.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] b4, int off, int len) throws IOException {
        return this.in.read(b4, off, len);
    }

    @Override // java.io.DataInput
    public final void readFully(byte[] b4) throws IOException {
        readFully(b4, 0, b4.length);
    }

    @Override // java.io.DataInput
    public final void readFully(byte[] b4, int off, int len) throws IOException {
        if (len < 0) {
            throw new IndexOutOfBoundsException();
        }
        int n10 = 0;
        while (n10 < len) {
            int count = this.in.read(b4, off + n10, len - n10);
            if (count < 0) {
                throw new EOFException();
            }
            n10 += count;
        }
    }

    @Override // java.io.DataInput
    public final int skipBytes(int n10) throws IOException {
        int total = 0;
        while (total < n10) {
            int cur = (int) this.in.skip(n10 - total);
            if (cur <= 0) {
                break;
            }
            total += cur;
        }
        return total;
    }

    @Override // java.io.DataInput
    public final boolean readBoolean() throws IOException {
        int ch = this.in.read();
        if (ch >= 0) {
            return ch != 0;
        }
        throw new EOFException();
    }

    @Override // java.io.DataInput
    public final byte readByte() throws IOException {
        int ch = this.in.read();
        if (ch < 0) {
            throw new EOFException();
        }
        return (byte) ch;
    }

    @Override // java.io.DataInput
    public final int readUnsignedByte() throws IOException {
        int ch = this.in.read();
        if (ch < 0) {
            throw new EOFException();
        }
        return ch;
    }

    @Override // java.io.DataInput
    public final short readShort() throws IOException {
        readFully(this.readBuffer, 0, 2);
        return Memory.peekShort(this.readBuffer, 0, ByteOrder.BIG_ENDIAN);
    }

    @Override // java.io.DataInput
    public final int readUnsignedShort() throws IOException {
        readFully(this.readBuffer, 0, 2);
        return Memory.peekShort(this.readBuffer, 0, ByteOrder.BIG_ENDIAN) & 65535;
    }

    @Override // java.io.DataInput
    public final char readChar() throws IOException {
        readFully(this.readBuffer, 0, 2);
        return (char) Memory.peekShort(this.readBuffer, 0, ByteOrder.BIG_ENDIAN);
    }

    @Override // java.io.DataInput
    public final int readInt() throws IOException {
        readFully(this.readBuffer, 0, 4);
        return Memory.peekInt(this.readBuffer, 0, ByteOrder.BIG_ENDIAN);
    }

    @Override // java.io.DataInput
    public final long readLong() throws IOException {
        readFully(this.readBuffer, 0, 8);
        byte[] bArr = this.readBuffer;
        return (bArr[0] << 56) + ((bArr[1] & 255) << 48) + ((bArr[2] & 255) << 40) + ((bArr[3] & 255) << 32) + ((bArr[4] & 255) << 24) + ((bArr[5] & 255) << 16) + ((bArr[6] & 255) << 8) + ((bArr[7] & 255) << 0);
    }

    @Override // java.io.DataInput
    public final float readFloat() throws IOException {
        return Float.intBitsToFloat(readInt());
    }

    @Override // java.io.DataInput
    public final double readDouble() throws IOException {
        return Double.longBitsToDouble(readLong());
    }

    @Override // java.io.DataInput
    @Deprecated
    public final String readLine() throws IOException {
        int c4;
        char[] buf = this.lineBuffer;
        if (buf == null) {
            char[] cArr = new char[128];
            this.lineBuffer = cArr;
            buf = cArr;
        }
        int room = buf.length;
        int offset = 0;
        while (true) {
            c4 = this.in.read();
            switch (c4) {
                case -1:
                case 10:
                    break;
                case 13:
                    int c22 = this.in.read();
                    if (c22 != 10 && c22 != -1) {
                        if (!(this.in instanceof PushbackInputStream)) {
                            this.in = new PushbackInputStream(this.in);
                        }
                        ((PushbackInputStream) this.in).unread(c22);
                        break;
                    }
                    break;
                default:
                    room--;
                    if (room < 0) {
                        buf = new char[offset + 128];
                        int room2 = (buf.length - offset) - 1;
                        System.arraycopy((Object) this.lineBuffer, 0, (Object) buf, 0, offset);
                        this.lineBuffer = buf;
                        room = room2;
                    }
                    buf[offset] = (char) c4;
                    offset++;
            }
        }
        if (c4 == -1 && offset == 0) {
            return null;
        }
        return String.copyValueOf(buf, 0, offset);
    }

    @Override // java.io.DataInput
    public final String readUTF() throws IOException {
        return readUTF(this);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:16:0x004f. Please report as an issue. */
    public static final String readUTF(DataInput in) throws IOException {
        byte[] bytearr;
        char[] chararr;
        int utflen = in.readUnsignedShort();
        if (in instanceof DataInputStream) {
            DataInputStream dis = (DataInputStream) in;
            if (dis.bytearr.length < utflen) {
                dis.bytearr = new byte[utflen * 2];
                dis.chararr = new char[utflen * 2];
            }
            chararr = dis.chararr;
            bytearr = dis.bytearr;
        } else {
            bytearr = new byte[utflen];
            chararr = new char[utflen];
        }
        int count = 0;
        int chararr_count = 0;
        in.readFully(bytearr, 0, utflen);
        while (count < utflen) {
            int c4 = bytearr[count] & 255;
            if (c4 > 127) {
                break;
            }
            count++;
            chararr[chararr_count] = (char) c4;
            chararr_count++;
        }
        while (count < utflen) {
            int c10 = bytearr[count] & 255;
            switch (c10 >> 4) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    count++;
                    chararr[chararr_count] = (char) c10;
                    chararr_count++;
                case 8:
                case 9:
                case 10:
                case 11:
                default:
                    throw new UTFDataFormatException("malformed input around byte " + count);
                case 12:
                case 13:
                    count += 2;
                    if (count > utflen) {
                        throw new UTFDataFormatException("malformed input: partial character at end");
                    }
                    int char2 = bytearr[count - 1];
                    if ((char2 & 192) != 128) {
                        throw new UTFDataFormatException("malformed input around byte " + count);
                    }
                    chararr[chararr_count] = (char) (((c10 & 31) << 6) | (char2 & 63));
                    chararr_count++;
                case 14:
                    count += 3;
                    if (count > utflen) {
                        throw new UTFDataFormatException("malformed input: partial character at end");
                    }
                    int char22 = bytearr[count - 2];
                    int char3 = bytearr[count - 1];
                    if ((char22 & 192) == 128 && (char3 & 192) == 128) {
                        chararr[chararr_count] = (char) (((c10 & 15) << 12) | ((char22 & 63) << 6) | ((char3 & 63) << 0));
                        chararr_count++;
                    } else {
                        throw new UTFDataFormatException("malformed input around byte " + (count - 1));
                    }
                    break;
            }
        }
        return new String(chararr, 0, chararr_count);
    }
}
