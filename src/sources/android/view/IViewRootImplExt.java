package android.view;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.BLASTBufferQueue;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.MergedConfiguration;
import android.util.TypedValue;
import android.view.SurfaceControl;
import android.view.ViewRootImpl;
import android.view.WindowManager;
import java.io.PrintWriter;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface IViewRootImplExt {
    default void init(ViewRootImpl viewRootImpl, Context context) {
    }

    default void hookNewInstance(Context context) {
    }

    default void logConfigurationNightError(Context context, boolean useAutoDark) {
    }

    default void logForceDarkAllowedStatus(Context context, boolean forceDarkAllowedDefault) {
    }

    default void forceDarkWithoutTheme(Context context, View view, boolean useAutoDark) {
    }

    default int changeSystemUiVisibility(int mSystemUiVisibility) {
        return 0;
    }

    default void setDarkModeProgress(View view, Configuration globalConfig) {
    }

    default void refreshForceDark(View view, Parcelable mOplusDarkModeData) {
    }

    default void updateLogLevel() {
    }

    default boolean isLevelDebug() {
        return false;
    }

    default void debugInputStageDeliverd(String mTag, int flag, InputEvent event, String stage, String detail) {
    }

    default void v(String tag, String msg) {
    }

    default void debugEventHandled(String tag, InputEvent event, String detail) {
    }

    default void debugInputEventEnqueue(String tag, InputEvent event, boolean immediately, boolean scheduled) {
    }

    default void debugInputEventFinished(String tag, int flag, InputEvent event) {
    }

    default void debugInputEventStart(String tag, InputEvent event) {
    }

    default void setRefreshRateIfNeed(boolean ifNeed, Context context, View view, ViewRootImpl.W window) {
    }

    default void dispatchDetachedFromWindow(View view) {
    }

    default void hookSetView(View view, Context context) {
    }

    default ViewRootImpl.W createWindowClient() {
        return null;
    }

    default void hookViewRootImplHooks(Context context) {
    }

    default void setConnected(boolean isConnected) {
    }

    default boolean isConnected() {
        return false;
    }

    default void initSystemUINavigationGesture(ViewRootImpl viewRootImpl, Context context) {
    }

    default void checkKeyguardAndConfig(String tag) {
    }

    default void handleGestureMotionDown(View view) {
    }

    default void handleGestureConfigCheck() {
    }

    default void setSystemGestureExclusionRegion(List<Rect> rects) {
    }

    default boolean processGestureEvent(MotionEvent event) {
        return false;
    }

    default boolean showSurfaceViewBackground(int subLayer) {
        return false;
    }

    default void setLastReportedMergedConfiguration(View mView, Configuration newConfig, Context context) {
    }

    default void onWindowFocusChangedByRoot(boolean hasWindowFocus, View view, MergedConfiguration configuration) {
    }

    default void updateInputEventForBracketModeIfNeeded(View view, InputEvent event, InputEventReceiver receiver) {
    }

    default void updateInputEventToInputMethod(InputEvent event) {
    }

    default void checkIsFragmentAnimUI() {
    }

    default boolean isFragmentAnimUI() {
        return false;
    }

    default void showSoftInput(String pkg) {
    }

    default void hideSoftInputFromWindow(String pkg) {
    }

    default boolean checkTraversalsImmediatelyProssible(boolean isFirst) {
        return false;
    }

    default boolean checkTraversalsImmediatelyProssibleInTraversals(boolean isFirst, boolean mIsInTraversal) {
        return false;
    }

    default boolean disableRelayout() {
        return false;
    }

    default void enableClickIfNeededWhenInputEventFinish(InputEvent event) {
    }

    default void disableClickIfNeededWhenInputEventStart(InputEvent event) {
    }

    default boolean isClickDisabled() {
        return false;
    }

    default float getWindowGlobalScale() {
        return 1.0f;
    }

    default IRemoteTaskWindowInsetHelperExt getRTWindowInsetHelper() {
        return null;
    }

    default int getColorMode(int colorMode) {
        return colorMode;
    }

    default String getOsieLayerName(String tag, String title) {
        return tag;
    }

    default boolean setTransparentRegionForZoom(MergedConfiguration configuration, SurfaceControl sc2, SurfaceControl.Transaction transaction) {
        return false;
    }

    default int getBaseSize(WindowManager.LayoutParams lp, TypedValue value, Resources res) {
        return (int) value.getDimension(res.getDisplayMetrics());
    }

    default void debugCancelDraw(String tag, boolean cancelDraw, boolean isViewVisible) {
    }

    default void dump(String prefix, PrintWriter writer) {
    }

    default void hookCreateSyncIfNeeded(String tag, boolean syncBuffer, int seqId) {
    }

    default void hookReportDrawFinished(String tag, int seqId) {
    }

    default boolean cancelAndRedraw(String tag, boolean cancelAndRedraw, boolean isViewVisible, boolean syncBuffer) {
        return cancelAndRedraw;
    }

    default void setPendingBufferCountSetting(boolean pendingBufferCountSetting) {
    }

    default void checkPendingBufferCountSetting(Surface surface) {
    }

    default boolean shouldSkipScheduleTraversals(Object vri) {
        return false;
    }

    default void onUpdateInternalDisplay(Display display) {
    }

    default void registerRemoteAnimationsForWindow(RemoteAnimationDefinition definition) {
    }

    default void unregisterRemoteAnimationsForWindow() {
    }

    default void setLaunchViewInfoForWindow(Object launchViewInfo) {
    }

    default void clearLaunchViewInfoForWindow() {
    }

    default void attachToWindow() {
    }

    default boolean shouldDrawOnMirrorContent(View view) {
        return false;
    }

    default void removeMirrorSurfaceControl(IBinder mirrorToken) {
    }

    default void addMirrorSurfaceControl(IBinder mirrorToken, SurfaceControl mirrorRootLeash) {
    }

    default void notifySurfaceViewReplaced() {
    }

    default void drawViewRoot() {
    }

    default void setFrame(int width, int height) {
    }

    default void doDie() {
    }

    default void notifySurfaceDestroyed() {
    }

    default void updateBlastSurfaceIfNeeded(BLASTBufferQueue mBlastBufferQueue) {
    }

    default void updateSurfaceViewRelativeZIfNeed(SurfaceView surfaceView, SurfaceControl.Transaction t2) {
    }

    default Rect adjustSurfaceViewFrameIfNeed(SurfaceView view, Rect inRect) {
        return inRect;
    }

    default void hookDispatchDispatchSystemUiVisibilityChanged() {
    }

    default void setScrollToTopRootView(View view, WindowManager.LayoutParams params) {
    }

    default void setScrollToTopWinFrame(Rect winFrame) {
    }

    default void handleWindowFocusChanged(Context context, boolean hasFocus) {
    }

    default void postShowGuidePopupRunnable(View decorView) {
    }

    default void processPointerEvent(MotionEvent e2, Context context, boolean handled) {
    }

    default void onWindowDying() {
    }

    default boolean needUpdateInternalDisplay(Context context, Display display) {
        return false;
    }

    default void intersectOverrideWindowBoundsIfNeed(MergedConfiguration mergedConfiguration, Rect outRect) {
    }

    default boolean updateAlwaysConsumeSystemBarsIfNeeded(boolean pendingAlwaysConsumeSystemBars) {
        return false;
    }

    default boolean shouldBlockResizeReportForSplashScreen(WindowManager.LayoutParams windowAttrs, String packageName) {
        return false;
    }

    default int wrapConfigInfoIntoFlags(int flags, int smallestScreenWidthDp, int rotation, boolean relayoutAsync) {
        return flags;
    }

    default boolean isZoomWindowMode(int windowMode) {
        return false;
    }

    default boolean changeActivityPreloadDisplay(int displayId, String displayName) {
        return false;
    }

    default void updateSplitScreenImmersiveFlag(Bundle bundle) {
    }

    default WindowInsets adjustWindowInsetsForDispatchIfNeed(WindowInsets windowInsets) {
        return windowInsets;
    }

    default void markBeforeDispatchTouchEvent(MotionEvent event, String title) {
    }

    default void markAfterDispatchTouchEvent(MotionEvent event) {
    }

    default void markAndDumpWindowFocusChangeMsg(String tag, Handler handler) {
    }

    default String markPerformLayout(View hostView, WindowManager.LayoutParams windowAttrs) {
        return "";
    }

    default String markPerformMeasure(View hostView, WindowManager.LayoutParams windowAttrs, int childWidthMeasureSpec, int childHeightMeasureSpec) {
        return "";
    }

    default String markPerformDraw(View hostView, WindowManager.LayoutParams windowAttrs) {
        return "";
    }

    default String markScheduleTraversals(View hostView, WindowManager.LayoutParams windowAttrs) {
        return "";
    }

    default void markOnHandleMessageImpl(String msgName) {
    }

    default void markPerformMeasureReason(String reason) {
    }

    default void markPerformLayoutReason(String reason) {
    }

    default void markOnSetFrame(Rect frame, WindowManager.LayoutParams windowAttrs) {
    }

    default void markHandleAppVisibility(boolean visible, WindowManager.LayoutParams windowAttrs) {
    }

    default void markShowInsets(int insetsType, boolean fromIme) {
    }

    default void markHideInsets(int insetsType, boolean fromIme) {
    }

    default void markOnPerformTraversalsStart(View hostView, boolean first) {
    }

    default void markOnPerformTraversalsEnd(View hostView) {
    }

    default void markHandleWindowFocusChange(boolean windowFocusChanged, boolean upcomingWindowFocus, boolean added, WindowManager.LayoutParams windowAttributes) {
    }

    default boolean isInterceptedProcessPointerEvent(String tag, MotionEvent event, Context mContext) {
        return false;
    }

    default void updateTaskBarInset(View view, WindowInsets insets, InsetsState insetsState) {
    }

    default void updateRecordSurfaceViewState(boolean hasSurfaceView) {
    }

    default boolean isSupportLocalLayout(int displayId) {
        return true;
    }

    default void onDisplayChanged(int displayId) {
    }

    default boolean isMirageDisplayAdded() {
        return false;
    }

    default void hookSetBinderUxFlag(boolean applyToUx, WindowManager.LayoutParams windowAttributes) {
    }
}
