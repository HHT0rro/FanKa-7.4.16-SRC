package kotlinx.coroutines;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: JobSupport.kt */
@kotlin.d
@td.d(c = "kotlinx.coroutines.JobSupport$children$1", f = "JobSupport.kt", l = {952, 954}, m = "invokeSuspend")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
final class JobSupport$children$1 extends RestrictedSuspendLambda implements Function2<kotlin.sequences.i<? super n1>, Continuation<? super kotlin.p>, Object> {
    private /* synthetic */ Object L$0;
    public Object L$1;
    public Object L$2;
    public int label;
    public final /* synthetic */ u1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JobSupport$children$1(u1 u1Var, Continuation<? super JobSupport$children$1> continuation) {
        super(2, continuation);
        this.this$0 = u1Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<kotlin.p> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        JobSupport$children$1 jobSupport$children$1 = new JobSupport$children$1(this.this$0, continuation);
        jobSupport$children$1.L$0 = obj;
        return jobSupport$children$1;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    /* renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final Object mo1743invoke(@NotNull kotlin.sequences.i<? super n1> iVar, @Nullable Continuation<? super kotlin.p> continuation) {
        return ((JobSupport$children$1) create(iVar, continuation)).invokeSuspend(kotlin.p.f51048a);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0066  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0068 -> B:6:0x007e). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x007b -> B:6:0x007e). Please report as a decompilation issue!!! */
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
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L2b
            if (r1 == r3) goto L27
            if (r1 != r2) goto L1f
            java.lang.Object r1 = r7.L$2
            kotlinx.coroutines.internal.LockFreeLinkedListNode r1 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r1
            java.lang.Object r3 = r7.L$1
            kotlinx.coroutines.internal.p r3 = (kotlinx.coroutines.internal.p) r3
            java.lang.Object r4 = r7.L$0
            kotlin.sequences.i r4 = (kotlin.sequences.i) r4
            kotlin.e.b(r8)
            r8 = r7
            goto L7e
        L1f:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L27:
            kotlin.e.b(r8)
            goto L83
        L2b:
            kotlin.e.b(r8)
            java.lang.Object r8 = r7.L$0
            kotlin.sequences.i r8 = (kotlin.sequences.i) r8
            kotlinx.coroutines.u1 r1 = r7.this$0
            java.lang.Object r1 = r1.d0()
            boolean r4 = r1 instanceof kotlinx.coroutines.s
            if (r4 == 0) goto L49
            kotlinx.coroutines.s r1 = (kotlinx.coroutines.s) r1
            kotlinx.coroutines.t r1 = r1.f51463f
            r7.label = r3
            java.lang.Object r8 = r8.a(r1, r7)
            if (r8 != r0) goto L83
            return r0
        L49:
            boolean r3 = r1 instanceof kotlinx.coroutines.h1
            if (r3 == 0) goto L83
            kotlinx.coroutines.h1 r1 = (kotlinx.coroutines.h1) r1
            kotlinx.coroutines.y1 r1 = r1.c()
            if (r1 == 0) goto L83
            java.lang.Object r3 = r1.E()
            kotlinx.coroutines.internal.LockFreeLinkedListNode r3 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r3
            r4 = r8
            r8 = r7
            r6 = r3
            r3 = r1
            r1 = r6
        L60:
            boolean r5 = kotlin.jvm.internal.s.d(r1, r3)
            if (r5 != 0) goto L83
            boolean r5 = r1 instanceof kotlinx.coroutines.s
            if (r5 == 0) goto L7e
            r5 = r1
            kotlinx.coroutines.s r5 = (kotlinx.coroutines.s) r5
            kotlinx.coroutines.t r5 = r5.f51463f
            r8.L$0 = r4
            r8.L$1 = r3
            r8.L$2 = r1
            r8.label = r2
            java.lang.Object r5 = r4.a(r5, r8)
            if (r5 != r0) goto L7e
            return r0
        L7e:
            kotlinx.coroutines.internal.LockFreeLinkedListNode r1 = r1.F()
            goto L60
        L83:
            kotlin.p r8 = kotlin.p.f51048a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.JobSupport$children$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
