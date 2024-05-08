package androidx.window.layout;

import android.graphics.Rect;
import androidx.annotation.RestrictTo;
import androidx.window.core.Bounds;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: WindowMetrics.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class WindowMetrics {

    @NotNull
    private final Bounds _bounds;

    public WindowMetrics(@NotNull Bounds _bounds) {
        s.i(_bounds, "_bounds");
        this._bounds = _bounds;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !s.d(WindowMetrics.class, obj.getClass())) {
            return false;
        }
        return s.d(this._bounds, ((WindowMetrics) obj)._bounds);
    }

    @NotNull
    public final Rect getBounds() {
        return this._bounds.toRect();
    }

    public int hashCode() {
        return this._bounds.hashCode();
    }

    @NotNull
    public String toString() {
        return "WindowMetrics { bounds: " + ((Object) getBounds()) + " }";
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @RestrictTo({RestrictTo.Scope.TESTS})
    public WindowMetrics(@NotNull Rect bounds) {
        this(new Bounds(bounds));
        s.i(bounds, "bounds");
    }
}
