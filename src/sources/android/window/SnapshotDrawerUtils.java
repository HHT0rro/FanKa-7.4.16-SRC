package android.window;

import android.app.ActivityManager;
import android.app.ActivityThread;
import android.app.ContextImpl;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.GraphicBuffer;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.HardwareBuffer;
import android.os.IBinder;
import android.util.Log;
import android.view.InsetsState;
import android.view.SurfaceControl;
import android.view.SurfaceSession;
import android.view.WindowInsets;
import android.view.WindowManager;
import com.android.internal.R;
import com.android.internal.policy.DecorView;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class SnapshotDrawerUtils {
    static final int FLAG_INHERIT_EXCLUDES = 830922808;
    private static final String TAG = "SnapshotDrawerUtils";
    private static final RectF sTmpSnapshotSize = new RectF();
    private static final RectF sTmpDstFrame = new RectF();
    private static final Matrix sSnapshotMatrix = new Matrix();
    private static final float[] sTmpFloat9 = new float[9];
    private static final Paint sBackgroundPaint = new Paint();

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class SnapshotSurface {
        private final SurfaceControl mRootSurface;
        private boolean mSizeMismatch;
        private final TaskSnapshot mSnapshot;
        private SystemBarBackgroundPainter mSystemBarBackgroundPainter;
        private final Rect mTaskBounds;
        private final CharSequence mTitle;
        private final SurfaceControl.Transaction mTransaction = new SurfaceControl.Transaction();
        private final Rect mFrame = new Rect();
        private final Rect mSystemBarInsets = new Rect();

        public SnapshotSurface(SurfaceControl rootSurface, TaskSnapshot snapshot, CharSequence title, Rect taskBounds) {
            this.mRootSurface = rootSurface;
            this.mSnapshot = snapshot;
            this.mTitle = title;
            this.mTaskBounds = taskBounds;
        }

        void initiateSystemBarPainter(int windowFlags, int windowPrivateFlags, int appearance, ActivityManager.TaskDescription taskDescription, int requestedVisibleTypes) {
            this.mSystemBarBackgroundPainter = new SystemBarBackgroundPainter(windowFlags, windowPrivateFlags, appearance, taskDescription, 1.0f, requestedVisibleTypes);
            int backgroundColor = taskDescription.getBackgroundColor();
            SnapshotDrawerUtils.sBackgroundPaint.setColor(backgroundColor != 0 ? backgroundColor : -1);
        }

        void setFrames(Rect frame, Rect systemBarInsets) {
            this.mFrame.set(frame);
            this.mSystemBarInsets.set(systemBarInsets);
            HardwareBuffer snapshot = this.mSnapshot.getHardwareBuffer();
            this.mSizeMismatch = (this.mFrame.width() == snapshot.getWidth() && this.mFrame.height() == snapshot.getHeight()) ? false : true;
            this.mSystemBarBackgroundPainter.setInsets(systemBarInsets);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void drawSnapshot(boolean releaseAfterDraw) {
            Log.v(SnapshotDrawerUtils.TAG, "Drawing snapshot surface sizeMismatch=" + this.mSizeMismatch);
            if (this.mSizeMismatch) {
                drawSizeMismatchSnapshot();
            } else {
                drawSizeMatchSnapshot();
            }
            if (this.mSnapshot.getHardwareBuffer() != null) {
                this.mSnapshot.getHardwareBuffer().close();
            }
            if (releaseAfterDraw) {
                this.mRootSurface.release();
            }
        }

        private void drawSizeMatchSnapshot() {
            this.mTransaction.setBuffer(this.mRootSurface, this.mSnapshot.getHardwareBuffer()).setColorSpace(this.mRootSurface, this.mSnapshot.getColorSpace()).apply();
        }

        private void drawSizeMismatchSnapshot() {
            Rect frame;
            HardwareBuffer buffer = this.mSnapshot.getHardwareBuffer();
            SurfaceSession session = new SurfaceSession();
            boolean aspectRatioMismatch = !SnapshotDrawerUtils.isAspectRatioMatch(this.mFrame, this.mSnapshot);
            SurfaceControl childSurfaceControl = new SurfaceControl.Builder(session).setName(((Object) this.mTitle) + " - task-snapshot-surface").setBLASTLayer().setFormat(buffer.getFormat()).setParent(this.mRootSurface).setCallsite("TaskSnapshotWindow.drawSizeMismatchSnapshot").build();
            this.mTransaction.show(childSurfaceControl);
            if (aspectRatioMismatch) {
                Rect crop = null;
                Rect letterboxInsets = this.mSnapshot.getLetterboxInsets();
                if (letterboxInsets.left != 0 || letterboxInsets.top != 0 || letterboxInsets.right != 0 || letterboxInsets.bottom != 0) {
                    crop = calculateSnapshotCrop(letterboxInsets);
                    aspectRatioMismatch = !SnapshotDrawerUtils.isAspectRatioMatch(this.mFrame, crop);
                }
                if (aspectRatioMismatch) {
                    crop = calculateSnapshotCrop(this.mSnapshot.getContentInsets());
                }
                frame = calculateSnapshotFrame(crop);
                this.mTransaction.setWindowCrop(childSurfaceControl, crop);
                this.mTransaction.setPosition(childSurfaceControl, frame.left, frame.top);
                SnapshotDrawerUtils.sTmpSnapshotSize.set(crop);
                SnapshotDrawerUtils.sTmpDstFrame.set(frame);
            } else {
                frame = null;
                SnapshotDrawerUtils.sTmpSnapshotSize.set(0.0f, 0.0f, buffer.getWidth(), buffer.getHeight());
                SnapshotDrawerUtils.sTmpDstFrame.set(this.mFrame);
                SnapshotDrawerUtils.sTmpDstFrame.offsetTo(0.0f, 0.0f);
            }
            SnapshotDrawerUtils.sSnapshotMatrix.setRectToRect(SnapshotDrawerUtils.sTmpSnapshotSize, SnapshotDrawerUtils.sTmpDstFrame, Matrix.ScaleToFit.FILL);
            this.mTransaction.setMatrix(childSurfaceControl, SnapshotDrawerUtils.sSnapshotMatrix, SnapshotDrawerUtils.sTmpFloat9);
            this.mTransaction.setColorSpace(childSurfaceControl, this.mSnapshot.getColorSpace());
            this.mTransaction.setBuffer(childSurfaceControl, this.mSnapshot.getHardwareBuffer());
            if (aspectRatioMismatch) {
                GraphicBuffer background = GraphicBuffer.create(this.mFrame.width(), this.mFrame.height(), 1, 2336);
                if (background == null) {
                    Log.e(SnapshotDrawerUtils.TAG, "Unable to draw snapshot: failed to allocate graphic buffer for " + ((Object) this.mTitle));
                    return;
                }
                Canvas c4 = background.lockCanvas();
                if (c4 == null) {
                    childSurfaceControl.release();
                    Log.e(SnapshotDrawerUtils.TAG, "drawSizeMismatchSnapshot have a null Canvas, abort it.");
                    return;
                } else {
                    drawBackgroundAndBars(c4, frame);
                    background.unlockCanvasAndPost(c4);
                    this.mTransaction.setBuffer(this.mRootSurface, HardwareBuffer.createFromGraphicBuffer(background));
                }
            }
            this.mTransaction.apply();
            childSurfaceControl.release();
        }

        Rect calculateSnapshotCrop(Rect insets) {
            Rect rect = new Rect();
            HardwareBuffer snapshot = this.mSnapshot.getHardwareBuffer();
            rect.set(0, 0, snapshot.getWidth(), snapshot.getHeight());
            float scaleX = snapshot.getWidth() / this.mSnapshot.getTaskSize().x;
            float scaleY = snapshot.getHeight() / this.mSnapshot.getTaskSize().y;
            boolean isTop = this.mTaskBounds.top == 0 && this.mFrame.top == 0;
            rect.inset((int) (insets.left * scaleX), isTop ? 0 : (int) (insets.top * scaleY), (int) (insets.right * scaleX), (int) (insets.bottom * scaleY));
            return rect;
        }

        Rect calculateSnapshotFrame(Rect crop) {
            HardwareBuffer snapshot = this.mSnapshot.getHardwareBuffer();
            float scaleX = snapshot.getWidth() / this.mSnapshot.getTaskSize().x;
            float scaleY = snapshot.getHeight() / this.mSnapshot.getTaskSize().y;
            Rect frame = new Rect(0, 0, (int) ((crop.width() / scaleX) + 0.5f), (int) ((crop.height() / scaleY) + 0.5f));
            frame.offset(this.mSystemBarInsets.left, 0);
            return frame;
        }

        void drawBackgroundAndBars(Canvas c4, Rect frame) {
            int statusBarHeight = this.mSystemBarBackgroundPainter.getStatusBarColorViewHeight();
            boolean fillHorizontally = c4.getWidth() > frame.right;
            boolean fillVertically = c4.getHeight() > frame.bottom;
            if (fillHorizontally) {
                c4.drawRect(frame.right, Color.alpha(this.mSystemBarBackgroundPainter.mStatusBarColor) == 255 ? statusBarHeight : 0.0f, c4.getWidth(), fillVertically ? frame.bottom : c4.getHeight(), SnapshotDrawerUtils.sBackgroundPaint);
            }
            if (fillVertically) {
                c4.drawRect(0.0f, frame.bottom, c4.getWidth(), c4.getHeight(), SnapshotDrawerUtils.sBackgroundPaint);
            }
            this.mSystemBarBackgroundPainter.drawDecors(c4, frame);
        }

        void drawStatusBarBackground(Canvas c4, Rect alreadyDrawnFrame) {
            SystemBarBackgroundPainter systemBarBackgroundPainter = this.mSystemBarBackgroundPainter;
            systemBarBackgroundPainter.drawStatusBarBackground(c4, alreadyDrawnFrame, systemBarBackgroundPainter.getStatusBarColorViewHeight());
        }

        void drawNavigationBarBackground(Canvas c4) {
            this.mSystemBarBackgroundPainter.drawNavigationBarBackground(c4);
        }
    }

    public static boolean isAspectRatioMatch(Rect frame, TaskSnapshot snapshot) {
        if (frame.isEmpty()) {
            return false;
        }
        HardwareBuffer buffer = snapshot.getHardwareBuffer();
        return Math.abs((((float) buffer.getWidth()) / ((float) buffer.getHeight())) - (((float) frame.width()) / ((float) frame.height()))) <= 0.01f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isAspectRatioMatch(Rect frame1, Rect frame2) {
        return (frame1.isEmpty() || frame2.isEmpty() || Math.abs((((float) frame2.width()) / ((float) frame2.height())) - (((float) frame1.width()) / ((float) frame1.height()))) > 0.01f) ? false : true;
    }

    public static ActivityManager.TaskDescription getOrCreateTaskDescription(ActivityManager.RunningTaskInfo runningTaskInfo) {
        if (runningTaskInfo.taskDescription != null) {
            return runningTaskInfo.taskDescription;
        }
        ActivityManager.TaskDescription taskDescription = new ActivityManager.TaskDescription();
        taskDescription.setBackgroundColor(-1);
        return taskDescription;
    }

    public static void drawSnapshotOnSurface(StartingWindowInfo info, WindowManager.LayoutParams lp, SurfaceControl rootSurface, TaskSnapshot snapshot, Rect configBounds, Rect windowBounds, InsetsState topWindowInsetsState, boolean releaseAfterDraw) {
        if (windowBounds.isEmpty()) {
            Log.e(TAG, "Unable to draw snapshot on an empty windowBounds");
            return;
        }
        SnapshotSurface drawSurface = new SnapshotSurface(rootSurface, snapshot, lp.getTitle(), configBounds);
        WindowManager.LayoutParams attrs = info.topOpaqueWindowLayoutParams;
        ActivityManager.RunningTaskInfo runningTaskInfo = info.taskInfo;
        ActivityManager.TaskDescription taskDescription = getOrCreateTaskDescription(runningTaskInfo);
        drawSurface.initiateSystemBarPainter(lp.flags, lp.privateFlags, attrs.insetsFlags.appearance, taskDescription, info.requestedVisibleTypes);
        Rect systemBarInsets = getSystemBarInsets(windowBounds, topWindowInsetsState);
        drawSurface.setFrames(windowBounds, systemBarInsets);
        drawSurface.drawSnapshot(releaseAfterDraw);
    }

    public static WindowManager.LayoutParams createLayoutParameters(StartingWindowInfo info, CharSequence title, int windowType, int pixelFormat, IBinder token) {
        WindowManager.LayoutParams attrs = info.topOpaqueWindowLayoutParams;
        WindowManager.LayoutParams mainWindowParams = info.mainWindowLayoutParams;
        InsetsState topWindowInsetsState = info.topOpaqueWindowInsetsState;
        if (attrs == null || mainWindowParams == null || topWindowInsetsState == null) {
            Log.w(TAG, "unable to create taskSnapshot surface ");
            return null;
        }
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        int appearance = attrs.insetsFlags.appearance;
        int windowFlags = attrs.flags;
        int windowPrivateFlags = attrs.privateFlags;
        layoutParams.packageName = mainWindowParams.packageName;
        layoutParams.windowAnimations = mainWindowParams.windowAnimations;
        layoutParams.dimAmount = mainWindowParams.dimAmount;
        layoutParams.type = windowType;
        layoutParams.format = pixelFormat;
        layoutParams.flags = ((-830922809) & windowFlags) | 8 | 16;
        layoutParams.privateFlags = (32768 & windowPrivateFlags) | 536870912 | 33554432;
        layoutParams.token = token;
        layoutParams.width = -1;
        layoutParams.height = -1;
        layoutParams.insetsFlags.appearance = appearance;
        layoutParams.insetsFlags.behavior = attrs.insetsFlags.behavior;
        layoutParams.layoutInDisplayCutoutMode = attrs.layoutInDisplayCutoutMode;
        layoutParams.setFitInsetsTypes(attrs.getFitInsetsTypes());
        layoutParams.setFitInsetsSides(attrs.getFitInsetsSides());
        layoutParams.setFitInsetsIgnoringVisibility(attrs.isFitInsetsIgnoringVisibility());
        layoutParams.setTitle(title);
        layoutParams.inputFeatures |= 1;
        return layoutParams;
    }

    static Rect getSystemBarInsets(Rect frame, InsetsState state) {
        return state.calculateInsets(frame, WindowInsets.Type.systemBars(), false).toRect();
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class SystemBarBackgroundPainter {
        private final int mNavigationBarColor;
        private final Paint mNavigationBarPaint;
        private final int mRequestedVisibleTypes;
        private final float mScale;
        private final int mStatusBarColor;
        private final Paint mStatusBarPaint;
        private final Rect mSystemBarInsets;
        private final int mWindowFlags;
        private final int mWindowPrivateFlags;

        public SystemBarBackgroundPainter(int windowFlags, int windowPrivateFlags, int appearance, ActivityManager.TaskDescription taskDescription, float scale, int requestedVisibleTypes) {
            Paint paint = new Paint();
            this.mStatusBarPaint = paint;
            Paint paint2 = new Paint();
            this.mNavigationBarPaint = paint2;
            this.mSystemBarInsets = new Rect();
            this.mWindowFlags = windowFlags;
            this.mWindowPrivateFlags = windowPrivateFlags;
            this.mScale = scale;
            ContextImpl systemUiContext = ActivityThread.currentActivityThread().getSystemUiContext();
            int semiTransparent = systemUiContext.getColor(R.color.system_bar_background_semi_transparent);
            int calculateBarColor = DecorView.calculateBarColor(windowFlags, 67108864, semiTransparent, taskDescription.getStatusBarColor(), appearance, 8, taskDescription.getEnsureStatusBarContrastWhenTransparent());
            this.mStatusBarColor = calculateBarColor;
            int calculateBarColor2 = DecorView.calculateBarColor(windowFlags, 134217728, semiTransparent, taskDescription.getNavigationBarColor(), appearance, 16, taskDescription.getEnsureNavigationBarContrastWhenTransparent() && systemUiContext.getResources().getBoolean(R.bool.config_navBarNeedsScrim));
            this.mNavigationBarColor = calculateBarColor2;
            paint.setColor(calculateBarColor);
            paint2.setColor(calculateBarColor2);
            this.mRequestedVisibleTypes = requestedVisibleTypes;
        }

        public void setInsets(Rect systemBarInsets) {
            this.mSystemBarInsets.set(systemBarInsets);
        }

        int getStatusBarColorViewHeight() {
            boolean forceBarBackground = (this.mWindowPrivateFlags & 32768) != 0;
            if (DecorView.STATUS_BAR_COLOR_VIEW_ATTRIBUTES.isVisible(this.mRequestedVisibleTypes, this.mStatusBarColor, this.mWindowFlags, forceBarBackground)) {
                return (int) (this.mSystemBarInsets.top * this.mScale);
            }
            return 0;
        }

        private boolean isNavigationBarColorViewVisible() {
            boolean forceBarBackground = (this.mWindowPrivateFlags & 32768) != 0;
            return DecorView.NAVIGATION_BAR_COLOR_VIEW_ATTRIBUTES.isVisible(this.mRequestedVisibleTypes, this.mNavigationBarColor, this.mWindowFlags, forceBarBackground);
        }

        public void drawDecors(Canvas c4, Rect alreadyDrawnFrame) {
            drawStatusBarBackground(c4, alreadyDrawnFrame, getStatusBarColorViewHeight());
            drawNavigationBarBackground(c4);
        }

        void drawStatusBarBackground(Canvas c4, Rect alreadyDrawnFrame, int statusBarHeight) {
            if (statusBarHeight > 0 && Color.alpha(this.mStatusBarColor) != 0) {
                if (alreadyDrawnFrame == null || c4.getWidth() > alreadyDrawnFrame.right) {
                    int rightInset = (int) (this.mSystemBarInsets.right * this.mScale);
                    int left = alreadyDrawnFrame != null ? alreadyDrawnFrame.right : 0;
                    c4.drawRect(left, 0.0f, c4.getWidth() - rightInset, statusBarHeight, this.mStatusBarPaint);
                }
            }
        }

        void drawNavigationBarBackground(Canvas c4) {
            Rect navigationBarRect = new Rect();
            DecorView.getNavigationBarRect(c4.getWidth(), c4.getHeight(), this.mSystemBarInsets, navigationBarRect, this.mScale);
            boolean visible = isNavigationBarColorViewVisible();
            if (visible && Color.alpha(this.mNavigationBarColor) != 0 && !navigationBarRect.isEmpty()) {
                c4.drawRect(navigationBarRect, this.mNavigationBarPaint);
            }
        }
    }
}
