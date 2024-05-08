package com.kwad.components.ad.reward.e;

import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsRewardVideoAd;
import java.util.HashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class f {
    private static final HashMap<String, f> ru = new HashMap<>();
    private KsRewardVideoAd.RewardAdInteractionListener mInteractionListener;
    private com.kwad.components.core.i.d oy;
    private KsRewardVideoAd.RewardAdInteractionListener rv;

    @Nullable
    private static f F(String str) {
        return ru.get(str);
    }

    public static KsRewardVideoAd.RewardAdInteractionListener G(String str) {
        f F = F(str);
        if (F != null) {
            return F.rv;
        }
        return null;
    }

    public static void H(String str) {
        f F = F(str);
        if (F != null) {
            F.rv = F.mInteractionListener;
        }
    }

    public static com.kwad.components.core.i.d I(String str) {
        f F = F(str);
        if (F != null) {
            return F.oy;
        }
        return null;
    }

    public static void J(String str) {
        f F = F(str);
        if (F != null) {
            F.destroy();
            ru.put(str, null);
        }
    }

    public static void a(String str, KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener, com.kwad.components.core.i.d dVar) {
        f fVar = new f();
        fVar.mInteractionListener = rewardAdInteractionListener;
        fVar.oy = dVar;
        fVar.rv = rewardAdInteractionListener;
        ru.put(str, fVar);
    }

    private void destroy() {
        this.mInteractionListener = null;
        this.rv = null;
        com.kwad.components.core.i.d dVar = this.oy;
        if (dVar != null) {
            dVar.destroy();
            this.oy = null;
        }
    }
}
