package android.view;

import android.content.Context;
import android.content.res.CompatibilityInfo;
import android.graphics.BLASTBufferQueue;
import android.graphics.BlendMode;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.RenderNode;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.util.ArraySet;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceControl;
import android.view.SurfaceControlViewHost;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.ViewRootImpl;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.IAccessibilityEmbeddedConnection;
import android.window.SurfaceSyncGroup;
import com.android.internal.view.SurfaceCallbackHelper;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Consumer;
import system.ext.loader.core.ExtLoader;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class SurfaceView extends View implements ViewRootImpl.SurfaceChangedCallback {
    private static final int MAX_VALUE = 16384;
    public static final int SURFACE_LIFECYCLE_DEFAULT = 0;
    public static final int SURFACE_LIFECYCLE_FOLLOWS_ATTACHMENT = 2;
    public static final int SURFACE_LIFECYCLE_FOLLOWS_VISIBILITY = 1;
    private static final String TAG = "SurfaceView";
    private final boolean DEBUG;
    private final boolean DEBUG_LOG_ALL;
    private final boolean DEBUG_POSITION;
    float mAlpha;
    private boolean mAttachedToWindow;
    int mBackgroundColor;
    SurfaceControl mBackgroundControl;
    private BLASTBufferQueue mBlastBufferQueue;
    private SurfaceControl mBlastSurfaceControl;
    final ArrayList<SurfaceHolder.Callback> mCallbacks;
    boolean mClipSurfaceToBounds;
    float mCornerRadius;
    private boolean mDisableBackgroundLayer;
    boolean mDrawFinished;
    private final ViewTreeObserver.OnPreDrawListener mDrawListener;
    boolean mDrawingStopped;
    int mFormat;
    private final SurfaceControl.Transaction mFrameCallbackTransaction;
    private boolean mGlobalListenersAdded;
    boolean mHaveFrame;
    boolean mIsCreating;
    long mLastLockTime;
    int mLastSurfaceHeight;
    int mLastSurfaceWidth;
    boolean mLastWindowVisibility;
    final int[] mLocation;
    private int mParentSurfaceSequenceId;
    private SurfaceViewPositionUpdateListener mPositionListener;
    private final Rect mRTLastReportedPosition;
    private RemoteAccessibilityController mRemoteAccessibilityController;
    int mRequestedFormat;
    int mRequestedHeight;
    int mRequestedSubLayer;
    private int mRequestedSurfaceLifecycleStrategy;
    boolean mRequestedVisible;
    int mRequestedWidth;
    Paint mRoundedViewportPaint;
    private final SurfaceControl.Transaction mRtTransaction;
    final Rect mScreenRect;
    private final ViewTreeObserver.OnScrollChangedListener mScrollChangedListener;
    int mSubLayer;
    final Surface mSurface;
    SurfaceControl mSurfaceControl;
    final Object mSurfaceControlLock;
    boolean mSurfaceCreated;
    private int mSurfaceFlags;
    final Rect mSurfaceFrame;
    int mSurfaceHeight;
    private final SurfaceHolder mSurfaceHolder;
    private int mSurfaceLifecycleStrategy;
    final ReentrantLock mSurfaceLock;
    SurfaceControlViewHost.SurfacePackage mSurfacePackage;
    private final SurfaceSession mSurfaceSession;
    private ISurfaceViewExt mSurfaceViewExt;
    private ISurfaceViewSocExt mSurfaceViewSocExt;
    private ISurfaceViewWrapper mSurfaceViewlWrapper;
    int mSurfaceWidth;
    private final ArraySet<SurfaceSyncGroup> mSyncGroups;
    private final Matrix mTmpMatrix;
    final Rect mTmpRect;
    int mTransformHint;
    boolean mViewVisibility;
    boolean mVisible;
    int mWindowSpaceLeft;
    int mWindowSpaceTop;
    boolean mWindowStopped;
    boolean mWindowVisibility;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public @interface SurfaceLifecycleStrategy {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$new$0() {
        this.mHaveFrame = getWidth() > 0 && getHeight() > 0;
        updateSurface();
        return true;
    }

    public SurfaceView(Context context) {
        this(context, null);
    }

    public SurfaceView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SurfaceView(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public SurfaceView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        this(context, attrs, defStyleAttr, defStyleRes, false);
    }

    public SurfaceView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes, boolean disableBackgroundLayer) {
        super(context, attrs, defStyleAttr, defStyleRes);
        boolean z10 = SystemProperties.getBoolean("persist.sys.assert.panic", false);
        this.DEBUG = z10;
        this.DEBUG_POSITION = z10;
        this.DEBUG_LOG_ALL = z10 && SystemProperties.getBoolean("debug.surfaceview.log", false);
        this.mCallbacks = new ArrayList<>();
        this.mLocation = new int[2];
        this.mSurfaceLock = new ReentrantLock(true);
        this.mSurface = new Surface();
        this.mDrawingStopped = true;
        this.mDrawFinished = false;
        this.mScreenRect = new Rect();
        this.mSurfaceSession = new SurfaceSession();
        this.mDisableBackgroundLayer = false;
        this.mRequestedSurfaceLifecycleStrategy = 0;
        this.mSurfaceLifecycleStrategy = 0;
        this.mSurfaceControlLock = new Object();
        this.mTmpRect = new Rect();
        this.mSubLayer = -2;
        this.mRequestedSubLayer = -2;
        this.mIsCreating = false;
        this.mScrollChangedListener = new ViewTreeObserver.OnScrollChangedListener() { // from class: android.view.SurfaceView$$ExternalSyntheticLambda1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public final void onScrollChanged() {
                SurfaceView.this.updateSurface();
            }
        };
        this.mDrawListener = new ViewTreeObserver.OnPreDrawListener() { // from class: android.view.SurfaceView$$ExternalSyntheticLambda2
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public final boolean onPreDraw() {
                boolean lambda$new$0;
                lambda$new$0 = SurfaceView.this.lambda$new$0();
                return lambda$new$0;
            }
        };
        this.mRequestedVisible = false;
        this.mWindowVisibility = false;
        this.mLastWindowVisibility = false;
        this.mViewVisibility = false;
        this.mWindowStopped = false;
        this.mRequestedWidth = -1;
        this.mRequestedHeight = -1;
        this.mRequestedFormat = 4;
        this.mAlpha = 1.0f;
        this.mBackgroundColor = -16777216;
        this.mHaveFrame = false;
        this.mSurfaceCreated = false;
        this.mLastLockTime = 0L;
        this.mVisible = false;
        this.mWindowSpaceLeft = -1;
        this.mWindowSpaceTop = -1;
        this.mSurfaceWidth = -1;
        this.mSurfaceHeight = -1;
        this.mFormat = -1;
        this.mSurfaceFrame = new Rect();
        this.mLastSurfaceWidth = -1;
        this.mLastSurfaceHeight = -1;
        this.mTransformHint = 0;
        this.mSurfaceFlags = 4;
        this.mSyncGroups = new ArraySet<>();
        this.mRtTransaction = new SurfaceControl.Transaction();
        this.mFrameCallbackTransaction = new SurfaceControl.Transaction();
        this.mRemoteAccessibilityController = new RemoteAccessibilityController(this);
        this.mTmpMatrix = new Matrix();
        this.mRTLastReportedPosition = new Rect();
        this.mPositionListener = null;
        this.mSurfaceHolder = new AnonymousClass1();
        this.mSurfaceViewlWrapper = new SurfaceViewImplWrapper();
        this.mSurfaceViewExt = (ISurfaceViewExt) ExtLoader.type(ISurfaceViewExt.class).base(this).create();
        setWillNotDraw(true);
        this.mDisableBackgroundLayer = disableBackgroundLayer;
        this.mSurfaceViewSocExt = (ISurfaceViewSocExt) ExtLoader.type(ISurfaceViewSocExt.class).base(this).create();
    }

    public SurfaceHolder getHolder() {
        return this.mSurfaceHolder;
    }

    private void updateRequestedVisibility() {
        this.mRequestedVisible = this.mViewVisibility && this.mWindowVisibility && !this.mWindowStopped;
    }

    private void setWindowStopped(boolean stopped) {
        if (this.DEBUG) {
            Log.i(TAG, "setWindowStopped,stopped:" + this.mWindowStopped + ",stopped:" + stopped);
        }
        this.mWindowStopped = stopped;
        updateRequestedVisibility();
        updateSurface();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Log.i(TAG, System.identityHashCode(this) + " onAttachedToWindow");
        getViewRootImpl().addSurfaceChangedCallback(this);
        this.mWindowStopped = false;
        this.mViewVisibility = getVisibility() == 0;
        updateRequestedVisibility();
        this.mAttachedToWindow = true;
        this.mParent.requestTransparentRegion(this);
        if (!this.mGlobalListenersAdded) {
            ViewTreeObserver observer = getViewTreeObserver();
            observer.addOnScrollChangedListener(this.mScrollChangedListener);
            observer.addOnPreDrawListener(this.mDrawListener);
            this.mGlobalListenersAdded = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onWindowVisibilityChanged(int visibility) {
        super.onWindowVisibilityChanged(visibility);
        this.mWindowVisibility = visibility == 0;
        updateRequestedVisibility();
        updateSurface();
    }

    @Override // android.view.View
    public void setVisibility(int visibility) {
        super.setVisibility(visibility);
        boolean z10 = visibility == 0;
        this.mViewVisibility = z10;
        boolean newRequestedVisible = this.mWindowVisibility && z10 && !this.mWindowStopped;
        if (newRequestedVisible != this.mRequestedVisible) {
            requestLayout();
        }
        this.mRequestedVisible = newRequestedVisible;
        updateSurface();
    }

    public void setUseAlpha() {
    }

    @Override // android.view.View
    public void setAlpha(float alpha) {
        if (this.DEBUG) {
            Log.d(TAG, System.identityHashCode(this) + " setAlpha: alpha=" + alpha);
        }
        super.setAlpha(alpha);
    }

    @Override // android.view.View
    protected boolean onSetAlpha(int alpha) {
        if (Math.round(this.mAlpha * 255.0f) != alpha) {
            updateSurface();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void performDrawFinished() {
        this.mDrawFinished = true;
        Log.d(TAG, System.identityHashCode(this) + " performDrawFinished mAttachedToWindow " + this.mAttachedToWindow);
        if (this.mAttachedToWindow) {
            this.mParent.requestTransparentRegion(this);
            if (getViewRootImpl() != null) {
                getViewRootImpl().getWrapper().getExtImpl().updateRecordSurfaceViewState(true);
            }
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDetachedFromWindow() {
        ViewRootImpl viewRoot = getViewRootImpl();
        if (viewRoot != null) {
            viewRoot.removeSurfaceChangedCallback(this);
        }
        if (this.DEBUG) {
            Log.i(TAG, "onDetachedFromWindow");
        }
        this.mAttachedToWindow = false;
        if (this.mGlobalListenersAdded) {
            ViewTreeObserver observer = getViewTreeObserver();
            observer.removeOnScrollChangedListener(this.mScrollChangedListener);
            observer.removeOnPreDrawListener(this.mDrawListener);
            this.mGlobalListenersAdded = false;
        }
        if (this.DEBUG) {
            Log.i(TAG, System.identityHashCode(this) + " Detaching SV");
        }
        this.mRequestedVisible = false;
        updateSurface();
        releaseSurfaces(true);
        this.mHaveFrame = false;
        super.onDetachedFromWindow();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width;
        int height;
        int i10 = this.mRequestedWidth;
        if (i10 >= 0) {
            width = resolveSizeAndState(i10, widthMeasureSpec, 0);
        } else {
            width = getDefaultSize(0, widthMeasureSpec);
        }
        int i11 = this.mRequestedHeight;
        if (i11 >= 0) {
            height = resolveSizeAndState(i11, heightMeasureSpec, 0);
        } else {
            height = getDefaultSize(0, heightMeasureSpec);
        }
        setMeasuredDimension(width, height);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public boolean setFrame(int left, int top, int right, int bottom) {
        if (getViewRootImpl() != null) {
            Rect outRec = getViewRootImpl().getWrapper().getExtImpl().adjustSurfaceViewFrameIfNeed(this, new Rect(left, top, right, bottom));
            left = outRec.left;
            top = outRec.top;
            right = outRec.right;
            bottom = outRec.bottom;
        }
        boolean result = super.setFrame(left, top, right, bottom);
        updateSurface();
        return result;
    }

    @Override // android.view.View
    public boolean gatherTransparentRegion(Region region) {
        if (isAboveParent() || !this.mDrawFinished) {
            return super.gatherTransparentRegion(region);
        }
        boolean opaque = true;
        if ((this.mPrivateFlags & 128) == 0) {
            opaque = super.gatherTransparentRegion(region);
        } else if (region != null) {
            int w3 = getWidth();
            int h10 = getHeight();
            if (w3 > 0 && h10 > 0) {
                getLocationInWindow(this.mLocation);
                int[] iArr = this.mLocation;
                int l10 = iArr[0];
                int t2 = iArr[1];
                region.op(l10, t2, l10 + w3, t2 + h10, Region.Op.UNION);
            }
        }
        if (PixelFormat.formatHasAlpha(this.mRequestedFormat)) {
            return false;
        }
        return opaque;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Log.d(TAG, System.identityHashCode(this) + " draw mDrawFinished " + this.mDrawFinished + " isAboveParent " + isAboveParent() + " (mPrivateFlags & PFLAG_SKIP_DRAW) " + (this.mPrivateFlags & 128));
        if (this.mDrawFinished && !isAboveParent() && (this.mPrivateFlags & 128) == 0) {
            clearSurfaceViewPort(canvas);
        }
        super.draw(canvas);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void dispatchDraw(Canvas canvas) {
        Log.d(TAG, System.identityHashCode(this) + " dispatchDraw mDrawFinished " + this.mDrawFinished + " isAboveParent " + isAboveParent() + " (mPrivateFlags & PFLAG_SKIP_DRAW) " + (this.mPrivateFlags & 128));
        if (this.mDrawFinished && !isAboveParent() && (this.mPrivateFlags & 128) == 128) {
            clearSurfaceViewPort(canvas);
        }
        super.dispatchDraw(canvas);
    }

    public void setEnableSurfaceClipping(boolean enabled) {
        this.mClipSurfaceToBounds = enabled;
        invalidate();
    }

    @Override // android.view.View
    public void setClipBounds(Rect clipBounds) {
        super.setClipBounds(clipBounds);
        if (!this.mClipSurfaceToBounds || this.mSurfaceControl == null) {
            return;
        }
        if (this.mCornerRadius > 0.0f && !isAboveParent()) {
            invalidate();
        }
        if (this.mClipBounds != null) {
            this.mTmpRect.set(this.mClipBounds);
        } else {
            this.mTmpRect.set(0, 0, this.mSurfaceWidth, this.mSurfaceHeight);
        }
        if (this.DEBUG) {
            if (clipBounds != null) {
                Log.v(TAG, String.format("%d setClipBounds([%d %d %d %d])", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(clipBounds.left), Integer.valueOf(clipBounds.top), Integer.valueOf(clipBounds.right), Integer.valueOf(clipBounds.bottom)));
            } else {
                Log.v(TAG, String.format("%d setClipBounds, clipBounds is null", Integer.valueOf(System.identityHashCode(this))));
            }
            Log.v(TAG, String.format("%d setWindowCrop([%d %d %d %d]) in setClipBounds()", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(this.mTmpRect.left), Integer.valueOf(this.mTmpRect.top), Integer.valueOf(this.mTmpRect.right), Integer.valueOf(this.mTmpRect.bottom)));
        }
        SurfaceControl.Transaction transaction = new SurfaceControl.Transaction();
        transaction.setWindowCrop(this.mSurfaceControl, this.mTmpRect);
        applyTransactionOnVriDraw(transaction);
        invalidate();
    }

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return false;
    }

    private void clearSurfaceViewPort(Canvas canvas) {
        Log.d(TAG, System.identityHashCode(this) + " clearSurfaceViewPort mCornerRadius " + this.mCornerRadius);
        float alpha = getAlpha();
        if (this.mCornerRadius > 0.0f) {
            canvas.getClipBounds(this.mTmpRect);
            if (this.mClipSurfaceToBounds && this.mClipBounds != null) {
                this.mTmpRect.intersect(this.mClipBounds);
            }
            float f10 = this.mTmpRect.left;
            float f11 = this.mTmpRect.top;
            float f12 = this.mTmpRect.right;
            float f13 = this.mTmpRect.bottom;
            float f14 = this.mCornerRadius;
            canvas.punchHole(f10, f11, f12, f13, f14, f14, alpha);
            return;
        }
        canvas.punchHole(0.0f, 0.0f, getWidth(), getHeight(), 0.0f, 0.0f, alpha);
    }

    public void setCornerRadius(float cornerRadius) {
        this.mCornerRadius = cornerRadius;
        if (cornerRadius > 0.0f && this.mRoundedViewportPaint == null) {
            Paint paint = new Paint(1);
            this.mRoundedViewportPaint = paint;
            paint.setBlendMode(BlendMode.CLEAR);
            this.mRoundedViewportPaint.setColor(0);
        }
        invalidate();
    }

    public float getCornerRadius() {
        return this.mCornerRadius;
    }

    public void setZOrderMediaOverlay(boolean isMediaOverlay) {
        this.mRequestedSubLayer = isMediaOverlay ? -1 : -2;
    }

    public void setZOrderOnTop(boolean onTop) {
        boolean allowDynamicChange = getContext().getApplicationInfo().targetSdkVersion > 29;
        setZOrderedOnTop(onTop, allowDynamicChange);
    }

    public boolean isZOrderedOnTop() {
        return this.mRequestedSubLayer > 0;
    }

    public boolean setZOrderedOnTop(boolean onTop, boolean allowDynamicChange) {
        int subLayer;
        if (onTop) {
            subLayer = 1;
        } else {
            subLayer = -2;
        }
        if (this.mRequestedSubLayer == subLayer) {
            return false;
        }
        this.mRequestedSubLayer = subLayer;
        if (!allowDynamicChange) {
            return false;
        }
        if (this.mSurfaceControl == null) {
            return true;
        }
        ViewRootImpl viewRoot = getViewRootImpl();
        if (viewRoot == null) {
            return true;
        }
        updateSurface();
        invalidate();
        return true;
    }

    public void setSecure(boolean isSecure) {
        if (isSecure) {
            this.mSurfaceFlags |= 128;
        } else {
            this.mSurfaceFlags &= -129;
        }
    }

    public void setProtected(boolean isProtected) {
        if (isProtected) {
            this.mSurfaceFlags |= 2048;
        } else {
            this.mSurfaceFlags &= -2049;
        }
    }

    public void setSurfaceLifecycle(int lifecycleStrategy) {
        this.mRequestedSurfaceLifecycleStrategy = lifecycleStrategy;
        updateSurface();
    }

    private void updateOpaqueFlag() {
        if (!PixelFormat.formatHasAlpha(this.mRequestedFormat)) {
            this.mSurfaceFlags |= 1024;
        } else {
            this.mSurfaceFlags &= -1025;
        }
    }

    private void updateBackgroundVisibility(SurfaceControl.Transaction t2) {
        SurfaceControl surfaceControl = this.mBackgroundControl;
        if (surfaceControl == null) {
            return;
        }
        if (this.mSubLayer < 0 && (this.mSurfaceFlags & 1024) != 0 && !this.mDisableBackgroundLayer) {
            t2.show(surfaceControl);
        } else if (getViewRootImpl() != null && getViewRootImpl().getWrapper().getExtImpl().showSurfaceViewBackground(this.mSubLayer)) {
            t2.show(this.mBackgroundControl);
        } else {
            t2.hide(this.mBackgroundControl);
        }
    }

    private SurfaceControl.Transaction updateBackgroundColor(SurfaceControl.Transaction t2) {
        float[] colorComponents = {Color.red(this.mBackgroundColor) / 255.0f, Color.green(this.mBackgroundColor) / 255.0f, Color.blue(this.mBackgroundColor) / 255.0f};
        t2.setColor(this.mBackgroundControl, colorComponents);
        return t2;
    }

    private void releaseSurfaces(boolean releaseSurfacePackage) {
        SurfaceControlViewHost.SurfacePackage surfacePackage;
        this.mAlpha = 1.0f;
        this.mSurface.destroy();
        if (this.mSurfaceLock.isLocked()) {
            Log.w(TAG, "releaseSurfaces, but mSurfaceLock is locked, holded by " + this.mSurfaceLock.toString());
        }
        synchronized (this.mSurfaceControlLock) {
            this.mSurface.destroy();
            BLASTBufferQueue bLASTBufferQueue = this.mBlastBufferQueue;
            if (bLASTBufferQueue != null) {
                bLASTBufferQueue.destroy();
                this.mBlastBufferQueue = null;
            }
            SurfaceControl.Transaction transaction = new SurfaceControl.Transaction();
            SurfaceControl surfaceControl = this.mSurfaceControl;
            if (surfaceControl != null) {
                transaction.remove(surfaceControl);
                this.mSurfaceControl = null;
            }
            SurfaceControl surfaceControl2 = this.mBackgroundControl;
            if (surfaceControl2 != null) {
                transaction.remove(surfaceControl2);
                this.mBackgroundControl = null;
            }
            SurfaceControl surfaceControl3 = this.mBlastSurfaceControl;
            if (surfaceControl3 != null) {
                transaction.remove(surfaceControl3);
                this.mBlastSurfaceControl = null;
            }
            if (releaseSurfacePackage && (surfacePackage = this.mSurfacePackage) != null) {
                surfacePackage.release();
                this.mSurfacePackage = null;
            }
            applyTransactionOnVriDraw(transaction);
        }
    }

    private void replacePositionUpdateListener(int surfaceWidth, int surfaceHeight) {
        if (this.mPositionListener != null) {
            this.mRenderNode.removePositionUpdateListener(this.mPositionListener);
        }
        this.mPositionListener = new SurfaceViewPositionUpdateListener(surfaceWidth, surfaceHeight);
        this.mRenderNode.addPositionUpdateListener(this.mPositionListener);
    }

    private boolean performSurfaceTransaction(ViewRootImpl viewRoot, CompatibilityInfo.Translator translator, boolean creating, boolean sizeChanged, boolean hintChanged, boolean relativeZChanged, SurfaceControl.Transaction surfaceUpdateTransaction) {
        char c4;
        char c10;
        this.mSurfaceLock.lock();
        try {
            boolean z10 = true;
            this.mDrawingStopped = !surfaceShouldExist();
            if (this.DEBUG) {
                Log.i(TAG, System.identityHashCode(this) + " Cur surface: " + ((Object) this.mSurface));
            }
            if (creating) {
                updateRelativeZ(surfaceUpdateTransaction);
                SurfaceControlViewHost.SurfacePackage surfacePackage = this.mSurfacePackage;
                if (surfacePackage != null) {
                    reparentSurfacePackage(surfaceUpdateTransaction, surfacePackage);
                }
            }
            this.mParentSurfaceSequenceId = viewRoot.getSurfaceSequenceId();
            if (!isHardwareAccelerated()) {
                if (this.mViewVisibility) {
                    surfaceUpdateTransaction.show(this.mSurfaceControl);
                } else {
                    surfaceUpdateTransaction.hide(this.mSurfaceControl);
                }
            }
            updateBackgroundVisibility(surfaceUpdateTransaction);
            updateBackgroundColor(surfaceUpdateTransaction);
            if (isAboveParent()) {
                float alpha = getAlpha();
                surfaceUpdateTransaction.setAlpha(this.mSurfaceControl, alpha);
            }
            if (relativeZChanged) {
                if (!isAboveParent()) {
                    surfaceUpdateTransaction.setAlpha(this.mSurfaceControl, 1.0f);
                }
                updateRelativeZ(surfaceUpdateTransaction);
            }
            if (this.mSurfaceViewlWrapper.getExtImpl().isShowSurfaceCornerRadius()) {
                surfaceUpdateTransaction.setCornerRadius(this.mSurfaceControl, this.mCornerRadius);
            }
            if ((sizeChanged || hintChanged) && !creating) {
                setBufferSize(surfaceUpdateTransaction);
            }
            if (sizeChanged || creating || !isHardwareAccelerated()) {
                if (this.mClipSurfaceToBounds && this.mClipBounds != null) {
                    if (this.DEBUG) {
                        Log.v(TAG, String.format("%d setWindowCrop([%d %d %d %d]) in performSurfaceTransaction()", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(this.mClipBounds.left), Integer.valueOf(this.mClipBounds.top), Integer.valueOf(this.mClipBounds.right), Integer.valueOf(this.mClipBounds.bottom)));
                    }
                    surfaceUpdateTransaction.setWindowCrop(this.mSurfaceControl, this.mClipBounds);
                } else {
                    if (this.DEBUG) {
                        Log.v(TAG, String.format("%d setWindowCrop(w=%d, h=%d) in performSurfaceTransaction()", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(this.mSurfaceWidth), Integer.valueOf(this.mSurfaceHeight)));
                    }
                    surfaceUpdateTransaction.setWindowCrop(this.mSurfaceControl, this.mSurfaceWidth, this.mSurfaceHeight);
                }
                surfaceUpdateTransaction.setDesintationFrame(this.mBlastSurfaceControl, this.mSurfaceWidth, this.mSurfaceHeight);
                if (isHardwareAccelerated()) {
                    replacePositionUpdateListener(this.mSurfaceWidth, this.mSurfaceHeight);
                    c4 = 3;
                    c10 = 5;
                } else {
                    c4 = 3;
                    c10 = 5;
                    onSetSurfacePositionAndScale(surfaceUpdateTransaction, this.mSurfaceControl, this.mScreenRect.left, this.mScreenRect.top, this.mScreenRect.width() / this.mSurfaceWidth, this.mScreenRect.height() / this.mSurfaceHeight);
                }
                if (this.DEBUG_POSITION) {
                    Object[] objArr = new Object[8];
                    objArr[0] = Integer.valueOf(System.identityHashCode(this));
                    objArr[1] = isHardwareAccelerated() ? "RenderWorker" : "UI Thread";
                    objArr[2] = Integer.valueOf(this.mScreenRect.left);
                    objArr[c4] = Integer.valueOf(this.mScreenRect.top);
                    objArr[4] = Integer.valueOf(this.mScreenRect.right);
                    objArr[c10] = Integer.valueOf(this.mScreenRect.bottom);
                    objArr[6] = Integer.valueOf(this.mSurfaceWidth);
                    objArr[7] = Integer.valueOf(this.mSurfaceHeight);
                    Log.d(TAG, String.format("%d performSurfaceTransaction %s position = [%d, %d, %d, %d] surfaceSize = %dx%d", objArr));
                }
            }
            applyTransactionOnVriDraw(surfaceUpdateTransaction);
            updateEmbeddedAccessibilityMatrix(false);
            this.mSurfaceFrame.left = 0;
            this.mSurfaceFrame.top = 0;
            if (translator == null) {
                this.mSurfaceFrame.right = this.mSurfaceWidth;
                this.mSurfaceFrame.bottom = this.mSurfaceHeight;
            } else {
                float appInvertedScale = translator.applicationInvertedScale;
                this.mSurfaceFrame.right = (int) ((this.mSurfaceWidth * appInvertedScale) + 0.5f);
                this.mSurfaceFrame.bottom = (int) ((this.mSurfaceHeight * appInvertedScale) + 0.5f);
            }
            int surfaceWidth = this.mSurfaceFrame.right;
            int surfaceHeight = this.mSurfaceFrame.bottom;
            if (this.mLastSurfaceWidth == surfaceWidth && this.mLastSurfaceHeight == surfaceHeight) {
                z10 = false;
            }
            boolean realSizeChanged = z10;
            this.mLastSurfaceWidth = surfaceWidth;
            this.mLastSurfaceHeight = surfaceHeight;
            return realSizeChanged;
        } finally {
            this.mSurfaceLock.unlock();
        }
    }

    private boolean requiresSurfaceControlCreation(boolean formatChanged, boolean visibleChanged) {
        return this.mSurfaceLifecycleStrategy == 2 ? (this.mSurfaceControl == null || formatChanged) && this.mAttachedToWindow : (this.mSurfaceControl == null || formatChanged || visibleChanged) && this.mRequestedVisible;
    }

    private boolean surfaceShouldExist() {
        boolean respectVisibility = this.mSurfaceLifecycleStrategy != 2;
        if (this.mVisible) {
            return true;
        }
        return !respectVisibility && this.mAttachedToWindow;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't wrap try/catch for region: R(53:16|(1:18)|19|(1:21)|22|(1:24)|25|(1:27)(1:364)|28|(1:30)(1:363)|31|(1:33)(1:362)|34|(1:361)(1:38)|39|(1:41)(1:360)|42|(1:359)(1:46)|47|(1:358)(1:51)|52|(1:357)(1:56)|57|(1:59)(1:356)|60|(1:62)(1:355)|63|(1:354)(2:66|(2:78|79))|80|(5:82|(1:84)(1:352)|85|(1:87)(1:351)|88)(1:353)|(7:89|90|(5:337|338|339|340|341)(1:92)|93|94|95|(7:96|97|98|99|100|101|(9:305|306|(3:320|321|322)|308|309|310|311|(2:315|(1:317))|318)(4:103|104|105|(1:107))))|(11:(31:118|119|(2:123|(26:125|126|(6:285|286|287|288|289|290)(1:128)|129|130|131|132|133|134|(1:136)(1:277)|137|(1:139)(1:276)|140|(1:275)(1:143)|144|(2:(2:(2:153|154)|(2:149|(1:(0))))|164)|166|167|168|(1:271)(4:172|(5:177|178|(2:180|181)|183|184)|(9:229|(14:243|244|245|246|247|248|249|250|251|252|253|254|255|256)(1:231)|(2:233|234)|235|236|237|(2:239|240)|241|242)(1:194)|(6:196|(1:198)|(2:200|201)|205|(2:207|208)(1:223)|209)(1:228))|210|211|(1:215)|216|217|(2:219|220)(1:221)))|300|126|(0)(0)|129|130|131|132|133|134|(0)(0)|137|(0)(0)|140|(0)|275|144|(0)|166|167|168|(1:170)|271|210|211|(2:213|215)|216|217|(0)(0))|167|168|(0)|271|210|211|(0)|216|217|(0)(0))|301|119|(3:121|123|(0))|300|126|(0)(0)|129|130|131|132|133|134|(0)(0)|137|(0)(0)|140|(0)|275|144|(0)|166) */
    /* JADX WARN: Can't wrap try/catch for region: R(59:16|(1:18)|19|(1:21)|22|(1:24)|25|(1:27)(1:364)|28|(1:30)(1:363)|31|(1:33)(1:362)|34|(1:361)(1:38)|39|(1:41)(1:360)|42|(1:359)(1:46)|47|(1:358)(1:51)|52|(1:357)(1:56)|57|(1:59)(1:356)|60|(1:62)(1:355)|63|(1:354)(2:66|(2:78|79))|80|(5:82|(1:84)(1:352)|85|(1:87)(1:351)|88)(1:353)|89|90|(5:337|338|339|340|341)(1:92)|93|94|95|(7:96|97|98|99|100|101|(9:305|306|(3:320|321|322)|308|309|310|311|(2:315|(1:317))|318)(4:103|104|105|(1:107)))|(11:(31:118|119|(2:123|(26:125|126|(6:285|286|287|288|289|290)(1:128)|129|130|131|132|133|134|(1:136)(1:277)|137|(1:139)(1:276)|140|(1:275)(1:143)|144|(2:(2:(2:153|154)|(2:149|(1:(0))))|164)|166|167|168|(1:271)(4:172|(5:177|178|(2:180|181)|183|184)|(9:229|(14:243|244|245|246|247|248|249|250|251|252|253|254|255|256)(1:231)|(2:233|234)|235|236|237|(2:239|240)|241|242)(1:194)|(6:196|(1:198)|(2:200|201)|205|(2:207|208)(1:223)|209)(1:228))|210|211|(1:215)|216|217|(2:219|220)(1:221)))|300|126|(0)(0)|129|130|131|132|133|134|(0)(0)|137|(0)(0)|140|(0)|275|144|(0)|166|167|168|(1:170)|271|210|211|(2:213|215)|216|217|(0)(0))|167|168|(0)|271|210|211|(0)|216|217|(0)(0))|301|119|(3:121|123|(0))|300|126|(0)(0)|129|130|131|132|133|134|(0)(0)|137|(0)(0)|140|(0)|275|144|(0)|166) */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x0411, code lost:
    
        if (r5 != false) goto L208;
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x0407, code lost:
    
        if (r40.mAttachedToWindow != false) goto L203;
     */
    /* JADX WARN: Code restructure failed: missing block: B:278:0x05f5, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:283:0x05f8, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:284:0x05f9, code lost:
    
        r1 = " h=";
        r8 = " w=";
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:125:0x035f  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x03b7  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x03ec  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x03f2  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x03f8 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0401  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x05eb A[Catch: Exception -> 0x05f5, TryCatch #9 {Exception -> 0x05f5, blocks: (B:158:0x05e4, B:160:0x05eb, B:162:0x05ef, B:163:0x05f4, B:211:0x05b7, B:213:0x05bd, B:215:0x05c1), top: B:133:0x03e7 }] */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0436 A[Catch: all -> 0x05c7, TryCatch #3 {all -> 0x05c7, blocks: (B:168:0x042d, B:170:0x0436, B:172:0x043e, B:229:0x04b7), top: B:167:0x042d }] */
    /* JADX WARN: Removed duplicated region for block: B:213:0x05bd A[Catch: Exception -> 0x05f5, TryCatch #9 {Exception -> 0x05f5, blocks: (B:158:0x05e4, B:160:0x05eb, B:162:0x05ef, B:163:0x05f4, B:211:0x05b7, B:213:0x05bd, B:215:0x05c1), top: B:133:0x03e7 }] */
    /* JADX WARN: Removed duplicated region for block: B:219:0x0675  */
    /* JADX WARN: Removed duplicated region for block: B:221:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:276:0x03f4  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x03ee  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x0379 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r40v0, types: [android.view.SurfaceView, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v14, types: [android.view.SurfaceControl$Transaction] */
    /* JADX WARN: Type inference failed for: r8v15 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v36 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void updateSurface() {
        /*
            Method dump skipped, instructions count: 1804
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.view.SurfaceView.updateSurface():void");
    }

    public String getName() {
        ViewRootImpl viewRoot = getViewRootImpl();
        String viewRootName = viewRoot == null ? "detached" : viewRoot.getTitle().toString();
        return "SurfaceView[" + viewRootName + "]";
    }

    private void handleSyncBufferCallback(SurfaceHolder.Callback[] callbacks, final SyncBufferTransactionCallback syncBufferTransactionCallback) {
        Log.d(TAG, System.identityHashCode(this) + " handleSyncBufferCallback");
        final SurfaceSyncGroup surfaceSyncGroup = new SurfaceSyncGroup(getName());
        getViewRootImpl().addToSync(surfaceSyncGroup);
        if (this.mSurfaceViewExt.shouldDelaySync()) {
            getViewRootImpl().getWrapper().addToWmsSync(surfaceSyncGroup);
        }
        redrawNeededAsync(callbacks, new Runnable() { // from class: android.view.SurfaceView$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                SurfaceView.this.lambda$handleSyncBufferCallback$1(syncBufferTransactionCallback, surfaceSyncGroup);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleSyncBufferCallback$1(SyncBufferTransactionCallback syncBufferTransactionCallback, SurfaceSyncGroup surfaceSyncGroup) {
        SurfaceControl.Transaction t2 = null;
        BLASTBufferQueue bLASTBufferQueue = this.mBlastBufferQueue;
        if (bLASTBufferQueue != null) {
            bLASTBufferQueue.stopContinuousSyncTransaction();
            t2 = syncBufferTransactionCallback.waitForTransaction();
        }
        surfaceSyncGroup.addTransaction(t2);
        surfaceSyncGroup.markSyncReady();
        onDrawFinished();
    }

    private void handleSyncNoBuffer(SurfaceHolder.Callback[] callbacks) {
        Log.d(TAG, System.identityHashCode(this) + " handleSyncNoBuffer");
        final SurfaceSyncGroup surfaceSyncGroup = new SurfaceSyncGroup(getName());
        synchronized (this.mSyncGroups) {
            this.mSyncGroups.add(surfaceSyncGroup);
            if (this.mSurfaceViewExt.shouldDelaySync()) {
                getViewRootImpl().getWrapper().addToWmsSync(surfaceSyncGroup);
            }
        }
        redrawNeededAsync(callbacks, new Runnable() { // from class: android.view.SurfaceView$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                SurfaceView.this.lambda$handleSyncNoBuffer$2(surfaceSyncGroup);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleSyncNoBuffer$2(SurfaceSyncGroup surfaceSyncGroup) {
        synchronized (this.mSyncGroups) {
            this.mSyncGroups.remove(surfaceSyncGroup);
        }
        if (this.mSurfaceViewExt.shouldDelaySync()) {
            this.mSurfaceViewExt.onDrawFinishedWithSync(surfaceSyncGroup);
        } else {
            surfaceSyncGroup.markSyncReady();
            onDrawFinished();
        }
    }

    private void redrawNeededAsync(SurfaceHolder.Callback[] callbacks, Runnable callbacksCollected) {
        SurfaceCallbackHelper sch = new SurfaceCallbackHelper(callbacksCollected);
        sch.dispatchSurfaceRedrawNeededAsync(this.mSurfaceHolder, callbacks);
    }

    @Override // android.view.ViewRootImpl.SurfaceChangedCallback
    public void vriDrawStarted(boolean isWmSync) {
        ViewRootImpl viewRoot = getViewRootImpl();
        synchronized (this.mSyncGroups) {
            if (isWmSync && viewRoot != null) {
                Iterator<SurfaceSyncGroup> it = this.mSyncGroups.iterator();
                while (it.hasNext()) {
                    SurfaceSyncGroup syncGroup = it.next();
                    viewRoot.addToSync(syncGroup);
                }
            }
            this.mSyncGroups.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class SyncBufferTransactionCallback {
        private final CountDownLatch mCountDownLatch;
        private SurfaceControl.Transaction mTransaction;

        private SyncBufferTransactionCallback() {
            this.mCountDownLatch = new CountDownLatch(1);
        }

        SurfaceControl.Transaction waitForTransaction() {
            try {
                this.mCountDownLatch.await();
            } catch (InterruptedException e2) {
            }
            return this.mTransaction;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void onTransactionReady(SurfaceControl.Transaction t2) {
            this.mTransaction = t2;
            this.mCountDownLatch.countDown();
        }
    }

    private void copySurface(boolean surfaceControlCreated, boolean bufferSizeChanged) {
        BLASTBufferQueue bLASTBufferQueue;
        if (surfaceControlCreated) {
            this.mSurface.copyFrom(this.mBlastBufferQueue);
        }
        if (bufferSizeChanged && getContext().getApplicationInfo().targetSdkVersion < 26 && (bLASTBufferQueue = this.mBlastBufferQueue) != null) {
            this.mSurface.transferFrom(bLASTBufferQueue.createSurfaceWithHandle());
        }
    }

    private void setBufferSize(SurfaceControl.Transaction transaction) {
        if (this.mSurfaceWidth > 16384 || this.mSurfaceHeight > 16384) {
            Log.d(TAG, ((Object) this) + " mSurfaceWidth = " + this.mSurfaceWidth + " mSurfaceHeight = " + this.mSurfaceHeight);
            throw new IllegalStateException("SurfaceView width and height must be smaller than 16384");
        }
        this.mBlastSurfaceControl.setTransformHint(this.mTransformHint);
        BLASTBufferQueue bLASTBufferQueue = this.mBlastBufferQueue;
        if (bLASTBufferQueue != null) {
            bLASTBufferQueue.update(this.mBlastSurfaceControl, this.mSurfaceWidth, this.mSurfaceHeight, this.mFormat);
        }
    }

    private void createBlastSurfaceControls(ViewRootImpl viewRoot, String name, SurfaceControl.Transaction surfaceUpdateTransaction) {
        if (this.mSurfaceControl == null) {
            this.mSurfaceControl = new SurfaceControl.Builder(this.mSurfaceSession).setName(name).setLocalOwnerView(this).setParent(viewRoot.getBoundsLayer()).setCallsite("SurfaceView.updateSurface").setContainerLayer().build();
        }
        SurfaceControl surfaceControl = this.mBlastSurfaceControl;
        if (surfaceControl == null) {
            this.mBlastSurfaceControl = new SurfaceControl.Builder(this.mSurfaceSession).setName(name + "(BLAST)").setLocalOwnerView(this).setParent(this.mSurfaceControl).setFlags(this.mSurfaceFlags).setHidden(false).setBLASTLayer().setCallsite("SurfaceView.updateSurface").build();
        } else {
            surfaceUpdateTransaction.setOpaque(surfaceControl, (this.mSurfaceFlags & 1024) != 0).setSecure(this.mBlastSurfaceControl, (this.mSurfaceFlags & 128) != 0).show(this.mBlastSurfaceControl);
        }
        if (this.mBackgroundControl == null) {
            this.mBackgroundControl = new SurfaceControl.Builder(this.mSurfaceSession).setName("Background for " + name).setLocalOwnerView(this).setOpaque(true).setColorLayer().setParent(this.mSurfaceControl).setCallsite("SurfaceView.updateSurface").build();
        }
        BLASTBufferQueue bLASTBufferQueue = this.mBlastBufferQueue;
        if (bLASTBufferQueue != null) {
            bLASTBufferQueue.destroy();
        }
        int bufferTransformHint = viewRoot.getBufferTransformHint();
        this.mTransformHint = bufferTransformHint;
        this.mBlastSurfaceControl.setTransformHint(bufferTransformHint);
        BLASTBufferQueue bLASTBufferQueue2 = new BLASTBufferQueue(name, false);
        this.mBlastBufferQueue = bLASTBufferQueue2;
        bLASTBufferQueue2.update(this.mBlastSurfaceControl, this.mSurfaceWidth, this.mSurfaceHeight, this.mFormat);
        this.mBlastBufferQueue.setTransactionHangCallback(ViewRootImpl.sTransactionHangCallback);
    }

    private void onDrawFinished() {
        Log.d(TAG, System.identityHashCode(this) + " finishedDrawing");
        runOnUiThread(new Runnable() { // from class: android.view.SurfaceView$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                SurfaceView.this.performDrawFinished();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onSetSurfacePositionAndScale(SurfaceControl.Transaction transaction, SurfaceControl surface, int positionLeft, int positionTop, float postScaleX, float postScaleY) {
        if (this.DEBUG) {
            Log.v(TAG, System.identityHashCode(this) + " onSetSurfacePositionAndScale() , positionLeft=" + positionLeft + ", positionTop=" + positionTop + ", postScaleX=" + postScaleX + ", postScaleY=" + postScaleY);
        }
        transaction.setPosition(surface, positionLeft, positionTop);
        transaction.setMatrix(surface, postScaleX, 0.0f, 0.0f, postScaleY);
    }

    public void requestUpdateSurfacePositionAndScale() {
        if (this.mSurfaceControl == null) {
            return;
        }
        SurfaceControl.Transaction transaction = new SurfaceControl.Transaction();
        onSetSurfacePositionAndScale(transaction, this.mSurfaceControl, this.mScreenRect.left, this.mScreenRect.top, this.mScreenRect.width() / this.mSurfaceWidth, this.mScreenRect.height() / this.mSurfaceHeight);
        applyTransactionOnVriDraw(transaction);
        invalidate();
    }

    public Rect getSurfaceRenderPosition() {
        return this.mRTLastReportedPosition;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void applyOrMergeTransaction(SurfaceControl.Transaction t2, long frameNumber) {
        ViewRootImpl viewRoot = getViewRootImpl();
        if (viewRoot != null) {
            viewRoot.mergeWithNextTransaction(t2, frameNumber);
        } else {
            t2.apply();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public class SurfaceViewPositionUpdateListener implements RenderNode.PositionUpdateListener {
        private final SurfaceControl.Transaction mPositionChangedTransaction = new SurfaceControl.Transaction();
        private final int mRtSurfaceHeight;
        private final int mRtSurfaceWidth;

        SurfaceViewPositionUpdateListener(int surfaceWidth, int surfaceHeight) {
            this.mRtSurfaceWidth = surfaceWidth;
            this.mRtSurfaceHeight = surfaceHeight;
        }

        public void positionChanged(long frameNumber, int left, int top, int right, int bottom) {
            try {
                if (SurfaceView.this.DEBUG_POSITION) {
                    Log.d(SurfaceView.TAG, String.format("%d updateSurfacePosition RenderWorker, frameNr = %d, position = [%d, %d, %d, %d] surfaceSize = %dx%d", Integer.valueOf(System.identityHashCode(SurfaceView.this)), Long.valueOf(frameNumber), Integer.valueOf(left), Integer.valueOf(top), Integer.valueOf(right), Integer.valueOf(bottom), Integer.valueOf(this.mRtSurfaceWidth), Integer.valueOf(this.mRtSurfaceHeight)));
                }
                synchronized (SurfaceView.this.mSurfaceControlLock) {
                    if (SurfaceView.this.mSurfaceControl != null && SurfaceView.this.mSurfaceControl.mNativeObject != 0) {
                        SurfaceView.this.mRTLastReportedPosition.set(left, top, right, bottom);
                        SurfaceView surfaceView = SurfaceView.this;
                        surfaceView.onSetSurfacePositionAndScale(this.mPositionChangedTransaction, surfaceView.mSurfaceControl, SurfaceView.this.mRTLastReportedPosition.left, SurfaceView.this.mRTLastReportedPosition.top, SurfaceView.this.mRTLastReportedPosition.width() / this.mRtSurfaceWidth, SurfaceView.this.mRTLastReportedPosition.height() / this.mRtSurfaceHeight);
                        this.mPositionChangedTransaction.show(SurfaceView.this.mSurfaceControl);
                        SurfaceView.this.applyOrMergeTransaction(this.mPositionChangedTransaction, frameNumber);
                        return;
                    }
                    if (SurfaceView.this.mSurfaceControl == null) {
                        Log.d(SurfaceView.TAG, System.identityHashCode(this) + "positionChanged mSurfaceControl is null return;");
                    } else if (SurfaceView.this.mSurfaceControl.mNativeObject == 0) {
                        Log.d(SurfaceView.TAG, System.identityHashCode(this) + "positionChanged mSurfaceControl.mNativeObject is 0 return;");
                    }
                }
            } catch (Exception ex) {
                Log.e(SurfaceView.TAG, "Exception from repositionChild", ex);
            }
        }

        public void applyStretch(long frameNumber, float width, float height, float vecX, float vecY, float maxStretchX, float maxStretchY, float childRelativeLeft, float childRelativeTop, float childRelativeRight, float childRelativeBottom) {
            SurfaceView.this.mRtTransaction.setStretchEffect(SurfaceView.this.mSurfaceControl, width, height, vecX, vecY, maxStretchX, maxStretchY, childRelativeLeft, childRelativeTop, childRelativeRight, childRelativeBottom);
            SurfaceView surfaceView = SurfaceView.this;
            surfaceView.applyOrMergeTransaction(surfaceView.mRtTransaction, frameNumber);
        }

        public void positionLost(long frameNumber) {
            if (SurfaceView.this.DEBUG_POSITION) {
                Log.d(SurfaceView.TAG, String.format("%d windowPositionLost, frameNr = %d", Integer.valueOf(System.identityHashCode(SurfaceView.this)), Long.valueOf(frameNumber)));
            }
            SurfaceView.this.mRTLastReportedPosition.setEmpty();
            synchronized (SurfaceView.this.mSurfaceControlLock) {
                if (SurfaceView.this.mSurfaceControl != null && SurfaceView.this.mSurfaceControl.mNativeObject != 0) {
                    SurfaceView.this.mRtTransaction.hide(SurfaceView.this.mSurfaceControl);
                    SurfaceView surfaceView = SurfaceView.this;
                    surfaceView.applyOrMergeTransaction(surfaceView.mRtTransaction, frameNumber);
                    return;
                }
                if (SurfaceView.this.mSurfaceControl == null) {
                    Log.d(SurfaceView.TAG, System.identityHashCode(this) + "positionLost mSurfaceControl is null return;");
                } else if (SurfaceView.this.mSurfaceControl.mNativeObject == 0 || SurfaceView.this.mBackgroundControl.mNativeObject == 0) {
                    Log.d(SurfaceView.TAG, System.identityHashCode(this) + "positionLost mSurfaceControl.mNativeObject or mBackgroundControl.mNativeObject is 0 return;");
                }
            }
        }
    }

    private SurfaceHolder.Callback[] getSurfaceCallbacks() {
        SurfaceHolder.Callback[] callbacks;
        synchronized (this.mCallbacks) {
            callbacks = new SurfaceHolder.Callback[this.mCallbacks.size()];
            this.mCallbacks.toArray(callbacks);
        }
        return callbacks;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runOnUiThread(Runnable runnable) {
        Handler handler = getHandler();
        if (handler != null && handler.getLooper() != Looper.myLooper()) {
            handler.post(runnable);
        } else {
            runnable.run();
        }
    }

    public boolean isFixedSize() {
        return (this.mRequestedWidth == -1 && this.mRequestedHeight == -1) ? false : true;
    }

    private boolean isAboveParent() {
        return this.mSubLayer >= 0;
    }

    public void setResizeBackgroundColor(int bgColor) {
        SurfaceControl.Transaction transaction = new SurfaceControl.Transaction();
        setResizeBackgroundColor(transaction, bgColor);
        applyTransactionOnVriDraw(transaction);
        invalidate();
    }

    public void setResizeBackgroundColor(SurfaceControl.Transaction t2, int bgColor) {
        if (this.mBackgroundControl == null) {
            return;
        }
        this.mBackgroundColor = bgColor;
        updateBackgroundColor(t2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* renamed from: android.view.SurfaceView$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public class AnonymousClass1 implements SurfaceHolder {
        private static final String LOG_TAG = "SurfaceHolder";

        AnonymousClass1() {
        }

        @Override // android.view.SurfaceHolder
        public boolean isCreating() {
            return SurfaceView.this.mIsCreating;
        }

        @Override // android.view.SurfaceHolder
        public void addCallback(SurfaceHolder.Callback callback) {
            synchronized (SurfaceView.this.mCallbacks) {
                if (!SurfaceView.this.mCallbacks.contains(callback)) {
                    SurfaceView.this.mCallbacks.add(callback);
                }
            }
        }

        @Override // android.view.SurfaceHolder
        public void removeCallback(SurfaceHolder.Callback callback) {
            synchronized (SurfaceView.this.mCallbacks) {
                SurfaceView.this.mCallbacks.remove(callback);
            }
        }

        @Override // android.view.SurfaceHolder
        public void setFixedSize(int width, int height) {
            if (SurfaceView.this.mRequestedWidth != width || SurfaceView.this.mRequestedHeight != height) {
                if (SurfaceView.this.DEBUG_POSITION) {
                    Log.d(SurfaceView.TAG, String.format("%d setFixedSize %dx%d -> %dx%d", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(SurfaceView.this.mRequestedWidth), Integer.valueOf(SurfaceView.this.mRequestedHeight), Integer.valueOf(width), Integer.valueOf(height)));
                }
                SurfaceView.this.mRequestedWidth = width;
                SurfaceView.this.mRequestedHeight = height;
                SurfaceView.this.requestLayout();
            }
        }

        @Override // android.view.SurfaceHolder
        public void setSizeFromLayout() {
            if (SurfaceView.this.mRequestedWidth != -1 || SurfaceView.this.mRequestedHeight != -1) {
                if (SurfaceView.this.DEBUG_POSITION) {
                    Log.d(SurfaceView.TAG, String.format("%d setSizeFromLayout was %dx%d", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(SurfaceView.this.mRequestedWidth), Integer.valueOf(SurfaceView.this.mRequestedHeight)));
                }
                SurfaceView surfaceView = SurfaceView.this;
                surfaceView.mRequestedHeight = -1;
                surfaceView.mRequestedWidth = -1;
                SurfaceView.this.requestLayout();
            }
        }

        @Override // android.view.SurfaceHolder
        public void setFormat(int format) {
            if (format == -1) {
                format = 4;
            }
            SurfaceView.this.mRequestedFormat = format;
            if (SurfaceView.this.mSurfaceControl != null) {
                SurfaceView.this.updateSurface();
            }
        }

        @Override // android.view.SurfaceHolder
        @Deprecated
        public void setType(int type) {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setKeepScreenOn$0(boolean screenOn) {
            SurfaceView.this.setKeepScreenOn(screenOn);
        }

        @Override // android.view.SurfaceHolder
        public void setKeepScreenOn(final boolean screenOn) {
            SurfaceView.this.runOnUiThread(new Runnable() { // from class: android.view.SurfaceView$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    SurfaceView.AnonymousClass1.this.lambda$setKeepScreenOn$0(screenOn);
                }
            });
        }

        @Override // android.view.SurfaceHolder
        public Canvas lockCanvas() {
            return internalLockCanvas(null, false);
        }

        @Override // android.view.SurfaceHolder
        public Canvas lockCanvas(Rect inOutDirty) {
            return internalLockCanvas(inOutDirty, false);
        }

        @Override // android.view.SurfaceHolder
        public Canvas lockHardwareCanvas() {
            return internalLockCanvas(null, true);
        }

        private Canvas internalLockCanvas(Rect dirty, boolean hardware) {
            SurfaceView.this.mSurfaceLock.lock();
            if (SurfaceView.this.DEBUG_LOG_ALL) {
                Log.i(SurfaceView.TAG, System.identityHashCode(this) + " Locking canvas... stopped=" + SurfaceView.this.mDrawingStopped + ", surfaceControl=" + ((Object) SurfaceView.this.mSurfaceControl));
            }
            Canvas c4 = null;
            if (!SurfaceView.this.mDrawingStopped && SurfaceView.this.mSurfaceControl != null) {
                try {
                    if (hardware) {
                        c4 = SurfaceView.this.mSurface.lockHardwareCanvas();
                    } else {
                        c4 = SurfaceView.this.mSurface.lockCanvas(dirty);
                    }
                } catch (Exception e2) {
                    Log.e(LOG_TAG, "Exception locking surface", e2);
                }
            }
            if (SurfaceView.this.DEBUG_LOG_ALL) {
                Log.i(SurfaceView.TAG, System.identityHashCode(this) + " Returned canvas: " + ((Object) c4));
            }
            if (c4 != null) {
                SurfaceView.this.mLastLockTime = SystemClock.uptimeMillis();
                return c4;
            }
            long now = SystemClock.uptimeMillis();
            long nextTime = SurfaceView.this.mLastLockTime + 100;
            if (nextTime > now) {
                try {
                    Thread.sleep(nextTime - now);
                } catch (InterruptedException e10) {
                }
                now = SystemClock.uptimeMillis();
            }
            SurfaceView.this.mLastLockTime = now;
            SurfaceView.this.mSurfaceLock.unlock();
            return null;
        }

        @Override // android.view.SurfaceHolder
        public void unlockCanvasAndPost(Canvas canvas) {
            if (SurfaceView.this.DEBUG_LOG_ALL) {
                Log.i(SurfaceView.TAG, System.identityHashCode(this) + "[unlockCanvasAndPost] canvas:" + ((Object) canvas));
            }
            try {
                SurfaceView.this.mSurface.unlockCanvasAndPost(canvas);
            } finally {
                SurfaceView.this.mSurfaceLock.unlock();
            }
        }

        @Override // android.view.SurfaceHolder
        public Surface getSurface() {
            return SurfaceView.this.mSurface;
        }

        @Override // android.view.SurfaceHolder
        public Rect getSurfaceFrame() {
            return SurfaceView.this.mSurfaceFrame;
        }
    }

    public SurfaceControl getSurfaceControl() {
        return this.mSurfaceControl;
    }

    public IBinder getHostToken() {
        ViewRootImpl viewRoot = getViewRootImpl();
        if (viewRoot == null) {
            return null;
        }
        return viewRoot.getInputToken();
    }

    @Override // android.view.ViewRootImpl.SurfaceChangedCallback
    public void surfaceCreated(SurfaceControl.Transaction t2) {
        setWindowStopped(false);
    }

    @Override // android.view.ViewRootImpl.SurfaceChangedCallback
    public void surfaceDestroyed() {
        setWindowStopped(true);
        this.mRemoteAccessibilityController.disassosciateHierarchy();
    }

    @Override // android.view.ViewRootImpl.SurfaceChangedCallback
    public void surfaceReplaced(SurfaceControl.Transaction t2) {
        if (this.mSurfaceControl != null && this.mBackgroundControl != null) {
            updateRelativeZ(t2);
        }
    }

    private void updateRelativeZ(SurfaceControl.Transaction t2) {
        ViewRootImpl viewRoot = getViewRootImpl();
        if (viewRoot == null) {
            return;
        }
        SurfaceControl viewRootControl = viewRoot.getSurfaceControl();
        t2.setRelativeLayer(this.mBackgroundControl, viewRootControl, Integer.MIN_VALUE);
        t2.setRelativeLayer(this.mSurfaceControl, viewRootControl, this.mSubLayer);
        if (getViewRootImpl() != null) {
            getViewRootImpl().getWrapper().getExtImpl().updateSurfaceViewRelativeZIfNeed(this, t2);
        }
    }

    public void setChildSurfacePackage(SurfaceControlViewHost.SurfacePackage p10) {
        SurfaceControlViewHost.SurfacePackage surfacePackage = this.mSurfacePackage;
        SurfaceControl lastSc = surfacePackage != null ? surfacePackage.getSurfaceControl() : null;
        SurfaceControl.Transaction transaction = new SurfaceControl.Transaction();
        if (this.mSurfaceControl != null) {
            if (lastSc != null) {
                transaction.reparent(lastSc, null);
                this.mSurfacePackage.release();
            }
            reparentSurfacePackage(transaction, p10);
            applyTransactionOnVriDraw(transaction);
        }
        this.mSurfacePackage = p10;
        if (isFocused()) {
            requestEmbeddedFocus(true);
        }
        invalidate();
    }

    private void reparentSurfacePackage(SurfaceControl.Transaction t2, SurfaceControlViewHost.SurfacePackage p10) {
        SurfaceControl sc2 = p10.getSurfaceControl();
        if (sc2 == null || !sc2.isValid()) {
            return;
        }
        initEmbeddedHierarchyForAccessibility(p10);
        t2.reparent(sc2, this.mBlastSurfaceControl).show(sc2);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfoInternal(AccessibilityNodeInfo info) {
        super.onInitializeAccessibilityNodeInfoInternal(info);
        if (!this.mRemoteAccessibilityController.connected()) {
            return;
        }
        info.addChild(this.mRemoteAccessibilityController.getLeashToken());
    }

    @Override // android.view.View
    public int getImportantForAccessibility() {
        int mode = super.getImportantForAccessibility();
        RemoteAccessibilityController remoteAccessibilityController = this.mRemoteAccessibilityController;
        if ((remoteAccessibilityController != null && !remoteAccessibilityController.connected()) || mode != 0) {
            return mode;
        }
        return 1;
    }

    private void initEmbeddedHierarchyForAccessibility(SurfaceControlViewHost.SurfacePackage p10) {
        IAccessibilityEmbeddedConnection connection = p10.getAccessibilityEmbeddedConnection();
        if (this.mRemoteAccessibilityController.alreadyAssociated(connection)) {
            return;
        }
        this.mRemoteAccessibilityController.assosciateHierarchy(connection, getViewRootImpl().mLeashToken, getAccessibilityViewId());
        updateEmbeddedAccessibilityMatrix(true);
    }

    private void notifySurfaceDestroyed() {
        if (this.mSurface.isValid()) {
            Log.i(TAG, System.identityHashCode(this) + " surfaceDestroyed");
            SurfaceHolder.Callback[] callbacks = getSurfaceCallbacks();
            for (SurfaceHolder.Callback c4 : callbacks) {
                c4.surfaceDestroyed(this.mSurfaceHolder);
            }
            if (this.mSurface.isValid()) {
                this.mSurface.forceScopedDisconnect();
            }
        }
    }

    void updateEmbeddedAccessibilityMatrix(boolean force) {
        if (!this.mRemoteAccessibilityController.connected()) {
            return;
        }
        getBoundsOnScreen(this.mTmpRect);
        this.mTmpRect.offset(-this.mAttachInfo.mWindowLeft, -this.mAttachInfo.mWindowTop);
        this.mTmpMatrix.reset();
        this.mTmpMatrix.setTranslate(this.mTmpRect.left, this.mTmpRect.top);
        this.mTmpMatrix.postScale(this.mScreenRect.width() / this.mSurfaceWidth, this.mScreenRect.height() / this.mSurfaceHeight);
        this.mRemoteAccessibilityController.setWindowMatrix(this.mTmpMatrix, force);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onFocusChanged(boolean gainFocus, int direction, Rect previouslyFocusedRect) {
        super.onFocusChanged(gainFocus, direction, previouslyFocusedRect);
        requestEmbeddedFocus(gainFocus);
    }

    private void requestEmbeddedFocus(boolean gainFocus) {
        ViewRootImpl viewRoot = getViewRootImpl();
        if (this.mSurfacePackage == null || viewRoot == null) {
            return;
        }
        try {
            viewRoot.mWindowSession.grantEmbeddedWindowFocus(viewRoot.mWindow, this.mSurfacePackage.getInputToken(), gainFocus);
        } catch (Exception e2) {
            Log.e(TAG, System.identityHashCode(this) + "Exception requesting focus on embedded window", e2);
        }
    }

    private void applyTransactionOnVriDraw(SurfaceControl.Transaction t2) {
        ViewRootImpl viewRoot = getViewRootImpl();
        if (viewRoot != null) {
            viewRoot.applyTransactionOnDraw(t2);
        } else {
            t2.apply();
        }
    }

    public void syncNextFrame(Consumer<SurfaceControl.Transaction> t2) {
        this.mBlastBufferQueue.syncNextTransaction(t2);
    }

    public void applyTransactionToFrame(SurfaceControl.Transaction transaction) {
        synchronized (this.mSurfaceControlLock) {
            BLASTBufferQueue bLASTBufferQueue = this.mBlastBufferQueue;
            if (bLASTBufferQueue == null) {
                throw new IllegalStateException("Surface does not exist!");
            }
            long frameNumber = bLASTBufferQueue.getLastAcquiredFrameNum() + 1;
            this.mBlastBufferQueue.mergeWithNextTransaction(transaction, frameNumber);
        }
    }

    public ISurfaceViewWrapper getWrapper() {
        return this.mSurfaceViewlWrapper;
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    private class SurfaceViewImplWrapper implements ISurfaceViewWrapper {
        private SurfaceViewImplWrapper() {
        }

        @Override // android.view.ISurfaceViewWrapper
        public SurfaceControl getBlastSurfaceControl() {
            return SurfaceView.this.mBlastSurfaceControl;
        }

        @Override // android.view.ISurfaceViewWrapper
        public ISurfaceViewExt getExtImpl() {
            return SurfaceView.this.mSurfaceViewExt;
        }

        @Override // android.view.ISurfaceViewWrapper
        public void performDrawFinishedSync(SurfaceSyncGroup syncGroup) {
            SurfaceView.this.performDrawFinished();
            syncGroup.markSyncReady();
        }

        @Override // android.view.ISurfaceViewWrapper
        public void onDrawFinished(final SurfaceSyncGroup syncGroup) {
            Log.d(SurfaceView.TAG, System.identityHashCode(this) + " finishedDrawing with sync group " + ((Object) syncGroup));
            SurfaceView.this.runOnUiThread(new Runnable() { // from class: android.view.SurfaceView.SurfaceViewImplWrapper.1
                @Override // java.lang.Runnable
                public void run() {
                    SurfaceViewImplWrapper.this.performDrawFinishedSync(syncGroup);
                }
            });
        }
    }
}
