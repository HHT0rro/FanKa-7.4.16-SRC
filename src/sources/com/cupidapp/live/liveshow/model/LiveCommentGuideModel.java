package com.cupidapp.live.liveshow.model;

import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveShowResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LiveCommentGuideModel implements Serializable {

    @Nullable
    private final LiveCommentGuideItemModel alohaAlertGuide;

    @Nullable
    private final LiveCommentGuideItemModel alohaCommentGuide;

    @Nullable
    private final LiveCommentGuideItemModel commentGuide;

    @Nullable
    private final LiveCommentGuideItemModel giftGuide;

    public LiveCommentGuideModel(@Nullable LiveCommentGuideItemModel liveCommentGuideItemModel, @Nullable LiveCommentGuideItemModel liveCommentGuideItemModel2, @Nullable LiveCommentGuideItemModel liveCommentGuideItemModel3, @Nullable LiveCommentGuideItemModel liveCommentGuideItemModel4) {
        this.alohaCommentGuide = liveCommentGuideItemModel;
        this.alohaAlertGuide = liveCommentGuideItemModel2;
        this.commentGuide = liveCommentGuideItemModel3;
        this.giftGuide = liveCommentGuideItemModel4;
    }

    public static /* synthetic */ LiveCommentGuideModel copy$default(LiveCommentGuideModel liveCommentGuideModel, LiveCommentGuideItemModel liveCommentGuideItemModel, LiveCommentGuideItemModel liveCommentGuideItemModel2, LiveCommentGuideItemModel liveCommentGuideItemModel3, LiveCommentGuideItemModel liveCommentGuideItemModel4, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            liveCommentGuideItemModel = liveCommentGuideModel.alohaCommentGuide;
        }
        if ((i10 & 2) != 0) {
            liveCommentGuideItemModel2 = liveCommentGuideModel.alohaAlertGuide;
        }
        if ((i10 & 4) != 0) {
            liveCommentGuideItemModel3 = liveCommentGuideModel.commentGuide;
        }
        if ((i10 & 8) != 0) {
            liveCommentGuideItemModel4 = liveCommentGuideModel.giftGuide;
        }
        return liveCommentGuideModel.copy(liveCommentGuideItemModel, liveCommentGuideItemModel2, liveCommentGuideItemModel3, liveCommentGuideItemModel4);
    }

    @Nullable
    public final LiveCommentGuideItemModel component1() {
        return this.alohaCommentGuide;
    }

    @Nullable
    public final LiveCommentGuideItemModel component2() {
        return this.alohaAlertGuide;
    }

    @Nullable
    public final LiveCommentGuideItemModel component3() {
        return this.commentGuide;
    }

    @Nullable
    public final LiveCommentGuideItemModel component4() {
        return this.giftGuide;
    }

    @NotNull
    public final LiveCommentGuideModel copy(@Nullable LiveCommentGuideItemModel liveCommentGuideItemModel, @Nullable LiveCommentGuideItemModel liveCommentGuideItemModel2, @Nullable LiveCommentGuideItemModel liveCommentGuideItemModel3, @Nullable LiveCommentGuideItemModel liveCommentGuideItemModel4) {
        return new LiveCommentGuideModel(liveCommentGuideItemModel, liveCommentGuideItemModel2, liveCommentGuideItemModel3, liveCommentGuideItemModel4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LiveCommentGuideModel)) {
            return false;
        }
        LiveCommentGuideModel liveCommentGuideModel = (LiveCommentGuideModel) obj;
        return s.d(this.alohaCommentGuide, liveCommentGuideModel.alohaCommentGuide) && s.d(this.alohaAlertGuide, liveCommentGuideModel.alohaAlertGuide) && s.d(this.commentGuide, liveCommentGuideModel.commentGuide) && s.d(this.giftGuide, liveCommentGuideModel.giftGuide);
    }

    @Nullable
    public final LiveCommentGuideItemModel getAlohaAlertGuide() {
        return this.alohaAlertGuide;
    }

    @Nullable
    public final LiveCommentGuideItemModel getAlohaCommentGuide() {
        return this.alohaCommentGuide;
    }

    @Nullable
    public final LiveCommentGuideItemModel getCommentGuide() {
        return this.commentGuide;
    }

    @Nullable
    public final LiveCommentGuideItemModel getGiftGuide() {
        return this.giftGuide;
    }

    public int hashCode() {
        LiveCommentGuideItemModel liveCommentGuideItemModel = this.alohaCommentGuide;
        int hashCode = (liveCommentGuideItemModel == null ? 0 : liveCommentGuideItemModel.hashCode()) * 31;
        LiveCommentGuideItemModel liveCommentGuideItemModel2 = this.alohaAlertGuide;
        int hashCode2 = (hashCode + (liveCommentGuideItemModel2 == null ? 0 : liveCommentGuideItemModel2.hashCode())) * 31;
        LiveCommentGuideItemModel liveCommentGuideItemModel3 = this.commentGuide;
        int hashCode3 = (hashCode2 + (liveCommentGuideItemModel3 == null ? 0 : liveCommentGuideItemModel3.hashCode())) * 31;
        LiveCommentGuideItemModel liveCommentGuideItemModel4 = this.giftGuide;
        return hashCode3 + (liveCommentGuideItemModel4 != null ? liveCommentGuideItemModel4.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "LiveCommentGuideModel(alohaCommentGuide=" + ((Object) this.alohaCommentGuide) + ", alohaAlertGuide=" + ((Object) this.alohaAlertGuide) + ", commentGuide=" + ((Object) this.commentGuide) + ", giftGuide=" + ((Object) this.giftGuide) + ")";
    }
}
