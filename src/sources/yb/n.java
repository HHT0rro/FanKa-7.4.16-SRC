package yb;

/* compiled from: DatabaseWorkerPool.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class n {

    /* compiled from: DatabaseWorkerPool.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class a implements j {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f54772a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ o f54773b;

        public a(o oVar, i iVar) {
            this.f54773b = oVar;
            this.f54772a = iVar;
        }

        @Override // yb.j
        public int a() {
            return this.f54772a.f54750c;
        }

        @Override // yb.j
        public boolean b() {
            return this.f54772a.F();
        }
    }

    public static void a(o oVar, i iVar, Runnable runnable) {
        oVar.a(new k(iVar == null ? null : new a(oVar, iVar), runnable));
    }

    public static o b(String str, int i10, int i11) {
        if (i10 == 1) {
            return new s(str, i11);
        }
        return new q(str, i10, i11);
    }
}
