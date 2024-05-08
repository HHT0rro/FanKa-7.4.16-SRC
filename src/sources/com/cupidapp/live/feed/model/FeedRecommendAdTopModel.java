package com.cupidapp.live.feed.model;

import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FeedModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FeedRecommendAdTopModel {

    @Nullable
    private final List<FeedTabModel> tabList;

    @Nullable
    private final TopShowGuideModel topShowGuide;

    public FeedRecommendAdTopModel(@Nullable List<FeedTabModel> list, @Nullable TopShowGuideModel topShowGuideModel) {
        this.tabList = list;
        this.topShowGuide = topShowGuideModel;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FeedRecommendAdTopModel copy$default(FeedRecommendAdTopModel feedRecommendAdTopModel, List list, TopShowGuideModel topShowGuideModel, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = feedRecommendAdTopModel.tabList;
        }
        if ((i10 & 2) != 0) {
            topShowGuideModel = feedRecommendAdTopModel.topShowGuide;
        }
        return feedRecommendAdTopModel.copy(list, topShowGuideModel);
    }

    @Nullable
    public final List<FeedTabModel> component1() {
        return this.tabList;
    }

    @Nullable
    public final TopShowGuideModel component2() {
        return this.topShowGuide;
    }

    @NotNull
    public final FeedRecommendAdTopModel copy(@Nullable List<FeedTabModel> list, @Nullable TopShowGuideModel topShowGuideModel) {
        return new FeedRecommendAdTopModel(list, topShowGuideModel);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FeedRecommendAdTopModel)) {
            return false;
        }
        FeedRecommendAdTopModel feedRecommendAdTopModel = (FeedRecommendAdTopModel) obj;
        return s.d(this.tabList, feedRecommendAdTopModel.tabList) && s.d(this.topShowGuide, feedRecommendAdTopModel.topShowGuide);
    }

    @Nullable
    public final List<FeedTabModel> getTabList() {
        return this.tabList;
    }

    @Nullable
    public final TopShowGuideModel getTopShowGuide() {
        return this.topShowGuide;
    }

    public int hashCode() {
        List<FeedTabModel> list = this.tabList;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        TopShowGuideModel topShowGuideModel = this.topShowGuide;
        return hashCode + (topShowGuideModel != null ? topShowGuideModel.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "FeedRecommendAdTopModel(tabList=" + ((Object) this.tabList) + ", topShowGuide=" + ((Object) this.topShowGuide) + ")";
    }
}
