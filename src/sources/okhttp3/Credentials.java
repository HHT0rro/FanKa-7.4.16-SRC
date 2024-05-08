package okhttp3;

import com.android.internal.accessibility.common.ShortcutConstants;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import kotlin.d;
import kotlin.jvm.internal.s;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;

/* compiled from: Credentials.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class Credentials {
    public static final Credentials INSTANCE = new Credentials();

    private Credentials() {
    }

    @NotNull
    public static final String basic(@NotNull String str, @NotNull String str2) {
        return basic$default(str, str2, null, 4, null);
    }

    @NotNull
    public static final String basic(@NotNull String username, @NotNull String password, @NotNull Charset charset) {
        s.i(username, "username");
        s.i(password, "password");
        s.i(charset, "charset");
        return "Basic " + ByteString.Companion.encodeString(username + ShortcutConstants.SERVICES_SEPARATOR + password, charset).base64();
    }

    public static /* synthetic */ String basic$default(String str, String str2, Charset ISO_8859_1, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            ISO_8859_1 = StandardCharsets.ISO_8859_1;
            s.h(ISO_8859_1, "ISO_8859_1");
        }
        return basic(str, str2, ISO_8859_1);
    }
}
