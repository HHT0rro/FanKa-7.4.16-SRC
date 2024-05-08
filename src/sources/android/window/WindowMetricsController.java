package android.window;

import android.app.ResourcesManager;
import android.app.WindowConfiguration;
import android.content.Context;
import android.content.res.CompatibilityInfo;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.DisplayInfo;
import android.view.InsetsState;
import android.view.WindowInsets;
import android.view.WindowManagerGlobal;
import android.view.WindowMetrics;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public final class WindowMetricsController {
    private final Context mContext;

    public WindowMetricsController(Context context) {
        this.mContext = context;
    }

    public WindowMetrics getCurrentWindowMetrics() {
        return getWindowMetricsInternal(false);
    }

    public WindowMetrics getMaximumWindowMetrics() {
        return getWindowMetricsInternal(true);
    }

    private WindowMetrics getWindowMetricsInternal(boolean isMaximum) {
        Rect bounds;
        float density;
        final boolean isScreenRound;
        final int windowingMode;
        synchronized (ResourcesManager.getInstance()) {
            Configuration config = this.mContext.getResources().getConfiguration();
            WindowConfiguration winConfig = config.windowConfiguration;
            bounds = isMaximum ? winConfig.getMaxBounds() : winConfig.getBounds();
            density = config.densityDpi * 0.00625f;
            isScreenRound = config.isScreenRound();
            windowingMode = winConfig.getWindowingMode();
        }
        final IBinder token = Context.getToken(this.mContext);
        final Rect rect = bounds;
        Supplier<WindowInsets> insetsSupplier = new Supplier() { // from class: android.window.WindowMetricsController$$ExternalSyntheticLambda0
            @Override // java.util.function.Supplier
            public final Object get() {
                WindowInsets lambda$getWindowMetricsInternal$0;
                lambda$getWindowMetricsInternal$0 = WindowMetricsController.this.lambda$getWindowMetricsInternal$0(token, rect, isScreenRound, windowingMode);
                return lambda$getWindowMetricsInternal$0;
            }
        };
        return new WindowMetrics(new Rect(bounds), insetsSupplier, density);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ WindowInsets lambda$getWindowMetricsInternal$0(IBinder token, Rect bounds, boolean isScreenRound, int windowingMode) {
        return getWindowInsetsFromServerForDisplay(this.mContext.getDisplayId(), token, bounds, isScreenRound, windowingMode);
    }

    private static WindowInsets getWindowInsetsFromServerForDisplay(int displayId, IBinder token, Rect bounds, boolean isScreenRound, int windowingMode) {
        InsetsState insetsState;
        try {
            insetsState = new InsetsState();
        } catch (RemoteException e2) {
            e = e2;
        }
        try {
            boolean alwaysConsumeSystemBars = WindowManagerGlobal.getWindowManagerService().getWindowInsets(displayId, token, insetsState);
            float overrideInvScale = CompatibilityInfo.getOverrideInvertedScale();
            if (overrideInvScale != 1.0f) {
                insetsState.scale(overrideInvScale);
            }
            return insetsState.calculateInsets(bounds, null, isScreenRound, alwaysConsumeSystemBars, 48, 0, 0, -1, windowingMode, null);
        } catch (RemoteException e10) {
            e = e10;
            throw e.rethrowFromSystemServer();
        }
    }

    public Set<WindowMetrics> getPossibleMaximumWindowMetrics(int displayId) {
        try {
            List<DisplayInfo> possibleDisplayInfos = WindowManagerGlobal.getWindowManagerService().getPossibleDisplayInfo(displayId);
            Set<WindowMetrics> maxMetrics = new HashSet<>();
            for (int i10 = 0; i10 < possibleDisplayInfos.size(); i10++) {
                DisplayInfo currentDisplayInfo = possibleDisplayInfos.get(i10);
                Rect maxBounds = new Rect(0, 0, currentDisplayInfo.logicalWidth, currentDisplayInfo.logicalHeight);
                boolean isScreenRound = (currentDisplayInfo.flags & 16) != 0;
                WindowInsets windowInsets = getWindowInsetsFromServerForDisplay(currentDisplayInfo.displayId, null, new Rect(0, 0, currentDisplayInfo.getNaturalWidth(), currentDisplayInfo.getNaturalHeight()), isScreenRound, 1);
                float density = currentDisplayInfo.logicalDensityDpi * 0.00625f;
                maxMetrics.add(new WindowMetrics(maxBounds, new WindowInsets.Builder(windowInsets).setRoundedCorners(currentDisplayInfo.roundedCorners).setDisplayCutout(currentDisplayInfo.displayCutout).build(), density));
            }
            return maxMetrics;
        } catch (RemoteException e2) {
            throw e2.rethrowFromSystemServer();
        }
    }
}
