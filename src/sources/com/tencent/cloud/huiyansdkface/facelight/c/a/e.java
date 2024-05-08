package com.tencent.cloud.huiyansdkface.facelight.c.a;

import android.content.Context;
import android.view.View;
import com.alimm.tanx.core.utils.LandingPageUtHelper;
import com.tencent.cloud.huiyansdkface.a.g.a;
import com.tencent.cloud.huiyansdkface.normal.tools.WLogger;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class e implements com.tencent.cloud.huiyansdkface.a.g.a {

    /* renamed from: a, reason: collision with root package name */
    private com.tencent.cloud.huiyansdkface.facelight.c.d.c f40608a;

    @Override // com.tencent.cloud.huiyansdkface.a.g.a
    public View a(Context context) {
        return this.f40608a.a(context);
    }

    public void a() {
        WLogger.d("TuringPreviewView", LandingPageUtHelper.XAD_UT_LP_DESTROY);
        this.f40608a.c();
    }

    @Override // com.tencent.cloud.huiyansdkface.a.g.a
    public void a(com.tencent.cloud.huiyansdkface.a.c.a.a aVar) {
        this.f40608a.a(aVar.a());
    }

    @Override // com.tencent.cloud.huiyansdkface.a.g.a
    public void a(a.InterfaceC0616a interfaceC0616a) {
        WLogger.i("TuringPreviewView", "set TuringCallback");
        this.f40608a.a(interfaceC0616a);
    }

    public void a(com.tencent.cloud.huiyansdkface.facelight.c.d.c cVar) {
        this.f40608a = cVar;
    }

    @Override // com.tencent.cloud.huiyansdkface.a.g.a
    public boolean b() {
        return false;
    }
}
