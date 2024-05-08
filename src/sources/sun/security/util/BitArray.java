package sun.security.util;

import java.io.ByteArrayOutputStream;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class BitArray {
    private static final int BITS_PER_UNIT = 8;
    private static final int BYTES_PER_LINE = 8;
    private static final byte[][] NYBBLE = {new byte[]{48, 48, 48, 48}, new byte[]{48, 48, 48, 49}, new byte[]{48, 48, 49, 48}, new byte[]{48, 48, 49, 49}, new byte[]{48, 49, 48, 48}, new byte[]{48, 49, 48, 49}, new byte[]{48, 49, 49, 48}, new byte[]{48, 49, 49, 49}, new byte[]{49, 48, 48, 48}, new byte[]{49, 48, 48, 49}, new byte[]{49, 48, 49, 48}, new byte[]{49, 48, 49, 49}, new byte[]{49, 49, 48, 48}, new byte[]{49, 49, 48, 49}, new byte[]{49, 49, 49, 48}, new byte[]{49, 49, 49, 49}};
    private int length;
    private byte[] repn;

    private static int subscript(int idx) {
        return idx / 8;
    }

    private static int position(int idx) {
        return 1 << (7 - (idx % 8));
    }

    public BitArray(int length) throws IllegalArgumentException {
        if (length < 0) {
            throw new IllegalArgumentException("Negative length for BitArray");
        }
        this.length = length;
        this.repn = new byte[((length + 8) - 1) / 8];
    }

    public BitArray(int length, byte[] a10) throws IllegalArgumentException {
        this(length, a10, 0);
    }

    public BitArray(int length, byte[] a10, int ofs) throws IllegalArgumentException {
        if (length < 0) {
            throw new IllegalArgumentException("Negative length for BitArray");
        }
        if ((a10.length - ofs) * 8 < length) {
            throw new IllegalArgumentException("Byte array too short to represent " + length + "-bit array");
        }
        this.length = length;
        int repLength = ((length + 8) - 1) / 8;
        int unusedBits = (repLength * 8) - length;
        byte bitMask = (byte) (255 << unusedBits);
        byte[] bArr = new byte[repLength];
        this.repn = bArr;
        System.arraycopy((Object) a10, ofs, (Object) bArr, 0, repLength);
        if (repLength > 0) {
            byte[] bArr2 = this.repn;
            int i10 = repLength - 1;
            bArr2[i10] = (byte) (bArr2[i10] & bitMask);
        }
    }

    public BitArray(boolean[] bits) {
        int length = bits.length;
        this.length = length;
        this.repn = new byte[(length + 7) / 8];
        for (int i10 = 0; i10 < this.length; i10++) {
            set(i10, bits[i10]);
        }
    }

    private BitArray(BitArray ba2) {
        this.length = ba2.length;
        this.repn = (byte[]) ba2.repn.clone();
    }

    public boolean get(int index) throws ArrayIndexOutOfBoundsException {
        if (index < 0 || index >= this.length) {
            throw new ArrayIndexOutOfBoundsException(Integer.toString(index));
        }
        return (this.repn[subscript(index)] & position(index)) != 0;
    }

    public void set(int index, boolean value) throws ArrayIndexOutOfBoundsException {
        if (index < 0 || index >= this.length) {
            throw new ArrayIndexOutOfBoundsException(Integer.toString(index));
        }
        int idx = subscript(index);
        int bit = position(index);
        if (value) {
            byte[] bArr = this.repn;
            bArr[idx] = (byte) (bArr[idx] | bit);
        } else {
            byte[] bArr2 = this.repn;
            bArr2[idx] = (byte) (bArr2[idx] & (~bit));
        }
    }

    public int length() {
        return this.length;
    }

    public byte[] toByteArray() {
        return (byte[]) this.repn.clone();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof BitArray)) {
            return false;
        }
        BitArray ba2 = (BitArray) obj;
        if (ba2.length != this.length) {
            return false;
        }
        int i10 = 0;
        while (true) {
            byte[] bArr = this.repn;
            if (i10 >= bArr.length) {
                return true;
            }
            if (bArr[i10] != ba2.repn[i10]) {
                return false;
            }
            i10++;
        }
    }

    public boolean[] toBooleanArray() {
        boolean[] bits = new boolean[this.length];
        for (int i10 = 0; i10 < this.length; i10++) {
            bits[i10] = get(i10);
        }
        return bits;
    }

    public int hashCode() {
        int hashCode = 0;
        int i10 = 0;
        while (true) {
            byte[] bArr = this.repn;
            if (i10 < bArr.length) {
                hashCode = (hashCode * 31) + bArr[i10];
                i10++;
            } else {
                int i11 = this.length;
                return i11 ^ hashCode;
            }
        }
    }

    public Object clone() {
        return new BitArray(this);
    }

    public String toString() {
        byte[] bArr;
        if (this.length == 0) {
            return "";
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int i10 = 0;
        while (true) {
            bArr = this.repn;
            if (i10 >= bArr.length - 1) {
                break;
            }
            byte[][] bArr2 = NYBBLE;
            out.write(bArr2[(bArr[i10] >> 4) & 15], 0, 4);
            out.write(bArr2[this.repn[i10] & 15], 0, 4);
            if (i10 % 8 == 7) {
                out.write(10);
            } else {
                out.write(32);
            }
            i10++;
        }
        int i11 = bArr.length;
        for (int i12 = (i11 - 1) * 8; i12 < this.length; i12++) {
            out.write(get(i12) ? 49 : 48);
        }
        return new String(out.toByteArray());
    }

    public BitArray truncate() {
        for (int i10 = this.length - 1; i10 >= 0; i10--) {
            if (get(i10)) {
                return new BitArray(i10 + 1, this.repn, 0);
            }
        }
        return new BitArray(1);
    }
}
