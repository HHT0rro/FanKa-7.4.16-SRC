package f;

import java.util.List;

/* compiled from: ColorKeyframeAnimation.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class b extends g<Integer> {
    public b(List<o.a<Integer>> list) {
        super(list);
    }

    public int p() {
        return q(b(), d());
    }

    public int q(o.a<Integer> aVar, float f10) {
        Integer num;
        if (aVar.f52211b != null && aVar.f52212c != null) {
            o.c<A> cVar = this.f49027e;
            if (cVar != 0 && (num = (Integer) cVar.b(aVar.f52216g, aVar.f52217h.floatValue(), aVar.f52211b, aVar.f52212c, f10, e(), f())) != null) {
                return num.intValue();
            }
            return n.b.c(n.g.b(f10, 0.0f, 1.0f), aVar.f52211b.intValue(), aVar.f52212c.intValue());
        }
        throw new IllegalStateException("Missing values for keyframe.");
    }

    @Override // f.a
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public Integer i(o.a<Integer> aVar, float f10) {
        return Integer.valueOf(q(aVar, f10));
    }
}
