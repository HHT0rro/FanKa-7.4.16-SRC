package b7;

import java.io.Closeable;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
@Deprecated
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class h {
    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }
}
