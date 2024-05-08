package android.view;

import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import android.graphics.GraphicBuffer;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Region;
import android.hardware.HardwareBuffer;
import android.hardware.OverlayProperties;
import android.hardware.SyncFence;
import android.hardware.display.DeviceProductInfo;
import android.hardware.display.DisplayManager;
import android.hardware.display.DisplayManagerGlobal;
import android.hardware.display.DisplayedContentSample;
import android.hardware.display.DisplayedContentSamplingAttributes;
import android.hardware.display.IDisplayManager;
import android.hardware.display.IVirtualDisplayCallback;
import android.hardware.display.VirtualDisplay;
import android.hardware.graphics.common.DisplayDecorationSupport;
import android.os.Build;
import android.os.Debug;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.SystemProperties;
import android.os.Trace;
import android.util.ArrayMap;
import android.util.Log;
import android.util.Size;
import android.util.Slog;
import android.util.SparseIntArray;
import android.util.proto.ProtoOutputStream;
import android.view.Display;
import android.view.Surface;
import android.view.SurfaceControl;
import com.alipay.sdk.util.i;
import com.android.internal.util.Preconditions;
import com.android.internal.util.VirtualRefBasePtr;
import com.huawei.quickcard.base.Attributes;
import dalvik.system.CloseGuard;
import java.io.Closeable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.function.Consumer;
import libcore.util.NativeAllocationRegistry;
import system.ext.loader.core.ExtLoader;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public final class SurfaceControl implements Parcelable {
    public static final int AOD_FLAGS = 2097152;
    public static final int BUFFER_TRANSFORM_IDENTITY = 0;
    public static final int BUFFER_TRANSFORM_MIRROR_HORIZONTAL = 1;
    public static final int BUFFER_TRANSFORM_MIRROR_VERTICAL = 2;
    public static final int BUFFER_TRANSFORM_ROTATE_180 = 3;
    public static final int BUFFER_TRANSFORM_ROTATE_270 = 7;
    public static final int BUFFER_TRANSFORM_ROTATE_90 = 4;
    public static final int CACHING_DISABLED = 0;
    public static final int CACHING_ENABLED = 1;
    public static final int CAST_FLAGS = 32;
    public static final Parcelable.Creator<SurfaceControl> CREATOR;
    public static final int CURSOR_WINDOW = 8192;
    private static final boolean DEBUG_ALL;
    private static final int DEBUG_DEPTH;
    private static boolean DEBUG_EGINGTEST = false;
    private static boolean DEBUG_LOGALWAYS_ON = SystemProperties.getBoolean("persist.sys.alwayson.enable", false);
    private static boolean DEBUG_SFC = false;
    private static boolean DEBUG_SFC_PRE_VERSION = false;
    public static final int DISPLAY_DECORATION = 512;
    public static final int DISPLAY_RECEIVES_INPUT = 1;
    public static final int EDR_AUXILIARY_IMAGE = 100;
    public static final int EDR_IMAGE_METADATA = 101;
    public static final int ENABLE_BACKPRESSURE = 256;
    public static final int FX_SURFACE_BLAST = 262144;
    public static final int FX_SURFACE_CONTAINER = 524288;
    public static final int FX_SURFACE_EFFECT = 131072;
    public static final int FX_SURFACE_MASK = 983040;
    public static final int FX_SURFACE_NORMAL = 0;
    public static final int HIDDEN = 4;
    private static final int MAX_VALUE = 16384;
    public static final int METADATA_ACCESSIBILITY_ID = 5;
    public static final int METADATA_GAME_MODE = 8;
    public static final int METADATA_MOUSE_CURSOR = 4;
    public static final int METADATA_OWNER_PID = 6;
    public static final int METADATA_OWNER_UID = 1;
    public static final int METADATA_TASK_ID = 3;
    public static final int METADATA_WINDOW_TYPE = 2;
    public static final int NON_PREMULTIPLIED = 256;
    public static final int NO_COLOR_FILL = 16384;
    public static final int OPAQUE = 1024;
    public static final int POWER_MODE_DOZE = 1;
    public static final int POWER_MODE_DOZE_SUSPEND = 3;
    public static final int POWER_MODE_NORMAL = 2;
    public static final int POWER_MODE_OFF = 0;
    public static final int POWER_MODE_ON_SUSPEND = 4;
    public static final int PROTECTED_APP = 2048;
    public static final int SECURE = 128;
    public static final int SKIP_SCREENSHOT = 64;
    private static final int SURFACE_HIDDEN = 1;
    private static final int SURFACE_OPAQUE = 2;
    private static final String TAG = "SurfaceControl";
    private static volatile boolean sDebugUsageAfterRelease;
    static GlobalTransactionWrapper sGlobalTransaction;
    private static final NativeAllocationRegistry sRegistry;
    static long sTransactionNestCount;
    private String mCallsite;
    private Choreographer mChoreographer;
    private final Object mChoreographerLock;
    private final CloseGuard mCloseGuard;
    private Runnable mFreeNativeResources;
    private int mHeight;
    private WeakReference<View> mLocalOwnerView;
    private final Object mLock;
    private String mName;
    private long mNativeHandle;
    public long mNativeObject;
    private Throwable mReleaseStack;
    private ArrayList<OnReparentListener> mReparentListeners;
    public ISurfaceControlExt mSurfaceControlExt;
    private TrustedPresentationCallback mTrustedPresentationCallback;
    private int mWidth;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public @interface BufferTransform {
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public @interface CachingHint {
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static final class CieXyz {
        public float X;
        public float Y;
        public float Z;
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static final class DisplayPrimaries {
        public CieXyz blue;
        public CieXyz green;
        public CieXyz red;
        public CieXyz white;
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static abstract class OnJankDataListener {
        private final VirtualRefBasePtr mNativePtr = new VirtualRefBasePtr(SurfaceControl.nativeCreateJankDataListenerWrapper(this));

        public abstract void onJankDataAvailable(JankData[] jankDataArr);
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public interface OnReparentListener {
        void onReparent(Transaction transaction, SurfaceControl surfaceControl);
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public interface TransactionCommittedListener {
        void onTransactionCommitted();
    }

    /* renamed from: -$$Nest$smgetNativeTrustedPresentationCallbackFinalizer, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m232$$Nest$smgetNativeTrustedPresentationCallbackFinalizer() {
        return getNativeTrustedPresentationCallbackFinalizer();
    }

    /* renamed from: -$$Nest$smnativeCreateTransaction, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m240$$Nest$smnativeCreateTransaction() {
        return nativeCreateTransaction();
    }

    /* renamed from: -$$Nest$smnativeGetDefaultApplyToken, reason: not valid java name */
    static /* bridge */ /* synthetic */ IBinder m241$$Nest$smnativeGetDefaultApplyToken() {
        return nativeGetDefaultApplyToken();
    }

    /* renamed from: -$$Nest$smnativeGetNativeTransactionFinalizer, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m242$$Nest$smnativeGetNativeTransactionFinalizer() {
        return nativeGetNativeTransactionFinalizer();
    }

    private static native long getNativeTrustedPresentationCallbackFinalizer();

    private static native void nativeAddJankDataListener(long j10, long j11);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeAddTransactionCommittedListener(long j10, TransactionCommittedListener transactionCommittedListener);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeAddWindowInfosReportedListener(long j10, Runnable runnable);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeApplyTransaction(long j10, boolean z10);

    private static native boolean nativeBootFinished();

    private static native boolean nativeClearAnimationFrameStats();

    private static native void nativeClearBootDisplayMode(IBinder iBinder);

    private static native boolean nativeClearContentFrameStats(long j10);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeClearTransaction(long j10);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeClearTrustedPresentationCallback(long j10, long j11);

    private static native long nativeCopyFromSurfaceControl(long j10);

    private static native long nativeCreate(SurfaceSession surfaceSession, String str, int i10, int i11, int i12, int i13, long j10, Parcel parcel) throws Surface.OutOfResourcesException;

    /* JADX INFO: Access modifiers changed from: private */
    public static native long nativeCreateJankDataListenerWrapper(OnJankDataListener onJankDataListener);

    /* JADX INFO: Access modifiers changed from: private */
    public static native long nativeCreateTpc(TrustedPresentationCallback trustedPresentationCallback);

    private static native long nativeCreateTransaction();

    private static native void nativeDisconnect(long j10);

    private static native boolean nativeGetAnimationFrameStats(WindowAnimationFrameStats windowAnimationFrameStats);

    private static native boolean nativeGetBootDisplayModeSupport();

    private static native int[] nativeGetCompositionDataspaces();

    private static native boolean nativeGetContentFrameStats(long j10, WindowContentFrameStats windowContentFrameStats);

    private static native IBinder nativeGetDefaultApplyToken();

    private static native DesiredDisplayModeSpecs nativeGetDesiredDisplayModeSpecs(IBinder iBinder);

    private static native boolean nativeGetDisplayBrightnessSupport(IBinder iBinder);

    private static native DisplayDecorationSupport nativeGetDisplayDecorationSupport(IBinder iBinder);

    private static native DisplayPrimaries nativeGetDisplayNativePrimaries(IBinder iBinder);

    private static native DisplayedContentSample nativeGetDisplayedContentSample(IBinder iBinder, long j10, long j11);

    private static native DisplayedContentSamplingAttributes nativeGetDisplayedContentSamplingAttributes(IBinder iBinder);

    private static native DynamicDisplayInfo nativeGetDynamicDisplayInfo(long j10);

    private static native int nativeGetGPUContextPriority();

    private static native long nativeGetHandle(long j10);

    private static native int nativeGetLayerId(long j10);

    private static native long nativeGetNativeSurfaceControlFinalizer();

    private static native long nativeGetNativeTransactionFinalizer();

    private static native OverlayProperties nativeGetOverlaySupport();

    private static native boolean nativeGetProtectedContentSupport();

    private static native StaticDisplayInfo nativeGetStaticDisplayInfo(long j10);

    /* JADX INFO: Access modifiers changed from: private */
    public static native long nativeGetTransactionId(long j10);

    private static native int nativeGetTransformHint(long j10);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeMergeTransaction(long j10, long j11);

    private static native long nativeMirrorSurface(long j10);

    private static native long nativeReadFromParcel(Parcel parcel);

    /* JADX INFO: Access modifiers changed from: private */
    public static native long nativeReadTransactionFromParcel(Parcel parcel);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeRemoveCurrentInputFocus(long j10, int i10);

    private static native void nativeRemoveJankDataListener(long j10);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeReparent(long j10, long j11, long j12);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeSanitize(long j10, int i10, int i11);

    private static native boolean nativeSetActiveColorMode(IBinder iBinder, int i10);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeSetAlpha(long j10, long j11, float f10);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeSetAnimationTransaction(long j10);

    private static native void nativeSetAutoLowLatencyMode(IBinder iBinder, boolean z10);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeSetBackgroundBlurRadius(long j10, long j11, int i10);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeSetBlurColor(long j10, long j11, float f10, float f11, float f12, float f13);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeSetBlurRegions(long j10, long j11, float[][] fArr, int i10);

    private static native void nativeSetBootDisplayMode(IBinder iBinder, int i10);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeSetBuffer(long j10, long j11, HardwareBuffer hardwareBuffer, long j12, Consumer<SyncFence> consumer);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeSetBufferTransform(long j10, long j11, int i10);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeSetCachingHint(long j10, long j11, int i10);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeSetColor(long j10, long j11, float[] fArr);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeSetColorSpaceAgnostic(long j10, long j11, boolean z10);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeSetColorTransform(long j10, long j11, float[] fArr, float[] fArr2);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeSetCornerRadius(long j10, long j11, float f10);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeSetDamageRegion(long j10, long j11, Region region);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeSetDataSpace(long j10, long j11, int i10);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeSetDefaultApplyToken(IBinder iBinder);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeSetDefaultFrameRateCompatibility(long j10, long j11, int i10);

    private static native boolean nativeSetDesiredDisplayModeSpecs(IBinder iBinder, DesiredDisplayModeSpecs desiredDisplayModeSpecs);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeSetDestinationFrame(long j10, long j11, int i10, int i11, int i12, int i13);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeSetDimmingEnabled(long j10, long j11, boolean z10);

    private static native boolean nativeSetDisplayBrightness(IBinder iBinder, float f10, float f11, float f12, float f13);

    private static native boolean nativeSetDisplayBrightnessWithColor(IBinder iBinder, float f10, float f11, float f12, float f13, float f14, float f15, float f16, int i10, boolean z10);

    private static native boolean nativeSetDisplayBrightnessWithLevel(IBinder iBinder, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17, int i10, boolean z10);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeSetDisplayFlags(long j10, IBinder iBinder, int i10);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeSetDisplayLayerStack(long j10, IBinder iBinder, int i10);

    private static native void nativeSetDisplayPowerMode(IBinder iBinder, int i10);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeSetDisplayProjection(long j10, IBinder iBinder, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeSetDisplaySize(long j10, IBinder iBinder, int i10, int i11);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeSetDisplaySurface(long j10, IBinder iBinder, long j11);

    private static native boolean nativeSetDisplayedContentSamplingEnabled(IBinder iBinder, boolean z10, int i10, int i11);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeSetDropInputMode(long j10, long j11, int i10);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeSetEarlyWakeupEnd(long j10);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeSetEarlyWakeupStart(long j10);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeSetEdrFlags(long j10, long j11, int i10);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeSetEdrImageSize(long j10, long j11, int i10, int i11, int i12);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeSetEdrMetadata(long j10, long j11, int i10, Parcel parcel, int i11);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeSetEdrViewTransform(long j10, long j11, int i10, int i11, int i12, int i13, Rect rect, float[] fArr);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeSetExtendedRangeBrightness(long j10, long j11, float f10, float f11);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeSetFixedTransformHint(long j10, long j11, int i10);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeSetFlags(long j10, long j11, int i10, int i11);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeSetFocusedWindow(long j10, IBinder iBinder, String str, int i10);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeSetFrameRate(long j10, long j11, float f10, int i10, int i11);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeSetFrameRateSelectionPriority(long j10, long j11, int i10);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeSetFrameTimelineVsync(long j10, long j11);

    private static native void nativeSetGameContentType(IBinder iBinder, boolean z10);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeSetGeometry(long j10, long j11, Rect rect, Rect rect2, long j12);

    private static native void nativeSetGlobalShadowSettings(float[] fArr, float[] fArr2, float f10, float f11, float f12);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeSetInputWindowInfo(long j10, long j11, InputWindowHandle inputWindowHandle);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeSetLayer(long j10, long j11, int i10);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeSetLayerStack(long j10, long j11, int i10);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeSetMatrix(long j10, long j11, float f10, float f11, float f12, float f13);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeSetMetadata(long j10, long j11, int i10, Parcel parcel);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeSetPosition(long j10, long j11, float f10, float f11);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeSetRelativeLayer(long j10, long j11, long j12, int i10);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeSetScale(long j10, long j11, float f10, float f11);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeSetShadowRadius(long j10, long j11, float f10);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeSetStretchEffect(long j10, long j11, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18, float f19);

    private static native void nativeSetTransformHint(long j10, int i10);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeSetTransparentRegionHint(long j10, long j11, Region region);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeSetTrustedOverlay(long j10, long j11, boolean z10);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeSetTrustedPresentationCallback(long j10, long j11, long j12, TrustedPresentationThresholds trustedPresentationThresholds);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeSetWindowCrop(long j10, long j11, int i10, int i11, int i12, int i13);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeSurfaceFlushJankData(long j10);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeUnsetBuffer(long j10, long j11);

    private static native void nativeUpdateDefaultBufferSize(long j10, int i10, int i11);

    private static native void nativeWriteToParcel(long j10, Parcel parcel);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeWriteTransactionToParcel(long j10, Parcel parcel);

    static {
        boolean z10 = !"0".equals(SystemProperties.get("persist.sys.agingtest", "0"));
        DEBUG_EGINGTEST = z10;
        DEBUG_SFC = !z10 && SystemProperties.getBoolean("persist.sys.assert.panic", false);
        DEBUG_SFC_PRE_VERSION = !DEBUG_EGINGTEST && DEBUG_LOGALWAYS_ON;
        DEBUG_ALL = SystemProperties.getBoolean("debug.surfacectrl", false);
        DEBUG_DEPTH = SystemProperties.getInt("debug.surfacectrl.depth", 10);
        sDebugUsageAfterRelease = false;
        sTransactionNestCount = 0L;
        sRegistry = NativeAllocationRegistry.createMalloced(SurfaceControl.class.getClassLoader(), nativeGetNativeSurfaceControlFinalizer());
        CREATOR = new Parcelable.Creator<SurfaceControl>() { // from class: android.view.SurfaceControl.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SurfaceControl createFromParcel(Parcel in) {
                return new SurfaceControl(in);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SurfaceControl[] newArray(int size) {
                return new SurfaceControl[size];
            }
        };
    }

    public static int rotationToBufferTransform(int rotation) {
        switch (rotation) {
            case 0:
                return 0;
            case 1:
                return 4;
            case 2:
                return 3;
            case 3:
                return 7;
            default:
                Log.e(TAG, "Trying to convert unknown rotation=" + rotation);
                return 0;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class JankData {
        public static final int BUFFER_STUFFING = 64;
        public static final int DISPLAY_HAL = 1;
        public static final int JANK_APP_DEADLINE_MISSED = 8;
        public static final int JANK_NONE = 0;
        public static final int JANK_SURFACEFLINGER_DEADLINE_MISSED = 2;
        public static final int JANK_SURFACEFLINGER_GPU_DEADLINE_MISSED = 4;
        public static final int PREDICTION_ERROR = 16;
        public static final int SURFACE_FLINGER_SCHEDULING = 32;
        public static final int UNKNOWN = 128;
        public final long frameVsyncId;
        public final int jankType;

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
        public @interface JankType {
        }

        public JankData(long frameVsyncId, int jankType) {
            this.frameVsyncId = frameVsyncId;
            this.jankType = jankType;
        }
    }

    public boolean addOnReparentListener(OnReparentListener listener) {
        boolean add;
        synchronized (this.mLock) {
            if (this.mReparentListeners == null) {
                this.mReparentListeners = new ArrayList<>(1);
            }
            add = this.mReparentListeners.add(listener);
        }
        return add;
    }

    public boolean removeOnReparentListener(OnReparentListener listener) {
        boolean removed;
        synchronized (this.mLock) {
            removed = this.mReparentListeners.remove(listener);
            if (this.mReparentListeners.isEmpty()) {
                this.mReparentListeners = null;
            }
        }
        return removed;
    }

    private void assignNativeObject(long nativeObject, String callsite) {
        if (this.mNativeObject != 0) {
            release();
        }
        if (nativeObject != 0) {
            this.mFreeNativeResources = sRegistry.registerNativeAllocation(this, nativeObject);
        }
        this.mNativeObject = nativeObject;
        this.mNativeHandle = nativeObject != 0 ? nativeGetHandle(nativeObject) : 0L;
        if (sDebugUsageAfterRelease && this.mNativeObject == 0) {
            this.mReleaseStack = new Throwable("Assigned invalid nativeObject");
        } else {
            this.mReleaseStack = null;
        }
        setUnreleasedWarningCallSite(callsite);
        if (nativeObject != 0) {
            addToRegistry();
        }
    }

    public void copyFrom(SurfaceControl other, String callsite) {
        this.mName = other.mName;
        this.mWidth = other.mWidth;
        this.mHeight = other.mHeight;
        this.mLocalOwnerView = other.mLocalOwnerView;
        assignNativeObject(nativeCopyFromSurfaceControl(other.mNativeObject), callsite);
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class Builder {
        private int mHeight;
        private WeakReference<View> mLocalOwnerView;
        private SparseIntArray mMetadata;
        private String mName;
        private SurfaceControl mParent;
        private SurfaceSession mSession;
        private int mWidth;
        private int mFlags = 4;
        private int mFormat = -1;
        private String mCallsite = "SurfaceControl.Builder";

        public Builder(SurfaceSession session) {
            this.mSession = session;
        }

        public Builder() {
        }

        public SurfaceControl build() {
            int i10;
            int i11 = this.mWidth;
            if (i11 < 0 || (i10 = this.mHeight) < 0) {
                throw new IllegalStateException("width and height must be positive or unset");
            }
            if ((i11 > 0 || i10 > 0) && (isEffectLayer() || isContainerLayer())) {
                throw new IllegalStateException("Only buffer layers can set a valid buffer size.");
            }
            if (this.mName == null) {
                Log.w(SurfaceControl.TAG, "Missing name for SurfaceControl", new Throwable());
            }
            if ((this.mFlags & SurfaceControl.FX_SURFACE_MASK) == 0) {
                setBLASTLayer();
            }
            return new SurfaceControl(this.mSession, this.mName, this.mWidth, this.mHeight, this.mFormat, this.mFlags, this.mParent, this.mMetadata, this.mLocalOwnerView, this.mCallsite);
        }

        public Builder setName(String name) {
            this.mName = name;
            return this;
        }

        public Builder setLocalOwnerView(View view) {
            this.mLocalOwnerView = new WeakReference<>(view);
            return this;
        }

        public Builder setBufferSize(int width, int height) {
            if (width < 0 || height < 0) {
                throw new IllegalArgumentException("width and height must be positive");
            }
            if (width > 16384 || height > 16384) {
                Log.i(SurfaceControl.TAG, ((Object) this) + " mSurfaceWidth = " + width + " mSurfaceHeight = " + height);
                throw new IllegalStateException("SurfaceView width and height must be smaller than 16384");
            }
            this.mWidth = width;
            this.mHeight = height;
            return setFlags(0, SurfaceControl.FX_SURFACE_MASK);
        }

        private void unsetBufferSize() {
            this.mWidth = 0;
            this.mHeight = 0;
        }

        public Builder setFormat(int format) {
            this.mFormat = format;
            return this;
        }

        public Builder setProtected(boolean protectedContent) {
            if (protectedContent) {
                this.mFlags |= 2048;
            } else {
                this.mFlags &= -2049;
            }
            return this;
        }

        public Builder setSecure(boolean secure) {
            if (secure) {
                this.mFlags |= 128;
            } else {
                this.mFlags &= -129;
            }
            return this;
        }

        public Builder setOpaque(boolean opaque) {
            if (opaque) {
                this.mFlags |= 1024;
            } else {
                this.mFlags &= -1025;
            }
            return this;
        }

        public Builder setHidden(boolean hidden) {
            if (hidden) {
                this.mFlags |= 4;
            } else {
                this.mFlags &= -5;
            }
            return this;
        }

        public Builder setParent(SurfaceControl parent) {
            this.mParent = parent;
            if (parent != null && parent.mSurfaceControlExt.isFingerprintType(this.mName)) {
                Log.i(SurfaceControl.TAG, "setParent sc " + ((Object) this) + ",parent=" + ((Object) parent) + " caller=" + Debug.getCallers(SurfaceControl.DEBUG_DEPTH));
            }
            return this;
        }

        public Builder setMetadata(int key, int data) {
            if (this.mMetadata == null) {
                this.mMetadata = new SparseIntArray();
            }
            this.mMetadata.put(key, data);
            return this;
        }

        public Builder setEffectLayer() {
            this.mFlags |= 16384;
            unsetBufferSize();
            return setFlags(131072, SurfaceControl.FX_SURFACE_MASK);
        }

        public Builder setColorLayer() {
            unsetBufferSize();
            return setFlags(131072, SurfaceControl.FX_SURFACE_MASK);
        }

        private boolean isEffectLayer() {
            return (this.mFlags & 131072) == 131072;
        }

        public Builder setBLASTLayer() {
            return setFlags(262144, SurfaceControl.FX_SURFACE_MASK);
        }

        public Builder setContainerLayer() {
            unsetBufferSize();
            return setFlags(524288, SurfaceControl.FX_SURFACE_MASK);
        }

        private boolean isContainerLayer() {
            return (this.mFlags & 524288) == 524288;
        }

        public Builder setFlags(int flags) {
            this.mFlags = flags;
            return this;
        }

        public Builder setCallsite(String callsite) {
            this.mCallsite = callsite;
            return this;
        }

        private Builder setFlags(int flags, int mask) {
            this.mFlags = (this.mFlags & (~mask)) | flags;
            return this;
        }
    }

    private SurfaceControl(SurfaceSession session, String name, int w3, int h10, int format, int flags, SurfaceControl parent, SparseIntArray metadata, WeakReference<View> localOwnerView, String callsite) throws Surface.OutOfResourcesException, IllegalArgumentException {
        Parcel metaParcel;
        this.mCloseGuard = CloseGuard.get();
        this.mSurfaceControlExt = (ISurfaceControlExt) ExtLoader.type(ISurfaceControlExt.class).create();
        this.mChoreographerLock = new Object();
        this.mLock = new Object();
        this.mReleaseStack = null;
        if (name == null) {
            throw new IllegalArgumentException("name must not be null");
        }
        this.mName = name;
        this.mWidth = w3;
        this.mHeight = h10;
        this.mLocalOwnerView = localOwnerView;
        Parcel metaParcel2 = Parcel.obtain();
        if (metadata != null) {
            try {
                if (metadata.size() > 0) {
                    metaParcel2.writeInt(metadata.size());
                    for (int i10 = 0; i10 < metadata.size(); i10++) {
                        metaParcel2.writeInt(metadata.keyAt(i10));
                        metaParcel2.writeByteArray(ByteBuffer.allocate(4).order(ByteOrder.nativeOrder()).putInt(metadata.valueAt(i10)).array());
                    }
                    metaParcel2.setDataPosition(0);
                }
            } catch (Throwable th) {
                th = th;
                metaParcel = metaParcel2;
                metaParcel.recycle();
                throw th;
            }
        }
        metaParcel = metaParcel2;
        try {
            long nativeObject = nativeCreate(session, name, w3, h10, format, flags, parent != null ? parent.mNativeObject : 0L, metaParcel);
            metaParcel.recycle();
            if (nativeObject == 0) {
                throw new Surface.OutOfResourcesException("Couldn't allocate SurfaceControl native object");
            }
            assignNativeObject(nativeObject, callsite);
        } catch (Throwable th2) {
            th = th2;
            metaParcel.recycle();
            throw th;
        }
    }

    public SurfaceControl(SurfaceControl other, String callsite) {
        this.mCloseGuard = CloseGuard.get();
        this.mSurfaceControlExt = (ISurfaceControlExt) ExtLoader.type(ISurfaceControlExt.class).create();
        this.mChoreographerLock = new Object();
        this.mLock = new Object();
        this.mReleaseStack = null;
        copyFrom(other, callsite);
    }

    private SurfaceControl(Parcel in) {
        this.mCloseGuard = CloseGuard.get();
        this.mSurfaceControlExt = (ISurfaceControlExt) ExtLoader.type(ISurfaceControlExt.class).create();
        this.mChoreographerLock = new Object();
        this.mLock = new Object();
        this.mReleaseStack = null;
        readFromParcel(in);
    }

    public SurfaceControl() {
        this.mCloseGuard = CloseGuard.get();
        this.mSurfaceControlExt = (ISurfaceControlExt) ExtLoader.type(ISurfaceControlExt.class).create();
        this.mChoreographerLock = new Object();
        this.mLock = new Object();
        this.mReleaseStack = null;
    }

    public void readFromParcel(Parcel in) {
        if (in == null) {
            throw new IllegalArgumentException("source must not be null");
        }
        this.mName = in.readString8();
        this.mWidth = in.readInt();
        this.mHeight = in.readInt();
        long object = 0;
        if (in.readInt() != 0) {
            object = nativeReadFromParcel(in);
        }
        assignNativeObject(object, "readFromParcel");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        if (sDebugUsageAfterRelease) {
            checkNotReleased();
        }
        dest.writeString8(this.mName);
        dest.writeInt(this.mWidth);
        dest.writeInt(this.mHeight);
        if (this.mNativeObject == 0) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
        }
        nativeWriteToParcel(this.mNativeObject, dest);
        if ((flags & 1) != 0) {
            release();
        }
    }

    public static void setDebugUsageAfterRelease(boolean debug) {
        if (!Build.isDebuggable()) {
            return;
        }
        sDebugUsageAfterRelease = debug;
    }

    public void setUnreleasedWarningCallSite(String callsite) {
        if (!isValid()) {
            return;
        }
        this.mCloseGuard.openWithCallSite("release", callsite);
        this.mCallsite = callsite;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getCallsite() {
        return this.mCallsite;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getName() {
        return this.mName;
    }

    public boolean isSameSurface(SurfaceControl other) {
        return other.mNativeHandle == this.mNativeHandle;
    }

    public Choreographer getChoreographer() {
        checkNotReleased();
        synchronized (this.mChoreographerLock) {
            Choreographer choreographer = this.mChoreographer;
            if (choreographer != null) {
                return choreographer;
            }
            return getChoreographer(Looper.myLooper());
        }
    }

    public Choreographer getChoreographer(Looper looper) {
        Choreographer choreographer;
        checkNotReleased();
        synchronized (this.mChoreographerLock) {
            Choreographer choreographer2 = this.mChoreographer;
            if (choreographer2 == null) {
                this.mChoreographer = Choreographer.getInstanceForSurfaceControl(this.mNativeHandle, looper);
            } else if (!choreographer2.isTheLooperSame(looper)) {
                throw new IllegalStateException("Choreographer already exists with a different looper");
            }
            choreographer = this.mChoreographer;
        }
        return choreographer;
    }

    public boolean hasChoreographer() {
        boolean z10;
        synchronized (this.mChoreographerLock) {
            z10 = this.mChoreographer != null;
        }
        return z10;
    }

    public void dumpDebug(ProtoOutputStream proto, long fieldId) {
        long token = proto.start(fieldId);
        proto.write(1120986464257L, System.identityHashCode(this));
        proto.write(1138166333442L, this.mName);
        proto.write(1120986464259L, getLayerId());
        proto.end(token);
    }

    protected void finalize() throws Throwable {
        try {
            CloseGuard closeGuard = this.mCloseGuard;
            if (closeGuard != null) {
                closeGuard.warnIfOpen();
            }
            if (DEBUG_ALL) {
                Log.i(TAG, "SurfaceControl finalize:  this " + ((Object) this) + " caller=" + Debug.getCallers(5));
            }
            this.mNativeObject = 0L;
            this.mNativeHandle = 0L;
            removeFromRegistry();
        } finally {
            super.finalize();
        }
    }

    public void release() {
        if (this.mNativeObject != 0) {
            this.mFreeNativeResources.run();
            if (DEBUG_SFC || DEBUG_SFC_PRE_VERSION) {
                Log.i(TAG, "SurfaceControl release:  this " + ((Object) this) + " caller=" + Debug.getCallers(5));
            }
            this.mNativeObject = 0L;
            this.mNativeHandle = 0L;
            if (sDebugUsageAfterRelease) {
                this.mReleaseStack = new Throwable("Released");
            }
            this.mCloseGuard.close();
            synchronized (this.mChoreographerLock) {
                Choreographer choreographer = this.mChoreographer;
                if (choreographer != null) {
                    choreographer.invalidate();
                    this.mChoreographer = null;
                }
            }
            removeFromRegistry();
        }
    }

    public void disconnect() {
        long j10 = this.mNativeObject;
        if (j10 != 0) {
            nativeDisconnect(j10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkNotReleased() {
        if (this.mNativeObject == 0) {
            if (this.mReleaseStack != null) {
                throw new IllegalStateException("Invalid usage after release of " + ((Object) this), this.mReleaseStack);
            }
            throw new NullPointerException("mNativeObject of " + ((Object) this) + " is null. Have you called release() already?");
        }
    }

    public boolean isValid() {
        return this.mNativeObject != 0;
    }

    public static void openTransaction() {
        synchronized (SurfaceControl.class) {
            if (sGlobalTransaction == null) {
                sGlobalTransaction = new GlobalTransactionWrapper();
            }
            synchronized (SurfaceControl.class) {
                sTransactionNestCount++;
            }
        }
    }

    @Deprecated
    public static void mergeToGlobalTransaction(Transaction t2) {
        synchronized (SurfaceControl.class) {
            sGlobalTransaction.merge(t2);
        }
    }

    public static void closeTransaction() {
        synchronized (SurfaceControl.class) {
            long j10 = sTransactionNestCount;
            if (j10 == 0) {
                Log.e(TAG, "Call to SurfaceControl.closeTransaction without matching openTransaction");
            } else {
                long j11 = j10 - 1;
                sTransactionNestCount = j11;
                if (j11 > 0) {
                    return;
                }
            }
            sGlobalTransaction.applyGlobalTransaction(false);
        }
    }

    public boolean clearContentFrameStats() {
        checkNotReleased();
        return nativeClearContentFrameStats(this.mNativeObject);
    }

    public boolean getContentFrameStats(WindowContentFrameStats outStats) {
        checkNotReleased();
        return nativeGetContentFrameStats(this.mNativeObject, outStats);
    }

    public static boolean clearAnimationFrameStats() {
        return nativeClearAnimationFrameStats();
    }

    public static boolean getAnimationFrameStats(WindowAnimationFrameStats outStats) {
        return nativeGetAnimationFrameStats(outStats);
    }

    public int getWidth() {
        int i10;
        synchronized (this.mLock) {
            i10 = this.mWidth;
        }
        return i10;
    }

    public int getHeight() {
        int i10;
        synchronized (this.mLock) {
            i10 = this.mHeight;
        }
        return i10;
    }

    public View getLocalOwnerView() {
        WeakReference<View> weakReference = this.mLocalOwnerView;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public String toString() {
        return "Surface(name=" + this.mName + ")/@0x" + Integer.toHexString(System.identityHashCode(this));
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static final class StaticDisplayInfo {
        public float density;
        public DeviceProductInfo deviceProductInfo;
        public int installOrientation;
        public boolean isInternal;
        public boolean secure;

        public String toString() {
            return "StaticDisplayInfo{isInternal=" + this.isInternal + ", density=" + this.density + ", secure=" + this.secure + ", deviceProductInfo=" + ((Object) this.deviceProductInfo) + ", installOrientation=" + this.installOrientation + i.f4738d;
        }

        public boolean equals(Object o10) {
            if (this == o10) {
                return true;
            }
            if (o10 == null || getClass() != o10.getClass()) {
                return false;
            }
            StaticDisplayInfo that = (StaticDisplayInfo) o10;
            if (this.isInternal == that.isInternal && this.density == that.density && this.secure == that.secure && Objects.equals(this.deviceProductInfo, that.deviceProductInfo) && this.installOrientation == that.installOrientation) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return Objects.hash(Boolean.valueOf(this.isInternal), Float.valueOf(this.density), Boolean.valueOf(this.secure), this.deviceProductInfo, Integer.valueOf(this.installOrientation));
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static final class DynamicDisplayInfo {
        public int activeColorMode;
        public int activeDisplayModeId;
        public boolean autoLowLatencyModeSupported;
        public boolean gameContentTypeSupported;
        public Display.HdrCapabilities hdrCapabilities;
        public int preferredBootDisplayMode;
        public float renderFrameRate;
        public int[] supportedColorModes;
        public DisplayMode[] supportedDisplayModes;

        public String toString() {
            return "DynamicDisplayInfo{supportedDisplayModes=" + Arrays.toString(this.supportedDisplayModes) + ", activeDisplayModeId=" + this.activeDisplayModeId + ", renderFrameRate=" + this.renderFrameRate + ", supportedColorModes=" + Arrays.toString(this.supportedColorModes) + ", activeColorMode=" + this.activeColorMode + ", hdrCapabilities=" + ((Object) this.hdrCapabilities) + ", autoLowLatencyModeSupported=" + this.autoLowLatencyModeSupported + ", gameContentTypeSupported" + this.gameContentTypeSupported + ", preferredBootDisplayMode" + this.preferredBootDisplayMode + i.f4738d;
        }

        public boolean equals(Object o10) {
            if (this == o10) {
                return true;
            }
            if (o10 == null || getClass() != o10.getClass()) {
                return false;
            }
            DynamicDisplayInfo that = (DynamicDisplayInfo) o10;
            if (Arrays.equals(this.supportedDisplayModes, that.supportedDisplayModes) && this.activeDisplayModeId == that.activeDisplayModeId && this.renderFrameRate == that.renderFrameRate && Arrays.equals(this.supportedColorModes, that.supportedColorModes) && this.activeColorMode == that.activeColorMode && Objects.equals(this.hdrCapabilities, that.hdrCapabilities) && this.preferredBootDisplayMode == that.preferredBootDisplayMode) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return Objects.hash(Integer.valueOf(Arrays.hashCode(this.supportedDisplayModes)), Integer.valueOf(this.activeDisplayModeId), Float.valueOf(this.renderFrameRate), Integer.valueOf(this.activeColorMode), this.hdrCapabilities);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static final class DisplayMode {
        public long appVsyncOffsetNanos;
        public int group;
        public int height;

        /* renamed from: id, reason: collision with root package name */
        public int f813id;
        public long presentationDeadlineNanos;
        public float refreshRate;
        public int[] supportedHdrTypes;
        public int width;
        public float xDpi;
        public float yDpi;

        public String toString() {
            return "DisplayMode{id=" + this.f813id + ", width=" + this.width + ", height=" + this.height + ", xDpi=" + this.xDpi + ", yDpi=" + this.yDpi + ", refreshRate=" + this.refreshRate + ", appVsyncOffsetNanos=" + this.appVsyncOffsetNanos + ", presentationDeadlineNanos=" + this.presentationDeadlineNanos + ", supportedHdrTypes=" + Arrays.toString(this.supportedHdrTypes) + ", group=" + this.group + i.f4738d;
        }

        public boolean equals(Object o10) {
            if (this == o10) {
                return true;
            }
            if (o10 == null || getClass() != o10.getClass()) {
                return false;
            }
            DisplayMode that = (DisplayMode) o10;
            if (this.f813id == that.f813id && this.width == that.width && this.height == that.height && Float.compare(that.xDpi, this.xDpi) == 0 && Float.compare(that.yDpi, this.yDpi) == 0 && Float.compare(that.refreshRate, this.refreshRate) == 0 && this.appVsyncOffsetNanos == that.appVsyncOffsetNanos && this.presentationDeadlineNanos == that.presentationDeadlineNanos && Arrays.equals(this.supportedHdrTypes, that.supportedHdrTypes) && this.group == that.group) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return Objects.hash(Integer.valueOf(this.f813id), Integer.valueOf(this.width), Integer.valueOf(this.height), Float.valueOf(this.xDpi), Float.valueOf(this.yDpi), Float.valueOf(this.refreshRate), Long.valueOf(this.appVsyncOffsetNanos), Long.valueOf(this.presentationDeadlineNanos), Integer.valueOf(this.group), Integer.valueOf(Arrays.hashCode(this.supportedHdrTypes)));
        }
    }

    public static void setDisplayPowerMode(IBinder displayToken, int mode) {
        if (displayToken == null) {
            throw new IllegalArgumentException("displayToken must not be null");
        }
        nativeSetDisplayPowerMode(displayToken, mode);
    }

    public static StaticDisplayInfo getStaticDisplayInfo(long displayId) {
        return nativeGetStaticDisplayInfo(displayId);
    }

    public static DynamicDisplayInfo getDynamicDisplayInfo(long displayId) {
        return nativeGetDynamicDisplayInfo(displayId);
    }

    public static DisplayedContentSamplingAttributes getDisplayedContentSamplingAttributes(IBinder displayToken) {
        if (displayToken == null) {
            throw new IllegalArgumentException("displayToken must not be null");
        }
        return nativeGetDisplayedContentSamplingAttributes(displayToken);
    }

    public static boolean setDisplayedContentSamplingEnabled(IBinder displayToken, boolean enable, int componentMask, int maxFrames) {
        if (displayToken == null) {
            throw new IllegalArgumentException("displayToken must not be null");
        }
        if ((componentMask >> 4) != 0) {
            throw new IllegalArgumentException("invalid componentMask when enabling sampling");
        }
        return nativeSetDisplayedContentSamplingEnabled(displayToken, enable, componentMask, maxFrames);
    }

    public static DisplayedContentSample getDisplayedContentSample(IBinder displayToken, long maxFrames, long timestamp) {
        if (displayToken == null) {
            throw new IllegalArgumentException("displayToken must not be null");
        }
        return nativeGetDisplayedContentSample(displayToken, maxFrames, timestamp);
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static final class RefreshRateRange implements Parcelable {
        public static final Parcelable.Creator<RefreshRateRange> CREATOR = new Parcelable.Creator<RefreshRateRange>() { // from class: android.view.SurfaceControl.RefreshRateRange.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public RefreshRateRange createFromParcel(Parcel in) {
                return new RefreshRateRange(in.readFloat(), in.readFloat());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public RefreshRateRange[] newArray(int size) {
                return new RefreshRateRange[size];
            }
        };
        public static final float FLOAT_TOLERANCE = 0.01f;
        public static final String TAG = "RefreshRateRange";
        public float max;
        public float min;

        public RefreshRateRange() {
        }

        public RefreshRateRange(float min, float max) {
            if (min < 0.0f || max < 0.0f || min > 0.01f + max) {
                Slog.e(TAG, "Wrong values for min and max when initializing RefreshRateRange : " + min + " " + max);
                this.max = 0.0f;
                this.min = 0.0f;
            } else {
                if (min > max) {
                    min = max;
                    max = min;
                }
                this.min = min;
                this.max = max;
            }
        }

        public boolean equals(Object other) {
            if (other == this) {
                return true;
            }
            if (!(other instanceof RefreshRateRange)) {
                return false;
            }
            RefreshRateRange refreshRateRange = (RefreshRateRange) other;
            return this.min == refreshRateRange.min && this.max == refreshRateRange.max;
        }

        public int hashCode() {
            return Objects.hash(Float.valueOf(this.min), Float.valueOf(this.max));
        }

        public String toString() {
            return "(" + this.min + " " + this.max + ")";
        }

        public void copyFrom(RefreshRateRange other) {
            this.min = other.min;
            this.max = other.max;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeFloat(this.min);
            dest.writeFloat(this.max);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static final class RefreshRateRanges {
        public static final String TAG = "RefreshRateRanges";
        public final RefreshRateRange physical;
        public final RefreshRateRange render;

        public RefreshRateRanges() {
            this.physical = new RefreshRateRange();
            this.render = new RefreshRateRange();
        }

        public RefreshRateRanges(RefreshRateRange physical, RefreshRateRange render) {
            this.physical = new RefreshRateRange(physical.min, physical.max);
            this.render = new RefreshRateRange(render.min, render.max);
        }

        public boolean equals(Object other) {
            if (other == this) {
                return true;
            }
            if (!(other instanceof RefreshRateRanges)) {
                return false;
            }
            RefreshRateRanges rates = (RefreshRateRanges) other;
            return this.physical.equals(rates.physical) && this.render.equals(rates.render);
        }

        public int hashCode() {
            return Objects.hash(this.physical, this.render);
        }

        public String toString() {
            return "physical: " + ((Object) this.physical) + " render:  " + ((Object) this.render);
        }

        public void copyFrom(RefreshRateRanges other) {
            this.physical.copyFrom(other.physical);
            this.render.copyFrom(other.render);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static final class DesiredDisplayModeSpecs {
        public boolean allowGroupSwitching;
        public final RefreshRateRanges appRequestRanges;
        public int defaultMode;
        public final RefreshRateRanges primaryRanges;

        public DesiredDisplayModeSpecs() {
            this.primaryRanges = new RefreshRateRanges();
            this.appRequestRanges = new RefreshRateRanges();
        }

        public DesiredDisplayModeSpecs(DesiredDisplayModeSpecs other) {
            this.primaryRanges = new RefreshRateRanges();
            this.appRequestRanges = new RefreshRateRanges();
            copyFrom(other);
        }

        public DesiredDisplayModeSpecs(int defaultMode, boolean allowGroupSwitching, RefreshRateRanges primaryRanges, RefreshRateRanges appRequestRanges) {
            this.defaultMode = defaultMode;
            this.allowGroupSwitching = allowGroupSwitching;
            this.primaryRanges = new RefreshRateRanges(primaryRanges.physical, primaryRanges.render);
            this.appRequestRanges = new RefreshRateRanges(appRequestRanges.physical, appRequestRanges.render);
        }

        public boolean equals(Object o10) {
            return (o10 instanceof DesiredDisplayModeSpecs) && equals((DesiredDisplayModeSpecs) o10);
        }

        public boolean equals(DesiredDisplayModeSpecs other) {
            return other != null && this.defaultMode == other.defaultMode && this.allowGroupSwitching == other.allowGroupSwitching && this.primaryRanges.equals(other.primaryRanges) && this.appRequestRanges.equals(other.appRequestRanges);
        }

        public int hashCode() {
            return 0;
        }

        public void copyFrom(DesiredDisplayModeSpecs other) {
            this.defaultMode = other.defaultMode;
            this.allowGroupSwitching = other.allowGroupSwitching;
            this.primaryRanges.copyFrom(other.primaryRanges);
            this.appRequestRanges.copyFrom(other.appRequestRanges);
        }

        public String toString() {
            return "defaultMode=" + this.defaultMode + " allowGroupSwitching=" + this.allowGroupSwitching + " primaryRanges=" + ((Object) this.primaryRanges) + " appRequestRanges=" + ((Object) this.appRequestRanges);
        }
    }

    public static boolean setDesiredDisplayModeSpecs(IBinder displayToken, DesiredDisplayModeSpecs desiredDisplayModeSpecs) {
        if (displayToken == null) {
            throw new IllegalArgumentException("displayToken must not be null");
        }
        if (desiredDisplayModeSpecs == null) {
            throw new IllegalArgumentException("desiredDisplayModeSpecs must not be null");
        }
        if (desiredDisplayModeSpecs.defaultMode < 0) {
            throw new IllegalArgumentException("defaultMode must be non-negative");
        }
        return nativeSetDesiredDisplayModeSpecs(displayToken, desiredDisplayModeSpecs);
    }

    public static DesiredDisplayModeSpecs getDesiredDisplayModeSpecs(IBinder displayToken) {
        if (displayToken == null) {
            throw new IllegalArgumentException("displayToken must not be null");
        }
        return nativeGetDesiredDisplayModeSpecs(displayToken);
    }

    public static DisplayPrimaries getDisplayNativePrimaries(IBinder displayToken) {
        if (displayToken == null) {
            throw new IllegalArgumentException("displayToken must not be null");
        }
        return nativeGetDisplayNativePrimaries(displayToken);
    }

    public static boolean setActiveColorMode(IBinder displayToken, int colorMode) {
        if (displayToken == null) {
            throw new IllegalArgumentException("displayToken must not be null");
        }
        return nativeSetActiveColorMode(displayToken, colorMode);
    }

    public static ColorSpace[] getCompositionColorSpaces() {
        int[] dataspaces = nativeGetCompositionDataspaces();
        ColorSpace srgb = ColorSpace.get(ColorSpace.Named.SRGB);
        ColorSpace[] colorSpaces = {srgb, srgb};
        if (dataspaces.length == 2) {
            for (int i10 = 0; i10 < 2; i10++) {
                ColorSpace cs = ColorSpace.getFromDataSpace(dataspaces[i10]);
                if (cs != null) {
                    colorSpaces[i10] = cs;
                }
            }
        }
        return colorSpaces;
    }

    public static OverlayProperties getOverlaySupport() {
        return nativeGetOverlaySupport();
    }

    public static boolean getBootDisplayModeSupport() {
        return nativeGetBootDisplayModeSupport();
    }

    public static void setBootDisplayMode(IBinder displayToken, int displayModeId) {
        if (displayToken == null) {
            throw new IllegalArgumentException("displayToken must not be null");
        }
        nativeSetBootDisplayMode(displayToken, displayModeId);
    }

    public static void clearBootDisplayMode(IBinder displayToken) {
        if (displayToken == null) {
            throw new IllegalArgumentException("displayToken must not be null");
        }
        nativeClearBootDisplayMode(displayToken);
    }

    public static void setAutoLowLatencyMode(IBinder displayToken, boolean on) {
        if (displayToken == null) {
            throw new IllegalArgumentException("displayToken must not be null");
        }
        nativeSetAutoLowLatencyMode(displayToken, on);
    }

    public static void setGameContentType(IBinder displayToken, boolean on) {
        if (displayToken == null) {
            throw new IllegalArgumentException("displayToken must not be null");
        }
        nativeSetGameContentType(displayToken, on);
    }

    public static void setDisplayProjection(IBinder displayToken, int orientation, Rect layerStackRect, Rect displayRect) {
        DisplayManagerGlobal.getInstance().resizeVirtualDisplay(IVirtualDisplayCallback.Stub.asInterface(displayToken), layerStackRect.width(), layerStackRect.height(), 1);
    }

    public static void setDisplayLayerStack(IBinder displayToken, int layerStack) {
        IBinder b4 = ServiceManager.getService(Attributes.Style.DISPLAY);
        if (b4 == null) {
            throw new UnsupportedOperationException();
        }
        IDisplayManager dm = IDisplayManager.Stub.asInterface(b4);
        try {
            dm.setDisplayIdToMirror(displayToken, layerStack);
        } catch (RemoteException e2) {
            throw new UnsupportedOperationException(e2);
        }
    }

    public static void setDisplaySurface(IBinder displayToken, Surface surface) {
        IVirtualDisplayCallback virtualDisplayCallback = IVirtualDisplayCallback.Stub.asInterface(displayToken);
        DisplayManagerGlobal dm = DisplayManagerGlobal.getInstance();
        dm.setVirtualDisplaySurface(virtualDisplayCallback, surface);
    }

    public static IBinder createDisplay(String name, boolean secure) {
        if (name == null) {
            throw new IllegalArgumentException("name must not be null");
        }
        VirtualDisplay vd2 = DisplayManager.createVirtualDisplay(name, 1, 1, -1, null);
        if (vd2 == null) {
            return null;
        }
        return vd2.getToken().asBinder();
    }

    public static void destroyDisplay(IBinder displayToken) {
        if (displayToken == null) {
            throw new IllegalArgumentException("displayToken must not be null");
        }
        DisplayManagerGlobal.getInstance().releaseVirtualDisplay(IVirtualDisplayCallback.Stub.asInterface(displayToken));
    }

    public static boolean getProtectedContentSupport() {
        return nativeGetProtectedContentSupport();
    }

    public static boolean getDisplayBrightnessSupport(IBinder displayToken) {
        return nativeGetDisplayBrightnessSupport(displayToken);
    }

    public static boolean setDisplayBrightness(IBinder displayToken, float brightness) {
        return setDisplayBrightness(displayToken, brightness, -1.0f, brightness, -1.0f);
    }

    public static boolean setDisplayBrightness(IBinder displayToken, float sdrBrightness, float sdrBrightnessNits, float displayBrightness, float displayBrightnessNits) {
        Objects.requireNonNull(displayToken);
        if (Float.isNaN(displayBrightness) || displayBrightness > 1.0f || (displayBrightness < 0.0f && displayBrightness != -1.0f)) {
            throw new IllegalArgumentException("displayBrightness must be a number between 0.0f  and 1.0f, or -1 to turn the backlight off: " + displayBrightness);
        }
        if (Float.isNaN(sdrBrightness) || sdrBrightness > 1.0f || (sdrBrightness < 0.0f && sdrBrightness != -1.0f)) {
            throw new IllegalArgumentException("sdrBrightness must be a number between 0.0f and 1.0f, or -1 to turn the backlight off: " + sdrBrightness);
        }
        return nativeSetDisplayBrightness(displayToken, sdrBrightness, sdrBrightnessNits, displayBrightness, displayBrightnessNits);
    }

    public static boolean setDisplayBrightness(IBinder displayToken, float brightness, float color) {
        return setDisplayBrightness(displayToken, brightness, -1.0f, brightness, -1.0f, color, 1.0f, -1.0f, 0, false);
    }

    public static boolean setDisplayBrightness(IBinder displayToken, float sdrBrightness, float sdrBrightnessNits, float displayBrightness, float displayBrightnessNits, float color, float scale, float displayBrightnessOri, int edrType, boolean isAnimating) {
        Objects.requireNonNull(displayToken);
        if (Float.isNaN(displayBrightness) || displayBrightness > 1.0f || (displayBrightness < 0.0f && displayBrightness != -1.0f)) {
            throw new IllegalArgumentException("displayBrightness must be a number between 0.0f  and 1.0f, or -1 to turn the backlight off: " + displayBrightness);
        }
        if (Float.isNaN(sdrBrightness) || sdrBrightness > 1.0f || (sdrBrightness < 0.0f && sdrBrightness != -1.0f)) {
            throw new IllegalArgumentException("sdrBrightness must be a number between 0.0f and 1.0f, or -1 to turn the backlight off: " + sdrBrightness);
        }
        return nativeSetDisplayBrightnessWithColor(displayToken, sdrBrightness, sdrBrightnessNits, displayBrightness, displayBrightnessNits, color, scale, displayBrightnessOri, edrType, isAnimating);
    }

    public static boolean setDisplayBrightness(IBinder displayToken, float sdrBrightness, float sdrBrightnessNits, float displayBrightness, float displayBrightnessNits, float color, float scale, float displayBrightnessOri, float level, int edrType, boolean isAnimating) {
        Objects.requireNonNull(displayToken);
        if (Float.isNaN(displayBrightness) || displayBrightness > 1.0f || (displayBrightness < 0.0f && displayBrightness != -1.0f)) {
            throw new IllegalArgumentException("displayBrightness must be a number between 0.0f  and 1.0f, or -1 to turn the backlight off: " + displayBrightness);
        }
        if (Float.isNaN(sdrBrightness) || sdrBrightness > 1.0f || (sdrBrightness < 0.0f && sdrBrightness != -1.0f)) {
            throw new IllegalArgumentException("sdrBrightness must be a number between 0.0f and 1.0f, or -1 to turn the backlight off: " + sdrBrightness);
        }
        return nativeSetDisplayBrightnessWithLevel(displayToken, sdrBrightness, sdrBrightnessNits, displayBrightness, displayBrightnessNits, color, scale, displayBrightnessOri, level, edrType, isAnimating);
    }

    public static SurfaceControl mirrorSurface(SurfaceControl mirrorOf) {
        long nativeObj = nativeMirrorSurface(mirrorOf.mNativeObject);
        SurfaceControl sc2 = new SurfaceControl();
        sc2.mName = mirrorOf.mName + " (mirror)";
        sc2.assignNativeObject(nativeObj, "mirrorSurface");
        return sc2;
    }

    private static void validateColorArg(float[] color) {
        if (color.length != 4) {
            throw new IllegalArgumentException("Color must be specified as a float array with four values to represent r, g, b, a in range [0..1]");
        }
        for (float c4 : color) {
            if (c4 < 0.0f || c4 > 1.0f) {
                throw new IllegalArgumentException("Color must be specified as a float array with four values to represent r, g, b, a in range [0..1]");
            }
        }
    }

    public static void setGlobalShadowSettings(float[] ambientColor, float[] spotColor, float lightPosY, float lightPosZ, float lightRadius) {
        validateColorArg(ambientColor);
        validateColorArg(spotColor);
        nativeSetGlobalShadowSettings(ambientColor, spotColor, lightPosY, lightPosZ, lightRadius);
    }

    public static DisplayDecorationSupport getDisplayDecorationSupport(IBinder displayToken) {
        return nativeGetDisplayDecorationSupport(displayToken);
    }

    public static void addJankDataListener(OnJankDataListener listener, SurfaceControl surface) {
        nativeAddJankDataListener(listener.mNativePtr.get(), surface.mNativeObject);
    }

    public static void removeJankDataListener(OnJankDataListener listener) {
        nativeRemoveJankDataListener(listener.mNativePtr.get());
    }

    public static int getGPUContextPriority() {
        return nativeGetGPUContextPriority();
    }

    public static boolean bootFinished() {
        return nativeBootFinished();
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static final class TrustedPresentationThresholds {
        private final float mMinAlpha;
        private final float mMinFractionRendered;
        private final int mStabilityRequirementMs;

        public TrustedPresentationThresholds(float minAlpha, float minFractionRendered, int stabilityRequirementMs) {
            this.mMinAlpha = minAlpha;
            this.mMinFractionRendered = minFractionRendered;
            this.mStabilityRequirementMs = stabilityRequirementMs;
            checkValid();
        }

        private void checkValid() {
            if (this.mMinAlpha <= 0.0f || this.mMinFractionRendered <= 0.0f || this.mStabilityRequirementMs < 1) {
                throw new IllegalArgumentException("TrustedPresentationThresholds values are invalid");
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static abstract class TrustedPresentationCallback {
        private static final NativeAllocationRegistry sRegistry = NativeAllocationRegistry.createMalloced(TrustedPresentationCallback.class.getClassLoader(), SurfaceControl.m232$$Nest$smgetNativeTrustedPresentationCallbackFinalizer());
        private final Runnable mFreeNativeResources;
        private final long mNativeObject;

        public abstract void onTrustedPresentationChanged(boolean z10);

        private TrustedPresentationCallback() {
            long nativeCreateTpc = SurfaceControl.nativeCreateTpc(this);
            this.mNativeObject = nativeCreateTpc;
            this.mFreeNativeResources = sRegistry.registerNativeAllocation(this, nativeCreateTpc);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class Transaction implements Closeable, Parcelable {
        Runnable mFreeNativeResources;
        public long mNativeObject;
        private final ArrayMap<SurfaceControl, SurfaceControl> mReparentedSurfaces;
        private final ArrayMap<SurfaceControl, Point> mResizedSurfaces;
        public static final NativeAllocationRegistry sRegistry = new NativeAllocationRegistry(Transaction.class.getClassLoader(), SurfaceControl.m242$$Nest$smnativeGetNativeTransactionFinalizer(), 512);
        private static final float[] INVALID_COLOR = {-1.0f, -1.0f, -1.0f};
        public static final Parcelable.Creator<Transaction> CREATOR = new Parcelable.Creator<Transaction>() { // from class: android.view.SurfaceControl.Transaction.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public Transaction createFromParcel(Parcel in) {
                return new Transaction(in);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public Transaction[] newArray(int size) {
                return new Transaction[size];
            }
        };

        protected void checkPreconditions(SurfaceControl sc2) {
            sc2.checkNotReleased();
        }

        public Transaction() {
            this(SurfaceControl.m240$$Nest$smnativeCreateTransaction());
        }

        private Transaction(long nativeObject) {
            this.mResizedSurfaces = new ArrayMap<>();
            this.mReparentedSurfaces = new ArrayMap<>();
            this.mNativeObject = nativeObject;
            this.mFreeNativeResources = sRegistry.registerNativeAllocation(this, nativeObject);
        }

        private Transaction(Parcel in) {
            this.mResizedSurfaces = new ArrayMap<>();
            this.mReparentedSurfaces = new ArrayMap<>();
            readFromParcel(in);
        }

        public static void setDefaultApplyToken(IBinder token) {
            SurfaceControl.nativeSetDefaultApplyToken(token);
        }

        public static IBinder getDefaultApplyToken() {
            return SurfaceControl.m241$$Nest$smnativeGetDefaultApplyToken();
        }

        public void apply() {
            apply(false);
        }

        public void clear() {
            this.mResizedSurfaces.clear();
            this.mReparentedSurfaces.clear();
            long j10 = this.mNativeObject;
            if (j10 != 0) {
                SurfaceControl.nativeClearTransaction(j10);
            }
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.mResizedSurfaces.clear();
            this.mReparentedSurfaces.clear();
            this.mFreeNativeResources.run();
            this.mNativeObject = 0L;
        }

        public void apply(boolean sync) {
            applyResizedSurfaces();
            notifyReparentedSurfaces();
            if (Trace.isTagEnabled(32L)) {
                Trace.traceBegin(32L, "apply:" + this.mNativeObject + " sync=" + sync);
            }
            SurfaceControl.nativeApplyTransaction(this.mNativeObject, sync);
            if (Trace.isTagEnabled(32L)) {
                Trace.traceEnd(32L);
            }
        }

        protected void applyResizedSurfaces() {
            for (int i10 = this.mResizedSurfaces.size() - 1; i10 >= 0; i10--) {
                Point size = this.mResizedSurfaces.valueAt(i10);
                SurfaceControl surfaceControl = this.mResizedSurfaces.keyAt(i10);
                synchronized (surfaceControl.mLock) {
                    surfaceControl.resize(size.x, size.y);
                }
            }
            this.mResizedSurfaces.clear();
        }

        protected void notifyReparentedSurfaces() {
            int reparentCount = this.mReparentedSurfaces.size();
            for (int i10 = reparentCount - 1; i10 >= 0; i10--) {
                SurfaceControl child = this.mReparentedSurfaces.keyAt(i10);
                synchronized (child.mLock) {
                    int listenerCount = child.mReparentListeners != null ? child.mReparentListeners.size() : 0;
                    for (int j10 = 0; j10 < listenerCount; j10++) {
                        OnReparentListener listener = (OnReparentListener) child.mReparentListeners.get(j10);
                        listener.onReparent(this, this.mReparentedSurfaces.valueAt(i10));
                    }
                    this.mReparentedSurfaces.removeAt(i10);
                }
            }
        }

        public Transaction setVisibility(SurfaceControl sc2, boolean visible) {
            checkPreconditions(sc2);
            if (visible) {
                return show(sc2);
            }
            return hide(sc2);
        }

        public Transaction setFrameRateSelectionPriority(SurfaceControl sc2, int priority) {
            checkPreconditions(sc2);
            SurfaceControl.nativeSetFrameRateSelectionPriority(this.mNativeObject, sc2.mNativeObject, priority);
            return this;
        }

        public Transaction show(SurfaceControl sc2) {
            if (SurfaceControl.DEBUG_SFC || SurfaceControl.DEBUG_ALL || SurfaceControl.DEBUG_SFC_PRE_VERSION || SurfaceControl.DEBUG_EGINGTEST) {
                Log.i(SurfaceControl.TAG, "SurfaceControl show : sc " + ((Object) sc2) + "\n caller = " + Debug.getCallers(SurfaceControl.DEBUG_DEPTH));
            }
            checkPreconditions(sc2);
            SurfaceControl.nativeSetFlags(this.mNativeObject, sc2.mNativeObject, 0, 1);
            return this;
        }

        public Transaction hide(SurfaceControl sc2) {
            if (SurfaceControl.DEBUG_SFC || SurfaceControl.DEBUG_ALL || SurfaceControl.DEBUG_SFC_PRE_VERSION || SurfaceControl.DEBUG_EGINGTEST) {
                Log.i(SurfaceControl.TAG, "SurfaceControl hide: sc " + ((Object) sc2) + "\n caller = " + Debug.getCallers(SurfaceControl.DEBUG_DEPTH));
            }
            checkPreconditions(sc2);
            SurfaceControl.nativeSetFlags(this.mNativeObject, sc2.mNativeObject, 1, 1);
            return this;
        }

        public Transaction setPosition(SurfaceControl sc2, float x10, float y10) {
            if (SurfaceControl.DEBUG_SFC || SurfaceControl.DEBUG_ALL) {
                Log.i(SurfaceControl.TAG, "SurfaceControl setPosition:  sc " + ((Object) sc2) + " x=" + x10 + " y=" + y10 + " caller=" + Debug.getCallers(SurfaceControl.DEBUG_DEPTH));
            }
            checkPreconditions(sc2);
            SurfaceControl.nativeSetPosition(this.mNativeObject, sc2.mNativeObject, x10, y10);
            return this;
        }

        public Transaction setScale(SurfaceControl sc2, float scaleX, float scaleY) {
            checkPreconditions(sc2);
            Preconditions.checkArgument(scaleX >= 0.0f, "Negative value passed in for scaleX");
            Preconditions.checkArgument(scaleY >= 0.0f, "Negative value passed in for scaleY");
            SurfaceControl.nativeSetScale(this.mNativeObject, sc2.mNativeObject, scaleX, scaleY);
            return this;
        }

        public Transaction setCastFlags(SurfaceControl sc2, int flags) {
            checkPreconditions(sc2);
            SurfaceControl.nativeSetFlags(this.mNativeObject, sc2.mNativeObject, flags, 32);
            return this;
        }

        public Transaction setAodFlags(SurfaceControl sc2, int flags) {
            checkPreconditions(sc2);
            SurfaceControl.nativeSetFlags(this.mNativeObject, sc2.mNativeObject, flags == 1 ? 2097152 : 0, 2097152);
            return this;
        }

        public Transaction setBufferSize(SurfaceControl sc2, int w3, int h10) {
            if (SurfaceControl.DEBUG_ALL) {
                Log.i(SurfaceControl.TAG, "SurfaceControl setBufferSize: w " + w3 + " h " + h10 + " sc " + ((Object) sc2));
            }
            if (w3 > 16384 || h10 > 16384) {
                Log.i(SurfaceControl.TAG, ((Object) this) + " mSurfaceWidth = " + w3 + " mSurfaceHeight = " + h10);
                throw new IllegalStateException("SurfaceView width and height must be smaller than 16384");
            }
            checkPreconditions(sc2);
            this.mResizedSurfaces.put(sc2, new Point(w3, h10));
            return this;
        }

        public Transaction setFixedTransformHint(SurfaceControl sc2, int transformHint) {
            checkPreconditions(sc2);
            SurfaceControl.nativeSetFixedTransformHint(this.mNativeObject, sc2.mNativeObject, transformHint);
            return this;
        }

        public Transaction unsetFixedTransformHint(SurfaceControl sc2) {
            checkPreconditions(sc2);
            SurfaceControl.nativeSetFixedTransformHint(this.mNativeObject, sc2.mNativeObject, -1);
            return this;
        }

        public Transaction setLayer(SurfaceControl sc2, int z10) {
            if (SurfaceControl.DEBUG_ALL) {
                Log.i(SurfaceControl.TAG, "setLayer z " + z10 + " sc " + ((Object) sc2));
            }
            checkPreconditions(sc2);
            SurfaceControl.nativeSetLayer(this.mNativeObject, sc2.mNativeObject, z10);
            return this;
        }

        public Transaction setRelativeLayer(SurfaceControl sc2, SurfaceControl relativeTo, int z10) {
            checkPreconditions(sc2);
            if (SurfaceControl.DEBUG_ALL) {
                Log.i(SurfaceControl.TAG, " setRelativeLayer:  sc " + ((Object) sc2) + " relativeTo=" + ((Object) relativeTo) + " z=" + z10 + " caller=" + Debug.getCallers(SurfaceControl.DEBUG_DEPTH * 2));
            }
            SurfaceControl.nativeSetRelativeLayer(this.mNativeObject, sc2.mNativeObject, relativeTo.mNativeObject, z10);
            return this;
        }

        public Transaction setTransparentRegionHint(SurfaceControl sc2, Region transparentRegion) {
            checkPreconditions(sc2);
            SurfaceControl.nativeSetTransparentRegionHint(this.mNativeObject, sc2.mNativeObject, transparentRegion);
            return this;
        }

        public Transaction setAlpha(SurfaceControl sc2, float alpha) {
            if ((SurfaceControl.DEBUG_SFC || SurfaceControl.DEBUG_EGINGTEST) && (alpha == 0.0f || alpha == 1.0f)) {
                Log.i(SurfaceControl.TAG, "SurfaceControl setAlpha:  sc=" + ((Object) sc2) + " alpha=" + alpha + " caller=" + Debug.getCallers(SurfaceControl.DEBUG_DEPTH));
            }
            checkPreconditions(sc2);
            SurfaceControl.nativeSetAlpha(this.mNativeObject, sc2.mNativeObject, alpha);
            return this;
        }

        public Transaction setInputWindowInfo(SurfaceControl sc2, InputWindowHandle handle) {
            checkPreconditions(sc2);
            SurfaceControl.nativeSetInputWindowInfo(this.mNativeObject, sc2.mNativeObject, handle);
            return this;
        }

        public Transaction addWindowInfosReportedListener(Runnable listener) {
            if (Trace.isTagEnabled(32L)) {
                Trace.traceBegin(32L, "addWindowInfosReportedListener:" + this.mNativeObject);
            }
            SurfaceControl.nativeAddWindowInfosReportedListener(this.mNativeObject, listener);
            if (Trace.isTagEnabled(32L)) {
                Trace.traceEnd(32L);
            }
            return this;
        }

        public Transaction setGeometry(SurfaceControl sc2, Rect sourceCrop, Rect destFrame, int orientation) {
            checkPreconditions(sc2);
            SurfaceControl.nativeSetGeometry(this.mNativeObject, sc2.mNativeObject, sourceCrop, destFrame, orientation);
            return this;
        }

        public Transaction setMatrix(SurfaceControl sc2, float dsdx, float dtdx, float dtdy, float dsdy) {
            if (SurfaceControl.DEBUG_ALL) {
                Log.i(SurfaceControl.TAG, "SurfaceControl setMatrix: dsdx " + dsdx + " dtdx " + dtdx + " dtdy " + dtdy + "dsdy " + dsdy + " caller=" + Debug.getCallers(SurfaceControl.DEBUG_DEPTH));
            }
            checkPreconditions(sc2);
            SurfaceControl.nativeSetMatrix(this.mNativeObject, sc2.mNativeObject, dsdx, dtdx, dtdy, dsdy);
            return this;
        }

        public Transaction setMatrix(SurfaceControl sc2, Matrix matrix, float[] float9) {
            matrix.getValues(float9);
            setMatrix(sc2, float9[0], float9[3], float9[1], float9[4]);
            setPosition(sc2, float9[2], float9[5]);
            sc2.mSurfaceControlExt.onSetMatrix(sc2, float9);
            return this;
        }

        public Transaction setColorTransform(SurfaceControl sc2, float[] matrix, float[] translation) {
            checkPreconditions(sc2);
            SurfaceControl.nativeSetColorTransform(this.mNativeObject, sc2.mNativeObject, matrix, translation);
            return this;
        }

        public Transaction setColorSpaceAgnostic(SurfaceControl sc2, boolean agnostic) {
            checkPreconditions(sc2);
            SurfaceControl.nativeSetColorSpaceAgnostic(this.mNativeObject, sc2.mNativeObject, agnostic);
            return this;
        }

        @Deprecated
        public Transaction setWindowCrop(SurfaceControl sc2, Rect crop) {
            checkPreconditions(sc2);
            if (crop != null) {
                SurfaceControl.nativeSetWindowCrop(this.mNativeObject, sc2.mNativeObject, crop.left, crop.top, crop.right, crop.bottom);
            } else {
                SurfaceControl.nativeSetWindowCrop(this.mNativeObject, sc2.mNativeObject, 0, 0, 0, 0);
            }
            return this;
        }

        public Transaction setCrop(SurfaceControl sc2, Rect crop) {
            checkPreconditions(sc2);
            if (crop != null) {
                if (SurfaceControl.DEBUG_ALL) {
                    Log.i(SurfaceControl.TAG, "SurfaceControl setCrop: crop.left " + crop.left + " crop.top " + crop.top + " crop.right " + crop.right + " crop.bottom " + crop.bottom + " caller=" + Debug.getCallers(SurfaceControl.DEBUG_DEPTH));
                }
                Preconditions.checkArgument(crop.isValid(), "Crop isn't valid.");
                SurfaceControl.nativeSetWindowCrop(this.mNativeObject, sc2.mNativeObject, crop.left, crop.top, crop.right, crop.bottom);
            } else {
                SurfaceControl.nativeSetWindowCrop(this.mNativeObject, sc2.mNativeObject, 0, 0, 0, 0);
            }
            return this;
        }

        public Transaction setWindowCrop(SurfaceControl sc2, int width, int height) {
            if (SurfaceControl.DEBUG_ALL) {
                Log.i(SurfaceControl.TAG, "SurfaceControl setWindowCrop: width " + width + " height " + height + " caller=" + Debug.getCallers(SurfaceControl.DEBUG_DEPTH));
            }
            checkPreconditions(sc2);
            SurfaceControl.nativeSetWindowCrop(this.mNativeObject, sc2.mNativeObject, 0, 0, width, height);
            return this;
        }

        public Transaction setCornerRadius(SurfaceControl sc2, float cornerRadius) {
            checkPreconditions(sc2);
            SurfaceControl.nativeSetCornerRadius(this.mNativeObject, sc2.mNativeObject, cornerRadius);
            return this;
        }

        public Transaction setBackgroundBlurRadius(SurfaceControl sc2, int radius) {
            checkPreconditions(sc2);
            SurfaceControl.nativeSetBackgroundBlurRadius(this.mNativeObject, sc2.mNativeObject, radius);
            return this;
        }

        public Transaction setBlurRegions(SurfaceControl sc2, float[][] regions) {
            checkPreconditions(sc2);
            SurfaceControl.nativeSetBlurRegions(this.mNativeObject, sc2.mNativeObject, regions, regions.length);
            return this;
        }

        public Transaction setStretchEffect(SurfaceControl sc2, float width, float height, float vecX, float vecY, float maxStretchAmountX, float maxStretchAmountY, float childRelativeLeft, float childRelativeTop, float childRelativeRight, float childRelativeBottom) {
            checkPreconditions(sc2);
            SurfaceControl.nativeSetStretchEffect(this.mNativeObject, sc2.mNativeObject, width, height, vecX, vecY, maxStretchAmountX, maxStretchAmountY, childRelativeLeft, childRelativeTop, childRelativeRight, childRelativeBottom);
            return this;
        }

        public Transaction setLayerStack(SurfaceControl sc2, int layerStack) {
            checkPreconditions(sc2);
            if (SurfaceControl.DEBUG_SFC || SurfaceControl.DEBUG_EGINGTEST) {
                Log.i(SurfaceControl.TAG, " setLayerStack sc=" + ((Object) sc2) + ",layerStack=" + layerStack + " caller=" + Debug.getCallers(SurfaceControl.DEBUG_DEPTH));
            }
            SurfaceControl.nativeSetLayerStack(this.mNativeObject, sc2.mNativeObject, layerStack);
            return this;
        }

        public Transaction reparent(SurfaceControl sc2, SurfaceControl newParent) {
            checkPreconditions(sc2);
            long otherObject = 0;
            if (newParent != null && newParent.isValid()) {
                newParent.checkNotReleased();
                otherObject = newParent.mNativeObject;
            }
            if (SurfaceControl.DEBUG_SFC || SurfaceControl.DEBUG_ALL || sc2.mSurfaceControlExt.isFingerprintType(sc2.mName) || SurfaceControl.DEBUG_SFC_PRE_VERSION) {
                Log.i(SurfaceControl.TAG, "Transaction reparent sc " + ((Object) sc2) + ",parent=" + ((Object) newParent) + " caller=" + Debug.getCallers(SurfaceControl.DEBUG_DEPTH));
            }
            SurfaceControl.nativeReparent(this.mNativeObject, sc2.mNativeObject, otherObject);
            this.mReparentedSurfaces.put(sc2, newParent);
            return this;
        }

        public Transaction setColor(SurfaceControl sc2, float[] color) {
            checkPreconditions(sc2);
            SurfaceControl.nativeSetColor(this.mNativeObject, sc2.mNativeObject, color);
            return this;
        }

        public Transaction unsetColor(SurfaceControl sc2) {
            checkPreconditions(sc2);
            SurfaceControl.nativeSetColor(this.mNativeObject, sc2.mNativeObject, INVALID_COLOR);
            return this;
        }

        public Transaction setSecure(SurfaceControl sc2, boolean isSecure) {
            checkPreconditions(sc2);
            if (isSecure) {
                SurfaceControl.nativeSetFlags(this.mNativeObject, sc2.mNativeObject, 128, 128);
            } else {
                SurfaceControl.nativeSetFlags(this.mNativeObject, sc2.mNativeObject, 0, 128);
            }
            return this;
        }

        public Transaction setDisplayDecoration(SurfaceControl sc2, boolean displayDecoration) {
            checkPreconditions(sc2);
            if (displayDecoration) {
                SurfaceControl.nativeSetFlags(this.mNativeObject, sc2.mNativeObject, 512, 512);
            } else {
                SurfaceControl.nativeSetFlags(this.mNativeObject, sc2.mNativeObject, 0, 512);
            }
            return this;
        }

        public Transaction setOpaque(SurfaceControl sc2, boolean isOpaque) {
            checkPreconditions(sc2);
            if (isOpaque) {
                SurfaceControl.nativeSetFlags(this.mNativeObject, sc2.mNativeObject, 2, 2);
            } else {
                SurfaceControl.nativeSetFlags(this.mNativeObject, sc2.mNativeObject, 0, 2);
            }
            return this;
        }

        public Transaction setDisplaySurface(IBinder displayToken, Surface surface) {
            if (displayToken == null) {
                throw new IllegalArgumentException("displayToken must not be null");
            }
            if (surface != null) {
                synchronized (surface.mLock) {
                    SurfaceControl.nativeSetDisplaySurface(this.mNativeObject, displayToken, surface.mNativeObject);
                }
            } else {
                SurfaceControl.nativeSetDisplaySurface(this.mNativeObject, displayToken, 0L);
            }
            return this;
        }

        public Transaction setDisplayLayerStack(IBinder displayToken, int layerStack) {
            if (displayToken == null) {
                throw new IllegalArgumentException("displayToken must not be null");
            }
            SurfaceControl.nativeSetDisplayLayerStack(this.mNativeObject, displayToken, layerStack);
            return this;
        }

        public Transaction setDisplayFlags(IBinder displayToken, int flags) {
            if (displayToken == null) {
                throw new IllegalArgumentException("displayToken must not be null");
            }
            SurfaceControl.nativeSetDisplayFlags(this.mNativeObject, displayToken, flags);
            return this;
        }

        public Transaction setDisplayProjection(IBinder displayToken, int orientation, Rect layerStackRect, Rect displayRect) {
            if (displayToken == null) {
                throw new IllegalArgumentException("displayToken must not be null");
            }
            if (layerStackRect == null) {
                throw new IllegalArgumentException("layerStackRect must not be null");
            }
            if (displayRect == null) {
                throw new IllegalArgumentException("displayRect must not be null");
            }
            SurfaceControl.nativeSetDisplayProjection(this.mNativeObject, displayToken, orientation, layerStackRect.left, layerStackRect.top, layerStackRect.right, layerStackRect.bottom, displayRect.left, displayRect.top, displayRect.right, displayRect.bottom);
            return this;
        }

        public Transaction setDisplaySize(IBinder displayToken, int width, int height) {
            if (displayToken == null) {
                throw new IllegalArgumentException("displayToken must not be null");
            }
            if (width <= 0 || height <= 0) {
                throw new IllegalArgumentException("width and height must be positive");
            }
            SurfaceControl.nativeSetDisplaySize(this.mNativeObject, displayToken, width, height);
            return this;
        }

        public Transaction setAnimationTransaction() {
            SurfaceControl.nativeSetAnimationTransaction(this.mNativeObject);
            return this;
        }

        public Transaction setEarlyWakeupStart() {
            SurfaceControl.nativeSetEarlyWakeupStart(this.mNativeObject);
            return this;
        }

        public Transaction setEarlyWakeupEnd() {
            SurfaceControl.nativeSetEarlyWakeupEnd(this.mNativeObject);
            return this;
        }

        public long getId() {
            return SurfaceControl.nativeGetTransactionId(this.mNativeObject);
        }

        public Transaction setMetadata(SurfaceControl sc2, int key, int data) {
            Parcel parcel = Parcel.obtain();
            parcel.writeInt(data);
            try {
                setMetadata(sc2, key, parcel);
                return this;
            } finally {
                parcel.recycle();
            }
        }

        public Transaction setMetadata(SurfaceControl sc2, int key, Parcel data) {
            checkPreconditions(sc2);
            SurfaceControl.nativeSetMetadata(this.mNativeObject, sc2.mNativeObject, key, data);
            return this;
        }

        public Transaction setShadowRadius(SurfaceControl sc2, float shadowRadius) {
            checkPreconditions(sc2);
            SurfaceControl.nativeSetShadowRadius(this.mNativeObject, sc2.mNativeObject, shadowRadius);
            return this;
        }

        public Transaction setFrameRate(SurfaceControl sc2, float frameRate, int compatibility) {
            return setFrameRate(sc2, frameRate, compatibility, 0);
        }

        public Transaction setFrameRate(SurfaceControl sc2, float frameRate, int compatibility, int changeFrameRateStrategy) {
            checkPreconditions(sc2);
            SurfaceControl.nativeSetFrameRate(this.mNativeObject, sc2.mNativeObject, frameRate, compatibility, changeFrameRateStrategy);
            return this;
        }

        public Transaction clearFrameRate(SurfaceControl sc2) {
            checkPreconditions(sc2);
            SurfaceControl.nativeSetFrameRate(this.mNativeObject, sc2.mNativeObject, 0.0f, 0, 1);
            return this;
        }

        public Transaction setDefaultFrameRateCompatibility(SurfaceControl sc2, int compatibility) {
            checkPreconditions(sc2);
            SurfaceControl.nativeSetDefaultFrameRateCompatibility(this.mNativeObject, sc2.mNativeObject, compatibility);
            return this;
        }

        public Transaction setFocusedWindow(IBinder token, String windowName, int displayId) {
            SurfaceControl.nativeSetFocusedWindow(this.mNativeObject, token, windowName, displayId);
            return this;
        }

        public Transaction removeCurrentInputFocus(int displayId) {
            SurfaceControl.nativeRemoveCurrentInputFocus(this.mNativeObject, displayId);
            return this;
        }

        public Transaction setSkipScreenshot(SurfaceControl sc2, boolean skipScrenshot) {
            checkPreconditions(sc2);
            if (skipScrenshot) {
                SurfaceControl.nativeSetFlags(this.mNativeObject, sc2.mNativeObject, 64, 64);
            } else {
                SurfaceControl.nativeSetFlags(this.mNativeObject, sc2.mNativeObject, 0, 64);
            }
            return this;
        }

        @Deprecated
        public Transaction setBuffer(SurfaceControl sc2, GraphicBuffer buffer) {
            return setBuffer(sc2, HardwareBuffer.createFromGraphicBuffer(buffer));
        }

        public Transaction setBuffer(SurfaceControl sc2, HardwareBuffer buffer) {
            return setBuffer(sc2, buffer, null);
        }

        public Transaction unsetBuffer(SurfaceControl sc2) {
            SurfaceControl.nativeUnsetBuffer(this.mNativeObject, sc2.mNativeObject);
            return this;
        }

        public Transaction setBuffer(SurfaceControl sc2, HardwareBuffer buffer, SyncFence fence) {
            return setBuffer(sc2, buffer, fence, null);
        }

        public Transaction setBuffer(SurfaceControl sc2, HardwareBuffer buffer, SyncFence fence, Consumer<SyncFence> releaseCallback) {
            checkPreconditions(sc2);
            if (fence != null) {
                synchronized (fence.getLock()) {
                    SurfaceControl.nativeSetBuffer(this.mNativeObject, sc2.mNativeObject, buffer, fence.getNativeFence(), releaseCallback);
                }
            } else {
                SurfaceControl.nativeSetBuffer(this.mNativeObject, sc2.mNativeObject, buffer, 0L, releaseCallback);
            }
            return this;
        }

        public Transaction setBufferTransform(SurfaceControl sc2, int transform) {
            checkPreconditions(sc2);
            SurfaceControl.nativeSetBufferTransform(this.mNativeObject, sc2.mNativeObject, transform);
            return this;
        }

        public Transaction setDamageRegion(SurfaceControl sc2, Region region) {
            SurfaceControl.nativeSetDamageRegion(this.mNativeObject, sc2.mNativeObject, region);
            return this;
        }

        public Transaction setDimmingEnabled(SurfaceControl sc2, boolean dimmingEnabled) {
            checkPreconditions(sc2);
            SurfaceControl.nativeSetDimmingEnabled(this.mNativeObject, sc2.mNativeObject, dimmingEnabled);
            return this;
        }

        @Deprecated
        public Transaction setColorSpace(SurfaceControl sc2, ColorSpace colorSpace) {
            checkPreconditions(sc2);
            if (colorSpace.getId() == ColorSpace.Named.DISPLAY_P3.ordinal()) {
                setDataSpace(sc2, 143261696);
            } else {
                setDataSpace(sc2, 142671872);
            }
            return this;
        }

        public Transaction setDataSpace(SurfaceControl sc2, int dataspace) {
            checkPreconditions(sc2);
            SurfaceControl.nativeSetDataSpace(this.mNativeObject, sc2.mNativeObject, dataspace);
            return this;
        }

        public Transaction setExtendedRangeBrightness(SurfaceControl sc2, float currentBufferRatio, float desiredRatio) {
            checkPreconditions(sc2);
            Log.i(SurfaceControl.TAG, " setExtendedRangeBrightness sc=" + ((Object) sc2) + ",currentBufferRatio=" + currentBufferRatio + ",desiredRatio=" + desiredRatio);
            if (!Float.isFinite(1.0f) || 1.0f < 1.0f) {
                throw new IllegalArgumentException("currentBufferRatio must be finite && >= 1.0f; got 1.0");
            }
            if (Float.isFinite(1.0f) && 1.0f >= 1.0f) {
                SurfaceControl.nativeSetExtendedRangeBrightness(this.mNativeObject, sc2.mNativeObject, 1.0f, 1.0f);
                return this;
            }
            throw new IllegalArgumentException("desiredRatio must be finite && >= 1.0f; got 1.0");
        }

        public Transaction setCachingHint(SurfaceControl sc2, int cachingHint) {
            checkPreconditions(sc2);
            SurfaceControl.nativeSetCachingHint(this.mNativeObject, sc2.mNativeObject, cachingHint);
            return this;
        }

        public Transaction setTrustedOverlay(SurfaceControl sc2, boolean isTrustedOverlay) {
            checkPreconditions(sc2);
            SurfaceControl.nativeSetTrustedOverlay(this.mNativeObject, sc2.mNativeObject, isTrustedOverlay);
            return this;
        }

        public Transaction setDropInputMode(SurfaceControl sc2, int mode) {
            checkPreconditions(sc2);
            SurfaceControl.nativeSetDropInputMode(this.mNativeObject, sc2.mNativeObject, mode);
            return this;
        }

        public static void sendSurfaceFlushJankData(SurfaceControl sc2) {
            sc2.checkNotReleased();
            SurfaceControl.nativeSurfaceFlushJankData(sc2.mNativeObject);
        }

        public void sanitize(int pid, int uid) {
            SurfaceControl.nativeSanitize(this.mNativeObject, pid, uid);
        }

        public Transaction setDesintationFrame(SurfaceControl sc2, Rect destinationFrame) {
            checkPreconditions(sc2);
            SurfaceControl.nativeSetDestinationFrame(this.mNativeObject, sc2.mNativeObject, destinationFrame.left, destinationFrame.top, destinationFrame.right, destinationFrame.bottom);
            return this;
        }

        public Transaction setDesintationFrame(SurfaceControl sc2, int width, int height) {
            checkPreconditions(sc2);
            SurfaceControl.nativeSetDestinationFrame(this.mNativeObject, sc2.mNativeObject, 0, 0, width, height);
            return this;
        }

        public Transaction merge(Transaction other) {
            if (this == other) {
                return this;
            }
            this.mResizedSurfaces.putAll((ArrayMap<? extends SurfaceControl, ? extends Point>) other.mResizedSurfaces);
            other.mResizedSurfaces.clear();
            this.mReparentedSurfaces.putAll((ArrayMap<? extends SurfaceControl, ? extends SurfaceControl>) other.mReparentedSurfaces);
            other.mReparentedSurfaces.clear();
            SurfaceControl.nativeMergeTransaction(this.mNativeObject, other.mNativeObject);
            return this;
        }

        public Transaction remove(SurfaceControl sc2) {
            if (SurfaceControl.DEBUG_SFC || SurfaceControl.DEBUG_ALL) {
                Log.i(SurfaceControl.TAG, "SurfaceControl remove in transaction: sc " + ((Object) sc2) + " caller=" + Debug.getCallers(SurfaceControl.DEBUG_DEPTH));
            }
            reparent(sc2, null);
            sc2.release();
            return this;
        }

        public Transaction setFrameTimelineVsync(long frameTimelineVsyncId) {
            SurfaceControl.nativeSetFrameTimelineVsync(this.mNativeObject, frameTimelineVsyncId);
            return this;
        }

        public Transaction addTransactionCommittedListener(final Executor executor, final TransactionCommittedListener listener) {
            TransactionCommittedListener listenerInner = new TransactionCommittedListener() { // from class: android.view.SurfaceControl$Transaction$$ExternalSyntheticLambda0
                @Override // android.view.SurfaceControl.TransactionCommittedListener
                public final void onTransactionCommitted() {
                    SurfaceControl.Transaction.lambda$addTransactionCommittedListener$0(Executor.this, listener);
                }
            };
            SurfaceControl.nativeAddTransactionCommittedListener(this.mNativeObject, listenerInner);
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ void lambda$addTransactionCommittedListener$0(Executor executor, final TransactionCommittedListener listener) {
            Objects.requireNonNull(listener);
            executor.execute(new Runnable() { // from class: android.view.SurfaceControl$Transaction$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    SurfaceControl.TransactionCommittedListener.this.onTransactionCommitted();
                }
            });
        }

        public Transaction setBlurColor(SurfaceControl sc2, float r10, float g3, float b4, float a10) {
            checkPreconditions(sc2);
            SurfaceControl.nativeSetBlurColor(this.mNativeObject, sc2.mNativeObject, r10, g3, b4, a10);
            return this;
        }

        public Transaction setEdrFlags(SurfaceControl sc2, int flags) {
            checkPreconditions(sc2);
            SurfaceControl.nativeSetEdrFlags(this.mNativeObject, sc2.mNativeObject, flags);
            return this;
        }

        public Transaction setEdrImageSize(SurfaceControl sc2, Size imageSize, int index) {
            checkPreconditions(sc2);
            SurfaceControl.nativeSetEdrImageSize(this.mNativeObject, sc2.mNativeObject, imageSize.getWidth(), imageSize.getHeight(), index);
            return this;
        }

        public Transaction setEdrImageMetadata(SurfaceControl sc2, byte[] metadata, int index) {
            checkPreconditions(sc2);
            Parcel metaParcel = Parcel.obtain();
            try {
                if (metadata.length > 0) {
                    metaParcel.writeByteArray(metadata);
                }
                metaParcel.setDataPosition(0);
                SurfaceControl.nativeSetEdrMetadata(this.mNativeObject, sc2.mNativeObject, 101, metaParcel, index);
                return this;
            } finally {
                metaParcel.recycle();
            }
        }

        public Transaction setEdrAuxiliaryImage(SurfaceControl sc2, Bitmap bitmap, int index) {
            checkPreconditions(sc2);
            Parcel metaParcel = Parcel.obtain();
            try {
                bitmap.writeToParcel(metaParcel, 0);
                metaParcel.setDataPosition(0);
                SurfaceControl.nativeSetEdrMetadata(this.mNativeObject, sc2.mNativeObject, 100, metaParcel, index);
                return this;
            } finally {
                metaParcel.recycle();
            }
        }

        public Transaction setEdrViewTransform(SurfaceControl sc2, int imageRotation, int[] displayPosition, Rect displayRect, float[] displayTransform, int index) {
            checkPreconditions(sc2);
            SurfaceControl.nativeSetEdrViewTransform(this.mNativeObject, sc2.mNativeObject, index, imageRotation, displayPosition[0], displayPosition[1], displayRect, displayTransform);
            return this;
        }

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
        /* renamed from: android.view.SurfaceControl$Transaction$1, reason: invalid class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
        class AnonymousClass1 extends TrustedPresentationCallback {
            final /* synthetic */ Executor val$executor;
            final /* synthetic */ Consumer val$listener;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(Executor executor, Consumer consumer) {
                super();
                this.val$executor = executor;
                this.val$listener = consumer;
            }

            @Override // android.view.SurfaceControl.TrustedPresentationCallback
            public void onTrustedPresentationChanged(final boolean inTrustedPresentationState) {
                Executor executor = this.val$executor;
                final Consumer consumer = this.val$listener;
                executor.execute(new Runnable() { // from class: android.view.SurfaceControl$Transaction$1$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        Consumer.this.accept(Boolean.valueOf(inTrustedPresentationState));
                    }
                });
            }
        }

        public Transaction setTrustedPresentationCallback(SurfaceControl sc2, TrustedPresentationThresholds thresholds, Executor executor, Consumer<Boolean> listener) {
            checkPreconditions(sc2);
            TrustedPresentationCallback tpc = new AnonymousClass1(executor, listener);
            if (sc2.mTrustedPresentationCallback != null) {
                sc2.mTrustedPresentationCallback.mFreeNativeResources.run();
            }
            SurfaceControl.nativeSetTrustedPresentationCallback(this.mNativeObject, sc2.mNativeObject, tpc.mNativeObject, thresholds);
            sc2.mTrustedPresentationCallback = tpc;
            return this;
        }

        public Transaction clearTrustedPresentationCallback(SurfaceControl sc2) {
            checkPreconditions(sc2);
            SurfaceControl.nativeClearTrustedPresentationCallback(this.mNativeObject, sc2.mNativeObject);
            if (sc2.mTrustedPresentationCallback != null) {
                sc2.mTrustedPresentationCallback.mFreeNativeResources.run();
                sc2.mTrustedPresentationCallback = null;
            }
            return this;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel dest, int flags) {
            if (this.mNativeObject == 0) {
                dest.writeInt(0);
                return;
            }
            dest.writeInt(1);
            SurfaceControl.nativeWriteTransactionToParcel(this.mNativeObject, dest);
            if ((flags & 1) != 0) {
                SurfaceControl.nativeClearTransaction(this.mNativeObject);
            }
        }

        private void readFromParcel(Parcel in) {
            this.mNativeObject = 0L;
            if (in.readInt() != 0) {
                long nativeReadTransactionFromParcel = SurfaceControl.nativeReadTransactionFromParcel(in);
                this.mNativeObject = nativeReadTransactionFromParcel;
                this.mFreeNativeResources = sRegistry.registerNativeAllocation(this, nativeReadTransactionFromParcel);
            }
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class LockDebuggingTransaction extends Transaction {
        Object mMonitor;

        public LockDebuggingTransaction(Object o10) {
            this.mMonitor = o10;
        }

        @Override // android.view.SurfaceControl.Transaction
        protected void checkPreconditions(SurfaceControl sc2) {
            super.checkPreconditions(sc2);
            if (!Thread.holdsLock(this.mMonitor)) {
                throw new RuntimeException("Unlocked access to synchronized SurfaceControl.Transaction");
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    private static class GlobalTransactionWrapper extends Transaction {
        private GlobalTransactionWrapper() {
        }

        void applyGlobalTransaction(boolean sync) {
            applyResizedSurfaces();
            notifyReparentedSurfaces();
            if (Trace.isTagEnabled(32L)) {
                Trace.traceBegin(32L, "applyGlobalTransaction:" + this.mNativeObject + " sync=" + sync);
            }
            SurfaceControl.nativeApplyTransaction(this.mNativeObject, sync);
            if (Trace.isTagEnabled(32L)) {
                Trace.traceEnd(32L);
            }
        }

        @Override // android.view.SurfaceControl.Transaction
        public void apply(boolean sync) {
            throw new RuntimeException("Global transaction must be applied from closeTransaction");
        }
    }

    public static Transaction getGlobalTransaction() {
        return sGlobalTransaction;
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public class ScreenshotGraphicBuffer {
        public ScreenshotGraphicBuffer() {
        }
    }

    public void resize(int w3, int h10) {
        this.mWidth = w3;
        this.mHeight = h10;
        nativeUpdateDefaultBufferSize(this.mNativeObject, w3, h10);
    }

    public int getTransformHint() {
        checkNotReleased();
        return nativeGetTransformHint(this.mNativeObject);
    }

    public void setTransformHint(int transformHint) {
        nativeSetTransformHint(this.mNativeObject, transformHint);
    }

    public int getLayerId() {
        long j10 = this.mNativeObject;
        if (j10 != 0) {
            return nativeGetLayerId(j10);
        }
        return -1;
    }

    private void addToRegistry() {
        SurfaceControlRegistry registry = SurfaceControlRegistry.getProcessInstance();
        if (registry != null) {
            registry.add(this);
        }
    }

    private void removeFromRegistry() {
        SurfaceControlRegistry registry = SurfaceControlRegistry.getProcessInstance();
        if (registry != null) {
            registry.remove(this);
        }
    }

    private static void invokeReleaseCallback(Consumer<SyncFence> callback, long nativeFencePtr) {
        SyncFence fence = new SyncFence(nativeFencePtr);
        callback.accept(fence);
    }
}
