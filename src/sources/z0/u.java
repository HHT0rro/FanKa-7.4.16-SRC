package z0;

import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Html;
import android.text.Spanned;
import android.widget.TextView;
import androidx.core.widget.TextViewCompat;
import com.cupidapp.live.base.utils.i0;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: TextViewExtension.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class u {
    public static final void a(@NotNull TextView textView) {
        kotlin.jvm.internal.s.i(textView, "<this>");
        if (Build.VERSION.SDK_INT >= 28 && i0.f12331a.e()) {
            textView.setTypeface(Typeface.create(Typeface.DEFAULT_BOLD, 600, false));
        } else {
            textView.getPaint().setFakeBoldText(true);
        }
    }

    public static final void b(@NotNull TextView textView, int i10, boolean z10) {
        kotlin.jvm.internal.s.i(textView, "<this>");
        if (i10 < 0 || i10 > 45) {
            return;
        }
        textView.getPaint().setTextSkewX(((float) Math.tan(i(i10))) * (z10 ? -1 : 1));
    }

    public static /* synthetic */ void c(TextView textView, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 15;
        }
        if ((i11 & 2) != 0) {
            z10 = true;
        }
        b(textView, i10, z10);
    }

    public static final void d(@NotNull TextView textView, int i10, int i11, int i12, int i13) {
        kotlin.jvm.internal.s.i(textView, "<this>");
        textView.setCompoundDrawablesWithIntrinsicBounds(i10, i11, i12, i13);
    }

    public static /* synthetic */ void e(TextView textView, int i10, int i11, int i12, int i13, int i14, Object obj) {
        if ((i14 & 1) != 0) {
            i10 = 0;
        }
        if ((i14 & 2) != 0) {
            i11 = 0;
        }
        if ((i14 & 4) != 0) {
            i12 = 0;
        }
        if ((i14 & 8) != 0) {
            i13 = 0;
        }
        d(textView, i10, i11, i12, i13);
    }

    public static final void f(@NotNull TextView textView, int i10) {
        kotlin.jvm.internal.s.i(textView, "<this>");
        textView.setMaxLines(1);
        TextViewCompat.setAutoSizeTextTypeWithDefaults(textView, 1);
        TextViewCompat.setAutoSizeTextTypeUniformWithConfiguration(textView, 1, i10, 1, 2);
    }

    public static final void g(@NotNull TextView textView, @NotNull List<Integer> colorList) {
        kotlin.jvm.internal.s.i(textView, "<this>");
        kotlin.jvm.internal.s.i(colorList, "colorList");
        textView.setTextColor(-16777216);
        textView.getPaint().setShader(new LinearGradient(0.0f, 0.0f, textView.getPaint().getTextSize() * textView.getText().length(), 0.0f, CollectionsKt___CollectionsKt.w0(colorList), (float[]) null, Shader.TileMode.CLAMP));
    }

    public static final void h(@NotNull TextView textView, @Nullable String str) {
        Spanned fromHtml;
        kotlin.jvm.internal.s.i(textView, "<this>");
        if (Build.VERSION.SDK_INT >= 24) {
            fromHtml = Html.fromHtml(str, 0);
        } else {
            fromHtml = Html.fromHtml(str);
        }
        textView.setText(fromHtml);
    }

    public static final double i(int i10) {
        return (i10 / 180.0d) * 3.141592653589793d;
    }
}
