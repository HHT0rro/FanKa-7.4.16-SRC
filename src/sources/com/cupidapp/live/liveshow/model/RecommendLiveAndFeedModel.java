package com.cupidapp.live.liveshow.model;

import com.cupidapp.live.feed.model.FeedResultModel;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveListResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class RecommendLiveAndFeedModel {

    @Nullable
    private final FeedResultModel feedResultModel;

    @Nullable
    private final String nextCursorId;

    @Nullable
    private final FeedTopLiveModel recommendLive;

    public RecommendLiveAndFeedModel(@Nullable FeedTopLiveModel feedTopLiveModel, @Nullable FeedResultModel feedResultModel, @Nullable String str) {
        this.recommendLive = feedTopLiveModel;
        this.feedResultModel = feedResultModel;
        this.nextCursorId = str;
    }

    public static /* synthetic */ RecommendLiveAndFeedModel copy$default(RecommendLiveAndFeedModel recommendLiveAndFeedModel, FeedTopLiveModel feedTopLiveModel, FeedResultModel feedResultModel, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            feedTopLiveModel = recommendLiveAndFeedModel.recommendLive;
        }
        if ((i10 & 2) != 0) {
            feedResultModel = recommendLiveAndFeedModel.feedResultModel;
        }
        if ((i10 & 4) != 0) {
            str = recommendLiveAndFeedModel.nextCursorId;
        }
        return recommendLiveAndFeedModel.copy(feedTopLiveModel, feedResultModel, str);
    }

    @Nullable
    public final FeedTopLiveModel component1() {
        return this.recommendLive;
    }

    @Nullable
    public final FeedResultModel component2() {
        return this.feedResultModel;
    }

    @Nullable
    public final String component3() {
        return this.nextCursorId;
    }

    @NotNull
    public final RecommendLiveAndFeedModel copy(@Nullable FeedTopLiveModel feedTopLiveModel, @Nullable FeedResultModel feedResultModel, @Nullable String str) {
        return new RecommendLiveAndFeedModel(feedTopLiveModel, feedResultModel, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RecommendLiveAndFeedModel)) {
            return false;
        }
        RecommendLiveAndFeedModel recommendLiveAndFeedModel = (RecommendLiveAndFeedModel) obj;
        return s.d(this.recommendLive, recommendLiveAndFeedModel.recommendLive) && s.d(this.feedResultModel, recommendLiveAndFeedModel.feedResultModel) && s.d(this.nextCursorId, recommendLiveAndFeedModel.nextCursorId);
    }

    @Nullable
    public final FeedResultModel getFeedResultModel() {
        return this.feedResultModel;
    }

    @Nullable
    public final String getNextCursorId() {
        return this.nextCursorId;
    }

    @Nullable
    public final FeedTopLiveModel getRecommendLive() {
        return this.recommendLive;
    }

    public int hashCode() {
        FeedTopLiveModel feedTopLiveModel = this.recommendLive;
        int hashCode = (feedTopLiveModel == null ? 0 : feedTopLiveModel.hashCode()) * 31;
        FeedResultModel feedResultModel = this.feedResultModel;
        int hashCode2 = (hashCode + (feedResultModel == null ? 0 : feedResultModel.hashCode())) * 31;
        String str = this.nextCursorId;
        return hashCode2 + (str != null ? str.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        FeedTopLiveModel feedTopLiveModel = this.recommendLive;
        FeedResultModel feedResultModel = this.feedResultModel;
        return "RecommendLiveAndFeedModel(recommendLive=" + ((Object) feedTopLiveModel) + ", feedResultModel=" + ((Object) feedResultModel) + ", nextCursorId=" + this.nextCursorId + ")";
    }
}
