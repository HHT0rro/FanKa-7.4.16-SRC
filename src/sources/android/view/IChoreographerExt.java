package android.view;

import android.view.Choreographer;
import android.view.DisplayEventReceiver;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface IChoreographerExt {
    default void recordSkippedFrames(long skippedFrames, boolean animation, boolean traversal, long startNanos, long jitterNanos) {
    }

    default void traceBeginForSkippedFrames() {
    }

    default void traceEndForSkippedFrames() {
    }

    default void dumpAnimationDropInfo(long startNanos) {
    }

    default void setIsSFChoregrapher(boolean isSFChoregrapher) {
    }

    default void doFrameStartHook(long frameStartNanos) {
    }

    default void doFrameHook() {
    }

    default boolean isInsertingFrame() {
        return false;
    }

    default void adjustFrameTimeNanos(long frameTimeNanos, long lastFrameTimeNanos, long startNanos) {
    }

    default boolean isTimeBackward() {
        return false;
    }

    default boolean isScrollOptEnabled() {
        return false;
    }

    default void setVsync(long frameTimeNanos, long jitterNanos, long intendedFrameTimeNanos, long startNanos, DisplayEventReceiver.VsyncEventData vsyncEventData) {
    }

    default void traceBeginForOptimizeSlidingEffect() {
    }

    default void traceEndForOptimizeSlidingEffect() {
    }

    default void onDoFrameFinished() {
    }

    default void updateFrameIntervalNanos(long frameIntervalNanos) {
    }

    default long getAnimationFrameTimeNanos(Choreographer.FrameData frameData) {
        return 0L;
    }

    default void afterDoCallBacks(Choreographer.FrameData frameData) {
    }

    default void doFrameInsert(long intendedFrameTimeNanos, int msg) {
    }

    default void doAnimAheadCallback(Choreographer.FrameData frameData) {
    }

    default void onChoreographerInit() {
    }

    default boolean checkJankTrackerEnable() {
        return false;
    }

    default void handleInputEvent(InputEvent event, int maximumVelocity, int minimumVelocity) {
    }

    default void populateAndResetFrameInfo(long[] frameInfoList, boolean appVisible) {
    }

    default void populateMeasureCost(long cost, View view, String reason) {
    }

    default void populateLayoutCost(long cost, View view) {
    }

    default void markDrawingCacheFlag() {
    }

    default void markRelayout() {
    }

    default void resetFrameCount() {
    }

    default void markDrawStart() {
    }

    default void syncViewCount(int viewCount) {
    }

    default void setLifecycleState(int state, boolean haveOnCreate, long activityLaunchTime, long activityResumeTime, long activityPauseTime) {
    }

    default void makePauseActivityEnd() {
    }

    default void markPerformClickFlag() {
    }

    default void showSoftInput(boolean fromIme) {
    }

    default void hideSoftInput(boolean fromIme) {
    }

    default void showInsetAnim(int types, boolean fromIme) {
    }

    default void onAnimationStart(boolean needsEarlyWakeup, long duration) {
    }

    default void onAnimationEnd(boolean needsEarlyWakeup) {
    }

    default void setScheduleVsync() {
    }

    default boolean hasPendingFramerateChange() {
        return false;
    }

    default void handlePendingFramerateChange(long startNanos) {
    }

    default String markOnVsync(DisplayEventReceiver.VsyncEventData vsyncEventData, long timestampNanos, long lastFrameTimeNanos) {
        return "";
    }

    default String markOnDoframe(DisplayEventReceiver.VsyncEventData vsyncEventData, long timestampNanos, long lastFrameTimeNanos) {
        return "";
    }

    default void setAnimating(boolean animating) {
    }

    default void dispatchVsyncData(long timestampNanos, DisplayEventReceiver.VsyncEventData vsyncEventData) {
    }

    default void addOplusVsyncCallback(Object callback) {
    }

    default void removeOplusVsyncCallback(Object callback) {
    }
}
