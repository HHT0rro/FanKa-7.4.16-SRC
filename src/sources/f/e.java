package f;

import java.util.List;

/* compiled from: GradientColorKeyframeAnimation.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class e extends g<j.c> {

    /* renamed from: i, reason: collision with root package name */
    public final j.c f49046i;

    public e(List<o.a<j.c>> list) {
        super(list);
        j.c cVar = list.get(0).f52211b;
        int e2 = cVar != null ? cVar.e() : 0;
        this.f49046i = new j.c(new float[e2], new int[e2]);
    }

    @Override // f.a
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public j.c i(o.a<j.c> aVar, float f10) {
        this.f49046i.f(aVar.f52211b, aVar.f52212c, f10);
        return this.f49046i;
    }
}
