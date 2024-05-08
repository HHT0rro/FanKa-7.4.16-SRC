package android.view;

import android.graphics.HardwareRenderer;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.Slog;
import android.view.SurfaceControl;
import android.view.View;
import java.util.function.Consumer;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class SyncRtSurfaceTransactionApplier {
    public static final int FLAG_ALL = -1;
    public static final int FLAG_ALPHA = 1;
    public static final int FLAG_BACKGROUND_BLUR_RADIUS = 32;
    public static final int FLAG_CORNER_RADIUS = 16;
    public static final int FLAG_LAYER = 8;
    public static final int FLAG_MATRIX = 2;
    public static final int FLAG_TRANSACTION = 128;
    public static final int FLAG_VISIBILITY = 64;
    public static final int FLAG_WINDOW_CROP = 4;
    private SurfaceControl mTargetSc;
    private final ViewRootImpl mTargetViewRootImpl;
    private final float[] mTmpFloat9 = new float[9];

    public SyncRtSurfaceTransactionApplier(View targetView) {
        this.mTargetViewRootImpl = targetView != null ? targetView.getViewRootImpl() : null;
    }

    public void scheduleApply(SurfaceParams... params) {
        ViewRootImpl viewRootImpl = this.mTargetViewRootImpl;
        if (viewRootImpl == null) {
            return;
        }
        this.mTargetSc = viewRootImpl.getSurfaceControl();
        final SurfaceControl.Transaction t2 = new SurfaceControl.Transaction();
        applyParams(t2, params);
        this.mTargetViewRootImpl.registerRtFrameCallback(new HardwareRenderer.FrameDrawingCallback() { // from class: android.view.SyncRtSurfaceTransactionApplier$$ExternalSyntheticLambda0
            public final void onFrameDraw(long j10) {
                SyncRtSurfaceTransactionApplier.this.lambda$scheduleApply$0(t2, j10);
            }
        });
        this.mTargetViewRootImpl.getView().invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$scheduleApply$0(SurfaceControl.Transaction t2, long frame) {
        SurfaceControl surfaceControl = this.mTargetSc;
        if (surfaceControl != null && surfaceControl.isValid()) {
            applyTransaction(t2, frame);
        }
        t2.close();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void applyParams(SurfaceControl.Transaction t2, SurfaceParams... params) {
        for (int i10 = params.length - 1; i10 >= 0; i10--) {
            SurfaceParams surfaceParams = params[i10];
            SurfaceControl surfaceControl = surfaceParams.surface;
            applyParams(t2, surfaceParams, this.mTmpFloat9);
        }
    }

    void applyTransaction(SurfaceControl.Transaction t2, long frame) {
        ViewRootImpl viewRootImpl = this.mTargetViewRootImpl;
        if (viewRootImpl != null) {
            viewRootImpl.mergeWithNextTransaction(t2, frame);
        } else {
            t2.apply();
        }
    }

    public static void applyParams(SurfaceControl.Transaction t2, SurfaceParams params, float[] tmpFloat9) {
        if (params.surface == null || !params.surface.isValid()) {
            Slog.e("SyncRtSurfaceTransactionApplier", "applyParams error");
            return;
        }
        if ((params.flags & 128) != 0) {
            t2.merge(params.mergeTransaction);
        }
        if ((params.flags & 2) != 0) {
            t2.setMatrix(params.surface, params.matrix, tmpFloat9);
        }
        if ((params.flags & 4) != 0) {
            t2.setWindowCrop(params.surface, params.windowCrop);
        }
        if ((params.flags & 1) != 0) {
            t2.setAlpha(params.surface, params.alpha);
        }
        if ((params.flags & 8) != 0) {
            t2.setLayer(params.surface, params.layer);
        }
        if ((params.flags & 16) != 0) {
            t2.setCornerRadius(params.surface, params.cornerRadius);
        }
        if ((params.flags & 32) != 0) {
            t2.setBackgroundBlurRadius(params.surface, params.backgroundBlurRadius);
        }
        if ((params.flags & 64) != 0) {
            if (params.visible) {
                t2.show(params.surface);
            } else {
                t2.hide(params.surface);
            }
        }
    }

    public static void create(final View targetView, final Consumer<SyncRtSurfaceTransactionApplier> callback) {
        if (targetView == null) {
            callback.accept(null);
        } else if (targetView.getViewRootImpl() != null) {
            callback.accept(new SyncRtSurfaceTransactionApplier(targetView));
        } else {
            targetView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: android.view.SyncRtSurfaceTransactionApplier.1
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View v2) {
                    View.this.removeOnAttachStateChangeListener(this);
                    callback.accept(new SyncRtSurfaceTransactionApplier(View.this));
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View v2) {
                }
            });
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class SurfaceParams {
        public final float alpha;
        public final int backgroundBlurRadius;
        public final float cornerRadius;
        private final int flags;
        public final int layer;
        public final Matrix matrix;
        public final SurfaceControl.Transaction mergeTransaction;
        public final SurfaceControl surface;
        public final boolean visible;
        public final Rect windowCrop;

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
        public static class Builder {
            float alpha;
            int backgroundBlurRadius;
            float cornerRadius;
            int flags;
            int layer;
            Matrix matrix;
            SurfaceControl.Transaction mergeTransaction;
            final SurfaceControl surface;
            boolean visible;
            Rect windowCrop;

            public Builder(SurfaceControl surface) {
                this.surface = surface;
            }

            public Builder withAlpha(float alpha) {
                this.alpha = alpha;
                this.flags |= 1;
                return this;
            }

            public Builder withMatrix(Matrix matrix) {
                this.matrix = new Matrix(matrix);
                this.flags |= 2;
                return this;
            }

            public Builder withWindowCrop(Rect windowCrop) {
                this.windowCrop = new Rect(windowCrop);
                this.flags |= 4;
                return this;
            }

            public Builder withLayer(int layer) {
                this.layer = layer;
                this.flags |= 8;
                return this;
            }

            public Builder withCornerRadius(float radius) {
                this.cornerRadius = radius;
                this.flags |= 16;
                return this;
            }

            public Builder withBackgroundBlur(int radius) {
                this.backgroundBlurRadius = radius;
                this.flags |= 32;
                return this;
            }

            public Builder withVisibility(boolean visible) {
                this.visible = visible;
                this.flags |= 64;
                return this;
            }

            public Builder withMergeTransaction(SurfaceControl.Transaction mergeTransaction) {
                this.mergeTransaction = mergeTransaction;
                this.flags |= 128;
                return this;
            }

            public SurfaceParams build() {
                return new SurfaceParams(this.surface, this.flags, this.alpha, this.matrix, this.windowCrop, this.layer, this.cornerRadius, this.backgroundBlurRadius, this.visible, this.mergeTransaction);
            }
        }

        private SurfaceParams(SurfaceControl surface, int params, float alpha, Matrix matrix, Rect windowCrop, int layer, float cornerRadius, int backgroundBlurRadius, boolean visible, SurfaceControl.Transaction mergeTransaction) {
            this.flags = params;
            this.surface = surface;
            this.alpha = alpha;
            this.matrix = matrix;
            this.windowCrop = windowCrop;
            this.layer = layer;
            this.cornerRadius = cornerRadius;
            this.backgroundBlurRadius = backgroundBlurRadius;
            this.visible = visible;
            this.mergeTransaction = mergeTransaction;
        }
    }
}
