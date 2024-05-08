package com.google.android.material.bottomappbar;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.google.android.material.shape.EdgeTreatment;
import com.google.android.material.shape.ShapePath;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class BottomAppBarTopEdgeTreatment extends EdgeTreatment implements Cloneable {
    private static final int ANGLE_LEFT = 180;
    private static final int ANGLE_UP = 270;
    private static final int ARC_HALF = 180;
    private static final int ARC_QUARTER = 90;
    private float cradleVerticalOffset;
    private float fabDiameter;
    private float fabMargin;
    private float horizontalOffset;
    private float roundedCornerRadius;

    public BottomAppBarTopEdgeTreatment(float f10, float f11, float f12) {
        this.fabMargin = f10;
        this.roundedCornerRadius = f11;
        this.cradleVerticalOffset = f12;
        if (f12 >= 0.0f) {
            this.horizontalOffset = 0.0f;
            return;
        }
        throw new IllegalArgumentException("cradleVerticalOffset must be positive.");
    }

    public float getCradleVerticalOffset() {
        return this.cradleVerticalOffset;
    }

    @Override // com.google.android.material.shape.EdgeTreatment
    public void getEdgePath(float f10, float f11, float f12, @NonNull ShapePath shapePath) {
        float f13 = this.fabDiameter;
        if (f13 == 0.0f) {
            shapePath.lineTo(f10, 0.0f);
            return;
        }
        float f14 = ((this.fabMargin * 2.0f) + f13) / 2.0f;
        float f15 = f12 * this.roundedCornerRadius;
        float f16 = f11 + this.horizontalOffset;
        float f17 = (this.cradleVerticalOffset * f12) + ((1.0f - f12) * f14);
        if (f17 / f14 >= 1.0f) {
            shapePath.lineTo(f10, 0.0f);
            return;
        }
        float f18 = f14 + f15;
        float f19 = f17 + f15;
        float sqrt = (float) Math.sqrt((f18 * f18) - (f19 * f19));
        float f20 = f16 - sqrt;
        float f21 = f16 + sqrt;
        float degrees = (float) Math.toDegrees(Math.atan(sqrt / f19));
        float f22 = 90.0f - degrees;
        shapePath.lineTo(f20, 0.0f);
        float f23 = f15 * 2.0f;
        shapePath.addArc(f20 - f15, 0.0f, f20 + f15, f23, 270.0f, degrees);
        shapePath.addArc(f16 - f14, (-f14) - f17, f16 + f14, f14 - f17, 180.0f - f22, (f22 * 2.0f) - 180.0f);
        shapePath.addArc(f21 - f15, 0.0f, f21 + f15, f23, 270.0f - degrees, degrees);
        shapePath.lineTo(f10, 0.0f);
    }

    public float getFabCradleMargin() {
        return this.fabMargin;
    }

    public float getFabCradleRoundedCornerRadius() {
        return this.roundedCornerRadius;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public float getFabDiameter() {
        return this.fabDiameter;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public float getHorizontalOffset() {
        return this.horizontalOffset;
    }

    public void setCradleVerticalOffset(float f10) {
        this.cradleVerticalOffset = f10;
    }

    public void setFabCradleMargin(float f10) {
        this.fabMargin = f10;
    }

    public void setFabCradleRoundedCornerRadius(float f10) {
        this.roundedCornerRadius = f10;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setFabDiameter(float f10) {
        this.fabDiameter = f10;
    }

    public void setHorizontalOffset(float f10) {
        this.horizontalOffset = f10;
    }
}
