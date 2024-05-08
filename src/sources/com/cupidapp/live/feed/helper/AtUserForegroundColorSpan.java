package com.cupidapp.live.feed.helper;

import android.text.style.ForegroundColorSpan;
import androidx.annotation.ColorInt;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: AtUserForegroundColorSpan.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class AtUserForegroundColorSpan extends ForegroundColorSpan {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final String f14293b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public final String f14294c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AtUserForegroundColorSpan(@NotNull String userName, @NotNull String userId, @ColorInt int i10) {
        super(i10);
        s.i(userName, "userName");
        s.i(userId, "userId");
        this.f14293b = userName;
        this.f14294c = userId;
    }

    @NotNull
    public final String a() {
        return this.f14294c;
    }

    @NotNull
    public final String b() {
        return this.f14293b;
    }
}
