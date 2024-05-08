package com.android.internal.graphics.drawable;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.HardwareRenderer;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RenderNode;
import android.graphics.drawable.Drawable;
import android.os.SystemProperties;
import android.util.ArraySet;
import android.util.Log;
import android.util.LongSparseArray;
import android.view.ViewRootImpl;
import android.view.ViewTreeObserver;
import com.alipay.sdk.util.i;
import com.android.internal.graphics.drawable.BackgroundBlurDrawable;
import system.ext.loader.core.ExtLoader;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public final class BackgroundBlurDrawable extends Drawable {
    private static boolean DEBUG;
    private static final String TAG;
    private final Aggregator mAggregator;
    private float mAlpha;
    private float[] mBlurColor;
    private int mBlurRadius;
    private float mCornerRadiusBL;
    private float mCornerRadiusBR;
    private float mCornerRadiusTL;
    private float mCornerRadiusTR;
    private final Paint mPaint;
    public final RenderNode.PositionUpdateListener mPositionUpdateListener;
    private final Rect mRect;
    private final Path mRectPath;
    private final RenderNode mRenderNode;
    private final float[] mTmpRadii;
    private boolean mVisible;

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0017, code lost:
    
        if (android.os.SystemProperties.getBoolean("persist.sys.assert.panic", false) != false) goto L6;
     */
    static {
        /*
            java.lang.Class<com.android.internal.graphics.drawable.BackgroundBlurDrawable> r0 = com.android.internal.graphics.drawable.BackgroundBlurDrawable.class
            java.lang.String r0 = r0.getSimpleName()
            com.android.internal.graphics.drawable.BackgroundBlurDrawable.TAG = r0
            r1 = 3
            boolean r0 = android.util.Log.isLoggable(r0, r1)
            if (r0 != 0) goto L19
            java.lang.String r0 = "persist.sys.assert.panic"
            r1 = 0
            boolean r0 = android.os.SystemProperties.getBoolean(r0, r1)
            if (r0 == 0) goto L1a
        L19:
            r1 = 1
        L1a:
            com.android.internal.graphics.drawable.BackgroundBlurDrawable.DEBUG = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.internal.graphics.drawable.BackgroundBlurDrawable.<clinit>():void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* renamed from: com.android.internal.graphics.drawable.BackgroundBlurDrawable$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public class AnonymousClass1 implements RenderNode.PositionUpdateListener {
        AnonymousClass1() {
        }

        public void positionChanged(long frameNumber, final int left, final int top, final int right, final int bottom) {
            if (BackgroundBlurDrawable.DEBUG) {
                Log.d(BackgroundBlurDrawable.TAG, "positionChanged frame " + frameNumber + " [" + left + " " + top + " " + right + " " + bottom + "]");
            }
            BackgroundBlurDrawable.this.mAggregator.onRenderNodePositionChanged(frameNumber, new Runnable() { // from class: com.android.internal.graphics.drawable.BackgroundBlurDrawable$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    BackgroundBlurDrawable.AnonymousClass1.this.lambda$positionChanged$0(left, top, right, bottom);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$positionChanged$0(int left, int top, int right, int bottom) {
            BackgroundBlurDrawable.this.mRect.set(left, top, right, bottom);
        }

        public void positionLost(long frameNumber) {
            if (BackgroundBlurDrawable.DEBUG) {
                Log.d(BackgroundBlurDrawable.TAG, "positionLost frame " + frameNumber);
            }
            BackgroundBlurDrawable.this.mAggregator.onRenderNodePositionChanged(frameNumber, new Runnable() { // from class: com.android.internal.graphics.drawable.BackgroundBlurDrawable$1$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    BackgroundBlurDrawable.AnonymousClass1.this.lambda$positionLost$1();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$positionLost$1() {
            BackgroundBlurDrawable.this.mRect.setEmpty();
        }
    }

    private BackgroundBlurDrawable(Aggregator aggregator) {
        Paint paint = new Paint();
        this.mPaint = paint;
        this.mRectPath = new Path();
        this.mTmpRadii = new float[8];
        this.mVisible = true;
        this.mAlpha = 1.0f;
        this.mBlurColor = new float[4];
        this.mRect = new Rect();
        AnonymousClass1 anonymousClass1 = new AnonymousClass1();
        this.mPositionUpdateListener = anonymousClass1;
        DEBUG = DEBUG ? true : SystemProperties.getBoolean("persist.sys.assert.panic", false);
        this.mAggregator = aggregator;
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        paint.setColor(0);
        paint.setAntiAlias(true);
        RenderNode renderNode = new RenderNode("BackgroundBlurDrawable");
        this.mRenderNode = renderNode;
        renderNode.addPositionUpdateListener(anonymousClass1);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.mRectPath.isEmpty() || !isVisible() || getAlpha() == 0) {
            return;
        }
        canvas.drawPath(this.mRectPath, this.mPaint);
        canvas.drawRenderNode(this.mRenderNode);
    }

    public void setColor(int color) {
        this.mPaint.setColor(color);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean visible, boolean restart) {
        boolean changed = super.setVisible(visible, restart);
        if (changed) {
            this.mVisible = visible;
            this.mAggregator.onBlurDrawableUpdated(this);
        }
        return changed;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        if (this.mAlpha != alpha / 255.0f) {
            this.mAlpha = alpha / 255.0f;
            invalidateSelf();
            this.mAggregator.onBlurDrawableUpdated(this);
        }
    }

    public void setBlurRadius(int blurRadius) {
        if (this.mBlurRadius != blurRadius) {
            this.mBlurRadius = blurRadius;
            invalidateSelf();
            this.mAggregator.onBlurDrawableUpdated(this);
        }
    }

    public void setCornerRadius(float cornerRadius) {
        setCornerRadius(cornerRadius, cornerRadius, cornerRadius, cornerRadius);
    }

    public void setCornerRadius(float cornerRadiusTL, float cornerRadiusTR, float cornerRadiusBL, float cornerRadiusBR) {
        if (this.mCornerRadiusTL != cornerRadiusTL || this.mCornerRadiusTR != cornerRadiusTR || this.mCornerRadiusBL != cornerRadiusBL || this.mCornerRadiusBR != cornerRadiusBR) {
            this.mCornerRadiusTL = cornerRadiusTL;
            this.mCornerRadiusTR = cornerRadiusTR;
            this.mCornerRadiusBL = cornerRadiusBL;
            this.mCornerRadiusBR = cornerRadiusBR;
            updatePath();
            invalidateSelf();
            this.mAggregator.onBlurDrawableUpdated(this);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int left, int top, int right, int bottom) {
        super.setBounds(left, top, right, bottom);
        this.mRenderNode.setPosition(left, top, right, bottom);
        updatePath();
    }

    public void setBlurColor(float r10, float g3, float b4, float a10) {
        float[] fArr = this.mBlurColor;
        boolean changed = (fArr[0] == r10 && fArr[1] == g3 && fArr[2] == b4 && fArr[3] == a10) ? false : true;
        if (changed) {
            fArr[0] = r10;
            fArr[1] = g3;
            fArr[2] = b4;
            fArr[3] = a10;
            invalidateSelf();
            this.mAggregator.onBlurDrawableUpdated(this);
        }
    }

    private void updatePath() {
        float[] fArr = this.mTmpRadii;
        float f10 = this.mCornerRadiusTL;
        fArr[1] = f10;
        fArr[0] = f10;
        float f11 = this.mCornerRadiusTR;
        fArr[3] = f11;
        fArr[2] = f11;
        float f12 = this.mCornerRadiusBL;
        fArr[5] = f12;
        fArr[4] = f12;
        float f13 = this.mCornerRadiusBR;
        fArr[7] = f13;
        fArr[6] = f13;
        this.mRectPath.reset();
        if (getAlpha() == 0 || !isVisible()) {
            return;
        }
        Rect bounds = getBounds();
        this.mRectPath.addRoundRect(bounds.left, bounds.top, bounds.right, bounds.bottom, this.mTmpRadii, Path.Direction.CW);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        throw new IllegalArgumentException("not implemented");
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public String toString() {
        return "BackgroundBlurDrawable{blurRadius=" + this.mBlurRadius + ", corners={" + this.mCornerRadiusTL + "," + this.mCornerRadiusTR + "," + this.mCornerRadiusBL + "," + this.mCornerRadiusBR + "}, color={" + this.mBlurColor[0] + "," + this.mBlurColor[1] + "," + this.mBlurColor[2] + "," + this.mBlurColor[3] + "}, alpha=" + this.mAlpha + ", visible=" + this.mVisible + i.f4738d;
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static final class Aggregator {
        private boolean mHasUiUpdates;
        private ViewTreeObserver.OnPreDrawListener mOnPreDrawListener;
        private final ViewRootImpl mViewRoot;
        private final Object mRtLock = new Object();
        private final ArraySet<BackgroundBlurDrawable> mDrawables = new ArraySet<>();
        private final LongSparseArray<ArraySet<Runnable>> mFrameRtUpdates = new LongSparseArray<>();
        private long mLastFrameNumber = 0;
        private BlurRegion[] mLastFrameBlurRegions = null;
        private BlurRegion[] mTmpBlurRegionsForFrame = new BlurRegion[0];
        private IBackgroundBlurDrawableExt mBackgroundBlurDrawableExtImpl = (IBackgroundBlurDrawableExt) ExtLoader.type(IBackgroundBlurDrawableExt.class).base((Object) null).create();

        public Aggregator(ViewRootImpl viewRoot) {
            this.mViewRoot = viewRoot;
        }

        public BackgroundBlurDrawable createBackgroundBlurDrawable(Context context) {
            BackgroundBlurDrawable drawable = new BackgroundBlurDrawable(this);
            drawable.setBlurRadius(context.getResources().getDimensionPixelSize(17105184));
            this.mBackgroundBlurDrawableExtImpl.setPackageName(context.getPackageName());
            return drawable;
        }

        void onBlurDrawableUpdated(BackgroundBlurDrawable drawable) {
            boolean shouldBeDrawn = drawable.mAlpha != 0.0f && drawable.mBlurRadius > 0 && drawable.mVisible;
            boolean isDrawn = this.mDrawables.contains(drawable);
            if (shouldBeDrawn) {
                this.mHasUiUpdates = true;
                if (!isDrawn) {
                    this.mDrawables.add(drawable);
                    if (BackgroundBlurDrawable.DEBUG) {
                        Log.d(BackgroundBlurDrawable.TAG, "Add " + ((Object) drawable));
                    }
                } else if (BackgroundBlurDrawable.DEBUG) {
                    Log.d(BackgroundBlurDrawable.TAG, "Update " + ((Object) drawable));
                }
            } else if (!shouldBeDrawn && isDrawn) {
                this.mHasUiUpdates = true;
                this.mDrawables.remove(drawable);
                if (BackgroundBlurDrawable.DEBUG) {
                    Log.d(BackgroundBlurDrawable.TAG, "Remove " + ((Object) drawable));
                }
            }
            if (this.mOnPreDrawListener == null && this.mViewRoot.getView() != null && hasRegions()) {
                registerPreDrawListener();
            }
        }

        private void registerPreDrawListener() {
            this.mOnPreDrawListener = new ViewTreeObserver.OnPreDrawListener() { // from class: com.android.internal.graphics.drawable.BackgroundBlurDrawable$Aggregator$$ExternalSyntheticLambda1
                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public final boolean onPreDraw() {
                    boolean lambda$registerPreDrawListener$1;
                    lambda$registerPreDrawListener$1 = BackgroundBlurDrawable.Aggregator.this.lambda$registerPreDrawListener$1();
                    return lambda$registerPreDrawListener$1;
                }
            };
            this.mViewRoot.getView().getViewTreeObserver().addOnPreDrawListener(this.mOnPreDrawListener);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ boolean lambda$registerPreDrawListener$1() {
            final boolean hasUiUpdates = hasUpdates();
            if (hasUiUpdates || hasRegions()) {
                final BlurRegion[] blurRegionsForNextFrame = getBlurRegionsCopyForRT();
                this.mViewRoot.registerRtFrameCallback(new HardwareRenderer.FrameDrawingCallback() { // from class: com.android.internal.graphics.drawable.BackgroundBlurDrawable$Aggregator$$ExternalSyntheticLambda0
                    public final void onFrameDraw(long j10) {
                        BackgroundBlurDrawable.Aggregator.this.lambda$registerPreDrawListener$0(blurRegionsForNextFrame, hasUiUpdates, j10);
                    }
                });
            }
            if (!hasRegions() && this.mViewRoot.getView() != null) {
                this.mViewRoot.getView().getViewTreeObserver().removeOnPreDrawListener(this.mOnPreDrawListener);
                this.mOnPreDrawListener = null;
                return true;
            }
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$registerPreDrawListener$0(BlurRegion[] blurRegionsForNextFrame, boolean hasUiUpdates, long frame) {
            synchronized (this.mRtLock) {
                this.mLastFrameNumber = frame;
                this.mLastFrameBlurRegions = blurRegionsForNextFrame;
                handleDispatchBlurTransactionLocked(frame, blurRegionsForNextFrame, hasUiUpdates);
            }
        }

        void onRenderNodePositionChanged(long frameNumber, Runnable update) {
            synchronized (this.mRtLock) {
                ArraySet<Runnable> frameRtUpdates = this.mFrameRtUpdates.get(frameNumber);
                if (frameRtUpdates == null) {
                    frameRtUpdates = new ArraySet<>();
                    this.mFrameRtUpdates.put(frameNumber, frameRtUpdates);
                }
                frameRtUpdates.add(update);
                if (this.mLastFrameNumber == frameNumber) {
                    handleDispatchBlurTransactionLocked(frameNumber, this.mLastFrameBlurRegions, true);
                }
            }
        }

        public boolean hasUpdates() {
            return this.mHasUiUpdates;
        }

        public boolean hasRegions() {
            return this.mDrawables.size() > 0;
        }

        public BlurRegion[] getBlurRegionsCopyForRT() {
            if (this.mHasUiUpdates) {
                this.mTmpBlurRegionsForFrame = new BlurRegion[this.mDrawables.size()];
                for (int i10 = 0; i10 < this.mDrawables.size(); i10++) {
                    this.mTmpBlurRegionsForFrame[i10] = new BlurRegion(this.mDrawables.valueAt(i10));
                }
                this.mHasUiUpdates = false;
            }
            BlurRegion[] sortBlurRegionsIfNeeded = this.mBackgroundBlurDrawableExtImpl.sortBlurRegionsIfNeeded(this.mTmpBlurRegionsForFrame);
            this.mTmpBlurRegionsForFrame = sortBlurRegionsIfNeeded;
            return sortBlurRegionsIfNeeded;
        }

        public float[][] getBlurRegionsForFrameLocked(long frameNumber, BlurRegion[] blurRegionsForFrame, boolean forceUpdate) {
            if (!forceUpdate && (this.mFrameRtUpdates.size() == 0 || this.mFrameRtUpdates.keyAt(0) > frameNumber)) {
                this.mFrameRtUpdates.clear();
                return null;
            }
            while (this.mFrameRtUpdates.size() != 0 && this.mFrameRtUpdates.keyAt(0) <= frameNumber) {
                ArraySet<Runnable> frameUpdates = this.mFrameRtUpdates.valueAt(0);
                this.mFrameRtUpdates.removeAt(0);
                for (int i10 = 0; i10 < frameUpdates.size(); i10++) {
                    frameUpdates.valueAt(i10).run();
                }
            }
            if (BackgroundBlurDrawable.DEBUG) {
                Log.d(BackgroundBlurDrawable.TAG, "Dispatching " + blurRegionsForFrame.length + " blur regions:");
            }
            float[][] blurRegionsArray = new float[blurRegionsForFrame.length];
            for (int i11 = 0; i11 < blurRegionsArray.length; i11++) {
                blurRegionsArray[i11] = blurRegionsForFrame[i11].toFloatArray();
                if (BackgroundBlurDrawable.DEBUG) {
                    Log.d(BackgroundBlurDrawable.TAG, blurRegionsForFrame[i11].toString());
                }
            }
            return blurRegionsArray;
        }

        private void handleDispatchBlurTransactionLocked(long frameNumber, BlurRegion[] blurRegions, boolean forceUpdate) {
            float[][] blurRegionsArray = getBlurRegionsForFrameLocked(frameNumber, blurRegions, forceUpdate);
            if (blurRegionsArray != null) {
                this.mViewRoot.dispatchBlurRegions(blurRegionsArray, frameNumber);
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static final class BlurRegion {
        public final float alpha;
        public final float blurColorA;
        public final float blurColorB;
        public final float blurColorG;
        public final float blurColorR;
        public final int blurRadius;
        public final float cornerRadiusBL;
        public final float cornerRadiusBR;
        public final float cornerRadiusTL;
        public final float cornerRadiusTR;
        public final Rect rect;

        BlurRegion(BackgroundBlurDrawable drawable) {
            this.alpha = drawable.mAlpha;
            this.blurRadius = drawable.mBlurRadius;
            this.cornerRadiusTL = drawable.mCornerRadiusTL;
            this.cornerRadiusTR = drawable.mCornerRadiusTR;
            this.cornerRadiusBL = drawable.mCornerRadiusBL;
            this.cornerRadiusBR = drawable.mCornerRadiusBR;
            this.rect = drawable.mRect;
            this.blurColorR = drawable.mBlurColor[0];
            this.blurColorG = drawable.mBlurColor[1];
            this.blurColorB = drawable.mBlurColor[2];
            this.blurColorA = drawable.mBlurColor[3];
        }

        float[] toFloatArray() {
            float[] floatArray = {this.blurRadius, this.alpha, this.rect.left, this.rect.top, this.rect.right, this.rect.bottom, this.cornerRadiusTL, this.cornerRadiusTR, this.cornerRadiusBL, this.cornerRadiusBR, this.blurColorR, this.blurColorG, this.blurColorB, this.blurColorA};
            return floatArray;
        }

        public String toString() {
            return "BlurRegion{blurRadius=" + this.blurRadius + ", corners={" + this.cornerRadiusTL + "," + this.cornerRadiusTR + "," + this.cornerRadiusBL + "," + this.cornerRadiusBR + "}, alpha=" + this.alpha + ", rect=" + ((Object) this.rect) + ", blurColor[" + this.blurColorR + " " + this.blurColorG + " " + this.blurColorB + " " + this.blurColorA + "]}";
        }
    }
}
