package com.cupidapp.live.club.model;

import com.cupidapp.live.base.network.model.ImageModel;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ClubTotalModelFile.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ClubRedEnvelopeModel {

    @NotNull
    private final String clubId;

    @Nullable
    private final ImageModel giftIcon;

    @Nullable
    private final String giftName;
    private final boolean opened;

    @NotNull
    private final String redPacketId;

    @Nullable
    private final ImageModel senderAvatar;

    @Nullable
    private final String senderName;

    public ClubRedEnvelopeModel(@NotNull String clubId, @NotNull String redPacketId, @Nullable ImageModel imageModel, @Nullable String str, @Nullable ImageModel imageModel2, @Nullable String str2, boolean z10) {
        s.i(clubId, "clubId");
        s.i(redPacketId, "redPacketId");
        this.clubId = clubId;
        this.redPacketId = redPacketId;
        this.senderAvatar = imageModel;
        this.senderName = str;
        this.giftIcon = imageModel2;
        this.giftName = str2;
        this.opened = z10;
    }

    public static /* synthetic */ ClubRedEnvelopeModel copy$default(ClubRedEnvelopeModel clubRedEnvelopeModel, String str, String str2, ImageModel imageModel, String str3, ImageModel imageModel2, String str4, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = clubRedEnvelopeModel.clubId;
        }
        if ((i10 & 2) != 0) {
            str2 = clubRedEnvelopeModel.redPacketId;
        }
        String str5 = str2;
        if ((i10 & 4) != 0) {
            imageModel = clubRedEnvelopeModel.senderAvatar;
        }
        ImageModel imageModel3 = imageModel;
        if ((i10 & 8) != 0) {
            str3 = clubRedEnvelopeModel.senderName;
        }
        String str6 = str3;
        if ((i10 & 16) != 0) {
            imageModel2 = clubRedEnvelopeModel.giftIcon;
        }
        ImageModel imageModel4 = imageModel2;
        if ((i10 & 32) != 0) {
            str4 = clubRedEnvelopeModel.giftName;
        }
        String str7 = str4;
        if ((i10 & 64) != 0) {
            z10 = clubRedEnvelopeModel.opened;
        }
        return clubRedEnvelopeModel.copy(str, str5, imageModel3, str6, imageModel4, str7, z10);
    }

    @NotNull
    public final String component1() {
        return this.clubId;
    }

    @NotNull
    public final String component2() {
        return this.redPacketId;
    }

    @Nullable
    public final ImageModel component3() {
        return this.senderAvatar;
    }

    @Nullable
    public final String component4() {
        return this.senderName;
    }

    @Nullable
    public final ImageModel component5() {
        return this.giftIcon;
    }

    @Nullable
    public final String component6() {
        return this.giftName;
    }

    public final boolean component7() {
        return this.opened;
    }

    @NotNull
    public final ClubRedEnvelopeModel copy(@NotNull String clubId, @NotNull String redPacketId, @Nullable ImageModel imageModel, @Nullable String str, @Nullable ImageModel imageModel2, @Nullable String str2, boolean z10) {
        s.i(clubId, "clubId");
        s.i(redPacketId, "redPacketId");
        return new ClubRedEnvelopeModel(clubId, redPacketId, imageModel, str, imageModel2, str2, z10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ClubRedEnvelopeModel)) {
            return false;
        }
        ClubRedEnvelopeModel clubRedEnvelopeModel = (ClubRedEnvelopeModel) obj;
        return s.d(this.clubId, clubRedEnvelopeModel.clubId) && s.d(this.redPacketId, clubRedEnvelopeModel.redPacketId) && s.d(this.senderAvatar, clubRedEnvelopeModel.senderAvatar) && s.d(this.senderName, clubRedEnvelopeModel.senderName) && s.d(this.giftIcon, clubRedEnvelopeModel.giftIcon) && s.d(this.giftName, clubRedEnvelopeModel.giftName) && this.opened == clubRedEnvelopeModel.opened;
    }

    @NotNull
    public final String getClubId() {
        return this.clubId;
    }

    @Nullable
    public final ImageModel getGiftIcon() {
        return this.giftIcon;
    }

    @Nullable
    public final String getGiftName() {
        return this.giftName;
    }

    public final boolean getOpened() {
        return this.opened;
    }

    @NotNull
    public final String getRedPacketId() {
        return this.redPacketId;
    }

    @Nullable
    public final ImageModel getSenderAvatar() {
        return this.senderAvatar;
    }

    @Nullable
    public final String getSenderName() {
        return this.senderName;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.clubId.hashCode() * 31) + this.redPacketId.hashCode()) * 31;
        ImageModel imageModel = this.senderAvatar;
        int hashCode2 = (hashCode + (imageModel == null ? 0 : imageModel.hashCode())) * 31;
        String str = this.senderName;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        ImageModel imageModel2 = this.giftIcon;
        int hashCode4 = (hashCode3 + (imageModel2 == null ? 0 : imageModel2.hashCode())) * 31;
        String str2 = this.giftName;
        int hashCode5 = (hashCode4 + (str2 != null ? str2.hashCode() : 0)) * 31;
        boolean z10 = this.opened;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        return hashCode5 + i10;
    }

    @NotNull
    public String toString() {
        String str = this.clubId;
        String str2 = this.redPacketId;
        ImageModel imageModel = this.senderAvatar;
        String str3 = this.senderName;
        ImageModel imageModel2 = this.giftIcon;
        return "ClubRedEnvelopeModel(clubId=" + str + ", redPacketId=" + str2 + ", senderAvatar=" + ((Object) imageModel) + ", senderName=" + str3 + ", giftIcon=" + ((Object) imageModel2) + ", giftName=" + this.giftName + ", opened=" + this.opened + ")";
    }
}
