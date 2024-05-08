package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Emitters.kt */
@kotlin.d
@td.d(c = "kotlinx.coroutines.flow.FlowKt__EmittersKt$transform$1", f = "Emitters.kt", l = {40}, m = "invokeSuspend")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class FlowKt__EmittersKt$transform$1 extends SuspendLambda implements Function2<d<Object>, Continuation<? super kotlin.p>, Object> {
    public final /* synthetic */ c<Object> $this_transform;
    public final /* synthetic */ Function3<d<Object>, Object, Continuation<? super kotlin.p>, Object> $transform;
    private /* synthetic */ Object L$0;
    public int label;

    /* compiled from: Emitters.kt */
    @kotlin.d
    /* renamed from: kotlinx.coroutines.flow.FlowKt__EmittersKt$transform$1$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class AnonymousClass1<T> implements d {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function3<d<Object>, T, Continuation<? super kotlin.p>, Object> f51251b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ d<Object> f51252c;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Function3<? super d<Object>, ? super T, ? super Continuation<? super kotlin.p>, ? extends Object> function3, d<Object> dVar) {
            this.f51251b = function3;
            this.f51252c = dVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
        @Override // kotlinx.coroutines.flow.d
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object emit(T r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.p> r6) {
            /*
                r4 = this;
                boolean r0 = r6 instanceof kotlinx.coroutines.flow.FlowKt__EmittersKt$transform$1$1$emit$1
                if (r0 == 0) goto L13
                r0 = r6
                kotlinx.coroutines.flow.FlowKt__EmittersKt$transform$1$1$emit$1 r0 = (kotlinx.coroutines.flow.FlowKt__EmittersKt$transform$1$1$emit$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                kotlinx.coroutines.flow.FlowKt__EmittersKt$transform$1$1$emit$1 r0 = new kotlinx.coroutines.flow.FlowKt__EmittersKt$transform$1$1$emit$1
                r0.<init>(r4, r6)
            L18:
                java.lang.Object r6 = r0.result
                java.lang.Object r1 = sd.a.d()
                int r2 = r0.label
                r3 = 1
                if (r2 == 0) goto L31
                if (r2 != r3) goto L29
                kotlin.e.b(r6)
                goto L41
            L29:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L31:
                kotlin.e.b(r6)
                kotlin.jvm.functions.Function3<kotlinx.coroutines.flow.d<java.lang.Object>, T, kotlin.coroutines.Continuation<? super kotlin.p>, java.lang.Object> r6 = r4.f51251b
                kotlinx.coroutines.flow.d<java.lang.Object> r2 = r4.f51252c
                r0.label = r3
                java.lang.Object r5 = r6.invoke(r2, r5, r0)
                if (r5 != r1) goto L41
                return r1
            L41:
                kotlin.p r5 = kotlin.p.f51048a
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__EmittersKt$transform$1.AnonymousClass1.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__EmittersKt$transform$1(c<Object> cVar, Function3<? super d<Object>, Object, ? super Continuation<? super kotlin.p>, ? extends Object> function3, Continuation<? super FlowKt__EmittersKt$transform$1> continuation) {
        super(2, continuation);
        this.$this_transform = cVar;
        this.$transform = function3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<kotlin.p> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        FlowKt__EmittersKt$transform$1 flowKt__EmittersKt$transform$1 = new FlowKt__EmittersKt$transform$1(this.$this_transform, this.$transform, continuation);
        flowKt__EmittersKt$transform$1.L$0 = obj;
        return flowKt__EmittersKt$transform$1;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    /* renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final Object mo1743invoke(@NotNull d<Object> dVar, @Nullable Continuation<? super kotlin.p> continuation) {
        return ((FlowKt__EmittersKt$transform$1) create(dVar, continuation)).invokeSuspend(kotlin.p.f51048a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object d10 = sd.a.d();
        int i10 = this.label;
        if (i10 == 0) {
            kotlin.e.b(obj);
            d dVar = (d) this.L$0;
            c<Object> cVar = this.$this_transform;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$transform, dVar);
            this.label = 1;
            if (cVar.a(anonymousClass1, this) == d10) {
                return d10;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.e.b(obj);
        }
        return kotlin.p.f51048a;
    }

    @Nullable
    public final Object invokeSuspend$$forInline(@NotNull Object obj) {
        d dVar = (d) this.L$0;
        c<Object> cVar = this.$this_transform;
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$transform, dVar);
        kotlin.jvm.internal.r.c(0);
        cVar.a(anonymousClass1, this);
        kotlin.jvm.internal.r.c(1);
        return kotlin.p.f51048a;
    }
}
