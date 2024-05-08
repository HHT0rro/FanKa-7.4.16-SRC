package kotlinx.coroutines;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: JobSupport.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class v1 {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final kotlinx.coroutines.internal.f0 f51547a = new kotlinx.coroutines.internal.f0("COMPLETING_ALREADY");

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final kotlinx.coroutines.internal.f0 f51548b = new kotlinx.coroutines.internal.f0("COMPLETING_WAITING_CHILDREN");

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final kotlinx.coroutines.internal.f0 f51549c = new kotlinx.coroutines.internal.f0("COMPLETING_RETRY");

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final kotlinx.coroutines.internal.f0 f51550d = new kotlinx.coroutines.internal.f0("TOO_LATE_TO_CANCEL");

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public static final kotlinx.coroutines.internal.f0 f51551e = new kotlinx.coroutines.internal.f0("SEALED");

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public static final w0 f51552f = new w0(false);

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public static final w0 f51553g = new w0(true);

    public static final /* synthetic */ kotlinx.coroutines.internal.f0 a() {
        return f51547a;
    }

    public static final /* synthetic */ kotlinx.coroutines.internal.f0 b() {
        return f51549c;
    }

    public static final /* synthetic */ w0 c() {
        return f51553g;
    }

    public static final /* synthetic */ w0 d() {
        return f51552f;
    }

    public static final /* synthetic */ kotlinx.coroutines.internal.f0 e() {
        return f51551e;
    }

    public static final /* synthetic */ kotlinx.coroutines.internal.f0 f() {
        return f51550d;
    }

    @Nullable
    public static final Object g(@Nullable Object obj) {
        return obj instanceof h1 ? new i1((h1) obj) : obj;
    }

    @Nullable
    public static final Object h(@Nullable Object obj) {
        h1 h1Var;
        i1 i1Var = obj instanceof i1 ? (i1) obj : null;
        return (i1Var == null || (h1Var = i1Var.f51352a) == null) ? obj : h1Var;
    }
}
