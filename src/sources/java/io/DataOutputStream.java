package java.io;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class DataOutputStream extends FilterOutputStream implements DataOutput {
    private byte[] bytearr;
    private byte[] writeBuffer;
    protected int written;

    public DataOutputStream(OutputStream out) {
        super(out);
        this.bytearr = null;
        this.writeBuffer = new byte[8];
    }

    private void incCount(int value) {
        int temp = this.written + value;
        if (temp < 0) {
            temp = Integer.MAX_VALUE;
        }
        this.written = temp;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public synchronized void write(int b4) throws IOException {
        this.out.write(b4);
        incCount(1);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public synchronized void write(byte[] b4, int off, int len) throws IOException {
        this.out.write(b4, off, len);
        incCount(len);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        this.out.flush();
    }

    @Override // java.io.DataOutput
    public final void writeBoolean(boolean z10) throws IOException {
        this.out.write(z10 ? 1 : 0);
        incCount(1);
    }

    @Override // java.io.DataOutput
    public final void writeByte(int v2) throws IOException {
        this.out.write(v2);
        incCount(1);
    }

    @Override // java.io.DataOutput
    public final void writeShort(int v2) throws IOException {
        this.out.write((v2 >>> 8) & 255);
        this.out.write((v2 >>> 0) & 255);
        incCount(2);
    }

    @Override // java.io.DataOutput
    public final void writeChar(int v2) throws IOException {
        this.out.write((v2 >>> 8) & 255);
        this.out.write((v2 >>> 0) & 255);
        incCount(2);
    }

    @Override // java.io.DataOutput
    public final void writeInt(int v2) throws IOException {
        this.out.write((v2 >>> 24) & 255);
        this.out.write((v2 >>> 16) & 255);
        this.out.write((v2 >>> 8) & 255);
        this.out.write((v2 >>> 0) & 255);
        incCount(4);
    }

    @Override // java.io.DataOutput
    public final void writeLong(long v2) throws IOException {
        byte[] bArr = this.writeBuffer;
        bArr[0] = (byte) (v2 >>> 56);
        bArr[1] = (byte) (v2 >>> 48);
        bArr[2] = (byte) (v2 >>> 40);
        bArr[3] = (byte) (v2 >>> 32);
        bArr[4] = (byte) (v2 >>> 24);
        bArr[5] = (byte) (v2 >>> 16);
        bArr[6] = (byte) (v2 >>> 8);
        bArr[7] = (byte) (v2 >>> 0);
        this.out.write(this.writeBuffer, 0, 8);
        incCount(8);
    }

    @Override // java.io.DataOutput
    public final void writeFloat(float v2) throws IOException {
        writeInt(Float.floatToIntBits(v2));
    }

    @Override // java.io.DataOutput
    public final void writeDouble(double v2) throws IOException {
        writeLong(Double.doubleToLongBits(v2));
    }

    @Override // java.io.DataOutput
    public final void writeBytes(String s2) throws IOException {
        int len = s2.length();
        for (int i10 = 0; i10 < len; i10++) {
            this.out.write((byte) s2.charAt(i10));
        }
        incCount(len);
    }

    @Override // java.io.DataOutput
    public final void writeChars(String s2) throws IOException {
        int len = s2.length();
        for (int i10 = 0; i10 < len; i10++) {
            int v2 = s2.charAt(i10);
            this.out.write((v2 >>> 8) & 255);
            this.out.write((v2 >>> 0) & 255);
        }
        int i11 = len * 2;
        incCount(i11);
    }

    @Override // java.io.DataOutput
    public final void writeUTF(String str) throws IOException {
        writeUTF(str, this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int writeUTF(String str, DataOutput out) throws IOException {
        byte[] bytearr;
        int strlen = str.length();
        int utflen = 0;
        for (int i10 = 0; i10 < strlen; i10++) {
            int c4 = str.charAt(i10);
            if (c4 >= 1 && c4 <= 127) {
                utflen++;
            } else if (c4 > 2047) {
                utflen += 3;
            } else {
                utflen += 2;
            }
        }
        if (utflen > 65535) {
            throw new UTFDataFormatException("encoded string too long: " + utflen + " bytes");
        }
        if (out instanceof DataOutputStream) {
            DataOutputStream dos = (DataOutputStream) out;
            byte[] bArr = dos.bytearr;
            if (bArr == null || bArr.length < utflen + 2) {
                dos.bytearr = new byte[(utflen * 2) + 2];
            }
            bytearr = dos.bytearr;
        } else {
            bytearr = new byte[utflen + 2];
        }
        int count = 0 + 1;
        bytearr[0] = (byte) ((utflen >>> 8) & 255);
        int count2 = count + 1;
        bytearr[count] = (byte) ((utflen >>> 0) & 255);
        int i11 = 0;
        while (i11 < strlen) {
            int c10 = str.charAt(i11);
            if (c10 < 1 || c10 > 127) {
                break;
            }
            bytearr[count2] = (byte) c10;
            i11++;
            count2++;
        }
        while (i11 < strlen) {
            int c11 = str.charAt(i11);
            if (c11 >= 1 && c11 <= 127) {
                bytearr[count2] = (byte) c11;
                count2++;
            } else if (c11 > 2047) {
                int count3 = count2 + 1;
                bytearr[count2] = (byte) (((c11 >> 12) & 15) | 224);
                int count4 = count3 + 1;
                bytearr[count3] = (byte) (((c11 >> 6) & 63) | 128);
                bytearr[count4] = (byte) (((c11 >> 0) & 63) | 128);
                count2 = count4 + 1;
            } else {
                int count5 = count2 + 1;
                bytearr[count2] = (byte) (((c11 >> 6) & 31) | 192);
                count2 = count5 + 1;
                bytearr[count5] = (byte) (((c11 >> 0) & 63) | 128);
            }
            i11++;
        }
        out.write(bytearr, 0, utflen + 2);
        return utflen + 2;
    }

    public final int size() {
        return this.written;
    }
}
