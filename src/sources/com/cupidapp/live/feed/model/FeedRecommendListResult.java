package com.cupidapp.live.feed.model;

import com.cupidapp.live.feed.adapter.FeedClassifyModel;
import com.cupidapp.live.liveshow.model.AdModel;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FeedModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FeedRecommendListResult {

    @Nullable
    private final List<AdModel> adList;

    @Nullable
    private final List<FeedRecommendResult> list;

    @Nullable
    private String nextCursorId;

    @Nullable
    private final List<FeedClassifyModel> tagList;

    public FeedRecommendListResult(@Nullable List<FeedRecommendResult> list, @Nullable List<AdModel> list2, @Nullable List<FeedClassifyModel> list3, @Nullable String str) {
        this.list = list;
        this.adList = list2;
        this.tagList = list3;
        this.nextCursorId = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FeedRecommendListResult copy$default(FeedRecommendListResult feedRecommendListResult, List list, List list2, List list3, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = feedRecommendListResult.list;
        }
        if ((i10 & 2) != 0) {
            list2 = feedRecommendListResult.adList;
        }
        if ((i10 & 4) != 0) {
            list3 = feedRecommendListResult.tagList;
        }
        if ((i10 & 8) != 0) {
            str = feedRecommendListResult.nextCursorId;
        }
        return feedRecommendListResult.copy(list, list2, list3, str);
    }

    @Nullable
    public final List<FeedRecommendResult> component1() {
        return this.list;
    }

    @Nullable
    public final List<AdModel> component2() {
        return this.adList;
    }

    @Nullable
    public final List<FeedClassifyModel> component3() {
        return this.tagList;
    }

    @Nullable
    public final String component4() {
        return this.nextCursorId;
    }

    @NotNull
    public final FeedRecommendListResult copy(@Nullable List<FeedRecommendResult> list, @Nullable List<AdModel> list2, @Nullable List<FeedClassifyModel> list3, @Nullable String str) {
        return new FeedRecommendListResult(list, list2, list3, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FeedRecommendListResult)) {
            return false;
        }
        FeedRecommendListResult feedRecommendListResult = (FeedRecommendListResult) obj;
        return s.d(this.list, feedRecommendListResult.list) && s.d(this.adList, feedRecommendListResult.adList) && s.d(this.tagList, feedRecommendListResult.tagList) && s.d(this.nextCursorId, feedRecommendListResult.nextCursorId);
    }

    @Nullable
    public final List<AdModel> getAdList() {
        return this.adList;
    }

    @Nullable
    public final List<FeedRecommendResult> getList() {
        return this.list;
    }

    @Nullable
    public final String getNextCursorId() {
        return this.nextCursorId;
    }

    @Nullable
    public final List<FeedClassifyModel> getTagList() {
        return this.tagList;
    }

    public int hashCode() {
        List<FeedRecommendResult> list = this.list;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        List<AdModel> list2 = this.adList;
        int hashCode2 = (hashCode + (list2 == null ? 0 : list2.hashCode())) * 31;
        List<FeedClassifyModel> list3 = this.tagList;
        int hashCode3 = (hashCode2 + (list3 == null ? 0 : list3.hashCode())) * 31;
        String str = this.nextCursorId;
        return hashCode3 + (str != null ? str.hashCode() : 0);
    }

    public final void setNextCursorId(@Nullable String str) {
        this.nextCursorId = str;
    }

    @NotNull
    public String toString() {
        List<FeedRecommendResult> list = this.list;
        List<AdModel> list2 = this.adList;
        List<FeedClassifyModel> list3 = this.tagList;
        return "FeedRecommendListResult(list=" + ((Object) list) + ", adList=" + ((Object) list2) + ", tagList=" + ((Object) list3) + ", nextCursorId=" + this.nextCursorId + ")";
    }
}
