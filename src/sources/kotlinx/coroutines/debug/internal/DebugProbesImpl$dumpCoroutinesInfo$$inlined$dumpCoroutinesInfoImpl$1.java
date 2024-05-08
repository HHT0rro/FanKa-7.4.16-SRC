package kotlinx.coroutines.debug.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.debug.internal.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: DebugProbesImpl.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class DebugProbesImpl$dumpCoroutinesInfo$$inlined$dumpCoroutinesInfoImpl$1 extends Lambda implements Function1<d.a<?>, b> {
    public DebugProbesImpl$dumpCoroutinesInfo$$inlined$dumpCoroutinesInfoImpl$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    @Nullable
    public final b invoke(@NotNull d.a<?> aVar) {
        boolean e2;
        CoroutineContext b4;
        e2 = d.f51215a.e(aVar);
        if (e2 || (b4 = aVar.f51226c.b()) == null) {
            return null;
        }
        return new b(aVar.f51226c, b4);
    }
}
