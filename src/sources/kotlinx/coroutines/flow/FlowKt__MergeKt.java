package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest;
import org.jetbrains.annotations.NotNull;

/* compiled from: Merge.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final /* synthetic */ class FlowKt__MergeKt {

    /* renamed from: a, reason: collision with root package name */
    public static final int f51258a = kotlinx.coroutines.internal.g0.b("kotlinx.coroutines.flow.defaultConcurrency", 16, 1, Integer.MAX_VALUE);

    @NotNull
    public static final <T, R> c<R> a(@NotNull c<? extends T> cVar, @NotNull Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2) {
        return e.D(cVar, new FlowKt__MergeKt$mapLatest$1(function2, null));
    }

    @NotNull
    public static final <T, R> c<R> b(@NotNull c<? extends T> cVar, @NotNull Function3<? super d<? super R>, ? super T, ? super Continuation<? super kotlin.p>, ? extends Object> function3) {
        return new ChannelFlowTransformLatest(function3, cVar, null, 0, null, 28, null);
    }
}
