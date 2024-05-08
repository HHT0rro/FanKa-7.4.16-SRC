package com.google.android.material.shape;

import android.graphics.RectF;
import androidx.annotation.NonNull;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class CornerTreatment {
    @Deprecated
    public void getCornerPath(float f10, float f11, @NonNull ShapePath shapePath) {
    }

    public void getCornerPath(@NonNull ShapePath shapePath, float f10, float f11, float f12) {
        getCornerPath(f10, f11, shapePath);
    }

    public void getCornerPath(@NonNull ShapePath shapePath, float f10, float f11, @NonNull RectF rectF, @NonNull CornerSize cornerSize) {
        getCornerPath(shapePath, f10, f11, cornerSize.getCornerSize(rectF));
    }
}
