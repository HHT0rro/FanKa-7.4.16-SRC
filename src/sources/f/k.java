package f;

import android.graphics.PointF;
import java.util.List;

/* compiled from: PointKeyframeAnimation.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class k extends g<PointF> {

    /* renamed from: i, reason: collision with root package name */
    public final PointF f49056i;

    public k(List<o.a<PointF>> list) {
        super(list);
        this.f49056i = new PointF();
    }

    @Override // f.a
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public PointF i(o.a<PointF> aVar, float f10) {
        return j(aVar, f10, f10, f10);
    }

    @Override // f.a
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public PointF j(o.a<PointF> aVar, float f10, float f11, float f12) {
        PointF pointF;
        PointF pointF2;
        PointF pointF3 = aVar.f52211b;
        if (pointF3 != null && (pointF = aVar.f52212c) != null) {
            PointF pointF4 = pointF3;
            PointF pointF5 = pointF;
            o.c<A> cVar = this.f49027e;
            if (cVar != 0 && (pointF2 = (PointF) cVar.b(aVar.f52216g, aVar.f52217h.floatValue(), pointF4, pointF5, f10, e(), f())) != null) {
                return pointF2;
            }
            PointF pointF6 = this.f49056i;
            float f13 = pointF4.x;
            float f14 = f13 + (f11 * (pointF5.x - f13));
            float f15 = pointF4.y;
            pointF6.set(f14, f15 + (f12 * (pointF5.y - f15)));
            return this.f49056i;
        }
        throw new IllegalStateException("Missing values for keyframe.");
    }
}
