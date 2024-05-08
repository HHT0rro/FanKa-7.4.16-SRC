package androidx.core.text;

import android.text.Spannable;
import android.text.SpannableString;
import kotlin.jvm.internal.s;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;

/* compiled from: SpannableString.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class SpannableStringKt {
    public static final void clearSpans(@NotNull Spannable spannable) {
        s.i(spannable, "<this>");
        Object[] spans = spannable.getSpans(0, spannable.length(), Object.class);
        s.h(spans, "getSpans(start, end, T::class.java)");
        for (Object obj : spans) {
            spannable.removeSpan(obj);
        }
    }

    public static final void set(@NotNull Spannable spannable, int i10, int i11, @NotNull Object span) {
        s.i(spannable, "<this>");
        s.i(span, "span");
        spannable.setSpan(span, i10, i11, 17);
    }

    @NotNull
    public static final Spannable toSpannable(@NotNull CharSequence charSequence) {
        s.i(charSequence, "<this>");
        SpannableString valueOf = SpannableString.valueOf(charSequence);
        s.h(valueOf, "valueOf(this)");
        return valueOf;
    }

    public static final void set(@NotNull Spannable spannable, @NotNull IntRange range, @NotNull Object span) {
        s.i(spannable, "<this>");
        s.i(range, "range");
        s.i(span, "span");
        spannable.setSpan(span, range.getStart().intValue(), range.getEndInclusive().intValue(), 17);
    }
}
