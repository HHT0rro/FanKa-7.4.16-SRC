package com.kwad.sdk.core.adlog;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.huawei.hms.ads.hs;
import com.huawei.openalliance.ad.download.app.d;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.track.AdTrackLog;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.h;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.t;
import com.qq.e.comm.pi.IBidding;
import java.util.Iterator;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a extends com.kwad.sdk.core.network.b {
    public int apa;

    @NonNull
    private final com.kwad.sdk.core.adlog.c.a apb;
    private final AdTemplate mAdTemplate;

    @KsJson
    /* renamed from: com.kwad.sdk.core.adlog.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class C0516a extends com.kwad.sdk.core.response.a.a {
        public String apd;
        public int ape;
        public int apf;
        public int apg;
        public JSONObject aph;
        public int api;
        public int apj;

        @Nullable
        public AdTrackLog apk;
        public String templateId;
        public int apc = -1;
        public long duration = -1;
        public int showLiveStatus = -1;
        public int showLiveStyle = -1;

        public final AdTrackLog a(AdTemplate adTemplate, String str, String str2, com.kwad.sdk.g.a<AdTrackLog> aVar) {
            h hVar;
            if (adTemplate == null || (hVar = (h) ServiceProvider.get(h.class)) == null || !hVar.yT()) {
                return null;
            }
            AdTrackLog adTrackLog = new AdTrackLog(str, str2);
            this.apk = adTrackLog;
            adTrackLog.bindABParams(adTemplate);
            if (aVar != null) {
                aVar.accept(this.apk);
            }
            return this.apk;
        }

        @Override // com.kwad.sdk.core.response.a.a
        public void afterToJson(JSONObject jSONObject) {
            super.afterToJson(jSONObject);
            int i10 = this.apc;
            if (i10 != -1) {
                t.putValue(jSONObject, "shield_reason", i10);
            }
            long j10 = this.duration;
            if (j10 != -1) {
                t.putValue(jSONObject, "duration", j10);
            }
            int i11 = this.showLiveStatus;
            if (i11 != -1) {
                t.putValue(jSONObject, "show_live_status", i11);
            }
            int i12 = this.showLiveStyle;
            if (i12 != -1) {
                t.putValue(jSONObject, "show_live_style", i12);
            }
            AdTrackLog adTrackLog = this.apk;
            if (adTrackLog != null) {
                t.putValue(jSONObject, "ad_track_log", adTrackLog.toJson().toString());
            }
            JSONObject jSONObject2 = this.aph;
            if (jSONObject2 != null) {
                try {
                    Iterator<String> keys = jSONObject2.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        jSONObject.putOpt(next, this.aph.get(next));
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public a(@NonNull com.kwad.sdk.core.adlog.c.a aVar) {
        this.apb = aVar;
        this.mAdTemplate = aVar.adTemplate;
        this.apa = aVar.aoM;
    }

    private void Be() {
        JSONObject jSONObject = this.apb.apH;
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        t.putValue(jSONObject, "clientTimestamp", System.currentTimeMillis());
        putBody("extData", jSONObject.toString());
    }

    private void a(String str, @Nullable com.kwad.sdk.core.adlog.c.a aVar) {
        if (aVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        int i10 = aVar.aqj;
        if (i10 >= 0) {
            putBody("adOrder", i10);
        }
        int i11 = aVar.KF;
        if (i11 >= 0) {
            putBody("adInterstitialSource", i11);
        }
        if (!TextUtils.isEmpty(aVar.apM)) {
            putBody("adRenderArea", aVar.apM);
        }
        putBody("adxResult", aVar.adxResult);
        int i12 = aVar.aqn;
        if (i12 != 0) {
            putBody("fingerSwipeType", i12);
        }
        int i13 = aVar.aqo;
        if (i13 != 0) {
            putBody("fingerSwipeDistance", i13);
        }
        int i14 = aVar.aqg;
        if (i14 != -1) {
            putBody("installStatus", i14);
        }
        C0516a c0516a = aVar.KH;
        if (c0516a != null) {
            putBody("clientExtData", c0516a.toJson().toString());
        }
        String str2 = aVar.aqq;
        if (str2 != null) {
            putBody("clientPkFailAdInfo", str2);
        }
        int i15 = aVar.KJ;
        if (i15 != -1) {
            putBody("triggerType", i15);
        }
        int i16 = aVar.KI;
        if (i16 != 0) {
            putBody("photoSizeStyle", i16);
        }
    }

    private void b(String str, @Nullable com.kwad.sdk.core.adlog.c.a aVar) {
        if (aVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        int i10 = aVar.kl;
        if (i10 != 0) {
            putBody("itemClickType", i10);
        }
        if (!TextUtils.isEmpty(aVar.KG)) {
            putBody("payload", aVar.KG);
        }
        int i11 = aVar.apY;
        if (i11 != 0) {
            putBody("adAggPageSource", i11);
        }
        int i12 = aVar.aqj;
        if (i12 >= 0) {
            putBody("adOrder", i12);
        }
        int i13 = aVar.KF;
        if (i13 >= 0) {
            putBody("adInterstitialSource", i13);
        }
        int i14 = aVar.KJ;
        if (i14 != -1) {
            putBody("triggerType", i14);
        }
        int i15 = aVar.aqp;
        if (i15 != 0) {
            putBody("cardCloseType", i15);
        }
        putBody("adxResult", aVar.adxResult);
        double d10 = aVar.ko;
        if (d10 > ShadowDrawableWrapper.COS_45) {
            putBody("splashShakeAcceleration", d10);
        }
        if (!TextUtils.isEmpty(aVar.aqk)) {
            putBody("splashInteractionRotateAngle", aVar.aqk);
        }
        int i16 = aVar.aqn;
        if (i16 != 0) {
            putBody("fingerSwipeType", i16);
        }
        int i17 = aVar.aqo;
        if (i17 != 0) {
            putBody("fingerSwipeDistance", i17);
        }
        long j10 = aVar.vz;
        if (j10 > 0) {
            putBody("playedDuration", j10);
        }
        int i18 = aVar.aqi;
        if (i18 > 0) {
            putBody("playedRate", i18);
        }
        String str2 = aVar.aqq;
        if (str2 != null) {
            putBody("clientPkFailAdInfo", str2);
        }
        int i19 = aVar.apQ;
        if (i19 != -1) {
            putBody("retainCodeType", i19);
        }
        C0516a c0516a = aVar.KH;
        if (c0516a != null) {
            putBody("clientExtData", c0516a.toJson().toString());
        }
        int i20 = aVar.KI;
        if (i20 != 0) {
            putBody("photoSizeStyle", i20);
        }
    }

    private void c(String str, @Nullable com.kwad.sdk.core.adlog.c.a aVar) {
        if (aVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        int i10 = aVar.apK;
        if (i10 != 0) {
            putBody("itemCloseType", i10);
        }
        int i11 = aVar.apI;
        if (i11 > 0) {
            putBody("photoPlaySecond", i11);
        }
        int i12 = aVar.apJ;
        if (i12 != 0) {
            putBody("awardReceiveStage", i12);
        }
        int i13 = aVar.apL;
        if (i13 != 0) {
            putBody("elementType", i13);
        }
        if (!TextUtils.isEmpty(aVar.KG)) {
            putBody("payload", aVar.KG);
        }
        C0516a c0516a = aVar.KH;
        if (c0516a != null) {
            putBody("clientExtData", c0516a.toJson().toString());
        }
        int i14 = aVar.apR;
        if (i14 > 0) {
            putBody("deeplinkType", i14);
        }
        if (!TextUtils.isEmpty(aVar.apS)) {
            putBody("deeplinkAppName", aVar.apS);
        }
        int i15 = aVar.apT;
        if (i15 != 0) {
            putBody("deeplinkFailedReason", i15);
        }
        int i16 = aVar.downloadSource;
        if (i16 > 0) {
            putBody(hs.I, i16);
        }
        int i17 = aVar.aqp;
        if (i17 != 0) {
            putBody("cardCloseType", i17);
        }
        int i18 = aVar.apU;
        if (i18 > 0) {
            putBody("isPackageChanged", i18);
        }
        putBody("installedFrom", aVar.apV);
        putBody("isChangedEndcard", aVar.apX);
        int i19 = aVar.apY;
        if (i19 != 0) {
            putBody("adAggPageSource", i19);
        }
        String str2 = aVar.apW;
        if (str2 != null) {
            putBody("downloadFailedReason", str2);
        }
        if (!bg.isNullString(aVar.aqa)) {
            putBody("installedPackageName", aVar.aqa);
        }
        if (!bg.isNullString(aVar.apZ)) {
            putBody("serverPackageName", aVar.apZ);
        }
        int i20 = aVar.aqc;
        if (i20 > 0) {
            putBody("closeButtonClickTime", i20);
        }
        int i21 = aVar.aqb;
        if (i21 > 0) {
            putBody("closeButtonImpressionTime", i21);
        }
        int i22 = aVar.downloadStatus;
        if (i22 >= 0) {
            putBody(d.C, i22);
        }
        long j10 = aVar.aqd;
        if (j10 > 0) {
            putBody("landingPageLoadedDuration", j10);
        }
        long j11 = aVar.Li;
        if (j11 > 0) {
            putBody("leaveTime", j11);
        }
        long j12 = aVar.aqe;
        if (j12 > 0) {
            putBody("adItemClickBackDuration", j12);
        }
        int i23 = aVar.apQ;
        if (i23 != -1) {
            putBody("retainCodeType", i23);
        }
        long j13 = aVar.apN;
        if (j13 > -1) {
            putBody(IBidding.HIGHEST_LOSS_PRICE, j13);
        }
        int i24 = aVar.apO;
        if (i24 >= 0) {
            putBody("impFailReason", i24);
        }
        long j14 = aVar.apP;
        if (j14 > -1) {
            putBody("winEcpm", j14);
        }
        int i25 = aVar.adnType;
        if (i25 > 0) {
            putBody("adnType", i25);
        }
        if (!TextUtils.isEmpty(aVar.adnName)) {
            putBody(MediationConstant.KEY_ADN_NAME, aVar.adnName);
        }
        putBody("downloadCardType", aVar.aqh);
        putBody("landingPageType", aVar.Om);
        int i26 = aVar.KF;
        if (i26 >= 0) {
            putBody("adInterstitialSource", i26);
        }
        int i27 = aVar.aql;
        if (i27 > 0) {
            putBody("downloadInstallType", i27);
        }
        int i28 = aVar.aqn;
        if (i28 != 0) {
            putBody("fingerSwipeType", i28);
        }
        int i29 = aVar.aqo;
        if (i29 != 0) {
            putBody("fingerSwipeDistance", i29);
        }
        int i30 = aVar.aqm;
        if (i30 > 0) {
            putBody("businessSceneType", i30);
        }
        long j15 = aVar.vz;
        if (j15 > 0) {
            putBody("playedDuration", j15);
        }
        int i31 = aVar.aqi;
        if (i31 > 0) {
            putBody("playedRate", i31);
        }
        int i32 = aVar.aqf;
        if (i32 != -1) {
            putBody("appStorePageType", i32);
        }
        int i33 = aVar.KJ;
        if (i33 != -1) {
            putBody("triggerType", i33);
        }
        int i34 = aVar.KI;
        if (i34 != 0) {
            putBody("photoSizeStyle", i34);
        }
    }

    @Override // com.kwad.sdk.core.network.b
    public final void buildBaseBody() {
    }

    @Override // com.kwad.sdk.core.network.b
    public final void buildBaseHeader() {
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final JSONObject getBody() {
        return this.mBodyParams;
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final String getUrl() {
        String replaceFirst;
        String replaceFirst2;
        Context context = ServiceProvider.getContext();
        AdInfo dQ = e.dQ(this.mAdTemplate);
        int i10 = this.apa;
        if (i10 == 1) {
            String str = dQ.adBaseInfo.showUrl;
            if (this.mAdTemplate.mBidEcpm == 0 && ((h) ServiceProvider.get(h.class)).yI()) {
                replaceFirst2 = str.replaceFirst("__PR__", String.valueOf(com.kwad.sdk.core.response.b.a.aR(e.dQ(this.mAdTemplate))));
            } else {
                replaceFirst2 = str.replaceFirst("__PR__", String.valueOf(this.mAdTemplate.mBidEcpm));
            }
            replaceFirst = replaceFirst2.replaceFirst("__TYPE__", String.valueOf(this.mAdTemplate.mVideoPlayerStatus.mVideoPlayerType)).replaceFirst("__BEHAVIOR__", String.valueOf(this.mAdTemplate.mVideoPlayerStatus.mVideoPlayerBehavior));
            a(replaceFirst, this.apb);
            a(replaceFirst, this.mAdTemplate, this.apb);
        } else if (i10 == 2) {
            replaceFirst = ac.am(context, ac.a(dQ.adBaseInfo.clickUrl, this.apb.kn)).replaceFirst("__PR__", String.valueOf(this.mAdTemplate.mBidEcpm)).replaceFirst("__TYPE__", String.valueOf(this.mAdTemplate.mVideoPlayerStatus.mVideoPlayerType)).replaceFirst("__BEHAVIOR__", String.valueOf(this.mAdTemplate.mVideoPlayerStatus.mVideoPlayerBehavior));
            b(replaceFirst, this.apb);
            a(replaceFirst, this.mAdTemplate, this.apb);
        } else {
            replaceFirst = dQ.adBaseInfo.convUrl.replaceFirst("__ACTION__", String.valueOf(i10)).replaceFirst("__PR__", String.valueOf(this.mAdTemplate.mBidEcpm)).replaceFirst("__TYPE__", String.valueOf(this.mAdTemplate.mVideoPlayerStatus.mVideoPlayerType)).replaceFirst("__BEHAVIOR__", String.valueOf(this.mAdTemplate.mVideoPlayerStatus.mVideoPlayerBehavior));
            c(replaceFirst, this.apb);
        }
        Be();
        return replaceFirst;
    }

    private void a(String str, AdTemplate adTemplate, @Nullable com.kwad.sdk.core.adlog.c.a aVar) {
        if (TextUtils.isEmpty(str) || adTemplate == null) {
            return;
        }
        int i10 = adTemplate.mInitVoiceStatus;
        if (i10 != 0) {
            putBody("initVoiceStatus", i10);
        }
        if (this.mAdTemplate.mBidEcpm == 0) {
            putBody("ecpmType", 2);
        } else {
            putBody("ecpmType", 1);
        }
        if (aVar == null) {
            return;
        }
        int i11 = aVar.apY;
        if (i11 != 0) {
            putBody("adAggPageSource", i11);
        }
        if (TextUtils.isEmpty(aVar.KG)) {
            return;
        }
        putBody("payload", aVar.KG);
    }
}
