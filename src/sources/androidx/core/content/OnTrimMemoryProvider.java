package androidx.core.content;

import androidx.annotation.NonNull;
import androidx.core.util.Consumer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface OnTrimMemoryProvider {
    void addOnTrimMemoryListener(@NonNull Consumer<Integer> consumer);

    void removeOnTrimMemoryListener(@NonNull Consumer<Integer> consumer);
}
