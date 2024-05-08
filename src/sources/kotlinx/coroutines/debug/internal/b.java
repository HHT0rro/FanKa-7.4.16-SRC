package kotlinx.coroutines.debug.internal;

import java.util.List;
import kotlin.coroutines.CoroutineContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: DebugCoroutineInfo.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public final CoroutineContext f51205a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public final td.c f51206b;

    /* renamed from: c, reason: collision with root package name */
    public final long f51207c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public final List<StackTraceElement> f51208d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public final String f51209e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public final Thread f51210f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public final td.c f51211g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public final List<StackTraceElement> f51212h;

    public b(@NotNull c cVar, @NotNull CoroutineContext coroutineContext) {
        this.f51205a = coroutineContext;
        cVar.c();
        this.f51206b = null;
        this.f51207c = cVar.f51213a;
        this.f51208d = cVar.d();
        this.f51209e = cVar.f();
        this.f51210f = cVar.f51214b;
        this.f51211g = cVar.e();
        this.f51212h = cVar.g();
    }
}
