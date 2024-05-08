package androidx.core.app;

import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.core.util.Consumer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface OnNewIntentProvider {
    void addOnNewIntentListener(@NonNull Consumer<Intent> consumer);

    void removeOnNewIntentListener(@NonNull Consumer<Intent> consumer);
}
