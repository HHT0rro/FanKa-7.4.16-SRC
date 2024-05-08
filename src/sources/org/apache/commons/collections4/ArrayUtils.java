package org.apache.commons.collections4;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
class ArrayUtils {
    public static final int INDEX_NOT_FOUND = -1;

    public static boolean contains(Object[] objArr, Object obj) {
        return indexOf(objArr, obj) != -1;
    }

    public static <T> int indexOf(T[] tArr, Object obj) {
        return indexOf(tArr, obj, 0);
    }

    public static int indexOf(Object[] objArr, Object obj, int i10) {
        if (objArr == null) {
            return -1;
        }
        if (i10 < 0) {
            i10 = 0;
        }
        if (obj == null) {
            while (i10 < objArr.length) {
                if (objArr[i10] == null) {
                    return i10;
                }
                i10++;
            }
        } else {
            while (i10 < objArr.length) {
                if (obj.equals(objArr[i10])) {
                    return i10;
                }
                i10++;
            }
        }
        return -1;
    }
}
