package androidx.lifecycle;

import java.util.LinkedHashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

/* compiled from: SavedStateHandleSupport.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class SavedStateHandlesVM extends ViewModel {

    @NotNull
    private final Map<String, SavedStateHandle> handles = new LinkedHashMap();

    @NotNull
    public final Map<String, SavedStateHandle> getHandles() {
        return this.handles;
    }
}
