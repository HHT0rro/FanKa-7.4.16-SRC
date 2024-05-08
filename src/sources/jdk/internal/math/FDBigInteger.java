package jdk.internal.math;

import com.android.internal.logging.nano.MetricsProto;
import java.math.BigInteger;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class FDBigInteger {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long LONG_MASK = 4294967295L;
    private static final int MAX_FIVE_POW = 340;
    public static final FDBigInteger ZERO;
    private int[] data;
    private boolean isImmutable = false;
    private int nWords;
    private int offset;
    static final int[] SMALL_5_POW = {1, 5, 25, 125, MetricsProto.MetricsEvent.PROVISIONING_ERROR, 3125, 15625, 78125, 390625, 1953125, 9765625, 48828125, 244140625, 1220703125};
    static final long[] LONG_5_POW = {1, 5, 25, 125, 625, 3125, 15625, 78125, 390625, 1953125, 9765625, 48828125, 244140625, 1220703125, 6103515625L, 30517578125L, 152587890625L, 762939453125L, 3814697265625L, 19073486328125L, 95367431640625L, 476837158203125L, 2384185791015625L, 11920928955078125L, 59604644775390625L, 298023223876953125L, 1490116119384765625L};
    private static final FDBigInteger[] POW_5_CACHE = new FDBigInteger[340];

    static {
        int i10 = 0;
        while (true) {
            int[] iArr = SMALL_5_POW;
            if (i10 >= iArr.length) {
                break;
            }
            FDBigInteger pow5 = new FDBigInteger(new int[]{iArr[i10]}, 0);
            pow5.makeImmutable();
            POW_5_CACHE[i10] = pow5;
            i10++;
        }
        FDBigInteger prev = POW_5_CACHE[i10 - 1];
        while (i10 < 340) {
            FDBigInteger[] fDBigIntegerArr = POW_5_CACHE;
            FDBigInteger mult = prev.mult(5);
            prev = mult;
            fDBigIntegerArr[i10] = mult;
            prev.makeImmutable();
            i10++;
        }
        FDBigInteger fDBigInteger = new FDBigInteger(new int[0], 0);
        ZERO = fDBigInteger;
        fDBigInteger.makeImmutable();
    }

    private FDBigInteger(int[] data, int offset) {
        this.data = data;
        this.offset = offset;
        this.nWords = data.length;
        trimLeadingZeros();
    }

    public FDBigInteger(long lValue, char[] digits, int kDigits, int nDigits) {
        int n10 = Math.max((nDigits + 8) / 9, 2);
        int[] iArr = new int[n10];
        this.data = iArr;
        iArr[0] = (int) lValue;
        iArr[1] = (int) (lValue >>> 32);
        this.offset = 0;
        this.nWords = 2;
        int i10 = kDigits;
        int limit = nDigits - 5;
        while (i10 < limit) {
            int ilim = i10 + 5;
            int v2 = digits[i10] - '0';
            i10++;
            while (i10 < ilim) {
                v2 = ((v2 * 10) + digits[i10]) - 48;
                i10++;
            }
            multAddMe(100000, v2);
        }
        int factor = 1;
        int v10 = 0;
        while (i10 < nDigits) {
            v10 = ((v10 * 10) + digits[i10]) - 48;
            factor *= 10;
            i10++;
        }
        if (factor != 1) {
            multAddMe(factor, v10);
        }
        trimLeadingZeros();
    }

    public static FDBigInteger valueOfPow52(int p52, int p22) {
        if (p52 != 0) {
            if (p22 == 0) {
                return big5pow(p52);
            }
            int[] iArr = SMALL_5_POW;
            if (p52 < iArr.length) {
                int pow5 = iArr[p52];
                int wordcount = p22 >> 5;
                int bitcount = p22 & 31;
                if (bitcount == 0) {
                    return new FDBigInteger(new int[]{pow5}, wordcount);
                }
                return new FDBigInteger(new int[]{pow5 << bitcount, pow5 >>> (32 - bitcount)}, wordcount);
            }
            return big5pow(p52).leftShift(p22);
        }
        return valueOfPow2(p22);
    }

    public static FDBigInteger valueOfMulPow52(long value, int p52, int p22) {
        int[] r10;
        int v02 = (int) value;
        int v12 = (int) (value >>> 32);
        int wordcount = p22 >> 5;
        int bitcount = p22 & 31;
        int i10 = 0;
        if (p52 != 0) {
            if (p52 < SMALL_5_POW.length) {
                long pow5 = r10[p52] & 4294967295L;
                long carry = (v02 & 4294967295L) * pow5;
                int v03 = (int) carry;
                long carry2 = ((v12 & 4294967295L) * pow5) + (carry >>> 32);
                int v13 = (int) carry2;
                int v2 = (int) (carry2 >>> 32);
                if (bitcount == 0) {
                    return new FDBigInteger(new int[]{v03, v13, v2}, wordcount);
                }
                return new FDBigInteger(new int[]{v03 << bitcount, (v13 << bitcount) | (v03 >>> (32 - bitcount)), (v2 << bitcount) | (v13 >>> (32 - bitcount)), v2 >>> (32 - bitcount)}, wordcount);
            }
            FDBigInteger pow52 = big5pow(p52);
            if (v12 == 0) {
                int i11 = pow52.nWords;
                int i12 = i11 + 1;
                if (p22 != 0) {
                    i10 = 1;
                }
                r10 = new int[i12 + i10];
                mult(pow52.data, i11, v02, r10);
            } else {
                int i13 = pow52.nWords;
                int i14 = i13 + 2;
                if (p22 != 0) {
                    i10 = 1;
                }
                r10 = new int[i14 + i10];
                mult(pow52.data, i13, v02, v12, r10);
            }
            return new FDBigInteger(r10, pow52.offset).leftShift(p22);
        }
        if (p22 != 0) {
            if (bitcount == 0) {
                return new FDBigInteger(new int[]{v02, v12}, wordcount);
            }
            return new FDBigInteger(new int[]{v02 << bitcount, (v12 << bitcount) | (v02 >>> (32 - bitcount)), v12 >>> (32 - bitcount)}, wordcount);
        }
        return new FDBigInteger(new int[]{v02, v12}, 0);
    }

    private static FDBigInteger valueOfPow2(int p22) {
        int wordcount = p22 >> 5;
        int bitcount = p22 & 31;
        return new FDBigInteger(new int[]{1 << bitcount}, wordcount);
    }

    private void trimLeadingZeros() {
        int i10 = this.nWords;
        if (i10 > 0) {
            int i11 = i10 - 1;
            if (this.data[i11] == 0) {
                while (i11 > 0 && this.data[i11 - 1] == 0) {
                    i11--;
                }
                this.nWords = i11;
                if (i11 == 0) {
                    this.offset = 0;
                }
            }
        }
    }

    public int getNormalizationBias() {
        int i10 = this.nWords;
        if (i10 == 0) {
            throw new IllegalArgumentException("Zero value cannot be normalized");
        }
        int zeros = Integer.numberOfLeadingZeros(this.data[i10 - 1]);
        return zeros < 4 ? zeros + 28 : zeros - 4;
    }

    private static void leftShift(int[] src, int idx, int[] result, int bitcount, int anticount, int prev) {
        while (idx > 0) {
            int v2 = prev << bitcount;
            prev = src[idx - 1];
            result[idx] = v2 | (prev >>> anticount);
            idx--;
        }
        int v10 = prev << bitcount;
        result[0] = v10;
    }

    public FDBigInteger leftShift(int shift) {
        int i10;
        int[] result;
        int i11;
        int[] result2;
        if (shift == 0 || (i10 = this.nWords) == 0) {
            return this;
        }
        int wordcount = shift >> 5;
        int bitcount = shift & 31;
        if (this.isImmutable) {
            if (bitcount == 0) {
                return new FDBigInteger(Arrays.copyOf(this.data, i10), this.offset + wordcount);
            }
            int anticount = 32 - bitcount;
            int idx = i10 - 1;
            int[] iArr = this.data;
            int prev = iArr[idx];
            int hi = prev >>> anticount;
            if (hi != 0) {
                int[] result3 = new int[i10 + 1];
                result3[i10] = hi;
                result2 = result3;
            } else {
                result2 = new int[i10];
            }
            leftShift(iArr, idx, result2, bitcount, anticount, prev);
            return new FDBigInteger(result2, this.offset + wordcount);
        }
        if (bitcount != 0) {
            int anticount2 = 32 - bitcount;
            int[] iArr2 = this.data;
            if ((iArr2[0] << bitcount) == 0) {
                int idx2 = 0;
                int prev2 = iArr2[0];
                while (true) {
                    i11 = this.nWords;
                    if (idx2 >= i11 - 1) {
                        break;
                    }
                    int v2 = prev2 >>> anticount2;
                    int[] iArr3 = this.data;
                    prev2 = iArr3[idx2 + 1];
                    iArr3[idx2] = v2 | (prev2 << bitcount);
                    idx2++;
                }
                int v10 = prev2 >>> anticount2;
                this.data[idx2] = v10;
                if (v10 == 0) {
                    this.nWords = i11 - 1;
                }
                this.offset++;
            } else {
                int idx3 = i10 - 1;
                int prev3 = iArr2[idx3];
                int hi2 = prev3 >>> anticount2;
                int[] result4 = this.data;
                int[] src = this.data;
                if (hi2 == 0) {
                    result = result4;
                } else {
                    if (i10 == iArr2.length) {
                        int[] iArr4 = new int[i10 + 1];
                        result4 = iArr4;
                        this.data = iArr4;
                    }
                    this.nWords = i10 + 1;
                    result4[i10] = hi2;
                    result = result4;
                }
                leftShift(src, idx3, result, bitcount, anticount2, prev3);
            }
        }
        this.offset += wordcount;
        return this;
    }

    private int size() {
        return this.nWords + this.offset;
    }

    public int quoRemIteration(FDBigInteger S) throws IllegalArgumentException {
        int thSize = size();
        int sSize = S.size();
        if (thSize < sSize) {
            int[] iArr = this.data;
            int p10 = multAndCarryBy10(iArr, this.nWords, iArr);
            if (p10 != 0) {
                int[] iArr2 = this.data;
                int i10 = this.nWords;
                this.nWords = i10 + 1;
                iArr2[i10] = p10;
                return 0;
            }
            trimLeadingZeros();
            return 0;
        }
        if (thSize > sSize) {
            throw new IllegalArgumentException("disparate values");
        }
        long q10 = (this.data[this.nWords - 1] & 4294967295L) / (S.data[S.nWords - 1] & 4294967295L);
        long diff = multDiffMe(q10, S);
        if (diff != 0) {
            long sum = 0;
            int tStart = S.offset - this.offset;
            int[] sd2 = S.data;
            int[] td2 = this.data;
            for (long j10 = 0; sum == j10; j10 = 0) {
                int sIndex = 0;
                int tIndex = tStart;
                while (tIndex < this.nWords) {
                    long sum2 = sum + (td2[tIndex] & 4294967295L) + (sd2[sIndex] & 4294967295L);
                    td2[tIndex] = (int) sum2;
                    sum = sum2 >>> 32;
                    sIndex++;
                    tIndex++;
                    thSize = thSize;
                    diff = diff;
                }
                q10--;
                thSize = thSize;
                diff = diff;
            }
        }
        int[] iArr3 = this.data;
        multAndCarryBy10(iArr3, this.nWords, iArr3);
        trimLeadingZeros();
        return (int) q10;
    }

    public FDBigInteger multBy10() {
        int i10 = this.nWords;
        if (i10 == 0) {
            return this;
        }
        if (this.isImmutable) {
            int[] res = new int[i10 + 1];
            res[i10] = multAndCarryBy10(this.data, i10, res);
            return new FDBigInteger(res, this.offset);
        }
        int[] res2 = this.data;
        int p10 = multAndCarryBy10(res2, i10, res2);
        if (p10 != 0) {
            int i11 = this.nWords;
            int[] iArr = this.data;
            if (i11 == iArr.length) {
                if (iArr[0] == 0) {
                    int i12 = i11 - 1;
                    this.nWords = i12;
                    System.arraycopy((Object) iArr, 1, (Object) iArr, 0, i12);
                    this.offset++;
                } else {
                    this.data = Arrays.copyOf(iArr, iArr.length + 1);
                }
            }
            int[] iArr2 = this.data;
            int i13 = this.nWords;
            this.nWords = i13 + 1;
            iArr2[i13] = p10;
        } else {
            trimLeadingZeros();
        }
        return this;
    }

    public FDBigInteger multByPow52(int p52, int p22) {
        int i10 = this.nWords;
        if (i10 == 0) {
            return this;
        }
        FDBigInteger res = this;
        if (p52 != 0) {
            int extraSize = p22 != 0 ? 1 : 0;
            int[] iArr = SMALL_5_POW;
            if (p52 < iArr.length) {
                int[] r10 = new int[i10 + 1 + extraSize];
                mult(this.data, i10, iArr[p52], r10);
                res = new FDBigInteger(r10, this.offset);
            } else {
                FDBigInteger pow5 = big5pow(p52);
                int[] r11 = new int[this.nWords + pow5.size() + extraSize];
                mult(this.data, this.nWords, pow5.data, pow5.nWords, r11);
                res = new FDBigInteger(r11, this.offset + pow5.offset);
            }
        }
        return res.leftShift(p22);
    }

    private static void mult(int[] s12, int s1Len, int[] s2, int s2Len, int[] dst) {
        for (int i10 = 0; i10 < s1Len; i10++) {
            long v2 = s12[i10] & 4294967295L;
            long p10 = 0;
            for (int j10 = 0; j10 < s2Len; j10++) {
                long p11 = p10 + (dst[i10 + j10] & 4294967295L) + ((s2[j10] & 4294967295L) * v2);
                dst[i10 + j10] = (int) p11;
                p10 = p11 >>> 32;
            }
            dst[i10 + s2Len] = (int) p10;
        }
    }

    public FDBigInteger leftInplaceSub(FDBigInteger subtrahend) {
        FDBigInteger minuend;
        if (this.isImmutable) {
            minuend = new FDBigInteger((int[]) this.data.clone(), this.offset);
        } else {
            minuend = this;
        }
        int offsetDiff = subtrahend.offset - minuend.offset;
        int[] sData = subtrahend.data;
        int[] mData = minuend.data;
        int subLen = subtrahend.nWords;
        int minLen = minuend.nWords;
        if (offsetDiff < 0) {
            int rLen = minLen - offsetDiff;
            if (rLen < mData.length) {
                System.arraycopy((Object) mData, 0, (Object) mData, -offsetDiff, minLen);
                Arrays.fill(mData, 0, -offsetDiff, 0);
            } else {
                int[] r10 = new int[rLen];
                System.arraycopy((Object) mData, 0, (Object) r10, -offsetDiff, minLen);
                mData = r10;
                minuend.data = r10;
            }
            minuend.offset = subtrahend.offset;
            minLen = rLen;
            minuend.nWords = rLen;
            offsetDiff = 0;
        }
        long borrow = 0;
        int mIndex = offsetDiff;
        int sIndex = 0;
        while (sIndex < subLen && mIndex < minLen) {
            long diff = ((mData[mIndex] & 4294967295L) - (sData[sIndex] & 4294967295L)) + borrow;
            mData[mIndex] = (int) diff;
            borrow = diff >> 32;
            sIndex++;
            mIndex++;
            sData = sData;
            offsetDiff = offsetDiff;
        }
        while (borrow != 0 && mIndex < minLen) {
            long diff2 = (mData[mIndex] & 4294967295L) + borrow;
            mData[mIndex] = (int) diff2;
            borrow = diff2 >> 32;
            mIndex++;
        }
        minuend.trimLeadingZeros();
        return minuend;
    }

    public FDBigInteger rightInplaceSub(FDBigInteger subtrahend) {
        FDBigInteger subtrahend2 = subtrahend;
        FDBigInteger minuend = this;
        if (subtrahend2.isImmutable) {
            subtrahend2 = new FDBigInteger((int[]) subtrahend2.data.clone(), subtrahend2.offset);
        }
        int offsetDiff = minuend.offset - subtrahend2.offset;
        int[] sData = subtrahend2.data;
        int[] mData = minuend.data;
        int subLen = subtrahend2.nWords;
        int minLen = minuend.nWords;
        if (offsetDiff < 0) {
            if (minLen < sData.length) {
                System.arraycopy((Object) sData, 0, (Object) sData, -offsetDiff, subLen);
                Arrays.fill(sData, 0, -offsetDiff, 0);
            } else {
                int[] r10 = new int[minLen];
                System.arraycopy((Object) sData, 0, (Object) r10, -offsetDiff, subLen);
                sData = r10;
                subtrahend2.data = r10;
            }
            subtrahend2.offset = minuend.offset;
            int i10 = subLen - offsetDiff;
            offsetDiff = 0;
        } else {
            int rLen = minLen + offsetDiff;
            if (rLen >= sData.length) {
                int[] copyOf = Arrays.copyOf(sData, rLen);
                sData = copyOf;
                subtrahend2.data = copyOf;
            }
        }
        int sIndex = 0;
        long borrow = 0;
        while (sIndex < offsetDiff) {
            long diff = (0 - (4294967295L & sData[sIndex])) + borrow;
            sData[sIndex] = (int) diff;
            borrow = diff >> 32;
            sIndex++;
        }
        int mIndex = 0;
        while (mIndex < minLen) {
            long diff2 = ((mData[mIndex] & 4294967295L) - (sData[sIndex] & 4294967295L)) + borrow;
            sData[sIndex] = (int) diff2;
            borrow = diff2 >> 32;
            sIndex++;
            mIndex++;
            minuend = minuend;
            offsetDiff = offsetDiff;
        }
        subtrahend2.nWords = sIndex;
        subtrahend2.trimLeadingZeros();
        return subtrahend2;
    }

    private static int checkZeroTail(int[] a10, int from) {
        while (from > 0) {
            from--;
            if (a10[from] != 0) {
                return 1;
            }
        }
        return 0;
    }

    public int cmp(FDBigInteger other) {
        int aSize = this.nWords + this.offset;
        int bSize = other.nWords + other.offset;
        if (aSize > bSize) {
            return 1;
        }
        if (aSize < bSize) {
            return -1;
        }
        int aLen = this.nWords;
        int bLen = other.nWords;
        while (aLen > 0 && bLen > 0) {
            aLen--;
            int a10 = this.data[aLen];
            bLen--;
            int b4 = other.data[bLen];
            if (a10 != b4) {
                if ((a10 & 4294967295L) >= (4294967295L & b4)) {
                    return 1;
                }
                return -1;
            }
        }
        if (aLen > 0) {
            return checkZeroTail(this.data, aLen);
        }
        if (bLen > 0) {
            return -checkZeroTail(other.data, bLen);
        }
        return 0;
    }

    public int cmpPow52(int p52, int p22) {
        if (p52 != 0) {
            return cmp(big5pow(p52).leftShift(p22));
        }
        int wordcount = p22 >> 5;
        int bitcount = p22 & 31;
        int i10 = this.nWords;
        int size = this.offset + i10;
        if (size > wordcount + 1) {
            return 1;
        }
        if (size < wordcount + 1) {
            return -1;
        }
        int[] iArr = this.data;
        int a10 = iArr[i10 - 1];
        int b4 = 1 << bitcount;
        if (a10 != b4) {
            return (((long) a10) & 4294967295L) < (((long) b4) & 4294967295L) ? -1 : 1;
        }
        return checkZeroTail(iArr, i10 - 1);
    }

    public int addAndCmp(FDBigInteger x10, FDBigInteger y10) {
        FDBigInteger big;
        FDBigInteger small;
        int bSize;
        int sSize;
        int xSize = x10.size();
        int ySize = y10.size();
        if (xSize >= ySize) {
            big = x10;
            small = y10;
            bSize = xSize;
            sSize = ySize;
        } else {
            big = y10;
            small = x10;
            bSize = ySize;
            sSize = xSize;
        }
        int thSize = size();
        if (bSize == 0) {
            return thSize == 0 ? 0 : 1;
        }
        if (sSize == 0) {
            return cmp(big);
        }
        if (bSize > thSize) {
            return -1;
        }
        if (bSize + 1 < thSize) {
            return 1;
        }
        long top = big.data[big.nWords - 1] & 4294967295L;
        if (sSize == bSize) {
            top += small.data[small.nWords - 1] & 4294967295L;
        }
        if ((top >>> 32) == 0) {
            if (((top + 1) >>> 32) == 0) {
                if (bSize < thSize) {
                    return 1;
                }
                long v2 = 4294967295L & this.data[this.nWords - 1];
                if (v2 < top) {
                    return -1;
                }
                if (v2 > top + 1) {
                    return 1;
                }
            }
        } else {
            if (bSize + 1 > thSize) {
                return -1;
            }
            long top2 = top >>> 32;
            long v10 = 4294967295L & this.data[this.nWords - 1];
            if (v10 < top2) {
                return -1;
            }
            if (v10 > top2 + 1) {
                return 1;
            }
        }
        return cmp(big.add(small));
    }

    public void makeImmutable() {
        this.isImmutable = true;
    }

    private FDBigInteger mult(int i10) {
        int i11 = this.nWords;
        if (i11 == 0) {
            return this;
        }
        int[] r10 = new int[i11 + 1];
        mult(this.data, i11, i10, r10);
        return new FDBigInteger(r10, this.offset);
    }

    private FDBigInteger mult(FDBigInteger other) {
        if (this.nWords == 0) {
            return this;
        }
        if (size() == 1) {
            return other.mult(this.data[0]);
        }
        if (other.nWords == 0) {
            return other;
        }
        if (other.size() == 1) {
            return mult(other.data[0]);
        }
        int i10 = this.nWords;
        int i11 = other.nWords;
        int[] r10 = new int[i10 + i11];
        mult(this.data, i10, other.data, i11, r10);
        return new FDBigInteger(r10, this.offset + other.offset);
    }

    private FDBigInteger add(FDBigInteger other) {
        FDBigInteger big;
        int bigLen;
        FDBigInteger small;
        int smallLen;
        int tSize;
        int oSize;
        long j10;
        int tSize2 = size();
        int oSize2 = other.size();
        if (tSize2 >= oSize2) {
            big = this;
            bigLen = tSize2;
            small = other;
            smallLen = oSize2;
        } else {
            big = other;
            bigLen = oSize2;
            small = this;
            smallLen = tSize2;
        }
        int[] r10 = new int[bigLen + 1];
        int i10 = 0;
        long carry = 0;
        while (i10 < smallLen) {
            long j11 = i10 < big.offset ? 0L : big.data[i10 - r15] & 4294967295L;
            int i11 = small.offset;
            if (i10 < i11) {
                tSize = tSize2;
                oSize = oSize2;
                j10 = 0;
            } else {
                int i12 = small.data[i10 - i11];
                tSize = tSize2;
                oSize = oSize2;
                j10 = i12 & 4294967295L;
            }
            long carry2 = carry + j11 + j10;
            r10[i10] = (int) carry2;
            carry = carry2 >> 32;
            i10++;
            tSize2 = tSize;
            oSize2 = oSize;
        }
        while (i10 < bigLen) {
            long carry3 = carry + (i10 < big.offset ? 0L : big.data[i10 - r0] & 4294967295L);
            r10[i10] = (int) carry3;
            carry = carry3 >> 32;
            i10++;
        }
        r10[bigLen] = (int) carry;
        return new FDBigInteger(r10, 0);
    }

    private void multAddMe(int iv, int addend) {
        int i10;
        long v2 = iv & 4294967295L;
        long p10 = ((r4[0] & 4294967295L) * v2) + (addend & 4294967295L);
        this.data[0] = (int) p10;
        long p11 = p10 >>> 32;
        int i11 = 1;
        while (true) {
            i10 = this.nWords;
            if (i11 >= i10) {
                break;
            }
            long p12 = p11 + ((r8[i11] & 4294967295L) * v2);
            this.data[i11] = (int) p12;
            p11 = p12 >>> 32;
            i11++;
        }
        if (p11 != 0) {
            int[] iArr = this.data;
            this.nWords = i10 + 1;
            iArr[i10] = (int) p11;
        }
    }

    private long multDiffMe(long q10, FDBigInteger S) {
        long diff = 0;
        if (q10 != 0) {
            int deltaSize = S.offset - this.offset;
            if (deltaSize >= 0) {
                int[] sd2 = S.data;
                int[] td2 = this.data;
                int sIndex = 0;
                int tIndex = deltaSize;
                while (sIndex < S.nWords) {
                    long diff2 = diff + ((td2[tIndex] & 4294967295L) - ((sd2[sIndex] & 4294967295L) * q10));
                    td2[tIndex] = (int) diff2;
                    diff = diff2 >> 32;
                    sIndex++;
                    tIndex++;
                }
            } else {
                int deltaSize2 = -deltaSize;
                int[] rd2 = new int[this.nWords + deltaSize2];
                int sIndex2 = 0;
                int rIndex = 0;
                int[] sd3 = S.data;
                while (rIndex < deltaSize2 && sIndex2 < S.nWords) {
                    long diff3 = diff - ((sd3[sIndex2] & 4294967295L) * q10);
                    rd2[rIndex] = (int) diff3;
                    diff = diff3 >> 32;
                    sIndex2++;
                    rIndex++;
                }
                int tIndex2 = 0;
                int[] td3 = this.data;
                while (sIndex2 < S.nWords) {
                    long diff4 = diff + ((td3[tIndex2] & 4294967295L) - ((sd3[sIndex2] & 4294967295L) * q10));
                    rd2[rIndex] = (int) diff4;
                    diff = diff4 >> 32;
                    sIndex2++;
                    tIndex2++;
                    rIndex++;
                    deltaSize2 = deltaSize2;
                }
                int deltaSize3 = deltaSize2;
                this.nWords += deltaSize3;
                this.offset -= deltaSize3;
                this.data = rd2;
            }
        }
        return diff;
    }

    private static int multAndCarryBy10(int[] src, int srcLen, int[] dst) {
        long carry = 0;
        for (int i10 = 0; i10 < srcLen; i10++) {
            long product = ((src[i10] & 4294967295L) * 10) + carry;
            dst[i10] = (int) product;
            carry = product >>> 32;
        }
        int i11 = (int) carry;
        return i11;
    }

    private static void mult(int[] src, int srcLen, int value, int[] dst) {
        long val = value & 4294967295L;
        long carry = 0;
        for (int i10 = 0; i10 < srcLen; i10++) {
            long product = ((src[i10] & 4294967295L) * val) + carry;
            dst[i10] = (int) product;
            carry = product >>> 32;
        }
        dst[srcLen] = (int) carry;
    }

    private static void mult(int[] src, int srcLen, int v02, int v12, int[] dst) {
        long v2 = v02 & 4294967295L;
        long carry = 0;
        for (int j10 = 0; j10 < srcLen; j10++) {
            long product = ((src[j10] & 4294967295L) * v2) + carry;
            dst[j10] = (int) product;
            carry = product >>> 32;
        }
        int j11 = (int) carry;
        dst[srcLen] = j11;
        long v10 = v12 & 4294967295L;
        long carry2 = 0;
        for (int j12 = 0; j12 < srcLen; j12++) {
            long product2 = (dst[j12 + 1] & 4294967295L) + ((src[j12] & 4294967295L) * v10) + carry2;
            dst[j12 + 1] = (int) product2;
            carry2 = product2 >>> 32;
        }
        dst[srcLen + 1] = (int) carry2;
    }

    private static FDBigInteger big5pow(int p10) {
        if (p10 < 340) {
            return POW_5_CACHE[p10];
        }
        return big5powRec(p10);
    }

    private static FDBigInteger big5powRec(int p10) {
        if (p10 < 340) {
            return POW_5_CACHE[p10];
        }
        int q10 = p10 >> 1;
        int r10 = p10 - q10;
        FDBigInteger bigq = big5powRec(q10);
        int[] iArr = SMALL_5_POW;
        if (r10 < iArr.length) {
            return bigq.mult(iArr[r10]);
        }
        return bigq.mult(big5powRec(r10));
    }

    public String toHexString() {
        if (this.nWords == 0) {
            return "0";
        }
        StringBuilder sb2 = new StringBuilder((this.nWords + this.offset) * 8);
        for (int i10 = this.nWords - 1; i10 >= 0; i10--) {
            String subStr = Integer.toHexString(this.data[i10]);
            for (int j10 = subStr.length(); j10 < 8; j10++) {
                sb2.append('0');
            }
            sb2.append(subStr);
        }
        for (int i11 = this.offset; i11 > 0; i11--) {
            sb2.append("00000000");
        }
        return sb2.toString();
    }

    public BigInteger toBigInteger() {
        byte[] magnitude = new byte[(this.nWords * 4) + 1];
        for (int i10 = 0; i10 < this.nWords; i10++) {
            int w3 = this.data[i10];
            magnitude[(magnitude.length - (i10 * 4)) - 1] = (byte) w3;
            magnitude[(magnitude.length - (i10 * 4)) - 2] = (byte) (w3 >> 8);
            magnitude[(magnitude.length - (i10 * 4)) - 3] = (byte) (w3 >> 16);
            magnitude[(magnitude.length - (i10 * 4)) - 4] = (byte) (w3 >> 24);
        }
        return new BigInteger(magnitude).shiftLeft(this.offset * 32);
    }

    public String toString() {
        return toBigInteger().toString();
    }
}
