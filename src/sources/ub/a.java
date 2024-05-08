package ub;

import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: DefaultLogCat.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a implements b {
    @Override // ub.b
    public void a(@NotNull String tag, @Nullable String str, @Nullable Throwable th) {
        s.j(tag, "tag");
    }

    @Override // ub.b
    public void b(@NotNull String tag, @NotNull String msg) {
        s.j(tag, "tag");
        s.j(msg, "msg");
    }

    @Override // ub.b
    public void c(@NotNull String tag, @NotNull String msg) {
        s.j(tag, "tag");
        s.j(msg, "msg");
    }

    @Override // ub.b
    public void d(@NotNull String tag, @NotNull String msg) {
        s.j(tag, "tag");
        s.j(msg, "msg");
    }
}
