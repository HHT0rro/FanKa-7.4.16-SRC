package com.tencent.cloud.huiyansdkface.a.c.a;

import android.hardware.Camera;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    private Camera f40393a;

    public l(Camera camera) {
        this.f40393a = camera;
    }

    public void a(float f10) {
        com.tencent.cloud.huiyansdkface.a.d.a.a("V1ZoomOperator", "take scale:" + f10, new Object[0]);
        try {
            Camera.Parameters parameters = this.f40393a.getParameters();
            if (!parameters.isZoomSupported()) {
                com.tencent.cloud.huiyansdkface.a.d.a.a("V1ZoomOperator", "zoom unsupported", new Object[0]);
                return;
            }
            int maxZoom = parameters.getMaxZoom();
            if (f10 > 1.0f) {
                f10 = 1.0f;
            }
            if (f10 < 0.0f) {
                f10 = 0.0f;
            }
            parameters.setZoom((int) (maxZoom * f10));
            this.f40393a.setParameters(parameters);
            com.tencent.cloud.huiyansdkface.a.d.a.a("V1ZoomOperator", "take scale success.", new Object[0]);
        } catch (Exception e2) {
            com.tencent.cloud.huiyansdkface.a.b.b.a(com.tencent.cloud.huiyansdkface.a.b.c.a(63, "set zoom failed", e2));
        }
    }
}
