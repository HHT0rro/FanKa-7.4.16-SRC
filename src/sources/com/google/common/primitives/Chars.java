package com.google.common.primitives;

import com.google.common.base.o;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class Chars {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class CharArrayAsList extends AbstractList<Character> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;
        public final char[] array;
        public final int end;
        public final int start;

        public CharArrayAsList(char[] cArr) {
            this(cArr, 0, cArr.length);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return (obj instanceof Character) && Chars.e(this.array, ((Character) obj).charValue(), this.start, this.end) != -1;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.Set
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof CharArrayAsList) {
                CharArrayAsList charArrayAsList = (CharArrayAsList) obj;
                int size = size();
                if (charArrayAsList.size() != size) {
                    return false;
                }
                for (int i10 = 0; i10 < size; i10++) {
                    if (this.array[this.start + i10] != charArrayAsList.array[charArrayAsList.start + i10]) {
                        return false;
                    }
                }
                return true;
            }
            return super.equals(obj);
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.Set
        public int hashCode() {
            int i10 = 1;
            for (int i11 = this.start; i11 < this.end; i11++) {
                i10 = (i10 * 31) + Chars.d(this.array[i11]);
            }
            return i10;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object obj) {
            int e2;
            if (!(obj instanceof Character) || (e2 = Chars.e(this.array, ((Character) obj).charValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return e2 - this.start;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object obj) {
            int f10;
            if (!(obj instanceof Character) || (f10 = Chars.f(this.array, ((Character) obj).charValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return f10 - this.start;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.end - this.start;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Character> subList(int i10, int i11) {
            o.w(i10, i11, size());
            if (i10 == i11) {
                return Collections.emptyList();
            }
            char[] cArr = this.array;
            int i12 = this.start;
            return new CharArrayAsList(cArr, i10 + i12, i12 + i11);
        }

        public char[] toCharArray() {
            return Arrays.copyOfRange(this.array, this.start, this.end);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            StringBuilder sb2 = new StringBuilder(size() * 3);
            sb2.append('[');
            sb2.append(this.array[this.start]);
            int i10 = this.start;
            while (true) {
                i10++;
                if (i10 < this.end) {
                    sb2.append(", ");
                    sb2.append(this.array[i10]);
                } else {
                    sb2.append(']');
                    return sb2.toString();
                }
            }
        }

        public CharArrayAsList(char[] cArr, int i10, int i11) {
            this.array = cArr;
            this.start = i10;
            this.end = i11;
        }

        @Override // java.util.AbstractList, java.util.List
        public Character get(int i10) {
            o.p(i10, size());
            return Character.valueOf(this.array[this.start + i10]);
        }

        @Override // java.util.AbstractList, java.util.List
        public Character set(int i10, Character ch) {
            o.p(i10, size());
            char[] cArr = this.array;
            int i11 = this.start;
            char c4 = cArr[i11 + i10];
            cArr[i11 + i10] = ((Character) o.r(ch)).charValue();
            return Character.valueOf(c4);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public enum LexicographicalComparator implements Comparator<char[]> {
        INSTANCE;

        @Override // java.lang.Enum
        public String toString() {
            return "Chars.lexicographicalComparator()";
        }

        @Override // java.util.Comparator
        public int compare(char[] cArr, char[] cArr2) {
            int min = Math.min(cArr.length, cArr2.length);
            for (int i10 = 0; i10 < min; i10++) {
                int c4 = Chars.c(cArr[i10], cArr2[i10]);
                if (c4 != 0) {
                    return c4;
                }
            }
            return cArr.length - cArr2.length;
        }
    }

    public static int c(char c4, char c10) {
        return c4 - c10;
    }

    public static int d(char c4) {
        return c4;
    }

    public static int e(char[] cArr, char c4, int i10, int i11) {
        while (i10 < i11) {
            if (cArr[i10] == c4) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    public static int f(char[] cArr, char c4, int i10, int i11) {
        for (int i12 = i11 - 1; i12 >= i10; i12--) {
            if (cArr[i12] == c4) {
                return i12;
            }
        }
        return -1;
    }
}
