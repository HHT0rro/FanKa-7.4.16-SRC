package kotlinx.coroutines.flow.internal;

import java.util.ArrayList;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.s;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.j0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ChannelFlow.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class ChannelFlow<T> implements k<T> {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final CoroutineContext f51299b;

    /* renamed from: c, reason: collision with root package name */
    public final int f51300c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public final BufferOverflow f51301d;

    public ChannelFlow(@NotNull CoroutineContext coroutineContext, int i10, @NotNull BufferOverflow bufferOverflow) {
        this.f51299b = coroutineContext;
        this.f51300c = i10;
        this.f51301d = bufferOverflow;
    }

    public static /* synthetic */ Object d(ChannelFlow channelFlow, kotlinx.coroutines.flow.d dVar, Continuation continuation) {
        Object b4 = i0.b(new ChannelFlow$collect$2(dVar, channelFlow, null), continuation);
        return b4 == sd.a.d() ? b4 : kotlin.p.f51048a;
    }

    @Override // kotlinx.coroutines.flow.c
    @Nullable
    public Object a(@NotNull kotlinx.coroutines.flow.d<? super T> dVar, @NotNull Continuation<? super kotlin.p> continuation) {
        return d(this, dVar, continuation);
    }

    @Override // kotlinx.coroutines.flow.internal.k
    @NotNull
    public kotlinx.coroutines.flow.c<T> b(@NotNull CoroutineContext coroutineContext, int i10, @NotNull BufferOverflow bufferOverflow) {
        CoroutineContext plus = coroutineContext.plus(this.f51299b);
        if (bufferOverflow == BufferOverflow.SUSPEND) {
            int i11 = this.f51300c;
            if (i11 != -3) {
                if (i10 != -3) {
                    if (i11 != -2) {
                        if (i10 != -2 && (i11 = i11 + i10) < 0) {
                            i10 = Integer.MAX_VALUE;
                        }
                    }
                }
                i10 = i11;
            }
            bufferOverflow = this.f51301d;
        }
        return (s.d(plus, this.f51299b) && i10 == this.f51300c && bufferOverflow == this.f51301d) ? this : f(plus, i10, bufferOverflow);
    }

    @Nullable
    public String c() {
        return null;
    }

    @Nullable
    public abstract Object e(@NotNull kotlinx.coroutines.channels.m<? super T> mVar, @NotNull Continuation<? super kotlin.p> continuation);

    @NotNull
    public abstract ChannelFlow<T> f(@NotNull CoroutineContext coroutineContext, int i10, @NotNull BufferOverflow bufferOverflow);

    @NotNull
    public final Function2<kotlinx.coroutines.channels.m<? super T>, Continuation<? super kotlin.p>, Object> g() {
        return new ChannelFlow$collectToFun$1(this, null);
    }

    public final int h() {
        int i10 = this.f51300c;
        if (i10 == -3) {
            return -2;
        }
        return i10;
    }

    @NotNull
    public ReceiveChannel<T> i(@NotNull h0 h0Var) {
        return ProduceKt.e(h0Var, this.f51299b, h(), this.f51301d, CoroutineStart.ATOMIC, null, g(), 16, null);
    }

    @NotNull
    public String toString() {
        ArrayList arrayList = new ArrayList(4);
        String c4 = c();
        if (c4 != null) {
            arrayList.add(c4);
        }
        if (this.f51299b != EmptyCoroutineContext.INSTANCE) {
            arrayList.add("context=" + ((Object) this.f51299b));
        }
        if (this.f51300c != -3) {
            arrayList.add("capacity=" + this.f51300c);
        }
        if (this.f51301d != BufferOverflow.SUSPEND) {
            arrayList.add("onBufferOverflow=" + ((Object) this.f51301d));
        }
        return j0.a(this) + '[' + CollectionsKt___CollectionsKt.c0(arrayList, ", ", null, null, 0, null, null, 62, null) + ']';
    }
}
