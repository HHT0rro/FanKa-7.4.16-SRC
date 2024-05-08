package okio;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Okio.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final /* synthetic */ class Okio__OkioKt {
    @NotNull
    public static final Sink blackhole() {
        return new BlackholeSink();
    }

    @NotNull
    public static final BufferedSource buffer(@NotNull Source buffer) {
        s.i(buffer, "$this$buffer");
        return new RealBufferedSource(buffer);
    }

    @NotNull
    public static final BufferedSink buffer(@NotNull Sink buffer) {
        s.i(buffer, "$this$buffer");
        return new RealBufferedSink(buffer);
    }
}
