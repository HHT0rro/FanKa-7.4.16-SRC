package kotlinx.coroutines;

import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: CancellableContinuation.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface l<T> extends Continuation<T> {

    /* compiled from: CancellableContinuation.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class a {
        public static /* synthetic */ Object a(l lVar, Object obj, Object obj2, int i10, Object obj3) {
            if (obj3 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tryResume");
            }
            if ((i10 & 2) != 0) {
                obj2 = null;
            }
            return lVar.t(obj, obj2);
        }
    }

    @Nullable
    Object B(T t2, @Nullable Object obj, @Nullable Function1<? super Throwable, kotlin.p> function1);

    void C(@NotNull CoroutineDispatcher coroutineDispatcher, T t2);

    void h(T t2, @Nullable Function1<? super Throwable, kotlin.p> function1);

    void s(@NotNull Object obj);

    @Nullable
    Object t(T t2, @Nullable Object obj);

    void v(@NotNull Function1<? super Throwable, kotlin.p> function1);

    @Nullable
    Object x(@NotNull Throwable th);
}
