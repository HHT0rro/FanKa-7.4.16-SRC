package io.flutter.embedding.engine.plugins.activity;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.flutter.plugin.common.PluginRegistry;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface ActivityPluginBinding {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface OnSaveInstanceStateListener {
        void onRestoreInstanceState(@Nullable Bundle bundle);

        void onSaveInstanceState(@NonNull Bundle bundle);
    }

    void addActivityResultListener(@NonNull PluginRegistry.ActivityResultListener activityResultListener);

    void addOnNewIntentListener(@NonNull PluginRegistry.NewIntentListener newIntentListener);

    void addOnSaveStateListener(@NonNull OnSaveInstanceStateListener onSaveInstanceStateListener);

    void addOnUserLeaveHintListener(@NonNull PluginRegistry.UserLeaveHintListener userLeaveHintListener);

    void addOnWindowFocusChangedListener(@NonNull PluginRegistry.WindowFocusChangedListener windowFocusChangedListener);

    void addRequestPermissionsResultListener(@NonNull PluginRegistry.RequestPermissionsResultListener requestPermissionsResultListener);

    @NonNull
    Activity getActivity();

    @NonNull
    Object getLifecycle();

    void removeActivityResultListener(@NonNull PluginRegistry.ActivityResultListener activityResultListener);

    void removeOnNewIntentListener(@NonNull PluginRegistry.NewIntentListener newIntentListener);

    void removeOnSaveStateListener(@NonNull OnSaveInstanceStateListener onSaveInstanceStateListener);

    void removeOnUserLeaveHintListener(@NonNull PluginRegistry.UserLeaveHintListener userLeaveHintListener);

    void removeOnWindowFocusChangedListener(@NonNull PluginRegistry.WindowFocusChangedListener windowFocusChangedListener);

    void removeRequestPermissionsResultListener(@NonNull PluginRegistry.RequestPermissionsResultListener requestPermissionsResultListener);
}
