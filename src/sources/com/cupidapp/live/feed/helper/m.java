package com.cupidapp.live.feed.helper;

import android.content.Context;
import com.cupidapp.live.startup.helper.ADMonitorHelper;
import kotlin.collections.r;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: RTBAsiaHelper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final m f14354a = new m();

    public final void a(@Nullable Context context, @Nullable String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        ADMonitorHelper.f18414a.b(context, r.e(str));
    }
}
