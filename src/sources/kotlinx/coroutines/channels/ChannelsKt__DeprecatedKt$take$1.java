package kotlinx.coroutines.channels;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Deprecated.kt */
@kotlin.d
@td.d(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$take$1", f = "Deprecated.kt", l = {254, 255}, m = "invokeSuspend")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
final class ChannelsKt__DeprecatedKt$take$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ int $n;
    public final /* synthetic */ ReceiveChannel $this_take;
    public int I$0;
    private /* synthetic */ Object L$0;
    public Object L$1;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelsKt__DeprecatedKt$take$1(int i10, ReceiveChannel receiveChannel, Continuation continuation) {
        super(2, continuation);
        this.$n = i10;
        this.$this_take = receiveChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<kotlin.p> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        ChannelsKt__DeprecatedKt$take$1 channelsKt__DeprecatedKt$take$1 = new ChannelsKt__DeprecatedKt$take$1(this.$n, this.$this_take, continuation);
        channelsKt__DeprecatedKt$take$1.L$0 = obj;
        return channelsKt__DeprecatedKt$take$1;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final Object mo1743invoke(@NotNull m mVar, @Nullable Continuation continuation) {
        return ((ChannelsKt__DeprecatedKt$take$1) create(mVar, continuation)).invokeSuspend(kotlin.p.f51048a);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0060 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0086  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0080 -> B:6:0x0082). Please report as a decompilation issue!!! */
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
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L36
            if (r1 == r3) goto L27
            if (r1 != r2) goto L1f
            int r1 = r8.I$0
            java.lang.Object r4 = r8.L$1
            kotlinx.coroutines.channels.ChannelIterator r4 = (kotlinx.coroutines.channels.ChannelIterator) r4
            java.lang.Object r5 = r8.L$0
            kotlinx.coroutines.channels.m r5 = (kotlinx.coroutines.channels.m) r5
            kotlin.e.b(r9)
            r9 = r5
            r5 = r8
            goto L82
        L1f:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L27:
            int r1 = r8.I$0
            java.lang.Object r4 = r8.L$1
            kotlinx.coroutines.channels.ChannelIterator r4 = (kotlinx.coroutines.channels.ChannelIterator) r4
            java.lang.Object r5 = r8.L$0
            kotlinx.coroutines.channels.m r5 = (kotlinx.coroutines.channels.m) r5
            kotlin.e.b(r9)
            r6 = r8
            goto L65
        L36:
            kotlin.e.b(r9)
            java.lang.Object r9 = r8.L$0
            kotlinx.coroutines.channels.m r9 = (kotlinx.coroutines.channels.m) r9
            int r1 = r8.$n
            if (r1 != 0) goto L44
            kotlin.p r9 = kotlin.p.f51048a
            return r9
        L44:
            if (r1 < 0) goto L48
            r4 = 1
            goto L49
        L48:
            r4 = 0
        L49:
            if (r4 == 0) goto L8c
            kotlinx.coroutines.channels.ReceiveChannel r4 = r8.$this_take
            kotlinx.coroutines.channels.ChannelIterator r4 = r4.iterator()
            r5 = r8
        L52:
            r5.L$0 = r9
            r5.L$1 = r4
            r5.I$0 = r1
            r5.label = r3
            java.lang.Object r6 = r4.a(r5)
            if (r6 != r0) goto L61
            return r0
        L61:
            r7 = r5
            r5 = r9
            r9 = r6
            r6 = r7
        L65:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto L89
            java.lang.Object r9 = r4.next()
            r6.L$0 = r5
            r6.L$1 = r4
            r6.I$0 = r1
            r6.label = r2
            java.lang.Object r9 = r5.E(r9, r6)
            if (r9 != r0) goto L80
            return r0
        L80:
            r9 = r5
            r5 = r6
        L82:
            int r1 = r1 + (-1)
            if (r1 != 0) goto L52
            kotlin.p r9 = kotlin.p.f51048a
            return r9
        L89:
            kotlin.p r9 = kotlin.p.f51048a
            return r9
        L8c:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r0 = "Requested element count "
            r9.append(r0)
            r9.append(r1)
            java.lang.String r0 = " is less than zero."
            r9.append(r0)
            java.lang.String r9 = r9.toString()
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r9 = r9.toString()
            r0.<init>(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$take$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
