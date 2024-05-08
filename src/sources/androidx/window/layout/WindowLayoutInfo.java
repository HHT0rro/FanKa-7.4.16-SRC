package androidx.window.layout;

import androidx.annotation.RestrictTo;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: WindowLayoutInfo.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class WindowLayoutInfo {

    @NotNull
    private final List<DisplayFeature> displayFeatures;

    /* JADX WARN: Multi-variable type inference failed */
    @RestrictTo({RestrictTo.Scope.TESTS})
    public WindowLayoutInfo(@NotNull List<? extends DisplayFeature> displayFeatures) {
        s.i(displayFeatures, "displayFeatures");
        this.displayFeatures = displayFeatures;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !s.d(WindowLayoutInfo.class, obj.getClass())) {
            return false;
        }
        return s.d(this.displayFeatures, ((WindowLayoutInfo) obj).displayFeatures);
    }

    @NotNull
    public final List<DisplayFeature> getDisplayFeatures() {
        return this.displayFeatures;
    }

    public int hashCode() {
        return this.displayFeatures.hashCode();
    }

    @NotNull
    public String toString() {
        return CollectionsKt___CollectionsKt.c0(this.displayFeatures, ", ", "WindowLayoutInfo{ DisplayFeatures[", "] }", 0, null, null, 56, null);
    }
}
