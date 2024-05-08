package android.widget;

import android.content.Context;
import android.view.animation.Interpolator;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface IOplusOverScrollerExt {
    default void setFriction(float friction) {
    }

    default boolean isFinished() {
        return false;
    }

    default int getCurrX() {
        return -1;
    }

    default int getCurrY() {
        return -1;
    }

    default int getFinalX() {
        return -1;
    }

    default int getFinalY() {
        return -1;
    }

    default boolean getOptHelperEnable() {
        return false;
    }

    default boolean interpolatorValid() {
        return false;
    }

    default boolean setSpringOverScrollerInterpolator(Interpolator interpolator) {
        return false;
    }

    default void forceFinished(boolean finished) {
    }

    default float getCurrVelocity() {
        return -1.0f;
    }

    default int getStartX() {
        return -1;
    }

    default int getStartY() {
        return -1;
    }

    default int getDuration() {
        return -1;
    }

    default void extendDuration(int extend) {
    }

    default int timePassed() {
        return -1;
    }

    default void setFinalX(int x10) {
    }

    default void setFinalY(int y10) {
    }

    default boolean computeScrollOffset() {
        return false;
    }

    default void startScroll(int startX, int startY, int dx, int dy) {
    }

    default void startScroll(int startX, int startY, int dx, int dy, int duration) {
    }

    default boolean springBack(int startX, int startY, int minX, int maxX, int minY, int maxY) {
        return false;
    }

    default void fling(int startX, int startY, int velocityX, int velocityY, int minX, int maxX, int minY, int maxY) {
    }

    default void fling(int startX, int startY, int velocityX, int velocityY, int minX, int maxX, int minY, int maxY, int overX, int overY) {
    }

    default void notifyHorizontalEdgeReached(int startX, int finalX, int overX) {
    }

    default void notifyVerticalEdgeReached(int startY, int finalY, int overY) {
    }

    default boolean isOverScrolled() {
        return false;
    }

    default void abortAnimation() {
    }

    default boolean isScrollingInDirection(float xvel, float yvel) {
        return false;
    }

    default void setSpringOverScroller(Object scroller) {
    }

    default void setForceUsingSpring(boolean forceUsingSpring) {
    }

    default boolean hookOverScroller(Context context, Interpolator interpolator) {
        return false;
    }

    default Interpolator getInterpolator(Interpolator interpolator) {
        return interpolator;
    }

    default void setInterpolator(Interpolator interpolator) {
    }

    default boolean getForceUsingSpring() {
        return false;
    }

    default boolean hookCheckFlingFlag() {
        return false;
    }

    default boolean hookAbortAnimation(ISplineOverScrollerExt mSplineOverScrollerExtX, ISplineOverScrollerExt mSplineOverScrollerExtY) {
        return false;
    }
}
