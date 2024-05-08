package com.cupidapp.live.appdialog.model;

import kotlin.d;
import org.jetbrains.annotations.NotNull;

/* compiled from: AppDialogModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public enum WindowType {
    AppRate("AppRate"),
    FakeAvatar("FakeAvatar"),
    Web("Web"),
    Agreement("Agreement"),
    Birthday("Birthday"),
    TestVersion("TestVersion"),
    PushPriWindow("PushPriWindow"),
    ForceUpdate("ForceUpdate"),
    PrivacyExpire("PrivacyExpire"),
    AvatarVideo("AvatarVideo"),
    SecretLounge("SecretLounge"),
    ActiveMatchFilterGuide("ActiveFilterRecommendGuide"),
    GeneralMatchFilterGuide("FilterRecommendGuide"),
    MatchFilterGuide("MatchFilterGuide"),
    CustomIcon("CustomIcon"),
    LiveTabTextBubble("LiveTabTextBubble"),
    DailyHeart("DailyLike"),
    Exposure("SuperBoost"),
    CustomProtocol("CustomProtocol"),
    UserPraiseGuide("UserPraiseGuide"),
    TeenMode("TeenMode"),
    SsvipMatchGuide("SsvipMatchGuide"),
    SsvipMatchAvatarFrameGuide("SsvipMatchAvatarFrameGuide"),
    TravelBoostGuide("TravelBoostGuide"),
    AiGraphGuide("AiGraphGuide"),
    VasExpireTextRemind("VasExpireTextRemind"),
    NewUserVasMarketing("NewUserVasMarketing"),
    NearbyMapRcmdV2("NearbyMapRcmdV2");


    @NotNull
    private final String type;

    WindowType(String str) {
        this.type = str;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }
}
