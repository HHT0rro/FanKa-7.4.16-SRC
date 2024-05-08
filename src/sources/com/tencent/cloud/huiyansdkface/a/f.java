package com.tencent.cloud.huiyansdkface.a;

import android.os.Handler;
import android.os.Looper;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private com.tencent.cloud.huiyansdkface.a.a.a.a f40427a;

    /* renamed from: b, reason: collision with root package name */
    private c f40428b;

    /* renamed from: c, reason: collision with root package name */
    private Handler f40429c = new Handler(Looper.getMainLooper());

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface a {
        void a();
    }

    public f(com.tencent.cloud.huiyansdkface.a.a.a.a aVar, c cVar) {
        this.f40427a = aVar;
        this.f40428b = cVar;
    }

    public com.tencent.cloud.huiyansdkface.a.a.a.a a() {
        com.tencent.cloud.huiyansdkface.a.a.a.a aVar = this.f40427a.b() ? com.tencent.cloud.huiyansdkface.a.a.a.a.BACK : com.tencent.cloud.huiyansdkface.a.a.a.a.FRONT;
        this.f40427a = aVar;
        return aVar;
    }

    public void a(final c cVar, final a aVar) {
        if (cVar != null) {
            c cVar2 = this.f40428b;
            cVar.a((b) new e() { // from class: com.tencent.cloud.huiyansdkface.a.f.1
                @Override // com.tencent.cloud.huiyansdkface.a.e, com.tencent.cloud.huiyansdkface.a.b
                public void a(com.tencent.cloud.huiyansdkface.a.c.a aVar2) {
                    super.a(aVar2);
                    cVar.b(this);
                    f.this.f40429c.post(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.a.f.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            aVar.a();
                        }
                    });
                }
            });
            if (cVar2 != null) {
                cVar2.a((b) new com.tencent.cloud.huiyansdkface.a.a() { // from class: com.tencent.cloud.huiyansdkface.a.f.2
                    @Override // com.tencent.cloud.huiyansdkface.a.a, com.tencent.cloud.huiyansdkface.a.b
                    public void a() {
                        f.this.f40428b = cVar;
                        f.this.f40428b.b(this);
                        cVar.b();
                    }
                });
                cVar2.d();
            }
        }
    }
}
