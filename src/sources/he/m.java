package he;

/* compiled from: Subscription.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public final Object f49653a;

    /* renamed from: b, reason: collision with root package name */
    public final k f49654b;

    /* renamed from: c, reason: collision with root package name */
    public volatile boolean f49655c = true;

    public m(Object obj, k kVar) {
        this.f49653a = obj;
        this.f49654b = kVar;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return this.f49653a == mVar.f49653a && this.f49654b.equals(mVar.f49654b);
    }

    public int hashCode() {
        return this.f49653a.hashCode() + this.f49654b.f49639f.hashCode();
    }
}
