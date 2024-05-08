package io.flutter.plugin.platform;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.flutter.embedding.android.FlutterImageView;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class PlatformOverlayView extends FlutterImageView {

    @Nullable
    private AccessibilityEventsDelegate accessibilityDelegate;

    public PlatformOverlayView(@NonNull Context context, int i10, int i11, @NonNull AccessibilityEventsDelegate accessibilityEventsDelegate) {
        super(context, i10, i11, FlutterImageView.SurfaceKind.overlay);
        this.accessibilityDelegate = accessibilityEventsDelegate;
    }

    @Override // android.view.View
    public boolean onHoverEvent(@NonNull MotionEvent motionEvent) {
        AccessibilityEventsDelegate accessibilityEventsDelegate = this.accessibilityDelegate;
        if (accessibilityEventsDelegate == null || !accessibilityEventsDelegate.onAccessibilityHoverEvent(motionEvent, true)) {
            return super.onHoverEvent(motionEvent);
        }
        return true;
    }

    public PlatformOverlayView(@NonNull Context context) {
        this(context, 1, 1, null);
    }

    public PlatformOverlayView(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        this(context, 1, 1, null);
    }
}
