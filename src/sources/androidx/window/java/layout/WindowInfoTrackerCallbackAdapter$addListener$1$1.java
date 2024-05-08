package androidx.window.java.layout;

import androidx.core.util.Consumer;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.d;
import kotlin.e;
import kotlin.jvm.functions.Function2;
import kotlin.p;
import kotlinx.coroutines.flow.c;
import kotlinx.coroutines.h0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sd.a;

/* compiled from: WindowInfoTrackerCallbackAdapter.kt */
@d
@td.d(c = "androidx.window.java.layout.WindowInfoTrackerCallbackAdapter$addListener$1$1", f = "WindowInfoTrackerCallbackAdapter.kt", l = {96}, m = "invokeSuspend")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class WindowInfoTrackerCallbackAdapter$addListener$1$1 extends SuspendLambda implements Function2<h0, Continuation<? super p>, Object> {
    public final /* synthetic */ Consumer<T> $consumer;
    public final /* synthetic */ c<T> $flow;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public WindowInfoTrackerCallbackAdapter$addListener$1$1(c<? extends T> cVar, Consumer<T> consumer, Continuation<? super WindowInfoTrackerCallbackAdapter$addListener$1$1> continuation) {
        super(2, continuation);
        this.$flow = cVar;
        this.$consumer = consumer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<p> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WindowInfoTrackerCallbackAdapter$addListener$1$1(this.$flow, this.$consumer, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    /* renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final Object mo1743invoke(@NotNull h0 h0Var, @Nullable Continuation<? super p> continuation) {
        return ((WindowInfoTrackerCallbackAdapter$addListener$1$1) create(h0Var, continuation)).invokeSuspend(p.f51048a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object d10 = a.d();
        int i10 = this.label;
        if (i10 == 0) {
            e.b(obj);
            c<T> cVar = this.$flow;
            final Consumer<T> consumer = this.$consumer;
            Object obj2 = new kotlinx.coroutines.flow.d<T>() { // from class: androidx.window.java.layout.WindowInfoTrackerCallbackAdapter$addListener$1$1$invokeSuspend$$inlined$collect$1
                @Override // kotlinx.coroutines.flow.d
                @Nullable
                public Object emit(T t2, @NotNull Continuation<? super p> continuation) {
                    Consumer.this.accept(t2);
                    return p.f51048a;
                }
            };
            this.label = 1;
            if (cVar.a(obj2, this) == d10) {
                return d10;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            e.b(obj);
        }
        return p.f51048a;
    }
}
