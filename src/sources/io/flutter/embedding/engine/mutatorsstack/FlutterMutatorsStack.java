package io.flutter.embedding.engine.mutatorsstack;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

@Keep
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class FlutterMutatorsStack {

    @NonNull
    private List<FlutterMutator> mutators = new ArrayList();
    private Matrix finalMatrix = new Matrix();
    private List<Path> finalClippingPaths = new ArrayList();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public enum FlutterMutatorType {
        CLIP_RECT,
        CLIP_RRECT,
        CLIP_PATH,
        TRANSFORM,
        OPACITY
    }

    public List<Path> getFinalClippingPaths() {
        return this.finalClippingPaths;
    }

    public Matrix getFinalMatrix() {
        return this.finalMatrix;
    }

    public List<FlutterMutator> getMutators() {
        return this.mutators;
    }

    public void pushClipRRect(int i10, int i11, int i12, int i13, float[] fArr) {
        Rect rect = new Rect(i10, i11, i12, i13);
        this.mutators.add(new FlutterMutator(rect, fArr));
        Path path = new Path();
        path.addRoundRect(new RectF(rect), fArr, Path.Direction.CCW);
        path.transform(this.finalMatrix);
        this.finalClippingPaths.add(path);
    }

    public void pushClipRect(int i10, int i11, int i12, int i13) {
        Rect rect = new Rect(i10, i11, i12, i13);
        this.mutators.add(new FlutterMutator(rect));
        Path path = new Path();
        path.addRect(new RectF(rect), Path.Direction.CCW);
        path.transform(this.finalMatrix);
        this.finalClippingPaths.add(path);
    }

    public void pushTransform(float[] fArr) {
        Matrix matrix = new Matrix();
        matrix.setValues(fArr);
        FlutterMutator flutterMutator = new FlutterMutator(matrix);
        this.mutators.add(flutterMutator);
        this.finalMatrix.preConcat(flutterMutator.getMatrix());
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class FlutterMutator {

        @Nullable
        private Matrix matrix;

        @Nullable
        private Path path;

        @Nullable
        private float[] radiis;

        @Nullable
        private Rect rect;
        private FlutterMutatorType type;

        public FlutterMutator(Rect rect) {
            this.type = FlutterMutatorType.CLIP_RECT;
            this.rect = rect;
        }

        public Matrix getMatrix() {
            return this.matrix;
        }

        public Path getPath() {
            return this.path;
        }

        public Rect getRect() {
            return this.rect;
        }

        public FlutterMutatorType getType() {
            return this.type;
        }

        public FlutterMutator(Rect rect, float[] fArr) {
            this.type = FlutterMutatorType.CLIP_RRECT;
            this.rect = rect;
            this.radiis = fArr;
        }

        public FlutterMutator(Path path) {
            this.type = FlutterMutatorType.CLIP_PATH;
            this.path = path;
        }

        public FlutterMutator(Matrix matrix) {
            this.type = FlutterMutatorType.TRANSFORM;
            this.matrix = matrix;
        }
    }
}
