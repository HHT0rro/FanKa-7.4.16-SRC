package androidx.savedstate;

import androidx.lifecycle.LifecycleOwner;
import org.jetbrains.annotations.NotNull;

/* compiled from: SavedStateRegistryOwner.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface SavedStateRegistryOwner extends LifecycleOwner {
    @NotNull
    SavedStateRegistry getSavedStateRegistry();
}
