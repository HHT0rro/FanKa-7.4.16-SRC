package com.kwad.sdk.commercial.h;

import android.content.Context;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.ksad.annotation.invoker.InvokeBy;
import com.kuaishou.weapon.p0.t;
import com.kwad.sdk.core.c.b;
import com.kwad.sdk.core.c.d;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.i.g;
import com.kwad.sdk.i.h;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.f;
import com.kwad.sdk.utils.av;
import com.kwad.sdk.utils.ay;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a implements com.kwad.sdk.core.e.a.a {
    private final AtomicBoolean JB;

    /* renamed from: com.kwad.sdk.commercial.h.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class C0513a {
        private static final a aoH = new a(0);
    }

    public /* synthetic */ a(byte b4) {
        this();
    }

    public static a AR() {
        return C0513a.aoH;
    }

    @InvokeBy(invokerClass = c.class, methodId = "registerLogger")
    public static void register() {
        c.a(AR());
    }

    public final void cH(String str) {
        try {
            if (this.JB.get()) {
                return;
            }
            Context KO = ServiceProvider.KO();
            final f fVar = (f) ServiceProvider.get(f.class);
            h.Jc().a(str, g.IX().fN(ServiceProvider.KP().appId).fO(ServiceProvider.getSdkVersion()).fP(av.getOaid()).fS(av.cv(KO)).fQ(av.getDeviceId()).fR(av.cw(KO)).m(fVar.yx()).bE(com.kwad.sdk.components.f.encryptDisable()).fT(fVar.yw()).g(fVar.yz()).n(fVar.yy()), new com.kwad.sdk.i.f() { // from class: com.kwad.sdk.commercial.h.a.1
                @Override // com.kwad.sdk.i.f
                public final void a(String str2, Map<String, String> map, String str3) {
                    fVar.a(str2, map, str3);
                }

                @Override // com.kwad.sdk.i.f
                public final String al(String str2) {
                    return fVar.al(str2);
                }
            });
            b.DD();
            b.a(new d() { // from class: com.kwad.sdk.commercial.h.a.2
                @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
                public final void onBackToBackground() {
                    super.onBackToBackground();
                }

                @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
                public final void onBackToForeground() {
                    super.onBackToForeground();
                    com.kwad.sdk.utils.g.schedule(new ay() { // from class: com.kwad.sdk.commercial.h.a.2.1
                        @Override // com.kwad.sdk.utils.ay
                        public final void doTask() {
                            h.Jc().Jd();
                        }
                    }, 3L, TimeUnit.SECONDS);
                }
            });
            this.JB.set(true);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.sdk.core.e.a.a
    public final void d(String str, String str2) {
        h.Jc().f("d", str, str2);
    }

    @Override // com.kwad.sdk.core.e.a.a
    public final void e(String str, String str2) {
        h.Jc().f("e", str, str2);
    }

    @Override // com.kwad.sdk.core.e.a.a
    public final void i(String str, String str2) {
        h.Jc().f(t.f36220e, str, str2);
    }

    @Override // com.kwad.sdk.core.e.a.a
    public final void printStackTraceOnly(Throwable th) {
    }

    @Override // com.kwad.sdk.core.e.a.a
    public final void v(String str, String str2) {
        h.Jc().f(t.f36218c, str, str2);
    }

    @Override // com.kwad.sdk.core.e.a.a
    public final void w(String str, String str2) {
        h.Jc().f(IAdInterListener.AdReqParam.WIDTH, str, str2);
    }

    private a() {
        this.JB = new AtomicBoolean(false);
    }

    @Override // com.kwad.sdk.core.e.a.a
    public final void v(String str, String str2, boolean z10) {
        h.Jc().f(t.f36218c, str, str2);
    }

    @Override // com.kwad.sdk.core.e.a.a
    public final void w(String str, String str2, boolean z10) {
        h.Jc().f(IAdInterListener.AdReqParam.WIDTH, str, str2);
    }
}
