package e;

import android.graphics.PointF;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.model.CubicCurveData;
import com.airbnb.lottie.model.content.ShapeData;
import com.airbnb.lottie.model.layer.BaseLayer;
import f.a;
import java.util.ArrayList;
import java.util.List;

/* compiled from: RoundedCornersContent.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class p implements r, a.b {

    /* renamed from: a, reason: collision with root package name */
    public final LottieDrawable f48829a;

    /* renamed from: b, reason: collision with root package name */
    public final String f48830b;

    /* renamed from: c, reason: collision with root package name */
    public final f.a<Float, Float> f48831c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public ShapeData f48832d;

    public p(LottieDrawable lottieDrawable, BaseLayer baseLayer, j.g gVar) {
        this.f48829a = lottieDrawable;
        this.f48830b = gVar.b();
        f.a<Float, Float> a10 = gVar.a().a();
        this.f48831c = a10;
        baseLayer.i(a10);
        a10.a(this);
    }

    public static int a(int i10, int i11) {
        int i12 = i10 / i11;
        return ((i10 ^ i11) >= 0 || i11 * i12 == i10) ? i12 : i12 - 1;
    }

    public static int c(int i10, int i11) {
        return i10 - (a(i10, i11) * i11);
    }

    @Override // f.a.b
    public void e() {
        this.f48829a.invalidateSelf();
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void f(List<Content> list, List<Content> list2) {
    }

    @Override // e.r
    public ShapeData g(ShapeData shapeData) {
        List<CubicCurveData> list;
        List<CubicCurveData> curves = shapeData.getCurves();
        if (curves.size() <= 2) {
            return shapeData;
        }
        float floatValue = this.f48831c.h().floatValue();
        if (floatValue == 0.0f) {
            return shapeData;
        }
        ShapeData i10 = i(shapeData);
        i10.setInitialPoint(shapeData.getInitialPoint().x, shapeData.getInitialPoint().y);
        List<CubicCurveData> curves2 = i10.getCurves();
        boolean isClosed = shapeData.isClosed();
        int i11 = 0;
        int i12 = 0;
        while (i11 < curves.size()) {
            CubicCurveData cubicCurveData = curves.get(i11);
            CubicCurveData cubicCurveData2 = curves.get(c(i11 - 1, curves.size()));
            CubicCurveData cubicCurveData3 = curves.get(c(i11 - 2, curves.size()));
            PointF vertex = (i11 != 0 || isClosed) ? cubicCurveData2.getVertex() : shapeData.getInitialPoint();
            PointF controlPoint2 = (i11 != 0 || isClosed) ? cubicCurveData2.getControlPoint2() : vertex;
            PointF controlPoint1 = cubicCurveData.getControlPoint1();
            PointF vertex2 = cubicCurveData3.getVertex();
            PointF vertex3 = cubicCurveData.getVertex();
            boolean z10 = !shapeData.isClosed() && i11 == 0 && i11 == curves.size() + (-1);
            if (controlPoint2.equals(vertex) && controlPoint1.equals(vertex) && !z10) {
                float f10 = vertex.x;
                float f11 = f10 - vertex2.x;
                float f12 = vertex.y;
                float f13 = f12 - vertex2.y;
                float f14 = vertex3.x - f10;
                float f15 = vertex3.y - f12;
                list = curves;
                float hypot = (float) Math.hypot(f11, f13);
                float hypot2 = (float) Math.hypot(f14, f15);
                float min = Math.min(floatValue / hypot, 0.5f);
                float min2 = Math.min(floatValue / hypot2, 0.5f);
                float f16 = vertex.x;
                float f17 = ((vertex2.x - f16) * min) + f16;
                float f18 = vertex.y;
                float f19 = ((vertex2.y - f18) * min) + f18;
                float f20 = ((vertex3.x - f16) * min2) + f16;
                float f21 = ((vertex3.y - f18) * min2) + f18;
                float f22 = f17 - ((f17 - f16) * 0.5519f);
                float f23 = f19 - ((f19 - f18) * 0.5519f);
                float f24 = f20 - ((f20 - f16) * 0.5519f);
                float f25 = f21 - ((f21 - f18) * 0.5519f);
                CubicCurveData cubicCurveData4 = curves2.get(c(i12 - 1, curves2.size()));
                CubicCurveData cubicCurveData5 = curves2.get(i12);
                cubicCurveData4.setControlPoint2(f17, f19);
                cubicCurveData4.setVertex(f17, f19);
                if (i11 == 0) {
                    i10.setInitialPoint(f17, f19);
                }
                cubicCurveData5.setControlPoint1(f22, f23);
                i12++;
                CubicCurveData cubicCurveData6 = curves2.get(i12);
                cubicCurveData5.setControlPoint2(f24, f25);
                cubicCurveData5.setVertex(f20, f21);
                cubicCurveData6.setControlPoint1(f20, f21);
            } else {
                list = curves;
                CubicCurveData cubicCurveData7 = curves2.get(c(i12 - 1, curves2.size()));
                CubicCurveData cubicCurveData8 = curves2.get(i12);
                cubicCurveData7.setControlPoint2(cubicCurveData2.getControlPoint2().x, cubicCurveData2.getControlPoint2().y);
                cubicCurveData7.setVertex(cubicCurveData2.getVertex().x, cubicCurveData2.getVertex().y);
                cubicCurveData8.setControlPoint1(cubicCurveData.getControlPoint1().x, cubicCurveData.getControlPoint1().y);
            }
            i12++;
            i11++;
            curves = list;
        }
        return i10;
    }

    public f.a<Float, Float> h() {
        return this.f48831c;
    }

    @NonNull
    public final ShapeData i(ShapeData shapeData) {
        List<CubicCurveData> curves = shapeData.getCurves();
        boolean isClosed = shapeData.isClosed();
        int size = curves.size() - 1;
        int i10 = 0;
        while (size >= 0) {
            CubicCurveData cubicCurveData = curves.get(size);
            CubicCurveData cubicCurveData2 = curves.get(c(size - 1, curves.size()));
            PointF vertex = (size != 0 || isClosed) ? cubicCurveData2.getVertex() : shapeData.getInitialPoint();
            i10 = (((size != 0 || isClosed) ? cubicCurveData2.getControlPoint2() : vertex).equals(vertex) && cubicCurveData.getControlPoint1().equals(vertex) && !(!shapeData.isClosed() && size == 0 && size == curves.size() - 1)) ? i10 + 2 : i10 + 1;
            size--;
        }
        ShapeData shapeData2 = this.f48832d;
        if (shapeData2 == null || shapeData2.getCurves().size() != i10) {
            ArrayList arrayList = new ArrayList(i10);
            for (int i11 = 0; i11 < i10; i11++) {
                arrayList.add(new CubicCurveData());
            }
            this.f48832d = new ShapeData(new PointF(0.0f, 0.0f), false, arrayList);
        }
        this.f48832d.setClosed(isClosed);
        return this.f48832d;
    }
}
