package com.cupidapp.live.maskparty.model;

import com.cupidapp.live.base.network.model.ImageModel;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MaskPartyMatchConfigResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MaskPartyMatchConfigResult {

    @NotNull
    private final List<ImageModel> avatarList;

    @Nullable
    private final String enterRemind;

    @Nullable
    private final String enterTitle;

    @NotNull
    private final List<MaskPartyConfigModel> gameEntrance;

    @Nullable
    private final CompleteInfoGuideModel guide;

    @Nullable
    private final String itemCardDetailUrl;

    @Nullable
    private final String itemCardOrderUrl;
    private final int itemCardRemains;

    @Nullable
    private final List<Integer> selectedTypeList;

    public MaskPartyMatchConfigResult(@NotNull List<MaskPartyConfigModel> gameEntrance, @NotNull List<ImageModel> avatarList, @Nullable CompleteInfoGuideModel completeInfoGuideModel, @Nullable List<Integer> list, int i10, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        s.i(gameEntrance, "gameEntrance");
        s.i(avatarList, "avatarList");
        this.gameEntrance = gameEntrance;
        this.avatarList = avatarList;
        this.guide = completeInfoGuideModel;
        this.selectedTypeList = list;
        this.itemCardRemains = i10;
        this.enterTitle = str;
        this.enterRemind = str2;
        this.itemCardDetailUrl = str3;
        this.itemCardOrderUrl = str4;
    }

    @NotNull
    public final List<MaskPartyConfigModel> component1() {
        return this.gameEntrance;
    }

    @NotNull
    public final List<ImageModel> component2() {
        return this.avatarList;
    }

    @Nullable
    public final CompleteInfoGuideModel component3() {
        return this.guide;
    }

    @Nullable
    public final List<Integer> component4() {
        return this.selectedTypeList;
    }

    public final int component5() {
        return this.itemCardRemains;
    }

    @Nullable
    public final String component6() {
        return this.enterTitle;
    }

    @Nullable
    public final String component7() {
        return this.enterRemind;
    }

    @Nullable
    public final String component8() {
        return this.itemCardDetailUrl;
    }

    @Nullable
    public final String component9() {
        return this.itemCardOrderUrl;
    }

    @NotNull
    public final MaskPartyMatchConfigResult copy(@NotNull List<MaskPartyConfigModel> gameEntrance, @NotNull List<ImageModel> avatarList, @Nullable CompleteInfoGuideModel completeInfoGuideModel, @Nullable List<Integer> list, int i10, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        s.i(gameEntrance, "gameEntrance");
        s.i(avatarList, "avatarList");
        return new MaskPartyMatchConfigResult(gameEntrance, avatarList, completeInfoGuideModel, list, i10, str, str2, str3, str4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MaskPartyMatchConfigResult)) {
            return false;
        }
        MaskPartyMatchConfigResult maskPartyMatchConfigResult = (MaskPartyMatchConfigResult) obj;
        return s.d(this.gameEntrance, maskPartyMatchConfigResult.gameEntrance) && s.d(this.avatarList, maskPartyMatchConfigResult.avatarList) && s.d(this.guide, maskPartyMatchConfigResult.guide) && s.d(this.selectedTypeList, maskPartyMatchConfigResult.selectedTypeList) && this.itemCardRemains == maskPartyMatchConfigResult.itemCardRemains && s.d(this.enterTitle, maskPartyMatchConfigResult.enterTitle) && s.d(this.enterRemind, maskPartyMatchConfigResult.enterRemind) && s.d(this.itemCardDetailUrl, maskPartyMatchConfigResult.itemCardDetailUrl) && s.d(this.itemCardOrderUrl, maskPartyMatchConfigResult.itemCardOrderUrl);
    }

    @NotNull
    public final List<ImageModel> getAvatarList() {
        return this.avatarList;
    }

    @Nullable
    public final String getEnterRemind() {
        return this.enterRemind;
    }

    @Nullable
    public final String getEnterTitle() {
        return this.enterTitle;
    }

    @NotNull
    public final List<MaskPartyConfigModel> getGameEntrance() {
        return this.gameEntrance;
    }

    @Nullable
    public final CompleteInfoGuideModel getGuide() {
        return this.guide;
    }

    @Nullable
    public final String getItemCardDetailUrl() {
        return this.itemCardDetailUrl;
    }

    @Nullable
    public final String getItemCardOrderUrl() {
        return this.itemCardOrderUrl;
    }

    public final int getItemCardRemains() {
        return this.itemCardRemains;
    }

    @Nullable
    public final List<Integer> getSelectedTypeList() {
        return this.selectedTypeList;
    }

    public int hashCode() {
        int hashCode = ((this.gameEntrance.hashCode() * 31) + this.avatarList.hashCode()) * 31;
        CompleteInfoGuideModel completeInfoGuideModel = this.guide;
        int hashCode2 = (hashCode + (completeInfoGuideModel == null ? 0 : completeInfoGuideModel.hashCode())) * 31;
        List<Integer> list = this.selectedTypeList;
        int hashCode3 = (((hashCode2 + (list == null ? 0 : list.hashCode())) * 31) + this.itemCardRemains) * 31;
        String str = this.enterTitle;
        int hashCode4 = (hashCode3 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.enterRemind;
        int hashCode5 = (hashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.itemCardDetailUrl;
        int hashCode6 = (hashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.itemCardOrderUrl;
        return hashCode6 + (str4 != null ? str4.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        List<MaskPartyConfigModel> list = this.gameEntrance;
        List<ImageModel> list2 = this.avatarList;
        CompleteInfoGuideModel completeInfoGuideModel = this.guide;
        List<Integer> list3 = this.selectedTypeList;
        return "MaskPartyMatchConfigResult(gameEntrance=" + ((Object) list) + ", avatarList=" + ((Object) list2) + ", guide=" + ((Object) completeInfoGuideModel) + ", selectedTypeList=" + ((Object) list3) + ", itemCardRemains=" + this.itemCardRemains + ", enterTitle=" + this.enterTitle + ", enterRemind=" + this.enterRemind + ", itemCardDetailUrl=" + this.itemCardDetailUrl + ", itemCardOrderUrl=" + this.itemCardOrderUrl + ")";
    }
}
