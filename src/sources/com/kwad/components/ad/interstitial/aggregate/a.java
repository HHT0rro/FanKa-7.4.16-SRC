package com.kwad.components.ad.interstitial.aggregate;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import com.kwad.components.ad.interstitial.e.c;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdResultData;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class a extends PagerAdapter {
    private final KsAdVideoPlayConfig dU;

    /* renamed from: ie, reason: collision with root package name */
    private final KsInterstitialAd.AdInteractionListener f36504ie;

    /* renamed from: im, reason: collision with root package name */
    private final List<AdResultData> f36505im = new ArrayList();

    /* renamed from: io, reason: collision with root package name */
    private final com.kwad.components.ad.interstitial.d f36506io;
    private final boolean iq;
    private b ir;
    private InterfaceC0413a is;

    /* renamed from: com.kwad.components.ad.interstitial.aggregate.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface InterfaceC0413a {
        void cp();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface b {
        void a(com.kwad.components.ad.interstitial.g.c cVar, int i10);
    }

    public a(AdResultData adResultData, com.kwad.components.ad.interstitial.d dVar, KsAdVideoPlayConfig ksAdVideoPlayConfig, KsInterstitialAd.AdInteractionListener adInteractionListener) {
        this.f36506io = dVar;
        this.dU = ksAdVideoPlayConfig;
        this.f36504ie = adInteractionListener;
        this.iq = com.kwad.sdk.core.response.b.a.cs(e.dQ(com.kwad.sdk.core.response.b.c.n(adResultData))) == 1;
    }

    public final void d(List<AdResultData> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.f36505im.clear();
        this.f36505im.addAll(list);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void destroyItem(@NonNull ViewGroup viewGroup, int i10, Object obj) {
        if (obj instanceof View) {
            viewGroup.removeView((View) obj);
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final int getCount() {
        return this.f36505im.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @NonNull
    public final Object instantiateItem(@NonNull ViewGroup viewGroup, final int i10) {
        com.kwad.components.ad.interstitial.g.c cVar = new com.kwad.components.ad.interstitial.g.c(viewGroup.getContext());
        viewGroup.addView(cVar);
        cVar.setAggregateAdView(i10 > 0);
        if (i10 == 0) {
            cVar.setAdConvertListener(new c.a() { // from class: com.kwad.components.ad.interstitial.aggregate.a.1
                @Override // com.kwad.components.ad.interstitial.e.c.a
                public final void b(long j10, long j11) {
                    AdResultData adResultData = (AdResultData) a.this.f36505im.get(i10);
                    if (adResultData == null) {
                        return;
                    }
                    com.kwad.components.ad.interstitial.report.a.dM().b(com.kwad.sdk.core.response.b.c.n(adResultData), j10, j11);
                    if (a.this.is != null) {
                        a.this.is.cp();
                    }
                }
            });
        }
        if (i10 > 0) {
            if (i10 == 1) {
                cVar.setAggregateShowTriggerType(this.iq ? 8 : 7);
            } else {
                cVar.setAggregateShowTriggerType(7);
            }
        }
        cVar.a(this.f36505im.get(i10), this.f36506io, this.dU, this.f36504ie);
        b bVar = this.ir;
        if (bVar != null) {
            bVar.a(cVar, i10);
        }
        return cVar;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
        return view == obj;
    }

    public final void a(b bVar) {
        this.ir = bVar;
    }

    public final void a(InterfaceC0413a interfaceC0413a) {
        this.is = interfaceC0413a;
    }
}
