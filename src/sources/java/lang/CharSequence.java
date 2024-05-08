package java.lang;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.PrimitiveIterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.IntConsumer;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.StreamSupport;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface CharSequence {
    char charAt(int i10);

    int length();

    CharSequence subSequence(int i10, int i11);

    String toString();

    default IntStream chars() {
        return StreamSupport.intStream(new Supplier() { // from class: java.lang.CharSequence$$ExternalSyntheticLambda1
            @Override // java.util.function.Supplier
            public final Object get() {
                Spliterator.OfInt lambda$chars$0;
                lambda$chars$0 = CharSequence.this.lambda$chars$0();
                return lambda$chars$0;
            }
        }, 16464, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* synthetic */ default Spliterator.OfInt lambda$chars$0() {
        return Spliterators.spliterator(new PrimitiveIterator.OfInt() { // from class: java.lang.CharSequence.1CharIterator
            int cur = 0;

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.cur < CharSequence.this.length();
            }

            @Override // java.util.PrimitiveIterator.OfInt
            public int nextInt() {
                if (hasNext()) {
                    CharSequence charSequence = CharSequence.this;
                    int i10 = this.cur;
                    this.cur = i10 + 1;
                    return charSequence.charAt(i10);
                }
                throw new NoSuchElementException();
            }

            @Override // java.util.PrimitiveIterator.OfInt, java.util.PrimitiveIterator
            public void forEachRemaining(IntConsumer block) {
                while (this.cur < CharSequence.this.length()) {
                    block.accept(CharSequence.this.charAt(this.cur));
                    this.cur++;
                }
            }
        }, length(), 16);
    }

    default IntStream codePoints() {
        return StreamSupport.intStream(new Supplier() { // from class: java.lang.CharSequence$$ExternalSyntheticLambda0
            @Override // java.util.function.Supplier
            public final Object get() {
                Spliterator.OfInt lambda$codePoints$1;
                lambda$codePoints$1 = CharSequence.this.lambda$codePoints$1();
                return lambda$codePoints$1;
            }
        }, 16, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* synthetic */ default Spliterator.OfInt lambda$codePoints$1() {
        return Spliterators.spliteratorUnknownSize(new PrimitiveIterator.OfInt() { // from class: java.lang.CharSequence.1CodePointIterator
            int cur = 0;

            @Override // java.util.PrimitiveIterator.OfInt, java.util.PrimitiveIterator
            public void forEachRemaining(IntConsumer block) {
                int i10;
                Throwable th;
                int length = CharSequence.this.length();
                int i11 = this.cur;
                while (i11 < length) {
                    try {
                        i10 = i11 + 1;
                    } catch (Throwable th2) {
                        i10 = i11;
                        th = th2;
                    }
                    try {
                        char c12 = CharSequence.this.charAt(i11);
                        if (Character.isHighSurrogate(c12) && i10 < length) {
                            char c22 = CharSequence.this.charAt(i10);
                            if (Character.isLowSurrogate(c22)) {
                                block.accept(Character.toCodePoint(c12, c22));
                                i11 = i10 + 1;
                            } else {
                                block.accept(c12);
                                i11 = i10;
                            }
                        }
                        block.accept(c12);
                        i11 = i10;
                    } catch (Throwable th3) {
                        th = th3;
                        this.cur = i10;
                        throw th;
                    }
                }
                this.cur = i11;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.cur < CharSequence.this.length();
            }

            @Override // java.util.PrimitiveIterator.OfInt
            public int nextInt() {
                int i10;
                int length = CharSequence.this.length();
                int i11 = this.cur;
                if (i11 >= length) {
                    throw new NoSuchElementException();
                }
                CharSequence charSequence = CharSequence.this;
                this.cur = i11 + 1;
                char c12 = charSequence.charAt(i11);
                if (Character.isHighSurrogate(c12) && (i10 = this.cur) < length) {
                    char c22 = CharSequence.this.charAt(i10);
                    if (Character.isLowSurrogate(c22)) {
                        this.cur++;
                        return Character.toCodePoint(c12, c22);
                    }
                }
                return c12;
            }
        }, 16);
    }

    static int compare(CharSequence cs1, CharSequence cs2) {
        if (Objects.requireNonNull(cs1) == Objects.requireNonNull(cs2)) {
            return 0;
        }
        if (cs1.getClass() == cs2.getClass() && (cs1 instanceof Comparable)) {
            return ((Comparable) cs1).compareTo(cs2);
        }
        int len = Math.min(cs1.length(), cs2.length());
        for (int i10 = 0; i10 < len; i10++) {
            char a10 = cs1.charAt(i10);
            char b4 = cs2.charAt(i10);
            if (a10 != b4) {
                return a10 - b4;
            }
        }
        int i11 = cs1.length();
        return i11 - cs2.length();
    }
}
