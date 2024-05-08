package sun.security.util;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.Date;
import org.apache.commons.lang3.CharEncoding;
import sun.misc.IOUtils;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class DerValue {
    public static final byte TAG_APPLICATION = 64;
    public static final byte TAG_CONTEXT = Byte.MIN_VALUE;
    public static final byte TAG_PRIVATE = -64;
    public static final byte TAG_UNIVERSAL = 0;
    public static final byte tag_BMPString = 30;
    public static final byte tag_BitString = 3;
    public static final byte tag_Boolean = 1;
    public static final byte tag_Enumerated = 10;
    public static final byte tag_GeneralString = 27;
    public static final byte tag_GeneralizedTime = 24;
    public static final byte tag_IA5String = 22;
    public static final byte tag_Integer = 2;
    public static final byte tag_Null = 5;
    public static final byte tag_ObjectId = 6;
    public static final byte tag_OctetString = 4;
    public static final byte tag_PrintableString = 19;
    public static final byte tag_Sequence = 48;
    public static final byte tag_SequenceOf = 48;
    public static final byte tag_Set = 49;
    public static final byte tag_SetOf = 49;
    public static final byte tag_T61String = 20;
    public static final byte tag_UTF8String = 12;
    public static final byte tag_UniversalString = 28;
    public static final byte tag_UtcTime = 23;
    protected DerInputBuffer buffer;
    public final DerInputStream data;
    private int length;
    private byte[] originalEncodedForm;
    public byte tag;

    public boolean isUniversal() {
        return (this.tag & 192) == 0;
    }

    public boolean isApplication() {
        return (this.tag & 192) == 64;
    }

    public boolean isContextSpecific() {
        return (this.tag & 192) == 128;
    }

    public boolean isContextSpecific(byte cntxtTag) {
        return isContextSpecific() && (this.tag & 31) == cntxtTag;
    }

    boolean isPrivate() {
        return (this.tag & 192) == 192;
    }

    public boolean isConstructed() {
        return (this.tag & 32) == 32;
    }

    public boolean isConstructed(byte constructedTag) {
        return isConstructed() && (this.tag & 31) == constructedTag;
    }

    public DerValue(String value) throws IOException {
        boolean isPrintableString = true;
        int i10 = 0;
        while (true) {
            if (i10 >= value.length()) {
                break;
            }
            if (isPrintableStringChar(value.charAt(i10))) {
                i10++;
            } else {
                isPrintableString = false;
                break;
            }
        }
        this.data = init(isPrintableString ? (byte) 19 : (byte) 12, value);
    }

    public DerValue(byte stringTag, String value) throws IOException {
        this.data = init(stringTag, value);
    }

    public DerValue(byte tag, byte[] data) {
        this.tag = tag;
        DerInputBuffer derInputBuffer = new DerInputBuffer((byte[]) data.clone());
        this.buffer = derInputBuffer;
        this.length = data.length;
        DerInputStream derInputStream = new DerInputStream(derInputBuffer);
        this.data = derInputStream;
        derInputStream.mark(Integer.MAX_VALUE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DerValue(DerInputBuffer in, boolean originalEncodedFormRetained) throws IOException {
        int startPosInInput = in.getPos();
        this.tag = (byte) in.read();
        byte lenByte = (byte) in.read();
        int length = DerInputStream.getLength(lenByte, in);
        this.length = length;
        if (length == -1) {
            DerInputBuffer inbuf = in.dup();
            int readLen = inbuf.available();
            byte[] indefData = new byte[readLen + 2];
            indefData[0] = this.tag;
            indefData[1] = lenByte;
            DataInputStream dis = new DataInputStream(inbuf);
            dis.readFully(indefData, 2, readLen);
            dis.close();
            DerIndefLenConverter derIn = new DerIndefLenConverter();
            DerInputBuffer inbuf2 = new DerInputBuffer(derIn.convert(indefData));
            if (this.tag != inbuf2.read()) {
                throw new IOException("Indefinite length encoding not supported");
            }
            this.length = DerInputStream.getLength(inbuf2);
            DerInputBuffer dup = inbuf2.dup();
            this.buffer = dup;
            dup.truncate(this.length);
            this.data = new DerInputStream(this.buffer);
            in.skip(this.length + 2);
        } else {
            DerInputBuffer inbuf3 = in.dup();
            this.buffer = inbuf3;
            inbuf3.truncate(this.length);
            this.data = new DerInputStream(this.buffer);
            in.skip(this.length);
        }
        if (originalEncodedFormRetained) {
            int consumed = in.getPos() - startPosInInput;
            this.originalEncodedForm = in.getSlice(startPosInInput, consumed);
        }
    }

    public DerValue(byte[] buf) throws IOException {
        this.data = init(true, (InputStream) new ByteArrayInputStream(buf));
    }

    public DerValue(byte[] buf, int offset, int len) throws IOException {
        this.data = init(true, (InputStream) new ByteArrayInputStream(buf, offset, len));
    }

    public DerValue(InputStream in) throws IOException {
        this.data = init(false, in);
    }

    private DerInputStream init(byte stringTag, String value) throws IOException {
        String enc;
        this.tag = stringTag;
        switch (stringTag) {
            case 12:
                enc = "UTF8";
                break;
            case 19:
            case 22:
            case 27:
                enc = "ASCII";
                break;
            case 20:
                enc = CharEncoding.ISO_8859_1;
                break;
            case 30:
                enc = "UnicodeBigUnmarked";
                break;
            default:
                throw new IllegalArgumentException("Unsupported DER string type");
        }
        byte[] buf = value.getBytes(enc);
        this.length = buf.length;
        DerInputBuffer derInputBuffer = new DerInputBuffer(buf);
        this.buffer = derInputBuffer;
        DerInputStream result = new DerInputStream(derInputBuffer);
        result.mark(Integer.MAX_VALUE);
        return result;
    }

    private DerInputStream init(boolean fullyBuffered, InputStream in) throws IOException {
        this.tag = (byte) in.read();
        byte lenByte = (byte) in.read();
        int length = DerInputStream.getLength(lenByte, in);
        this.length = length;
        if (length == -1) {
            int readLen = in.available();
            byte[] indefData = new byte[readLen + 2];
            indefData[0] = this.tag;
            indefData[1] = lenByte;
            DataInputStream dis = new DataInputStream(in);
            dis.readFully(indefData, 2, readLen);
            dis.close();
            DerIndefLenConverter derIn = new DerIndefLenConverter();
            in = new ByteArrayInputStream(derIn.convert(indefData));
            if (this.tag != in.read()) {
                throw new IOException("Indefinite length encoding not supported");
            }
            this.length = DerInputStream.getLength(in);
        }
        if (fullyBuffered && in.available() != this.length) {
            throw new IOException("extra data given to DerValue constructor");
        }
        byte[] bytes = IOUtils.readFully(in, this.length, true);
        DerInputBuffer derInputBuffer = new DerInputBuffer(bytes);
        this.buffer = derInputBuffer;
        return new DerInputStream(derInputBuffer);
    }

    public void encode(DerOutputStream out) throws IOException {
        out.write(this.tag);
        out.putLength(this.length);
        int i10 = this.length;
        if (i10 > 0) {
            byte[] value = new byte[i10];
            synchronized (this.data) {
                this.buffer.reset();
                if (this.buffer.read(value) != this.length) {
                    throw new IOException("short DER value read (encode)");
                }
                out.write(value);
            }
        }
    }

    public final DerInputStream getData() {
        return this.data;
    }

    public final byte getTag() {
        return this.tag;
    }

    public boolean getBoolean() throws IOException {
        if (this.tag != 1) {
            throw new IOException("DerValue.getBoolean, not a BOOLEAN " + ((int) this.tag));
        }
        if (this.length == 1) {
            return this.buffer.read() != 0;
        }
        throw new IOException("DerValue.getBoolean, invalid length " + this.length);
    }

    public ObjectIdentifier getOID() throws IOException {
        if (this.tag != 6) {
            throw new IOException("DerValue.getOID, not an OID " + ((int) this.tag));
        }
        return new ObjectIdentifier(this.buffer);
    }

    private byte[] append(byte[] a10, byte[] b4) {
        if (a10 == null) {
            return b4;
        }
        byte[] ret = new byte[a10.length + b4.length];
        System.arraycopy((Object) a10, 0, (Object) ret, 0, a10.length);
        System.arraycopy((Object) b4, 0, (Object) ret, a10.length, b4.length);
        return ret;
    }

    public byte[] getOctetString() throws IOException {
        if (this.tag != 4 && !isConstructed((byte) 4)) {
            throw new IOException("DerValue.getOctetString, not an Octet String: " + ((int) this.tag));
        }
        int i10 = this.length;
        byte[] bytes = new byte[i10];
        if (i10 == 0) {
            return bytes;
        }
        if (this.buffer.read(bytes) != this.length) {
            throw new IOException("short read on DerValue buffer");
        }
        if (isConstructed()) {
            DerInputStream in = new DerInputStream(bytes);
            bytes = null;
            while (in.available() != 0) {
                bytes = append(bytes, in.getOctetString());
            }
        }
        return bytes;
    }

    public int getInteger() throws IOException {
        if (this.tag != 2) {
            throw new IOException("DerValue.getInteger, not an int " + ((int) this.tag));
        }
        return this.buffer.getInteger(this.data.available());
    }

    public BigInteger getBigInteger() throws IOException {
        if (this.tag != 2) {
            throw new IOException("DerValue.getBigInteger, not an int " + ((int) this.tag));
        }
        return this.buffer.getBigInteger(this.data.available(), false);
    }

    public BigInteger getPositiveBigInteger() throws IOException {
        if (this.tag != 2) {
            throw new IOException("DerValue.getBigInteger, not an int " + ((int) this.tag));
        }
        return this.buffer.getBigInteger(this.data.available(), true);
    }

    public int getEnumerated() throws IOException {
        if (this.tag != 10) {
            throw new IOException("DerValue.getEnumerated, incorrect tag: " + ((int) this.tag));
        }
        return this.buffer.getInteger(this.data.available());
    }

    public byte[] getBitString() throws IOException {
        if (this.tag != 3) {
            throw new IOException("DerValue.getBitString, not a bit string " + ((int) this.tag));
        }
        return this.buffer.getBitString();
    }

    public BitArray getUnalignedBitString() throws IOException {
        if (this.tag != 3) {
            throw new IOException("DerValue.getBitString, not a bit string " + ((int) this.tag));
        }
        return this.buffer.getUnalignedBitString();
    }

    public String getAsString() throws IOException {
        byte b4 = this.tag;
        if (b4 == 12) {
            return getUTF8String();
        }
        if (b4 == 19) {
            return getPrintableString();
        }
        if (b4 == 20) {
            return getT61String();
        }
        if (b4 == 22) {
            return getIA5String();
        }
        if (b4 == 30) {
            return getBMPString();
        }
        if (b4 == 27) {
            return getGeneralString();
        }
        return null;
    }

    public byte[] getBitString(boolean tagImplicit) throws IOException {
        if (!tagImplicit && this.tag != 3) {
            throw new IOException("DerValue.getBitString, not a bit string " + ((int) this.tag));
        }
        return this.buffer.getBitString();
    }

    public BitArray getUnalignedBitString(boolean tagImplicit) throws IOException {
        if (!tagImplicit && this.tag != 3) {
            throw new IOException("DerValue.getBitString, not a bit string " + ((int) this.tag));
        }
        return this.buffer.getUnalignedBitString();
    }

    public byte[] getDataBytes() throws IOException {
        byte[] retVal = new byte[this.length];
        synchronized (this.data) {
            this.data.reset();
            this.data.getBytes(retVal);
        }
        return retVal;
    }

    public String getPrintableString() throws IOException {
        if (this.tag != 19) {
            throw new IOException("DerValue.getPrintableString, not a string " + ((int) this.tag));
        }
        return new String(getDataBytes(), "ASCII");
    }

    public String getT61String() throws IOException {
        if (this.tag != 20) {
            throw new IOException("DerValue.getT61String, not T61 " + ((int) this.tag));
        }
        return new String(getDataBytes(), CharEncoding.ISO_8859_1);
    }

    public String getIA5String() throws IOException {
        if (this.tag != 22) {
            throw new IOException("DerValue.getIA5String, not IA5 " + ((int) this.tag));
        }
        return new String(getDataBytes(), "ASCII");
    }

    public String getBMPString() throws IOException {
        if (this.tag != 30) {
            throw new IOException("DerValue.getBMPString, not BMP " + ((int) this.tag));
        }
        return new String(getDataBytes(), "UnicodeBigUnmarked");
    }

    public String getUTF8String() throws IOException {
        if (this.tag != 12) {
            throw new IOException("DerValue.getUTF8String, not UTF-8 " + ((int) this.tag));
        }
        return new String(getDataBytes(), "UTF8");
    }

    public String getGeneralString() throws IOException {
        if (this.tag != 27) {
            throw new IOException("DerValue.getGeneralString, not GeneralString " + ((int) this.tag));
        }
        return new String(getDataBytes(), "ASCII");
    }

    public Date getUTCTime() throws IOException {
        if (this.tag != 23) {
            throw new IOException("DerValue.getUTCTime, not a UtcTime: " + ((int) this.tag));
        }
        return this.buffer.getUTCTime(this.data.available());
    }

    public Date getGeneralizedTime() throws IOException {
        if (this.tag != 24) {
            throw new IOException("DerValue.getGeneralizedTime, not a GeneralizedTime: " + ((int) this.tag));
        }
        return this.buffer.getGeneralizedTime(this.data.available());
    }

    public boolean equals(Object other) {
        if (other instanceof DerValue) {
            return equals((DerValue) other);
        }
        return false;
    }

    public boolean equals(DerValue other) {
        if (this == other) {
            return true;
        }
        if (this.tag != other.tag) {
            return false;
        }
        DerInputStream derInputStream = this.data;
        if (derInputStream == other.data) {
            return true;
        }
        if (System.identityHashCode(derInputStream) > System.identityHashCode(other.data)) {
            return doEquals(this, other);
        }
        return doEquals(other, this);
    }

    private static boolean doEquals(DerValue d12, DerValue d22) {
        boolean equals;
        synchronized (d12.data) {
            synchronized (d22.data) {
                d12.data.reset();
                d22.data.reset();
                equals = d12.buffer.equals(d22.buffer);
            }
        }
        return equals;
    }

    public String toString() {
        try {
            String str = getAsString();
            if (str != null) {
                return "\"" + str + "\"";
            }
            byte b4 = this.tag;
            if (b4 == 5) {
                return "[DerValue, null]";
            }
            if (b4 == 6) {
                return "OID." + ((Object) getOID());
            }
            return "[DerValue, tag = " + ((int) this.tag) + ", length = " + this.length + "]";
        } catch (IOException e2) {
            throw new IllegalArgumentException("misformatted DER value");
        }
    }

    public byte[] getOriginalEncodedForm() {
        byte[] bArr = this.originalEncodedForm;
        if (bArr != null) {
            return (byte[]) bArr.clone();
        }
        return null;
    }

    public byte[] toByteArray() throws IOException {
        DerOutputStream out = new DerOutputStream();
        encode(out);
        this.data.reset();
        return out.toByteArray();
    }

    public DerInputStream toDerInputStream() throws IOException {
        byte b4 = this.tag;
        if (b4 == 48 || b4 == 49) {
            return new DerInputStream(this.buffer);
        }
        throw new IOException("toDerInputStream rejects tag type " + ((int) this.tag));
    }

    public int length() {
        return this.length;
    }

    public static boolean isPrintableStringChar(char ch) {
        if ((ch >= 'a' && ch <= 'z') || ((ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9'))) {
            return true;
        }
        switch (ch) {
            case ' ':
            case '\'':
            case '(':
            case ')':
            case '+':
            case ',':
            case '-':
            case '.':
            case '/':
            case ':':
            case '=':
            case '?':
                return true;
            default:
                return false;
        }
    }

    public static byte createTag(byte tagClass, boolean form, byte val) {
        byte tag = (byte) (tagClass | val);
        if (form) {
            return (byte) (tag | 32);
        }
        return tag;
    }

    public void resetTag(byte tag) {
        this.tag = tag;
    }

    public int hashCode() {
        return toString().hashCode();
    }
}
