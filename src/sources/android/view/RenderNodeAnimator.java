package android.view;

import android.graphics.CanvasProperty;
import android.graphics.Paint;
import android.graphics.animation.RenderNodeAnimator;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class RenderNodeAnimator extends android.graphics.animation.RenderNodeAnimator implements RenderNodeAnimator.ViewListener {
    private View mViewTarget;

    public RenderNodeAnimator(int property, float finalValue) {
        super(property, finalValue);
    }

    public RenderNodeAnimator(CanvasProperty<Float> property, float finalValue) {
        super(property, finalValue);
    }

    public RenderNodeAnimator(CanvasProperty<Paint> property, int paintField, float finalValue) {
        super(property, paintField, finalValue);
    }

    public RenderNodeAnimator(int x10, int y10, float startRadius, float endRadius) {
        super(x10, y10, startRadius, endRadius);
    }

    public void onAlphaAnimationStart(float finalAlpha) {
        this.mViewTarget.ensureTransformationInfo();
        this.mViewTarget.setAlphaInternal(finalAlpha);
    }

    public void invalidateParent(boolean forceRedraw) {
        this.mViewTarget.invalidateViewProperty(true, false);
    }

    public void setTarget(View view) {
        this.mViewTarget = view;
        setViewListener(this);
        setTarget(this.mViewTarget.mRenderNode);
    }
}
