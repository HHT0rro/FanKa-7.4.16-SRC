package androidx.activity.contextaware;

import android.content.Context;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ContextAware.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface ContextAware {
    void addOnContextAvailableListener(@NotNull OnContextAvailableListener onContextAvailableListener);

    @Nullable
    Context peekAvailableContext();

    void removeOnContextAvailableListener(@NotNull OnContextAvailableListener onContextAvailableListener);
}
