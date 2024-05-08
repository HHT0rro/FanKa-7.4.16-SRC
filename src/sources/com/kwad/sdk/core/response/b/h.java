package com.kwad.sdk.core.response.b;

import android.graphics.Matrix;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.PhotoInfo;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class h {
    public static String a(@NonNull PhotoInfo photoInfo) {
        return photoInfo.videoInfo.videoUrl;
    }

    public static String b(@NonNull PhotoInfo photoInfo) {
        return photoInfo.videoInfo.manifest;
    }

    public static String c(PhotoInfo photoInfo) {
        return photoInfo.baseInfo.sdkExtraData;
    }

    public static boolean a(@Nullable Matrix matrix, int i10, int i11, PhotoInfo.VideoInfo videoInfo) {
        if (matrix != null) {
            matrix.reset();
        }
        if (videoInfo == null) {
            return false;
        }
        float f10 = videoInfo.width;
        float f11 = videoInfo.height;
        if (f10 >= f11) {
            return false;
        }
        float f12 = (float) videoInfo.leftRatio;
        float f13 = (float) videoInfo.topRatio;
        float f14 = (float) videoInfo.widthRatio;
        float f15 = (float) videoInfo.heightRatio;
        float f16 = i10;
        float f17 = f16 / f10;
        float f18 = i11;
        float f19 = f18 / f11;
        float f20 = f17 / f19;
        if (Math.abs(f20 - 1.0f) < 0.01d) {
            return false;
        }
        if (f17 > f19) {
            float f21 = f19 / f17;
            float f22 = (1.0f - f21) / 2.0f;
            float f23 = (f21 + 1.0f) / 2.0f;
            if (f13 < f22 || f13 + f15 > f23) {
                return false;
            }
        } else {
            float f24 = (1.0f - f20) / 2.0f;
            float f25 = (f20 + 1.0f) / 2.0f;
            if (f12 < f24 || f12 + f14 > f25) {
                return false;
            }
            f17 = f19;
        }
        if (matrix == null) {
            return true;
        }
        matrix.preTranslate((f16 - f10) / 2.0f, (f18 - f11) / 2.0f);
        matrix.preScale(f10 / f16, f11 / f18);
        matrix.postScale(f17, f17, f16 / 2.0f, f18 / 2.0f);
        return true;
    }
}
