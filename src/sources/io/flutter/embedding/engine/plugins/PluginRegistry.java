package io.flutter.embedding.engine.plugins;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Set;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface PluginRegistry {
    void add(@NonNull FlutterPlugin flutterPlugin);

    void add(@NonNull Set<FlutterPlugin> set);

    @Nullable
    FlutterPlugin get(@NonNull Class<? extends FlutterPlugin> cls);

    boolean has(@NonNull Class<? extends FlutterPlugin> cls);

    void remove(@NonNull Class<? extends FlutterPlugin> cls);

    void remove(@NonNull Set<Class<? extends FlutterPlugin>> set);

    void removeAll();
}
