package com.tencent.cloud.huiyansdkface.a.c.a;

import android.hardware.Camera;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private com.tencent.cloud.huiyansdkface.a.a.a f40365a;

    /* renamed from: b, reason: collision with root package name */
    private com.tencent.cloud.huiyansdkface.a.a.c f40366b;

    public h(com.tencent.cloud.huiyansdkface.a.a.a aVar, com.tencent.cloud.huiyansdkface.a.a.c cVar) {
        this.f40365a = aVar;
        this.f40366b = cVar;
    }

    public void a(a aVar) {
        j jVar = new j();
        final com.tencent.cloud.huiyansdkface.a.a.a aVar2 = this.f40365a;
        jVar.a(new i() { // from class: com.tencent.cloud.huiyansdkface.a.c.a.h.1
            @Override // com.tencent.cloud.huiyansdkface.a.c.a.i
            public void a(Camera.Parameters parameters, a aVar3) {
                com.tencent.cloud.huiyansdkface.a.d.a.a("V1SingParaOperator", "start config focus mode.", new Object[0]);
                String f10 = aVar2.f();
                if (f10 != null) {
                    parameters.setFocusMode(f10);
                }
            }
        });
        jVar.a(new i() { // from class: com.tencent.cloud.huiyansdkface.a.c.a.h.2
            @Override // com.tencent.cloud.huiyansdkface.a.c.a.i
            public void a(Camera.Parameters parameters, a aVar3) {
                com.tencent.cloud.huiyansdkface.a.d.a.a("V1SingParaOperator", "start config flash mode.", new Object[0]);
                String e2 = aVar2.e();
                if (e2 != null) {
                    parameters.setFlashMode(e2);
                }
            }
        });
        jVar.a(new i() { // from class: com.tencent.cloud.huiyansdkface.a.c.a.h.3
            @Override // com.tencent.cloud.huiyansdkface.a.c.a.i
            public void a(Camera.Parameters parameters, a aVar3) {
                com.tencent.cloud.huiyansdkface.a.d.a.a("V1SingParaOperator", "start config previewSize.", new Object[0]);
                com.tencent.cloud.huiyansdkface.a.a.a.d a10 = aVar2.a();
                if (a10 != null) {
                    parameters.setPreviewSize(a10.a(), a10.b());
                }
            }
        });
        jVar.a(new i() { // from class: com.tencent.cloud.huiyansdkface.a.c.a.h.4
            @Override // com.tencent.cloud.huiyansdkface.a.c.a.i
            public void a(Camera.Parameters parameters, a aVar3) {
                com.tencent.cloud.huiyansdkface.a.d.a.a("V1SingParaOperator", "start config pictureSize.", new Object[0]);
                com.tencent.cloud.huiyansdkface.a.a.a.d c4 = aVar2.c();
                if (c4 != null) {
                    parameters.setPictureSize(c4.a(), c4.b());
                }
            }
        });
        jVar.a(new i() { // from class: com.tencent.cloud.huiyansdkface.a.c.a.h.5
            @Override // com.tencent.cloud.huiyansdkface.a.c.a.i
            public void a(Camera.Parameters parameters, a aVar3) {
                com.tencent.cloud.huiyansdkface.a.d.a.a("V1SingParaOperator", "start config fps.", new Object[0]);
                com.tencent.cloud.huiyansdkface.a.a.a.b b4 = aVar2.b();
                if (b4 == null || !b4.c()) {
                    return;
                }
                parameters.setPreviewFpsRange(b4.a(), b4.b());
            }
        });
        List<com.tencent.cloud.huiyansdkface.a.a.e> a10 = this.f40366b.a();
        if (a10 != null && a10.size() > 0) {
            for (int size = a10.size() - 1; size >= 0; size--) {
                com.tencent.cloud.huiyansdkface.a.a.e eVar = a10.get(size);
                if (eVar instanceof i) {
                    jVar.a((i) eVar);
                }
            }
        }
        jVar.a(aVar);
    }
}
