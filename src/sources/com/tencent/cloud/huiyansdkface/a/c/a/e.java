package com.tencent.cloud.huiyansdkface.a.c.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class e implements com.tencent.cloud.huiyansdkface.a.a.b {

    /* renamed from: a, reason: collision with root package name */
    private com.tencent.cloud.huiyansdkface.a.c.d f40358a;

    public e(com.tencent.cloud.huiyansdkface.a.c.d dVar) {
        this.f40358a = dVar;
    }

    @Override // com.tencent.cloud.huiyansdkface.a.a.b
    public com.tencent.cloud.huiyansdkface.a.a.a a(com.tencent.cloud.huiyansdkface.a.a.c cVar) {
        if (cVar == null) {
            return null;
        }
        try {
            com.tencent.cloud.huiyansdkface.a.a.a aVar = new com.tencent.cloud.huiyansdkface.a.a.a();
            aVar.a(this.f40358a.b().b() ? cVar.i() : -1.0f).a(cVar.g().b(this.f40358a.b().f(), this.f40358a)).b(cVar.h().b(this.f40358a.b().g(), this.f40358a)).c(cVar.e().b(this.f40358a.b().d(), this.f40358a)).b(cVar.f().b(this.f40358a.b().e(), this.f40358a)).a(cVar.d().b(this.f40358a.b().c(), this.f40358a)).a(cVar.c().b(this.f40358a.b().a(), this.f40358a));
            com.tencent.cloud.huiyansdkface.a.d.a.b("V1ConfigSelector", "get camera config:" + aVar.toString(), new Object[0]);
            return aVar;
        } catch (Exception e2) {
            com.tencent.cloud.huiyansdkface.a.b.b.a(com.tencent.cloud.huiyansdkface.a.b.c.a(21, "read parameter error", e2));
            return null;
        }
    }
}
