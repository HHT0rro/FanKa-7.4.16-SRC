package n;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.FloatRange;
import com.airbnb.lottie.model.CubicCurveData;
import com.airbnb.lottie.model.content.ShapeData;
import e.j;
import java.util.List;

/* compiled from: MiscUtils.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    public static final PointF f52017a = new PointF();

    public static PointF a(PointF pointF, PointF pointF2) {
        return new PointF(pointF.x + pointF2.x, pointF.y + pointF2.y);
    }

    public static float b(float f10, float f11, float f12) {
        return Math.max(f11, Math.min(f12, f10));
    }

    public static int c(int i10, int i11, int i12) {
        return Math.max(i11, Math.min(i12, i10));
    }

    public static boolean d(float f10, float f11, float f12) {
        return f10 >= f11 && f10 <= f12;
    }

    public static int e(int i10, int i11) {
        int i12 = i10 / i11;
        return (((i10 ^ i11) >= 0) || i10 % i11 == 0) ? i12 : i12 - 1;
    }

    public static int f(float f10, float f11) {
        return g((int) f10, (int) f11);
    }

    public static int g(int i10, int i11) {
        return i10 - (i11 * e(i10, i11));
    }

    public static void h(ShapeData shapeData, Path path) {
        path.reset();
        PointF initialPoint = shapeData.getInitialPoint();
        path.moveTo(initialPoint.x, initialPoint.y);
        f52017a.set(initialPoint.x, initialPoint.y);
        for (int i10 = 0; i10 < shapeData.getCurves().size(); i10++) {
            CubicCurveData cubicCurveData = shapeData.getCurves().get(i10);
            PointF controlPoint1 = cubicCurveData.getControlPoint1();
            PointF controlPoint2 = cubicCurveData.getControlPoint2();
            PointF vertex = cubicCurveData.getVertex();
            PointF pointF = f52017a;
            if (controlPoint1.equals(pointF) && controlPoint2.equals(vertex)) {
                path.lineTo(vertex.x, vertex.y);
            } else {
                path.cubicTo(controlPoint1.x, controlPoint1.y, controlPoint2.x, controlPoint2.y, vertex.x, vertex.y);
            }
            pointF.set(vertex.x, vertex.y);
        }
        if (shapeData.isClosed()) {
            path.close();
        }
    }

    public static float i(float f10, float f11, @FloatRange(from = 0.0d, to = 1.0d) float f12) {
        return f10 + (f12 * (f11 - f10));
    }

    public static int j(int i10, int i11, @FloatRange(from = 0.0d, to = 1.0d) float f10) {
        return (int) (i10 + (f10 * (i11 - i10)));
    }

    public static void k(h.c cVar, int i10, List<h.c> list, h.c cVar2, j jVar) {
        if (cVar.c(jVar.getName(), i10)) {
            list.add(cVar2.a(jVar.getName()).i(jVar));
        }
    }
}
