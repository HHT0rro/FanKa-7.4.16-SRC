package com.alibaba.security.biometrics.jni;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class YuvEngineWrap {
    private static Object lockobj = new Object();
    private static YuvEngineWrap mInstance;
    private long cPtr = 0;

    private YuvEngineWrap() {
    }

    public static YuvEngineWrap getInstance() {
        synchronized (lockobj) {
            if (mInstance == null) {
                mInstance = new YuvEngineWrap();
            }
        }
        return mInstance;
    }

    public void I420ClockWiseRotate90(byte[] bArr, int i10, int i11, byte[] bArr2, int[] iArr, int[] iArr2) {
        long j10 = this.cPtr;
        if (j10 != 0) {
            YuvEngineNative.I420ClockWiseRotate90(j10, bArr, i10, i11, bArr2, iArr, iArr2);
        }
    }

    public void I420ToNv21(byte[] bArr, byte[] bArr2, int i10, int i11) {
        long j10 = this.cPtr;
        if (j10 != 0) {
            YuvEngineNative.I420ToNv21(j10, bArr, bArr2, i10, i11);
        }
    }

    public void I420ToYv12(byte[] bArr, byte[] bArr2, int i10, int i11) {
        long j10 = this.cPtr;
        if (j10 != 0) {
            YuvEngineNative.I420ToYv12(j10, bArr, bArr2, i10, i11);
        }
    }

    public void Nv12ClockWiseRotate90(byte[] bArr, int i10, int i11, byte[] bArr2, int[] iArr, int[] iArr2) {
        long j10 = this.cPtr;
        if (j10 != 0) {
            YuvEngineNative.Nv12ClockWiseRotate90(j10, bArr, i10, i11, bArr2, iArr, iArr2);
        }
    }

    public void Nv12ToNv21(byte[] bArr, byte[] bArr2, int i10, int i11) {
        long j10 = this.cPtr;
        if (j10 != 0) {
            YuvEngineNative.Nv12ToNv21(j10, bArr, bArr2, i10, i11);
        }
    }

    public void Nv21ClockWiseRotate180(byte[] bArr, int i10, int i11, byte[] bArr2, int[] iArr, int[] iArr2) {
        long j10 = this.cPtr;
        if (j10 != 0) {
            YuvEngineNative.Nv21ClockWiseRotate180(j10, bArr, i10, i11, bArr2, iArr, iArr2);
        }
    }

    public void Nv21ClockWiseRotate270(byte[] bArr, int i10, int i11, byte[] bArr2, int[] iArr, int[] iArr2) {
        long j10 = this.cPtr;
        if (j10 != 0) {
            YuvEngineNative.Nv21ClockWiseRotate270(j10, bArr, i10, i11, bArr2, iArr, iArr2);
        }
    }

    public void Nv21ClockWiseRotate90(byte[] bArr, int i10, int i11, byte[] bArr2, int[] iArr, int[] iArr2) {
        long j10 = this.cPtr;
        if (j10 != 0) {
            YuvEngineNative.Nv21ClockWiseRotate90(j10, bArr, i10, i11, bArr2, iArr, iArr2);
        }
    }

    public void Nv21ToI420(byte[] bArr, byte[] bArr2, int i10, int i11) {
        long j10 = this.cPtr;
        if (j10 != 0) {
            YuvEngineNative.Nv21ToI420(j10, bArr, bArr2, i10, i11);
        }
    }

    public void Nv21ToNv12(byte[] bArr, byte[] bArr2, int i10, int i11) {
        long j10 = this.cPtr;
        if (j10 != 0) {
            YuvEngineNative.Nv21ToNv12(j10, bArr, bArr2, i10, i11);
        }
    }

    public void Nv21ToYv12(byte[] bArr, byte[] bArr2, int i10, int i11) {
        long j10 = this.cPtr;
        if (j10 != 0) {
            YuvEngineNative.Nv21ToYV12(j10, bArr, bArr2, i10, i11);
        }
    }

    public void Yv12ClockWiseRotate90(byte[] bArr, int i10, int i11, byte[] bArr2, int[] iArr, int[] iArr2) {
        long j10 = this.cPtr;
        if (j10 != 0) {
            YuvEngineNative.Yv12ClockWiseRotate90(j10, bArr, i10, i11, bArr2, iArr, iArr2);
        }
    }

    public void Yv12ToI420(byte[] bArr, byte[] bArr2, int i10, int i11) {
        long j10 = this.cPtr;
        if (j10 != 0) {
            YuvEngineNative.Yv12ToI420(j10, bArr, bArr2, i10, i11);
        }
    }

    public void Yv12ToNv21(byte[] bArr, byte[] bArr2, int i10, int i11) {
        long j10 = this.cPtr;
        if (j10 != 0) {
            YuvEngineNative.YV12ToNv21(j10, bArr, bArr2, i10, i11);
        }
    }

    public void cutCommonYuv(int i10, int i11, int i12, byte[] bArr, int i13, int i14, byte[] bArr2, int i15, int i16) {
        long j10 = this.cPtr;
        if (j10 != 0) {
            YuvEngineNative.cutCommonYuv(j10, i10, i11, i12, bArr, i13, i14, bArr2, i15, i16);
        }
    }

    public void getSpecYuvBuffer(int i10, byte[] bArr, byte[] bArr2, int i11, int i12, int i13, int i14) {
        long j10 = this.cPtr;
        if (j10 != 0) {
            YuvEngineNative.getSpecYuvBuffer(j10, i10, bArr, bArr2, i11, i12, i13, i14);
        }
    }

    public void startYuvEngine() {
        this.cPtr = YuvEngineNative.startYuvEngine();
    }

    public void stopYuvEngine() {
        long j10 = this.cPtr;
        if (j10 != 0) {
            YuvEngineNative.stopYuvEngine(j10);
        }
        mInstance = null;
    }

    public void yuvAddWaterMark(int i10, int i11, int i12, byte[] bArr, int i13, int i14, byte[] bArr2, int i15, int i16) {
        long j10 = this.cPtr;
        if (j10 != 0) {
            YuvEngineNative.yuvAddWaterMark(j10, i10, i11, i12, bArr, i13, i14, bArr2, i15, i16);
        }
    }
}
