package com.cupidapp.live.base.utils;

import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLogUtil.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f12332a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    public static boolean f12333b;

    /* compiled from: FKLogUtil.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@Nullable String str, @NotNull String msg) {
            kotlin.jvm.internal.s.i(msg, "msg");
            boolean z10 = j.f12333b;
        }

        public final void b(@Nullable String str, @NotNull String msg, @Nullable Throwable th) {
            kotlin.jvm.internal.s.i(msg, "msg");
            boolean z10 = j.f12333b;
        }

        public final void c(@Nullable String str, @NotNull String msg) {
            kotlin.jvm.internal.s.i(msg, "msg");
            boolean z10 = j.f12333b;
        }

        public final void d(@Nullable String str, @NotNull String msg, @Nullable Throwable th) {
            kotlin.jvm.internal.s.i(msg, "msg");
            boolean z10 = j.f12333b;
        }

        public final void e(boolean z10) {
            j.f12333b = z10;
        }

        public final void f(@Nullable String str, @NotNull String msg) {
            kotlin.jvm.internal.s.i(msg, "msg");
            boolean z10 = j.f12333b;
        }
    }

    public static final void a(@Nullable String str, @NotNull String str2) {
        f12332a.a(str, str2);
    }

    public static final void b(@Nullable String str, @NotNull String str2) {
        f12332a.f(str, str2);
    }
}
