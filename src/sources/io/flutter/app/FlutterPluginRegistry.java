package io.flutter.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.PluginRegistry;
import io.flutter.plugin.platform.PlatformViewRegistry;
import io.flutter.plugin.platform.PlatformViewsController;
import io.flutter.view.FlutterMain;
import io.flutter.view.FlutterNativeView;
import io.flutter.view.FlutterView;
import io.flutter.view.TextureRegistry;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Deprecated
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class FlutterPluginRegistry implements PluginRegistry, PluginRegistry.RequestPermissionsResultListener, PluginRegistry.ActivityResultListener, PluginRegistry.NewIntentListener, PluginRegistry.WindowFocusChangedListener, PluginRegistry.UserLeaveHintListener, PluginRegistry.ViewDestroyListener {
    private static final String TAG = "FlutterPluginRegistry";
    private Activity mActivity;
    private Context mAppContext;
    private FlutterView mFlutterView;
    private FlutterNativeView mNativeView;
    private final Map<String, Object> mPluginMap = new LinkedHashMap(0);
    private final List<PluginRegistry.RequestPermissionsResultListener> mRequestPermissionsResultListeners = new ArrayList(0);
    private final List<PluginRegistry.ActivityResultListener> mActivityResultListeners = new ArrayList(0);
    private final List<PluginRegistry.NewIntentListener> mNewIntentListeners = new ArrayList(0);
    private final List<PluginRegistry.UserLeaveHintListener> mUserLeaveHintListeners = new ArrayList(0);
    private final List<PluginRegistry.WindowFocusChangedListener> mWindowFocusChangedListeners = new ArrayList(0);
    private final List<PluginRegistry.ViewDestroyListener> mViewDestroyListeners = new ArrayList(0);
    private final PlatformViewsController mPlatformViewsController = new PlatformViewsController();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class FlutterRegistrar implements PluginRegistry.Registrar {
        private final String pluginKey;

        public FlutterRegistrar(String str) {
            this.pluginKey = str;
        }

        @Override // io.flutter.plugin.common.PluginRegistry.Registrar
        public Context activeContext() {
            return FlutterPluginRegistry.this.mActivity != null ? FlutterPluginRegistry.this.mActivity : FlutterPluginRegistry.this.mAppContext;
        }

        @Override // io.flutter.plugin.common.PluginRegistry.Registrar
        public Activity activity() {
            return FlutterPluginRegistry.this.mActivity;
        }

        @Override // io.flutter.plugin.common.PluginRegistry.Registrar
        public PluginRegistry.Registrar addActivityResultListener(PluginRegistry.ActivityResultListener activityResultListener) {
            FlutterPluginRegistry.this.mActivityResultListeners.add(activityResultListener);
            return this;
        }

        @Override // io.flutter.plugin.common.PluginRegistry.Registrar
        public PluginRegistry.Registrar addNewIntentListener(PluginRegistry.NewIntentListener newIntentListener) {
            FlutterPluginRegistry.this.mNewIntentListeners.add(newIntentListener);
            return this;
        }

        @Override // io.flutter.plugin.common.PluginRegistry.Registrar
        public PluginRegistry.Registrar addRequestPermissionsResultListener(PluginRegistry.RequestPermissionsResultListener requestPermissionsResultListener) {
            FlutterPluginRegistry.this.mRequestPermissionsResultListeners.add(requestPermissionsResultListener);
            return this;
        }

        @Override // io.flutter.plugin.common.PluginRegistry.Registrar
        public PluginRegistry.Registrar addUserLeaveHintListener(PluginRegistry.UserLeaveHintListener userLeaveHintListener) {
            FlutterPluginRegistry.this.mUserLeaveHintListeners.add(userLeaveHintListener);
            return this;
        }

        @Override // io.flutter.plugin.common.PluginRegistry.Registrar
        public PluginRegistry.Registrar addViewDestroyListener(PluginRegistry.ViewDestroyListener viewDestroyListener) {
            FlutterPluginRegistry.this.mViewDestroyListeners.add(viewDestroyListener);
            return this;
        }

        @Override // io.flutter.plugin.common.PluginRegistry.Registrar
        public PluginRegistry.Registrar addWindowFocusChangedListener(PluginRegistry.WindowFocusChangedListener windowFocusChangedListener) {
            FlutterPluginRegistry.this.mWindowFocusChangedListeners.add(windowFocusChangedListener);
            return this;
        }

        @Override // io.flutter.plugin.common.PluginRegistry.Registrar
        public Context context() {
            return FlutterPluginRegistry.this.mAppContext;
        }

        @Override // io.flutter.plugin.common.PluginRegistry.Registrar
        public String lookupKeyForAsset(String str) {
            return FlutterMain.getLookupKeyForAsset(str);
        }

        @Override // io.flutter.plugin.common.PluginRegistry.Registrar
        public BinaryMessenger messenger() {
            return FlutterPluginRegistry.this.mNativeView;
        }

        @Override // io.flutter.plugin.common.PluginRegistry.Registrar
        public PlatformViewRegistry platformViewRegistry() {
            return FlutterPluginRegistry.this.mPlatformViewsController.getRegistry();
        }

        @Override // io.flutter.plugin.common.PluginRegistry.Registrar
        public PluginRegistry.Registrar publish(Object obj) {
            FlutterPluginRegistry.this.mPluginMap.put(this.pluginKey, obj);
            return this;
        }

        @Override // io.flutter.plugin.common.PluginRegistry.Registrar
        public TextureRegistry textures() {
            return FlutterPluginRegistry.this.mFlutterView;
        }

        @Override // io.flutter.plugin.common.PluginRegistry.Registrar
        public FlutterView view() {
            return FlutterPluginRegistry.this.mFlutterView;
        }

        @Override // io.flutter.plugin.common.PluginRegistry.Registrar
        public String lookupKeyForAsset(String str, String str2) {
            return FlutterMain.getLookupKeyForAsset(str, str2);
        }
    }

    public FlutterPluginRegistry(FlutterNativeView flutterNativeView, Context context) {
        this.mNativeView = flutterNativeView;
        this.mAppContext = context;
    }

    public void attach(FlutterView flutterView, Activity activity) {
        this.mFlutterView = flutterView;
        this.mActivity = activity;
        this.mPlatformViewsController.attach(activity, flutterView, flutterView.getDartExecutor());
    }

    public void destroy() {
        this.mPlatformViewsController.onDetachedFromJNI();
    }

    public void detach() {
        this.mPlatformViewsController.detach();
        this.mPlatformViewsController.onDetachedFromJNI();
        this.mFlutterView = null;
        this.mActivity = null;
    }

    public PlatformViewsController getPlatformViewsController() {
        return this.mPlatformViewsController;
    }

    @Override // io.flutter.plugin.common.PluginRegistry
    public boolean hasPlugin(String str) {
        return this.mPluginMap.containsKey(str);
    }

    @Override // io.flutter.plugin.common.PluginRegistry.ActivityResultListener
    public boolean onActivityResult(int i10, int i11, Intent intent) {
        Iterator<PluginRegistry.ActivityResultListener> iterator2 = this.mActivityResultListeners.iterator2();
        while (iterator2.hasNext()) {
            if (iterator2.next().onActivityResult(i10, i11, intent)) {
                return true;
            }
        }
        return false;
    }

    @Override // io.flutter.plugin.common.PluginRegistry.NewIntentListener
    public boolean onNewIntent(Intent intent) {
        Iterator<PluginRegistry.NewIntentListener> iterator2 = this.mNewIntentListeners.iterator2();
        while (iterator2.hasNext()) {
            if (iterator2.next().onNewIntent(intent)) {
                return true;
            }
        }
        return false;
    }

    public void onPreEngineRestart() {
        this.mPlatformViewsController.onPreEngineRestart();
    }

    @Override // io.flutter.plugin.common.PluginRegistry.RequestPermissionsResultListener
    public boolean onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        Iterator<PluginRegistry.RequestPermissionsResultListener> iterator2 = this.mRequestPermissionsResultListeners.iterator2();
        while (iterator2.hasNext()) {
            if (iterator2.next().onRequestPermissionsResult(i10, strArr, iArr)) {
                return true;
            }
        }
        return false;
    }

    @Override // io.flutter.plugin.common.PluginRegistry.UserLeaveHintListener
    public void onUserLeaveHint() {
        Iterator<PluginRegistry.UserLeaveHintListener> iterator2 = this.mUserLeaveHintListeners.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().onUserLeaveHint();
        }
    }

    @Override // io.flutter.plugin.common.PluginRegistry.ViewDestroyListener
    public boolean onViewDestroy(FlutterNativeView flutterNativeView) {
        Iterator<PluginRegistry.ViewDestroyListener> iterator2 = this.mViewDestroyListeners.iterator2();
        boolean z10 = false;
        while (iterator2.hasNext()) {
            if (iterator2.next().onViewDestroy(flutterNativeView)) {
                z10 = true;
            }
        }
        return z10;
    }

    @Override // io.flutter.plugin.common.PluginRegistry.WindowFocusChangedListener
    public void onWindowFocusChanged(boolean z10) {
        Iterator<PluginRegistry.WindowFocusChangedListener> iterator2 = this.mWindowFocusChangedListeners.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().onWindowFocusChanged(z10);
        }
    }

    @Override // io.flutter.plugin.common.PluginRegistry
    public PluginRegistry.Registrar registrarFor(String str) {
        if (!this.mPluginMap.containsKey(str)) {
            this.mPluginMap.put(str, null);
            return new FlutterRegistrar(str);
        }
        throw new IllegalStateException("Plugin key " + str + " is already in use");
    }

    @Override // io.flutter.plugin.common.PluginRegistry
    public <T> T valuePublishedByPlugin(String str) {
        return (T) this.mPluginMap.get(str);
    }

    public FlutterPluginRegistry(FlutterEngine flutterEngine, Context context) {
        this.mAppContext = context;
    }
}
