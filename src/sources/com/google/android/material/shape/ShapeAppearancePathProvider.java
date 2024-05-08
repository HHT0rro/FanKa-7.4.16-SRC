package com.google.android.material.shape;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class ShapeAppearancePathProvider {
    private final ShapePath[] cornerPaths = new ShapePath[4];
    private final Matrix[] cornerTransforms = new Matrix[4];
    private final Matrix[] edgeTransforms = new Matrix[4];
    private final PointF pointF = new PointF();
    private final ShapePath shapePath = new ShapePath();
    private final float[] scratch = new float[2];
    private final float[] scratch2 = new float[2];

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface PathListener {
        void onCornerPathCreated(ShapePath shapePath, Matrix matrix, int i10);

        void onEdgePathCreated(ShapePath shapePath, Matrix matrix, int i10);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class ShapeAppearancePathSpec {

        @NonNull
        public final RectF bounds;
        public final float interpolation;

        @NonNull
        public final Path path;

        @Nullable
        public final PathListener pathListener;

        @NonNull
        public final ShapeAppearanceModel shapeAppearanceModel;

        public ShapeAppearancePathSpec(@NonNull ShapeAppearanceModel shapeAppearanceModel, float f10, RectF rectF, @Nullable PathListener pathListener, Path path) {
            this.pathListener = pathListener;
            this.shapeAppearanceModel = shapeAppearanceModel;
            this.interpolation = f10;
            this.bounds = rectF;
            this.path = path;
        }
    }

    public ShapeAppearancePathProvider() {
        for (int i10 = 0; i10 < 4; i10++) {
            this.cornerPaths[i10] = new ShapePath();
            this.cornerTransforms[i10] = new Matrix();
            this.edgeTransforms[i10] = new Matrix();
        }
    }

    private float angleOfEdge(int i10) {
        return (i10 + 1) * 90;
    }

    private void appendCornerPath(@NonNull ShapeAppearancePathSpec shapeAppearancePathSpec, int i10) {
        this.scratch[0] = this.cornerPaths[i10].getStartX();
        this.scratch[1] = this.cornerPaths[i10].getStartY();
        this.cornerTransforms[i10].mapPoints(this.scratch);
        if (i10 == 0) {
            Path path = shapeAppearancePathSpec.path;
            float[] fArr = this.scratch;
            path.moveTo(fArr[0], fArr[1]);
        } else {
            Path path2 = shapeAppearancePathSpec.path;
            float[] fArr2 = this.scratch;
            path2.lineTo(fArr2[0], fArr2[1]);
        }
        this.cornerPaths[i10].applyToPath(this.cornerTransforms[i10], shapeAppearancePathSpec.path);
        PathListener pathListener = shapeAppearancePathSpec.pathListener;
        if (pathListener != null) {
            pathListener.onCornerPathCreated(this.cornerPaths[i10], this.cornerTransforms[i10], i10);
        }
    }

    private void appendEdgePath(@NonNull ShapeAppearancePathSpec shapeAppearancePathSpec, int i10) {
        int i11 = (i10 + 1) % 4;
        this.scratch[0] = this.cornerPaths[i10].getEndX();
        this.scratch[1] = this.cornerPaths[i10].getEndY();
        this.cornerTransforms[i10].mapPoints(this.scratch);
        this.scratch2[0] = this.cornerPaths[i11].getStartX();
        this.scratch2[1] = this.cornerPaths[i11].getStartY();
        this.cornerTransforms[i11].mapPoints(this.scratch2);
        float f10 = this.scratch[0];
        float[] fArr = this.scratch2;
        float max = Math.max(((float) Math.hypot(f10 - fArr[0], r0[1] - fArr[1])) - 0.001f, 0.0f);
        float edgeCenterForIndex = getEdgeCenterForIndex(shapeAppearancePathSpec.bounds, i10);
        this.shapePath.reset(0.0f, 0.0f);
        getEdgeTreatmentForIndex(i10, shapeAppearancePathSpec.shapeAppearanceModel).getEdgePath(max, edgeCenterForIndex, shapeAppearancePathSpec.interpolation, this.shapePath);
        this.shapePath.applyToPath(this.edgeTransforms[i10], shapeAppearancePathSpec.path);
        PathListener pathListener = shapeAppearancePathSpec.pathListener;
        if (pathListener != null) {
            pathListener.onEdgePathCreated(this.shapePath, this.edgeTransforms[i10], i10);
        }
    }

    private void getCoordinatesOfCorner(int i10, @NonNull RectF rectF, @NonNull PointF pointF) {
        if (i10 == 1) {
            pointF.set(rectF.right, rectF.bottom);
            return;
        }
        if (i10 == 2) {
            pointF.set(rectF.left, rectF.bottom);
        } else if (i10 != 3) {
            pointF.set(rectF.right, rectF.top);
        } else {
            pointF.set(rectF.left, rectF.top);
        }
    }

    private CornerSize getCornerSizeForIndex(int i10, @NonNull ShapeAppearanceModel shapeAppearanceModel) {
        if (i10 == 1) {
            return shapeAppearanceModel.getBottomRightCornerSize();
        }
        if (i10 == 2) {
            return shapeAppearanceModel.getBottomLeftCornerSize();
        }
        if (i10 != 3) {
            return shapeAppearanceModel.getTopRightCornerSize();
        }
        return shapeAppearanceModel.getTopLeftCornerSize();
    }

    private CornerTreatment getCornerTreatmentForIndex(int i10, @NonNull ShapeAppearanceModel shapeAppearanceModel) {
        if (i10 == 1) {
            return shapeAppearanceModel.getBottomRightCorner();
        }
        if (i10 == 2) {
            return shapeAppearanceModel.getBottomLeftCorner();
        }
        if (i10 != 3) {
            return shapeAppearanceModel.getTopRightCorner();
        }
        return shapeAppearanceModel.getTopLeftCorner();
    }

    private float getEdgeCenterForIndex(@NonNull RectF rectF, int i10) {
        float[] fArr = this.scratch;
        ShapePath[] shapePathArr = this.cornerPaths;
        fArr[0] = shapePathArr[i10].endX;
        fArr[1] = shapePathArr[i10].endY;
        this.cornerTransforms[i10].mapPoints(fArr);
        if (i10 != 1 && i10 != 3) {
            return Math.abs(rectF.centerY() - this.scratch[1]);
        }
        return Math.abs(rectF.centerX() - this.scratch[0]);
    }

    private EdgeTreatment getEdgeTreatmentForIndex(int i10, @NonNull ShapeAppearanceModel shapeAppearanceModel) {
        if (i10 == 1) {
            return shapeAppearanceModel.getBottomEdge();
        }
        if (i10 == 2) {
            return shapeAppearanceModel.getLeftEdge();
        }
        if (i10 != 3) {
            return shapeAppearanceModel.getRightEdge();
        }
        return shapeAppearanceModel.getTopEdge();
    }

    private void setCornerPathAndTransform(@NonNull ShapeAppearancePathSpec shapeAppearancePathSpec, int i10) {
        getCornerTreatmentForIndex(i10, shapeAppearancePathSpec.shapeAppearanceModel).getCornerPath(this.cornerPaths[i10], 90.0f, shapeAppearancePathSpec.interpolation, shapeAppearancePathSpec.bounds, getCornerSizeForIndex(i10, shapeAppearancePathSpec.shapeAppearanceModel));
        float angleOfEdge = angleOfEdge(i10);
        this.cornerTransforms[i10].reset();
        getCoordinatesOfCorner(i10, shapeAppearancePathSpec.bounds, this.pointF);
        Matrix matrix = this.cornerTransforms[i10];
        PointF pointF = this.pointF;
        matrix.setTranslate(pointF.x, pointF.y);
        this.cornerTransforms[i10].preRotate(angleOfEdge);
    }

    private void setEdgePathAndTransform(int i10) {
        this.scratch[0] = this.cornerPaths[i10].getEndX();
        this.scratch[1] = this.cornerPaths[i10].getEndY();
        this.cornerTransforms[i10].mapPoints(this.scratch);
        float angleOfEdge = angleOfEdge(i10);
        this.edgeTransforms[i10].reset();
        Matrix matrix = this.edgeTransforms[i10];
        float[] fArr = this.scratch;
        matrix.setTranslate(fArr[0], fArr[1]);
        this.edgeTransforms[i10].preRotate(angleOfEdge);
    }

    public void calculatePath(ShapeAppearanceModel shapeAppearanceModel, float f10, RectF rectF, @NonNull Path path) {
        calculatePath(shapeAppearanceModel, f10, rectF, null, path);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void calculatePath(ShapeAppearanceModel shapeAppearanceModel, float f10, RectF rectF, PathListener pathListener, @NonNull Path path) {
        path.rewind();
        ShapeAppearancePathSpec shapeAppearancePathSpec = new ShapeAppearancePathSpec(shapeAppearanceModel, f10, rectF, pathListener, path);
        for (int i10 = 0; i10 < 4; i10++) {
            setCornerPathAndTransform(shapeAppearancePathSpec, i10);
            setEdgePathAndTransform(i10);
        }
        for (int i11 = 0; i11 < 4; i11++) {
            appendCornerPath(shapeAppearancePathSpec, i11);
            appendEdgePath(shapeAppearancePathSpec, i11);
        }
        path.close();
    }
}
