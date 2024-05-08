package com.google.android.gms.internal.mlkit_common;

import com.huawei.quickcard.base.Attributes;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.mlkit:common@@17.1.1 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class u0 {
    public static int a(int i10, int i11, @NullableDecl String str) {
        String a10;
        if (i10 >= 0 && i10 < i11) {
            return i10;
        }
        if (i10 < 0) {
            a10 = b.a("%s (%s) must not be negative", Attributes.Style.INDEX, Integer.valueOf(i10));
        } else {
            if (i11 < 0) {
                StringBuilder sb2 = new StringBuilder(26);
                sb2.append("negative size: ");
                sb2.append(i11);
                throw new IllegalArgumentException(sb2.toString());
            }
            a10 = b.a("%s (%s) must be less than size (%s)", Attributes.Style.INDEX, Integer.valueOf(i10), Integer.valueOf(i11));
        }
        throw new IndexOutOfBoundsException(a10);
    }

    public static int b(int i10, int i11, @NullableDecl String str) {
        if (i10 < 0 || i10 > i11) {
            throw new IndexOutOfBoundsException(d(i10, i11, Attributes.Style.INDEX));
        }
        return i10;
    }

    public static void c(int i10, int i11, int i12) {
        String d10;
        if (i10 < 0 || i11 < i10 || i11 > i12) {
            if (i10 >= 0 && i10 <= i12) {
                d10 = (i11 < 0 || i11 > i12) ? d(i11, i12, "end index") : b.a("end index (%s) must not be less than start index (%s)", Integer.valueOf(i11), Integer.valueOf(i10));
            } else {
                d10 = d(i10, i12, "start index");
            }
            throw new IndexOutOfBoundsException(d10);
        }
    }

    public static String d(int i10, int i11, @NullableDecl String str) {
        if (i10 < 0) {
            return b.a("%s (%s) must not be negative", str, Integer.valueOf(i10));
        }
        if (i11 >= 0) {
            return b.a("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i10), Integer.valueOf(i11));
        }
        StringBuilder sb2 = new StringBuilder(26);
        sb2.append("negative size: ");
        sb2.append(i11);
        throw new IllegalArgumentException(sb2.toString());
    }
}
