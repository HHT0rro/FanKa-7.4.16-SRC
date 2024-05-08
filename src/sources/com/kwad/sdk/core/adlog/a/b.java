package com.kwad.sdk.core.adlog.a;

import androidx.annotation.Nullable;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.h;
import com.kwad.sdk.utils.ah;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.bn;
import com.kwad.sdk.utils.t;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class b {
    private final c apv;
    private final List<com.kwad.sdk.core.adlog.a.a> apw;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class a {
        private static final b apy = new b(0);
    }

    public /* synthetic */ b(byte b4) {
        this();
    }

    public static b Bi() {
        return a.apy;
    }

    @Nullable
    private synchronized com.kwad.sdk.core.adlog.a.a Bk() {
        if (ah.I(this.apw)) {
            return null;
        }
        return this.apw.remove(0);
    }

    private boolean Bm() {
        c cVar = this.apv;
        return cVar == null || !cVar.apz;
    }

    public final void Bj() {
        try {
            if (Bm() || ah.I(this.apw)) {
                return;
            }
            bn.runOnUiThread(new ay() { // from class: com.kwad.sdk.core.adlog.a.b.2
                @Override // com.kwad.sdk.utils.ay
                public final void doTask() {
                    com.kwad.sdk.core.adlog.b.Bf();
                }
            });
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Nullable
    public final com.kwad.sdk.core.adlog.a.a Bl() {
        com.kwad.sdk.core.adlog.a.a Bk = Bk();
        if (Bk == null) {
            return null;
        }
        com.kwad.sdk.core.adlog.b.a.d(Bk, this.apv, this.apw.size());
        long currentTimeMillis = System.currentTimeMillis() - Bk.aps;
        c cVar = this.apv;
        if (currentTimeMillis > cVar.apB * 1000) {
            com.kwad.sdk.core.adlog.b.a.b(Bk, cVar, this.apw.size(), currentTimeMillis);
            com.kwad.sdk.core.e.c.i("AdLogCacheManager", "getCache fail expired cacheTime: " + currentTimeMillis + ", adLogCache：" + ((Object) Bk));
            return null;
        }
        Bk.retryCount++;
        com.kwad.sdk.core.adlog.b.a.a(Bk, cVar, this.apw.size(), currentTimeMillis);
        com.kwad.sdk.core.e.c.i("AdLogCacheManager", "getCache success：" + ((Object) Bk));
        return Bk;
    }

    public final void a(@Nullable com.kwad.sdk.core.adlog.a.a aVar, String str, JSONObject jSONObject, com.kwad.sdk.core.adlog.c.a aVar2, int i10, String str2) {
        try {
            if (Bm()) {
                return;
            }
            if (aVar == null) {
                aVar = com.kwad.sdk.core.adlog.a.a.Bh().cX(str).i(jSONObject).c(aVar2).ad(System.currentTimeMillis());
            }
            aVar.cr(i10).cY(str2);
            com.kwad.sdk.core.adlog.b.a.a(aVar, this.apv, this.apw.size());
            int i11 = aVar.retryCount;
            c cVar = this.apv;
            if (i11 >= cVar.apA) {
                com.kwad.sdk.core.adlog.b.a.c(aVar, cVar, this.apw.size());
                com.kwad.sdk.core.e.c.i("AdLogCacheManager", "addCache fail limit retryCount: " + aVar.retryCount + ", log: " + ((Object) aVar));
                return;
            }
            if (this.apw.size() >= this.apv.apC) {
                com.kwad.sdk.core.adlog.a.a Bk = Bk();
                com.kwad.sdk.core.e.c.i("AdLogCacheManager", "addCache limit size: " + this.apw.size() + ", remove log：" + ((Object) Bk));
                com.kwad.sdk.core.adlog.b.a.e(Bk, this.apv, this.apw.size());
            }
            a(aVar);
            com.kwad.sdk.core.e.c.i("AdLogCacheManager", "addCache success size: " + this.apw.size() + ", log: " + ((Object) aVar));
            com.kwad.sdk.core.adlog.b.a.b(aVar, this.apv, this.apw.size());
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private b() {
        this.apw = new CopyOnWriteArrayList();
        this.apv = (c) t.b(((h) ServiceProvider.get(h.class)).yY(), new com.kwad.sdk.core.c<c>() { // from class: com.kwad.sdk.core.adlog.a.b.1
            private static c Bn() {
                return new c();
            }

            @Override // com.kwad.sdk.core.c
            public final /* synthetic */ c AW() {
                return Bn();
            }
        });
    }

    private synchronized void a(com.kwad.sdk.core.adlog.a.a aVar) {
        this.apw.add(aVar);
    }
}
