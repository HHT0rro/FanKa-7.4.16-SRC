package com.cupidapp.live.feed;

import kotlin.d;
import org.jetbrains.annotations.NotNull;

/* compiled from: FeedType.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public enum FeedType {
    ImagePost("ImagePost"),
    VideoPost("VideoPost"),
    ShowCase("ShowCase"),
    RecommendFeed("Recommend"),
    ProgramAd("ProgramAd"),
    PostLimit("PostLimitList"),
    FeedAlohaGuide("FeedAlohaGuide"),
    MatchNearByGuide("MatchNearByGuide"),
    PostSpecialExposure("PostSpecialExposure");


    @NotNull
    private final String value;

    FeedType(String str) {
        this.value = str;
    }

    @NotNull
    public final String getValue() {
        return this.value;
    }
}
