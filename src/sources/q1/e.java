package q1;

import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.text.util.Linkify;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import java.util.ArrayList;
import java.util.regex.Pattern;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: HyperLinkHelper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f53007a = new e();

    /* compiled from: HyperLinkHelper.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a extends ClickableSpan {

        /* renamed from: b, reason: collision with root package name */
        @NotNull
        public final String f53008b;

        /* renamed from: c, reason: collision with root package name */
        @Nullable
        public final Integer f53009c;

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public final Function1<String, p> f53010d;

        /* renamed from: e, reason: collision with root package name */
        public int f53011e;

        /* renamed from: f, reason: collision with root package name */
        public int f53012f;

        /* JADX WARN: Multi-variable type inference failed */
        public a(@NotNull String url, @ColorInt @Nullable Integer num, @NotNull Function1<? super String, p> clickCallback) {
            s.i(url, "url");
            s.i(clickCallback, "clickCallback");
            this.f53008b = url;
            this.f53009c = num;
            this.f53010d = clickCallback;
        }

        public final int a() {
            return this.f53012f;
        }

        public final int b() {
            return this.f53011e;
        }

        public final void c(int i10) {
            this.f53012f = i10;
        }

        public final void d(int i10) {
            this.f53011e = i10;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NotNull View widget) {
            s.i(widget, "widget");
            this.f53010d.invoke(this.f53008b);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NotNull TextPaint ds) {
            s.i(ds, "ds");
            super.updateDrawState(ds);
            Integer num = this.f53009c;
            if (num != null) {
                ds.setColor(num.intValue());
            }
        }
    }

    public final void a(@Nullable TextView textView, @Nullable String str, @ColorInt @Nullable Integer num, @NotNull Function1<? super String, p> clickCallback) {
        s.i(clickCallback, "clickCallback");
        if (textView == null) {
            return;
        }
        boolean z10 = true;
        if (str == null || str.length() == 0) {
            textView.setText(str);
            return;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        Linkify.addLinks(spannableStringBuilder, Pattern.compile("(((http[s]?|ftp?|file?)://)+[a-zA-Z0-9.\\-]+\\.([a-zA-Z]{2,4})(:\\d+)?(/[a-zA-Z0-9.\\-~!@#$%^&*+?:_/=<>']*)?)|(www.[a-zA-Z0-9.\\-]+\\.([a-zA-Z]{2,4})(:\\d+)?(/[a-zA-Z0-9.\\-~!@#$%^&*+?:_/=<>']*)?)"), "");
        Linkify.addLinks(spannableStringBuilder, Pattern.compile("finka2020://[-A-Za-z0-9+&@#/%?=~_|!:,.;]+[-A-Za-z0-9+&@#/%=~_|]", 2), "finka2020://");
        URLSpan[] urlSpans = (URLSpan[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), URLSpan.class);
        if (urlSpans != null) {
            if (!(urlSpans.length == 0)) {
                z10 = false;
            }
        }
        if (z10) {
            textView.setText(spannableStringBuilder);
            return;
        }
        ArrayList<a> arrayList = new ArrayList();
        int i10 = -1;
        s.h(urlSpans, "urlSpans");
        String str2 = str;
        int i11 = 0;
        for (URLSpan uRLSpan : urlSpans) {
            String url = uRLSpan.getURL();
            s.h(url, "span.url");
            a aVar = new a(url, num, clickCallback);
            int spanStart = spannableStringBuilder.getSpanStart(uRLSpan);
            int spanEnd = spannableStringBuilder.getSpanEnd(uRLSpan);
            if (spanStart > i10) {
                aVar.d(spanStart - i11);
                aVar.c(aVar.b() + 6);
                i11 += (spanEnd - spanStart) - 6;
                arrayList.add(aVar);
                String url2 = uRLSpan.getURL();
                s.h(url2, "span.url");
                str2 = kotlin.text.p.A(str2, url2, "网页链接 >", false, 4, null);
                i10 = spanEnd;
            }
        }
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(str2);
        int length = spannableStringBuilder2.length();
        for (a aVar2 : arrayList) {
            if (!b(aVar2.b(), aVar2.a(), length)) {
                spannableStringBuilder2.setSpan(aVar2, aVar2.b(), aVar2.a(), 33);
            }
        }
        textView.setText(spannableStringBuilder2);
        textView.setMovementMethod(f.f53013b.a());
    }

    public final boolean b(int i10, int i11, int i12) {
        return i11 < i10 || i10 > i12 || i11 > i12 || i10 < 0 || i11 < 0;
    }
}
