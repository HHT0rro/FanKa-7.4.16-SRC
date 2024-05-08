package android.view;

import android.content.Context;
import android.graphics.Rect;
import android.view.HandwritingInitiator;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class HandwritingInitiator {
    private final int mHandwritingSlop;
    private final InputMethodManager mImm;
    private State mState;
    private final HandwritingAreaTracker mHandwritingAreasTracker = new HandwritingAreaTracker();
    public WeakReference<View> mConnectedView = null;
    private int mConnectionCount = 0;
    private WeakReference<View> mCachedHoverTarget = null;
    private boolean mShowHoverIconForConnectedView = true;
    private final long mHandwritingTimeoutInMillis = ViewConfiguration.getLongPressTimeout();

    public HandwritingInitiator(ViewConfiguration viewConfiguration, InputMethodManager inputMethodManager) {
        this.mHandwritingSlop = viewConfiguration.getScaledHandwritingSlop();
        this.mImm = inputMethodManager;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0006. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00ff  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r12) {
        /*
            Method dump skipped, instructions count: 322
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.view.HandwritingInitiator.onTouchEvent(android.view.MotionEvent):boolean");
    }

    private View getConnectedView() {
        WeakReference<View> weakReference = this.mConnectedView;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    private void clearConnectedView() {
        this.mConnectedView = null;
        this.mConnectionCount = 0;
    }

    public void onDelegateViewFocused(View view) {
        if (view == getConnectedView() && tryAcceptStylusHandwritingDelegation(view)) {
            this.mShowHoverIconForConnectedView = false;
        }
    }

    public void onInputConnectionCreated(View view) {
        if (!view.isAutoHandwritingEnabled()) {
            clearConnectedView();
            return;
        }
        View connectedView = getConnectedView();
        if (connectedView == view) {
            this.mConnectionCount++;
            return;
        }
        this.mConnectedView = new WeakReference<>(view);
        this.mConnectionCount = 1;
        this.mShowHoverIconForConnectedView = true;
        if (view.isHandwritingDelegate() && tryAcceptStylusHandwritingDelegation(view)) {
            this.mShowHoverIconForConnectedView = false;
            return;
        }
        State state = this.mState;
        if (state != null && state.mShouldInitHandwriting) {
            tryStartHandwriting();
        }
    }

    public void onInputConnectionClosed(View view) {
        View connectedView = getConnectedView();
        if (connectedView == null) {
            return;
        }
        if (connectedView == view) {
            int i10 = this.mConnectionCount - 1;
            this.mConnectionCount = i10;
            if (i10 == 0) {
                clearConnectedView();
                return;
            }
            return;
        }
        clearConnectedView();
    }

    private void tryStartHandwriting() {
        View connectedView;
        if (!this.mState.mExceedHandwritingSlop || (connectedView = getConnectedView()) == null) {
            return;
        }
        if (!connectedView.isAutoHandwritingEnabled()) {
            clearConnectedView();
            return;
        }
        Rect handwritingArea = getViewHandwritingArea(connectedView);
        if (isInHandwritingArea(handwritingArea, this.mState.mStylusDownX, this.mState.mStylusDownY, connectedView)) {
            startHandwriting(connectedView);
        } else {
            this.mState.mShouldInitHandwriting = false;
        }
    }

    public void startHandwriting(View view) {
        this.mImm.startStylusHandwriting(view);
        this.mState.mHasInitiatedHandwriting = true;
        this.mState.mShouldInitHandwriting = false;
        this.mShowHoverIconForConnectedView = false;
        if (view instanceof TextView) {
            ((TextView) view).hideHint();
        }
    }

    public boolean tryAcceptStylusHandwritingDelegation(View view) {
        String delegatorPackageName = view.getAllowedHandwritingDelegatorPackageName();
        if (delegatorPackageName == null) {
            delegatorPackageName = view.getContext().getOpPackageName();
        }
        if (!this.mImm.acceptStylusHandwritingDelegation(view, delegatorPackageName)) {
            return false;
        }
        State state = this.mState;
        if (state != null) {
            state.mHasInitiatedHandwriting = true;
            this.mState.mShouldInitHandwriting = false;
        }
        if (view instanceof TextView) {
            ((TextView) view).hideHint();
        }
        return true;
    }

    public void updateHandwritingAreasForView(View view) {
        this.mHandwritingAreasTracker.updateHandwritingAreaForView(view);
    }

    private static boolean shouldTriggerStylusHandwritingForView(View view) {
        if (!view.isAutoHandwritingEnabled()) {
            return false;
        }
        return view.isStylusHandwritingAvailable();
    }

    public PointerIcon onResolvePointerIcon(Context context, MotionEvent event) {
        View hoverView = findHoverView(event);
        if (hoverView == null) {
            return null;
        }
        if (this.mShowHoverIconForConnectedView) {
            return PointerIcon.getSystemIcon(context, 1022);
        }
        if (hoverView == getConnectedView()) {
            return null;
        }
        this.mShowHoverIconForConnectedView = true;
        return PointerIcon.getSystemIcon(context, 1022);
    }

    private View getCachedHoverTarget() {
        WeakReference<View> weakReference = this.mCachedHoverTarget;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    private View findHoverView(MotionEvent event) {
        if (!event.isStylusPointer() || !event.isHoverEvent()) {
            return null;
        }
        if (event.getActionMasked() == 9 || event.getActionMasked() == 7) {
            float hoverX = event.getX(event.getActionIndex());
            float hoverY = event.getY(event.getActionIndex());
            View cachedHoverTarget = getCachedHoverTarget();
            if (cachedHoverTarget != null) {
                Rect handwritingArea = getViewHandwritingArea(cachedHoverTarget);
                if (isInHandwritingArea(handwritingArea, hoverX, hoverY, cachedHoverTarget) && shouldTriggerStylusHandwritingForView(cachedHoverTarget)) {
                    return cachedHoverTarget;
                }
            }
            View candidateView = findBestCandidateView(hoverX, hoverY);
            if (candidateView != null) {
                this.mCachedHoverTarget = new WeakReference<>(candidateView);
                return candidateView;
            }
        }
        this.mCachedHoverTarget = null;
        return null;
    }

    private static void requestFocusWithoutReveal(View view) {
        if (view.getRevealOnFocusHint()) {
            view.setRevealOnFocusHint(false);
            view.requestFocus();
            view.setRevealOnFocusHint(true);
            return;
        }
        view.requestFocus();
    }

    private View findBestCandidateView(float x10, float y10) {
        View connectedView = getConnectedView();
        if (connectedView != null && isInHandwritingArea(getViewHandwritingArea(connectedView), x10, y10, connectedView) && shouldTriggerStylusHandwritingForView(connectedView)) {
            return connectedView;
        }
        float minDistance = Float.MAX_VALUE;
        View bestCandidate = null;
        List<HandwritableViewInfo> handwritableViewInfos = this.mHandwritingAreasTracker.computeViewInfos();
        for (HandwritableViewInfo viewInfo : handwritableViewInfos) {
            View view = viewInfo.getView();
            Rect handwritingArea = viewInfo.getHandwritingArea();
            if (isInHandwritingArea(handwritingArea, x10, y10, view) && shouldTriggerStylusHandwritingForView(view)) {
                float distance = distance(handwritingArea, x10, y10);
                if (distance == 0.0f) {
                    return view;
                }
                if (distance < minDistance) {
                    minDistance = distance;
                    bestCandidate = view;
                }
            }
        }
        return bestCandidate;
    }

    private static float distance(Rect rect, float x10, float y10) {
        float xDistance;
        float yDistance;
        if (contains(rect, x10, y10, 0.0f, 0.0f, 0.0f, 0.0f)) {
            return 0.0f;
        }
        if (x10 >= rect.left && x10 < rect.right) {
            xDistance = 0.0f;
        } else if (x10 < rect.left) {
            xDistance = rect.left - x10;
        } else {
            xDistance = x10 - rect.right;
        }
        if (y10 >= rect.top && y10 < rect.bottom) {
            yDistance = 0.0f;
        } else if (y10 < rect.top) {
            yDistance = rect.top - y10;
        } else {
            yDistance = y10 - rect.bottom;
        }
        return (xDistance * xDistance) + (yDistance * yDistance);
    }

    private static Rect getViewHandwritingArea(View view) {
        ViewParent viewParent = view.getParent();
        if (viewParent != null && view.isAttachedToWindow() && view.isAggregatedVisible()) {
            Rect localHandwritingArea = view.getHandwritingArea();
            Rect globalHandwritingArea = new Rect();
            if (localHandwritingArea != null) {
                globalHandwritingArea.set(localHandwritingArea);
            } else {
                globalHandwritingArea.set(0, 0, view.getWidth(), view.getHeight());
            }
            if (viewParent.getChildVisibleRect(view, globalHandwritingArea, null)) {
                return globalHandwritingArea;
            }
        }
        return null;
    }

    private static boolean isInHandwritingArea(Rect handwritingArea, float x10, float y10, View view) {
        if (handwritingArea == null) {
            return false;
        }
        return contains(handwritingArea, x10, y10, view.getHandwritingBoundsOffsetLeft(), view.getHandwritingBoundsOffsetTop(), view.getHandwritingBoundsOffsetRight(), view.getHandwritingBoundsOffsetBottom());
    }

    private static boolean contains(Rect rect, float x10, float y10, float offsetLeft, float offsetTop, float offsetRight, float offsetBottom) {
        return x10 >= ((float) rect.left) - offsetLeft && x10 < ((float) rect.right) + offsetRight && y10 >= ((float) rect.top) - offsetTop && y10 < ((float) rect.bottom) + offsetBottom;
    }

    private boolean largerThanTouchSlop(float x12, float y1, float x22, float y22) {
        float dx = x12 - x22;
        float dy = y1 - y22;
        float f10 = (dx * dx) + (dy * dy);
        int i10 = this.mHandwritingSlop;
        return f10 > ((float) (i10 * i10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class State {
        private boolean mExceedHandwritingSlop;
        private boolean mHasInitiatedHandwriting;
        private boolean mHasPreparedHandwritingDelegation;
        private boolean mShouldInitHandwriting;
        private final long mStylusDownTimeInMillis;
        private final float mStylusDownX;
        private final float mStylusDownY;
        private final int mStylusPointerId;

        private State(MotionEvent motionEvent) {
            int actionIndex = motionEvent.getActionIndex();
            this.mStylusPointerId = motionEvent.getPointerId(actionIndex);
            this.mStylusDownTimeInMillis = motionEvent.getEventTime();
            this.mStylusDownX = motionEvent.getX(actionIndex);
            this.mStylusDownY = motionEvent.getY(actionIndex);
            this.mShouldInitHandwriting = true;
            this.mHasInitiatedHandwriting = false;
            this.mHasPreparedHandwritingDelegation = false;
            this.mExceedHandwritingSlop = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isViewActive(View view) {
        return view != null && view.isAttachedToWindow() && view.isAggregatedVisible() && view.isAutoHandwritingEnabled();
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class HandwritingAreaTracker {
        private final List<HandwritableViewInfo> mHandwritableViewInfos = new ArrayList();

        public void updateHandwritingAreaForView(View view) {
            Iterator<HandwritableViewInfo> iterator = this.mHandwritableViewInfos.iterator2();
            boolean found = false;
            while (iterator.hasNext()) {
                HandwritableViewInfo handwritableViewInfo = iterator.next();
                View curView = handwritableViewInfo.getView();
                if (!HandwritingInitiator.isViewActive(curView)) {
                    iterator.remove();
                }
                if (curView == view) {
                    found = true;
                    handwritableViewInfo.mIsDirty = true;
                }
            }
            if (!found && HandwritingInitiator.isViewActive(view)) {
                this.mHandwritableViewInfos.add(new HandwritableViewInfo(view));
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ boolean lambda$computeViewInfos$0(HandwritableViewInfo viewInfo) {
            return !viewInfo.update();
        }

        public List<HandwritableViewInfo> computeViewInfos() {
            this.mHandwritableViewInfos.removeIf(new Predicate() { // from class: android.view.HandwritingInitiator$HandwritingAreaTracker$$ExternalSyntheticLambda0
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return HandwritingInitiator.HandwritingAreaTracker.lambda$computeViewInfos$0((HandwritingInitiator.HandwritableViewInfo) obj);
                }
            });
            return this.mHandwritableViewInfos;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class HandwritableViewInfo {
        Rect mHandwritingArea = null;
        public boolean mIsDirty = true;
        final WeakReference<View> mViewRef;

        public HandwritableViewInfo(View view) {
            this.mViewRef = new WeakReference<>(view);
        }

        public View getView() {
            return this.mViewRef.get();
        }

        public Rect getHandwritingArea() {
            return this.mHandwritingArea;
        }

        public boolean update() {
            View view = getView();
            if (!HandwritingInitiator.isViewActive(view)) {
                return false;
            }
            if (!this.mIsDirty) {
                return true;
            }
            Rect handwritingArea = view.getHandwritingArea();
            if (handwritingArea == null) {
                return false;
            }
            ViewParent parent = view.getParent();
            if (parent != null) {
                if (this.mHandwritingArea == null) {
                    this.mHandwritingArea = new Rect();
                }
                this.mHandwritingArea.set(handwritingArea);
                if (!parent.getChildVisibleRect(view, this.mHandwritingArea, null)) {
                    this.mHandwritingArea = null;
                }
            }
            this.mIsDirty = false;
            return true;
        }
    }
}
