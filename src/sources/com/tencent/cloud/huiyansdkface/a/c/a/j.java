package com.tencent.cloud.huiyansdkface.a.c.a;

import android.hardware.Camera;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private List<i> f40377a = new ArrayList();

    public void a(a aVar) {
        Camera a10 = aVar.a();
        long currentTimeMillis = System.currentTimeMillis();
        Exception e2 = null;
        int i10 = -1;
        for (int i11 = 0; i11 < this.f40377a.size(); i11++) {
            Camera.Parameters parameters = a10.getParameters();
            try {
                this.f40377a.get(i11).a(parameters, aVar);
                a10.setParameters(parameters);
            } catch (Exception e10) {
                e2 = e10;
                i10 = i11;
            }
        }
        if (e2 != null) {
            com.tencent.cloud.huiyansdkface.a.b.b.a(new com.tencent.cloud.huiyansdkface.a.b.c(22, "set some parameter failed:" + i10, e2, "type_normal"));
        }
        com.tencent.cloud.huiyansdkface.a.d.a.a("V1ParasOperator", "set config success. use time:" + (System.currentTimeMillis() - currentTimeMillis), new Object[0]);
    }

    public void a(i iVar) {
        if (iVar == null || this.f40377a.contains(iVar)) {
            return;
        }
        this.f40377a.add(iVar);
    }
}
