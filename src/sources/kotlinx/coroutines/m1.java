package kotlinx.coroutines;

import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: JobSupport.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class m1 extends t1 {

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public final Function1<Throwable, kotlin.p> f51445f;

    /* JADX WARN: Multi-variable type inference failed */
    public m1(@NotNull Function1<? super Throwable, kotlin.p> function1) {
        this.f51445f = function1;
    }

    @Override // kotlinx.coroutines.z
    public void P(@Nullable Throwable th) {
        this.f51445f.invoke(th);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ kotlin.p invoke(Throwable th) {
        P(th);
        return kotlin.p.f51048a;
    }
}
