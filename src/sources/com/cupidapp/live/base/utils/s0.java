package com.cupidapp.live.base.utils;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: UrlUtils.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class s0 {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final s0 f12376a = new s0();

    @NotNull
    public final String a(@NotNull String firstPath, @Nullable String str) {
        kotlin.jvm.internal.s.i(firstPath, "firstPath");
        if (str == null || str.length() == 0) {
            return firstPath;
        }
        return firstPath + "/" + str;
    }
}
