package androidx.core.text;

import android.text.Html;
import android.text.Spanned;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Html.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class HtmlKt {
    @NotNull
    public static final Spanned parseAsHtml(@NotNull String str, int i10, @Nullable Html.ImageGetter imageGetter, @Nullable Html.TagHandler tagHandler) {
        s.i(str, "<this>");
        Spanned fromHtml = HtmlCompat.fromHtml(str, i10, imageGetter, tagHandler);
        s.h(fromHtml, "fromHtml(this, flags, imageGetter, tagHandler)");
        return fromHtml;
    }

    public static /* synthetic */ Spanned parseAsHtml$default(String str, int i10, Html.ImageGetter imageGetter, Html.TagHandler tagHandler, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 0;
        }
        if ((i11 & 2) != 0) {
            imageGetter = null;
        }
        if ((i11 & 4) != 0) {
            tagHandler = null;
        }
        s.i(str, "<this>");
        Spanned fromHtml = HtmlCompat.fromHtml(str, i10, imageGetter, tagHandler);
        s.h(fromHtml, "fromHtml(this, flags, imageGetter, tagHandler)");
        return fromHtml;
    }

    @NotNull
    public static final String toHtml(@NotNull Spanned spanned, int i10) {
        s.i(spanned, "<this>");
        String html = HtmlCompat.toHtml(spanned, i10);
        s.h(html, "toHtml(this, option)");
        return html;
    }

    public static /* synthetic */ String toHtml$default(Spanned spanned, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 0;
        }
        s.i(spanned, "<this>");
        String html = HtmlCompat.toHtml(spanned, i10);
        s.h(html, "toHtml(this, option)");
        return html;
    }
}
