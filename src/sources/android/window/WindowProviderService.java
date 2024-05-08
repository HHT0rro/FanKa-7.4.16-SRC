package android.window;

import android.app.ActivityThread;
import android.app.LoadedApk;
import android.app.Service;
import android.content.ComponentCallbacks;
import android.content.ComponentCallbacksController;
import android.content.Context;
import android.content.res.Configuration;
import android.hardware.display.DisplayManager;
import android.os.Bundle;
import android.os.IBinder;
import android.view.Display;
import android.view.WindowManager;
import android.view.WindowManagerImpl;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public abstract class WindowProviderService extends Service implements WindowProvider {
    private final ComponentCallbacksController mCallbacksController;
    private final WindowContextController mController;
    private boolean mInitialized;
    private final Bundle mOptions;
    private WindowManager mWindowManager;
    private final WindowTokenClient mWindowToken;

    @Override // android.window.WindowProvider
    public abstract int getWindowType();

    public static boolean isWindowProviderService(Bundle windowContextOptions) {
        if (windowContextOptions == null) {
            return false;
        }
        return windowContextOptions.getBoolean(WindowProvider.KEY_IS_WINDOW_PROVIDER_SERVICE, false);
    }

    public WindowProviderService() {
        WindowTokenClient windowTokenClient = new WindowTokenClient();
        this.mWindowToken = windowTokenClient;
        this.mController = new WindowContextController(windowTokenClient);
        this.mCallbacksController = new ComponentCallbacksController();
        Bundle bundle = new Bundle();
        this.mOptions = bundle;
        bundle.putBoolean(WindowProvider.KEY_IS_WINDOW_PROVIDER_SERVICE, true);
    }

    @Override // android.window.WindowProvider
    public Bundle getWindowContextOptions() {
        return this.mOptions;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void registerComponentCallbacks(ComponentCallbacks callback) {
        this.mCallbacksController.registerCallbacks(callback);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void unregisterComponentCallbacks(ComponentCallbacks callback) {
        this.mCallbacksController.unregisterCallbacks(callback);
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        this.mCallbacksController.dispatchConfigurationChanged(configuration);
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onLowMemory() {
        this.mCallbacksController.dispatchLowMemory();
    }

    @Override // android.app.Service, android.content.ComponentCallbacks2
    public void onTrimMemory(int level) {
        this.mCallbacksController.dispatchTrimMemory(level);
    }

    public int getInitialDisplayId() {
        return 0;
    }

    public final void attachToWindowToken(IBinder windowToken) {
        this.mController.attachToWindowToken(windowToken);
    }

    public final Context createServiceBaseContext(ActivityThread mainThread, LoadedApk packageInfo) {
        Context createServiceBaseContext = super.createServiceBaseContext(mainThread, packageInfo);
        Display display = ((DisplayManager) createServiceBaseContext.getSystemService(DisplayManager.class)).getDisplay(getInitialDisplayId());
        return createServiceBaseContext.createTokenContext(this.mWindowToken, display);
    }

    @Override // android.app.Service, android.content.ContextWrapper
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(newBase);
        if (!this.mInitialized) {
            this.mWindowToken.attachContext(this);
            this.mController.attachToDisplayArea(getWindowType(), getDisplayId(), getWindowContextOptions());
            this.mWindowManager = WindowManagerImpl.createWindowContextWindowManager(this);
            this.mInitialized = true;
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String name) {
        if ("window".equals(name)) {
            return this.mWindowManager;
        }
        return super.getSystemService(name);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.mController.detachIfNeeded();
        this.mCallbacksController.clearCallbacks();
    }
}
