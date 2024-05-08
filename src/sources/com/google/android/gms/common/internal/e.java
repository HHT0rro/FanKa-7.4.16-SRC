package com.google.android.gms.common.internal;

import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;

/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final String f23673a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public final String f23674b;

    public e(@RecentlyNonNull String str, @Nullable String str2) {
        h.i(str, "log tag cannot be null");
        h.c(str.length() <= 23, "tag \"%s\" is longer than the %d character maximum", str, 23);
        this.f23673a = str;
        if (str2 != null && str2.length() > 0) {
            this.f23674b = str2;
        } else {
            this.f23674b = null;
        }
    }

    @RecentlyNonNull
    public final boolean a(@RecentlyNonNull int i10) {
        return Log.isLoggable(this.f23673a, i10);
    }

    public final void b(@RecentlyNonNull String str, @RecentlyNonNull String str2) {
        if (a(3)) {
            g(str2);
        }
    }

    public final void c(@RecentlyNonNull String str, @RecentlyNonNull String str2) {
        if (a(6)) {
            g(str2);
        }
    }

    public final void d(@RecentlyNonNull String str, @RecentlyNonNull String str2, @RecentlyNonNull Throwable th) {
        if (a(6)) {
            g(str2);
        }
    }

    public final void e(@RecentlyNonNull String str, @RecentlyNonNull String str2) {
        if (a(2)) {
            g(str2);
        }
    }

    public final void f(@RecentlyNonNull String str, @RecentlyNonNull String str2) {
        if (a(5)) {
            g(str2);
        }
    }

    public final String g(String str) {
        String str2 = this.f23674b;
        return str2 == null ? str : str2.concat(str);
    }
}
