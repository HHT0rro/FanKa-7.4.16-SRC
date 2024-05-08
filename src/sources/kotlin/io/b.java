package kotlin.io;

import java.io.Closeable;
import org.jetbrains.annotations.Nullable;

/* compiled from: Closeable.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class b {
    public static final void a(@Nullable Closeable closeable, @Nullable Throwable th) {
        if (closeable != null) {
            if (th == null) {
                closeable.close();
                return;
            }
            try {
                closeable.close();
            } catch (Throwable th2) {
                kotlin.a.a(th, th2);
            }
        }
    }
}
