package io.flutter.embedding.android;

import android.content.Context;
import android.graphics.Matrix;
import android.os.Build;
import android.util.TypedValue;
import android.view.InputDevice;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class AndroidTouchProcessor {

    @VisibleForTesting
    public static final int BYTES_PER_FIELD = 8;

    @VisibleForTesting
    public static final int DEFAULT_HORIZONTAL_SCROLL_FACTOR = 48;

    @VisibleForTesting
    public static final int DEFAULT_VERTICAL_SCROLL_FACTOR = 48;
    private static final Matrix IDENTITY_TRANSFORM = new Matrix();
    private static final int IMPLICIT_VIEW_ID = 0;
    private static final int POINTER_DATA_FIELD_COUNT = 36;
    private static final int POINTER_DATA_FLAG_BATCHED = 1;
    private static final String TAG = "AndroidTouchProcessor";
    private int cachedVerticalScrollFactor;

    @NonNull
    private final FlutterRenderer renderer;
    private final boolean trackMotionEvents;
    private final Map<Integer, float[]> ongoingPans = new HashMap();

    @NonNull
    private final MotionEventTracker motionEventTracker = MotionEventTracker.getInstance();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public @interface PointerChange {
        public static final int ADD = 1;
        public static final int CANCEL = 0;
        public static final int DOWN = 4;
        public static final int HOVER = 3;
        public static final int MOVE = 5;
        public static final int PAN_ZOOM_END = 9;
        public static final int PAN_ZOOM_START = 7;
        public static final int PAN_ZOOM_UPDATE = 8;
        public static final int REMOVE = 2;
        public static final int UP = 6;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public @interface PointerDeviceKind {
        public static final int INVERTED_STYLUS = 3;
        public static final int MOUSE = 1;
        public static final int STYLUS = 2;
        public static final int TOUCH = 0;
        public static final int TRACKPAD = 4;
        public static final int UNKNOWN = 5;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public @interface PointerSignalKind {
        public static final int NONE = 0;
        public static final int SCALE = 3;
        public static final int SCROLL = 1;
        public static final int SCROLL_INERTIA_CANCEL = 2;
        public static final int UNKNOWN = 4;
    }

    public AndroidTouchProcessor(@NonNull FlutterRenderer flutterRenderer, boolean z10) {
        this.renderer = flutterRenderer;
        this.trackMotionEvents = z10;
    }

    private void addPointerForIndex(MotionEvent motionEvent, int i10, int i11, int i12, Matrix matrix, ByteBuffer byteBuffer) {
        addPointerForIndex(motionEvent, i10, i11, i12, matrix, byteBuffer, null);
    }

    private float getHorizontalScrollFactor(@NonNull Context context) {
        if (Build.VERSION.SDK_INT >= 26) {
            return ViewConfiguration.get(context).getScaledHorizontalScrollFactor();
        }
        return getVerticalScrollFactorPre26(context);
    }

    @PointerChange
    private int getPointerChangeForAction(int i10) {
        if (i10 == 0) {
            return 4;
        }
        if (i10 == 1) {
            return 6;
        }
        if (i10 == 5) {
            return 4;
        }
        if (i10 == 6) {
            return 6;
        }
        if (i10 == 2) {
            return 5;
        }
        if (i10 == 7) {
            return 3;
        }
        if (i10 == 3) {
            return 0;
        }
        return i10 == 8 ? 3 : -1;
    }

    @PointerChange
    private int getPointerChangeForPanZoom(int i10) {
        if (i10 == 4) {
            return 7;
        }
        if (i10 == 5) {
            return 8;
        }
        return (i10 == 6 || i10 == 0) ? 9 : -1;
    }

    @PointerDeviceKind
    private int getPointerDeviceTypeForToolType(int i10) {
        if (i10 == 1) {
            return 0;
        }
        if (i10 == 2) {
            return 2;
        }
        if (i10 != 3) {
            return i10 != 4 ? 5 : 3;
        }
        return 1;
    }

    private float getVerticalScrollFactor(@NonNull Context context) {
        if (Build.VERSION.SDK_INT >= 26) {
            return getVerticalScrollFactorAbove26(context);
        }
        return getVerticalScrollFactorPre26(context);
    }

    private float getVerticalScrollFactorAbove26(@NonNull Context context) {
        return ViewConfiguration.get(context).getScaledVerticalScrollFactor();
    }

    private int getVerticalScrollFactorPre26(@NonNull Context context) {
        if (this.cachedVerticalScrollFactor == 0) {
            TypedValue typedValue = new TypedValue();
            if (!context.getTheme().resolveAttribute(16842829, typedValue, true)) {
                return 48;
            }
            this.cachedVerticalScrollFactor = (int) typedValue.getDimension(context.getResources().getDisplayMetrics());
        }
        return this.cachedVerticalScrollFactor;
    }

    public boolean onGenericMotionEvent(@NonNull MotionEvent motionEvent, @NonNull Context context) {
        boolean z10 = motionEvent.isFromSource(2);
        boolean z11 = motionEvent.getActionMasked() == 7 || motionEvent.getActionMasked() == 8;
        if (!z10 || !z11) {
            return false;
        }
        int pointerChangeForAction = getPointerChangeForAction(motionEvent.getActionMasked());
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(motionEvent.getPointerCount() * 36 * 8);
        allocateDirect.order(ByteOrder.LITTLE_ENDIAN);
        addPointerForIndex(motionEvent, motionEvent.getActionIndex(), pointerChangeForAction, 0, IDENTITY_TRANSFORM, allocateDirect, context);
        if (allocateDirect.position() % 288 == 0) {
            this.renderer.dispatchPointerDataPacket(allocateDirect, allocateDirect.position());
            return true;
        }
        throw new AssertionError((Object) "Packet position is not on field boundary.");
    }

    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        return onTouchEvent(motionEvent, IDENTITY_TRANSFORM);
    }

    private void addPointerForIndex(MotionEvent motionEvent, int i10, int i11, int i12, Matrix matrix, ByteBuffer byteBuffer, Context context) {
        long j10;
        int i13;
        double d10;
        double d11;
        double d12;
        double d13;
        double d14;
        InputDevice.MotionRange motionRange;
        int i14 = -1;
        if (i11 == -1) {
            return;
        }
        int pointerId = motionEvent.getPointerId(i10);
        int pointerDeviceTypeForToolType = getPointerDeviceTypeForToolType(motionEvent.getToolType(i10));
        float[] fArr = {motionEvent.getX(i10), motionEvent.getY(i10)};
        matrix.mapPoints(fArr);
        if (pointerDeviceTypeForToolType == 1) {
            j10 = motionEvent.getButtonState() & 31;
            if (j10 == 0 && motionEvent.getSource() == 8194 && i11 == 4) {
                this.ongoingPans.put(Integer.valueOf(pointerId), fArr);
            }
        } else {
            j10 = pointerDeviceTypeForToolType == 2 ? (motionEvent.getButtonState() >> 4) & 15 : 0L;
        }
        boolean containsKey = this.ongoingPans.containsKey(Integer.valueOf(pointerId));
        if (containsKey) {
            int pointerChangeForPanZoom = getPointerChangeForPanZoom(i11);
            if (pointerChangeForPanZoom == -1) {
                return;
            } else {
                i14 = pointerChangeForPanZoom;
            }
        }
        long id2 = this.trackMotionEvents ? this.motionEventTracker.track(motionEvent).getId() : 0L;
        int i15 = motionEvent.getActionMasked() == 8 ? 1 : 0;
        int i16 = i14;
        long eventTime = motionEvent.getEventTime() * 1000;
        byteBuffer.putLong(id2);
        byteBuffer.putLong(eventTime);
        if (containsKey) {
            i13 = i16;
            byteBuffer.putLong(i13);
            byteBuffer.putLong(4L);
        } else {
            i13 = i16;
            byteBuffer.putLong(i11);
            byteBuffer.putLong(pointerDeviceTypeForToolType);
        }
        byteBuffer.putLong(i15);
        byteBuffer.putLong(pointerId);
        byteBuffer.putLong(0L);
        if (containsKey) {
            float[] fArr2 = this.ongoingPans.get(Integer.valueOf(pointerId));
            byteBuffer.putDouble(fArr2[0]);
            byteBuffer.putDouble(fArr2[1]);
        } else {
            byteBuffer.putDouble(fArr[0]);
            byteBuffer.putDouble(fArr[1]);
        }
        byteBuffer.putDouble(ShadowDrawableWrapper.COS_45);
        byteBuffer.putDouble(ShadowDrawableWrapper.COS_45);
        byteBuffer.putLong(j10);
        byteBuffer.putLong(0L);
        byteBuffer.putLong(0L);
        byteBuffer.putDouble(motionEvent.getPressure(i10));
        if (motionEvent.getDevice() == null || (motionRange = motionEvent.getDevice().getMotionRange(2)) == null) {
            d10 = 1.0d;
            d11 = ShadowDrawableWrapper.COS_45;
        } else {
            d11 = motionRange.getMin();
            d10 = motionRange.getMax();
        }
        byteBuffer.putDouble(d11);
        byteBuffer.putDouble(d10);
        if (pointerDeviceTypeForToolType == 2) {
            byteBuffer.putDouble(motionEvent.getAxisValue(24, i10));
            d12 = ShadowDrawableWrapper.COS_45;
            byteBuffer.putDouble(ShadowDrawableWrapper.COS_45);
        } else {
            d12 = ShadowDrawableWrapper.COS_45;
            byteBuffer.putDouble(ShadowDrawableWrapper.COS_45);
            byteBuffer.putDouble(ShadowDrawableWrapper.COS_45);
        }
        byteBuffer.putDouble(motionEvent.getSize(i10));
        byteBuffer.putDouble(motionEvent.getToolMajor(i10));
        byteBuffer.putDouble(motionEvent.getToolMinor(i10));
        byteBuffer.putDouble(d12);
        byteBuffer.putDouble(d12);
        byteBuffer.putDouble(motionEvent.getAxisValue(8, i10));
        if (pointerDeviceTypeForToolType == 2) {
            byteBuffer.putDouble(motionEvent.getAxisValue(25, i10));
        } else {
            byteBuffer.putDouble(d12);
        }
        byteBuffer.putLong(i12);
        if (i15 == 1) {
            double d15 = 48.0d;
            if (context != null) {
                d15 = getHorizontalScrollFactor(context);
                d14 = getVerticalScrollFactor(context);
            } else {
                d14 = 48.0d;
            }
            byteBuffer.putDouble(d15 * (-motionEvent.getAxisValue(10, i10)));
            byteBuffer.putDouble(d14 * (-motionEvent.getAxisValue(9, i10)));
        } else {
            byteBuffer.putDouble(ShadowDrawableWrapper.COS_45);
            byteBuffer.putDouble(ShadowDrawableWrapper.COS_45);
        }
        if (containsKey) {
            float[] fArr3 = this.ongoingPans.get(Integer.valueOf(pointerId));
            byteBuffer.putDouble(fArr[0] - fArr3[0]);
            byteBuffer.putDouble(fArr[1] - fArr3[1]);
            d13 = ShadowDrawableWrapper.COS_45;
        } else {
            d13 = ShadowDrawableWrapper.COS_45;
            byteBuffer.putDouble(ShadowDrawableWrapper.COS_45);
            byteBuffer.putDouble(ShadowDrawableWrapper.COS_45);
        }
        byteBuffer.putDouble(d13);
        byteBuffer.putDouble(d13);
        byteBuffer.putDouble(1.0d);
        byteBuffer.putDouble(d13);
        byteBuffer.putLong(0L);
        if (containsKey && i13 == 9) {
            this.ongoingPans.remove(Integer.valueOf(pointerId));
        }
    }

    public boolean onTouchEvent(@NonNull MotionEvent motionEvent, @NonNull Matrix matrix) {
        int pointerCount = motionEvent.getPointerCount();
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(pointerCount * 36 * 8);
        allocateDirect.order(ByteOrder.LITTLE_ENDIAN);
        int actionMasked = motionEvent.getActionMasked();
        int pointerChangeForAction = getPointerChangeForAction(motionEvent.getActionMasked());
        boolean z10 = actionMasked == 0 || actionMasked == 5;
        boolean z11 = !z10 && (actionMasked == 1 || actionMasked == 6);
        if (z10) {
            addPointerForIndex(motionEvent, motionEvent.getActionIndex(), pointerChangeForAction, 0, matrix, allocateDirect);
        } else if (z11) {
            for (int i10 = 0; i10 < pointerCount; i10++) {
                if (i10 != motionEvent.getActionIndex() && motionEvent.getToolType(i10) == 1) {
                    addPointerForIndex(motionEvent, i10, 5, 1, matrix, allocateDirect);
                }
            }
            addPointerForIndex(motionEvent, motionEvent.getActionIndex(), pointerChangeForAction, 0, matrix, allocateDirect);
        } else {
            for (int i11 = 0; i11 < pointerCount; i11++) {
                addPointerForIndex(motionEvent, i11, pointerChangeForAction, 0, matrix, allocateDirect);
            }
        }
        if (allocateDirect.position() % 288 == 0) {
            this.renderer.dispatchPointerDataPacket(allocateDirect, allocateDirect.position());
            return true;
        }
        throw new AssertionError((Object) "Packet position is not on field boundary");
    }
}
