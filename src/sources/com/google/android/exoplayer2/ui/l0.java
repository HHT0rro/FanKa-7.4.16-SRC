package com.google.android.exoplayer2.ui;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.RelativeSizeSpan;
import e6.a;

/* compiled from: SubtitleViewUtils.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class l0 {
    public static /* synthetic */ boolean c(Object obj) {
        return !(obj instanceof h6.b);
    }

    public static /* synthetic */ boolean d(Object obj) {
        return (obj instanceof AbsoluteSizeSpan) || (obj instanceof RelativeSizeSpan);
    }

    public static void e(a.b bVar) {
        bVar.b();
        if (bVar.e() instanceof Spanned) {
            if (!(bVar.e() instanceof Spannable)) {
                bVar.o(SpannableString.valueOf(bVar.e()));
            }
            g((Spannable) com.google.android.exoplayer2.util.a.e(bVar.e()), new com.google.common.base.p() { // from class: com.google.android.exoplayer2.ui.j0
                @Override // com.google.common.base.p
                public final boolean apply(Object obj) {
                    boolean c4;
                    c4 = l0.c(obj);
                    return c4;
                }
            });
        }
        f(bVar);
    }

    public static void f(a.b bVar) {
        bVar.q(-3.4028235E38f, Integer.MIN_VALUE);
        if (bVar.e() instanceof Spanned) {
            if (!(bVar.e() instanceof Spannable)) {
                bVar.o(SpannableString.valueOf(bVar.e()));
            }
            g((Spannable) com.google.android.exoplayer2.util.a.e(bVar.e()), new com.google.common.base.p() { // from class: com.google.android.exoplayer2.ui.k0
                @Override // com.google.common.base.p
                public final boolean apply(Object obj) {
                    boolean d10;
                    d10 = l0.d(obj);
                    return d10;
                }
            });
        }
    }

    public static void g(Spannable spannable, com.google.common.base.p<Object> pVar) {
        for (Object obj : spannable.getSpans(0, spannable.length(), Object.class)) {
            if (pVar.apply(obj)) {
                spannable.removeSpan(obj);
            }
        }
    }

    public static float h(int i10, float f10, int i11, int i12) {
        float f11;
        if (f10 == -3.4028235E38f) {
            return -3.4028235E38f;
        }
        if (i10 == 0) {
            f11 = i12;
        } else {
            if (i10 != 1) {
                if (i10 != 2) {
                    return -3.4028235E38f;
                }
                return f10;
            }
            f11 = i11;
        }
        return f10 * f11;
    }
}
