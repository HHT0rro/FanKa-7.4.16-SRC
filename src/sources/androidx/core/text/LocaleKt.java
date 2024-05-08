package androidx.core.text;

import android.text.TextUtils;
import androidx.annotation.RequiresApi;
import java.util.Locale;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: Locale.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class LocaleKt {
    @RequiresApi(17)
    public static final int getLayoutDirection(@NotNull Locale locale) {
        s.i(locale, "<this>");
        return TextUtils.getLayoutDirectionFromLocale(locale);
    }
}
