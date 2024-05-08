package java.nio;

import java.io.IOException;
import java.util.Spliterator;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.StreamSupport;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class CharBuffer extends Buffer implements Comparable<CharBuffer>, Appendable, CharSequence, Readable {

    /* renamed from: hb, reason: collision with root package name */
    final char[] f50378hb;
    boolean isReadOnly;
    final int offset;

    public abstract CharBuffer asReadOnlyBuffer();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract ByteOrder charRegionOrder();

    @Override // java.nio.Buffer
    public /* bridge */ /* synthetic */ CharBuffer clear() {
        return (CharBuffer) clear();
    }

    public abstract CharBuffer compact();

    @Override // java.nio.Buffer
    public abstract CharBuffer duplicate();

    @Override // java.nio.Buffer
    public /* bridge */ /* synthetic */ CharBuffer flip() {
        return (CharBuffer) flip();
    }

    public abstract char get();

    public abstract char get(int i10);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract char getUnchecked(int i10);

    @Override // java.nio.Buffer
    public abstract boolean isDirect();

    @Override // java.nio.Buffer
    public /* bridge */ /* synthetic */ CharBuffer limit(int i10) {
        return (CharBuffer) limit(i10);
    }

    @Override // java.nio.Buffer
    public /* bridge */ /* synthetic */ CharBuffer mark() {
        return (CharBuffer) mark();
    }

    public abstract ByteOrder order();

    @Override // java.nio.Buffer
    public /* bridge */ /* synthetic */ CharBuffer position(int i10) {
        return (CharBuffer) position(i10);
    }

    public abstract CharBuffer put(char c4);

    public abstract CharBuffer put(int i10, char c4);

    @Override // java.nio.Buffer
    public /* bridge */ /* synthetic */ CharBuffer reset() {
        return (CharBuffer) reset();
    }

    @Override // java.nio.Buffer
    public /* bridge */ /* synthetic */ CharBuffer rewind() {
        return (CharBuffer) rewind();
    }

    @Override // java.nio.Buffer
    public abstract CharBuffer slice();

    @Override // java.nio.Buffer
    public abstract CharBuffer slice(int i10, int i11);

    @Override // java.lang.CharSequence
    public abstract CharBuffer subSequence(int i10, int i11);

    abstract String toString(int i10, int i11);

    /* JADX INFO: Access modifiers changed from: package-private */
    public CharBuffer(int mark, int pos, int lim, int cap, char[] hb2, int offset) {
        super(mark, pos, lim, cap, 1);
        this.f50378hb = hb2;
        this.offset = offset;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CharBuffer(int mark, int pos, int lim, int cap) {
        this(mark, pos, lim, cap, null, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // java.nio.Buffer
    public Object base() {
        return this.f50378hb;
    }

    public static CharBuffer allocate(int capacity) {
        if (capacity < 0) {
            throw createCapacityException(capacity);
        }
        return new HeapCharBuffer(capacity, capacity);
    }

    public static CharBuffer wrap(char[] array, int offset, int length) {
        try {
            return new HeapCharBuffer(array, offset, length);
        } catch (IllegalArgumentException e2) {
            throw new IndexOutOfBoundsException();
        }
    }

    public static CharBuffer wrap(char[] array) {
        return wrap(array, 0, array.length);
    }

    @Override // java.lang.Readable
    public int read(CharBuffer target) throws IOException {
        int targetRemaining = target.remaining();
        int remaining = remaining();
        if (remaining == 0) {
            return -1;
        }
        int n10 = Math.min(remaining, targetRemaining);
        int limit = limit();
        if (targetRemaining < remaining) {
            limit(position() + n10);
        }
        if (n10 > 0) {
            try {
                target.put(this);
            } finally {
                limit(limit);
            }
        }
        return n10;
    }

    public static CharBuffer wrap(CharSequence csq, int start, int end) {
        try {
            return new StringCharBuffer(csq, start, end);
        } catch (IllegalArgumentException e2) {
            throw new IndexOutOfBoundsException();
        }
    }

    public static CharBuffer wrap(CharSequence csq) {
        return wrap(csq, 0, csq.length());
    }

    public CharBuffer get(char[] dst, int offset, int length) {
        checkBounds(offset, length, dst.length);
        if (length > remaining()) {
            throw new BufferUnderflowException();
        }
        int end = offset + length;
        for (int i10 = offset; i10 < end; i10++) {
            dst[i10] = get();
        }
        return this;
    }

    public CharBuffer get(char[] dst) {
        return get(dst, 0, dst.length);
    }

    public CharBuffer put(CharBuffer src) {
        if (src == this) {
            throw createSameBufferException();
        }
        if (isReadOnly()) {
            throw new ReadOnlyBufferException();
        }
        int n10 = src.remaining();
        if (n10 > remaining()) {
            throw new BufferOverflowException();
        }
        for (int i10 = 0; i10 < n10; i10++) {
            put(src.get());
        }
        return this;
    }

    public CharBuffer put(char[] src, int offset, int length) {
        checkBounds(offset, length, src.length);
        if (length > remaining()) {
            throw new BufferOverflowException();
        }
        int end = offset + length;
        for (int i10 = offset; i10 < end; i10++) {
            put(src[i10]);
        }
        return this;
    }

    public final CharBuffer put(char[] src) {
        return put(src, 0, src.length);
    }

    public CharBuffer put(String src, int start, int end) {
        checkBounds(start, end - start, src.length());
        if (start == end) {
            return this;
        }
        if (isReadOnly()) {
            throw new ReadOnlyBufferException();
        }
        if (end - start > remaining()) {
            throw new BufferOverflowException();
        }
        for (int i10 = start; i10 < end; i10++) {
            put(src.charAt(i10));
        }
        return this;
    }

    public final CharBuffer put(String src) {
        return put(src, 0, src.length());
    }

    @Override // java.nio.Buffer
    public final boolean hasArray() {
        return (this.f50378hb == null || this.isReadOnly) ? false : true;
    }

    @Override // java.nio.Buffer
    public final char[] array() {
        char[] cArr = this.f50378hb;
        if (cArr == null) {
            throw new UnsupportedOperationException();
        }
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        return cArr;
    }

    @Override // java.nio.Buffer
    public final int arrayOffset() {
        if (this.f50378hb == null) {
            throw new UnsupportedOperationException();
        }
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        return this.offset;
    }

    @Override // java.nio.Buffer
    public Buffer position(int newPosition) {
        return super.position(newPosition);
    }

    @Override // java.nio.Buffer
    public Buffer limit(int newLimit) {
        return super.limit(newLimit);
    }

    @Override // java.nio.Buffer
    public Buffer mark() {
        return super.mark();
    }

    @Override // java.nio.Buffer
    public Buffer reset() {
        return super.reset();
    }

    @Override // java.nio.Buffer
    public Buffer clear() {
        return super.clear();
    }

    @Override // java.nio.Buffer
    public Buffer flip() {
        return super.flip();
    }

    @Override // java.nio.Buffer
    public Buffer rewind() {
        return super.rewind();
    }

    public int hashCode() {
        int h10 = 1;
        int p10 = position();
        for (int i10 = limit() - 1; i10 >= p10; i10--) {
            h10 = (h10 * 31) + get(i10);
        }
        return h10;
    }

    public boolean equals(Object ob2) {
        if (this == ob2) {
            return true;
        }
        if (!(ob2 instanceof CharBuffer)) {
            return false;
        }
        CharBuffer that = (CharBuffer) ob2;
        if (remaining() != that.remaining()) {
            return false;
        }
        int p10 = position();
        int i10 = limit() - 1;
        int j10 = that.limit() - 1;
        while (i10 >= p10) {
            if (!equals(get(i10), that.get(j10))) {
                return false;
            }
            i10--;
            j10--;
        }
        return true;
    }

    private static boolean equals(char x10, char y10) {
        return x10 == y10;
    }

    @Override // java.lang.Comparable
    public int compareTo(CharBuffer that) {
        int n10 = position() + Math.min(remaining(), that.remaining());
        int i10 = position();
        int j10 = that.position();
        while (i10 < n10) {
            int cmp = compare(get(i10), that.get(j10));
            if (cmp == 0) {
                i10++;
                j10++;
            } else {
                return cmp;
            }
        }
        int i11 = remaining();
        return i11 - that.remaining();
    }

    private static int compare(char x10, char y10) {
        return Character.compare(x10, y10);
    }

    public int mismatch(CharBuffer that) {
        int thisPos = position();
        int thisRem = limit() - thisPos;
        int thatPos = that.position();
        int thatRem = that.limit() - thatPos;
        int length = Math.min(thisRem, thatRem);
        if (length < 0) {
            return -1;
        }
        int r10 = BufferMismatch.mismatch(this, thisPos, that, thatPos, length);
        return (r10 != -1 || thisRem == thatRem) ? r10 : length;
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return toString(position(), limit());
    }

    @Override // java.lang.CharSequence
    public final int length() {
        return remaining();
    }

    public final boolean isEmpty() {
        return remaining() == 0;
    }

    @Override // java.lang.CharSequence
    public final char charAt(int index) {
        return get(position() + checkIndex(index, 1));
    }

    @Override // java.lang.Appendable
    public CharBuffer append(CharSequence csq) {
        if (csq == null) {
            return put("null");
        }
        return put(csq.toString());
    }

    @Override // java.lang.Appendable
    public CharBuffer append(CharSequence csq, int start, int end) {
        CharSequence cs = csq == null ? "null" : csq;
        return put(cs.subSequence(start, end).toString());
    }

    @Override // java.lang.Appendable
    public CharBuffer append(char c4) {
        return put(c4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Spliterator.OfInt lambda$chars$0() {
        return new CharBufferSpliterator(this);
    }

    @Override // java.lang.CharSequence
    public IntStream chars() {
        return StreamSupport.intStream(new Supplier() { // from class: java.nio.CharBuffer$$ExternalSyntheticLambda0
            @Override // java.util.function.Supplier
            public final Object get() {
                Spliterator.OfInt lambda$chars$0;
                lambda$chars$0 = CharBuffer.this.lambda$chars$0();
                return lambda$chars$0;
            }
        }, 16464, false);
    }
}
