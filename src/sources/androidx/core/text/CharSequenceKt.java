package androidx.core.text;

import android.text.TextUtils;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: CharSequence.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class CharSequenceKt {
    public static final boolean isDigitsOnly(@NotNull CharSequence charSequence) {
        s.i(charSequence, "<this>");
        return TextUtils.isDigitsOnly(charSequence);
    }

    public static final int trimmedLength(@NotNull CharSequence charSequence) {
        s.i(charSequence, "<this>");
        return TextUtils.getTrimmedLength(charSequence);
    }
}
