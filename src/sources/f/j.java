package f;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import java.util.List;

/* compiled from: PathKeyframeAnimation.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class j extends g<PointF> {

    /* renamed from: i, reason: collision with root package name */
    public final PointF f49052i;

    /* renamed from: j, reason: collision with root package name */
    public final float[] f49053j;

    /* renamed from: k, reason: collision with root package name */
    public final PathMeasure f49054k;

    /* renamed from: l, reason: collision with root package name */
    public i f49055l;

    public j(List<? extends o.a<PointF>> list) {
        super(list);
        this.f49052i = new PointF();
        this.f49053j = new float[2];
        this.f49054k = new PathMeasure();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // f.a
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public PointF i(o.a<PointF> aVar, float f10) {
        PointF pointF;
        i iVar = (i) aVar;
        Path k10 = iVar.k();
        if (k10 == null) {
            return aVar.f52211b;
        }
        o.c<A> cVar = this.f49027e;
        if (cVar != 0 && (pointF = (PointF) cVar.b(iVar.f52216g, iVar.f52217h.floatValue(), (PointF) iVar.f52211b, (PointF) iVar.f52212c, e(), f10, f())) != null) {
            return pointF;
        }
        if (this.f49055l != iVar) {
            this.f49054k.setPath(k10, false);
            this.f49055l = iVar;
        }
        PathMeasure pathMeasure = this.f49054k;
        pathMeasure.getPosTan(f10 * pathMeasure.getLength(), this.f49053j, null);
        PointF pointF2 = this.f49052i;
        float[] fArr = this.f49053j;
        pointF2.set(fArr[0], fArr[1]);
        return this.f49052i;
    }
}
