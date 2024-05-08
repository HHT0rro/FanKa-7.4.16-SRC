package com.cupidapp.live.feed.model;

import com.cupidapp.live.feed.FeedSensorType;
import java.io.Serializable;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FeedResultModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FeedRecommendListModel implements Serializable, IBaseFeedModel {

    @NotNull
    private final List<FeedRecommendResult> list;

    public FeedRecommendListModel(@NotNull List<FeedRecommendResult> list) {
        s.i(list, "list");
        this.list = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FeedRecommendListModel copy$default(FeedRecommendListModel feedRecommendListModel, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = feedRecommendListModel.list;
        }
        return feedRecommendListModel.copy(list);
    }

    @NotNull
    public final List<FeedRecommendResult> component1() {
        return this.list;
    }

    @NotNull
    public final FeedRecommendListModel copy(@NotNull List<FeedRecommendResult> list) {
        s.i(list, "list");
        return new FeedRecommendListModel(list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof FeedRecommendListModel) && s.d(this.list, ((FeedRecommendListModel) obj).list);
    }

    @NotNull
    public final List<FeedRecommendResult> getList() {
        return this.list;
    }

    @Override // com.cupidapp.live.feed.model.IBaseFeedModel
    @NotNull
    public String getSensorFeedType() {
        return FeedSensorType.RecommendFeed.getValue();
    }

    public int hashCode() {
        return this.list.hashCode();
    }

    @NotNull
    public String toString() {
        return "FeedRecommendListModel(list=" + ((Object) this.list) + ")";
    }
}
