package com.tencent.youtu.ytposedetect.jni;

import android.graphics.Bitmap;
import com.tencent.youtu.ytposedetect.data.YTActRefData;
import com.tencent.youtu.ytposedetect.data.YTActRefImage;
import java.io.ByteArrayOutputStream;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class YTPoseDetectJNIInterface {
    private static IYtLoggerListener loggerListener;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface IYtLoggerListener {
        void log(String str, String str2);
    }

    public static native String Checksum(byte[] bArr);

    public static native boolean canReflect();

    public static native void configNativeLog(boolean z10);

    public static byte[] encodeJpeg(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 99, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static native YTActRefData getActionReflectData(int i10);

    public static native byte[] getBestImage(int i10);

    public static native byte[] getEyeImage(int i10);

    public static native byte[][] getFrameList();

    public static native String getLiveSelectDataChecksum(String str, String str2);

    public static native byte[] getMouthImage(int i10);

    public static native String getVersion();

    public static native int initModel(String str);

    public static native boolean isRecordingDone();

    public static void nativeLog(int i10, String str) {
        IYtLoggerListener iYtLoggerListener = loggerListener;
        if (iYtLoggerListener != null) {
            iYtLoggerListener.log("[YTPoseDetectJNIInterface.nativeLog]", str);
        }
    }

    public static void nativeLog(String str, String str2) {
        IYtLoggerListener iYtLoggerListener = loggerListener;
        if (iYtLoggerListener != null) {
            iYtLoggerListener.log(str, str2);
        }
    }

    public static native int poseDetect(float[] fArr, float[] fArr2, int i10, byte[] bArr, int i11, int i12, int i13, float f10, float f11, float f12, int i14, int i15);

    public static native void releaseAll();

    public static native void resetDetect();

    public static native byte[] rotateYuv(byte[] bArr, int i10, int i11, int i12);

    public static native void setColorData(String str, String str2, String str3);

    public static void setLoggerListener(IYtLoggerListener iYtLoggerListener) {
        loggerListener = iYtLoggerListener;
    }

    public static native void setSafetyLevel(int i10);

    public static native int updateParam(String str, String str2);

    public static native YTActRefImage yuv2bgr(float[] fArr, byte[] bArr, int i10, int i11, int i12, int i13, int i14);
}
