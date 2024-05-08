package com.cupidapp.live.feed.holder;

import com.cupidapp.live.feed.adapter.FeedRainbowRecommendItemModel;
import java.util.List;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FeedRainbowRecommendViewHolder.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FeedRainbowRecommendModel {

    @NotNull
    private final List<FeedRainbowRecommendItemModel> recommendList;

    public FeedRainbowRecommendModel(@NotNull List<FeedRainbowRecommendItemModel> recommendList) {
        s.i(recommendList, "recommendList");
        this.recommendList = recommendList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FeedRainbowRecommendModel copy$default(FeedRainbowRecommendModel feedRainbowRecommendModel, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = feedRainbowRecommendModel.recommendList;
        }
        return feedRainbowRecommendModel.copy(list);
    }

    @NotNull
    public final List<FeedRainbowRecommendItemModel> component1() {
        return this.recommendList;
    }

    @NotNull
    public final FeedRainbowRecommendModel copy(@NotNull List<FeedRainbowRecommendItemModel> recommendList) {
        s.i(recommendList, "recommendList");
        return new FeedRainbowRecommendModel(recommendList);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof FeedRainbowRecommendModel) && s.d(this.recommendList, ((FeedRainbowRecommendModel) obj).recommendList);
    }

    @NotNull
    public final List<FeedRainbowRecommendItemModel> getRecommendList() {
        return this.recommendList;
    }

    public int hashCode() {
        return this.recommendList.hashCode();
    }

    @NotNull
    public String toString() {
        return "FeedRainbowRecommendModel(recommendList=" + ((Object) this.recommendList) + ")";
    }
}
