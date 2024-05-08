package android.view;

import android.content.Context;
import com.android.internal.R;
import libcore.util.NativeAllocationRegistry;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public final class MotionPredictor {
    private final boolean mIsPredictionEnabled;
    private final long mPtr;

    /* renamed from: -$$Nest$smnativeGetNativeMotionPredictorFinalizer, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m172$$Nest$smnativeGetNativeMotionPredictorFinalizer() {
        return nativeGetNativeMotionPredictorFinalizer();
    }

    private static native long nativeGetNativeMotionPredictorFinalizer();

    private static native long nativeInitialize(int i10);

    private static native boolean nativeIsPredictionAvailable(long j10, int i10, int i11);

    private static native MotionEvent nativePredict(long j10, long j11);

    private static native void nativeRecord(long j10, MotionEvent motionEvent);

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    private static class RegistryHolder {
        public static final NativeAllocationRegistry REGISTRY = NativeAllocationRegistry.createMalloced(MotionPredictor.class.getClassLoader(), MotionPredictor.m172$$Nest$smnativeGetNativeMotionPredictorFinalizer());

        private RegistryHolder() {
        }
    }

    public MotionPredictor(Context context) {
        this.mIsPredictionEnabled = context.getResources().getBoolean(R.bool.config_enableMotionPrediction);
        int offsetNanos = context.getResources().getInteger(17694903);
        long nativeInitialize = nativeInitialize(offsetNanos);
        this.mPtr = nativeInitialize;
        RegistryHolder.REGISTRY.registerNativeAllocation(this, nativeInitialize);
    }

    public void record(MotionEvent event) {
        if (!this.mIsPredictionEnabled) {
            return;
        }
        nativeRecord(this.mPtr, event);
    }

    public MotionEvent predict(long predictionTimeNanos) {
        if (!this.mIsPredictionEnabled) {
            return null;
        }
        return nativePredict(this.mPtr, predictionTimeNanos);
    }

    public boolean isPredictionAvailable(int deviceId, int source) {
        return this.mIsPredictionEnabled && nativeIsPredictionAvailable(this.mPtr, deviceId, source);
    }
}
