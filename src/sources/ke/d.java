package ke;

/* compiled from: ConverterManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class d {

    /* renamed from: f, reason: collision with root package name */
    public static d f50881f;

    /* renamed from: a, reason: collision with root package name */
    public e f50882a;

    /* renamed from: b, reason: collision with root package name */
    public e f50883b;

    /* renamed from: c, reason: collision with root package name */
    public e f50884c;

    /* renamed from: d, reason: collision with root package name */
    public e f50885d;

    /* renamed from: e, reason: collision with root package name */
    public e f50886e;

    public d() {
        o oVar = o.f50895a;
        s sVar = s.f50899a;
        b bVar = b.f50880a;
        f fVar = f.f50891a;
        j jVar = j.f50892a;
        k kVar = k.f50893a;
        this.f50882a = new e(new c[]{oVar, sVar, bVar, fVar, jVar, kVar});
        this.f50883b = new e(new c[]{q.f50897a, oVar, sVar, bVar, fVar, jVar, kVar});
        n nVar = n.f50894a;
        p pVar = p.f50896a;
        this.f50884c = new e(new c[]{nVar, pVar, sVar, jVar, kVar});
        this.f50885d = new e(new c[]{nVar, r.f50898a, pVar, sVar, kVar});
        this.f50886e = new e(new c[]{pVar, sVar, kVar});
    }

    public static d b() {
        if (f50881f == null) {
            f50881f = new d();
        }
        return f50881f;
    }

    public g a(Object obj) {
        g gVar = (g) this.f50884c.b(obj == null ? null : obj.getClass());
        if (gVar != null) {
            return gVar;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("No duration converter found for type: ");
        sb2.append(obj == null ? "null" : obj.getClass().getName());
        throw new IllegalArgumentException(sb2.toString());
    }

    public h c(Object obj) {
        h hVar = (h) this.f50882a.b(obj == null ? null : obj.getClass());
        if (hVar != null) {
            return hVar;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("No instant converter found for type: ");
        sb2.append(obj == null ? "null" : obj.getClass().getName());
        throw new IllegalArgumentException(sb2.toString());
    }

    public i d(Object obj) {
        i iVar = (i) this.f50886e.b(obj == null ? null : obj.getClass());
        if (iVar != null) {
            return iVar;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("No interval converter found for type: ");
        sb2.append(obj == null ? "null" : obj.getClass().getName());
        throw new IllegalArgumentException(sb2.toString());
    }

    public l e(Object obj) {
        l lVar = (l) this.f50883b.b(obj == null ? null : obj.getClass());
        if (lVar != null) {
            return lVar;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("No partial converter found for type: ");
        sb2.append(obj == null ? "null" : obj.getClass().getName());
        throw new IllegalArgumentException(sb2.toString());
    }

    public m f(Object obj) {
        m mVar = (m) this.f50885d.b(obj == null ? null : obj.getClass());
        if (mVar != null) {
            return mVar;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("No period converter found for type: ");
        sb2.append(obj == null ? "null" : obj.getClass().getName());
        throw new IllegalArgumentException(sb2.toString());
    }

    public String toString() {
        return "ConverterManager[" + this.f50882a.d() + " instant," + this.f50883b.d() + " partial," + this.f50884c.d() + " duration," + this.f50885d.d() + " period," + this.f50886e.d() + " interval]";
    }
}
