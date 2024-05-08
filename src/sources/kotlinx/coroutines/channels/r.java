package kotlinx.coroutines.channels;

import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Channel.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface r<E> {

    /* compiled from: Channel.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class a {
        public static /* synthetic */ boolean a(r rVar, Throwable th, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: close");
            }
            if ((i10 & 1) != 0) {
                th = null;
            }
            return rVar.D(th);
        }
    }

    boolean D(@Nullable Throwable th);

    @Nullable
    Object E(E e2, @NotNull Continuation<? super kotlin.p> continuation);

    void k(@NotNull Function1<? super Throwable, kotlin.p> function1);

    @NotNull
    Object l(E e2);

    boolean q();
}
