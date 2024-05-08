package java.nio;

import java.util.Spliterator;
import java.util.function.IntConsumer;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class CharBufferSpliterator implements Spliterator.OfInt {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final CharBuffer buffer;
    private int index;
    private final int limit;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CharBufferSpliterator(CharBuffer buffer) {
        this(buffer, buffer.position(), buffer.limit());
    }

    CharBufferSpliterator(CharBuffer buffer, int origin, int limit) {
        this.buffer = buffer;
        this.index = origin <= limit ? origin : limit;
        this.limit = limit;
    }

    @Override // java.util.Spliterator.OfInt, java.util.Spliterator.OfPrimitive, java.util.Spliterator
    public Spliterator.OfInt trySplit() {
        int lo = this.index;
        int mid = (this.limit + lo) >>> 1;
        if (lo >= mid) {
            return null;
        }
        CharBuffer charBuffer = this.buffer;
        this.index = mid;
        return new CharBufferSpliterator(charBuffer, lo, mid);
    }

    @Override // java.util.Spliterator.OfInt, java.util.Spliterator.OfPrimitive
    public void forEachRemaining(IntConsumer action) {
        if (action == null) {
            throw new NullPointerException();
        }
        CharBuffer cb2 = this.buffer;
        int hi = this.limit;
        this.index = hi;
        for (int i10 = this.index; i10 < hi; i10++) {
            action.accept(cb2.getUnchecked(i10));
        }
    }

    @Override // java.util.Spliterator.OfInt, java.util.Spliterator.OfPrimitive
    public boolean tryAdvance(IntConsumer action) {
        if (action == null) {
            throw new NullPointerException();
        }
        int i10 = this.index;
        if (i10 >= 0 && i10 < this.limit) {
            CharBuffer charBuffer = this.buffer;
            this.index = i10 + 1;
            action.accept(charBuffer.getUnchecked(i10));
            return true;
        }
        return false;
    }

    @Override // java.util.Spliterator
    public long estimateSize() {
        return this.limit - this.index;
    }

    @Override // java.util.Spliterator
    public int characteristics() {
        return 16464;
    }
}
