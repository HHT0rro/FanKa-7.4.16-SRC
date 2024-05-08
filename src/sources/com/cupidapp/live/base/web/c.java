package com.cupidapp.live.base.web;

import android.net.Uri;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKWebConstants.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f13063a = new c();

    public final boolean a(@Nullable Uri uri) {
        return s.d(uri != null ? uri.getScheme() : null, "finka2020");
    }

    public final boolean b(@Nullable Uri uri) {
        if (!s.d(uri != null ? uri.getScheme() : null, "pushscheme")) {
            if (!s.d(uri != null ? uri.getScheme() : null, "mipushscheme")) {
                if (!s.d(uri != null ? uri.getScheme() : null, "vivopushscheme")) {
                    return false;
                }
            }
        }
        return true;
    }
}
