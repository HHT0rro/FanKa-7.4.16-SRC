package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Share.kt */
@kotlin.d
@td.d(c = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharingDeferred$1", f = "Share.kt", l = {340}, m = "invokeSuspend")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
final class FlowKt__ShareKt$launchSharingDeferred$1 extends SuspendLambda implements Function2<kotlinx.coroutines.h0, Continuation<? super kotlin.p>, Object> {
    public final /* synthetic */ kotlinx.coroutines.u<p1<Object>> $result;
    public final /* synthetic */ c<Object> $upstream;
    private /* synthetic */ Object L$0;
    public int label;

    /* compiled from: Share.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class a<T> implements d {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Ref$ObjectRef<g1<T>> f51274b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ kotlinx.coroutines.h0 f51275c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ kotlinx.coroutines.u<p1<T>> f51276d;

        public a(Ref$ObjectRef<g1<T>> ref$ObjectRef, kotlinx.coroutines.h0 h0Var, kotlinx.coroutines.u<p1<T>> uVar) {
            this.f51274b = ref$ObjectRef;
            this.f51275c = h0Var;
            this.f51276d = uVar;
        }

        /* JADX WARN: Type inference failed for: r4v2, types: [kotlinx.coroutines.flow.p1, T, kotlinx.coroutines.flow.g1] */
        @Override // kotlinx.coroutines.flow.d
        @Nullable
        public final Object emit(T t2, @NotNull Continuation<? super kotlin.p> continuation) {
            kotlin.p pVar;
            g1<T> g1Var = this.f51274b.element;
            if (g1Var != null) {
                g1Var.setValue(t2);
                pVar = kotlin.p.f51048a;
            } else {
                pVar = null;
            }
            if (pVar == null) {
                kotlinx.coroutines.h0 h0Var = this.f51275c;
                Ref$ObjectRef<g1<T>> ref$ObjectRef = this.f51274b;
                kotlinx.coroutines.u<p1<T>> uVar = this.f51276d;
                ?? r42 = (T) q1.a(t2);
                uVar.i(new h1(r42, kotlinx.coroutines.q1.i(h0Var.getCoroutineContext())));
                ref$ObjectRef.element = r42;
            }
            return kotlin.p.f51048a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__ShareKt$launchSharingDeferred$1(c<Object> cVar, kotlinx.coroutines.u<p1<Object>> uVar, Continuation<? super FlowKt__ShareKt$launchSharingDeferred$1> continuation) {
        super(2, continuation);
        this.$upstream = cVar;
        this.$result = uVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<kotlin.p> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        FlowKt__ShareKt$launchSharingDeferred$1 flowKt__ShareKt$launchSharingDeferred$1 = new FlowKt__ShareKt$launchSharingDeferred$1(this.$upstream, this.$result, continuation);
        flowKt__ShareKt$launchSharingDeferred$1.L$0 = obj;
        return flowKt__ShareKt$launchSharingDeferred$1;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    /* renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final Object mo1743invoke(@NotNull kotlinx.coroutines.h0 h0Var, @Nullable Continuation<? super kotlin.p> continuation) {
        return ((FlowKt__ShareKt$launchSharingDeferred$1) create(h0Var, continuation)).invokeSuspend(kotlin.p.f51048a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object d10 = sd.a.d();
        int i10 = this.label;
        try {
            if (i10 == 0) {
                kotlin.e.b(obj);
                kotlinx.coroutines.h0 h0Var = (kotlinx.coroutines.h0) this.L$0;
                Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
                c<Object> cVar = this.$upstream;
                a aVar = new a(ref$ObjectRef, h0Var, this.$result);
                this.label = 1;
                if (cVar.a(aVar, this) == d10) {
                    return d10;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.e.b(obj);
            }
            return kotlin.p.f51048a;
        } catch (Throwable th) {
            this.$result.g(th);
            throw th;
        }
    }
}
