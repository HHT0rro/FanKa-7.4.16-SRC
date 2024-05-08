package kotlinx.coroutines.flow;

import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.k;
import org.jetbrains.annotations.NotNull;

/* compiled from: Context.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final /* synthetic */ class t {
    @NotNull
    public static final <T> c<T> a(@NotNull c<? extends T> cVar, int i10, @NotNull BufferOverflow bufferOverflow) {
        int i11;
        BufferOverflow bufferOverflow2;
        boolean z10 = true;
        if (i10 >= 0 || i10 == -2 || i10 == -1) {
            if (i10 == -1 && bufferOverflow != BufferOverflow.SUSPEND) {
                z10 = false;
            }
            if (!z10) {
                throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow".toString());
            }
            if (i10 == -1) {
                bufferOverflow2 = BufferOverflow.DROP_OLDEST;
                i11 = 0;
            } else {
                i11 = i10;
                bufferOverflow2 = bufferOverflow;
            }
            return cVar instanceof kotlinx.coroutines.flow.internal.k ? k.a.a((kotlinx.coroutines.flow.internal.k) cVar, null, i11, bufferOverflow2, 1, null) : new kotlinx.coroutines.flow.internal.f(cVar, null, i11, bufferOverflow2, 2, null);
        }
        throw new IllegalArgumentException(("Buffer size should be non-negative, BUFFERED, or CONFLATED, but was " + i10).toString());
    }

    public static /* synthetic */ c b(c cVar, int i10, BufferOverflow bufferOverflow, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = -2;
        }
        if ((i11 & 2) != 0) {
            bufferOverflow = BufferOverflow.SUSPEND;
        }
        return e.b(cVar, i10, bufferOverflow);
    }

    @NotNull
    public static final <T> c<T> c(@NotNull c<? extends T> cVar) {
        c<T> b4;
        b4 = b(cVar, -1, null, 2, null);
        return b4;
    }
}
