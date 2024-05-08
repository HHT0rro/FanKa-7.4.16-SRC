package org.apache.commons.lang3;

import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class CharRange implements Iterable<Character>, Serializable {
    private static final long serialVersionUID = 8270183163158333422L;
    private final char end;
    private transient String iToString;
    private final boolean negated;
    private final char start;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class CharacterIterator implements Iterator<Character> {
        private char current;
        private boolean hasNext;
        private final CharRange range;

        private void prepareNext() {
            if (this.range.negated) {
                char c4 = this.current;
                if (c4 == 65535) {
                    this.hasNext = false;
                    return;
                }
                if (c4 + 1 == this.range.start) {
                    if (this.range.end == 65535) {
                        this.hasNext = false;
                        return;
                    } else {
                        this.current = (char) (this.range.end + 1);
                        return;
                    }
                }
                this.current = (char) (this.current + 1);
                return;
            }
            if (this.current < this.range.end) {
                this.current = (char) (this.current + 1);
            } else {
                this.hasNext = false;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.hasNext;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        private CharacterIterator(CharRange charRange) {
            this.range = charRange;
            this.hasNext = true;
            if (charRange.negated) {
                if (charRange.start == 0) {
                    if (charRange.end == 65535) {
                        this.hasNext = false;
                        return;
                    } else {
                        this.current = (char) (charRange.end + 1);
                        return;
                    }
                }
                this.current = (char) 0;
                return;
            }
            this.current = charRange.start;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public Character next() {
            if (this.hasNext) {
                char c4 = this.current;
                prepareNext();
                return Character.valueOf(c4);
            }
            throw new NoSuchElementException();
        }
    }

    private CharRange(char c4, char c10, boolean z10) {
        if (c4 > c10) {
            c10 = c4;
            c4 = c10;
        }
        this.start = c4;
        this.end = c10;
        this.negated = z10;
    }

    public static CharRange is(char c4) {
        return new CharRange(c4, c4, false);
    }

    public static CharRange isIn(char c4, char c10) {
        return new CharRange(c4, c10, false);
    }

    public static CharRange isNot(char c4) {
        return new CharRange(c4, c4, true);
    }

    public static CharRange isNotIn(char c4, char c10) {
        return new CharRange(c4, c10, true);
    }

    public boolean contains(char c4) {
        return (c4 >= this.start && c4 <= this.end) != this.negated;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CharRange)) {
            return false;
        }
        CharRange charRange = (CharRange) obj;
        return this.start == charRange.start && this.end == charRange.end && this.negated == charRange.negated;
    }

    public char getEnd() {
        return this.end;
    }

    public char getStart() {
        return this.start;
    }

    public int hashCode() {
        return this.start + 'S' + (this.end * 7) + (this.negated ? 1 : 0);
    }

    public boolean isNegated() {
        return this.negated;
    }

    @Override // java.lang.Iterable
    /* renamed from: iterator */
    public Iterator<Character> iterator2() {
        return new CharacterIterator();
    }

    public String toString() {
        if (this.iToString == null) {
            StringBuilder sb2 = new StringBuilder(4);
            if (isNegated()) {
                sb2.append('^');
            }
            sb2.append(this.start);
            if (this.start != this.end) {
                sb2.append('-');
                sb2.append(this.end);
            }
            this.iToString = sb2.toString();
        }
        return this.iToString;
    }

    public boolean contains(CharRange charRange) {
        Validate.isTrue(charRange != null, "The Range must not be null", new Object[0]);
        return this.negated ? charRange.negated ? this.start >= charRange.start && this.end <= charRange.end : charRange.end < this.start || charRange.start > this.end : charRange.negated ? this.start == 0 && this.end == 65535 : this.start <= charRange.start && this.end >= charRange.end;
    }
}
