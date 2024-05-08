package java.math;

import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class MutableBigInteger {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final int KNUTH_POW2_THRESH_LEN = 6;
    static final int KNUTH_POW2_THRESH_ZEROS = 3;
    static final MutableBigInteger ONE = new MutableBigInteger(1);
    int intLen;
    int offset;
    int[] value;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MutableBigInteger() {
        this.offset = 0;
        this.value = new int[1];
        this.intLen = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MutableBigInteger(int val) {
        this.offset = 0;
        this.value = r2;
        this.intLen = 1;
        int[] iArr = {val};
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MutableBigInteger(int[] val) {
        this.offset = 0;
        this.value = val;
        this.intLen = val.length;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MutableBigInteger(BigInteger b4) {
        this.offset = 0;
        this.intLen = b4.mag.length;
        this.value = Arrays.copyOf(b4.mag, this.intLen);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MutableBigInteger(MutableBigInteger val) {
        this.offset = 0;
        int i10 = val.intLen;
        this.intLen = i10;
        int[] iArr = val.value;
        int i11 = val.offset;
        this.value = Arrays.copyOfRange(iArr, i11, i10 + i11);
    }

    private void ones(int n10) {
        if (n10 > this.value.length) {
            this.value = new int[n10];
        }
        Arrays.fill(this.value, -1);
        this.offset = 0;
        this.intLen = n10;
    }

    private int[] getMagnitudeArray() {
        int i10 = this.offset;
        if (i10 > 0 || this.value.length != this.intLen) {
            int[] tmp = Arrays.copyOfRange(this.value, i10, this.intLen + i10);
            Arrays.fill(this.value, 0);
            this.offset = 0;
            this.intLen = tmp.length;
            this.value = tmp;
        }
        return this.value;
    }

    private long toLong() {
        int i10 = this.intLen;
        if (i10 == 0) {
            return 0L;
        }
        int[] iArr = this.value;
        int i11 = this.offset;
        long d10 = iArr[i11] & 4294967295L;
        if (i10 != 2) {
            return d10;
        }
        return (iArr[i11 + 1] & 4294967295L) | (d10 << 32);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BigInteger toBigInteger(int sign) {
        if (this.intLen == 0 || sign == 0) {
            return BigInteger.ZERO;
        }
        return new BigInteger(getMagnitudeArray(), sign);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BigInteger toBigInteger() {
        normalize();
        return toBigInteger(!isZero() ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BigDecimal toBigDecimal(int sign, int scale) {
        if (this.intLen == 0 || sign == 0) {
            return BigDecimal.zeroValueOf(scale);
        }
        int[] mag = getMagnitudeArray();
        int len = mag.length;
        int d10 = mag[0];
        if (len > 2 || (d10 < 0 && len == 2)) {
            return new BigDecimal(new BigInteger(mag, sign), Long.MIN_VALUE, scale, 0);
        }
        long v2 = len == 2 ? ((d10 & 4294967295L) << 32) | (mag[1] & 4294967295L) : d10 & 4294967295L;
        return BigDecimal.valueOf(sign == -1 ? -v2 : v2, scale);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long toCompactValue(int sign) {
        if (this.intLen == 0 || sign == 0) {
            return 0L;
        }
        int[] mag = getMagnitudeArray();
        int len = mag.length;
        int d10 = mag[0];
        if (len <= 2) {
            if (d10 < 0 && len == 2) {
                return Long.MIN_VALUE;
            }
            long v2 = len == 2 ? ((d10 & 4294967295L) << 32) | (mag[1] & 4294967295L) : d10 & 4294967295L;
            return sign == -1 ? -v2 : v2;
        }
        return Long.MIN_VALUE;
    }

    void clear() {
        this.intLen = 0;
        this.offset = 0;
        int n10 = this.value.length;
        for (int index = 0; index < n10; index++) {
            this.value[index] = 0;
        }
    }

    void reset() {
        this.intLen = 0;
        this.offset = 0;
    }

    final int compare(MutableBigInteger b4) {
        int blen = b4.intLen;
        int i10 = this.intLen;
        if (i10 < blen) {
            return -1;
        }
        if (i10 > blen) {
            return 1;
        }
        int[] bval = b4.value;
        int i11 = this.offset;
        int j10 = b4.offset;
        while (i11 < this.intLen + this.offset) {
            int b12 = this.value[i11] - 2147483648;
            int b22 = bval[j10] - 2147483648;
            if (b12 < b22) {
                return -1;
            }
            if (b12 > b22) {
                return 1;
            }
            i11++;
            j10++;
        }
        return 0;
    }

    private int compareShifted(MutableBigInteger b4, int ints) {
        int blen = b4.intLen;
        int alen = this.intLen - ints;
        if (alen < blen) {
            return -1;
        }
        if (alen > blen) {
            return 1;
        }
        int[] bval = b4.value;
        int i10 = this.offset;
        int j10 = b4.offset;
        while (i10 < this.offset + alen) {
            int b12 = this.value[i10] - 2147483648;
            int b22 = bval[j10] - 2147483648;
            if (b12 < b22) {
                return -1;
            }
            if (b12 > b22) {
                return 1;
            }
            i10++;
            j10++;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int compareHalf(MutableBigInteger b4) {
        int blen = b4.intLen;
        int len = this.intLen;
        if (len <= 0) {
            return blen <= 0 ? 0 : -1;
        }
        if (len > blen) {
            return 1;
        }
        if (len < blen - 1) {
            return -1;
        }
        int[] bval = b4.value;
        int bstart = 0;
        int carry = 0;
        if (len != blen) {
            if (bval[0] != 1) {
                return -1;
            }
            bstart = 0 + 1;
            carry = Integer.MIN_VALUE;
        }
        int[] val = this.value;
        int i10 = this.offset;
        int bv = bstart;
        while (i10 < this.offset + len) {
            int j10 = bv + 1;
            int bv2 = bval[bv];
            long hb2 = ((bv2 >>> 1) + carry) & 4294967295L;
            int i11 = i10 + 1;
            long v2 = val[i10] & 4294967295L;
            if (v2 != hb2) {
                return v2 < hb2 ? -1 : 1;
            }
            carry = (bv2 & 1) << 31;
            bv = j10;
            i10 = i11;
        }
        return carry == 0 ? 0 : -1;
    }

    private final int getLowestSetBit() {
        int i10 = this.intLen;
        if (i10 == 0) {
            return -1;
        }
        int j10 = i10 - 1;
        while (j10 > 0 && this.value[this.offset + j10] == 0) {
            j10--;
        }
        int b4 = this.value[this.offset + j10];
        if (b4 == 0) {
            return -1;
        }
        return (((this.intLen - 1) - j10) << 5) + Integer.numberOfTrailingZeros(b4);
    }

    private final int getInt(int index) {
        return this.value[this.offset + index];
    }

    private final long getLong(int index) {
        return this.value[this.offset + index] & 4294967295L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void normalize() {
        int i10 = this.intLen;
        if (i10 == 0) {
            this.offset = 0;
            return;
        }
        int index = this.offset;
        if (this.value[index] != 0) {
            return;
        }
        int indexBound = i10 + index;
        do {
            index++;
            if (index >= indexBound) {
                break;
            }
        } while (this.value[index] == 0);
        int i11 = this.offset;
        int numZeros = index - i11;
        int i12 = this.intLen - numZeros;
        this.intLen = i12;
        this.offset = i12 != 0 ? i11 + numZeros : 0;
    }

    private final void ensureCapacity(int len) {
        if (this.value.length < len) {
            this.value = new int[len];
            this.offset = 0;
            this.intLen = len;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] toIntArray() {
        int[] result = new int[this.intLen];
        for (int i10 = 0; i10 < this.intLen; i10++) {
            result[i10] = this.value[this.offset + i10];
        }
        return result;
    }

    void setInt(int index, int val) {
        this.value[this.offset + index] = val;
    }

    void setValue(int[] val, int length) {
        this.value = val;
        this.intLen = length;
        this.offset = 0;
    }

    void copyValue(MutableBigInteger src) {
        int len = src.intLen;
        if (this.value.length < len) {
            this.value = new int[len];
        }
        System.arraycopy((Object) src.value, src.offset, (Object) this.value, 0, len);
        this.intLen = len;
        this.offset = 0;
    }

    void copyValue(int[] val) {
        int len = val.length;
        if (this.value.length < len) {
            this.value = new int[len];
        }
        System.arraycopy((Object) val, 0, (Object) this.value, 0, len);
        this.intLen = len;
        this.offset = 0;
    }

    boolean isOne() {
        return this.intLen == 1 && this.value[this.offset] == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isZero() {
        return this.intLen == 0;
    }

    boolean isEven() {
        int i10 = this.intLen;
        return i10 == 0 || (this.value[(this.offset + i10) - 1] & 1) == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isOdd() {
        return !isZero() && (this.value[(this.offset + this.intLen) - 1] & 1) == 1;
    }

    boolean isNormal() {
        int i10 = this.intLen;
        int i11 = this.offset;
        int i12 = i10 + i11;
        int[] iArr = this.value;
        if (i12 > iArr.length) {
            return false;
        }
        return i10 == 0 || iArr[i11] != 0;
    }

    public String toString() {
        BigInteger b4 = toBigInteger(1);
        return b4.toString();
    }

    void safeRightShift(int n10) {
        if (n10 / 32 >= this.intLen) {
            reset();
        } else {
            rightShift(n10);
        }
    }

    void rightShift(int n10) {
        int i10 = this.intLen;
        if (i10 == 0) {
            return;
        }
        int nInts = n10 >>> 5;
        int nBits = n10 & 31;
        this.intLen = i10 - nInts;
        if (nBits == 0) {
            return;
        }
        int bitsInHighWord = BigInteger.bitLengthForInt(this.value[this.offset]);
        if (nBits >= bitsInHighWord) {
            primitiveLeftShift(32 - nBits);
            this.intLen--;
        } else {
            primitiveRightShift(nBits);
        }
    }

    void safeLeftShift(int n10) {
        if (n10 > 0) {
            leftShift(n10);
        }
    }

    void leftShift(int n10) {
        if (this.intLen == 0) {
            return;
        }
        int nInts = n10 >>> 5;
        int nBits = n10 & 31;
        int bitsInHighWord = BigInteger.bitLengthForInt(this.value[this.offset]);
        if (n10 <= 32 - bitsInHighWord) {
            primitiveLeftShift(nBits);
            return;
        }
        int newLen = this.intLen + nInts + 1;
        if (nBits <= 32 - bitsInHighWord) {
            newLen--;
        }
        int[] iArr = this.value;
        if (iArr.length < newLen) {
            int[] result = new int[newLen];
            for (int i10 = 0; i10 < this.intLen; i10++) {
                result[i10] = this.value[this.offset + i10];
            }
            setValue(result, newLen);
        } else if (iArr.length - this.offset >= newLen) {
            int i11 = 0;
            while (true) {
                int i12 = this.intLen;
                if (i11 >= newLen - i12) {
                    break;
                }
                this.value[this.offset + i12 + i11] = 0;
                i11++;
            }
        } else {
            for (int i13 = 0; i13 < this.intLen; i13++) {
                int[] iArr2 = this.value;
                iArr2[i13] = iArr2[this.offset + i13];
            }
            for (int i14 = this.intLen; i14 < newLen; i14++) {
                this.value[i14] = 0;
            }
            this.offset = 0;
        }
        this.intLen = newLen;
        if (nBits == 0) {
            return;
        }
        if (nBits <= 32 - bitsInHighWord) {
            primitiveLeftShift(nBits);
        } else {
            primitiveRightShift(32 - nBits);
        }
    }

    private int divadd(int[] a10, int[] result, int offset) {
        long carry = 0;
        for (int j10 = a10.length - 1; j10 >= 0; j10--) {
            long sum = (a10[j10] & 4294967295L) + (4294967295L & result[j10 + offset]) + carry;
            result[j10 + offset] = (int) sum;
            carry = sum >>> 32;
        }
        int j11 = (int) carry;
        return j11;
    }

    private int mulsub(int[] q10, int[] a10, int x10, int len, int offset) {
        long xLong = x10 & 4294967295L;
        long carry = 0;
        int offset2 = offset + len;
        int j10 = len - 1;
        while (j10 >= 0) {
            long product = ((a10[j10] & 4294967295L) * xLong) + carry;
            long difference = q10[offset2] - product;
            int offset3 = offset2 - 1;
            q10[offset2] = (int) difference;
            carry = (product >>> 32) + ((difference & 4294967295L) > (((long) (~((int) product))) & 4294967295L) ? 1 : 0);
            j10--;
            offset2 = offset3;
            xLong = xLong;
        }
        return (int) carry;
    }

    private int mulsubBorrow(int[] q10, int[] a10, int x10, int len, int offset) {
        long xLong = x10 & 4294967295L;
        long carry = 0;
        int offset2 = offset + len;
        int j10 = len - 1;
        while (j10 >= 0) {
            long product = ((a10[j10] & 4294967295L) * xLong) + carry;
            long difference = q10[offset2] - product;
            carry = (product >>> 32) + ((difference & 4294967295L) > (((long) (~((int) product))) & 4294967295L) ? 1 : 0);
            j10--;
            offset2--;
            xLong = xLong;
        }
        return (int) carry;
    }

    private final void primitiveRightShift(int n10) {
        int[] val = this.value;
        int n22 = 32 - n10;
        int i10 = (this.offset + this.intLen) - 1;
        int c4 = val[i10];
        while (true) {
            int i11 = this.offset;
            if (i10 > i11) {
                int b4 = c4;
                c4 = val[i10 - 1];
                val[i10] = (c4 << n22) | (b4 >>> n10);
                i10--;
            } else {
                val[i11] = val[i11] >>> n10;
                return;
            }
        }
    }

    private final void primitiveLeftShift(int n10) {
        int[] val = this.value;
        int n22 = 32 - n10;
        int i10 = this.offset;
        int c4 = val[i10];
        int m10 = (this.intLen + i10) - 1;
        while (i10 < m10) {
            int b4 = c4;
            c4 = val[i10 + 1];
            val[i10] = (b4 << n10) | (c4 >>> n22);
            i10++;
        }
        int i11 = (this.offset + this.intLen) - 1;
        val[i11] = val[i11] << n10;
    }

    private BigInteger getLower(int n10) {
        if (isZero()) {
            return BigInteger.ZERO;
        }
        if (this.intLen < n10) {
            return toBigInteger(1);
        }
        int len = n10;
        while (len > 0 && this.value[(this.offset + this.intLen) - len] == 0) {
            len--;
        }
        int sign = len <= 0 ? 0 : 1;
        int[] iArr = this.value;
        int i10 = this.offset;
        int i11 = this.intLen;
        return new BigInteger(Arrays.copyOfRange(iArr, (i10 + i11) - len, i10 + i11), sign);
    }

    private void keepLower(int n10) {
        int i10 = this.intLen;
        if (i10 >= n10) {
            this.offset += i10 - n10;
            this.intLen = n10;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void add(MutableBigInteger addend) {
        int rstart = this.intLen;
        int y10 = addend.intLen;
        int resultLen = this.intLen;
        int i10 = addend.intLen;
        if (resultLen <= i10) {
            resultLen = i10;
        }
        int[] result = this.value;
        if (result.length < resultLen) {
            result = new int[resultLen];
        }
        int rstart2 = result.length - 1;
        long carry = 0;
        while (rstart > 0 && y10 > 0) {
            int x10 = rstart - 1;
            long sum = (this.value[this.offset + x10] & 4294967295L) + (addend.value[addend.offset + r3] & 4294967295L) + carry;
            result[rstart2] = (int) sum;
            carry = sum >>> 32;
            rstart2--;
            rstart = x10;
            y10--;
        }
        while (rstart > 0) {
            rstart--;
            if (carry != 0 || result != this.value || rstart2 != this.offset + rstart) {
                long sum2 = (this.value[this.offset + rstart] & 4294967295L) + carry;
                result[rstart2] = (int) sum2;
                carry = sum2 >>> 32;
                rstart2--;
            } else {
                return;
            }
        }
        while (y10 > 0) {
            y10--;
            long sum3 = (addend.value[addend.offset + y10] & 4294967295L) + carry;
            result[rstart2] = (int) sum3;
            carry = sum3 >>> 32;
            rstart2--;
        }
        if (carry > 0) {
            resultLen++;
            if (result.length < resultLen) {
                int[] temp = new int[resultLen];
                System.arraycopy((Object) result, 0, (Object) temp, 1, result.length);
                temp[0] = 1;
                result = temp;
            } else {
                int i11 = rstart2 - 1;
                result[rstart2] = 1;
            }
        }
        this.value = result;
        this.intLen = resultLen;
        this.offset = result.length - resultLen;
    }

    void addShifted(MutableBigInteger addend, int n10) {
        if (addend.isZero()) {
            return;
        }
        int x10 = this.intLen;
        int y10 = addend.intLen + n10;
        int resultLen = this.intLen;
        if (resultLen <= y10) {
            resultLen = y10;
        }
        int[] result = this.value;
        if (result.length < resultLen) {
            result = new int[resultLen];
        }
        int rstart = result.length - 1;
        long carry = 0;
        while (x10 > 0 && y10 > 0) {
            x10--;
            y10--;
            int i10 = addend.offset;
            int i11 = y10 + i10;
            int[] iArr = addend.value;
            int bval = i11 < iArr.length ? iArr[i10 + y10] : 0;
            long sum = (this.value[this.offset + x10] & 4294967295L) + (bval & 4294967295L) + carry;
            result[rstart] = (int) sum;
            carry = sum >>> 32;
            rstart--;
        }
        while (x10 > 0) {
            x10--;
            if (carry != 0 || result != this.value || rstart != this.offset + x10) {
                long sum2 = (this.value[this.offset + x10] & 4294967295L) + carry;
                result[rstart] = (int) sum2;
                carry = sum2 >>> 32;
                rstart--;
            } else {
                return;
            }
        }
        while (y10 > 0) {
            y10--;
            int i12 = addend.offset;
            int i13 = y10 + i12;
            int[] iArr2 = addend.value;
            int bval2 = i13 < iArr2.length ? iArr2[i12 + y10] : 0;
            long sum3 = (bval2 & 4294967295L) + carry;
            result[rstart] = (int) sum3;
            carry = sum3 >>> 32;
            rstart--;
        }
        if (carry > 0) {
            resultLen++;
            if (result.length < resultLen) {
                int[] temp = new int[resultLen];
                System.arraycopy((Object) result, 0, (Object) temp, 1, result.length);
                temp[0] = 1;
                result = temp;
            } else {
                int i14 = rstart - 1;
                result[rstart] = 1;
            }
        }
        this.value = result;
        this.intLen = resultLen;
        this.offset = result.length - resultLen;
    }

    void addDisjoint(MutableBigInteger addend, int n10) {
        int[] result;
        if (addend.isZero()) {
            return;
        }
        int x10 = this.intLen;
        int y10 = addend.intLen + n10;
        int i10 = this.intLen;
        int resultLen = i10 > y10 ? i10 : y10;
        int[] iArr = this.value;
        if (iArr.length < resultLen) {
            result = new int[resultLen];
        } else {
            int[] result2 = this.value;
            Arrays.fill(iArr, this.offset + i10, iArr.length, 0);
            result = result2;
        }
        int rstart = result.length - 1;
        System.arraycopy((Object) this.value, this.offset, (Object) result, (rstart + 1) - x10, x10);
        int y11 = y10 - x10;
        int rstart2 = rstart - x10;
        int len = Math.min(y11, addend.value.length - addend.offset);
        System.arraycopy((Object) addend.value, addend.offset, (Object) result, (rstart2 + 1) - y11, len);
        for (int i11 = ((rstart2 + 1) - y11) + len; i11 < rstart2 + 1; i11++) {
            result[i11] = 0;
        }
        this.value = result;
        this.intLen = resultLen;
        this.offset = result.length - resultLen;
    }

    void addLower(MutableBigInteger addend, int n10) {
        MutableBigInteger a10 = new MutableBigInteger(addend);
        int i10 = a10.offset;
        int i11 = a10.intLen;
        if (i10 + i11 >= n10) {
            a10.offset = (i10 + i11) - n10;
            a10.intLen = n10;
        }
        a10.normalize();
        add(a10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int subtract(MutableBigInteger b4) {
        MutableBigInteger a10 = this;
        int[] result = this.value;
        MutableBigInteger b10 = b4;
        int sign = a10.compare(b10);
        if (sign == 0) {
            reset();
            return 0;
        }
        if (sign < 0) {
            a10 = b4;
            b10 = a10;
        }
        int resultLen = a10.intLen;
        if (result.length < resultLen) {
            result = new int[resultLen];
        }
        long diff = 0;
        int x10 = a10.intLen;
        int y10 = b10.intLen;
        int rstart = result.length - 1;
        while (y10 > 0) {
            x10--;
            y10--;
            diff = ((a10.value[a10.offset + x10] & 4294967295L) - (b10.value[b10.offset + y10] & 4294967295L)) - ((int) (-(diff >> 32)));
            result[rstart] = (int) diff;
            rstart--;
        }
        while (x10 > 0) {
            x10--;
            diff = (a10.value[a10.offset + x10] & 4294967295L) - ((int) (-(diff >> 32)));
            result[rstart] = (int) diff;
            rstart--;
        }
        this.value = result;
        this.intLen = resultLen;
        this.offset = result.length - resultLen;
        normalize();
        return sign;
    }

    private int difference(MutableBigInteger b4) {
        MutableBigInteger a10 = this;
        MutableBigInteger b10 = b4;
        int sign = a10.compare(b10);
        if (sign == 0) {
            return 0;
        }
        if (sign < 0) {
            a10 = b4;
            b10 = a10;
        }
        long diff = 0;
        int x10 = a10.intLen;
        int y10 = b10.intLen;
        while (y10 > 0) {
            x10--;
            y10--;
            diff = ((r10[r11 + x10] & 4294967295L) - (4294967295L & b10.value[b10.offset + y10])) - ((int) (-(diff >> 32)));
            a10.value[a10.offset + x10] = (int) diff;
        }
        while (x10 > 0) {
            x10--;
            diff = (r10[r11 + x10] & 4294967295L) - ((int) (-(diff >> 32)));
            a10.value[a10.offset + x10] = (int) diff;
        }
        a10.normalize();
        return sign;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void multiply(MutableBigInteger y10, MutableBigInteger z10) {
        long j10;
        MutableBigInteger mutableBigInteger = this;
        MutableBigInteger mutableBigInteger2 = y10;
        int xLen = mutableBigInteger.intLen;
        int yLen = mutableBigInteger2.intLen;
        int newLen = xLen + yLen;
        if (z10.value.length < newLen) {
            z10.value = new int[newLen];
        }
        z10.offset = 0;
        z10.intLen = newLen;
        long carry = 0;
        int j11 = yLen - 1;
        int k10 = (yLen + xLen) - 1;
        while (true) {
            j10 = 4294967295L;
            if (j11 < 0) {
                break;
            }
            long product = ((mutableBigInteger2.value[mutableBigInteger2.offset + j11] & 4294967295L) * (mutableBigInteger.value[(xLen - 1) + mutableBigInteger.offset] & 4294967295L)) + carry;
            z10.value[k10] = (int) product;
            carry = product >>> 32;
            j11--;
            k10--;
            mutableBigInteger = this;
            mutableBigInteger2 = y10;
        }
        z10.value[xLen - 1] = (int) carry;
        int i10 = xLen - 2;
        while (i10 >= 0) {
            long carry2 = 0;
            int j12 = yLen - 1;
            int k11 = yLen + i10;
            while (j12 >= 0) {
                long j13 = (y10.value[y10.offset + j12] & j10) * (this.value[this.offset + i10] & 4294967295L);
                long product2 = j13 + (r11[k11] & 4294967295L) + carry2;
                z10.value[k11] = (int) product2;
                carry2 = product2 >>> 32;
                j12--;
                k11--;
                j10 = 4294967295L;
                xLen = xLen;
                yLen = yLen;
            }
            z10.value[i10] = (int) carry2;
            i10--;
            xLen = xLen;
            yLen = yLen;
        }
        z10.normalize();
    }

    void mul(int y10, MutableBigInteger z10) {
        if (y10 == 1) {
            z10.copyValue(this);
            return;
        }
        if (y10 == 0) {
            z10.clear();
            return;
        }
        long ylong = y10 & 4294967295L;
        int[] zval = z10.value;
        int length = zval.length;
        int i10 = this.intLen;
        if (length < i10 + 1) {
            zval = new int[i10 + 1];
        }
        long carry = 0;
        for (int i11 = i10 - 1; i11 >= 0; i11--) {
            long product = ((this.value[this.offset + i11] & 4294967295L) * ylong) + carry;
            zval[i11 + 1] = (int) product;
            carry = product >>> 32;
        }
        if (carry == 0) {
            z10.offset = 1;
            z10.intLen = this.intLen;
        } else {
            z10.offset = 0;
            z10.intLen = this.intLen + 1;
            zval[0] = (int) carry;
        }
        z10.value = zval;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int divideOneWord(int divisor, MutableBigInteger quotient) {
        long divisorLong;
        int q10;
        long divisorLong2 = divisor & 4294967295L;
        int i10 = this.intLen;
        if (i10 == 1) {
            long dividendValue = 4294967295L & this.value[this.offset];
            int q11 = (int) (dividendValue / divisorLong2);
            int r10 = (int) (dividendValue - (q11 * divisorLong2));
            quotient.value[0] = q11;
            quotient.intLen = q11 == 0 ? 0 : 1;
            quotient.offset = 0;
            return r10;
        }
        if (quotient.value.length < i10) {
            quotient.value = new int[i10];
        }
        quotient.offset = 0;
        quotient.intLen = i10;
        int shift = Integer.numberOfLeadingZeros(divisor);
        int rem = this.value[this.offset];
        long remLong = rem & 4294967295L;
        if (remLong < divisorLong2) {
            quotient.value[0] = 0;
        } else {
            int i11 = (int) (remLong / divisorLong2);
            quotient.value[0] = i11;
            rem = (int) (remLong - (i11 * divisorLong2));
            remLong = rem & 4294967295L;
        }
        int xlen = this.intLen;
        while (true) {
            xlen--;
            if (xlen <= 0) {
                break;
            }
            long dividendEstimate = (this.value[(this.offset + this.intLen) - xlen] & 4294967295L) | (remLong << 32);
            if (dividendEstimate >= 0) {
                q10 = (int) (dividendEstimate / divisorLong2);
                rem = (int) (dividendEstimate - (q10 * divisorLong2));
                divisorLong = divisorLong2;
            } else {
                long tmp = divWord(dividendEstimate, divisor);
                divisorLong = divisorLong2;
                int q12 = (int) (tmp & 4294967295L);
                int i12 = (int) (tmp >>> 32);
                q10 = q12;
                rem = i12;
            }
            quotient.value[this.intLen - xlen] = q10;
            remLong = rem & 4294967295L;
            divisorLong2 = divisorLong;
        }
        quotient.normalize();
        if (shift > 0) {
            return rem % divisor;
        }
        return rem;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MutableBigInteger divide(MutableBigInteger b4, MutableBigInteger quotient) {
        return divide(b4, quotient, true);
    }

    MutableBigInteger divide(MutableBigInteger b4, MutableBigInteger quotient, boolean needRemainder) {
        int i10 = b4.intLen;
        if (i10 < 80 || this.intLen - i10 < 40) {
            return divideKnuth(b4, quotient, needRemainder);
        }
        return divideAndRemainderBurnikelZiegler(b4, quotient);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MutableBigInteger divideKnuth(MutableBigInteger b4, MutableBigInteger quotient) {
        return divideKnuth(b4, quotient, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MutableBigInteger divideKnuth(MutableBigInteger b4, MutableBigInteger quotient, boolean needRemainder) {
        int trailingZeroBits;
        if (b4.intLen == 0) {
            throw new ArithmeticException("BigInteger divide by zero");
        }
        if (this.intLen == 0) {
            quotient.offset = 0;
            quotient.intLen = 0;
            if (needRemainder) {
                return new MutableBigInteger();
            }
            return null;
        }
        int cmp = compare(b4);
        if (cmp < 0) {
            quotient.offset = 0;
            quotient.intLen = 0;
            if (needRemainder) {
                return new MutableBigInteger(this);
            }
            return null;
        }
        if (cmp == 0) {
            int[] iArr = quotient.value;
            quotient.intLen = 1;
            iArr[0] = 1;
            quotient.offset = 0;
            if (needRemainder) {
                return new MutableBigInteger();
            }
            return null;
        }
        quotient.clear();
        if (b4.intLen == 1) {
            int r10 = divideOneWord(b4.value[b4.offset], quotient);
            if (!needRemainder) {
                return null;
            }
            if (r10 == 0) {
                return new MutableBigInteger();
            }
            return new MutableBigInteger(r10);
        }
        if (this.intLen >= 6 && (trailingZeroBits = Math.min(getLowestSetBit(), b4.getLowestSetBit())) >= 96) {
            MutableBigInteger a10 = new MutableBigInteger(this);
            MutableBigInteger b10 = new MutableBigInteger(b4);
            a10.rightShift(trailingZeroBits);
            b10.rightShift(trailingZeroBits);
            MutableBigInteger r11 = a10.divideKnuth(b10, quotient);
            r11.leftShift(trailingZeroBits);
            return r11;
        }
        return divideMagnitude(b4, quotient, needRemainder);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MutableBigInteger divideAndRemainderBurnikelZiegler(MutableBigInteger b4, MutableBigInteger quotient) {
        int r10 = this.intLen;
        int s2 = b4.intLen;
        quotient.intLen = 0;
        quotient.offset = 0;
        if (r10 < s2) {
            return this;
        }
        int m10 = 1 << (32 - Integer.numberOfLeadingZeros(s2 / 80));
        int j10 = ((s2 + m10) - 1) / m10;
        int n10 = j10 * m10;
        long n32 = n10 * 32;
        int sigma = (int) Math.max(0L, n32 - b4.bitLength());
        MutableBigInteger bShifted = new MutableBigInteger(b4);
        bShifted.safeLeftShift(sigma);
        MutableBigInteger aShifted = new MutableBigInteger(this);
        aShifted.safeLeftShift(sigma);
        int t2 = (int) ((aShifted.bitLength() + n32) / n32);
        if (t2 < 2) {
            t2 = 2;
        }
        MutableBigInteger a12 = aShifted.getBlock(t2 - 1, t2, n10);
        MutableBigInteger z10 = aShifted.getBlock(t2 - 2, t2, n10);
        z10.addDisjoint(a12, n10);
        MutableBigInteger qi = new MutableBigInteger();
        int i10 = t2 - 2;
        while (i10 > 0) {
            MutableBigInteger qi2 = qi;
            MutableBigInteger ri = z10.divide2n1n(bShifted, qi2);
            z10 = aShifted.getBlock(i10 - 1, t2, n10);
            z10.addDisjoint(ri, n10);
            quotient.addShifted(qi2, i10 * n10);
            i10--;
            r10 = r10;
            qi = qi2;
        }
        MutableBigInteger qi3 = qi;
        MutableBigInteger ri2 = z10.divide2n1n(bShifted, qi3);
        quotient.add(qi3);
        ri2.rightShift(sigma);
        return ri2;
    }

    private MutableBigInteger divide2n1n(MutableBigInteger b4, MutableBigInteger quotient) {
        int n10 = b4.intLen;
        if (n10 % 2 != 0 || n10 < 80) {
            return divideKnuth(b4, quotient);
        }
        MutableBigInteger aUpper = new MutableBigInteger(this);
        aUpper.safeRightShift((n10 / 2) * 32);
        keepLower(n10 / 2);
        MutableBigInteger q12 = new MutableBigInteger();
        MutableBigInteger r12 = aUpper.divide3n2n(b4, q12);
        addDisjoint(r12, n10 / 2);
        MutableBigInteger r22 = divide3n2n(b4, quotient);
        quotient.addDisjoint(q12, n10 / 2);
        return r22;
    }

    private MutableBigInteger divide3n2n(MutableBigInteger b4, MutableBigInteger quotient) {
        MutableBigInteger r10;
        MutableBigInteger d10;
        int n10 = b4.intLen / 2;
        MutableBigInteger a12 = new MutableBigInteger(this);
        a12.safeRightShift(n10 * 32);
        MutableBigInteger b12 = new MutableBigInteger(b4);
        b12.safeRightShift(n10 * 32);
        BigInteger b22 = b4.getLower(n10);
        if (compareShifted(b4, n10) < 0) {
            r10 = a12.divide2n1n(b12, quotient);
            d10 = new MutableBigInteger(quotient.toBigInteger().multiply(b22));
        } else {
            quotient.ones(n10);
            a12.add(b12);
            b12.leftShift(n10 * 32);
            a12.subtract(b12);
            r10 = a12;
            d10 = new MutableBigInteger(b22);
            d10.leftShift(n10 * 32);
            d10.subtract(new MutableBigInteger(b22));
        }
        r10.leftShift(n10 * 32);
        r10.addLower(this, n10);
        while (r10.compare(d10) < 0) {
            r10.add(b4);
            quotient.subtract(ONE);
        }
        r10.subtract(d10);
        return r10;
    }

    private MutableBigInteger getBlock(int index, int numBlocks, int blockLength) {
        int blockEnd;
        int blockStart = index * blockLength;
        int i10 = this.intLen;
        if (blockStart >= i10) {
            return new MutableBigInteger();
        }
        if (index == numBlocks - 1) {
            blockEnd = this.intLen;
        } else {
            int blockEnd2 = index + 1;
            blockEnd = blockEnd2 * blockLength;
        }
        if (blockEnd > i10) {
            return new MutableBigInteger();
        }
        int[] iArr = this.value;
        int i11 = this.offset;
        int[] newVal = Arrays.copyOfRange(iArr, (i11 + i10) - blockEnd, (i11 + i10) - blockStart);
        return new MutableBigInteger(newVal);
    }

    long bitLength() {
        int i10 = this.intLen;
        if (i10 == 0) {
            return 0L;
        }
        return (i10 * 32) - Integer.numberOfLeadingZeros(this.value[this.offset]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long divide(long v2, MutableBigInteger quotient) {
        if (v2 == 0) {
            throw new ArithmeticException("BigInteger divide by zero");
        }
        if (this.intLen == 0) {
            quotient.offset = 0;
            quotient.intLen = 0;
            return 0L;
        }
        if (v2 < 0) {
            v2 = -v2;
        }
        int d10 = (int) (v2 >>> 32);
        quotient.clear();
        if (d10 == 0) {
            return divideOneWord((int) v2, quotient) & 4294967295L;
        }
        return divideLongMagnitude(v2, quotient).toLong();
    }

    private static void copyAndShift(int[] src, int srcFrom, int srcLen, int[] dst, int dstFrom, int shift) {
        int n22 = 32 - shift;
        int c4 = src[srcFrom];
        for (int i10 = 0; i10 < srcLen - 1; i10++) {
            int b4 = c4;
            srcFrom++;
            c4 = src[srcFrom];
            dst[dstFrom + i10] = (b4 << shift) | (c4 >>> n22);
        }
        int i11 = dstFrom + srcLen;
        dst[i11 - 1] = c4 << shift;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x02c3  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x02e6  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x02d2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.math.MutableBigInteger divideMagnitude(java.math.MutableBigInteger r37, java.math.MutableBigInteger r38, boolean r39) {
        /*
            Method dump skipped, instructions count: 798
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: java.math.MutableBigInteger.divideMagnitude(java.math.MutableBigInteger, java.math.MutableBigInteger, boolean):java.math.MutableBigInteger");
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x014a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.math.MutableBigInteger divideLongMagnitude(long r30, java.math.MutableBigInteger r32) {
        /*
            Method dump skipped, instructions count: 390
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: java.math.MutableBigInteger.divideLongMagnitude(long, java.math.MutableBigInteger):java.math.MutableBigInteger");
    }

    private int divaddLong(int dh, int dl, int[] result, int offset) {
        result[offset + 1] = (int) ((dl & 4294967295L) + (result[offset + 1] & 4294967295L));
        long sum = (dh & 4294967295L) + (4294967295L & result[offset]) + 0;
        result[offset] = (int) sum;
        long carry = sum >>> 32;
        return (int) carry;
    }

    private int mulsubLong(int[] q10, int dh, int dl, int x10, int offset) {
        long xLong = x10 & 4294967295L;
        int offset2 = offset + 2;
        long product = (dl & 4294967295L) * xLong;
        long difference = q10[offset2] - product;
        int offset3 = offset2 - 1;
        q10[offset2] = (int) difference;
        long carry = (product >>> 32) + ((difference & 4294967295L) > (((long) (~((int) product))) & 4294967295L) ? 1 : 0);
        long product2 = ((dh & 4294967295L) * xLong) + carry;
        long difference2 = q10[offset3] - product2;
        int i10 = offset3 - 1;
        q10[offset3] = (int) difference2;
        long carry2 = (product2 >>> 32) + ((difference2 & 4294967295L) > (((long) (~((int) product2))) & 4294967295L) ? 1 : 0);
        return (int) carry2;
    }

    private boolean unsignedLongCompare(long one, long two) {
        return one + Long.MIN_VALUE > Long.MIN_VALUE + two;
    }

    static long divWord(long n10, int d10) {
        long dLong = d10 & 4294967295L;
        if (dLong == 1) {
            return (4294967295L & ((int) n10)) | (0 << 32);
        }
        long q10 = (n10 >>> 1) / (dLong >>> 1);
        long r10 = n10 - (q10 * dLong);
        while (r10 < 0) {
            r10 += dLong;
            q10--;
        }
        while (r10 >= dLong) {
            r10 -= dLong;
            q10++;
        }
        return (4294967295L & q10) | (r10 << 32);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MutableBigInteger sqrt() {
        if (isZero()) {
            return new MutableBigInteger(0);
        }
        if (this.value.length == 1 && (r0[0] & 4294967295L) < 4) {
            return ONE;
        }
        if (bitLength() <= 63) {
            long v2 = new BigInteger(this.value, 1).longValueExact();
            long xk = (long) Math.floor(Math.sqrt(v2));
            while (true) {
                long xk1 = ((v2 / xk) + xk) / 2;
                if (xk1 >= xk) {
                    return new MutableBigInteger(new int[]{(int) (xk >>> 32), (int) (4294967295L & xk)});
                }
                xk = xk1;
            }
        } else {
            int bitLength = (int) bitLength();
            if (bitLength != bitLength()) {
                throw new ArithmeticException("bitLength() integer overflow");
            }
            int shift = bitLength - 63;
            if (shift % 2 == 1) {
                shift++;
            }
            MutableBigInteger xk2 = new MutableBigInteger(this);
            xk2.rightShift(shift);
            xk2.normalize();
            double d10 = new BigInteger(xk2.value, 1).doubleValue();
            BigInteger bi = BigInteger.valueOf((long) Math.ceil(Math.sqrt(d10)));
            MutableBigInteger xk3 = new MutableBigInteger(bi.mag);
            xk3.leftShift(shift / 2);
            MutableBigInteger xk12 = new MutableBigInteger();
            while (true) {
                divide(xk3, xk12, false);
                xk12.add(xk3);
                xk12.rightShift(1);
                if (xk12.compare(xk3) >= 0) {
                    return xk3;
                }
                xk3.copyValue(xk12);
                xk12.reset();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MutableBigInteger hybridGCD(MutableBigInteger b4) {
        MutableBigInteger a10 = this;
        MutableBigInteger q10 = new MutableBigInteger();
        while (true) {
            int i10 = b4.intLen;
            if (i10 != 0) {
                if (Math.abs(a10.intLen - i10) < 2) {
                    return a10.binaryGCD(b4);
                }
                MutableBigInteger r10 = a10.divide(b4, q10);
                a10 = b4;
                b4 = r10;
            } else {
                return a10;
            }
        }
    }

    private MutableBigInteger binaryGCD(MutableBigInteger v2) {
        MutableBigInteger u10 = this;
        MutableBigInteger r10 = new MutableBigInteger();
        int s12 = u10.getLowestSetBit();
        int s2 = v2.getLowestSetBit();
        int k10 = s12 < s2 ? s12 : s2;
        if (k10 != 0) {
            u10.rightShift(k10);
            v2.rightShift(k10);
        }
        boolean uOdd = k10 == s12;
        MutableBigInteger t2 = uOdd ? v2 : u10;
        int tsign = uOdd ? -1 : 1;
        while (true) {
            int lb2 = t2.getLowestSetBit();
            if (lb2 < 0) {
                break;
            }
            t2.rightShift(lb2);
            if (tsign > 0) {
                u10 = t2;
            } else {
                v2 = t2;
            }
            if (u10.intLen < 2 && v2.intLen < 2) {
                int x10 = u10.value[u10.offset];
                int y10 = v2.value[v2.offset];
                r10.value[0] = binaryGcd(x10, y10);
                r10.intLen = 1;
                r10.offset = 0;
                if (k10 > 0) {
                    r10.leftShift(k10);
                }
                return r10;
            }
            int x11 = u10.difference(v2);
            tsign = x11;
            if (x11 == 0) {
                break;
            }
            t2 = tsign >= 0 ? u10 : v2;
        }
        if (k10 > 0) {
            u10.leftShift(k10);
        }
        return u10;
    }

    static int binaryGcd(int a10, int b4) {
        if (b4 == 0) {
            return a10;
        }
        if (a10 == 0) {
            return b4;
        }
        int aZeros = Integer.numberOfTrailingZeros(a10);
        int bZeros = Integer.numberOfTrailingZeros(b4);
        int a11 = a10 >>> aZeros;
        int b10 = b4 >>> bZeros;
        int t2 = aZeros < bZeros ? aZeros : bZeros;
        while (a11 != b10) {
            if (a11 - 2147483648 > Integer.MIN_VALUE + b10) {
                int a12 = a11 - b10;
                a11 = a12 >>> Integer.numberOfTrailingZeros(a12);
            } else {
                int b11 = b10 - a11;
                b10 = b11 >>> Integer.numberOfTrailingZeros(b11);
            }
        }
        return a11 << t2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MutableBigInteger mutableModInverse(MutableBigInteger p10) {
        if (p10.isOdd()) {
            return modInverse(p10);
        }
        if (isEven()) {
            throw new ArithmeticException("BigInteger not invertible.");
        }
        int powersOf2 = p10.getLowestSetBit();
        MutableBigInteger oddMod = new MutableBigInteger(p10);
        oddMod.rightShift(powersOf2);
        if (oddMod.isOne()) {
            return modInverseMP2(powersOf2);
        }
        MutableBigInteger oddPart = modInverse(oddMod);
        MutableBigInteger evenPart = modInverseMP2(powersOf2);
        MutableBigInteger y1 = modInverseBP2(oddMod, powersOf2);
        MutableBigInteger y22 = oddMod.modInverseMP2(powersOf2);
        MutableBigInteger temp1 = new MutableBigInteger();
        MutableBigInteger temp2 = new MutableBigInteger();
        MutableBigInteger result = new MutableBigInteger();
        oddPart.leftShift(powersOf2);
        oddPart.multiply(y1, result);
        evenPart.multiply(oddMod, temp1);
        temp1.multiply(y22, temp2);
        result.add(temp2);
        return result.divide(p10, temp1);
    }

    MutableBigInteger modInverseMP2(int k10) {
        if (isEven()) {
            throw new ArithmeticException("Non-invertible. (GCD != 1)");
        }
        if (k10 > 64) {
            return euclidModInverse(k10);
        }
        int t2 = inverseMod32(this.value[(this.offset + this.intLen) - 1]);
        if (k10 < 33) {
            return new MutableBigInteger(k10 == 32 ? t2 : ((1 << k10) - 1) & t2);
        }
        int[] iArr = this.value;
        int i10 = this.offset;
        long pLong = iArr[(i10 + r6) - 1] & 4294967295L;
        if (this.intLen > 1) {
            pLong |= iArr[(i10 + r6) - 2] << 32;
        }
        long tLong = t2 & 4294967295L;
        long tLong2 = tLong * (2 - (pLong * tLong));
        long tLong3 = k10 == 64 ? tLong2 : tLong2 & ((1 << k10) - 1);
        MutableBigInteger result = new MutableBigInteger(new int[2]);
        int[] iArr2 = result.value;
        iArr2[0] = (int) (tLong3 >>> 32);
        iArr2[1] = (int) tLong3;
        result.intLen = 2;
        result.normalize();
        return result;
    }

    static int inverseMod32(int val) {
        int t2 = val * (2 - (val * val));
        int t10 = t2 * (2 - (val * t2));
        int t11 = t10 * (2 - (val * t10));
        return t11 * (2 - (val * t11));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long inverseMod64(long val) {
        long t2 = val * (2 - (val * val));
        long t10 = t2 * (2 - (val * t2));
        long t11 = t10 * (2 - (val * t10));
        long t12 = t11 * (2 - (val * t11));
        return t12 * (2 - (val * t12));
    }

    static MutableBigInteger modInverseBP2(MutableBigInteger mod, int k10) {
        return fixup(new MutableBigInteger(1), new MutableBigInteger(mod), k10);
    }

    private MutableBigInteger modInverse(MutableBigInteger mod) {
        MutableBigInteger p10 = new MutableBigInteger(mod);
        MutableBigInteger f10 = new MutableBigInteger(this);
        MutableBigInteger g3 = new MutableBigInteger(p10);
        SignedMutableBigInteger c4 = new SignedMutableBigInteger(1);
        SignedMutableBigInteger d10 = new SignedMutableBigInteger();
        int k10 = 0;
        if (f10.isEven()) {
            int trailingZeros = f10.getLowestSetBit();
            f10.rightShift(trailingZeros);
            d10.leftShift(trailingZeros);
            k10 = trailingZeros;
        }
        while (!f10.isOne()) {
            if (f10.isZero()) {
                throw new ArithmeticException("BigInteger not invertible.");
            }
            if (f10.compare(g3) < 0) {
                MutableBigInteger temp = f10;
                f10 = g3;
                g3 = temp;
                SignedMutableBigInteger sTemp = d10;
                d10 = c4;
                c4 = sTemp;
            }
            if (((f10.value[(f10.offset + f10.intLen) - 1] ^ g3.value[(g3.offset + g3.intLen) - 1]) & 3) == 0) {
                f10.subtract(g3);
                c4.signedSubtract(d10);
            } else {
                f10.add(g3);
                c4.signedAdd(d10);
            }
            int trailingZeros2 = f10.getLowestSetBit();
            f10.rightShift(trailingZeros2);
            d10.leftShift(trailingZeros2);
            k10 += trailingZeros2;
        }
        if (c4.compare(p10) >= 0) {
            MutableBigInteger remainder = c4.divide(p10, new MutableBigInteger());
            c4.copyValue(remainder);
        }
        if (c4.sign < 0) {
            c4.signedAdd(p10);
        }
        return fixup(c4, p10, k10);
    }

    static MutableBigInteger fixup(MutableBigInteger c4, MutableBigInteger p10, int k10) {
        MutableBigInteger temp = new MutableBigInteger();
        int r10 = -inverseMod32(p10.value[(p10.offset + p10.intLen) - 1]);
        int numWords = k10 >> 5;
        for (int i10 = 0; i10 < numWords; i10++) {
            int v2 = c4.value[(c4.offset + c4.intLen) - 1] * r10;
            p10.mul(v2, temp);
            c4.add(temp);
            c4.intLen--;
        }
        int i11 = k10 & 31;
        if (i11 != 0) {
            int v10 = c4.value[(c4.offset + c4.intLen) - 1] * r10;
            p10.mul(v10 & ((1 << i11) - 1), temp);
            c4.add(temp);
            c4.rightShift(i11);
        }
        int v11 = c4.compare(p10);
        if (v11 >= 0) {
            return c4.divide(p10, new MutableBigInteger());
        }
        return c4;
    }

    MutableBigInteger euclidModInverse(int k10) {
        MutableBigInteger b4 = new MutableBigInteger(1);
        b4.leftShift(k10);
        MutableBigInteger mod = new MutableBigInteger(b4);
        MutableBigInteger a10 = new MutableBigInteger(this);
        MutableBigInteger q10 = new MutableBigInteger();
        MutableBigInteger b10 = b4.divide(a10, q10);
        MutableBigInteger t12 = new MutableBigInteger(q10);
        MutableBigInteger t02 = new MutableBigInteger(1);
        MutableBigInteger temp = new MutableBigInteger();
        while (!b10.isOne()) {
            MutableBigInteger r10 = a10.divide(b10, q10);
            if (r10.intLen == 0) {
                throw new ArithmeticException("BigInteger not invertible.");
            }
            a10 = r10;
            if (q10.intLen == 1) {
                t12.mul(q10.value[q10.offset], temp);
            } else {
                q10.multiply(t12, temp);
            }
            MutableBigInteger swapper = q10;
            MutableBigInteger q11 = temp;
            t02.add(q11);
            if (a10.isOne()) {
                return t02;
            }
            MutableBigInteger r11 = b10.divide(a10, q11);
            if (r11.intLen == 0) {
                throw new ArithmeticException("BigInteger not invertible.");
            }
            b10 = r11;
            if (q11.intLen == 1) {
                t02.mul(q11.value[q11.offset], swapper);
            } else {
                q11.multiply(t02, swapper);
            }
            q10 = swapper;
            temp = q11;
            t12.add(q10);
        }
        mod.subtract(t12);
        return mod;
    }
}
