package com.tencent.liteav.beauty;

import android.graphics.Bitmap;
import com.tencent.liteav.base.annotations.JNINamespace;

@JNINamespace("liteav::manager")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class TXBeautyManagerImpl implements TXBeautyManager {
    private long mNativeBeautyManager;

    public TXBeautyManagerImpl(long j10) {
        this.mNativeBeautyManager = j10;
    }

    private static native void nativeDestroy(long j10);

    private static native void nativeEnableSharpnessEnhancement(long j10, boolean z10);

    private static native void nativeSetBeautyLevel(long j10, float f10);

    private static native void nativeSetBeautyStyle(long j10, int i10);

    private static native int nativeSetChinLevel(long j10, float f10);

    private static native int nativeSetEyeAngleLevel(long j10, float f10);

    private static native int nativeSetEyeDistanceLevel(long j10, float f10);

    private static native int nativeSetEyeLightenLevel(long j10, float f10);

    private static native int nativeSetEyeScaleLevel(long j10, float f10);

    private static native int nativeSetFaceBeautyLevel(long j10, float f10);

    private static native int nativeSetFaceNarrowLevel(long j10, float f10);

    private static native int nativeSetFaceShortLevel(long j10, float f10);

    private static native int nativeSetFaceSlimLevel(long j10, float f10);

    private static native int nativeSetFaceVLevel(long j10, float f10);

    private static native void nativeSetFilter(long j10, Bitmap bitmap);

    private static native void nativeSetFilterStrength(long j10, float f10);

    private static native int nativeSetForeheadLevel(long j10, float f10);

    private static native int nativeSetGreenScreenFile(long j10, String str);

    private static native int nativeSetLipsThicknessLevel(long j10, float f10);

    private static native void nativeSetMotionMute(long j10, boolean z10);

    private static native void nativeSetMotionTmpl(long j10, String str);

    private static native int nativeSetMouthShapeLevel(long j10, float f10);

    private static native int nativeSetNosePositionLevel(long j10, float f10);

    private static native int nativeSetNoseSlimLevel(long j10, float f10);

    private static native int nativeSetNoseWingLevel(long j10, float f10);

    private static native int nativeSetPounchRemoveLevel(long j10, float f10);

    private static native void nativeSetRuddyLevel(long j10, float f10);

    private static native int nativeSetSmileLinesRemoveLevel(long j10, float f10);

    private static native int nativeSetToothWhitenLevel(long j10, float f10);

    private static native void nativeSetWhitenessLevel(long j10, float f10);

    private static native int nativeSetWrinkleRemoveLevel(long j10, float f10);

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public void enableSharpnessEnhancement(boolean z10) {
        long j10 = this.mNativeBeautyManager;
        if (j10 != 0) {
            nativeEnableSharpnessEnhancement(j10, z10);
        }
    }

    public void finalize() throws Throwable {
        super.finalize();
        long j10 = this.mNativeBeautyManager;
        if (j10 != 0) {
            nativeDestroy(j10);
            this.mNativeBeautyManager = 0L;
        }
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public void setBeautyLevel(float f10) {
        long j10 = this.mNativeBeautyManager;
        if (j10 != 0) {
            nativeSetBeautyLevel(j10, f10);
        }
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public void setBeautyStyle(int i10) {
        long j10 = this.mNativeBeautyManager;
        if (j10 != 0) {
            nativeSetBeautyStyle(j10, i10);
        }
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public int setChinLevel(float f10) {
        long j10 = this.mNativeBeautyManager;
        if (j10 == 0) {
            return 0;
        }
        nativeSetChinLevel(j10, f10);
        return 0;
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public int setEyeAngleLevel(float f10) {
        long j10 = this.mNativeBeautyManager;
        if (j10 == 0) {
            return 0;
        }
        nativeSetEyeAngleLevel(j10, f10);
        return 0;
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public int setEyeDistanceLevel(float f10) {
        long j10 = this.mNativeBeautyManager;
        if (j10 == 0) {
            return 0;
        }
        nativeSetEyeDistanceLevel(j10, f10);
        return 0;
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public int setEyeLightenLevel(float f10) {
        long j10 = this.mNativeBeautyManager;
        if (j10 == 0) {
            return 0;
        }
        nativeSetEyeLightenLevel(j10, f10);
        return 0;
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public int setEyeScaleLevel(float f10) {
        long j10 = this.mNativeBeautyManager;
        if (j10 == 0) {
            return 0;
        }
        nativeSetEyeScaleLevel(j10, f10);
        return 0;
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public int setFaceBeautyLevel(float f10) {
        long j10 = this.mNativeBeautyManager;
        if (j10 == 0) {
            return 0;
        }
        nativeSetFaceBeautyLevel(j10, f10);
        return 0;
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public int setFaceNarrowLevel(float f10) {
        long j10 = this.mNativeBeautyManager;
        if (j10 == 0) {
            return 0;
        }
        nativeSetFaceNarrowLevel(j10, f10);
        return 0;
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public int setFaceShortLevel(float f10) {
        long j10 = this.mNativeBeautyManager;
        if (j10 == 0) {
            return 0;
        }
        nativeSetFaceShortLevel(j10, f10);
        return 0;
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public int setFaceSlimLevel(float f10) {
        long j10 = this.mNativeBeautyManager;
        if (j10 == 0) {
            return 0;
        }
        nativeSetFaceSlimLevel(j10, f10);
        return 0;
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public int setFaceVLevel(float f10) {
        long j10 = this.mNativeBeautyManager;
        if (j10 == 0) {
            return 0;
        }
        nativeSetFaceVLevel(j10, f10);
        return 0;
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public void setFilter(Bitmap bitmap) {
        long j10 = this.mNativeBeautyManager;
        if (j10 != 0) {
            nativeSetFilter(j10, bitmap);
        }
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public void setFilterStrength(float f10) {
        long j10 = this.mNativeBeautyManager;
        if (j10 != 0) {
            nativeSetFilterStrength(j10, f10);
        }
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public int setForeheadLevel(float f10) {
        long j10 = this.mNativeBeautyManager;
        if (j10 == 0) {
            return 0;
        }
        nativeSetForeheadLevel(j10, f10);
        return 0;
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public int setGreenScreenFile(String str) {
        long j10 = this.mNativeBeautyManager;
        if (j10 == 0) {
            return 0;
        }
        nativeSetGreenScreenFile(j10, str);
        return 0;
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public int setLipsThicknessLevel(float f10) {
        long j10 = this.mNativeBeautyManager;
        if (j10 == 0) {
            return 0;
        }
        nativeSetLipsThicknessLevel(j10, f10);
        return 0;
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public void setMotionMute(boolean z10) {
        long j10 = this.mNativeBeautyManager;
        if (j10 != 0) {
            nativeSetMotionMute(j10, z10);
        }
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public void setMotionTmpl(String str) {
        long j10 = this.mNativeBeautyManager;
        if (j10 != 0) {
            nativeSetMotionTmpl(j10, str);
        }
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public int setMouthShapeLevel(float f10) {
        long j10 = this.mNativeBeautyManager;
        if (j10 == 0) {
            return 0;
        }
        nativeSetMouthShapeLevel(j10, f10);
        return 0;
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public int setNosePositionLevel(float f10) {
        long j10 = this.mNativeBeautyManager;
        if (j10 == 0) {
            return 0;
        }
        nativeSetNosePositionLevel(j10, f10);
        return 0;
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public int setNoseSlimLevel(float f10) {
        long j10 = this.mNativeBeautyManager;
        if (j10 == 0) {
            return 0;
        }
        nativeSetNoseSlimLevel(j10, f10);
        return 0;
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public int setNoseWingLevel(float f10) {
        long j10 = this.mNativeBeautyManager;
        if (j10 == 0) {
            return 0;
        }
        nativeSetNoseWingLevel(j10, f10);
        return 0;
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public int setPounchRemoveLevel(float f10) {
        long j10 = this.mNativeBeautyManager;
        if (j10 == 0) {
            return 0;
        }
        nativeSetPounchRemoveLevel(j10, f10);
        return 0;
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public void setRuddyLevel(float f10) {
        long j10 = this.mNativeBeautyManager;
        if (j10 != 0) {
            nativeSetRuddyLevel(j10, f10);
        }
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public int setSmileLinesRemoveLevel(float f10) {
        long j10 = this.mNativeBeautyManager;
        if (j10 == 0) {
            return 0;
        }
        nativeSetSmileLinesRemoveLevel(j10, f10);
        return 0;
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public int setToothWhitenLevel(float f10) {
        long j10 = this.mNativeBeautyManager;
        if (j10 == 0) {
            return 0;
        }
        nativeSetToothWhitenLevel(j10, f10);
        return 0;
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public void setWhitenessLevel(float f10) {
        long j10 = this.mNativeBeautyManager;
        if (j10 != 0) {
            nativeSetWhitenessLevel(j10, f10);
        }
    }

    @Override // com.tencent.liteav.beauty.TXBeautyManager
    public int setWrinkleRemoveLevel(float f10) {
        long j10 = this.mNativeBeautyManager;
        if (j10 == 0) {
            return 0;
        }
        nativeSetWrinkleRemoveLevel(j10, f10);
        return 0;
    }
}
