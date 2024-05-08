package java.util;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class StringJoiner {
    private final String delimiter;
    private String[] elts;
    private String emptyValue;
    private int len;
    private final String prefix;
    private int size;
    private final String suffix;

    public StringJoiner(CharSequence delimiter) {
        this(delimiter, "", "");
    }

    public StringJoiner(CharSequence delimiter, CharSequence prefix, CharSequence suffix) {
        Objects.requireNonNull(prefix, "The prefix must not be null");
        Objects.requireNonNull(delimiter, "The delimiter must not be null");
        Objects.requireNonNull(suffix, "The suffix must not be null");
        this.prefix = prefix.toString();
        this.delimiter = delimiter.toString();
        this.suffix = suffix.toString();
    }

    public StringJoiner setEmptyValue(CharSequence emptyValue) {
        this.emptyValue = ((CharSequence) Objects.requireNonNull(emptyValue, "The empty value must not be null")).toString();
        return this;
    }

    private static int getChars(String s2, char[] chars, int start) {
        int len = s2.length();
        s2.getChars(0, len, chars, start);
        return len;
    }

    public String toString() {
        String str;
        String[] elts = this.elts;
        if (elts == null && (str = this.emptyValue) != null) {
            return str;
        }
        int size = this.size;
        int addLen = this.prefix.length() + this.suffix.length();
        if (addLen == 0) {
            compactElts();
            return size == 0 ? "" : elts[0];
        }
        String delimiter = this.delimiter;
        char[] chars = new char[this.len + addLen];
        int k10 = getChars(this.prefix, chars, 0);
        if (size > 0) {
            k10 += getChars(elts[0], chars, k10);
            for (int i10 = 1; i10 < size; i10++) {
                int k11 = k10 + getChars(delimiter, chars, k10);
                k10 = k11 + getChars(elts[i10], chars, k11);
            }
        }
        int chars2 = k10 + getChars(this.suffix, chars, k10);
        return new String(chars);
    }

    public StringJoiner add(CharSequence newElement) {
        String elt = String.valueOf(newElement);
        String[] strArr = this.elts;
        if (strArr == null) {
            this.elts = new String[8];
        } else {
            int i10 = this.size;
            if (i10 == strArr.length) {
                this.elts = (String[]) Arrays.copyOf(strArr, i10 * 2);
            }
            this.len += this.delimiter.length();
        }
        this.len += elt.length();
        String[] strArr2 = this.elts;
        int i11 = this.size;
        this.size = i11 + 1;
        strArr2[i11] = elt;
        return this;
    }

    public StringJoiner merge(StringJoiner other) {
        Objects.requireNonNull(other);
        if (other.elts == null) {
            return this;
        }
        other.compactElts();
        return add(other.elts[0]);
    }

    private void compactElts() {
        String[] strArr;
        if (this.size > 1) {
            char[] chars = new char[this.len];
            int i10 = 1;
            int k10 = getChars(this.elts[0], chars, 0);
            do {
                int k11 = k10 + getChars(this.delimiter, chars, k10);
                k10 = k11 + getChars(this.elts[i10], chars, k11);
                strArr = this.elts;
                strArr[i10] = null;
                i10++;
            } while (i10 < this.size);
            this.size = 1;
            strArr[0] = new String(chars);
        }
    }

    public int length() {
        String str;
        return (this.size != 0 || (str = this.emptyValue) == null) ? this.len + this.prefix.length() + this.suffix.length() : str.length();
    }
}
