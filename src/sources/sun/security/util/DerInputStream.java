package sun.security.util;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.Date;
import java.util.Vector;
import org.apache.commons.lang3.CharEncoding;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class DerInputStream {
    DerInputBuffer buffer;
    public byte tag;

    public DerInputStream(byte[] data) throws IOException {
        init(data, 0, data.length, true);
    }

    public DerInputStream(byte[] data, int offset, int len) throws IOException {
        init(data, offset, len, true);
    }

    public DerInputStream(byte[] data, int offset, int len, boolean allowIndefiniteLength) throws IOException {
        init(data, offset, len, allowIndefiniteLength);
    }

    private void init(byte[] data, int offset, int len, boolean allowIndefiniteLength) throws IOException {
        if (offset + 2 > data.length || offset + len > data.length) {
            throw new IOException("Encoding bytes too short");
        }
        if (DerIndefLenConverter.isIndefinite(data[offset + 1])) {
            if (!allowIndefiniteLength) {
                throw new IOException("Indefinite length BER encoding found");
            }
            byte[] inData = new byte[len];
            System.arraycopy((Object) data, offset, (Object) inData, 0, len);
            DerIndefLenConverter derIn = new DerIndefLenConverter();
            this.buffer = new DerInputBuffer(derIn.convert(inData));
        } else {
            this.buffer = new DerInputBuffer(data, offset, len);
        }
        this.buffer.mark(Integer.MAX_VALUE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DerInputStream(DerInputBuffer buf) {
        this.buffer = buf;
        buf.mark(Integer.MAX_VALUE);
    }

    public DerInputStream subStream(int len, boolean do_skip) throws IOException {
        DerInputBuffer newbuf = this.buffer.dup();
        newbuf.truncate(len);
        if (do_skip) {
            this.buffer.skip(len);
        }
        return new DerInputStream(newbuf);
    }

    public byte[] toByteArray() {
        return this.buffer.toByteArray();
    }

    public int getInteger() throws IOException {
        if (this.buffer.read() != 2) {
            throw new IOException("DER input, Integer tag error");
        }
        DerInputBuffer derInputBuffer = this.buffer;
        return derInputBuffer.getInteger(getLength(derInputBuffer));
    }

    public BigInteger getBigInteger() throws IOException {
        if (this.buffer.read() != 2) {
            throw new IOException("DER input, Integer tag error");
        }
        DerInputBuffer derInputBuffer = this.buffer;
        return derInputBuffer.getBigInteger(getLength(derInputBuffer), false);
    }

    public BigInteger getPositiveBigInteger() throws IOException {
        if (this.buffer.read() != 2) {
            throw new IOException("DER input, Integer tag error");
        }
        DerInputBuffer derInputBuffer = this.buffer;
        return derInputBuffer.getBigInteger(getLength(derInputBuffer), true);
    }

    public int getEnumerated() throws IOException {
        if (this.buffer.read() != 10) {
            throw new IOException("DER input, Enumerated tag error");
        }
        DerInputBuffer derInputBuffer = this.buffer;
        return derInputBuffer.getInteger(getLength(derInputBuffer));
    }

    public byte[] getBitString() throws IOException {
        if (this.buffer.read() != 3) {
            throw new IOException("DER input not an bit string");
        }
        DerInputBuffer derInputBuffer = this.buffer;
        return derInputBuffer.getBitString(getLength(derInputBuffer));
    }

    public BitArray getUnalignedBitString() throws IOException {
        if (this.buffer.read() != 3) {
            throw new IOException("DER input not a bit string");
        }
        int length = getLength(this.buffer) - 1;
        int excessBits = this.buffer.read();
        if (excessBits < 0) {
            throw new IOException("Unused bits of bit string invalid");
        }
        int validBits = (length * 8) - excessBits;
        if (validBits < 0) {
            throw new IOException("Valid bits of bit string invalid");
        }
        byte[] repn = new byte[length];
        if (length != 0 && this.buffer.read(repn) != length) {
            throw new IOException("Short read of DER bit string");
        }
        return new BitArray(validBits, repn);
    }

    public byte[] getOctetString() throws IOException {
        if (this.buffer.read() != 4) {
            throw new IOException("DER input not an octet string");
        }
        int length = getLength(this.buffer);
        byte[] retval = new byte[length];
        if (length != 0 && this.buffer.read(retval) != length) {
            throw new IOException("Short read of DER octet string");
        }
        return retval;
    }

    public void getBytes(byte[] val) throws IOException {
        if (val.length != 0 && this.buffer.read(val) != val.length) {
            throw new IOException("Short read of DER octet string");
        }
    }

    public void getNull() throws IOException {
        if (this.buffer.read() != 5 || this.buffer.read() != 0) {
            throw new IOException("getNull, bad data");
        }
    }

    public ObjectIdentifier getOID() throws IOException {
        return new ObjectIdentifier(this);
    }

    public DerValue[] getSequence(int startLen, boolean originalEncodedFormRetained) throws IOException {
        byte read = (byte) this.buffer.read();
        this.tag = read;
        if (read != 48) {
            throw new IOException("Sequence tag error");
        }
        return readVector(startLen, originalEncodedFormRetained);
    }

    public DerValue[] getSequence(int startLen) throws IOException {
        return getSequence(startLen, false);
    }

    public DerValue[] getSet(int startLen) throws IOException {
        byte read = (byte) this.buffer.read();
        this.tag = read;
        if (read != 49) {
            throw new IOException("Set tag error");
        }
        return readVector(startLen);
    }

    public DerValue[] getSet(int startLen, boolean implicit) throws IOException {
        return getSet(startLen, implicit, false);
    }

    public DerValue[] getSet(int startLen, boolean implicit, boolean originalEncodedFormRetained) throws IOException {
        byte read = (byte) this.buffer.read();
        this.tag = read;
        if (!implicit && read != 49) {
            throw new IOException("Set tag error");
        }
        return readVector(startLen, originalEncodedFormRetained);
    }

    protected DerValue[] readVector(int startLen) throws IOException {
        return readVector(startLen, false);
    }

    protected DerValue[] readVector(int startLen, boolean originalEncodedFormRetained) throws IOException {
        DerInputStream newstr;
        byte lenByte = (byte) this.buffer.read();
        int len = getLength(lenByte, this.buffer);
        if (len == -1) {
            int readLen = this.buffer.available();
            byte[] indefData = new byte[readLen + 2];
            indefData[0] = this.tag;
            indefData[1] = lenByte;
            DataInputStream dis = new DataInputStream(this.buffer);
            dis.readFully(indefData, 2, readLen);
            dis.close();
            DerIndefLenConverter derIn = new DerIndefLenConverter();
            DerInputBuffer derInputBuffer = new DerInputBuffer(derIn.convert(indefData));
            this.buffer = derInputBuffer;
            if (this.tag != derInputBuffer.read()) {
                throw new IOException("Indefinite length encoding not supported");
            }
            len = getLength(this.buffer);
        }
        if (len == 0) {
            return new DerValue[0];
        }
        if (this.buffer.available() == len) {
            newstr = this;
        } else {
            newstr = subStream(len, true);
        }
        Vector<DerValue> vec = new Vector<>(startLen);
        do {
            DerValue value = new DerValue(newstr.buffer, originalEncodedFormRetained);
            vec.addElement(value);
        } while (newstr.available() > 0);
        if (newstr.available() != 0) {
            throw new IOException("Extra data at end of vector");
        }
        int max = vec.size();
        DerValue[] retval = new DerValue[max];
        for (int i10 = 0; i10 < max; i10++) {
            retval[i10] = vec.elementAt(i10);
        }
        return retval;
    }

    public DerValue getDerValue() throws IOException {
        return new DerValue(this.buffer);
    }

    public String getUTF8String() throws IOException {
        return readString((byte) 12, "UTF-8", "UTF8");
    }

    public String getPrintableString() throws IOException {
        return readString((byte) 19, "Printable", "ASCII");
    }

    public String getT61String() throws IOException {
        return readString((byte) 20, "T61", CharEncoding.ISO_8859_1);
    }

    public String getIA5String() throws IOException {
        return readString((byte) 22, "IA5", "ASCII");
    }

    public String getBMPString() throws IOException {
        return readString((byte) 30, "BMP", "UnicodeBigUnmarked");
    }

    public String getGeneralString() throws IOException {
        return readString((byte) 27, "General", "ASCII");
    }

    private String readString(byte stringTag, String stringName, String enc) throws IOException {
        if (this.buffer.read() != stringTag) {
            throw new IOException("DER input not a " + stringName + " string");
        }
        int length = getLength(this.buffer);
        byte[] retval = new byte[length];
        if (length != 0 && this.buffer.read(retval) != length) {
            throw new IOException("Short read of DER " + stringName + " string");
        }
        return new String(retval, enc);
    }

    public Date getUTCTime() throws IOException {
        if (this.buffer.read() != 23) {
            throw new IOException("DER input, UTCtime tag invalid ");
        }
        DerInputBuffer derInputBuffer = this.buffer;
        return derInputBuffer.getUTCTime(getLength(derInputBuffer));
    }

    public Date getGeneralizedTime() throws IOException {
        if (this.buffer.read() != 24) {
            throw new IOException("DER input, GeneralizedTime tag invalid ");
        }
        DerInputBuffer derInputBuffer = this.buffer;
        return derInputBuffer.getGeneralizedTime(getLength(derInputBuffer));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getByte() throws IOException {
        return this.buffer.read() & 255;
    }

    public int peekByte() throws IOException {
        return this.buffer.peek();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getLength() throws IOException {
        return getLength(this.buffer);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getLength(InputStream in) throws IOException {
        return getLength(in.read(), in);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getLength(int lenByte, InputStream in) throws IOException {
        if (lenByte == -1) {
            throw new IOException("Short read of DER length");
        }
        if ((lenByte & 128) == 0) {
            return lenByte;
        }
        int tmp = lenByte & 127;
        if (tmp == 0) {
            return -1;
        }
        if (tmp < 0 || tmp > 4) {
            throw new IOException("DerInputStream.getLength(): lengthTag=" + tmp + ", " + (tmp < 0 ? "incorrect DER encoding." : "too big."));
        }
        int value = in.read() & 255;
        int tmp2 = tmp - 1;
        if (value == 0) {
            throw new IOException("DerInputStream.getLength(): Redundant length bytes found");
        }
        int value2 = value;
        while (true) {
            int value3 = tmp2 - 1;
            if (tmp2 <= 0) {
                break;
            }
            value2 = (value2 << 8) + (in.read() & 255);
            tmp2 = value3;
        }
        if (value2 < 0) {
            throw new IOException("DerInputStream.getLength(): Invalid length bytes");
        }
        if (value2 <= 127) {
            throw new IOException("DerInputStream.getLength(): Should use short form for length");
        }
        return value2;
    }

    public void mark(int value) {
        this.buffer.mark(value);
    }

    public void reset() {
        this.buffer.reset();
    }

    public int available() {
        return this.buffer.available();
    }
}
