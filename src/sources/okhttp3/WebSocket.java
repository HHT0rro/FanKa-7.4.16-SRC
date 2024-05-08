package okhttp3;

import kotlin.d;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: WebSocket.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface WebSocket {

    /* compiled from: WebSocket.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface Factory {
        @NotNull
        WebSocket newWebSocket(@NotNull Request request, @NotNull WebSocketListener webSocketListener);
    }

    void cancel();

    boolean close(int i10, @Nullable String str);

    long queueSize();

    @NotNull
    Request request();

    boolean send(@NotNull String str);

    boolean send(@NotNull ByteString byteString);
}
