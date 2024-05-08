package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.internal.ThreadContextKt;
import kotlinx.coroutines.s1;
import kotlinx.coroutines.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Combine.kt */
@kotlin.d
@td.d(c = "kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1", f = "Combine.kt", l = {129}, m = "invokeSuspend")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
final class CombineKt$zipImpl$1$1 extends SuspendLambda implements Function2<h0, Continuation<? super kotlin.p>, Object> {
    public final /* synthetic */ kotlinx.coroutines.flow.c<Object> $flow;
    public final /* synthetic */ kotlinx.coroutines.flow.c<Object> $flow2;
    public final /* synthetic */ kotlinx.coroutines.flow.d<Object> $this_unsafeFlow;
    public final /* synthetic */ Function3<Object, Object, Continuation<Object>, Object> $transform;
    private /* synthetic */ Object L$0;
    public int label;

    /* compiled from: Combine.kt */
    @kotlin.d
    @td.d(c = "kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2", f = "Combine.kt", l = {130}, m = "invokeSuspend")
    /* renamed from: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<kotlin.p, Continuation<? super kotlin.p>, Object> {
        public final /* synthetic */ Object $cnt;
        public final /* synthetic */ kotlinx.coroutines.flow.c<Object> $flow;
        public final /* synthetic */ CoroutineContext $scopeContext;
        public final /* synthetic */ ReceiveChannel<Object> $second;
        public final /* synthetic */ kotlinx.coroutines.flow.d<Object> $this_unsafeFlow;
        public final /* synthetic */ Function3<Object, Object, Continuation<Object>, Object> $transform;
        public int label;

        /* compiled from: Combine.kt */
        @kotlin.d
        /* renamed from: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1, reason: invalid class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
        public static final class AnonymousClass1<T> implements kotlinx.coroutines.flow.d {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ CoroutineContext f51310b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Object f51311c;

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ ReceiveChannel<Object> f51312d;

            /* renamed from: e, reason: collision with root package name */
            public final /* synthetic */ kotlinx.coroutines.flow.d<Object> f51313e;

            /* renamed from: f, reason: collision with root package name */
            public final /* synthetic */ Function3<Object, Object, Continuation<Object>, Object> f51314f;

