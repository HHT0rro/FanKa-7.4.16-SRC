package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SharingStarted.kt */
@kotlin.d
@td.d(c = "kotlinx.coroutines.flow.StartedWhileSubscribed$command$1", f = "SharingStarted.kt", l = {178, 180, 182, 183, 185}, m = "invokeSuspend")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
final class StartedWhileSubscribed$command$1 extends SuspendLambda implements Function3<d<? super SharingCommand>, Integer, Continuation<? super kotlin.p>, Object> {
    public /* synthetic */ int I$0;
    private /* synthetic */ Object L$0;
    public int label;
    public final /* synthetic */ o1 this$0;

    public StartedWhileSubscribed$command$1(o1 o1Var, Continuation<? super StartedWhileSubscribed$command$1> continuation) {
        super(3, continuation);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(d<? super SharingCommand> dVar, Integer num, Continuation<? super kotlin.p> continuation) {
        return invoke(dVar, num.intValue(), continuation);
    }

    @Nullable
    public final Object invoke(@NotNull d<? super SharingCommand> dVar, int i10, @Nullable Continuation<? super kotlin.p> continuation) {
        StartedWhileSubscribed$command$1 startedWhileSubscribed$command$1 = new StartedWhileSubscribed$command$1(null, continuation);
        startedWhileSubscribed$command$1.L$0 = dVar;
        startedWhileSubscribed$command$1.I$0 = i10;
        return startedWhileSubscribed$command$1.invokeSuspend(kotlin.p.f51048a);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0095 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0088 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x006d  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r11) {
        /*
            r10 = this;
            java.lang.Object r0 = sd.a.d()
            int r1 = r10.label
            r2 = 5
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            r7 = 0
            if (r1 == 0) goto L3d
            if (r1 == r6) goto L39
            if (r1 == r5) goto L31
            if (r1 == r4) goto L29
            if (r1 == r3) goto L21
            if (r1 != r2) goto L19
            goto L39
        L19:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L21:
            java.lang.Object r1 = r10.L$0
            kotlinx.coroutines.flow.d r1 = (kotlinx.coroutines.flow.d) r1
            kotlin.e.b(r11)
            goto L89
        L29:
            java.lang.Object r1 = r10.L$0
            kotlinx.coroutines.flow.d r1 = (kotlinx.coroutines.flow.d) r1
            kotlin.e.b(r11)
            goto L7a
        L31:
            java.lang.Object r1 = r10.L$0
            kotlinx.coroutines.flow.d r1 = (kotlinx.coroutines.flow.d) r1
            kotlin.e.b(r11)
            goto L63
        L39:
            kotlin.e.b(r11)
            goto L96
        L3d:
            kotlin.e.b(r11)
            java.lang.Object r11 = r10.L$0
            r1 = r11
            kotlinx.coroutines.flow.d r1 = (kotlinx.coroutines.flow.d) r1
            int r11 = r10.I$0
            if (r11 <= 0) goto L54
            kotlinx.coroutines.flow.SharingCommand r11 = kotlinx.coroutines.flow.SharingCommand.START
            r10.label = r6
            java.lang.Object r11 = r1.emit(r11, r10)
            if (r11 != r0) goto L96
            return r0
        L54:
            long r8 = kotlinx.coroutines.flow.o1.c(r7)
            r10.L$0 = r1
            r10.label = r5
            java.lang.Object r11 = kotlinx.coroutines.DelayKt.b(r8, r10)
            if (r11 != r0) goto L63
            return r0
        L63:
            long r5 = kotlinx.coroutines.flow.o1.b(r7)
            r8 = 0
            int r11 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r11 <= 0) goto L89
            kotlinx.coroutines.flow.SharingCommand r11 = kotlinx.coroutines.flow.SharingCommand.STOP
            r10.L$0 = r1
            r10.label = r4
            java.lang.Object r11 = r1.emit(r11, r10)
            if (r11 != r0) goto L7a
            return r0
        L7a:
            long r4 = kotlinx.coroutines.flow.o1.b(r7)
            r10.L$0 = r1
            r10.label = r3
            java.lang.Object r11 = kotlinx.coroutines.DelayKt.b(r4, r10)
            if (r11 != r0) goto L89
            return r0
        L89:
            kotlinx.coroutines.flow.SharingCommand r11 = kotlinx.coroutines.flow.SharingCommand.STOP_AND_RESET_REPLAY_CACHE
            r10.L$0 = r7
            r10.label = r2
            java.lang.Object r11 = r1.emit(r11, r10)
            if (r11 != r0) goto L96
            return r0
        L96:
            kotlin.p r11 = kotlin.p.f51048a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.StartedWhileSubscribed$command$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
