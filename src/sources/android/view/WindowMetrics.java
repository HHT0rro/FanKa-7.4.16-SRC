package android.view;

import android.graphics.Rect;
import com.alipay.sdk.util.i;
import java.util.function.Supplier;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public final class WindowMetrics {
    private final Rect mBounds;
    private final float mDensity;
    private WindowInsets mWindowInsets;
    private Supplier<WindowInsets> mWindowInsetsSupplier;

    @Deprecated
    public WindowMetrics(Rect bounds, WindowInsets windowInsets) {
        this(bounds, windowInsets, 1.0f);
    }

    public WindowMetrics(Rect bounds, WindowInsets windowInsets, float density) {
        this.mBounds = bounds;
        this.mWindowInsets = windowInsets;
        this.mDensity = density;
    }

    public WindowMetrics(Rect bounds, Supplier<WindowInsets> windowInsetsSupplier, float density) {
        this.mBounds = bounds;
        this.mWindowInsetsSupplier = windowInsetsSupplier;
        this.mDensity = density;
    }

    public Rect getBounds() {
        return this.mBounds;
    }

    public WindowInsets getWindowInsets() {
        WindowInsets windowInsets = this.mWindowInsets;
        if (windowInsets != null) {
            return windowInsets;
        }
        WindowInsets windowInsets2 = this.mWindowInsetsSupplier.get();
        this.mWindowInsets = windowInsets2;
        return windowInsets2;
    }

    public float getDensity() {
        return this.mDensity;
    }

    public String toString() {
        return WindowMetrics.class.getSimpleName() + ":{bounds=" + ((Object) this.mBounds) + ", windowInsets=" + ((Object) this.mWindowInsets) + ", density=" + this.mDensity + i.f4738d;
    }
}
