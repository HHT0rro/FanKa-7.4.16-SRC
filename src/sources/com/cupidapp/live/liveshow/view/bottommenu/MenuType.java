package com.cupidapp.live.liveshow.view.bottommenu;

import org.jetbrains.annotations.NotNull;

/* compiled from: LiveMoreMenuAdapter.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public enum MenuType {
    MagicRefine("magicRefine"),
    FanClub("FanClub"),
    RedEnvelope("RedEnvelope"),
    Noble("Noble"),
    GiftFragments("GiftFragments"),
    LiveTask("LiveTask"),
    DressUpMall("DressUpMall"),
    MyOutfit("dressUp"),
    Share("Share"),
    Report("Report"),
    GiftEffects("GiftEffects"),
    GiftWall("GiftWall"),
    FollowLive("streamFollow"),
    Mall("Mall"),
    Mirror("Mirror"),
    ChangeCamera("ChangeCamera"),
    Music("Music"),
    Administrator("Administrator"),
    Sticker("Stick");


    @NotNull
    private final String type;

    MenuType(String str) {
        this.type = str;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }
}
