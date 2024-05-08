package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.ChannelFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Builders.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class b<T> extends ChannelFlow<T> {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public final Function2<kotlinx.coroutines.channels.m<? super T>, Continuation<? super kotlin.p>, Object> f51295e;

    /* JADX WARN: Multi-variable type inference failed */
    public b(@NotNull Function2<? super kotlinx.coroutines.channels.m<? super T>, ? super Continuation<? super kotlin.p>, ? extends Object> function2, @NotNull CoroutineContext coroutineContext, int i10, @NotNull BufferOverflow bufferOverflow) {
        super(coroutineContext, i10, bufferOverflow);
        this.f51295e = function2;
    }

    public static /* synthetic */ Object l(b bVar, kotlinx.coroutines.channels.m mVar, Continuation continuation) {
        Object mo1743invoke = bVar.f51295e.mo1743invoke(mVar, continuation);
        return mo1743invoke == sd.a.d() ? mo1743invoke : kotlin.p.f51048a;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    @Nullable
    public Object e(@NotNull kotlinx.coroutines.channels.m<? super T> mVar, @NotNull Continuation<? super kotlin.p> continuation) {
        return l(this, mVar, continuation);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    @NotNull
    public String toString() {
        return "block[" + ((Object) this.f51295e) + "] -> " + super.toString();
    }
}
