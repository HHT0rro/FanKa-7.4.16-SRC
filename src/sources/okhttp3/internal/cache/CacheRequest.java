package okhttp3.internal.cache;

import java.io.IOException;
import kotlin.d;
import okio.Sink;
import org.jetbrains.annotations.NotNull;

/* compiled from: CacheRequest.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface CacheRequest {
    void abort();

    @NotNull
    Sink body() throws IOException;
}
