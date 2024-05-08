package io.reactivex.internal.util;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class OpenHashSet<T> {
    private static final int INT_PHI = -1640531527;
    public T[] keys;
    public final float loadFactor;
    public int mask;
    public int maxSize;
    public int size;

    public OpenHashSet() {
        this(16, 0.75f);
    }

    public static int mix(int i10) {
        int i11 = i10 * INT_PHI;
        return i11 ^ (i11 >>> 16);
    }

    public boolean add(T t2) {
        T t10;
        T[] tArr = this.keys;
        int i10 = this.mask;
        int mix = mix(t2.hashCode()) & i10;
        T t11 = tArr[mix];
        if (t11 != null) {
            if (t11.equals(t2)) {
                return false;
            }
            do {
                mix = (mix + 1) & i10;
                t10 = tArr[mix];
                if (t10 == null) {
                }
            } while (!t10.equals(t2));
            return false;
        }
        tArr[mix] = t2;
        int i11 = this.size + 1;
        this.size = i11;
        if (i11 >= this.maxSize) {
            rehash();
        }
        return true;
    }

    public Object[] keys() {
        return this.keys;
    }

    public void rehash() {
        T[] tArr = this.keys;
        int length = tArr.length;
        int i10 = length << 1;
        int i11 = i10 - 1;
        T[] tArr2 = (T[]) new Object[i10];
        int i12 = this.size;
        while (true) {
            int i13 = i12 - 1;
            if (i12 == 0) {
                this.mask = i11;
                this.maxSize = (int) (i10 * this.loadFactor);
                this.keys = tArr2;
                return;
            }
            do {
                length--;
            } while (tArr[length] == null);
            int mix = mix(tArr[length].hashCode()) & i11;
            if (tArr2[mix] == null) {
                tArr2[mix] = tArr[length];
                i12 = i13;
            }
            do {
                mix = (mix + 1) & i11;
            } while (tArr2[mix] != null);
            tArr2[mix] = tArr[length];
            i12 = i13;
        }
    }

    public boolean remove(T t2) {
        T t10;
        T[] tArr = this.keys;
        int i10 = this.mask;
        int mix = mix(t2.hashCode()) & i10;
        T t11 = tArr[mix];
        if (t11 == null) {
            return false;
        }
        if (t11.equals(t2)) {
            return removeEntry(mix, tArr, i10);
        }
        do {
            mix = (mix + 1) & i10;
            t10 = tArr[mix];
            if (t10 == null) {
                return false;
            }
        } while (!t10.equals(t2));
        return removeEntry(mix, tArr, i10);
    }

    public boolean removeEntry(int i10, T[] tArr, int i11) {
        int i12;
        T t2;
        this.size--;
        while (true) {
            int i13 = i10 + 1;
            while (true) {
                i12 = i13 & i11;
                t2 = tArr[i12];
                if (t2 == null) {
                    tArr[i10] = null;
                    return true;
                }
                int mix = mix(t2.hashCode()) & i11;
                if (i10 > i12) {
                    if (i10 >= mix && mix > i12) {
                        break;
                    }
                    i13 = i12 + 1;
                } else if (i10 < mix && mix <= i12) {
                    i13 = i12 + 1;
                }
            }
            tArr[i10] = t2;
            i10 = i12;
        }
    }

    public int size() {
        return this.size;
    }

    public OpenHashSet(int i10) {
        this(i10, 0.75f);
    }

    public OpenHashSet(int i10, float f10) {
        this.loadFactor = f10;
        int roundToPowerOfTwo = Pow2.roundToPowerOfTwo(i10);
        this.mask = roundToPowerOfTwo - 1;
        this.maxSize = (int) (f10 * roundToPowerOfTwo);
        this.keys = (T[]) new Object[roundToPowerOfTwo];
    }
}
