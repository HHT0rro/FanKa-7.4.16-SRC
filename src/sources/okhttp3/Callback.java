package okhttp3;

import java.io.IOException;
import kotlin.d;
import org.jetbrains.annotations.NotNull;

/* compiled from: Callback.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface Callback {
    void onFailure(@NotNull Call call, @NotNull IOException iOException);

    void onResponse(@NotNull Call call, @NotNull Response response) throws IOException;
}
