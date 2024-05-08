package com.google.android.gms.internal.vision;

import com.huawei.quickcard.base.Attributes;
import java.util.Objects;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class p0 {
    public static int a(int i10, int i11) {
        String c4;
        if (i10 >= 0 && i10 < i11) {
            return i10;
        }
        if (i10 < 0) {
            c4 = r0.c("%s (%s) must not be negative", Attributes.Style.INDEX, Integer.valueOf(i10));
        } else {
            if (i11 < 0) {
                StringBuilder sb2 = new StringBuilder(26);
                sb2.append("negative size: ");
                sb2.append(i11);
                throw new IllegalArgumentException(sb2.toString());
            }
            c4 = r0.c("%s (%s) must be less than size (%s)", Attributes.Style.INDEX, Integer.valueOf(i10), Integer.valueOf(i11));
        }
        throw new IndexOutOfBoundsException(c4);
    }

    @NonNullDecl
    public static <T> T b(@NonNullDecl T t2) {
        Objects.requireNonNull(t2);
        return t2;
    }

    @NonNullDecl
    public static <T> T c(@NonNullDecl T t2, @NullableDecl Object obj) {
        if (t2 != null) {
            return t2;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static String d(int i10, int i11, @NullableDecl String str) {
        if (i10 < 0) {
            return r0.c("%s (%s) must not be negative", str, Integer.valueOf(i10));
        }
        if (i11 >= 0) {
            return r0.c("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i10), Integer.valueOf(i11));
        }
        StringBuilder sb2 = new StringBuilder(26);
        sb2.append("negative size: ");
        sb2.append(i11);
        throw new IllegalArgumentException(sb2.toString());
    }

    public static void e(int i10, int i11, int i12) {
        String d10;
        if (i10 < 0 || i11 < i10 || i11 > i12) {
            if (i10 >= 0 && i10 <= i12) {
                d10 = (i11 < 0 || i11 > i12) ? d(i11, i12, "end index") : r0.c("end index (%s) must not be less than start index (%s)", Integer.valueOf(i11), Integer.valueOf(i10));
            } else {
                d10 = d(i10, i12, "start index");
            }
            throw new IndexOutOfBoundsException(d10);
        }
    }

    public static void f(boolean z10, @NullableDecl Object obj) {
        if (!z10) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static int g(int i10, int i11) {
        if (i10 < 0 || i10 > i11) {
            throw new IndexOutOfBoundsException(d(i10, i11, Attributes.Style.INDEX));
        }
        return i10;
    }

    public static void h(boolean z10, @NullableDecl Object obj) {
        if (!z10) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }
}
