package androidx.core.app;

import androidx.annotation.NonNull;
import androidx.core.util.Consumer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface OnMultiWindowModeChangedProvider {
    void addOnMultiWindowModeChangedListener(@NonNull Consumer<MultiWindowModeChangedInfo> consumer);

    void removeOnMultiWindowModeChangedListener(@NonNull Consumer<MultiWindowModeChangedInfo> consumer);
}
