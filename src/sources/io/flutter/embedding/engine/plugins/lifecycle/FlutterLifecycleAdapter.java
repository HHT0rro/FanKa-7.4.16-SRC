package io.flutter.embedding.engine.plugins.lifecycle;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class FlutterLifecycleAdapter {
    @NonNull
    public static Lifecycle getActivityLifecycle(@NonNull ActivityPluginBinding activityPluginBinding) {
        return ((HiddenLifecycleReference) activityPluginBinding.getLifecycle()).getLifecycle();
    }
}
