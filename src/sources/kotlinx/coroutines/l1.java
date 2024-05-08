package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: JobSupport.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class l1 extends o1 {

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f51437g = AtomicIntegerFieldUpdater.newUpdater(l1.class, "_invoked");

    @NotNull
    private volatile /* synthetic */ int _invoked = 0;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public final Function1<Throwable, kotlin.p> f51438f;

    /* JADX WARN: Multi-variable type inference failed */
    public l1(@NotNull Function1<? super Throwable, kotlin.p> function1) {
        this.f51438f = function1;
    }

    @Override // kotlinx.coroutines.z
    public void P(@Nullable Throwable th) {
        if (f51437g.compareAndSet(this, 0, 1)) {
            this.f51438f.invoke(th);
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ kotlin.p invoke(Throwable th) {
        P(th);
        return kotlin.p.f51048a;
    }
}
