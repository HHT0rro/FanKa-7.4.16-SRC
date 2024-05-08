package io.reactivex.internal.queue;

import io.reactivex.annotations.Nullable;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.util.Pow2;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class SpscLinkedArrayQueue<T> implements SimplePlainQueue<T> {
    public AtomicReferenceArray<Object> consumerBuffer;
    public final int consumerMask;
    public AtomicReferenceArray<Object> producerBuffer;
    public long producerLookAhead;
    public int producerLookAheadStep;
    public final int producerMask;
    public static final int MAX_LOOK_AHEAD_STEP = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object HAS_NEXT = new Object();
    public final AtomicLong producerIndex = new AtomicLong();
    public final AtomicLong consumerIndex = new AtomicLong();

    public SpscLinkedArrayQueue(int i10) {
        int roundToPowerOfTwo = Pow2.roundToPowerOfTwo(Math.max(8, i10));
        int i11 = roundToPowerOfTwo - 1;
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(roundToPowerOfTwo + 1);
        this.producerBuffer = atomicReferenceArray;
        this.producerMask = i11;
        adjustLookAheadStep(roundToPowerOfTwo);
        this.consumerBuffer = atomicReferenceArray;
        this.consumerMask = i11;
        this.producerLookAhead = i11 - 1;
        soProducerIndex(0L);
    }

    private void adjustLookAheadStep(int i10) {
        this.producerLookAheadStep = Math.min(i10 / 4, MAX_LOOK_AHEAD_STEP);
    }

    private static int calcDirectOffset(int i10) {
        return i10;
    }

    private static int calcWrappedOffset(long j10, int i10) {
        return calcDirectOffset(((int) j10) & i10);
    }

    private long lpConsumerIndex() {
        return this.consumerIndex.get();
    }

    private long lpProducerIndex() {
        return this.producerIndex.get();
    }

    private long lvConsumerIndex() {
        return this.consumerIndex.get();
    }

    private static <E> Object lvElement(AtomicReferenceArray<Object> atomicReferenceArray, int i10) {
        return atomicReferenceArray.get(i10);
    }

    private AtomicReferenceArray<Object> lvNextBufferAndUnlink(AtomicReferenceArray<Object> atomicReferenceArray, int i10) {
        int calcDirectOffset = calcDirectOffset(i10);
        AtomicReferenceArray<Object> atomicReferenceArray2 = (AtomicReferenceArray) lvElement(atomicReferenceArray, calcDirectOffset);
        soElement(atomicReferenceArray, calcDirectOffset, null);
        return atomicReferenceArray2;
    }

    private long lvProducerIndex() {
        return this.producerIndex.get();
    }

    private T newBufferPeek(AtomicReferenceArray<Object> atomicReferenceArray, long j10, int i10) {
        this.consumerBuffer = atomicReferenceArray;
        return (T) lvElement(atomicReferenceArray, calcWrappedOffset(j10, i10));
    }

    private T newBufferPoll(AtomicReferenceArray<Object> atomicReferenceArray, long j10, int i10) {
        this.consumerBuffer = atomicReferenceArray;
        int calcWrappedOffset = calcWrappedOffset(j10, i10);
        T t2 = (T) lvElement(atomicReferenceArray, calcWrappedOffset);
        if (t2 != null) {
            soElement(atomicReferenceArray, calcWrappedOffset, null);
            soConsumerIndex(j10 + 1);
        }
        return t2;
    }

    private void resize(AtomicReferenceArray<Object> atomicReferenceArray, long j10, int i10, T t2, long j11) {
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.producerBuffer = atomicReferenceArray2;
        this.producerLookAhead = (j11 + j10) - 1;
        soElement(atomicReferenceArray2, i10, t2);
        soNext(atomicReferenceArray, atomicReferenceArray2);
        soElement(atomicReferenceArray, i10, HAS_NEXT);
        soProducerIndex(j10 + 1);
    }

    private void soConsumerIndex(long j10) {
        this.consumerIndex.lazySet(j10);
    }

    private static void soElement(AtomicReferenceArray<Object> atomicReferenceArray, int i10, Object obj) {
        atomicReferenceArray.lazySet(i10, obj);
    }

    private void soNext(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        soElement(atomicReferenceArray, calcDirectOffset(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    private void soProducerIndex(long j10) {
        this.producerIndex.lazySet(j10);
    }

    private boolean writeToQueue(AtomicReferenceArray<Object> atomicReferenceArray, T t2, long j10, int i10) {
        soElement(atomicReferenceArray, i10, t2);
        soProducerIndex(j10 + 1);
        return true;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean isEmpty() {
        return lvProducerIndex() == lvConsumerIndex();
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean offer(T t2) {
        Objects.requireNonNull(t2, "Null is not a valid element");
        AtomicReferenceArray<Object> atomicReferenceArray = this.producerBuffer;
        long lpProducerIndex = lpProducerIndex();
        int i10 = this.producerMask;
        int calcWrappedOffset = calcWrappedOffset(lpProducerIndex, i10);
        if (lpProducerIndex < this.producerLookAhead) {
            return writeToQueue(atomicReferenceArray, t2, lpProducerIndex, calcWrappedOffset);
        }
        long j10 = this.producerLookAheadStep + lpProducerIndex;
        if (lvElement(atomicReferenceArray, calcWrappedOffset(j10, i10)) == null) {
            this.producerLookAhead = j10 - 1;
            return writeToQueue(atomicReferenceArray, t2, lpProducerIndex, calcWrappedOffset);
        }
        if (lvElement(atomicReferenceArray, calcWrappedOffset(1 + lpProducerIndex, i10)) == null) {
            return writeToQueue(atomicReferenceArray, t2, lpProducerIndex, calcWrappedOffset);
        }
        resize(atomicReferenceArray, lpProducerIndex, calcWrappedOffset, t2, i10);
        return true;
    }

    public T peek() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.consumerBuffer;
        long lpConsumerIndex = lpConsumerIndex();
        int i10 = this.consumerMask;
        T t2 = (T) lvElement(atomicReferenceArray, calcWrappedOffset(lpConsumerIndex, i10));
        return t2 == HAS_NEXT ? newBufferPeek(lvNextBufferAndUnlink(atomicReferenceArray, i10 + 1), lpConsumerIndex, i10) : t2;
    }

    @Override // io.reactivex.internal.fuseable.SimplePlainQueue, io.reactivex.internal.fuseable.SimpleQueue
    @Nullable
    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.consumerBuffer;
        long lpConsumerIndex = lpConsumerIndex();
        int i10 = this.consumerMask;
        int calcWrappedOffset = calcWrappedOffset(lpConsumerIndex, i10);
        T t2 = (T) lvElement(atomicReferenceArray, calcWrappedOffset);
        boolean z10 = t2 == HAS_NEXT;
        if (t2 == null || z10) {
            if (z10) {
                return newBufferPoll(lvNextBufferAndUnlink(atomicReferenceArray, i10 + 1), lpConsumerIndex, i10);
            }
            return null;
        }
        soElement(atomicReferenceArray, calcWrappedOffset, null);
        soConsumerIndex(lpConsumerIndex + 1);
        return t2;
    }

    public int size() {
        long lvConsumerIndex = lvConsumerIndex();
        while (true) {
            long lvProducerIndex = lvProducerIndex();
            long lvConsumerIndex2 = lvConsumerIndex();
            if (lvConsumerIndex == lvConsumerIndex2) {
                return (int) (lvProducerIndex - lvConsumerIndex2);
            }
            lvConsumerIndex = lvConsumerIndex2;
        }
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean offer(T t2, T t10) {
        AtomicReferenceArray<Object> atomicReferenceArray = this.producerBuffer;
        long lvProducerIndex = lvProducerIndex();
        int i10 = this.producerMask;
        long j10 = 2 + lvProducerIndex;
        if (lvElement(atomicReferenceArray, calcWrappedOffset(j10, i10)) == null) {
            int calcWrappedOffset = calcWrappedOffset(lvProducerIndex, i10);
            soElement(atomicReferenceArray, calcWrappedOffset + 1, t10);
            soElement(atomicReferenceArray, calcWrappedOffset, t2);
            soProducerIndex(j10);
            return true;
        }
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.producerBuffer = atomicReferenceArray2;
        int calcWrappedOffset2 = calcWrappedOffset(lvProducerIndex, i10);
        soElement(atomicReferenceArray2, calcWrappedOffset2 + 1, t10);
        soElement(atomicReferenceArray2, calcWrappedOffset2, t2);
        soNext(atomicReferenceArray, atomicReferenceArray2);
        soElement(atomicReferenceArray, calcWrappedOffset2, HAS_NEXT);
        soProducerIndex(j10);
        return true;
    }
}
