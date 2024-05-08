package com.tencent.cloud.huiyansdkface.a.c.a;

import android.hardware.Camera;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private com.tencent.cloud.huiyansdkface.a.c.a f40356a;

    /* renamed from: b, reason: collision with root package name */
    private a f40357b;

    public d(com.tencent.cloud.huiyansdkface.a.c.a aVar, a aVar2) {
        this.f40356a = aVar;
        this.f40357b = aVar2;
    }

    private com.tencent.cloud.huiyansdkface.a.a.a a(com.tencent.cloud.huiyansdkface.a.a.a aVar, Camera.Parameters parameters) {
        int[] iArr = new int[2];
        parameters.getPreviewFpsRange(iArr);
        return aVar.a(parameters.getZoom()).a(new com.tencent.cloud.huiyansdkface.a.a.a.d(parameters.getPreviewSize().width, parameters.getPreviewSize().height)).c(new com.tencent.cloud.huiyansdkface.a.a.a.d(parameters.getPictureSize().width, parameters.getPictureSize().height)).b(parameters.getFocusMode()).a(parameters.getFlashMode()).a(parameters.isZoomSupported() ? parameters.getZoom() / parameters.getMaxZoom() : -1.0f).a(new com.tencent.cloud.huiyansdkface.a.a.a.b(iArr[0], iArr[1]));
    }

    private com.tencent.cloud.huiyansdkface.a.a.a b(com.tencent.cloud.huiyansdkface.a.a.c cVar) {
        com.tencent.cloud.huiyansdkface.a.a.a a10 = new e(this.f40357b).a(cVar);
        Camera.Parameters parameters = this.f40357b.a().getParameters();
        if (a10 == null) {
            com.tencent.cloud.huiyansdkface.a.a.a aVar = new com.tencent.cloud.huiyansdkface.a.a.a();
            a(aVar, parameters);
            return aVar;
        }
        com.tencent.cloud.huiyansdkface.a.d.a.b("V1ConfigOperator", "start camera config.", new Object[0]);
        new h(a10, cVar).a(this.f40357b);
        float d10 = a10.d();
        if (d10 >= 0.0f) {
            this.f40356a.a(d10 / parameters.getMaxZoom());
        }
        a(a10, this.f40357b.a().getParameters());
        return a10;
    }

    public com.tencent.cloud.huiyansdkface.a.a.a a(com.tencent.cloud.huiyansdkface.a.a.c cVar) {
        try {
            return b(cVar);
        } catch (Exception e2) {
            com.tencent.cloud.huiyansdkface.a.d.a.d("V1ConfigOperator", e2, "update camera config error:%s", e2.getMessage());
            return null;
        }
    }
}
