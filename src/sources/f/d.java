package f;

import java.util.List;

/* compiled from: FloatKeyframeAnimation.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class d extends g<Float> {
    public d(List<o.a<Float>> list) {
        super(list);
    }

    public float p() {
        return q(b(), d());
    }

    public float q(o.a<Float> aVar, float f10) {
        Float f11;
        if (aVar.f52211b != null && aVar.f52212c != null) {
            o.c<A> cVar = this.f49027e;
            if (cVar != 0 && (f11 = (Float) cVar.b(aVar.f52216g, aVar.f52217h.floatValue(), aVar.f52211b, aVar.f52212c, f10, e(), f())) != null) {
                return f11.floatValue();
            }
            return n.g.i(aVar.g(), aVar.d(), f10);
        }
        throw new IllegalStateException("Missing values for keyframe.");
    }

    @Override // f.a
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public Float i(o.a<Float> aVar, float f10) {
        return Float.valueOf(q(aVar, f10));
    }
}
