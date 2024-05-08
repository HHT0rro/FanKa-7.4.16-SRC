package h6;

import android.text.Spannable;

/* compiled from: SpanUtil.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class d {
    public static void a(Spannable spannable, Object obj, int i10, int i11, int i12) {
        for (Object obj2 : spannable.getSpans(i10, i11, obj.getClass())) {
            if (spannable.getSpanStart(obj2) == i10 && spannable.getSpanEnd(obj2) == i11 && spannable.getSpanFlags(obj2) == i12) {
                spannable.removeSpan(obj2);
            }
        }
        spannable.setSpan(obj, i10, i11, i12);
    }
}
