package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import org.jetbrains.annotations.NotNull;

/* compiled from: SafeCollector.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class l implements Continuation<Object> {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final l f51327b = new l();

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final CoroutineContext f51328c = EmptyCoroutineContext.INSTANCE;

    @Override // kotlin.coroutines.Continuation
    @NotNull
    public CoroutineContext getContext() {
        return f51328c;
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(@NotNull Object obj) {
    }
}
