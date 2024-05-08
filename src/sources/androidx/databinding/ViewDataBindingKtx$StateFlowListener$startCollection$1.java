package androidx.databinding;

import androidx.databinding.ViewDataBindingKtx;
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

/* compiled from: ViewDataBindingKtx.kt */
@d
@td.d(c = "androidx.databinding.ViewDataBindingKtx$StateFlowListener$startCollection$1", f = "ViewDataBindingKtx.kt", l = {116}, m = "invokeSuspend")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ViewDataBindingKtx$StateFlowListener$startCollection$1 extends SuspendLambda implements Function2<h0, Continuation<? super p>, Object> {
    public final /* synthetic */ c<Object> $flow;
    public int label;
    public final /* synthetic */ ViewDataBindingKtx.StateFlowListener this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewDataBindingKtx$StateFlowListener$startCollection$1(c<? extends Object> cVar, ViewDataBindingKtx.StateFlowListener stateFlowListener, Continuation<? super ViewDataBindingKtx$StateFlowListener$startCollection$1> continuation) {
        super(2, continuation);
        this.$flow = cVar;
        this.this$0 = stateFlowListener;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<p> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ViewDataBindingKtx$StateFlowListener$startCollection$1(this.$flow, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    /* renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final Object mo1743invoke(@NotNull h0 h0Var, @Nullable Continuation<? super p> continuation) {
        return ((ViewDataBindingKtx$StateFlowListener$startCollection$1) create(h0Var, continuation)).invokeSuspend(p.f51048a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object d10 = a.d();
        int i10 = this.label;
        if (i10 == 0) {
            e.b(obj);
            c<Object> cVar = this.$flow;
            final ViewDataBindingKtx.StateFlowListener stateFlowListener = this.this$0;
            kotlinx.coroutines.flow.d<? super Object> dVar = new kotlinx.coroutines.flow.d<Object>() { // from class: androidx.databinding.ViewDataBindingKtx$StateFlowListener$startCollection$1$invokeSuspend$$inlined$collect$1
                @Override // kotlinx.coroutines.flow.d
                @Nullable
                public Object emit(Object obj2, @NotNull Continuation continuation) {
                    WeakListener weakListener;
                    WeakListener weakListener2;
                    WeakListener weakListener3;
                    p pVar;
                    weakListener = ViewDataBindingKtx.StateFlowListener.this.listener;
                    ViewDataBinding binder = weakListener.getBinder();
                    if (binder == null) {
                        pVar = null;
                    } else {
                        weakListener2 = ViewDataBindingKtx.StateFlowListener.this.listener;
                        int i11 = weakListener2.mLocalFieldId;
                        weakListener3 = ViewDataBindingKtx.StateFlowListener.this.listener;
                        binder.handleFieldChange(i11, weakListener3.getTarget(), 0);
                        pVar = p.f51048a;
                    }
                    return pVar == a.d() ? pVar : p.f51048a;
                }
            };
            this.label = 1;
            if (cVar.a(dVar, this) == d10) {
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
