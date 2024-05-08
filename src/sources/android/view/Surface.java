package android.view;

import android.content.res.CompatibilityInfo;
import android.graphics.BLASTBufferQueue;
import android.graphics.Canvas;
import android.graphics.ColorSpace;
import android.graphics.HardwareRenderer;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.RecordingCanvas;
import android.graphics.Rect;
import android.graphics.RenderNode;
import android.graphics.SurfaceTexture;
import android.hardware.HardwareBuffer;
import android.os.Parcel;
import android.os.Parcelable;
import android.system.OsConstants;
import android.util.Log;
import dalvik.system.CloseGuard;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import system.ext.loader.core.ExtLoader;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class Surface implements Parcelable {
    public static final int CHANGE_FRAME_RATE_ALWAYS = 1;
    public static final int CHANGE_FRAME_RATE_ONLY_IF_SEAMLESS = 0;
    public static final Parcelable.Creator<Surface> CREATOR = new Parcelable.Creator<Surface>() { // from class: android.view.Surface.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Surface createFromParcel(Parcel source) {
            try {
                Surface s2 = new Surface();
                s2.readFromParcel(source);
                return s2;
            } catch (Exception e2) {
                Log.e(Surface.TAG, "Exception creating surface from parcel", e2);
                return null;
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Surface[] newArray(int size) {
            return new Surface[size];
        }
    };
    public static final int FRAME_RATE_COMPATIBILITY_DEFAULT = 0;
    public static final int FRAME_RATE_COMPATIBILITY_EXACT = 100;
    public static final int FRAME_RATE_COMPATIBILITY_FIXED_SOURCE = 1;
    public static final int FRAME_RATE_COMPATIBILITY_MIN = 102;
    public static final int FRAME_RATE_COMPATIBILITY_NO_VOTE = 101;
    public static final int ROTATION_0 = 0;
    public static final int ROTATION_180 = 2;
    public static final int ROTATION_270 = 3;
    public static final int ROTATION_90 = 1;
    public static final int SCALING_MODE_FREEZE = 0;
    public static final int SCALING_MODE_NO_SCALE_CROP = 3;
    public static final int SCALING_MODE_SCALE_CROP = 2;
    public static final int SCALING_MODE_SCALE_TO_WINDOW = 1;
    private static final String TAG = "Surface";
    private final Canvas mCanvas;
    private final CloseGuard mCloseGuard;
    private Matrix mCompatibleMatrix;
    private int mGenerationId;
    private HwuiContext mHwuiContext;
    private boolean mIsAutoRefreshEnabled;
    private boolean mIsSharedBufferModeEnabled;
    private boolean mIsSingleBuffered;
    final Object mLock;
    private long mLockedObject;
    private String mName;
    long mNativeObject;
    private ISurfaceSocExt mSocExt;
    public ISurfaceExt mSurfaceExt;
    private ISurfaceWrapper mSurfaceWrapper;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public @interface ChangeFrameRateStrategy {
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public @interface FrameRateCompatibility {
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public @interface Rotation {
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public @interface ScalingMode {
    }

    private static native void nativeAllocateBuffers(long j10);

    private static native int nativeAttachAndQueueBufferWithColorSpace(long j10, HardwareBuffer hardwareBuffer, int i10);

    private static native long nativeCreateFromSurfaceControl(long j10);

    private static native long nativeCreateFromSurfaceTexture(SurfaceTexture surfaceTexture) throws OutOfResourcesException;

    private static native void nativeDestroy(long j10);

    private static native int nativeForceScopedDisconnect(long j10);

    private static native long nativeGetFromBlastBufferQueue(long j10, long j11);

    private static native long nativeGetFromSurfaceControl(long j10, long j11);

    private static native int nativeGetHeight(long j10);

    private static native long nativeGetNextFrameNumber(long j10);

    private static native int nativeGetWidth(long j10);

    private static native boolean nativeIsConsumerRunningBehind(long j10);

    private static native boolean nativeIsValid(long j10);

    private static native long nativeLockCanvas(long j10, Canvas canvas, Rect rect) throws OutOfResourcesException;

    private static native long nativeReadFromParcel(long j10, Parcel parcel);

    private static native void nativeRelease(long j10);

    private static native int nativeSetAutoRefreshEnabled(long j10, boolean z10);

    private static native int nativeSetFrameRate(long j10, float f10, int i10, int i11);

    private static native int nativeSetScalingMode(long j10, int i10);

    private static native int nativeSetSharedBufferModeEnabled(long j10, boolean z10);

    private static native void nativeUnlockCanvasAndPost(long j10, Canvas canvas);

    private static native void nativeWriteToParcel(long j10, Parcel parcel);

    public Surface() {
        this.mCloseGuard = CloseGuard.get();
        this.mLock = new Object();
        this.mCanvas = new CompatibleCanvas();
        this.mSocExt = (ISurfaceSocExt) ExtLoader.type(ISurfaceSocExt.class).base(this).create();
        this.mSurfaceWrapper = new SurfaceWrapper();
        this.mSurfaceExt = (ISurfaceExt) ExtLoader.type(ISurfaceExt.class).base(this).create();
    }

    public Surface(SurfaceControl surfaceControl) {
        this.mCloseGuard = CloseGuard.get();
        this.mLock = new Object();
        this.mCanvas = new CompatibleCanvas();
        this.mSocExt = (ISurfaceSocExt) ExtLoader.type(ISurfaceSocExt.class).base(this).create();
        this.mSurfaceWrapper = new SurfaceWrapper();
        this.mSurfaceExt = (ISurfaceExt) ExtLoader.type(ISurfaceExt.class).base(this).create();
        copyFrom(surfaceControl);
    }

    public Surface(SurfaceTexture surfaceTexture) {
        this.mCloseGuard = CloseGuard.get();
        Object obj = new Object();
        this.mLock = obj;
        this.mCanvas = new CompatibleCanvas();
        this.mSocExt = (ISurfaceSocExt) ExtLoader.type(ISurfaceSocExt.class).base(this).create();
        this.mSurfaceWrapper = new SurfaceWrapper();
        this.mSurfaceExt = (ISurfaceExt) ExtLoader.type(ISurfaceExt.class).base(this).create();
        if (surfaceTexture == null) {
            throw new IllegalArgumentException("surfaceTexture must not be null");
        }
        this.mIsSingleBuffered = surfaceTexture.isSingleBuffered();
        synchronized (obj) {
            this.mName = surfaceTexture.toString();
            setNativeObjectLocked(nativeCreateFromSurfaceTexture(surfaceTexture));
        }
    }

    private Surface(long j10) {
        this.mCloseGuard = CloseGuard.get();
        Object obj = new Object();
        this.mLock = obj;
        this.mCanvas = new CompatibleCanvas();
        this.mSocExt = (ISurfaceSocExt) ExtLoader.type(ISurfaceSocExt.class).base(this).create();
        this.mSurfaceWrapper = new SurfaceWrapper();
        this.mSurfaceExt = (ISurfaceExt) ExtLoader.type(ISurfaceExt.class).base(this).create();
        synchronized (obj) {
            setNativeObjectLocked(j10);
        }
    }

    protected void finalize() throws Throwable {
        try {
            CloseGuard closeGuard = this.mCloseGuard;
            if (closeGuard != null) {
                closeGuard.warnIfOpen();
            }
            release();
        } finally {
            super.finalize();
        }
    }

    public void release() {
        synchronized (this.mLock) {
            HwuiContext hwuiContext = this.mHwuiContext;
            if (hwuiContext != null) {
                hwuiContext.destroy();
                this.mHwuiContext = null;
            }
            long j10 = this.mNativeObject;
            if (j10 != 0) {
                nativeRelease(j10);
                setNativeObjectLocked(0L);
            }
        }
    }

    public void destroy() {
        synchronized (this.mLock) {
            long j10 = this.mNativeObject;
            if (j10 != 0) {
                nativeDestroy(j10);
            }
            release();
        }
    }

    public void hwuiDestroy() {
        HwuiContext hwuiContext = this.mHwuiContext;
        if (hwuiContext != null) {
            hwuiContext.destroy();
            this.mHwuiContext = null;
        }
    }

    public boolean isValid() {
        synchronized (this.mLock) {
            long j10 = this.mNativeObject;
            if (j10 == 0) {
                return false;
            }
            return nativeIsValid(j10);
        }
    }

    public int getGenerationId() {
        int i10;
        synchronized (this.mLock) {
            i10 = this.mGenerationId;
        }
        return i10;
    }

    public long getNextFrameNumber() {
        long nativeGetNextFrameNumber;
        synchronized (this.mLock) {
            checkNotReleasedLocked();
            nativeGetNextFrameNumber = nativeGetNextFrameNumber(this.mNativeObject);
        }
        return nativeGetNextFrameNumber;
    }

    public boolean isConsumerRunningBehind() {
        boolean nativeIsConsumerRunningBehind;
        synchronized (this.mLock) {
            checkNotReleasedLocked();
            nativeIsConsumerRunningBehind = nativeIsConsumerRunningBehind(this.mNativeObject);
        }
        return nativeIsConsumerRunningBehind;
    }

    public Point getDefaultSize() {
        Point point;
        synchronized (this.mLock) {
            checkNotReleasedLocked();
            point = new Point(nativeGetWidth(this.mNativeObject), nativeGetHeight(this.mNativeObject));
        }
        return point;
    }

    public Canvas lockCanvas(Rect inOutDirty) throws OutOfResourcesException, IllegalArgumentException {
        synchronized (this.mLock) {
            if (this.mSocExt.hookLockCanvas()) {
                return lockHardwareCanvas();
            }
            checkNotReleasedLocked();
            if (this.mLockedObject != 0) {
                throw new IllegalArgumentException("Surface was already locked");
            }
            this.mLockedObject = nativeLockCanvas(this.mNativeObject, this.mCanvas, inOutDirty);
            return this.mCanvas;
        }
    }

    public void unlockCanvasAndPost(Canvas canvas) {
        synchronized (this.mLock) {
            checkNotReleasedLocked();
            HwuiContext hwuiContext = this.mHwuiContext;
            if (hwuiContext != null) {
                hwuiContext.unlockAndPost(canvas);
            } else {
                unlockSwCanvasAndPost(canvas);
            }
        }
    }

    private void unlockSwCanvasAndPost(Canvas canvas) {
        if (canvas != this.mCanvas) {
            throw new IllegalArgumentException("canvas object must be the same instance that was previously returned by lockCanvas");
        }
        if (this.mNativeObject != this.mLockedObject) {
            Log.w(TAG, "WARNING: Surface's mNativeObject (0x" + Long.toHexString(this.mNativeObject) + ") != mLockedObject (0x" + Long.toHexString(this.mLockedObject) + ")");
        }
        long j10 = this.mLockedObject;
        if (j10 == 0) {
            throw new IllegalStateException("Surface was not locked");
        }
        try {
            nativeUnlockCanvasAndPost(j10, canvas);
        } finally {
            nativeRelease(this.mLockedObject);
            this.mLockedObject = 0L;
        }
    }

    public Canvas lockHardwareCanvas() {
        Canvas lockCanvas;
        synchronized (this.mLock) {
            checkNotReleasedLocked();
            if (this.mHwuiContext == null) {
                this.mHwuiContext = new HwuiContext(false);
            }
            lockCanvas = this.mHwuiContext.lockCanvas(nativeGetWidth(this.mNativeObject), nativeGetHeight(this.mNativeObject));
        }
        return lockCanvas;
    }

    public Canvas lockHardwareWideColorGamutCanvas() {
        Canvas lockCanvas;
        synchronized (this.mLock) {
            checkNotReleasedLocked();
            HwuiContext hwuiContext = this.mHwuiContext;
            if (hwuiContext != null && !hwuiContext.isWideColorGamut()) {
                this.mHwuiContext.destroy();
                this.mHwuiContext = null;
            }
            if (this.mHwuiContext == null) {
                this.mHwuiContext = new HwuiContext(true);
            }
            lockCanvas = this.mHwuiContext.lockCanvas(nativeGetWidth(this.mNativeObject), nativeGetHeight(this.mNativeObject));
        }
        return lockCanvas;
    }

    @Deprecated
    public void unlockCanvas(Canvas canvas) {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCompatibilityTranslator(CompatibilityInfo.Translator translator) {
        if (translator != null) {
            float appScale = translator.applicationScale;
            Matrix matrix = new Matrix();
            this.mCompatibleMatrix = matrix;
            matrix.setScale(appScale, appScale);
        }
    }

    private void updateNativeObject(long newNativeObject) {
        synchronized (this.mLock) {
            long j10 = this.mNativeObject;
            if (newNativeObject == j10) {
                return;
            }
            if (j10 != 0) {
                nativeRelease(j10);
            }
            setNativeObjectLocked(newNativeObject);
        }
    }

    public void copyFrom(SurfaceControl other) {
        if (other == null) {
            throw new IllegalArgumentException("other must not be null");
        }
        long surfaceControlPtr = other.mNativeObject;
        if (surfaceControlPtr == 0) {
            throw new NullPointerException("null SurfaceControl native object. Are you using a released SurfaceControl?");
        }
        long newNativeObject = nativeGetFromSurfaceControl(this.mNativeObject, surfaceControlPtr);
        updateNativeObject(newNativeObject);
    }

    public void copyFrom(BLASTBufferQueue queue) {
        if (queue == null) {
            throw new IllegalArgumentException("queue must not be null");
        }
        long blastBufferQueuePtr = queue.mNativeObject;
        if (blastBufferQueuePtr == 0) {
            throw new NullPointerException("Null BLASTBufferQueue native object");
        }
        long newNativeObject = nativeGetFromBlastBufferQueue(this.mNativeObject, blastBufferQueuePtr);
        updateNativeObject(newNativeObject);
    }

    public void createFrom(SurfaceControl other) {
        if (other == null) {
            throw new IllegalArgumentException("other must not be null");
        }
        long surfaceControlPtr = other.mNativeObject;
        if (surfaceControlPtr == 0) {
            throw new NullPointerException("null SurfaceControl native object. Are you using a released SurfaceControl?");
        }
        long newNativeObject = nativeCreateFromSurfaceControl(surfaceControlPtr);
        synchronized (this.mLock) {
            long j10 = this.mNativeObject;
            if (j10 != 0) {
                nativeRelease(j10);
            }
            setNativeObjectLocked(newNativeObject);
        }
    }

    @Deprecated
    public void transferFrom(Surface other) {
        long newPtr;
        if (other == null) {
            throw new IllegalArgumentException("other must not be null");
        }
        if (other != this) {
            synchronized (other.mLock) {
                newPtr = other.mNativeObject;
                other.setNativeObjectLocked(0L);
            }
            synchronized (this.mLock) {
                long j10 = this.mNativeObject;
                if (j10 != 0) {
                    nativeRelease(j10);
                }
                setNativeObjectLocked(newPtr);
            }
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void readFromParcel(Parcel source) {
        if (source == null) {
            throw new IllegalArgumentException("source must not be null");
        }
        synchronized (this.mLock) {
            this.mName = source.readString();
            this.mIsSingleBuffered = source.readInt() != 0;
            setNativeObjectLocked(nativeReadFromParcel(this.mNativeObject, source));
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        if (dest == null) {
            throw new IllegalArgumentException("dest must not be null");
        }
        synchronized (this.mLock) {
            dest.writeString(this.mName);
            dest.writeInt(this.mIsSingleBuffered ? 1 : 0);
            nativeWriteToParcel(this.mNativeObject, dest);
        }
        if ((flags & 1) != 0) {
            release();
        }
    }

    public String toString() {
        String str;
        synchronized (this.mLock) {
            str = "Surface(name=" + this.mName + ")/@0x" + Integer.toHexString(System.identityHashCode(this));
        }
        return str;
    }

    private void setNativeObjectLocked(long ptr) {
        long j10 = this.mNativeObject;
        if (j10 != ptr) {
            if (j10 == 0 && ptr != 0) {
                this.mCloseGuard.open("Surface.release");
            } else if (j10 != 0 && ptr == 0) {
                this.mCloseGuard.close();
            }
            this.mNativeObject = ptr;
            this.mGenerationId++;
            HwuiContext hwuiContext = this.mHwuiContext;
            if (hwuiContext != null) {
                hwuiContext.updateSurface();
            }
        }
    }

    private void checkNotReleasedLocked() {
        if (this.mNativeObject == 0) {
            throw new IllegalStateException("Surface has already been released.");
        }
    }

    public void allocateBuffers() {
        synchronized (this.mLock) {
            checkNotReleasedLocked();
            nativeAllocateBuffers(this.mNativeObject);
        }
    }

    public void setScalingMode(int scalingMode) {
        synchronized (this.mLock) {
            checkNotReleasedLocked();
            int err = nativeSetScalingMode(this.mNativeObject, scalingMode);
            if (err != 0) {
                throw new IllegalArgumentException("Invalid scaling mode: " + scalingMode);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void forceScopedDisconnect() {
        synchronized (this.mLock) {
            checkNotReleasedLocked();
            int err = nativeForceScopedDisconnect(this.mNativeObject);
            if (err != 0) {
                throw new RuntimeException("Failed to disconnect Surface instance (bad object?)");
            }
        }
    }

    public void attachAndQueueBufferWithColorSpace(HardwareBuffer buffer, ColorSpace colorSpace) {
        synchronized (this.mLock) {
            checkNotReleasedLocked();
            if (colorSpace == null) {
                colorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
            }
            int err = nativeAttachAndQueueBufferWithColorSpace(this.mNativeObject, buffer, colorSpace.getId());
            if (err != 0) {
                throw new RuntimeException("Failed to attach and queue buffer to Surface (bad object?), native error: " + err);
            }
        }
    }

    public boolean isSingleBuffered() {
        return this.mIsSingleBuffered;
    }

    public void setSharedBufferModeEnabled(boolean enabled) {
        if (this.mIsSharedBufferModeEnabled != enabled) {
            int error = nativeSetSharedBufferModeEnabled(this.mNativeObject, enabled);
            if (error != 0) {
                throw new RuntimeException("Failed to set shared buffer mode on Surface (bad object?)");
            }
            this.mIsSharedBufferModeEnabled = enabled;
        }
    }

    public boolean isSharedBufferModeEnabled() {
        return this.mIsSharedBufferModeEnabled;
    }

    public void setAutoRefreshEnabled(boolean enabled) {
        if (this.mIsAutoRefreshEnabled != enabled) {
            int error = nativeSetAutoRefreshEnabled(this.mNativeObject, enabled);
            if (error != 0) {
                throw new RuntimeException("Failed to set auto refresh on Surface (bad object?)");
            }
            this.mIsAutoRefreshEnabled = enabled;
        }
    }

    public boolean isAutoRefreshEnabled() {
        return this.mIsAutoRefreshEnabled;
    }

    public void setFrameRate(float frameRate, int compatibility, int changeFrameRateStrategy) {
        synchronized (this.mLock) {
            checkNotReleasedLocked();
            int error = nativeSetFrameRate(this.mNativeObject, frameRate, compatibility, changeFrameRateStrategy);
            if (error == (-OsConstants.EINVAL)) {
                throw new IllegalArgumentException("Invalid argument to Surface.setFrameRate()");
            }
            if (error != 0) {
                throw new RuntimeException("Failed to set frame rate on Surface. Native error: " + error);
            }
        }
    }

    public void clearFrameRate() {
        synchronized (this.mLock) {
            checkNotReleasedLocked();
            int error = nativeSetFrameRate(this.mNativeObject, 0.0f, 0, 0);
            if (error != 0) {
                throw new RuntimeException("Failed to clear the frame rate on Surface. Native error: " + error);
            }
        }
    }

    public void setFrameRate(float frameRate, int compatibility) {
        setFrameRate(frameRate, compatibility, 0);
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class OutOfResourcesException extends RuntimeException {
        public OutOfResourcesException() {
        }

        public OutOfResourcesException(String name) {
            super(name);
        }
    }

    public static String rotationToString(int rotation) {
        switch (rotation) {
            case 0:
                return "ROTATION_0";
            case 1:
                return "ROTATION_90";
            case 2:
                return "ROTATION_180";
            case 3:
                return "ROTATION_270";
            default:
                return Integer.toString(rotation);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    private final class CompatibleCanvas extends Canvas {
        private Matrix mOrigMatrix;

        private CompatibleCanvas() {
            this.mOrigMatrix = null;
        }

        @Override // android.graphics.Canvas
        public void setMatrix(Matrix matrix) {
            Matrix matrix2;
            if (Surface.this.mCompatibleMatrix == null || (matrix2 = this.mOrigMatrix) == null || matrix2.equals(matrix)) {
                super.setMatrix(matrix);
                return;
            }
            Matrix m10 = new Matrix(Surface.this.mCompatibleMatrix);
            m10.preConcat(matrix);
            super.setMatrix(m10);
        }

        @Override // android.graphics.Canvas
        public void getMatrix(Matrix m10) {
            super.getMatrix(m10);
            if (this.mOrigMatrix == null) {
                this.mOrigMatrix = new Matrix();
            }
            this.mOrigMatrix.set(m10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public final class HwuiContext {
        private RecordingCanvas mCanvas;
        private HardwareRenderer mHardwareRenderer;
        private final boolean mIsWideColorGamut;
        private final RenderNode mRenderNode;

        HwuiContext(boolean isWideColorGamut) {
            RenderNode create = RenderNode.create("HwuiCanvas", null);
            this.mRenderNode = create;
            create.setClipToBounds(false);
            create.setForceDarkAllowed(false);
            this.mIsWideColorGamut = isWideColorGamut;
            HardwareRenderer hardwareRenderer = new HardwareRenderer();
            this.mHardwareRenderer = hardwareRenderer;
            hardwareRenderer.setContentRoot(create);
            this.mHardwareRenderer.setSurface(Surface.this, true);
            this.mHardwareRenderer.setColorMode(isWideColorGamut ? 1 : 0);
            this.mHardwareRenderer.setLightSourceAlpha(0.0f, 0.0f);
            this.mHardwareRenderer.setLightSourceGeometry(0.0f, 0.0f, 0.0f, 0.0f);
        }

        Canvas lockCanvas(int width, int height) {
            if (this.mCanvas != null) {
                throw new IllegalStateException("Surface was already locked!");
            }
            RecordingCanvas beginRecording = this.mRenderNode.beginRecording(width, height);
            this.mCanvas = beginRecording;
            return beginRecording;
        }

        void unlockAndPost(Canvas canvas) {
            if (canvas != this.mCanvas) {
                throw new IllegalArgumentException("canvas object must be the same instance that was previously returned by lockCanvas");
            }
            this.mRenderNode.endRecording();
            this.mCanvas = null;
            this.mHardwareRenderer.createRenderRequest().setVsyncTime(System.nanoTime()).syncAndDraw();
        }

        void updateSurface() {
            this.mHardwareRenderer.setSurface(Surface.this, true);
        }

        void destroy() {
            this.mHardwareRenderer.destroy();
        }

        boolean isWideColorGamut() {
            return this.mIsWideColorGamut;
        }
    }

    public ISurfaceExt getSurfaceExt() {
        return this.mSurfaceExt;
    }

    public ISurfaceWrapper getWrapper() {
        return this.mSurfaceWrapper;
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    private class SurfaceWrapper implements ISurfaceWrapper {
        private SurfaceWrapper() {
        }

        @Override // android.view.ISurfaceWrapper
        public Object getLock() {
            return Surface.this.mLock;
        }

        @Override // android.view.ISurfaceWrapper
        public long getNativeObject() {
            return Surface.this.mNativeObject;
        }
    }
}
