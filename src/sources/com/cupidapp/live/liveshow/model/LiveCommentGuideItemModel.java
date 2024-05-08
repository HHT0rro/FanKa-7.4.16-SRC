package com.cupidapp.live.liveshow.model;

import java.io.Serializable;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveShowResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LiveCommentGuideItemModel implements Serializable {

    @Nullable
    private final Integer commentCount;

    @Nullable
    private final List<String> commonWords;

    @Nullable
    private final Integer duration;

    public LiveCommentGuideItemModel(@Nullable Integer num, @Nullable Integer num2, @Nullable List<String> list) {
        this.duration = num;
        this.commentCount = num2;
        this.commonWords = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LiveCommentGuideItemModel copy$default(LiveCommentGuideItemModel liveCommentGuideItemModel, Integer num, Integer num2, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            num = liveCommentGuideItemModel.duration;
        }
        if ((i10 & 2) != 0) {
            num2 = liveCommentGuideItemModel.commentCount;
        }
        if ((i10 & 4) != 0) {
            list = liveCommentGuideItemModel.commonWords;
        }
        return liveCommentGuideItemModel.copy(num, num2, list);
    }

    @Nullable
    public final Integer component1() {
        return this.duration;
    }

    @Nullable
    public final Integer component2() {
        return this.commentCount;
    }

    @Nullable
    public final List<String> component3() {
        return this.commonWords;
    }

    @NotNull
    public final LiveCommentGuideItemModel copy(@Nullable Integer num, @Nullable Integer num2, @Nullable List<String> list) {
        return new LiveCommentGuideItemModel(num, num2, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LiveCommentGuideItemModel)) {
            return false;
        }
        LiveCommentGuideItemModel liveCommentGuideItemModel = (LiveCommentGuideItemModel) obj;
        return s.d(this.duration, liveCommentGuideItemModel.duration) && s.d(this.commentCount, liveCommentGuideItemModel.commentCount) && s.d(this.commonWords, liveCommentGuideItemModel.commonWords);
    }

    @Nullable
    public final Integer getCommentCount() {
        return this.commentCount;
    }

    @Nullable
    public final List<String> getCommonWords() {
        return this.commonWords;
    }

    @Nullable
    public final Integer getDuration() {
        return this.duration;
    }

    public int hashCode() {
        Integer num = this.duration;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.commentCount;
        int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        List<String> list = this.commonWords;
        return hashCode2 + (list != null ? list.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "LiveCommentGuideItemModel(duration=" + ((Object) this.duration) + ", commentCount=" + ((Object) this.commentCount) + ", commonWords=" + ((Object) this.commonWords) + ")";
    }
}
