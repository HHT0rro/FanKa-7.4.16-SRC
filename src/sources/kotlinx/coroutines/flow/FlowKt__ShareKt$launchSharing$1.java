package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Share.kt */
@kotlin.d
@td.d(c = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1", f = "Share.kt", l = {214, 218, 219, 225}, m = "invokeSuspend")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
final class FlowKt__ShareKt$launchSharing$1 extends SuspendLambda implements Function2<kotlinx.coroutines.h0, Continuation<? super kotlin.p>, Object> {
    public final /* synthetic */ Object $initialValue;
    public final /* synthetic */ f1<Object> $shared;
    public final /* synthetic */ m1 $started;
    public final /* synthetic */ c<Object> $upstream;
    public int label;

    /* compiled from: Share.kt */
    @kotlin.d
    @td.d(c = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$1", f = "Share.kt", l = {}, m = "invokeSuspend")
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<Integer, Continuation<? super Boolean>, Object> {
        public /* synthetic */ int I$0;
        public int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<kotlin.p> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
            anonymousClass1.I$0 = ((Number) obj).intValue();
            return anonymousClass1;
        }

        @Nullable
        public final Object invoke(int i10, @Nullable Continuation<? super Boolean> continuation) {
            return ((AnonymousClass1) create(Integer.valueOf(i10), continuation)).invokeSuspend(kotlin.p.f51048a);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo1743invoke(Integer num, Continuation<? super Boolean> continuation) {
            return invoke(num.intValue(), continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            sd.a.d();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.e.b(obj);
            return td.a.a(this.I$0 > 0);
        }
    }

    /* compiled from: Share.kt */
    @kotlin.d
    @td.d(c = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$2", f = "Share.kt", l = {227}, m = "invokeSuspend")
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$2, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<SharingCommand, Continuation<? super kotlin.p>, Object> {
        public final /* synthetic */ Object $initialValue;
        public final /* synthetic */ f1<Object> $shared;
        public final /* synthetic */ c<Object> $upstream;
        public /* synthetic */ Object L$0;
        public int label;

        /* compiled from: Share.kt */
        @kotlin.d
        /* renamed from: kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$2$a */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
        public /* synthetic */ class a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f51273a;

            static {
                int[] iArr = new int[SharingCommand.values().length];
                iArr[SharingCommand.START.ordinal()] = 1;
                iArr[SharingCommand.STOP.ordinal()] = 2;
                iArr[SharingCommand.STOP_AND_RESET_REPLAY_CACHE.ordinal()] = 3;
                f51273a = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(c<Object> cVar, f1<Object> f1Var, Object obj, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$upstream = cVar;
            this.$shared = f1Var;
            this.$initialValue = obj;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<kotlin.p> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$upstream, this.$shared, this.$initialValue, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo1743invoke(@NotNull SharingCommand sharingCommand, @Nullable Continuation<? super kotlin.p> continuation) {
            return ((AnonymousClass2) create(sharingCommand, continuation)).invokeSuspend(kotlin.p.f51048a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object d10 = sd.a.d();
            int i10 = this.label;
            if (i10 == 0) {
                kotlin.e.b(obj);
                int i11 = a.f51273a[((SharingCommand) this.L$0).ordinal()];
                if (i11 == 1) {
                    c<Object> cVar = this.$upstream;
                    f1<Object> f1Var = this.$shared;
                    this.label = 1;
                    if (cVar.a(f1Var, this) == d10) {
                        return d10;
                    }
                } else if (i11 == 3) {
                    Object obj2 = this.$initialValue;
                    if (obj2 == k1.f51336a) {
                        this.$shared.j();
                    } else {
                        this.$shared.k(obj2);
                    }
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
    public FlowKt__ShareKt$launchSharing$1(m1 m1Var, c<Object> cVar, f1<Object> f1Var, Object obj, Continuation<? super FlowKt__ShareKt$launchSharing$1> continuation) {
        super(2, continuation);
        this.$started = m1Var;
        this.$upstream = cVar;
        this.$shared = f1Var;
        this.$initialValue = obj;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<kotlin.p> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FlowKt__ShareKt$launchSharing$1(this.$started, this.$upstream, this.$shared, this.$initialValue, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    /* renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final Object mo1743invoke(@NotNull kotlinx.coroutines.h0 h0Var, @Nullable Continuation<? super kotlin.p> continuation) {
        return ((FlowKt__ShareKt$launchSharing$1) create(h0Var, continuation)).invokeSuspend(kotlin.p.f51048a);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0068 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = sd.a.d()
            int r1 = r7.label
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L25
            if (r1 == r5) goto L21
            if (r1 == r4) goto L1d
            if (r1 == r3) goto L21
            if (r1 != r2) goto L15
            goto L21
        L15:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L1d:
            kotlin.e.b(r8)
            goto L5c
        L21:
            kotlin.e.b(r8)
            goto L8d
        L25:
            kotlin.e.b(r8)
            kotlinx.coroutines.flow.m1 r8 = r7.$started
            kotlinx.coroutines.flow.m1$a r1 = kotlinx.coroutines.flow.m1.f51339a
            kotlinx.coroutines.flow.m1 r6 = r1.a()
            if (r8 != r6) goto L3f
            kotlinx.coroutines.flow.c<java.lang.Object> r8 = r7.$upstream
            kotlinx.coroutines.flow.f1<java.lang.Object> r1 = r7.$shared
            r7.label = r5
            java.lang.Object r8 = r8.a(r1, r7)
            if (r8 != r0) goto L8d
            return r0
        L3f:
            kotlinx.coroutines.flow.m1 r8 = r7.$started
            kotlinx.coroutines.flow.m1 r1 = r1.b()
            r5 = 0
            if (r8 != r1) goto L69
            kotlinx.coroutines.flow.f1<java.lang.Object> r8 = r7.$shared
            kotlinx.coroutines.flow.p1 r8 = r8.o()
            kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$1 r1 = new kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$1
            r1.<init>(r5)
            r7.label = r4
            java.lang.Object r8 = kotlinx.coroutines.flow.e.p(r8, r1, r7)
            if (r8 != r0) goto L5c
            return r0
        L5c:
            kotlinx.coroutines.flow.c<java.lang.Object> r8 = r7.$upstream
            kotlinx.coroutines.flow.f1<java.lang.Object> r1 = r7.$shared
            r7.label = r3
            java.lang.Object r8 = r8.a(r1, r7)
            if (r8 != r0) goto L8d
            return r0
        L69:
            kotlinx.coroutines.flow.m1 r8 = r7.$started
            kotlinx.coroutines.flow.f1<java.lang.Object> r1 = r7.$shared
            kotlinx.coroutines.flow.p1 r1 = r1.o()
            kotlinx.coroutines.flow.c r8 = r8.a(r1)
            kotlinx.coroutines.flow.c r8 = kotlinx.coroutines.flow.e.k(r8)
            kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$2 r1 = new kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$2
            kotlinx.coroutines.flow.c<java.lang.Object> r3 = r7.$upstream
            kotlinx.coroutines.flow.f1<java.lang.Object> r4 = r7.$shared
            java.lang.Object r6 = r7.$initialValue
            r1.<init>(r3, r4, r6, r5)
            r7.label = r2
            java.lang.Object r8 = kotlinx.coroutines.flow.e.g(r8, r1, r7)
            if (r8 != r0) goto L8d
            return r0
        L8d:
            kotlin.p r8 = kotlin.p.f51048a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
