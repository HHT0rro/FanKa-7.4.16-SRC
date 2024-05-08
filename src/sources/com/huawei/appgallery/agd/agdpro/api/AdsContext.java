package com.huawei.appgallery.agd.agdpro.api;

import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.app.ComponentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.huawei.appgallery.agd.agdpro.api.ICardAd;
import com.huawei.appgallery.agd.agdpro.impl.reward.AgdRewardAd;
import com.huawei.appgallery.agd.core.api.AdSlot;
import com.huawei.appgallery.agd.core.api.AgdAdApi;
import com.huawei.appgallery.agd.core.impl.AgdAdManager;
import com.huawei.appgallery.agd.core.impl.report.MaintBi;
import com.huawei.appgallery.agd.core.internalapi.CoreApi;
import e9.c;
import e9.d;
import e9.e;
import e9.i;
import e9.l;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import org.json.JSONArray;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class AdsContext {

    /* renamed from: a, reason: collision with root package name */
    public final WeakReference<ComponentActivity> f27220a;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class LifecycleRunnable implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final Activity f27225a;

        /* renamed from: b, reason: collision with root package name */
        public final List<ITemplateAd> f27226b;

        public LifecycleRunnable(@NonNull Activity activity, @NonNull List<ITemplateAd> list) {
            this.f27225a = activity;
            this.f27226b = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            ComponentCallbacks2 componentCallbacks2 = this.f27225a;
            if (componentCallbacks2 instanceof LifecycleOwner) {
                ((LifecycleOwner) componentCallbacks2).getLifecycle().addObserver(new LifecycleEventObserver() { // from class: com.huawei.appgallery.agd.agdpro.api.AdsContext.LifecycleRunnable.1
                    @Override // androidx.lifecycle.LifecycleEventObserver
                    public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
                        if (lifecycleOwner.getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) {
                            Iterator<ITemplateAd> iterator2 = LifecycleRunnable.this.f27226b.iterator2();
                            while (iterator2.hasNext()) {
                                iterator2.next().destroy();
                            }
                            lifecycleOwner.getLifecycle().removeObserver(this);
                        }
                    }
                });
            }
        }
    }

    public AdsContext(ComponentActivity componentActivity) {
        Objects.requireNonNull(componentActivity, "can not create AdsContext as activity null");
        this.f27220a = new WeakReference<>(componentActivity);
    }

    public final void a(final AdSlot adSlot, final int i10, final ICardAd.LoadListener loadListener) {
        if (loadListener != null && adSlot != null) {
            if (!AgdAdApi.isInitSuccess()) {
                e.f48945d.e("AdsContext", "not init yet");
                loadListener.onError(2001, "not init yet");
                return;
            } else {
                if (TextUtils.isEmpty(adSlot.getSlotId())) {
                    e.f48945d.e("AdsContext", "param invalid, slotId empty");
                    String slotId = adSlot.getSlotId();
                    if (AgdAdApi.isInitSuccess()) {
                        MaintBi.reportMediaRequestAd(2002, "param invalid, slotId empty", 0L, slotId);
                    }
                    loadListener.onError(2002, "param invalid, slotId empty");
                    return;
                }
                d dVar = new d(adSlot, new d.a() { // from class: com.huawei.appgallery.agd.agdpro.api.AdsContext.1
                    @Override // e9.d.a
                    public void onFail(int i11, String str) {
                        loadListener.onError(i11, str);
                    }

                    @Override // e9.d.a
                    public void onLoadSuccess(@NonNull List<JSONArray> list) {
                        int i11 = i10;
                        if (i11 == 5) {
                            i iVar = new i(adSlot, list.get(0));
                            e.f48945d.d("AdsContext", "load interstitialAd ad success add ad");
                            AgdAdManager.addAd(iVar);
                            ((InterstitialLoadListener) loadListener).onAdLoad(iVar);
                            return;
                        }
                        if (i11 != 6) {
                            ArrayList arrayList = new ArrayList();
                            Iterator<JSONArray> iterator2 = list.iterator2();
                            while (iterator2.hasNext()) {
                                l lVar = new l(adSlot, iterator2.next(), AdsContext.this, i10);
                                arrayList.add(lVar);
                                AgdAdManager.addAd(lVar);
                            }
                            e.f48945d.d("AdsContext", "load templateAd ad success add ad");
                            ComponentActivity componentActivity = AdsContext.this.f27220a.get();
                            if (componentActivity != null) {
                                componentActivity.runOnUiThread(new LifecycleRunnable(componentActivity, arrayList));
                            }
                            ((TemplateLoadListener) loadListener).onAdLoad(arrayList);
                            return;
                        }
                        e.f48945d.d("AdsContext", "load reward ad success add ad");
                        AgdRewardAd agdRewardAd = new AgdRewardAd(adSlot, list.get(0));
                        ((RewardLoadListener) loadListener).onSuccess(agdRewardAd);
                        AgdAdManager.addAd(agdRewardAd);
                    }
                }, this, i10);
                CoreApi.queryCardDataV2(dVar.f48942a, dVar.f48944c, new c(dVar));
                return;
            }
        }
        throw new NullPointerException("param invalid, " + (adSlot == null ? "adSlot" : "loadListener") + " is null");
    }

    public Activity getActivity() {
        return this.f27220a.get();
    }

    public void loadAppAds(AdSlot adSlot, TemplateLoadListener templateLoadListener) {
        e.f48945d.i("AdsContext", "loadAppAds start");
        a(adSlot, 1, templateLoadListener);
    }

    public void loadBannerAds(AdSlot adSlot, TemplateLoadListener templateLoadListener) {
        e.f48945d.i("AdsContext", "loadBannerAds start");
        a(adSlot, 2, templateLoadListener);
    }

    public void loadFeedAds(AdSlot adSlot, TemplateLoadListener templateLoadListener) {
        e.f48945d.i("AdsContext", "loadFeedAds start");
        a(adSlot, 0, templateLoadListener);
    }

    public void loadInterstitialAd(AdSlot adSlot, InterstitialLoadListener interstitialLoadListener) {
        e.f48945d.i("AdsContext", "load interstitial ad start");
        a(adSlot, 5, interstitialLoadListener);
    }

    public void loadRewardVideoAd(AdSlot adSlot, RewardLoadListener rewardLoadListener) {
        a(adSlot, 6, rewardLoadListener);
    }

    public void loadSplashAds(AdSlot adSlot, TemplateLoadListener templateLoadListener) {
        e.f48945d.i("AdsContext", "loadSplashAds start");
        a(adSlot, 4, templateLoadListener);
    }

    public void loadVideoFeedAds(AdSlot adSlot, TemplateLoadListener templateLoadListener) {
        e.f48945d.i("AdsContext", "loadVideoFeedAds start");
        a(adSlot, 3, templateLoadListener);
    }
}
