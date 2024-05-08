package okhttp3.internal.http2;

import java.io.IOException;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: StreamResetException.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class StreamResetException extends IOException {

    @NotNull
    public final ErrorCode errorCode;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StreamResetException(@NotNull ErrorCode errorCode) {
        super("stream was reset: " + ((Object) errorCode));
        s.i(errorCode, "errorCode");
        this.errorCode = errorCode;
    }
}
