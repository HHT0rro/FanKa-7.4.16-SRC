package com.kwad.components.ad.reward.k.a;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.g;
import com.kwad.components.ad.reward.k.l;
import com.kwad.components.ad.reward.k.m;
import com.kwad.components.ad.reward.k.n;
import com.kwad.components.ad.reward.k.o;
import com.kwad.components.ad.reward.k.p;
import com.kwad.components.ad.reward.k.r;
import com.kwad.components.ad.reward.k.s;
import com.kwad.components.ad.reward.page.BackPressHandleResult;
import com.kwad.components.core.webview.jshandler.ak;
import com.kwad.components.core.webview.jshandler.w;
import com.kwad.components.core.webview.tachikoma.i;
import com.kwad.components.core.webview.tachikoma.j;
import com.kwad.sdk.components.q;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.lang.ref.WeakReference;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class d extends i implements r, w.b {

    @Nullable
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private WeakReference<g> qh;
    private List<AdTemplate> xA;

    @Nullable
    private DialogInterface.OnDismissListener xB;
    private com.kwad.components.ad.reward.c.e xw;
    private m xx;
    private l xy;
    private n xz;

    public d(@NonNull g gVar, long j10, Context context) {
        super(j10, context);
        this.xA = null;
        this.qh = new WeakReference<>(gVar);
    }

    @Override // com.kwad.components.core.webview.jshandler.w.b
    public final void N(AdTemplate adTemplate) {
        com.kwad.components.core.i.c cVar = new com.kwad.components.core.i.c(adTemplate, com.kwad.components.core.i.e.AGGREGATION);
        WeakReference<g> weakReference = this.qh;
        g gVar = weakReference != null ? weakReference.get() : null;
        if (gVar != null) {
            gVar.b(cVar);
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.i
    public final void a(@Nullable Activity activity, AdResultData adResultData, j jVar) {
        super.a(activity, adResultData, jVar);
        WeakReference<g> weakReference = this.qh;
        g gVar = weakReference != null ? weakReference.get() : null;
        if (gVar != null) {
            gVar.a(this);
        }
    }

    @Override // com.kwad.components.ad.reward.k.r
    public final void aa(boolean z10) {
        n nVar = this.xz;
        if (nVar != null) {
            nVar.Z(z10);
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.i
    public final ak c(com.kwad.sdk.core.webview.b bVar) {
        WeakReference<g> weakReference = this.qh;
        return new p(weakReference != null ? weakReference.get() : null, getTkTemplateId(), this.xs, bVar);
    }

    @Override // com.kwad.components.core.webview.tachikoma.i, com.kwad.components.core.e.e.f
    public final void dismiss() {
        WeakReference<g> weakReference = this.qh;
        if (weakReference != null) {
            weakReference.get().D(false);
        }
        super.dismiss();
    }

    public final BackPressHandleResult gn() {
        m mVar = this.xx;
        if (mVar == null) {
            return BackPressHandleResult.NOT_HANDLED;
        }
        mVar.jg();
        return BackPressHandleResult.HANDLED;
    }

    public final void h(List<AdTemplate> list) {
        this.xA = list;
    }

    public final com.kwad.components.ad.reward.c.e jn() {
        return this.xw;
    }

    public final l jo() {
        return this.xy;
    }

    @Override // com.kwad.components.core.webview.tachikoma.i
    public final void jp() {
        super.jp();
        WeakReference<g> weakReference = this.qh;
        g gVar = weakReference != null ? weakReference.get() : null;
        if (gVar != null) {
            gVar.b(this);
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.i, com.kwad.components.core.e.e.f
    public final void show() {
        super.show();
        WeakReference<g> weakReference = this.qh;
        if (weakReference != null) {
            weakReference.get().D(true);
        }
    }

    public d(g gVar, long j10, Context context, @Nullable DialogInterface.OnDismissListener onDismissListener) {
        super(-1L, context);
        this.xA = null;
        this.xB = onDismissListener;
        this.qh = new WeakReference<>(gVar);
    }

    @Override // com.kwad.components.core.webview.tachikoma.i
    public final void a(com.kwad.sdk.core.webview.b bVar, com.kwad.components.core.e.d.c cVar, q qVar, ViewGroup viewGroup) {
        super.a(bVar, cVar, qVar, viewGroup);
        this.mApkDownloadHelper = cVar;
        WeakReference<g> weakReference = this.qh;
        com.kwad.sdk.core.webview.c.a qVar2 = new com.kwad.components.ad.reward.k.q(bVar, cVar, weakReference != null ? weakReference.get() : null, this.xs, this, this.xB);
        com.kwad.components.core.e.e.g.or().a(this);
        qVar.c(qVar2);
        com.kwad.components.ad.reward.c.e eVar = new com.kwad.components.ad.reward.c.e();
        this.xw = eVar;
        qVar.c(eVar);
        Context context = this.mContext;
        WeakReference<g> weakReference2 = this.qh;
        qVar.c(new s(context, weakReference2 != null ? weakReference2.get() : null));
        WeakReference<g> weakReference3 = this.qh;
        qVar.c(new o(weakReference3 != null ? weakReference3.get() : null));
        m mVar = new m();
        this.xx = mVar;
        qVar.c(mVar);
        l lVar = new l();
        this.xy = lVar;
        qVar.c(lVar);
        List<AdTemplate> list = this.xA;
        if (list != null) {
            this.xy.g(list);
            this.xA = null;
        }
        w wVar = new w(bVar);
        wVar.a(this);
        qVar.c(wVar);
        n nVar = new n();
        this.xz = nVar;
        qVar.c(nVar);
    }
}
