package okio;

import kotlin.d;
import org.jetbrains.annotations.NotNull;

/* compiled from: -DeprecatedUpgrade.kt */
@d
/* renamed from: okio.-DeprecatedUpgrade, reason: invalid class name */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class DeprecatedUpgrade {

    @NotNull
    private static final DeprecatedOkio Okio = DeprecatedOkio.INSTANCE;

    @NotNull
    private static final DeprecatedUtf8 Utf8 = DeprecatedUtf8.INSTANCE;

    @NotNull
    public static final DeprecatedOkio getOkio() {
        return Okio;
    }

    @NotNull
    public static final DeprecatedUtf8 getUtf8() {
        return Utf8;
    }
}
