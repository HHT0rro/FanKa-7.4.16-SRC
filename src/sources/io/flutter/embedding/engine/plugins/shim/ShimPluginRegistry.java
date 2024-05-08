package io.flutter.embedding.engine.plugins.shim;

import androidx.annotation.NonNull;
import io.flutter.Log;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.PluginRegistry;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class ShimPluginRegistry implements PluginRegistry {
    private static final String TAG = "ShimPluginRegistry";
    private final FlutterEngine flutterEngine;
    private final Map<String, Object> pluginMap = new HashMap();
    private final ShimRegistrarAggregate shimRegistrarAggregate;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class ShimRegistrarAggregate implements FlutterPlugin, ActivityAware {
        private ActivityPluginBinding activityPluginBinding;
        private FlutterPlugin.FlutterPluginBinding flutterPluginBinding;
        private final Set<ShimRegistrar> shimRegistrars;

        private ShimRegistrarAggregate() {
            this.shimRegistrars = new HashSet();
        }

        public void addPlugin(@NonNull ShimRegistrar shimRegistrar) {
            this.shimRegistrars.add(shimRegistrar);
            FlutterPlugin.FlutterPluginBinding flutterPluginBinding = this.flutterPluginBinding;
            if (flutterPluginBinding != null) {
                shimRegistrar.onAttachedToEngine(flutterPluginBinding);
            }
            ActivityPluginBinding activityPluginBinding = this.activityPluginBinding;
            if (activityPluginBinding != null) {
                shimRegistrar.onAttachedToActivity(activityPluginBinding);
            }
        }

        @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
        public void onAttachedToActivity(@NonNull ActivityPluginBinding activityPluginBinding) {
            this.activityPluginBinding = activityPluginBinding;
            Iterator<ShimRegistrar> iterator2 = this.shimRegistrars.iterator2();
            while (iterator2.hasNext()) {
                iterator2.next().onAttachedToActivity(activityPluginBinding);
            }
        }

        @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
        public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
            this.flutterPluginBinding = flutterPluginBinding;
            Iterator<ShimRegistrar> iterator2 = this.shimRegistrars.iterator2();
            while (iterator2.hasNext()) {
                iterator2.next().onAttachedToEngine(flutterPluginBinding);
            }
        }

        @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
        public void onDetachedFromActivity() {
            Iterator<ShimRegistrar> iterator2 = this.shimRegistrars.iterator2();
            while (iterator2.hasNext()) {
                iterator2.next().onDetachedFromActivity();
            }
            this.activityPluginBinding = null;
        }

        @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
        public void onDetachedFromActivityForConfigChanges() {
            Iterator<ShimRegistrar> iterator2 = this.shimRegistrars.iterator2();
            while (iterator2.hasNext()) {
                iterator2.next().onDetachedFromActivity();
            }
            this.activityPluginBinding = null;
        }

        @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
        public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
            Iterator<ShimRegistrar> iterator2 = this.shimRegistrars.iterator2();
            while (iterator2.hasNext()) {
                iterator2.next().onDetachedFromEngine(flutterPluginBinding);
            }
            this.flutterPluginBinding = null;
            this.activityPluginBinding = null;
        }

        @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
        public void onReattachedToActivityForConfigChanges(@NonNull ActivityPluginBinding activityPluginBinding) {
            this.activityPluginBinding = activityPluginBinding;
            Iterator<ShimRegistrar> iterator2 = this.shimRegistrars.iterator2();
            while (iterator2.hasNext()) {
                iterator2.next().onReattachedToActivityForConfigChanges(activityPluginBinding);
            }
        }
    }

    public ShimPluginRegistry(@NonNull FlutterEngine flutterEngine) {
        this.flutterEngine = flutterEngine;
        ShimRegistrarAggregate shimRegistrarAggregate = new ShimRegistrarAggregate();
        this.shimRegistrarAggregate = shimRegistrarAggregate;
        flutterEngine.getPlugins().add(shimRegistrarAggregate);
    }

    @Override // io.flutter.plugin.common.PluginRegistry
    public boolean hasPlugin(@NonNull String str) {
        return this.pluginMap.containsKey(str);
    }

    @Override // io.flutter.plugin.common.PluginRegistry
    @NonNull
    public PluginRegistry.Registrar registrarFor(@NonNull String str) {
        Log.v(TAG, "Creating plugin Registrar for '" + str + "'");
        if (!this.pluginMap.containsKey(str)) {
            this.pluginMap.put(str, null);
            ShimRegistrar shimRegistrar = new ShimRegistrar(str, this.pluginMap);
            this.shimRegistrarAggregate.addPlugin(shimRegistrar);
            return shimRegistrar;
        }
        throw new IllegalStateException("Plugin key " + str + " is already in use");
    }

    @Override // io.flutter.plugin.common.PluginRegistry
    public <T> T valuePublishedByPlugin(@NonNull String str) {
        return (T) this.pluginMap.get(str);
    }
}
