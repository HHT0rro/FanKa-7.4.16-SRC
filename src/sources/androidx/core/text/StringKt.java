package androidx.core.text;

import android.text.TextUtils;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: String.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class StringKt {
    @NotNull
    public static final String htmlEncode(@NotNull String str) {
        s.i(str, "<this>");
        String htmlEncode = TextUtils.htmlEncode(str);
        s.h(htmlEncode, "htmlEncode(this)");
        return htmlEncode;
    }
}
