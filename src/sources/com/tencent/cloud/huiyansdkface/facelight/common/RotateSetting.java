package com.tencent.cloud.huiyansdkface.facelight.common;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.hardware.Camera;
import android.view.WindowManager;
import com.tencent.cloud.huiyansdkface.facelight.net.model.Param;
import com.tencent.cloud.huiyansdkface.normal.tools.WLogger;
import java.io.ByteArrayOutputStream;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class RotateSetting {

    /* renamed from: a, reason: collision with root package name */
    private static final String f40687a = "RotateSetting";

    /* renamed from: b, reason: collision with root package name */
    private static int f40688b = 0;

    /* renamed from: c, reason: collision with root package name */
    private static int f40689c = -1;

    public static byte[] Nv21MirrorCenter(byte[] bArr, int i10, int i11) {
        int i12 = 0;
        int i13 = 0;
        while (i12 < i11) {
            int i14 = i13 + i10;
            for (int i15 = i14 - 1; i13 < i15; i15--) {
                byte b4 = bArr[i13];
                bArr[i13] = bArr[i15];
                bArr[i15] = b4;
                i13++;
            }
            i12++;
            i13 = i14;
        }
        int i16 = i10 * i11;
        int i17 = 0;
        for (int i18 = 0; i18 < i11 / 2; i18++) {
            int i19 = i16 + i17;
            int i20 = (i19 + i10) - 2;
            while (i19 < i20) {
                byte b10 = bArr[i19];
                bArr[i19] = bArr[i20];
                bArr[i20] = b10;
                int i21 = i19 + 1;
                int i22 = i20 - 1;
                byte b11 = bArr[i21];
                bArr[i21] = bArr[i22];
                bArr[i22] = b11;
                i19 = i21 + 1;
                i20 = i22 - 1;
            }
            i17 += i10;
        }
        return bArr;
    }

    private static int a(int i10) {
        if (i10 == 1) {
            return 2;
        }
        if (i10 == 2) {
            return 1;
        }
        if (i10 == 3) {
            return 4;
        }
        if (i10 == 4) {
            return 3;
        }
        if (i10 == 5) {
            return 8;
        }
        if (i10 == 6) {
            return 7;
        }
        if (i10 == 7) {
            return 6;
        }
        if (i10 == 8) {
            return 5;
        }
        WLogger.w(f40687a, "[YtCameraSetting.transBackFacingCameraRatateTag] unsurported rotateTag: " + i10);
        return 0;
    }

    private static int a(int i10, int i11) {
        int i12;
        if (i10 == 90) {
            i12 = 7;
        } else if (i10 == 180) {
            i12 = 3;
        } else if (i10 == 270) {
            i12 = 5;
        } else {
            WLogger.i(f40687a, "camera rotate not 90degree or 180degree, input: " + i10);
            i12 = 1;
        }
        return i11 == 1 ? i12 : a(i12);
    }

    private static int a(Context context, int i10) {
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        Camera.getCameraInfo(i10, cameraInfo);
        int rotation = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation();
        int i11 = 0;
        if (rotation != 0) {
            if (rotation == 1) {
                i11 = 90;
            } else if (rotation == 2) {
                i11 = 180;
            } else if (rotation == 3) {
                i11 = 270;
            }
        }
        int i12 = (cameraInfo.facing == 1 ? 360 - ((cameraInfo.orientation + i11) % 360) : (cameraInfo.orientation - i11) + 360) % 360;
        WLogger.i(f40687a, "debug camera orientation is " + cameraInfo.orientation + " ui degrees is " + i11);
        f40689c = i12;
        return i12;
    }

    public static void calRotateTag(Context context, int i10, int i11) {
        f40688b = a(a(context, i10), i11);
    }

    public static int getRotate() {
        return f40688b;
    }

    public static int getVideoRotate() {
        return f40689c;
    }

    public static byte[] rawCamDataToJpg(int i10, byte[] bArr, int i11, int i12, boolean z10) {
        int i13;
        int i14;
        int i15;
        int i16;
        byte[] rotateRawCamData = rotateRawCamData(i10, bArr, i11, i12);
        if (z10 && (i10 == 1 || i10 == 2 || i10 == 3 || i10 == 4)) {
            i14 = i11;
            i13 = i12;
        } else {
            i13 = i11;
            i14 = i12;
        }
        if (i10 == 5 || i10 == 6 || i10 == 7 || i10 == 8) {
            i15 = i11;
            i16 = i12;
        } else {
            i16 = i13;
            i15 = i14;
        }
        YuvImage yuvImage = new YuvImage(rotateRawCamData, 17, i16, i15, null);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        yuvImage.compressToJpeg(new Rect(0, 0, yuvImage.getWidth(), yuvImage.getHeight()), 100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.reset();
            byteArrayOutputStream.close();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return byteArray;
    }

    public static byte[] rotateNV21Degree90(byte[] bArr, int i10, int i11) {
        int i12 = i10 * i11;
        int i13 = (i12 * 3) / 2;
        byte[] bArr2 = new byte[i13];
        int i14 = 0;
        for (int i15 = 0; i15 < i10; i15++) {
            for (int i16 = i11 - 1; i16 >= 0; i16--) {
                bArr2[i14] = bArr[(i16 * i10) + i15];
                i14++;
            }
        }
        int i17 = i13 - 1;
        for (int i18 = i10 - 1; i18 > 0; i18 -= 2) {
            for (int i19 = 0; i19 < i11 / 2; i19++) {
                int i20 = (i19 * i10) + i12;
                bArr2[i17] = bArr[i20 + i18];
                int i21 = i17 - 1;
                bArr2[i21] = bArr[i20 + (i18 - 1)];
                i17 = i21 - 1;
            }
        }
        return bArr2;
    }

    public static byte[] rotateRawCamData(int i10, byte[] bArr, int i11, int i12) {
        switch (i10) {
            case 2:
                return Nv21MirrorCenter(bArr, i11, i12);
            case 3:
                return rotateYUV420Degree180(bArr, i11, i12);
            case 4:
                return rotateYUV420Degree180(Nv21MirrorCenter(bArr, i11, i12), i11, i12);
            case 5:
                return rotateYUV420Degree270(Nv21MirrorCenter(bArr, i11, i12), i11, i12);
            case 6:
                return rotateNV21Degree90(bArr, i11, i12);
            case 7:
                return rotateNV21Degree90(Nv21MirrorCenter(bArr, i11, i12), i11, i12);
            case 8:
                return rotateYUV420Degree270(bArr, i11, i12);
            default:
                return bArr;
        }
    }

    public static byte[] rotateYUV420Degree180(byte[] bArr, int i10, int i11) {
        int i12 = i10 * i11;
        int i13 = (i12 * 3) / 2;
        byte[] bArr2 = new byte[i13];
        int i14 = 0;
        for (int i15 = i12 - 1; i15 >= 0; i15--) {
            bArr2[i14] = bArr[i15];
            i14++;
        }
        for (int i16 = i13 - 1; i16 >= i12; i16 -= 2) {
            int i17 = i14 + 1;
            bArr2[i14] = bArr[i16 - 1];
            i14 = i17 + 1;
            bArr2[i17] = bArr[i16];
        }
        return bArr2;
    }

    public static byte[] rotateYUV420Degree270(byte[] bArr, int i10, int i11) {
        int i12 = i10 * i11;
        byte[] bArr2 = new byte[(i12 * 3) / 2];
        int i13 = i10 - 1;
        int i14 = 0;
        for (int i15 = i13; i15 >= 0; i15--) {
            for (int i16 = 0; i16 < i11; i16++) {
                bArr2[i14] = bArr[(i16 * i10) + i15];
                i14++;
            }
        }
        while (i13 > 0) {
            for (int i17 = 0; i17 < i11 / 2; i17++) {
                int i18 = (i17 * i10) + i12;
                bArr2[i14] = bArr[(i13 - 1) + i18];
                int i19 = i14 + 1;
                bArr2[i19] = bArr[i18 + i13];
                i14 = i19 + 1;
            }
            i13 -= 2;
        }
        return bArr2;
    }

    public static void setRotateInfo(int i10) {
        int i11;
        switch (i10) {
            case 1:
            case 2:
                WLogger.d(f40687a, "ROTATE 0");
                i11 = 0;
                break;
            case 3:
            case 4:
                WLogger.d(f40687a, "ROTATE 180");
                i11 = 180;
                break;
            case 5:
            case 6:
                WLogger.d(f40687a, "ROTATE 270");
                i11 = 270;
                break;
            case 7:
            case 8:
                WLogger.d(f40687a, "ROTATE 90");
                i11 = 90;
                break;
            default:
                return;
        }
        Param.setRolateInfo(String.valueOf(i11));
    }
}
