package kotlinx.coroutines;

import org.jetbrains.annotations.NotNull;

/* compiled from: EventLoop.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class f extends y0 {

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public final Thread f51232g;

    public f(@NotNull Thread thread) {
        this.f51232g = thread;
    }

    @Override // kotlinx.coroutines.z0
    @NotNull
    public Thread J() {
        return this.f51232g;
    }
}
