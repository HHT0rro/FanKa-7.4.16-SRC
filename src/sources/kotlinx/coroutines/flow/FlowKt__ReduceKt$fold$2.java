package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref$ObjectRef;

/* compiled from: Reduce.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class FlowKt__ReduceKt$fold$2<T> implements d {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref$ObjectRef<R> f51269b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function3<R, T, Continuation<? super R>, Object> f51270c;

    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__ReduceKt$fold$2(Ref$ObjectRef<R> ref$ObjectRef, Function3<? super R, ? super T, ? super Continuation<? super R>, ? extends Object> function3) {
        this.f51269b = ref$ObjectRef;
        this.f51270c = function3;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // kotlinx.coroutines.flow.d
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object emit(T r7, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.p> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof kotlinx.coroutines.flow.FlowKt__ReduceKt$fold$2$emit$1
            if (r0 == 0) goto L13
            r0 = r8
            kotlinx.coroutines.flow.FlowKt__ReduceKt$fold$2$emit$1 r0 = (kotlinx.coroutines.flow.FlowKt__ReduceKt$fold$2$emit$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__ReduceKt$fold$2$emit$1 r0 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$fold$2$emit$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = sd.a.d()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r7 = r0.L$0
            kotlin.jvm.internal.Ref$ObjectRef r7 = (kotlin.jvm.internal.Ref$ObjectRef) r7
            kotlin.e.b(r8)
            goto L4c
        L2d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L35:
            kotlin.e.b(r8)
            kotlin.jvm.internal.Ref$ObjectRef<R> r8 = r6.f51269b
            kotlin.jvm.functions.Function3<R, T, kotlin.coroutines.Continuation<? super R>, java.lang.Object> r2 = r6.f51270c
            T r4 = r8.element
            r0.L$0 = r8
            r0.label = r3
            java.lang.Object r7 = r2.invoke(r4, r7, r0)
            if (r7 != r1) goto L49
            return r1
        L49:
            r5 = r8
            r8 = r7
            r7 = r5
        L4c:
            r7.element = r8
            kotlin.p r7 = kotlin.p.f51048a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ReduceKt$fold$2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
