package com.cupidapp.live.feed;

import kotlin.d;
import org.jetbrains.annotations.NotNull;

/* compiled from: FeedType.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public enum FeedSensorType {
    ImagePost("图片"),
    MultipleImagePost("多图"),
    VideoPost("视频"),
    ShowCase("置顶Feed"),
    RecommendFeed("推荐动态入口"),
    ProgramAd("信息流广告"),
    SponsorPost("赞助Post"),
    AdTagPost("adTagPost");


    @NotNull
    private final String value;

    FeedSensorType(String str) {
        this.value = str;
    }

    @NotNull
    public final String getValue() {
        return this.value;
    }
}
