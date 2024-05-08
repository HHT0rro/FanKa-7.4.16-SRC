package com.tencent.cloud.huiyansdkface.facelight.c;

import android.util.Base64;
import com.tencent.cloud.huiyansdkface.normal.tools.WLogger;
import com.tencent.youtu.liveness.YTFaceTracker;
import com.tencent.youtu.ytagreflectlivecheck.jni.cppDefine.DataPack;
import com.tencent.youtu.ytagreflectlivecheck.jni.cppDefine.RawImgData;
import com.tencent.youtu.ytagreflectlivecheck.jni.cppDefine.Timeval;
import com.tencent.youtu.ytagreflectlivecheck.jni.model.ColorImgData;
import com.tencent.youtu.ytagreflectlivecheck.jni.model.ReflectColorData;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static final String f40613a = "b";

    private static float a(float f10, float f11, float f12, float f13) {
        return (f10 * f13) - (f12 * f11);
    }

    public static float a(float[] fArr) {
        float f10 = fArr[32] - fArr[40];
        float f11 = fArr[33] - fArr[41];
        float sqrt = (float) Math.sqrt((f10 * f10) + (f11 * f11));
        float abs = (Math.abs(a(f10, f11, fArr[44] - fArr[40], fArr[45] - fArr[41])) + Math.abs(a(f10, f11, fArr[36] - fArr[40], fArr[37] - fArr[41]))) / (sqrt * sqrt);
        float f12 = fArr[56] - fArr[48];
        float f13 = fArr[57] - fArr[49];
        float sqrt2 = (float) Math.sqrt((f12 * f12) + (f13 * f13));
        float abs2 = (Math.abs(a(f12, f13, fArr[60] - fArr[56], fArr[61] - fArr[57])) + Math.abs(a(f12, f13, fArr[52] - fArr[56], fArr[53] - fArr[57]))) / (sqrt2 * sqrt2);
        return abs > abs2 ? abs2 : abs;
    }

    public static Timeval a(long j10) {
        return new Timeval(j10 / 1000, (int) ((j10 * 1000) % 1000000));
    }

    private static ColorImgData a(RawImgData rawImgData) {
        ColorImgData colorImgData = new ColorImgData();
        colorImgData.setImage(new String(Base64.encode(rawImgData.frameBuffer, 2)));
        colorImgData.checksum = rawImgData.checksum;
        colorImgData.setCapture_time(rawImgData.captureTime);
        colorImgData.setX(rawImgData.f46038x);
        colorImgData.setY(rawImgData.f46039y);
        return colorImgData;
    }

    public static ReflectColorData a(DataPack dataPack) {
        ReflectColorData reflectColorData = new ReflectColorData();
        ArrayList<ColorImgData> arrayList = new ArrayList<>();
        int i10 = 0;
        int i11 = 0;
        while (true) {
            RawImgData[] rawImgDataArr = dataPack.videoData;
            if (i11 >= rawImgDataArr.length) {
                break;
            }
            arrayList.add(a(rawImgDataArr[i11]));
            i11++;
        }
        reflectColorData.setImages_data(arrayList);
        reflectColorData.setBegin_time(dataPack.beginTime);
        reflectColorData.setChangepoint_time(dataPack.changePointTime);
        reflectColorData.changepoint_time_list = new ArrayList<>();
        while (true) {
            long[] jArr = dataPack.changePointTimeList;
            if (i10 >= jArr.length) {
                break;
            }
            reflectColorData.changepoint_time_list.add(Long.valueOf(jArr[i10]));
            i10++;
        }
        reflectColorData.setOffset_sys(dataPack.offsetSys);
        reflectColorData.setFrame_num(dataPack.frameNum);
        reflectColorData.setLandmark_num(dataPack.landMarkNum);
        reflectColorData.setWidth(dataPack.width);
        reflectColorData.setHeight(dataPack.height);
        reflectColorData.version = "3.6.7";
        try {
            reflectColorData.setLog(new String(dataPack.log, "UTF-8"));
        } catch (UnsupportedEncodingException unused) {
        }
        reflectColorData.setConfig_begin(dataPack.config_begin);
        return reflectColorData;
    }

    public static boolean a(YTFaceTracker.TrackedFace trackedFace, float f10, float f11) {
        int i10;
        int i11;
        String str;
        StringBuilder sb2;
        String str2;
        int i12 = (int) (f10 * 17.0f);
        int i13 = 0;
        int i14 = 0;
        while (true) {
            if (i13 >= 8) {
                break;
            }
            if (trackedFace.faceVisible[i13] < f11) {
                i14++;
            }
            i13++;
        }
        int i15 = 16;
        while (true) {
            if (i15 >= 24) {
                break;
            }
            if (trackedFace.faceVisible[i15] < f11) {
                i14++;
            }
            i15++;
        }
        if (trackedFace.faceVisible[88] < f11) {
            i14++;
        }
        if (i14 > i12) {
            str = f40613a;
            sb2 = new StringBuilder();
            str2 = "左眼部被挡住，count=";
        } else {
            i14 = 0;
            for (i10 = 8; i10 < 16; i10++) {
                if (trackedFace.faceVisible[i10] < f11) {
                    i14++;
                }
            }
            for (i11 = 24; i11 < 32; i11++) {
                if (trackedFace.faceVisible[i11] < f11) {
                    i14++;
                }
            }
            if (trackedFace.faceVisible[89] < f11) {
                i14++;
            }
            if (i14 <= i12) {
                return false;
            }
            str = f40613a;
            sb2 = new StringBuilder();
            str2 = "右眼部被挡住，count=";
        }
        sb2.append(str2);
        sb2.append(i14);
        WLogger.w(str, sb2.toString());
        return true;
    }

    public static YTFaceTracker.TrackedFace[] a(YTFaceTracker.TrackedFace[] trackedFaceArr) {
        if (trackedFaceArr != null) {
            for (int i10 = 0; i10 < trackedFaceArr.length; i10++) {
                trackedFaceArr[i10].faceShape = b(trackedFaceArr[i10].faceShape);
                trackedFaceArr[i10].faceVisible = c(trackedFaceArr[i10].faceVisible);
            }
        }
        return trackedFaceArr;
    }

    public static boolean b(YTFaceTracker.TrackedFace trackedFace, float f10, float f11) {
        int i10 = (int) (f10 * 13.0f);
        int i11 = 0;
        for (int i12 = 32; i12 < 45; i12++) {
            if (trackedFace.faceVisible[i12] < f11) {
                i11++;
            }
        }
        if (i11 <= i10) {
            return false;
        }
        WLogger.w(f40613a, "鼻子被挡住，count=" + i11);
        return true;
    }

    private static float[] b(float[] fArr) {
        float[] fArr2 = new float[180];
        int[] iArr = {0, 4, 18, 19, 7, 8, 10, 11, 12, 14, 15, 21, 20};
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (i11 < 32) {
            fArr2[i12] = fArr[i13];
            i11++;
            i13++;
            i12++;
        }
        int i14 = 0;
        while (i14 < 32) {
            fArr2[i12] = fArr[i13];
            i14++;
            i13++;
            i12++;
        }
        float[] fArr3 = new float[44];
        int i15 = 0;
        while (i15 < 44) {
            fArr3[i15] = fArr[i13];
            i15++;
            i13++;
        }
        fArr3[16] = (fArr3[16] + fArr3[18]) / 2.0f;
        fArr3[19] = (fArr3[19] + fArr3[19]) / 2.0f;
        fArr3[28] = (fArr3[28] + fArr3[26]) / 2.0f;
        fArr3[29] = (fArr3[29] + fArr3[27]) / 2.0f;
        for (int i16 = 0; i16 < 13; i16++) {
            int i17 = i12 + 1;
            fArr2[i12] = fArr3[iArr[i16] * 2];
            i12 = i17 + 1;
            fArr2[i17] = fArr3[(iArr[i16] * 2) + 1];
        }
        int i18 = 0;
        while (i18 < 44) {
            fArr2[i12] = fArr[i13];
            i18++;
            i13++;
            i12++;
        }
        int i19 = 0;
        while (i19 < 82) {
            if ((i19 / 2) % 2 != 1) {
                fArr2[i12] = fArr[i13];
                i12++;
            }
            i19++;
            i13++;
        }
        int i20 = 0;
        while (i20 < 14) {
            i20++;
            i13++;
        }
        while (i10 < 4) {
            fArr2[i12] = fArr[i13];
            i10++;
            i13++;
            i12++;
        }
        return fArr2;
    }

    public static boolean c(YTFaceTracker.TrackedFace trackedFace, float f10, float f11) {
        int i10 = (int) (f10 * 22.0f);
        int i11 = 0;
        for (int i12 = 45; i12 < 67; i12++) {
            if (trackedFace.faceVisible[i12] < f11) {
                i11++;
            }
        }
        if (i11 <= i10) {
            return false;
        }
        WLogger.w(f40613a, "嘴巴被挡住，count=" + i11);
        return true;
    }

    private static float[] c(float[] fArr) {
        float[] fArr2 = new float[90];
        int[] iArr = {0, 4, 18, 19, 7, 8, 10, 11, 12, 14, 15, 21, 20};
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (i11 < 16) {
            fArr2[i12] = fArr[i13];
            i11++;
            i13++;
            i12++;
        }
        int i14 = 0;
        while (i14 < 16) {
            fArr2[i12] = fArr[i13];
            i14++;
            i13++;
            i12++;
        }
        float[] fArr3 = new float[22];
        int i15 = 0;
        while (i15 < 22) {
            fArr3[i15] = fArr[i13];
            i15++;
            i13++;
        }
        fArr3[8] = (fArr3[8] + fArr3[9]) / 2.0f;
        fArr3[14] = (fArr3[14] + fArr3[13]) / 2.0f;
        int i16 = 0;
        while (i16 < 13) {
            fArr2[i12] = fArr3[iArr[i16]];
            i16++;
            i12++;
        }
        int i17 = 0;
        while (i17 < 22) {
            fArr2[i12] = fArr[i13];
            i17++;
            i13++;
            i12++;
        }
        int i18 = 0;
        while (i18 < 41) {
            if (i18 % 2 != 1) {
                fArr2[i12] = fArr[i13];
                i12++;
            }
            i18++;
            i13++;
        }
        int i19 = 0;
        while (i19 < 7) {
            i19++;
            i13++;
        }
        while (i10 < 2) {
            fArr2[i12] = fArr[i13];
            i10++;
            i13++;
            i12++;
        }
        return fArr2;
    }
}
