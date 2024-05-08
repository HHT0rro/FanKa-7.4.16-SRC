package q1;

import android.graphics.BlurMaskFilter;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.MaskFilterSpan;
import com.cupidapp.live.base.utils.text.FakeBoldForegroundSpan;
import java.util.List;
import kotlin.jvm.internal.s;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKSpannableUtil.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class d {

    /* renamed from: a */
    @NotNull
    public static final d f53006a = new d();

    public static /* synthetic */ SpannableStringBuilder d(d dVar, String str, List list, Integer num, Integer num2, boolean z10, List list2, Integer num3, int i10, Object obj) {
        return dVar.c(str, list, (i10 & 4) != 0 ? null : num, (i10 & 8) != 0 ? null : num2, (i10 & 16) != 0 ? false : z10, (i10 & 32) != 0 ? null : list2, (i10 & 64) != 0 ? null : num3);
    }

    @NotNull
    public final SpannableStringBuilder a(@NotNull String content, @NotNull String specifyStr) {
        s.i(content, "content");
        s.i(specifyStr, "specifyStr");
        return g(content, specifyStr, new MaskFilterSpan(new BlurMaskFilter(15.0f, BlurMaskFilter.Blur.NORMAL)));
    }

    public final SpannableStringBuilder b(String str, Integer num, Integer num2, boolean z10, Integer num3, ClickableSpan clickableSpan) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(clickableSpan, 0, str.length(), 17);
        if (num != null) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(num.intValue()), 0, str.length(), 17);
        }
        if (z10) {
            spannableStringBuilder.setSpan(new FakeBoldForegroundSpan(0), 0, str.length(), 33);
        }
        if (num2 != null) {
            spannableStringBuilder.setSpan(new BackgroundColorSpan(num2.intValue()), 0, str.length(), 17);
        }
        if (num3 != null) {
            spannableStringBuilder.setSpan(new AbsoluteSizeSpan(num3.intValue()), 0, str.length(), 34);
        }
        return spannableStringBuilder;
    }

    @Nullable
    public final SpannableStringBuilder c(@NotNull String content, @NotNull List<String> spans, @Nullable Integer num, @Nullable Integer num2, boolean z10, @Nullable List<ClickableSpan> list, @Nullable Integer num3) {
        s.i(content, "content");
        s.i(spans, "spans");
        if (!spans.isEmpty()) {
            if (!(content.length() == 0)) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(content);
                int i10 = 0;
                for (String str : spans) {
                    int i11 = i10 + 1;
                    if (i10 < 0) {
                        kotlin.collections.s.s();
                    }
                    String str2 = str;
                    int X = StringsKt__StringsKt.X(content, str2, 0, false, 6, null);
                    int length = str2.length() + X;
                    if (X != -1) {
                        spannableStringBuilder.replace(X, length, (CharSequence) f53006a.b(str2, num, num2, z10, num3, list == null || list.isEmpty() ? null : list.get(i10)));
                    }
                    i10 = i11;
                }
                return spannableStringBuilder;
            }
        }
        return null;
    }

    public final SpannableStringBuilder e(String str, Integer num, Integer num2, boolean z10) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        if (num != null) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(num.intValue()), 0, str.length(), 33);
        }
        if (num2 != null) {
            spannableStringBuilder.setSpan(new BackgroundColorSpan(num2.intValue()), 0, str.length(), 33);
        }
        if (z10) {
            spannableStringBuilder.setSpan(new FakeBoldForegroundSpan(0), 0, str.length(), 33);
        }
        return spannableStringBuilder;
    }

    @NotNull
    public final SpannableStringBuilder f(@NotNull String str, @NotNull Object span) {
        s.i(str, "str");
        s.i(span, "span");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(span, 0, str.length(), 33);
        return spannableStringBuilder;
    }

    @NotNull
    public final SpannableStringBuilder g(@NotNull String content, @NotNull String str, @NotNull Object span) {
        s.i(content, "content");
        s.i(str, "str");
        s.i(span, "span");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(content);
        if (StringsKt__StringsKt.K(spannableStringBuilder, str, false, 2, null)) {
            int X = StringsKt__StringsKt.X(spannableStringBuilder, str, 0, false, 6, null);
            int length = str.length() + X;
            if (X != -1) {
                spannableStringBuilder.setSpan(span, X, length, 33);
            }
        }
        return spannableStringBuilder;
    }

    @NotNull
    public final SpannableStringBuilder h(@NotNull String content, @NotNull List<String> strList, @Nullable Integer num, @Nullable Integer num2, boolean z10) {
        s.i(content, "content");
        s.i(strList, "strList");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(content);
        for (String str : strList) {
            if (StringsKt__StringsKt.K(content, str, false, 2, null)) {
                int X = StringsKt__StringsKt.X(content, str, 0, false, 6, null);
                int length = str.length() + X;
                if (X != -1) {
                    spannableStringBuilder.replace(X, length, (CharSequence) f53006a.e(str, num, num2, z10));
                }
            }
        }
        return spannableStringBuilder;
    }

    @NotNull
    public final SpannableStringBuilder j(@NotNull String content, @NotNull String str, int i10) {
        s.i(content, "content");
        s.i(str, "str");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(content);
        int X = StringsKt__StringsKt.X(spannableStringBuilder, str, 0, false, 6, null);
        int d02 = StringsKt__StringsKt.d0(spannableStringBuilder, str, 0, false, 6, null);
        if (X != -1 && d02 != -1 && X != d02) {
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(spannableStringBuilder.subSequence(X + 1, d02).toString());
            spannableStringBuilder2.setSpan(new ForegroundColorSpan(i10), 0, spannableStringBuilder2.length(), 33);
            spannableStringBuilder.replace(X, d02 + 1, (CharSequence) spannableStringBuilder2);
        }
        return spannableStringBuilder;
    }
}
