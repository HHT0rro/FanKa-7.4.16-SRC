package com.cupidapp.live.liveshow.model;

import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveAnimationModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LiveShowShakeMessageModel {

    @Nullable
    private final LiveShowAnimationModel animation;

    @Nullable
    private final CommentModel comment;
    private final int expireSecond;

    @NotNull
    private final String itemId;

    @Nullable
    private final LiveShowAnimationModel shakeAnimation;

    public LiveShowShakeMessageModel(@NotNull String itemId, int i10, @Nullable CommentModel commentModel, @Nullable LiveShowAnimationModel liveShowAnimationModel, @Nullable LiveShowAnimationModel liveShowAnimationModel2) {
        s.i(itemId, "itemId");
        this.itemId = itemId;
        this.expireSecond = i10;
        this.comment = commentModel;
        this.animation = liveShowAnimationModel;
        this.shakeAnimation = liveShowAnimationModel2;
    }

    public static /* synthetic */ LiveShowShakeMessageModel copy$default(LiveShowShakeMessageModel liveShowShakeMessageModel, String str, int i10, CommentModel commentModel, LiveShowAnimationModel liveShowAnimationModel, LiveShowAnimationModel liveShowAnimationModel2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = liveShowShakeMessageModel.itemId;
        }
        if ((i11 & 2) != 0) {
            i10 = liveShowShakeMessageModel.expireSecond;
        }
        int i12 = i10;
        if ((i11 & 4) != 0) {
            commentModel = liveShowShakeMessageModel.comment;
        }
        CommentModel commentModel2 = commentModel;
        if ((i11 & 8) != 0) {
            liveShowAnimationModel = liveShowShakeMessageModel.animation;
        }
        LiveShowAnimationModel liveShowAnimationModel3 = liveShowAnimationModel;
        if ((i11 & 16) != 0) {
            liveShowAnimationModel2 = liveShowShakeMessageModel.shakeAnimation;
        }
        return liveShowShakeMessageModel.copy(str, i12, commentModel2, liveShowAnimationModel3, liveShowAnimationModel2);
    }

    @NotNull
    public final String component1() {
        return this.itemId;
    }

    public final int component2() {
        return this.expireSecond;
    }

    @Nullable
    public final CommentModel component3() {
        return this.comment;
    }

    @Nullable
    public final LiveShowAnimationModel component4() {
        return this.animation;
    }

    @Nullable
    public final LiveShowAnimationModel component5() {
        return this.shakeAnimation;
    }

    @NotNull
    public final LiveShowShakeMessageModel copy(@NotNull String itemId, int i10, @Nullable CommentModel commentModel, @Nullable LiveShowAnimationModel liveShowAnimationModel, @Nullable LiveShowAnimationModel liveShowAnimationModel2) {
        s.i(itemId, "itemId");
        return new LiveShowShakeMessageModel(itemId, i10, commentModel, liveShowAnimationModel, liveShowAnimationModel2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LiveShowShakeMessageModel)) {
            return false;
        }
        LiveShowShakeMessageModel liveShowShakeMessageModel = (LiveShowShakeMessageModel) obj;
        return s.d(this.itemId, liveShowShakeMessageModel.itemId) && this.expireSecond == liveShowShakeMessageModel.expireSecond && s.d(this.comment, liveShowShakeMessageModel.comment) && s.d(this.animation, liveShowShakeMessageModel.animation) && s.d(this.shakeAnimation, liveShowShakeMessageModel.shakeAnimation);
    }

    @Nullable
    public final LiveShowAnimationModel getAnimation() {
        return this.animation;
    }

    @Nullable
    public final CommentModel getComment() {
        return this.comment;
    }

    public final int getExpireSecond() {
        return this.expireSecond;
    }

    @NotNull
    public final String getItemId() {
        return this.itemId;
    }

    @Nullable
    public final LiveShowAnimationModel getShakeAnimation() {
        return this.shakeAnimation;
    }

    public int hashCode() {
        int hashCode = ((this.itemId.hashCode() * 31) + this.expireSecond) * 31;
        CommentModel commentModel = this.comment;
        int hashCode2 = (hashCode + (commentModel == null ? 0 : commentModel.hashCode())) * 31;
        LiveShowAnimationModel liveShowAnimationModel = this.animation;
        int hashCode3 = (hashCode2 + (liveShowAnimationModel == null ? 0 : liveShowAnimationModel.hashCode())) * 31;
        LiveShowAnimationModel liveShowAnimationModel2 = this.shakeAnimation;
        return hashCode3 + (liveShowAnimationModel2 != null ? liveShowAnimationModel2.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "LiveShowShakeMessageModel(itemId=" + this.itemId + ", expireSecond=" + this.expireSecond + ", comment=" + ((Object) this.comment) + ", animation=" + ((Object) this.animation) + ", shakeAnimation=" + ((Object) this.shakeAnimation) + ")";
    }

    public /* synthetic */ LiveShowShakeMessageModel(String str, int i10, CommentModel commentModel, LiveShowAnimationModel liveShowAnimationModel, LiveShowAnimationModel liveShowAnimationModel2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i11 & 2) != 0 ? 0 : i10, commentModel, liveShowAnimationModel, liveShowAnimationModel2);
    }
}
