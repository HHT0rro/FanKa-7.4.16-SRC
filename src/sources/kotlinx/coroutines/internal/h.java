package kotlinx.coroutines.internal;

import kotlin.coroutines.CoroutineContext;
import org.jetbrains.annotations.NotNull;

/* compiled from: Scopes.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class h implements kotlinx.coroutines.h0 {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final CoroutineContext f51385b;

    public h(@NotNull CoroutineContext coroutineContext) {
        this.f51385b = coroutineContext;
    }

    @Override // kotlinx.coroutines.h0
    @NotNull
    public CoroutineContext getCoroutineContext() {
        return this.f51385b;
    }

    @NotNull
    public String toString() {
        return "CoroutineScope(coroutineContext=" + ((Object) getCoroutineContext()) + ')';
    }
}
