package com.cupidapp.live.login.helper;

import android.content.Context;
import com.cupidapp.live.R$string;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

/* compiled from: LoginInfoVerifier.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    public final Context f16162a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public final c f16163b;

    public f(@Nullable Context context, @Nullable c cVar) {
        this.f16162a = context;
        this.f16163b = cVar;
    }

    @Nullable
    public final String a(@Nullable String str) {
        if (!(str == null || str.length() == 0)) {
            return str;
        }
        c cVar = this.f16163b;
        if (cVar != null) {
            cVar.c();
        }
        com.cupidapp.live.base.view.h.f12779a.r(this.f16162a, R$string.login_username_is_invalid_text);
        return null;
    }

    @Nullable
    public final String b(@Nullable String str, @Nullable String str2) {
        if (c(str) == null || c(str2) == null) {
            return null;
        }
        if (str != null && str.equals(str2)) {
            return str;
        }
        com.cupidapp.live.base.view.h.f12779a.r(this.f16162a, R$string.confirm_password_not_same);
        return null;
    }

    @Nullable
    public final String c(@Nullable String str) {
        if (!(str == null || str.length() == 0) && str.length() >= 6) {
            return str;
        }
        c cVar = this.f16163b;
        if (cVar != null) {
            cVar.a();
        }
        com.cupidapp.live.base.view.h.f12779a.r(this.f16162a, R$string.login_password_is_invalid_text);
        return null;
    }

    @Nullable
    public final String d(@Nullable String str) {
        if (!(str == null || str.length() == 0)) {
            return str;
        }
        c cVar = this.f16163b;
        if (cVar != null) {
            cVar.b();
        }
        com.cupidapp.live.base.view.h.f12779a.r(this.f16162a, R$string.login_verify_code_must_not_be_null);
        return null;
    }

    public /* synthetic */ f(Context context, c cVar, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i10 & 2) != 0 ? null : cVar);
    }
}
