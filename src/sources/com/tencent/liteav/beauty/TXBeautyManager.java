package com.tencent.liteav.beauty;

import android.graphics.Bitmap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface TXBeautyManager {
    public static final int TXBeautyStyleNature = 1;
    public static final int TXBeautyStylePitu = 2;
    public static final int TXBeautyStyleSmooth = 0;

    void enableSharpnessEnhancement(boolean z10);

    void setBeautyLevel(float f10);

    void setBeautyStyle(int i10);

    int setChinLevel(float f10);

    int setEyeAngleLevel(float f10);

    int setEyeDistanceLevel(float f10);

    int setEyeLightenLevel(float f10);

    int setEyeScaleLevel(float f10);

    int setFaceBeautyLevel(float f10);

    int setFaceNarrowLevel(float f10);

    int setFaceShortLevel(float f10);

    int setFaceSlimLevel(float f10);

    int setFaceVLevel(float f10);

    void setFilter(Bitmap bitmap);

    void setFilterStrength(float f10);

    int setForeheadLevel(float f10);

    int setGreenScreenFile(String str);

    int setLipsThicknessLevel(float f10);

    void setMotionMute(boolean z10);

    void setMotionTmpl(String str);

    int setMouthShapeLevel(float f10);

    int setNosePositionLevel(float f10);

    int setNoseSlimLevel(float f10);

    int setNoseWingLevel(float f10);

    int setPounchRemoveLevel(float f10);

    void setRuddyLevel(float f10);

    int setSmileLinesRemoveLevel(float f10);

    int setToothWhitenLevel(float f10);

    void setWhitenessLevel(float f10);

    int setWrinkleRemoveLevel(float f10);
}
