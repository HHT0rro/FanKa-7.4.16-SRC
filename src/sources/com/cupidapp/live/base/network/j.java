package com.cupidapp.live.base.network;

import android.content.Context;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ResultErrorHandler.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final j f12008a = new j();

    public static /* synthetic */ String c(j jVar, Throwable th, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = true;
        }
        return jVar.b(th, z10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void f(j jVar, Throwable th, Context context, Map map, Function0 function0, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            context = null;
        }
        if ((i10 & 4) != 0) {
            map = null;
        }
        if ((i10 & 8) != 0) {
            function0 = null;
        }
        jVar.e(th, context, map, function0);
    }

    @Nullable
    public final String a(@Nullable Throwable th) {
        if (th instanceof ResultException) {
            return String.valueOf(((ResultException) th).getErrorCode());
        }
        return null;
    }

    @Nullable
    public final String b(@NotNull Throwable t2, boolean z10) {
        s.i(t2, "t");
        if (t2 instanceof ResultException) {
            return String.valueOf(((ResultException) t2).getErrorMessage());
        }
        if (z10) {
            return String.valueOf(t2);
        }
        return null;
    }

    @Nullable
    public final ResultShowErrorStyle d(@Nullable Throwable th) {
        if (th instanceof ResultException) {
            return ((ResultException) th).getResultShowErrorStyle();
        }
        return null;
    }

    public final void e(@NotNull Throwable t2, @Nullable Context context, @Nullable Map<Integer, ? extends Function1<? super String, p>> map, @Nullable Function0<p> function0) {
        s.i(t2, "t");
        new ResultErrorController(context, map, function0).b(t2);
    }
}
