package kotlinx.coroutines.flow.internal;

import java.util.concurrent.atomic.AtomicInteger;
import kotlin.collections.d0;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.channels.r;
import kotlinx.coroutines.h0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Combine.kt */
@kotlin.d
@td.d(c = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2", f = "Combine.kt", l = {57, 79, 82}, m = "invokeSuspend")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class CombineKt$combineInternal$2 extends SuspendLambda implements Function2<h0, Continuation<? super kotlin.p>, Object> {
    public final /* synthetic */ Function0<T[]> $arrayFactory;
    public final /* synthetic */ kotlinx.coroutines.flow.c<T>[] $flows;
    public final /* synthetic */ kotlinx.coroutines.flow.d<R> $this_combineInternal;
    public final /* synthetic */ Function3<kotlinx.coroutines.flow.d<? super R>, T[], Continuation<? super kotlin.p>, Object> $transform;
    public int I$0;
    public int I$1;
    private /* synthetic */ Object L$0;
    public Object L$1;
    public Object L$2;
    public int label;

    /* compiled from: Combine.kt */
    @kotlin.d
    @td.d(c = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1", f = "Combine.kt", l = {34}, m = "invokeSuspend")
    /* renamed from: kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<h0, Continuation<? super kotlin.p>, Object> {
        public final /* synthetic */ kotlinx.coroutines.flow.c<T>[] $flows;
        public final /* synthetic */ int $i;
        public final /* synthetic */ AtomicInteger $nonClosed;
        public final /* synthetic */ kotlinx.coroutines.channels.e<d0<Object>> $resultChannel;
        public int label;

        /* compiled from: Combine.kt */
        @kotlin.d
        /* renamed from: kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$1, reason: invalid class name and collision with other inner class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
        public static final class C07801<T> implements kotlinx.coroutines.flow.d {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ kotlinx.coroutines.channels.e<d0<Object>> f51308b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ int f51309c;

            public C07801(kotlinx.coroutines.channels.e<d0<Object>> eVar, int i10) {
                this.f51308b = eVar;
                this.f51309c = i10;
            }

            /* JADX WARN: Removed duplicated region for block: B:19:0x0055 A[RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:20:0x0038  */
            /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
            @Override // kotlinx.coroutines.flow.d
            @org.jetbrains.annotations.Nullable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object emit(T r7, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.p> r8) {
                /*
                    r6 = this;
                    boolean r0 = r8 instanceof kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$1$emit$1
                    if (r0 == 0) goto L13
                    r0 = r8
                    kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$1$emit$1 r0 = (kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$1$emit$1) r0
                    int r1 = r0.label
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.label = r1
                    goto L18
                L13:
                    kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$1$emit$1 r0 = new kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$1$emit$1
                    r0.<init>(r6, r8)
                L18:
                    java.lang.Object r8 = r0.result
                    java.lang.Object r1 = sd.a.d()
                    int r2 = r0.label
                    r3 = 2
                    r4 = 1
                    if (r2 == 0) goto L38
                    if (r2 == r4) goto L34
                    if (r2 != r3) goto L2c
                    kotlin.e.b(r8)
                    goto L56
                L2c:
                    java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                    java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                    r7.<init>(r8)
                    throw r7
                L34:
                    kotlin.e.b(r8)
                    goto L4d
                L38:
                    kotlin.e.b(r8)
                    kotlinx.coroutines.channels.e<kotlin.collections.d0<java.lang.Object>> r8 = r6.f51308b
                    kotlin.collections.d0 r2 = new kotlin.collections.d0
                    int r5 = r6.f51309c
                    r2.<init>(r5, r7)
                    r0.label = r4
                    java.lang.Object r7 = r8.E(r2, r0)
                    if (r7 != r1) goto L4d
                    return r1
                L4d:
                    r0.label = r3
                    java.lang.Object r7 = kotlinx.coroutines.q2.a(r0)
                    if (r7 != r1) goto L56
                    return r1
                L56:
                    kotlin.p r7 = kotlin.p.f51048a
                    return r7
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2.AnonymousClass1.C07801.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(kotlinx.coroutines.flow.c<? extends T>[] cVarArr, int i10, AtomicInteger atomicInteger, kotlinx.coroutines.channels.e<d0<Object>> eVar, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$flows = cVarArr;
            this.$i = i10;
            this.$nonClosed = atomicInteger;
            this.$resultChannel = eVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<kotlin.p> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(this.$flows, this.$i, this.$nonClosed, this.$resultChannel, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo1743invoke(@NotNull h0 h0Var, @Nullable Continuation<? super kotlin.p> continuation) {
            return ((AnonymousClass1) create(h0Var, continuation)).invokeSuspend(kotlin.p.f51048a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            AtomicInteger atomicInteger;
            Object d10 = sd.a.d();
            int i10 = this.label;
            try {
                if (i10 == 0) {
                    kotlin.e.b(obj);
                    kotlinx.coroutines.flow.c[] cVarArr = this.$flows;
                    int i11 = this.$i;
                    kotlinx.coroutines.flow.c cVar = cVarArr[i11];
                    C07801 c07801 = new C07801(this.$resultChannel, i11);
                    this.label = 1;
                    if (cVar.a(c07801, this) == d10) {
                        return d10;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    kotlin.e.b(obj);
                }
                if (atomicInteger.decrementAndGet() == 0) {
                    r.a.a(this.$resultChannel, null, 1, null);
                }
                return kotlin.p.f51048a;
            } finally {
                if (this.$nonClosed.decrementAndGet() == 0) {
                    r.a.a(this.$resultChannel, null, 1, null);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CombineKt$combineInternal$2(kotlinx.coroutines.flow.c<? extends T>[] cVarArr, Function0<T[]> function0, Function3<? super kotlinx.coroutines.flow.d<? super R>, ? super T[], ? super Continuation<? super kotlin.p>, ? extends Object> function3, kotlinx.coroutines.flow.d<? super R> dVar, Continuation<? super CombineKt$combineInternal$2> continuation) {
        super(2, continuation);
        this.$flows = cVarArr;
        this.$arrayFactory = function0;
        this.$transform = function3;
        this.$this_combineInternal = dVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<kotlin.p> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        CombineKt$combineInternal$2 combineKt$combineInternal$2 = new CombineKt$combineInternal$2(this.$flows, this.$arrayFactory, this.$transform, this.$this_combineInternal, continuation);
        combineKt$combineInternal$2.L$0 = obj;
        return combineKt$combineInternal$2;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    /* renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final Object mo1743invoke(@NotNull h0 h0Var, @Nullable Continuation<? super kotlin.p> continuation) {
        return ((CombineKt$combineInternal$2) create(h0Var, continuation)).invokeSuspend(kotlin.p.f51048a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x00db A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0111 A[EDGE_INSN: B:39:0x0111->B:25:0x0111 BREAK  A[LOOP:0: B:17:0x00ec->B:38:?], SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v12, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    /* JADX WARN: Type inference failed for: r2v9, types: [int] */
    /* JADX WARN: Type inference failed for: r7v0, types: [kotlinx.coroutines.flow.c<T>[]] */
    /* JADX WARN: Type inference failed for: r7v4, types: [kotlinx.coroutines.flow.c[], kotlinx.coroutines.flow.c<T>[]] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x0134 -> B:8:0x00c7). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r24) {
        /*
            Method dump skipped, instructions count: 367
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
