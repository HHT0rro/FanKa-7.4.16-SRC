package kotlinx.coroutines;

import org.jetbrains.annotations.NotNull;

/* compiled from: Executors.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class e2 implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final CoroutineDispatcher f51230b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public final l<kotlin.p> f51231c;

    /* JADX WARN: Multi-variable type inference failed */
    public e2(@NotNull CoroutineDispatcher coroutineDispatcher, @NotNull l<? super kotlin.p> lVar) {
        this.f51230b = coroutineDispatcher;
        this.f51231c = lVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f51231c.C(this.f51230b, kotlin.p.f51048a);
    }
}
