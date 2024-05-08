package com.cupidapp.live.base.network.model;

import com.baidu.mobads.sdk.api.IAdInterListener;
import kotlin.d;
import org.jetbrains.annotations.NotNull;

/* compiled from: ProfileResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public enum FollowPrefer {
    Feed(IAdInterListener.AdProdType.PRODUCT_FEEDS),
    PostStream("postStream"),
    FeedDetail("feedDetail"),
    LiveShow("liveShow"),
    MiniProfile("miniProfile"),
    Aloha("aloha"),
    Nearby("nearby"),
    DailyLike("dailyLike"),
    ChatDetail("chatDetail"),
    AlohaNotify("alohaNotify"),
    PostLimitRefer("postLimitDetail"),
    PostLimitViewerList("postLimitViewerList"),
    PostSpecialExposure("postSpecialExposure"),
    NearbySpecialExposure("nearbySpecialExposure"),
    AiGraph("aiGraph"),
    MultiPk("multiPk");


    @NotNull
    private final String value;

    FollowPrefer(String str) {
        this.value = str;
    }

    @NotNull
    public final String getValue() {
        return this.value;
    }
}
