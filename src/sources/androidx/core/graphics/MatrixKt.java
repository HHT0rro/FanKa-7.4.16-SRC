package androidx.core.graphics;

import android.graphics.Matrix;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: Matrix.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class MatrixKt {
    @NotNull
    public static final Matrix rotationMatrix(float f10, float f11, float f12) {
        Matrix matrix = new Matrix();
        matrix.setRotate(f10, f11, f12);
        return matrix;
    }

    public static /* synthetic */ Matrix rotationMatrix$default(float f10, float f11, float f12, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            f11 = 0.0f;
        }
        if ((i10 & 4) != 0) {
            f12 = 0.0f;
        }
        return rotationMatrix(f10, f11, f12);
    }

    @NotNull
    public static final Matrix scaleMatrix(float f10, float f11) {
        Matrix matrix = new Matrix();
        matrix.setScale(f10, f11);
        return matrix;
    }

    public static /* synthetic */ Matrix scaleMatrix$default(float f10, float f11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            f10 = 1.0f;
        }
        if ((i10 & 2) != 0) {
            f11 = 1.0f;
        }
        return scaleMatrix(f10, f11);
    }

    @NotNull
    public static final Matrix times(@NotNull Matrix matrix, @NotNull Matrix m10) {
        s.i(matrix, "<this>");
        s.i(m10, "m");
        Matrix matrix2 = new Matrix(matrix);
        matrix2.preConcat(m10);
        return matrix2;
    }

    @NotNull
    public static final Matrix translationMatrix(float f10, float f11) {
        Matrix matrix = new Matrix();
        matrix.setTranslate(f10, f11);
        return matrix;
    }

    public static /* synthetic */ Matrix translationMatrix$default(float f10, float f11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            f10 = 0.0f;
        }
        if ((i10 & 2) != 0) {
            f11 = 0.0f;
        }
        return translationMatrix(f10, f11);
    }

    @NotNull
    public static final float[] values(@NotNull Matrix matrix) {
        s.i(matrix, "<this>");
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        return fArr;
    }
}
