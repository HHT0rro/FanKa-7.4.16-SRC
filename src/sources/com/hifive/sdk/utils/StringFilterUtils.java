package com.hifive.sdk.utils;

import kotlin.d;
import kotlin.jvm.internal.s;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;

/* compiled from: StringFilterUtils.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class StringFilterUtils {
    public static final StringFilterUtils INSTANCE = new StringFilterUtils();

    private StringFilterUtils() {
    }

    public final boolean idFilter(@NotNull String str) {
        s.j(str, "str");
        return new Regex("[^a-zA-Z0-9]").matches(str);
    }

    public final boolean nameFilter(@NotNull String str) {
        s.j(str, "str");
        return new Regex("[^a-zA-Z0-9一-龥]").matches(str);
    }
}
