package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;
import org.jetbrains.annotations.NotNull;

/* compiled from: CoroutineExceptionHandler.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface c0 extends CoroutineContext.a {

    @NotNull
    public static final a B0 = a.f51134b;

    /* compiled from: CoroutineExceptionHandler.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class a implements CoroutineContext.b<c0> {

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ a f51134b = new a();
    }

    void m(@NotNull CoroutineContext coroutineContext, @NotNull Throwable th);
}
