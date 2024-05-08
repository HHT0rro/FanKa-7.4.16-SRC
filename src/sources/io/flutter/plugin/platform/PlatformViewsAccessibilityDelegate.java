package io.flutter.plugin.platform;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.flutter.view.AccessibilityBridge;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface PlatformViewsAccessibilityDelegate {
    void attachAccessibilityBridge(@NonNull AccessibilityBridge accessibilityBridge);

    void detachAccessibilityBridge();

    @Nullable
    View getPlatformViewById(int i10);

    boolean usesVirtualDisplay(int i10);
}
