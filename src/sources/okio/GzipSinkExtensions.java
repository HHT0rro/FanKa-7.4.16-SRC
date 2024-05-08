package okio;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: GzipSink.kt */
@d
/* renamed from: okio.-GzipSinkExtensions, reason: invalid class name */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class GzipSinkExtensions {
    @NotNull
    public static final GzipSink gzip(@NotNull Sink gzip) {
        s.i(gzip, "$this$gzip");
        return new GzipSink(gzip);
    }
}
