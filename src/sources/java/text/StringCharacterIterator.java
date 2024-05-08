package java.text;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class StringCharacterIterator implements CharacterIterator {
    private int begin;
    private int end;
    private int pos;
    private String text;

    public StringCharacterIterator(String text) {
        this(text, 0);
    }

    public StringCharacterIterator(String text, int pos) {
        this(text, 0, text.length(), pos);
    }

    public StringCharacterIterator(String text, int begin, int end, int pos) {
        if (text == null) {
            throw new NullPointerException();
        }
        this.text = text;
        if (begin < 0 || begin > end || end > text.length()) {
            throw new IllegalArgumentException("Invalid substring range");
        }
        if (pos < begin || pos > end) {
            throw new IllegalArgumentException("Invalid position");
        }
        this.begin = begin;
        this.end = end;
        this.pos = pos;
    }

    public void setText(String text) {
        if (text == null) {
            throw new NullPointerException();
        }
        this.text = text;
        this.begin = 0;
        this.end = text.length();
        this.pos = 0;
    }

    @Override // java.text.CharacterIterator
    public char first() {
        this.pos = this.begin;
        return current();
    }

    @Override // java.text.CharacterIterator
    public char last() {
        int i10 = this.end;
        if (i10 != this.begin) {
            this.pos = i10 - 1;
        } else {
            this.pos = i10;
        }
        return current();
    }

    @Override // java.text.CharacterIterator
    public char setIndex(int p10) {
        if (p10 < this.begin || p10 > this.end) {
            throw new IllegalArgumentException("Invalid index");
        }
        this.pos = p10;
        return current();
    }

    @Override // java.text.CharacterIterator
    public char current() {
        int i10 = this.pos;
        if (i10 >= this.begin && i10 < this.end) {
            return this.text.charAt(i10);
        }
        return (char) 65535;
    }

    @Override // java.text.CharacterIterator
    public char next() {
        int i10 = this.pos;
        int i11 = this.end;
        if (i10 < i11 - 1) {
            int i12 = i10 + 1;
            this.pos = i12;
            return this.text.charAt(i12);
        }
        this.pos = i11;
        return (char) 65535;
    }

    @Override // java.text.CharacterIterator
    public char previous() {
        int i10 = this.pos;
        if (i10 > this.begin) {
            int i11 = i10 - 1;
            this.pos = i11;
            return this.text.charAt(i11);
        }
        return (char) 65535;
    }

    @Override // java.text.CharacterIterator
    public int getBeginIndex() {
        return this.begin;
    }

    @Override // java.text.CharacterIterator
    public int getEndIndex() {
        return this.end;
    }

    @Override // java.text.CharacterIterator
    public int getIndex() {
        return this.pos;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StringCharacterIterator)) {
            return false;
        }
        StringCharacterIterator that = (StringCharacterIterator) obj;
        return hashCode() == that.hashCode() && this.text.equals(that.text) && this.pos == that.pos && this.begin == that.begin && this.end == that.end;
    }

    public int hashCode() {
        return ((this.text.hashCode() ^ this.pos) ^ this.begin) ^ this.end;
    }

    @Override // java.text.CharacterIterator
    public Object clone() {
        try {
            StringCharacterIterator other = (StringCharacterIterator) super.clone();
            return other;
        } catch (CloneNotSupportedException e2) {
            throw new InternalError(e2);
        }
    }
}
