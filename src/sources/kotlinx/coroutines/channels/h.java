package kotlinx.coroutines.channels;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class h {
    public static final void b(@NotNull ReceiveChannel<?> receiveChannel, @Nullable Throwable th) {
        ChannelsKt__Channels_commonKt.a(receiveChannel, th);
    }

    @Nullable
    public static final <E, C extends r<? super E>> Object s(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull C c4, @NotNull Continuation<? super C> continuation) {
        return ChannelsKt__DeprecatedKt.r(receiveChannel, c4, continuation);
    }

    @Nullable
    public static final <E, C extends Collection<? super E>> Object t(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull C c4, @NotNull Continuation<? super C> continuation) {
        return ChannelsKt__DeprecatedKt.s(receiveChannel, c4, continuation);
    }

    @Nullable
    public static final <E> Object u(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull Continuation<? super List<? extends E>> continuation) {
        return ChannelsKt__Channels_commonKt.d(receiveChannel, continuation);
    }

    @Nullable
    public static final <K, V, M extends Map<? super K, ? super V>> Object v(@NotNull ReceiveChannel<? extends Pair<? extends K, ? extends V>> receiveChannel, @NotNull M m10, @NotNull Continuation<? super M> continuation) {
        return ChannelsKt__DeprecatedKt.t(receiveChannel, m10, continuation);
    }
}
