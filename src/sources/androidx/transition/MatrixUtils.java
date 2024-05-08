package androidx.transition;

import android.graphics.Matrix;
import android.graphics.RectF;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
class MatrixUtils {
    public static final Matrix IDENTITY_MATRIX = new Matrix() { // from class: androidx.transition.MatrixUtils.1
        public void oops() {
            throw new IllegalStateException("Matrix can not be modified");
        }

        @Override // android.graphics.Matrix
        public boolean postConcat(Matrix matrix) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean postRotate(float f10, float f11, float f12) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean postScale(float f10, float f11, float f12, float f13) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean postSkew(float f10, float f11, float f12, float f13) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean postTranslate(float f10, float f11) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preConcat(Matrix matrix) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preRotate(float f10, float f11, float f12) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preScale(float f10, float f11, float f12, float f13) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preSkew(float f10, float f11, float f12, float f13) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preTranslate(float f10, float f11) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public void reset() {
            oops();
        }

        @Override // android.graphics.Matrix
        public void set(Matrix matrix) {
            oops();
        }

        @Override // android.graphics.Matrix
        public boolean setConcat(Matrix matrix, Matrix matrix2) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean setPolyToPoly(float[] fArr, int i10, float[] fArr2, int i11, int i12) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean setRectToRect(RectF rectF, RectF rectF2, Matrix.ScaleToFit scaleToFit) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public void setRotate(float f10, float f11, float f12) {
            oops();
        }

        @Override // android.graphics.Matrix
        public void setScale(float f10, float f11, float f12, float f13) {
            oops();
        }

        @Override // android.graphics.Matrix
        public void setSinCos(float f10, float f11, float f12, float f13) {
            oops();
        }

        @Override // android.graphics.Matrix
        public void setSkew(float f10, float f11, float f12, float f13) {
            oops();
        }

        @Override // android.graphics.Matrix
        public void setTranslate(float f10, float f11) {
            oops();
        }

        @Override // android.graphics.Matrix
        public void setValues(float[] fArr) {
            oops();
        }

        @Override // android.graphics.Matrix
        public boolean postRotate(float f10) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean postScale(float f10, float f11) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean postSkew(float f10, float f11) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preRotate(float f10) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preScale(float f10, float f11) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preSkew(float f10, float f11) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public void setRotate(float f10) {
            oops();
        }

        @Override // android.graphics.Matrix
        public void setScale(float f10, float f11) {
            oops();
        }

        @Override // android.graphics.Matrix
        public void setSinCos(float f10, float f11) {
            oops();
        }

        @Override // android.graphics.Matrix
        public void setSkew(float f10, float f11) {
            oops();
        }
    };

    private MatrixUtils() {
    }
}
