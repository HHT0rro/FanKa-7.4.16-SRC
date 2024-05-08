package sun.security.util;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.zip.ZipUtils;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class ObjectIdentifier implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long serialVersionUID = 8697030238860181294L;
    private int componentLen;
    private Object components;
    private transient boolean componentsCalculated;
    private byte[] encoding;
    private volatile transient String stringForm;

    private void readObject(ObjectInputStream is) throws IOException, ClassNotFoundException {
        is.defaultReadObject();
        if (this.encoding == null) {
            init((int[]) this.components, this.componentLen);
        }
    }

    private void writeObject(ObjectOutputStream os) throws IOException {
        if (!this.componentsCalculated) {
            int[] comps = toIntArray();
            if (comps != null) {
                this.components = comps;
                this.componentLen = comps.length;
            } else {
                this.components = HugeOidNotSupportedByOldJDK.theOne;
            }
            this.componentsCalculated = true;
        }
        os.defaultWriteObject();
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static class HugeOidNotSupportedByOldJDK implements Serializable {
        private static final long serialVersionUID = 1;
        static HugeOidNotSupportedByOldJDK theOne = new HugeOidNotSupportedByOldJDK();

        HugeOidNotSupportedByOldJDK() {
        }
    }

    public ObjectIdentifier(String oid) throws IOException {
        int end;
        String comp;
        int length;
        this.encoding = null;
        this.components = null;
        this.componentLen = -1;
        this.componentsCalculated = false;
        int start = 0;
        int pos = 0;
        byte[] tmp = new byte[oid.length()];
        int first = 0;
        int count = 0;
        do {
            try {
                end = oid.indexOf(46, start);
                if (end == -1) {
                    comp = oid.substring(start);
                    length = oid.length() - start;
                } else {
                    comp = oid.substring(start, end);
                    length = end - start;
                }
                if (length > 9) {
                    BigInteger bignum = new BigInteger(comp);
                    if (count == 0) {
                        checkFirstComponent(bignum);
                        first = bignum.intValue();
                    } else {
                        if (count == 1) {
                            checkSecondComponent(first, bignum);
                            bignum = bignum.add(BigInteger.valueOf(first * 40));
                        } else {
                            checkOtherComponent(count, bignum);
                        }
                        pos += pack7Oid(bignum, tmp, pos);
                    }
                } else {
                    int num = Integer.parseInt(comp);
                    if (count == 0) {
                        checkFirstComponent(num);
                        first = num;
                    } else {
                        if (count == 1) {
                            checkSecondComponent(first, num);
                            num += first * 40;
                        } else {
                            checkOtherComponent(count, num);
                        }
                        pos += pack7Oid(num, tmp, pos);
                    }
                }
                start = end + 1;
                count++;
            } catch (IOException ioe) {
                throw ioe;
            } catch (Exception e2) {
                throw new IOException("ObjectIdentifier() -- Invalid format: " + e2.toString(), e2);
            }
        } while (end != -1);
        checkCount(count);
        byte[] bArr = new byte[pos];
        this.encoding = bArr;
        System.arraycopy((Object) tmp, 0, (Object) bArr, 0, pos);
        this.stringForm = oid;
    }

    public ObjectIdentifier(int[] values) throws IOException {
        this.encoding = null;
        this.components = null;
        this.componentLen = -1;
        this.componentsCalculated = false;
        checkCount(values.length);
        checkFirstComponent(values[0]);
        checkSecondComponent(values[0], values[1]);
        for (int i10 = 2; i10 < values.length; i10++) {
            checkOtherComponent(i10, values[i10]);
        }
        int i11 = values.length;
        init(values, i11);
    }

    public ObjectIdentifier(DerInputStream in) throws IOException {
        this.encoding = null;
        this.components = null;
        this.componentLen = -1;
        this.componentsCalculated = false;
        byte type_id = (byte) in.getByte();
        if (type_id != 6) {
            throw new IOException("ObjectIdentifier() -- data isn't an object ID (tag = " + ((int) type_id) + ")");
        }
        int len = in.getLength();
        if (len > in.available()) {
            throw new IOException("ObjectIdentifier() -- length exceedsdata available.  Length: " + len + ", Available: " + in.available());
        }
        byte[] bArr = new byte[len];
        this.encoding = bArr;
        in.getBytes(bArr);
        check(this.encoding);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ObjectIdentifier(DerInputBuffer buf) throws IOException {
        this.encoding = null;
        this.components = null;
        this.componentLen = -1;
        this.componentsCalculated = false;
        DerInputStream in = new DerInputStream(buf);
        byte[] bArr = new byte[in.available()];
        this.encoding = bArr;
        in.getBytes(bArr);
        check(this.encoding);
    }

    private void init(int[] components, int length) {
        int pos;
        byte[] tmp = new byte[(length * 5) + 1];
        if (components[1] < Integer.MAX_VALUE - (components[0] * 40)) {
            pos = 0 + pack7Oid((components[0] * 40) + components[1], tmp, 0);
        } else {
            BigInteger big = BigInteger.valueOf(components[1]);
            pos = 0 + pack7Oid(big.add(BigInteger.valueOf(components[0] * 40)), tmp, 0);
        }
        for (int i10 = 2; i10 < length; i10++) {
            pos += pack7Oid(components[i10], tmp, pos);
        }
        byte[] bArr = new byte[pos];
        this.encoding = bArr;
        System.arraycopy((Object) tmp, 0, (Object) bArr, 0, pos);
    }

    public static ObjectIdentifier newInternal(int[] values) {
        try {
            return new ObjectIdentifier(values);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void encode(DerOutputStream out) throws IOException {
        out.write((byte) 6, this.encoding);
    }

    @Deprecated
    public boolean equals(ObjectIdentifier other) {
        return equals((Object) other);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ObjectIdentifier)) {
            return false;
        }
        ObjectIdentifier other = (ObjectIdentifier) obj;
        return Arrays.equals(this.encoding, other.encoding);
    }

    public int hashCode() {
        return Arrays.hashCode(this.encoding);
    }

    public int[] toIntArray() {
        int which;
        int length = this.encoding.length;
        int[] result = new int[20];
        int which2 = 0;
        int fromPos = 0;
        for (int i10 = 0; i10 < length; i10++) {
            if ((this.encoding[i10] & 128) == 0) {
                if ((i10 - fromPos) + 1 > 4) {
                    BigInteger big = new BigInteger(pack(this.encoding, fromPos, (i10 - fromPos) + 1, 7, 8));
                    if (fromPos == 0) {
                        int which3 = which2 + 1;
                        result[which2] = 2;
                        BigInteger second = big.subtract(BigInteger.valueOf(80L));
                        if (second.compareTo(BigInteger.valueOf(ZipUtils.UPPER_UNIXTIME_BOUND)) == 1) {
                            return null;
                        }
                        which = which3 + 1;
                        result[which3] = second.intValue();
                    } else {
                        if (big.compareTo(BigInteger.valueOf(ZipUtils.UPPER_UNIXTIME_BOUND)) == 1) {
                            return null;
                        }
                        which = which2 + 1;
                        result[which2] = big.intValue();
                    }
                } else {
                    int retval = 0;
                    for (int j10 = fromPos; j10 <= i10; j10++) {
                        byte tmp = this.encoding[j10];
                        retval = (retval << 7) | (tmp & Byte.MAX_VALUE);
                    }
                    if (fromPos == 0) {
                        if (retval < 80) {
                            int which4 = which2 + 1;
                            result[which2] = retval / 40;
                            result[which4] = retval % 40;
                            which = which4 + 1;
                        } else {
                            int which5 = which2 + 1;
                            result[which2] = 2;
                            result[which5] = retval - 80;
                            which = which5 + 1;
                        }
                    } else {
                        which = which2 + 1;
                        result[which2] = retval;
                    }
                }
                fromPos = i10 + 1;
                which2 = which;
            }
            if (which2 >= result.length) {
                result = Arrays.copyOf(result, which2 + 10);
            }
        }
        return Arrays.copyOf(result, which2);
    }

    public String toString() {
        String s2 = this.stringForm;
        if (s2 == null) {
            int length = this.encoding.length;
            StringBuffer sb2 = new StringBuffer(length * 4);
            int fromPos = 0;
            for (int i10 = 0; i10 < length; i10++) {
                if ((this.encoding[i10] & 128) == 0) {
                    if (fromPos != 0) {
                        sb2.append('.');
                    }
                    if ((i10 - fromPos) + 1 > 4) {
                        BigInteger big = new BigInteger(pack(this.encoding, fromPos, (i10 - fromPos) + 1, 7, 8));
                        if (fromPos == 0) {
                            sb2.append("2.");
                            sb2.append(big.subtract(BigInteger.valueOf(80L)));
                        } else {
                            sb2.append((Object) big);
                        }
                    } else {
                        int retval = 0;
                        for (int j10 = fromPos; j10 <= i10; j10++) {
                            byte tmp = this.encoding[j10];
                            retval = (retval << 7) | (tmp & Byte.MAX_VALUE);
                        }
                        if (fromPos == 0) {
                            if (retval < 80) {
                                sb2.append(retval / 40);
                                sb2.append('.');
                                sb2.append(retval % 40);
                            } else {
                                sb2.append("2.");
                                sb2.append(retval - 80);
                            }
                        } else {
                            sb2.append(retval);
                        }
                    }
                    fromPos = i10 + 1;
                }
            }
            String s10 = sb2.toString();
            this.stringForm = s10;
            return s10;
        }
        return s2;
    }

    private static byte[] pack(byte[] in, int ioffset, int ilength, int iw, int ow) {
        if (iw == ow) {
            return (byte[]) in.clone();
        }
        int bits = ilength * iw;
        byte[] out = new byte[((bits + ow) - 1) / ow];
        int ipos = 0;
        int opos = ((((bits + ow) - 1) / ow) * ow) - bits;
        while (ipos < bits) {
            int count = iw - (ipos % iw);
            if (count > ow - (opos % ow)) {
                count = ow - (opos % ow);
            }
            int i10 = opos / ow;
            out[i10] = (byte) (out[i10] | ((((in[(ipos / iw) + ioffset] + 256) >> ((iw - (ipos % iw)) - count)) & ((1 << count) - 1)) << ((ow - (opos % ow)) - count)));
            ipos += count;
            opos += count;
        }
        return out;
    }

    private static int pack7Oid(byte[] in, int ioffset, int ilength, byte[] out, int ooffset) {
        byte[] pack = pack(in, ioffset, ilength, 8, 7);
        int firstNonZero = pack.length - 1;
        for (int i10 = pack.length - 2; i10 >= 0; i10--) {
            if (pack[i10] != 0) {
                firstNonZero = i10;
            }
            pack[i10] = (byte) (pack[i10] | 128);
        }
        int i11 = pack.length;
        System.arraycopy((Object) pack, firstNonZero, (Object) out, ooffset, i11 - firstNonZero);
        return pack.length - firstNonZero;
    }

    private static int pack8(byte[] in, int ioffset, int ilength, byte[] out, int ooffset) {
        byte[] pack = pack(in, ioffset, ilength, 7, 8);
        int firstNonZero = pack.length - 1;
        for (int i10 = pack.length - 2; i10 >= 0; i10--) {
            if (pack[i10] != 0) {
                firstNonZero = i10;
            }
        }
        int i11 = pack.length;
        System.arraycopy((Object) pack, firstNonZero, (Object) out, ooffset, i11 - firstNonZero);
        return pack.length - firstNonZero;
    }

    private static int pack7Oid(int input, byte[] out, int ooffset) {
        byte[] b4 = {(byte) (input >> 24), (byte) (input >> 16), (byte) (input >> 8), (byte) input};
        return pack7Oid(b4, 0, 4, out, ooffset);
    }

    private static int pack7Oid(BigInteger input, byte[] out, int ooffset) {
        byte[] b4 = input.toByteArray();
        return pack7Oid(b4, 0, b4.length, out, ooffset);
    }

    private static void check(byte[] encoding) throws IOException {
        int length = encoding.length;
        if (length < 1 || (encoding[length - 1] & 128) != 0) {
            throw new IOException("ObjectIdentifier() -- Invalid DER encoding, not ended");
        }
        for (int i10 = 0; i10 < length; i10++) {
            if (encoding[i10] == Byte.MIN_VALUE && (i10 == 0 || (encoding[i10 - 1] & 128) == 0)) {
                throw new IOException("ObjectIdentifier() -- Invalid DER encoding, useless extra octet detected");
            }
        }
    }

    private static void checkCount(int count) throws IOException {
        if (count < 2) {
            throw new IOException("ObjectIdentifier() -- Must be at least two oid components ");
        }
    }

    private static void checkFirstComponent(int first) throws IOException {
        if (first < 0 || first > 2) {
            throw new IOException("ObjectIdentifier() -- First oid component is invalid ");
        }
    }

    private static void checkFirstComponent(BigInteger first) throws IOException {
        if (first.signum() == -1 || first.compareTo(BigInteger.valueOf(2L)) == 1) {
            throw new IOException("ObjectIdentifier() -- First oid component is invalid ");
        }
    }

    private static void checkSecondComponent(int first, int second) throws IOException {
        if (second < 0 || (first != 2 && second > 39)) {
            throw new IOException("ObjectIdentifier() -- Second oid component is invalid ");
        }
    }

    private static void checkSecondComponent(int first, BigInteger second) throws IOException {
        if (second.signum() == -1 || (first != 2 && second.compareTo(BigInteger.valueOf(39L)) == 1)) {
            throw new IOException("ObjectIdentifier() -- Second oid component is invalid ");
        }
    }

    private static void checkOtherComponent(int i10, int num) throws IOException {
        if (num < 0) {
            throw new IOException("ObjectIdentifier() -- oid component #" + (i10 + 1) + " must be non-negative ");
        }
    }

    private static void checkOtherComponent(int i10, BigInteger num) throws IOException {
        if (num.signum() == -1) {
            throw new IOException("ObjectIdentifier() -- oid component #" + (i10 + 1) + " must be non-negative ");
        }
    }
}
