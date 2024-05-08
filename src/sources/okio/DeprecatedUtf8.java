package okio;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: -DeprecatedUtf8.kt */
@d
/* renamed from: okio.-DeprecatedUtf8, reason: invalid class name */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class DeprecatedUtf8 {
    public static final DeprecatedUtf8 INSTANCE = new DeprecatedUtf8();

    private DeprecatedUtf8() {
    }

    public final long size(@NotNull String string) {
        s.i(string, "string");
        return Utf8.size$default(string, 0, 0, 3, null);
    }

    public final long size(@NotNull String string, int i10, int i11) {
        s.i(string, "string");
        return Utf8.size(string, i10, i11);
    }
}
