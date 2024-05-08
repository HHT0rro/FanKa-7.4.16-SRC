package com.kwad.sdk;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.core.d.a;
import com.kwad.components.core.e.d.a;
import com.kwad.sdk.core.imageloader.ImageLoaderProxy;
import com.kwad.sdk.core.report.n;
import com.kwad.sdk.core.report.s;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class i {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a implements com.kwad.sdk.service.a.a {
        private a() {
        }

        public /* synthetic */ a(byte b4) {
            this();
        }

        @Override // com.kwad.sdk.service.a.a
        public final void g(Context context, AdTemplate adTemplate) {
            com.kwad.components.core.e.d.a.a(new a.C0461a(context).aq(adTemplate).aq(true));
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class b implements com.kwad.sdk.service.a.f {
        private b() {
        }

        public /* synthetic */ b(byte b4) {
            this();
        }

        @Override // com.kwad.sdk.service.a.f
        public final void a(String str, Map<String, String> map, String str2) {
            com.kwad.sdk.core.a.d.a(str, map, str2);
        }

        @Override // com.kwad.sdk.service.a.f
        public final boolean aF(AdTemplate adTemplate) {
            com.kwad.components.a.a.a aVar = (com.kwad.components.a.a.a) com.kwad.sdk.components.c.f(com.kwad.components.a.a.a.class);
            return aVar != null && aVar.tC();
        }

        @Override // com.kwad.sdk.service.a.f
        public final String al(String str) {
            return com.kwad.sdk.core.a.d.al(str);
        }

        @Override // com.kwad.sdk.service.a.f
        public final String getApiVersion() {
            return k.zd().getApiVersion();
        }

        @Override // com.kwad.sdk.service.a.f
        public final int getApiVersionCode() {
            return k.zd().getApiVersionCode();
        }

        @Override // com.kwad.sdk.service.a.f
        public final String getAppId() {
            return ServiceProvider.getAppId();
        }

        @Override // com.kwad.sdk.service.a.f
        public final String getAppName() {
            return ServiceProvider.getAppName();
        }

        @Override // com.kwad.sdk.service.a.f
        public final Context getContext() {
            return ServiceProvider.getContext();
        }

        @Override // com.kwad.sdk.service.a.f
        public final String getSDKVersion() {
            k.zd();
            return k.getSDKVersion();
        }

        @Override // com.kwad.sdk.service.a.f
        public final boolean oK() {
            com.kwad.components.core.n.a.a.a aVar = (com.kwad.components.core.n.a.a.a) com.kwad.sdk.components.c.f(com.kwad.components.core.n.a.a.a.class);
            if (aVar != null) {
                return aVar.oK();
            }
            return false;
        }

        @Override // com.kwad.sdk.service.a.f
        public final com.kwad.sdk.core.response.b.g tD() {
            com.kwad.components.a.a.a aVar = (com.kwad.components.a.a.a) com.kwad.sdk.components.c.f(com.kwad.components.a.a.a.class);
            if (aVar != null) {
                return aVar.tD();
            }
            return null;
        }

        @Override // com.kwad.sdk.service.a.f
        public final boolean yp() {
            return k.zd().yp();
        }

        @Override // com.kwad.sdk.service.a.f
        public final boolean yq() {
            return k.zd().yq();
        }

        @Override // com.kwad.sdk.service.a.f
        public final boolean yr() {
            return k.zd().yr();
        }

        @Override // com.kwad.sdk.service.a.f
        public final boolean ys() {
            return k.zd().ys();
        }

        @Override // com.kwad.sdk.service.a.f
        public final String yt() {
            return com.kwad.sdk.kgeo.a.yt();
        }

        @Override // com.kwad.sdk.service.a.f
        public final com.kwad.sdk.core.b yu() {
            return com.kwad.sdk.kgeo.a.IS();
        }

        @Override // com.kwad.sdk.service.a.f
        public final List<AdTemplate> yv() {
            return com.kwad.sdk.core.download.b.De().yv();
        }

        @Override // com.kwad.sdk.service.a.f
        public final String yw() {
            return g.ya();
        }

        @Override // com.kwad.sdk.service.a.f
        public final JSONObject yx() {
            return com.kwad.components.core.o.a.qi().m("", "").toJson();
        }

        @Override // com.kwad.sdk.service.a.f
        public final JSONObject yy() {
            return new com.kwad.sdk.core.report.f((List<n>) null).getBodyParams();
        }

        @Override // com.kwad.sdk.service.a.f
        public final Map<String, String> yz() {
            return new com.kwad.sdk.core.report.f((List<n>) null).getHeader();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class c implements com.kwad.sdk.service.a.h {
        private c() {
        }

        public /* synthetic */ c(byte b4) {
            this();
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean X(long j10) {
            return com.kwad.sdk.core.config.d.X(j10);
        }

        @Override // com.kwad.sdk.service.a.h
        public final int as(Context context) {
            return com.kwad.sdk.core.config.item.c.aT(context);
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean bW(String str) {
            return com.kwad.sdk.core.config.a.bW(str);
        }

        @Override // com.kwad.sdk.service.a.h
        public final <T> T getAppConfigData(T t2, com.kwad.sdk.g.b<JSONObject, T> bVar) {
            return (T) com.kwad.sdk.core.config.d.Ca().getAppConfigData(null, bVar);
        }

        @Override // com.kwad.sdk.service.a.h
        public final String getAppId() {
            return ServiceProvider.getAppId();
        }

        @Override // com.kwad.sdk.service.a.h
        public final String getUserAgent() {
            return com.kwad.sdk.core.config.d.getUserAgent();
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean wJ() {
            return com.kwad.sdk.core.config.d.wJ();
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean yA() {
            return com.kwad.sdk.core.config.d.yA();
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean yB() {
            return com.kwad.sdk.core.config.d.b(com.kwad.sdk.core.config.c.aru);
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean yC() {
            return com.kwad.sdk.core.config.d.yC();
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean yD() {
            return com.kwad.sdk.core.config.d.yD();
        }

        @Override // com.kwad.sdk.service.a.h
        public final String yE() {
            return com.kwad.sdk.core.config.d.yE();
        }

        @Override // com.kwad.sdk.service.a.h
        public final String yF() {
            return com.kwad.sdk.core.config.d.yF();
        }

        @Override // com.kwad.sdk.service.a.h
        public final List<String> yG() {
            return com.kwad.sdk.core.config.d.yG();
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean yH() {
            return com.kwad.sdk.core.config.d.yH();
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean yI() {
            return com.kwad.sdk.core.config.d.yI();
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean yJ() {
            return com.kwad.sdk.core.config.d.Cf();
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean yK() {
            return com.kwad.sdk.core.config.d.yK();
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean yL() {
            return com.kwad.sdk.core.config.d.yL();
        }

        @Override // com.kwad.sdk.service.a.h
        public final int yM() {
            return com.kwad.sdk.core.config.d.yM();
        }

        @Override // com.kwad.sdk.service.a.h
        public final int yN() {
            return com.kwad.sdk.core.config.d.yN();
        }

        @Override // com.kwad.sdk.service.a.h
        public final double yO() {
            return com.kwad.sdk.core.config.d.yO();
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean yP() {
            return com.kwad.sdk.core.config.d.yP();
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean yQ() {
            return com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.asP);
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean yR() {
            return com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.asQ);
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean yS() {
            return com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.asR);
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean yT() {
            return com.kwad.sdk.core.config.d.yT();
        }

        @Override // com.kwad.sdk.service.a.h
        public final int yU() {
            return com.kwad.sdk.core.config.d.yU();
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean yV() {
            return com.kwad.sdk.core.config.d.yV();
        }

        @Override // com.kwad.sdk.service.a.h
        public final String yW() {
            return com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.asY);
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean yX() {
            return com.kwad.sdk.core.config.d.b(com.kwad.sdk.core.config.c.atc);
        }

        @Override // com.kwad.sdk.service.a.h
        public final String yY() {
            return com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.ath);
        }
    }

    public static void yj() {
        byte b4 = 0;
        ServiceProvider.put(com.kwad.sdk.service.a.f.class, new b(b4));
        ServiceProvider.put(com.kwad.sdk.service.a.h.class, new c(b4));
        ServiceProvider.put(com.kwad.sdk.service.a.e.class, new com.kwad.sdk.service.a.e() { // from class: com.kwad.sdk.i.1
            @Override // com.kwad.sdk.service.a.e
            public final void G(String str, String str2) {
                com.kwad.components.core.d.a.j(str, str2);
            }

            @Override // com.kwad.sdk.service.a.e
            public final void a(final com.kwad.sdk.service.a.c cVar) {
                com.kwad.components.core.d.a.a(new a.b() { // from class: com.kwad.sdk.i.1.1
                    @Override // com.kwad.components.core.d.a.b
                    public final String getKey() {
                        com.kwad.sdk.service.a.c cVar2 = cVar;
                        if (cVar2 != null) {
                            return cVar2.getKey();
                        }
                        return null;
                    }

                    @Override // com.kwad.components.core.d.a.b
                    public final JSONObject getValue() {
                        com.kwad.sdk.service.a.c cVar2 = cVar;
                        if (cVar2 != null) {
                            return cVar2.getValue();
                        }
                        return null;
                    }
                });
            }

            @Override // com.kwad.sdk.service.a.e
            public final void gatherException(Throwable th) {
                com.kwad.components.core.d.a.reportSdkCaughtException(th);
            }

            @Override // com.kwad.sdk.service.a.e
            public final void a(final com.kwad.sdk.service.a.g gVar) {
                com.kwad.components.core.d.a.a(new a.c() { // from class: com.kwad.sdk.i.1.2
                    @Override // com.kwad.components.core.d.a.c
                    public final void onCrashOccur(int i10, String str) {
                        com.kwad.sdk.service.a.g gVar2 = gVar;
                        if (gVar2 != null) {
                            gVar2.l(i10, str);
                        }
                    }
                });
            }
        });
        ServiceProvider.put(com.kwad.sdk.service.a.d.class, new com.kwad.sdk.service.a.d() { // from class: com.kwad.sdk.i.2
            @Override // com.kwad.sdk.service.a.d
            public final void a(boolean z10, String str, String str2, String str3) {
                com.kwad.sdk.core.diskcache.b.a.Dc().dr(str);
            }

            @Override // com.kwad.sdk.service.a.d
            public final File bV(String str) {
                return com.kwad.sdk.core.diskcache.b.a.Dc().bV(str);
            }
        });
        ServiceProvider.put(com.kwad.sdk.service.a.j.class, new com.kwad.sdk.service.a.j() { // from class: com.kwad.sdk.i.3
            @Override // com.kwad.sdk.service.a.j
            public final boolean qB() {
                com.kwad.components.core.p.b.qA();
                return com.kwad.components.core.p.b.qB();
            }

            @Override // com.kwad.sdk.service.a.j
            public final int qC() {
                com.kwad.components.core.p.b.qA();
                return com.kwad.components.core.p.b.qC();
            }

            @Override // com.kwad.sdk.service.a.j
            public final int qD() {
                return com.kwad.components.core.p.b.qA().qD();
            }

            @Override // com.kwad.sdk.service.a.j
            public final InputStream wrapInputStream(InputStream inputStream) {
                com.kwad.components.core.p.b.qA();
                return com.kwad.components.core.p.b.wrapInputStream(inputStream);
            }
        });
        ServiceProvider.put(com.kwad.sdk.core.network.k.class, new com.kwad.sdk.core.network.k() { // from class: com.kwad.sdk.i.4
            @Override // com.kwad.sdk.core.network.k
            public final void a(com.kwad.sdk.core.network.j jVar) {
                com.kwad.sdk.commercial.b.b(jVar);
            }

            @Override // com.kwad.sdk.core.network.k
            public final com.kwad.sdk.core.b yk() {
                return com.kwad.components.core.request.model.b.qz();
            }

            @Override // com.kwad.sdk.core.network.k
            public final void a(com.kwad.sdk.core.network.i iVar) {
                com.kwad.sdk.commercial.b.b(iVar);
            }
        });
        ServiceProvider.put(com.kwad.sdk.service.a.i.class, ImageLoaderProxy.INSTANCE);
        ServiceProvider.put(com.kwad.sdk.service.a.b.class, new com.kwad.sdk.service.a.b() { // from class: com.kwad.sdk.i.5
            @Override // com.kwad.sdk.service.a.b
            public final void H(String str, String str2) {
                com.kwad.sdk.core.e.c.e("image_load_failed_info", "errorMsg:" + str2 + "\nurl:" + str);
            }

            @Override // com.kwad.sdk.service.a.b
            public final void aE(AdTemplate adTemplate) {
                com.kwad.components.core.o.a.qi().f(adTemplate, 21007);
            }

            @Override // com.kwad.sdk.service.a.b
            public final void e(@NonNull JSONObject jSONObject, int i10) {
                com.kwad.components.core.o.a.qi().e(jSONObject, i10);
            }

            @Override // com.kwad.sdk.service.a.b
            public final void yl() {
                com.kwad.components.core.o.a.qi().ae(ServiceProvider.getContext());
            }
        });
        ServiceProvider.put(s.class, new s() { // from class: com.kwad.sdk.i.6
            @Override // com.kwad.sdk.core.report.s
            public final boolean W(long j10) {
                com.kwad.sdk.core.config.item.n nVar = com.kwad.sdk.core.config.c.arh;
                return com.kwad.sdk.core.config.item.n.W(j10);
            }

            @Override // com.kwad.sdk.core.report.s
            public final int tA() {
                com.kwad.components.a.a.a aVar = (com.kwad.components.a.a.a) com.kwad.sdk.components.c.f(com.kwad.components.a.a.a.class);
                if (aVar != null) {
                    return aVar.tA();
                }
                return 0;
            }

            @Override // com.kwad.sdk.core.report.s
            public final int ym() {
                return com.kwad.sdk.core.config.d.ym();
            }
        });
        ServiceProvider.put(com.kwad.sdk.core.video.a.f.class, new com.kwad.sdk.core.video.a.f() { // from class: com.kwad.sdk.i.7
            @Override // com.kwad.sdk.core.video.a.f
            public final boolean tB() {
                return ((com.kwad.components.a.a.a) com.kwad.sdk.components.c.f(com.kwad.components.a.a.a.class)).tB();
            }

            @Override // com.kwad.sdk.core.video.a.f
            public final boolean yn() {
                return com.kwad.sdk.core.config.d.yn();
            }

            @Override // com.kwad.sdk.core.video.a.f
            public final boolean yo() {
                return com.kwad.sdk.core.config.d.yo();
            }
        });
        ServiceProvider.put(com.kwad.sdk.utils.b.b.class, new com.kwad.sdk.utils.b.b() { // from class: com.kwad.sdk.i.8
            @Override // com.kwad.sdk.utils.b.b
            public final void a(com.kwad.sdk.utils.b.a aVar) {
                if (aVar == null) {
                    return;
                }
                com.kwad.sdk.commercial.b.b(aVar);
            }
        });
        ServiceProvider.put(com.kwad.sdk.service.a.a.class, new a(b4));
    }
}
