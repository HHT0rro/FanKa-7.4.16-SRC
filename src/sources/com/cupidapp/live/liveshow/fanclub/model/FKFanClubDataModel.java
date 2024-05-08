package com.cupidapp.live.liveshow.fanclub.model;

import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.liveshow.model.GiftModel;
import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKFanClubResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKFanClubDataModel implements Serializable {

    @NotNull
    private final String descRuleUrl;

    @NotNull
    private final ImageModel iconImage;

    /* renamed from: id, reason: collision with root package name */
    @NotNull
    private final String f14983id;

    @NotNull
    private final GiftModel joinGift;
    private final int memberCount;

    @NotNull
    private final String memberCountFormatted;

    @NotNull
    private final String privilegeUrl;

    @NotNull
    private final String title;

    public FKFanClubDataModel(@NotNull String id2, @NotNull String title, int i10, @NotNull String memberCountFormatted, @NotNull ImageModel iconImage, @NotNull GiftModel joinGift, @NotNull String descRuleUrl, @NotNull String privilegeUrl) {
        s.i(id2, "id");
        s.i(title, "title");
        s.i(memberCountFormatted, "memberCountFormatted");
        s.i(iconImage, "iconImage");
        s.i(joinGift, "joinGift");
        s.i(descRuleUrl, "descRuleUrl");
        s.i(privilegeUrl, "privilegeUrl");
        this.f14983id = id2;
        this.title = title;
        this.memberCount = i10;
        this.memberCountFormatted = memberCountFormatted;
        this.iconImage = iconImage;
        this.joinGift = joinGift;
        this.descRuleUrl = descRuleUrl;
        this.privilegeUrl = privilegeUrl;
    }

    @NotNull
    public final String component1() {
        return this.f14983id;
    }

    @NotNull
    public final String component2() {
        return this.title;
    }

    public final int component3() {
        return this.memberCount;
    }

    @NotNull
    public final String component4() {
        return this.memberCountFormatted;
    }

    @NotNull
    public final ImageModel component5() {
        return this.iconImage;
    }

    @NotNull
    public final GiftModel component6() {
        return this.joinGift;
    }

    @NotNull
    public final String component7() {
        return this.descRuleUrl;
    }

    @NotNull
    public final String component8() {
        return this.privilegeUrl;
    }

    @NotNull
    public final FKFanClubDataModel copy(@NotNull String id2, @NotNull String title, int i10, @NotNull String memberCountFormatted, @NotNull ImageModel iconImage, @NotNull GiftModel joinGift, @NotNull String descRuleUrl, @NotNull String privilegeUrl) {
        s.i(id2, "id");
        s.i(title, "title");
        s.i(memberCountFormatted, "memberCountFormatted");
        s.i(iconImage, "iconImage");
        s.i(joinGift, "joinGift");
        s.i(descRuleUrl, "descRuleUrl");
        s.i(privilegeUrl, "privilegeUrl");
        return new FKFanClubDataModel(id2, title, i10, memberCountFormatted, iconImage, joinGift, descRuleUrl, privilegeUrl);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FKFanClubDataModel)) {
            return false;
        }
        FKFanClubDataModel fKFanClubDataModel = (FKFanClubDataModel) obj;
        return s.d(this.f14983id, fKFanClubDataModel.f14983id) && s.d(this.title, fKFanClubDataModel.title) && this.memberCount == fKFanClubDataModel.memberCount && s.d(this.memberCountFormatted, fKFanClubDataModel.memberCountFormatted) && s.d(this.iconImage, fKFanClubDataModel.iconImage) && s.d(this.joinGift, fKFanClubDataModel.joinGift) && s.d(this.descRuleUrl, fKFanClubDataModel.descRuleUrl) && s.d(this.privilegeUrl, fKFanClubDataModel.privilegeUrl);
    }

    @NotNull
    public final String getDescRuleUrl() {
        return this.descRuleUrl;
    }

    @NotNull
    public final ImageModel getIconImage() {
        return this.iconImage;
    }

    @NotNull
    public final String getId() {
        return this.f14983id;
    }

    @NotNull
    public final GiftModel getJoinGift() {
        return this.joinGift;
    }

    public final int getMemberCount() {
        return this.memberCount;
    }

    @NotNull
    public final String getMemberCountFormatted() {
        return this.memberCountFormatted;
    }

    @NotNull
    public final String getPrivilegeUrl() {
        return this.privilegeUrl;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return (((((((((((((this.f14983id.hashCode() * 31) + this.title.hashCode()) * 31) + this.memberCount) * 31) + this.memberCountFormatted.hashCode()) * 31) + this.iconImage.hashCode()) * 31) + this.joinGift.hashCode()) * 31) + this.descRuleUrl.hashCode()) * 31) + this.privilegeUrl.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.f14983id;
        String str2 = this.title;
        int i10 = this.memberCount;
        String str3 = this.memberCountFormatted;
        ImageModel imageModel = this.iconImage;
        GiftModel giftModel = this.joinGift;
        return "FKFanClubDataModel(id=" + str + ", title=" + str2 + ", memberCount=" + i10 + ", memberCountFormatted=" + str3 + ", iconImage=" + ((Object) imageModel) + ", joinGift=" + ((Object) giftModel) + ", descRuleUrl=" + this.descRuleUrl + ", privilegeUrl=" + this.privilegeUrl + ")";
    }
}
