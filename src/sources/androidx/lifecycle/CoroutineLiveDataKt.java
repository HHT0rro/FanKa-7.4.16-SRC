package androidx.lifecycle;

import androidx.annotation.RequiresApi;
import java.time.Duration;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.s;
import kotlin.p;
import kotlinx.coroutines.r0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: CoroutineLiveData.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class CoroutineLiveDataKt {
    public static final long DEFAULT_TIMEOUT = 5000;

    @Nullable
    public static final <T> Object addDisposableSource(@NotNull MediatorLiveData<T> mediatorLiveData, @NotNull LiveData<T> liveData, @NotNull Continuation<? super EmittedSource> continuation) {
        return kotlinx.coroutines.g.c(r0.c().x(), new CoroutineLiveDataKt$addDisposableSource$2(mediatorLiveData, liveData, null), continuation);
    }

    @NotNull
    public static final <T> LiveData<T> liveData(@NotNull CoroutineContext context, long j10, @NotNull Function2<? super LiveDataScope<T>, ? super Continuation<? super p>, ? extends Object> block) {
        s.i(context, "context");
        s.i(block, "block");
        return new CoroutineLiveData(context, j10, block);
    }

    public static /* synthetic */ LiveData liveData$default(CoroutineContext coroutineContext, long j10, Function2 function2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        if ((i10 & 2) != 0) {
            j10 = 5000;
        }
        return liveData(coroutineContext, j10, function2);
    }

    @RequiresApi(26)
    @NotNull
    public static final <T> LiveData<T> liveData(@NotNull CoroutineContext context, @NotNull Duration timeout, @NotNull Function2<? super LiveDataScope<T>, ? super Continuation<? super p>, ? extends Object> block) {
        s.i(context, "context");
        s.i(timeout, "timeout");
        s.i(block, "block");
        return new CoroutineLiveData(context, Api26Impl.INSTANCE.toMillis(timeout), block);
    }

    public static /* synthetic */ LiveData liveData$default(CoroutineContext coroutineContext, Duration duration, Function2 function2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        return liveData(coroutineContext, duration, function2);
    }
}
