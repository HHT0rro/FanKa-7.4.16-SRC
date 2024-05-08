package okhttp3;

import kotlin.d;
import kotlin.jvm.internal.s;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: WebSocketListener.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class WebSocketListener {
    public void onClosed(@NotNull WebSocket webSocket, int i10, @NotNull String reason) {
        s.i(webSocket, "webSocket");
        s.i(reason, "reason");
    }

    public void onClosing(@NotNull WebSocket webSocket, int i10, @NotNull String reason) {
        s.i(webSocket, "webSocket");
        s.i(reason, "reason");
    }

    public void onFailure(@NotNull WebSocket webSocket, @NotNull Throwable t2, @Nullable Response response) {
        s.i(webSocket, "webSocket");
        s.i(t2, "t");
    }

    public void onMessage(@NotNull WebSocket webSocket, @NotNull String text) {
        s.i(webSocket, "webSocket");
        s.i(text, "text");
    }

    public void onMessage(@NotNull WebSocket webSocket, @NotNull ByteString bytes) {
        s.i(webSocket, "webSocket");
        s.i(bytes, "bytes");
    }

    public void onOpen(@NotNull WebSocket webSocket, @NotNull Response response) {
        s.i(webSocket, "webSocket");
        s.i(response, "response");
    }
}
