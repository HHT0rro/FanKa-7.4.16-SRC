package com.huawei.appgallery.agd.agdpro.impl.reward;

import android.app.Activity;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.appgallery.agd.agdpro.api.IRewardVideoAd;
import com.huawei.appgallery.agd.agdpro.impl.page.RewardBaseActivity;
import com.huawei.appgallery.agd.core.api.AdSlot;
import com.huawei.appgallery.agd.core.impl.AgdAdManager;
import com.huawei.appgallery.agd.core.impl.IAgdAd;
import com.huawei.appgallery.agd.core.impl.report.MaintBi;
import com.huawei.appgallery.agd.core.impl.report.OperationBi;
import e9.a;
import e9.b;
import e9.e;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class AgdRewardAd extends b implements IRewardVideoAd {

    /* renamed from: k, reason: collision with root package name */
    public static final AtomicInteger f27247k = new AtomicInteger(0);

    /* renamed from: d, reason: collision with root package name */
    public final String f27248d;

    /* renamed from: e, reason: collision with root package name */
    public final AdSlot f27249e;

    /* renamed from: f, reason: collision with root package name */
    public IRewardVideoAd.InteractionListener f27250f;

    /* renamed from: g, reason: collision with root package name */
    public final RewardController f27251g;

    /* renamed from: h, reason: collision with root package name */
    public final JSONArray f27252h;

    /* renamed from: i, reason: collision with root package name */
    public long f27253i;

    /* renamed from: j, reason: collision with root package name */
    public volatile boolean f27254j = false;

    public AgdRewardAd(@NonNull AdSlot adSlot, @NonNull JSONArray jSONArray) {
        StringBuilder b4 = a.b("AgdRewardAd-");
        b4.append(adSlot.getSlotId());
        b4.append("-");
        b4.append(f27247k.incrementAndGet());
        this.f27248d = b4.toString();
        this.f27252h = jSONArray;
        this.f27249e = adSlot;
        this.f27251g = new RewardController(this, jSONArray);
    }

    @Nullable
    public static AgdRewardAd e(String str) {
        IAgdAd ad2 = AgdAdManager.getAd(str);
        if (ad2 instanceof AgdRewardAd) {
            return (AgdRewardAd) ad2;
        }
        return null;
    }

    @Override // e9.b
    public long c() {
        return this.f27253i;
    }

    public void f(boolean z10, String str) {
        e.f48945d.i("AgdRewardAd", "onParseResult success: " + z10 + ", reason " + str);
        IRewardVideoAd.InteractionListener interactionListener = this.f27250f;
        if (interactionListener != null) {
            if (z10) {
                interactionListener.onAdShow();
                this.f27254j = true;
                MaintBi.reportAdShow(0, System.currentTimeMillis() - this.f27253i, j());
                OperationBi.reportAdCallBackOperate(OperationBi.ACTION_AD_SHOW_SUCCESS, j());
                return;
            }
            interactionListener.onAdShowError(10001);
            MaintBi.reportAdShowError(10001, "", "FLayout error", j());
            OperationBi.reportAdCallBackOperate(OperationBi.ACTION_AD_SHOW_FAILURE, j());
        }
    }

    public IRewardVideoAd.InteractionListener g() {
        return this.f27250f;
    }

    @Override // com.huawei.appgallery.agd.core.impl.IAgdAd
    public AdSlot getAdSlot() {
        return this.f27249e;
    }

    @Override // com.huawei.appgallery.agd.core.impl.IAgdAd
    public String getUniqueId() {
        return this.f27248d;
    }

    public JSONArray h() {
        return this.f27252h;
    }

    public RewardController i() {
        return this.f27251g;
    }

    public String j() {
        AdSlot adSlot = this.f27249e;
        return adSlot == null ? "" : adSlot.getSlotId();
    }

    public boolean k() {
        return this.f27254j;
    }

    @Override // com.huawei.appgallery.agd.agdpro.api.IRewardVideoAd
    public void setInteractionListener(IRewardVideoAd.InteractionListener interactionListener) {
        this.f27250f = interactionListener;
    }

    @Override // com.huawei.appgallery.agd.agdpro.api.IRewardVideoAd
    public void show(Activity activity) {
        this.f27253i = System.currentTimeMillis();
        if (k() && this.f27250f != null) {
            e.f48945d.i("AgdRewardAd", "show with ad expired");
            this.f27250f.onAdExpired();
            MaintBi.reportAdExpired(j());
            return;
        }
        e eVar = e.f48945d;
        eVar.i("AgdRewardAd", "show AGD SDK Ad");
        Intent intent = new Intent(activity, (Class<?>) RewardBaseActivity.class);
        intent.putExtra("ad_id", this.f27248d);
        AdSlot adSlot = this.f27249e;
        if (adSlot != null) {
            intent.putExtra("video_Orientation", adSlot.getOrientation());
        } else {
            eVar.e("AgdRewardAd", "AGD SDK adSlot is empty");
        }
        activity.startActivity(intent);
    }
}
