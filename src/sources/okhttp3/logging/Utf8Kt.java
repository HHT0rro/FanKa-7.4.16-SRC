package okhttp3.logging;

import ce.n;
import java.io.EOFException;
import kotlin.d;
import kotlin.jvm.internal.s;
import okio.Buffer;
import org.jetbrains.annotations.NotNull;

/* compiled from: utf8.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class Utf8Kt {
    public static final boolean isProbablyUtf8(@NotNull Buffer isProbablyUtf8) {
        s.j(isProbablyUtf8, "$this$isProbablyUtf8");
        try {
            Buffer buffer = new Buffer();
            isProbablyUtf8.copyTo(buffer, 0L, n.e(isProbablyUtf8.size(), 64L));
            for (int i10 = 0; i10 < 16; i10++) {
                if (buffer.exhausted()) {
                    return true;
                }
                int readUtf8CodePoint = buffer.readUtf8CodePoint();
                if (Character.isISOControl(readUtf8CodePoint) && !Character.isWhitespace(readUtf8CodePoint)) {
                    return false;
                }
            }
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }
}
