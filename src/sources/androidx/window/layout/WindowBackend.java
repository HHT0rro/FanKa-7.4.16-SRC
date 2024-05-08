package androidx.window.layout;

import android.app.Activity;
import androidx.core.util.Consumer;
import java.util.concurrent.Executor;
import org.jetbrains.annotations.NotNull;

/* compiled from: WindowBackend.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface WindowBackend {
    void registerLayoutChangeCallback(@NotNull Activity activity, @NotNull Executor executor, @NotNull Consumer<WindowLayoutInfo> consumer);

    void unregisterLayoutChangeCallback(@NotNull Consumer<WindowLayoutInfo> consumer);
}
