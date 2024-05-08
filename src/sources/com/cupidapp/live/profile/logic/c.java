package com.cupidapp.live.profile.logic;

import com.cupidapp.live.profile.model.User;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p1.g;

/* compiled from: UserUtil.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f17839a = new c();

    public final boolean a(@Nullable String str) {
        User X = g.f52734a.X();
        return s.d(X != null ? X.userId() : null, str);
    }

    public final boolean b() {
        User X = g.f52734a.X();
        return X != null && X.isSsvip();
    }

    public final boolean c() {
        User X = g.f52734a.X();
        return X != null && X.isSVip();
    }

    public final boolean d() {
        return c() || b();
    }

    public final boolean e() {
        User X = g.f52734a.X();
        return X != null && X.isVip();
    }

    public final boolean f() {
        return e() || c() || b();
    }
}
