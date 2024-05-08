package android.view;

import android.os.CancellationSignal;
import android.view.animation.Interpolator;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface WindowInsetsController {
    public static final int APPEARANCE_LIGHT_NAVIGATION_BARS = 16;
    public static final int APPEARANCE_LIGHT_STATUS_BARS = 8;
    public static final int APPEARANCE_LOW_PROFILE_BARS = 4;
    public static final int APPEARANCE_OPAQUE_NAVIGATION_BARS = 2;
    public static final int APPEARANCE_OPAQUE_STATUS_BARS = 1;
    public static final int APPEARANCE_SEMI_TRANSPARENT_NAVIGATION_BARS = 64;
    public static final int APPEARANCE_SEMI_TRANSPARENT_STATUS_BARS = 32;
    public static final int BEHAVIOR_DEFAULT = 1;

    @Deprecated
    public static final int BEHAVIOR_SHOW_BARS_BY_SWIPE = 1;

    @Deprecated
    public static final int BEHAVIOR_SHOW_BARS_BY_TOUCH = 0;
    public static final int BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE = 2;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public @interface Appearance {
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public @interface Behavior {
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public interface OnControllableInsetsChangedListener {
        void onControllableInsetsChanged(WindowInsetsController windowInsetsController, int i10);
    }

    void addOnControllableInsetsChangedListener(OnControllableInsetsChangedListener onControllableInsetsChangedListener);

    void controlWindowInsetsAnimation(int i10, long j10, Interpolator interpolator, CancellationSignal cancellationSignal, WindowInsetsAnimationControlListener windowInsetsAnimationControlListener);

    int getRequestedVisibleTypes();

    InsetsState getState();

    int getSystemBarsAppearance();

    int getSystemBarsBehavior();

    void hide(int i10);

    void removeOnControllableInsetsChangedListener(OnControllableInsetsChangedListener onControllableInsetsChangedListener);

    void setAnimationsDisabled(boolean z10);

    void setCaptionInsetsHeight(int i10);

    void setSystemBarsAppearance(int i10, int i11);

    void setSystemBarsBehavior(int i10);

    void setSystemDrivenInsetsAnimationLoggingListener(WindowInsetsAnimationControlListener windowInsetsAnimationControlListener);

    void show(int i10);
}
