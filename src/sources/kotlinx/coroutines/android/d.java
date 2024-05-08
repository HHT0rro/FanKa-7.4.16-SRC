package kotlinx.coroutines.android;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.t0;
import kotlinx.coroutines.x1;
import org.jetbrains.annotations.NotNull;

/* compiled from: HandlerDispatcher.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class d extends x1 implements m0 {
    public d() {
    }

    public /* synthetic */ d(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @NotNull
    public t0 l(long j10, @NotNull Runnable runnable, @NotNull CoroutineContext coroutineContext) {
        return m0.a.a(this, j10, runnable, coroutineContext);
    }
}
