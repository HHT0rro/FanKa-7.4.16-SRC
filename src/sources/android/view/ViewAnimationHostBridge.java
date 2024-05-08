package android.view;

import android.graphics.RenderNode;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class ViewAnimationHostBridge implements RenderNode.AnimationHost {
    private final View mView;

    public ViewAnimationHostBridge(View view) {
        this.mView = view;
    }

    public void registerAnimatingRenderNode(RenderNode animator) {
        this.mView.mAttachInfo.mViewRootImpl.registerAnimatingRenderNode(animator);
    }

    public void registerVectorDrawableAnimator(NativeVectorDrawableAnimator animator) {
        this.mView.mAttachInfo.mViewRootImpl.registerVectorDrawableAnimator(animator);
    }

    public boolean isAttached() {
        return this.mView.mAttachInfo != null;
    }
}
