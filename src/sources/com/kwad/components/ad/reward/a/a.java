package com.kwad.components.ad.reward.a;

import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.sdk.core.config.item.d;
import com.kwad.sdk.core.config.item.g;
import com.kwad.sdk.core.config.item.k;
import com.kwad.sdk.core.config.item.p;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class a {
    public static k qt = new k("rewardSkipType", 0);
    public static k qu = new k("rewardActiveAppTaskMinSecond", 15);
    public static k qv = new k("rewardContentDetainType", 0);
    public static d qw = new d("forceGetAudioFocus", false);
    public static p qx = new p("rewardSkipTips", "");
    public static p qy = new p("fullscreenSkipTips", "");
    public static k qz = new k("ecRewardAdOrderSwitch", 0);
    public static k qA = new k("ecRewardAdFanSwitch", 0);
    public static k qB = new k("ecRewardAdKwaishopStyle", 0);
    public static k qC = new k("xdtCouponShowDuration", 3000);
    public static k qD = new k("jinniuCloseDialogStyle", 1);
    public static g qE = new g("interactionTimeInRewardedVideo", 0.0f);
    public static d qF = new d("autoJumpInRewardedVideo", false);
    public static k qG = new k("advanceJumpDirectDeliveryMaxCount", 0);
    public static d qH = new d("advanceJumpDirectDeliverySwitch", false);
    public static k qI = new k("shortVideoFollowRewardPlayStyle", 0);
    public static d qJ = new d("enableRewardLayoutOptimise", false);
    public static d qK = new d("enableFullscreenLayoutOptimise", false);

    @InvokeBy(invokerClass = com.kwad.sdk.core.config.d.class, methodId = "initConfigList")
    public static void init() {
    }
}
