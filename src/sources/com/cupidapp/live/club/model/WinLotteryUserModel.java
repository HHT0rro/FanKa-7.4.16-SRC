package com.cupidapp.live.club.model;

import com.cupidapp.live.base.network.model.ImageModel;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ClubTotalModelFile.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class WinLotteryUserModel {

    @NotNull
    private final ImageModel avatarImage;

    @NotNull
    private final String nickname;
    private final boolean theBest;

    @NotNull
    private final String ticket;

    @NotNull
    private final String userId;

    public WinLotteryUserModel(@NotNull String userId, @NotNull String nickname, @NotNull ImageModel avatarImage, @NotNull String ticket, boolean z10) {
        s.i(userId, "userId");
        s.i(nickname, "nickname");
        s.i(avatarImage, "avatarImage");
        s.i(ticket, "ticket");
        this.userId = userId;
        this.nickname = nickname;
        this.avatarImage = avatarImage;
        this.ticket = ticket;
        this.theBest = z10;
    }

    public static /* synthetic */ WinLotteryUserModel copy$default(WinLotteryUserModel winLotteryUserModel, String str, String str2, ImageModel imageModel, String str3, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = winLotteryUserModel.userId;
        }
        if ((i10 & 2) != 0) {
            str2 = winLotteryUserModel.nickname;
        }
        String str4 = str2;
        if ((i10 & 4) != 0) {
            imageModel = winLotteryUserModel.avatarImage;
        }
        ImageModel imageModel2 = imageModel;
        if ((i10 & 8) != 0) {
            str3 = winLotteryUserModel.ticket;
        }
        String str5 = str3;
        if ((i10 & 16) != 0) {
            z10 = winLotteryUserModel.theBest;
        }
        return winLotteryUserModel.copy(str, str4, imageModel2, str5, z10);
    }

    @NotNull
    public final String component1() {
        return this.userId;
    }

    @NotNull
    public final String component2() {
        return this.nickname;
    }

    @NotNull
    public final ImageModel component3() {
        return this.avatarImage;
    }

    @NotNull
    public final String component4() {
        return this.ticket;
    }

    public final boolean component5() {
        return this.theBest;
    }

    @NotNull
    public final WinLotteryUserModel copy(@NotNull String userId, @NotNull String nickname, @NotNull ImageModel avatarImage, @NotNull String ticket, boolean z10) {
        s.i(userId, "userId");
        s.i(nickname, "nickname");
        s.i(avatarImage, "avatarImage");
        s.i(ticket, "ticket");
        return new WinLotteryUserModel(userId, nickname, avatarImage, ticket, z10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WinLotteryUserModel)) {
            return false;
        }
        WinLotteryUserModel winLotteryUserModel = (WinLotteryUserModel) obj;
        return s.d(this.userId, winLotteryUserModel.userId) && s.d(this.nickname, winLotteryUserModel.nickname) && s.d(this.avatarImage, winLotteryUserModel.avatarImage) && s.d(this.ticket, winLotteryUserModel.ticket) && this.theBest == winLotteryUserModel.theBest;
    }

    @NotNull
    public final ImageModel getAvatarImage() {
        return this.avatarImage;
    }

    @NotNull
    public final String getNickname() {
        return this.nickname;
    }

    public final boolean getTheBest() {
        return this.theBest;
    }

    @NotNull
    public final String getTicket() {
        return this.ticket;
    }

    @NotNull
    public final String getUserId() {
        return this.userId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((this.userId.hashCode() * 31) + this.nickname.hashCode()) * 31) + this.avatarImage.hashCode()) * 31) + this.ticket.hashCode()) * 31;
        boolean z10 = this.theBest;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        return hashCode + i10;
    }

    @NotNull
    public String toString() {
        String str = this.userId;
        String str2 = this.nickname;
        ImageModel imageModel = this.avatarImage;
        return "WinLotteryUserModel(userId=" + str + ", nickname=" + str2 + ", avatarImage=" + ((Object) imageModel) + ", ticket=" + this.ticket + ", theBest=" + this.theBest + ")";
    }
}
