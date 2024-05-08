package kotlinx.coroutines.channels;

import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Channel.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class g {
    @NotNull
    public static final <E> e<E> a(int i10, @NotNull BufferOverflow bufferOverflow, @Nullable Function1<? super E, kotlin.p> function1) {
        if (i10 == -2) {
            return new c(bufferOverflow == BufferOverflow.SUSPEND ? e.D0.a() : 1, bufferOverflow, function1);
        }
        if (i10 == -1) {
            if ((bufferOverflow != BufferOverflow.SUSPEND ? 0 : 1) != 0) {
                return new j(function1);
            }
            throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow".toString());
        }
        if (i10 == 0) {
            if (bufferOverflow == BufferOverflow.SUSPEND) {
                return new p(function1);
            }
            return new c(1, bufferOverflow, function1);
        }
        if (i10 != Integer.MAX_VALUE) {
            if (i10 == 1 && bufferOverflow == BufferOverflow.DROP_OLDEST) {
                return new j(function1);
            }
            return new c(i10, bufferOverflow, function1);
        }
        return new k(function1);
    }

    public static /* synthetic */ e b(int i10, BufferOverflow bufferOverflow, Function1 function1, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 0;
        }
        if ((i11 & 2) != 0) {
            bufferOverflow = BufferOverflow.SUSPEND;
        }
        if ((i11 & 4) != 0) {
            function1 = null;
        }
        return a(i10, bufferOverflow, function1);
    }
}
