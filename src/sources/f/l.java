package f;

import java.util.List;

/* compiled from: ScaleKeyframeAnimation.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class l extends g<o.d> {

    /* renamed from: i, reason: collision with root package name */
    public final o.d f49057i;

    public l(List<o.a<o.d>> list) {
        super(list);
        this.f49057i = new o.d();
    }

    @Override // f.a
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public o.d i(o.a<o.d> aVar, float f10) {
        o.d dVar;
        o.d dVar2;
        o.d dVar3 = aVar.f52211b;
        if (dVar3 != null && (dVar = aVar.f52212c) != null) {
            o.d dVar4 = dVar3;
            o.d dVar5 = dVar;
            o.c<A> cVar = this.f49027e;
            if (cVar != 0 && (dVar2 = (o.d) cVar.b(aVar.f52216g, aVar.f52217h.floatValue(), dVar4, dVar5, f10, e(), f())) != null) {
                return dVar2;
            }
            this.f49057i.d(n.g.i(dVar4.b(), dVar5.b(), f10), n.g.i(dVar4.c(), dVar5.c(), f10));
            return this.f49057i;
        }
        throw new IllegalStateException("Missing values for keyframe.");
    }
}
