package kotlinx.coroutines;

import org.jetbrains.annotations.NotNull;

/* compiled from: EventLoop.common.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class b1 {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final kotlinx.coroutines.internal.f0 f51132a = new kotlinx.coroutines.internal.f0("REMOVED_TASK");

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final kotlinx.coroutines.internal.f0 f51133b = new kotlinx.coroutines.internal.f0("CLOSED_EMPTY");

    public static final long c(long j10) {
        return j10 / 1000000;
    }

    public static final long d(long j10) {
        if (j10 <= 0) {
            return 0L;
        }
        if (j10 >= 9223372036854L) {
            return Long.MAX_VALUE;
        }
        return 1000000 * j10;
    }
}
