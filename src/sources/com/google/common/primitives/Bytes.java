package com.google.common.primitives;

import com.google.common.base.o;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class Bytes {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class ByteArrayAsList extends AbstractList<Byte> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;
        public final byte[] array;
        public final int end;
        public final int start;

        public ByteArrayAsList(byte[] bArr) {
            this(bArr, 0, bArr.length);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return (obj instanceof Byte) && Bytes.d(this.array, ((Byte) obj).byteValue(), this.start, this.end) != -1;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.Set
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof ByteArrayAsList) {
                ByteArrayAsList byteArrayAsList = (ByteArrayAsList) obj;
                int size = size();
                if (byteArrayAsList.size() != size) {
                    return false;
                }
                for (int i10 = 0; i10 < size; i10++) {
                    if (this.array[this.start + i10] != byteArrayAsList.array[byteArrayAsList.start + i10]) {
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
                i10 = (i10 * 31) + Bytes.c(this.array[i11]);
            }
            return i10;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object obj) {
            int d10;
            if (!(obj instanceof Byte) || (d10 = Bytes.d(this.array, ((Byte) obj).byteValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return d10 - this.start;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object obj) {
            int e2;
            if (!(obj instanceof Byte) || (e2 = Bytes.e(this.array, ((Byte) obj).byteValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return e2 - this.start;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.end - this.start;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Byte> subList(int i10, int i11) {
            o.w(i10, i11, size());
            if (i10 == i11) {
                return Collections.emptyList();
            }
            byte[] bArr = this.array;
            int i12 = this.start;
            return new ByteArrayAsList(bArr, i10 + i12, i12 + i11);
        }

        public byte[] toByteArray() {
            return Arrays.copyOfRange(this.array, this.start, this.end);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            StringBuilder sb2 = new StringBuilder(size() * 5);
            sb2.append('[');
            sb2.append((int) this.array[this.start]);
            int i10 = this.start;
            while (true) {
                i10++;
                if (i10 < this.end) {
                    sb2.append(", ");
                    sb2.append((int) this.array[i10]);
                } else {
                    sb2.append(']');
                    return sb2.toString();
                }
            }
        }

        public ByteArrayAsList(byte[] bArr, int i10, int i11) {
            this.array = bArr;
            this.start = i10;
            this.end = i11;
        }

        @Override // java.util.AbstractList, java.util.List
        public Byte get(int i10) {
            o.p(i10, size());
            return Byte.valueOf(this.array[this.start + i10]);
        }

        @Override // java.util.AbstractList, java.util.List
        public Byte set(int i10, Byte b4) {
            o.p(i10, size());
            byte[] bArr = this.array;
            int i11 = this.start;
            byte b10 = bArr[i11 + i10];
            bArr[i11 + i10] = ((Byte) o.r(b4)).byteValue();
            return Byte.valueOf(b10);
        }
    }

    public static int c(byte b4) {
        return b4;
    }

    public static int d(byte[] bArr, byte b4, int i10, int i11) {
        while (i10 < i11) {
            if (bArr[i10] == b4) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    public static int e(byte[] bArr, byte b4, int i10, int i11) {
        for (int i12 = i11 - 1; i12 >= i10; i12--) {
            if (bArr[i12] == b4) {
                return i12;
            }
        }
        return -1;
    }
}
