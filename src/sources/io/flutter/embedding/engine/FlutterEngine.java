package io.flutter.embedding.engine;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import io.flutter.FlutterInjector;
import io.flutter.Log;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.deferredcomponents.DeferredComponentManager;
import io.flutter.embedding.engine.loader.FlutterLoader;
import io.flutter.embedding.engine.plugins.PluginRegistry;
import io.flutter.embedding.engine.plugins.activity.ActivityControlSurface;
import io.flutter.embedding.engine.plugins.broadcastreceiver.BroadcastReceiverControlSurface;
import io.flutter.embedding.engine.plugins.contentprovider.ContentProviderControlSurface;
import io.flutter.embedding.engine.plugins.service.ServiceControlSurface;
import io.flutter.embedding.engine.plugins.util.GeneratedPluginRegister;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import io.flutter.embedding.engine.systemchannels.AccessibilityChannel;
import io.flutter.embedding.engine.systemchannels.DeferredComponentChannel;
import io.flutter.embedding.engine.systemchannels.LifecycleChannel;
import io.flutter.embedding.engine.systemchannels.LocalizationChannel;
import io.flutter.embedding.engine.systemchannels.MouseCursorChannel;
import io.flutter.embedding.engine.systemchannels.NavigationChannel;
import io.flutter.embedding.engine.systemchannels.PlatformChannel;
import io.flutter.embedding.engine.systemchannels.ProcessTextChannel;
import io.flutter.embedding.engine.systemchannels.RestorationChannel;
import io.flutter.embedding.engine.systemchannels.SettingsChannel;
import io.flutter.embedding.engine.systemchannels.SpellCheckChannel;
import io.flutter.embedding.engine.systemchannels.SystemChannel;
import io.flutter.embedding.engine.systemchannels.TextInputChannel;
import io.flutter.plugin.localization.LocalizationPlugin;
import io.flutter.plugin.platform.PlatformViewsController;
import io.flutter.plugin.text.ProcessTextPlugin;
import io.flutter.util.ViewUtils;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class FlutterEngine implements ViewUtils.DisplayUpdater {
    private static final String TAG = "FlutterEngine";

    @NonNull
    private final AccessibilityChannel accessibilityChannel;

    @NonNull
    private final DartExecutor dartExecutor;

    @NonNull
    private final DeferredComponentChannel deferredComponentChannel;

    @NonNull
    private final EngineLifecycleListener engineLifecycleListener;

    @NonNull
    private final Set<EngineLifecycleListener> engineLifecycleListeners;

    @NonNull
    private final FlutterJNI flutterJNI;

    @NonNull
    private final LifecycleChannel lifecycleChannel;

    @NonNull
    private final LocalizationChannel localizationChannel;

    @NonNull
    private final LocalizationPlugin localizationPlugin;

    @NonNull
    private final MouseCursorChannel mouseCursorChannel;

    @NonNull
    private final NavigationChannel navigationChannel;

    @NonNull
    private final PlatformChannel platformChannel;

    @NonNull
    private final PlatformViewsController platformViewsController;

    @NonNull
    private final FlutterEngineConnectionRegistry pluginRegistry;

    @NonNull
    private final ProcessTextChannel processTextChannel;

    @NonNull
    private final FlutterRenderer renderer;

    @NonNull
    private final RestorationChannel restorationChannel;

    @NonNull
    private final SettingsChannel settingsChannel;

    @NonNull
    private final SpellCheckChannel spellCheckChannel;

    @NonNull
    private final SystemChannel systemChannel;

    @NonNull
    private final TextInputChannel textInputChannel;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface EngineLifecycleListener {
        void onEngineWillDestroy();

        void onPreEngineRestart();
    }

    public FlutterEngine(@NonNull Context context) {
        this(context, null);
    }

    private void attachToJni() {
        Log.v(TAG, "Attaching to JNI.");
        this.flutterJNI.attachToNative();
        if (!isAttachedToJni()) {
            throw new RuntimeException("FlutterEngine failed to attach to its native Object reference.");
        }
    }

    private boolean isAttachedToJni() {
        return this.flutterJNI.isAttached();
    }

    public void addEngineLifecycleListener(@NonNull EngineLifecycleListener engineLifecycleListener) {
        this.engineLifecycleListeners.add(engineLifecycleListener);
    }

    public void destroy() {
        Log.v(TAG, "Destroying.");
        Iterator<EngineLifecycleListener> iterator2 = this.engineLifecycleListeners.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().onEngineWillDestroy();
        }
        this.pluginRegistry.destroy();
        this.platformViewsController.onDetachedFromJNI();
        this.dartExecutor.onDetachedFromJNI();
        this.flutterJNI.removeEngineLifecycleListener(this.engineLifecycleListener);
        this.flutterJNI.setDeferredComponentManager(null);
        this.flutterJNI.detachFromNativeAndReleaseResources();
        if (FlutterInjector.instance().deferredComponentManager() != null) {
            FlutterInjector.instance().deferredComponentManager().destroy();
            this.deferredComponentChannel.setDeferredComponentManager(null);
        }
    }

    @NonNull
    public AccessibilityChannel getAccessibilityChannel() {
        return this.accessibilityChannel;
    }

    @NonNull
    public ActivityControlSurface getActivityControlSurface() {
        return this.pluginRegistry;
    }

    @NonNull
    public BroadcastReceiverControlSurface getBroadcastReceiverControlSurface() {
        return this.pluginRegistry;
    }

    @NonNull
    public ContentProviderControlSurface getContentProviderControlSurface() {
        return this.pluginRegistry;
    }

    @NonNull
    public DartExecutor getDartExecutor() {
        return this.dartExecutor;
    }

    @NonNull
    public DeferredComponentChannel getDeferredComponentChannel() {
        return this.deferredComponentChannel;
    }

    @NonNull
    public LifecycleChannel getLifecycleChannel() {
        return this.lifecycleChannel;
    }

    @NonNull
    public LocalizationChannel getLocalizationChannel() {
        return this.localizationChannel;
    }

    @NonNull
    public LocalizationPlugin getLocalizationPlugin() {
        return this.localizationPlugin;
    }

    @NonNull
    public MouseCursorChannel getMouseCursorChannel() {
        return this.mouseCursorChannel;
    }

    @NonNull
    public NavigationChannel getNavigationChannel() {
        return this.navigationChannel;
    }

    @NonNull
    public PlatformChannel getPlatformChannel() {
        return this.platformChannel;
    }

    @NonNull
    public PlatformViewsController getPlatformViewsController() {
        return this.platformViewsController;
    }

    @NonNull
    public PluginRegistry getPlugins() {
        return this.pluginRegistry;
    }

    @NonNull
    public ProcessTextChannel getProcessTextChannel() {
        return this.processTextChannel;
    }

    @NonNull
    public FlutterRenderer getRenderer() {
        return this.renderer;
    }

    @NonNull
    public RestorationChannel getRestorationChannel() {
        return this.restorationChannel;
    }

    @NonNull
    public ServiceControlSurface getServiceControlSurface() {
        return this.pluginRegistry;
    }

    @NonNull
    public SettingsChannel getSettingsChannel() {
        return this.settingsChannel;
    }

    @NonNull
    public SpellCheckChannel getSpellCheckChannel() {
        return this.spellCheckChannel;
    }

    @NonNull
    public SystemChannel getSystemChannel() {
        return this.systemChannel;
    }

    @NonNull
    public TextInputChannel getTextInputChannel() {
        return this.textInputChannel;
    }

    public void removeEngineLifecycleListener(@NonNull EngineLifecycleListener engineLifecycleListener) {
        this.engineLifecycleListeners.remove(engineLifecycleListener);
    }

    @NonNull
    public FlutterEngine spawn(@NonNull Context context, @NonNull DartExecutor.DartEntrypoint dartEntrypoint, @Nullable String str, @Nullable List<String> list, @Nullable PlatformViewsController platformViewsController, boolean z10, boolean z11) {
        if (isAttachedToJni()) {
            return new FlutterEngine(context, null, this.flutterJNI.spawn(dartEntrypoint.dartEntrypointFunctionName, dartEntrypoint.dartEntrypointLibrary, str, list), platformViewsController, null, z10, z11);
        }
        throw new IllegalStateException("Spawn can only be called on a fully constructed FlutterEngine");
    }

    @Override // io.flutter.util.ViewUtils.DisplayUpdater
    public void updateDisplayMetrics(float f10, float f11, float f12) {
        this.flutterJNI.updateDisplayMetrics(0, f10, f11, f12);
    }

    public FlutterEngine(@NonNull Context context, @Nullable String[] strArr) {
        this(context, null, null, strArr, true);
    }

    public FlutterEngine(@NonNull Context context, @Nullable String[] strArr, boolean z10) {
        this(context, null, null, strArr, z10);
    }

    public FlutterEngine(@NonNull Context context, @Nullable String[] strArr, boolean z10, boolean z11) {
        this(context, null, null, new PlatformViewsController(), strArr, z10, z11);
    }

    public FlutterEngine(@NonNull Context context, @Nullable FlutterLoader flutterLoader, @NonNull FlutterJNI flutterJNI) {
        this(context, flutterLoader, flutterJNI, null, true);
    }

    public FlutterEngine(@NonNull Context context, @Nullable FlutterLoader flutterLoader, @NonNull FlutterJNI flutterJNI, @Nullable String[] strArr, boolean z10) {
        this(context, flutterLoader, flutterJNI, new PlatformViewsController(), strArr, z10);
    }

    public FlutterEngine(@NonNull Context context, @Nullable FlutterLoader flutterLoader, @NonNull FlutterJNI flutterJNI, @NonNull PlatformViewsController platformViewsController, @Nullable String[] strArr, boolean z10) {
        this(context, flutterLoader, flutterJNI, platformViewsController, strArr, z10, false);
    }

    public FlutterEngine(@NonNull Context context, @Nullable FlutterLoader flutterLoader, @NonNull FlutterJNI flutterJNI, @NonNull PlatformViewsController platformViewsController, @Nullable String[] strArr, boolean z10, boolean z11) {
        this(context, flutterLoader, flutterJNI, platformViewsController, strArr, z10, z11, null);
    }

    @VisibleForTesting(otherwise = 3)
    public FlutterEngine(@NonNull Context context, @Nullable FlutterLoader flutterLoader, @NonNull FlutterJNI flutterJNI, @NonNull PlatformViewsController platformViewsController, @Nullable String[] strArr, boolean z10, boolean z11, @Nullable FlutterEngineGroup flutterEngineGroup) {
        AssetManager assets;
        this.engineLifecycleListeners = new HashSet();
        this.engineLifecycleListener = new EngineLifecycleListener() { // from class: io.flutter.embedding.engine.FlutterEngine.1
            @Override // io.flutter.embedding.engine.FlutterEngine.EngineLifecycleListener
            public void onEngineWillDestroy() {
            }

            @Override // io.flutter.embedding.engine.FlutterEngine.EngineLifecycleListener
            public void onPreEngineRestart() {
                Log.v(FlutterEngine.TAG, "onPreEngineRestart()");
                Iterator iterator2 = FlutterEngine.this.engineLifecycleListeners.iterator2();
                while (iterator2.hasNext()) {
                    ((EngineLifecycleListener) iterator2.next()).onPreEngineRestart();
                }
                FlutterEngine.this.platformViewsController.onPreEngineRestart();
                FlutterEngine.this.restorationChannel.clearData();
            }
        };
        try {
            assets = context.createPackageContext(context.getPackageName(), 0).getAssets();
        } catch (PackageManager.NameNotFoundException unused) {
            assets = context.getAssets();
        }
        FlutterInjector instance = FlutterInjector.instance();
        flutterJNI = flutterJNI == null ? instance.getFlutterJNIFactory().provideFlutterJNI() : flutterJNI;
        this.flutterJNI = flutterJNI;
        DartExecutor dartExecutor = new DartExecutor(flutterJNI, assets);
        this.dartExecutor = dartExecutor;
        dartExecutor.onAttachedToJNI();
        DeferredComponentManager deferredComponentManager = FlutterInjector.instance().deferredComponentManager();
        this.accessibilityChannel = new AccessibilityChannel(dartExecutor, flutterJNI);
        DeferredComponentChannel deferredComponentChannel = new DeferredComponentChannel(dartExecutor);
        this.deferredComponentChannel = deferredComponentChannel;
        this.lifecycleChannel = new LifecycleChannel(dartExecutor);
        LocalizationChannel localizationChannel = new LocalizationChannel(dartExecutor);
        this.localizationChannel = localizationChannel;
        this.mouseCursorChannel = new MouseCursorChannel(dartExecutor);
        this.navigationChannel = new NavigationChannel(dartExecutor);
        this.platformChannel = new PlatformChannel(dartExecutor);
        this.processTextChannel = new ProcessTextChannel(dartExecutor, context.getPackageManager());
        this.restorationChannel = new RestorationChannel(dartExecutor, z11);
        this.settingsChannel = new SettingsChannel(dartExecutor);
        this.spellCheckChannel = new SpellCheckChannel(dartExecutor);
        this.systemChannel = new SystemChannel(dartExecutor);
        this.textInputChannel = new TextInputChannel(dartExecutor);
        if (deferredComponentManager != null) {
            deferredComponentManager.setDeferredComponentChannel(deferredComponentChannel);
        }
        LocalizationPlugin localizationPlugin = new LocalizationPlugin(context, localizationChannel);
        this.localizationPlugin = localizationPlugin;
        flutterLoader = flutterLoader == null ? instance.flutterLoader() : flutterLoader;
        if (!flutterJNI.isAttached()) {
            flutterLoader.startInitialization(context.getApplicationContext());
            flutterLoader.ensureInitializationComplete(context, strArr);
        }
        flutterJNI.addEngineLifecycleListener(this.engineLifecycleListener);
        flutterJNI.setPlatformViewsController(platformViewsController);
        flutterJNI.setLocalizationPlugin(localizationPlugin);
        flutterJNI.setDeferredComponentManager(instance.deferredComponentManager());
        if (!flutterJNI.isAttached()) {
            attachToJni();
        }
        this.renderer = new FlutterRenderer(flutterJNI);
        this.platformViewsController = platformViewsController;
        platformViewsController.onAttachedToJNI();
        FlutterEngineConnectionRegistry flutterEngineConnectionRegistry = new FlutterEngineConnectionRegistry(context.getApplicationContext(), this, flutterLoader, flutterEngineGroup);
        this.pluginRegistry = flutterEngineConnectionRegistry;
        localizationPlugin.sendLocalesToFlutter(context.getResources().getConfiguration());
        if (z10 && flutterLoader.automaticallyRegisterPlugins()) {
            GeneratedPluginRegister.registerGeneratedPlugins(this);
        }
        ViewUtils.calculateMaximumDisplayMetrics(context, this);
        flutterEngineConnectionRegistry.add(new ProcessTextPlugin(getProcessTextChannel()));
    }
}
