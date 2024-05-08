package okio;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: GzipSource.kt */
@d
/* renamed from: okio.-GzipSourceExtensions, reason: invalid class name */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class GzipSourceExtensions {
    private static final int FCOMMENT = 4;
    private static final int FEXTRA = 2;
    private static final int FHCRC = 1;
    private static final int FNAME = 3;
    private static final byte SECTION_BODY = 1;
    private static final byte SECTION_DONE = 3;
    private static final byte SECTION_HEADER = 0;
    private static final byte SECTION_TRAILER = 2;

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getBit(int i10, int i11) {
        return ((i10 >> i11) & 1) == 1;
    }

    @NotNull
    public static final GzipSource gzip(@NotNull Source gzip) {
        s.i(gzip, "$this$gzip");
        return new GzipSource(gzip);
    }
}
