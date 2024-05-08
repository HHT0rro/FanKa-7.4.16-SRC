package sun.security.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import org.apache.commons.lang3.CharEncoding;
import org.apache.commons.lang3.time.TimeZones;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class DerOutputStream extends ByteArrayOutputStream implements DerEncoder {
    private static ByteArrayLexOrder lexOrder = new ByteArrayLexOrder();
    private static ByteArrayTagOrder tagOrder = new ByteArrayTagOrder();

    public DerOutputStream(int size) {
        super(size);
    }

    public DerOutputStream() {
    }

    public void write(byte tag, byte[] buf) throws IOException {
        write(tag);
        putLength(buf.length);
        write(buf, 0, buf.length);
    }

    public void write(byte tag, DerOutputStream out) throws IOException {
        write(tag);
        putLength(out.count);
        write(out.buf, 0, out.count);
    }

    public void writeImplicit(byte tag, DerOutputStream value) throws IOException {
        write(tag);
        write(value.buf, 1, value.count - 1);
    }

    public void putDerValue(DerValue val) throws IOException {
        val.encode(this);
    }

    public void putBoolean(boolean val) throws IOException {
        write(1);
        putLength(1);
        if (val) {
            write(255);
        } else {
            write(0);
        }
    }

    public void putEnumerated(int i10) throws IOException {
        write(10);
        putIntegerContents(i10);
    }

    public void putInteger(BigInteger i10) throws IOException {
        write(2);
        byte[] buf = i10.toByteArray();
        putLength(buf.length);
        write(buf, 0, buf.length);
    }

    public void putInteger(Integer i10) throws IOException {
        putInteger(i10.intValue());
    }

    public void putInteger(int i10) throws IOException {
        write(2);
        putIntegerContents(i10);
    }

    private void putIntegerContents(int i10) throws IOException {
        int start = 0;
        byte[] bytes = {(byte) (((-16777216) & i10) >>> 24), (byte) ((16711680 & i10) >>> 16), (byte) ((65280 & i10) >>> 8), (byte) (i10 & 255)};
        if (bytes[0] == -1) {
            for (int j10 = 0; j10 < 3 && bytes[j10] == -1 && (bytes[j10 + 1] & 128) == 128; j10++) {
                start++;
            }
        } else if (bytes[0] == 0) {
            for (int j11 = 0; j11 < 3 && bytes[j11] == 0 && (bytes[j11 + 1] & 128) == 0; j11++) {
                start++;
            }
        }
        int j12 = 4 - start;
        putLength(j12);
        for (int k10 = start; k10 < 4; k10++) {
            write(bytes[k10]);
        }
    }

    public void putBitString(byte[] bits) throws IOException {
        write(3);
        putLength(bits.length + 1);
        write(0);
        write(bits);
    }

    public void putUnalignedBitString(BitArray ba2) throws IOException {
        byte[] bits = ba2.toByteArray();
        write(3);
        putLength(bits.length + 1);
        write((bits.length * 8) - ba2.length());
        write(bits);
    }

    public void putTruncatedUnalignedBitString(BitArray ba2) throws IOException {
        putUnalignedBitString(ba2.truncate());
    }

    public void putOctetString(byte[] octets) throws IOException {
        write((byte) 4, octets);
    }

    public void putNull() throws IOException {
        write(5);
        putLength(0);
    }

    public void putOID(ObjectIdentifier oid) throws IOException {
        oid.encode(this);
    }

    public void putSequence(DerValue[] seq) throws IOException {
        DerOutputStream bytes = new DerOutputStream();
        for (DerValue derValue : seq) {
            derValue.encode(bytes);
        }
        write((byte) 48, bytes);
    }

    public void putSet(DerValue[] set) throws IOException {
        DerOutputStream bytes = new DerOutputStream();
        for (DerValue derValue : set) {
            derValue.encode(bytes);
        }
        write((byte) 49, bytes);
    }

    public void putOrderedSetOf(byte tag, DerEncoder[] set) throws IOException {
        putOrderedSet(tag, set, lexOrder);
    }

    public void putOrderedSet(byte tag, DerEncoder[] set) throws IOException {
        putOrderedSet(tag, set, tagOrder);
    }

    private void putOrderedSet(byte tag, DerEncoder[] set, Comparator<byte[]> order) throws IOException {
        DerOutputStream[] streams = new DerOutputStream[set.length];
        for (int i10 = 0; i10 < set.length; i10++) {
            streams[i10] = new DerOutputStream();
            set[i10].derEncode(streams[i10]);
        }
        int i11 = streams.length;
        byte[][] bufs = new byte[i11];
        for (int i12 = 0; i12 < streams.length; i12++) {
            bufs[i12] = streams[i12].toByteArray();
        }
        Arrays.sort(bufs, order);
        DerOutputStream bytes = new DerOutputStream();
        for (int i13 = 0; i13 < streams.length; i13++) {
            bytes.write(bufs[i13]);
        }
        write(tag, bytes);
    }

    public void putUTF8String(String s2) throws IOException {
        writeString(s2, (byte) 12, "UTF8");
    }

    public void putPrintableString(String s2) throws IOException {
        writeString(s2, (byte) 19, "ASCII");
    }

    public void putT61String(String s2) throws IOException {
        writeString(s2, (byte) 20, CharEncoding.ISO_8859_1);
    }

    public void putIA5String(String s2) throws IOException {
        writeString(s2, (byte) 22, "ASCII");
    }

    public void putBMPString(String s2) throws IOException {
        writeString(s2, (byte) 30, "UnicodeBigUnmarked");
    }

    public void putGeneralString(String s2) throws IOException {
        writeString(s2, (byte) 27, "ASCII");
    }

    private void writeString(String s2, byte stringTag, String enc) throws IOException {
        byte[] data = s2.getBytes(enc);
        write(stringTag);
        putLength(data.length);
        write(data);
    }

    public void putUTCTime(Date d10) throws IOException {
        putTime(d10, (byte) 23);
    }

    public void putGeneralizedTime(Date d10) throws IOException {
        putTime(d10, (byte) 24);
    }

    private void putTime(Date d10, byte tag) throws IOException {
        String pattern;
        TimeZone tz = TimeZone.getTimeZone(TimeZones.GMT_ID);
        if (tag == 23) {
            pattern = "yyMMddHHmmss'Z'";
        } else {
            tag = 24;
            pattern = "yyyyMMddHHmmss'Z'";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern, Locale.US);
        sdf.setTimeZone(tz);
        byte[] time = sdf.format(d10).getBytes(CharEncoding.ISO_8859_1);
        write(tag);
        putLength(time.length);
        write(time);
    }

    public void putLength(int len) throws IOException {
        if (len < 128) {
            write((byte) len);
            return;
        }
        if (len < 256) {
            write(-127);
            write((byte) len);
            return;
        }
        if (len < 65536) {
            write(-126);
            write((byte) (len >> 8));
            write((byte) len);
        } else {
            if (len < 16777216) {
                write(-125);
                write((byte) (len >> 16));
                write((byte) (len >> 8));
                write((byte) len);
                return;
            }
            write(-124);
            write((byte) (len >> 24));
            write((byte) (len >> 16));
            write((byte) (len >> 8));
            write((byte) len);
        }
    }

    public void putTag(byte tagClass, boolean form, byte val) {
        byte tag = (byte) (tagClass | val);
        if (form) {
            tag = (byte) (tag | 32);
        }
        write(tag);
    }

    @Override // sun.security.util.DerEncoder
    public void derEncode(OutputStream out) throws IOException {
        out.write(toByteArray());
    }
}
