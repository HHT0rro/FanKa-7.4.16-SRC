package com.kwad.components.ad.reward.model;

import android.content.Intent;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.KSRewardVideoActivityProxy;
import com.kwad.components.core.c.f;
import com.kwad.components.core.internal.api.e;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.core.response.model.AdGlobalConfigInfo;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.t;
import java.io.File;
import java.io.Serializable;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class c {
    private AdInfo mAdInfo;
    private AdResultData mAdResultData;
    private AdTemplate mAdTemplate;
    private JSONObject mReportExtData;
    public int mScreenOrientation;
    private KsVideoPlayConfig mVideoPlayConfig;
    private int rewardType = 1;
    public final boolean gt = com.kwad.components.ad.reward.a.b.gD();

    @Nullable
    public static c a(Intent intent) {
        KsVideoPlayConfig ksVideoPlayConfig;
        if (com.kwad.sdk.core.config.d.CG()) {
            ksVideoPlayConfig = e.b(intent.getStringExtra("key_video_play_config_json"), true);
        } else {
            Serializable serializableExtra = intent.getSerializableExtra("key_video_play_config");
            if (!(serializableExtra instanceof KsVideoPlayConfig)) {
                com.kwad.sdk.core.e.c.e("RewardActivityModel", "data is not instanceof VideoPlayConfigImpl:" + ((Object) serializableExtra));
                return null;
            }
            ksVideoPlayConfig = (KsVideoPlayConfig) serializableExtra;
        }
        int intExtra = intent.getIntExtra(KSRewardVideoActivityProxy.KEY_REWARD_TYPE, 1);
        try {
            AdResultData d10 = f.mE().d(intent.getIntExtra("key_ad_result_cache_idx", 0), true);
            if (d10 == null) {
                return null;
            }
            return a(d10, intExtra, ksVideoPlayConfig);
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(th);
            return null;
        }
    }

    private static boolean c(AdTemplate adTemplate, AdInfo adInfo) {
        if (!com.kwad.sdk.core.config.d.CG() && com.kwad.sdk.core.response.b.e.eg(adTemplate) < 0) {
            File bV = com.kwad.sdk.core.diskcache.b.a.Dc().bV(com.kwad.sdk.core.response.b.a.K(adInfo));
            if (bV == null || !bV.exists()) {
                return false;
            }
        }
        return true;
    }

    public final AdInfo bH() {
        return this.mAdInfo;
    }

    public final boolean bI() {
        return com.kwad.sdk.core.response.b.e.ec(this.mAdTemplate);
    }

    public final AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }

    public final int getScreenOrientation() {
        return this.mScreenOrientation;
    }

    public final boolean hi() {
        return com.kwad.sdk.core.response.b.e.i(getAdTemplate(), com.kwad.components.ad.reward.a.b.k(bH()));
    }

    public final boolean hj() {
        return com.kwad.sdk.core.response.b.e.F(getAdTemplate());
    }

    public final AdResultData hk() {
        return this.mAdResultData;
    }

    public final KsVideoPlayConfig hl() {
        return this.mVideoPlayConfig;
    }

    public final int hm() {
        return this.rewardType;
    }

    public final JSONObject hn() {
        return this.mReportExtData;
    }

    public final AdGlobalConfigInfo ho() {
        AdResultData adResultData = this.mAdResultData;
        if (adResultData != null) {
            return adResultData.adGlobalConfigInfo;
        }
        return null;
    }

    @Nullable
    private static c a(AdResultData adResultData, int i10, KsVideoPlayConfig ksVideoPlayConfig) {
        c cVar = new c();
        AdTemplate n10 = com.kwad.sdk.core.response.b.c.n(adResultData);
        if (n10 == null) {
            com.kwad.sdk.core.e.c.e("RewardActivityModel", "data is null:");
            return null;
        }
        AdInfo dQ = com.kwad.sdk.core.response.b.e.dQ(n10);
        if (!c(n10, dQ)) {
            return null;
        }
        boolean isShowLandscape = ksVideoPlayConfig.isShowLandscape();
        n10.mInitVoiceStatus = ksVideoPlayConfig.isVideoSoundEnable() ? 2 : 1;
        if (!TextUtils.isEmpty(ksVideoPlayConfig.getShowScene())) {
            JSONObject jSONObject = new JSONObject();
            t.putValue(jSONObject, "ext_showscene", ksVideoPlayConfig.getShowScene());
            cVar.mReportExtData = jSONObject;
        }
        cVar.mVideoPlayConfig = ksVideoPlayConfig;
        cVar.mAdResultData = adResultData;
        cVar.mAdTemplate = n10;
        cVar.mAdInfo = dQ;
        cVar.mScreenOrientation = isShowLandscape ? 1 : 0;
        cVar.rewardType = i10;
        return cVar;
    }
}
