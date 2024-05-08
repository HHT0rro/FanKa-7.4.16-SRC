package android.view;

import android.graphics.Point;
import android.graphics.Rect;
import com.alipay.sdk.util.i;
import java.io.PrintWriter;
import java.util.Objects;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public final class ScrollCaptureTarget {
    private final ScrollCaptureCallback mCallback;
    private final View mContainingView;
    private final int mHint;
    private final Rect mLocalVisibleRect;
    private final Point mPositionInWindow;
    private Rect mScrollBounds;
    private final int[] mTmpIntArr = new int[2];

    public ScrollCaptureTarget(View scrollTarget, Rect localVisibleRect, Point positionInWindow, ScrollCaptureCallback callback) {
        View view = (View) Objects.requireNonNull(scrollTarget);
        this.mContainingView = view;
        this.mHint = view.getScrollCaptureHint();
        this.mCallback = (ScrollCaptureCallback) Objects.requireNonNull(callback);
        this.mLocalVisibleRect = (Rect) Objects.requireNonNull(localVisibleRect);
        this.mPositionInWindow = (Point) Objects.requireNonNull(positionInWindow);
    }

    public int getHint() {
        return this.mHint;
    }

    public ScrollCaptureCallback getCallback() {
        return this.mCallback;
    }

    public View getContainingView() {
        return this.mContainingView;
    }

    public Rect getLocalVisibleRect() {
        return this.mLocalVisibleRect;
    }

    public Point getPositionInWindow() {
        return this.mPositionInWindow;
    }

    public Rect getScrollBounds() {
        return this.mScrollBounds;
    }

    public void setScrollBounds(Rect scrollBounds) {
        Rect copyOrNull = Rect.copyOrNull(scrollBounds);
        this.mScrollBounds = copyOrNull;
        if (copyOrNull != null && !copyOrNull.intersect(0, 0, this.mContainingView.getWidth(), this.mContainingView.getHeight())) {
            this.mScrollBounds.setEmpty();
        }
    }

    public void updatePositionInWindow() {
        this.mContainingView.getLocationInWindow(this.mTmpIntArr);
        this.mPositionInWindow.x = this.mTmpIntArr[0];
        this.mPositionInWindow.y = this.mTmpIntArr[1];
    }

    public String toString() {
        return "ScrollCaptureTarget{view=" + ((Object) this.mContainingView) + ", callback=" + ((Object) this.mCallback) + ", scrollBounds=" + ((Object) this.mScrollBounds) + ", localVisibleRect=" + ((Object) this.mLocalVisibleRect) + ", positionInWindow=" + ((Object) this.mPositionInWindow) + i.f4738d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dump(PrintWriter writer) {
        View view = getContainingView();
        writer.println("view: " + ((Object) view));
        writer.println("hint: " + this.mHint);
        writer.println("callback: " + ((Object) this.mCallback));
        StringBuilder append = new StringBuilder().append("scrollBounds: ");
        Rect rect = this.mScrollBounds;
        writer.println(append.append(rect == null ? "null" : rect.toShortString()).toString());
        Point inWindow = getPositionInWindow();
        writer.println("positionInWindow: " + (inWindow == null ? "null" : "[" + inWindow.x + "," + inWindow.y + "]"));
        Rect localVisible = getLocalVisibleRect();
        writer.println("localVisibleRect: " + (localVisible != null ? localVisible.toShortString() : "null"));
    }
}
