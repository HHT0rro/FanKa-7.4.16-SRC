package androidx.lifecycle;

import androidx.annotation.RequiresApi;
import androidx.arch.core.executor.ArchTaskExecutor;
import java.time.Duration;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.s;
import kotlinx.coroutines.flow.p1;
import org.jetbrains.annotations.NotNull;

/* compiled from: FlowLiveData.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class FlowLiveDataConversions {
    @NotNull
    public static final <T> kotlinx.coroutines.flow.c<T> asFlow(@NotNull LiveData<T> liveData) {
        s.i(liveData, "<this>");
        return kotlinx.coroutines.flow.e.h(kotlinx.coroutines.flow.e.d(new FlowLiveDataConversions$asFlow$1(liveData, null)));
    }

    @NotNull
    public static final <T> LiveData<T> asLiveData(@NotNull kotlinx.coroutines.flow.c<? extends T> cVar) {
        s.i(cVar, "<this>");
        return asLiveData$default(cVar, (CoroutineContext) null, 0L, 3, (Object) null);
    }

    @NotNull
    public static final <T> LiveData<T> asLiveData(@NotNull kotlinx.coroutines.flow.c<? extends T> cVar, @NotNull CoroutineContext context) {
        s.i(cVar, "<this>");
        s.i(context, "context");
        return asLiveData$default(cVar, context, 0L, 2, (Object) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <T> LiveData<T> asLiveData(@NotNull kotlinx.coroutines.flow.c<? extends T> cVar, @NotNull CoroutineContext context, long j10) {
        s.i(cVar, "<this>");
        s.i(context, "context");
        ComputableLiveData$_liveData$1 computableLiveData$_liveData$1 = (LiveData<T>) CoroutineLiveDataKt.liveData(context, j10, new FlowLiveDataConversions$asLiveData$1(cVar, null));
        if (cVar instanceof p1) {
            if (ArchTaskExecutor.getInstance().isMainThread()) {
                computableLiveData$_liveData$1.setValue(((p1) cVar).getValue());
            } else {
                computableLiveData$_liveData$1.postValue(((p1) cVar).getValue());
            }
        }
        return computableLiveData$_liveData$1;
    }

    public static /* synthetic */ LiveData asLiveData$default(kotlinx.coroutines.flow.c cVar, CoroutineContext coroutineContext, long j10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        if ((i10 & 2) != 0) {
            j10 = 5000;
        }
        return asLiveData(cVar, coroutineContext, j10);
    }

    public static /* synthetic */ LiveData asLiveData$default(kotlinx.coroutines.flow.c cVar, CoroutineContext coroutineContext, Duration duration, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        return asLiveData(cVar, coroutineContext, duration);
    }

    @RequiresApi(26)
    @NotNull
    public static final <T> LiveData<T> asLiveData(@NotNull kotlinx.coroutines.flow.c<? extends T> cVar, @NotNull CoroutineContext context, @NotNull Duration timeout) {
        s.i(cVar, "<this>");
        s.i(context, "context");
        s.i(timeout, "timeout");
        return asLiveData(cVar, context, Api26Impl.INSTANCE.toMillis(timeout));
    }
}