            /* compiled from: Combine.kt */
            @kotlin.d
            @td.d(c = "kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1$1", f = "Combine.kt", l = {132, 135, 135}, m = "invokeSuspend")
            /* renamed from: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1$1, reason: invalid class name and collision with other inner class name */
            /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
            public static final class C07811 extends SuspendLambda implements Function2<kotlin.p, Continuation<? super kotlin.p>, Object> {
                public final /* synthetic */ ReceiveChannel<Object> $second;
                public final /* synthetic */ kotlinx.coroutines.flow.d<Object> $this_unsafeFlow;
                public final /* synthetic */ Function3<Object, Object, Continuation<Object>, Object> $transform;
                public final /* synthetic */ Object $value;
                public Object L$0;
                public int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                public C07811(ReceiveChannel<? extends Object> receiveChannel, kotlinx.coroutines.flow.d<Object> dVar, Function3<Object, Object, ? super Continuation<Object>, ? extends Object> function3, Object obj, Continuation<? super C07811> continuation) {
                    super(2, continuation);
                    this.$second = receiveChannel;
                    this.$this_unsafeFlow = dVar;
                    this.$transform = function3;
                    this.$value = obj;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @NotNull
                public final Continuation<kotlin.p> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                    return new C07811(this.$second, this.$this_unsafeFlow, this.$transform, this.$value, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                @Nullable
                /* renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
                public final Object mo1743invoke(@NotNull kotlin.p pVar, @Nullable Continuation<? super kotlin.p> continuation) {
                    return ((C07811) create(pVar, continuation)).invokeSuspend(kotlin.p.f51048a);
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x006e A[RETURN] */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @org.jetbrains.annotations.Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r9) {
                    /*
                        r8 = this;
                        java.lang.Object r0 = sd.a.d()
                        int r1 = r8.label
                        r2 = 0
                        r3 = 3
                        r4 = 2
                        r5 = 1
                        if (r1 == 0) goto L30
                        if (r1 == r5) goto L26
                        if (r1 == r4) goto L1e
                        if (r1 != r3) goto L16
                        kotlin.e.b(r9)
                        goto L6f
                    L16:
                        java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                        java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                        r9.<init>(r0)
                        throw r9
                    L1e:
                        java.lang.Object r1 = r8.L$0
                        kotlinx.coroutines.flow.d r1 = (kotlinx.coroutines.flow.d) r1
                        kotlin.e.b(r9)
                        goto L64
                    L26:
                        kotlin.e.b(r9)
                        kotlinx.coroutines.channels.ChannelResult r9 = (kotlinx.coroutines.channels.ChannelResult) r9
                        java.lang.Object r9 = r9.m3589unboximpl()
                        goto L3e
                    L30:
                        kotlin.e.b(r9)
                        kotlinx.coroutines.channels.ReceiveChannel<java.lang.Object> r9 = r8.$second
                        r8.label = r5
                        java.lang.Object r9 = r9.p(r8)
                        if (r9 != r0) goto L3e
                        return r0
                    L3e:
                        kotlinx.coroutines.flow.d<java.lang.Object> r1 = r8.$this_unsafeFlow
                        boolean r5 = r9 instanceof kotlinx.coroutines.channels.ChannelResult.Failed
                        if (r5 == 0) goto L50
                        java.lang.Throwable r9 = kotlinx.coroutines.channels.ChannelResult.m3581exceptionOrNullimpl(r9)
                        if (r9 != 0) goto L4f
                        kotlinx.coroutines.flow.internal.AbortFlowException r9 = new kotlinx.coroutines.flow.internal.AbortFlowException
                        r9.<init>(r1)
                    L4f:
                        throw r9
                    L50:
                        kotlin.jvm.functions.Function3<java.lang.Object, java.lang.Object, kotlin.coroutines.Continuation<java.lang.Object>, java.lang.Object> r5 = r8.$transform
                        java.lang.Object r6 = r8.$value
                        kotlinx.coroutines.internal.f0 r7 = kotlinx.coroutines.flow.internal.n.f51330a
                        if (r9 != r7) goto L59
                        r9 = r2
                    L59:
                        r8.L$0 = r1
                        r8.label = r4
                        java.lang.Object r9 = r5.invoke(r6, r9, r8)
                        if (r9 != r0) goto L64
                        return r0
                    L64:
                        r8.L$0 = r2
                        r8.label = r3
                        java.lang.Object r9 = r1.emit(r9, r8)
                        if (r9 != r0) goto L6f
                        return r0
                    L6f:
                        kotlin.p r9 = kotlin.p.f51048a
                        return r9
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1.AnonymousClass2.AnonymousClass1.C07811.invokeSuspend(java.lang.Object):java.lang.Object");
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            public AnonymousClass1(CoroutineContext coroutineContext, Object obj, ReceiveChannel<? extends Object> receiveChannel, kotlinx.coroutines.flow.d<Object> dVar, Function3<Object, Object, ? super Continuation<Object>, ? extends Object> function3) {
                this.f51310b = coroutineContext;
                this.f51311c = obj;
                this.f51312d = receiveChannel;
                this.f51313e = dVar;
                this.f51314f = function3;
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
            /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
            @Override // kotlinx.coroutines.flow.d
            @org.jetbrains.annotations.Nullable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object emit(java.lang.Object r13, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.p> r14) {
                /*
                    r12 = this;
                    boolean r0 = r14 instanceof kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1$emit$1
                    if (r0 == 0) goto L13
                    r0 = r14
                    kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1$emit$1 r0 = (kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1$emit$1) r0
                    int r1 = r0.label
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.label = r1
                    goto L18
                L13:
                    kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1$emit$1 r0 = new kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1$emit$1
                    r0.<init>(r12, r14)
                L18:
                    java.lang.Object r14 = r0.result
                    java.lang.Object r1 = sd.a.d()
                    int r2 = r0.label
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    kotlin.e.b(r14)
                    goto L51
                L29:
                    java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                    java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
                    r13.<init>(r14)
                    throw r13
                L31:
                    kotlin.e.b(r14)
                    kotlin.coroutines.CoroutineContext r14 = r12.f51310b
                    kotlin.p r2 = kotlin.p.f51048a
                    java.lang.Object r4 = r12.f51311c
                    kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1$1 r11 = new kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1$1
                    kotlinx.coroutines.channels.ReceiveChannel<java.lang.Object> r6 = r12.f51312d
                    kotlinx.coroutines.flow.d<java.lang.Object> r7 = r12.f51313e
                    kotlin.jvm.functions.Function3<java.lang.Object, java.lang.Object, kotlin.coroutines.Continuation<java.lang.Object>, java.lang.Object> r8 = r12.f51314f
                    r10 = 0
                    r5 = r11
                    r9 = r13
                    r5.<init>(r6, r7, r8, r9, r10)
                    r0.label = r3
                    java.lang.Object r13 = kotlinx.coroutines.flow.internal.d.b(r14, r2, r4, r11, r0)
                    if (r13 != r1) goto L51
                    return r1
                L51:
                    kotlin.p r13 = kotlin.p.f51048a
                    return r13
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1.AnonymousClass2.AnonymousClass1.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(kotlinx.coroutines.flow.c<Object> cVar, CoroutineContext coroutineContext, Object obj, ReceiveChannel<? extends Object> receiveChannel, kotlinx.coroutines.flow.d<Object> dVar, Function3<Object, Object, ? super Continuation<Object>, ? extends Object> function3, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$flow = cVar;
            this.$scopeContext = coroutineContext;
            this.$cnt = obj;
            this.$second = receiveChannel;
            this.$this_unsafeFlow = dVar;
            this.$transform = function3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<kotlin.p> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass2(this.$flow, this.$scopeContext, this.$cnt, this.$second, this.$this_unsafeFlow, this.$transform, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo1743invoke(@NotNull kotlin.p pVar, @Nullable Continuation<? super kotlin.p> continuation) {
            return ((AnonymousClass2) create(pVar, continuation)).invokeSuspend(kotlin.p.f51048a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object d10 = sd.a.d();
            int i10 = this.label;
            if (i10 == 0) {
                kotlin.e.b(obj);
                kotlinx.coroutines.flow.c<Object> cVar = this.$flow;
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$scopeContext, this.$cnt, this.$second, this.$this_unsafeFlow, this.$transform);
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
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CombineKt$zipImpl$1$1(kotlinx.coroutines.flow.d<Object> dVar, kotlinx.coroutines.flow.c<Object> cVar, kotlinx.coroutines.flow.c<Object> cVar2, Function3<Object, Object, ? super Continuation<Object>, ? extends Object> function3, Continuation<? super CombineKt$zipImpl$1$1> continuation) {
        super(2, continuation);
        this.$this_unsafeFlow = dVar;
        this.$flow2 = cVar;
        this.$flow = cVar2;
        this.$transform = function3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<kotlin.p> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        CombineKt$zipImpl$1$1 combineKt$zipImpl$1$1 = new CombineKt$zipImpl$1$1(this.$this_unsafeFlow, this.$flow2, this.$flow, this.$transform, continuation);
        combineKt$zipImpl$1$1.L$0 = obj;
        return combineKt$zipImpl$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    /* renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final Object mo1743invoke(@NotNull h0 h0Var, @Nullable Continuation<? super kotlin.p> continuation) {
        return ((CombineKt$zipImpl$1$1) create(h0Var, continuation)).invokeSuspend(kotlin.p.f51048a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v12, types: [kotlinx.coroutines.channels.ReceiveChannel] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v2, types: [kotlinx.coroutines.channels.ReceiveChannel] */
    /* JADX WARN: Type inference failed for: r1v5 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        final v b4;
        ReceiveChannel receiveChannel;
        ReceiveChannel receiveChannel2;
        CoroutineContext plus;
        kotlin.p pVar;
        AnonymousClass2 anonymousClass2;
        Object d10 = sd.a.d();
        ?? r12 = this.label;
        try {
            if (r12 != 0) {
                if (r12 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                receiveChannel2 = (ReceiveChannel) this.L$0;
                try {
                    kotlin.e.b(obj);
                    r12 = receiveChannel2;
                } catch (AbortFlowException e2) {
                    e = e2;
                }
                ReceiveChannel.DefaultImpls.a(r12, null, 1, null);
                return kotlin.p.f51048a;
            }
            kotlin.e.b(obj);
            h0 h0Var = (h0) this.L$0;
            ReceiveChannel d11 = ProduceKt.d(h0Var, null, 0, new CombineKt$zipImpl$1$1$second$1(this.$flow2, null), 3, null);
            b4 = s1.b(null, 1, null);
            final kotlinx.coroutines.flow.d<Object> dVar = this.$this_unsafeFlow;
            ((kotlinx.coroutines.channels.r) d11).k(new Function1<Throwable, kotlin.p>() { // from class: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ kotlin.p invoke(Throwable th) {
                    invoke2(th);
                    return kotlin.p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable Throwable th) {
                    if (v.this.isActive()) {
                        v.this.a(new AbortFlowException(dVar));
                    }
                }
            });
            try {
                CoroutineContext coroutineContext = h0Var.getCoroutineContext();
                Object b10 = ThreadContextKt.b(coroutineContext);
                plus = h0Var.getCoroutineContext().plus(b4);
                pVar = kotlin.p.f51048a;
                anonymousClass2 = new AnonymousClass2(this.$flow, coroutineContext, b10, d11, this.$this_unsafeFlow, this.$transform, null);
                this.L$0 = d11;
                this.label = 1;
                receiveChannel = d11;
            } catch (AbortFlowException e10) {
                e = e10;
                receiveChannel = d11;
            } catch (Throwable th) {
                th = th;
                receiveChannel = d11;
            }
            try {
            } catch (AbortFlowException e11) {
                e = e11;
                receiveChannel2 = receiveChannel;
                j.a(e, this.$this_unsafeFlow);
                r12 = receiveChannel2;
                ReceiveChannel.DefaultImpls.a(r12, null, 1, null);
                return kotlin.p.f51048a;
            } catch (Throwable th2) {
                th = th2;
                r12 = receiveChannel;
                ReceiveChannel.DefaultImpls.a(r12, null, 1, null);
                throw th;
            }
            if (d.c(plus, pVar, null, anonymousClass2, this, 4, null) == d10) {
                return d10;
            }
            r12 = receiveChannel;
            ReceiveChannel.DefaultImpls.a(r12, null, 1, null);
            return kotlin.p.f51048a;
            j.a(e, this.$this_unsafeFlow);
            r12 = receiveChannel2;
            ReceiveChannel.DefaultImpls.a(r12, null, 1, null);
            return kotlin.p.f51048a;
        } catch (Throwable th3) {
            th = th3;
        }
    }
}
