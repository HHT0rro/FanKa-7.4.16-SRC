package okio;

import java.util.zip.Inflater;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: InflaterSource.kt */
@d
/* renamed from: okio.-InflaterSourceExtensions, reason: invalid class name */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class InflaterSourceExtensions {
    @NotNull
    public static final InflaterSource inflate(@NotNull Source inflate, @NotNull Inflater inflater) {
        s.i(inflate, "$this$inflate");
        s.i(inflater, "inflater");
        return new InflaterSource(inflate, inflater);
    }

    public static /* synthetic */ InflaterSource inflate$default(Source inflate, Inflater inflater, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            inflater = new Inflater();
        }
        s.i(inflate, "$this$inflate");
        s.i(inflater, "inflater");
        return new InflaterSource(inflate, inflater);
    }
}
