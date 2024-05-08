package android.view;

import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Region;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.accessibility.AccessibilityEvent;
import android.window.OnBackInvokedDispatcher;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface ViewParent {
    void bringChildToFront(View view);

    boolean canResolveLayoutDirection();

    boolean canResolveTextAlignment();

    boolean canResolveTextDirection();

    void childDrawableStateChanged(View view);

    void childHasTransientStateChanged(View view, boolean z10);

    void clearChildFocus(View view);

    void createContextMenu(ContextMenu contextMenu);

    View focusSearch(View view, int i10);

    void focusableViewAvailable(View view);

    boolean getChildVisibleRect(View view, Rect rect, Point point);

    int getLayoutDirection();

    ViewParent getParent();

    ViewParent getParentForAccessibility();

    int getTextAlignment();

    int getTextDirection();

    @Deprecated
    void invalidateChild(View view, Rect rect);

    @Deprecated
    ViewParent invalidateChildInParent(int[] iArr, Rect rect);

    boolean isLayoutDirectionResolved();

    boolean isLayoutRequested();

    boolean isTextAlignmentResolved();

    boolean isTextDirectionResolved();

    View keyboardNavigationClusterSearch(View view, int i10);

    void notifySubtreeAccessibilityStateChanged(View view, View view2, int i10);

    boolean onNestedFling(View view, float f10, float f11, boolean z10);

    boolean onNestedPreFling(View view, float f10, float f11);

    boolean onNestedPrePerformAccessibilityAction(View view, int i10, Bundle bundle);

    void onNestedPreScroll(View view, int i10, int i11, int[] iArr);

    void onNestedScroll(View view, int i10, int i11, int i12, int i13);

    void onNestedScrollAccepted(View view, View view2, int i10);

    boolean onStartNestedScroll(View view, View view2, int i10);

    void onStopNestedScroll(View view);

    void recomputeViewAttributes(View view);

    void requestChildFocus(View view, View view2);

    boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z10);

    void requestDisallowInterceptTouchEvent(boolean z10);

    void requestFitSystemWindows();

    void requestLayout();

    boolean requestSendAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent);

    void requestTransparentRegion(View view);

    boolean showContextMenuForChild(View view);

    boolean showContextMenuForChild(View view, float f10, float f11);

    ActionMode startActionModeForChild(View view, ActionMode.Callback callback);

    ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int i10);

    default void onDescendantInvalidated(View child, View target) {
        if (getParent() != null) {
            getParent().onDescendantInvalidated(child, target);
        }
    }

    default void subtractObscuredTouchableRegion(Region touchableRegion, View view) {
    }

    default void onDescendantUnbufferedRequested() {
        if (getParent() != null) {
            getParent().onDescendantUnbufferedRequested();
        }
    }

    default OnBackInvokedDispatcher findOnBackInvokedDispatcherForChild(View child, View requester) {
        return null;
    }
}
