package android.view;

import android.content.Context;
import android.graphics.BLASTBufferQueue;
import android.util.BoostFramework;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class ViewRootImplSocExtImpl implements IViewRootImplSocExt {
    private boolean mHaveMoveEvent = false;
    private ViewRootImpl mViewRootImpl;

    public ViewRootImplSocExtImpl(Object obj) {
        this.mViewRootImpl = null;
        this.mViewRootImpl = (ViewRootImpl) obj;
    }

    @Override // android.view.IViewRootImplSocExt
    public void setBLASTBufferQueue(BLASTBufferQueue bLASTBufferQueue) {
        BoostFramework.ScrollOptimizer.setBLASTBufferQueue(bLASTBufferQueue);
    }

    @Override // android.view.IViewRootImplSocExt
    public void setHaveMoveEvent(MotionEvent event) {
        int action = event.getActionMasked();
        if (action == 2) {
            this.mHaveMoveEvent = true;
        } else if (action == 1) {
            this.mHaveMoveEvent = false;
        }
    }

    @Override // android.view.IViewRootImplSocExt
    public void hookScrollPerfHint(Context context) {
    }

    @Override // android.view.IViewRootImplSocExt
    public void hookMotionEventPerfHint(MotionEvent event, Context context) {
    }

    @Override // android.view.IViewRootImplSocExt
    public void hookFinishDrawingPerfHint() {
    }

    @Override // android.view.IViewRootImplSocExt
    public void hookOnFrameDrawPerfHint() {
    }

    @Override // android.view.IViewRootImplSocExt
    public void hookRealDrawPerfHint() {
    }
}
