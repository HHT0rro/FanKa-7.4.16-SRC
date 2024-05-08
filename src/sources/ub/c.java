package ub;

import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: LogUtils.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f54010a = new c();

    public final void a(@NotNull String tag, @NotNull String msg) {
        b a10;
        s.j(tag, "tag");
        s.j(msg, "msg");
        d dVar = d.f54013c;
        if (dVar.b() && (a10 = dVar.a()) != null) {
            a10.b(tag, msg);
        }
    }

    public final void b(@NotNull String tag, @NotNull String msg) {
        b a10;
        s.j(tag, "tag");
        s.j(msg, "msg");
        d dVar = d.f54013c;
        if (dVar.b() && (a10 = dVar.a()) != null) {
            a10.a(tag, msg, null);
        }
    }

    public final void c(@NotNull String tag, @NotNull String msg, @NotNull Throwable error) {
        b a10;
        s.j(tag, "tag");
        s.j(msg, "msg");
        s.j(error, "error");
        d dVar = d.f54013c;
        if (dVar.b() && (a10 = dVar.a()) != null) {
            a10.a(tag, msg, error);
        }
    }

    public final void d(@NotNull String tag, @NotNull Throwable error) {
        b a10;
        s.j(tag, "tag");
        s.j(error, "error");
        d dVar = d.f54013c;
        if (dVar.b() && (a10 = dVar.a()) != null) {
            a10.a(tag, error.getMessage(), error);
        }
    }

    public final void e(@NotNull String tag, @NotNull String msg) {
        b a10;
        s.j(tag, "tag");
        s.j(msg, "msg");
        d dVar = d.f54013c;
        if (dVar.b() && (a10 = dVar.a()) != null) {
            a10.d(tag, msg);
        }
    }

    public final void f(@NotNull String tag, @NotNull String msg) {
        b a10;
        s.j(tag, "tag");
        s.j(msg, "msg");
        d dVar = d.f54013c;
        if (dVar.b() && (a10 = dVar.a()) != null) {
            a10.c(tag, msg);
        }
    }
}
