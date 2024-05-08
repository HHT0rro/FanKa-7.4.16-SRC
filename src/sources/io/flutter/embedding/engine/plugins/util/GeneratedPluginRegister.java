package io.flutter.embedding.engine.plugins.util;

import androidx.annotation.NonNull;
import io.flutter.Log;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugins.GeneratedPluginRegistrant;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class GeneratedPluginRegister {
    private static final String TAG = "GeneratedPluginsRegister";

    public static void registerGeneratedPlugins(@NonNull FlutterEngine flutterEngine) {
        try {
            GeneratedPluginRegistrant.class.getDeclaredMethod("registerWith", FlutterEngine.class).invoke(null, flutterEngine);
        } catch (Exception e2) {
            Log.e(TAG, "Tried to automatically register plugins with FlutterEngine (" + ((Object) flutterEngine) + ") but could not find or invoke the GeneratedPluginRegistrant.");
            Log.e(TAG, "Received exception while registering", e2);
        }
    }
}
