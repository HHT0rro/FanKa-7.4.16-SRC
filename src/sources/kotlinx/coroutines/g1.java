package kotlinx.coroutines;

import org.jetbrains.annotations.NotNull;

/* compiled from: JobSupport.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class g1 implements h1 {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final y1 f51350b;

    public g1(@NotNull y1 y1Var) {
        this.f51350b = y1Var;
    }

    @Override // kotlinx.coroutines.h1
    @NotNull
    public y1 c() {
        return this.f51350b;
    }

    @Override // kotlinx.coroutines.h1
    public boolean isActive() {
        return false;
    }

    @NotNull
    public String toString() {
        return super.toString();
    }
}
