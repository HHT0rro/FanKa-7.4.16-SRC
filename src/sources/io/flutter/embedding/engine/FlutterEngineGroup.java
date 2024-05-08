package io.flutter.embedding.engine;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import io.flutter.FlutterInjector;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.loader.FlutterLoader;
import io.flutter.plugin.platform.PlatformViewsController;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class FlutterEngineGroup {

    @VisibleForTesting
    public final List<FlutterEngine> activeEngines;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class Options {

        @NonNull
        private Context context;

        @Nullable
        private DartExecutor.DartEntrypoint dartEntrypoint;

        @Nullable
        private List<String> dartEntrypointArgs;

        @Nullable
        private String initialRoute;

        @NonNull
        private PlatformViewsController platformViewsController;
        private boolean automaticallyRegisterPlugins = true;
        private boolean waitForRestorationData = false;

        public Options(@NonNull Context context) {
            this.context = context;
        }

        public boolean getAutomaticallyRegisterPlugins() {
            return this.automaticallyRegisterPlugins;
        }

        public Context getContext() {
            return this.context;
        }

        public DartExecutor.DartEntrypoint getDartEntrypoint() {
            return this.dartEntrypoint;
        }

        public List<String> getDartEntrypointArgs() {
            return this.dartEntrypointArgs;
        }

        public String getInitialRoute() {
            return this.initialRoute;
        }

        public PlatformViewsController getPlatformViewsController() {
            return this.platformViewsController;
        }

        public boolean getWaitForRestorationData() {
            return this.waitForRestorationData;
        }

        public Options setAutomaticallyRegisterPlugins(boolean z10) {
            this.automaticallyRegisterPlugins = z10;
            return this;
        }

        public Options setDartEntrypoint(DartExecutor.DartEntrypoint dartEntrypoint) {
            this.dartEntrypoint = dartEntrypoint;
            return this;
        }

        public Options setDartEntrypointArgs(List<String> list) {
            this.dartEntrypointArgs = list;
            return this;
        }

        public Options setInitialRoute(String str) {
            this.initialRoute = str;
            return this;
        }

        public Options setPlatformViewsController(@NonNull PlatformViewsController platformViewsController) {
            this.platformViewsController = platformViewsController;
            return this;
        }

        public Options setWaitForRestorationData(boolean z10) {
            this.waitForRestorationData = z10;
            return this;
        }
    }

    public FlutterEngineGroup(@NonNull Context context) {
        this(context, null);
    }

    public FlutterEngine createAndRunDefaultEngine(@NonNull Context context) {
        return createAndRunEngine(context, null);
    }

    public FlutterEngine createAndRunEngine(@NonNull Context context, @Nullable DartExecutor.DartEntrypoint dartEntrypoint) {
        return createAndRunEngine(context, dartEntrypoint, null);
    }

    @VisibleForTesting
    public FlutterEngine createEngine(Context context, @NonNull PlatformViewsController platformViewsController, boolean z10, boolean z11) {
        return new FlutterEngine(context, null, null, platformViewsController, null, z10, z11, this);
    }

    public FlutterEngineGroup(@NonNull Context context, @Nullable String[] strArr) {
        this.activeEngines = new ArrayList();
        FlutterLoader flutterLoader = FlutterInjector.instance().flutterLoader();
        if (flutterLoader.initialized()) {
            return;
        }
        flutterLoader.startInitialization(context.getApplicationContext());
        flutterLoader.ensureInitializationComplete(context.getApplicationContext(), strArr);
    }

    public FlutterEngine createAndRunEngine(@NonNull Context context, @Nullable DartExecutor.DartEntrypoint dartEntrypoint, @Nullable String str) {
        return createAndRunEngine(new Options(context).setDartEntrypoint(dartEntrypoint).setInitialRoute(str));
    }

    public FlutterEngine createAndRunEngine(@NonNull Options options) {
        final FlutterEngine spawn;
        Context context = options.getContext();
        DartExecutor.DartEntrypoint dartEntrypoint = options.getDartEntrypoint();
        String initialRoute = options.getInitialRoute();
        List<String> dartEntrypointArgs = options.getDartEntrypointArgs();
        PlatformViewsController platformViewsController = options.getPlatformViewsController();
        if (platformViewsController == null) {
            platformViewsController = new PlatformViewsController();
        }
        PlatformViewsController platformViewsController2 = platformViewsController;
        boolean automaticallyRegisterPlugins = options.getAutomaticallyRegisterPlugins();
        boolean waitForRestorationData = options.getWaitForRestorationData();
        DartExecutor.DartEntrypoint createDefault = dartEntrypoint == null ? DartExecutor.DartEntrypoint.createDefault() : dartEntrypoint;
        if (this.activeEngines.size() == 0) {
            spawn = createEngine(context, platformViewsController2, automaticallyRegisterPlugins, waitForRestorationData);
            if (initialRoute != null) {
                spawn.getNavigationChannel().setInitialRoute(initialRoute);
            }
            spawn.getDartExecutor().executeDartEntrypoint(createDefault, dartEntrypointArgs);
        } else {
            spawn = this.activeEngines.get(0).spawn(context, createDefault, initialRoute, dartEntrypointArgs, platformViewsController2, automaticallyRegisterPlugins, waitForRestorationData);
        }
        this.activeEngines.add(spawn);
        spawn.addEngineLifecycleListener(new FlutterEngine.EngineLifecycleListener() { // from class: io.flutter.embedding.engine.FlutterEngineGroup.1
            @Override // io.flutter.embedding.engine.FlutterEngine.EngineLifecycleListener
            public void onEngineWillDestroy() {
                FlutterEngineGroup.this.activeEngines.remove(spawn);
            }

            @Override // io.flutter.embedding.engine.FlutterEngine.EngineLifecycleListener
            public void onPreEngineRestart() {
            }
        });
        return spawn;
    }
}
