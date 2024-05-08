package com.google.android.gms.internal.mlkit_vision_face;

import com.huawei.quickcard.base.Attributes;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class a {
    public static void a(boolean z10, @NullableDecl Object obj) {
        if (!z10) {
            throw new IllegalStateException((String) obj);
        }
    }

    public static int b(int i10, int i11, @NullableDecl String str) {
        String b4;
        if (i10 >= 0 && i10 < i11) {
            return i10;
        }
        if (i10 < 0) {
            b4 = b.b("%s (%s) must not be negative", Attributes.Style.INDEX, Integer.valueOf(i10));
        } else {
            if (i11 < 0) {
                StringBuilder sb2 = new StringBuilder(26);
                sb2.append("negative size: ");
                sb2.append(i11);
                throw new IllegalArgumentException(sb2.toString());
            }
            b4 = b.b("%s (%s) must be less than size (%s)", Attributes.Style.INDEX, Integer.valueOf(i10), Integer.valueOf(i11));
        }
        throw new IndexOutOfBoundsException(b4);
    }

    public static int c(int i10, int i11, @NullableDecl String str) {
        if (i10 < 0 || i10 > i11) {
            throw new IndexOutOfBoundsException(e(i10, i11, Attributes.Style.INDEX));
        }
        return i10;
    }

    public static void d(int i10, int i11, int i12) {
        String e2;
        if (i10 < 0 || i11 < i10 || i11 > i12) {
            if (i10 >= 0 && i10 <= i12) {
                e2 = (i11 < 0 || i11 > i12) ? e(i11, i12, "end index") : b.b("end index (%s) must not be less than start index (%s)", Integer.valueOf(i11), Integer.valueOf(i10));
            } else {
                e2 = e(i10, i12, "start index");
            }
            throw new IndexOutOfBoundsException(e2);
        }
    }

    public static String e(int i10, int i11, @NullableDecl String str) {
        if (i10 < 0) {
            return b.b("%s (%s) must not be negative", str, Integer.valueOf(i10));
        }
        if (i11 >= 0) {
            return b.b("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i10), Integer.valueOf(i11));
        }
        StringBuilder sb2 = new StringBuilder(26);
        sb2.append("negative size: ");
        sb2.append(i11);
        throw new IllegalArgumentException(sb2.toString());
    }
}
