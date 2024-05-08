package kotlinx.coroutines.debug.internal;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.p;

/* compiled from: DebugProbesImpl.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
final class DebugProbesImpl$startWeakRefCleanerThread$1 extends Lambda implements Function0<p> {
    public static final DebugProbesImpl$startWeakRefCleanerThread$1 INSTANCE = new DebugProbesImpl$startWeakRefCleanerThread$1();

    public DebugProbesImpl$startWeakRefCleanerThread$1() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ p invoke() {
        invoke2();
        return p.f51048a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ConcurrentWeakMap concurrentWeakMap;
        concurrentWeakMap = d.f51224j;
        concurrentWeakMap.j();
    }
}
