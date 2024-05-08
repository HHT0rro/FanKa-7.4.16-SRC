package com.tencent.liteav.videoproducer2;

import android.os.Looper;
import android.view.OrientationEventListener;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.annotations.CalledByNative;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.Rotation;
import com.tencent.liteav.base.util.SystemUtil;
import com.tencent.liteav.base.util.w;

@JNINamespace("liteav::video")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class SystemNotificationMonitor extends OrientationEventListener implements w.a {
    private Rotation mDisplayRotation;
    private volatile long mListenerPtr;
    private Rotation mSensorRotation;
    private volatile w mTimer;

    /* renamed from: com.tencent.liteav.videoproducer2.SystemNotificationMonitor$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f45065a;

        static {
            int[] iArr = new int[Rotation.values().length];
            f45065a = iArr;
            try {
                iArr[Rotation.ROTATION_90.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f45065a[Rotation.ROTATION_180.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f45065a[Rotation.ROTATION_270.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f45065a[Rotation.NORMAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    @CalledByNative
    public SystemNotificationMonitor() {
        super(ContextUtils.getApplicationContext());
        this.mTimer = null;
        this.mListenerPtr = 0L;
        this.mSensorRotation = null;
        this.mDisplayRotation = null;
    }

    private Rotation getSensorRotationByDisplayRotation(Rotation rotation) {
        if (rotation == null) {
            return Rotation.NORMAL;
        }
        int i10 = AnonymousClass1.f45065a[rotation.ordinal()];
        if (i10 == 1) {
            return Rotation.ROTATION_270;
        }
        if (i10 == 2) {
            return Rotation.ROTATION_180;
        }
        if (i10 != 3) {
            return Rotation.NORMAL;
        }
        return Rotation.ROTATION_90;
    }

    private static native void nativeSensorChanged(long j10, int i10, int i11);

    private synchronized void notifyOrientationChanged() {
        if (this.mListenerPtr == 0) {
            return;
        }
        Rotation rotation = this.mSensorRotation;
        int i10 = rotation != null ? rotation.mValue : 0;
        Rotation rotation2 = this.mDisplayRotation;
        nativeSensorChanged(this.mListenerPtr, i10, rotation2 != null ? rotation2.mValue : 0);
    }

    @CalledByNative
    public synchronized void initialize(long j10) {
        this.mListenerPtr = j10;
        if (this.mTimer != null) {
            return;
        }
        super.enable();
        this.mTimer = new w(Looper.getMainLooper(), this);
        this.mTimer.a(0, 1000);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0023 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0024  */
    @Override // android.view.OrientationEventListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onOrientationChanged(int r2) {
        /*
            r1 = this;
            r0 = -1
            if (r2 != r0) goto L4
            return
        L4:
            r0 = 45
            if (r2 <= r0) goto L1d
            r0 = 135(0x87, float:1.89E-43)
            if (r2 > r0) goto Lf
            com.tencent.liteav.base.util.Rotation r2 = com.tencent.liteav.base.util.Rotation.ROTATION_90
            goto L1f
        Lf:
            r0 = 225(0xe1, float:3.15E-43)
            if (r2 > r0) goto L16
            com.tencent.liteav.base.util.Rotation r2 = com.tencent.liteav.base.util.Rotation.ROTATION_180
            goto L1f
        L16:
            r0 = 315(0x13b, float:4.41E-43)
            if (r2 > r0) goto L1d
            com.tencent.liteav.base.util.Rotation r2 = com.tencent.liteav.base.util.Rotation.ROTATION_270
            goto L1f
        L1d:
            com.tencent.liteav.base.util.Rotation r2 = com.tencent.liteav.base.util.Rotation.NORMAL
        L1f:
            com.tencent.liteav.base.util.Rotation r0 = r1.mSensorRotation
            if (r0 != r2) goto L24
            return
        L24:
            r1.mSensorRotation = r2
            int r2 = com.tencent.liteav.base.util.SystemUtil.getDisplayRotationDegree()
            com.tencent.liteav.base.util.Rotation r2 = com.tencent.liteav.base.util.Rotation.a(r2)
            r1.mDisplayRotation = r2
            r1.notifyOrientationChanged()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.videoproducer2.SystemNotificationMonitor.onOrientationChanged(int):void");
    }

    @Override // com.tencent.liteav.base.util.w.a
    public void onTimeout() {
        Rotation a10 = Rotation.a(SystemUtil.getDisplayRotationDegree());
        if (this.mDisplayRotation == a10) {
            return;
        }
        this.mDisplayRotation = a10;
        if (this.mSensorRotation == null) {
            this.mSensorRotation = getSensorRotationByDisplayRotation(a10);
        }
        notifyOrientationChanged();
    }

    @CalledByNative
    public synchronized void uninitialize() {
        super.disable();
        this.mListenerPtr = 0L;
        if (this.mTimer != null) {
            this.mTimer.a();
            this.mTimer = null;
        }
    }
}
