package com.cupidapp.live.base.utils;

import android.app.Activity;
import com.cupidapp.live.R$id;
import com.cupidapp.live.base.web.FKWebView;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ActivityExtension.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class a {
    @Nullable
    public static final FKWebView a(@NotNull Activity activity) {
        kotlin.jvm.internal.s.i(activity, "<this>");
        return (FKWebView) activity.findViewById(R$id.appWebView);
    }
}
