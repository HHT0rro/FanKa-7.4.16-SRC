package com.google.android.material.shape;

import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.NonNull;
import com.google.android.material.internal.ViewUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class MaterialShapeUtils {
    private MaterialShapeUtils() {
    }

    @NonNull
    public static CornerTreatment createCornerTreatment(int i10) {
        if (i10 == 0) {
            return new RoundedCornerTreatment();
        }
        if (i10 != 1) {
            return createDefaultCornerTreatment();
        }
        return new CutCornerTreatment();
    }

    @NonNull
    public static CornerTreatment createDefaultCornerTreatment() {
        return new RoundedCornerTreatment();
    }

    @NonNull
    public static EdgeTreatment createDefaultEdgeTreatment() {
        return new EdgeTreatment();
    }

    public static void setElevation(@NonNull View view, float f10) {
        Drawable background = view.getBackground();
        if (background instanceof MaterialShapeDrawable) {
            ((MaterialShapeDrawable) background).setElevation(f10);
        }
    }

    public static void setParentAbsoluteElevation(@NonNull View view) {
        Drawable background = view.getBackground();
        if (background instanceof MaterialShapeDrawable) {
            setParentAbsoluteElevation(view, (MaterialShapeDrawable) background);
        }
    }

    public static void setParentAbsoluteElevation(@NonNull View view, @NonNull MaterialShapeDrawable materialShapeDrawable) {
        if (materialShapeDrawable.isElevationOverlayEnabled()) {
            materialShapeDrawable.setParentAbsoluteElevation(ViewUtils.getParentAbsoluteElevation(view));
        }
    }
}
