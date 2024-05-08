package com.tencent.liteav.videoproducer.capture;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.annotations.CalledByNative;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.Rotation;
import com.tencent.liteav.videobase.frame.PixelFrame;
import com.tencent.liteav.videobase.videobase.IVideoReporter;
import java.util.Locale;

@JNINamespace("liteav::video")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class CaptureSourceInterface {
    private static final String TAG = "CaptureSourceInterface";

    /* renamed from: com.tencent.liteav.videoproducer.capture.CaptureSourceInterface$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f44180a;

        static {
            int[] iArr = new int[SourceType.values().length];
            f44180a = iArr;
            try {
                iArr[SourceType.CAMERA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f44180a[SourceType.SCREEN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f44180a[SourceType.VIRTUAL_CAMERA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class CaptureParams {

        /* renamed from: b, reason: collision with root package name */
        public int f44181b;

        /* renamed from: c, reason: collision with root package name */
        public int f44182c;

        /* renamed from: d, reason: collision with root package name */
        public int f44183d;

        /* renamed from: e, reason: collision with root package name */
        public Rect f44184e;

        public CaptureParams() {
        }

        public CaptureParams(CaptureParams captureParams) {
            this.f44181b = captureParams.f44181b;
            this.f44182c = captureParams.f44182c;
            this.f44183d = captureParams.f44183d;
            this.f44184e = captureParams.f44184e;
        }

        public boolean equals(@Nullable Object obj) {
            if (!(obj instanceof CaptureParams)) {
                return false;
            }
            CaptureParams captureParams = (CaptureParams) obj;
            return this.f44181b == captureParams.f44181b && this.f44182c == captureParams.f44182c && this.f44183d == captureParams.f44183d;
        }

        @NonNull
        public String toString() {
            return String.format(Locale.ENGLISH, "size: %dx%d, fps: %d", Integer.valueOf(this.f44182c), Integer.valueOf(this.f44183d), Integer.valueOf(this.f44181b));
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface CaptureSourceListener {
        void onCameraTouchEnable(boolean z10);

        void onCameraZoomEnable(boolean z10);

        void onCaptureError();

        void onCaptureFirstFrame();

        void onFrameAvailable(@Nullable CaptureSourceInterface captureSourceInterface, PixelFrame pixelFrame);

        void onScreenDisplayOrientationChanged(Rotation rotation);

        void onStartFinish(boolean z10);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public enum SourceType {
        NONE(0),
        CAMERA(1),
        SCREEN(2),
        VIRTUAL_CAMERA(3),
        CUSTOM(4);

        public final int mValue;

        SourceType(int i10) {
            this.mValue = i10;
        }

        public static SourceType a(int i10) {
            for (SourceType sourceType : values()) {
                if (sourceType.mValue == i10) {
                    return sourceType;
                }
            }
            return NONE;
        }
    }

    @CalledByNative
    public static CaptureSourceInterface create(SourceType sourceType, IVideoReporter iVideoReporter, Handler handler) {
        if (handler != null && handler.getLooper() != null) {
            Looper looper = handler.getLooper();
            Context applicationContext = ContextUtils.getApplicationContext();
            int i10 = AnonymousClass1.f44180a[sourceType.ordinal()];
            if (i10 == 1) {
                return new t(iVideoReporter, looper);
            }
            if (i10 == 2) {
                return new ScreenCapturer(applicationContext, looper, iVideoReporter);
            }
            if (i10 != 3) {
                return null;
            }
            return new VirtualCamera(looper, iVideoReporter);
        }
        LiteavLog.e(TAG, "create capture source instance with invalid handler ".concat(String.valueOf(handler)));
        return null;
    }

    @CalledByNative
    public abstract void pause();

    @CalledByNative
    public abstract void resume();

    @CalledByNative
    public abstract void setCaptureCloudConfig(CaptureCloudConfig captureCloudConfig);

    @CalledByNative
    public abstract void start(Object obj, CaptureParams captureParams, CaptureSourceListener captureSourceListener);

    @CalledByNative
    public abstract void stop();

    @CalledByNative
    public abstract void updateParams(CaptureParams captureParams);
}
