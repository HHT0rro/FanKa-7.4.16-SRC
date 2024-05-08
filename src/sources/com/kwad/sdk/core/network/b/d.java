package com.kwad.sdk.core.network.b;

import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.huawei.appgallery.agd.common.constant.SymbolValues;
import com.kwad.sdk.core.network.i;
import com.kwad.sdk.core.network.j;
import com.kwad.sdk.core.network.k;
import com.kwad.sdk.service.ServiceProvider;
import java.util.Random;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class d implements b {
    private static boolean awN = true;
    public static double awO = 1.0d;
    private static volatile boolean awS = false;
    private static String awT = "";
    private long awP = -1;
    private long awQ = -1;
    private long awR = -1;
    private j awU = new j();

    public d() {
        awO = new Random().nextDouble();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: Ek, reason: merged with bridge method [inline-methods] */
    public d Ec() {
        this.awU.avY = SystemClock.elapsedRealtime();
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: El, reason: merged with bridge method [inline-methods] */
    public d Ed() {
        this.awQ = SystemClock.elapsedRealtime();
        ec("this.responseReceiveTime:" + this.awQ);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: Em, reason: merged with bridge method [inline-methods] */
    public d Ee() {
        if (al(this.awP) && al(this.awQ)) {
            this.awU.awf = this.awQ - this.awP;
            ec("info.waiting_response_cost:" + this.awU.awf);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: En, reason: merged with bridge method [inline-methods] */
    public d Ef() {
        if (al(this.awU.avY)) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.awP = elapsedRealtime;
            j jVar = this.awU;
            jVar.avS = elapsedRealtime - jVar.avY;
            if (al(jVar.avQ)) {
                j jVar2 = this.awU;
                jVar2.avR = jVar2.avS - jVar2.avQ;
            }
            ec("info.request_create_cost:" + this.awU.avS);
            ec("info.requestAddParamsCost:" + this.awU.avR);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: Eo, reason: merged with bridge method [inline-methods] */
    public d Eh() {
        if (al(this.awQ)) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.awR = elapsedRealtime;
            this.awU.awd = elapsedRealtime - this.awQ;
            ec("info.response_parse_cost:" + this.awU.awd);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: Ep, reason: merged with bridge method [inline-methods] */
    public d Ei() {
        if (al(this.awR)) {
            this.awU.awk = SystemClock.elapsedRealtime() - this.awR;
            Eq();
            ec("info.response_done_cost:" + this.awU.awk);
        }
        return this;
    }

    private void Eq() {
        j jVar = this.awU;
        if (jVar == null || jVar.awj != 1 || ao(jVar.awk)) {
            return;
        }
        this.awU.awk = -1L;
    }

    private d Er() {
        this.awU.awn = (int) com.kwad.sdk.ip.direct.a.Ix();
        this.awU.awo = (int) com.kwad.sdk.ip.direct.a.Iy();
        this.awU.awp = (int) com.kwad.sdk.ip.direct.a.Iz();
        return this;
    }

    private void Es() {
        i c4 = c(this.awU);
        k kVar = (k) ServiceProvider.get(k.class);
        if (kVar != null) {
            kVar.a(c4);
        }
        com.kwad.sdk.core.e.c.d("NetworkMonitorRecorder", "reportError" + c4.toJson().toString());
    }

    private static boolean al(long j10) {
        return j10 != -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: am, reason: merged with bridge method [inline-methods] */
    public d ak(long j10) {
        this.awU.awe = j10;
        ec("responseSize:" + j10);
        return this;
    }

    private d an(long j10) {
        this.awU.awg = j10;
        ec("totalCost:" + j10);
        return this;
    }

    private static boolean ao(long j10) {
        return j10 >= 50;
    }

    private static boolean c(@NonNull i iVar) {
        if (TextUtils.isEmpty(iVar.url)) {
            return true;
        }
        String lowerCase = iVar.url.toLowerCase();
        return lowerCase.contains("beta") || lowerCase.contains("test") || lowerCase.contains("staging");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: dj, reason: merged with bridge method [inline-methods] */
    public d df(int i10) {
        this.awU.httpCode = i10;
        ec("http_code:" + i10);
        return this;
    }

    private d dk(int i10) {
        this.awU.awj = i10;
        ec("hasData:" + i10);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: dl, reason: merged with bridge method [inline-methods] */
    public d dh(int i10) {
        this.awU.result = i10;
        ec("result:" + i10);
        return this;
    }

    private static void ec(String str) {
        if (awN) {
            com.kwad.sdk.core.e.c.d("NetworkMonitorRecorder", str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: ed, reason: merged with bridge method [inline-methods] */
    public d dX(String str) {
        if (TextUtils.isEmpty(str)) {
            return this;
        }
        this.awU.url = str;
        if (str.contains(SymbolValues.QUESTION_EN_SYMBOL)) {
            String[] split = str.split("\\?");
            if (split.length > 0) {
                str = split[0];
            }
        }
        if (!TextUtils.isEmpty(str)) {
            ec("url:" + str);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: ee, reason: merged with bridge method [inline-methods] */
    public d dY(String str) {
        try {
            this.awU.host = Uri.parse(str).getHost();
            ec("host:" + this.awU.host);
        } catch (Exception e2) {
            com.kwad.sdk.core.e.c.e("NetworkMonitorRecorder", Log.getStackTraceString(e2));
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: ef, reason: merged with bridge method [inline-methods] */
    public d dZ(String str) {
        this.awU.errorMsg = str;
        ec(str);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: eg, reason: merged with bridge method [inline-methods] */
    public d ea(String str) {
        this.awU.avO = str;
        ec("reqType:" + str);
        ei(com.kwad.sdk.ip.direct.a.Iw());
        Er();
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: eh, reason: merged with bridge method [inline-methods] */
    public d eb(String str) {
        this.awU.awi = str;
        ec("requestId:" + str);
        return this;
    }

    private d ei(String str) {
        this.awU.awl = str;
        return this;
    }

    @Override // com.kwad.sdk.core.network.b.b
    public final b Eg() {
        if (al(this.awU.avY)) {
            this.awU.avQ = SystemClock.elapsedRealtime() - this.awU.avY;
            ec("info.request_prepare_cost:" + this.awU.avQ);
        }
        return this;
    }

    @Override // com.kwad.sdk.core.network.b.b
    public final /* synthetic */ b dg(int i10) {
        return dk(1);
    }

    @Override // com.kwad.sdk.core.network.b.b
    public final b di(int i10) {
        j jVar = this.awU;
        jVar.awm = i10;
        if (i10 != 0) {
            jVar.avP = 1;
        }
        return this;
    }

    @Override // com.kwad.sdk.core.network.b.b
    public final void report() {
        if (c((i) this.awU)) {
            return;
        }
        if (this.awU.httpCode != 200) {
            Es();
            return;
        }
        long elapsedRealtime = al(this.awU.avY) ? SystemClock.elapsedRealtime() - this.awU.avY : -1L;
        an(elapsedRealtime);
        if (elapsedRealtime > 30000 || elapsedRealtime <= -1) {
            return;
        }
        k kVar = (k) ServiceProvider.get(k.class);
        if (kVar != null) {
            kVar.a(this.awU);
        }
        ec("report normal" + this.awU.toString());
    }

    private static i c(j jVar) {
        i iVar = new i();
        iVar.errorMsg = jVar.errorMsg;
        iVar.host = jVar.host;
        iVar.httpCode = jVar.httpCode;
        iVar.avO = jVar.avO;
        iVar.url = jVar.url;
        iVar.avP = jVar.avP;
        return iVar;
    }
}
