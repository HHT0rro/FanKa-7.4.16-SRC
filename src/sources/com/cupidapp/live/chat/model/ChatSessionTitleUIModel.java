package com.cupidapp.live.chat.model;

import com.cupidapp.live.chat.service.ClubEntranceModel;
import com.cupidapp.live.feed.model.PromotionNearByGuideModel;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ChatSessionTitleUIModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ChatSessionTitleUIModel {

    @Nullable
    private ClubEntranceModel clubEntrance;

    @Nullable
    private PromotionNearByGuideModel guide;

    @Nullable
    private ChatMatchUIModel matchUserModel;
    private boolean showPushStatus;
    private boolean stealthMessage;

    public ChatSessionTitleUIModel() {
        this(null, false, false, null, null, 31, null);
    }

    public ChatSessionTitleUIModel(@Nullable ChatMatchUIModel chatMatchUIModel, boolean z10, boolean z11, @Nullable PromotionNearByGuideModel promotionNearByGuideModel, @Nullable ClubEntranceModel clubEntranceModel) {
        this.matchUserModel = chatMatchUIModel;
        this.showPushStatus = z10;
        this.stealthMessage = z11;
        this.guide = promotionNearByGuideModel;
        this.clubEntrance = clubEntranceModel;
    }

    public static /* synthetic */ ChatSessionTitleUIModel copy$default(ChatSessionTitleUIModel chatSessionTitleUIModel, ChatMatchUIModel chatMatchUIModel, boolean z10, boolean z11, PromotionNearByGuideModel promotionNearByGuideModel, ClubEntranceModel clubEntranceModel, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            chatMatchUIModel = chatSessionTitleUIModel.matchUserModel;
        }
        if ((i10 & 2) != 0) {
            z10 = chatSessionTitleUIModel.showPushStatus;
        }
        boolean z12 = z10;
        if ((i10 & 4) != 0) {
            z11 = chatSessionTitleUIModel.stealthMessage;
        }
        boolean z13 = z11;
        if ((i10 & 8) != 0) {
            promotionNearByGuideModel = chatSessionTitleUIModel.guide;
        }
        PromotionNearByGuideModel promotionNearByGuideModel2 = promotionNearByGuideModel;
        if ((i10 & 16) != 0) {
            clubEntranceModel = chatSessionTitleUIModel.clubEntrance;
        }
        return chatSessionTitleUIModel.copy(chatMatchUIModel, z12, z13, promotionNearByGuideModel2, clubEntranceModel);
    }

    @Nullable
    public final ChatMatchUIModel component1() {
        return this.matchUserModel;
    }

    public final boolean component2() {
        return this.showPushStatus;
    }

    public final boolean component3() {
        return this.stealthMessage;
    }

    @Nullable
    public final PromotionNearByGuideModel component4() {
        return this.guide;
    }

    @Nullable
    public final ClubEntranceModel component5() {
        return this.clubEntrance;
    }

    @NotNull
    public final ChatSessionTitleUIModel copy(@Nullable ChatMatchUIModel chatMatchUIModel, boolean z10, boolean z11, @Nullable PromotionNearByGuideModel promotionNearByGuideModel, @Nullable ClubEntranceModel clubEntranceModel) {
        return new ChatSessionTitleUIModel(chatMatchUIModel, z10, z11, promotionNearByGuideModel, clubEntranceModel);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChatSessionTitleUIModel)) {
            return false;
        }
        ChatSessionTitleUIModel chatSessionTitleUIModel = (ChatSessionTitleUIModel) obj;
        return s.d(this.matchUserModel, chatSessionTitleUIModel.matchUserModel) && this.showPushStatus == chatSessionTitleUIModel.showPushStatus && this.stealthMessage == chatSessionTitleUIModel.stealthMessage && s.d(this.guide, chatSessionTitleUIModel.guide) && s.d(this.clubEntrance, chatSessionTitleUIModel.clubEntrance);
    }

    @Nullable
    public final ClubEntranceModel getClubEntrance() {
        return this.clubEntrance;
    }

    @Nullable
    public final PromotionNearByGuideModel getGuide() {
        return this.guide;
    }

    @Nullable
    public final ChatMatchUIModel getMatchUserModel() {
        return this.matchUserModel;
    }

    public final boolean getShowPushStatus() {
        return this.showPushStatus;
    }

    public final boolean getStealthMessage() {
        return this.stealthMessage;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        ChatMatchUIModel chatMatchUIModel = this.matchUserModel;
        int hashCode = (chatMatchUIModel == null ? 0 : chatMatchUIModel.hashCode()) * 31;
        boolean z10 = this.showPushStatus;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        int i11 = (hashCode + i10) * 31;
        boolean z11 = this.stealthMessage;
        int i12 = (i11 + (z11 ? 1 : z11 ? 1 : 0)) * 31;
        PromotionNearByGuideModel promotionNearByGuideModel = this.guide;
        int hashCode2 = (i12 + (promotionNearByGuideModel == null ? 0 : promotionNearByGuideModel.hashCode())) * 31;
        ClubEntranceModel clubEntranceModel = this.clubEntrance;
        return hashCode2 + (clubEntranceModel != null ? clubEntranceModel.hashCode() : 0);
    }

    public final void setClubEntrance(@Nullable ClubEntranceModel clubEntranceModel) {
        this.clubEntrance = clubEntranceModel;
    }

    public final void setGuide(@Nullable PromotionNearByGuideModel promotionNearByGuideModel) {
        this.guide = promotionNearByGuideModel;
    }

    public final void setMatchUserModel(@Nullable ChatMatchUIModel chatMatchUIModel) {
        this.matchUserModel = chatMatchUIModel;
    }

    public final void setShowPushStatus(boolean z10) {
        this.showPushStatus = z10;
    }

    public final void setStealthMessage(boolean z10) {
        this.stealthMessage = z10;
    }

    @NotNull
    public String toString() {
        ChatMatchUIModel chatMatchUIModel = this.matchUserModel;
        return "ChatSessionTitleUIModel(matchUserModel=" + ((Object) chatMatchUIModel) + ", showPushStatus=" + this.showPushStatus + ", stealthMessage=" + this.stealthMessage + ", guide=" + ((Object) this.guide) + ", clubEntrance=" + ((Object) this.clubEntrance) + ")";
    }

    public /* synthetic */ ChatSessionTitleUIModel(ChatMatchUIModel chatMatchUIModel, boolean z10, boolean z11, PromotionNearByGuideModel promotionNearByGuideModel, ClubEntranceModel clubEntranceModel, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : chatMatchUIModel, (i10 & 2) != 0 ? false : z10, (i10 & 4) == 0 ? z11 : false, (i10 & 8) != 0 ? null : promotionNearByGuideModel, (i10 & 16) != 0 ? null : clubEntranceModel);
    }
}
