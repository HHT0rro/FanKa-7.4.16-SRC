package com.cupidapp.live.base.sensorslog;

import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: SensorScene.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public enum SensorScene {
    Match("MATCH"),
    Chat("CHAT"),
    Feed("FEED"),
    Live("LIVE"),
    Nearby("NEARBY"),
    Hashtag("HASHTAG"),
    NewFollower("NEW_FOLLOWER"),
    NotificationLike("NOTIFICATION_LIKE"),
    NotificationComment("NOTIFICATION_COMMENT"),
    MatchList("MATCH_LIST"),
    FollowerList("FOLLOWER_LIST"),
    FollowingList("FOLLOWING_LIST"),
    LikedPost("LIKED_FEED"),
    MyVisitors("MY_VISITORS"),
    NewMatchList("NEW_MATCH"),
    PersonalData("PROFILE"),
    RecommendFeed("RECOMMEND_FEED"),
    NearbySameCityRecommend("SAME_CITY_RECOMMEND"),
    NearbyNewFace("NEARBY_NEW_PEOPLE"),
    MapFind("MAP_FIND"),
    Footmark("FOOT_MARK"),
    BlackList("BLACKLIST"),
    DailyHeart("DAILY_HEART"),
    NearbySuperBoost("NEARBY_SUPER_BOOST"),
    SuperBoost("SUPER_BOOST"),
    GroupChat("GROUP_CHAT"),
    FeedRainbowRecommend("FEED_RAINBOW_RECOMMEND"),
    RainbowRecommend("RAINBOW_A_PLUS_RECOMMEND"),
    AI_FACE_IDENTITY("AI_FACE_IDENTITY"),
    CONSULT_LIVE("CONSULT_LIVE"),
    NEARBY_MATCH("NEARBY_MATCH"),
    DynScene(GrsBaseInfo.CountryCodeSource.UNKNOWN);


    @NotNull
    private String value;

    SensorScene(String str) {
        this.value = str;
    }

    @NotNull
    public final String getValue() {
        return this.value;
    }

    public final void setValue(@NotNull String str) {
        s.i(str, "<set-?>");
        this.value = str;
    }
}
