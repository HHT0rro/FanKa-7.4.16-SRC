package fe;

import ce.n;
import java.util.concurrent.TimeUnit;
import kotlinx.coroutines.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: Tasks.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public static final long f49337a = g0.g("kotlinx.coroutines.scheduler.resolution.ns", 100000, 0, 0, 12, null);

    /* renamed from: b, reason: collision with root package name */
    public static final int f49338b = g0.f("kotlinx.coroutines.scheduler.core.pool.size", n.b(g0.a(), 2), 1, 0, 8, null);

    /* renamed from: c, reason: collision with root package name */
    public static final int f49339c = g0.f("kotlinx.coroutines.scheduler.max.pool.size", 2097150, 0, 2097150, 4, null);

    /* renamed from: d, reason: collision with root package name */
    public static final long f49340d = TimeUnit.SECONDS.toNanos(g0.g("kotlinx.coroutines.scheduler.keep.alive.sec", 60, 0, 0, 12, null));

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public static f f49341e = d.f49327a;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public static final h f49342f = new i(0);

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public static final h f49343g = new i(1);
}
