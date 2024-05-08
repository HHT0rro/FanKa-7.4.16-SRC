package java.math;

import java.util.Random;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class BitSieve {
    private static BitSieve smallSieve = new BitSieve();
    private long[] bits;
    private int length;

    private BitSieve() {
        this.length = 9600;
        this.bits = new long[unitIndex(9600 - 1) + 1];
        set(0);
        int nextIndex = 1;
        int nextPrime = 3;
        do {
            sieveSingle(this.length, nextIndex + nextPrime, nextPrime);
            nextIndex = sieveSearch(this.length, nextIndex + 1);
            nextPrime = (nextIndex * 2) + 1;
            if (nextIndex <= 0) {
                return;
            }
        } while (nextPrime < this.length);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BitSieve(BigInteger base, int searchLen) {
        this.bits = new long[unitIndex(searchLen - 1) + 1];
        this.length = searchLen;
        BitSieve bitSieve = smallSieve;
        int step = bitSieve.sieveSearch(bitSieve.length, 0);
        int convertedStep = (step * 2) + 1;
        MutableBigInteger b4 = new MutableBigInteger(base);
        MutableBigInteger q10 = new MutableBigInteger();
        do {
            int start = convertedStep - b4.divideOneWord(convertedStep, q10);
            sieveSingle(searchLen, ((start % 2 == 0 ? start + convertedStep : start) - 1) / 2, convertedStep);
            BitSieve bitSieve2 = smallSieve;
            step = bitSieve2.sieveSearch(bitSieve2.length, step + 1);
            convertedStep = (step * 2) + 1;
        } while (step > 0);
    }

    private static int unitIndex(int bitIndex) {
        return bitIndex >>> 6;
    }

    private static long bit(int bitIndex) {
        return 1 << (bitIndex & 63);
    }

    private boolean get(int bitIndex) {
        int unitIndex = unitIndex(bitIndex);
        return (this.bits[unitIndex] & bit(bitIndex)) != 0;
    }

    private void set(int bitIndex) {
        int unitIndex = unitIndex(bitIndex);
        long[] jArr = this.bits;
        jArr[unitIndex] = jArr[unitIndex] | bit(bitIndex);
    }

    private int sieveSearch(int limit, int start) {
        if (start >= limit) {
            return -1;
        }
        int index = start;
        while (get(index)) {
            index++;
            if (index >= limit - 1) {
                return -1;
            }
        }
        return index;
    }

    private void sieveSingle(int limit, int start, int step) {
        while (start < limit) {
            set(start);
            start += step;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BigInteger retrieve(BigInteger initValue, int certainty, Random random) {
        int offset = 1;
        int i10 = 0;
        while (true) {
            long[] jArr = this.bits;
            if (i10 < jArr.length) {
                long nextLong = ~jArr[i10];
                for (int j10 = 0; j10 < 64; j10++) {
                    if ((nextLong & 1) == 1) {
                        BigInteger candidate = initValue.add(BigInteger.valueOf(offset));
                        if (candidate.primeToCertainty(certainty, random)) {
                            return candidate;
                        }
                    }
                    nextLong >>>= 1;
                    offset += 2;
                }
                i10++;
            } else {
                return null;
            }
        }
    }
}
