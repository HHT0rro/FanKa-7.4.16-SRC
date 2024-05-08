package io.reactivex.internal.queue;

import io.reactivex.annotations.Nullable;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.util.Pow2;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class SpscArrayQueue<E> extends AtomicReferenceArray<E> implements SimplePlainQueue<E> {
    private static final Integer MAX_LOOK_AHEAD_STEP = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);
    private static final long serialVersionUID = -1296597691183856449L;
    public final AtomicLong consumerIndex;
    public final int lookAheadStep;
    public final int mask;
    public final AtomicLong producerIndex;
    public long producerLookAhead;

    public SpscArrayQueue(int i10) {
        super(Pow2.roundToPowerOfTwo(i10));
        this.mask = length() - 1;
        this.producerIndex = new AtomicLong();
        this.consumerIndex = new AtomicLong();
        this.lookAheadStep = Math.min(i10 / 4, MAX_LOOK_AHEAD_STEP.intValue());
    }

    public int calcElementOffset(long j10) {
        return this.mask & ((int) j10);
    }

    public int calcElementOffset(long j10, int i10) {
        return ((int) j10) & i10;
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
        return this.producerIndex.get() == this.consumerIndex.get();
    }

    public E lvElement(int i10) {
        return get(i10);
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean offer(E e2) {
        Objects.requireNonNull(e2, "Null is not a valid element");
        int i10 = this.mask;
        long j10 = this.producerIndex.get();
        int calcElementOffset = calcElementOffset(j10, i10);
        if (j10 >= this.producerLookAhead) {
            long j11 = this.lookAheadStep + j10;
            if (lvElement(calcElementOffset(j11, i10)) == null) {
                this.producerLookAhead = j11;
            } else if (lvElement(calcElementOffset) != null) {
                return false;
            }
        }
        soElement(calcElementOffset, e2);
        soProducerIndex(j10 + 1);
        return true;
    }

    @Override // io.reactivex.internal.fuseable.SimplePlainQueue, io.reactivex.internal.fuseable.SimpleQueue
    @Nullable
    public E poll() {
        long j10 = this.consumerIndex.get();
        int calcElementOffset = calcElementOffset(j10);
        E lvElement = lvElement(calcElementOffset);
        if (lvElement == null) {
            return null;
        }
        soConsumerIndex(j10 + 1);
        soElement(calcElementOffset, null);
        return lvElement;
    }

    public void soConsumerIndex(long j10) {
        this.consumerIndex.lazySet(j10);
    }

    public void soElement(int i10, E e2) {
        lazySet(i10, e2);
    }

    public void soProducerIndex(long j10) {
        this.producerIndex.lazySet(j10);
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean offer(E e2, E e10) {
        return offer(e2) && offer(e10);
    }
}
