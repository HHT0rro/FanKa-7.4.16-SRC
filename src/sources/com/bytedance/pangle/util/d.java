package com.bytedance.pangle.util;

import androidx.annotation.Nullable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class d {
    public static <T> boolean a(@Nullable T[] tArr) {
        return tArr == null || tArr.length == 0;
    }

    public static <T> boolean a(@Nullable T[] tArr, T[] tArr2) {
        if (tArr2 == null) {
            return true;
        }
        for (T t2 : tArr2) {
            if (!a(tArr, t2)) {
                return false;
            }
        }
        return true;
    }

    private static <T> boolean a(@Nullable T[] tArr, T t2) {
        int i10;
        if (tArr != null) {
            i10 = 0;
            while (i10 < tArr.length) {
                if (tArr[i10] == t2 || (tArr[i10] != null && tArr[i10].equals(t2))) {
                    break;
                }
                i10++;
            }
        }
        i10 = -1;
        return i10 != -1;
    }
}
