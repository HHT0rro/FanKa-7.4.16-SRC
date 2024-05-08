package okio;

import java.util.zip.Deflater;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: DeflaterSink.kt */
@d
/* renamed from: okio.-DeflaterSinkExtensions, reason: invalid class name */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class DeflaterSinkExtensions {
    @NotNull
    public static final DeflaterSink deflate(@NotNull Sink deflate, @NotNull Deflater deflater) {
        s.i(deflate, "$this$deflate");
        s.i(deflater, "deflater");
        return new DeflaterSink(deflate, deflater);
    }

    public static /* synthetic */ DeflaterSink deflate$default(Sink deflate, Deflater deflater, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            deflater = new Deflater();
        }
        s.i(deflate, "$this$deflate");
        s.i(deflater, "deflater");
        return new DeflaterSink(deflate, deflater);
    }
}
