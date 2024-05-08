package java.util.stream;

import XI.CA.XI.K0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.PrimitiveIterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.LongConsumer;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class SpinedBuffer<E> extends AbstractSpinedBuffer implements Consumer<E>, Iterable<E> {
    private static final int SPLITERATOR_CHARACTERISTICS = 16464;
    protected E[] curChunk;
    protected E[][] spine;

    @Override // java.util.stream.AbstractSpinedBuffer
    public /* bridge */ /* synthetic */ long count() {
        return super.count();
    }

    @Override // java.util.stream.AbstractSpinedBuffer
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    public SpinedBuffer(int i10) {
        super(i10);
        this.curChunk = (E[]) new Object[1 << this.initialChunkPower];
    }

    public SpinedBuffer() {
        this.curChunk = (E[]) new Object[1 << this.initialChunkPower];
    }

    protected long capacity() {
        if (this.spineIndex == 0) {
            return this.curChunk.length;
        }
        return this.priorElementCount[this.spineIndex] + this.spine[this.spineIndex].length;
    }

    private void inflateSpine() {
        if (this.spine == null) {
            this.spine = (E[][]) new Object[8];
            this.priorElementCount = new long[8];
            this.spine[0] = this.curChunk;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void ensureCapacity(long j10) {
        long capacity = capacity();
        if (j10 > capacity) {
            inflateSpine();
            int i10 = this.spineIndex;
            while (true) {
                i10++;
                if (j10 > capacity) {
                    E[][] eArr = this.spine;
                    if (i10 >= eArr.length) {
                        int length = eArr.length * 2;
                        this.spine = (E[][]) ((Object[][]) Arrays.copyOf(eArr, length));
                        this.priorElementCount = Arrays.copyOf(this.priorElementCount, length);
                    }
                    int chunkSize = chunkSize(i10);
                    ((E[][]) this.spine)[i10] = new Object[chunkSize];
                    this.priorElementCount[i10] = this.priorElementCount[i10 - 1] + this.spine[i10 - 1].length;
                    capacity += chunkSize;
                } else {
                    return;
                }
            }
        }
    }

    protected void increaseCapacity() {
        ensureCapacity(capacity() + 1);
    }

    public E get(long index) {
        if (this.spineIndex == 0) {
            if (index < this.elementIndex) {
                return this.curChunk[(int) index];
            }
            throw new IndexOutOfBoundsException(Long.toString(index));
        }
        if (index >= count()) {
            throw new IndexOutOfBoundsException(Long.toString(index));
        }
        for (int j10 = 0; j10 <= this.spineIndex; j10++) {
            long j11 = this.priorElementCount[j10];
            E[] eArr = this.spine[j10];
            if (index < j11 + eArr.length) {
                return eArr[(int) (index - this.priorElementCount[j10])];
            }
        }
        throw new IndexOutOfBoundsException(Long.toString(index));
    }

    public void copyInto(E[] array, int offset) {
        long finalOffset = offset + count();
        if (finalOffset > array.length || finalOffset < offset) {
            throw new IndexOutOfBoundsException("does not fit");
        }
        if (this.spineIndex == 0) {
            System.arraycopy(this.curChunk, 0, array, offset, this.elementIndex);
            return;
        }
        for (int i10 = 0; i10 < this.spineIndex; i10++) {
            E[] eArr = this.spine[i10];
            System.arraycopy(eArr, 0, array, offset, eArr.length);
            offset += this.spine[i10].length;
        }
        int i11 = this.elementIndex;
        if (i11 > 0) {
            System.arraycopy(this.curChunk, 0, array, offset, this.elementIndex);
        }
    }

    public E[] asArray(IntFunction<E[]> arrayFactory) {
        long size = count();
        if (size >= 2147483639) {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
        E[] result = arrayFactory.apply((int) size);
        copyInto(result, 0);
        return result;
    }

    @Override // java.util.stream.AbstractSpinedBuffer
    public void clear() {
        E[][] eArr = this.spine;
        if (eArr != null) {
            this.curChunk = eArr[0];
            int i10 = 0;
            while (true) {
                E[] eArr2 = this.curChunk;
                if (i10 >= eArr2.length) {
                    break;
                }
                eArr2[i10] = null;
                i10++;
            }
            this.spine = null;
            this.priorElementCount = null;
        } else {
            for (int i11 = 0; i11 < this.elementIndex; i11++) {
                this.curChunk[i11] = null;
            }
        }
        this.elementIndex = 0;
        this.spineIndex = 0;
    }

    @Override // java.lang.Iterable
    /* renamed from: iterator */
    public Iterator<E> iterator2() {
        return Spliterators.iterator(spliterator());
    }

    public void forEach(Consumer<? super E> consumer) {
        for (int i10 = 0; i10 < this.spineIndex; i10++) {
            for (K0 k02 : this.spine[i10]) {
                consumer.accept(k02);
            }
        }
        for (int i11 = 0; i11 < this.elementIndex; i11++) {
            consumer.accept(this.curChunk[i11]);
        }
    }

    public void accept(E e2) {
        if (this.elementIndex == this.curChunk.length) {
            inflateSpine();
            int i10 = this.spineIndex + 1;
            E[][] eArr = this.spine;
            if (i10 >= eArr.length || eArr[this.spineIndex + 1] == null) {
                increaseCapacity();
            }
            this.elementIndex = 0;
            this.spineIndex++;
            this.curChunk = this.spine[this.spineIndex];
        }
        E[] eArr2 = this.curChunk;
        int i11 = this.elementIndex;
        this.elementIndex = i11 + 1;
        eArr2[i11] = e2;
    }

    public String toString() {
        final List<E> list = new ArrayList<>();
        Objects.requireNonNull(list);
        forEach(new Consumer() { // from class: java.util.stream.SpinedBuffer$$ExternalSyntheticLambda0
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                List.this.add(obj);
            }
        });
        return "SpinedBuffer:" + list.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* renamed from: java.util.stream.SpinedBuffer$1Splitr, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public class C1Splitr implements Spliterator<E> {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        final int lastSpineElementFence;
        final int lastSpineIndex;
        E[] splChunk;
        int splElementIndex;
        int splSpineIndex;

        C1Splitr(int firstSpineIndex, int lastSpineIndex, int firstSpineElementIndex, int lastSpineElementFence) {
            this.splSpineIndex = firstSpineIndex;
            this.lastSpineIndex = lastSpineIndex;
            this.splElementIndex = firstSpineElementIndex;
            this.lastSpineElementFence = lastSpineElementFence;
            this.splChunk = SpinedBuffer.this.spine == null ? SpinedBuffer.this.curChunk : SpinedBuffer.this.spine[firstSpineIndex];
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            if (this.splSpineIndex == this.lastSpineIndex) {
                return this.lastSpineElementFence - this.splElementIndex;
            }
            return ((SpinedBuffer.this.priorElementCount[this.lastSpineIndex] + this.lastSpineElementFence) - SpinedBuffer.this.priorElementCount[this.splSpineIndex]) - this.splElementIndex;
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return SpinedBuffer.SPLITERATOR_CHARACTERISTICS;
        }

        @Override // java.util.Spliterator
        public boolean tryAdvance(Consumer<? super E> consumer) {
            Objects.requireNonNull(consumer);
            int i10 = this.splSpineIndex;
            int i11 = this.lastSpineIndex;
            if (i10 >= i11 && (i10 != i11 || this.splElementIndex >= this.lastSpineElementFence)) {
                return false;
            }
            E[] eArr = this.splChunk;
            int i12 = this.splElementIndex;
            this.splElementIndex = i12 + 1;
            consumer.accept(eArr[i12]);
            if (this.splElementIndex == this.splChunk.length) {
                this.splElementIndex = 0;
                this.splSpineIndex++;
                if (SpinedBuffer.this.spine != null && this.splSpineIndex <= this.lastSpineIndex) {
                    this.splChunk = SpinedBuffer.this.spine[this.splSpineIndex];
                }
            }
            return true;
        }

        @Override // java.util.Spliterator
        public void forEachRemaining(Consumer<? super E> consumer) {
            int i10;
            Objects.requireNonNull(consumer);
            int i11 = this.splSpineIndex;
            int i12 = this.lastSpineIndex;
            if (i11 < i12 || (i11 == i12 && this.splElementIndex < this.lastSpineElementFence)) {
                int i13 = this.splElementIndex;
                int i14 = this.splSpineIndex;
                while (true) {
                    i10 = this.lastSpineIndex;
                    if (i14 >= i10) {
                        break;
                    }
                    K0[] k0Arr = SpinedBuffer.this.spine[i14];
                    while (i13 < k0Arr.length) {
                        consumer.accept(k0Arr[i13]);
                        i13++;
                    }
                    i13 = 0;
                    i14++;
                }
                E[] eArr = this.splSpineIndex == i10 ? this.splChunk : (E[]) SpinedBuffer.this.spine[this.lastSpineIndex];
                int i15 = this.lastSpineElementFence;
                while (i13 < i15) {
                    consumer.accept(eArr[i13]);
                    i13++;
                }
                this.splSpineIndex = this.lastSpineIndex;
                this.splElementIndex = this.lastSpineElementFence;
            }
        }

        @Override // java.util.Spliterator
        public Spliterator<E> trySplit() {
            int i10 = this.splSpineIndex;
            int i11 = this.lastSpineIndex;
            if (i10 < i11) {
                SpinedBuffer spinedBuffer = SpinedBuffer.this;
                Spliterator<E> ret = new C1Splitr(i10, i11 - 1, this.splElementIndex, spinedBuffer.spine[this.lastSpineIndex - 1].length);
                this.splSpineIndex = this.lastSpineIndex;
                this.splElementIndex = 0;
                this.splChunk = SpinedBuffer.this.spine[this.splSpineIndex];
                return ret;
            }
            if (i10 != i11) {
                return null;
            }
            int i12 = this.lastSpineElementFence;
            int i13 = this.splElementIndex;
            int t2 = (i12 - i13) / 2;
            if (t2 == 0) {
                return null;
            }
            Spliterator<E> ret2 = Arrays.spliterator(this.splChunk, i13, i13 + t2);
            this.splElementIndex += t2;
            return ret2;
        }
    }

    public Spliterator<E> spliterator() {
        return new C1Splitr(0, this.spineIndex, 0, this.elementIndex);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static abstract class OfPrimitive<E, T_ARR, T_CONS> extends AbstractSpinedBuffer implements Iterable<E> {
        T_ARR curChunk;
        T_ARR[] spine;

        protected abstract void arrayForEach(T_ARR t_arr, int i10, int i11, T_CONS t_cons);

        protected abstract int arrayLength(T_ARR t_arr);

        public abstract void forEach(Consumer<? super E> consumer);

        /* renamed from: iterator */
        public abstract Iterator<E> iterator2();

        public abstract T_ARR newArray(int i10);

        protected abstract T_ARR[] newArrayArray(int i10);

        OfPrimitive(int initialCapacity) {
            super(initialCapacity);
            this.curChunk = newArray(1 << this.initialChunkPower);
        }

        OfPrimitive() {
            this.curChunk = newArray(1 << this.initialChunkPower);
        }

        protected long capacity() {
            if (this.spineIndex == 0) {
                return arrayLength(this.curChunk);
            }
            return this.priorElementCount[this.spineIndex] + arrayLength(this.spine[this.spineIndex]);
        }

        private void inflateSpine() {
            if (this.spine == null) {
                this.spine = newArrayArray(8);
                this.priorElementCount = new long[8];
                this.spine[0] = this.curChunk;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public final void ensureCapacity(long j10) {
            long capacity = capacity();
            if (j10 > capacity) {
                inflateSpine();
                int i10 = this.spineIndex;
                while (true) {
                    i10++;
                    if (j10 > capacity) {
                        T_ARR[] t_arrArr = this.spine;
                        if (i10 >= t_arrArr.length) {
                            int length = t_arrArr.length * 2;
                            this.spine = (T_ARR[]) Arrays.copyOf(t_arrArr, length);
                            this.priorElementCount = Arrays.copyOf(this.priorElementCount, length);
                        }
                        int chunkSize = chunkSize(i10);
                        this.spine[i10] = newArray(chunkSize);
                        this.priorElementCount[i10] = this.priorElementCount[i10 - 1] + arrayLength(this.spine[i10 - 1]);
                        capacity += chunkSize;
                    } else {
                        return;
                    }
                }
            }
        }

        protected void increaseCapacity() {
            ensureCapacity(capacity() + 1);
        }

        protected int chunkFor(long index) {
            if (this.spineIndex == 0) {
                if (index < this.elementIndex) {
                    return 0;
                }
                throw new IndexOutOfBoundsException(Long.toString(index));
            }
            if (index >= count()) {
                throw new IndexOutOfBoundsException(Long.toString(index));
            }
            for (int j10 = 0; j10 <= this.spineIndex; j10++) {
                if (index < this.priorElementCount[j10] + arrayLength(this.spine[j10])) {
                    return j10;
                }
            }
            throw new IndexOutOfBoundsException(Long.toString(index));
        }

        public void copyInto(T_ARR array, int offset) {
            long finalOffset = offset + count();
            if (finalOffset > arrayLength(array) || finalOffset < offset) {
                throw new IndexOutOfBoundsException("does not fit");
            }
            if (this.spineIndex == 0) {
                System.arraycopy(this.curChunk, 0, array, offset, this.elementIndex);
                return;
            }
            for (int i10 = 0; i10 < this.spineIndex; i10++) {
                T_ARR t_arr = this.spine[i10];
                System.arraycopy(t_arr, 0, array, offset, arrayLength(t_arr));
                offset += arrayLength(this.spine[i10]);
            }
            int i11 = this.elementIndex;
            if (i11 > 0) {
                System.arraycopy(this.curChunk, 0, array, offset, this.elementIndex);
            }
        }

        public T_ARR asPrimitiveArray() {
            long size = count();
            if (size >= 2147483639) {
                throw new IllegalArgumentException("Stream size exceeds max array size");
            }
            T_ARR result = newArray((int) size);
            copyInto(result, 0);
            return result;
        }

        protected void preAccept() {
            if (this.elementIndex == arrayLength(this.curChunk)) {
                inflateSpine();
                int i10 = this.spineIndex + 1;
                T_ARR[] t_arrArr = this.spine;
                if (i10 >= t_arrArr.length || t_arrArr[this.spineIndex + 1] == null) {
                    increaseCapacity();
                }
                this.elementIndex = 0;
                this.spineIndex++;
                this.curChunk = this.spine[this.spineIndex];
            }
        }

        @Override // java.util.stream.AbstractSpinedBuffer
        public void clear() {
            T_ARR[] t_arrArr = this.spine;
            if (t_arrArr != null) {
                this.curChunk = t_arrArr[0];
                this.spine = null;
                this.priorElementCount = null;
            }
            this.elementIndex = 0;
            this.spineIndex = 0;
        }

        public void forEach(T_CONS consumer) {
            for (int j10 = 0; j10 < this.spineIndex; j10++) {
                T_ARR t_arr = this.spine[j10];
                arrayForEach(t_arr, 0, arrayLength(t_arr), consumer);
            }
            arrayForEach(this.curChunk, 0, this.elementIndex, consumer);
        }

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        abstract class BaseSpliterator<T_SPLITR extends Spliterator.OfPrimitive<E, T_CONS, T_SPLITR>> implements Spliterator.OfPrimitive<E, T_CONS, T_SPLITR> {
            static final /* synthetic */ boolean $assertionsDisabled = false;
            final int lastSpineElementFence;
            final int lastSpineIndex;
            T_ARR splChunk;
            int splElementIndex;
            int splSpineIndex;

            abstract void arrayForOne(T_ARR t_arr, int i10, T_CONS t_cons);

            abstract T_SPLITR arraySpliterator(T_ARR t_arr, int i10, int i11);

            abstract T_SPLITR newSpliterator(int i10, int i11, int i12, int i13);

            BaseSpliterator(int firstSpineIndex, int lastSpineIndex, int firstSpineElementIndex, int lastSpineElementFence) {
                this.splSpineIndex = firstSpineIndex;
                this.lastSpineIndex = lastSpineIndex;
                this.splElementIndex = firstSpineElementIndex;
                this.lastSpineElementFence = lastSpineElementFence;
                this.splChunk = OfPrimitive.this.spine == null ? OfPrimitive.this.curChunk : OfPrimitive.this.spine[firstSpineIndex];
            }

            @Override // java.util.Spliterator
            public long estimateSize() {
                if (this.splSpineIndex == this.lastSpineIndex) {
                    return this.lastSpineElementFence - this.splElementIndex;
                }
                return ((OfPrimitive.this.priorElementCount[this.lastSpineIndex] + this.lastSpineElementFence) - OfPrimitive.this.priorElementCount[this.splSpineIndex]) - this.splElementIndex;
            }

            @Override // java.util.Spliterator
            public int characteristics() {
                return SpinedBuffer.SPLITERATOR_CHARACTERISTICS;
            }

            @Override // java.util.Spliterator.OfPrimitive
            public boolean tryAdvance(T_CONS consumer) {
                Objects.requireNonNull(consumer);
                int i10 = this.splSpineIndex;
                int i11 = this.lastSpineIndex;
                if (i10 >= i11 && (i10 != i11 || this.splElementIndex >= this.lastSpineElementFence)) {
                    return false;
                }
                T_ARR t_arr = this.splChunk;
                int i12 = this.splElementIndex;
                this.splElementIndex = i12 + 1;
                arrayForOne(t_arr, i12, consumer);
                if (this.splElementIndex == OfPrimitive.this.arrayLength(this.splChunk)) {
                    this.splElementIndex = 0;
                    this.splSpineIndex++;
                    if (OfPrimitive.this.spine != null && this.splSpineIndex <= this.lastSpineIndex) {
                        this.splChunk = OfPrimitive.this.spine[this.splSpineIndex];
                    }
                }
                return true;
            }

            @Override // java.util.Spliterator.OfPrimitive
            public void forEachRemaining(T_CONS consumer) {
                int i10;
                Objects.requireNonNull(consumer);
                int i11 = this.splSpineIndex;
                int i12 = this.lastSpineIndex;
                if (i11 < i12 || (i11 == i12 && this.splElementIndex < this.lastSpineElementFence)) {
                    int i13 = this.splElementIndex;
                    int sp = this.splSpineIndex;
                    while (true) {
                        i10 = this.lastSpineIndex;
                        if (sp >= i10) {
                            break;
                        }
                        T_ARR chunk = OfPrimitive.this.spine[sp];
                        OfPrimitive ofPrimitive = OfPrimitive.this;
                        ofPrimitive.arrayForEach(chunk, i13, ofPrimitive.arrayLength(chunk), consumer);
                        i13 = 0;
                        sp++;
                    }
                    int sp2 = this.splSpineIndex;
                    OfPrimitive.this.arrayForEach(sp2 == i10 ? this.splChunk : OfPrimitive.this.spine[this.lastSpineIndex], i13, this.lastSpineElementFence, consumer);
                    this.splSpineIndex = this.lastSpineIndex;
                    this.splElementIndex = this.lastSpineElementFence;
                }
            }

            @Override // java.util.Spliterator.OfPrimitive, java.util.Spliterator
            public T_SPLITR trySplit() {
                int i10 = this.splSpineIndex;
                int i11 = this.lastSpineIndex;
                if (i10 < i11) {
                    int i12 = this.splElementIndex;
                    OfPrimitive ofPrimitive = OfPrimitive.this;
                    T_SPLITR ret = newSpliterator(i10, i11 - 1, i12, ofPrimitive.arrayLength(ofPrimitive.spine[this.lastSpineIndex - 1]));
                    this.splSpineIndex = this.lastSpineIndex;
                    this.splElementIndex = 0;
                    this.splChunk = OfPrimitive.this.spine[this.splSpineIndex];
                    return ret;
                }
                if (i10 != i11) {
                    return null;
                }
                int i13 = this.lastSpineElementFence;
                int i14 = this.splElementIndex;
                int t2 = (i13 - i14) / 2;
                if (t2 == 0) {
                    return null;
                }
                T_SPLITR ret2 = arraySpliterator(this.splChunk, i14, t2);
                this.splElementIndex += t2;
                return ret2;
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class OfInt extends OfPrimitive<Integer, int[], IntConsumer> implements IntConsumer {
        @Override // java.util.stream.SpinedBuffer.OfPrimitive, java.util.stream.Node.OfPrimitive
        public /* bridge */ /* synthetic */ Object asPrimitiveArray() {
            return super.asPrimitiveArray();
        }

        @Override // java.util.stream.SpinedBuffer.OfPrimitive, java.util.stream.AbstractSpinedBuffer
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // java.util.stream.SpinedBuffer.OfPrimitive, java.util.stream.Node.OfPrimitive
        public /* bridge */ /* synthetic */ void copyInto(Object obj, int i10) {
            super.copyInto(obj, i10);
        }

        @Override // java.util.stream.AbstractSpinedBuffer
        public /* bridge */ /* synthetic */ long count() {
            return super.count();
        }

        @Override // java.util.stream.SpinedBuffer.OfPrimitive, java.util.stream.Node.OfPrimitive
        public /* bridge */ /* synthetic */ void forEach(Object obj) {
            super.forEach((OfInt) obj);
        }

        @Override // java.util.stream.AbstractSpinedBuffer
        public /* bridge */ /* synthetic */ boolean isEmpty() {
            return super.isEmpty();
        }

        public OfInt() {
        }

        public OfInt(int initialCapacity) {
            super(initialCapacity);
        }

        @Override // java.util.stream.SpinedBuffer.OfPrimitive, java.lang.Iterable
        public void forEach(Consumer<? super Integer> consumer) {
            if (consumer instanceof IntConsumer) {
                forEach((IntConsumer) consumer);
                return;
            }
            if (Tripwire.ENABLED) {
                Tripwire.trip(getClass(), "{0} calling SpinedBuffer.OfInt.forEach(Consumer)");
            }
            spliterator().forEachRemaining(consumer);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.util.stream.SpinedBuffer.OfPrimitive
        public int[][] newArrayArray(int size) {
            return new int[size];
        }

        @Override // java.util.stream.SpinedBuffer.OfPrimitive
        public int[] newArray(int size) {
            return new int[size];
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.util.stream.SpinedBuffer.OfPrimitive
        public int arrayLength(int[] array) {
            return array.length;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.util.stream.SpinedBuffer.OfPrimitive
        public void arrayForEach(int[] array, int from, int to, IntConsumer consumer) {
            for (int i10 = from; i10 < to; i10++) {
                consumer.accept(array[i10]);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void accept(int i10) {
            preAccept();
            int[] iArr = (int[]) this.curChunk;
            int i11 = this.elementIndex;
            this.elementIndex = i11 + 1;
            iArr[i11] = i10;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int get(long index) {
            int ch = chunkFor(index);
            if (this.spineIndex == 0 && ch == 0) {
                return ((int[]) this.curChunk)[(int) index];
            }
            return ((int[][]) this.spine)[ch][(int) (index - this.priorElementCount[ch])];
        }

        @Override // java.util.stream.SpinedBuffer.OfPrimitive, java.lang.Iterable
        /* renamed from: iterator */
        public PrimitiveIterator.OfInt iterator2() {
            return Spliterators.iterator(spliterator());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* renamed from: java.util.stream.SpinedBuffer$OfInt$1Splitr, reason: invalid class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        public class C1Splitr extends OfPrimitive<Integer, int[], IntConsumer>.BaseSpliterator<Spliterator.OfInt> implements Spliterator.OfInt {
            @Override // java.util.Spliterator.OfInt
            public /* bridge */ /* synthetic */ void forEachRemaining(IntConsumer intConsumer) {
                super.forEachRemaining((C1Splitr) intConsumer);
            }

            @Override // java.util.Spliterator.OfInt
            public /* bridge */ /* synthetic */ boolean tryAdvance(IntConsumer intConsumer) {
                return super.tryAdvance((C1Splitr) intConsumer);
            }

            @Override // java.util.stream.SpinedBuffer.OfPrimitive.BaseSpliterator, java.util.Spliterator.OfPrimitive, java.util.Spliterator
            public /* bridge */ /* synthetic */ Spliterator.OfInt trySplit() {
                return (Spliterator.OfInt) super.trySplit();
            }

            C1Splitr(int firstSpineIndex, int lastSpineIndex, int firstSpineElementIndex, int lastSpineElementFence) {
                super(firstSpineIndex, lastSpineIndex, firstSpineElementIndex, lastSpineElementFence);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // java.util.stream.SpinedBuffer.OfPrimitive.BaseSpliterator
            public Spliterator.OfInt newSpliterator(int firstSpineIndex, int lastSpineIndex, int firstSpineElementIndex, int lastSpineElementFence) {
                return new C1Splitr(firstSpineIndex, lastSpineIndex, firstSpineElementIndex, lastSpineElementFence);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // java.util.stream.SpinedBuffer.OfPrimitive.BaseSpliterator
            public void arrayForOne(int[] array, int index, IntConsumer consumer) {
                consumer.accept(array[index]);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // java.util.stream.SpinedBuffer.OfPrimitive.BaseSpliterator
            public Spliterator.OfInt arraySpliterator(int[] array, int offset, int len) {
                return Arrays.spliterator(array, offset, offset + len);
            }
        }

        @Override // java.lang.Iterable
        public Spliterator.OfInt spliterator() {
            return new C1Splitr(0, this.spineIndex, 0, this.elementIndex);
        }

        public String toString() {
            int[] array = (int[]) asPrimitiveArray();
            if (array.length < 200) {
                return String.format("%s[length=%d, chunks=%d]%s", getClass().getSimpleName(), Integer.valueOf(array.length), Integer.valueOf(this.spineIndex), Arrays.toString(array));
            }
            int[] array2 = Arrays.copyOf(array, 200);
            return String.format("%s[length=%d, chunks=%d]%s...", getClass().getSimpleName(), Integer.valueOf(array.length), Integer.valueOf(this.spineIndex), Arrays.toString(array2));
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class OfLong extends OfPrimitive<Long, long[], LongConsumer> implements LongConsumer {
        @Override // java.util.stream.SpinedBuffer.OfPrimitive, java.util.stream.Node.OfPrimitive
        public /* bridge */ /* synthetic */ Object asPrimitiveArray() {
            return super.asPrimitiveArray();
        }

        @Override // java.util.stream.SpinedBuffer.OfPrimitive, java.util.stream.AbstractSpinedBuffer
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // java.util.stream.SpinedBuffer.OfPrimitive, java.util.stream.Node.OfPrimitive
        public /* bridge */ /* synthetic */ void copyInto(Object obj, int i10) {
            super.copyInto(obj, i10);
        }

        @Override // java.util.stream.AbstractSpinedBuffer
        public /* bridge */ /* synthetic */ long count() {
            return super.count();
        }

        @Override // java.util.stream.SpinedBuffer.OfPrimitive, java.util.stream.Node.OfPrimitive
        public /* bridge */ /* synthetic */ void forEach(Object obj) {
            super.forEach((OfLong) obj);
        }

        @Override // java.util.stream.AbstractSpinedBuffer
        public /* bridge */ /* synthetic */ boolean isEmpty() {
            return super.isEmpty();
        }

        public OfLong() {
        }

        public OfLong(int initialCapacity) {
            super(initialCapacity);
        }

        @Override // java.util.stream.SpinedBuffer.OfPrimitive, java.lang.Iterable
        public void forEach(Consumer<? super Long> consumer) {
            if (consumer instanceof LongConsumer) {
                forEach((LongConsumer) consumer);
                return;
            }
            if (Tripwire.ENABLED) {
                Tripwire.trip(getClass(), "{0} calling SpinedBuffer.OfLong.forEach(Consumer)");
            }
            spliterator().forEachRemaining(consumer);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.util.stream.SpinedBuffer.OfPrimitive
        public long[][] newArrayArray(int size) {
            return new long[size];
        }

        @Override // java.util.stream.SpinedBuffer.OfPrimitive
        public long[] newArray(int size) {
            return new long[size];
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.util.stream.SpinedBuffer.OfPrimitive
        public int arrayLength(long[] array) {
            return array.length;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.util.stream.SpinedBuffer.OfPrimitive
        public void arrayForEach(long[] array, int from, int to, LongConsumer consumer) {
            for (int i10 = from; i10 < to; i10++) {
                consumer.accept(array[i10]);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void accept(long i10) {
            preAccept();
            long[] jArr = (long[]) this.curChunk;
            int i11 = this.elementIndex;
            this.elementIndex = i11 + 1;
            jArr[i11] = i10;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public long get(long index) {
            int ch = chunkFor(index);
            if (this.spineIndex == 0 && ch == 0) {
                return ((long[]) this.curChunk)[(int) index];
            }
            return ((long[][]) this.spine)[ch][(int) (index - this.priorElementCount[ch])];
        }

        @Override // java.util.stream.SpinedBuffer.OfPrimitive, java.lang.Iterable
        /* renamed from: iterator */
        public PrimitiveIterator.OfLong iterator2() {
            return Spliterators.iterator(spliterator());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* renamed from: java.util.stream.SpinedBuffer$OfLong$1Splitr, reason: invalid class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        public class C1Splitr extends OfPrimitive<Long, long[], LongConsumer>.BaseSpliterator<Spliterator.OfLong> implements Spliterator.OfLong {
            @Override // java.util.Spliterator.OfLong
            public /* bridge */ /* synthetic */ void forEachRemaining(LongConsumer longConsumer) {
                super.forEachRemaining((C1Splitr) longConsumer);
            }

            @Override // java.util.Spliterator.OfLong
            public /* bridge */ /* synthetic */ boolean tryAdvance(LongConsumer longConsumer) {
                return super.tryAdvance((C1Splitr) longConsumer);
            }

            @Override // java.util.stream.SpinedBuffer.OfPrimitive.BaseSpliterator, java.util.Spliterator.OfPrimitive, java.util.Spliterator
            public /* bridge */ /* synthetic */ Spliterator.OfLong trySplit() {
                return (Spliterator.OfLong) super.trySplit();
            }

            C1Splitr(int firstSpineIndex, int lastSpineIndex, int firstSpineElementIndex, int lastSpineElementFence) {
                super(firstSpineIndex, lastSpineIndex, firstSpineElementIndex, lastSpineElementFence);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // java.util.stream.SpinedBuffer.OfPrimitive.BaseSpliterator
            public Spliterator.OfLong newSpliterator(int firstSpineIndex, int lastSpineIndex, int firstSpineElementIndex, int lastSpineElementFence) {
                return new C1Splitr(firstSpineIndex, lastSpineIndex, firstSpineElementIndex, lastSpineElementFence);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // java.util.stream.SpinedBuffer.OfPrimitive.BaseSpliterator
            public void arrayForOne(long[] array, int index, LongConsumer consumer) {
                consumer.accept(array[index]);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // java.util.stream.SpinedBuffer.OfPrimitive.BaseSpliterator
            public Spliterator.OfLong arraySpliterator(long[] array, int offset, int len) {
                return Arrays.spliterator(array, offset, offset + len);
            }
        }

        @Override // java.lang.Iterable
        public Spliterator.OfLong spliterator() {
            return new C1Splitr(0, this.spineIndex, 0, this.elementIndex);
        }

        public String toString() {
            long[] array = (long[]) asPrimitiveArray();
            if (array.length < 200) {
                return String.format("%s[length=%d, chunks=%d]%s", getClass().getSimpleName(), Integer.valueOf(array.length), Integer.valueOf(this.spineIndex), Arrays.toString(array));
            }
            long[] array2 = Arrays.copyOf(array, 200);
            return String.format("%s[length=%d, chunks=%d]%s...", getClass().getSimpleName(), Integer.valueOf(array.length), Integer.valueOf(this.spineIndex), Arrays.toString(array2));
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class OfDouble extends OfPrimitive<Double, double[], DoubleConsumer> implements DoubleConsumer {
        @Override // java.util.stream.SpinedBuffer.OfPrimitive, java.util.stream.Node.OfPrimitive
        public /* bridge */ /* synthetic */ Object asPrimitiveArray() {
            return super.asPrimitiveArray();
        }

        @Override // java.util.stream.SpinedBuffer.OfPrimitive, java.util.stream.AbstractSpinedBuffer
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // java.util.stream.SpinedBuffer.OfPrimitive, java.util.stream.Node.OfPrimitive
        public /* bridge */ /* synthetic */ void copyInto(Object obj, int i10) {
            super.copyInto(obj, i10);
        }

        @Override // java.util.stream.AbstractSpinedBuffer
        public /* bridge */ /* synthetic */ long count() {
            return super.count();
        }

        @Override // java.util.stream.SpinedBuffer.OfPrimitive, java.util.stream.Node.OfPrimitive
        public /* bridge */ /* synthetic */ void forEach(Object obj) {
            super.forEach((OfDouble) obj);
        }

        @Override // java.util.stream.AbstractSpinedBuffer
        public /* bridge */ /* synthetic */ boolean isEmpty() {
            return super.isEmpty();
        }

        public OfDouble() {
        }

        public OfDouble(int initialCapacity) {
            super(initialCapacity);
        }

        @Override // java.util.stream.SpinedBuffer.OfPrimitive, java.lang.Iterable
        public void forEach(Consumer<? super Double> consumer) {
            if (consumer instanceof DoubleConsumer) {
                forEach((DoubleConsumer) consumer);
                return;
            }
            if (Tripwire.ENABLED) {
                Tripwire.trip(getClass(), "{0} calling SpinedBuffer.OfDouble.forEach(Consumer)");
            }
            spliterator().forEachRemaining(consumer);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.util.stream.SpinedBuffer.OfPrimitive
        public double[][] newArrayArray(int size) {
            return new double[size];
        }

        @Override // java.util.stream.SpinedBuffer.OfPrimitive
        public double[] newArray(int size) {
            return new double[size];
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.util.stream.SpinedBuffer.OfPrimitive
        public int arrayLength(double[] array) {
            return array.length;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.util.stream.SpinedBuffer.OfPrimitive
        public void arrayForEach(double[] array, int from, int to, DoubleConsumer consumer) {
            for (int i10 = from; i10 < to; i10++) {
                consumer.accept(array[i10]);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void accept(double i10) {
            preAccept();
            double[] dArr = (double[]) this.curChunk;
            int i11 = this.elementIndex;
            this.elementIndex = i11 + 1;
            dArr[i11] = i10;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public double get(long index) {
            int ch = chunkFor(index);
            if (this.spineIndex == 0 && ch == 0) {
                return ((double[]) this.curChunk)[(int) index];
            }
            return ((double[][]) this.spine)[ch][(int) (index - this.priorElementCount[ch])];
        }

        @Override // java.util.stream.SpinedBuffer.OfPrimitive, java.lang.Iterable
        /* renamed from: iterator */
        public PrimitiveIterator.OfDouble iterator2() {
            return Spliterators.iterator(spliterator());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* renamed from: java.util.stream.SpinedBuffer$OfDouble$1Splitr, reason: invalid class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        public class C1Splitr extends OfPrimitive<Double, double[], DoubleConsumer>.BaseSpliterator<Spliterator.OfDouble> implements Spliterator.OfDouble {
            @Override // java.util.Spliterator.OfDouble
            public /* bridge */ /* synthetic */ void forEachRemaining(DoubleConsumer doubleConsumer) {
                super.forEachRemaining((C1Splitr) doubleConsumer);
            }

            @Override // java.util.Spliterator.OfDouble
            public /* bridge */ /* synthetic */ boolean tryAdvance(DoubleConsumer doubleConsumer) {
                return super.tryAdvance((C1Splitr) doubleConsumer);
            }

            @Override // java.util.stream.SpinedBuffer.OfPrimitive.BaseSpliterator, java.util.Spliterator.OfPrimitive, java.util.Spliterator
            public /* bridge */ /* synthetic */ Spliterator.OfDouble trySplit() {
                return (Spliterator.OfDouble) super.trySplit();
            }

            C1Splitr(int firstSpineIndex, int lastSpineIndex, int firstSpineElementIndex, int lastSpineElementFence) {
                super(firstSpineIndex, lastSpineIndex, firstSpineElementIndex, lastSpineElementFence);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // java.util.stream.SpinedBuffer.OfPrimitive.BaseSpliterator
            public Spliterator.OfDouble newSpliterator(int firstSpineIndex, int lastSpineIndex, int firstSpineElementIndex, int lastSpineElementFence) {
                return new C1Splitr(firstSpineIndex, lastSpineIndex, firstSpineElementIndex, lastSpineElementFence);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // java.util.stream.SpinedBuffer.OfPrimitive.BaseSpliterator
            public void arrayForOne(double[] array, int index, DoubleConsumer consumer) {
                consumer.accept(array[index]);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // java.util.stream.SpinedBuffer.OfPrimitive.BaseSpliterator
            public Spliterator.OfDouble arraySpliterator(double[] array, int offset, int len) {
                return Arrays.spliterator(array, offset, offset + len);
            }
        }

        @Override // java.lang.Iterable
        public Spliterator.OfDouble spliterator() {
            return new C1Splitr(0, this.spineIndex, 0, this.elementIndex);
        }

        public String toString() {
            double[] array = (double[]) asPrimitiveArray();
            if (array.length < 200) {
                return String.format("%s[length=%d, chunks=%d]%s", getClass().getSimpleName(), Integer.valueOf(array.length), Integer.valueOf(this.spineIndex), Arrays.toString(array));
            }
            double[] array2 = Arrays.copyOf(array, 200);
            return String.format("%s[length=%d, chunks=%d]%s...", getClass().getSimpleName(), Integer.valueOf(array.length), Integer.valueOf(this.spineIndex), Arrays.toString(array2));
        }
    }
}
