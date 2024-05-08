package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SendingCollector.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class p<T> implements kotlinx.coroutines.flow.d<T> {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final kotlinx.coroutines.channels.r<T> f51333b;

    /* JADX WARN: Multi-variable type inference failed */
    public p(@NotNull kotlinx.coroutines.channels.r<? super T> rVar) {
        this.f51333b = rVar;
    }

    @Override // kotlinx.coroutines.flow.d
    @Nullable
    public Object emit(T t2, @NotNull Continuation<? super kotlin.p> continuation) {
        Object E = this.f51333b.E(t2, continuation);
        return E == sd.a.d() ? E : kotlin.p.f51048a;
    }
}
