package java.util;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.LongBuffer;
import java.util.Spliterator;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;
import java.util.stream.StreamSupport;
import jdk.internal.util.ArraysSupport;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class BitSet implements Cloneable, Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int ADDRESS_BITS_PER_WORD = 6;
    private static final int BITS_PER_WORD = 64;
    private static final int BIT_INDEX_MASK = 63;
    private static final long WORD_MASK = -1;
    private static final ObjectStreamField[] serialPersistentFields = {new ObjectStreamField("bits", long[].class)};
    private static final long serialVersionUID = 7997698588986878753L;
    private transient boolean sizeIsSticky;
    private long[] words;
    private transient int wordsInUse;

    /* JADX INFO: Access modifiers changed from: private */
    public static int wordIndex(int bitIndex) {
        return bitIndex >> 6;
    }

    private void checkInvariants() {
    }

    private void recalculateWordsInUse() {
        int i10 = this.wordsInUse - 1;
        while (i10 >= 0 && this.words[i10] == 0) {
            i10--;
        }
        this.wordsInUse = i10 + 1;
    }

    public BitSet() {
        this.wordsInUse = 0;
        this.sizeIsSticky = false;
        initWords(64);
        this.sizeIsSticky = false;
    }

    public BitSet(int nbits) {
        this.wordsInUse = 0;
        this.sizeIsSticky = false;
        if (nbits < 0) {
            throw new NegativeArraySizeException("nbits < 0: " + nbits);
        }
        initWords(nbits);
        this.sizeIsSticky = true;
    }

    private void initWords(int nbits) {
        this.words = new long[wordIndex(nbits - 1) + 1];
    }

    private BitSet(long[] words) {
        this.wordsInUse = 0;
        this.sizeIsSticky = false;
        this.words = words;
        this.wordsInUse = words.length;
        checkInvariants();
    }

    public static BitSet valueOf(long[] longs) {
        int n10 = longs.length;
        while (n10 > 0 && longs[n10 - 1] == 0) {
            n10--;
        }
        return new BitSet(Arrays.copyOf(longs, n10));
    }

    public static BitSet valueOf(LongBuffer lb2) {
        LongBuffer lb3 = lb2.slice();
        int n10 = lb3.remaining();
        while (n10 > 0 && lb3.get(n10 - 1) == 0) {
            n10--;
        }
        long[] words = new long[n10];
        lb3.get(words);
        return new BitSet(words);
    }

    public static BitSet valueOf(byte[] bytes) {
        return valueOf(ByteBuffer.wrap(bytes));
    }

    public static BitSet valueOf(ByteBuffer bb2) {
        ByteBuffer bb3 = bb2.slice().order(ByteOrder.LITTLE_ENDIAN);
        int n10 = bb3.remaining();
        while (n10 > 0 && bb3.get(n10 - 1) == 0) {
            n10--;
        }
        long[] words = new long[(n10 + 7) / 8];
        bb3.limit(n10);
        int i10 = 0;
        while (bb3.remaining() >= 8) {
            words[i10] = bb3.getLong();
            i10++;
        }
        int remaining = bb3.remaining();
        for (int j10 = 0; j10 < remaining; j10++) {
            words[i10] = words[i10] | ((bb3.get() & 255) << (j10 * 8));
        }
        return new BitSet(words);
    }

    public byte[] toByteArray() {
        int n10 = this.wordsInUse;
        if (n10 == 0) {
            return new byte[0];
        }
        int len = (n10 - 1) * 8;
        for (long x10 = this.words[n10 - 1]; x10 != 0; x10 >>>= 8) {
            len++;
        }
        byte[] bytes = new byte[len];
        ByteBuffer bb2 = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN);
        for (int i10 = 0; i10 < n10 - 1; i10++) {
            bb2.putLong(this.words[i10]);
        }
        for (long x11 = this.words[n10 - 1]; x11 != 0; x11 >>>= 8) {
            bb2.put((byte) (255 & x11));
        }
        return bytes;
    }

    public long[] toLongArray() {
        return Arrays.copyOf(this.words, this.wordsInUse);
    }

    private void ensureCapacity(int wordsRequired) {
        long[] jArr = this.words;
        if (jArr.length < wordsRequired) {
            int request = Math.max(jArr.length * 2, wordsRequired);
            this.words = Arrays.copyOf(this.words, request);
            this.sizeIsSticky = false;
        }
    }

    private void expandTo(int wordIndex) {
        int wordsRequired = wordIndex + 1;
        if (this.wordsInUse < wordsRequired) {
            ensureCapacity(wordsRequired);
            this.wordsInUse = wordsRequired;
        }
    }

    private static void checkRange(int fromIndex, int toIndex) {
        if (fromIndex < 0) {
            throw new IndexOutOfBoundsException("fromIndex < 0: " + fromIndex);
        }
        if (toIndex < 0) {
            throw new IndexOutOfBoundsException("toIndex < 0: " + toIndex);
        }
        if (fromIndex > toIndex) {
            throw new IndexOutOfBoundsException("fromIndex: " + fromIndex + " > toIndex: " + toIndex);
        }
    }

    public void flip(int bitIndex) {
        if (bitIndex < 0) {
            throw new IndexOutOfBoundsException("bitIndex < 0: " + bitIndex);
        }
        int wordIndex = wordIndex(bitIndex);
        expandTo(wordIndex);
        long[] jArr = this.words;
        jArr[wordIndex] = jArr[wordIndex] ^ (1 << bitIndex);
        recalculateWordsInUse();
        checkInvariants();
    }

    public void flip(int fromIndex, int toIndex) {
        checkRange(fromIndex, toIndex);
        if (fromIndex == toIndex) {
            return;
        }
        int startWordIndex = wordIndex(fromIndex);
        int endWordIndex = wordIndex(toIndex - 1);
        expandTo(endWordIndex);
        long firstWordMask = (-1) << fromIndex;
        long lastWordMask = (-1) >>> (-toIndex);
        if (startWordIndex == endWordIndex) {
            long[] jArr = this.words;
            jArr[startWordIndex] = jArr[startWordIndex] ^ (firstWordMask & lastWordMask);
        } else {
            long[] jArr2 = this.words;
            jArr2[startWordIndex] = jArr2[startWordIndex] ^ firstWordMask;
            for (int i10 = startWordIndex + 1; i10 < endWordIndex; i10++) {
                long[] jArr3 = this.words;
                jArr3[i10] = ~jArr3[i10];
            }
            long[] jArr4 = this.words;
            jArr4[endWordIndex] = jArr4[endWordIndex] ^ lastWordMask;
        }
        recalculateWordsInUse();
        checkInvariants();
    }

    public void set(int bitIndex) {
        if (bitIndex < 0) {
            throw new IndexOutOfBoundsException("bitIndex < 0: " + bitIndex);
        }
        int wordIndex = wordIndex(bitIndex);
        expandTo(wordIndex);
        long[] jArr = this.words;
        jArr[wordIndex] = jArr[wordIndex] | (1 << bitIndex);
        checkInvariants();
    }

    public void set(int bitIndex, boolean value) {
        if (value) {
            set(bitIndex);
        } else {
            clear(bitIndex);
        }
    }

    public void set(int fromIndex, int toIndex) {
        checkRange(fromIndex, toIndex);
        if (fromIndex == toIndex) {
            return;
        }
        int startWordIndex = wordIndex(fromIndex);
        int endWordIndex = wordIndex(toIndex - 1);
        expandTo(endWordIndex);
        long firstWordMask = (-1) << fromIndex;
        long lastWordMask = (-1) >>> (-toIndex);
        if (startWordIndex == endWordIndex) {
            long[] jArr = this.words;
            jArr[startWordIndex] = jArr[startWordIndex] | (firstWordMask & lastWordMask);
        } else {
            long[] jArr2 = this.words;
            jArr2[startWordIndex] = jArr2[startWordIndex] | firstWordMask;
            for (int i10 = startWordIndex + 1; i10 < endWordIndex; i10++) {
                this.words[i10] = -1;
            }
            long[] jArr3 = this.words;
            jArr3[endWordIndex] = jArr3[endWordIndex] | lastWordMask;
        }
        checkInvariants();
    }

    public void set(int fromIndex, int toIndex, boolean value) {
        if (value) {
            set(fromIndex, toIndex);
        } else {
            clear(fromIndex, toIndex);
        }
    }

    public void clear(int bitIndex) {
        if (bitIndex < 0) {
            throw new IndexOutOfBoundsException("bitIndex < 0: " + bitIndex);
        }
        int wordIndex = wordIndex(bitIndex);
        if (wordIndex >= this.wordsInUse) {
            return;
        }
        long[] jArr = this.words;
        jArr[wordIndex] = jArr[wordIndex] & (~(1 << bitIndex));
        recalculateWordsInUse();
        checkInvariants();
    }

    public void clear(int fromIndex, int toIndex) {
        int startWordIndex;
        checkRange(fromIndex, toIndex);
        if (fromIndex == toIndex || (startWordIndex = wordIndex(fromIndex)) >= this.wordsInUse) {
            return;
        }
        int endWordIndex = wordIndex(toIndex - 1);
        if (endWordIndex >= this.wordsInUse) {
            toIndex = length();
            endWordIndex = this.wordsInUse - 1;
        }
        long firstWordMask = (-1) << fromIndex;
        long lastWordMask = (-1) >>> (-toIndex);
        if (startWordIndex == endWordIndex) {
            long[] jArr = this.words;
            jArr[startWordIndex] = jArr[startWordIndex] & (~(firstWordMask & lastWordMask));
        } else {
            long[] jArr2 = this.words;
            jArr2[startWordIndex] = jArr2[startWordIndex] & (~firstWordMask);
            for (int i10 = startWordIndex + 1; i10 < endWordIndex; i10++) {
                this.words[i10] = 0;
            }
            long[] jArr3 = this.words;
            jArr3[endWordIndex] = jArr3[endWordIndex] & (~lastWordMask);
        }
        recalculateWordsInUse();
        checkInvariants();
    }

    public void clear() {
        while (true) {
            int i10 = this.wordsInUse;
            if (i10 > 0) {
                long[] jArr = this.words;
                int i11 = i10 - 1;
                this.wordsInUse = i11;
                jArr[i11] = 0;
            } else {
                return;
            }
        }
    }

    public boolean get(int bitIndex) {
        if (bitIndex < 0) {
            throw new IndexOutOfBoundsException("bitIndex < 0: " + bitIndex);
        }
        checkInvariants();
        int wordIndex = wordIndex(bitIndex);
        return wordIndex < this.wordsInUse && (this.words[wordIndex] & (1 << bitIndex)) != 0;
    }

    public BitSet get(int fromIndex, int toIndex) {
        long j10;
        long j11;
        int toIndex2 = toIndex;
        checkRange(fromIndex, toIndex);
        checkInvariants();
        int len = length();
        if (len <= fromIndex || fromIndex == toIndex2) {
            return new BitSet(0);
        }
        if (toIndex2 > len) {
            toIndex2 = len;
        }
        BitSet result = new BitSet(toIndex2 - fromIndex);
        int targetWords = wordIndex((toIndex2 - fromIndex) - 1) + 1;
        int sourceIndex = wordIndex(fromIndex);
        boolean wordAligned = (fromIndex & 63) == 0;
        int i10 = 0;
        while (i10 < targetWords - 1) {
            long[] jArr = result.words;
            if (wordAligned) {
                j11 = this.words[sourceIndex];
            } else {
                long[] jArr2 = this.words;
                j11 = (jArr2[sourceIndex] >>> fromIndex) | (jArr2[sourceIndex + 1] << (-fromIndex));
            }
            jArr[i10] = j11;
            i10++;
            sourceIndex++;
        }
        long lastWordMask = (-1) >>> (-toIndex2);
        long[] jArr3 = result.words;
        int i11 = targetWords - 1;
        if (((toIndex2 - 1) & 63) < (fromIndex & 63)) {
            long[] jArr4 = this.words;
            j10 = (jArr4[sourceIndex] >>> fromIndex) | ((jArr4[sourceIndex + 1] & lastWordMask) << (-fromIndex));
        } else {
            j10 = (this.words[sourceIndex] & lastWordMask) >>> fromIndex;
        }
        jArr3[i11] = j10;
        result.wordsInUse = targetWords;
        result.recalculateWordsInUse();
        result.checkInvariants();
        return result;
    }

    public int nextSetBit(int fromIndex) {
        if (fromIndex < 0) {
            throw new IndexOutOfBoundsException("fromIndex < 0: " + fromIndex);
        }
        checkInvariants();
        int u10 = wordIndex(fromIndex);
        if (u10 >= this.wordsInUse) {
            return -1;
        }
        long word = this.words[u10] & ((-1) << fromIndex);
        while (word == 0) {
            u10++;
            if (u10 == this.wordsInUse) {
                return -1;
            }
            word = this.words[u10];
        }
        return (u10 * 64) + Long.numberOfTrailingZeros(word);
    }

    public int nextClearBit(int fromIndex) {
        if (fromIndex < 0) {
            throw new IndexOutOfBoundsException("fromIndex < 0: " + fromIndex);
        }
        checkInvariants();
        int u10 = wordIndex(fromIndex);
        if (u10 >= this.wordsInUse) {
            return fromIndex;
        }
        long word = (~this.words[u10]) & ((-1) << fromIndex);
        while (word == 0) {
            u10++;
            int i10 = this.wordsInUse;
            if (u10 == i10) {
                return i10 * 64;
            }
            word = ~this.words[u10];
        }
        return (u10 * 64) + Long.numberOfTrailingZeros(word);
    }

    public int previousSetBit(int fromIndex) {
        if (fromIndex < 0) {
            if (fromIndex == -1) {
                return -1;
            }
            throw new IndexOutOfBoundsException("fromIndex < -1: " + fromIndex);
        }
        checkInvariants();
        int u10 = wordIndex(fromIndex);
        if (u10 >= this.wordsInUse) {
            return length() - 1;
        }
        long word = this.words[u10] & ((-1) >>> (-(fromIndex + 1)));
        while (word == 0) {
            int u11 = u10 - 1;
            if (u10 == 0) {
                return -1;
            }
            word = this.words[u11];
            u10 = u11;
        }
        return (((u10 + 1) * 64) - 1) - Long.numberOfLeadingZeros(word);
    }

    public int previousClearBit(int fromIndex) {
        if (fromIndex < 0) {
            if (fromIndex == -1) {
                return -1;
            }
            throw new IndexOutOfBoundsException("fromIndex < -1: " + fromIndex);
        }
        checkInvariants();
        int u10 = wordIndex(fromIndex);
        if (u10 >= this.wordsInUse) {
            return fromIndex;
        }
        long word = (~this.words[u10]) & ((-1) >>> (-(fromIndex + 1)));
        while (word == 0) {
            int u11 = u10 - 1;
            if (u10 == 0) {
                return -1;
            }
            word = ~this.words[u11];
            u10 = u11;
        }
        return (((u10 + 1) * 64) - 1) - Long.numberOfLeadingZeros(word);
    }

    public int length() {
        int i10 = this.wordsInUse;
        if (i10 == 0) {
            return 0;
        }
        return ((i10 - 1) * 64) + (64 - Long.numberOfLeadingZeros(this.words[i10 - 1]));
    }

    public boolean isEmpty() {
        return this.wordsInUse == 0;
    }

    public boolean intersects(BitSet set) {
        for (int i10 = Math.min(this.wordsInUse, set.wordsInUse) - 1; i10 >= 0; i10--) {
            if ((this.words[i10] & set.words[i10]) != 0) {
                return true;
            }
        }
        return false;
    }

    public int cardinality() {
        int sum = 0;
        for (int i10 = 0; i10 < this.wordsInUse; i10++) {
            sum += Long.bitCount(this.words[i10]);
        }
        return sum;
    }

    public void and(BitSet set) {
        if (this == set) {
            return;
        }
        while (true) {
            int i10 = this.wordsInUse;
            if (i10 <= set.wordsInUse) {
                break;
            }
            long[] jArr = this.words;
            int i11 = i10 - 1;
            this.wordsInUse = i11;
            jArr[i11] = 0;
        }
        for (int i12 = 0; i12 < this.wordsInUse; i12++) {
            long[] jArr2 = this.words;
            jArr2[i12] = jArr2[i12] & set.words[i12];
        }
        recalculateWordsInUse();
        checkInvariants();
    }

    public void or(BitSet set) {
        if (this == set) {
            return;
        }
        int wordsInCommon = Math.min(this.wordsInUse, set.wordsInUse);
        int i10 = this.wordsInUse;
        int i11 = set.wordsInUse;
        if (i10 < i11) {
            ensureCapacity(i11);
            this.wordsInUse = set.wordsInUse;
        }
        for (int i12 = 0; i12 < wordsInCommon; i12++) {
            long[] jArr = this.words;
            jArr[i12] = jArr[i12] | set.words[i12];
        }
        int i13 = set.wordsInUse;
        if (wordsInCommon < i13) {
            System.arraycopy((Object) set.words, wordsInCommon, (Object) this.words, wordsInCommon, this.wordsInUse - wordsInCommon);
        }
        checkInvariants();
    }

    public void xor(BitSet set) {
        int wordsInCommon = Math.min(this.wordsInUse, set.wordsInUse);
        int i10 = this.wordsInUse;
        int i11 = set.wordsInUse;
        if (i10 < i11) {
            ensureCapacity(i11);
            this.wordsInUse = set.wordsInUse;
        }
        for (int i12 = 0; i12 < wordsInCommon; i12++) {
            long[] jArr = this.words;
            jArr[i12] = jArr[i12] ^ set.words[i12];
        }
        int i13 = set.wordsInUse;
        if (wordsInCommon < i13) {
            System.arraycopy((Object) set.words, wordsInCommon, (Object) this.words, wordsInCommon, i13 - wordsInCommon);
        }
        recalculateWordsInUse();
        checkInvariants();
    }

    public void andNot(BitSet set) {
        for (int i10 = Math.min(this.wordsInUse, set.wordsInUse) - 1; i10 >= 0; i10--) {
            long[] jArr = this.words;
            jArr[i10] = jArr[i10] & (~set.words[i10]);
        }
        recalculateWordsInUse();
        checkInvariants();
    }

    public int hashCode() {
        long h10 = 1234;
        int i10 = this.wordsInUse;
        while (true) {
            i10--;
            if (i10 >= 0) {
                h10 ^= this.words[i10] * (i10 + 1);
            } else {
                return (int) ((h10 >> 32) ^ h10);
            }
        }
    }

    public int size() {
        return this.words.length * 64;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BitSet)) {
            return false;
        }
        BitSet set = (BitSet) obj;
        if (this == obj) {
            return true;
        }
        checkInvariants();
        set.checkInvariants();
        if (this.wordsInUse != set.wordsInUse) {
            return false;
        }
        for (int i10 = 0; i10 < this.wordsInUse; i10++) {
            if (this.words[i10] != set.words[i10]) {
                return false;
            }
        }
        return true;
    }

    public Object clone() {
        if (!this.sizeIsSticky) {
            trimToSize();
        }
        try {
            BitSet result = (BitSet) super.clone();
            result.words = (long[]) this.words.clone();
            result.checkInvariants();
            return result;
        } catch (CloneNotSupportedException e2) {
            throw new InternalError(e2);
        }
    }

    private void trimToSize() {
        int i10 = this.wordsInUse;
        long[] jArr = this.words;
        if (i10 != jArr.length) {
            this.words = Arrays.copyOf(jArr, i10);
            checkInvariants();
        }
    }

    private void writeObject(ObjectOutputStream s2) throws IOException {
        checkInvariants();
        if (!this.sizeIsSticky) {
            trimToSize();
        }
        ObjectOutputStream.PutField fields = s2.putFields();
        fields.put("bits", this.words);
        s2.writeFields();
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0023, code lost:
    
        if (r1[r1.length - 1] == 0) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void readObject(java.io.ObjectInputStream r7) throws java.io.IOException, java.lang.ClassNotFoundException {
        /*
            r6 = this;
            java.io.ObjectInputStream$GetField r0 = r7.readFields()
            java.lang.String r1 = "bits"
            r2 = 0
            java.lang.Object r1 = r0.get(r1, r2)
            long[] r1 = (long[]) r1
            r6.words = r1
            int r1 = r1.length
            r6.wordsInUse = r1
            r6.recalculateWordsInUse()
            long[] r1 = r6.words
            int r2 = r1.length
            if (r2 <= 0) goto L26
            int r2 = r1.length
            r3 = 1
            int r2 = r2 - r3
            r1 = r1[r2]
            r4 = 0
            int r1 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r1 != 0) goto L26
            goto L27
        L26:
            r3 = 0
        L27:
            r6.sizeIsSticky = r3
            r6.checkInvariants()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.BitSet.readObject(java.io.ObjectInputStream):void");
    }

    public String toString() {
        checkInvariants();
        int i10 = this.wordsInUse;
        int numBits = i10 > 128 ? cardinality() : i10 * 64;
        int initialCapacity = numBits <= 357913939 ? (numBits * 6) + 2 : ArraysSupport.SOFT_MAX_ARRAY_LENGTH;
        StringBuilder b4 = new StringBuilder(initialCapacity);
        b4.append('{');
        int i11 = nextSetBit(0);
        if (i11 != -1) {
            b4.append(i11);
            while (true) {
                int i12 = i11 + 1;
                if (i12 < 0) {
                    break;
                }
                int nextSetBit = nextSetBit(i12);
                i11 = nextSetBit;
                if (nextSetBit < 0) {
                    break;
                }
                int endOfRun = nextClearBit(i11);
                do {
                    b4.append(", ").append(i11);
                    i11++;
                } while (i11 != endOfRun);
            }
        }
        b4.append('}');
        return b4.toString();
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* renamed from: java.util.BitSet$1BitSetSpliterator, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    class C1BitSetSpliterator implements Spliterator.OfInt {
        private int est;
        private int fence;
        private int index;
        private boolean root;

        C1BitSetSpliterator(int origin, int fence, int est, boolean root) {
            this.index = origin;
            this.fence = fence;
            this.est = est;
            this.root = root;
        }

        private int getFence() {
            int hi = this.fence;
            if (hi >= 0) {
                return hi;
            }
            int i10 = BitSet.this.wordsInUse < BitSet.wordIndex(Integer.MAX_VALUE) ? BitSet.this.wordsInUse << 6 : Integer.MAX_VALUE;
            this.fence = i10;
            int hi2 = i10;
            this.est = BitSet.this.cardinality();
            this.index = BitSet.this.nextSetBit(0);
            return hi2;
        }

        @Override // java.util.Spliterator.OfInt, java.util.Spliterator.OfPrimitive
        public boolean tryAdvance(IntConsumer action) {
            Objects.requireNonNull(action);
            int hi = getFence();
            int i10 = this.index;
            if (i10 < 0 || i10 >= hi) {
                if (i10 == Integer.MAX_VALUE && hi == Integer.MAX_VALUE) {
                    this.index = -1;
                    action.accept(Integer.MAX_VALUE);
                    return true;
                }
                return false;
            }
            this.index = BitSet.this.nextSetBit(i10 + 1, BitSet.wordIndex(hi - 1));
            action.accept(i10);
            return true;
        }

        @Override // java.util.Spliterator.OfInt, java.util.Spliterator.OfPrimitive
        public void forEachRemaining(IntConsumer action) {
            Objects.requireNonNull(action);
            int hi = getFence();
            int u10 = this.index;
            this.index = -1;
            if (u10 >= 0 && u10 < hi) {
                int i10 = u10 + 1;
                action.accept(u10);
                int u11 = BitSet.wordIndex(i10);
                int v2 = BitSet.wordIndex(hi - 1);
                loop0: while (u11 <= v2 && i10 <= hi) {
                    long word = BitSet.this.words[u11] & ((-1) << i10);
                    while (word != 0) {
                        int i11 = (u11 << 6) + Long.numberOfTrailingZeros(word);
                        if (i11 >= hi) {
                            u10 = i11;
                            break loop0;
                        } else {
                            word &= ~(1 << i11);
                            action.accept(i11);
                        }
                    }
                    u11++;
                    i10 = u11 << 6;
                }
                u10 = i10;
            }
            if (u10 == Integer.MAX_VALUE && hi == Integer.MAX_VALUE) {
                action.accept(Integer.MAX_VALUE);
            }
        }

        @Override // java.util.Spliterator.OfInt, java.util.Spliterator.OfPrimitive, java.util.Spliterator
        public Spliterator.OfInt trySplit() {
            int hi = getFence();
            int lo = this.index;
            if (lo < 0) {
                return null;
            }
            int i10 = Integer.MAX_VALUE;
            if (hi < Integer.MAX_VALUE || !BitSet.this.get(Integer.MAX_VALUE)) {
                i10 = BitSet.this.previousSetBit(hi - 1) + 1;
            }
            this.fence = i10;
            int hi2 = i10;
            int mid = (lo + hi2) >>> 1;
            if (lo >= mid) {
                return null;
            }
            this.index = BitSet.this.nextSetBit(mid, BitSet.wordIndex(hi2 - 1));
            this.root = false;
            BitSet bitSet = BitSet.this;
            int i11 = this.est >>> 1;
            this.est = i11;
            return new C1BitSetSpliterator(lo, mid, i11, false);
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            getFence();
            return this.est;
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return (this.root ? 64 : 0) | 16 | 1 | 4;
        }

        @Override // java.util.Spliterator
        public Comparator<? super Integer> getComparator() {
            return null;
        }
    }

    public IntStream stream() {
        return StreamSupport.intStream(new C1BitSetSpliterator(0, -1, 0, true), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int nextSetBit(int fromIndex, int toWordIndex) {
        int u10 = wordIndex(fromIndex);
        if (u10 > toWordIndex) {
            return -1;
        }
        long word = this.words[u10] & ((-1) << fromIndex);
        while (word == 0) {
            u10++;
            if (u10 > toWordIndex) {
                return -1;
            }
            word = this.words[u10];
        }
        return (u10 * 64) + Long.numberOfTrailingZeros(word);
    }
}
