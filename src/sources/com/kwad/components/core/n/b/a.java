package com.kwad.components.core.n.b;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.kwad.components.offline.api.IOfflineCompo;
import com.kwad.library.solder.lib.ext.PluginError;
import com.kwad.library.solder.lib.ext.b;
import com.kwad.library.solder.lib.i;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class a<T extends IOfflineCompo<?>> {
    private long EW;
    private String Mx = "";

    private void ab(final Context context) {
        if (com.kwad.components.core.a.Iu.booleanValue()) {
            c.d(getTag(), "init start disableOffline");
            a(context, false, getClass().getClassLoader());
            return;
        }
        com.kwad.library.solder.lib.c.b oL = oL();
        c.d(getTag(), "load component start pluginInfo: " + ((Object) oL));
        com.kwad.library.solder.a.a.a(context, oL, new b.a() { // from class: com.kwad.components.core.n.b.a.1
            public long My;

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.library.solder.lib.ext.b.C0507b, com.kwad.library.solder.lib.ext.b
            public void b(com.kwad.library.solder.lib.b.a aVar) {
                super.b((AnonymousClass1) aVar);
                c.d(a.this.getTag(), "install component resource start");
                com.kwad.components.core.n.c.a.b(a.this.oO(), a.this.getDuration(), a.this.Mx);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.library.solder.lib.ext.b.C0507b, com.kwad.library.solder.lib.ext.b
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(com.kwad.library.solder.lib.b.a aVar) {
                super.a((AnonymousClass1) aVar);
                c.d(a.this.getTag(), "install component resource success");
                com.kwad.components.core.n.c.a.c(a.this.oO(), a.this.getDuration(), a.this.Mx);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.library.solder.lib.ext.b.C0507b, com.kwad.library.solder.lib.ext.b
            /* renamed from: d, reason: merged with bridge method [inline-methods] */
            public void e(com.kwad.library.solder.lib.b.a aVar) {
                super.e((AnonymousClass1) aVar);
                this.My = SystemClock.elapsedRealtime();
                a.this.Mx = aVar.xu() ? "ASSETS" : "NETWORK";
                c.d(a.this.getTag(), "update component resource start");
                com.kwad.components.core.n.c.c.d(a.this.oO(), a.this.getDuration(), a.this.Mx);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.library.solder.lib.ext.b.C0507b, com.kwad.library.solder.lib.ext.b
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public void c(com.kwad.library.solder.lib.b.a aVar) {
                super.c((AnonymousClass1) aVar);
                c.d(a.this.getTag(), "load component resource start");
                a.this.Mx = "LOCAL";
                com.kwad.components.core.n.c.a.b(a.this.oO(), a.this.getDuration(), aVar.xl().wY().xz());
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.library.solder.lib.ext.b.C0507b, com.kwad.library.solder.lib.ext.b
            public void a(com.kwad.library.solder.lib.b.a aVar, com.kwad.library.b.a aVar2) {
                super.a((AnonymousClass1) aVar, (com.kwad.library.solder.lib.b.a) aVar2);
                c.d(a.this.getTag(), "load component resource success");
                com.kwad.components.core.n.c.a.a(a.this.oO(), a.this.getDuration(), a.this.Mx);
                a.this.a(context, !"LOCAL".equals(r4.Mx), aVar2.wU());
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.library.solder.lib.ext.b.C0507b, com.kwad.library.solder.lib.ext.b
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void d(com.kwad.library.solder.lib.b.a aVar) {
                super.d((AnonymousClass1) aVar);
                c.d(a.this.getTag(), "update component resource success");
                com.kwad.components.core.n.c.c.a(a.this.oO(), a.this.getDuration(), SystemClock.elapsedRealtime() - this.My, a.this.Mx);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.library.solder.lib.ext.b.C0507b, com.kwad.library.solder.lib.ext.b
            public void a(com.kwad.library.solder.lib.b.a aVar, PluginError pluginError) {
                super.a((AnonymousClass1) aVar, pluginError);
                if (aVar.getState() == 1) {
                    com.kwad.components.core.n.c.c.b(a.this.oO(), a.this.getDuration(), pluginError.getCode(), a.this.Mx, pluginError.getMessage());
                }
                com.kwad.components.core.n.c.a.a(a.this.oO(), a.this.getDuration(), pluginError.getCode(), "cmp_load_error " + pluginError.getMessage(), a.this.Mx);
                c.d(a.this.getTag(), "load component resource failed error: " + ((Object) pluginError));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long getDuration() {
        return SystemClock.elapsedRealtime() - this.EW;
    }

    private com.kwad.library.solder.lib.c.b oL() {
        com.kwad.library.solder.lib.c.b bVar = new com.kwad.library.solder.lib.c.b();
        bVar.akf = oP();
        bVar.Jd = true;
        bVar.akj = false;
        bVar.akg = com.kwad.sdk.core.network.idc.a.DU().dU(oR());
        bVar.version = oQ();
        bVar.aki = oS();
        if (com.kwad.components.core.a.Ix.booleanValue()) {
            bVar.ajI = oT();
            bVar.ajJ = true;
        }
        if (TextUtils.isEmpty(oS()) || TextUtils.isEmpty(oP()) || TextUtils.isEmpty(oQ()) || TextUtils.isEmpty(oR())) {
            com.kwad.components.core.n.c.a.a(oO(), getDuration(), 6001, "buildRemotePlugInfo error", this.Mx);
        }
        return bVar;
    }

    private void oM() {
        c.d(getTag(), "init component start cost: " + getDuration());
        com.kwad.components.core.n.c.a.d(oO(), getDuration());
    }

    public abstract void a(Context context, boolean z10, T t2);

    public final void au(int i10) {
        c.d(getTag(), "init component error time: " + getDuration());
        com.kwad.components.core.n.c.a.a(oO(), getDuration(), 5001, "cmp_init_error, errorCode:" + i10, this.Mx);
    }

    public abstract String getTag();

    public final void init(Context context) {
        try {
            if (isEnabled()) {
                this.EW = SystemClock.elapsedRealtime();
                com.kwad.components.core.n.c.a.c(oO(), getDuration());
                c.d(getTag(), "init start");
                ab(context);
                return;
            }
            try {
                c.d(getTag(), "del start");
                com.kwad.library.solder.a.a.j(context, oP());
            } catch (Throwable unused) {
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public abstract boolean isEnabled();

    public final void oN() {
        c.d(getTag(), "init component success cost: " + getDuration());
        com.kwad.components.core.n.c.a.c(oO(), getDuration(), i.xe().wY().xz());
    }

    public abstract String oO();

    public abstract String oP();

    public abstract String oQ();

    public abstract String oR();

    public abstract String oS();

    public abstract String oT();

    public abstract String oU();

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(Context context, boolean z10, ClassLoader classLoader) {
        oM();
        String oU = oU();
        try {
            IOfflineCompo iOfflineCompo = (IOfflineCompo) classLoader.loadClass(oU).newInstance();
            c.d(getTag(), "load component instance success: " + iOfflineCompo.getClass().getName() + ", loadFromNet:" + z10 + ", classLoader:" + ((Object) classLoader));
            a(context, z10, (boolean) iOfflineCompo);
        } catch (Throwable th) {
            com.kwad.components.core.n.c.a.a(oO(), getDuration(), 4005, "loadClass error", this.Mx);
            c.e(getTag(), "loadClass or instance failed: " + oU, th);
        }
    }
}
