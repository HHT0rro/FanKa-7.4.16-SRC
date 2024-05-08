package kotlin.sequences;

import java.util.Iterator;
import kotlin.coroutines.Continuation;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SequenceBuilder.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class i<T> {
    @Nullable
    public abstract Object a(T t2, @NotNull Continuation<? super p> continuation);

    @Nullable
    public abstract Object b(@NotNull Iterator<? extends T> it, @NotNull Continuation<? super p> continuation);

    @Nullable
    public final Object c(@NotNull g<? extends T> gVar, @NotNull Continuation<? super p> continuation) {
        Object b4 = b(gVar.iterator(), continuation);
        return b4 == sd.a.d() ? b4 : p.f51048a;
    }
}
