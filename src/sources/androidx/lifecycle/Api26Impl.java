package androidx.lifecycle;

import androidx.annotation.RequiresApi;
import java.time.Duration;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: CoroutineLiveData.kt */
@RequiresApi(26)
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class Api26Impl {

    @NotNull
    public static final Api26Impl INSTANCE = new Api26Impl();

    private Api26Impl() {
    }

    public final long toMillis(@NotNull Duration timeout) {
        s.i(timeout, "timeout");
        return timeout.toMillis();
    }
}
