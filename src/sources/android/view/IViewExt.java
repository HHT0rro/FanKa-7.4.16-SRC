package android.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.Animation;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface IViewExt {
    public static final int DRAG_FLAG_CUSTOM_CANCEL_ANIMATION = 1073741824;
    public static final int DRAG_FLAG_CUSTOM_RETURN_ANIMATION = Integer.MIN_VALUE;
    public static final int LOG_LEVEL_DEBUG = 1;
    public static final int LOG_LEVEL_VERBOSE = 2;
    public static final int LOG_LEVEL_VERBOSE_ACTION = 21;
    public static final int TYPE_FORCE_DARK_ALGORITHM_GOOGLE = 2;
    public static final int TYPE_FORCE_DARK_ALGORITHM_OPLUS = 1;

    default void hookPerformClick() {
    }

    default void hookAssignParent(ViewParent parent) {
    }

    default void hookStartDraw(View view, Canvas canvas) {
    }

    default void hookAfterDispatchDraw(View view, Canvas canvas) {
    }

    default void hookAfterDrawCanvas(View view, Canvas canvas) {
    }

    default void hookDrawBackground(View view, Canvas canvas) {
    }

    default void getDrawableRenderNode(View view, Canvas canvas) {
    }

    default void hookSizeChange(View view) {
    }

    default void hookRequestLayout() {
    }

    default void hookOverScrollBy(int scrollX, int scrollY, int scrollRangeX, int scrollRangeY) {
    }

    default boolean hookDispatchNestedScroll() {
        return true;
    }

    default boolean isOplusOSStyle() {
        return false;
    }

    default boolean isOplusStyle() {
        return false;
    }

    default Bitmap getColorCustomDrawingCache(Rect clip, int viewTop) {
        return null;
    }

    default int getOriginWebSettingForceDark() {
        return -1;
    }

    default SurfaceControl getViewRootSurfaceControl() {
        return null;
    }

    default void setOriginWebSettingForceDark(int forceDark) {
    }

    default void setUsageForceDarkAlgorithmType(int type) {
    }

    default void setCrudeState(int state) {
    }

    default int getCrudeState() {
        return 0;
    }

    default int getOplusViewType() {
        return 0;
    }

    default void setOplusViewTypeLocked(int viewType) {
    }

    default void hookTextView(Layout mlayout) {
    }

    default float getTextViewDefaultLineMulti(Object textview, float pxSize, float oriValue) {
        return oriValue;
    }

    default float getTextViewParaSpacing(Object textview) {
        return 0.0f;
    }

    default void setLayout(Layout layout) {
    }

    default void setScrollXForColor(int x10) {
    }

    default void setScrollYForColor(int y10) {
    }

    default boolean debugWebViewDraw() {
        return false;
    }

    default void onTouchEvent(MotionEvent event) {
    }

    default IViewRootImplExt getViewRootImpl() {
        return null;
    }

    default boolean initialAwakenScrollBars() {
        return false;
    }

    default boolean hookIsTouchPressed() {
        return false;
    }

    default void setContentDescriptionForField(AccessibilityNodeInfo info) {
    }

    default void logEvent(int level, String tag, InputEvent event, String info) {
    }

    default View getView() {
        return null;
    }

    default void initViewHooks(Resources resources) {
    }

    default void initView() {
    }

    default void checkBoostAnimation(Animation animation) {
    }

    default void checkBoostBuildDrawingCache() {
    }

    default void checkBoostTouchEvent(int action) {
    }

    default void checkBoostOnPerformClick(View.OnClickListener onClickListener) {
    }

    default void checkNeedBoostedPropertyAnimator(ViewPropertyAnimator animator) {
    }

    default void ignoreSpecailViewDescendantInvalidated(ViewParent p10) {
    }

    default boolean isIgnoreSpecailViewDescendantInvalidated() {
        return false;
    }

    default void adjustImageViewLayerType(int width, int height) {
    }

    default boolean checkMutiTouchView() {
        return false;
    }

    default boolean disableOnClick(View view, InputEvent event) {
        return false;
    }

    default boolean isClickDisabled() {
        return false;
    }

    default void setOplusResampleTouch(boolean enabled) {
    }

    default boolean shouldFilterByMultiSearch(Resources resources) {
        return false;
    }

    default boolean drawWithMirrorModeIfNeeded(Canvas canvas) {
        return false;
    }

    default void dispatchAttachedToWindow() {
    }

    default void dispatchDetachedFromWindow() {
    }

    default void beforeUpdateDisplayListIfDirty(View view) {
    }

    default void beforeDraw(View view, Canvas canvas) {
    }

    default void afterDraw(View view, Canvas canvas) {
    }

    default int[] beforeMeasure(View view, int widthMeasureSpec, int heightMeasureSpec) {
        return new int[]{widthMeasureSpec, heightMeasureSpec};
    }

    default int[] hookSetMeasureDimension(View view, int measuredWidth, int measuredHeight) {
        return new int[]{measuredWidth, measuredHeight};
    }

    default void afterMeasure(View view) {
    }

    default int[] beforeLayout(View view, int l10, int t2, int r10, int b4) {
        return new int[]{l10, t2, r10, b4};
    }

    default void afterLayout(View view) {
    }

    default Object getViewInfo() {
        return null;
    }

    default String getViewInfoStr() {
        return "";
    }

    default ViewGroup.LayoutParams hookSetLayoutParams(ViewGroup.LayoutParams params) {
        return params;
    }

    default void onEventHandled(Object vri, MotionEvent ev) {
    }

    default void onScrollBarFadeStart(int duration) {
    }

    default void onScrollBarFadeEnd() {
    }

    default void onScrollChangedHook(int l10, int t2, int oldl, int oldt) {
    }

    default void markOnRequestLayout() {
    }

    default void markOnInvalidate() {
    }

    default void markOnFocusChange(boolean gainFocus, boolean hasWindowFocus, View view) {
    }

    default boolean isInMirageDisplayMode(View.AttachInfo attachInfo) {
        return false;
    }

    default void extractViewInfo(View view, Bundle bundle) {
    }

    default void initViewExtract(View view) {
    }

    default void appendViewExtractInfo(View view, ViewStructure info) {
    }

    default boolean isViewExtract(int flag) {
        return false;
    }

    default int addViewExtractFlag(int flag, int viewFlags) {
        return viewFlags;
    }

    default void setKeepMeasureSpec(boolean keep) {
    }

    default boolean shouldKeepMeasureSpec() {
        return false;
    }

    default void modifyOutShadowMetricsIfNeeded(Context context, Point outShadowMetrics, Point shadowSize) {
    }

    default void setRealClassName(CharSequence className, AccessibilityNodeInfo nodeInfo) {
    }

    default CharSequence getRealClassName(AccessibilityNodeInfo nodeInfo) {
        return null;
    }
}
