package okhttp3;

import java.io.IOException;
import kotlin.d;
import okio.Timeout;
import org.jetbrains.annotations.NotNull;

/* compiled from: Call.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface Call extends Cloneable {

    /* compiled from: Call.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface Factory {
        @NotNull
        Call newCall(@NotNull Request request);
    }

    void cancel();

    @NotNull
    Call clone();

    void enqueue(@NotNull Callback callback);

    @NotNull
    Response execute() throws IOException;

    boolean isCanceled();

    boolean isExecuted();

    @NotNull
    Request request();

    @NotNull
    Timeout timeout();
}
